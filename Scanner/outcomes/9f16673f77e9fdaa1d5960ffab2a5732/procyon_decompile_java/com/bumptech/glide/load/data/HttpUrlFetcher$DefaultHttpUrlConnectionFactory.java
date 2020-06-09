// 
// Decompiled by Procyon v0.5.30
// 

package com.bumptech.glide.load.data;

import java.net.HttpURLConnection;
import java.net.URL;

class HttpUrlFetcher$DefaultHttpUrlConnectionFactory implements HttpUrlFetcher$HttpUrlConnectionFactory
{
    public HttpURLConnection build(final URL url) {
        return (HttpURLConnection)url.openConnection();
    }
}
