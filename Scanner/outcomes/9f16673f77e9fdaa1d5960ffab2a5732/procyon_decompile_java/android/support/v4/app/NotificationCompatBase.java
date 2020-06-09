// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.app;

import java.lang.reflect.InvocationTargetException;
import android.app.PendingIntent;
import android.content.Context;
import android.app.Notification;
import java.lang.reflect.Method;

public class NotificationCompatBase
{
    private static Method sSetLatestEventInfo;
    
    public static Notification add(final Notification notification, final Context context, final CharSequence charSequence, final CharSequence charSequence2, final PendingIntent pendingIntent, final PendingIntent fullScreenIntent) {
        Method sSetLatestEventInfo = NotificationCompatBase.sSetLatestEventInfo;
        final int n = 3;
        final int n2 = 2;
        final int n3 = 1;
        final int n4 = 4;
        if (sSetLatestEventInfo == null) {
            final Class<Notification> clazz = Notification.class;
            final String s = "setLatestEventInfo";
            try {
                final Class[] array = new Class[n4];
                array[0] = Context.class;
                array[n2] = (array[n3] = CharSequence.class);
                array[n] = PendingIntent.class;
                sSetLatestEventInfo = clazz.getMethod(s, (Class[])array);
                try {
                    NotificationCompatBase.sSetLatestEventInfo = sSetLatestEventInfo;
                }
                catch (NoSuchMethodException ex) {
                    throw new RuntimeException(ex);
                }
            }
            catch (NoSuchMethodException ex2) {}
        }
        try {
            sSetLatestEventInfo = NotificationCompatBase.sSetLatestEventInfo;
            try {
                final Object[] array2 = new Object[n4];
                array2[0] = context;
                array2[n3] = charSequence;
                array2[n2] = charSequence2;
                array2[n] = pendingIntent;
                sSetLatestEventInfo.invoke(notification, array2);
                notification.fullScreenIntent = fullScreenIntent;
                return notification;
            }
            catch (InvocationTargetException sSetLatestEventInfo) {}
            catch (IllegalAccessException ex3) {}
        }
        catch (InvocationTargetException ex4) {}
        catch (IllegalAccessException ex5) {}
        throw new RuntimeException((Throwable)sSetLatestEventInfo);
    }
}
