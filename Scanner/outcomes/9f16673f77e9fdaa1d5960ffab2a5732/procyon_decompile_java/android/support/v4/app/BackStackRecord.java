// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.app;

import java.io.FileDescriptor;
import java.io.Writer;
import java.io.PrintWriter;
import android.support.v4.util.LogWriter;
import android.util.Log;
import android.support.v4.view.ViewCompat;
import android.view.View;
import java.lang.reflect.Modifier;
import android.os.Build$VERSION;
import java.util.ArrayList;

final class BackStackRecord extends FragmentTransaction implements FragmentManager$BackStackEntry, FragmentManagerImpl$OpGenerator
{
    static final int OP_ADD = 1;
    static final int OP_ATTACH = 7;
    static final int OP_DETACH = 6;
    static final int OP_HIDE = 4;
    static final int OP_NULL = 0;
    static final int OP_REMOVE = 3;
    static final int OP_REPLACE = 2;
    static final int OP_SHOW = 5;
    static final boolean SUPPORTS_TRANSITIONS = false;
    static final String TAG = "FragmentManager";
    boolean mAddToBackStack;
    boolean mAllowAddToBackStack;
    boolean mAllowOptimization;
    int mBreadCrumbShortTitleRes;
    CharSequence mBreadCrumbShortTitleText;
    int mBreadCrumbTitleRes;
    CharSequence mBreadCrumbTitleText;
    boolean mCommitted;
    int mEnterAnim;
    int mExitAnim;
    int mIndex;
    final FragmentManagerImpl mManager;
    String mName;
    ArrayList mOps;
    int mPopEnterAnim;
    int mPopExitAnim;
    ArrayList mSharedElementSourceNames;
    ArrayList mSharedElementTargetNames;
    int mTransition;
    int mTransitionStyle;
    
    public BackStackRecord(final FragmentManagerImpl mManager) {
        this.mOps = new ArrayList();
        this.mAllowAddToBackStack = true;
        this.mIndex = -1;
        this.mAllowOptimization = false;
        this.mManager = mManager;
    }
    
    private void doAddOp(final int n, final Fragment fragment, final String mTag, final int cmd) {
        final Class<? extends Fragment> class1 = fragment.getClass();
        final int modifiers = class1.getModifiers();
        if (!class1.isAnonymousClass() && Modifier.isPublic(modifiers) && (!class1.isMemberClass() || Modifier.isStatic(modifiers))) {
            fragment.mFragmentManager = this.mManager;
            if (mTag != null) {
                if (fragment.mTag != null && !mTag.equals(fragment.mTag)) {
                    final StringBuilder sb = new StringBuilder();
                    sb.append("Can't change tag of fragment ");
                    sb.append(fragment);
                    sb.append(": was ");
                    sb.append(fragment.mTag);
                    sb.append(" now ");
                    sb.append(mTag);
                    throw new IllegalStateException(sb.toString());
                }
                fragment.mTag = mTag;
            }
            if (n != 0) {
                if (n == -1) {
                    final StringBuilder sb2 = new StringBuilder();
                    sb2.append("Can't add fragment ");
                    sb2.append(fragment);
                    sb2.append(" with tag ");
                    sb2.append(mTag);
                    sb2.append(" to container view with no id");
                    throw new IllegalArgumentException(sb2.toString());
                }
                if (fragment.mFragmentId != 0 && fragment.mFragmentId != n) {
                    final StringBuilder sb3 = new StringBuilder();
                    sb3.append("Can't change container ID of fragment ");
                    sb3.append(fragment);
                    sb3.append(": was ");
                    sb3.append(fragment.mFragmentId);
                    sb3.append(" now ");
                    sb3.append(n);
                    throw new IllegalStateException(sb3.toString());
                }
                fragment.mFragmentId = n;
                fragment.mContainerId = n;
            }
            final BackStackRecord$Op backStackRecord$Op = new BackStackRecord$Op();
            backStackRecord$Op.cmd = cmd;
            backStackRecord$Op.fragment = fragment;
            this.addOp(backStackRecord$Op);
            return;
        }
        final StringBuilder sb4 = new StringBuilder();
        sb4.append("Fragment ");
        sb4.append(class1.getCanonicalName());
        sb4.append(" must be a public static class to be  properly recreated from");
        sb4.append(" instance state.");
        throw new IllegalStateException(sb4.toString());
    }
    
