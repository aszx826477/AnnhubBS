// 
// Decompiled by Procyon v0.5.30
// 

package com.bumptech.glide.load.model;

import java.util.Iterator;
import java.util.List;
import java.util.HashMap;
import java.util.Collections;
import java.util.Map;

public final class LazyHeaders implements Headers
{
    private volatile Map combinedHeaders;
    private final Map headers;
    
    LazyHeaders(final Map map) {
        this.headers = Collections.unmodifiableMap((Map<?, ?>)map);
    }
    
    private Map generateHeaders() {
        final HashMap<Object, String> hashMap = new HashMap<Object, String>();
        for (final Map.Entry<K, List> entry : this.headers.entrySet()) {
            final StringBuilder sb = new StringBuilder();
            final List<LazyHeaderFactory> list = entry.getValue();
            for (int i = 0; i < list.size(); ++i) {
                sb.append(list.get(i).buildHeader());
                if (i != list.size() - 1) {
                    sb.append(',');
                }
            }
            hashMap.put(entry.getKey(), sb.toString());
        }
        return hashMap;
    }
    
    public boolean equals(final Object o) {
        return o instanceof LazyHeaders && this.headers.equals(((LazyHeaders)o).headers);
    }
    
    public Map getHeaders() {
        if (this.combinedHeaders == null) {
            synchronized (this) {
                if (this.combinedHeaders == null) {
                    this.combinedHeaders = Collections.unmodifiableMap((Map<?, ?>)this.generateHeaders());
                }
            }
        }
        return this.combinedHeaders;
    }
    
    public int hashCode() {
        return this.headers.hashCode();
    }
    
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("LazyHeaders{headers=");
        sb.append(this.headers);
        sb.append('}');
        return sb.toString();
    }
}
