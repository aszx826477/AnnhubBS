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

class RequestManager$OptionsApplier
{
    final /* synthetic */ RequestManager this$0;
    
    RequestManager$OptionsApplier(final RequestManager this$0) {
        this.this$0 = this$0;
    }
    
    public GenericRequestBuilder apply(final GenericRequestBuilder genericRequestBuilder) {
        if (this.this$0.options != null) {
            this.this$0.options.apply(genericRequestBuilder);
        }
        return genericRequestBuilder;
    }
}
