// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.widget;

import java.util.Comparator;
import java.util.List;
import java.util.Collections;
import java.util.ArrayList;
import android.graphics.Rect;

class FocusStrategy
{
    private static boolean beamBeats(final int n, final Rect rect, final Rect rect2, final Rect rect3) {
        final boolean beamsOverlap = beamsOverlap(n, rect, rect2);
        final boolean beamsOverlap2 = beamsOverlap(n, rect, rect3);
        boolean b = false;
        if (beamsOverlap2 || !beamsOverlap) {
            return false;
        }
        final boolean toDirection = isToDirectionOf(n, rect, rect3);
        final boolean b2 = true;
        if (!toDirection) {
            return b2;
        }
        if (n != 17 && n != 66) {
            if (majorAxisDistance(n, rect, rect2) < majorAxisDistanceToFarEdge(n, rect, rect3)) {
                b = true;
            }
            return b;
        }
        return b2;
    }
    
    private static boolean beamsOverlap(final int n, final Rect rect, final Rect rect2) {
        final int n2 = 17;
        boolean b = true;
        Label_0097: {
            if (n != n2) {
                if (n != 33) {
                    if (n == 66) {
                        break Label_0097;
                    }
                    if (n != 130) {
                        throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                    }
                }
                if (rect2.right < rect.left || rect2.left > rect.right) {
                    b = false;
                }
                return b;
            }
        }
        if (rect2.bottom < rect.top || rect2.top > rect.bottom) {
            b = false;
        }
        return b;
    }
    
    public static Object findNextFocusInAbsoluteDirection(final Object o, final FocusStrategy$CollectionAdapter focusStrategy$CollectionAdapter, final FocusStrategy$BoundsAdapter focusStrategy$BoundsAdapter, final Object o2, final Rect rect, final int n) {
        final Rect rect2 = new Rect(rect);
        if (n != 17) {
            if (n != 33) {
                if (n != 66) {
                    if (n != 130) {
                        throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                    }
                    rect2.offset(0, -(rect.height() + 1));
                }
                else {
                    rect2.offset(-(rect.width() + 1), 0);
                }
            }
            else {
                rect2.offset(0, rect.height() + 1);
            }
        }
        else {
            rect2.offset(rect.width() + 1, 0);
        }
        Object o3 = null;
        final int size = focusStrategy$CollectionAdapter.size(o);
        final Rect rect3 = new Rect();
        for (int i = 0; i < size; ++i) {
            final Object value = focusStrategy$CollectionAdapter.get(o, i);
            if (value != o2) {
                focusStrategy$BoundsAdapter.obtainBounds(value, rect3);
                if (isBetterCandidate(n, rect, rect3, rect2)) {
                    rect2.set(rect3);
                    o3 = value;
                }
            }
        }
        return o3;
    }
    
    public static Object findNextFocusInRelativeDirection(final Object o, final FocusStrategy$CollectionAdapter focusStrategy$CollectionAdapter, final FocusStrategy$BoundsAdapter focusStrategy$BoundsAdapter, final Object o2, final int n, final boolean b, final boolean b2) {
        final int size = focusStrategy$CollectionAdapter.size(o);
        final ArrayList list = new ArrayList<Object>(size);
        for (int i = 0; i < size; ++i) {
            list.add((T)focusStrategy$CollectionAdapter.get(o, i));
        }
        Collections.sort((List<Object>)list, new FocusStrategy$SequentialComparator(b, focusStrategy$BoundsAdapter));
        switch (n) {
            default: {
                throw new IllegalArgumentException("direction must be one of {FOCUS_FORWARD, FOCUS_BACKWARD}.");
            }
            case 2: {
                return getNextFocusable(o2, list, b2);
            }
            case 1: {
                return getPreviousFocusable(o2, list, b2);
            }
        }
    }
    
    private static Object getNextFocusable(final Object o, final ArrayList list, final boolean b) {
        final int size = list.size();
        int lastIndex;
        if (o == null) {
            lastIndex = -1;
        }
        else {
            lastIndex = list.lastIndexOf(o);
        }
        final int n = lastIndex + 1;
        if (n < size) {
            return list.get(n);
        }
        if (b && size > 0) {
            return list.get(0);
        }
        return null;
    }
    
    private static Object getPreviousFocusable(final Object o, final ArrayList list, final boolean b) {
        final int size = list.size();
        int index;
        if (o == null) {
            index = size;
        }
        else {
            index = list.indexOf(o);
        }
        final int n = index - 1;
        if (n >= 0) {
            return list.get(n);
        }
        if (b && size > 0) {
            return list.get(size - 1);
        }
        return null;
    }
    
