// 
// Decompiled by Procyon v0.5.30
// 

package android.support.annotation;

import java.lang.annotation.Annotation;

public @interface Dimension {
    public static final int DP = 0;
    public static final int PX = 1;
    public static final int SP = 2;
    
    int unit();
}
