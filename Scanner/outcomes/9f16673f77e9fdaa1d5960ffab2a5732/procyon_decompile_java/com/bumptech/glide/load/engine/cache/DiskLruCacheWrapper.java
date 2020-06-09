// 
// Decompiled by Procyon v0.5.30
// 

package com.bumptech.glide.load.engine.cache;

import com.bumptech.glide.disklrucache.DiskLruCache$Editor;
import com.bumptech.glide.disklrucache.DiskLruCache$Value;
import com.bumptech.glide.load.Key;
import java.io.IOException;
import android.util.Log;
import com.bumptech.glide.disklrucache.DiskLruCache;
import java.io.File;

public class DiskLruCacheWrapper implements DiskCache
{
    private static final int APP_VERSION = 1;
    private static final String TAG = "DiskLruCacheWrapper";
    private static final int VALUE_COUNT = 1;
    private static DiskLruCacheWrapper wrapper;
    private final File directory;
    private DiskLruCache diskLruCache;
    private final int maxSize;
    private final SafeKeyGenerator safeKeyGenerator;
    private final DiskCacheWriteLocker writeLocker;
    
    static {
        DiskLruCacheWrapper.wrapper = null;
    }
    
    protected DiskLruCacheWrapper(final File directory, final int maxSize) {
        this.writeLocker = new DiskCacheWriteLocker();
        this.directory = directory;
        this.maxSize = maxSize;
        this.safeKeyGenerator = new SafeKeyGenerator();
    }
    
    public static DiskCache get(final File file, final int n) {
        synchronized (DiskLruCacheWrapper.class) {
            if (DiskLruCacheWrapper.wrapper == null) {
                DiskLruCacheWrapper.wrapper = new DiskLruCacheWrapper(file, n);
            }
            return DiskLruCacheWrapper.wrapper;
        }
    }
    
    private DiskLruCache getDiskCache() {
        synchronized (this) {
            if (this.diskLruCache == null) {
                final File directory = this.directory;
                final long n = this.maxSize;
                final int n2 = 1;
                this.diskLruCache = DiskLruCache.open(directory, n2, n2, n);
            }
            return this.diskLruCache;
        }
    }
    
    private void resetDiskCache() {
        synchronized (this) {
            this.diskLruCache = null;
        }
    }
    
    public void clear() {
        // monitorenter(this)
        // monitorexit(this)
        Label_0061: {
            Label_0058: {
                DiskLruCache diskLruCache;
                try {
                    final DiskLruCache diskCache;
                    diskLruCache = (diskCache = this.getDiskCache());
                    diskCache.delete();
                    final DiskLruCacheWrapper diskLruCacheWrapper = this;
                    diskLruCacheWrapper.resetDiskCache();
                    break Label_0058;
                }
                catch (IOException ex3) {
                    final IOException ex2;
                    final IOException ex = ex2;
                    if (Log.isLoggable("DiskLruCacheWrapper", 5)) {
                        Log.w("DiskLruCacheWrapper", "Unable to clear disk cache", (Throwable)ex);
                    }
                    break Label_0058;
                }
                finally {
                    break Label_0061;
                }
                try {
                    final DiskLruCache diskCache = diskLruCache;
                    diskCache.delete();
                    final DiskLruCacheWrapper diskLruCacheWrapper = this;
                    diskLruCacheWrapper.resetDiskCache();
                }
                catch (IOException ex2) {}
            }
            return;
        }
    }
    // monitorexit(this)
    
    public void delete(final Key key) {
        final String safeKey = this.safeKeyGenerator.getSafeKey(key);
        try {
            this.getDiskCache().remove(safeKey);
        }
        catch (IOException ex) {
            if (Log.isLoggable("DiskLruCacheWrapper", 5)) {
                Log.w("DiskLruCacheWrapper", "Unable to delete from disk cache", (Throwable)ex);
            }
        }
    }
    
    public File get(final Key key) {
        final String safeKey = this.safeKeyGenerator.getSafeKey(key);
        File file = null;
        try {
            final DiskLruCache$Value value = this.getDiskCache().get(safeKey);
            if (value != null) {
                file = value.getFile(0);
            }
        }
        catch (IOException ex) {
            if (Log.isLoggable("DiskLruCacheWrapper", 5)) {
                Log.w("DiskLruCacheWrapper", "Unable to get from disk cache", (Throwable)ex);
            }
        }
        return file;
    }
    
    public void put(final Key key, final DiskCache$Writer diskCache$Writer) {
        final String safeKey = this.safeKeyGenerator.getSafeKey(key);
        this.writeLocker.acquire(key);
        while (true) {
            try {
                try {
                    final DiskLruCache$Editor edit = this.getDiskCache().edit(safeKey);
                    if (edit != null) {
                        final DiskLruCache$Editor diskLruCache$Editor = edit;
                        try {
                            if (diskCache$Writer.write(diskLruCache$Editor.getFile(0))) {
                                edit.commit();
                            }
                        }
                        finally {
                            edit.abortUnlessCommitted();
                        }
                    }
                    this.writeLocker.release(key);
                }
                finally {}
            }
            catch (IOException ex) {
                if (Log.isLoggable("DiskLruCacheWrapper", 5)) {
                    Log.w("DiskLruCacheWrapper", "Unable to put to disk cache", (Throwable)ex);
                    continue;
                }
                continue;
            }
            break;
        }
        return;
        this.writeLocker.release(key);
    }
}
