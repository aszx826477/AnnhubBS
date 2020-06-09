// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v7.view.menu;

import android.view.View;
import android.graphics.drawable.Drawable;
import android.view.Menu;
import android.view.MenuItem;
import android.content.Context;
import android.view.SubMenu;

public class SubMenuBuilder extends MenuBuilder implements SubMenu
{
    private MenuItemImpl mItem;
    private MenuBuilder mParentMenu;
    
    public SubMenuBuilder(final Context context, final MenuBuilder mParentMenu, final MenuItemImpl mItem) {
        super(context);
        this.mParentMenu = mParentMenu;
        this.mItem = mItem;
    }
    
    public boolean collapseItemActionView(final MenuItemImpl menuItemImpl) {
        return this.mParentMenu.collapseItemActionView(menuItemImpl);
    }
    
    boolean dispatchMenuItemSelected(final MenuBuilder menuBuilder, final MenuItem menuItem) {
        return super.dispatchMenuItemSelected(menuBuilder, menuItem) || this.mParentMenu.dispatchMenuItemSelected(menuBuilder, menuItem);
    }
    
    public boolean expandItemActionView(final MenuItemImpl menuItemImpl) {
        return this.mParentMenu.expandItemActionView(menuItemImpl);
    }
    
    public String getActionViewStatesKey() {
        final MenuItemImpl mItem = this.mItem;
        int itemId;
        if (mItem != null) {
            itemId = mItem.getItemId();
        }
        else {
            itemId = 0;
        }
        if (itemId == 0) {
            return null;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append(super.getActionViewStatesKey());
        sb.append(":");
        sb.append(itemId);
        return sb.toString();
    }
    
    public MenuItem getItem() {
        return (MenuItem)this.mItem;
    }
    
    public Menu getParentMenu() {
        return (Menu)this.mParentMenu;
    }
    
    public MenuBuilder getRootMenu() {
        return this.mParentMenu.getRootMenu();
    }
    
    public boolean isQwertyMode() {
        return this.mParentMenu.isQwertyMode();
    }
    
    public boolean isShortcutsVisible() {
        return this.mParentMenu.isShortcutsVisible();
    }
    
    public void setCallback(final MenuBuilder$Callback callback) {
        this.mParentMenu.setCallback(callback);
    }
    
    public SubMenu setHeaderIcon(final int headerIconInt) {
        return (SubMenu)super.setHeaderIconInt(headerIconInt);
    }
    
    public SubMenu setHeaderIcon(final Drawable headerIconInt) {
        return (SubMenu)super.setHeaderIconInt(headerIconInt);
    }
    
    public SubMenu setHeaderTitle(final int headerTitleInt) {
        return (SubMenu)super.setHeaderTitleInt(headerTitleInt);
    }
    
    public SubMenu setHeaderTitle(final CharSequence headerTitleInt) {
        return (SubMenu)super.setHeaderTitleInt(headerTitleInt);
    }
    
    public SubMenu setHeaderView(final View headerViewInt) {
        return (SubMenu)super.setHeaderViewInt(headerViewInt);
    }
    
    public SubMenu setIcon(final int icon) {
        this.mItem.setIcon(icon);
        return (SubMenu)this;
    }
    
    public SubMenu setIcon(final Drawable icon) {
        this.mItem.setIcon(icon);
        return (SubMenu)this;
    }
    
    public void setQwertyMode(final boolean qwertyMode) {
        this.mParentMenu.setQwertyMode(qwertyMode);
    }
    
    public void setShortcutsVisible(final boolean shortcutsVisible) {
        this.mParentMenu.setShortcutsVisible(shortcutsVisible);
    }
}
