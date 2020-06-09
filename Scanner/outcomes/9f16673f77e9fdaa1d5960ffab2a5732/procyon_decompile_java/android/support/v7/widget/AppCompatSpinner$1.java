// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v7.widget;

import android.support.v7.content.res.AppCompatResources;
import android.widget.ListAdapter;
import android.widget.Adapter;
import android.view.MotionEvent;
import android.graphics.PorterDuff$Mode;
import android.content.res.ColorStateList;
import android.view.ViewGroup$LayoutParams;
import android.view.ViewGroup;
import android.view.View$MeasureSpec;
import android.graphics.drawable.Drawable;
import android.content.res.TypedArray;
import android.support.v7.appcompat.R$layout;
import android.widget.ArrayAdapter;
import android.os.Build$VERSION;
import android.support.v7.view.ContextThemeWrapper;
import android.support.v7.appcompat.R$styleable;
import android.content.res.Resources$Theme;
import android.support.v7.appcompat.R$attr;
import android.util.AttributeSet;
import android.graphics.Rect;
import android.widget.SpinnerAdapter;
import android.content.Context;
import android.support.v4.view.TintableBackgroundView;
import android.widget.Spinner;
import android.support.v7.view.menu.ShowableListMenu;
import android.view.View;

class AppCompatSpinner$1 extends ForwardingListener
{
    final /* synthetic */ AppCompatSpinner this$0;
    final /* synthetic */ AppCompatSpinner$DropdownPopup val$popup;
    
    AppCompatSpinner$1(final AppCompatSpinner this$0, final View view, final AppCompatSpinner$DropdownPopup val$popup) {
        this.this$0 = this$0;
        this.val$popup = val$popup;
        super(view);
    }
    
    public ShowableListMenu getPopup() {
        return this.val$popup;
    }
    
    public boolean onForwardingStarted() {
        if (!this.this$0.mPopup.isShowing()) {
            this.this$0.mPopup.show();
        }
        return true;
    }
}