    private static boolean isFragmentPostponed(final BackStackRecord$Op backStackRecord$Op) {
        final Fragment fragment = backStackRecord$Op.fragment;
        return fragment.mAdded && fragment.mView != null && !fragment.mDetached && !fragment.mHidden && fragment.isPostponed();
    }
    
    public FragmentTransaction add(final int n, final Fragment fragment) {
        this.doAddOp(n, fragment, null, 1);
        return this;
    }
    
    public FragmentTransaction add(final int n, final Fragment fragment, final String s) {
        this.doAddOp(n, fragment, s, 1);
        return this;
    }
    
    public FragmentTransaction add(final Fragment fragment, final String s) {
        this.doAddOp(0, fragment, s, 1);
        return this;
    }
    
    void addOp(final BackStackRecord$Op backStackRecord$Op) {
        this.mOps.add(backStackRecord$Op);
        backStackRecord$Op.enterAnim = this.mEnterAnim;
        backStackRecord$Op.exitAnim = this.mExitAnim;
        backStackRecord$Op.popEnterAnim = this.mPopEnterAnim;
        backStackRecord$Op.popExitAnim = this.mPopExitAnim;
    }
    
    public FragmentTransaction addSharedElement(final View view, final String s) {
        if (BackStackRecord.SUPPORTS_TRANSITIONS) {
            final String transitionName = ViewCompat.getTransitionName(view);
            if (transitionName == null) {
                throw new IllegalArgumentException("Unique transitionNames are required for all sharedElements");
            }
            if (this.mSharedElementSourceNames == null) {
                this.mSharedElementSourceNames = new ArrayList();
                this.mSharedElementTargetNames = new ArrayList();
            }
            else {
                if (this.mSharedElementTargetNames.contains(s)) {
                    final StringBuilder sb = new StringBuilder();
                    sb.append("A shared element with the target name '");
                    sb.append(s);
                    sb.append("' has already been added to the transaction.");
                    throw new IllegalArgumentException(sb.toString());
                }
                if (this.mSharedElementSourceNames.contains(transitionName)) {
                    final StringBuilder sb2 = new StringBuilder();
                    sb2.append("A shared element with the source name '");
                    sb2.append(transitionName);
                    sb2.append(" has already been added to the transaction.");
                    throw new IllegalArgumentException(sb2.toString());
                }
            }
            this.mSharedElementSourceNames.add(transitionName);
            this.mSharedElementTargetNames.add(s);
        }
        return this;
    }
    
    public FragmentTransaction addToBackStack(final String mName) {
        if (this.mAllowAddToBackStack) {
            this.mAddToBackStack = true;
            this.mName = mName;
            return this;
        }
        throw new IllegalStateException("This FragmentTransaction is not allowed to be added to the back stack.");
    }
    
    public FragmentTransaction attach(final Fragment fragment) {
        final BackStackRecord$Op backStackRecord$Op = new BackStackRecord$Op();
        backStackRecord$Op.cmd = 7;
        backStackRecord$Op.fragment = fragment;
        this.addOp(backStackRecord$Op);
        return this;
    }
    
    void bumpBackStackNesting(final int n) {
        if (!this.mAddToBackStack) {
            return;
        }
        if (FragmentManagerImpl.DEBUG) {
            final String s = "FragmentManager";
            final StringBuilder sb = new StringBuilder();
            sb.append("Bump nesting in ");
            sb.append(this);
            sb.append(" by ");
            sb.append(n);
            Log.v(s, sb.toString());
        }
        for (int size = this.mOps.size(), i = 0; i < size; ++i) {
            final BackStackRecord$Op backStackRecord$Op = this.mOps.get(i);
            if (backStackRecord$Op.fragment != null) {
                final Fragment fragment = backStackRecord$Op.fragment;
                fragment.mBackStackNesting += n;
                if (FragmentManagerImpl.DEBUG) {
                    final String s2 = "FragmentManager";
                    final StringBuilder sb2 = new StringBuilder();
                    sb2.append("Bump nesting of ");
                    sb2.append(backStackRecord$Op.fragment);
                    sb2.append(" to ");
                    sb2.append(backStackRecord$Op.fragment.mBackStackNesting);
                    Log.v(s2, sb2.toString());
                }
            }
        }
    }
    
