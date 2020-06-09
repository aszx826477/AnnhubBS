// 
// Decompiled by Procyon v0.5.30
// 

package com.google.gson.internal;

import java.util.ConcurrentModificationException;
import java.util.NoSuchElementException;
import java.util.Iterator;

abstract class LinkedTreeMap$LinkedTreeMapIterator implements Iterator
{
    int expectedModCount;
    LinkedTreeMap$Node lastReturned;
    LinkedTreeMap$Node next;
    final /* synthetic */ LinkedTreeMap this$0;
    
    LinkedTreeMap$LinkedTreeMapIterator(final LinkedTreeMap this$0) {
        this.this$0 = this$0;
        this.next = this.this$0.header.next;
        this.lastReturned = null;
        this.expectedModCount = this.this$0.modCount;
    }
    
    public final boolean hasNext() {
        return this.next != this.this$0.header;
    }
    
    final LinkedTreeMap$Node nextNode() {
        final LinkedTreeMap$Node next = this.next;
        if (next == this.this$0.header) {
            throw new NoSuchElementException();
        }
        if (this.this$0.modCount == this.expectedModCount) {
            this.next = next.next;
            return this.lastReturned = next;
        }
        throw new ConcurrentModificationException();
    }
    
    public final void remove() {
        final LinkedTreeMap$Node lastReturned = this.lastReturned;
        if (lastReturned != null) {
            this.this$0.removeInternal(lastReturned, true);
            this.lastReturned = null;
            this.expectedModCount = this.this$0.modCount;
            return;
        }
        throw new IllegalStateException();
    }
}
