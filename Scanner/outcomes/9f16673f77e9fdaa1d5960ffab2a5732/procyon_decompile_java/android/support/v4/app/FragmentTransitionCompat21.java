// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.app;

import android.transition.Transition$EpicenterCallback;
import android.transition.Transition$TransitionListener;
import java.util.Collection;
import android.graphics.Rect;
import java.util.Iterator;
import java.util.List;
import android.transition.TransitionManager;
import android.view.ViewGroup;
import android.transition.TransitionSet;
import java.util.ArrayList;
import android.transition.Transition;
import android.view.View;
import java.util.Map;

class FragmentTransitionCompat21
{
    public static void addTarget(final Object o, final View view) {
        if (o != null) {
            ((Transition)o).addTarget(view);
        }
    }
    
    public static void addTargets(final Object o, final ArrayList list) {
        final Transition transition = (Transition)o;
        if (transition == null) {
            return;
        }
        if (transition instanceof TransitionSet) {
            final TransitionSet set = (TransitionSet)transition;
            for (int transitionCount = set.getTransitionCount(), i = 0; i < transitionCount; ++i) {
                addTargets(set.getTransitionAt(i), list);
            }
        }
        else if (!hasSimpleTarget(transition)) {
            if (isNullOrEmpty(transition.getTargets())) {
                for (int size = list.size(), j = 0; j < size; ++j) {
                    transition.addTarget((View)list.get(j));
                }
            }
        }
    }
    
    public static void beginDelayedTransition(final ViewGroup viewGroup, final Object o) {
        TransitionManager.beginDelayedTransition(viewGroup, (Transition)o);
    }
    
    private static void bfsAddViewChildren(final List list, final View view) {
        final int size = list.size();
        if (containedBeforeIndex(list, view, size)) {
            return;
        }
        list.add(view);
        for (int i = size; i < list.size(); ++i) {
            final View view2 = list.get(i);
            if (view2 instanceof ViewGroup) {
                final ViewGroup viewGroup = (ViewGroup)view2;
                for (int childCount = viewGroup.getChildCount(), j = 0; j < childCount; ++j) {
                    final View child = viewGroup.getChildAt(j);
                    if (!containedBeforeIndex(list, child, size)) {
                        list.add(child);
                    }
                }
            }
        }
    }
    
    public static void captureTransitioningViews(final ArrayList list, final View view) {
        if (view.getVisibility() == 0) {
            if (view instanceof ViewGroup) {
                final ViewGroup viewGroup = (ViewGroup)view;
                if (viewGroup.isTransitionGroup()) {
                    list.add(viewGroup);
                }
                else {
                    for (int childCount = viewGroup.getChildCount(), i = 0; i < childCount; ++i) {
                        captureTransitioningViews(list, viewGroup.getChildAt(i));
                    }
                }
            }
            else {
                list.add(view);
            }
        }
    }
    
    public static Object cloneTransition(final Object o) {
        Object clone = null;
        if (o != null) {
            clone = ((Transition)o).clone();
        }
        return clone;
    }
    
    private static boolean containedBeforeIndex(final List list, final View view, final int n) {
        for (int i = 0; i < n; ++i) {
            if (list.get(i) == view) {
                return true;
            }
        }
        return false;
    }
    
    private static String findKeyForValue(final Map map, final String s) {
        for (final Map.Entry<K, Object> entry : map.entrySet()) {
            if (s.equals(entry.getValue())) {
                return (String)entry.getKey();
            }
        }
        return null;
    }
    
    public static void findNamedViews(final Map map, final View view) {
        if (view.getVisibility() == 0) {
            final String transitionName = view.getTransitionName();
            if (transitionName != null) {
                map.put(transitionName, view);
            }
            if (view instanceof ViewGroup) {
                final ViewGroup viewGroup = (ViewGroup)view;
                for (int childCount = viewGroup.getChildCount(), i = 0; i < childCount; ++i) {
                    findNamedViews(map, viewGroup.getChildAt(i));
                }
            }
        }
    }
    
    public static void getBoundsOnScreen(final View view, final Rect rect) {
        final int[] array = new int[2];
        view.getLocationOnScreen(array);
        final int n = array[0];
        final int n2 = 1;
        rect.set(n, array[n2], array[0] + view.getWidth(), array[n2] + view.getHeight());
    }
    
    private static boolean hasSimpleTarget(final Transition transition) {
        if (isNullOrEmpty(transition.getTargetIds())) {
            if (isNullOrEmpty(transition.getTargetNames())) {
                if (isNullOrEmpty(transition.getTargetTypes())) {
                    return false;
                }
            }
        }
        return true;
    }
    
    private static boolean isNullOrEmpty(final List list) {
        return list == null || list.isEmpty();
    }
    
    public static Object mergeTransitionsInSequence(final Object o, final Object o2, final Object o3) {
        Object setOrdering = null;
        final Transition transition = (Transition)o;
        final Transition transition2 = (Transition)o2;
        final Transition transition3 = (Transition)o3;
        if (transition != null && transition2 != null) {
            setOrdering = new TransitionSet().addTransition(transition).addTransition(transition2).setOrdering(1);
        }
        else if (transition != null) {
            setOrdering = transition;
        }
        else if (transition2 != null) {
            setOrdering = transition2;
        }
        if (transition3 != null) {
            final TransitionSet set = new TransitionSet();
            if (setOrdering != null) {
                set.addTransition((Transition)setOrdering);
            }
            set.addTransition(transition3);
            return set;
        }
        return setOrdering;
    }
    
