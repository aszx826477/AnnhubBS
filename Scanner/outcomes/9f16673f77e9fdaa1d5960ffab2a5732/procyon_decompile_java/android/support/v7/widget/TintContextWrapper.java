// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v7.widget;

import android.content.res.AssetManager;
import java.lang.ref.WeakReference;
import android.os.Build$VERSION;
import android.content.Context;
import android.content.res.Resources$Theme;
import android.content.res.Resources;
import java.util.ArrayList;
import android.content.ContextWrapper;

public class TintContextWrapper extends ContextWrapper
{
    private static final Object CACHE_LOCK;
    private static ArrayList sCache;
    private final Resources mResources;
    private final Resources$Theme mTheme;
    
    static {
        CACHE_LOCK = new Object();
    }
    
    private TintContextWrapper(final Context context) {
        super(context);
        if (VectorEnabledTintResources.shouldBeUsed()) {
            this.mResources = new VectorEnabledTintResources((Context)this, context.getResources());
            (this.mTheme = this.mResources.newTheme()).setTo(context.getTheme());
        }
        else {
            this.mResources = new TintResources((Context)this, context.getResources());
            this.mTheme = null;
        }
    }
    
    private static boolean shouldWrap(final Context context) {
        final boolean b = context instanceof TintContextWrapper;
        boolean b2 = false;
        if (!b) {
            if (!(context.getResources() instanceof TintResources)) {
                if (!(context.getResources() instanceof VectorEnabledTintResources)) {
                    if (Build$VERSION.SDK_INT < 21 || VectorEnabledTintResources.shouldBeUsed()) {
                        b2 = true;
                    }
                    return b2;
                }
            }
        }
        return false;
    }
    
    public static Context wrap(final Context context) {
        if (shouldWrap(context)) {
            synchronized (TintContextWrapper.CACHE_LOCK) {
                if (TintContextWrapper.sCache == null) {
                    TintContextWrapper.sCache = new ArrayList();
                }
                else {
                    for (int i = TintContextWrapper.sCache.size() - 1; i >= 0; --i) {
                        final WeakReference<Object> weakReference = TintContextWrapper.sCache.get(i);
                        if (weakReference == null || weakReference.get() == null) {
                            TintContextWrapper.sCache.remove(i);
                        }
                    }
                    for (int j = TintContextWrapper.sCache.size() - 1; j >= 0; --j) {
                        final WeakReference<Object> weakReference2 = TintContextWrapper.sCache.get(j);
                        TintContextWrapper tintContextWrapper;
                        if (weakReference2 != null) {
                            tintContextWrapper = weakReference2.get();
                        }
                        else {
                            tintContextWrapper = null;
                        }
                        if (tintContextWrapper != null && tintContextWrapper.getBaseContext() == context) {
                            return (Context)tintContextWrapper;
                        }
                    }
                }
                final TintContextWrapper tintContextWrapper2 = new TintContextWrapper(context);
                TintContextWrapper.sCache.add(new WeakReference<Object>(tintContextWrapper2));
                return (Context)tintContextWrapper2;
            }
        }
        return context;
    }
    
    public AssetManager getAssets() {
        return this.mResources.getAssets();
    }
    
    public Resources getResources() {
        return this.mResources;
    }
    
    public Resources$Theme getTheme() {
        Resources$Theme resources$Theme = this.mTheme;
        if (resources$Theme == null) {
            resources$Theme = super.getTheme();
        }
        return resources$Theme;
    }
    
    public void setTheme(final int theme) {
        final Resources$Theme mTheme = this.mTheme;
        if (mTheme == null) {
            super.setTheme(theme);
        }
        else {
            mTheme.applyStyle(theme, true);
        }
    }
}
