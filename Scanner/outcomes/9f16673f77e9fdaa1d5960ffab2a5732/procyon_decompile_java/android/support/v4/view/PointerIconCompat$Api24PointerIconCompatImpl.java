// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.view;

import android.content.res.Resources;
import android.content.Context;
import android.graphics.Bitmap;

class PointerIconCompat$Api24PointerIconCompatImpl extends PointerIconCompat$BasePointerIconCompatImpl
{
    public Object create(final Bitmap bitmap, final float n, final float n2) {
        return PointerIconCompatApi24.create(bitmap, n, n2);
    }
    
    public Object getSystemIcon(final Context context, final int n) {
        return PointerIconCompatApi24.getSystemIcon(context, n);
    }
    
    public Object load(final Resources resources, final int n) {
        return PointerIconCompatApi24.load(resources, n);
    }
}
