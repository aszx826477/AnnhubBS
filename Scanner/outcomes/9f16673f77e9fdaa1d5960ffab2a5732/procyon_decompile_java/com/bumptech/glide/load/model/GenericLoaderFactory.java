// 
// Decompiled by Procyon v0.5.30
// 

package com.bumptech.glide.load.model;

import java.util.Iterator;
import java.util.HashMap;
import android.content.Context;
import java.util.Map;

public class GenericLoaderFactory
{
    private static final ModelLoader NULL_MODEL_LOADER;
    private final Map cachedModelLoaders;
    private final Context context;
    private final Map modelClassToResourceFactories;
    
    static {
        NULL_MODEL_LOADER = new GenericLoaderFactory$1();
    }
    
    public GenericLoaderFactory(final Context context) {
        this.modelClassToResourceFactories = new HashMap();
        this.cachedModelLoaders = new HashMap();
        this.context = context.getApplicationContext();
    }
    
    private void cacheModelLoader(final Class clazz, final Class clazz2, final ModelLoader modelLoader) {
        Map<?, ?> map = this.cachedModelLoaders.get(clazz);
        if (map == null) {
            map = new HashMap<Object, Object>();
            this.cachedModelLoaders.put(clazz, map);
        }
        map.put(clazz2, modelLoader);
    }
    
    private void cacheNullLoader(final Class clazz, final Class clazz2) {
        this.cacheModelLoader(clazz, clazz2, GenericLoaderFactory.NULL_MODEL_LOADER);
    }
    
    private ModelLoader getCachedLoader(final Class clazz, final Class clazz2) {
        final Map<Object, Object> map = this.cachedModelLoaders.get(clazz);
        ModelLoader modelLoader = null;
        if (map != null) {
            modelLoader = map.get(clazz2);
        }
        return modelLoader;
    }
    
    private ModelLoaderFactory getFactory(final Class clazz, final Class clazz2) {
        final Map<Object, Object> map = this.modelClassToResourceFactories.get(clazz);
        ModelLoaderFactory modelLoaderFactory = null;
        if (map != null) {
            modelLoaderFactory = map.get(clazz2);
        }
        if (modelLoaderFactory == null) {
            for (final Class clazz3 : this.modelClassToResourceFactories.keySet()) {
                if (clazz3.isAssignableFrom(clazz)) {
                    final Map<Object, Object> map2 = this.modelClassToResourceFactories.get(clazz3);
                    if (map2 == null) {
                        continue;
                    }
                    modelLoaderFactory = (ModelLoaderFactory)map2.get(clazz2);
                    if (modelLoaderFactory != null) {
                        break;
                    }
                    continue;
                }
            }
        }
        return modelLoaderFactory;
    }
    
    public ModelLoader buildModelLoader(final Class clazz, final Class clazz2) {
        synchronized (this) {
            ModelLoader modelLoader = this.getCachedLoader(clazz, clazz2);
            if (modelLoader == null) {
                final ModelLoaderFactory factory = this.getFactory(clazz, clazz2);
                if (factory != null) {
                    this.cacheModelLoader(clazz, clazz2, modelLoader = factory.build(this.context, this));
                }
                else {
                    this.cacheNullLoader(clazz, clazz2);
                }
                return modelLoader;
            }
            if (GenericLoaderFactory.NULL_MODEL_LOADER.equals(modelLoader)) {
                return null;
            }
            return modelLoader;
        }
    }
    
    public ModelLoader buildModelLoader(final Class clazz, final Class clazz2, final Context context) {
        synchronized (this) {
            return this.buildModelLoader(clazz, clazz2);
        }
    }
    
    public ModelLoaderFactory register(final Class clazz, final Class clazz2, final ModelLoaderFactory modelLoaderFactory) {
        synchronized (this) {
            this.cachedModelLoaders.clear();
            Map<?, ?> map = this.modelClassToResourceFactories.get(clazz);
            if (map == null) {
                map = new HashMap<Object, Object>();
                this.modelClassToResourceFactories.put(clazz, map);
            }
            ModelLoaderFactory modelLoaderFactory2 = map.put(clazz2, modelLoaderFactory);
            if (modelLoaderFactory2 != null) {
                final Iterator<Map> iterator = this.modelClassToResourceFactories.values().iterator();
                while (iterator.hasNext()) {
                    if (iterator.next().containsValue(modelLoaderFactory2)) {
                        modelLoaderFactory2 = null;
                        break;
                    }
                }
            }
            return modelLoaderFactory2;
        }
    }
    
    public ModelLoaderFactory unregister(final Class clazz, final Class clazz2) {
        synchronized (this) {
            this.cachedModelLoaders.clear();
            ModelLoaderFactory modelLoaderFactory = null;
            final Map<Object, Object> map = this.modelClassToResourceFactories.get(clazz);
            if (map != null) {
                modelLoaderFactory = (ModelLoaderFactory)map.remove(clazz2);
            }
            return modelLoaderFactory;
        }
    }
}
