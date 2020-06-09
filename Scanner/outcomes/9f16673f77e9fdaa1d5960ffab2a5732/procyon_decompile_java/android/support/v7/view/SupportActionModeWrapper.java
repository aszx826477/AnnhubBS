// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v7.view;

import android.view.MenuInflater;
import android.support.v7.view.menu.MenuWrapperFactory;
import android.support.v4.internal.view.SupportMenu;
import android.view.Menu;
import android.view.View;
import android.content.Context;
import android.view.ActionMode;

public class SupportActionModeWrapper extends ActionMode
{
    final Context mContext;
    final android.support.v7.view.ActionMode mWrappedObject;
    
    public SupportActionModeWrapper(final Context mContext, final android.support.v7.view.ActionMode mWrappedObject) {
        this.mContext = mContext;
        this.mWrappedObject = mWrappedObject;
    }
    
    public void finish() {
        this.mWrappedObject.finish();
    }
    
    public View getCustomView() {
        return this.mWrappedObject.getCustomView();
    }
    
    public Menu getMenu() {
        return MenuWrapperFactory.wrapSupportMenu(this.mContext, (SupportMenu)this.mWrappedObject.getMenu());
    }
    
    public MenuInflater getMenuInflater() {
        return this.mWrappedObject.getMenuInflater();
    }
    
    public CharSequence getSubtitle() {
        return this.mWrappedObject.getSubtitle();
    }
    
    public Object getTag() {
        return this.mWrappedObject.getTag();
    }
    
    public CharSequence getTitle() {
        return this.mWrappedObject.getTitle();
    }
    
    public boolean getTitleOptionalHint() {
        return this.mWrappedObject.getTitleOptionalHint();
    }
    
    public void invalidate() {
        this.mWrappedObject.invalidate();
    }
    
    public boolean isTitleOptional() {
        return this.mWrappedObject.isTitleOptional();
    }
    
    public void setCustomView(final View customView) {
        this.mWrappedObject.setCustomView(customView);
    }
    
    public void setSubtitle(final int subtitle) {
        this.mWrappedObject.setSubtitle(subtitle);
    }
    
    public void setSubtitle(final CharSequence subtitle) {
        this.mWrappedObject.setSubtitle(subtitle);
    }
    
    public void setTag(final Object tag) {
        this.mWrappedObject.setTag(tag);
    }
    
    public void setTitle(final int title) {
        this.mWrappedObject.setTitle(title);
    }
    
    public void setTitle(final CharSequence title) {
        this.mWrappedObject.setTitle(title);
    }
    
    public void setTitleOptionalHint(final boolean titleOptionalHint) {
        this.mWrappedObject.setTitleOptionalHint(titleOptionalHint);
    }
}
