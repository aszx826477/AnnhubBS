// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.app;

import android.content.pm.PackageManager;
import android.app.Activity;

final class ActivityCompat$1 implements Runnable
{
    final /* synthetic */ Activity val$activity;
    final /* synthetic */ String[] val$permissions;
    final /* synthetic */ int val$requestCode;
    
    ActivityCompat$1(final String[] val$permissions, final Activity val$activity, final int val$requestCode) {
        this.val$permissions = val$permissions;
        this.val$activity = val$activity;
        this.val$requestCode = val$requestCode;
    }
    
    public void run() {
        final int[] array = new int[this.val$permissions.length];
        final PackageManager packageManager = this.val$activity.getPackageManager();
        final String packageName = this.val$activity.getPackageName();
        for (int length = this.val$permissions.length, i = 0; i < length; ++i) {
            array[i] = packageManager.checkPermission(this.val$permissions[i], packageName);
        }
        ((ActivityCompat$OnRequestPermissionsResultCallback)this.val$activity).onRequestPermissionsResult(this.val$requestCode, this.val$permissions, array);
    }
}
