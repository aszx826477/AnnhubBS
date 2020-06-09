// 
// Decompiled by Procyon v0.5.30
// 

package com.bumptech.glide.load.engine.bitmap_recycle;

import android.graphics.Bitmap$Config;

class AttributeStrategy$KeyPool extends BaseKeyPool
{
    protected AttributeStrategy$Key create() {
        return new AttributeStrategy$Key(this);
    }
    
    public AttributeStrategy$Key get(final int n, final int n2, final Bitmap$Config bitmap$Config) {
        final AttributeStrategy$Key attributeStrategy$Key = (AttributeStrategy$Key)this.get();
        attributeStrategy$Key.init(n, n2, bitmap$Config);
        return attributeStrategy$Key;
    }
}
