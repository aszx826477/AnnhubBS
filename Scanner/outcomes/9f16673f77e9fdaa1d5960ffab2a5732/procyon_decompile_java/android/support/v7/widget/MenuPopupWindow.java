// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v7.widget;

import android.transition.Transition;
import android.os.Build$VERSION;
import android.view.MenuItem;
import android.support.v7.view.menu.MenuBuilder;
import android.util.AttributeSet;
import android.content.Context;
import android.util.Log;
import android.widget.PopupWindow;
import java.lang.reflect.Method;

public class MenuPopupWindow extends ListPopupWindow implements MenuItemHoverListener
{
    private static final String TAG = "MenuPopupWindow";
    private static Method sSetTouchModalMethod;
    private MenuItemHoverListener mHoverListener;
    
    static {
        final Class<PopupWindow> clazz = PopupWindow.class;
        final String s = "setTouchModal";
        final int n = 1;
        try {
            final Class[] array = new Class[n];
            try {
                array[0] = Boolean.TYPE;
                final Method declaredMethod = clazz.getDeclaredMethod(s, (Class[])array);
                try {
                    MenuPopupWindow.sSetTouchModalMethod = declaredMethod;
                }
                catch (NoSuchMethodException ex) {
                    Log.i("MenuPopupWindow", "Could not find method setTouchModal() on PopupWindow. Oh well.");
                }
            }
            catch (NoSuchMethodException ex2) {}
        }
        catch (NoSuchMethodException ex3) {}
    }
    
    public MenuPopupWindow(final Context context, final AttributeSet set, final int n, final int n2) {
        super(context, set, n, n2);
    }
    
    DropDownListView createDropDownListView(final Context context, final boolean b) {
        final MenuPopupWindow$MenuDropDownListView menuPopupWindow$MenuDropDownListView = new MenuPopupWindow$MenuDropDownListView(context, b);
        menuPopupWindow$MenuDropDownListView.setHoverListener(this);
        return menuPopupWindow$MenuDropDownListView;
    }
    
    public void onItemHoverEnter(final MenuBuilder menuBuilder, final MenuItem menuItem) {
        final MenuItemHoverListener mHoverListener = this.mHoverListener;
        if (mHoverListener != null) {
            mHoverListener.onItemHoverEnter(menuBuilder, menuItem);
        }
    }
    
    public void onItemHoverExit(final MenuBuilder menuBuilder, final MenuItem menuItem) {
        final MenuItemHoverListener mHoverListener = this.mHoverListener;
        if (mHoverListener != null) {
            mHoverListener.onItemHoverExit(menuBuilder, menuItem);
        }
    }
    
    public void setEnterTransition(final Object o) {
        if (Build$VERSION.SDK_INT >= 23) {
            this.mPopup.setEnterTransition((Transition)o);
        }
    }
    
    public void setExitTransition(final Object o) {
        if (Build$VERSION.SDK_INT >= 23) {
            this.mPopup.setExitTransition((Transition)o);
        }
    }
    
    public void setHoverListener(final MenuItemHoverListener mHoverListener) {
        this.mHoverListener = mHoverListener;
    }
    
    public void setTouchModal(final boolean b) {
        final Method sSetTouchModalMethod = MenuPopupWindow.sSetTouchModalMethod;
        if (sSetTouchModalMethod != null) {
            try {
                final PopupWindow mPopup = this.mPopup;
                final Object[] array = { null };
                try {
                    array[0] = b;
                    sSetTouchModalMethod.invoke(mPopup, array);
                }
                catch (Exception ex) {
                    Log.i("MenuPopupWindow", "Could not invoke setTouchModal() on PopupWindow. Oh well.");
                }
            }
            catch (Exception ex2) {}
        }
    }
}
