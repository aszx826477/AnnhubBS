// 
// Decompiled by Procyon v0.5.30
// 

package com.baidu.android.bbalbs.common.util;

import java.util.Comparator;

class c implements Comparator
{
    final /* synthetic */ b a;
    
    c(final b a) {
        this.a = a;
    }
    
    public int a(final b$a b$a, final b$a b$a2) {
        final int n = b$a2.b - b$a.b;
        if (n == 0) {
            if (b$a.d && b$a2.d) {
                return 0;
            }
            if (b$a.d) {
                return -1;
            }
            if (b$a2.d) {
                return 1;
            }
        }
        return n;
    }
}
