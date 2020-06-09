// 
// Decompiled by Procyon v0.5.30
// 

package com.bumptech.glide.load.resource.transcode;

import java.util.HashMap;
import java.util.Map;
import com.bumptech.glide.util.MultiClassKey;

public class TranscoderRegistry
{
    private static final MultiClassKey GET_KEY;
    private final Map factories;
    
    static {
        GET_KEY = new MultiClassKey();
    }
    
    public TranscoderRegistry() {
        this.factories = new HashMap();
    }
    
    public ResourceTranscoder get(final Class clazz, final Class clazz2) {
        if (clazz.equals(clazz2)) {
            return UnitTranscoder.get();
        }
        Object get_KEY = TranscoderRegistry.GET_KEY;
        synchronized (get_KEY) {
            TranscoderRegistry.GET_KEY.set(clazz, clazz2);
            final ResourceTranscoder resourceTranscoder = this.factories.get(TranscoderRegistry.GET_KEY);
            // monitorexit(get_KEY)
            if (resourceTranscoder != null) {
                return resourceTranscoder;
            }
            final StringBuilder sb = new StringBuilder();
            sb.append("No transcoder registered for ");
            sb.append(clazz);
            sb.append(" and ");
            sb.append(clazz2);
            get_KEY = new IllegalArgumentException(sb.toString());
            throw get_KEY;
        }
    }
    
    public void register(final Class clazz, final Class clazz2, final ResourceTranscoder resourceTranscoder) {
        this.factories.put(new MultiClassKey(clazz, clazz2), resourceTranscoder);
    }
}
