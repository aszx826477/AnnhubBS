// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.content;

import android.database.Cursor;
import android.support.v4.os.CancellationSignal;
import android.net.Uri;
import android.content.ContentResolver;
import android.os.Build$VERSION;

public final class ContentResolverCompat
{
    private static final ContentResolverCompat$ContentResolverCompatImpl IMPL;
    
    static {
        if (Build$VERSION.SDK_INT >= 16) {
            IMPL = new ContentResolverCompat$ContentResolverCompatImplJB();
        }
        else {
            IMPL = new ContentResolverCompat$ContentResolverCompatImplBase();
        }
    }
    
    public static Cursor query(final ContentResolver contentResolver, final Uri uri, final String[] array, final String s, final String[] array2, final String s2, final CancellationSignal cancellationSignal) {
        return ContentResolverCompat.IMPL.query(contentResolver, uri, array, s, array2, s2, cancellationSignal);
    }
}
