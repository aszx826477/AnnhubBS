// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.util;

import java.lang.reflect.Array;
import java.util.Iterator;
import java.util.Set;
import java.util.Collection;

public final class ArraySet implements Collection, Set
{
    private static final int BASE_SIZE = 4;
    private static final int CACHE_SIZE = 10;
    private static final boolean DEBUG = false;
    private static final int[] INT;
    private static final Object[] OBJECT;
    private static final String TAG = "ArraySet";
    static Object[] sBaseCache;
    static int sBaseCacheSize;
    static Object[] sTwiceBaseCache;
    static int sTwiceBaseCacheSize;
    Object[] mArray;
    MapCollections mCollections;
    int[] mHashes;
    final boolean mIdentityHashCode;
    int mSize;
    
    static {
        INT = new int[0];
        OBJECT = new Object[0];
    }
    
    public ArraySet() {
        this(0, false);
    }
    
    public ArraySet(final int n) {
        this(n, false);
    }
    
    public ArraySet(final int n, final boolean mIdentityHashCode) {
        this.mIdentityHashCode = mIdentityHashCode;
        if (n == 0) {
            this.mHashes = ArraySet.INT;
            this.mArray = ArraySet.OBJECT;
        }
        else {
            this.allocArrays(n);
        }
        this.mSize = 0;
    }
    
    public ArraySet(final ArraySet set) {
        this();
        if (set != null) {
            this.addAll(set);
        }
    }
    
    public ArraySet(final Collection collection) {
        this();
        if (collection != null) {
            this.addAll(collection);
        }
    }
    
    private void allocArrays(final int n) {
        final int n2 = 1;
        Label_0262: {
            if (n == 8) {
                synchronized (ArraySet.class) {
                    if (ArraySet.sTwiceBaseCache != null) {
                        final Object[] sTwiceBaseCache = ArraySet.sTwiceBaseCache;
                        this.mArray = sTwiceBaseCache;
                        ArraySet.sTwiceBaseCache = (Object[])sTwiceBaseCache[0];
                        this.mHashes = (int[])sTwiceBaseCache[n2];
                        sTwiceBaseCache[0] = (sTwiceBaseCache[n2] = null);
                        ArraySet.sTwiceBaseCacheSize -= n2;
                        return;
                    }
                    break Label_0262;
                }
            }
            if (n == 4) {
                synchronized (ArraySet.class) {
                    if (ArraySet.sBaseCache != null) {
                        final Object[] sBaseCache = ArraySet.sBaseCache;
                        this.mArray = sBaseCache;
                        ArraySet.sBaseCache = (Object[])sBaseCache[0];
                        this.mHashes = (int[])sBaseCache[n2];
                        sBaseCache[0] = (sBaseCache[n2] = null);
                        ArraySet.sBaseCacheSize -= n2;
                        return;
                    }
                }
            }
        }
        this.mHashes = new int[n];
        this.mArray = new Object[n];
    }
    
    private static void freeArrays(final int[] array, final Object[] array2, final int n) {
        final int length = array.length;
        final int n2 = 2;
        final int n3 = 10;
        final int n4 = 1;
        if (length == 8) {
            synchronized (ArraySet.class) {
                if (ArraySet.sTwiceBaseCacheSize < n3) {
                    array2[0] = ArraySet.sTwiceBaseCache;
                    array2[n4] = array;
                    for (int i = n - 1; i >= n2; --i) {
                        array2[i] = null;
                    }
                    ArraySet.sTwiceBaseCache = array2;
                    ArraySet.sTwiceBaseCacheSize += n4;
                }
                return;
            }
        }
        if (array.length == 4) {
            synchronized (ArraySet.class) {
                if (ArraySet.sBaseCacheSize < n3) {
                    array2[0] = ArraySet.sBaseCache;
                    array2[n4] = array;
                    for (int j = n - 1; j >= n2; --j) {
                        array2[j] = null;
                    }
                    ArraySet.sBaseCache = array2;
                    ArraySet.sBaseCacheSize += n4;
                }
            }
        }
    }
    
    private MapCollections getCollection() {
        if (this.mCollections == null) {
            this.mCollections = new ArraySet$1(this);
        }
        return this.mCollections;
    }
    
    private int indexOf(final Object o, final int n) {
        final int mSize = this.mSize;
        if (mSize == 0) {
            return -1;
        }
        final int binarySearch = ContainerHelpers.binarySearch(this.mHashes, mSize, n);
        if (binarySearch < 0) {
            return binarySearch;
        }
        if (o.equals(this.mArray[binarySearch])) {
            return binarySearch;
        }
        int n2;
        for (n2 = binarySearch + 1; n2 < mSize && this.mHashes[n2] == n; ++n2) {
            if (o.equals(this.mArray[n2])) {
                return n2;
            }
        }
        for (int n3 = binarySearch - 1; n3 >= 0 && this.mHashes[n3] == n; --n3) {
            if (o.equals(this.mArray[n3])) {
                return n3;
            }
        }
        return ~n2;
    }
    
