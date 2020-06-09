// 
// Decompiled by Procyon v0.5.30
// 

package com.bumptech.glide;

import com.bumptech.glide.load.model.file_descriptor.FileDescriptorModelLoader;
import com.bumptech.glide.load.model.stream.StreamModelLoader;
import com.bumptech.glide.load.model.stream.StreamByteArrayLoader;
import java.util.Iterator;
import com.bumptech.glide.signature.MediaStoreSignature;
import java.net.URL;
import com.bumptech.glide.signature.ApplicationVersionSignature;
import com.bumptech.glide.load.model.stream.MediaStoreStreamLoader;
import android.net.Uri;
import java.io.File;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.signature.StringSignature;
import java.util.UUID;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.manager.ConnectivityMonitor;
import android.os.Handler;
import android.os.Looper;
import com.bumptech.glide.util.Util;
import com.bumptech.glide.manager.ConnectivityMonitor$ConnectivityListener;
import com.bumptech.glide.manager.ConnectivityMonitorFactory;
import com.bumptech.glide.manager.RequestManagerTreeNode;
import com.bumptech.glide.manager.RequestTracker;
import com.bumptech.glide.manager.Lifecycle;
import android.content.Context;
import com.bumptech.glide.manager.LifecycleListener;

public class RequestManager implements LifecycleListener
{
    private final Context context;
    private final Glide glide;
    private final Lifecycle lifecycle;
    private RequestManager$DefaultOptions options;
    private final RequestManager$OptionsApplier optionsApplier;
    private final RequestTracker requestTracker;
    private final RequestManagerTreeNode treeNode;
    
    public RequestManager(final Context context, final Lifecycle lifecycle, final RequestManagerTreeNode requestManagerTreeNode) {
        this(context, lifecycle, requestManagerTreeNode, new RequestTracker(), new ConnectivityMonitorFactory());
    }
    
    RequestManager(final Context context, final Lifecycle lifecycle, final RequestManagerTreeNode treeNode, final RequestTracker requestTracker, final ConnectivityMonitorFactory connectivityMonitorFactory) {
        this.context = context.getApplicationContext();
        this.lifecycle = lifecycle;
        this.treeNode = treeNode;
        this.requestTracker = requestTracker;
        this.glide = Glide.get(context);
        this.optionsApplier = new RequestManager$OptionsApplier(this);
        final ConnectivityMonitor build = connectivityMonitorFactory.build(context, new RequestManager$RequestManagerConnectivityListener(requestTracker));
        if (Util.isOnBackgroundThread()) {
            new Handler(Looper.getMainLooper()).post((Runnable)new RequestManager$1(this, lifecycle));
        }
        else {
            lifecycle.addListener(this);
        }
        lifecycle.addListener(build);
    }
    
    private static Class getSafeClass(final Object o) {
        Class<?> class1;
        if (o != null) {
            class1 = o.getClass();
        }
        else {
            class1 = null;
        }
        return class1;
    }
    
    private DrawableTypeRequest loadGeneric(final Class clazz) {
        final ModelLoader buildStreamModelLoader = Glide.buildStreamModelLoader(clazz, this.context);
        final ModelLoader buildFileDescriptorModelLoader = Glide.buildFileDescriptorModelLoader(clazz, this.context);
        if (clazz != null && buildStreamModelLoader == null && buildFileDescriptorModelLoader == null) {
            final StringBuilder sb = new StringBuilder();
            sb.append("Unknown type ");
            sb.append(clazz);
            sb.append(". You must provide a Model of a type for");
            sb.append(" which there is a registered ModelLoader, if you are using a custom model, you must first call");
            sb.append(" Glide#register with a ModelLoaderFactory for your custom model class");
            throw new IllegalArgumentException(sb.toString());
        }
        final RequestManager$OptionsApplier optionsApplier = this.optionsApplier;
        return (DrawableTypeRequest)optionsApplier.apply(new DrawableTypeRequest(clazz, buildStreamModelLoader, buildFileDescriptorModelLoader, this.context, this.glide, this.requestTracker, this.lifecycle, optionsApplier));
    }
    
    public DrawableTypeRequest from(final Class clazz) {
        return this.loadGeneric(clazz);
    }
    
    public DrawableTypeRequest fromBytes() {
        return (DrawableTypeRequest)this.loadGeneric(byte[].class).signature(new StringSignature(UUID.randomUUID().toString())).diskCacheStrategy(DiskCacheStrategy.NONE).skipMemoryCache(true);
    }
    
    public DrawableTypeRequest fromFile() {
        return this.loadGeneric(File.class);
    }
    
