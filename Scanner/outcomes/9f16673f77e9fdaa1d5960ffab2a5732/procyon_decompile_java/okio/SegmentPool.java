// 
// Decompiled by Procyon v0.5.30
// 

package okio;

final class SegmentPool
{
    static final long MAX_SIZE = 65536L;
    static long byteCount;
    static Segment next;
    
    static void recycle(final Segment next) {
        if (next.next == null && next.prev == null) {
            if (next.shared) {
                return;
            }
            synchronized (SegmentPool.class) {
                final long byteCount = SegmentPool.byteCount;
                final long n = 8192L;
                if (byteCount + n > 65536L) {
                    return;
                }
                SegmentPool.byteCount += n;
                next.next = SegmentPool.next;
                next.limit = 0;
                next.pos = 0;
                SegmentPool.next = next;
                return;
            }
        }
        throw new IllegalArgumentException();
    }
    
    static Segment take() {
        Object o = SegmentPool.class;
        synchronized (o) {
            if (SegmentPool.next != null) {
                final Segment next = SegmentPool.next;
                SegmentPool.next = next.next;
                next.next = null;
                SegmentPool.byteCount -= 8192L;
                return next;
            }
            // monitorexit(o)
            o = new Segment();
            return (Segment)o;
        }
    }
}
