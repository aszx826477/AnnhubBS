// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.view;

import android.view.View;
import android.util.AttributeSet;
import android.content.Context;
import android.view.LayoutInflater$Factory;

class LayoutInflaterCompatBase$FactoryWrapper implements LayoutInflater$Factory
{
    final LayoutInflaterFactory mDelegateFactory;
    
    LayoutInflaterCompatBase$FactoryWrapper(final LayoutInflaterFactory mDelegateFactory) {
        this.mDelegateFactory = mDelegateFactory;
    }
    
    public View onCreateView(final String s, final Context context, final AttributeSet set) {
        return this.mDelegateFactory.onCreateView(null, s, context, set);
    }
    
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(this.getClass().getName());
        sb.append("{");
        sb.append(this.mDelegateFactory);
        sb.append("}");
        return sb.toString();
    }
}
