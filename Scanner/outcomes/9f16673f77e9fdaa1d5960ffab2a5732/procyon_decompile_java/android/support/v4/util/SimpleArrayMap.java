// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.util;

import java.util.Map;

public class SimpleArrayMap
{
    private static final int BASE_SIZE = 4;
    private static final int CACHE_SIZE = 10;
    private static final boolean DEBUG = false;
    private static final String TAG = "ArrayMap";
    static Object[] mBaseCache;
    static int mBaseCacheSize;
    static Object[] mTwiceBaseCache;
    static int mTwiceBaseCacheSize;
    Object[] mArray;
    int[] mHashes;
    int mSize;
    
    public SimpleArrayMap() {
        this.mHashes = ContainerHelpers.EMPTY_INTS;
        this.mArray = ContainerHelpers.EMPTY_OBJECTS;
        this.mSize = 0;
    }
    
    public SimpleArrayMap(final int n) {
        if (n == 0) {
            this.mHashes = ContainerHelpers.EMPTY_INTS;
            this.mArray = ContainerHelpers.EMPTY_OBJECTS;
        }
        else {
            this.allocArrays(n);
        }
        this.mSize = 0;
    }
    
    public SimpleArrayMap(final SimpleArrayMap simpleArrayMap) {
        this();
        if (simpleArrayMap != null) {
            this.putAll(simpleArrayMap);
        }
    }
    
    private void allocArrays(final int n) {
        final int n2 = 1;
        Label_0262: {
            if (n == 8) {
                synchronized (ArrayMap.class) {
                    if (SimpleArrayMap.mTwiceBaseCache != null) {
                        final Object[] mTwiceBaseCache = SimpleArrayMap.mTwiceBaseCache;
                        this.mArray = mTwiceBaseCache;
                        SimpleArrayMap.mTwiceBaseCache = (Object[])mTwiceBaseCache[0];
                        this.mHashes = (int[])mTwiceBaseCache[n2];
                        mTwiceBaseCache[0] = (mTwiceBaseCache[n2] = null);
                        SimpleArrayMap.mTwiceBaseCacheSize -= n2;
                        return;
                    }
                    break Label_0262;
                }
            }
            if (n == 4) {
                synchronized (ArrayMap.class) {
                    if (SimpleArrayMap.mBaseCache != null) {
                        final Object[] mBaseCache = SimpleArrayMap.mBaseCache;
                        this.mArray = mBaseCache;
                        SimpleArrayMap.mBaseCache = (Object[])mBaseCache[0];
                        this.mHashes = (int[])mBaseCache[n2];
                        mBaseCache[0] = (mBaseCache[n2] = null);
                        SimpleArrayMap.mBaseCacheSize -= n2;
                        return;
                    }
                }
            }
        }
        this.mHashes = new int[n];
        this.mArray = new Object[n << 1];
    }
    
    private static void freeArrays(final int[] array, final Object[] array2, final int n) {
        final int length = array.length;
        final int n2 = 2;
        final int n3 = 10;
        final int n4 = 1;
        if (length == 8) {
            synchronized (ArrayMap.class) {
                if (SimpleArrayMap.mTwiceBaseCacheSize < n3) {
                    array2[0] = SimpleArrayMap.mTwiceBaseCache;
                    array2[n4] = array;
                    for (int i = (n << 1) - n4; i >= n2; --i) {
                        array2[i] = null;
                    }
                    SimpleArrayMap.mTwiceBaseCache = array2;
                    SimpleArrayMap.mTwiceBaseCacheSize += n4;
                }
                return;
            }
        }
        if (array.length == 4) {
            synchronized (ArrayMap.class) {
                if (SimpleArrayMap.mBaseCacheSize < n3) {
                    array2[0] = SimpleArrayMap.mBaseCache;
                    array2[n4] = array;
                    for (int j = (n << 1) - n4; j >= n2; --j) {
                        array2[j] = null;
                    }
                    SimpleArrayMap.mBaseCache = array2;
                    SimpleArrayMap.mBaseCacheSize += n4;
                }
            }
        }
    }
    