    public int commit() {
        return this.commitInternal(false);
    }
    
    public int commitAllowingStateLoss() {
        return this.commitInternal(true);
    }
    
    int commitInternal(final boolean b) {
        if (!this.mCommitted) {
            if (FragmentManagerImpl.DEBUG) {
                final StringBuilder sb = new StringBuilder();
                sb.append("Commit: ");
                sb.append(this);
                Log.v("FragmentManager", sb.toString());
                final PrintWriter printWriter = new PrintWriter(new LogWriter("FragmentManager"));
                this.dump("  ", null, printWriter, null);
                printWriter.close();
            }
            this.mCommitted = true;
            if (this.mAddToBackStack) {
                this.mIndex = this.mManager.allocBackStackIndex(this);
            }
            else {
                this.mIndex = -1;
            }
            this.mManager.enqueueAction(this, b);
            return this.mIndex;
        }
        throw new IllegalStateException("commit already called");
    }
    
    public void commitNow() {
        this.disallowAddToBackStack();
        this.mManager.execSingleAction(this, false);
    }
    
    public void commitNowAllowingStateLoss() {
        this.disallowAddToBackStack();
        this.mManager.execSingleAction(this, true);
    }
    
    public FragmentTransaction detach(final Fragment fragment) {
        final BackStackRecord$Op backStackRecord$Op = new BackStackRecord$Op();
        backStackRecord$Op.cmd = 6;
        backStackRecord$Op.fragment = fragment;
        this.addOp(backStackRecord$Op);
        return this;
    }
    
    public FragmentTransaction disallowAddToBackStack() {
        if (!this.mAddToBackStack) {
            this.mAllowAddToBackStack = false;
            return this;
        }
        throw new IllegalStateException("This transaction is already being added to the back stack");
    }
    
    public void dump(final String s, final FileDescriptor fileDescriptor, final PrintWriter printWriter, final String[] array) {
        this.dump(s, printWriter, true);
    }
    
