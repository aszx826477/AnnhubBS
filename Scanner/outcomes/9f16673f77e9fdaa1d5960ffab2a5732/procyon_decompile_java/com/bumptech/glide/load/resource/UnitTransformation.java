// 
// Decompiled by Procyon v0.5.30
// 

package com.bumptech.glide.load.resource;

import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.Transformation;

public class UnitTransformation implements Transformation
{
    private static final Transformation TRANSFORMATION;
    
    static {
        TRANSFORMATION = new UnitTransformation();
    }
    
    public static UnitTransformation get() {
        return (UnitTransformation)UnitTransformation.TRANSFORMATION;
    }
    
    public String getId() {
        return "";
    }
    
    public Resource transform(final Resource resource, final int n, final int n2) {
        return resource;
    }
}
