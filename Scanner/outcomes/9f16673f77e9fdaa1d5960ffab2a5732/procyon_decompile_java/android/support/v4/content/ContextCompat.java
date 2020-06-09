// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.content;

import android.os.Bundle;
import android.content.Intent;
import android.os.Environment;
import android.graphics.drawable.Drawable;
import android.content.res.ColorStateList;
import android.os.Build$VERSION;
import android.util.Log;
import android.support.v4.os.BuildCompat;
import android.os.Process;
import android.content.Context;
import java.io.File;
import android.util.TypedValue;

public class ContextCompat
{
    private static final String DIR_ANDROID = "Android";
    private static final String DIR_OBB = "obb";
    private static final String TAG = "ContextCompat";
    private static final Object sLock;
    private static TypedValue sTempValue;
    
    static {
        sLock = new Object();
    }
    
    private static File buildPath(final File file, final String... array) {
        File file2 = file;
        for (int length = array.length, i = 0; i < length; ++i) {
            final String s = array[i];
            if (file2 == null) {
                file2 = new File(s);
            }
            else if (s != null) {
                file2 = new File(file2, s);
            }
        }
        return file2;
    }
    
    public static int checkSelfPermission(final Context context, final String s) {
        if (s != null) {
            return context.checkPermission(s, Process.myPid(), Process.myUid());
        }
        throw new IllegalArgumentException("permission is null");
    }
    
    public static Context createDeviceProtectedStorageContext(final Context context) {
        if (BuildCompat.isAtLeastN()) {
            return ContextCompatApi24.createDeviceProtectedStorageContext(context);
        }
        return null;
    }
    
    private static File createFilesDir(final File file) {
        synchronized (ContextCompat.class) {
            if (file.exists() || file.mkdirs()) {
                return file;
            }
            if (file.exists()) {
                return file;
            }
            final String s = "ContextCompat";
            final StringBuilder sb = new StringBuilder();
            sb.append("Unable to create files subdir ");
            sb.append(file.getPath());
            Log.w(s, sb.toString());
            return null;
        }
    }
    
    public static File getCodeCacheDir(final Context context) {
        if (Build$VERSION.SDK_INT >= 21) {
            return ContextCompatApi21.getCodeCacheDir(context);
        }
        return createFilesDir(new File(context.getApplicationInfo().dataDir, "code_cache"));
    }
    
    public static final int getColor(final Context context, final int n) {
        if (Build$VERSION.SDK_INT >= 23) {
            return ContextCompatApi23.getColor(context, n);
        }
        return context.getResources().getColor(n);
    }
    
    public static final ColorStateList getColorStateList(final Context context, final int n) {
        if (Build$VERSION.SDK_INT >= 23) {
            return ContextCompatApi23.getColorStateList(context, n);
        }
        return context.getResources().getColorStateList(n);
    }
    
    public static File getDataDir(final Context context) {
        if (BuildCompat.isAtLeastN()) {
            return ContextCompatApi24.getDataDir(context);
        }
        final String dataDir = context.getApplicationInfo().dataDir;
        File file;
        if (dataDir != null) {
            file = new File(dataDir);
        }
        else {
            file = null;
        }
        return file;
    }
    
    public static final Drawable getDrawable(final Context context, final int n) {
        final int sdk_INT = Build$VERSION.SDK_INT;
        if (sdk_INT >= 21) {
            return ContextCompatApi21.getDrawable(context, n);
        }
        if (sdk_INT >= 16) {
            return context.getResources().getDrawable(n);
        }
        final Object sLock = ContextCompat.sLock;
        synchronized (sLock) {
            if (ContextCompat.sTempValue == null) {
                ContextCompat.sTempValue = new TypedValue();
            }
            context.getResources().getValue(n, ContextCompat.sTempValue, true);
            final int resourceId = ContextCompat.sTempValue.resourceId;
            // monitorexit(sLock)
            return context.getResources().getDrawable(resourceId);
        }
    }
    
    public static File[] getExternalCacheDirs(final Context context) {
        if (Build$VERSION.SDK_INT >= 19) {
            return ContextCompatKitKat.getExternalCacheDirs(context);
        }
        return new File[] { context.getExternalCacheDir() };
    }
    
    public static File[] getExternalFilesDirs(final Context context, final String s) {
        if (Build$VERSION.SDK_INT >= 19) {
            return ContextCompatKitKat.getExternalFilesDirs(context, s);
        }
        return new File[] { context.getExternalFilesDir(s) };
    }
    
    public static final File getNoBackupFilesDir(final Context context) {
        if (Build$VERSION.SDK_INT >= 21) {
            return ContextCompatApi21.getNoBackupFilesDir(context);
        }
        return createFilesDir(new File(context.getApplicationInfo().dataDir, "no_backup"));
    }
    
    public static File[] getObbDirs(final Context context) {
        final int sdk_INT = Build$VERSION.SDK_INT;
        if (sdk_INT >= 19) {
            return ContextCompatKitKat.getObbDirs(context);
        }
        final int n = 11;
        final int n2 = 1;
        File file;
        if (sdk_INT >= n) {
            file = ContextCompatHoneycomb.getObbDir(context);
        }
        else {
            final File externalStorageDirectory = Environment.getExternalStorageDirectory();
            final String[] array = { "Android", null, null };
            array[n2] = "obb";
            array[2] = context.getPackageName();
            file = buildPath(externalStorageDirectory, array);
        }
        final File[] array2 = new File[n2];
        array2[0] = file;
        return array2;
    }
    
    public static boolean isDeviceProtectedStorage(final Context context) {
        return BuildCompat.isAtLeastN() && ContextCompatApi24.isDeviceProtectedStorage(context);
    }
    
    public static boolean startActivities(final Context context, final Intent[] array) {
        return startActivities(context, array, null);
    }
    
    public static boolean startActivities(final Context context, final Intent[] array, final Bundle bundle) {
        final int sdk_INT = Build$VERSION.SDK_INT;
        final boolean b = true;
        if (sdk_INT >= 16) {
            ContextCompatJellybean.startActivities(context, array, bundle);
            return b;
        }
        if (sdk_INT >= 11) {
            ContextCompatHoneycomb.startActivities(context, array);
            return b;
        }
        return false;
    }
    
    public static void startActivity(final Context context, final Intent intent, final Bundle bundle) {
        if (Build$VERSION.SDK_INT >= 16) {
            ContextCompatJellybean.startActivity(context, intent, bundle);
        }
        else {
            context.startActivity(intent);
        }
    }
}
