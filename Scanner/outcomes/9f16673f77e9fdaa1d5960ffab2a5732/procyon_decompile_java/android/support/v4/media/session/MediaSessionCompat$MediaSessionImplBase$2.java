// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.media.session;

import android.support.v4.media.RatingCompat;

class MediaSessionCompat$MediaSessionImplBase$2 implements MediaSessionCompatApi19$Callback
{
    final /* synthetic */ MediaSessionCompat$MediaSessionImplBase this$0;
    
    MediaSessionCompat$MediaSessionImplBase$2(final MediaSessionCompat$MediaSessionImplBase this$0) {
        this.this$0 = this$0;
    }
    
    public void onSeekTo(final long n) {
        this.this$0.postToHandler(18, n);
    }
    
    public void onSetRating(final Object o) {
        this.this$0.postToHandler(19, RatingCompat.fromRating(o));
    }
}
