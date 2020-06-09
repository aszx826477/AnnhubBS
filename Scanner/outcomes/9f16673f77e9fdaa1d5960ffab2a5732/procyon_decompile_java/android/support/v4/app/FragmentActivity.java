// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.app;

import android.content.IntentSender;
import android.support.v4.util.SimpleArrayMap;
import android.view.MenuItem;
import android.view.Menu;
import android.os.Parcelable;
import android.os.Bundle;
import android.content.res.Configuration;
import android.util.Log;
import android.content.Intent;
import android.app.Activity;
import android.support.v4.media.session.MediaControllerCompat;
import android.os.Build$VERSION;
import java.io.FileDescriptor;
import android.util.AttributeSet;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources$NotFoundException;
import android.view.ViewGroup;
import android.view.View;
import java.io.PrintWriter;
import android.support.v4.util.SparseArrayCompat;
import android.os.Handler;

public class FragmentActivity extends BaseFragmentActivityJB implements ActivityCompat$OnRequestPermissionsResultCallback, ActivityCompatApi23$RequestPermissionsRequestCodeValidator
{
    static final String ALLOCATED_REQUEST_INDICIES_TAG = "android:support:request_indicies";
    static final String FRAGMENTS_TAG = "android:support:fragments";
    static final int MAX_NUM_PENDING_FRAGMENT_ACTIVITY_RESULTS = 65534;
    static final int MSG_REALLY_STOPPED = 1;
    static final int MSG_RESUME_PENDING = 2;
    static final String NEXT_CANDIDATE_REQUEST_INDEX_TAG = "android:support:next_request_index";
    static final String REQUEST_FRAGMENT_WHO_TAG = "android:support:request_fragment_who";
    private static final String TAG = "FragmentActivity";
    boolean mCreated;
    final FragmentController mFragments;
    final Handler mHandler;
    int mNextCandidateRequestIndex;
    boolean mOptionsMenuInvalidated;
    SparseArrayCompat mPendingFragmentActivityResults;
    boolean mReallyStopped;
    boolean mRequestedPermissionsFromFragment;
    boolean mResumed;
    boolean mRetaining;
    boolean mStopped;
    
    public FragmentActivity() {
        this.mHandler = new FragmentActivity$1(this);
        this.mFragments = FragmentController.createController(new FragmentActivity$HostCallbacks(this));
        final boolean b = true;
        this.mStopped = b;
        this.mReallyStopped = b;
    }
    
    private int allocateRequestIndex(final Fragment fragment) {
        final int size = this.mPendingFragmentActivityResults.size();
        final char c = (char)(-2);
        if (size < c) {
            while (this.mPendingFragmentActivityResults.indexOfKey(this.mNextCandidateRequestIndex) >= 0) {
                this.mNextCandidateRequestIndex = (this.mNextCandidateRequestIndex + 1) % c;
            }
            final int mNextCandidateRequestIndex = this.mNextCandidateRequestIndex;
            this.mPendingFragmentActivityResults.put(mNextCandidateRequestIndex, fragment.mWho);
            this.mNextCandidateRequestIndex = (this.mNextCandidateRequestIndex + 1) % c;
            return mNextCandidateRequestIndex;
        }
        throw new IllegalStateException("Too many pending Fragment activity results.");
    }
    
