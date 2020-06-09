// 
// Decompiled by Procyon v0.5.30
// 

package okio;

final class Segment
{
    static final int SHARE_MINIMUM = 1024;
    static final int SIZE = 8192;
    final byte[] data;
    int limit;
    Segment next;
    boolean owner;
    int pos;
    Segment prev;
    boolean shared;
    
    Segment() {
        this.data = new byte[8192];
        this.owner = true;
        this.shared = false;
    }
    
    Segment(final Segment segment) {
        this(segment.data, segment.pos, segment.limit);
        segment.shared = true;
    }
    
    Segment(final byte[] data, final int pos, final int limit) {
        this.data = data;
        this.pos = pos;
        this.limit = limit;
        this.owner = false;
        this.shared = true;
    }
    
    public void compact() {
        final Segment prev = this.prev;
        if (prev == this) {
            throw new IllegalStateException();
        }
        if (!prev.owner) {
            return;
        }
        final int n = this.limit - this.pos;
        final int n2 = 8192 - prev.limit;
        int pos;
        if (prev.shared) {
            pos = 0;
        }
        else {
            pos = prev.pos;
        }
        if (n > n2 + pos) {
            return;
        }
        this.writeTo(this.prev, n);
        this.pop();
        SegmentPool.recycle(this);
    }
    
    public Segment pop() {
        Segment next = this.next;
        if (next == this) {
            next = null;
        }
        final Segment prev = this.prev;
        prev.next = this.next;
        this.next.prev = prev;
        this.next = null;
        this.prev = null;
        return next;
    }
    
    public Segment push(final Segment segment) {
        segment.prev = this;
        segment.next = this.next;
        this.next.prev = segment;
        return this.next = segment;
    }
    
    public Segment split(final int n) {
        if (n > 0 && n <= this.limit - this.pos) {
            Segment take;
            if (n >= 1024) {
                take = new Segment(this);
            }
            else {
                take = SegmentPool.take();
                System.arraycopy(this.data, this.pos, take.data, 0, n);
            }
            take.limit = take.pos + n;
            this.pos += n;
            this.prev.push(take);
            return take;
        }
        throw new IllegalArgumentException();
    }
    
    public void writeTo(final Segment segment, final int n) {
        if (segment.owner) {
            final int limit = segment.limit;
            final int n2 = limit + n;
            final int n3 = 8192;
            if (n2 > n3) {
                if (segment.shared) {
                    throw new IllegalArgumentException();
                }
                final int n4 = limit + n;
                final int pos = segment.pos;
                if (n4 - pos > n3) {
                    throw new IllegalArgumentException();
                }
                final byte[] data = segment.data;
                System.arraycopy(data, pos, data, 0, limit - pos);
                segment.limit -= segment.pos;
                segment.pos = 0;
            }
            System.arraycopy(this.data, this.pos, segment.data, segment.limit, n);
            segment.limit += n;
            this.pos += n;
            return;
        }
        throw new IllegalArgumentException();
    }
}