    public DrawableTypeRequest fromMediaStore() {
        final MediaStoreStreamLoader mediaStoreStreamLoader = new MediaStoreStreamLoader(this.context, Glide.buildStreamModelLoader(Uri.class, this.context));
        final ModelLoader buildFileDescriptorModelLoader = Glide.buildFileDescriptorModelLoader(Uri.class, this.context);
        final RequestManager$OptionsApplier optionsApplier = this.optionsApplier;
        return (DrawableTypeRequest)optionsApplier.apply(new DrawableTypeRequest(Uri.class, mediaStoreStreamLoader, buildFileDescriptorModelLoader, this.context, this.glide, this.requestTracker, this.lifecycle, optionsApplier));
    }
    
    public DrawableTypeRequest fromResource() {
        return (DrawableTypeRequest)this.loadGeneric(Integer.class).signature(ApplicationVersionSignature.obtain(this.context));
    }
    
    public DrawableTypeRequest fromString() {
        return this.loadGeneric(String.class);
    }
    
    public DrawableTypeRequest fromUri() {
        return this.loadGeneric(Uri.class);
    }
    
    public DrawableTypeRequest fromUrl() {
        return this.loadGeneric(URL.class);
    }
    
    public boolean isPaused() {
        Util.assertMainThread();
        return this.requestTracker.isPaused();
    }
    
    public DrawableTypeRequest load(final Uri uri) {
        return (DrawableTypeRequest)this.fromUri().load(uri);
    }
    
    public DrawableTypeRequest load(final File file) {
        return (DrawableTypeRequest)this.fromFile().load(file);
    }
    
    public DrawableTypeRequest load(final Integer n) {
        return (DrawableTypeRequest)this.fromResource().load(n);
    }
    
    public DrawableTypeRequest load(final Object o) {
        return (DrawableTypeRequest)this.loadGeneric(getSafeClass(o)).load(o);
    }
    
    public DrawableTypeRequest load(final String s) {
        return (DrawableTypeRequest)this.fromString().load(s);
    }
    
    public DrawableTypeRequest load(final URL url) {
        return (DrawableTypeRequest)this.fromUrl().load(url);
    }
    
    public DrawableTypeRequest load(final byte[] array) {
        return (DrawableTypeRequest)this.fromBytes().load(array);
    }
    
    public DrawableTypeRequest load(final byte[] array, final String s) {
        return (DrawableTypeRequest)this.load(array).signature(new StringSignature(s));
    }
    
    public DrawableTypeRequest loadFromMediaStore(final Uri uri) {
        return (DrawableTypeRequest)this.fromMediaStore().load(uri);
    }
    
    public DrawableTypeRequest loadFromMediaStore(final Uri uri, final String s, final long n, final int n2) {
        return (DrawableTypeRequest)this.loadFromMediaStore(uri).signature(new MediaStoreSignature(s, n, n2));
    }
    
    public void onDestroy() {
        this.requestTracker.clearRequests();
    }
    
    public void onLowMemory() {
        this.glide.clearMemory();
    }
    
    public void onStart() {
        this.resumeRequests();
    }
    
    public void onStop() {
        this.pauseRequests();
    }
    
    public void onTrimMemory(final int n) {
        this.glide.trimMemory(n);
    }
    
    public void pauseRequests() {
        Util.assertMainThread();
        this.requestTracker.pauseRequests();
    }
    
    public void pauseRequestsRecursive() {
        Util.assertMainThread();
        this.pauseRequests();
        final Iterator<RequestManager> iterator = this.treeNode.getDescendants().iterator();
        while (iterator.hasNext()) {
            iterator.next().pauseRequests();
        }
    }
    
    public void resumeRequests() {
        Util.assertMainThread();
        this.requestTracker.resumeRequests();
    }
    
    public void resumeRequestsRecursive() {
        Util.assertMainThread();
        this.resumeRequests();
        final Iterator<RequestManager> iterator = this.treeNode.getDescendants().iterator();
        while (iterator.hasNext()) {
            iterator.next().resumeRequests();
        }
    }
    
    public void setDefaultOptions(final RequestManager$DefaultOptions options) {
        this.options = options;
    }
    
    public RequestManager$GenericModelRequest using(final ModelLoader modelLoader, final Class clazz) {
        return new RequestManager$GenericModelRequest(this, modelLoader, clazz);
    }
    
    public RequestManager$ImageModelRequest using(final StreamByteArrayLoader streamByteArrayLoader) {
        return new RequestManager$ImageModelRequest(this, streamByteArrayLoader);
    }
    
    public RequestManager$ImageModelRequest using(final StreamModelLoader streamModelLoader) {
        return new RequestManager$ImageModelRequest(this, streamModelLoader);
    }
    
    public RequestManager$VideoModelRequest using(final FileDescriptorModelLoader fileDescriptorModelLoader) {
        return new RequestManager$VideoModelRequest(this, fileDescriptorModelLoader);
    }
}
