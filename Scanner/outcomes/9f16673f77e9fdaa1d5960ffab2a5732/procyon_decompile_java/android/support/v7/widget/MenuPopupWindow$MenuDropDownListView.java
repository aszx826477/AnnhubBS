// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v7.widget;

import android.view.View;
import android.support.v7.view.menu.ListMenuItemView;
import android.view.KeyEvent;
import android.support.v7.view.menu.MenuBuilder;
import android.widget.ListAdapter;
import android.support.v7.view.menu.MenuAdapter;
import android.widget.HeaderViewListAdapter;
import android.view.MotionEvent;
import android.content.res.Configuration;
import android.os.Build$VERSION;
import android.content.Context;
import android.view.MenuItem;

public class MenuPopupWindow$MenuDropDownListView extends DropDownListView
{
    final int mAdvanceKey;
    private MenuItemHoverListener mHoverListener;
    private MenuItem mHoveredMenuItem;
    final int mRetreatKey;
    
    public MenuPopupWindow$MenuDropDownListView(final Context context, final boolean b) {
        super(context, b);
        final Configuration configuration = context.getResources().getConfiguration();
        final int sdk_INT = Build$VERSION.SDK_INT;
        final int n = 21;
        final int n2 = 22;
        if (sdk_INT >= 17 && 1 == configuration.getLayoutDirection()) {
            this.mAdvanceKey = n;
            this.mRetreatKey = n2;
        }
        else {
            this.mAdvanceKey = n2;
            this.mRetreatKey = n;
        }
    }
    
    public void clearSelection() {
        this.setSelection(-1);
    }
    
    public boolean onHoverEvent(final MotionEvent motionEvent) {
        if (this.mHoverListener != null) {
            final ListAdapter adapter = this.getAdapter();
            int headersCount;
            MenuAdapter menuAdapter;
            if (adapter instanceof HeaderViewListAdapter) {
                final HeaderViewListAdapter headerViewListAdapter = (HeaderViewListAdapter)adapter;
                headersCount = headerViewListAdapter.getHeadersCount();
                menuAdapter = (MenuAdapter)headerViewListAdapter.getWrappedAdapter();
            }
            else {
                headersCount = 0;
                menuAdapter = (MenuAdapter)adapter;
            }
            Object item = null;
            if (motionEvent.getAction() != 10) {
                final int pointToPosition = this.pointToPosition((int)motionEvent.getX(), (int)motionEvent.getY());
                if (pointToPosition != -1) {
                    final int n = pointToPosition - headersCount;
                    if (n >= 0 && n < menuAdapter.getCount()) {
                        item = menuAdapter.getItem(n);
                    }
                }
            }
            final MenuItem mHoveredMenuItem = this.mHoveredMenuItem;
            if (mHoveredMenuItem != item) {
                final MenuBuilder adapterMenu = menuAdapter.getAdapterMenu();
                if (mHoveredMenuItem != null) {
                    this.mHoverListener.onItemHoverExit(adapterMenu, mHoveredMenuItem);
                }
                if ((this.mHoveredMenuItem = (MenuItem)item) != null) {
                    this.mHoverListener.onItemHoverEnter(adapterMenu, (MenuItem)item);
                }
            }
        }
        return super.onHoverEvent(motionEvent);
    }
    
    public boolean onKeyDown(final int n, final KeyEvent keyEvent) {
        final ListMenuItemView listMenuItemView = (ListMenuItemView)this.getSelectedView();
        final boolean b = true;
        if (listMenuItemView != null && n == this.mAdvanceKey) {
            if (listMenuItemView.isEnabled() && listMenuItemView.getItemData().hasSubMenu()) {
                this.performItemClick((View)listMenuItemView, this.getSelectedItemPosition(), this.getSelectedItemId());
            }
            return b;
        }
        if (listMenuItemView != null && n == this.mRetreatKey) {
            this.setSelection(-1);
            ((MenuAdapter)this.getAdapter()).getAdapterMenu().close(false);
            return b;
        }
        return super.onKeyDown(n, keyEvent);
    }
    
    public void setHoverListener(final MenuItemHoverListener mHoverListener) {
        this.mHoverListener = mHoverListener;
    }
}
