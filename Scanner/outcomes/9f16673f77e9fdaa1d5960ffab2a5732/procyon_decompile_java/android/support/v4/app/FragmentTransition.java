// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.app;

import android.os.Build$VERSION;
import android.graphics.Rect;
import android.view.ViewGroup;
import java.util.Map;
import java.util.List;
import android.util.SparseArray;
import android.support.v4.view.ViewCompat;
import java.util.Collection;
import android.support.v4.util.ArrayMap;
import android.view.View;
import java.util.ArrayList;

class FragmentTransition
{
    private static final int[] INVERSE_OPS;
    
    static {
        final int[] array;
        final int[] inverse_OPS = array = new int[8];
        array[0] = 0;
        array[1] = 3;
        array[2] = 0;
        array[3] = 1;
        array[array[4] = 5] = 4;
        array[array[6] = 7] = 6;
        INVERSE_OPS = inverse_OPS;
    }
    
    private static void addSharedElementsWithMatchingNames(final ArrayList list, final ArrayMap arrayMap, final Collection collection) {
        for (int i = arrayMap.size() - 1; i >= 0; --i) {
            final View view = (View)arrayMap.valueAt(i);
            if (collection.contains(ViewCompat.getTransitionName(view))) {
                list.add(view);
            }
        }
    }
    
