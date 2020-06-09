// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v7.widget;

import android.graphics.drawable.Drawable;
import android.os.Build$VERSION;
import android.support.v7.app.AppCompatDelegate;
import android.content.Context;
import java.lang.ref.WeakReference;
import android.content.res.Resources;

public class VectorEnabledTintResources extends Resources
{
    public static final int MAX_SDK_WHERE_REQUIRED = 20;
    private final WeakReference mContextRef;
    
    public VectorEnabledTintResources(final Context context, final Resources resources) {
        super(resources.getAssets(), resources.getDisplayMetrics(), resources.getConfiguration());
        this.mContextRef = new WeakReference((T)context);
    }
    
    public static boolean shouldBeUsed() {
        return AppCompatDelegate.isCompatVectorFromResourcesEnabled() && Build$VERSION.SDK_INT <= 20;
    }
    
    public Drawable getDrawable(final int n) {
        final Context context = (Context)this.mContextRef.get();
        if (context != null) {
            return AppCompatDrawableManager.get().onDrawableLoadedFromResources(context, this, n);
        }
        return super.getDrawable(n);
    }
    
    final Drawable superGetDrawable(final int n) {
        return super.getDrawable(n);
    }
}
