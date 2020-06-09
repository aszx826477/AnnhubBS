// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.media.session;

import android.os.SystemClock;
import java.util.Collection;
import java.util.ArrayList;
import android.os.Bundle;
import java.util.List;

public final class PlaybackStateCompat$Builder
{
    private long mActions;
    private long mActiveItemId;
    private long mBufferedPosition;
    private final List mCustomActions;
    private int mErrorCode;
    private CharSequence mErrorMessage;
    private Bundle mExtras;
    private long mPosition;
    private float mRate;
    private int mState;
    private long mUpdateTime;
    
    public PlaybackStateCompat$Builder() {
        this.mCustomActions = new ArrayList();
        this.mActiveItemId = -1;
    }
    
    public PlaybackStateCompat$Builder(final PlaybackStateCompat playbackStateCompat) {
        this.mCustomActions = new ArrayList();
        this.mActiveItemId = -1;
        this.mState = playbackStateCompat.mState;
        this.mPosition = playbackStateCompat.mPosition;
        this.mRate = playbackStateCompat.mSpeed;
        this.mUpdateTime = playbackStateCompat.mUpdateTime;
        this.mBufferedPosition = playbackStateCompat.mBufferedPosition;
        this.mActions = playbackStateCompat.mActions;
        this.mErrorCode = playbackStateCompat.mErrorCode;
        this.mErrorMessage = playbackStateCompat.mErrorMessage;
        if (playbackStateCompat.mCustomActions != null) {
            this.mCustomActions.addAll(playbackStateCompat.mCustomActions);
        }
        this.mActiveItemId = playbackStateCompat.mActiveItemId;
        this.mExtras = playbackStateCompat.mExtras;
    }
    
    public PlaybackStateCompat$Builder addCustomAction(final PlaybackStateCompat$CustomAction playbackStateCompat$CustomAction) {
        if (playbackStateCompat$CustomAction != null) {
            this.mCustomActions.add(playbackStateCompat$CustomAction);
            return this;
        }
        throw new IllegalArgumentException("You may not add a null CustomAction to PlaybackStateCompat.");
    }
    
    public PlaybackStateCompat$Builder addCustomAction(final String s, final String s2, final int n) {
        return this.addCustomAction(new PlaybackStateCompat$CustomAction(s, s2, n, null));
    }
    
    public PlaybackStateCompat build() {
        return new PlaybackStateCompat(this.mState, this.mPosition, this.mBufferedPosition, this.mRate, this.mActions, this.mErrorCode, this.mErrorMessage, this.mUpdateTime, this.mCustomActions, this.mActiveItemId, this.mExtras);
    }
    
    public PlaybackStateCompat$Builder setActions(final long mActions) {
        this.mActions = mActions;
        return this;
    }
    
    public PlaybackStateCompat$Builder setActiveQueueItemId(final long mActiveItemId) {
        this.mActiveItemId = mActiveItemId;
        return this;
    }
    
    public PlaybackStateCompat$Builder setBufferedPosition(final long mBufferedPosition) {
        this.mBufferedPosition = mBufferedPosition;
        return this;
    }
    
    public PlaybackStateCompat$Builder setErrorMessage(final int mErrorCode, final CharSequence mErrorMessage) {
        this.mErrorCode = mErrorCode;
        this.mErrorMessage = mErrorMessage;
        return this;
    }
    
    public PlaybackStateCompat$Builder setErrorMessage(final CharSequence mErrorMessage) {
        this.mErrorMessage = mErrorMessage;
        return this;
    }
    
    public PlaybackStateCompat$Builder setExtras(final Bundle mExtras) {
        this.mExtras = mExtras;
        return this;
    }
    
    public PlaybackStateCompat$Builder setState(final int n, final long n2, final float n3) {
        return this.setState(n, n2, n3, SystemClock.elapsedRealtime());
    }
    
    public PlaybackStateCompat$Builder setState(final int mState, final long mPosition, final float mRate, final long mUpdateTime) {
        this.mState = mState;
        this.mPosition = mPosition;
        this.mUpdateTime = mUpdateTime;
        this.mRate = mRate;
        return this;
    }
}
