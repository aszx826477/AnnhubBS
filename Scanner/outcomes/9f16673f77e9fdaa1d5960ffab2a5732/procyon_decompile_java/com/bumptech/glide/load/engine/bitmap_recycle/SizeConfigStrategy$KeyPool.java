// 
// Decompiled by Procyon v0.5.30
// 

package com.bumptech.glide.load.engine.bitmap_recycle;

import android.graphics.Bitmap$Config;

class SizeConfigStrategy$KeyPool extends BaseKeyPool
{
    protected SizeConfigStrategy$Key create() {
        return new SizeConfigStrategy$Key(this);
    }
    
    public SizeConfigStrategy$Key get(final int n, final Bitmap$Config bitmap$Config) {
        final SizeConfigStrategy$Key sizeConfigStrategy$Key = (SizeConfigStrategy$Key)this.get();
        sizeConfigStrategy$Key.init(n, bitmap$Config);
        return sizeConfigStrategy$Key;
    }
}
