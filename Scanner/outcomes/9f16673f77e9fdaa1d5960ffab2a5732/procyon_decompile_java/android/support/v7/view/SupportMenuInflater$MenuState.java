// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v7.view;

import android.content.res.TypedArray;
import android.support.v7.appcompat.R$styleable;
import android.util.AttributeSet;
import android.view.SubMenu;
import android.view.View;
import android.support.v7.view.menu.MenuItemWrapperICS;
import android.support.v7.view.menu.MenuItemImpl;
import android.view.MenuItem$OnMenuItemClickListener;
import android.support.v4.view.MenuItemCompat;
import android.view.MenuItem;
import java.lang.reflect.Constructor;
import android.content.Context;
import android.util.Log;
import android.view.Menu;
import android.support.v4.view.ActionProvider;

class SupportMenuInflater$MenuState
{
    private static final int defaultGroupId = 0;
    private static final int defaultItemCategory = 0;
    private static final int defaultItemCheckable = 0;
    private static final boolean defaultItemChecked = false;
    private static final boolean defaultItemEnabled = true;
    private static final int defaultItemId = 0;
    private static final int defaultItemOrder = 0;
    private static final boolean defaultItemVisible = true;
    private int groupCategory;
    private int groupCheckable;
    private boolean groupEnabled;
    private int groupId;
    private int groupOrder;
    private boolean groupVisible;
    ActionProvider itemActionProvider;
    private String itemActionProviderClassName;
    private String itemActionViewClassName;
    private int itemActionViewLayout;
    private boolean itemAdded;
    private char itemAlphabeticShortcut;
    private int itemCategoryOrder;
    private int itemCheckable;
    private boolean itemChecked;
    private boolean itemEnabled;
    private int itemIconResId;
    private int itemId;
    private String itemListenerMethodName;
    private char itemNumericShortcut;
    private int itemShowAsAction;
    private CharSequence itemTitle;
    private CharSequence itemTitleCondensed;
    private boolean itemVisible;
    private Menu menu;
    final /* synthetic */ SupportMenuInflater this$0;
    
    public SupportMenuInflater$MenuState(final SupportMenuInflater this$0, final Menu menu) {
        this.this$0 = this$0;
        this.menu = menu;
        this.resetGroup();
    }
    
    private char getShortcut(final String s) {
        if (s == null) {
            return '\0';
        }
        return s.charAt(0);
    }
    
    private Object newInstance(final String s, final Class[] array, final Object[] array2) {
        try {
            final SupportMenuInflater this$0 = this.this$0;
            try {
                final Context mContext = this$0.mContext;
                try {
                    final Constructor<?> constructor = mContext.getClassLoader().loadClass(s).getConstructor((Class<?>[])array);
                    constructor.setAccessible(true);
                    final Constructor<?> constructor2 = constructor;
                    try {
                        return constructor2.newInstance(array2);
                    }
                    catch (Exception ex) {
                        final StringBuilder sb = new StringBuilder();
                        sb.append("Cannot instantiate class: ");
                        sb.append(s);
                        Log.w("SupportMenuInflater", sb.toString(), (Throwable)ex);
                        return null;
                    }
                }
                catch (Exception ex2) {}
            }
            catch (Exception ex3) {}
        }
        catch (Exception ex4) {}
    }
    
    private void setItem(final MenuItem menuItem) {
        final MenuItem setEnabled = menuItem.setChecked(this.itemChecked).setVisible(this.itemVisible).setEnabled(this.itemEnabled);
        final int itemCheckable = this.itemCheckable;
        final int n = 1;
        setEnabled.setCheckable(itemCheckable >= n).setTitleCondensed(this.itemTitleCondensed).setIcon(this.itemIconResId).setAlphabeticShortcut(this.itemAlphabeticShortcut).setNumericShortcut(this.itemNumericShortcut);
        final int itemShowAsAction = this.itemShowAsAction;
        if (itemShowAsAction >= 0) {
            MenuItemCompat.setShowAsAction(menuItem, itemShowAsAction);
        }
        if (this.itemListenerMethodName != null) {
            if (this.this$0.mContext.isRestricted()) {
                throw new IllegalStateException("The android:onClick attribute cannot be used within a restricted context");
            }
            menuItem.setOnMenuItemClickListener((MenuItem$OnMenuItemClickListener)new SupportMenuInflater$InflatedOnMenuItemClickListener(this.this$0.getRealOwner(), this.itemListenerMethodName));
        }
        if (menuItem instanceof MenuItemImpl) {
            final MenuItemImpl menuItemImpl = (MenuItemImpl)menuItem;
        }
        if (this.itemCheckable >= 2) {
            if (menuItem instanceof MenuItemImpl) {
                ((MenuItemImpl)menuItem).setExclusiveCheckable(n != 0);
            }
            else if (menuItem instanceof MenuItemWrapperICS) {
                ((MenuItemWrapperICS)menuItem).setExclusiveCheckable(n != 0);
            }
        }
        boolean b = false;
        final String itemActionViewClassName = this.itemActionViewClassName;
        if (itemActionViewClassName != null) {
            MenuItemCompat.setActionView(menuItem, (View)this.newInstance(itemActionViewClassName, SupportMenuInflater.ACTION_VIEW_CONSTRUCTOR_SIGNATURE, this.this$0.mActionViewConstructorArguments));
            b = true;
        }
        final int itemActionViewLayout = this.itemActionViewLayout;
        if (itemActionViewLayout > 0) {
            if (!b) {
                MenuItemCompat.setActionView(menuItem, itemActionViewLayout);
            }
            else {
                Log.w("SupportMenuInflater", "Ignoring attribute 'itemActionViewLayout'. Action view already specified.");
            }
        }
        final ActionProvider itemActionProvider = this.itemActionProvider;
        if (itemActionProvider != null) {
            MenuItemCompat.setActionProvider(menuItem, itemActionProvider);
        }
    }
    