    private static void addToFirstInLastOut(final BackStackRecord backStackRecord, final BackStackRecord$Op backStackRecord$Op, final SparseArray sparseArray, final boolean b, final boolean b2) {
        final Fragment fragment = backStackRecord$Op.fragment;
        final int mContainerId = fragment.mContainerId;
        if (mContainerId == 0) {
            return;
        }
        int cmd;
        if (b) {
            cmd = FragmentTransition.INVERSE_OPS[backStackRecord$Op.cmd];
        }
        else {
            cmd = backStackRecord$Op.cmd;
        }
        final int n = cmd;
        int n2 = 0;
        final int n3 = 1;
        int n4 = 0;
        boolean b3 = false;
        int n5 = 0;
        boolean b4 = false;
        Label_0582: {
            if (n != n3) {
                switch (n) {
                    default: {
                        n4 = 0;
                        b3 = false;
                        n5 = 0;
                        b4 = false;
                        break Label_0582;
                    }
                    case 5: {
                        int mHidden;
                        if (b2) {
                            if (fragment.mHiddenChanged && !fragment.mHidden && fragment.mAdded) {
                                n2 = 1;
                            }
                            mHidden = n2;
                        }
                        else {
                            mHidden = (fragment.mHidden ? 1 : 0);
                        }
                        final boolean b5 = true;
                        n4 = mHidden;
                        b3 = false;
                        n5 = 0;
                        b4 = b5;
                        break Label_0582;
                    }
                    case 4: {
                        int n6;
                        if (b2) {
                            if (fragment.mHiddenChanged && fragment.mAdded && fragment.mHidden) {
                                n2 = 1;
                            }
                            n6 = n2;
                        }
                        else {
                            if (fragment.mAdded && !fragment.mHidden) {
                                n2 = 1;
                            }
                            n6 = n2;
                        }
                        final boolean b6 = true;
                        n4 = 0;
                        b3 = b6;
                        n5 = n6;
                        b4 = false;
                        break Label_0582;
                    }
                    case 3:
                    case 6: {
                        int n7;
                        if (b2) {
                            if (!fragment.mAdded && fragment.mView != null) {
                                if (fragment.mView.getVisibility() == 0 && fragment.mPostponedAlpha >= 0.0f) {
                                    n2 = 1;
                                }
                            }
                            n7 = n2;
                        }
                        else {
                            if (fragment.mAdded && !fragment.mHidden) {
                                n2 = 1;
                            }
                            n7 = n2;
                        }
                        final boolean b7 = true;
                        n4 = 0;
                        b3 = b7;
                        n5 = n7;
                        b4 = false;
                        break Label_0582;
                    }
                    case 7: {
                        break;
                    }
                }
            }
            int mIsNewlyAdded;
            if (b2) {
                mIsNewlyAdded = (fragment.mIsNewlyAdded ? 1 : 0);
            }
            else {
                if (!fragment.mAdded && !fragment.mHidden) {
                    n2 = 1;
                }
                mIsNewlyAdded = n2;
            }
            final boolean b8 = true;
            n4 = mIsNewlyAdded;
            b3 = false;
            n5 = 0;
            b4 = b8;
        }
        final FragmentTransition$FragmentContainerTransition fragmentTransition$FragmentContainerTransition = (FragmentTransition$FragmentContainerTransition)sparseArray.get(mContainerId);
        FragmentTransition$FragmentContainerTransition fragmentTransition$FragmentContainerTransition2;
        if (n4 != 0) {
            final FragmentTransition$FragmentContainerTransition ensureContainer = ensureContainer(fragmentTransition$FragmentContainerTransition, sparseArray, mContainerId);
            ensureContainer.lastIn = fragment;
            ensureContainer.lastInIsPop = b;
            ensureContainer.lastInTransaction = backStackRecord;
            fragmentTransition$FragmentContainerTransition2 = ensureContainer;
        }
        else {
            fragmentTransition$FragmentContainerTransition2 = fragmentTransition$FragmentContainerTransition;
        }
        FragmentTransition$FragmentContainerTransition fragmentTransition$FragmentContainerTransition3;
        if (!b2 && b4) {
            if (fragmentTransition$FragmentContainerTransition2 != null && fragmentTransition$FragmentContainerTransition2.firstOut == fragment) {
                fragmentTransition$FragmentContainerTransition2.firstOut = null;
            }
            final FragmentManagerImpl mManager = backStackRecord.mManager;
            if (fragment.mState < n3 && mManager.mCurState >= n3 && !backStackRecord.mAllowOptimization) {
                mManager.makeActive(fragment);
                final int n8 = 1;
                fragmentTransition$FragmentContainerTransition3 = fragmentTransition$FragmentContainerTransition2;
                mManager.moveToState(fragment, n8, 0, 0, false);
            }
            else {
                fragmentTransition$FragmentContainerTransition3 = fragmentTransition$FragmentContainerTransition2;
            }
        }
        else {
            fragmentTransition$FragmentContainerTransition3 = fragmentTransition$FragmentContainerTransition2;
        }
        FragmentTransition$FragmentContainerTransition fragmentTransition$FragmentContainerTransition4;
        if (n5 != 0) {
            if ((fragmentTransition$FragmentContainerTransition4 = fragmentTransition$FragmentContainerTransition3) == null || fragmentTransition$FragmentContainerTransition3.firstOut == null) {
                final FragmentTransition$FragmentContainerTransition ensureContainer2 = ensureContainer(fragmentTransition$FragmentContainerTransition4, sparseArray, mContainerId);
                ensureContainer2.firstOut = fragment;
                ensureContainer2.firstOutIsPop = b;
                ensureContainer2.firstOutTransaction = backStackRecord;
                fragmentTransition$FragmentContainerTransition4 = ensureContainer2;
            }
        }
        else {
            fragmentTransition$FragmentContainerTransition4 = fragmentTransition$FragmentContainerTransition3;
        }
        if (!b2 && b3 && fragmentTransition$FragmentContainerTransition4 != null && fragmentTransition$FragmentContainerTransition4.lastIn == fragment) {
            fragmentTransition$FragmentContainerTransition4.lastIn = null;
        }
    }
    
    public static void calculateFragments(final BackStackRecord backStackRecord, final SparseArray sparseArray, final boolean b) {
        for (int size = backStackRecord.mOps.size(), i = 0; i < size; ++i) {
            addToFirstInLastOut(backStackRecord, (BackStackRecord$Op)backStackRecord.mOps.get(i), sparseArray, false, b);
        }
    }
    
