// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.media.session;

import android.support.v4.media.RatingCompat;
import android.net.Uri;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.Log;

class MediaControllerCompat$TransportControlsBase extends MediaControllerCompat$TransportControls
{
    private IMediaSession mBinder;
    
    public MediaControllerCompat$TransportControlsBase(final IMediaSession mBinder) {
        this.mBinder = mBinder;
    }
    
    public void fastForward() {
        try {
            final IMediaSession mBinder = this.mBinder;
            try {
                mBinder.fastForward();
            }
            catch (RemoteException ex) {
                Log.e("MediaControllerCompat", "Dead object in fastForward.", (Throwable)ex);
            }
        }
        catch (RemoteException ex2) {}
    }
    
    public void pause() {
        try {
            final IMediaSession mBinder = this.mBinder;
            try {
                mBinder.pause();
            }
            catch (RemoteException ex) {
                Log.e("MediaControllerCompat", "Dead object in pause.", (Throwable)ex);
            }
        }
        catch (RemoteException ex2) {}
    }
    
    public void play() {
        try {
            final IMediaSession mBinder = this.mBinder;
            try {
                mBinder.play();
            }
            catch (RemoteException ex) {
                Log.e("MediaControllerCompat", "Dead object in play.", (Throwable)ex);
            }
        }
        catch (RemoteException ex2) {}
    }
    
    public void playFromMediaId(final String s, final Bundle bundle) {
        try {
            this.mBinder.playFromMediaId(s, bundle);
        }
        catch (RemoteException ex) {
            Log.e("MediaControllerCompat", "Dead object in playFromMediaId.", (Throwable)ex);
        }
    }
    
    public void playFromSearch(final String s, final Bundle bundle) {
        try {
            this.mBinder.playFromSearch(s, bundle);
        }
        catch (RemoteException ex) {
            Log.e("MediaControllerCompat", "Dead object in playFromSearch.", (Throwable)ex);
        }
    }
    
    public void playFromUri(final Uri uri, final Bundle bundle) {
        try {
            this.mBinder.playFromUri(uri, bundle);
        }
        catch (RemoteException ex) {
            Log.e("MediaControllerCompat", "Dead object in playFromUri.", (Throwable)ex);
        }
    }
    
    public void prepare() {
        try {
            final IMediaSession mBinder = this.mBinder;
            try {
                mBinder.prepare();
            }
            catch (RemoteException ex) {
                Log.e("MediaControllerCompat", "Dead object in prepare.", (Throwable)ex);
            }
        }
        catch (RemoteException ex2) {}
    }
    
    public void prepareFromMediaId(final String s, final Bundle bundle) {
        try {
            this.mBinder.prepareFromMediaId(s, bundle);
        }
        catch (RemoteException ex) {
            Log.e("MediaControllerCompat", "Dead object in prepareFromMediaId.", (Throwable)ex);
        }
    }
    
    public void prepareFromSearch(final String s, final Bundle bundle) {
        try {
            this.mBinder.prepareFromSearch(s, bundle);
        }
        catch (RemoteException ex) {
            Log.e("MediaControllerCompat", "Dead object in prepareFromSearch.", (Throwable)ex);
        }
    }
    
    public void prepareFromUri(final Uri uri, final Bundle bundle) {
        try {
            this.mBinder.prepareFromUri(uri, bundle);
        }
        catch (RemoteException ex) {
            Log.e("MediaControllerCompat", "Dead object in prepareFromUri.", (Throwable)ex);
        }
    }
    
    public void rewind() {
        try {
            final IMediaSession mBinder = this.mBinder;
            try {
                mBinder.rewind();
            }
            catch (RemoteException ex) {
                Log.e("MediaControllerCompat", "Dead object in rewind.", (Throwable)ex);
            }
        }
        catch (RemoteException ex2) {}
    }
    
    public void seekTo(final long n) {
        try {
            this.mBinder.seekTo(n);
        }
        catch (RemoteException ex) {
            Log.e("MediaControllerCompat", "Dead object in seekTo.", (Throwable)ex);
        }
    }
    
    public void sendCustomAction(final PlaybackStateCompat$CustomAction playbackStateCompat$CustomAction, final Bundle bundle) {
        this.sendCustomAction(playbackStateCompat$CustomAction.getAction(), bundle);
    }
    
    public void sendCustomAction(final String s, final Bundle bundle) {
        try {
            this.mBinder.sendCustomAction(s, bundle);
        }
        catch (RemoteException ex) {
            Log.e("MediaControllerCompat", "Dead object in sendCustomAction.", (Throwable)ex);
        }
    }
    
    public void setCaptioningEnabled(final boolean captioningEnabled) {
        try {
            this.mBinder.setCaptioningEnabled(captioningEnabled);
        }
        catch (RemoteException ex) {
            Log.e("MediaControllerCompat", "Dead object in setCaptioningEnabled.", (Throwable)ex);
        }
    }
    
    public void setRating(final RatingCompat ratingCompat) {
        try {
            this.mBinder.rate(ratingCompat);
        }
        catch (RemoteException ex) {
            Log.e("MediaControllerCompat", "Dead object in setRating.", (Throwable)ex);
        }
    }
    
    public void setRepeatMode(final int repeatMode) {
        try {
            this.mBinder.setRepeatMode(repeatMode);
        }
        catch (RemoteException ex) {
            Log.e("MediaControllerCompat", "Dead object in setRepeatMode.", (Throwable)ex);
        }
    }
    
    public void setShuffleModeEnabled(final boolean shuffleModeEnabled) {
        try {
            this.mBinder.setShuffleModeEnabled(shuffleModeEnabled);
        }
        catch (RemoteException ex) {
            Log.e("MediaControllerCompat", "Dead object in setShuffleModeEnabled.", (Throwable)ex);
        }
    }
    
    public void skipToNext() {
        try {
            final IMediaSession mBinder = this.mBinder;
            try {
                mBinder.next();
            }
            catch (RemoteException ex) {
                Log.e("MediaControllerCompat", "Dead object in skipToNext.", (Throwable)ex);
            }
        }
        catch (RemoteException ex2) {}
    }
    
    public void skipToPrevious() {
        try {
            final IMediaSession mBinder = this.mBinder;
            try {
                mBinder.previous();
            }
            catch (RemoteException ex) {
                Log.e("MediaControllerCompat", "Dead object in skipToPrevious.", (Throwable)ex);
            }
        }
        catch (RemoteException ex2) {}
    }
    
    public void skipToQueueItem(final long n) {
        try {
            this.mBinder.skipToQueueItem(n);
        }
        catch (RemoteException ex) {
            Log.e("MediaControllerCompat", "Dead object in skipToQueueItem.", (Throwable)ex);
        }
    }
    
    public void stop() {
        try {
            final IMediaSession mBinder = this.mBinder;
            try {
                mBinder.stop();
            }
            catch (RemoteException ex) {
                Log.e("MediaControllerCompat", "Dead object in stop.", (Throwable)ex);
            }
        }
        catch (RemoteException ex2) {}
    }
}
