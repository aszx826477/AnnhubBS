// 
// Decompiled by Procyon v0.5.30
// 

package com.bumptech.glide.manager;

import android.app.Activity;
import java.util.Iterator;
import java.util.Collections;
import java.util.Set;
import com.bumptech.glide.RequestManager;
import java.util.HashSet;
import android.support.v4.app.Fragment;

public class SupportRequestManagerFragment extends Fragment
{
    private final HashSet childRequestManagerFragments;
    private final ActivityFragmentLifecycle lifecycle;
    private RequestManager requestManager;
    private final RequestManagerTreeNode requestManagerTreeNode;
    private SupportRequestManagerFragment rootRequestManagerFragment;
    
    public SupportRequestManagerFragment() {
        this(new ActivityFragmentLifecycle());
    }
    
    public SupportRequestManagerFragment(final ActivityFragmentLifecycle lifecycle) {
        this.requestManagerTreeNode = new SupportRequestManagerFragment$SupportFragmentRequestManagerTreeNode(this, null);
        this.childRequestManagerFragments = new HashSet();
        this.lifecycle = lifecycle;
    }
    
    private void addChildRequestManagerFragment(final SupportRequestManagerFragment supportRequestManagerFragment) {
        this.childRequestManagerFragments.add(supportRequestManagerFragment);
    }
    
    private boolean isDescendant(Fragment parentFragment) {
        final Fragment parentFragment2 = this.getParentFragment();
        while (parentFragment.getParentFragment() != null) {
            if (parentFragment.getParentFragment() == parentFragment2) {
                return true;
            }
            parentFragment = parentFragment.getParentFragment();
        }
        return false;
    }
    
    private void removeChildRequestManagerFragment(final SupportRequestManagerFragment supportRequestManagerFragment) {
        this.childRequestManagerFragments.remove(supportRequestManagerFragment);
    }
    
    public Set getDescendantRequestManagerFragments() {
        final SupportRequestManagerFragment rootRequestManagerFragment = this.rootRequestManagerFragment;
        if (rootRequestManagerFragment == null) {
            return Collections.emptySet();
        }
        if (rootRequestManagerFragment == this) {
            return Collections.unmodifiableSet((Set<?>)this.childRequestManagerFragments);
        }
        final HashSet<SupportRequestManagerFragment> set = new HashSet<SupportRequestManagerFragment>();
        for (final SupportRequestManagerFragment supportRequestManagerFragment : this.rootRequestManagerFragment.getDescendantRequestManagerFragments()) {
            if (this.isDescendant(supportRequestManagerFragment.getParentFragment())) {
                set.add(supportRequestManagerFragment);
            }
        }
        return Collections.unmodifiableSet((Set<?>)set);
    }
    
    ActivityFragmentLifecycle getLifecycle() {
        return this.lifecycle;
    }
    
    public RequestManager getRequestManager() {
        return this.requestManager;
    }
    
    public RequestManagerTreeNode getRequestManagerTreeNode() {
        return this.requestManagerTreeNode;
    }
    
    public void onAttach(final Activity activity) {
        super.onAttach(activity);
        this.rootRequestManagerFragment = RequestManagerRetriever.get().getSupportRequestManagerFragment(this.getActivity().getSupportFragmentManager());
        final SupportRequestManagerFragment rootRequestManagerFragment = this.rootRequestManagerFragment;
        if (rootRequestManagerFragment != this) {
            rootRequestManagerFragment.addChildRequestManagerFragment(this);
        }
    }
    
    public void onDestroy() {
        super.onDestroy();
        this.lifecycle.onDestroy();
    }
    
    public void onDetach() {
        super.onDetach();
        final SupportRequestManagerFragment rootRequestManagerFragment = this.rootRequestManagerFragment;
        if (rootRequestManagerFragment != null) {
            rootRequestManagerFragment.removeChildRequestManagerFragment(this);
            this.rootRequestManagerFragment = null;
        }
    }
    
    public void onLowMemory() {
        super.onLowMemory();
        final RequestManager requestManager = this.requestManager;
        if (requestManager != null) {
            requestManager.onLowMemory();
        }
    }
    
    public void onStart() {
        super.onStart();
        this.lifecycle.onStart();
    }
    
    public void onStop() {
        super.onStop();
        this.lifecycle.onStop();
    }
    
    public void setRequestManager(final RequestManager requestManager) {
        this.requestManager = requestManager;
    }
}
