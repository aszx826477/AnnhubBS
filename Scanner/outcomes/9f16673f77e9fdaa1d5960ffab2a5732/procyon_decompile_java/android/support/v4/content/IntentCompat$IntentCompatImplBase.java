// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.content;

import android.content.Intent;
import android.content.ComponentName;

class IntentCompat$IntentCompatImplBase implements IntentCompat$IntentCompatImpl
{
    public Intent makeMainActivity(final ComponentName component) {
        final Intent intent = new Intent("android.intent.action.MAIN");
        intent.setComponent(component);
        intent.addCategory("android.intent.category.LAUNCHER");
        return intent;
    }
    
    public Intent makeMainSelectorActivity(final String s, final String s2) {
        final Intent intent = new Intent(s);
        intent.addCategory(s2);
        return intent;
    }
    
    public Intent makeRestartActivityTask(final ComponentName componentName) {
        final Intent mainActivity = this.makeMainActivity(componentName);
        mainActivity.addFlags(268468224);
        return mainActivity;
    }
}
