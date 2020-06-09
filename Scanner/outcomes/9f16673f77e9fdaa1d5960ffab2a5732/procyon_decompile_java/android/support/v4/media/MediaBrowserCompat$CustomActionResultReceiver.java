// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.media;

import android.util.Log;
import android.os.Handler;
import android.os.Bundle;
import android.support.v4.os.ResultReceiver;

class MediaBrowserCompat$CustomActionResultReceiver extends ResultReceiver
{
    private final String mAction;
    private final MediaBrowserCompat$CustomActionCallback mCallback;
    private final Bundle mExtras;
    
    MediaBrowserCompat$CustomActionResultReceiver(final String mAction, final Bundle mExtras, final MediaBrowserCompat$CustomActionCallback mCallback, final Handler handler) {
        super(handler);
        this.mAction = mAction;
        this.mExtras = mExtras;
        this.mCallback = mCallback;
    }
    
    protected void onReceiveResult(final int n, final Bundle bundle) {
        final MediaBrowserCompat$CustomActionCallback mCallback = this.mCallback;
        if (mCallback == null) {
            return;
        }
        switch (n) {
            default: {
                final String s = "MediaBrowserCompat";
                final StringBuilder sb = new StringBuilder();
                sb.append("Unknown result code: ");
                sb.append(n);
                sb.append(" (extras=");
                sb.append(this.mExtras);
                sb.append(", resultData=");
                sb.append(bundle);
                sb.append(")");
                Log.w(s, sb.toString());
                break;
            }
            case 1: {
                mCallback.onProgressUpdate(this.mAction, this.mExtras, bundle);
                break;
            }
            case 0: {
                mCallback.onResult(this.mAction, this.mExtras, bundle);
                break;
            }
            case -1: {
                mCallback.onError(this.mAction, this.mExtras, bundle);
                break;
            }
        }
    }
}
