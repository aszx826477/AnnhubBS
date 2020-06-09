// 
// Decompiled by Procyon v0.5.30
// 

package com.bumptech.glide.load.engine.prefill;

import java.util.Iterator;
import java.util.Collection;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

final class PreFillQueue
{
    private final Map bitmapsPerType;
    private int bitmapsRemaining;
    private int keyIndex;
    private final List keyList;
    
    public PreFillQueue(final Map bitmapsPerType) {
        this.bitmapsPerType = bitmapsPerType;
        this.keyList = new ArrayList(bitmapsPerType.keySet());
        final Iterator<Integer> iterator = bitmapsPerType.values().iterator();
        while (iterator.hasNext()) {
            this.bitmapsRemaining += iterator.next();
        }
    }
    
    public int getSize() {
        return this.bitmapsRemaining;
    }
    
    public boolean isEmpty() {
        return this.bitmapsRemaining == 0;
    }
    
    public PreFillType remove() {
        final PreFillType preFillType = this.keyList.get(this.keyIndex);
        final Integer n = this.bitmapsPerType.get(preFillType);
        final int intValue = n;
        final int n2 = 1;
        if (intValue == n2) {
            this.bitmapsPerType.remove(preFillType);
            this.keyList.remove(this.keyIndex);
        }
        else {
            this.bitmapsPerType.put(preFillType, n - n2);
        }
        this.bitmapsRemaining -= n2;
        int keyIndex;
        if (this.keyList.isEmpty()) {
            keyIndex = 0;
        }
        else {
            keyIndex = (this.keyIndex + n2) % this.keyList.size();
        }
        this.keyIndex = keyIndex;
        return preFillType;
    }
}
