// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.graphics.drawable;

import android.util.Log;
import android.graphics.BitmapFactory;
import java.io.InputStream;
import android.os.Build$VERSION;
import android.graphics.Bitmap;
import android.content.res.Resources;

public final class RoundedBitmapDrawableFactory
{
    private static final String TAG = "RoundedBitmapDrawableFactory";
    
    public static RoundedBitmapDrawable create(final Resources resources, final Bitmap bitmap) {
        if (Build$VERSION.SDK_INT >= 21) {
            return new RoundedBitmapDrawable21(resources, bitmap);
        }
        return new RoundedBitmapDrawableFactory$DefaultRoundedBitmapDrawable(resources, bitmap);
    }
    
    public static RoundedBitmapDrawable create(final Resources resources, final InputStream inputStream) {
        final RoundedBitmapDrawable create = create(resources, BitmapFactory.decodeStream(inputStream));
        if (create.getBitmap() == null) {
            final String s = "RoundedBitmapDrawableFactory";
            final StringBuilder sb = new StringBuilder();
            sb.append("RoundedBitmapDrawable cannot decode ");
            sb.append(inputStream);
            Log.w(s, sb.toString());
        }
        return create;
    }
    
    public static RoundedBitmapDrawable create(final Resources resources, final String s) {
        final RoundedBitmapDrawable create = create(resources, BitmapFactory.decodeFile(s));
        if (create.getBitmap() == null) {
            final String s2 = "RoundedBitmapDrawableFactory";
            final StringBuilder sb = new StringBuilder();
            sb.append("RoundedBitmapDrawable cannot decode ");
            sb.append(s);
            Log.w(s2, sb.toString());
        }
        return create;
    }
}