    public void dump(final String s, final PrintWriter printWriter, final boolean b) {
        if (b) {
            printWriter.print(s);
            printWriter.print("mName=");
            printWriter.print(this.mName);
            printWriter.print(" mIndex=");
            printWriter.print(this.mIndex);
            printWriter.print(" mCommitted=");
            printWriter.println(this.mCommitted);
            if (this.mTransition != 0) {
                printWriter.print(s);
                printWriter.print("mTransition=#");
                printWriter.print(Integer.toHexString(this.mTransition));
                printWriter.print(" mTransitionStyle=#");
                printWriter.println(Integer.toHexString(this.mTransitionStyle));
            }
            if (this.mEnterAnim != 0 || this.mExitAnim != 0) {
                printWriter.print(s);
                printWriter.print("mEnterAnim=#");
                printWriter.print(Integer.toHexString(this.mEnterAnim));
                printWriter.print(" mExitAnim=#");
                printWriter.println(Integer.toHexString(this.mExitAnim));
            }
            if (this.mPopEnterAnim != 0 || this.mPopExitAnim != 0) {
                printWriter.print(s);
                printWriter.print("mPopEnterAnim=#");
                printWriter.print(Integer.toHexString(this.mPopEnterAnim));
                printWriter.print(" mPopExitAnim=#");
                printWriter.println(Integer.toHexString(this.mPopExitAnim));
            }
            if (this.mBreadCrumbTitleRes != 0 || this.mBreadCrumbTitleText != null) {
                printWriter.print(s);
                printWriter.print("mBreadCrumbTitleRes=#");
                printWriter.print(Integer.toHexString(this.mBreadCrumbTitleRes));
                printWriter.print(" mBreadCrumbTitleText=");
                printWriter.println(this.mBreadCrumbTitleText);
            }
            if (this.mBreadCrumbShortTitleRes != 0 || this.mBreadCrumbShortTitleText != null) {
                printWriter.print(s);
                printWriter.print("mBreadCrumbShortTitleRes=#");
                printWriter.print(Integer.toHexString(this.mBreadCrumbShortTitleRes));
                printWriter.print(" mBreadCrumbShortTitleText=");
                printWriter.println(this.mBreadCrumbShortTitleText);
            }
        }
        if (!this.mOps.isEmpty()) {
            printWriter.print(s);
            printWriter.println("Operations:");
            final StringBuilder sb = new StringBuilder();
            sb.append(s);
            sb.append("    ");
            sb.toString();
            for (int size = this.mOps.size(), i = 0; i < size; ++i) {
                final BackStackRecord$Op backStackRecord$Op = this.mOps.get(i);
                String string = null;
                switch (backStackRecord$Op.cmd) {
                    default: {
                        final StringBuilder sb2 = new StringBuilder();
                        sb2.append("cmd=");
                        sb2.append(backStackRecord$Op.cmd);
                        string = sb2.toString();
                        break;
                    }
                    case 7: {
                        string = "ATTACH";
                        break;
                    }
                    case 6: {
                        string = "DETACH";
                        break;
                    }
                    case 5: {
                        string = "SHOW";
                        break;
                    }
                    case 4: {
                        string = "HIDE";
                        break;
                    }
                    case 3: {
                        string = "REMOVE";
                        break;
                    }
                    case 2: {
                        string = "REPLACE";
                        break;
                    }
                    case 1: {
                        string = "ADD";
                        break;
                    }
                    case 0: {
                        string = "NULL";
                        break;
                    }
                }
                printWriter.print(s);
                printWriter.print("  Op #");
                printWriter.print(i);
                printWriter.print(": ");
                printWriter.print(string);
                printWriter.print(" ");
                printWriter.println(backStackRecord$Op.fragment);
                if (b) {
                    if (backStackRecord$Op.enterAnim != 0 || backStackRecord$Op.exitAnim != 0) {
                        printWriter.print(s);
                        printWriter.print("enterAnim=#");
                        printWriter.print(Integer.toHexString(backStackRecord$Op.enterAnim));
                        printWriter.print(" exitAnim=#");
                        printWriter.println(Integer.toHexString(backStackRecord$Op.exitAnim));
                    }
                    if (backStackRecord$Op.popEnterAnim != 0 || backStackRecord$Op.popExitAnim != 0) {
                        printWriter.print(s);
                        printWriter.print("popEnterAnim=#");
                        printWriter.print(Integer.toHexString(backStackRecord$Op.popEnterAnim));
                        printWriter.print(" popExitAnim=#");
                        printWriter.println(Integer.toHexString(backStackRecord$Op.popExitAnim));
                    }
                }
            }
        }
    }
    
    void executeOps() {
        final int size = this.mOps.size();
        int n = 0;
        while (true) {
            final boolean b = true;
            if (n >= size) {
                if (!this.mAllowOptimization) {
                    final FragmentManagerImpl mManager = this.mManager;
                    mManager.moveToState(mManager.mCurState, b);
                }
                return;
            }
            final BackStackRecord$Op backStackRecord$Op = this.mOps.get(n);
            final Fragment fragment = backStackRecord$Op.fragment;
            fragment.setNextTransition(this.mTransition, this.mTransitionStyle);
            final int cmd = backStackRecord$Op.cmd;
            if (cmd != (b ? 1 : 0)) {
                switch (cmd) {
                    default: {
                        final StringBuilder sb = new StringBuilder();
                        sb.append("Unknown cmd: ");
                        sb.append(backStackRecord$Op.cmd);
                        throw new IllegalArgumentException(sb.toString());
                    }
                    case 7: {
                        fragment.setNextAnim(backStackRecord$Op.enterAnim);
                        this.mManager.attachFragment(fragment);
                        break;
                    }
                    case 6: {
                        fragment.setNextAnim(backStackRecord$Op.exitAnim);
                        this.mManager.detachFragment(fragment);
                        break;
                    }
                    case 5: {
                        fragment.setNextAnim(backStackRecord$Op.enterAnim);
                        this.mManager.showFragment(fragment);
                        break;
                    }
                    case 4: {
                        fragment.setNextAnim(backStackRecord$Op.exitAnim);
                        this.mManager.hideFragment(fragment);
                        break;
                    }
                    case 3: {
                        fragment.setNextAnim(backStackRecord$Op.exitAnim);
                        this.mManager.removeFragment(fragment);
                        break;
                    }
                }
            }
            else {
                fragment.setNextAnim(backStackRecord$Op.enterAnim);
                this.mManager.addFragment(fragment, false);
            }
            if (!this.mAllowOptimization && backStackRecord$Op.cmd != (b ? 1 : 0)) {
                this.mManager.moveFragmentToExpectedState(fragment);
            }
            ++n;
        }
    }
    
