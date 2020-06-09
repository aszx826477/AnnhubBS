// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.app;

import android.content.IntentSender;
import android.os.Bundle;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import java.io.PrintWriter;
import java.io.FileDescriptor;
import android.os.Handler;
import android.content.Context;
import android.support.v4.util.SimpleArrayMap;
import android.app.Activity;

public abstract class FragmentHostCallback extends FragmentContainer
{
    private final Activity mActivity;
    private SimpleArrayMap mAllLoaderManagers;
    private boolean mCheckedForLoaderManager;
    final Context mContext;
    final FragmentManagerImpl mFragmentManager;
    private final Handler mHandler;
    private LoaderManagerImpl mLoaderManager;
    private boolean mLoadersStarted;
    private boolean mRetainLoaders;
    final int mWindowAnimations;
    
    FragmentHostCallback(final Activity mActivity, final Context mContext, final Handler mHandler, final int mWindowAnimations) {
        this.mFragmentManager = new FragmentManagerImpl();
        this.mActivity = mActivity;
        this.mContext = mContext;
        this.mHandler = mHandler;
        this.mWindowAnimations = mWindowAnimations;
    }
    
    public FragmentHostCallback(final Context context, final Handler handler, final int n) {
        Activity activity;
        if (context instanceof Activity) {
            activity = (Activity)context;
        }
        else {
            activity = null;
        }
        this(activity, context, handler, n);
    }
    
    FragmentHostCallback(final FragmentActivity fragmentActivity) {
        this(fragmentActivity, (Context)fragmentActivity, fragmentActivity.mHandler, 0);
    }
    
    void doLoaderDestroy() {
        final LoaderManagerImpl mLoaderManager = this.mLoaderManager;
        if (mLoaderManager == null) {
            return;
        }
        mLoaderManager.doDestroy();
    }
    
    void doLoaderRetain() {
        final LoaderManagerImpl mLoaderManager = this.mLoaderManager;
        if (mLoaderManager == null) {
            return;
        }
        mLoaderManager.doRetain();
    }
    
    void doLoaderStart() {
        if (this.mLoadersStarted) {
            return;
        }
        final boolean b = true;
        this.mLoadersStarted = b;
        final LoaderManagerImpl mLoaderManager = this.mLoaderManager;
        if (mLoaderManager != null) {
            mLoaderManager.doStart();
        }
        else if (!this.mCheckedForLoaderManager) {
            this.mLoaderManager = this.getLoaderManager("(root)", this.mLoadersStarted, false);
            final LoaderManagerImpl mLoaderManager2 = this.mLoaderManager;
            if (mLoaderManager2 != null && !mLoaderManager2.mStarted) {
                this.mLoaderManager.doStart();
            }
        }
        this.mCheckedForLoaderManager = b;
    }
    
    void doLoaderStop(final boolean mRetainLoaders) {
        this.mRetainLoaders = mRetainLoaders;
        final LoaderManagerImpl mLoaderManager = this.mLoaderManager;
        if (mLoaderManager == null) {
            return;
        }
        if (!this.mLoadersStarted) {
            return;
        }
        this.mLoadersStarted = false;
        if (mRetainLoaders) {
            mLoaderManager.doRetain();
        }
        else {
            mLoaderManager.doStop();
        }
    }
    
    void dumpLoaders(final String s, final FileDescriptor fileDescriptor, final PrintWriter printWriter, final String[] array) {
        printWriter.print(s);
        printWriter.print("mLoadersStarted=");
        printWriter.println(this.mLoadersStarted);
        if (this.mLoaderManager != null) {
            printWriter.print(s);
            printWriter.print("Loader Manager ");
            printWriter.print(Integer.toHexString(System.identityHashCode(this.mLoaderManager)));
            printWriter.println(":");
            final LoaderManagerImpl mLoaderManager = this.mLoaderManager;
            final StringBuilder sb = new StringBuilder();
            sb.append(s);
            sb.append("  ");
            mLoaderManager.dump(sb.toString(), fileDescriptor, printWriter, array);
        }
    }
    
    Activity getActivity() {
        return this.mActivity;
    }
    
    Context getContext() {
        return this.mContext;
    }
    
    FragmentManagerImpl getFragmentManagerImpl() {
        return this.mFragmentManager;
    }
    
    Handler getHandler() {
        return this.mHandler;
    }
    
    LoaderManagerImpl getLoaderManager(final String s, final boolean b, final boolean b2) {
        if (this.mAllLoaderManagers == null) {
            this.mAllLoaderManagers = new SimpleArrayMap();
        }
        LoaderManagerImpl loaderManagerImpl = (LoaderManagerImpl)this.mAllLoaderManagers.get(s);
        if (loaderManagerImpl == null && b2) {
            loaderManagerImpl = new LoaderManagerImpl(s, this, b);
            this.mAllLoaderManagers.put(s, loaderManagerImpl);
        }
        else if (b && loaderManagerImpl != null && !loaderManagerImpl.mStarted) {
            loaderManagerImpl.doStart();
        }
        return loaderManagerImpl;
    }
    
