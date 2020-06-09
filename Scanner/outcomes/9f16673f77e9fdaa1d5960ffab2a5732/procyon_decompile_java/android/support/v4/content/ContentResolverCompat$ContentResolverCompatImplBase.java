// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.content;

import android.database.Cursor;
import android.support.v4.os.CancellationSignal;
import android.net.Uri;
import android.content.ContentResolver;

class ContentResolverCompat$ContentResolverCompatImplBase implements ContentResolverCompat$ContentResolverCompatImpl
{
    public Cursor query(final ContentResolver contentResolver, final Uri uri, final String[] array, final String s, final String[] array2, final String s2, final CancellationSignal cancellationSignal) {
        if (cancellationSignal != null) {
            cancellationSignal.throwIfCanceled();
        }
        return contentResolver.query(uri, array, s, array2, s2);
    }
}