    public void clear() {
        final int mSize = this.mSize;
        if (mSize != 0) {
            freeArrays(this.mHashes, this.mArray, mSize);
            this.mHashes = ContainerHelpers.EMPTY_INTS;
            this.mArray = ContainerHelpers.EMPTY_OBJECTS;
            this.mSize = 0;
        }
    }
    
    public boolean containsKey(final Object o) {
        return this.indexOfKey(o) >= 0;
    }
    
    public boolean containsValue(final Object o) {
        return this.indexOfValue(o) >= 0;
    }
    
    public void ensureCapacity(final int n) {
        if (this.mHashes.length < n) {
            final int[] mHashes = this.mHashes;
            final Object[] mArray = this.mArray;
            this.allocArrays(n);
            final int mSize = this.mSize;
            if (mSize > 0) {
                System.arraycopy(mHashes, 0, this.mHashes, 0, mSize);
                System.arraycopy(mArray, 0, this.mArray, 0, this.mSize << 1);
            }
            freeArrays(mHashes, mArray, this.mSize);
        }
    }
    
    public boolean equals(final Object o) {
        final boolean b = true;
        if (this == o) {
            return b;
        }
        if (o instanceof SimpleArrayMap) {
            final SimpleArrayMap simpleArrayMap = (SimpleArrayMap)o;
            if (this.size() != simpleArrayMap.size()) {
                return false;
            }
            int i = 0;
            try {
                while (i < this.mSize) {
                    final Object key = this.keyAt(i);
                    final Object value = this.valueAt(i);
                    final Object value2 = simpleArrayMap.get(key);
                    if (value == null) {
                        if (value2 != null || simpleArrayMap.containsKey(key)) {
                            return false;
                        }
                    }
                    else if (!value.equals(value2)) {
                        return false;
                    }
                    ++i;
                }
                return b;
            }
            catch (ClassCastException ex) {
                return false;
            }
            catch (NullPointerException ex2) {
                return false;
            }
        }
        if (o instanceof Map) {
            final Map map = (Map)o;
            if (this.size() != map.size()) {
                return false;
            }
            int j = 0;
            try {
                while (j < this.mSize) {
                    final Object key2 = this.keyAt(j);
                    final Object value3 = this.valueAt(j);
                    final Object value4 = map.get(key2);
                    if (value3 == null) {
                        if (value4 != null || map.containsKey(key2)) {
                            return false;
                        }
                    }
                    else if (!value3.equals(value4)) {
                        return false;
                    }
                    ++j;
                }
                return b;
            }
            catch (ClassCastException ex3) {
                return false;
            }
            catch (NullPointerException ex4) {
                return false;
            }
        }
        return false;
    }
    
    public Object get(final Object o) {
        final int indexOfKey = this.indexOfKey(o);
        Object o2;
        if (indexOfKey >= 0) {
            o2 = this.mArray[(indexOfKey << 1) + 1];
        }
        else {
            o2 = null;
        }
        return o2;
    }
    
    public int hashCode() {
        final int[] mHashes = this.mHashes;
        final Object[] mArray = this.mArray;
        int n = 0;
        for (int i = 0, n2 = 1; i < this.mSize; ++i, n2 += 2) {
            final Object o = mArray[n2];
            final int n3 = mHashes[i];
            int hashCode;
            if (o == null) {
                hashCode = 0;
            }
            else {
                hashCode = o.hashCode();
            }
            n += (n3 ^ hashCode);
        }
        return n;
    }
    