    private int indexOfNull() {
        final int mSize = this.mSize;
        if (mSize == 0) {
            return -1;
        }
        final int binarySearch = ContainerHelpers.binarySearch(this.mHashes, mSize, 0);
        if (binarySearch < 0) {
            return binarySearch;
        }
        if (this.mArray[binarySearch] == null) {
            return binarySearch;
        }
        int n;
        for (n = binarySearch + 1; n < mSize && this.mHashes[n] == 0; ++n) {
            if (this.mArray[n] == null) {
                return n;
            }
        }
        for (int n2 = binarySearch - 1; n2 >= 0 && this.mHashes[n2] == 0; --n2) {
            if (this.mArray[n2] == null) {
                return n2;
            }
        }
        return ~n;
    }
    
    public boolean add(final Object o) {
        int n;
        int n2;
        if (o == null) {
            n = 0;
            n2 = this.indexOfNull();
        }
        else {
            if (this.mIdentityHashCode) {
                n = System.identityHashCode(o);
            }
            else {
                n = o.hashCode();
            }
            n2 = this.indexOf(o, n);
        }
        if (n2 >= 0) {
            return false;
        }
        final int n3 = ~n2;
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
            final Object[] mArray = this.mArray;
            this.allocArrays(n4);
            final int[] mHashes2 = this.mHashes;
            if (mHashes2.length > 0) {
                System.arraycopy(mHashes, 0, mHashes2, 0, mHashes.length);
                System.arraycopy(mArray, 0, this.mArray, 0, mArray.length);
            }
            freeArrays(mHashes, mArray, this.mSize);
        }
        final int mSize2 = this.mSize;
        if (n3 < mSize2) {
            final int[] mHashes3 = this.mHashes;
            System.arraycopy(mHashes3, n3, mHashes3, n3 + 1, mSize2 - n3);
            final Object[] mArray2 = this.mArray;
            System.arraycopy(mArray2, n3, mArray2, n3 + 1, this.mSize - n3);
        }
        this.mHashes[n3] = n;
        this.mArray[n3] = o;
        final int mSize3 = this.mSize;
        final int n5 = 1;
        this.mSize = mSize3 + n5;
        return n5 != 0;
    }
    
    public void addAll(final ArraySet set) {
        final int mSize = set.mSize;
        this.ensureCapacity(this.mSize + mSize);
        if (this.mSize == 0) {
            if (mSize > 0) {
                System.arraycopy(set.mHashes, 0, this.mHashes, 0, mSize);
                System.arraycopy(set.mArray, 0, this.mArray, 0, mSize);
                this.mSize = mSize;
            }
        }
        else {
            for (int i = 0; i < mSize; ++i) {
                this.add(set.valueAt(i));
            }
        }
    }
    
    public boolean addAll(final Collection collection) {
        this.ensureCapacity(this.mSize + collection.size());
        boolean b = false;
        final Iterator<Object> iterator = collection.iterator();
        while (iterator.hasNext()) {
            b |= this.add(iterator.next());
        }
        return b;
    }
    
    public void append(final Object o) {
        final int mSize = this.mSize;
        int n;
        if (o == null) {
            n = 0;
        }
        else if (this.mIdentityHashCode) {
            n = System.identityHashCode(o);
        }
        else {
            n = o.hashCode();
        }
        final int[] mHashes = this.mHashes;
        if (mSize >= mHashes.length) {
            throw new IllegalStateException("Array is full");
        }
        if (mSize > 0 && mHashes[mSize - 1] > n) {
            this.add(o);
            return;
        }
        this.mSize = mSize + 1;
        this.mHashes[mSize] = n;
        this.mArray[mSize] = o;
    }
    
    public void clear() {
        final int mSize = this.mSize;
        if (mSize != 0) {
            freeArrays(this.mHashes, this.mArray, mSize);
            this.mHashes = ArraySet.INT;
            this.mArray = ArraySet.OBJECT;
            this.mSize = 0;
        }
    }
    
    public boolean contains(final Object o) {
        return this.indexOf(o) >= 0;
    }
    
    public boolean containsAll(final Collection collection) {
        final Iterator<Object> iterator = collection.iterator();
        while (iterator.hasNext()) {
            if (!this.contains(iterator.next())) {
                return false;
            }
        }
        return true;
    }
    
    public void ensureCapacity(final int n) {
        if (this.mHashes.length < n) {
            final int[] mHashes = this.mHashes;
            final Object[] mArray = this.mArray;
            this.allocArrays(n);
            final int mSize = this.mSize;
            if (mSize > 0) {
                System.arraycopy(mHashes, 0, this.mHashes, 0, mSize);
                System.arraycopy(mArray, 0, this.mArray, 0, this.mSize);
            }
            freeArrays(mHashes, mArray, this.mSize);
        }
    }
    
    public boolean equals(final Object o) {
        final boolean b = true;
        if (this == o) {
            return b;
        }
        if (o instanceof Set) {
            final Set set = (Set)o;
            if (this.size() != set.size()) {
                return false;
            }
            int i = 0;
            try {
                while (i < this.mSize) {
                    if (!set.contains(this.valueAt(i))) {
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
        return false;
    }
    
    public int hashCode() {
        final int[] mHashes = this.mHashes;
        int n = 0;
        for (int i = 0; i < this.mSize; ++i) {
            n += mHashes[i];
        }
        return n;
    }
    
    public int indexOf(final Object o) {
        int n;
        if (o == null) {
            n = this.indexOfNull();
        }
        else {
            int n2;
            if (this.mIdentityHashCode) {
                n2 = System.identityHashCode(o);
            }
            else {
                n2 = o.hashCode();
            }
            n = this.indexOf(o, n2);
        }
        return n;
    }
    
    public boolean isEmpty() {
        return this.mSize <= 0;
    }
    
    public Iterator iterator() {
        return this.getCollection().getKeySet().iterator();
    }
    
    public boolean remove(final Object o) {
        final int index = this.indexOf(o);
        if (index >= 0) {
            this.removeAt(index);
            return true;
        }
        return false;
    }
    
    public boolean removeAll(final ArraySet set) {
        final int mSize = set.mSize;
        final int mSize2 = this.mSize;
        for (int i = 0; i < mSize; ++i) {
            this.remove(set.valueAt(i));
        }
        return mSize2 != this.mSize;
    }
    
    public boolean removeAll(final Collection collection) {
        boolean b = false;
        final Iterator<Object> iterator = collection.iterator();
        while (iterator.hasNext()) {
            b |= this.remove(iterator.next());
        }
        return b;
    }
    
    public Object removeAt(final int n) {
        final Object[] mArray = this.mArray;
        final Object o = mArray[n];
        final int mSize = this.mSize;
        final int n2 = 1;
        if (mSize <= n2) {
            freeArrays(this.mHashes, mArray, mSize);
            this.mHashes = ArraySet.INT;
            this.mArray = ArraySet.OBJECT;
            this.mSize = 0;
        }
        else {
            final int[] mHashes = this.mHashes;
            final int length = mHashes.length;
            int n3 = 8;
            if (length > n3 && mSize < mHashes.length / 3) {
                if (mSize > n3) {
                    n3 = mSize + (mSize >> 1);
                }
                final int[] mHashes2 = this.mHashes;
                final Object[] mArray2 = this.mArray;
                this.allocArrays(n3);
                this.mSize -= n2;
                if (n > 0) {
                    System.arraycopy(mHashes2, 0, this.mHashes, 0, n);
                    System.arraycopy(mArray2, 0, this.mArray, 0, n);
                }
                final int mSize2 = this.mSize;
                if (n < mSize2) {
                    System.arraycopy(mHashes2, n + 1, this.mHashes, n, mSize2 - n);
                    System.arraycopy(mArray2, n + 1, this.mArray, n, this.mSize - n);
                }
            }
            else {
                this.mSize -= n2;
                final int mSize3 = this.mSize;
                if (n < mSize3) {
                    final int[] mHashes3 = this.mHashes;
                    System.arraycopy(mHashes3, n + 1, mHashes3, n, mSize3 - n);
                    final Object[] mArray3 = this.mArray;
                    System.arraycopy(mArray3, n + 1, mArray3, n, this.mSize - n);
                }
                this.mArray[this.mSize] = null;
            }
        }
        return o;
    }
    
    public boolean retainAll(final Collection collection) {
        boolean b = false;
        for (int i = this.mSize - 1; i >= 0; --i) {
            if (!collection.contains(this.mArray[i])) {
                this.removeAt(i);
                b = true;
            }
        }
        return b;
    }
    
    public int size() {
        return this.mSize;
    }
    
    public Object[] toArray() {
        final int mSize = this.mSize;
        final Object[] array = new Object[mSize];
        System.arraycopy(this.mArray, 0, array, 0, mSize);
        return array;
    }
    
    public Object[] toArray(Object[] array) {
        if (array.length < this.mSize) {
            array = (Object[])Array.newInstance(array.getClass().getComponentType(), this.mSize);
        }
        System.arraycopy(this.mArray, 0, array, 0, this.mSize);
        final int length = array.length;
        final int mSize = this.mSize;
        if (length > mSize) {
            array[mSize] = null;
        }
        return array;
    }
    
    public String toString() {
        if (this.isEmpty()) {
            return "{}";
        }
        final StringBuilder sb = new StringBuilder(this.mSize * 14);
        sb.append('{');
        for (int i = 0; i < this.mSize; ++i) {
            if (i > 0) {
                sb.append(", ");
            }
            final Object value = this.valueAt(i);
            if (value != this) {
                sb.append(value);
            }
            else {
                sb.append("(this Set)");
            }
        }
        sb.append('}');
        return sb.toString();
    }
    
    public Object valueAt(final int n) {
        return this.mArray[n];
    }
}
