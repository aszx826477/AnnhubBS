// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.util;

public class Pair
{
    public final Object first;
    public final Object second;
    
    public Pair(final Object first, final Object second) {
        this.first = first;
        this.second = second;
    }
    
    public static Pair create(final Object o, final Object o2) {
        return new Pair(o, o2);
    }
    
    private static boolean objectsEqual(final Object o, final Object o2) {
        return o == o2 || (o != null && o.equals(o2));
    }
    
    public boolean equals(final Object o) {
        final boolean b = o instanceof Pair;
        boolean b2 = false;
        if (!b) {
            return false;
        }
        final Pair pair = (Pair)o;
        if (objectsEqual(pair.first, this.first) && objectsEqual(pair.second, this.second)) {
            b2 = true;
        }
        return b2;
    }
    
    public int hashCode() {
        final Object first = this.first;
        int hashCode = 0;
        int hashCode2;
        if (first == null) {
            hashCode2 = 0;
        }
        else {
            hashCode2 = first.hashCode();
        }
        final Object second = this.second;
        if (second != null) {
            hashCode = second.hashCode();
        }
        return hashCode2 ^ hashCode;
    }
    
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Pair{");
        sb.append(String.valueOf(this.first));
        sb.append(" ");
        sb.append(String.valueOf(this.second));
        sb.append("}");
        return sb.toString();
    }
}
