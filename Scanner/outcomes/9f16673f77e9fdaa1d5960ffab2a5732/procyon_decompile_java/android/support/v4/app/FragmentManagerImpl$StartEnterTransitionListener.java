// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.app;

import android.support.v4.util.DebugUtils;
import android.os.Parcelable;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.content.res.Resources;
import android.content.res.Resources$NotFoundException;
import android.view.animation.AnimationUtils;
import java.util.Collections;
import java.util.Arrays;
import java.util.Iterator;
import android.support.v4.util.Pair;
import android.view.MenuInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.content.res.Configuration;
import java.io.FileDescriptor;
import java.io.Writer;
import java.io.PrintWriter;
import android.support.v4.util.LogWriter;
import android.graphics.Paint;
import android.support.v4.view.ViewCompat;
import android.util.Log;
import android.view.animation.Animation$AnimationListener;
import java.util.List;
import android.view.animation.ScaleAnimation;
import android.view.animation.AnimationSet;
import android.view.animation.AlphaAnimation;
import android.content.Context;
import android.view.ViewGroup;
import java.util.Collection;
import android.os.Looper;
import android.view.animation.Animation;
import android.view.View;
import android.support.v4.util.ArraySet;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.os.Build$VERSION;
import android.os.Bundle;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.ArrayList;
import android.util.SparseArray;
import java.lang.reflect.Field;
import android.view.animation.Interpolator;
import android.support.v4.view.LayoutInflaterFactory;

class FragmentManagerImpl$StartEnterTransitionListener implements Fragment$OnStartEnterTransitionListener
{
    private final boolean mIsBack;
    private int mNumPostponed;
    private final BackStackRecord mRecord;
    
    FragmentManagerImpl$StartEnterTransitionListener(final BackStackRecord mRecord, final boolean mIsBack) {
        this.mIsBack = mIsBack;
        this.mRecord = mRecord;
    }
    
    public void cancelTransaction() {
        this.mRecord.mManager.completeExecute(this.mRecord, this.mIsBack, false, false);
    }
    
    public void completeTransaction() {
        final int mNumPostponed = this.mNumPostponed;
        boolean b = false;
        final boolean b2 = true;
        final boolean b3 = mNumPostponed > 0;
        final FragmentManagerImpl mManager = this.mRecord.mManager;
        for (int size = mManager.mAdded.size(), i = 0; i < size; ++i) {
            final Fragment fragment = mManager.mAdded.get(i);
            fragment.setOnStartEnterTransitionListener(null);
            if (b3 && fragment.isPostponed()) {
                fragment.startPostponedEnterTransition();
            }
        }
        final FragmentManagerImpl mManager2 = this.mRecord.mManager;
        final BackStackRecord mRecord = this.mRecord;
        final boolean mIsBack = this.mIsBack;
        if (!b3) {
            b = true;
        }
        mManager2.completeExecute(mRecord, mIsBack, b, b2);
    }
    
    public boolean isReady() {
        return this.mNumPostponed == 0;
    }
    
    public void onStartEnterTransition() {
        --this.mNumPostponed;
        if (this.mNumPostponed != 0) {
            return;
        }
        this.mRecord.mManager.scheduleCommit();
    }
    
    public void startListening() {
        ++this.mNumPostponed;
    }
}
