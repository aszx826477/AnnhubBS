// 
// Decompiled by Procyon v0.5.30
// 

package com.baidu.location.a;

import com.baidu.location.f;
import android.os.Message;
import android.os.Handler;

public class i$a extends Handler
{
    final /* synthetic */ i a;
    
    public i$a(final i a) {
        this.a = a;
    }
    
    public void handleMessage(final Message message) {
        if (!f.isServing) {
            return;
        }
        final int what = message.what;
        if (what != 21) {
            switch (what) {
                case 62:
                case 63: {
                    this.a.a();
                    break;
                }
            }
        }
        else {
            this.a.a(message);
        }
    }
}