    LoaderManagerImpl getLoaderManagerImpl() {
        final LoaderManagerImpl mLoaderManager = this.mLoaderManager;
        if (mLoaderManager != null) {
            return mLoaderManager;
        }
        final boolean mCheckedForLoaderManager = true;
        this.mCheckedForLoaderManager = mCheckedForLoaderManager;
        return this.mLoaderManager = this.getLoaderManager("(root)", this.mLoadersStarted, mCheckedForLoaderManager);
    }
    
    boolean getRetainLoaders() {
        return this.mRetainLoaders;
    }
    
    void inactivateFragment(final String s) {
        final SimpleArrayMap mAllLoaderManagers = this.mAllLoaderManagers;
        if (mAllLoaderManagers != null) {
            final LoaderManagerImpl loaderManagerImpl = (LoaderManagerImpl)mAllLoaderManagers.get(s);
            if (loaderManagerImpl != null && !loaderManagerImpl.mRetaining) {
                loaderManagerImpl.doDestroy();
                this.mAllLoaderManagers.remove(s);
            }
        }
    }
    
    void onAttachFragment(final Fragment fragment) {
    }
    
    public void onDump(final String s, final FileDescriptor fileDescriptor, final PrintWriter printWriter, final String[] array) {
    }
    
    public View onFindViewById(final int n) {
        return null;
    }
    
    public abstract Object onGetHost();
    
    public LayoutInflater onGetLayoutInflater() {
        return (LayoutInflater)this.mContext.getSystemService("layout_inflater");
    }
    
    public int onGetWindowAnimations() {
        return this.mWindowAnimations;
    }
    
    public boolean onHasView() {
        return true;
    }
    
    public boolean onHasWindowAnimations() {
        return true;
    }
    
    public void onRequestPermissionsFromFragment(final Fragment fragment, final String[] array, final int n) {
    }
    
    public boolean onShouldSaveFragmentState(final Fragment fragment) {
        return true;
    }
    
    public boolean onShouldShowRequestPermissionRationale(final String s) {
        return false;
    }
    
    public void onStartActivityFromFragment(final Fragment fragment, final Intent intent, final int n) {
        this.onStartActivityFromFragment(fragment, intent, n, null);
    }
    
    public void onStartActivityFromFragment(final Fragment fragment, final Intent intent, final int n, final Bundle bundle) {
        if (n == -1) {
            this.mContext.startActivity(intent);
            return;
        }
        throw new IllegalStateException("Starting activity with a requestCode requires a FragmentActivity host");
    }
    
    public void onStartIntentSenderFromFragment(final Fragment fragment, final IntentSender intentSender, final int n, final Intent intent, final int n2, final int n3, final int n4, final Bundle bundle) {
        if (n == -1) {
            ActivityCompat.startIntentSenderForResult(this.mActivity, intentSender, n, intent, n2, n3, n4, bundle);
            return;
        }
        throw new IllegalStateException("Starting intent sender with a requestCode requires a FragmentActivity host");
    }
    
    public void onSupportInvalidateOptionsMenu() {
    }
    
    void reportLoaderStart() {
        final SimpleArrayMap mAllLoaderManagers = this.mAllLoaderManagers;
        if (mAllLoaderManagers != null) {
            final int size = mAllLoaderManagers.size();
            final LoaderManagerImpl[] array = new LoaderManagerImpl[size];
            for (int i = size - 1; i >= 0; --i) {
                array[i] = (LoaderManagerImpl)this.mAllLoaderManagers.valueAt(i);
            }
            for (int j = 0; j < size; ++j) {
                final LoaderManagerImpl loaderManagerImpl = array[j];
                loaderManagerImpl.finishRetain();
                loaderManagerImpl.doReportStart();
            }
        }
    }
    
    void restoreLoaderNonConfig(final SimpleArrayMap mAllLoaderManagers) {
        if (mAllLoaderManagers != null) {
            for (int size = mAllLoaderManagers.size(), i = 0; i < size; ++i) {
                ((LoaderManagerImpl)mAllLoaderManagers.valueAt(i)).updateHostController(this);
            }
        }
        this.mAllLoaderManagers = mAllLoaderManagers;
    }
    
    SimpleArrayMap retainLoaderNonConfig() {
        boolean b = false;
        final SimpleArrayMap mAllLoaderManagers = this.mAllLoaderManagers;
        if (mAllLoaderManagers != null) {
            final int size = mAllLoaderManagers.size();
            final LoaderManagerImpl[] array = new LoaderManagerImpl[size];
            for (int i = size - 1; i >= 0; --i) {
                array[i] = (LoaderManagerImpl)this.mAllLoaderManagers.valueAt(i);
            }
            final boolean retainLoaders = this.getRetainLoaders();
            for (int j = 0; j < size; ++j) {
                final LoaderManagerImpl loaderManagerImpl = array[j];
                if (!loaderManagerImpl.mRetaining && retainLoaders) {
                    if (!loaderManagerImpl.mStarted) {
                        loaderManagerImpl.doStart();
                    }
                    loaderManagerImpl.doRetain();
                }
                if (loaderManagerImpl.mRetaining) {
                    b = true;
                }
                else {
                    loaderManagerImpl.doDestroy();
                    this.mAllLoaderManagers.remove(loaderManagerImpl.mWho);
                }
            }
        }
        if (b) {
            return this.mAllLoaderManagers;
        }
        return null;
    }
}
