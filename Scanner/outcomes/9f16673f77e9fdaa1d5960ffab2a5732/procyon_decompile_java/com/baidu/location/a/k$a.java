// 
// Decompiled by Procyon v0.5.30
// 

package com.baidu.location.a;

import android.webkit.WebSettings;
import android.os.Build$VERSION;
import com.baidu.location.LocationClient;
import android.webkit.WebView;
import android.content.Context;
import java.util.ArrayList;
import com.baidu.location.BDAbstractLocationListener;
import java.util.List;
import android.os.Message;
import java.util.Iterator;
import org.json.JSONObject;
import com.baidu.location.BDLocation;
import android.os.Looper;
import android.os.Handler;

class k$a extends Handler
{
    final /* synthetic */ k a;
    
    k$a(final k a, final Looper looper) {
        this.a = a;
        super(looper);
    }
    
    private String a(final BDLocation bdLocation) {
        String string = null;
        try {
            try {
                final JSONObject jsonObject = new JSONObject();
                jsonObject.put("latitude", bdLocation.getLatitude());
                jsonObject.put("longitude", bdLocation.getLongitude());
                jsonObject.put("radius", (double)bdLocation.getRadius());
                jsonObject.put("errorcode", 1);
                if (bdLocation.hasAltitude()) {
                    jsonObject.put("altitude", bdLocation.getAltitude());
                }
                if (bdLocation.hasSpeed()) {
                    jsonObject.put("speed", (double)(bdLocation.getSpeed() / 3.6f));
                }
                if (bdLocation.getLocType() == 61) {
                    jsonObject.put("direction", (double)bdLocation.getDirection());
                }
                if (bdLocation.getBuildingName() != null) {
                    jsonObject.put("buildingname", (Object)bdLocation.getBuildingName());
                }
                if (bdLocation.getBuildingID() != null) {
                    jsonObject.put("buildingid", (Object)bdLocation.getBuildingID());
                }
                if (bdLocation.getFloor() != null) {
                    jsonObject.put("floor", (Object)bdLocation.getFloor());
                }
                string = jsonObject.toString();
            }
            catch (Exception ex) {
                string = null;
            }
        }
        catch (Exception ex2) {}
        return string;
    }
    
    private void a(final String s) {
        if (this.a.l) {
            this.a.e.removeCallbacks((Runnable)this.a.k);
            this.a.l = false;
        }
        if (this.a.f != null && this.a.f.size() > 0) {
            final Iterator iterator = this.a.f.iterator();
            try {
                while (iterator.hasNext()) {
                    final k$b next = iterator.next();
                    try {
                        final k$b k$b = next;
                        try {
                            Label_0233: {
                                if (k$b.b() == null) {
                                    break Label_0233;
                                }
                                try {
                                    final StringBuilder sb = new StringBuilder();
                                    sb.append("javascript:");
                                    sb.append(k$b.b());
                                    sb.append("('");
                                    final StringBuilder sb2 = sb;
                                    try {
                                        sb2.append(s);
                                        sb.append("')");
                                        final String string = sb.toString();
                                        try {
                                            final k a = this.a;
                                            try {
                                                a.c.loadUrl(string);
                                                iterator.remove();
                                            }
                                            catch (Exception ex) {}
                                        }
                                        catch (Exception ex2) {}
                                    }
                                    catch (Exception ex3) {}
                                }
                                catch (Exception ex4) {}
                            }
                        }
                        catch (Exception ex5) {}
                    }
                    catch (Exception ex6) {}
                }
            }
            catch (Exception ex7) {}
        }
    }
    
    public void handleMessage(Message obtainMessage) {
        final int what = obtainMessage.what;
        final int n = 2;
        String s = null;
        switch (what) {
            default: {
                return;
            }
            case 6: {
                try {
                    try {
                        final JSONObject jsonObject = new JSONObject();
                        jsonObject.put("errorcode", n);
                        s = jsonObject.toString();
                    }
                    catch (Exception ex) {}
                }
                catch (Exception ex2) {}
                if (s != null) {
                    break;
                }
                return;
            }
            case 5: {
                try {
                    try {
                        final JSONObject jsonObject2 = new JSONObject();
                        jsonObject2.put("errorcode", 0);
                        s = jsonObject2.toString();
                    }
                    catch (Exception ex3) {}
                }
                catch (Exception ex4) {}
                if (s != null) {
                    break;
                }
                return;
            }
            case 4: {
                if (this.a.f != null) {
                    this.a.f.clear();
                    this.a.f = null;
                }
                this.a.d.unRegisterLocationListener(this.a.a);
                this.a.h = 0L;
                this.a.i = null;
                if (this.a.k != null && this.a.l) {
                    this.a.e.removeCallbacks((Runnable)this.a.k);
                }
                this.a.l = false;
                return;
            }
            case 3: {
                if (this.a.f == null) {
                    this.a.f = new ArrayList();
                }
                else {
                    this.a.f.clear();
                }
                this.a.d.registerLocationListener(this.a.a);
                return;
            }
            case 2: {
                this.a(this.a((BDLocation)obtainMessage.obj));
                return;
            }
            case 1: {
                final k$b k$b = (k$b)obtainMessage.obj;
                if (this.a.f != null) {
                    this.a.f.add(k$b);
                }
                if (this.a.d == null) {
                    return;
                }
                final int requestLocation = this.a.d.requestLocation();
                final boolean b = true;
                boolean b2 = false;
                Label_0544: {
                    if (requestLocation != 0) {
                        final long n2 = System.currentTimeMillis() - this.a.h;
                        if (this.a.i != null && n2 <= 10000L) {
                            obtainMessage = this.a.e.obtainMessage(n);
                            obtainMessage.obj = this.a.i;
                            obtainMessage.sendToTarget();
                            b2 = false;
                            break Label_0544;
                        }
                    }
                    b2 = true;
                }
                if (b2) {
                    if (this.a.l) {
                        this.a.e.removeCallbacks((Runnable)this.a.k);
                        this.a.l = false;
                    }
                    if (this.a.k == null) {
                        final k a = this.a;
                        a.k = new k$f(a, null);
                    }
                    this.a.e.postDelayed((Runnable)this.a.k, k.j);
                    this.a.l = b;
                }
                return;
            }
        }
        this.a(s);
    }
}
