// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v7.view;

import android.support.v4.view.ViewConfigurationCompat;
import android.view.ViewConfiguration;
import android.os.Build$VERSION;
import android.support.v7.appcompat.R$bool;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.support.v7.appcompat.R$attr;
import android.support.v7.appcompat.R$styleable;
import android.support.v7.appcompat.R$dimen;
import android.content.res.Resources;
import android.support.v4.content.res.ConfigurationHelper;
import android.content.Context;

public class ActionBarPolicy
{
    private Context mContext;
    
    private ActionBarPolicy(final Context mContext) {
        this.mContext = mContext;
    }
    
    public static ActionBarPolicy get(final Context context) {
        return new ActionBarPolicy(context);
    }
    
    public boolean enableHomeButtonByDefault() {
        return this.mContext.getApplicationInfo().targetSdkVersion < 14;
    }
    
    public int getEmbeddedMenuWidthLimit() {
        return this.mContext.getResources().getDisplayMetrics().widthPixels / 2;
    }
    
    public int getMaxActionButtons() {
        final Resources resources = this.mContext.getResources();
        final int screenWidthDp = ConfigurationHelper.getScreenWidthDp(resources);
        final int screenHeightDp = ConfigurationHelper.getScreenHeightDp(resources);
        final int smallestScreenWidthDp = ConfigurationHelper.getSmallestScreenWidthDp(resources);
        final int n = 600;
        if (smallestScreenWidthDp <= n && screenWidthDp <= n) {
            final int n2 = 720;
            final int n3 = 960;
            if (screenWidthDp <= n3 || screenHeightDp <= n2) {
                if (screenWidthDp <= n2 || screenHeightDp <= n3) {
                    if (screenWidthDp < 500) {
                        final int n4 = 480;
                        final int n5 = 640;
                        if (screenWidthDp <= n5 || screenHeightDp <= n4) {
                            if (screenWidthDp <= n4 || screenHeightDp <= n5) {
                                if (screenWidthDp >= 360) {
                                    return 3;
                                }
                                return 2;
                            }
                        }
                    }
                    return 4;
                }
            }
        }
        return 5;
    }
    
    public int getStackedTabMaxWidth() {
        return this.mContext.getResources().getDimensionPixelSize(R$dimen.abc_action_bar_stacked_tab_max_width);
    }
    
    public int getTabContainerHeight() {
        final TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes((AttributeSet)null, R$styleable.ActionBar, R$attr.actionBarStyle, 0);
        int n = obtainStyledAttributes.getLayoutDimension(R$styleable.ActionBar_height, 0);
        final Resources resources = this.mContext.getResources();
        if (!this.hasEmbeddedTabs()) {
            n = Math.min(n, resources.getDimensionPixelSize(R$dimen.abc_action_bar_stacked_max_height));
        }
        obtainStyledAttributes.recycle();
        return n;
    }
    
    public boolean hasEmbeddedTabs() {
        return this.mContext.getResources().getBoolean(R$bool.abc_action_bar_embed_tabs);
    }
    
    public boolean showsOverflowMenuButton() {
        final int sdk_INT = Build$VERSION.SDK_INT;
        final boolean b = true;
        if (sdk_INT >= 19) {
            return b;
        }
        return ViewConfigurationCompat.hasPermanentMenuKey(ViewConfiguration.get(this.mContext)) ^ b;
    }
}
