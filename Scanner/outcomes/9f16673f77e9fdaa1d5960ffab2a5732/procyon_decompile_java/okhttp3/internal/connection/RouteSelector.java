// 
// Decompiled by Procyon v0.5.30
// 

package okhttp3.internal.connection;

import java.util.NoSuchElementException;
import java.io.IOException;
import java.util.Collection;
import okhttp3.HttpUrl;
import java.net.SocketAddress;
import okhttp3.Route;
import java.net.SocketException;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Collections;
import java.net.Proxy;
import java.net.InetSocketAddress;
import java.util.List;
import okhttp3.Address;

public final class RouteSelector
{
    private final Address address;
    private List inetSocketAddresses;
    private InetSocketAddress lastInetSocketAddress;
    private Proxy lastProxy;
    private int nextInetSocketAddressIndex;
    private int nextProxyIndex;
    private final List postponedRoutes;
    private List proxies;
    private final RouteDatabase routeDatabase;
    
    public RouteSelector(final Address address, final RouteDatabase routeDatabase) {
        this.proxies = Collections.emptyList();
        this.inetSocketAddresses = Collections.emptyList();
        this.postponedRoutes = new ArrayList();
        this.address = address;
        this.routeDatabase = routeDatabase;
        this.resetNextProxy(address.url(), address.proxy());
    }
    
    static String getHostString(final InetSocketAddress inetSocketAddress) {
        final InetAddress address = inetSocketAddress.getAddress();
        if (address == null) {
            return inetSocketAddress.getHostName();
        }
        return address.getHostAddress();
    }
    
    private boolean hasNextInetSocketAddress() {
        return this.nextInetSocketAddressIndex < this.inetSocketAddresses.size();
    }
    
    private boolean hasNextPostponed() {
        return this.postponedRoutes.isEmpty() ^ true;
    }
    
    private boolean hasNextProxy() {
        return this.nextProxyIndex < this.proxies.size();
    }
    
    private InetSocketAddress nextInetSocketAddress() {
        if (this.hasNextInetSocketAddress()) {
            return this.inetSocketAddresses.get(this.nextInetSocketAddressIndex++);
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("No route to ");
        sb.append(this.address.url().host());
        sb.append("; exhausted inet socket addresses: ");
        sb.append(this.inetSocketAddresses);
        throw new SocketException(sb.toString());
    }
    
    private Route nextPostponed() {
        return this.postponedRoutes.remove(0);
    }
    
    private Proxy nextProxy() {
        if (this.hasNextProxy()) {
            final Proxy proxy = this.proxies.get(this.nextProxyIndex++);
            this.resetNextInetSocketAddress(proxy);
            return proxy;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("No route to ");
        sb.append(this.address.url().host());
        sb.append("; exhausted proxy configurations: ");
        sb.append(this.proxies);
        throw new SocketException(sb.toString());
    }
    
    private void resetNextInetSocketAddress(final Proxy proxy) {
        this.inetSocketAddresses = new ArrayList();
        String s;
        int n;
        if (proxy.type() != Proxy.Type.DIRECT && proxy.type() != Proxy.Type.SOCKS) {
            final SocketAddress address = proxy.address();
            if (!(address instanceof InetSocketAddress)) {
                final StringBuilder sb = new StringBuilder();
                sb.append("Proxy.address() is not an InetSocketAddress: ");
                sb.append(((InetSocketAddress)address).getClass());
                throw new IllegalArgumentException(sb.toString());
            }
            final InetSocketAddress inetSocketAddress = (InetSocketAddress)address;
            s = getHostString(inetSocketAddress);
            n = inetSocketAddress.getPort();
        }
        else {
            s = this.address.url().host();
            n = this.address.url().port();
        }
        if (n >= '\u0001' && n <= (char)(-1)) {
            if (proxy.type() == Proxy.Type.SOCKS) {
                this.inetSocketAddresses.add(InetSocketAddress.createUnresolved(s, n));
            }
            else {
                final List lookup = this.address.dns().lookup(s);
                for (int i = 0; i < lookup.size(); ++i) {
                    this.inetSocketAddresses.add(new InetSocketAddress(lookup.get(i), n));
                }
            }
            this.nextInetSocketAddressIndex = 0;
            return;
        }
        final StringBuilder sb2 = new StringBuilder();
        sb2.append("No route to ");
        sb2.append(s);
        sb2.append(":");
        sb2.append(n);
        sb2.append("; port is out of range");
        throw new SocketException(sb2.toString());
    }
    
    private void resetNextProxy(final HttpUrl httpUrl, final Proxy proxy) {
        if (proxy != null) {
            this.proxies = Collections.singletonList(proxy);
        }
        else {
            this.proxies = new ArrayList();
            final List<Proxy> select = this.address.proxySelector().select(httpUrl.uri());
            if (select != null) {
                this.proxies.addAll(select);
            }
            this.proxies.removeAll(Collections.singleton(Proxy.NO_PROXY));
            this.proxies.add(Proxy.NO_PROXY);
        }
        this.nextProxyIndex = 0;
    }
    
    public void connectFailed(final Route route, final IOException ex) {
        if (route.proxy().type() != Proxy.Type.DIRECT && this.address.proxySelector() != null) {
            this.address.proxySelector().connectFailed(this.address.url().uri(), route.proxy().address(), ex);
        }
        this.routeDatabase.failed(route);
    }
    
    public boolean hasNext() {
        if (!this.hasNextInetSocketAddress()) {
            if (!this.hasNextProxy()) {
                if (!this.hasNextPostponed()) {
                    return false;
                }
            }
        }
        return true;
    }
    
    public Route next() {
        if (!this.hasNextInetSocketAddress()) {
            if (!this.hasNextProxy()) {
                if (this.hasNextPostponed()) {
                    return this.nextPostponed();
                }
                throw new NoSuchElementException();
            }
            else {
                this.lastProxy = this.nextProxy();
            }
        }
        this.lastInetSocketAddress = this.nextInetSocketAddress();
        final Route route = new Route(this.address, this.lastProxy, this.lastInetSocketAddress);
        if (this.routeDatabase.shouldPostpone(route)) {
            this.postponedRoutes.add(route);
            return this.next();
        }
        return route;
    }
}
