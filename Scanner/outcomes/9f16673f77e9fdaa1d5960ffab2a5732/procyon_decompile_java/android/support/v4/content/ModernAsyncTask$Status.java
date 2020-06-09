// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.content;

public enum ModernAsyncTask$Status
{
    FINISHED("FINISHED", n2), 
    PENDING("PENDING", 0), 
    RUNNING("RUNNING", n);
    
    static {
        final int n = 1;
        final int n2 = 2;
        final ModernAsyncTask$Status[] $values = { ModernAsyncTask$Status.PENDING, null, null };
        $values[n] = ModernAsyncTask$Status.RUNNING;
        $values[n2] = ModernAsyncTask$Status.FINISHED;
        $VALUES = $values;
    }
    
    private ModernAsyncTask$Status(final String s, final int n) {
    }
}
