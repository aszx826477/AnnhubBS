// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v7.view.menu;

import java.util.Iterator;
import android.support.v4.internal.view.SupportSubMenu;
import android.view.SubMenu;
import android.support.v4.util.ArrayMap;
import android.support.v4.internal.view.SupportMenuItem;
import android.view.MenuItem;
import java.util.Map;
import android.content.Context;

abstract class BaseMenuWrapper extends BaseWrapper
{
    final Context mContext;
    private Map mMenuItems;
    private Map mSubMenus;
    
    BaseMenuWrapper(final Context mContext, final Object o) {
        super(o);
        this.mContext = mContext;
    }
    
    final MenuItem getMenuItemWrapper(final MenuItem menuItem) {
        if (menuItem instanceof SupportMenuItem) {
            final SupportMenuItem supportMenuItem = (SupportMenuItem)menuItem;
            if (this.mMenuItems == null) {
                this.mMenuItems = new ArrayMap();
            }
            MenuItem wrapSupportMenuItem = this.mMenuItems.get(menuItem);
            if (wrapSupportMenuItem == null) {
                wrapSupportMenuItem = MenuWrapperFactory.wrapSupportMenuItem(this.mContext, supportMenuItem);
                this.mMenuItems.put(supportMenuItem, wrapSupportMenuItem);
            }
            return wrapSupportMenuItem;
        }
        return menuItem;
    }
    
    final SubMenu getSubMenuWrapper(final SubMenu subMenu) {
        if (subMenu instanceof SupportSubMenu) {
            final SupportSubMenu supportSubMenu = (SupportSubMenu)subMenu;
            if (this.mSubMenus == null) {
                this.mSubMenus = new ArrayMap();
            }
            SubMenu wrapSupportSubMenu = this.mSubMenus.get(supportSubMenu);
            if (wrapSupportSubMenu == null) {
                wrapSupportSubMenu = MenuWrapperFactory.wrapSupportSubMenu(this.mContext, supportSubMenu);
                this.mSubMenus.put(supportSubMenu, wrapSupportSubMenu);
            }
            return wrapSupportSubMenu;
        }
        return subMenu;
    }
    
    final void internalClear() {
        final Map mMenuItems = this.mMenuItems;
        if (mMenuItems != null) {
            mMenuItems.clear();
        }
        final Map mSubMenus = this.mSubMenus;
        if (mSubMenus != null) {
            mSubMenus.clear();
        }
    }
    
    final void internalRemoveGroup(final int n) {
        final Map mMenuItems = this.mMenuItems;
        if (mMenuItems == null) {
            return;
        }
        final Iterator<MenuItem> iterator = mMenuItems.keySet().iterator();
        while (iterator.hasNext()) {
            if (n == iterator.next().getGroupId()) {
                iterator.remove();
            }
        }
    }
    
    final void internalRemoveItem(final int n) {
        final Map mMenuItems = this.mMenuItems;
        if (mMenuItems == null) {
            return;
        }
        final Iterator<MenuItem> iterator = mMenuItems.keySet().iterator();
        while (iterator.hasNext()) {
            if (n == iterator.next().getItemId()) {
                iterator.remove();
                break;
            }
        }
    }
}
