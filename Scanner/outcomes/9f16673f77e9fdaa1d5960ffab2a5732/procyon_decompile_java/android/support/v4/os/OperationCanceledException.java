// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.os;

public class OperationCanceledException extends RuntimeException
{
    public OperationCanceledException() {
        this((String)null);
    }
    
    public OperationCanceledException(final String s) {
        String s2;
        if (s != null) {
            s2 = s;
        }
        else {
            s2 = "The operation has been canceled.";
        }
        super(s2);
    }
}
