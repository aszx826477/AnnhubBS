// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.view;

import android.view.View;
import android.util.Log;
import android.support.v4.internal.view.SupportMenuItem;
import android.view.MenuItem;
import android.os.Build$VERSION;

public final class MenuItemCompat
{
    static final MenuItemCompat$MenuVersionImpl IMPL;
    public static final int SHOW_AS_ACTION_ALWAYS = 2;
    public static final int SHOW_AS_ACTION_COLLAPSE_ACTION_VIEW = 8;
    public static final int SHOW_AS_ACTION_IF_ROOM = 1;
    public static final int SHOW_AS_ACTION_NEVER = 0;
    public static final int SHOW_AS_ACTION_WITH_TEXT = 4;
    private static final String TAG = "MenuItemCompat";
    
    static {
        if (Build$VERSION.SDK_INT >= 14) {
            IMPL = new MenuItemCompat$IcsMenuVersionImpl();
        }
        else if (Build$VERSION.SDK_INT >= 11) {
            IMPL = new MenuItemCompat$HoneycombMenuVersionImpl();
        }
        else {
            IMPL = new MenuItemCompat$BaseMenuVersionImpl();
        }
    }
    
    public static boolean collapseActionView(final MenuItem menuItem) {
        if (menuItem instanceof SupportMenuItem) {
            return ((SupportMenuItem)menuItem).collapseActionView();
        }
        return MenuItemCompat.IMPL.collapseActionView(menuItem);
    }
    
    public static boolean expandActionView(final MenuItem menuItem) {
        if (menuItem instanceof SupportMenuItem) {
            return ((SupportMenuItem)menuItem).expandActionView();
        }
        return MenuItemCompat.IMPL.expandActionView(menuItem);
    }
    
    public static ActionProvider getActionProvider(final MenuItem menuItem) {
        if (menuItem instanceof SupportMenuItem) {
            return ((SupportMenuItem)menuItem).getSupportActionProvider();
        }
        Log.w("MenuItemCompat", "getActionProvider: item does not implement SupportMenuItem; returning null");
        return null;
    }
    
    public static View getActionView(final MenuItem menuItem) {
        if (menuItem instanceof SupportMenuItem) {
            return ((SupportMenuItem)menuItem).getActionView();
        }
        return MenuItemCompat.IMPL.getActionView(menuItem);
    }
    
    public static boolean isActionViewExpanded(final MenuItem menuItem) {
        if (menuItem instanceof SupportMenuItem) {
            return ((SupportMenuItem)menuItem).isActionViewExpanded();
        }
        return MenuItemCompat.IMPL.isActionViewExpanded(menuItem);
    }
    
    public static MenuItem setActionProvider(final MenuItem menuItem, final ActionProvider supportActionProvider) {
        if (menuItem instanceof SupportMenuItem) {
            return (MenuItem)((SupportMenuItem)menuItem).setSupportActionProvider(supportActionProvider);
        }
        Log.w("MenuItemCompat", "setActionProvider: item does not implement SupportMenuItem; ignoring");
        return menuItem;
    }
    
    public static MenuItem setActionView(final MenuItem menuItem, final int actionView) {
        if (menuItem instanceof SupportMenuItem) {
            return ((SupportMenuItem)menuItem).setActionView(actionView);
        }
        return MenuItemCompat.IMPL.setActionView(menuItem, actionView);
    }
    
    public static MenuItem setActionView(final MenuItem menuItem, final View actionView) {
        if (menuItem instanceof SupportMenuItem) {
            return ((SupportMenuItem)menuItem).setActionView(actionView);
        }
        return MenuItemCompat.IMPL.setActionView(menuItem, actionView);
    }
    
    public static MenuItem setOnActionExpandListener(final MenuItem menuItem, final MenuItemCompat$OnActionExpandListener supportOnActionExpandListener) {
        if (menuItem instanceof SupportMenuItem) {
            return (MenuItem)((SupportMenuItem)menuItem).setSupportOnActionExpandListener(supportOnActionExpandListener);
        }
        return MenuItemCompat.IMPL.setOnActionExpandListener(menuItem, supportOnActionExpandListener);
    }
    
    public static void setShowAsAction(final MenuItem menuItem, final int showAsAction) {
        if (menuItem instanceof SupportMenuItem) {
            ((SupportMenuItem)menuItem).setShowAsAction(showAsAction);
        }
        else {
            MenuItemCompat.IMPL.setShowAsAction(menuItem, showAsAction);
        }
    }
}
