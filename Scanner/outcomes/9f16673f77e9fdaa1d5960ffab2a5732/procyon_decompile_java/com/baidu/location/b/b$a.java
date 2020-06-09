// 
// Decompiled by Procyon v0.5.30
// 

package com.baidu.location.b;

import com.baidu.location.f;
import java.util.Locale;
import android.telephony.NeighboringCellInfo;
import java.util.LinkedList;
import java.io.RandomAccessFile;
import java.io.File;
import com.baidu.location.d.j;
import java.util.Iterator;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import android.telephony.CellSignalStrengthWcdma;
import android.telephony.CellIdentityWcdma;
import android.telephony.CellIdentityLte;
import android.telephony.CellIdentityCdma;
import android.telephony.CellIdentityGsm;
import android.os.SystemClock;
import android.telephony.CellInfoWcdma;
import android.telephony.CellInfoLte;
import android.telephony.CellInfoCdma;
import android.telephony.CellInfoGsm;
import android.os.Build$VERSION;
import android.telephony.CellInfo;
import android.os.Handler;
import java.util.List;
import android.telephony.TelephonyManager;
import java.lang.reflect.Method;
import android.telephony.SignalStrength;
import android.telephony.CellLocation;
import android.telephony.PhoneStateListener;

class b$a extends PhoneStateListener
{
    final /* synthetic */ b a;
    
    public b$a(final b a) {
        this.a = a;
    }
    
    public void onCellLocationChanged(final CellLocation cellLocation) {
        if (cellLocation == null) {
            return;
        }
        this.a.r.post((Runnable)new c(this));
    }
    
    public void onSignalStrengthsChanged(final SignalStrength signalStrength) {
        if (this.a.f != null) {
            a a;
            int h;
            if (this.a.f.i == 'g') {
                a = this.a.f;
                h = signalStrength.getGsmSignalStrength();
            }
            else {
                if (this.a.f.i != 'c') {
                    return;
                }
                a = this.a.f;
                h = signalStrength.getCdmaDbm();
            }
            a.h = h;
        }
    }
}
