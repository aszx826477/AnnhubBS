// 
// Decompiled by Procyon v0.5.30
// 

package com.bumptech.glide;

class ListPreloader$2 implements ListPreloader$PreloadSizeProvider
{
    final /* synthetic */ ListPreloader this$0;
    
    ListPreloader$2(final ListPreloader this$0) {
        this.this$0 = this$0;
    }
    
    public int[] getPreloadSize(final Object o, final int n, final int n2) {
        return this.this$0.getDimensions(o);
    }
}
