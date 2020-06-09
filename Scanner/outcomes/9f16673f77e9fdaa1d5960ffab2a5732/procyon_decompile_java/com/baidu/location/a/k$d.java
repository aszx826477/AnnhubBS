// 
// Decompiled by Procyon v0.5.30
// 

package com.baidu.location.a;

import android.webkit.WebSettings;
import android.os.Looper;
import android.os.Build$VERSION;
import com.baidu.location.BDLocation;
import java.util.List;
import com.baidu.location.LocationClient;
import android.webkit.WebView;
import android.content.Context;
import android.os.Message;

class k$d
{
    final /* synthetic */ k a;
    
    private k$d(final k a) {
        this.a = a;
    }
    
    public void sendMessage(String s) {
        if (s != null && this.a.g) {
            final k$b obj = new k$b(this.a, s);
            s = obj.a();
            if (s != null) {
                s = obj.a();
                if (s.equals("requestLoc") && this.a.e != null) {
                    final Message obtainMessage = this.a.e.obtainMessage(1);
                    obtainMessage.obj = obj;
                    obtainMessage.sendToTarget();
                }
            }
        }
    }
    
    public void showLog(final String s) {
    }
}
