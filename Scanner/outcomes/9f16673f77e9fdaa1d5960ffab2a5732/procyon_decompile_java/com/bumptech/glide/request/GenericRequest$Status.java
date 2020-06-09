// 
// Decompiled by Procyon v0.5.30
// 

package com.bumptech.glide.request;

enum GenericRequest$Status
{
    CANCELLED("CANCELLED", n5), 
    CLEARED("CLEARED", n6), 
    COMPLETE("COMPLETE", n3), 
    FAILED("FAILED", n4), 
    PAUSED("PAUSED", n7), 
    PENDING("PENDING", 0), 
    RUNNING("RUNNING", n), 
    WAITING_FOR_SIZE("WAITING_FOR_SIZE", n2);
    
    static {
        final int n = 1;
        final int n2 = 2;
        final int n3 = 3;
        final int n4 = 4;
        final int n5 = 5;
        final int n6 = 6;
        final int n7 = 7;
        final GenericRequest$Status[] $values = new GenericRequest$Status[8];
        $values[0] = GenericRequest$Status.PENDING;
        $values[n] = GenericRequest$Status.RUNNING;
        $values[n2] = GenericRequest$Status.WAITING_FOR_SIZE;
        $values[n3] = GenericRequest$Status.COMPLETE;
        $values[n4] = GenericRequest$Status.FAILED;
        $values[n5] = GenericRequest$Status.CANCELLED;
        $values[n6] = GenericRequest$Status.CLEARED;
        $values[n7] = GenericRequest$Status.PAUSED;
        $VALUES = $values;
    }
    
    private GenericRequest$Status(final String s, final int n) {
    }
}
