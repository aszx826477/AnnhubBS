// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.accessibilityservice;

import android.content.pm.PackageManager;
import android.accessibilityservice.AccessibilityServiceInfo;

class AccessibilityServiceInfoCompat$AccessibilityServiceInfoJellyBeanImpl extends AccessibilityServiceInfoCompat$AccessibilityServiceInfoIcsImpl
{
    public String loadDescription(final AccessibilityServiceInfo accessibilityServiceInfo, final PackageManager packageManager) {
        return AccessibilityServiceInfoCompatJellyBean.loadDescription(accessibilityServiceInfo, packageManager);
    }
}