    private static ArrayMap calculateNameOverrides(final int n, final ArrayList list, final ArrayList list2, final int n2, final int n3) {
        final ArrayMap arrayMap = new ArrayMap();
        for (int i = n3 - 1; i >= n2; --i) {
            final BackStackRecord backStackRecord = list.get(i);
            if (backStackRecord.interactsWith(n)) {
                final boolean booleanValue = list2.get(i);
                if (backStackRecord.mSharedElementSourceNames != null) {
                    final int size = backStackRecord.mSharedElementSourceNames.size();
                    ArrayList list3;
                    ArrayList list4;
                    if (booleanValue) {
                        list3 = backStackRecord.mSharedElementSourceNames;
                        list4 = backStackRecord.mSharedElementTargetNames;
                    }
                    else {
                        list4 = backStackRecord.mSharedElementSourceNames;
                        list3 = backStackRecord.mSharedElementTargetNames;
                    }
                    for (int j = 0; j < size; ++j) {
                        final String s = list4.get(j);
                        final String s2 = list3.get(j);
                        final String s3 = (String)arrayMap.remove(s2);
                        if (s3 != null) {
                            arrayMap.put(s, s3);
                        }
                        else {
                            arrayMap.put(s, s2);
                        }
                    }
                }
            }
        }
        return arrayMap;
    }
    
    public static void calculatePopFragments(final BackStackRecord backStackRecord, final SparseArray sparseArray, final boolean b) {
        if (!backStackRecord.mManager.mContainer.onHasView()) {
            return;
        }
        for (int i = backStackRecord.mOps.size() - 1; i >= 0; --i) {
            addToFirstInLastOut(backStackRecord, (BackStackRecord$Op)backStackRecord.mOps.get(i), sparseArray, true, b);
        }
    }
    
    private static void callSharedElementStartEnd(final Fragment fragment, final Fragment fragment2, final boolean b, final ArrayMap arrayMap, final boolean b2) {
        SharedElementCallback sharedElementCallback;
        if (b) {
            sharedElementCallback = fragment2.getEnterTransitionCallback();
        }
        else {
            sharedElementCallback = fragment.getEnterTransitionCallback();
        }
        if (sharedElementCallback != null) {
            final ArrayList<Object> list = new ArrayList<Object>();
            final ArrayList<Object> list2 = new ArrayList<Object>();
            int size;
            if (arrayMap == null) {
                size = 0;
            }
            else {
                size = arrayMap.size();
            }
            for (int i = 0; i < size; ++i) {
                list2.add(arrayMap.keyAt(i));
                list.add(arrayMap.valueAt(i));
            }
            if (b2) {
                sharedElementCallback.onSharedElementStart(list2, list, null);
            }
            else {
                sharedElementCallback.onSharedElementEnd(list2, list, null);
            }
        }
    }
    
    private static ArrayMap captureInSharedElements(final ArrayMap arrayMap, final Object o, final FragmentTransition$FragmentContainerTransition fragmentTransition$FragmentContainerTransition) {
        final Fragment lastIn = fragmentTransition$FragmentContainerTransition.lastIn;
        final View view = lastIn.getView();
        if (!arrayMap.isEmpty() && o != null && view != null) {
            final ArrayMap arrayMap2 = new ArrayMap();
            FragmentTransitionCompat21.findNamedViews(arrayMap2, view);
            final BackStackRecord lastInTransaction = fragmentTransition$FragmentContainerTransition.lastInTransaction;
            SharedElementCallback sharedElementCallback;
            ArrayList list;
            if (fragmentTransition$FragmentContainerTransition.lastInIsPop) {
                sharedElementCallback = lastIn.getExitTransitionCallback();
                list = lastInTransaction.mSharedElementSourceNames;
            }
            else {
                sharedElementCallback = lastIn.getEnterTransitionCallback();
                list = lastInTransaction.mSharedElementTargetNames;
            }
            if (list != null) {
                arrayMap2.retainAll(list);
            }
            if (sharedElementCallback != null) {
                sharedElementCallback.onMapSharedElements(list, arrayMap2);
                for (int i = list.size() - 1; i >= 0; --i) {
                    final String s = list.get(i);
                    final View view2 = (View)arrayMap2.get(s);
                    if (view2 == null) {
                        final String keyForValue = findKeyForValue(arrayMap, s);
                        if (keyForValue != null) {
                            arrayMap.remove(keyForValue);
                        }
                    }
                    else if (!s.equals(ViewCompat.getTransitionName(view2))) {
                        final String keyForValue2 = findKeyForValue(arrayMap, s);
                        if (keyForValue2 != null) {
                            arrayMap.put(keyForValue2, ViewCompat.getTransitionName(view2));
                        }
                    }
                }
            }
            else {
                retainValues(arrayMap, arrayMap2);
            }
            return arrayMap2;
        }
        arrayMap.clear();
        return null;
    }
    
