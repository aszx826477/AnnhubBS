// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.media.session;

import java.lang.reflect.Method;
import java.lang.reflect.GenericDeclaration;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import android.media.session.MediaSession;

class MediaSessionCompatApi24
{
    private static final String TAG = "MediaSessionCompatApi24";
    
    public static Object createCallback(final MediaSessionCompatApi24$Callback mediaSessionCompatApi24$Callback) {
        return new MediaSessionCompatApi24$CallbackProxy(mediaSessionCompatApi24$Callback);
    }
    
    public static String getCallingPackage(final Object o) {
        final MediaSession mediaSession = (MediaSession)o;
        GenericDeclaration genericDeclaration = null;
        try {
            genericDeclaration = mediaSession.getClass();
            genericDeclaration = ((Class)genericDeclaration).getMethod("getCallingPackage", (Class[])new Class[0]);
            try {
                final Object invoke = ((Method)genericDeclaration).invoke(mediaSession, new Object[0]);
                try {
                    return (String)invoke;
                }
                catch (IllegalAccessException genericDeclaration) {}
                catch (InvocationTargetException genericDeclaration) {}
                catch (NoSuchMethodException ex) {}
            }
            catch (IllegalAccessException ex2) {}
            catch (InvocationTargetException ex3) {}
            catch (NoSuchMethodException ex4) {}
        }
        catch (IllegalAccessException ex5) {}
        catch (InvocationTargetException ex6) {}
        catch (NoSuchMethodException ex7) {}
        Log.e("MediaSessionCompatApi24", "Cannot execute MediaSession.getCallingPackage()", (Throwable)genericDeclaration);
        return null;
    }
}