    int indexOf(final Object o, final int n) {
        final int mSize = this.mSize;
        if (mSize == 0) {
            return -1;
        }
        final int binarySearch = ContainerHelpers.binarySearch(this.mHashes, mSize, n);
        if (binarySearch < 0) {
            return binarySearch;
        }
        if (o.equals(this.mArray[binarySearch << 1])) {
            return binarySearch;
        }
        int n2;
        for (n2 = binarySearch + 1; n2 < mSize && this.mHashes[n2] == n; ++n2) {
            if (o.equals(this.mArray[n2 << 1])) {
                return n2;
            }
        }
        for (int n3 = binarySearch - 1; n3 >= 0 && this.mHashes[n3] == n; --n3) {
            if (o.equals(this.mArray[n3 << 1])) {
                return n3;
            }
        }
        return ~n2;
    }
    
    public int indexOfKey(final Object o) {
        int n;
        if (o == null) {
            n = this.indexOfNull();
        }
        else {
            n = this.indexOf(o, o.hashCode());
        }
        return n;
    }
    
    int indexOfNull() {
        final int mSize = this.mSize;
        if (mSize == 0) {
            return -1;
        }
        final int binarySearch = ContainerHelpers.binarySearch(this.mHashes, mSize, 0);
        if (binarySearch < 0) {
            return binarySearch;
        }
        if (this.mArray[binarySearch << 1] == null) {
            return binarySearch;
        }
        int n;
        for (n = binarySearch + 1; n < mSize && this.mHashes[n] == 0; ++n) {
            if (this.mArray[n << 1] == null) {
                return n;
            }
        }
        for (int n2 = binarySearch - 1; n2 >= 0 && this.mHashes[n2] == 0; --n2) {
            if (this.mArray[n2 << 1] == null) {
                return n2;
            }
        }
        return ~n;
    }
    
    int indexOfValue(final Object o) {
        final int n = this.mSize * 2;
        final Object[] mArray = this.mArray;
        if (o == null) {
            for (int i = 1; i < n; i += 2) {
                if (mArray[i] == null) {
                    return i >> 1;
                }
            }
        }
        else {
            for (int j = 1; j < n; j += 2) {
                if (o.equals(mArray[j])) {
                    return j >> 1;
                }
            }
        }
        return -1;
    }
    
    public boolean isEmpty() {
        return this.mSize <= 0;
    }
    
    public Object keyAt(final int n) {
        return this.mArray[n << 1];
    }
    
    public Object put(final Object o, final Object o2) {
        int hashCode;
        int n;
        if (o == null) {
            hashCode = 0;
            n = this.indexOfNull();
        }
        else {
            hashCode = o.hashCode();
            n = this.indexOf(o, hashCode);
        }
        if (n >= 0) {
            final int n2 = (n << 1) + 1;
            final Object[] mArray = this.mArray;
            final Object o3 = mArray[n2];
            mArray[n2] = o2;
            return o3;
        }
        final int n3 = ~n;
        final int mSize = this.mSize;
        if (mSize >= this.mHashes.length) {
            int n4 = 4;
            if (mSize >= 8) {
                n4 = (mSize >> 1) + mSize;
            }
            else if (mSize >= n4) {
                n4 = 8;
            }
            final int[] mHashes = this.mHashes;
            final Object[] mArray2 = this.mArray;
            this.allocArrays(n4);
            final int[] mHashes2 = this.mHashes;
            if (mHashes2.length > 0) {
                System.arraycopy(mHashes, 0, mHashes2, 0, mHashes.length);
                System.arraycopy(mArray2, 0, this.mArray, 0, mArray2.length);
            }
            freeArrays(mHashes, mArray2, this.mSize);
        }
        final int mSize2 = this.mSize;
        if (n3 < mSize2) {
            final int[] mHashes3 = this.mHashes;
            System.arraycopy(mHashes3, n3, mHashes3, n3 + 1, mSize2 - n3);
            final Object[] mArray3 = this.mArray;
            System.arraycopy(mArray3, n3 << 1, mArray3, n3 + 1 << 1, this.mSize - n3 << 1);
        }
        this.mHashes[n3] = hashCode;
        final Object[] mArray4 = this.mArray;
        mArray4[n3 << 1] = o;
        mArray4[(n3 << 1) + 1] = o2;
        ++this.mSize;
        return null;
    }
    
