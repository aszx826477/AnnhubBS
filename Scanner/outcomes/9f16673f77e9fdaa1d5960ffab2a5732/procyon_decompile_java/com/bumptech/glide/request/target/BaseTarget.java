// 
// Decompiled by Procyon v0.5.30
// 

package com.bumptech.glide.request.target;

import android.graphics.drawable.Drawable;
import com.bumptech.glide.request.Request;

public abstract class BaseTarget implements Target
{
    private Request request;
    
    public Request getRequest() {
        return this.request;
    }
    
    public void onDestroy() {
    }
    
    public void onLoadCleared(final Drawable drawable) {
    }
    
    public void onLoadFailed(final Exception ex, final Drawable drawable) {
    }
    
    public void onLoadStarted(final Drawable drawable) {
    }
    
    public void onStart() {
    }
    
    public void onStop() {
    }
    
    public void setRequest(final Request request) {
        this.request = request;
    }
}
