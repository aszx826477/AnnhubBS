// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.app;

import android.support.v4.util.DebugUtils;
import java.lang.reflect.Modifier;
import java.io.PrintWriter;
import java.io.FileDescriptor;
import android.util.Log;
import android.support.v4.content.Loader;
import android.os.Bundle;
import android.support.v4.content.Loader$OnLoadCanceledListener;
import android.support.v4.content.Loader$OnLoadCompleteListener;

final class LoaderManagerImpl$LoaderInfo implements Loader$OnLoadCompleteListener, Loader$OnLoadCanceledListener
{
    final Bundle mArgs;
    LoaderManager$LoaderCallbacks mCallbacks;
    Object mData;
    boolean mDeliveredData;
    boolean mDestroyed;
    boolean mHaveData;
    final int mId;
    boolean mListenerRegistered;
    Loader mLoader;
    LoaderManagerImpl$LoaderInfo mPendingLoader;
    boolean mReportNextStart;
    boolean mRetaining;
    boolean mRetainingStarted;
    boolean mStarted;
    final /* synthetic */ LoaderManagerImpl this$0;
    
    public LoaderManagerImpl$LoaderInfo(final LoaderManagerImpl this$0, final int mId, final Bundle mArgs, final LoaderManager$LoaderCallbacks mCallbacks) {
        this.this$0 = this$0;
        this.mId = mId;
        this.mArgs = mArgs;
        this.mCallbacks = mCallbacks;
    }
    
    void callOnLoadFinished(final Loader loader, final Object o) {
        if (this.mCallbacks != null) {
            String mNoTransactionsBecause = null;
            if (this.this$0.mHost != null) {
                mNoTransactionsBecause = this.this$0.mHost.mFragmentManager.mNoTransactionsBecause;
                this.this$0.mHost.mFragmentManager.mNoTransactionsBecause = "onLoadFinished";
            }
            try {
                if (LoaderManagerImpl.DEBUG) {
                    final String s = "LoaderManager";
                    final StringBuilder sb = new StringBuilder();
                    sb.append("  onLoadFinished in ");
                    sb.append(loader);
                    sb.append(": ");
                    sb.append(loader.dataToString(o));
                    Log.v(s, sb.toString());
                }
                this.mCallbacks.onLoadFinished(loader, o);
                if (this.this$0.mHost != null) {
                    this.this$0.mHost.mFragmentManager.mNoTransactionsBecause = mNoTransactionsBecause;
                }
                this.mDeliveredData = true;
            }
            finally {
                if (this.this$0.mHost != null) {
                    this.this$0.mHost.mFragmentManager.mNoTransactionsBecause = mNoTransactionsBecause;
                }
            }
        }
    }
    
    boolean cancel() {
        if (LoaderManagerImpl.DEBUG) {
            final String s = "LoaderManager";
            final StringBuilder sb = new StringBuilder();
            sb.append("  Canceling: ");
            sb.append(this);
            Log.v(s, sb.toString());
        }
        if (this.mStarted) {
            final Loader mLoader = this.mLoader;
            if (mLoader != null && this.mListenerRegistered) {
                final boolean cancelLoad = mLoader.cancelLoad();
                if (!cancelLoad) {
                    this.onLoadCanceled(this.mLoader);
                }
                return cancelLoad;
            }
        }
        return false;
    }
    
    void destroy() {
        if (LoaderManagerImpl.DEBUG) {
            final String s = "LoaderManager";
            final StringBuilder sb = new StringBuilder();
            sb.append("  Destroying: ");
            sb.append(this);
            Log.v(s, sb.toString());
        }
        this.mDestroyed = true;
        final boolean mDeliveredData = this.mDeliveredData;
        this.mDeliveredData = false;
        if (this.mCallbacks != null && this.mLoader != null && this.mHaveData && mDeliveredData) {
            if (LoaderManagerImpl.DEBUG) {
                final String s2 = "LoaderManager";
                final StringBuilder sb2 = new StringBuilder();
                sb2.append("  Resetting: ");
                sb2.append(this);
                Log.v(s2, sb2.toString());
            }
            String mNoTransactionsBecause = null;
            if (this.this$0.mHost != null) {
                mNoTransactionsBecause = this.this$0.mHost.mFragmentManager.mNoTransactionsBecause;
                this.this$0.mHost.mFragmentManager.mNoTransactionsBecause = "onLoaderReset";
            }
            try {
                this.mCallbacks.onLoaderReset(this.mLoader);
            }
            finally {
                if (this.this$0.mHost != null) {
                    this.this$0.mHost.mFragmentManager.mNoTransactionsBecause = mNoTransactionsBecause;
                }
            }
        }
        this.mCallbacks = null;
        this.mData = null;
        this.mHaveData = false;
        final Loader mLoader = this.mLoader;
        if (mLoader != null) {
            if (this.mListenerRegistered) {
                this.mListenerRegistered = false;
                mLoader.unregisterListener(this);
                this.mLoader.unregisterOnLoadCanceledListener(this);
            }
            this.mLoader.reset();
        }
        final LoaderManagerImpl$LoaderInfo mPendingLoader = this.mPendingLoader;
        if (mPendingLoader != null) {
            mPendingLoader.destroy();
        }
    }
    
