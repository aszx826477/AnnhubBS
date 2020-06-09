// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v7.app;

import android.content.DialogInterface;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView$OnItemClickListener;

class AlertController$AlertParams$3 implements AdapterView$OnItemClickListener
{
    final /* synthetic */ AlertController$AlertParams this$0;
    final /* synthetic */ AlertController val$dialog;
    
    AlertController$AlertParams$3(final AlertController$AlertParams this$0, final AlertController val$dialog) {
        this.this$0 = this$0;
        this.val$dialog = val$dialog;
    }
    
    public void onItemClick(final AdapterView adapterView, final View view, final int n, final long n2) {
        this.this$0.mOnClickListener.onClick((DialogInterface)this.val$dialog.mDialog, n);
        if (!this.this$0.mIsSingleChoice) {
            this.val$dialog.mDialog.dismiss();
        }
    }
}
