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

public final class RequestManager$GenericModelRequest$GenericTypeRequest
{
    private final Object model;
    private final Class modelClass;
    private final boolean providedModel;
    final /* synthetic */ RequestManager$GenericModelRequest this$1;
    
    RequestManager$GenericModelRequest$GenericTypeRequest(final RequestManager$GenericModelRequest this$1, final Class modelClass) {
        this.this$1 = this$1;
        this.providedModel = false;
        this.model = null;
        this.modelClass = modelClass;
    }
    
    RequestManager$GenericModelRequest$GenericTypeRequest(final RequestManager$GenericModelRequest this$1, final Object model) {
        this.this$1 = this$1;
        this.providedModel = true;
        this.model = model;
        this.modelClass = getSafeClass(model);
    }
    
    public GenericTranscodeRequest as(final Class clazz) {
        final GenericTranscodeRequest genericTranscodeRequest = (GenericTranscodeRequest)this.this$1.this$0.optionsApplier.apply(new GenericTranscodeRequest(this.this$1.this$0.context, this.this$1.this$0.glide, this.modelClass, this.this$1.modelLoader, this.this$1.dataClass, clazz, this.this$1.this$0.requestTracker, this.this$1.this$0.lifecycle, this.this$1.this$0.optionsApplier));
        if (this.providedModel) {
            genericTranscodeRequest.load(this.model);
        }
        return genericTranscodeRequest;
    }
}
