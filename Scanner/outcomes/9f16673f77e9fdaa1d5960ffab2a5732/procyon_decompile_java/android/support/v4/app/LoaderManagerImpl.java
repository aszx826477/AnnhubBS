// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.app;

import android.support.v4.util.DebugUtils;
import android.support.v4.content.Loader;
import java.io.PrintWriter;
import java.io.FileDescriptor;
import android.util.Log;
import android.os.Bundle;
import android.support.v4.util.SparseArrayCompat;

class LoaderManagerImpl extends LoaderManager
{
    static boolean DEBUG = false;
    static final String TAG = "LoaderManager";
    boolean mCreatingLoader;
    FragmentHostCallback mHost;
    final SparseArrayCompat mInactiveLoaders;
    final SparseArrayCompat mLoaders;
    boolean mRetaining;
    boolean mRetainingStarted;
    boolean mStarted;
    final String mWho;
    
    static {
        LoaderManagerImpl.DEBUG = false;
    }
    
    LoaderManagerImpl(final String mWho, final FragmentHostCallback mHost, final boolean mStarted) {
        this.mLoaders = new SparseArrayCompat();
        this.mInactiveLoaders = new SparseArrayCompat();
        this.mWho = mWho;
        this.mHost = mHost;
        this.mStarted = mStarted;
    }
    
    private LoaderManagerImpl$LoaderInfo createAndInstallLoader(final int n, final Bundle bundle, final LoaderManager$LoaderCallbacks loaderManager$LoaderCallbacks) {
        final boolean mCreatingLoader = true;
        try {
            this.mCreatingLoader = mCreatingLoader;
            final LoaderManagerImpl$LoaderInfo loader = this.createLoader(n, bundle, loaderManager$LoaderCallbacks);
            this.installLoader(loader);
            return loader;
        }
        finally {
            this.mCreatingLoader = false;
        }
    }
    
    private LoaderManagerImpl$LoaderInfo createLoader(final int n, final Bundle bundle, final LoaderManager$LoaderCallbacks loaderManager$LoaderCallbacks) {
        final LoaderManagerImpl$LoaderInfo loaderManagerImpl$LoaderInfo = new LoaderManagerImpl$LoaderInfo(this, n, bundle, loaderManager$LoaderCallbacks);
        loaderManagerImpl$LoaderInfo.mLoader = loaderManager$LoaderCallbacks.onCreateLoader(n, bundle);
        return loaderManagerImpl$LoaderInfo;
    }
    
    public void destroyLoader(final int n) {
        if (!this.mCreatingLoader) {
            if (LoaderManagerImpl.DEBUG) {
                final String s = "LoaderManager";
                final StringBuilder sb = new StringBuilder();
                sb.append("destroyLoader in ");
                sb.append(this);
                sb.append(" of ");
                sb.append(n);
                Log.v(s, sb.toString());
            }
            final int indexOfKey = this.mLoaders.indexOfKey(n);
            if (indexOfKey >= 0) {
                final LoaderManagerImpl$LoaderInfo loaderManagerImpl$LoaderInfo = (LoaderManagerImpl$LoaderInfo)this.mLoaders.valueAt(indexOfKey);
                this.mLoaders.removeAt(indexOfKey);
                loaderManagerImpl$LoaderInfo.destroy();
            }
            final int indexOfKey2 = this.mInactiveLoaders.indexOfKey(n);
            if (indexOfKey2 >= 0) {
                final LoaderManagerImpl$LoaderInfo loaderManagerImpl$LoaderInfo2 = (LoaderManagerImpl$LoaderInfo)this.mInactiveLoaders.valueAt(indexOfKey2);
                this.mInactiveLoaders.removeAt(indexOfKey2);
                loaderManagerImpl$LoaderInfo2.destroy();
            }
            if (this.mHost != null && !this.hasRunningLoaders()) {
                this.mHost.mFragmentManager.startPendingDeferredFragments();
            }
            return;
        }
        throw new IllegalStateException("Called while creating a loader");
    }
    
    void doDestroy() {
        if (!this.mRetaining) {
            if (LoaderManagerImpl.DEBUG) {
                final String s = "LoaderManager";
                final StringBuilder sb = new StringBuilder();
                sb.append("Destroying Active in ");
                sb.append(this);
                Log.v(s, sb.toString());
            }
            for (int i = this.mLoaders.size() - 1; i >= 0; --i) {
                ((LoaderManagerImpl$LoaderInfo)this.mLoaders.valueAt(i)).destroy();
            }
            this.mLoaders.clear();
        }
        if (LoaderManagerImpl.DEBUG) {
            final String s2 = "LoaderManager";
            final StringBuilder sb2 = new StringBuilder();
            sb2.append("Destroying Inactive in ");
            sb2.append(this);
            Log.v(s2, sb2.toString());
        }
        for (int j = this.mInactiveLoaders.size() - 1; j >= 0; --j) {
            ((LoaderManagerImpl$LoaderInfo)this.mInactiveLoaders.valueAt(j)).destroy();
        }
        this.mInactiveLoaders.clear();
        this.mHost = null;
    }
    