    private void dumpViewHierarchy(String string, final PrintWriter printWriter, final View view) {
        printWriter.print(string);
        if (view == null) {
            printWriter.println("null");
            return;
        }
        printWriter.println(viewToString(view));
        if (!(view instanceof ViewGroup)) {
            return;
        }
        final ViewGroup viewGroup = (ViewGroup)view;
        final int childCount = viewGroup.getChildCount();
        if (childCount <= 0) {
            return;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append(string);
        sb.append("  ");
        string = sb.toString();
        for (int i = 0; i < childCount; ++i) {
            this.dumpViewHierarchy(string, printWriter, viewGroup.getChildAt(i));
        }
    }
    
    private static String viewToString(final View view) {
        final StringBuilder sb = new StringBuilder(128);
        sb.append(view.getClass().getName());
        sb.append('{');
        sb.append(Integer.toHexString(System.identityHashCode(view)));
        final char c = ' ';
        sb.append(c);
        final int visibility = view.getVisibility();
        char c2 = 'V';
        char c3 = '.';
        if (visibility != 0) {
            if (visibility != 4) {
                if (visibility != 8) {
                    sb.append(c3);
                }
                else {
                    sb.append('G');
                }
            }
            else {
                sb.append('I');
            }
        }
        else {
            sb.append(c2);
        }
        final boolean focusable = view.isFocusable();
        char c4 = 'F';
        char c5;
        if (focusable) {
            c5 = 'F';
        }
        else {
            c5 = '.';
        }
        sb.append(c5);
        char c6;
        if (view.isEnabled()) {
            c6 = 'E';
        }
        else {
            c6 = '.';
        }
        sb.append(c6);
        char c7;
        if (view.willNotDraw()) {
            c7 = '.';
        }
        else {
            c7 = 'D';
        }
        sb.append(c7);
        char c8;
        if (view.isHorizontalScrollBarEnabled()) {
            c8 = 'H';
        }
        else {
            c8 = '.';
        }
        sb.append(c8);
        if (!view.isVerticalScrollBarEnabled()) {
            c2 = '.';
        }
        sb.append(c2);
        char c9;
        if (view.isClickable()) {
            c9 = 'C';
        }
        else {
            c9 = '.';
        }
        sb.append(c9);
        char c10;
        if (view.isLongClickable()) {
            c10 = 'L';
        }
        else {
            c10 = '.';
        }
        sb.append(c10);
        sb.append(c);
        if (!view.isFocused()) {
            c4 = '.';
        }
        sb.append(c4);
        char c11;
        if (view.isSelected()) {
            c11 = 'S';
        }
        else {
            c11 = '.';
        }
        sb.append(c11);
        if (view.isPressed()) {
            c3 = 'P';
        }
        sb.append(c3);
        sb.append(c);
        sb.append(view.getLeft());
        final char c12 = ',';
        sb.append(c12);
        sb.append(view.getTop());
        sb.append('-');
        sb.append(view.getRight());
        sb.append(c12);
        sb.append(view.getBottom());
        final int id = view.getId();
        if (id != -1) {
            sb.append(" #");
            sb.append(Integer.toHexString(id));
            final Resources resources = view.getResources();
            if (id != 0 && resources != null) {
                final int n = 0xFF000000 & id;
                String resourceEntryName = null;
                StringBuilder sb4 = null;
                Label_0604: {
                    if (n == 16777216) {
                        break Label_0604;
                    }
                    Label_0596: {
                        if (n == 2130706432) {
                            break Label_0596;
                        }
                        final Resources resources2 = resources;
                        try {
                            String resourcePackageName = resources2.getResourcePackageName(id);
                            while (true) {
                                final String resourceTypeName = resources.getResourceTypeName(id);
                                resourceEntryName = resources.getResourceEntryName(id);
                                sb.append(" ");
                                final StringBuilder sb2 = sb;
                                try {
                                    sb2.append(resourcePackageName);
                                    sb.append(":");
                                    final StringBuilder sb3 = sb;
                                    try {
                                        sb3.append(resourceTypeName);
                                        sb.append("/");
                                        sb4 = sb;
                                    }
                                    catch (Resources$NotFoundException ex) {}
                                }
                                catch (Resources$NotFoundException ex2) {}
                                resourcePackageName = "android";
                                continue;
                                resourcePackageName = "app";
                                continue;
                            }
                        }
                        catch (Resources$NotFoundException ex3) {}
                    }
                }
                sb4.append(resourceEntryName);
            }
        }
        while (true) {
            sb.append("}");
            return sb.toString();
            continue;
        }
    }
    
    final View dispatchFragmentsOnCreateView(final View view, final String s, final Context context, final AttributeSet set) {
        return this.mFragments.onCreateView(view, s, context, set);
    }
    
    void doReallyStop(final boolean mRetaining) {
        final boolean mReallyStopped = this.mReallyStopped;
        final int mReallyStopped2 = 1;
        if (!mReallyStopped) {
            this.mReallyStopped = (mReallyStopped2 != 0);
            this.mRetaining = mRetaining;
            this.mHandler.removeMessages(mReallyStopped2);
            this.onReallyStop();
        }
        else if (mRetaining) {
            this.mFragments.doLoaderStart();
            this.mFragments.doLoaderStop(mReallyStopped2 != 0);
        }
    }
    
    public void dump(final String s, final FileDescriptor fileDescriptor, final PrintWriter printWriter, final String[] array) {
        final int sdk_INT = Build$VERSION.SDK_INT;
        printWriter.print(s);
        printWriter.print("Local FragmentActivity ");
        printWriter.print(Integer.toHexString(System.identityHashCode(this)));
        printWriter.println(" State:");
        final StringBuilder sb = new StringBuilder();
        sb.append(s);
        sb.append("  ");
        final String string = sb.toString();
        printWriter.print(string);
        printWriter.print("mCreated=");
        printWriter.print(this.mCreated);
        printWriter.print("mResumed=");
        printWriter.print(this.mResumed);
        printWriter.print(" mStopped=");
        printWriter.print(this.mStopped);
        printWriter.print(" mReallyStopped=");
        printWriter.println(this.mReallyStopped);
        this.mFragments.dumpLoaders(string, fileDescriptor, printWriter, array);
        this.mFragments.getSupportFragmentManager().dump(s, fileDescriptor, printWriter, array);
        printWriter.print(s);
        printWriter.println("View Hierarchy:");
        final StringBuilder sb2 = new StringBuilder();
        sb2.append(s);
        sb2.append("  ");
        this.dumpViewHierarchy(sb2.toString(), printWriter, this.getWindow().getDecorView());
    }
    
    public Object getLastCustomNonConfigurationInstance() {
        final FragmentActivity$NonConfigurationInstances fragmentActivity$NonConfigurationInstances = (FragmentActivity$NonConfigurationInstances)this.getLastNonConfigurationInstance();
        Object custom;
        if (fragmentActivity$NonConfigurationInstances != null) {
            custom = fragmentActivity$NonConfigurationInstances.custom;
        }
        else {
            custom = null;
        }
        return custom;
    }
    
    public FragmentManager getSupportFragmentManager() {
        return this.mFragments.getSupportFragmentManager();
    }
    
    public LoaderManager getSupportLoaderManager() {
        return this.mFragments.getSupportLoaderManager();
    }
    
    public final MediaControllerCompat getSupportMediaController() {
        return MediaControllerCompat.getMediaController(this);
    }
    
    protected void onActivityResult(final int n, final int n2, final Intent intent) {
        this.mFragments.noteStateNotSaved();
        final int n3 = n >> 16;
        if (n3 == 0) {
            super.onActivityResult(n, n2, intent);
            return;
        }
        final int n4 = n3 - 1;
        final String s = (String)this.mPendingFragmentActivityResults.get(n4);
        this.mPendingFragmentActivityResults.remove(n4);
        if (s == null) {
            Log.w("FragmentActivity", "Activity result delivered for unknown Fragment.");
            return;
        }
        final Fragment fragmentByWho = this.mFragments.findFragmentByWho(s);
        if (fragmentByWho == null) {
            final String s2 = "FragmentActivity";
            final StringBuilder sb = new StringBuilder();
            sb.append("Activity result no fragment exists for who: ");
            sb.append(s);
            Log.w(s2, sb.toString());
        }
        else {
            fragmentByWho.onActivityResult((char)(-1) & n, n2, intent);
        }
    }
    
    public void onAttachFragment(final Fragment fragment) {
    }
    
    public void onBackPressed() {
        if (!this.mFragments.getSupportFragmentManager().popBackStackImmediate()) {
            super.onBackPressed();
        }
    }
    
    public void onConfigurationChanged(final Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.mFragments.dispatchConfigurationChanged(configuration);
    }
    
    protected void onCreate(final Bundle bundle) {
        final FragmentController mFragments = this.mFragments;
        FragmentManagerNonConfig fragments = null;
        mFragments.attachHost(null);
        super.onCreate(bundle);
        final FragmentActivity$NonConfigurationInstances fragmentActivity$NonConfigurationInstances = (FragmentActivity$NonConfigurationInstances)this.getLastNonConfigurationInstance();
        if (fragmentActivity$NonConfigurationInstances != null) {
            this.mFragments.restoreLoaderNonConfig(fragmentActivity$NonConfigurationInstances.loaders);
        }
        if (bundle != null) {
            final Parcelable parcelable = bundle.getParcelable("android:support:fragments");
            final FragmentController mFragments2 = this.mFragments;
            if (fragmentActivity$NonConfigurationInstances != null) {
                fragments = fragmentActivity$NonConfigurationInstances.fragments;
            }
            mFragments2.restoreAllState(parcelable, fragments);
            if (bundle.containsKey("android:support:next_request_index")) {
                this.mNextCandidateRequestIndex = bundle.getInt("android:support:next_request_index");
                final int[] intArray = bundle.getIntArray("android:support:request_indicies");
                final String[] stringArray = bundle.getStringArray("android:support:request_fragment_who");
                if (intArray != null && stringArray != null && intArray.length == stringArray.length) {
                    this.mPendingFragmentActivityResults = new SparseArrayCompat(intArray.length);
                    for (int i = 0; i < intArray.length; ++i) {
                        this.mPendingFragmentActivityResults.put(intArray[i], stringArray[i]);
                    }
                }
                else {
                    Log.w("FragmentActivity", "Invalid requestCode mapping in savedInstanceState.");
                }
            }
        }
        if (this.mPendingFragmentActivityResults == null) {
            this.mPendingFragmentActivityResults = new SparseArrayCompat();
            this.mNextCandidateRequestIndex = 0;
        }
        this.mFragments.dispatchCreate();
    }
    
    public boolean onCreatePanelMenu(final int n, final Menu menu) {
        if (n == 0) {
            final boolean b = super.onCreatePanelMenu(n, menu) | this.mFragments.dispatchCreateOptionsMenu(menu, this.getMenuInflater());
            return Build$VERSION.SDK_INT < 11 || b;
        }
        return super.onCreatePanelMenu(n, menu);
    }
    
    protected void onDestroy() {
        super.onDestroy();
        this.doReallyStop(false);
        this.mFragments.dispatchDestroy();
        this.mFragments.doLoaderDestroy();
    }
    
    public void onLowMemory() {
        super.onLowMemory();
        this.mFragments.dispatchLowMemory();
    }
    
    public boolean onMenuItemSelected(final int n, final MenuItem menuItem) {
        if (super.onMenuItemSelected(n, menuItem)) {
            return true;
        }
        if (n != 0) {
            return n == 6 && this.mFragments.dispatchContextItemSelected(menuItem);
        }
        return this.mFragments.dispatchOptionsItemSelected(menuItem);
    }
    
    public void onMultiWindowModeChanged(final boolean b) {
        this.mFragments.dispatchMultiWindowModeChanged(b);
    }
    
    protected void onNewIntent(final Intent intent) {
        super.onNewIntent(intent);
        this.mFragments.noteStateNotSaved();
    }
    
    public void onPanelClosed(final int n, final Menu menu) {
        if (n == 0) {
            this.mFragments.dispatchOptionsMenuClosed(menu);
        }
        super.onPanelClosed(n, menu);
    }
    
    protected void onPause() {
        super.onPause();
        this.mResumed = false;
        final Handler mHandler = this.mHandler;
        final int n = 2;
        if (mHandler.hasMessages(n)) {
            this.mHandler.removeMessages(n);
            this.onResumeFragments();
        }
        this.mFragments.dispatchPause();
    }
    
    public void onPictureInPictureModeChanged(final boolean b) {
        this.mFragments.dispatchPictureInPictureModeChanged(b);
    }
    
    protected void onPostResume() {
        super.onPostResume();
        this.mHandler.removeMessages(2);
        this.onResumeFragments();
        this.mFragments.execPendingActions();
    }
    
    protected boolean onPrepareOptionsPanel(final View view, final Menu menu) {
        return super.onPreparePanel(0, view, menu);
    }
    
    public boolean onPreparePanel(final int n, final View view, final Menu menu) {
        if (n == 0 && menu != null) {
            if (this.mOptionsMenuInvalidated) {
                this.mOptionsMenuInvalidated = false;
                menu.clear();
                this.onCreatePanelMenu(n, menu);
            }
            return this.onPrepareOptionsPanel(view, menu) | this.mFragments.dispatchPrepareOptionsMenu(menu);
        }
        return super.onPreparePanel(n, view, menu);
    }
    
    void onReallyStop() {
        this.mFragments.doLoaderStop(this.mRetaining);
        this.mFragments.dispatchReallyStop();
    }
    
    public void onRequestPermissionsResult(final int n, final String[] array, final int[] array2) {
        final int n2 = n >> 16;
        final char c = (char)(-1);
        final char c2 = (char)(n2 & c);
        if (c2 != '\0') {
            final int n3 = c2 - 1;
            final String s = (String)this.mPendingFragmentActivityResults.get(n3);
            this.mPendingFragmentActivityResults.remove(n3);
            if (s == null) {
                Log.w("FragmentActivity", "Activity result delivered for unknown Fragment.");
                return;
            }
            final Fragment fragmentByWho = this.mFragments.findFragmentByWho(s);
            if (fragmentByWho == null) {
                final String s2 = "FragmentActivity";
                final StringBuilder sb = new StringBuilder();
                sb.append("Activity result no fragment exists for who: ");
                sb.append(s);
                Log.w(s2, sb.toString());
            }
            else {
                fragmentByWho.onRequestPermissionsResult(c & n, array, array2);
            }
        }
    }
    
    protected void onResume() {
        super.onResume();
        this.mHandler.sendEmptyMessage(2);
        this.mResumed = true;
        this.mFragments.execPendingActions();
    }
    
    protected void onResumeFragments() {
        this.mFragments.dispatchResume();
    }
    
    public Object onRetainCustomNonConfigurationInstance() {
        return null;
    }
    
    public final Object onRetainNonConfigurationInstance() {
        if (this.mStopped) {
            this.doReallyStop(true);
        }
        final Object onRetainCustomNonConfigurationInstance = this.onRetainCustomNonConfigurationInstance();
        final FragmentManagerNonConfig retainNestedNonConfig = this.mFragments.retainNestedNonConfig();
        final SimpleArrayMap retainLoaderNonConfig = this.mFragments.retainLoaderNonConfig();
        if (retainNestedNonConfig == null && retainLoaderNonConfig == null && onRetainCustomNonConfigurationInstance == null) {
            return null;
        }
        final FragmentActivity$NonConfigurationInstances fragmentActivity$NonConfigurationInstances = new FragmentActivity$NonConfigurationInstances();
        fragmentActivity$NonConfigurationInstances.custom = onRetainCustomNonConfigurationInstance;
        fragmentActivity$NonConfigurationInstances.fragments = retainNestedNonConfig;
        fragmentActivity$NonConfigurationInstances.loaders = retainLoaderNonConfig;
        return fragmentActivity$NonConfigurationInstances;
    }
    
    protected void onSaveInstanceState(final Bundle bundle) {
        super.onSaveInstanceState(bundle);
        final Parcelable saveAllState = this.mFragments.saveAllState();
        if (saveAllState != null) {
            bundle.putParcelable("android:support:fragments", saveAllState);
        }
        if (this.mPendingFragmentActivityResults.size() > 0) {
            bundle.putInt("android:support:next_request_index", this.mNextCandidateRequestIndex);
            final int[] array = new int[this.mPendingFragmentActivityResults.size()];
            final String[] array2 = new String[this.mPendingFragmentActivityResults.size()];
            for (int i = 0; i < this.mPendingFragmentActivityResults.size(); ++i) {
                array[i] = this.mPendingFragmentActivityResults.keyAt(i);
                array2[i] = (String)this.mPendingFragmentActivityResults.valueAt(i);
            }
            bundle.putIntArray("android:support:request_indicies", array);
            bundle.putStringArray("android:support:request_fragment_who", array2);
        }
    }
    
    protected void onStart() {
        super.onStart();
        this.mStopped = false;
        this.mReallyStopped = false;
        final Handler mHandler = this.mHandler;
        final int mCreated = 1;
        mHandler.removeMessages(mCreated);
        if (!this.mCreated) {
            this.mCreated = (mCreated != 0);
            this.mFragments.dispatchActivityCreated();
        }
        this.mFragments.noteStateNotSaved();
        this.mFragments.execPendingActions();
        this.mFragments.doLoaderStart();
        this.mFragments.dispatchStart();
        this.mFragments.reportLoaderStart();
    }
    
    public void onStateNotSaved() {
        this.mFragments.noteStateNotSaved();
    }
    
    protected void onStop() {
        super.onStop();
        final int mStopped = 1;
        this.mStopped = (mStopped != 0);
        this.mHandler.sendEmptyMessage(mStopped);
        this.mFragments.dispatchStop();
    }
    
    void requestPermissionsFromFragment(final Fragment fragment, final String[] array, final int n) {
        if (n == -1) {
            ActivityCompat.requestPermissions(this, array, n);
            return;
        }
        BaseFragmentActivityGingerbread.checkForValidRequestCode(n);
        final boolean mRequestedPermissionsFromFragment = true;
        try {
            this.mRequestedPermissionsFromFragment = mRequestedPermissionsFromFragment;
            ActivityCompat.requestPermissions(this, array, (this.allocateRequestIndex(fragment) + 1 << 16) + ((char)(-1) & n));
        }
        finally {
            this.mRequestedPermissionsFromFragment = false;
        }
    }
    
    public void setEnterSharedElementCallback(final SharedElementCallback sharedElementCallback) {
        ActivityCompat.setEnterSharedElementCallback(this, sharedElementCallback);
    }
    
    public void setExitSharedElementCallback(final SharedElementCallback sharedElementCallback) {
        ActivityCompat.setExitSharedElementCallback(this, sharedElementCallback);
    }
    
    public final void setSupportMediaController(final MediaControllerCompat mediaControllerCompat) {
        MediaControllerCompat.setMediaController(this, mediaControllerCompat);
    }
    
    public void startActivityForResult(final Intent intent, final int n) {
        if (!this.mStartedActivityFromFragment) {
            if (n != -1) {
                BaseFragmentActivityGingerbread.checkForValidRequestCode(n);
            }
        }
        super.startActivityForResult(intent, n);
    }
    
    public void startActivityFromFragment(final Fragment fragment, final Intent intent, final int n) {
        this.startActivityFromFragment(fragment, intent, n, null);
    }
    
    public void startActivityFromFragment(final Fragment fragment, final Intent intent, final int n, final Bundle bundle) {
        this.mStartedActivityFromFragment = true;
        final int n2 = -1;
        Label_0029: {
            if (n != n2) {
                break Label_0029;
            }
            final int n3 = n2;
            try {
                ActivityCompat.startActivityForResult(this, intent, n3, bundle);
                return;
                BaseFragmentActivityGingerbread.checkForValidRequestCode(n);
                ActivityCompat.startActivityForResult(this, intent, (this.allocateRequestIndex(fragment) + 1 << 16) + ((char)(-1) & n), bundle);
            }
            finally {
                this.mStartedActivityFromFragment = false;
            }
        }
    }
    
    public void startIntentSenderFromFragment(final Fragment fragment, final IntentSender intentSender, final int n, final Intent intent, final int n2, final int n3, final int n4, final Bundle bundle) {
        this.mStartedIntentSenderFromFragment = true;
        Label_0042: {
            if (n != -1) {
                break Label_0042;
            }
            try {
                ActivityCompat.startIntentSenderForResult(this, intentSender, n, intent, n2, n3, n4, bundle);
                return;
                BaseFragmentActivityGingerbread.checkForValidRequestCode(n);
                ActivityCompat.startIntentSenderForResult(this, intentSender, (this.allocateRequestIndex(fragment) + 1 << 16) + ((char)(-1) & n), intent, n2, n3, n4, bundle);
            }
            finally {
                this.mStartedIntentSenderFromFragment = false;
            }
        }
    }
    
    public void supportFinishAfterTransition() {
        ActivityCompat.finishAfterTransition(this);
    }
    
    public void supportInvalidateOptionsMenu() {
        if (Build$VERSION.SDK_INT >= 11) {
            ActivityCompatHoneycomb.invalidateOptionsMenu(this);
            return;
        }
        this.mOptionsMenuInvalidated = true;
    }
    
    public void supportPostponeEnterTransition() {
        ActivityCompat.postponeEnterTransition(this);
    }
    
    public void supportStartPostponedEnterTransition() {
        ActivityCompat.startPostponedEnterTransition(this);
    }
    
    public final void validateRequestPermissionsRequestCode(final int n) {
        if (!this.mRequestedPermissionsFromFragment && n != -1) {
            BaseFragmentActivityGingerbread.checkForValidRequestCode(n);
        }
    }
}
