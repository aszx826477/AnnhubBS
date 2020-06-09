// 
// Decompiled by Procyon v0.5.30
// 

package com.bumptech.glide.load.model;

final class LazyHeaders$StringHeaderFactory implements LazyHeaderFactory
{
    private final String value;
    
    LazyHeaders$StringHeaderFactory(final String value) {
        this.value = value;
    }
    
    public String buildHeader() {
        return this.value;
    }
    
    public boolean equals(final Object o) {
        return o instanceof LazyHeaders$StringHeaderFactory && this.value.equals(((LazyHeaders$StringHeaderFactory)o).value);
    }
    
    public int hashCode() {
        return this.value.hashCode();
    }
    
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("StringHeaderFactory{value='");
        sb.append(this.value);
        sb.append('\'');
        sb.append('}');
        return sb.toString();
    }
}
