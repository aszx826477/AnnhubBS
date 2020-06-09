// 
// Decompiled by Procyon v0.5.30
// 

package com.bumptech.glide.manager;

import java.util.Iterator;
import com.bumptech.glide.RequestManager;
import java.util.HashSet;
import java.util.Set;

class SupportRequestManagerFragment$SupportFragmentRequestManagerTreeNode implements RequestManagerTreeNode
{
    final /* synthetic */ SupportRequestManagerFragment this$0;
    
    private SupportRequestManagerFragment$SupportFragmentRequestManagerTreeNode(final SupportRequestManagerFragment this$0) {
        this.this$0 = this$0;
    }
    
    public Set getDescendants() {
        final Set descendantRequestManagerFragments = this.this$0.getDescendantRequestManagerFragments();
        final HashSet set = new HashSet<RequestManager>(descendantRequestManagerFragments.size());
        for (final SupportRequestManagerFragment supportRequestManagerFragment : descendantRequestManagerFragments) {
            if (supportRequestManagerFragment.getRequestManager() != null) {
                set.add(supportRequestManagerFragment.getRequestManager());
            }
        }
        return set;
    }
}
