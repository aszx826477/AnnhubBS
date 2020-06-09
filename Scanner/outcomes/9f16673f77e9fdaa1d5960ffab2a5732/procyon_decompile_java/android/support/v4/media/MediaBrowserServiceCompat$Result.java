// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.media;

import android.os.Bundle;

public class MediaBrowserServiceCompat$Result
{
    private final Object mDebug;
    private boolean mDetachCalled;
    private int mFlags;
    private boolean mSendErrorCalled;
    private boolean mSendProgressUpdateCalled;
    private boolean mSendResultCalled;
    
    MediaBrowserServiceCompat$Result(final Object mDebug) {
        this.mDebug = mDebug;
    }
    
    public void detach() {
        if (this.mDetachCalled) {
            final StringBuilder sb = new StringBuilder();
            sb.append("detach() called when detach() had already been called for: ");
            sb.append(this.mDebug);
            throw new IllegalStateException(sb.toString());
        }
        if (this.mSendResultCalled) {
            final StringBuilder sb2 = new StringBuilder();
            sb2.append("detach() called when sendResult() had already been called for: ");
            sb2.append(this.mDebug);
            throw new IllegalStateException(sb2.toString());
        }
        if (!this.mSendErrorCalled) {
            this.mDetachCalled = true;
            return;
        }
        final StringBuilder sb3 = new StringBuilder();
        sb3.append("detach() called when sendError() had already been called for: ");
        sb3.append(this.mDebug);
        throw new IllegalStateException(sb3.toString());
    }
    
    int getFlags() {
        return this.mFlags;
    }
    
    boolean isDone() {
        return this.mDetachCalled || this.mSendResultCalled || this.mSendErrorCalled;
    }
    
    void onErrorSent(final Bundle bundle) {
        final StringBuilder sb = new StringBuilder();
        sb.append("It is not supported to send an error for ");
        sb.append(this.mDebug);
        throw new UnsupportedOperationException(sb.toString());
    }
    
    void onProgressUpdateSent(final Bundle bundle) {
        final StringBuilder sb = new StringBuilder();
        sb.append("It is not supported to send an interim update for ");
        sb.append(this.mDebug);
        throw new UnsupportedOperationException(sb.toString());
    }
    
    void onResultSent(final Object o) {
    }
    
    public void sendError(final Bundle bundle) {
        if (!this.mSendResultCalled && !this.mSendErrorCalled) {
            this.mSendErrorCalled = true;
            this.onErrorSent(bundle);
            return;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("sendError() called when either sendResult() or sendError() had already been called for: ");
        sb.append(this.mDebug);
        throw new IllegalStateException(sb.toString());
    }
    
    public void sendProgressUpdate(final Bundle bundle) {
        if (!this.mSendResultCalled && !this.mSendErrorCalled) {
            this.mSendProgressUpdateCalled = true;
            this.onProgressUpdateSent(bundle);
            return;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("sendProgressUpdate() called when either sendResult() or sendError() had already been called for: ");
        sb.append(this.mDebug);
        throw new IllegalStateException(sb.toString());
    }
    
    public void sendResult(final Object o) {
        if (!this.mSendResultCalled && !this.mSendErrorCalled) {
            this.mSendResultCalled = true;
            this.onResultSent(o);
            return;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("sendResult() called when either sendResult() or sendError() had already been called for: ");
        sb.append(this.mDebug);
        throw new IllegalStateException(sb.toString());
    }
    
    void setFlags(final int mFlags) {
        this.mFlags = mFlags;
    }
}
