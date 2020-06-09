// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.app;

import java.lang.reflect.Method;
import android.content.pm.ApplicationInfo;
import java.lang.reflect.InvocationTargetException;
import android.app.AppOpsManager;
import android.content.Context;

class NotificationManagerCompatKitKat
{
    private static final String CHECK_OP_NO_THROW = "checkOpNoThrow";
    private static final String OP_POST_NOTIFICATION = "OP_POST_NOTIFICATION";
    
    public static boolean areNotificationsEnabled(final Context context) {
        final AppOpsManager appOpsManager = (AppOpsManager)context.getSystemService("appops");
        final ApplicationInfo applicationInfo = context.getApplicationInfo();
        final String packageName = context.getApplicationContext().getPackageName();
        final int uid = applicationInfo.uid;
        int n = 1;
        final Class<AppOpsManager> clazz = AppOpsManager.class;
        try {
            final String name = clazz.getName();
            try {
                final Class<?> forName = Class.forName(name);
                final String s = "checkOpNoThrow";
                final int n2 = 3;
                final Class[] array = new Class[n2];
                try {
                    array[0] = Integer.TYPE;
                    array[n] = Integer.TYPE;
                    final Class<String> clazz2 = String.class;
                    final int n3 = 2;
                    array[n3] = clazz2;
                    final Method method = forName.getMethod(s, (Class<?>[])array);
                    final Object value = forName.getDeclaredField("OP_POST_NOTIFICATION").get(Integer.class);
                    try {
                        final Integer n4 = (Integer)value;
                        try {
                            final int intValue = n4;
                            try {
                                final Object[] array2 = new Object[n2];
                                try {
                                    array2[0] = intValue;
                                    array2[n] = uid;
                                    array2[n3] = packageName;
                                    final Object invoke = method.invoke(appOpsManager, array2);
                                    try {
                                        final Integer n5 = (Integer)invoke;
                                        try {
                                            if (n5 != 0) {
                                                n = 0;
                                            }
                                            return n != 0;
                                        }
                                        catch (RuntimeException ex) {}
                                        catch (IllegalAccessException ex2) {}
                                        catch (InvocationTargetException ex3) {}
                                        catch (NoSuchFieldException ex4) {}
                                        catch (NoSuchMethodException ex5) {}
                                        catch (ClassNotFoundException ex6) {}
                                    }
                                    catch (RuntimeException ex7) {}
                                    catch (IllegalAccessException ex8) {}
                                    catch (InvocationTargetException ex9) {}
                                    catch (NoSuchFieldException ex10) {}
                                    catch (NoSuchMethodException ex11) {}
                                    catch (ClassNotFoundException ex12) {}
                                }
                                catch (RuntimeException ex13) {}
                                catch (IllegalAccessException ex14) {}
                                catch (InvocationTargetException ex15) {}
                                catch (NoSuchFieldException ex16) {}
                                catch (NoSuchMethodException ex17) {}
                                catch (ClassNotFoundException ex18) {}
                            }
                            catch (RuntimeException ex19) {}
                            catch (IllegalAccessException ex20) {}
                            catch (InvocationTargetException ex21) {}
                            catch (NoSuchFieldException ex22) {}
                            catch (NoSuchMethodException ex23) {}
                            catch (ClassNotFoundException ex24) {}
                        }
                        catch (RuntimeException ex25) {}
                        catch (IllegalAccessException ex26) {}
                        catch (InvocationTargetException ex27) {}
                        catch (NoSuchFieldException ex28) {}
                        catch (NoSuchMethodException ex29) {}
                        catch (ClassNotFoundException ex30) {}
                    }
                    catch (RuntimeException ex31) {}
                    catch (IllegalAccessException ex32) {}
                    catch (InvocationTargetException ex33) {}
                    catch (NoSuchFieldException ex34) {}
                    catch (NoSuchMethodException ex35) {}
                    catch (ClassNotFoundException ex36) {}
                }
                catch (RuntimeException ex37) {}
                catch (IllegalAccessException ex38) {}
                catch (InvocationTargetException ex39) {}
                catch (NoSuchFieldException ex40) {}
                catch (NoSuchMethodException ex41) {}
                catch (ClassNotFoundException ex42) {}
            }
            catch (RuntimeException ex43) {}
            catch (IllegalAccessException ex44) {}
            catch (InvocationTargetException ex45) {}
            catch (NoSuchFieldException ex46) {}
            catch (NoSuchMethodException ex47) {}
            catch (ClassNotFoundException ex48) {}
        }
        catch (RuntimeException ex49) {}
        catch (IllegalAccessException ex50) {}
        catch (InvocationTargetException ex51) {}
        catch (NoSuchFieldException ex52) {}
        catch (NoSuchMethodException ex53) {}
        catch (ClassNotFoundException ex54) {}
        return n != 0;
    }
}
