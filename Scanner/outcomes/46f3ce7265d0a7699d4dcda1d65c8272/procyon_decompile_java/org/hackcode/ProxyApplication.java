// 
// Decompiled by Procyon v0.5.30
// 

package org.hackcode;

import android.widget.Toast;
import android.app.Instrumentation;
import android.content.pm.ApplicationInfo;
import java.util.ArrayList;
import java.lang.ref.WeakReference;
import java.util.Map;
import android.util.Log;
import android.content.Context;
import android.app.Application;

public class ProxyApplication extends Application
{
    static {
        System.loadLibrary("hackcodejiagu");
    }
    
    private native void start(final Application p0, final String p1, final ClassLoader p2, final Object p3);
    
    public void attachBaseContext(final Context context) {
        super.attachBaseContext(context);
        Log.v("demo", "[JiaguApk]=>attachBaseContext() start...");
        final String s = "android.app.ActivityThread";
        final String s2 = "currentActivityThread";
        try {
            final Class[] array = new Class[0];
            try {
                final Object invokeStaticMethod = ReflectUtils.invokeStaticMethod(s, s2, array, new Object[0]);
                try {
                    final String packageName = this.getPackageName();
                    final Object fieldObject = ReflectUtils.getFieldObject("android.app.ActivityThread", invokeStaticMethod, "mPackages");
                    try {
                        final Object value = ((Map<K, Object>)fieldObject).get(packageName);
                        try {
                            final WeakReference<Object> weakReference = (WeakReference<Object>)value;
                            try {
                                try {
                                    final StringBuilder sb = new StringBuilder();
                                    sb.append("/data/data/");
                                    final StringBuilder sb2 = sb;
                                    try {
                                        sb2.append(packageName);
                                        sb.append("/lib");
                                        final String string = sb.toString();
                                        try {
                                            final ClassLoader classLoader = context.getClassLoader();
                                            try {
                                                final ClassLoader parent = classLoader.getParent();
                                                try {
                                                    this.start(this, string, parent, weakReference.get());
                                                }
                                                catch (Exception ex) {
                                                    final String s3 = "demo";
                                                    final StringBuilder sb3 = new StringBuilder();
                                                    sb3.append("[JiaguApk]=>attachBaseContext() ");
                                                    sb3.append(Log.getStackTraceString((Throwable)ex));
                                                    Log.v(s3, sb3.toString());
                                                }
                                            }
                                            catch (Exception ex2) {}
                                        }
                                        catch (Exception ex3) {}
                                    }
                                    catch (Exception ex4) {}
                                }
                                catch (Exception ex5) {}
                            }
                            catch (Exception ex6) {}
                        }
                        catch (Exception ex7) {}
                    }
                    catch (Exception ex8) {}
                }
                catch (Exception ex9) {}
            }
            catch (Exception ex10) {}
        }
        catch (Exception ex11) {}
        Log.v("demo", "[JiaguApk]=>attachBaseContext() end...");
    }
    
    public String bytesToHexString(final byte[] array) {
        final StringBuilder sb = new StringBuilder("");
        if (array != null && array.length > 0) {
            for (int i = 0; i < array.length; ++i) {
                final String hexString = Integer.toHexString(array[i] & 0xFF);
                if (hexString.length() < 2) {
                    sb.append(0);
                }
                sb.append(hexString);
            }
            return sb.toString();
        }
        return null;
    }
    