    void executePopOps(final boolean b) {
        final int size = this.mOps.size();
        final int n = 1;
        for (int i = size - n; i >= 0; --i) {
            final BackStackRecord$Op backStackRecord$Op = this.mOps.get(i);
            final Fragment fragment = backStackRecord$Op.fragment;
            fragment.setNextTransition(FragmentManagerImpl.reverseTransit(this.mTransition), this.mTransitionStyle);
            final int cmd = backStackRecord$Op.cmd;
            if (cmd != n) {
                switch (cmd) {
                    default: {
                        final StringBuilder sb = new StringBuilder();
                        sb.append("Unknown cmd: ");
                        sb.append(backStackRecord$Op.cmd);
                        throw new IllegalArgumentException(sb.toString());
                    }
                    case 7: {
                        fragment.setNextAnim(backStackRecord$Op.popExitAnim);
                        this.mManager.detachFragment(fragment);
                        break;
                    }
                    case 6: {
                        fragment.setNextAnim(backStackRecord$Op.popEnterAnim);
                        this.mManager.attachFragment(fragment);
                        break;
                    }
                    case 5: {
                        fragment.setNextAnim(backStackRecord$Op.popExitAnim);
                        this.mManager.hideFragment(fragment);
                        break;
                    }
                    case 4: {
                        fragment.setNextAnim(backStackRecord$Op.popEnterAnim);
                        this.mManager.showFragment(fragment);
                        break;
                    }
                    case 3: {
                        fragment.setNextAnim(backStackRecord$Op.popEnterAnim);
                        this.mManager.addFragment(fragment, false);
                        break;
                    }
                }
            }
            else {
                fragment.setNextAnim(backStackRecord$Op.popExitAnim);
                this.mManager.removeFragment(fragment);
            }
            if (!this.mAllowOptimization && backStackRecord$Op.cmd != 3) {
                this.mManager.moveFragmentToExpectedState(fragment);
            }
        }
        if (!this.mAllowOptimization && b) {
            final FragmentManagerImpl mManager = this.mManager;
            mManager.moveToState(mManager.mCurState, n != 0);
        }
    }
    
    void expandReplaceOps(final ArrayList list) {
        int cmd2;
        for (int i = 0; i < this.mOps.size(); i += cmd2) {
            final BackStackRecord$Op backStackRecord$Op = this.mOps.get(i);
            final int cmd = backStackRecord$Op.cmd;
            cmd2 = 1;
            switch (cmd) {
                case 3:
                case 6: {
                    list.remove(backStackRecord$Op.fragment);
                    break;
                }
                case 2: {
                    final Fragment fragment = backStackRecord$Op.fragment;
                    final int mContainerId = fragment.mContainerId;
                    boolean b = false;
                    for (int j = list.size() - cmd2; j >= 0; --j) {
                        final Fragment fragment2 = list.get(j);
                        if (fragment2.mContainerId == mContainerId) {
                            if (fragment2 == fragment) {
                                b = true;
                            }
                            else {
                                final BackStackRecord$Op backStackRecord$Op2 = new BackStackRecord$Op();
                                backStackRecord$Op2.cmd = 3;
                                backStackRecord$Op2.fragment = fragment2;
                                backStackRecord$Op2.enterAnim = backStackRecord$Op.enterAnim;
                                backStackRecord$Op2.popEnterAnim = backStackRecord$Op.popEnterAnim;
                                backStackRecord$Op2.exitAnim = backStackRecord$Op.exitAnim;
                                backStackRecord$Op2.popExitAnim = backStackRecord$Op.popExitAnim;
                                this.mOps.add(i, backStackRecord$Op2);
                                list.remove(fragment2);
                                ++i;
                            }
                        }
                    }
                    if (b) {
                        this.mOps.remove(i);
                        --i;
                        break;
                    }
                    backStackRecord$Op.cmd = cmd2;
                    list.add(fragment);
                    break;
                }
                case 1:
                case 7: {
                    list.add(backStackRecord$Op.fragment);
                    break;
                }
            }
        }
    }
    
