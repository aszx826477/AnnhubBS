// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.app;

import android.support.v4.util.DebugUtils;
import android.os.Looper;
import android.content.IntentSender;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.MenuInflater;
import android.view.Menu;
import android.view.ContextMenu$ContextMenuInfo;
import android.view.ContextMenu;
import android.view.animation.Animation;
import android.view.MenuItem;
import android.content.res.Configuration;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v4.view.LayoutInflaterCompat;
import java.io.PrintWriter;
import java.io.FileDescriptor;
import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.os.Bundle;
import android.support.v4.util.SimpleArrayMap;
import android.view.View$OnCreateContextMenuListener;
import android.content.ComponentCallbacks;

class Fragment$1 implements Runnable
{
    final /* synthetic */ Fragment this$0;
    
    Fragment$1(final Fragment this$0) {
        this.this$0 = this$0;
    }
    
    public void run() {
        this.this$0.callStartTransitionListener();
    }
}
