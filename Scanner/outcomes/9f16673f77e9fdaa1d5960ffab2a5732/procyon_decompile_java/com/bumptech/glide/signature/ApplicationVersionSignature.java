// 
// Decompiled by Procyon v0.5.30
// 

package com.bumptech.glide.signature;

import android.content.pm.PackageManager;
import android.content.pm.PackageInfo;
import java.util.UUID;
import android.content.pm.PackageManager$NameNotFoundException;
import com.bumptech.glide.load.Key;
import android.content.Context;
import java.util.concurrent.ConcurrentHashMap;

public final class ApplicationVersionSignature
{
    private static final ConcurrentHashMap PACKAGE_NAME_TO_KEY;
    
    static {
        PACKAGE_NAME_TO_KEY = new ConcurrentHashMap();
    }
    
    public static Key obtain(final Context context) {
        final String packageName = context.getPackageName();
        Key key = ApplicationVersionSignature.PACKAGE_NAME_TO_KEY.get(packageName);
        if (key == null) {
            final Key obtainVersionSignature = obtainVersionSignature(context);
            key = ApplicationVersionSignature.PACKAGE_NAME_TO_KEY.putIfAbsent(packageName, obtainVersionSignature);
            if (key == null) {
                key = obtainVersionSignature;
            }
        }
        return key;
    }
    
    private static Key obtainVersionSignature(final Context context) {
        PackageInfo packageInfo = null;
        try {
            final PackageManager packageManager = context.getPackageManager();
            try {
                packageInfo = packageManager.getPackageInfo(context.getPackageName(), 0);
            }
            catch (PackageManager$NameNotFoundException ex) {
                ex.printStackTrace();
            }
        }
        catch (PackageManager$NameNotFoundException ex2) {}
        String s;
        if (packageInfo != null) {
            s = String.valueOf(packageInfo.versionCode);
        }
        else {
            s = UUID.randomUUID().toString();
        }
        return new StringSignature(s);
    }
    
    static void reset() {
        ApplicationVersionSignature.PACKAGE_NAME_TO_KEY.clear();
    }
}