    public void putAll(final SimpleArrayMap simpleArrayMap) {
        final int mSize = simpleArrayMap.mSize;
        this.ensureCapacity(this.mSize + mSize);
        if (this.mSize == 0) {
            if (mSize > 0) {
                System.arraycopy(simpleArrayMap.mHashes, 0, this.mHashes, 0, mSize);
                System.arraycopy(simpleArrayMap.mArray, 0, this.mArray, 0, mSize << 1);
                this.mSize = mSize;
            }
        }
        else {
            for (int i = 0; i < mSize; ++i) {
                this.put(simpleArrayMap.keyAt(i), simpleArrayMap.valueAt(i));
            }
        }
    }
    
    public Object remove(final Object o) {
        final int indexOfKey = this.indexOfKey(o);
        if (indexOfKey >= 0) {
            return this.removeAt(indexOfKey);
        }
        return null;
    }
    
    public Object removeAt(final int n) {
        final Object[] mArray = this.mArray;
        final int n2 = n << 1;
        final int n3 = 1;
        final Object o = mArray[n2 + n3];
        final int mSize = this.mSize;
        if (mSize <= n3) {
            freeArrays(this.mHashes, mArray, mSize);
            this.mHashes = ContainerHelpers.EMPTY_INTS;
            this.mArray = ContainerHelpers.EMPTY_OBJECTS;
            this.mSize = 0;
        }
        else {
            final int[] mHashes = this.mHashes;
            final int length = mHashes.length;
            int n4 = 8;
            if (length > n4 && mSize < mHashes.length / 3) {
                if (mSize > n4) {
                    n4 = mSize + (mSize >> 1);
                }
                final int[] mHashes2 = this.mHashes;
                final Object[] mArray2 = this.mArray;
                this.allocArrays(n4);
                this.mSize -= n3;
                if (n > 0) {
                    System.arraycopy(mHashes2, 0, this.mHashes, 0, n);
                    System.arraycopy(mArray2, 0, this.mArray, 0, n << 1);
                }
                final int mSize2 = this.mSize;
                if (n < mSize2) {
                    System.arraycopy(mHashes2, n + 1, this.mHashes, n, mSize2 - n);
                    System.arraycopy(mArray2, n + 1 << n3, this.mArray, n << 1, this.mSize - n << 1);
                }
            }
            else {
                this.mSize -= n3;
                final int mSize3 = this.mSize;
                if (n < mSize3) {
                    final int[] mHashes3 = this.mHashes;
                    System.arraycopy(mHashes3, n + 1, mHashes3, n, mSize3 - n);
                    final Object[] mArray3 = this.mArray;
                    System.arraycopy(mArray3, n + 1 << n3, mArray3, n << 1, this.mSize - n << n3);
                }
                final Object[] mArray4 = this.mArray;
                final int mSize4 = this.mSize;
                mArray4[(mSize4 << n3) + n3] = (mArray4[mSize4 << 1] = null);
            }
        }
        return o;
    }
    
    public Object setValueAt(final int n, final Object o) {
        final int n2 = (n << 1) + 1;
        final Object[] mArray = this.mArray;
        final Object o2 = mArray[n2];
        mArray[n2] = o;
        return o2;
    }
    
    public int size() {
        return this.mSize;
    }
    
    public String toString() {
        if (this.isEmpty()) {
            return "{}";
        }
        final StringBuilder sb = new StringBuilder(this.mSize * 28);
        sb.append('{');
        for (int i = 0; i < this.mSize; ++i) {
            if (i > 0) {
                sb.append(", ");
            }
            final Object key = this.keyAt(i);
            if (key != this) {
                sb.append(key);
            }
            else {
                sb.append("(this Map)");
            }
            sb.append('=');
            final Object value = this.valueAt(i);
            if (value != this) {
                sb.append(value);
            }
            else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }
    
    public Object valueAt(final int n) {
        return this.mArray[(n << 1) + 1];
    }
}
