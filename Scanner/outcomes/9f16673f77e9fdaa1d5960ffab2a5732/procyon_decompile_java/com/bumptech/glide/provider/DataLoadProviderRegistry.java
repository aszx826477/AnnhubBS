// 
// Decompiled by Procyon v0.5.30
// 

package com.bumptech.glide.provider;

import java.util.HashMap;
import java.util.Map;
import com.bumptech.glide.util.MultiClassKey;

public class DataLoadProviderRegistry
{
    private static final MultiClassKey GET_KEY;
    private final Map providers;
    
    static {
        GET_KEY = new MultiClassKey();
    }
    
    public DataLoadProviderRegistry() {
        this.providers = new HashMap();
    }
    
    public DataLoadProvider get(final Class clazz, final Class clazz2) {
        final MultiClassKey get_KEY = DataLoadProviderRegistry.GET_KEY;
        synchronized (get_KEY) {
            DataLoadProviderRegistry.GET_KEY.set(clazz, clazz2);
            DataLoadProvider value = this.providers.get(DataLoadProviderRegistry.GET_KEY);
            // monitorexit(get_KEY)
            if (value == null) {
                value = EmptyDataLoadProvider.get();
            }
            return value;
        }
    }
    
    public void register(final Class clazz, final Class clazz2, final DataLoadProvider dataLoadProvider) {
        this.providers.put(new MultiClassKey(clazz, clazz2), dataLoadProvider);
    }
}