    public void onCreate() {
        final int n = 1;
        final String s = "org.litepal.LitePalApplication";
        final String s2 = "android.app.ActivityThread";
        final String s3 = "currentActivityThread";
        Label_0469: {
            try {
                final Class[] array = new Class[0];
                try {
                    final Object invokeStaticMethod = ReflectUtils.invokeStaticMethod(s2, s3, array, new Object[0]);
                    final Object fieldObject = ReflectUtils.getFieldObject("android.app.ActivityThread", invokeStaticMethod, "mBoundApplication");
                    final Object fieldObject2 = ReflectUtils.getFieldObject("android.app.ActivityThread$AppBindData", fieldObject, "info");
                    Label_0148: {
                        if (fieldObject2 == null) {
                            Log.v("demo", "[JiaguApk]=>onCreate()=>loadedApkInfo is null!!!");
                            break Label_0148;
                        }
                        final String s4 = "demo";
                        try {
                            final StringBuilder sb = new StringBuilder();
                            sb.append("[JiaguApk]=>onCreate()=>loadedApkInfo:");
                            final StringBuilder sb2 = sb;
                            try {
                                sb2.append(fieldObject2);
                                Log.v(s4, sb.toString());
                                ReflectUtils.setFieldObject("android.app.LoadedApk", "mApplication", fieldObject2, null);
                                final Object fieldObject3 = ReflectUtils.getFieldObject("android.app.ActivityThread", invokeStaticMethod, "mInitialApplication");
                                final Object fieldObject4 = ReflectUtils.getFieldObject("android.app.ActivityThread", invokeStaticMethod, "mAllApplications");
                                try {
                                    ((ArrayList)fieldObject4).remove(fieldObject3);
                                    final Object fieldObject5 = ReflectUtils.getFieldObject("android.app.LoadedApk", fieldObject2, "mApplicationInfo");
                                    try {
                                        final ApplicationInfo applicationInfo = (ApplicationInfo)fieldObject5;
                                        final Object fieldObject6 = ReflectUtils.getFieldObject("android.app.ActivityThread$AppBindData", fieldObject, "appInfo");
                                        try {
                                            final ApplicationInfo applicationInfo2 = (ApplicationInfo)fieldObject6;
                                            applicationInfo.className = s;
                                            final ApplicationInfo applicationInfo3 = applicationInfo2;
                                            try {
                                                applicationInfo3.className = s;
                                                final String s5 = "android.app.LoadedApk";
                                                final String s6 = "makeApplication";
                                                final int n2 = 2;
                                                final Class[] array2 = new Class[n2];
                                                try {
                                                    array2[0] = Boolean.TYPE;
                                                    array2[n] = Instrumentation.class;
                                                    final Object[] array3 = new Object[n2];
                                                    try {
                                                        array3[0] = false;
                                                        array3[n] = null;
                                                        final Object invokeMethod = ReflectUtils.invokeMethod(s5, s6, fieldObject2, array2, array3);
                                                        try {
                                                            final Application application = (Application)invokeMethod;
                                                            ReflectUtils.setFieldObject("android.app.ActivityThread", "mInitialApplication", invokeStaticMethod, application);
                                                            if (application == null) {
                                                                Log.v("demo", "[JiaguApk]=>onCreate()=>app is null!!!");
                                                                break Label_0469;
                                                            }
                                                            application.onCreate();
                                                            Log.v("demo", "[JiaguApk]=>onCreate() success!");
                                                        }
                                                        catch (Exception ex) {
                                                            final String s7 = "demo";
                                                            final StringBuilder sb3 = new StringBuilder();
                                                            sb3.append("[JiaguApk]=>onCreate() ");
                                                            sb3.append(Log.getStackTraceString((Throwable)ex));
                                                            Log.v(s7, sb3.toString());
                                                        }
                                                    }
                                                    catch (Exception ex2) {}
                                                }
                                                catch (Exception ex3) {}
                                            }
                                            catch (Exception ex4) {}
                                        }
                                        catch (Exception ex5) {}
                                    }
                                    catch (Exception ex6) {}
                                }
                                catch (Exception ex7) {}
                            }
                            catch (Exception ex8) {}
                        }
                        catch (Exception ex9) {}
                    }
                }
                catch (Exception ex10) {}
            }
            catch (Exception ex11) {}
        }
        Toast.makeText((Context)this, (CharSequence)"Enforced by 01hackcode", n).show();
    }
}
