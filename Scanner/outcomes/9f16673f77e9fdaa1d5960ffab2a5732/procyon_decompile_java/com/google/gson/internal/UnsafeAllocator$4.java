// 
// Decompiled by Procyon v0.5.30
// 

package com.google.gson.internal;

final class UnsafeAllocator$4 extends UnsafeAllocator
{
    public Object newInstance(final Class clazz) {
        final StringBuilder sb = new StringBuilder();
        sb.append("Cannot allocate ");
        sb.append(clazz);
        throw new UnsupportedOperationException(sb.toString());
    }
}
