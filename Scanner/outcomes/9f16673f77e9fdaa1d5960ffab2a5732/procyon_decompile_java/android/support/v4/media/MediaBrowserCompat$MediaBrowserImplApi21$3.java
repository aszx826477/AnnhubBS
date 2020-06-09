// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.media;

class MediaBrowserCompat$MediaBrowserImplApi21$3 implements Runnable
{
    final /* synthetic */ MediaBrowserCompat$MediaBrowserImplApi21 this$0;
    final /* synthetic */ MediaBrowserCompat$ItemCallback val$cb;
    final /* synthetic */ String val$mediaId;
    
    MediaBrowserCompat$MediaBrowserImplApi21$3(final MediaBrowserCompat$MediaBrowserImplApi21 this$0, final MediaBrowserCompat$ItemCallback val$cb, final String val$mediaId) {
        this.this$0 = this$0;
        this.val$cb = val$cb;
        this.val$mediaId = val$mediaId;
    }
    
    public void run() {
        this.val$cb.onError(this.val$mediaId);
    }
}
