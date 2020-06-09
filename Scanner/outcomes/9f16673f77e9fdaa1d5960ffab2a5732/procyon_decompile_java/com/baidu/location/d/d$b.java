// 
// Decompiled by Procyon v0.5.30
// 

package com.baidu.location.d;

class d$b
{
    d$a a;
    d$a b;
    final /* synthetic */ d c;
    
    d$b(final d c, final d$a a, final d$a b) {
        this.c = c;
        this.a = a;
        this.b = b;
    }
    
    double a(final d$a d$a) {
        final d$a d$a2 = new d$a(this.c, this.b.a - this.a.a, this.b.b - this.a.b);
        final d$a d$a3 = new d$a(this.c, d$a.a - this.a.a, d$a.b - this.a.b);
        return d$a2.a * d$a3.b - d$a2.b * d$a3.a;
    }
    
    boolean b(d$a b) {
        if (this.c.a(this.a(b)) == 0) {
            final double a = b.a;
            final double max = Math.max(this.a.a, this.b.a);
            final double n = 1.0E-8;
            if (a < max + n && b.a > Math.min(this.a.a, this.b.a) - n && b.b < Math.max(this.a.b, this.b.b) + n) {
                final double b2 = b.b;
                final double b3 = this.a.b;
                b = this.b;
                if (b2 > Math.min(b3, b.b) - n) {
                    return true;
                }
            }
        }
        return false;
    }
}