    public boolean generateOps(final ArrayList list, final ArrayList list2) {
        if (FragmentManagerImpl.DEBUG) {
            final String s = "FragmentManager";
            final StringBuilder sb = new StringBuilder();
            sb.append("Run: ");
            sb.append(this);
            Log.v(s, sb.toString());
        }
        list.add(this);
        list2.add(false);
        if (this.mAddToBackStack) {
            this.mManager.addBackStackState(this);
        }
        return true;
    }
    
    public CharSequence getBreadCrumbShortTitle() {
        if (this.mBreadCrumbShortTitleRes != 0) {
            return this.mManager.mHost.getContext().getText(this.mBreadCrumbShortTitleRes);
        }
        return this.mBreadCrumbShortTitleText;
    }
    
    public int getBreadCrumbShortTitleRes() {
        return this.mBreadCrumbShortTitleRes;
    }
    
    public CharSequence getBreadCrumbTitle() {
        if (this.mBreadCrumbTitleRes != 0) {
            return this.mManager.mHost.getContext().getText(this.mBreadCrumbTitleRes);
        }
        return this.mBreadCrumbTitleText;
    }
    
    public int getBreadCrumbTitleRes() {
        return this.mBreadCrumbTitleRes;
    }
    
    public int getId() {
        return this.mIndex;
    }
    
    public String getName() {
        return this.mName;
    }
    
    public int getTransition() {
        return this.mTransition;
    }
    
    public int getTransitionStyle() {
        return this.mTransitionStyle;
    }
    
    public FragmentTransaction hide(final Fragment fragment) {
        final BackStackRecord$Op backStackRecord$Op = new BackStackRecord$Op();
        backStackRecord$Op.cmd = 4;
        backStackRecord$Op.fragment = fragment;
        this.addOp(backStackRecord$Op);
        return this;
    }
    
    boolean interactsWith(final int n) {
        for (int size = this.mOps.size(), i = 0; i < size; ++i) {
            if (((BackStackRecord$Op)this.mOps.get(i)).fragment.mContainerId == n) {
                return true;
            }
        }
        return false;
    }
    
