// 
// Decompiled by Procyon v0.5.30
// 

package com.baidu.location.a;

import android.webkit.WebSettings;
import android.os.Looper;
import android.os.Build$VERSION;
import java.util.List;
import android.webkit.WebView;
import android.content.Context;
import android.os.Message;
import com.baidu.location.LocationClient;
import com.baidu.location.BDLocation;
import com.baidu.location.BDAbstractLocationListener;

public class k$e extends BDAbstractLocationListener
{
    final /* synthetic */ k a;
    
    public k$e(final k a) {
        this.a = a;
    }
    
    public void onReceiveLocation(BDLocation bdLocationInCoorType) {
        if (this.a.g && bdLocationInCoorType != null) {
            BDLocation obj = new BDLocation(bdLocationInCoorType);
            final int locType = obj.getLocType();
            final String coorType = obj.getCoorType();
            Message message;
            if (locType != 61 && locType != 161 && locType != 66) {
                message = this.a.e.obtainMessage(5);
            }
            else {
                Label_0185: {
                    if (coorType != null) {
                        if (coorType.equals("gcj02")) {
                            obj = LocationClient.getBDLocationInCoorType(obj, "gcj2wgs");
                        }
                        else {
                            String s;
                            if (coorType.equals("bd09")) {
                                s = "bd092gcj";
                            }
                            else {
                                if (!coorType.equals("bd09ll")) {
                                    break Label_0185;
                                }
                                s = "bd09ll2gcj";
                            }
                            bdLocationInCoorType = LocationClient.getBDLocationInCoorType(obj, s);
                            obj = LocationClient.getBDLocationInCoorType(bdLocationInCoorType, "gcj2wgs");
                        }
                    }
                }
                this.a.h = System.currentTimeMillis();
                this.a.i = new BDLocation(obj);
                message = this.a.e.obtainMessage(2);
                message.obj = obj;
            }
            message.sendToTarget();
        }
    }
}
