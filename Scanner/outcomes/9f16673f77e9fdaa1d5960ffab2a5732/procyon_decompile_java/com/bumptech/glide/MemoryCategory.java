// 
// Decompiled by Procyon v0.5.30
// 

package com.bumptech.glide;

public enum MemoryCategory
{
    HIGH("HIGH", n2, 1.5f), 
    LOW("LOW", 0, 0.5f), 
    NORMAL("NORMAL", n, 1.0f);
    
    private float multiplier;
    
    static {
        final int n = 1;
        final int n2 = 2;
        final MemoryCategory[] $values = { MemoryCategory.LOW, null, null };
        $values[n] = MemoryCategory.NORMAL;
        $values[n2] = MemoryCategory.HIGH;
        $VALUES = $values;
    }
    
    private MemoryCategory(final String s, final int n, final float multiplier) {
        this.multiplier = multiplier;
    }
    
    public float getMultiplier() {
        return this.multiplier;
    }
}
