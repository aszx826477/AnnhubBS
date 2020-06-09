// 
// Decompiled by Procyon v0.5.30
// 

package com.baidu.lbsapi.auth;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;
import javax.net.ssl.HostnameVerifier;

class h implements HostnameVerifier
{
    final /* synthetic */ g a;
    
    h(final g a) {
        this.a = a;
    }
    
    public boolean verify(final String s, final SSLSession sslSession) {
        return "api.map.baidu.com".equals(s) || HttpsURLConnection.getDefaultHostnameVerifier().verify(s, sslSession);
    }
}
