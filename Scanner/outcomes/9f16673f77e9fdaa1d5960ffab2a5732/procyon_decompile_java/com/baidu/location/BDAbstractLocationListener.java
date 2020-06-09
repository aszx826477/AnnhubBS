// 
// Decompiled by Procyon v0.5.30
// 

package com.baidu.location;

public abstract class BDAbstractLocationListener
{
    public void onConnectHotSpotMessage(final String s, final int n) {
    }
    
    public void onLocDiagnosticMessage(final int n, final int n2, final String s) {
    }
    
    public abstract void onReceiveLocation(final BDLocation p0);
}
