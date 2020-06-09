// 
// Decompiled by Procyon v0.5.30
// 

package com.bumptech.glide.load.model;

import java.util.Iterator;
import java.util.Collection;
import java.util.ArrayList;
import java.util.Collections;
import android.text.TextUtils;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

public final class LazyHeaders$Builder
{
    private static final String DEFAULT_ENCODING = "identity";
    private static final Map DEFAULT_HEADERS;
    private static final String DEFAULT_USER_AGENT;
    private static final String ENCODING_HEADER = "Accept-Encoding";
    private static final String USER_AGENT_HEADER = "User-Agent";
    private boolean copyOnModify;
    private Map headers;
    private boolean isEncodingDefault;
    private boolean isUserAgentDefault;
    
    static {
        DEFAULT_USER_AGENT = System.getProperty("http.agent");
        final HashMap<String, List<LazyHeaders$StringHeaderFactory>> hashMap = new HashMap<String, List<LazyHeaders$StringHeaderFactory>>(2);
        if (!TextUtils.isEmpty((CharSequence)LazyHeaders$Builder.DEFAULT_USER_AGENT)) {
            hashMap.put("User-Agent", Collections.singletonList(new LazyHeaders$StringHeaderFactory(LazyHeaders$Builder.DEFAULT_USER_AGENT)));
        }
        hashMap.put("Accept-Encoding", Collections.singletonList(new LazyHeaders$StringHeaderFactory("identity")));
        DEFAULT_HEADERS = Collections.unmodifiableMap((Map<?, ?>)hashMap);
    }
    
    public LazyHeaders$Builder() {
        final boolean isUserAgentDefault = true;
        this.copyOnModify = isUserAgentDefault;
        this.headers = LazyHeaders$Builder.DEFAULT_HEADERS;
        this.isEncodingDefault = isUserAgentDefault;
        this.isUserAgentDefault = isUserAgentDefault;
    }
    
    private Map copyHeaders() {
        final HashMap<Object, ArrayList> hashMap = new HashMap<Object, ArrayList>(this.headers.size());
        for (final Map.Entry<Object, V> entry : this.headers.entrySet()) {
            hashMap.put(entry.getKey(), new ArrayList((Collection<?>)entry.getValue()));
        }
        return hashMap;
    }
    
    private void copyIfNecessary() {
        if (this.copyOnModify) {
            this.copyOnModify = false;
            this.headers = this.copyHeaders();
        }
    }
    
    private List getFactories(final String s) {
        List<?> list = this.headers.get(s);
        if (list == null) {
            list = new ArrayList<Object>();
            this.headers.put(s, list);
        }
        return list;
    }
    
    public LazyHeaders$Builder addHeader(final String s, final LazyHeaderFactory lazyHeaderFactory) {
        if ((!this.isEncodingDefault || !"Accept-Encoding".equalsIgnoreCase(s)) && (!this.isUserAgentDefault || !"User-Agent".equalsIgnoreCase(s))) {
            this.copyIfNecessary();
            this.getFactories(s).add(lazyHeaderFactory);
            return this;
        }
        return this.setHeader(s, lazyHeaderFactory);
    }
    
    public LazyHeaders$Builder addHeader(final String s, final String s2) {
        return this.addHeader(s, new LazyHeaders$StringHeaderFactory(s2));
    }
    
    public LazyHeaders build() {
        this.copyOnModify = true;
        return new LazyHeaders(this.headers);
    }
    
    public LazyHeaders$Builder setHeader(final String s, final LazyHeaderFactory lazyHeaderFactory) {
        this.copyIfNecessary();
        if (lazyHeaderFactory == null) {
            this.headers.remove(s);
        }
        else {
            final List factories = this.getFactories(s);
            factories.clear();
            factories.add(lazyHeaderFactory);
        }
        if (this.isEncodingDefault && "Accept-Encoding".equalsIgnoreCase(s)) {
            this.isEncodingDefault = false;
        }
        if (this.isUserAgentDefault && "User-Agent".equalsIgnoreCase(s)) {
            this.isUserAgentDefault = false;
        }
        return this;
    }
    
    public LazyHeaders$Builder setHeader(final String s, final String s2) {
        LazyHeaderFactory lazyHeaderFactory;
        if (s2 == null) {
            lazyHeaderFactory = null;
        }
        else {
            lazyHeaderFactory = new LazyHeaders$StringHeaderFactory(s2);
        }
        return this.setHeader(s, lazyHeaderFactory);
    }
}
