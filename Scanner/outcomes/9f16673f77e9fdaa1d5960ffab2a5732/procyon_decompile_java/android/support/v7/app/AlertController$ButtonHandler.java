// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v7.app;

import android.content.DialogInterface$OnClickListener;
import android.os.Message;
import android.content.DialogInterface;
import java.lang.ref.WeakReference;
import android.os.Handler;

final class AlertController$ButtonHandler extends Handler
{
    private static final int MSG_DISMISS_DIALOG = 1;
    private WeakReference mDialog;
    
    public AlertController$ButtonHandler(final DialogInterface dialogInterface) {
        this.mDialog = new WeakReference((T)dialogInterface);
    }
    
    public void handleMessage(final Message message) {
        final int what = message.what;
        if (what != 1) {
            switch (what) {
                case -3:
                case -2:
                case -1: {
                    ((DialogInterface$OnClickListener)message.obj).onClick((DialogInterface)this.mDialog.get(), message.what);
                    break;
                }
            }
        }
        else {
            ((DialogInterface)message.obj).dismiss();
        }
    }
}
