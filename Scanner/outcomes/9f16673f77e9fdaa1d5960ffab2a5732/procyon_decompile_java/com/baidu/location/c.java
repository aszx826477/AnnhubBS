// 
// Decompiled by Procyon v0.5.30
// 

package com.baidu.location;

import android.location.Location;
import android.text.TextUtils;
import com.baidu.location.a.j;
import android.util.Log;
import android.webkit.WebView;
import com.baidu.location.a.k;
import android.os.Bundle;
import android.os.Message;
import android.os.Build$VERSION;
import android.os.Parcelable;
import android.app.Notification;
import java.util.Iterator;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import java.util.ArrayList;
import android.os.Messenger;
import android.content.Context;
import android.content.ServiceConnection;
import com.baidu.location.a.c$a;

class c extends Thread
{
    final /* synthetic */ LocationClient a;
    
    c(final LocationClient a) {
        this.a = a;
    }
    
    public void run() {
        if (this.a.C == null) {
            final LocationClient a = this.a;
            a.C = new com.baidu.location.a.c(a.f, this.a.d, this.a);
        }
        this.a.C.c();
    }
}
