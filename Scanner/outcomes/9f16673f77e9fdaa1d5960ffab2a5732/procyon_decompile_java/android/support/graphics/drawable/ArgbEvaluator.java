// 
// Decompiled by Procyon v0.5.30
// 

package android.support.graphics.drawable;

import android.animation.TypeEvaluator;

public class ArgbEvaluator implements TypeEvaluator
{
    private static final ArgbEvaluator sInstance;
    
    static {
        sInstance = new ArgbEvaluator();
    }
    
    public static ArgbEvaluator getInstance() {
        return ArgbEvaluator.sInstance;
    }
    
    public Object evaluate(final float n, final Object o, final Object o2) {
        final int intValue = (int)o;
        final float n2 = intValue >> 24 & 0xFF;
        final float n3 = 255.0f;
        final float n4 = n2 / n3;
        final float n5 = (intValue >> 16 & 0xFF) / n3;
        final float n6 = (intValue >> 8 & 0xFF) / n3;
        final float n7 = (intValue & 0xFF) / n3;
        final int intValue2 = (int)o2;
        final float n8 = (intValue2 >> 24 & 0xFF) / n3;
        final float n9 = (intValue2 >> 16 & 0xFF) / n3;
        final float n10 = (intValue2 >> 8 & 0xFF) / n3;
        final float n11 = (intValue2 & 0xFF) / n3;
        final double n12 = n5;
        final double n13 = 2.2;
        final float n14 = (float)Math.pow(n12, n13);
        final float n15 = (float)Math.pow(n6, n13);
        final float n16 = (float)Math.pow(n7, n13);
        final float n17 = (float)Math.pow(n9, n13);
        final float n18 = (float)Math.pow(n10, n13);
        final float n19 = (float)Math.pow(n11, n13);
        final float n20 = (n8 - n4) * n + n4;
        final float n21 = (n17 - n14) * n + n14;
        final float n22 = (n18 - n15) * n + n15;
        final float n23 = (n19 - n16) * n + n16;
        final float n24 = n20 * n3;
        final double n25 = n21;
        final double n26 = 0.45454545454545453;
        return Math.round(n24) << 24 | Math.round((float)Math.pow(n25, n26) * 255.0f) << 16 | Math.round((float)Math.pow(n22, n26) * 255.0f) << 8 | Math.round((float)Math.pow(n23, n26) * 255.0f);
    }
}
