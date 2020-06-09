// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.app;

import android.content.Intent;
import android.os.Build$VERSION;
import android.os.Bundle;

public final class RemoteInput extends RemoteInputCompatBase$RemoteInput
{
    public static final String EXTRA_RESULTS_DATA = "android.remoteinput.resultsData";
    public static final RemoteInputCompatBase$RemoteInput$Factory FACTORY;
    private static final RemoteInput$Impl IMPL;
    public static final String RESULTS_CLIP_LABEL = "android.remoteinput.results";
    private static final String TAG = "RemoteInput";
    private final boolean mAllowFreeFormInput;
    private final CharSequence[] mChoices;
    private final Bundle mExtras;
    private final CharSequence mLabel;
    private final String mResultKey;
    
    static {
        if (Build$VERSION.SDK_INT >= 20) {
            IMPL = new RemoteInput$ImplApi20();
        }
        else if (Build$VERSION.SDK_INT >= 16) {
            IMPL = new RemoteInput$ImplJellybean();
        }
        else {
            IMPL = new RemoteInput$ImplBase();
        }
        FACTORY = new RemoteInput$1();
    }
    
    RemoteInput(final String mResultKey, final CharSequence mLabel, final CharSequence[] mChoices, final boolean mAllowFreeFormInput, final Bundle mExtras) {
        this.mResultKey = mResultKey;
        this.mLabel = mLabel;
        this.mChoices = mChoices;
        this.mAllowFreeFormInput = mAllowFreeFormInput;
        this.mExtras = mExtras;
    }
    
    public static void addResultsToIntent(final RemoteInput[] array, final Intent intent, final Bundle bundle) {
        RemoteInput.IMPL.addResultsToIntent(array, intent, bundle);
    }
    
    public static Bundle getResultsFromIntent(final Intent intent) {
        return RemoteInput.IMPL.getResultsFromIntent(intent);
    }
    
    public boolean getAllowFreeFormInput() {
        return this.mAllowFreeFormInput;
    }
    
    public CharSequence[] getChoices() {
        return this.mChoices;
    }
    
    public Bundle getExtras() {
        return this.mExtras;
    }
    
    public CharSequence getLabel() {
        return this.mLabel;
    }
    
    public String getResultKey() {
        return this.mResultKey;
    }
}
