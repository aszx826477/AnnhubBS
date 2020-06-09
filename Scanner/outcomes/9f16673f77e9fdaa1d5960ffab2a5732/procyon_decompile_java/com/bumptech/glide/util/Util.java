// 
// Decompiled by Procyon v0.5.30
// 

package com.bumptech.glide.util;

import android.os.Looper;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.List;
import java.util.Collection;
import android.os.Build$VERSION;
import android.graphics.Bitmap;
import android.graphics.Bitmap$Config;
import java.util.ArrayDeque;
import java.util.Queue;

public final class Util
{
    private static final char[] HEX_CHAR_ARRAY;
    private static final char[] SHA_1_CHARS;
    private static final char[] SHA_256_CHARS;
    
    static {
        HEX_CHAR_ARRAY = "0123456789abcdef".toCharArray();
        SHA_256_CHARS = new char[64];
        SHA_1_CHARS = new char[40];
    }
    
    public static void assertBackgroundThread() {
        if (isOnBackgroundThread()) {
            return;
        }
        throw new IllegalArgumentException("YOu must call this method on a background thread");
    }
    
    public static void assertMainThread() {
        if (isOnMainThread()) {
            return;
        }
        throw new IllegalArgumentException("You must call this method on the main thread");
    }
    
    private static String bytesToHex(final byte[] array, final char[] array2) {
        for (int i = 0; i < array.length; ++i) {
            final int n = array[i] & 0xFF;
            final int n2 = i * 2;
            final char[] hex_CHAR_ARRAY = Util.HEX_CHAR_ARRAY;
            array2[n2] = hex_CHAR_ARRAY[n >>> 4];
            array2[i * 2 + 1] = hex_CHAR_ARRAY[n & 0xF];
        }
        return new String(array2);
    }
    
    public static Queue createQueue(final int n) {
        return new ArrayDeque(n);
    }
    
    public static int getBitmapByteSize(final int n, final int n2, final Bitmap$Config bitmap$Config) {
        return n * n2 * getBytesPerPixel(bitmap$Config);
    }
    
    public static int getBitmapByteSize(final Bitmap bitmap) {
        if (Build$VERSION.SDK_INT >= 19) {
            try {
                return bitmap.getAllocationByteCount();
            }
            catch (NullPointerException ex) {}
        }
        return bitmap.getHeight() * bitmap.getRowBytes();
    }
    
    private static int getBytesPerPixel(Bitmap$Config argb_8888) {
        if (argb_8888 == null) {
            argb_8888 = Bitmap$Config.ARGB_8888;
        }
        int n = 0;
        switch (Util$1.$SwitchMap$android$graphics$Bitmap$Config[argb_8888.ordinal()]) {
            default: {
                n = 4;
                break;
            }
            case 2:
            case 3: {
                n = 2;
                break;
            }
            case 1: {
                n = 1;
                break;
            }
        }
        return n;
    }
    
    public static int getSize(final Bitmap bitmap) {
        return getBitmapByteSize(bitmap);
    }
    
    public static List getSnapshot(final Collection collection) {
        final ArrayList<Object> list = new ArrayList<Object>(collection.size());
        final Iterator<Object> iterator = collection.iterator();
        while (iterator.hasNext()) {
            list.add(iterator.next());
        }
        return list;
    }
    
    public static boolean isOnBackgroundThread() {
        return isOnMainThread() ^ true;
    }
    
    public static boolean isOnMainThread() {
        return Looper.myLooper() == Looper.getMainLooper();
    }
    
    private static boolean isValidDimension(final int n) {
        return n > 0 || n == -1 << -1;
    }
    
    public static boolean isValidDimensions(final int n, final int n2) {
        return isValidDimension(n) && isValidDimension(n2);
    }
    
    public static String sha1BytesToHex(final byte[] array) {
        synchronized (Util.SHA_1_CHARS) {
            return bytesToHex(array, Util.SHA_1_CHARS);
        }
    }
    
    public static String sha256BytesToHex(final byte[] array) {
        synchronized (Util.SHA_256_CHARS) {
            return bytesToHex(array, Util.SHA_256_CHARS);
        }
    }
}
