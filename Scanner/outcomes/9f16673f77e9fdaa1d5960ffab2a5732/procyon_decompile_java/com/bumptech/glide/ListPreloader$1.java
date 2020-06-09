// 
// Decompiled by Procyon v0.5.30
// 

package com.bumptech.glide;

import java.util.List;

class ListPreloader$1 implements ListPreloader$PreloadModelProvider
{
    final /* synthetic */ ListPreloader this$0;
    
    ListPreloader$1(final ListPreloader this$0) {
        this.this$0 = this$0;
    }
    
    public List getPreloadItems(final int n) {
        return this.this$0.getItems(n, n + 1);
    }
    
    public GenericRequestBuilder getPreloadRequestBuilder(final Object o) {
        return this.this$0.getRequestBuilder(o);
    }
}