    boolean interactsWith(final ArrayList list, final int n, final int n2) {
        if (n2 == n) {
            return false;
        }
        final int size = this.mOps.size();
        int n3 = -1;
        for (int i = 0; i < size; ++i) {
            final int mContainerId = this.mOps.get(i).fragment.mContainerId;
            if (mContainerId != 0 && mContainerId != n3) {
                n3 = mContainerId;
                for (int j = n; j < n2; ++j) {
                    final BackStackRecord backStackRecord = list.get(j);
                    for (int size2 = backStackRecord.mOps.size(), k = 0; k < size2; ++k) {
                        if (((BackStackRecord$Op)backStackRecord.mOps.get(k)).fragment.mContainerId == mContainerId) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
    
    public boolean isAddToBackStackAllowed() {
        return this.mAllowAddToBackStack;
    }
    
    public boolean isEmpty() {
        return this.mOps.isEmpty();
    }
    
    boolean isPostponed() {
        for (int i = 0; i < this.mOps.size(); ++i) {
            if (isFragmentPostponed((BackStackRecord$Op)this.mOps.get(i))) {
                return true;
            }
        }
        return false;
    }
    
    public FragmentTransaction remove(final Fragment fragment) {
        final BackStackRecord$Op backStackRecord$Op = new BackStackRecord$Op();
        backStackRecord$Op.cmd = 3;
        backStackRecord$Op.fragment = fragment;
        this.addOp(backStackRecord$Op);
        return this;
    }
    
    public FragmentTransaction replace(final int n, final Fragment fragment) {
        return this.replace(n, fragment, null);
    }
    
    public FragmentTransaction replace(final int n, final Fragment fragment, final String s) {
        if (n != 0) {
            this.doAddOp(n, fragment, s, 2);
            return this;
        }
        throw new IllegalArgumentException("Must use non-zero containerViewId");
    }
    
    public FragmentTransaction setAllowOptimization(final boolean mAllowOptimization) {
        this.mAllowOptimization = mAllowOptimization;
        return this;
    }
    
    public FragmentTransaction setBreadCrumbShortTitle(final int mBreadCrumbShortTitleRes) {
        this.mBreadCrumbShortTitleRes = mBreadCrumbShortTitleRes;
        this.mBreadCrumbShortTitleText = null;
        return this;
    }
    
    public FragmentTransaction setBreadCrumbShortTitle(final CharSequence mBreadCrumbShortTitleText) {
        this.mBreadCrumbShortTitleRes = 0;
        this.mBreadCrumbShortTitleText = mBreadCrumbShortTitleText;
        return this;
    }
    
    public FragmentTransaction setBreadCrumbTitle(final int mBreadCrumbTitleRes) {
        this.mBreadCrumbTitleRes = mBreadCrumbTitleRes;
        this.mBreadCrumbTitleText = null;
        return this;
    }
    
    public FragmentTransaction setBreadCrumbTitle(final CharSequence mBreadCrumbTitleText) {
        this.mBreadCrumbTitleRes = 0;
        this.mBreadCrumbTitleText = mBreadCrumbTitleText;
        return this;
    }
    
    public FragmentTransaction setCustomAnimations(final int n, final int n2) {
        return this.setCustomAnimations(n, n2, 0, 0);
    }
    
    public FragmentTransaction setCustomAnimations(final int mEnterAnim, final int mExitAnim, final int mPopEnterAnim, final int mPopExitAnim) {
        this.mEnterAnim = mEnterAnim;
        this.mExitAnim = mExitAnim;
        this.mPopEnterAnim = mPopEnterAnim;
        this.mPopExitAnim = mPopExitAnim;
        return this;
    }
    
    void setOnStartPostponedListener(final Fragment$OnStartEnterTransitionListener onStartEnterTransitionListener) {
        for (int i = 0; i < this.mOps.size(); ++i) {
            final BackStackRecord$Op backStackRecord$Op = this.mOps.get(i);
            if (isFragmentPostponed(backStackRecord$Op)) {
                backStackRecord$Op.fragment.setOnStartEnterTransitionListener(onStartEnterTransitionListener);
            }
        }
    }
    
    public FragmentTransaction setTransition(final int mTransition) {
        this.mTransition = mTransition;
        return this;
    }
    
    public FragmentTransaction setTransitionStyle(final int mTransitionStyle) {
        this.mTransitionStyle = mTransitionStyle;
        return this;
    }
    
    public FragmentTransaction show(final Fragment fragment) {
        final BackStackRecord$Op backStackRecord$Op = new BackStackRecord$Op();
        backStackRecord$Op.cmd = 5;
        backStackRecord$Op.fragment = fragment;
        this.addOp(backStackRecord$Op);
        return this;
    }
    
    public String toString() {
        final StringBuilder sb = new StringBuilder(128);
        sb.append("BackStackEntry{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        if (this.mIndex >= 0) {
            sb.append(" #");
            sb.append(this.mIndex);
        }
        if (this.mName != null) {
            sb.append(" ");
            sb.append(this.mName);
        }
        sb.append("}");
        return sb.toString();
    }
    
    void trackAddedFragmentsInPop(final ArrayList list) {
        for (int i = 0; i < this.mOps.size(); ++i) {
            final BackStackRecord$Op backStackRecord$Op = this.mOps.get(i);
            final int cmd = backStackRecord$Op.cmd;
            Label_0099: {
                if (cmd != 1) {
                    if (cmd != 3) {
                        switch (cmd) {
                            default: {
                                continue;
                            }
                            case 6: {
                                break;
                            }
                            case 7: {
                                break Label_0099;
                            }
                        }
                    }
                    list.add(backStackRecord$Op.fragment);
                    continue;
                }
            }
            list.remove(backStackRecord$Op.fragment);
        }
    }
}
