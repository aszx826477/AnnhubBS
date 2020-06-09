// 
// Decompiled by Procyon v0.5.30
// 

package com.bumptech.glide.load.engine;

public enum DiskCacheStrategy
{
    ALL("ALL", 0, (boolean)(n != 0), (boolean)(n != 0)), 
    NONE("NONE", n, false, false), 
    RESULT("RESULT", n3, false, (boolean)(n != 0)), 
    SOURCE("SOURCE", n2, (boolean)(n != 0), false);
    
    private final boolean cacheResult;
    private final boolean cacheSource;
    
    static {
        final int n = 1;
        final int n2 = 2;
        final int n3 = 3;
        final DiskCacheStrategy[] $values = new DiskCacheStrategy[4];
        $values[0] = DiskCacheStrategy.ALL;
        $values[n] = DiskCacheStrategy.NONE;
        $values[n2] = DiskCacheStrategy.SOURCE;
        $values[n3] = DiskCacheStrategy.RESULT;
        $VALUES = $values;
    }
    
    private DiskCacheStrategy(final String s, final int n, final boolean cacheSource, final boolean cacheResult) {
        this.cacheSource = cacheSource;
        this.cacheResult = cacheResult;
    }
    
    public boolean cacheResult() {
        return this.cacheResult;
    }
    
    public boolean cacheSource() {
        return this.cacheSource;
    }
}
