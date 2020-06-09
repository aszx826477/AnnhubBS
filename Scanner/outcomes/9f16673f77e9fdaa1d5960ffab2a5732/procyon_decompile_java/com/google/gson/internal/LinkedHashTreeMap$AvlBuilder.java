// 
// Decompiled by Procyon v0.5.30
// 

package com.google.gson.internal;

final class LinkedHashTreeMap$AvlBuilder
{
    private int leavesSkipped;
    private int leavesToSkip;
    private int size;
    private LinkedHashTreeMap$Node stack;
    
    void add(final LinkedHashTreeMap$Node stack) {
        stack.right = null;
        stack.parent = null;
        stack.left = null;
        final int height = 1;
        stack.height = height;
        final int leavesToSkip = this.leavesToSkip;
        if (leavesToSkip > 0) {
            final int size = this.size;
            if ((size & 0x1) == 0x0) {
                this.size = size + height;
                this.leavesToSkip = leavesToSkip - height;
                this.leavesSkipped += height;
            }
        }
        stack.parent = this.stack;
        this.stack = stack;
        this.size += height;
        final int leavesToSkip2 = this.leavesToSkip;
        if (leavesToSkip2 > 0) {
            final int size2 = this.size;
            if ((size2 & 0x1) == 0x0) {
                this.size = size2 + height;
                this.leavesToSkip = leavesToSkip2 - height;
                this.leavesSkipped += height;
            }
        }
        for (int n = 4; (this.size & n - 1) == n - 1; n *= 2) {
            final int leavesSkipped = this.leavesSkipped;
            if (leavesSkipped == 0) {
                final LinkedHashTreeMap$Node stack2 = this.stack;
                final LinkedHashTreeMap$Node parent = stack2.parent;
                final LinkedHashTreeMap$Node parent2 = parent.parent;
                parent.parent = parent2.parent;
                this.stack = parent;
                parent.left = parent2;
                parent.right = stack2;
                parent.height = stack2.height + height;
                parent2.parent = parent;
                stack2.parent = parent;
            }
            else if (leavesSkipped == height) {
                final LinkedHashTreeMap$Node stack3 = this.stack;
                final LinkedHashTreeMap$Node parent3 = stack3.parent;
                this.stack = parent3;
                parent3.right = stack3;
                parent3.height = stack3.height + height;
                stack3.parent = parent3;
                this.leavesSkipped = 0;
            }
            else if (leavesSkipped == 2) {
                this.leavesSkipped = 0;
            }
        }
    }
    
    void reset(final int n) {
        this.leavesToSkip = Integer.highestOneBit(n) * 2 - 1 - n;
        this.size = 0;
        this.leavesSkipped = 0;
        this.stack = null;
    }
    
    LinkedHashTreeMap$Node root() {
        final LinkedHashTreeMap$Node stack = this.stack;
        if (stack.parent == null) {
            return stack;
        }
        throw new IllegalStateException();
    }
}
