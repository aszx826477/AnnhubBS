// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v7.app;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.os.Message;
import android.content.DialogInterface$OnClickListener;
import android.view.KeyEvent;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Button;
import android.support.v7.appcompat.R$attr;
import android.util.TypedValue;
import android.content.DialogInterface$OnCancelListener;
import android.content.Context;
import android.content.DialogInterface;

public class AlertDialog extends AppCompatDialog implements DialogInterface
{
    static final int LAYOUT_HINT_NONE = 0;
    static final int LAYOUT_HINT_SIDE = 1;
    final AlertController mAlert;
    
    protected AlertDialog(final Context context) {
        this(context, 0);
    }
    
    protected AlertDialog(final Context context, final int n) {
        super(context, resolveDialogTheme(context, n));
        this.mAlert = new AlertController(this.getContext(), this, this.getWindow());
    }
    
    protected AlertDialog(final Context context, final boolean cancelable, final DialogInterface$OnCancelListener onCancelListener) {
        this(context, 0);
        this.setCancelable(cancelable);
        this.setOnCancelListener(onCancelListener);
    }
    
    static int resolveDialogTheme(final Context context, final int n) {
        if (n >= 16777216) {
            return n;
        }
        final TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(R$attr.alertDialogTheme, typedValue, true);
        return typedValue.resourceId;
    }
    
    public Button getButton(final int n) {
        return this.mAlert.getButton(n);
    }
    
    public ListView getListView() {
        return this.mAlert.getListView();
    }
    
    protected void onCreate(final Bundle bundle) {
        super.onCreate(bundle);
        this.mAlert.installContent();
    }
    
    public boolean onKeyDown(final int n, final KeyEvent keyEvent) {
        return this.mAlert.onKeyDown(n, keyEvent) || super.onKeyDown(n, keyEvent);
    }
    
    public boolean onKeyUp(final int n, final KeyEvent keyEvent) {
        return this.mAlert.onKeyUp(n, keyEvent) || super.onKeyUp(n, keyEvent);
    }
    
    public void setButton(final int n, final CharSequence charSequence, final DialogInterface$OnClickListener dialogInterface$OnClickListener) {
        this.mAlert.setButton(n, charSequence, dialogInterface$OnClickListener, null);
    }
    
    public void setButton(final int n, final CharSequence charSequence, final Message message) {
        this.mAlert.setButton(n, charSequence, null, message);
    }
    
    void setButtonPanelLayoutHint(final int buttonPanelLayoutHint) {
        this.mAlert.setButtonPanelLayoutHint(buttonPanelLayoutHint);
    }
    
    public void setCustomTitle(final View customTitle) {
        this.mAlert.setCustomTitle(customTitle);
    }
    
    public void setIcon(final int icon) {
        this.mAlert.setIcon(icon);
    }
    
    public void setIcon(final Drawable icon) {
        this.mAlert.setIcon(icon);
    }
    
    public void setIconAttribute(final int n) {
        final TypedValue typedValue = new TypedValue();
        this.getContext().getTheme().resolveAttribute(n, typedValue, true);
        this.mAlert.setIcon(typedValue.resourceId);
    }
    
    public void setMessage(final CharSequence message) {
        this.mAlert.setMessage(message);
    }
    
    public void setTitle(final CharSequence charSequence) {
        super.setTitle(charSequence);
        this.mAlert.setTitle(charSequence);
    }
    
    public void setView(final View view) {
        this.mAlert.setView(view);
    }
    
    public void setView(final View view, final int n, final int n2, final int n3, final int n4) {
        this.mAlert.setView(view, n, n2, n3, n4);
    }
}