    public void dump(final String s, final FileDescriptor fileDescriptor, final PrintWriter printWriter, final String[] array) {
        printWriter.print(s);
        printWriter.print("mId=");
        printWriter.print(this.mId);
        printWriter.print(" mArgs=");
        printWriter.println(this.mArgs);
        printWriter.print(s);
        printWriter.print("mCallbacks=");
        printWriter.println(this.mCallbacks);
        printWriter.print(s);
        printWriter.print("mLoader=");
        printWriter.println(this.mLoader);
        final Loader mLoader = this.mLoader;
        if (mLoader != null) {
            final StringBuilder sb = new StringBuilder();
            sb.append(s);
            sb.append("  ");
            mLoader.dump(sb.toString(), fileDescriptor, printWriter, array);
        }
        if (this.mHaveData || this.mDeliveredData) {
            printWriter.print(s);
            printWriter.print("mHaveData=");
            printWriter.print(this.mHaveData);
            printWriter.print("  mDeliveredData=");
            printWriter.println(this.mDeliveredData);
            printWriter.print(s);
            printWriter.print("mData=");
            printWriter.println(this.mData);
        }
        printWriter.print(s);
        printWriter.print("mStarted=");
        printWriter.print(this.mStarted);
        printWriter.print(" mReportNextStart=");
        printWriter.print(this.mReportNextStart);
        printWriter.print(" mDestroyed=");
        printWriter.println(this.mDestroyed);
        printWriter.print(s);
        printWriter.print("mRetaining=");
        printWriter.print(this.mRetaining);
        printWriter.print(" mRetainingStarted=");
        printWriter.print(this.mRetainingStarted);
        printWriter.print(" mListenerRegistered=");
        printWriter.println(this.mListenerRegistered);
        if (this.mPendingLoader != null) {
            printWriter.print(s);
            printWriter.println("Pending Loader ");
            printWriter.print(this.mPendingLoader);
            printWriter.println(":");
            final LoaderManagerImpl$LoaderInfo mPendingLoader = this.mPendingLoader;
            final StringBuilder sb2 = new StringBuilder();
            sb2.append(s);
            sb2.append("  ");
            mPendingLoader.dump(sb2.toString(), fileDescriptor, printWriter, array);
        }
    }
    
    void finishRetain() {
        if (this.mRetaining) {
            if (LoaderManagerImpl.DEBUG) {
                final String s = "LoaderManager";
                final StringBuilder sb = new StringBuilder();
                sb.append("  Finished Retaining: ");
                sb.append(this);
                Log.v(s, sb.toString());
            }
            this.mRetaining = false;
            final boolean mStarted = this.mStarted;
            if (mStarted != this.mRetainingStarted) {
                if (!mStarted) {
                    this.stop();
                }
            }
        }
        if (this.mStarted && this.mHaveData && !this.mReportNextStart) {
            this.callOnLoadFinished(this.mLoader, this.mData);
        }
    }
    
    public void onLoadCanceled(final Loader loader) {
        if (LoaderManagerImpl.DEBUG) {
            final String s = "LoaderManager";
            final StringBuilder sb = new StringBuilder();
            sb.append("onLoadCanceled: ");
            sb.append(this);
            Log.v(s, sb.toString());
        }
        if (this.mDestroyed) {
            if (LoaderManagerImpl.DEBUG) {
                Log.v("LoaderManager", "  Ignoring load canceled -- destroyed");
            }
            return;
        }
        if (this.this$0.mLoaders.get(this.mId) != this) {
            if (LoaderManagerImpl.DEBUG) {
                Log.v("LoaderManager", "  Ignoring load canceled -- not active");
            }
            return;
        }
        final LoaderManagerImpl$LoaderInfo mPendingLoader = this.mPendingLoader;
        if (mPendingLoader != null) {
            if (LoaderManagerImpl.DEBUG) {
                final String s2 = "LoaderManager";
                final StringBuilder sb2 = new StringBuilder();
                sb2.append("  Switching to pending loader: ");
                sb2.append(mPendingLoader);
                Log.v(s2, sb2.toString());
            }
            this.mPendingLoader = null;
            this.this$0.mLoaders.put(this.mId, null);
            this.destroy();
            this.this$0.installLoader(mPendingLoader);
        }
    }
    
