// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v7.widget;

import android.graphics.drawable.Drawable;
import android.content.res.Resources;
import android.content.Context;
import java.lang.ref.WeakReference;

class TintResources extends ResourcesWrapper
{
    private final WeakReference mContextRef;
    
    public TintResources(final Context context, final Resources resources) {
        super(resources);
        this.mContextRef = new WeakReference((T)context);
    }
    
    public Drawable getDrawable(final int n) {
        final Drawable drawable = super.getDrawable(n);
        final Context context = (Context)this.mContextRef.get();
        if (drawable != null && context != null) {
            AppCompatDrawableManager.get();
            AppCompatDrawableManager.tintDrawableUsingColorFilter(context, n, drawable);
        }
        return drawable;
    }
}
