// 
// Decompiled by Procyon v0.5.30
// 

package okhttp3;

import java.net.UnknownHostException;
import java.util.Arrays;
import java.net.InetAddress;
import java.util.List;

final class Dns$1 implements Dns
{
    public List lookup(final String s) {
        if (s != null) {
            return Arrays.asList(InetAddress.getAllByName(s));
        }
        throw new UnknownHostException("hostname == null");
    }
}
