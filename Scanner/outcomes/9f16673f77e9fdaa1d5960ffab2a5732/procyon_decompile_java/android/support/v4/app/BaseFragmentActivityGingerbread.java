// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.app;

import android.content.Intent;
import android.content.IntentSender;
import android.view.LayoutInflater$Factory;
import android.os.Build$VERSION;
import android.os.Bundle;
import android.util.AttributeSet;
import android.content.Context;
import android.view.View;

abstract class BaseFragmentActivityGingerbread extends SupportActivity
{
    boolean mStartedIntentSenderFromFragment;
    
    static void checkForValidRequestCode(final int n) {
        if ((0xFFFF0000 & n) == 0x0) {
            return;
        }
        throw new IllegalArgumentException("Can only use lower 16 bits for requestCode");
    }
    
    abstract View dispatchFragmentsOnCreateView(final View p0, final String p1, final Context p2, final AttributeSet p3);
    
    protected void onCreate(final Bundle bundle) {
        if (Build$VERSION.SDK_INT < 11 && this.getLayoutInflater().getFactory() == null) {
            this.getLayoutInflater().setFactory((LayoutInflater$Factory)this);
        }
        super.onCreate(bundle);
    }
    
    public View onCreateView(final String s, final Context context, final AttributeSet set) {
        final View dispatchFragmentsOnCreateView = this.dispatchFragmentsOnCreateView(null, s, context, set);
        if (dispatchFragmentsOnCreateView == null) {
            return super.onCreateView(s, context, set);
        }
        return dispatchFragmentsOnCreateView;
    }
    
    public void startIntentSenderForResult(final IntentSender intentSender, final int n, final Intent intent, final int n2, final int n3, final int n4) {
        if (!this.mStartedIntentSenderFromFragment) {
            if (n != -1) {
                checkForValidRequestCode(n);
            }
        }
        super.startIntentSenderForResult(intentSender, n, intent, n2, n3, n4);
    }
}
