// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.util;

public final class CircularArray
{
    private int mCapacityBitmask;
    private Object[] mElements;
    private int mHead;
    private int mTail;
    
    public CircularArray() {
        this(8);
    }
    
    public CircularArray(final int n) {
        final int n2 = 1;
        if (n < n2) {
            throw new IllegalArgumentException("capacity must be >= 1");
        }
        if (n <= 1073741824) {
            int n3;
            if (Integer.bitCount(n) != n2) {
                n3 = Integer.highestOneBit(n - 1) << 1;
            }
            else {
                n3 = n;
            }
            this.mCapacityBitmask = n3 - 1;
            this.mElements = new Object[n3];
            return;
        }
        throw new IllegalArgumentException("capacity must be <= 2^30");
    }
    
    private void doubleCapacity() {
        final Object[] mElements = this.mElements;
        final int length = mElements.length;
        final int mHead = this.mHead;
        final int n = length - mHead;
        final int n2 = length << 1;
        if (n2 >= 0) {
            final Object[] array = new Object[n2];
            System.arraycopy(mElements, mHead, array, 0, n);
            System.arraycopy(this.mElements, 0, array, n, this.mHead);
            this.mElements = array;
            this.mHead = 0;
            this.mTail = length;
            this.mCapacityBitmask = n2 - 1;
            return;
        }
        throw new RuntimeException("Max array capacity exceeded");
    }
    
    public void addFirst(final Object o) {
        this.mHead = (this.mHead - 1 & this.mCapacityBitmask);
        final Object[] mElements = this.mElements;
        final int mHead = this.mHead;
        mElements[mHead] = o;
        if (mHead == this.mTail) {
            this.doubleCapacity();
        }
    }
    
    public void addLast(final Object o) {
        final Object[] mElements = this.mElements;
        final int mTail = this.mTail;
        mElements[mTail] = o;
        this.mTail = (this.mCapacityBitmask & mTail + 1);
        if (this.mTail == this.mHead) {
            this.doubleCapacity();
        }
    }
    
    public void clear() {
        this.removeFromStart(this.size());
    }
    
    public Object get(final int n) {
        if (n >= 0 && n < this.size()) {
            return this.mElements[this.mHead + n & this.mCapacityBitmask];
        }
        throw new ArrayIndexOutOfBoundsException();
    }
    
    public Object getFirst() {
        final int mHead = this.mHead;
        if (mHead != this.mTail) {
            return this.mElements[mHead];
        }
        throw new ArrayIndexOutOfBoundsException();
    }
    
    public Object getLast() {
        final int mHead = this.mHead;
        final int mTail = this.mTail;
        if (mHead != mTail) {
            return this.mElements[mTail - 1 & this.mCapacityBitmask];
        }
        throw new ArrayIndexOutOfBoundsException();
    }
    
    public boolean isEmpty() {
        return this.mHead == this.mTail;
    }
    
    public Object popFirst() {
        final int mHead = this.mHead;
        if (mHead != this.mTail) {
            final Object[] mElements = this.mElements;
            final Object o = mElements[mHead];
            mElements[mHead] = null;
            this.mHead = (mHead + 1 & this.mCapacityBitmask);
            return o;
        }
        throw new ArrayIndexOutOfBoundsException();
    }
    
    public Object popLast() {
        final int mHead = this.mHead;
        final int mTail = this.mTail;
        if (mHead != mTail) {
            final int mTail2 = this.mCapacityBitmask & mTail - 1;
            final Object[] mElements = this.mElements;
            final Object o = mElements[mTail2];
            mElements[mTail2] = null;
            this.mTail = mTail2;
            return o;
        }
        throw new ArrayIndexOutOfBoundsException();
    }
    
    public void removeFromEnd(int n) {
        if (n <= 0) {
            return;
        }
        if (n <= this.size()) {
            int n2 = 0;
            final int mTail = this.mTail;
            if (n < mTail) {
                n2 = mTail - n;
            }
            int n3 = n2;
            int mTail2;
            while (true) {
                mTail2 = this.mTail;
                if (n3 >= mTail2) {
                    break;
                }
                this.mElements[n3] = null;
                ++n3;
            }
            final int n4 = mTail2 - n2;
            n -= n4;
            this.mTail = mTail2 - n4;
            if (n > 0) {
                this.mTail = this.mElements.length;
                int i;
                int mTail3;
                for (mTail3 = (i = this.mTail - n); i < this.mTail; ++i) {
                    this.mElements[i] = null;
                }
                this.mTail = mTail3;
            }
            return;
        }
        throw new ArrayIndexOutOfBoundsException();
    }
    
    public void removeFromStart(int mHead) {
        if (mHead <= 0) {
            return;
        }
        if (mHead <= this.size()) {
            int length = this.mElements.length;
            final int mHead2 = this.mHead;
            if (mHead < length - mHead2) {
                length = mHead2 + mHead;
            }
            for (int i = this.mHead; i < length; ++i) {
                this.mElements[i] = null;
            }
            final int mHead3 = this.mHead;
            final int n = length - mHead3;
            mHead -= n;
            this.mHead = (mHead3 + n & this.mCapacityBitmask);
            if (mHead > 0) {
                for (int j = 0; j < mHead; ++j) {
                    this.mElements[j] = null;
                }
                this.mHead = mHead;
            }
            return;
        }
        throw new ArrayIndexOutOfBoundsException();
    }
    
    public int size() {
        return this.mTail - this.mHead & this.mCapacityBitmask;
    }
}
