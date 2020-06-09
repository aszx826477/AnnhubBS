// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v7.app;

import android.support.v7.content.res.AppCompatResources;
import android.view.ViewGroup;
import android.view.LayoutInflater;
import android.graphics.drawable.Drawable;
import android.view.View;

public class WindowDecorActionBar$TabImpl extends ActionBar$Tab
{
    private ActionBar$TabListener mCallback;
    private CharSequence mContentDesc;
    private View mCustomView;
    private Drawable mIcon;
    private int mPosition;
    private Object mTag;
    private CharSequence mText;
    final /* synthetic */ WindowDecorActionBar this$0;
    
    public WindowDecorActionBar$TabImpl(final WindowDecorActionBar this$0) {
        this.this$0 = this$0;
        this.mPosition = -1;
    }
    
    public ActionBar$TabListener getCallback() {
        return this.mCallback;
    }
    
    public CharSequence getContentDescription() {
        return this.mContentDesc;
    }
    
    public View getCustomView() {
        return this.mCustomView;
    }
    
    public Drawable getIcon() {
        return this.mIcon;
    }
    
    public int getPosition() {
        return this.mPosition;
    }
    
    public Object getTag() {
        return this.mTag;
    }
    
    public CharSequence getText() {
        return this.mText;
    }
    
    public void select() {
        this.this$0.selectTab(this);
    }
    
    public ActionBar$Tab setContentDescription(final int n) {
        return this.setContentDescription(this.this$0.mContext.getResources().getText(n));
    }
    
    public ActionBar$Tab setContentDescription(final CharSequence mContentDesc) {
        this.mContentDesc = mContentDesc;
        if (this.mPosition >= 0) {
            this.this$0.mTabScrollView.updateTab(this.mPosition);
        }
        return this;
    }
    
    public ActionBar$Tab setCustomView(final int n) {
        return this.setCustomView(LayoutInflater.from(this.this$0.getThemedContext()).inflate(n, (ViewGroup)null));
    }
    
    public ActionBar$Tab setCustomView(final View mCustomView) {
        this.mCustomView = mCustomView;
        if (this.mPosition >= 0) {
            this.this$0.mTabScrollView.updateTab(this.mPosition);
        }
        return this;
    }
    
    public ActionBar$Tab setIcon(final int n) {
        return this.setIcon(AppCompatResources.getDrawable(this.this$0.mContext, n));
    }
    
    public ActionBar$Tab setIcon(final Drawable mIcon) {
        this.mIcon = mIcon;
        if (this.mPosition >= 0) {
            this.this$0.mTabScrollView.updateTab(this.mPosition);
        }
        return this;
    }
    
    public void setPosition(final int mPosition) {
        this.mPosition = mPosition;
    }
    
    public ActionBar$Tab setTabListener(final ActionBar$TabListener mCallback) {
        this.mCallback = mCallback;
        return this;
    }
    
    public ActionBar$Tab setTag(final Object mTag) {
        this.mTag = mTag;
        return this;
    }
    
    public ActionBar$Tab setText(final int n) {
        return this.setText(this.this$0.mContext.getResources().getText(n));
    }
    
    public ActionBar$Tab setText(final CharSequence mText) {
        this.mText = mText;
        if (this.mPosition >= 0) {
            this.this$0.mTabScrollView.updateTab(this.mPosition);
        }
        return this;
    }
}
