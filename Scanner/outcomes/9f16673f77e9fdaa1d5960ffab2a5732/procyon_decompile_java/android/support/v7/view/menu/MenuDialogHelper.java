// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v7.view.menu;

import android.view.WindowManager$LayoutParams;
import android.support.v7.appcompat.R$layout;
import android.support.v7.app.AlertDialog$Builder;
import android.os.IBinder;
import android.view.KeyEvent$DispatcherState;
import android.view.View;
import android.view.Window;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.content.DialogInterface$OnDismissListener;
import android.content.DialogInterface$OnClickListener;
import android.content.DialogInterface$OnKeyListener;

class MenuDialogHelper implements DialogInterface$OnKeyListener, DialogInterface$OnClickListener, DialogInterface$OnDismissListener, MenuPresenter$Callback
{
    private AlertDialog mDialog;
    private MenuBuilder mMenu;
    ListMenuPresenter mPresenter;
    private MenuPresenter$Callback mPresenterCallback;
    
    public MenuDialogHelper(final MenuBuilder mMenu) {
        this.mMenu = mMenu;
    }
    
    public void dismiss() {
        final AlertDialog mDialog = this.mDialog;
        if (mDialog != null) {
            mDialog.dismiss();
        }
    }
    
    public void onClick(final DialogInterface dialogInterface, final int n) {
        this.mMenu.performItemAction((MenuItem)this.mPresenter.getAdapter().getItem(n), 0);
    }
    
    public void onCloseMenu(final MenuBuilder menuBuilder, final boolean b) {
        if (b || menuBuilder == this.mMenu) {
            this.dismiss();
        }
        final MenuPresenter$Callback mPresenterCallback = this.mPresenterCallback;
        if (mPresenterCallback != null) {
            mPresenterCallback.onCloseMenu(menuBuilder, b);
        }
    }
    
    public void onDismiss(final DialogInterface dialogInterface) {
        this.mPresenter.onCloseMenu(this.mMenu, true);
    }
    
    public boolean onKey(final DialogInterface dialogInterface, final int n, final KeyEvent keyEvent) {
        if (n == 82 || n == 4) {
            final int action = keyEvent.getAction();
            final boolean b = true;
            if (action == 0 && keyEvent.getRepeatCount() == 0) {
                final Window window = this.mDialog.getWindow();
                if (window != null) {
                    final View decorView = window.getDecorView();
                    if (decorView != null) {
                        final KeyEvent$DispatcherState keyDispatcherState = decorView.getKeyDispatcherState();
                        if (keyDispatcherState != null) {
                            keyDispatcherState.startTracking(keyEvent, (Object)this);
                            return b;
                        }
                    }
                }
            }
            else if (keyEvent.getAction() == (b ? 1 : 0) && !keyEvent.isCanceled()) {
                final Window window2 = this.mDialog.getWindow();
                if (window2 != null) {
                    final View decorView2 = window2.getDecorView();
                    if (decorView2 != null) {
                        final KeyEvent$DispatcherState keyDispatcherState2 = decorView2.getKeyDispatcherState();
                        if (keyDispatcherState2 != null && keyDispatcherState2.isTracking(keyEvent)) {
                            this.mMenu.close(b);
                            dialogInterface.dismiss();
                            return b;
                        }
                    }
                }
            }
        }
        return this.mMenu.performShortcut(n, keyEvent, 0);
    }
    
    public boolean onOpenSubMenu(final MenuBuilder menuBuilder) {
        final MenuPresenter$Callback mPresenterCallback = this.mPresenterCallback;
        return mPresenterCallback != null && mPresenterCallback.onOpenSubMenu(menuBuilder);
    }
    
    public void setPresenterCallback(final MenuPresenter$Callback mPresenterCallback) {
        this.mPresenterCallback = mPresenterCallback;
    }
    
    public void show(final IBinder token) {
        final MenuBuilder mMenu = this.mMenu;
        final AlertDialog$Builder alertDialog$Builder = new AlertDialog$Builder(mMenu.getContext());
        (this.mPresenter = new ListMenuPresenter(alertDialog$Builder.getContext(), R$layout.abc_list_menu_item_layout)).setCallback(this);
        this.mMenu.addMenuPresenter(this.mPresenter);
        alertDialog$Builder.setAdapter(this.mPresenter.getAdapter(), (DialogInterface$OnClickListener)this);
        final View headerView = mMenu.getHeaderView();
        if (headerView != null) {
            alertDialog$Builder.setCustomTitle(headerView);
        }
        else {
            alertDialog$Builder.setIcon(mMenu.getHeaderIcon()).setTitle(mMenu.getHeaderTitle());
        }
        alertDialog$Builder.setOnKeyListener((DialogInterface$OnKeyListener)this);
        (this.mDialog = alertDialog$Builder.create()).setOnDismissListener((DialogInterface$OnDismissListener)this);
        final WindowManager$LayoutParams attributes = this.mDialog.getWindow().getAttributes();
        attributes.type = 1003;
        if (token != null) {
            attributes.token = token;
        }
        attributes.flags |= 0x20000;
        this.mDialog.show();
    }
}