    private static ArrayMap captureOutSharedElements(final ArrayMap arrayMap, final Object o, final FragmentTransition$FragmentContainerTransition fragmentTransition$FragmentContainerTransition) {
        if (!arrayMap.isEmpty() && o != null) {
            final Fragment firstOut = fragmentTransition$FragmentContainerTransition.firstOut;
            final ArrayMap arrayMap2 = new ArrayMap();
            FragmentTransitionCompat21.findNamedViews(arrayMap2, firstOut.getView());
            final BackStackRecord firstOutTransaction = fragmentTransition$FragmentContainerTransition.firstOutTransaction;
            SharedElementCallback sharedElementCallback;
            ArrayList list;
            if (fragmentTransition$FragmentContainerTransition.firstOutIsPop) {
                sharedElementCallback = firstOut.getEnterTransitionCallback();
                list = firstOutTransaction.mSharedElementTargetNames;
            }
            else {
                sharedElementCallback = firstOut.getExitTransitionCallback();
                list = firstOutTransaction.mSharedElementSourceNames;
            }
            arrayMap2.retainAll(list);
            if (sharedElementCallback != null) {
                sharedElementCallback.onMapSharedElements(list, arrayMap2);
                for (int i = list.size() - 1; i >= 0; --i) {
                    final String s = list.get(i);
                    final View view = (View)arrayMap2.get(s);
                    if (view == null) {
                        arrayMap.remove(s);
                    }
                    else if (!s.equals(ViewCompat.getTransitionName(view))) {
                        arrayMap.put(ViewCompat.getTransitionName(view), arrayMap.remove(s));
                    }
                }
            }
            else {
                arrayMap.retainAll(arrayMap2.keySet());
            }
            return arrayMap2;
        }
        arrayMap.clear();
        return null;
    }
    
    private static ArrayList configureEnteringExitingViews(final Object o, final Fragment fragment, final ArrayList list, final View view) {
        ArrayList<View> list2 = null;
        if (o != null) {
            list2 = new ArrayList<View>();
            final View view2 = fragment.getView();
            if (view2 != null) {
                FragmentTransitionCompat21.captureTransitioningViews(list2, view2);
            }
            if (list != null) {
                list2.removeAll(list);
            }
            if (!list2.isEmpty()) {
                list2.add(view);
                FragmentTransitionCompat21.addTargets(o, list2);
            }
        }
        return list2;
    }
    
    private static Object configureSharedElementsOptimized(final ViewGroup viewGroup, final View view, final ArrayMap arrayMap, final FragmentTransition$FragmentContainerTransition fragmentTransition$FragmentContainerTransition, final ArrayList list, final ArrayList list2, final Object o, final Object o2) {
        final Fragment lastIn = fragmentTransition$FragmentContainerTransition.lastIn;
        final Fragment firstOut = fragmentTransition$FragmentContainerTransition.firstOut;
        if (lastIn != null) {
            lastIn.getView().setVisibility(0);
        }
        if (lastIn != null) {
            if (firstOut != null) {
                final boolean lastInIsPop = fragmentTransition$FragmentContainerTransition.lastInIsPop;
                Object sharedElementTransition;
                if (arrayMap.isEmpty()) {
                    sharedElementTransition = null;
                }
                else {
                    sharedElementTransition = getSharedElementTransition(lastIn, firstOut, lastInIsPop);
                }
                final ArrayMap captureOutSharedElements = captureOutSharedElements(arrayMap, sharedElementTransition, fragmentTransition$FragmentContainerTransition);
                final ArrayMap captureInSharedElements = captureInSharedElements(arrayMap, sharedElementTransition, fragmentTransition$FragmentContainerTransition);
                Object o3;
                if (arrayMap.isEmpty()) {
                    if (captureOutSharedElements != null) {
                        captureOutSharedElements.clear();
                    }
                    if (captureInSharedElements != null) {
                        captureInSharedElements.clear();
                    }
                    o3 = null;
                }
                else {
                    addSharedElementsWithMatchingNames(list, captureOutSharedElements, arrayMap.keySet());
                    addSharedElementsWithMatchingNames(list2, captureInSharedElements, arrayMap.values());
                    o3 = sharedElementTransition;
                }
                if (o == null && o2 == null && o3 == null) {
                    return null;
                }
                callSharedElementStartEnd(lastIn, firstOut, lastInIsPop, captureOutSharedElements, true);
                View inEpicenterView;
                Rect rect2;
                if (o3 != null) {
                    list2.add(view);
                    FragmentTransitionCompat21.setSharedElementTargets(o3, view, list);
                    setOutEpicenter(o3, o2, captureOutSharedElements, fragmentTransition$FragmentContainerTransition.firstOutIsPop, fragmentTransition$FragmentContainerTransition.firstOutTransaction);
                    final Rect rect = new Rect();
                    inEpicenterView = getInEpicenterView(captureInSharedElements, fragmentTransition$FragmentContainerTransition, o, lastInIsPop);
                    if (inEpicenterView != null) {
                        FragmentTransitionCompat21.setEpicenter(o, rect);
                    }
                    rect2 = rect;
                }
                else {
                    rect2 = null;
                    inEpicenterView = null;
                }
                OneShotPreDrawListener.add((View)viewGroup, new FragmentTransition$3(lastIn, firstOut, lastInIsPop, captureInSharedElements, inEpicenterView, rect2));
                return o3;
            }
        }
        return null;
    }
    
