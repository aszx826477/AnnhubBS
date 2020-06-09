// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.accessibilityservice;

import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.accessibilityservice.AccessibilityServiceInfo;

class AccessibilityServiceInfoCompat$AccessibilityServiceInfoStubImpl implements AccessibilityServiceInfoCompat$AccessibilityServiceInfoVersionImpl
{
    public boolean getCanRetrieveWindowContent(final AccessibilityServiceInfo accessibilityServiceInfo) {
        return false;
    }
    
    public int getCapabilities(final AccessibilityServiceInfo accessibilityServiceInfo) {
        return 0;
    }
    
    public String getDescription(final AccessibilityServiceInfo accessibilityServiceInfo) {
        return null;
    }
    
    public String getId(final AccessibilityServiceInfo accessibilityServiceInfo) {
        return null;
    }
    
    public ResolveInfo getResolveInfo(final AccessibilityServiceInfo accessibilityServiceInfo) {
        return null;
    }
    
    public String getSettingsActivityName(final AccessibilityServiceInfo accessibilityServiceInfo) {
        return null;
    }
    
    public String loadDescription(final AccessibilityServiceInfo accessibilityServiceInfo, final PackageManager packageManager) {
        return null;
    }
}
