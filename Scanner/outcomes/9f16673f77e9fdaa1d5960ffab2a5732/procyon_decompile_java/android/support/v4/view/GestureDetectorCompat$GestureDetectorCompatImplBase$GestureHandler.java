// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.view;

import android.os.Message;
import android.os.Handler;

class GestureDetectorCompat$GestureDetectorCompatImplBase$GestureHandler extends Handler
{
    final /* synthetic */ GestureDetectorCompat$GestureDetectorCompatImplBase this$0;
    
    GestureDetectorCompat$GestureDetectorCompatImplBase$GestureHandler(final GestureDetectorCompat$GestureDetectorCompatImplBase this$0) {
        this.this$0 = this$0;
    }
    
    GestureDetectorCompat$GestureDetectorCompatImplBase$GestureHandler(final GestureDetectorCompat$GestureDetectorCompatImplBase this$0, final Handler handler) {
        this.this$0 = this$0;
        super(handler.getLooper());
    }
    
    public void handleMessage(final Message message) {
        switch (message.what) {
            default: {
                final StringBuilder sb = new StringBuilder();
                sb.append("Unknown message ");
                sb.append(message);
                throw new RuntimeException(sb.toString());
            }
            case 3: {
                if (this.this$0.mDoubleTapListener == null) {
                    break;
                }
                if (!this.this$0.mStillDown) {
                    this.this$0.mDoubleTapListener.onSingleTapConfirmed(this.this$0.mCurrentDownEvent);
                    break;
                }
                this.this$0.mDeferConfirmSingleTap = true;
                break;
            }
            case 2: {
                this.this$0.dispatchLongPress();
                break;
            }
            case 1: {
                this.this$0.mListener.onShowPress(this.this$0.mCurrentDownEvent);
                break;
            }
        }
    }
}
