// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v7.view;

import android.support.v4.internal.view.SupportMenuItem;
import android.view.MenuItem;
import android.support.v7.view.menu.MenuWrapperFactory;
import android.support.v4.internal.view.SupportMenu;
import android.view.Menu;
import android.support.v4.util.SimpleArrayMap;
import android.content.Context;
import java.util.ArrayList;

public class SupportActionModeWrapper$CallbackWrapper implements ActionMode$Callback
{
    final ArrayList mActionModes;
    final Context mContext;
    final SimpleArrayMap mMenus;
    final android.view.ActionMode$Callback mWrappedCallback;
    
    public SupportActionModeWrapper$CallbackWrapper(final Context mContext, final android.view.ActionMode$Callback mWrappedCallback) {
        this.mContext = mContext;
        this.mWrappedCallback = mWrappedCallback;
        this.mActionModes = new ArrayList();
        this.mMenus = new SimpleArrayMap();
    }
    
    private Menu getMenuWrapper(final Menu menu) {
        Menu wrapSupportMenu = (Menu)this.mMenus.get(menu);
        if (wrapSupportMenu == null) {
            wrapSupportMenu = MenuWrapperFactory.wrapSupportMenu(this.mContext, (SupportMenu)menu);
            this.mMenus.put(menu, wrapSupportMenu);
        }
        return wrapSupportMenu;
    }
    
    public android.view.ActionMode getActionModeWrapper(final ActionMode actionMode) {
        for (int i = 0; i < this.mActionModes.size(); ++i) {
            final SupportActionModeWrapper supportActionModeWrapper = this.mActionModes.get(i);
            if (supportActionModeWrapper != null && supportActionModeWrapper.mWrappedObject == actionMode) {
                return supportActionModeWrapper;
            }
        }
        final SupportActionModeWrapper supportActionModeWrapper2 = new SupportActionModeWrapper(this.mContext, actionMode);
        this.mActionModes.add(supportActionModeWrapper2);
        return supportActionModeWrapper2;
    }
    
    public boolean onActionItemClicked(final ActionMode actionMode, final MenuItem menuItem) {
        return this.mWrappedCallback.onActionItemClicked(this.getActionModeWrapper(actionMode), MenuWrapperFactory.wrapSupportMenuItem(this.mContext, (SupportMenuItem)menuItem));
    }
    
    public boolean onCreateActionMode(final ActionMode actionMode, final Menu menu) {
        return this.mWrappedCallback.onCreateActionMode(this.getActionModeWrapper(actionMode), this.getMenuWrapper(menu));
    }
    
    public void onDestroyActionMode(final ActionMode actionMode) {
        this.mWrappedCallback.onDestroyActionMode(this.getActionModeWrapper(actionMode));
    }
    
    public boolean onPrepareActionMode(final ActionMode actionMode, final Menu menu) {
        return this.mWrappedCallback.onPrepareActionMode(this.getActionModeWrapper(actionMode), this.getMenuWrapper(menu));
    }
}