    private static Object configureSharedElementsUnoptimized(final ViewGroup viewGroup, final View view, final ArrayMap arrayMap, final FragmentTransition$FragmentContainerTransition fragmentTransition$FragmentContainerTransition, final ArrayList list, final ArrayList list2, final Object o, final Object o2) {
        final Fragment lastIn = fragmentTransition$FragmentContainerTransition.lastIn;
        final Fragment firstOut = fragmentTransition$FragmentContainerTransition.firstOut;
        if (lastIn != null) {
            if (firstOut != null) {
                final boolean lastInIsPop = fragmentTransition$FragmentContainerTransition.lastInIsPop;
                Object sharedElementTransition;
                if (arrayMap.isEmpty()) {
                    sharedElementTransition = null;
                }
                else {
                    sharedElementTransition = getSharedElementTransition(lastIn, firstOut, lastInIsPop);
                }
                final ArrayMap captureOutSharedElements = captureOutSharedElements(arrayMap, sharedElementTransition, fragmentTransition$FragmentContainerTransition);
                Object o3;
                if (arrayMap.isEmpty()) {
                    o3 = null;
                }
                else {
                    list.addAll(captureOutSharedElements.values());
                    o3 = sharedElementTransition;
                }
                if (o == null && o2 == null && o3 == null) {
                    return null;
                }
                callSharedElementStartEnd(lastIn, firstOut, lastInIsPop, captureOutSharedElements, true);
                Rect rect2;
                if (o3 != null) {
                    final Rect rect = new Rect();
                    FragmentTransitionCompat21.setSharedElementTargets(o3, view, list);
                    setOutEpicenter(o3, o2, captureOutSharedElements, fragmentTransition$FragmentContainerTransition.firstOutIsPop, fragmentTransition$FragmentContainerTransition.firstOutTransaction);
                    if (o != null) {
                        FragmentTransitionCompat21.setEpicenter(o, rect);
                    }
                    rect2 = rect;
                }
                else {
                    rect2 = null;
                }
                final Object o4 = o3;
                OneShotPreDrawListener.add((View)viewGroup, new FragmentTransition$4(arrayMap, o4, fragmentTransition$FragmentContainerTransition, list2, view, lastIn, firstOut, lastInIsPop, list, o, rect2));
                return o4;
            }
        }
        return null;
    }
    
