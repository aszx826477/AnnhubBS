// 
// Decompiled by Procyon v0.5.30
// 

package com.bumptech.glide.manager;

import java.util.Iterator;
import com.bumptech.glide.RequestManager;
import java.util.HashSet;
import java.util.Set;

class RequestManagerFragment$FragmentRequestManagerTreeNode implements RequestManagerTreeNode
{
    final /* synthetic */ RequestManagerFragment this$0;
    
    private RequestManagerFragment$FragmentRequestManagerTreeNode(final RequestManagerFragment this$0) {
        this.this$0 = this$0;
    }
    
    public Set getDescendants() {
        final Set descendantRequestManagerFragments = this.this$0.getDescendantRequestManagerFragments();
        final HashSet set = new HashSet<RequestManager>(descendantRequestManagerFragments.size());
        for (final RequestManagerFragment requestManagerFragment : descendantRequestManagerFragments) {
            if (requestManagerFragment.getRequestManager() != null) {
                set.add(requestManagerFragment.getRequestManager());
            }
        }
        return set;
    }
}
