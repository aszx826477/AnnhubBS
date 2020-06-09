// 
// Decompiled by Procyon v0.5.30
// 

package com.bumptech.glide.load.engine.bitmap_recycle;

class SizeStrategy$KeyPool extends BaseKeyPool
{
    protected SizeStrategy$Key create() {
        return new SizeStrategy$Key(this);
    }
    
    public SizeStrategy$Key get(final int n) {
        final SizeStrategy$Key sizeStrategy$Key = (SizeStrategy$Key)this.get();
        sizeStrategy$Key.init(n);
        return sizeStrategy$Key;
    }
}