    private static void configureTransitionsOptimized(final FragmentManagerImpl fragmentManagerImpl, final int n, final FragmentTransition$FragmentContainerTransition fragmentTransition$FragmentContainerTransition, final View view, final ArrayMap arrayMap) {
        ViewGroup viewGroup;
        if (fragmentManagerImpl.mContainer.onHasView()) {
            viewGroup = (ViewGroup)fragmentManagerImpl.mContainer.onFindViewById(n);
        }
        else {
            viewGroup = null;
        }
        if (viewGroup == null) {
            return;
        }
        final Fragment lastIn = fragmentTransition$FragmentContainerTransition.lastIn;
        final Fragment firstOut = fragmentTransition$FragmentContainerTransition.firstOut;
        final boolean lastInIsPop = fragmentTransition$FragmentContainerTransition.lastInIsPop;
        final boolean firstOutIsPop = fragmentTransition$FragmentContainerTransition.firstOutIsPop;
        final ArrayList list = new ArrayList();
        final ArrayList list2 = new ArrayList();
        final Object enterTransition = getEnterTransition(lastIn, lastInIsPop);
        final Object exitTransition = getExitTransition(firstOut, firstOutIsPop);
        final Object o = enterTransition;
        final ArrayList list3 = list2;
        final ArrayList list4 = list2;
        final ArrayList list5 = list;
        final ArrayList list6 = list;
        final Object configureSharedElementsOptimized = configureSharedElementsOptimized(viewGroup, view, arrayMap, fragmentTransition$FragmentContainerTransition, list3, list5, o, exitTransition);
        final Object o2 = o;
        Object o3;
        if (o == null && configureSharedElementsOptimized == null) {
            if ((o3 = exitTransition) == null) {
                return;
            }
        }
        else {
            o3 = exitTransition;
        }
        final ArrayList configureEnteringExitingViews = configureEnteringExitingViews(o3, firstOut, list4, view);
        final ArrayList configureEnteringExitingViews2 = configureEnteringExitingViews(o2, lastIn, list6, view);
        setViewVisibility(configureEnteringExitingViews2, 4);
        final Object mergeTransitions = mergeTransitions(o2, o3, configureSharedElementsOptimized, lastIn, lastInIsPop);
        if (mergeTransitions != null) {
            replaceHide(o3, firstOut, configureEnteringExitingViews);
            final ArrayList prepareSetNameOverridesOptimized = FragmentTransitionCompat21.prepareSetNameOverridesOptimized(list6);
            FragmentTransitionCompat21.scheduleRemoveTargets(mergeTransitions, o2, configureEnteringExitingViews2, o3, configureEnteringExitingViews, configureSharedElementsOptimized, list6);
            FragmentTransitionCompat21.beginDelayedTransition(viewGroup, mergeTransitions);
            FragmentTransitionCompat21.setNameOverridesOptimized((View)viewGroup, list4, list6, prepareSetNameOverridesOptimized, arrayMap);
            setViewVisibility(configureEnteringExitingViews2, 0);
            FragmentTransitionCompat21.swapSharedElementTargets(configureSharedElementsOptimized, list4, list6);
        }
    }
    
    private static void configureTransitionsUnoptimized(final FragmentManagerImpl fragmentManagerImpl, final int n, final FragmentTransition$FragmentContainerTransition fragmentTransition$FragmentContainerTransition, final View view, final ArrayMap arrayMap) {
        ViewGroup viewGroup;
        if (fragmentManagerImpl.mContainer.onHasView()) {
            viewGroup = (ViewGroup)fragmentManagerImpl.mContainer.onFindViewById(n);
        }
        else {
            viewGroup = null;
        }
        if (viewGroup == null) {
            return;
        }
        final Fragment lastIn = fragmentTransition$FragmentContainerTransition.lastIn;
        final Fragment firstOut = fragmentTransition$FragmentContainerTransition.firstOut;
        final boolean lastInIsPop = fragmentTransition$FragmentContainerTransition.lastInIsPop;
        final boolean firstOutIsPop = fragmentTransition$FragmentContainerTransition.firstOutIsPop;
        final Object enterTransition = getEnterTransition(lastIn, lastInIsPop);
        final Object exitTransition = getExitTransition(firstOut, firstOutIsPop);
        final ArrayList list = new ArrayList();
        final ArrayList list2 = new ArrayList();
        final ArrayList list3 = list;
        final Object o = exitTransition;
        final Object o3;
        final Object o2 = o3 = enterTransition;
        final Object configureSharedElementsUnoptimized = configureSharedElementsUnoptimized(viewGroup, view, arrayMap, fragmentTransition$FragmentContainerTransition, list3, list2, o2, o);
        Object o4;
        if (o2 == null && configureSharedElementsUnoptimized == null) {
            if ((o4 = o) == null) {
                return;
            }
        }
        else {
            o4 = o;
        }
        final ArrayList configureEnteringExitingViews = configureEnteringExitingViews(o4, firstOut, list3, view);
        Object o5;
        if (configureEnteringExitingViews != null && !configureEnteringExitingViews.isEmpty()) {
            o5 = o4;
        }
        else {
            o5 = null;
        }
        FragmentTransitionCompat21.addTarget(o3, view);
        final Object mergeTransitions = mergeTransitions(o3, o5, configureSharedElementsUnoptimized, lastIn, fragmentTransition$FragmentContainerTransition.lastInIsPop);
        if (mergeTransitions != null) {
            final ArrayList list4 = new ArrayList();
            FragmentTransitionCompat21.scheduleRemoveTargets(mergeTransitions, o3, list4, o5, configureEnteringExitingViews, configureSharedElementsUnoptimized, list2);
            final Object o6 = mergeTransitions;
            scheduleTargetChange(viewGroup, lastIn, view, list2, o3, list4, o5, configureEnteringExitingViews);
            FragmentTransitionCompat21.setNameOverridesUnoptimized((View)viewGroup, list2, arrayMap);
            FragmentTransitionCompat21.beginDelayedTransition(viewGroup, o6);
            FragmentTransitionCompat21.scheduleNameReset(viewGroup, list2, arrayMap);
        }
    }
    
