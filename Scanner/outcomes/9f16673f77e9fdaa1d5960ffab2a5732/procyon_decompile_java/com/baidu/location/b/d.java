// 
// Decompiled by Procyon v0.5.30
// 

package com.baidu.location.b;

public final class d
{
    public static String a(final int n) {
        if (h.i()) {
            return "WIFI";
        }
        switch (n) {
            default: {
                return "unknown";
            }
            case 13: {
                return "4G";
            }
            case 3:
            case 5:
            case 6:
            case 8:
            case 9:
            case 10:
            case 12:
            case 14:
            case 15: {
                return "3G";
            }
            case 1:
            case 2:
            case 4:
            case 7:
            case 11: {
                return "2G";
            }
        }
    }
}
