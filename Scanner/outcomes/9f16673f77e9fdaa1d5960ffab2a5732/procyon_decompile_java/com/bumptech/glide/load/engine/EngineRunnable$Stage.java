// 
// Decompiled by Procyon v0.5.30
// 

package com.bumptech.glide.load.engine;

enum EngineRunnable$Stage
{
    CACHE("CACHE", 0), 
    SOURCE("SOURCE", n);
    
    static {
        final int n = 1;
        final EngineRunnable$Stage[] $values = { EngineRunnable$Stage.CACHE, null };
        $values[n] = EngineRunnable$Stage.SOURCE;
        $VALUES = $values;
    }
    
    private EngineRunnable$Stage(final String s, final int n) {
    }
}