    private static FragmentTransition$FragmentContainerTransition ensureContainer(FragmentTransition$FragmentContainerTransition fragmentTransition$FragmentContainerTransition, final SparseArray sparseArray, final int n) {
        if (fragmentTransition$FragmentContainerTransition == null) {
            sparseArray.put(n, (Object)(fragmentTransition$FragmentContainerTransition = new FragmentTransition$FragmentContainerTransition()));
        }
        return fragmentTransition$FragmentContainerTransition;
    }
    
    private static String findKeyForValue(final ArrayMap arrayMap, final String s) {
        for (int size = arrayMap.size(), i = 0; i < size; ++i) {
            if (s.equals(arrayMap.valueAt(i))) {
                return (String)arrayMap.keyAt(i);
            }
        }
        return null;
    }
    
    private static Object getEnterTransition(final Fragment fragment, final boolean b) {
        if (fragment == null) {
            return null;
        }
        Object o;
        if (b) {
            o = fragment.getReenterTransition();
        }
        else {
            o = fragment.getEnterTransition();
        }
        return FragmentTransitionCompat21.cloneTransition(o);
    }
    
    private static Object getExitTransition(final Fragment fragment, final boolean b) {
        if (fragment == null) {
            return null;
        }
        Object o;
        if (b) {
            o = fragment.getReturnTransition();
        }
        else {
            o = fragment.getExitTransition();
        }
        return FragmentTransitionCompat21.cloneTransition(o);
    }
    
    private static View getInEpicenterView(final ArrayMap arrayMap, final FragmentTransition$FragmentContainerTransition fragmentTransition$FragmentContainerTransition, final Object o, final boolean b) {
        final BackStackRecord lastInTransaction = fragmentTransition$FragmentContainerTransition.lastInTransaction;
        if (o != null && arrayMap != null && lastInTransaction.mSharedElementSourceNames != null && !lastInTransaction.mSharedElementSourceNames.isEmpty()) {
            String s;
            if (b) {
                s = lastInTransaction.mSharedElementSourceNames.get(0);
            }
            else {
                s = lastInTransaction.mSharedElementTargetNames.get(0);
            }
            return (View)arrayMap.get(s);
        }
        return null;
    }
    
    private static Object getSharedElementTransition(final Fragment fragment, final Fragment fragment2, final boolean b) {
        if (fragment != null && fragment2 != null) {
            Object o;
            if (b) {
                o = fragment2.getSharedElementReturnTransition();
            }
            else {
                o = fragment.getSharedElementEnterTransition();
            }
            return FragmentTransitionCompat21.wrapTransitionInSet(FragmentTransitionCompat21.cloneTransition(o));
        }
        return null;
    }
    
