// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v7.app;

import android.content.res.TypedArray;
import android.content.res.Resources$Theme;
import android.support.v7.appcompat.R$styleable;
import android.support.v7.view.ContextThemeWrapper;
import android.support.v7.appcompat.R$style;
import android.support.v7.appcompat.R$attr;
import android.util.TypedValue;
import android.os.Parcelable;
import android.support.v7.appcompat.R$layout;
import android.support.v7.view.menu.MenuView;
import android.support.v7.view.menu.MenuPresenter$Callback;
import android.support.v7.view.menu.MenuPresenter;
import android.support.v7.view.menu.MenuBuilder;
import android.content.Context;
import android.support.v7.view.menu.ListMenuPresenter;
import android.os.Bundle;
import android.view.ViewGroup;
import android.view.View;

public final class AppCompatDelegateImplV9$PanelFeatureState
{
    int background;
    View createdPanelView;
    ViewGroup decorView;
    int featureId;
    Bundle frozenActionViewState;
    Bundle frozenMenuState;
    int gravity;
    boolean isHandled;
    boolean isOpen;
    boolean isPrepared;
    ListMenuPresenter listMenuPresenter;
    Context listPresenterContext;
    MenuBuilder menu;
    public boolean qwertyMode;
    boolean refreshDecorView;
    boolean refreshMenuContent;
    View shownPanelView;
    boolean wasLastOpen;
    int windowAnimations;
    int x;
    int y;
    
    AppCompatDelegateImplV9$PanelFeatureState(final int featureId) {
        this.featureId = featureId;
        this.refreshDecorView = false;
    }
    
    void applyFrozenState() {
        final MenuBuilder menu = this.menu;
        if (menu != null) {
            final Bundle frozenMenuState = this.frozenMenuState;
            if (frozenMenuState != null) {
                menu.restorePresenterStates(frozenMenuState);
                this.frozenMenuState = null;
            }
        }
    }
    
    public void clearMenuPresenters() {
        final MenuBuilder menu = this.menu;
        if (menu != null) {
            menu.removeMenuPresenter(this.listMenuPresenter);
        }
        this.listMenuPresenter = null;
    }
    
    MenuView getListMenuView(final MenuPresenter$Callback callback) {
        if (this.menu == null) {
            return null;
        }
        if (this.listMenuPresenter == null) {
            (this.listMenuPresenter = new ListMenuPresenter(this.listPresenterContext, R$layout.abc_list_menu_item_layout)).setCallback(callback);
            this.menu.addMenuPresenter(this.listMenuPresenter);
        }
        return this.listMenuPresenter.getMenuView(this.decorView);
    }
    
    public boolean hasPanelItems() {
        final View shownPanelView = this.shownPanelView;
        boolean b = false;
        if (shownPanelView == null) {
            return false;
        }
        final View createdPanelView = this.createdPanelView;
        final boolean b2 = true;
        if (createdPanelView != null) {
            return b2;
        }
        if (this.listMenuPresenter.getAdapter().getCount() > 0) {
            b = true;
        }
        return b;
    }
    
    void onRestoreInstanceState(final Parcelable parcelable) {
        final AppCompatDelegateImplV9$PanelFeatureState$SavedState appCompatDelegateImplV9$PanelFeatureState$SavedState = (AppCompatDelegateImplV9$PanelFeatureState$SavedState)parcelable;
        this.featureId = appCompatDelegateImplV9$PanelFeatureState$SavedState.featureId;
        this.wasLastOpen = appCompatDelegateImplV9$PanelFeatureState$SavedState.isOpen;
        this.frozenMenuState = appCompatDelegateImplV9$PanelFeatureState$SavedState.menuState;
        this.shownPanelView = null;
        this.decorView = null;
    }
    
    Parcelable onSaveInstanceState() {
        final AppCompatDelegateImplV9$PanelFeatureState$SavedState appCompatDelegateImplV9$PanelFeatureState$SavedState = new AppCompatDelegateImplV9$PanelFeatureState$SavedState();
        appCompatDelegateImplV9$PanelFeatureState$SavedState.featureId = this.featureId;
        appCompatDelegateImplV9$PanelFeatureState$SavedState.isOpen = this.isOpen;
        if (this.menu != null) {
            appCompatDelegateImplV9$PanelFeatureState$SavedState.menuState = new Bundle();
            this.menu.savePresenterStates(appCompatDelegateImplV9$PanelFeatureState$SavedState.menuState);
        }
        return (Parcelable)appCompatDelegateImplV9$PanelFeatureState$SavedState;
    }
    
    void setMenu(final MenuBuilder menu) {
        final MenuBuilder menu2 = this.menu;
        if (menu == menu2) {
            return;
        }
        if (menu2 != null) {
            menu2.removeMenuPresenter(this.listMenuPresenter);
        }
        if ((this.menu = menu) != null) {
            final ListMenuPresenter listMenuPresenter = this.listMenuPresenter;
            if (listMenuPresenter != null) {
                menu.addMenuPresenter(listMenuPresenter);
            }
        }
    }
    
    void setStyle(final Context context) {
        final TypedValue typedValue = new TypedValue();
        final Resources$Theme theme = context.getResources().newTheme();
        theme.setTo(context.getTheme());
        final int actionBarPopupTheme = R$attr.actionBarPopupTheme;
        final boolean b = true;
        theme.resolveAttribute(actionBarPopupTheme, typedValue, b);
        if (typedValue.resourceId != 0) {
            theme.applyStyle(typedValue.resourceId, b);
        }
        theme.resolveAttribute(R$attr.panelMenuListTheme, typedValue, b);
        if (typedValue.resourceId != 0) {
            theme.applyStyle(typedValue.resourceId, b);
        }
        else {
            theme.applyStyle(R$style.Theme_AppCompat_CompactMenu, b);
        }
        final Context listPresenterContext;
        (listPresenterContext = (Context)new ContextThemeWrapper(context, 0)).getTheme().setTo(theme);
        this.listPresenterContext = listPresenterContext;
        final TypedArray obtainStyledAttributes = listPresenterContext.obtainStyledAttributes(R$styleable.AppCompatTheme);
        this.background = obtainStyledAttributes.getResourceId(R$styleable.AppCompatTheme_panelBackground, 0);
        this.windowAnimations = obtainStyledAttributes.getResourceId(R$styleable.AppCompatTheme_android_windowAnimationStyle, 0);
        obtainStyledAttributes.recycle();
    }
}
