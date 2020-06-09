// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.util;

public final class CircularIntArray
{
    private int mCapacityBitmask;
    private int[] mElements;
    private int mHead;
    private int mTail;
    
    public CircularIntArray() {
        this(8);
    }
    
    public CircularIntArray(final int n) {
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
            this.mElements = new int[n3];
            return;
        }
        throw new IllegalArgumentException("capacity must be <= 2^30");
    }
    
    private void doubleCapacity() {
        final int[] mElements = this.mElements;
        final int length = mElements.length;
        final int mHead = this.mHead;
        final int n = length - mHead;
        final int n2 = length << 1;
        if (n2 >= 0) {
            final int[] mElements2 = new int[n2];
            System.arraycopy(mElements, mHead, mElements2, 0, n);
            System.arraycopy(this.mElements, 0, mElements2, n, this.mHead);
            this.mElements = mElements2;
            this.mHead = 0;
            this.mTail = length;
            this.mCapacityBitmask = n2 - 1;
            return;
        }
        throw new RuntimeException("Max array capacity exceeded");
    }
    
    public void addFirst(final int n) {
        this.mHead = (this.mHead - 1 & this.mCapacityBitmask);
        final int[] mElements = this.mElements;
        final int mHead = this.mHead;
        mElements[mHead] = n;
        if (mHead == this.mTail) {
            this.doubleCapacity();
        }
    }
    
    public void addLast(final int n) {
        final int[] mElements = this.mElements;
        final int mTail = this.mTail;
        mElements[mTail] = n;
        this.mTail = (this.mCapacityBitmask & mTail + 1);
        if (this.mTail == this.mHead) {
            this.doubleCapacity();
        }
    }
    
    public void clear() {
        this.mTail = this.mHead;
    }
    
    public int get(final int n) {
        if (n >= 0 && n < this.size()) {
            return this.mElements[this.mHead + n & this.mCapacityBitmask];
        }
        throw new ArrayIndexOutOfBoundsException();
    }
    
    public int getFirst() {
        final int mHead = this.mHead;
        if (mHead != this.mTail) {
            return this.mElements[mHead];
        }
        throw new ArrayIndexOutOfBoundsException();
    }
    
    public int getLast() {
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
    
    public int popFirst() {
        final int mHead = this.mHead;
        if (mHead != this.mTail) {
            final int n = this.mElements[mHead];
            this.mHead = (mHead + 1 & this.mCapacityBitmask);
            return n;
        }
        throw new ArrayIndexOutOfBoundsException();
    }
    
    public int popLast() {
        final int mHead = this.mHead;
        final int mTail = this.mTail;
        if (mHead != mTail) {
            final int mTail2 = this.mCapacityBitmask & mTail - 1;
            final int n = this.mElements[mTail2];
            this.mTail = mTail2;
            return n;
        }
        throw new ArrayIndexOutOfBoundsException();
    }
    
    public void removeFromEnd(final int n) {
        if (n <= 0) {
            return;
        }
        if (n <= this.size()) {
            this.mTail = (this.mTail - n & this.mCapacityBitmask);
            return;
        }
        throw new ArrayIndexOutOfBoundsException();
    }
    
    public void removeFromStart(final int n) {
        if (n <= 0) {
            return;
        }
        if (n <= this.size()) {
            this.mHead = (this.mHead + n & this.mCapacityBitmask);
            return;
        }
        throw new ArrayIndexOutOfBoundsException();
    }
    
    public int size() {
        return this.mTail - this.mHead & this.mCapacityBitmask;
    }
}
