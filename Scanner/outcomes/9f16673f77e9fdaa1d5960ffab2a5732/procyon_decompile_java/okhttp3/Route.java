// 
// Decompiled by Procyon v0.5.30
// 

package okhttp3;

import java.net.Proxy;
import java.net.InetSocketAddress;

public final class Route
{
    final Address address;
    final InetSocketAddress inetSocketAddress;
    final Proxy proxy;
    
    public Route(final Address address, final Proxy proxy, final InetSocketAddress inetSocketAddress) {
        if (address == null) {
            throw new NullPointerException("address == null");
        }
        if (proxy == null) {
            throw new NullPointerException("proxy == null");
        }
        if (inetSocketAddress != null) {
            this.address = address;
            this.proxy = proxy;
            this.inetSocketAddress = inetSocketAddress;
            return;
        }
        throw new NullPointerException("inetSocketAddress == null");
    }
    
    public Address address() {
        return this.address;
    }
    
    public boolean equals(final Object o) {
        final boolean b = o instanceof Route;
        boolean b2 = false;
        if (b) {
            final Route route = (Route)o;
            if (this.address.equals(route.address)) {
                if (this.proxy.equals(route.proxy)) {
                    if (this.inetSocketAddress.equals(route.inetSocketAddress)) {
                        b2 = true;
                    }
                }
            }
            return b2;
        }
        return false;
    }
    
    public int hashCode() {
        return ((17 * 31 + this.address.hashCode()) * 31 + this.proxy.hashCode()) * 31 + this.inetSocketAddress.hashCode();
    }
    
    public Proxy proxy() {
        return this.proxy;
    }
    
    public boolean requiresTunnel() {
        return this.address.sslSocketFactory != null && this.proxy.type() == Proxy.Type.HTTP;
    }
    
    public InetSocketAddress socketAddress() {
        return this.inetSocketAddress;
    }
}
