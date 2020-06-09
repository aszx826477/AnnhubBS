// 
// Decompiled by Procyon v0.5.30
// 

package com.bumptech.glide.load.model.stream;

import android.text.TextUtils;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.model.Headers;
import com.bumptech.glide.Glide;
import java.io.InputStream;
import com.bumptech.glide.load.model.GlideUrl;
import android.content.Context;
import com.bumptech.glide.load.model.ModelCache;
import com.bumptech.glide.load.model.ModelLoader;

public abstract class BaseGlideUrlLoader implements StreamModelLoader
{
    private final ModelLoader concreteLoader;
    private final ModelCache modelCache;
    
    public BaseGlideUrlLoader(final Context context) {
        this(context, null);
    }
    
    public BaseGlideUrlLoader(final Context context, final ModelCache modelCache) {
        this(Glide.buildModelLoader(GlideUrl.class, InputStream.class, context), modelCache);
    }
    
    public BaseGlideUrlLoader(final ModelLoader modelLoader) {
        this(modelLoader, null);
    }
    
    public BaseGlideUrlLoader(final ModelLoader concreteLoader, final ModelCache modelCache) {
        this.concreteLoader = concreteLoader;
        this.modelCache = modelCache;
    }
    
    protected Headers getHeaders(final Object o, final int n, final int n2) {
        return Headers.DEFAULT;
    }
    
    public DataFetcher getResourceFetcher(final Object o, final int n, final int n2) {
        Object o2 = null;
        final ModelCache modelCache = this.modelCache;
        if (modelCache != null) {
            o2 = modelCache.get(o, n, n2);
        }
        if (o2 == null) {
            final String url = this.getUrl(o, n, n2);
            if (TextUtils.isEmpty((CharSequence)url)) {
                return null;
            }
            o2 = new GlideUrl(url, this.getHeaders(o, n, n2));
            final ModelCache modelCache2 = this.modelCache;
            if (modelCache2 != null) {
                modelCache2.put(o, n, n2, o2);
            }
        }
        return this.concreteLoader.getResourceFetcher(o2, n, n2);
    }
    
    protected abstract String getUrl(final Object p0, final int p1, final int p2);
}
