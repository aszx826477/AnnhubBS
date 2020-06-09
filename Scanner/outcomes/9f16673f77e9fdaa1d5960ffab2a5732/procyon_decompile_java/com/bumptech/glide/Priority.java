// 
// Decompiled by Procyon v0.5.30
// 

package com.bumptech.glide;

public enum Priority
{
    HIGH("HIGH", n), 
    IMMEDIATE("IMMEDIATE", 0), 
    LOW("LOW", n3), 
    NORMAL("NORMAL", n2), 
    priority("priority", n4);
    
    static {
        final int n = 1;
        final int n2 = 2;
        final int n3 = 3;
        final int n4 = 4;
        final Priority[] $values = new Priority[5];
        $values[0] = Priority.IMMEDIATE;
        $values[n] = Priority.HIGH;
        $values[n2] = Priority.NORMAL;
        $values[n3] = Priority.LOW;
        $values[n4] = Priority.priority;
        $VALUES = $values;
    }
    
    private Priority(final String s, final int n) {
    }
}