    private static int getWeightedDistanceFor(final int n, final int n2) {
        return n * 13 * n + n2 * n2;
    }
    
    private static boolean isBetterCandidate(final int n, final Rect rect, final Rect rect2, final Rect rect3) {
        final boolean candidate = isCandidate(rect, rect2, n);
        boolean b = false;
        if (!candidate) {
            return false;
        }
        final boolean candidate2 = isCandidate(rect, rect3, n);
        final boolean b2 = true;
        if (!candidate2) {
            return b2;
        }
        if (beamBeats(n, rect, rect2, rect3)) {
            return b2;
        }
        if (beamBeats(n, rect, rect3, rect2)) {
            return false;
        }
        if (getWeightedDistanceFor(majorAxisDistance(n, rect, rect2), minorAxisDistance(n, rect, rect2)) < getWeightedDistanceFor(majorAxisDistance(n, rect, rect3), minorAxisDistance(n, rect, rect3))) {
            b = true;
        }
        return b;
    }
    
    private static boolean isCandidate(final Rect rect, final Rect rect2, final int n) {
        final int n2 = 17;
        boolean b = true;
        if (n == n2) {
            if ((rect.right <= rect2.right && rect.left < rect2.right) || rect.left <= rect2.left) {
                b = false;
            }
            return b;
        }
        if (n == 33) {
            if ((rect.bottom <= rect2.bottom && rect.top < rect2.bottom) || rect.top <= rect2.top) {
                b = false;
            }
            return b;
        }
        if (n == 66) {
            if ((rect.left >= rect2.left && rect.right > rect2.left) || rect.right >= rect2.right) {
                b = false;
            }
            return b;
        }
        if (n == 130) {
            if ((rect.top >= rect2.top && rect.bottom > rect2.top) || rect.bottom >= rect2.bottom) {
                b = false;
            }
            return b;
        }
        throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
    }
    
    private static boolean isToDirectionOf(final int n, final Rect rect, final Rect rect2) {
        final int n2 = 17;
        boolean b = true;
        if (n == n2) {
            if (rect.left < rect2.right) {
                b = false;
            }
            return b;
        }
        if (n == 33) {
            if (rect.top < rect2.bottom) {
                b = false;
            }
            return b;
        }
        if (n == 66) {
            if (rect.right > rect2.left) {
                b = false;
            }
            return b;
        }
        if (n == 130) {
            if (rect.bottom > rect2.top) {
                b = false;
            }
            return b;
        }
        throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
    }
    
    private static int majorAxisDistance(final int n, final Rect rect, final Rect rect2) {
        return Math.max(0, majorAxisDistanceRaw(n, rect, rect2));
    }
    
    private static int majorAxisDistanceRaw(final int n, final Rect rect, final Rect rect2) {
        if (n == 17) {
            return rect.left - rect2.right;
        }
        if (n == 33) {
            return rect.top - rect2.bottom;
        }
        if (n == 66) {
            return rect2.left - rect.right;
        }
        if (n == 130) {
            return rect2.top - rect.bottom;
        }
        throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
    }
    
    private static int majorAxisDistanceToFarEdge(final int n, final Rect rect, final Rect rect2) {
        return Math.max(1, majorAxisDistanceToFarEdgeRaw(n, rect, rect2));
    }
    
    private static int majorAxisDistanceToFarEdgeRaw(final int n, final Rect rect, final Rect rect2) {
        if (n == 17) {
            return rect.left - rect2.left;
        }
        if (n == 33) {
            return rect.top - rect2.top;
        }
        if (n == 66) {
            return rect2.right - rect.right;
        }
        if (n == 130) {
            return rect2.bottom - rect.bottom;
        }
        throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
    }
    
    private static int minorAxisDistance(final int n, final Rect rect, final Rect rect2) {
        if (n != 17) {
            if (n != 33) {
                if (n == 66) {
                    return Math.abs(rect.top + rect.height() / 2 - (rect2.top + rect2.height() / 2));
                }
                if (n != 130) {
                    throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                }
            }
            return Math.abs(rect.left + rect.width() / 2 - (rect2.left + rect2.width() / 2));
        }
        return Math.abs(rect.top + rect.height() / 2 - (rect2.top + rect2.height() / 2));
    }
}
