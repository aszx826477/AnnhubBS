// 
// Decompiled by Procyon v0.5.30
// 

package com.bumptech.glide;

import com.bumptech.glide.load.model.ModelLoader;

public final class RequestManager$GenericModelRequest
{
    private final Class dataClass;
    private final ModelLoader modelLoader;
    final /* synthetic */ RequestManager this$0;
    
    RequestManager$GenericModelRequest(final RequestManager this$0, final ModelLoader modelLoader, final Class dataClass) {
        this.this$0 = this$0;
        this.modelLoader = modelLoader;
        this.dataClass = dataClass;
    }
    
    public RequestManager$GenericModelRequest$GenericTypeRequest from(final Class clazz) {
        return new RequestManager$GenericModelRequest$GenericTypeRequest(this, clazz);
    }
    
    public RequestManager$GenericModelRequest$GenericTypeRequest load(final Object o) {
        return new RequestManager$GenericModelRequest$GenericTypeRequest(this, o);
    }
}
