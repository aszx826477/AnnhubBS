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
import java.util.ArrayList;
import android.view.View;
import android.graphics.Point;
import java.util.List;
import android.util.Log;
import java.lang.ref.WeakReference;
import android.view.ViewTreeObserver$OnPreDrawListener;

class ViewTarget$SizeDeterminer$SizeDeterminerLayoutListener implements ViewTreeObserver$OnPreDrawListener
{
    private final WeakReference sizeDeterminerRef;
    
    public ViewTarget$SizeDeterminer$SizeDeterminerLayoutListener(final ViewTarget$SizeDeterminer viewTarget$SizeDeterminer) {
        this.sizeDeterminerRef = new WeakReference((T)viewTarget$SizeDeterminer);
    }
    
    public boolean onPreDraw() {
        if (Log.isLoggable("ViewTarget", 2)) {
            final String s = "ViewTarget";
            final StringBuilder sb = new StringBuilder();
            sb.append("OnGlobalLayoutListener called listener=");
            sb.append(this);
            Log.v(s, sb.toString());
        }
        final ViewTarget$SizeDeterminer viewTarget$SizeDeterminer = (ViewTarget$SizeDeterminer)this.sizeDeterminerRef.get();
        if (viewTarget$SizeDeterminer != null) {
            viewTarget$SizeDeterminer.checkCurrentDimens();
        }
        return true;
    }
}
