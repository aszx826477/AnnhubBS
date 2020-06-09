// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.view;

import android.util.Log;
import android.view.View;
import android.view.ViewParent;

class ViewParentCompatLollipop
{
    private static final String TAG = "ViewParentCompat";
    
    public static boolean onNestedFling(final ViewParent viewParent, final View view, final float n, final float n2, final boolean b) {
        try {
            return viewParent.onNestedFling(view, n, n2, b);
        }
        catch (AbstractMethodError abstractMethodError) {
            final StringBuilder sb = new StringBuilder();
            sb.append("ViewParent ");
            sb.append(viewParent);
            sb.append(" does not implement interface ");
            sb.append("method onNestedFling");
            Log.e("ViewParentCompat", sb.toString(), (Throwable)abstractMethodError);
            return false;
        }
    }
    
    public static boolean onNestedPreFling(final ViewParent viewParent, final View view, final float n, final float n2) {
        try {
            return viewParent.onNestedPreFling(view, n, n2);
        }
        catch (AbstractMethodError abstractMethodError) {
            final StringBuilder sb = new StringBuilder();
            sb.append("ViewParent ");
            sb.append(viewParent);
            sb.append(" does not implement interface ");
            sb.append("method onNestedPreFling");
            Log.e("ViewParentCompat", sb.toString(), (Throwable)abstractMethodError);
            return false;
        }
    }
    
    public static void onNestedPreScroll(final ViewParent viewParent, final View view, final int n, final int n2, final int[] array) {
        try {
            viewParent.onNestedPreScroll(view, n, n2, array);
        }
        catch (AbstractMethodError abstractMethodError) {
            final String s = "ViewParentCompat";
            final StringBuilder sb = new StringBuilder();
            sb.append("ViewParent ");
            sb.append(viewParent);
            sb.append(" does not implement interface ");
            sb.append("method onNestedPreScroll");
            Log.e(s, sb.toString(), (Throwable)abstractMethodError);
        }
    }
    
    public static void onNestedScroll(final ViewParent viewParent, final View view, final int n, final int n2, final int n3, final int n4) {
        try {
            viewParent.onNestedScroll(view, n, n2, n3, n4);
        }
        catch (AbstractMethodError abstractMethodError) {
            final String s = "ViewParentCompat";
            final StringBuilder sb = new StringBuilder();
            sb.append("ViewParent ");
            sb.append(viewParent);
            sb.append(" does not implement interface ");
            sb.append("method onNestedScroll");
            Log.e(s, sb.toString(), (Throwable)abstractMethodError);
        }
    }
    
    public static void onNestedScrollAccepted(final ViewParent viewParent, final View view, final View view2, final int n) {
        try {
            viewParent.onNestedScrollAccepted(view, view2, n);
        }
        catch (AbstractMethodError abstractMethodError) {
            final String s = "ViewParentCompat";
            final StringBuilder sb = new StringBuilder();
            sb.append("ViewParent ");
            sb.append(viewParent);
            sb.append(" does not implement interface ");
            sb.append("method onNestedScrollAccepted");
            Log.e(s, sb.toString(), (Throwable)abstractMethodError);
        }
    }
    
    public static boolean onStartNestedScroll(final ViewParent viewParent, final View view, final View view2, final int n) {
        try {
            return viewParent.onStartNestedScroll(view, view2, n);
        }
        catch (AbstractMethodError abstractMethodError) {
            final StringBuilder sb = new StringBuilder();
            sb.append("ViewParent ");
            sb.append(viewParent);
            sb.append(" does not implement interface ");
            sb.append("method onStartNestedScroll");
            Log.e("ViewParentCompat", sb.toString(), (Throwable)abstractMethodError);
            return false;
        }
    }
    
    public static void onStopNestedScroll(final ViewParent viewParent, final View view) {
        try {
            viewParent.onStopNestedScroll(view);
        }
        catch (AbstractMethodError abstractMethodError) {
            final String s = "ViewParentCompat";
            final StringBuilder sb = new StringBuilder();
            sb.append("ViewParent ");
            sb.append(viewParent);
            sb.append(" does not implement interface ");
            sb.append("method onStopNestedScroll");
            Log.e(s, sb.toString(), (Throwable)abstractMethodError);
        }
    }
}
