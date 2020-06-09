// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.app;

import android.os.Bundle;

final class FragmentTabHost$TabInfo
{
    final Bundle args;
    final Class clss;
    Fragment fragment;
    final String tag;
    
    FragmentTabHost$TabInfo(final String tag, final Class clss, final Bundle args) {
        this.tag = tag;
        this.clss = clss;
        this.args = args;
    }
}
