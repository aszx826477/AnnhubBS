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
import com.bumptech.glide.load.model.ModelLoader;

public final class RequestManager$ImageModelRequest
{
    private final ModelLoader loader;
    final /* synthetic */ RequestManager this$0;
    
    RequestManager$ImageModelRequest(final RequestManager this$0, final ModelLoader loader) {
        this.this$0 = this$0;
        this.loader = loader;
    }
    
    public DrawableTypeRequest from(final Class clazz) {
        return (DrawableTypeRequest)this.this$0.optionsApplier.apply(new DrawableTypeRequest(clazz, this.loader, null, this.this$0.context, this.this$0.glide, this.this$0.requestTracker, this.this$0.lifecycle, this.this$0.optionsApplier));
    }
    
    public DrawableTypeRequest load(final Object o) {
        return (DrawableTypeRequest)this.from(getSafeClass(o)).load(o);
    }
}
