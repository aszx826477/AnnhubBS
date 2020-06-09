// 
// Decompiled by Procyon v0.5.30
// 

package com.bumptech.glide.load.model;

import java.util.Map;

public interface Headers
{
    public static final Headers DEFAULT = new LazyHeaders$Builder().build();
    public static final Headers NONE = new Headers$1();
    
    Map getHeaders();
}