    void doReportNextStart() {
        final int size = this.mLoaders.size();
        final int mReportNextStart = 1;
        for (int i = size - mReportNextStart; i >= 0; --i) {
            ((LoaderManagerImpl$LoaderInfo)this.mLoaders.valueAt(i)).mReportNextStart = (mReportNextStart != 0);
        }
    }
    
    void doReportStart() {
        for (int i = this.mLoaders.size() - 1; i >= 0; --i) {
            ((LoaderManagerImpl$LoaderInfo)this.mLoaders.valueAt(i)).reportStart();
        }
    }
    
    void doRetain() {
        if (LoaderManagerImpl.DEBUG) {
            final String s = "LoaderManager";
            final StringBuilder sb = new StringBuilder();
            sb.append("Retaining in ");
            sb.append(this);
            Log.v(s, sb.toString());
        }
        if (!this.mStarted) {
            final RuntimeException ex = new RuntimeException("here");
            ex.fillInStackTrace();
            final StringBuilder sb2 = new StringBuilder();
            sb2.append("Called doRetain when not started: ");
            sb2.append(this);
            Log.w("LoaderManager", sb2.toString(), (Throwable)ex);
            return;
        }
        final int mRetaining = 1;
        this.mRetaining = (mRetaining != 0);
        this.mStarted = false;
        for (int i = this.mLoaders.size() - mRetaining; i >= 0; --i) {
            ((LoaderManagerImpl$LoaderInfo)this.mLoaders.valueAt(i)).retain();
        }
    }
    
    void doStart() {
        if (LoaderManagerImpl.DEBUG) {
            final String s = "LoaderManager";
            final StringBuilder sb = new StringBuilder();
            sb.append("Starting in ");
            sb.append(this);
            Log.v(s, sb.toString());
        }
        if (this.mStarted) {
            final RuntimeException ex = new RuntimeException("here");
            ex.fillInStackTrace();
            final StringBuilder sb2 = new StringBuilder();
            sb2.append("Called doStart when already started: ");
            sb2.append(this);
            Log.w("LoaderManager", sb2.toString(), (Throwable)ex);
            return;
        }
        final int mStarted = 1;
        this.mStarted = (mStarted != 0);
        for (int i = this.mLoaders.size() - mStarted; i >= 0; --i) {
            ((LoaderManagerImpl$LoaderInfo)this.mLoaders.valueAt(i)).start();
        }
    }
    
    void doStop() {
        if (LoaderManagerImpl.DEBUG) {
            final String s = "LoaderManager";
            final StringBuilder sb = new StringBuilder();
            sb.append("Stopping in ");
            sb.append(this);
            Log.v(s, sb.toString());
        }
        if (!this.mStarted) {
            final RuntimeException ex = new RuntimeException("here");
            ex.fillInStackTrace();
            final StringBuilder sb2 = new StringBuilder();
            sb2.append("Called doStop when not started: ");
            sb2.append(this);
            Log.w("LoaderManager", sb2.toString(), (Throwable)ex);
            return;
        }
        for (int i = this.mLoaders.size() - 1; i >= 0; --i) {
            ((LoaderManagerImpl$LoaderInfo)this.mLoaders.valueAt(i)).stop();
        }
        this.mStarted = false;
    }
    
