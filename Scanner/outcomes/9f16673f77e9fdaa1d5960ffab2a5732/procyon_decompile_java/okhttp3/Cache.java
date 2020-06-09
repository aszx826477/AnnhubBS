// 
// Decompiled by Procyon v0.5.30
// 

package okhttp3;

import okio.Source;
import okio.Okio;
import java.util.Iterator;
import okhttp3.internal.Util;
import okhttp3.internal.cache.DiskLruCache$Snapshot;
import okhttp3.internal.http.HttpHeaders;
import okhttp3.internal.http.HttpMethod;
import okhttp3.internal.cache.CacheStrategy;
import okio.BufferedSource;
import okhttp3.internal.cache.CacheRequest;
import java.io.IOException;
import okhttp3.internal.cache.DiskLruCache$Editor;
import okhttp3.internal.io.FileSystem;
import java.io.File;
import okhttp3.internal.cache.InternalCache;
import okhttp3.internal.cache.DiskLruCache;
import java.io.Flushable;
import java.io.Closeable;

public final class Cache implements Closeable, Flushable
{
    private static final int ENTRY_BODY = 1;
    private static final int ENTRY_COUNT = 2;
    private static final int ENTRY_METADATA = 0;
    private static final int VERSION = 201105;
    private final DiskLruCache cache;
    private int hitCount;
    final InternalCache internalCache;
    private int networkCount;
    private int requestCount;
    private int writeAbortCount;
    private int writeSuccessCount;
    
    public Cache(final File file, final long n) {
        this(file, n, FileSystem.SYSTEM);
    }
    
    Cache(final File file, final long n, final FileSystem fileSystem) {
        this.internalCache = new Cache$1(this);
        this.cache = DiskLruCache.create(fileSystem, file, 201105, 2, n);
    }
    
    private void abortQuietly(final DiskLruCache$Editor diskLruCache$Editor) {
        if (diskLruCache$Editor != null) {
            try {
                diskLruCache$Editor.abort();
            }
            catch (IOException ex) {}
        }
    }
    
    private CacheRequest put(final Response response) {
        final String method = response.request().method();
        if (HttpMethod.invalidatesCache(response.request().method())) {
            try {
                this.remove(response.request());
            }
            catch (IOException ex) {}
            return null;
        }
        if (!method.equals("GET")) {
            return null;
        }
        if (HttpHeaders.hasVaryAll(response)) {
            return null;
        }
        final Cache$Entry cache$Entry = new Cache$Entry(response);
        DiskLruCache$Editor edit = null;
        try {
            final DiskLruCache cache = this.cache;
            try {
                final Request request = response.request();
                try {
                    final DiskLruCache$Editor diskLruCache$Editor = edit = cache.edit(urlToKey(request));
                    if (diskLruCache$Editor == null) {
                        return null;
                    }
                    cache$Entry.writeTo(diskLruCache$Editor);
                    return new Cache$CacheRequestImpl(this, edit);
                }
                catch (IOException ex2) {
                    this.abortQuietly(edit);
                    return null;
                }
            }
            catch (IOException ex3) {}
        }
        catch (IOException ex4) {}
    }
    
    private static int readInt(final BufferedSource bufferedSource) {
        try {
            final long decimalLong = bufferedSource.readDecimalLong();
            try {
                final String utf8LineStrict = bufferedSource.readUtf8LineStrict();
                if (decimalLong >= 0L && decimalLong <= 2147483647L && utf8LineStrict.isEmpty()) {
                    return (int)decimalLong;
                }
                try {
                    try {
                        final StringBuilder sb = new StringBuilder();
                        sb.append("expected an int but was \"");
                        final StringBuilder sb2 = sb;
                        try {
                            sb2.append(decimalLong);
                            final StringBuilder sb3 = sb;
                            try {
                                sb3.append(utf8LineStrict);
                                sb.append("\"");
                                throw new IOException(sb.toString());
                            }
                            catch (NumberFormatException ex) {
                                throw new IOException(ex.getMessage());
                            }
                        }
                        catch (NumberFormatException ex2) {}
                    }
                    catch (NumberFormatException ex3) {}
                }
                catch (NumberFormatException ex4) {}
            }
            catch (NumberFormatException ex5) {}
        }
        catch (NumberFormatException ex6) {}
    }
    
    private void remove(final Request request) {
        this.cache.remove(urlToKey(request));
    }
    
    private void trackConditionalCacheHit() {
        synchronized (this) {
            ++this.hitCount;
        }
    }
    
    private void trackResponse(final CacheStrategy cacheStrategy) {
        synchronized (this) {
            ++this.requestCount;
            if (cacheStrategy.networkRequest != null) {
                ++this.networkCount;
            }
            else if (cacheStrategy.cacheResponse != null) {
                ++this.hitCount;
            }
        }
    }
    
    private void update(final Response response, final Response response2) {
        final Cache$Entry cache$Entry = new Cache$Entry(response2);
        final DiskLruCache$Snapshot access$500 = ((Cache$CacheResponseBody)response.body()).snapshot;
        DiskLruCache$Editor edit = null;
        try {
            final DiskLruCache$Editor diskLruCache$Editor = edit = access$500.edit();
            if (diskLruCache$Editor != null) {
                cache$Entry.writeTo(diskLruCache$Editor);
                diskLruCache$Editor.commit();
            }
        }
        catch (IOException ex) {
            this.abortQuietly(edit);
        }
    }
    
    private static String urlToKey(final Request request) {
        return Util.md5Hex(request.url().toString());
    }
    
    public void close() {
        this.cache.close();
    }
    
    public void delete() {
        this.cache.delete();
    }
    
    public File directory() {
        return this.cache.getDirectory();
    }
    
    public void evictAll() {
        this.cache.evictAll();
    }
    
    public void flush() {
        this.cache.flush();
    }
    
    Response get(final Request request) {
        final String urlToKey = urlToKey(request);
        try {
            final DiskLruCache$Snapshot value = this.cache.get(urlToKey);
            if (value == null) {
                return null;
            }
            try {
                final Cache$Entry cache$Entry = new Cache$Entry(value.getSource(0));
                final Response response = cache$Entry.response(value);
                if (!cache$Entry.matches(request, response)) {
                    Util.closeQuietly(response.body());
                    return null;
                }
                return response;
            }
            catch (IOException ex) {
                Util.closeQuietly(value);
                return null;
            }
        }
        catch (IOException ex2) {
            return null;
        }
    }
    
    public int hitCount() {
        synchronized (this) {
            return this.hitCount;
        }
    }
    
    public void initialize() {
        this.cache.initialize();
    }
    
    public boolean isClosed() {
        return this.cache.isClosed();
    }
    
    public long maxSize() {
        return this.cache.getMaxSize();
    }
    
    public int networkCount() {
        synchronized (this) {
            return this.networkCount;
        }
    }
    
    public int requestCount() {
        synchronized (this) {
            return this.requestCount;
        }
    }
    
    public long size() {
        return this.cache.size();
    }
    
    public Iterator urls() {
        return new Cache$2(this);
    }
    
    public int writeAbortCount() {
        synchronized (this) {
            return this.writeAbortCount;
        }
    }
    
    public int writeSuccessCount() {
        synchronized (this) {
            return this.writeSuccessCount;
        }
    }
}
