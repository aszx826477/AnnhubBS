// 
// Decompiled by Procyon v0.5.30
// 

package com.bumptech.glide.manager;

import android.app.Activity;
import java.util.Iterator;
import android.os.Build$VERSION;
import java.util.Collections;
import java.util.Set;
import com.bumptech.glide.RequestManager;
import java.util.HashSet;
import android.app.Fragment;

public class RequestManagerFragment extends Fragment
{
    private final HashSet childRequestManagerFragments;
    private final ActivityFragmentLifecycle lifecycle;
    private RequestManager requestManager;
    private final RequestManagerTreeNode requestManagerTreeNode;
    private RequestManagerFragment rootRequestManagerFragment;
    
    public RequestManagerFragment() {
        this(new ActivityFragmentLifecycle());
    }
    
    RequestManagerFragment(final ActivityFragmentLifecycle lifecycle) {
        this.requestManagerTreeNode = new RequestManagerFragment$FragmentRequestManagerTreeNode(this, null);
        this.childRequestManagerFragments = new HashSet();
        this.lifecycle = lifecycle;
    }
    
    private void addChildRequestManagerFragment(final RequestManagerFragment requestManagerFragment) {
        this.childRequestManagerFragments.add(requestManagerFragment);
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
    
    private void removeChildRequestManagerFragment(final RequestManagerFragment requestManagerFragment) {
        this.childRequestManagerFragments.remove(requestManagerFragment);
    }
    
    public Set getDescendantRequestManagerFragments() {
        final RequestManagerFragment rootRequestManagerFragment = this.rootRequestManagerFragment;
        if (rootRequestManagerFragment == this) {
            return Collections.unmodifiableSet((Set<?>)this.childRequestManagerFragments);
        }
        if (rootRequestManagerFragment != null && Build$VERSION.SDK_INT >= 17) {
            final HashSet<RequestManagerFragment> set = new HashSet<RequestManagerFragment>();
            for (final RequestManagerFragment requestManagerFragment : this.rootRequestManagerFragment.getDescendantRequestManagerFragments()) {
                if (this.isDescendant(requestManagerFragment.getParentFragment())) {
                    set.add(requestManagerFragment);
                }
            }
            return Collections.unmodifiableSet((Set<?>)set);
        }
        return Collections.emptySet();
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
        this.rootRequestManagerFragment = RequestManagerRetriever.get().getRequestManagerFragment(this.getActivity().getFragmentManager());
        final RequestManagerFragment rootRequestManagerFragment = this.rootRequestManagerFragment;
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
        final RequestManagerFragment rootRequestManagerFragment = this.rootRequestManagerFragment;
        if (rootRequestManagerFragment != null) {
            rootRequestManagerFragment.removeChildRequestManagerFragment(this);
            this.rootRequestManagerFragment = null;
        }
    }
    
    public void onLowMemory() {
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
    
    public void onTrimMemory(final int n) {
        final RequestManager requestManager = this.requestManager;
        if (requestManager != null) {
            requestManager.onTrimMemory(n);
        }
    }
    
    public void setRequestManager(final RequestManager requestManager) {
        this.requestManager = requestManager;
    }
}
