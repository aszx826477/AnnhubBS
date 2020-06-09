// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.app;

import java.util.ArrayList;

class FragmentManagerImpl$PopBackStackState implements FragmentManagerImpl$OpGenerator
{
    final int mFlags;
    final int mId;
    final String mName;
    final /* synthetic */ FragmentManagerImpl this$0;
    
    FragmentManagerImpl$PopBackStackState(final FragmentManagerImpl this$0, final String mName, final int mId, final int mFlags) {
        this.this$0 = this$0;
        this.mName = mName;
        this.mId = mId;
        this.mFlags = mFlags;
    }
    
    public boolean generateOps(final ArrayList list, final ArrayList list2) {
        return this.this$0.popBackStackState(list, list2, this.mName, this.mId, this.mFlags);
    }
}
