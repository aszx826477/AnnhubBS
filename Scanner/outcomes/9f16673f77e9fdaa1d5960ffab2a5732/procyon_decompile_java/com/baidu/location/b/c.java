// 
// Decompiled by Procyon v0.5.30
// 

package com.baidu.location.b;

import android.telephony.PhoneStateListener;
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
import android.telephony.CellLocation;
import android.os.Handler;
import java.util.List;
import android.telephony.TelephonyManager;
import java.lang.reflect.Method;

class c implements Runnable
{
    final /* synthetic */ b$a a;
    
    c(final b$a a) {
        this.a = a;
    }
    
    public void run() {
        try {
            final b$a a = this.a;
            try {
                final b a2 = a.a;
                try {
                    a2.k();
                }
                catch (Exception ex) {}
            }
            catch (Exception ex2) {}
        }
        catch (Exception ex3) {}
    }
}
