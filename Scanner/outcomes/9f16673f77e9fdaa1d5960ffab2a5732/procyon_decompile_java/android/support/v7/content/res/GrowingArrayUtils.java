// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v7.content.res;

import java.lang.reflect.Array;

final class GrowingArrayUtils
{
    public static int[] append(int[] array, final int n, final int n2) {
        if (n + 1 > array.length) {
            final int[] array2 = new int[growSize(n)];
            System.arraycopy(array, 0, array2, 0, n);
            array = array2;
        }
        array[n] = n2;
        return array;
    }
    
    public static long[] append(long[] array, final int n, final long n2) {
        if (n + 1 > array.length) {
            final long[] array2 = new long[growSize(n)];
            System.arraycopy(array, 0, array2, 0, n);
            array = array2;
        }
        array[n] = n2;
        return array;
    }
    
    public static Object[] append(Object[] array, final int n, final Object o) {
        if (n + 1 > array.length) {
            final Object[] array2 = (Object[])Array.newInstance(array.getClass().getComponentType(), growSize(n));
            System.arraycopy(array, 0, array2, 0, n);
            array = array2;
        }
        array[n] = o;
        return array;
    }
    
    public static boolean[] append(boolean[] array, final int n, final boolean b) {
        if (n + 1 > array.length) {
            final boolean[] array2 = new boolean[growSize(n)];
            System.arraycopy(array, 0, array2, 0, n);
            array = array2;
        }
        array[n] = b;
        return array;
    }
    
    public static int growSize(final int n) {
        int n2;
        if (n <= 4) {
            n2 = 8;
        }
        else {
            n2 = n * 2;
        }
        return n2;
    }
    
    public static int[] insert(final int[] array, final int n, final int n2, final int n3) {
        if (n + 1 <= array.length) {
            System.arraycopy(array, n2, array, n2 + 1, n - n2);
            array[n2] = n3;
            return array;
        }
        final int[] array2 = new int[growSize(n)];
        System.arraycopy(array, 0, array2, 0, n2);
        array2[n2] = n3;
        System.arraycopy(array, n2, array2, n2 + 1, array.length - n2);
        return array2;
    }
    
    public static long[] insert(final long[] array, final int n, final int n2, final long n3) {
        if (n + 1 <= array.length) {
            System.arraycopy(array, n2, array, n2 + 1, n - n2);
            array[n2] = n3;
            return array;
        }
        final long[] array2 = new long[growSize(n)];
        System.arraycopy(array, 0, array2, 0, n2);
        array2[n2] = n3;
        System.arraycopy(array, n2, array2, n2 + 1, array.length - n2);
        return array2;
    }
    
    public static Object[] insert(final Object[] array, final int n, final int n2, final Object o) {
        if (n + 1 <= array.length) {
            System.arraycopy(array, n2, array, n2 + 1, n - n2);
            array[n2] = o;
            return array;
        }
        final Object[] array2 = (Object[])Array.newInstance(array.getClass().getComponentType(), growSize(n));
        System.arraycopy(array, 0, array2, 0, n2);
        array2[n2] = o;
        System.arraycopy(array, n2, array2, n2 + 1, array.length - n2);
        return array2;
    }
    
    public static boolean[] insert(final boolean[] array, final int n, final int n2, final boolean b) {
        if (n + 1 <= array.length) {
            System.arraycopy(array, n2, array, n2 + 1, n - n2);
            array[n2] = b;
            return array;
        }
        final boolean[] array2 = new boolean[growSize(n)];
        System.arraycopy(array, 0, array2, 0, n2);
        array2[n2] = b;
        System.arraycopy(array, n2, array2, n2 + 1, array.length - n2);
        return array2;
    }
}
