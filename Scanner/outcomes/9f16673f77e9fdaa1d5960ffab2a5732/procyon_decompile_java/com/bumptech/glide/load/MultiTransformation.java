// 
// Decompiled by Procyon v0.5.30
// 

package com.bumptech.glide.load;

import com.bumptech.glide.load.engine.Resource;
import java.util.Iterator;
import java.util.Arrays;
import java.util.Collection;

public class MultiTransformation implements Transformation
{
    private String id;
    private final Collection transformations;
    
    public MultiTransformation(final Collection transformations) {
        if (transformations.size() >= 1) {
            this.transformations = transformations;
            return;
        }
        throw new IllegalArgumentException("MultiTransformation must contain at least one Transformation");
    }
    
    public MultiTransformation(final Transformation... array) {
        if (array.length >= 1) {
            this.transformations = Arrays.asList(array);
            return;
        }
        throw new IllegalArgumentException("MultiTransformation must contain at least one Transformation");
    }
    
    public String getId() {
        if (this.id == null) {
            final StringBuilder sb = new StringBuilder();
            final Iterator<Transformation> iterator = this.transformations.iterator();
            while (iterator.hasNext()) {
                sb.append(iterator.next().getId());
            }
            this.id = sb.toString();
        }
        return this.id;
    }
    
    public Resource transform(final Resource resource, final int n, final int n2) {
        Resource resource2 = resource;
        final Iterator<Transformation> iterator = this.transformations.iterator();
        while (iterator.hasNext()) {
            final Resource transform = iterator.next().transform(resource2, n, n2);
            if (resource2 != null && !resource2.equals(resource) && !resource2.equals(transform)) {
                resource2.recycle();
            }
            resource2 = transform;
        }
        return resource2;
    }
}