    public void dump(final String s, final FileDescriptor fileDescriptor, final PrintWriter printWriter, final String[] array) {
        if (this.mLoaders.size() > 0) {
            printWriter.print(s);
            printWriter.println("Active Loaders:");
            final StringBuilder sb = new StringBuilder();
            sb.append(s);
            sb.append("    ");
            final String string = sb.toString();
            for (int i = 0; i < this.mLoaders.size(); ++i) {
                final LoaderManagerImpl$LoaderInfo loaderManagerImpl$LoaderInfo = (LoaderManagerImpl$LoaderInfo)this.mLoaders.valueAt(i);
                printWriter.print(s);
                printWriter.print("  #");
                printWriter.print(this.mLoaders.keyAt(i));
                printWriter.print(": ");
                printWriter.println(loaderManagerImpl$LoaderInfo.toString());
                loaderManagerImpl$LoaderInfo.dump(string, fileDescriptor, printWriter, array);
            }
        }
        if (this.mInactiveLoaders.size() > 0) {
            printWriter.print(s);
            printWriter.println("Inactive Loaders:");
            final StringBuilder sb2 = new StringBuilder();
            sb2.append(s);
            sb2.append("    ");
            final String string2 = sb2.toString();
            for (int j = 0; j < this.mInactiveLoaders.size(); ++j) {
                final LoaderManagerImpl$LoaderInfo loaderManagerImpl$LoaderInfo2 = (LoaderManagerImpl$LoaderInfo)this.mInactiveLoaders.valueAt(j);
                printWriter.print(s);
                printWriter.print("  #");
                printWriter.print(this.mInactiveLoaders.keyAt(j));
                printWriter.print(": ");
                printWriter.println(loaderManagerImpl$LoaderInfo2.toString());
                loaderManagerImpl$LoaderInfo2.dump(string2, fileDescriptor, printWriter, array);
            }
        }
    }
    
    void finishRetain() {
        if (this.mRetaining) {
            if (LoaderManagerImpl.DEBUG) {
                final String s = "LoaderManager";
                final StringBuilder sb = new StringBuilder();
                sb.append("Finished Retaining in ");
                sb.append(this);
                Log.v(s, sb.toString());
            }
            this.mRetaining = false;
            for (int i = this.mLoaders.size() - 1; i >= 0; --i) {
                ((LoaderManagerImpl$LoaderInfo)this.mLoaders.valueAt(i)).finishRetain();
            }
        }
    }
    
    public Loader getLoader(final int n) {
        if (this.mCreatingLoader) {
            throw new IllegalStateException("Called while creating a loader");
        }
        final LoaderManagerImpl$LoaderInfo loaderManagerImpl$LoaderInfo = (LoaderManagerImpl$LoaderInfo)this.mLoaders.get(n);
        if (loaderManagerImpl$LoaderInfo == null) {
            return null;
        }
        if (loaderManagerImpl$LoaderInfo.mPendingLoader != null) {
            return loaderManagerImpl$LoaderInfo.mPendingLoader.mLoader;
        }
        return loaderManagerImpl$LoaderInfo.mLoader;
    }
    
    public boolean hasRunningLoaders() {
        boolean b = false;
        for (int size = this.mLoaders.size(), i = 0; i < size; ++i) {
            final LoaderManagerImpl$LoaderInfo loaderManagerImpl$LoaderInfo = (LoaderManagerImpl$LoaderInfo)this.mLoaders.valueAt(i);
            b |= (loaderManagerImpl$LoaderInfo.mStarted && !loaderManagerImpl$LoaderInfo.mDeliveredData);
        }
        return b;
    }
    
    public Loader initLoader(final int n, final Bundle bundle, final LoaderManager$LoaderCallbacks mCallbacks) {
        if (!this.mCreatingLoader) {
            LoaderManagerImpl$LoaderInfo andInstallLoader = (LoaderManagerImpl$LoaderInfo)this.mLoaders.get(n);
            if (LoaderManagerImpl.DEBUG) {
                final String s = "LoaderManager";
                final StringBuilder sb = new StringBuilder();
                sb.append("initLoader in ");
                sb.append(this);
                sb.append(": args=");
                sb.append(bundle);
                Log.v(s, sb.toString());
            }
            if (andInstallLoader == null) {
                andInstallLoader = this.createAndInstallLoader(n, bundle, mCallbacks);
                if (LoaderManagerImpl.DEBUG) {
                    final String s2 = "LoaderManager";
                    final StringBuilder sb2 = new StringBuilder();
                    sb2.append("  Created new loader ");
                    sb2.append(andInstallLoader);
                    Log.v(s2, sb2.toString());
                }
            }
            else {
                if (LoaderManagerImpl.DEBUG) {
                    final String s3 = "LoaderManager";
                    final StringBuilder sb3 = new StringBuilder();
                    sb3.append("  Re-using existing loader ");
                    sb3.append(andInstallLoader);
                    Log.v(s3, sb3.toString());
                }
                andInstallLoader.mCallbacks = mCallbacks;
            }
            if (andInstallLoader.mHaveData && this.mStarted) {
                andInstallLoader.callOnLoadFinished(andInstallLoader.mLoader, andInstallLoader.mData);
            }
            return andInstallLoader.mLoader;
        }
        throw new IllegalStateException("Called while creating a loader");
    }
    
