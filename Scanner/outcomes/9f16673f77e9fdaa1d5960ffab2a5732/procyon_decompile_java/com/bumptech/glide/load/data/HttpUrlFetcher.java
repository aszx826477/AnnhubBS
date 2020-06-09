// 
// Decompiled by Procyon v0.5.30
// 

package com.bumptech.glide.load.data;

import com.bumptech.glide.Priority;
import java.util.Iterator;
import java.net.URI;
import java.net.URISyntaxException;
import java.io.IOException;
import java.util.Map;
import java.net.URL;
import android.util.Log;
import com.bumptech.glide.util.ContentLengthInputStream;
import android.text.TextUtils;
import java.net.HttpURLConnection;
import java.io.InputStream;
import com.bumptech.glide.load.model.GlideUrl;

public class HttpUrlFetcher implements DataFetcher
{
    private static final HttpUrlFetcher$HttpUrlConnectionFactory DEFAULT_CONNECTION_FACTORY;
    private static final int MAXIMUM_REDIRECTS = 5;
    private static final String TAG = "HttpUrlFetcher";
    private final HttpUrlFetcher$HttpUrlConnectionFactory connectionFactory;
    private final GlideUrl glideUrl;
    private volatile boolean isCancelled;
    private InputStream stream;
    private HttpURLConnection urlConnection;
    
    static {
        DEFAULT_CONNECTION_FACTORY = new HttpUrlFetcher$DefaultHttpUrlConnectionFactory(null);
    }
    
    public HttpUrlFetcher(final GlideUrl glideUrl) {
        this(glideUrl, HttpUrlFetcher.DEFAULT_CONNECTION_FACTORY);
    }
    
    HttpUrlFetcher(final GlideUrl glideUrl, final HttpUrlFetcher$HttpUrlConnectionFactory connectionFactory) {
        this.glideUrl = glideUrl;
        this.connectionFactory = connectionFactory;
    }
    
    private InputStream getStreamForSuccessfulRequest(final HttpURLConnection httpURLConnection) {
        if (TextUtils.isEmpty((CharSequence)httpURLConnection.getContentEncoding())) {
            this.stream = ContentLengthInputStream.obtain(httpURLConnection.getInputStream(), httpURLConnection.getContentLength());
        }
        else {
            if (Log.isLoggable("HttpUrlFetcher", 3)) {
                final String s = "HttpUrlFetcher";
                final StringBuilder sb = new StringBuilder();
                sb.append("Got non empty content encoding: ");
                sb.append(httpURLConnection.getContentEncoding());
                Log.d(s, sb.toString());
            }
            this.stream = httpURLConnection.getInputStream();
        }
        return this.stream;
    }
    
    private InputStream loadDataWithRedirects(final URL url, final int n, final URL url2, final Map map) {
        if (n >= 5) {
            throw new IOException("Too many (> 5) redirects!");
        }
        Label_0066: {
            if (url2 != null) {
                try {
                    final URI uri = url.toURI();
                    try {
                        if (!uri.equals(url2.toURI())) {
                            break Label_0066;
                        }
                        throw new IOException("In re-direct loop");
                    }
                    catch (URISyntaxException ex) {}
                }
                catch (URISyntaxException ex2) {}
            }
        }
        this.urlConnection = this.connectionFactory.build(url);
        for (final Map.Entry<String, V> entry : map.entrySet()) {
            this.urlConnection.addRequestProperty(entry.getKey(), (String)entry.getValue());
        }
        final HttpURLConnection urlConnection = this.urlConnection;
        final int n2 = 2500;
        urlConnection.setConnectTimeout(n2);
        this.urlConnection.setReadTimeout(n2);
        this.urlConnection.setUseCaches(false);
        this.urlConnection.setDoInput(true);
        this.urlConnection.connect();
        if (this.isCancelled) {
            return null;
        }
        final int responseCode = this.urlConnection.getResponseCode();
        if (responseCode / 100 == 2) {
            return this.getStreamForSuccessfulRequest(this.urlConnection);
        }
        if (responseCode / 100 == 3) {
            final String headerField = this.urlConnection.getHeaderField("Location");
            if (!TextUtils.isEmpty((CharSequence)headerField)) {
                return this.loadDataWithRedirects(new URL(url, headerField), n + 1, url, map);
            }
            throw new IOException("Received empty or null redirect url");
        }
        else {
            if (responseCode == -1) {
                throw new IOException("Unable to retrieve response code from HttpUrlConnection.");
            }
            final StringBuilder sb = new StringBuilder();
            sb.append("Request failed ");
            sb.append(responseCode);
            sb.append(": ");
            sb.append(this.urlConnection.getResponseMessage());
            throw new IOException(sb.toString());
        }
    }
    
    public void cancel() {
        this.isCancelled = true;
    }
    
    public void cleanup() {
        final InputStream stream = this.stream;
        if (stream != null) {
            try {
                stream.close();
            }
            catch (IOException ex) {}
        }
        final HttpURLConnection urlConnection = this.urlConnection;
        if (urlConnection != null) {
            urlConnection.disconnect();
        }
    }
    
    public String getId() {
        return this.glideUrl.getCacheKey();
    }
    
    public InputStream loadData(final Priority priority) {
        return this.loadDataWithRedirects(this.glideUrl.toURL(), 0, null, this.glideUrl.getHeaders());
    }
}
