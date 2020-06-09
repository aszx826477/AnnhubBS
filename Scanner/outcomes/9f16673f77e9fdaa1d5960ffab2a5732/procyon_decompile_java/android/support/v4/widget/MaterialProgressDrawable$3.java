// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.widget;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable$Callback;

class MaterialProgressDrawable$3 implements Drawable$Callback
{
    final /* synthetic */ MaterialProgressDrawable this$0;
    
    MaterialProgressDrawable$3(final MaterialProgressDrawable this$0) {
        this.this$0 = this$0;
    }
    
    public void invalidateDrawable(final Drawable drawable) {
        this.this$0.invalidateSelf();
    }
    
    public void scheduleDrawable(final Drawable drawable, final Runnable runnable, final long n) {
        this.this$0.scheduleSelf(runnable, n);
    }
    
    public void unscheduleDrawable(final Drawable drawable, final Runnable runnable) {
        this.this$0.unscheduleSelf(runnable);
    }
}
