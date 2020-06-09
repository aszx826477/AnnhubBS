// 
// Decompiled by Procyon v0.5.30
// 

package com.bumptech.glide.util;

import android.util.Log;
import java.util.Queue;

public final class ByteArrayPool
{
    private static final ByteArrayPool BYTE_ARRAY_POOL;
    private static final int MAX_BYTE_ARRAY_COUNT = 32;
    private static final int MAX_SIZE = 2146304;
    private static final String TAG = "ByteArrayPool";
    private static final int TEMP_BYTES_SIZE = 65536;
    private final Queue tempQueue;
    
    static {
        BYTE_ARRAY_POOL = new ByteArrayPool();
    }
    
    private ByteArrayPool() {
        this.tempQueue = Util.createQueue(0);
    }
    
    public static ByteArrayPool get() {
        return ByteArrayPool.BYTE_ARRAY_POOL;
    }
    
    public void clear() {
        synchronized (this.tempQueue) {
            this.tempQueue.clear();
        }
    }
    
    public byte[] getBytes() {
        Object tempQueue = this.tempQueue;
        synchronized (tempQueue) {
            byte[] array = this.tempQueue.poll();
            // monitorexit(tempQueue)
            if (array == null) {
                array = new byte[65536];
                tempQueue = "ByteArrayPool";
                if (Log.isLoggable((String)tempQueue, 3)) {
                    tempQueue = "ByteArrayPool";
                    Log.d((String)tempQueue, "Created temp bytes");
                }
            }
            return array;
        }
    }
    
    public boolean releaseBytes(final byte[] array) {
        if (array.length != 65536) {
            return false;
        }
        boolean b = false;
        synchronized (this.tempQueue) {
            if (this.tempQueue.size() < 32) {
                b = true;
                this.tempQueue.offer(array);
            }
            return b;
        }
    }
}
