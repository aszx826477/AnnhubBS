// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.accessibilityservice;

import java.io.ObjectInputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.accessibilityservice.AccessibilityServiceInfo;
import android.os.Build$VERSION;

public final class AccessibilityServiceInfoCompat
{
    public static final int CAPABILITY_CAN_FILTER_KEY_EVENTS = 8;
    public static final int CAPABILITY_CAN_REQUEST_ENHANCED_WEB_ACCESSIBILITY = 4;
    public static final int CAPABILITY_CAN_REQUEST_TOUCH_EXPLORATION = 2;
    public static final int CAPABILITY_CAN_RETRIEVE_WINDOW_CONTENT = 1;
    public static final int DEFAULT = 1;
    public static final int FEEDBACK_ALL_MASK = 255;
    public static final int FEEDBACK_BRAILLE = 32;
    public static final int FLAG_INCLUDE_NOT_IMPORTANT_VIEWS = 2;
    public static final int FLAG_REPORT_VIEW_IDS = 16;
    public static final int FLAG_REQUEST_ENHANCED_WEB_ACCESSIBILITY = 8;
    public static final int FLAG_REQUEST_FILTER_KEY_EVENTS = 32;
    public static final int FLAG_REQUEST_TOUCH_EXPLORATION_MODE = 4;
    private static final AccessibilityServiceInfoCompat$AccessibilityServiceInfoVersionImpl IMPL;
    
    static {
        if (Build$VERSION.SDK_INT >= 18) {
            IMPL = new AccessibilityServiceInfoCompat$AccessibilityServiceInfoJellyBeanMr2Impl();
        }
        else if (Build$VERSION.SDK_INT >= 16) {
            IMPL = new AccessibilityServiceInfoCompat$AccessibilityServiceInfoJellyBeanImpl();
        }
        else if (Build$VERSION.SDK_INT >= 14) {
            IMPL = new AccessibilityServiceInfoCompat$AccessibilityServiceInfoIcsImpl();
        }
        else {
            IMPL = new AccessibilityServiceInfoCompat$AccessibilityServiceInfoStubImpl();
        }
    }
    
    public static String capabilityToString(final int n) {
        if (n == 4) {
            return "CAPABILITY_CAN_REQUEST_ENHANCED_WEB_ACCESSIBILITY";
        }
        if (n == 8) {
            return "CAPABILITY_CAN_FILTER_KEY_EVENTS";
        }
        switch (n) {
            default: {
                return "UNKNOWN";
            }
            case 2: {
                return "CAPABILITY_CAN_REQUEST_TOUCH_EXPLORATION";
            }
            case 1: {
                return "CAPABILITY_CAN_RETRIEVE_WINDOW_CONTENT";
            }
        }
    }
    
    public static String feedbackTypeToString(int i) {
        final StringBuilder sb = new StringBuilder();
        sb.append("[");
        while (i > 0) {
            final int numberOfTrailingZeros = Integer.numberOfTrailingZeros(i);
            final int n = 1;
            final int n2 = n << numberOfTrailingZeros;
            i &= ~n2;
            if (sb.length() > n) {
                sb.append(", ");
            }
            if (n2 != 4) {
                if (n2 != 8) {
                    if (n2 != 16) {
                        switch (n2) {
                            default: {
                                continue;
                            }
                            case 2: {
                                sb.append("FEEDBACK_HAPTIC");
                                continue;
                            }
                            case 1: {
                                sb.append("FEEDBACK_SPOKEN");
                                continue;
                            }
                        }
                    }
                    else {
                        sb.append("FEEDBACK_GENERIC");
                    }
                }
                else {
                    sb.append("FEEDBACK_VISUAL");
                }
            }
            else {
                sb.append("FEEDBACK_AUDIBLE");
            }
        }
        sb.append("]");
        return sb.toString();
    }
    
    public static String flagToString(final int n) {
        if (n == 4) {
            return "FLAG_REQUEST_TOUCH_EXPLORATION_MODE";
        }
        if (n == 8) {
            return "FLAG_REQUEST_ENHANCED_WEB_ACCESSIBILITY";
        }
        if (n == 16) {
            return "FLAG_REPORT_VIEW_IDS";
        }
        if (n == 32) {
            return "FLAG_REQUEST_FILTER_KEY_EVENTS";
        }
        switch (n) {
            default: {
                return null;
            }
            case 2: {
                return "FLAG_INCLUDE_NOT_IMPORTANT_VIEWS";
            }
            case 1: {
                return "DEFAULT";
            }
        }
    }
    
    public static boolean getCanRetrieveWindowContent(final AccessibilityServiceInfo accessibilityServiceInfo) {
        return AccessibilityServiceInfoCompat.IMPL.getCanRetrieveWindowContent(accessibilityServiceInfo);
    }
    
    public static int getCapabilities(final AccessibilityServiceInfo accessibilityServiceInfo) {
        return AccessibilityServiceInfoCompat.IMPL.getCapabilities(accessibilityServiceInfo);
    }
    
    public static String getDescription(final AccessibilityServiceInfo accessibilityServiceInfo) {
        return AccessibilityServiceInfoCompat.IMPL.getDescription(accessibilityServiceInfo);
    }
    
    public static String getId(final AccessibilityServiceInfo accessibilityServiceInfo) {
        return AccessibilityServiceInfoCompat.IMPL.getId(accessibilityServiceInfo);
    }
    
    public static ResolveInfo getResolveInfo(final AccessibilityServiceInfo accessibilityServiceInfo) {
        return AccessibilityServiceInfoCompat.IMPL.getResolveInfo(accessibilityServiceInfo);
    }
    
    public static String getSettingsActivityName(final AccessibilityServiceInfo accessibilityServiceInfo) {
        return AccessibilityServiceInfoCompat.IMPL.getSettingsActivityName(accessibilityServiceInfo);
    }
    
    public static String loadDescription(final AccessibilityServiceInfo accessibilityServiceInfo, final PackageManager packageManager) {
        return AccessibilityServiceInfoCompat.IMPL.loadDescription(accessibilityServiceInfo, packageManager);
    }
}