    public void onLoadComplete(final Loader loader, final Object mData) {
        if (LoaderManagerImpl.DEBUG) {
            final String s = "LoaderManager";
            final StringBuilder sb = new StringBuilder();
            sb.append("onLoadComplete: ");
            sb.append(this);
            Log.v(s, sb.toString());
        }
        if (this.mDestroyed) {
            if (LoaderManagerImpl.DEBUG) {
                Log.v("LoaderManager", "  Ignoring load complete -- destroyed");
            }
            return;
        }
        if (this.this$0.mLoaders.get(this.mId) != this) {
            if (LoaderManagerImpl.DEBUG) {
                Log.v("LoaderManager", "  Ignoring load complete -- not active");
            }
            return;
        }
        final LoaderManagerImpl$LoaderInfo mPendingLoader = this.mPendingLoader;
        if (mPendingLoader != null) {
            if (LoaderManagerImpl.DEBUG) {
                final String s2 = "LoaderManager";
                final StringBuilder sb2 = new StringBuilder();
                sb2.append("  Switching to pending loader: ");
                sb2.append(mPendingLoader);
                Log.v(s2, sb2.toString());
            }
            this.mPendingLoader = null;
            this.this$0.mLoaders.put(this.mId, null);
            this.destroy();
            this.this$0.installLoader(mPendingLoader);
            return;
        }
        if (this.mData != mData || this.mHaveData) {
            this.mData = mData;
            this.mHaveData = true;
            if (this.mStarted) {
                this.callOnLoadFinished(loader, mData);
            }
        }
        final LoaderManagerImpl$LoaderInfo loaderManagerImpl$LoaderInfo = (LoaderManagerImpl$LoaderInfo)this.this$0.mInactiveLoaders.get(this.mId);
        if (loaderManagerImpl$LoaderInfo != null && loaderManagerImpl$LoaderInfo != this) {
            loaderManagerImpl$LoaderInfo.mDeliveredData = false;
            loaderManagerImpl$LoaderInfo.destroy();
            this.this$0.mInactiveLoaders.remove(this.mId);
        }
        if (this.this$0.mHost != null && !this.this$0.hasRunningLoaders()) {
            this.this$0.mHost.mFragmentManager.startPendingDeferredFragments();
        }
    }
    
    void reportStart() {
        if (this.mStarted) {
            if (this.mReportNextStart) {
                this.mReportNextStart = false;
                if (this.mHaveData && !this.mRetaining) {
                    this.callOnLoadFinished(this.mLoader, this.mData);
                }
            }
        }
    }
    
    void retain() {
        if (LoaderManagerImpl.DEBUG) {
            final String s = "LoaderManager";
            final StringBuilder sb = new StringBuilder();
            sb.append("  Retaining: ");
            sb.append(this);
            Log.v(s, sb.toString());
        }
        this.mRetaining = true;
        this.mRetainingStarted = this.mStarted;
        this.mStarted = false;
        this.mCallbacks = null;
    }
    
    void start() {
        final boolean mRetaining = this.mRetaining;
        final boolean mListenerRegistered = true;
        if (mRetaining && this.mRetainingStarted) {
            this.mStarted = mListenerRegistered;
            return;
        }
        if (this.mStarted) {
            return;
        }
        this.mStarted = mListenerRegistered;
        if (LoaderManagerImpl.DEBUG) {
            final String s = "LoaderManager";
            final StringBuilder sb = new StringBuilder();
            sb.append("  Starting: ");
            sb.append(this);
            Log.v(s, sb.toString());
        }
        if (this.mLoader == null) {
            final LoaderManager$LoaderCallbacks mCallbacks = this.mCallbacks;
            if (mCallbacks != null) {
                this.mLoader = mCallbacks.onCreateLoader(this.mId, this.mArgs);
            }
        }
        final Loader mLoader = this.mLoader;
        if (mLoader != null) {
            if (mLoader.getClass().isMemberClass() && !Modifier.isStatic(this.mLoader.getClass().getModifiers())) {
                final StringBuilder sb2 = new StringBuilder();
                sb2.append("Object returned from onCreateLoader must not be a non-static inner member class: ");
                sb2.append(this.mLoader);
                throw new IllegalArgumentException(sb2.toString());
            }
            if (!this.mListenerRegistered) {
                this.mLoader.registerListener(this.mId, this);
                this.mLoader.registerOnLoadCanceledListener(this);
                this.mListenerRegistered = mListenerRegistered;
            }
            this.mLoader.startLoading();
        }
    }
    
    void stop() {
        if (LoaderManagerImpl.DEBUG) {
            final String s = "LoaderManager";
            final StringBuilder sb = new StringBuilder();
            sb.append("  Stopping: ");
            sb.append(this);
            Log.v(s, sb.toString());
        }
        this.mStarted = false;
        if (!this.mRetaining) {
            final Loader mLoader = this.mLoader;
            if (mLoader != null && this.mListenerRegistered) {
                this.mListenerRegistered = false;
                mLoader.unregisterListener(this);
                this.mLoader.unregisterOnLoadCanceledListener(this);
                this.mLoader.stopLoading();
            }
        }
    }
    
    public String toString() {
        final StringBuilder sb = new StringBuilder(64);
        sb.append("LoaderInfo{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" #");
        sb.append(this.mId);
        sb.append(" : ");
        DebugUtils.buildShortClassTag(this.mLoader, sb);
        sb.append("}}");
        return sb.toString();
    }
}