    void installLoader(final LoaderManagerImpl$LoaderInfo loaderManagerImpl$LoaderInfo) {
        this.mLoaders.put(loaderManagerImpl$LoaderInfo.mId, loaderManagerImpl$LoaderInfo);
        if (this.mStarted) {
            loaderManagerImpl$LoaderInfo.start();
        }
    }
    
    public Loader restartLoader(final int n, final Bundle bundle, final LoaderManager$LoaderCallbacks loaderManager$LoaderCallbacks) {
        if (!this.mCreatingLoader) {
            final LoaderManagerImpl$LoaderInfo loaderManagerImpl$LoaderInfo = (LoaderManagerImpl$LoaderInfo)this.mLoaders.get(n);
            if (LoaderManagerImpl.DEBUG) {
                final String s = "LoaderManager";
                final StringBuilder sb = new StringBuilder();
                sb.append("restartLoader in ");
                sb.append(this);
                sb.append(": args=");
                sb.append(bundle);
                Log.v(s, sb.toString());
            }
            if (loaderManagerImpl$LoaderInfo != null) {
                final LoaderManagerImpl$LoaderInfo loaderManagerImpl$LoaderInfo2 = (LoaderManagerImpl$LoaderInfo)this.mInactiveLoaders.get(n);
                if (loaderManagerImpl$LoaderInfo2 != null) {
                    if (loaderManagerImpl$LoaderInfo.mHaveData) {
                        if (LoaderManagerImpl.DEBUG) {
                            final String s2 = "LoaderManager";
                            final StringBuilder sb2 = new StringBuilder();
                            sb2.append("  Removing last inactive loader: ");
                            sb2.append(loaderManagerImpl$LoaderInfo);
                            Log.v(s2, sb2.toString());
                        }
                        loaderManagerImpl$LoaderInfo2.mDeliveredData = false;
                        loaderManagerImpl$LoaderInfo2.destroy();
                        loaderManagerImpl$LoaderInfo.mLoader.abandon();
                        this.mInactiveLoaders.put(n, loaderManagerImpl$LoaderInfo);
                    }
                    else {
                        if (loaderManagerImpl$LoaderInfo.cancel()) {
                            if (LoaderManagerImpl.DEBUG) {
                                Log.v("LoaderManager", "  Current loader is running; configuring pending loader");
                            }
                            if (loaderManagerImpl$LoaderInfo.mPendingLoader != null) {
                                if (LoaderManagerImpl.DEBUG) {
                                    final String s3 = "LoaderManager";
                                    final StringBuilder sb3 = new StringBuilder();
                                    sb3.append("  Removing pending loader: ");
                                    sb3.append(loaderManagerImpl$LoaderInfo.mPendingLoader);
                                    Log.v(s3, sb3.toString());
                                }
                                loaderManagerImpl$LoaderInfo.mPendingLoader.destroy();
                                loaderManagerImpl$LoaderInfo.mPendingLoader = null;
                            }
                            if (LoaderManagerImpl.DEBUG) {
                                Log.v("LoaderManager", "  Enqueuing as new pending loader");
                            }
                            loaderManagerImpl$LoaderInfo.mPendingLoader = this.createLoader(n, bundle, loaderManager$LoaderCallbacks);
                            return loaderManagerImpl$LoaderInfo.mPendingLoader.mLoader;
                        }
                        if (LoaderManagerImpl.DEBUG) {
                            Log.v("LoaderManager", "  Current loader is stopped; replacing");
                        }
                        this.mLoaders.put(n, null);
                        loaderManagerImpl$LoaderInfo.destroy();
                    }
                }
                else {
                    if (LoaderManagerImpl.DEBUG) {
                        final String s4 = "LoaderManager";
                        final StringBuilder sb4 = new StringBuilder();
                        sb4.append("  Making last loader inactive: ");
                        sb4.append(loaderManagerImpl$LoaderInfo);
                        Log.v(s4, sb4.toString());
                    }
                    loaderManagerImpl$LoaderInfo.mLoader.abandon();
                    this.mInactiveLoaders.put(n, loaderManagerImpl$LoaderInfo);
                }
            }
            return this.createAndInstallLoader(n, bundle, loaderManager$LoaderCallbacks).mLoader;
        }
        throw new IllegalStateException("Called while creating a loader");
    }
    
    public String toString() {
        final StringBuilder sb = new StringBuilder(128);
        sb.append("LoaderManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        DebugUtils.buildShortClassTag(this.mHost, sb);
        sb.append("}}");
        return sb.toString();
    }
    
    void updateHostController(final FragmentHostCallback mHost) {
        this.mHost = mHost;
    }
}