    private static Object mergeTransitions(final Object o, final Object o2, final Object o3, final Fragment fragment, final boolean b) {
        int n = 1;
        if (o != null && o2 != null && fragment != null) {
            boolean b2;
            if (b) {
                b2 = fragment.getAllowReturnTransitionOverlap();
            }
            else {
                b2 = fragment.getAllowEnterTransitionOverlap();
            }
            n = (b2 ? 1 : 0);
        }
        Object o4;
        if (n != 0) {
            o4 = FragmentTransitionCompat21.mergeTransitionsTogether(o2, o, o3);
        }
        else {
            o4 = FragmentTransitionCompat21.mergeTransitionsInSequence(o2, o, o3);
        }
        return o4;
    }
    
    private static void replaceHide(final Object o, final Fragment fragment, final ArrayList list) {
        if (fragment != null && o != null && fragment.mAdded && fragment.mHidden && fragment.mHiddenChanged) {
            fragment.setHideReplaced(true);
            FragmentTransitionCompat21.scheduleHideFragmentView(o, fragment.getView(), list);
            OneShotPreDrawListener.add((View)fragment.mContainer, new FragmentTransition$1(list));
        }
    }
    
    private static void retainValues(final ArrayMap arrayMap, final ArrayMap arrayMap2) {
        for (int i = arrayMap.size() - 1; i >= 0; --i) {
            if (!arrayMap2.containsKey(arrayMap.valueAt(i))) {
                arrayMap.removeAt(i);
            }
        }
    }
    
    private static void scheduleTargetChange(final ViewGroup viewGroup, final Fragment fragment, final View view, final ArrayList list, final Object o, final ArrayList list2, final Object o2, final ArrayList list3) {
        OneShotPreDrawListener.add((View)viewGroup, new FragmentTransition$2(o, view, fragment, list, list2, list3, o2));
    }
    
    private static void setOutEpicenter(final Object o, final Object o2, final ArrayMap arrayMap, final boolean b, final BackStackRecord backStackRecord) {
        if (backStackRecord.mSharedElementSourceNames != null) {
            if (!backStackRecord.mSharedElementSourceNames.isEmpty()) {
                String s;
                if (b) {
                    s = backStackRecord.mSharedElementTargetNames.get(0);
                }
                else {
                    s = backStackRecord.mSharedElementSourceNames.get(0);
                }
                final View view = (View)arrayMap.get(s);
                FragmentTransitionCompat21.setEpicenter(o, view);
                if (o2 != null) {
                    FragmentTransitionCompat21.setEpicenter(o2, view);
                }
            }
        }
    }
    
    private static void setViewVisibility(final ArrayList list, final int visibility) {
        if (list == null) {
            return;
        }
        for (int i = list.size() - 1; i >= 0; --i) {
            list.get(i).setVisibility(visibility);
        }
    }
    
    static void startTransitions(final FragmentManagerImpl fragmentManagerImpl, final ArrayList list, final ArrayList list2, final int n, final int n2, final boolean b) {
        if (fragmentManagerImpl.mCurState >= 1 && Build$VERSION.SDK_INT >= 21) {
            final SparseArray sparseArray = new SparseArray();
            for (int i = n; i < n2; ++i) {
                final BackStackRecord backStackRecord = list.get(i);
                if (list2.get(i)) {
                    calculatePopFragments(backStackRecord, sparseArray, b);
                }
                else {
                    calculateFragments(backStackRecord, sparseArray, b);
                }
            }
            if (sparseArray.size() != 0) {
                final View view = new View(fragmentManagerImpl.mHost.getContext());
                for (int size = sparseArray.size(), j = 0; j < size; ++j) {
                    final int key = sparseArray.keyAt(j);
                    final ArrayMap calculateNameOverrides = calculateNameOverrides(key, list, list2, n, n2);
                    final FragmentTransition$FragmentContainerTransition fragmentTransition$FragmentContainerTransition = (FragmentTransition$FragmentContainerTransition)sparseArray.valueAt(j);
                    if (b) {
                        configureTransitionsOptimized(fragmentManagerImpl, key, fragmentTransition$FragmentContainerTransition, view, calculateNameOverrides);
                    }
                    else {
                        configureTransitionsUnoptimized(fragmentManagerImpl, key, fragmentTransition$FragmentContainerTransition, view, calculateNameOverrides);
                    }
                }
            }
        }
    }
}
