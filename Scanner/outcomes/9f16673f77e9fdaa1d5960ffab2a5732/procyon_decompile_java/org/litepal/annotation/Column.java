// 
// Decompiled by Procyon v0.5.30
// 

package org.litepal.annotation;

import java.lang.annotation.Annotation;

public @interface Column {
    String defaultValue();
    
    boolean ignore();
    
    boolean nullable();
    
    boolean unique();
}
