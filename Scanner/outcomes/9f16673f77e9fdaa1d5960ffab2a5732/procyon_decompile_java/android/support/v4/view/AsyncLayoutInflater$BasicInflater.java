// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.view;

import android.view.View;
import android.util.AttributeSet;
import android.content.Context;
import android.view.LayoutInflater;

class AsyncLayoutInflater$BasicInflater extends LayoutInflater
{
    private static final String[] sClassPrefixList;
    
    static {
        sClassPrefixList = new String[] { "android.widget.", "android.webkit.", "android.app." };
    }
    
    AsyncLayoutInflater$BasicInflater(final Context context) {
        super(context);
    }
    
    public LayoutInflater cloneInContext(final Context context) {
        return new AsyncLayoutInflater$BasicInflater(context);
    }
    
    protected View onCreateView(final String s, final AttributeSet set) {
        final String[] sClassPrefixList = AsyncLayoutInflater$BasicInflater.sClassPrefixList;
        for (int length = sClassPrefixList.length, i = 0; i < length; ++i) {
            final String s2 = sClassPrefixList[i];
            try {
                final View view = this.createView(s, s2, set);
                if (view != null) {
                    return view;
                }
            }
            catch (ClassNotFoundException ex) {}
        }
        return super.onCreateView(s, set);
    }
}
