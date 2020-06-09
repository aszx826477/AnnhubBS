// 
// Decompiled by Procyon v0.5.30
// 

package com.bumptech.glide.request.target;

import java.util.Iterator;
import android.view.ViewGroup$LayoutParams;
import android.view.Display;
import android.os.Build$VERSION;
import android.view.WindowManager;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver$OnPreDrawListener;
import java.util.ArrayList;
import android.view.View;
import android.graphics.Point;
import java.util.List;

class ViewTarget$SizeDeterminer
{
    private static final int PENDING_SIZE;
    private final List cbs;
    private Point displayDimens;
    private ViewTarget$SizeDeterminer$SizeDeterminerLayoutListener layoutListener;
    private final View view;
    
    public ViewTarget$SizeDeterminer(final View view) {
        this.cbs = new ArrayList();
        this.view = view;
    }
    
    private void checkCurrentDimens() {
        if (this.cbs.isEmpty()) {
            return;
        }
        final int viewWidthOrParam = this.getViewWidthOrParam();
        final int viewHeightOrParam = this.getViewHeightOrParam();
        if (this.isSizeValid(viewWidthOrParam) && this.isSizeValid(viewHeightOrParam)) {
            this.notifyCbs(viewWidthOrParam, viewHeightOrParam);
            final ViewTreeObserver viewTreeObserver = this.view.getViewTreeObserver();
            if (viewTreeObserver.isAlive()) {
                viewTreeObserver.removeOnPreDrawListener((ViewTreeObserver$OnPreDrawListener)this.layoutListener);
            }
            this.layoutListener = null;
        }
    }
    
    private Point getDisplayDimens() {
        final Point displayDimens = this.displayDimens;
        if (displayDimens != null) {
            return displayDimens;
        }
        final Display defaultDisplay = ((WindowManager)this.view.getContext().getSystemService("window")).getDefaultDisplay();
        if (Build$VERSION.SDK_INT >= 13) {
            defaultDisplay.getSize(this.displayDimens = new Point());
        }
        else {
            this.displayDimens = new Point(defaultDisplay.getWidth(), defaultDisplay.getHeight());
        }
        return this.displayDimens;
    }
    
    private int getSizeForParam(final int n, final boolean b) {
        if (n == -2) {
            final Point displayDimens = this.getDisplayDimens();
            int n2;
            if (b) {
                n2 = displayDimens.y;
            }
            else {
                n2 = displayDimens.x;
            }
            return n2;
        }
        return n;
    }
    
    private int getViewHeightOrParam() {
        final ViewGroup$LayoutParams layoutParams = this.view.getLayoutParams();
        if (this.isSizeValid(this.view.getHeight())) {
            return this.view.getHeight();
        }
        if (layoutParams != null) {
            return this.getSizeForParam(layoutParams.height, true);
        }
        return 0;
    }
    
    private int getViewWidthOrParam() {
        final ViewGroup$LayoutParams layoutParams = this.view.getLayoutParams();
        if (this.isSizeValid(this.view.getWidth())) {
            return this.view.getWidth();
        }
        if (layoutParams != null) {
            return this.getSizeForParam(layoutParams.width, false);
        }
        return 0;
    }
    
    private boolean isSizeValid(final int n) {
        return n > 0 || n == -2;
    }
    
    private void notifyCbs(final int n, final int n2) {
        final Iterator<SizeReadyCallback> iterator = this.cbs.iterator();
        while (iterator.hasNext()) {
            iterator.next().onSizeReady(n, n2);
        }
        this.cbs.clear();
    }
    
    public void getSize(final SizeReadyCallback sizeReadyCallback) {
        final int viewWidthOrParam = this.getViewWidthOrParam();
        final int viewHeightOrParam = this.getViewHeightOrParam();
        if (this.isSizeValid(viewWidthOrParam) && this.isSizeValid(viewHeightOrParam)) {
            sizeReadyCallback.onSizeReady(viewWidthOrParam, viewHeightOrParam);
        }
        else {
            if (!this.cbs.contains(sizeReadyCallback)) {
                this.cbs.add(sizeReadyCallback);
            }
            if (this.layoutListener == null) {
                this.view.getViewTreeObserver().addOnPreDrawListener((ViewTreeObserver$OnPreDrawListener)(this.layoutListener = new ViewTarget$SizeDeterminer$SizeDeterminerLayoutListener(this)));
            }
        }
    }
}
