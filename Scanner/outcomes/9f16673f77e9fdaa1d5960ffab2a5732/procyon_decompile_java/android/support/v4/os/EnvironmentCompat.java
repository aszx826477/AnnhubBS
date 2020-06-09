// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.os;

import java.io.IOException;
import android.util.Log;
import android.os.Environment;
import android.os.Build$VERSION;
import java.io.File;

public final class EnvironmentCompat
{
    public static final String MEDIA_UNKNOWN = "unknown";
    private static final String TAG = "EnvironmentCompat";
    
    public static String getStorageState(final File file) {
        if (Build$VERSION.SDK_INT >= 19) {
            return EnvironmentCompatKitKat.getStorageState(file);
        }
        try {
            final String canonicalPath = file.getCanonicalPath();
            try {
                final File externalStorageDirectory = Environment.getExternalStorageDirectory();
                try {
                    if (canonicalPath.startsWith(externalStorageDirectory.getCanonicalPath())) {
                        return Environment.getExternalStorageState();
                    }
                    return "unknown";
                }
                catch (IOException ex) {
                    final String s = "EnvironmentCompat";
                    final StringBuilder sb = new StringBuilder();
                    sb.append("Failed to resolve canonical path: ");
                    sb.append(ex);
                    Log.w(s, sb.toString());
                }
            }
            catch (IOException ex2) {}
        }
        catch (IOException ex3) {}
        return "unknown";
    }
}