    public static Object mergeTransitionsTogether(final Object o, final Object o2, final Object o3) {
        final TransitionSet set = new TransitionSet();
        if (o != null) {
            set.addTransition((Transition)o);
        }
        if (o2 != null) {
            set.addTransition((Transition)o2);
        }
        if (o3 != null) {
            set.addTransition((Transition)o3);
        }
        return set;
    }
    
    public static ArrayList prepareSetNameOverridesOptimized(final ArrayList list) {
        final ArrayList<String> list2 = new ArrayList<String>();
        for (int size = list.size(), i = 0; i < size; ++i) {
            final View view = list.get(i);
            list2.add(view.getTransitionName());
            view.setTransitionName((String)null);
        }
        return list2;
    }
    
    public static void removeTarget(final Object o, final View view) {
        if (o != null) {
            ((Transition)o).removeTarget(view);
        }
    }
    
    public static void replaceTargets(final Object o, final ArrayList list, final ArrayList list2) {
        final Transition transition = (Transition)o;
        if (transition instanceof TransitionSet) {
            final TransitionSet set = (TransitionSet)transition;
            for (int transitionCount = set.getTransitionCount(), i = 0; i < transitionCount; ++i) {
                replaceTargets(set.getTransitionAt(i), list, list2);
            }
        }
        else if (!hasSimpleTarget(transition)) {
            final List targets = transition.getTargets();
            if (targets != null && targets.size() == list.size()) {
                if (targets.containsAll(list)) {
                    int size;
                    if (list2 == null) {
                        size = 0;
                    }
                    else {
                        size = list2.size();
                    }
                    for (int j = 0; j < size; ++j) {
                        transition.addTarget((View)list2.get(j));
                    }
                    for (int k = list.size() - 1; k >= 0; --k) {
                        transition.removeTarget((View)list.get(k));
                    }
                }
            }
        }
    }
    
    public static void scheduleHideFragmentView(final Object o, final View view, final ArrayList list) {
        ((Transition)o).addListener((Transition$TransitionListener)new FragmentTransitionCompat21$2(view, list));
    }
    
    public static void scheduleNameReset(final ViewGroup viewGroup, final ArrayList list, final Map map) {
        OneShotPreDrawListener.add((View)viewGroup, new FragmentTransitionCompat21$7(list, map));
    }
    
    public static void scheduleRemoveTargets(final Object o, final Object o2, final ArrayList list, final Object o3, final ArrayList list2, final Object o4, final ArrayList list3) {
        ((Transition)o).addListener((Transition$TransitionListener)new FragmentTransitionCompat21$5(o2, list, o3, list2, o4, list3));
    }
    
    public static void setEpicenter(final Object o, final Rect rect) {
        if (o != null) {
            ((Transition)o).setEpicenterCallback((Transition$EpicenterCallback)new FragmentTransitionCompat21$6(rect));
        }
    }
    
    public static void setEpicenter(final Object o, final View view) {
        if (view != null) {
            final Transition transition = (Transition)o;
            final Rect rect = new Rect();
            getBoundsOnScreen(view, rect);
            transition.setEpicenterCallback((Transition$EpicenterCallback)new FragmentTransitionCompat21$1(rect));
        }
    }
    
    public static void setNameOverridesOptimized(final View view, final ArrayList list, final ArrayList list2, final ArrayList list3, final Map map) {
        final int size = list2.size();
        final ArrayList<String> list4 = new ArrayList<String>();
        for (int i = 0; i < size; ++i) {
            final View view2 = list.get(i);
            final String transitionName = view2.getTransitionName();
            list4.add(transitionName);
            if (transitionName != null) {
                view2.setTransitionName((String)null);
                final String s = map.get(transitionName);
                for (int j = 0; j < size; ++j) {
                    if (s.equals(list3.get(j))) {
                        list2.get(j).setTransitionName(transitionName);
                        break;
                    }
                }
            }
        }
        OneShotPreDrawListener.add(view, new FragmentTransitionCompat21$3(size, list2, list3, list, list4));
    }
    
    public static void setNameOverridesUnoptimized(final View view, final ArrayList list, final Map map) {
        OneShotPreDrawListener.add(view, new FragmentTransitionCompat21$4(list, map));
    }
    
    public static void setSharedElementTargets(final Object o, final View view, final ArrayList list) {
        final TransitionSet set = (TransitionSet)o;
        final List targets = set.getTargets();
        targets.clear();
        for (int size = list.size(), i = 0; i < size; ++i) {
            bfsAddViewChildren(targets, list.get(i));
        }
        targets.add(view);
        list.add(view);
        addTargets(set, list);
    }
    
    public static void swapSharedElementTargets(final Object o, final ArrayList list, final ArrayList list2) {
        final TransitionSet set = (TransitionSet)o;
        if (set != null) {
            set.getTargets().clear();
            set.getTargets().addAll(list2);
            replaceTargets(set, list, list2);
        }
    }
    
    public static Object wrapTransitionInSet(final Object o) {
        if (o == null) {
            return null;
        }
        final TransitionSet set = new TransitionSet();
        set.addTransition((Transition)o);
        return set;
    }
}
