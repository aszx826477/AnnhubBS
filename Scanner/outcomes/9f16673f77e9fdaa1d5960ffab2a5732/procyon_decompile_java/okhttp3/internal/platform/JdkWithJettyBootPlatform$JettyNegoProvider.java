// 
// Decompiled by Procyon v0.5.30
// 

package okhttp3.internal.platform;

import okhttp3.internal.Util;
import java.lang.reflect.Method;
import java.util.List;
import java.lang.reflect.InvocationHandler;

class JdkWithJettyBootPlatform$JettyNegoProvider implements InvocationHandler
{
    private final List protocols;
    private String selected;
    private boolean unsupported;
    
    public JdkWithJettyBootPlatform$JettyNegoProvider(final List protocols) {
        this.protocols = protocols;
    }
    
    public Object invoke(final Object o, final Method method, Object[] empty_STRING_ARRAY) {
        final String name = method.getName();
        final Class<?> returnType = method.getReturnType();
        if (empty_STRING_ARRAY == null) {
            empty_STRING_ARRAY = Util.EMPTY_STRING_ARRAY;
        }
        final boolean equals = name.equals("supports");
        final boolean unsupported = true;
        if (equals && Boolean.TYPE == returnType) {
            return unsupported;
        }
        if (name.equals("unsupported") && Void.TYPE == returnType) {
            this.unsupported = unsupported;
            return null;
        }
        if (name.equals("protocols") && empty_STRING_ARRAY.length == 0) {
            return this.protocols;
        }
        if ((name.equals("selectProtocol") || name.equals("select")) && String.class == returnType && empty_STRING_ARRAY.length == (unsupported ? 1 : 0) && empty_STRING_ARRAY[0] instanceof List) {
            final List list = (List)empty_STRING_ARRAY[0];
            for (int i = 0; i < list.size(); ++i) {
                if (this.protocols.contains(list.get(i))) {
                    return this.selected = list.get(i);
                }
            }
            return this.selected = this.protocols.get(0);
        }
        if ((name.equals("protocolSelected") || name.equals("selected")) && empty_STRING_ARRAY.length == (unsupported ? 1 : 0)) {
            this.selected = (String)empty_STRING_ARRAY[0];
            return null;
        }
        return method.invoke(this, empty_STRING_ARRAY);
    }
}
