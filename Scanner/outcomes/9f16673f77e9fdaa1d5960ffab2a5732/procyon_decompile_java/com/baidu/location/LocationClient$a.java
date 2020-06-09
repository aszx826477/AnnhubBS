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
import android.os.Build$VERSION;
import android.content.Intent;
import android.os.Messenger;
import android.content.Context;
import android.content.ServiceConnection;
import com.baidu.location.a.c;
import com.baidu.location.a.c$a;
import java.util.Iterator;
import java.util.ArrayList;
import android.os.Parcelable;
import android.os.Bundle;
import android.app.Notification;
import android.os.Message;
import android.os.Looper;
import java.lang.ref.WeakReference;
import android.os.Handler;

class LocationClient$a extends Handler
{
    private final WeakReference a;
    
    LocationClient$a(final Looper looper, final LocationClient locationClient) {
        super(looper);
        this.a = new WeakReference((T)locationClient);
    }
    
    public void handleMessage(final Message message) {
        final LocationClient locationClient = (LocationClient)this.a.get();
        if (locationClient == null) {
            return;
        }
        final int what = message.what;
        final int n = 21;
        final boolean b = true;
        if (what != n) {
            while (true) {
                BDAbstractLocationListener bdAbstractLocationListener = null;
                int int3 = 0;
                int int4 = 0;
                byte[] byteArray2 = null;
                Label_0514: {
                    if (what == 303) {
                        break Label_0514;
                    }
                    Label_0392: {
                        if (what == 406) {
                            break Label_0392;
                        }
                        Label_0376: {
                            if (what == 701) {
                                break Label_0376;
                            }
                            Label_0368: {
                                if (what == 1300) {
                                    break Label_0368;
                                }
                                Label_0360: {
                                    if (what == 1400) {
                                        break Label_0360;
                                    }
                                    Label_0353: {
                                        switch (what) {
                                            default: {
                                                switch (what) {
                                                    default: {
                                                        switch (what) {
                                                            default: {
                                                                super.handleMessage(message);
                                                                return;
                                                            }
                                                            case 704: {
                                                                break Label_0353;
                                                            }
                                                            case 703: {
                                                                break Label_0353;
                                                            }
                                                        }
                                                        break;
                                                    }
                                                    case 55: {
                                                        break Label_0353;
                                                    }
                                                    case 54: {
                                                        break Label_0353;
                                                    }
                                                }
                                                break;
                                            }
                                            case 6: {
                                                break Label_0353;
                                            }
                                            case 5: {
                                                break Label_0353;
                                            }
                                            case 4: {
                                                break Label_0353;
                                            }
                                            case 3: {
                                                break Label_0353;
                                            }
                                            case 2: {
                                                break Label_0353;
                                            }
                                            case 1: {
                                                break Label_0353;
                                            }
                                        }
                                        try {
                                            locationClient.a(message.getData().getBoolean("removenotify"));
                                            return;
                                            Bundle data = null;
                                            Parcelable parcelable;
                                            int int1 = 0;
                                            byte[] byteArray;
                                            String s;
                                            Bundle data2;
                                            int int2;
                                            ArrayList m;
                                            Iterator<BDAbstractLocationListener> iterator;
                                            BDAbstractLocationListener next;
                                            ArrayList i;
                                            Iterator<BDAbstractLocationListener> iterator2;
                                            BDAbstractLocationListener next2;
                                            Bundle data3;
                                            Block_20_Outer:Block_21_Outer:
                                            while (true) {
                                                parcelable = data.getParcelable("notification");
                                                try {
                                                    locationClient.a(int1, (Notification)parcelable);
                                                    return;
                                                    locationClient.b(message);
                                                    return;
                                                    locationClient.e(message);
                                                    return;
                                                    locationClient.d();
                                                    return;
                                                    locationClient.a((BDLocation)message.obj);
                                                    return;
                                                    // iftrue(Label_0777:, !LocationClient.f(locationClient).location_change_notify)
                                                    // iftrue(Label_0777:, !LocationClient.f(locationClient).location_change_notify)
                                                    // iftrue(Label_0438:, byteArray == null)
                                                Block_19:
                                                    while (true) {
                                                        while (true) {
                                                            locationClient.q = b;
                                                            return;
                                                            s = new String(byteArray, "UTF-8");
                                                            Label_0438: {
                                                                break Label_0438;
                                                                break Block_19;
                                                                locationClient.a();
                                                                return;
                                                            }
                                                            int2 = data2.getInt("hotspot", -1);
                                                            try {
                                                                if (locationClient.k == null) {
                                                                    return;
                                                                }
                                                                m = locationClient.k;
                                                                try {
                                                                    iterator = m.iterator();
                                                                    try {
                                                                        while (iterator.hasNext()) {
                                                                            next = iterator.next();
                                                                            try {
                                                                                next.onConnectHotSpotMessage(s, int2);
                                                                                continue Block_20_Outer;
                                                                                i = locationClient.k;
                                                                                try {
                                                                                    iterator2 = i.iterator();
                                                                                    try {
                                                                                        if (!iterator2.hasNext()) {
                                                                                            return;
                                                                                        }
                                                                                        next2 = iterator2.next();
                                                                                        try {
                                                                                            bdAbstractLocationListener = next2;
                                                                                        }
                                                                                        catch (Exception ex) {}
                                                                                    }
                                                                                    catch (Exception ex2) {}
                                                                                }
                                                                                catch (Exception ex3) {}
                                                                                data3 = message.getData();
                                                                                int3 = data3.getInt("loctype");
                                                                                int4 = data3.getInt("diagtype");
                                                                                byteArray2 = data3.getByteArray("diagmessage");
                                                                            }
                                                                            // iftrue(Label_0777:, int3 <= 0 || int4 <= 0 || byteArray2 == null || LocationClient.m(locationClient) == null)
                                                                            catch (Exception ex4) {}
                                                                        }
                                                                    }
                                                                    catch (Exception ex5) {}
                                                                }
                                                                catch (Exception ex6) {}
                                                            }
                                                            catch (Exception ex7) {}
                                                            continue Block_21_Outer;
                                                        }
                                                        locationClient.b();
                                                        return;
                                                        locationClient.c(message);
                                                        return;
                                                        data2 = message.getData();
                                                        byteArray = data2.getByteArray("mac");
                                                        s = null;
                                                        continue;
                                                    }
                                                    locationClient.q = false;
                                                    return;
                                                    locationClient.d(message);
                                                    return;
                                                    locationClient.a(message);
                                                }
                                                catch (Exception ex8) {}
                                                data = message.getData();
                                                int1 = data.getInt("id", 0);
                                                continue;
                                            }
                                        }
                                        // iftrue(Label_0777:, int1 <= 0)
                                        catch (Exception ex9) {}
                                    }
                                }
                            }
                        }
                    }
                }
                bdAbstractLocationListener.onLocDiagnosticMessage(int3, int4, new String(byteArray2, "UTF-8"));
                continue;
            }
        }
        final Bundle data4 = message.getData();
        data4.setClassLoader(BDLocation.class.getClassLoader());
        final BDLocation bdLocation = (BDLocation)data4.getParcelable("locStr");
        if (locationClient.E || locationClient.D != b || bdLocation.getLocType() != 66) {
            if (!locationClient.E && locationClient.D == b) {
                locationClient.E = b;
            }
            else {
                if (!locationClient.E) {
                    locationClient.E = b;
                }
                locationClient.a(message, n);
            }
        }
        Label_0777:;
    }
}
