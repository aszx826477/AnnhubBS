// 
// Decompiled by Procyon v0.5.30
// 

package com.bumptech.glide.util;

import android.util.Log;
import android.text.TextUtils;
import java.io.IOException;
import java.io.InputStream;
import java.io.FilterInputStream;

public final class ContentLengthInputStream extends FilterInputStream
{
    private static final String TAG = "ContentLengthStream";
    private static final int UNKNOWN = 255;
    private final long contentLength;
    private int readSoFar;
    
    ContentLengthInputStream(final InputStream inputStream, final long contentLength) {
        super(inputStream);
        this.contentLength = contentLength;
    }
    
    private int checkReadSoFarOrThrow(final int n) {
        if (n >= 0) {
            this.readSoFar += n;
        }
        else if (this.contentLength - this.readSoFar > 0L) {
            final StringBuilder sb = new StringBuilder();
            sb.append("Failed to read all expected data, expected: ");
            sb.append(this.contentLength);
            sb.append(", but read: ");
            sb.append(this.readSoFar);
            throw new IOException(sb.toString());
        }
        return n;
    }
    
    public static InputStream obtain(final InputStream inputStream, final long n) {
        return new ContentLengthInputStream(inputStream, n);
    }
    
    public static InputStream obtain(final InputStream inputStream, final String s) {
        return obtain(inputStream, parseContentLength(s));
    }
    
    private static int parseContentLength(final String s) {
        int int1 = -1;
        if (!TextUtils.isEmpty((CharSequence)s)) {
            try {
                int1 = Integer.parseInt(s);
            }
            catch (NumberFormatException ex) {
                if (Log.isLoggable("ContentLengthStream", 3)) {
                    final String s2 = "ContentLengthStream";
                    final StringBuilder sb = new StringBuilder();
                    sb.append("failed to parse content length header: ");
                    sb.append(s);
                    Log.d(s2, sb.toString(), (Throwable)ex);
                }
            }
        }
        return int1;
    }
    
    public int available() {
        synchronized (this) {
            return (int)Math.max(this.contentLength - this.readSoFar, this.in.available());
        }
    }
    
    public int read() {
        synchronized (this) {
            return this.checkReadSoFarOrThrow(super.read());
        }
    }
    
    public int read(final byte[] array) {
        return this.read(array, 0, array.length);
    }
    
    public int read(final byte[] array, final int n, final int n2) {
        synchronized (this) {
            return this.checkReadSoFarOrThrow(super.read(array, n, n2));
        }
    }
}