    public void addItem() {
        this.itemAdded = true;
        this.setItem(this.menu.add(this.groupId, this.itemId, this.itemCategoryOrder, this.itemTitle));
    }
    
    public SubMenu addSubMenuItem() {
        this.itemAdded = true;
        final SubMenu addSubMenu = this.menu.addSubMenu(this.groupId, this.itemId, this.itemCategoryOrder, this.itemTitle);
        this.setItem(addSubMenu.getItem());
        return addSubMenu;
    }
    
    public boolean hasAddedItem() {
        return this.itemAdded;
    }
    
    public void readGroup(final AttributeSet set) {
        final TypedArray obtainStyledAttributes = this.this$0.mContext.obtainStyledAttributes(set, R$styleable.MenuGroup);
        this.groupId = obtainStyledAttributes.getResourceId(R$styleable.MenuGroup_android_id, 0);
        this.groupCategory = obtainStyledAttributes.getInt(R$styleable.MenuGroup_android_menuCategory, 0);
        this.groupOrder = obtainStyledAttributes.getInt(R$styleable.MenuGroup_android_orderInCategory, 0);
        this.groupCheckable = obtainStyledAttributes.getInt(R$styleable.MenuGroup_android_checkableBehavior, 0);
        final int menuGroup_android_visible = R$styleable.MenuGroup_android_visible;
        final boolean b = true;
        this.groupVisible = obtainStyledAttributes.getBoolean(menuGroup_android_visible, b);
        this.groupEnabled = obtainStyledAttributes.getBoolean(R$styleable.MenuGroup_android_enabled, b);
        obtainStyledAttributes.recycle();
    }
    
    public void readItem(final AttributeSet set) {
        final TypedArray obtainStyledAttributes = this.this$0.mContext.obtainStyledAttributes(set, R$styleable.MenuItem);
        this.itemId = obtainStyledAttributes.getResourceId(R$styleable.MenuItem_android_id, 0);
        this.itemCategoryOrder = ((0xFFFF0000 & obtainStyledAttributes.getInt(R$styleable.MenuItem_android_menuCategory, this.groupCategory)) | ((char)(-1) & obtainStyledAttributes.getInt(R$styleable.MenuItem_android_orderInCategory, this.groupOrder)));
        this.itemTitle = obtainStyledAttributes.getText(R$styleable.MenuItem_android_title);
        this.itemTitleCondensed = obtainStyledAttributes.getText(R$styleable.MenuItem_android_titleCondensed);
        this.itemIconResId = obtainStyledAttributes.getResourceId(R$styleable.MenuItem_android_icon, 0);
        this.itemAlphabeticShortcut = this.getShortcut(obtainStyledAttributes.getString(R$styleable.MenuItem_android_alphabeticShortcut));
        this.itemNumericShortcut = this.getShortcut(obtainStyledAttributes.getString(R$styleable.MenuItem_android_numericShortcut));
        if (obtainStyledAttributes.hasValue(R$styleable.MenuItem_android_checkable)) {
            this.itemCheckable = (obtainStyledAttributes.getBoolean(R$styleable.MenuItem_android_checkable, false) ? 1 : 0);
        }
        else {
            this.itemCheckable = this.groupCheckable;
        }
        this.itemChecked = obtainStyledAttributes.getBoolean(R$styleable.MenuItem_android_checked, false);
        this.itemVisible = obtainStyledAttributes.getBoolean(R$styleable.MenuItem_android_visible, this.groupVisible);
        this.itemEnabled = obtainStyledAttributes.getBoolean(R$styleable.MenuItem_android_enabled, this.groupEnabled);
        this.itemShowAsAction = obtainStyledAttributes.getInt(R$styleable.MenuItem_showAsAction, -1);
        this.itemListenerMethodName = obtainStyledAttributes.getString(R$styleable.MenuItem_android_onClick);
        this.itemActionViewLayout = obtainStyledAttributes.getResourceId(R$styleable.MenuItem_actionLayout, 0);
        this.itemActionViewClassName = obtainStyledAttributes.getString(R$styleable.MenuItem_actionViewClass);
        this.itemActionProviderClassName = obtainStyledAttributes.getString(R$styleable.MenuItem_actionProviderClass);
        final boolean b = this.itemActionProviderClassName != null;
        if (b && this.itemActionViewLayout == 0 && this.itemActionViewClassName == null) {
            this.itemActionProvider = (ActionProvider)this.newInstance(this.itemActionProviderClassName, SupportMenuInflater.ACTION_PROVIDER_CONSTRUCTOR_SIGNATURE, this.this$0.mActionProviderConstructorArguments);
        }
        else {
            if (b) {
                Log.w("SupportMenuInflater", "Ignoring attribute 'actionProviderClass'. Action view already specified.");
            }
            this.itemActionProvider = null;
        }
        obtainStyledAttributes.recycle();
        this.itemAdded = false;
    }
    
    public void resetGroup() {
        this.groupId = 0;
        this.groupCategory = 0;
        this.groupOrder = 0;
        this.groupCheckable = 0;
        final boolean b = true;
        this.groupVisible = b;
        this.groupEnabled = b;
    }
}
