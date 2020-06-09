// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.app;

import android.os.Bundle;

public final class RemoteInput$Builder
{
    private boolean mAllowFreeFormInput;
    private CharSequence[] mChoices;
    private Bundle mExtras;
    private CharSequence mLabel;
    private final String mResultKey;
    
    public RemoteInput$Builder(final String mResultKey) {
        this.mAllowFreeFormInput = true;
        this.mExtras = new Bundle();
        if (mResultKey != null) {
            this.mResultKey = mResultKey;
            return;
        }
        throw new IllegalArgumentException("Result key can't be null");
    }
    
    public RemoteInput$Builder addExtras(final Bundle bundle) {
        if (bundle != null) {
            this.mExtras.putAll(bundle);
        }
        return this;
    }
    
    public RemoteInput build() {
        return new RemoteInput(this.mResultKey, this.mLabel, this.mChoices, this.mAllowFreeFormInput, this.mExtras);
    }
    
    public Bundle getExtras() {
        return this.mExtras;
    }
    
    public RemoteInput$Builder setAllowFreeFormInput(final boolean mAllowFreeFormInput) {
        this.mAllowFreeFormInput = mAllowFreeFormInput;
        return this;
    }
    
    public RemoteInput$Builder setChoices(final CharSequence[] mChoices) {
        this.mChoices = mChoices;
        return this;
    }
    
    public RemoteInput$Builder setLabel(final CharSequence mLabel) {
        this.mLabel = mLabel;
        return this;
    }
}
