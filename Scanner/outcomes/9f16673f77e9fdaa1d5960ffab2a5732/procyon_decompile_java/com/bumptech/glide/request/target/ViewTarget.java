// 
// Decompiled by Procyon v0.5.30
// 

package com.bumptech.glide.request.target;

import com.bumptech.glide.request.Request;
import android.view.View;

public abstract class ViewTarget extends BaseTarget
{
    private static final String TAG = "ViewTarget";
    private static boolean isTagUsedAtLeastOnce;
    private static Integer tagId;
    private final ViewTarget$SizeDeterminer sizeDeterminer;
    protected final View view;
    
    static {
        ViewTarget.isTagUsedAtLeastOnce = false;
        ViewTarget.tagId = null;
    }
    
    public ViewTarget(final View view) {
        if (view != null) {
            this.view = view;
            this.sizeDeterminer = new ViewTarget$SizeDeterminer(view);
            return;
        }
        throw new NullPointerException("View must not be null!");
    }
    
    private Object getTag() {
        final Integer tagId = ViewTarget.tagId;
        if (tagId == null) {
            return this.view.getTag();
        }
        return this.view.getTag((int)tagId);
    }
    
    private void setTag(final Object tag) {
        final Integer tagId = ViewTarget.tagId;
        if (tagId == null) {
            ViewTarget.isTagUsedAtLeastOnce = true;
            this.view.setTag(tag);
        }
        else {
            this.view.setTag((int)tagId, tag);
        }
    }
    
    public static void setTagId(final int n) {
        if (ViewTarget.tagId == null && !ViewTarget.isTagUsedAtLeastOnce) {
            ViewTarget.tagId = n;
            return;
        }
        throw new IllegalArgumentException("You cannot set the tag id more than once or change the tag id after the first request has been made");
    }
    
    public Request getRequest() {
        final Object tag = this.getTag();
        Request request = null;
        if (tag != null) {
            if (!(tag instanceof Request)) {
                throw new IllegalArgumentException("You must not call setTag() on a view Glide is targeting");
            }
            request = (Request)tag;
        }
        return request;
    }
    
    public void getSize(final SizeReadyCallback sizeReadyCallback) {
        this.sizeDeterminer.getSize(sizeReadyCallback);
    }
    
    public View getView() {
        return this.view;
    }
    
    public void setRequest(final Request tag) {
        this.setTag(tag);
    }
    
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Target for: ");
        sb.append(this.view);
        return sb.toString();
    }
}
