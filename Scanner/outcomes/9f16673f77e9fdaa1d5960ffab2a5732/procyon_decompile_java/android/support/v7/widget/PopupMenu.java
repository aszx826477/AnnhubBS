// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v7.widget;

import android.support.v7.view.SupportMenuInflater;
import android.view.MenuInflater;
import android.view.Menu;
import android.widget.PopupWindow$OnDismissListener;
import android.support.v7.view.menu.MenuBuilder$Callback;
import android.support.v7.appcompat.R$attr;
import android.support.v7.view.menu.MenuPopupHelper;
import android.support.v7.view.menu.MenuBuilder;
import android.view.View$OnTouchListener;
import android.content.Context;
import android.view.View;

public class PopupMenu
{
    private final View mAnchor;
    private final Context mContext;
    private View$OnTouchListener mDragListener;
    private final MenuBuilder mMenu;
    PopupMenu$OnMenuItemClickListener mMenuItemClickListener;
    PopupMenu$OnDismissListener mOnDismissListener;
    final MenuPopupHelper mPopup;
    
    public PopupMenu(final Context context, final View view) {
        this(context, view, 0);
    }
    
    public PopupMenu(final Context context, final View view, final int n) {
        this(context, view, n, R$attr.popupMenuStyle, 0);
    }
    
    public PopupMenu(final Context mContext, final View mAnchor, final int gravity, final int n, final int n2) {
        this.mContext = mContext;
        this.mAnchor = mAnchor;
        (this.mMenu = new MenuBuilder(mContext)).setCallback(new PopupMenu$1(this));
        (this.mPopup = new MenuPopupHelper(mContext, this.mMenu, mAnchor, false, n, n2)).setGravity(gravity);
        this.mPopup.setOnDismissListener((PopupWindow$OnDismissListener)new PopupMenu$2(this));
    }
    
    public void dismiss() {
        this.mPopup.dismiss();
    }
    
    public View$OnTouchListener getDragToOpenListener() {
        if (this.mDragListener == null) {
            this.mDragListener = (View$OnTouchListener)new PopupMenu$3(this, this.mAnchor);
        }
        return this.mDragListener;
    }
    
    public int getGravity() {
        return this.mPopup.getGravity();
    }
    
    public Menu getMenu() {
        return (Menu)this.mMenu;
    }
    
    public MenuInflater getMenuInflater() {
        return new SupportMenuInflater(this.mContext);
    }
    
    public void inflate(final int n) {
        this.getMenuInflater().inflate(n, (Menu)this.mMenu);
    }
    
    public void setGravity(final int gravity) {
        this.mPopup.setGravity(gravity);
    }
    
    public void setOnDismissListener(final PopupMenu$OnDismissListener mOnDismissListener) {
        this.mOnDismissListener = mOnDismissListener;
    }
    
    public void setOnMenuItemClickListener(final PopupMenu$OnMenuItemClickListener mMenuItemClickListener) {
        this.mMenuItemClickListener = mMenuItemClickListener;
    }
    
    public void show() {
        this.mPopup.show();
    }
}
