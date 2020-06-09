// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.app;

import java.util.List;

public class FragmentManagerNonConfig
{
    private final List mChildNonConfigs;
    private final List mFragments;
    
    FragmentManagerNonConfig(final List mFragments, final List mChildNonConfigs) {
        this.mFragments = mFragments;
        this.mChildNonConfigs = mChildNonConfigs;
    }
    
    List getChildNonConfigs() {
        return this.mChildNonConfigs;
    }
    
    List getFragments() {
        return this.mFragments;
    }
}
