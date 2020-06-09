// 
// Decompiled by Procyon v0.5.30
// 

package com.baidu.location.d;

import java.util.Iterator;
import java.util.LinkedList;

public class d
{
    private static d a;
    private static final double[] b;
    private static final double[] c;
    private LinkedList d;
    
    static {
        d.a = null;
        final int n = 96;
        final double[] array;
        final double[] b2 = array = new double[n];
        array[0] = 110.389648;
        array[1] = 105.070224;
        array[2] = 96.898845;
        array[3] = 95.617053;
        array[4] = 93.822557;
        array[6] = (array[5] = 91.387165);
        array[7] = 89.079901;
        array[8] = 87.221341;
        array[9] = 86.259997;
        array[10] = 85.170461;
        array[11] = 85.234525;
        array[12] = 82.863261;
        array[13] = 81.901917;
        array[14] = 79.594685;
        array[15] = 80.395798;
        array[16] = 79.931142;
        array[17] = 77.800174;
        array[18] = 75.252622;
        array[19] = 73.490158;
        array[20] = 73.185732;
        array[21] = 73.874699;
        array[22] = 74.403435;
        array[23] = 74.099003;
        array[24] = 75.460905;
        array[25] = 76.77474;
        array[26] = 78.280852;
        array[27] = 78.15266;
        array[28] = 78.37698;
        array[29] = 78.8897;
        array[30] = 79.690818;
        array[31] = 81.196914;
        array[32] = 81.805762;
        array[33] = 83.888674;
        array[34] = 85.939538;
        array[35] = 87.862215;
        array[36] = 89.031847;
        array[37] = 90.057287;
        array[38] = 91.098741;
        array[39] = 92.156213;
        array[40] = 93.742421;
        array[41] = 95.825333;
        array[42] = 97.956327;
        array[43] = 97.123143;
        array[44] = 98.212679;
        array[45] = 99.206055;
        array[46] = 101.657471;
        array[47] = 102.52267;
        array[48] = 102.23427;
        array[49] = 105.022158;
        array[50] = 106.095662;
        array[51] = 107.858116;
        array[52] = 111.639396;
        array[53] = 109.588503;
        array[54] = 112.280343;
        array[55] = 117.792023;
        array[56] = 118.945559;
        array[57] = 114.203031;
        array[58] = 118.689303;
        array[59] = 123.143466;
        array[60] = 122.726858;
        array[61] = 120.932369;
        array[62] = 123.415857;
        array[63] = 122.374385;
        array[64] = 122.134054;
        array[65] = 121.586108;
        array[66] = 121.17271;
        array[67] = 120.676006;
        array[68] = 120.243409;
        array[69] = 122.790961;
        array[70] = 122.871076;
        array[71] = 121.300884;
        array[72] = 122.134052;
        array[73] = 123.736285;
        array[74] = 126.412019;
        array[75] = 128.559027;
        array[76] = 129.712627;
        array[77] = 131.218707;
        array[78] = 131.987795;
        array[79] = 133.622084;
        array[80] = 135.60888;
        array[81] = 131.378992;
        array[82] = 130.866224;
        array[83] = 128.623088;
        array[84] = 126.091572;
        array[85] = 124.393204;
        array[86] = 122.214164;
        array[87] = 119.65058;
        array[88] = 119.778772;
        array[89] = 118.561044;
        array[90] = 116.510192;
        array[91] = 114.811824;
        array[92] = 119.073776;
        array[93] = 116.446096;
        array[94] = 111.735536;
        array[95] = 110.389648;
        b = b2;
        final double[] array2;
        final double[] c2 = array2 = new double[n];
        array2[0] = 43.216755;
        array2[1] = 42.378597;
        array2[2] = 43.172612;
        array2[3] = 44.421188;
        array2[4] = 45.097508;
        array2[5] = 45.565732;
        array2[6] = 47.334548;
        array2[7] = 48.687188;
        array2[8] = 49.62362;
        array2[9] = 48.947316;
        array2[10] = 48.479092;
        array2[11] = 47.334548;
        array2[12] = 47.438596;
        array2[13] = 46.03394;
        array2[14] = 45.201556;
        array2[15] = 43.344095;
        array2[16] = 42.328663;
        array2[17] = 41.395882;
        array2[18] = 40.829126;
        array2[19] = 39.955382;
        array2[20] = 39.258748;
        array2[21] = 38.361382;
        array2[22] = 38.054394;
        array2[23] = 37.168842;
        array2[24] = 36.389553;
        array2[25] = 35.362313;
        array2[26] = 34.311457;
        array2[27] = 32.587581;
        array2[28] = 31.572149;
        array2[29] = 30.781055;
        array2[30] = 30.438642;
        array2[31] = 29.77743;
        array2[32] = 30.09623;
        array2[33] = 28.714766;
        array2[34] = 27.71114;
        array2[35] = 27.581258;
        array2[36] = 27.014504;
        array2[37] = 27.781984;
        array2[38] = 27.510415;
        array2[39] = 26.506787;
        array2[40] = 26.707513;
        array2[41] = 27.959095;
        array2[42] = 27.29788;
        array2[43] = 23.649404;
        array2[44] = 23.62579;
        array2[45] = 21.677574;
        array2[46] = 20.780213;
        array2[47] = 21.323353;
        array2[48] = 22.185291;
        array2[49] = 22.315173;
        array2[50] = 22.515897;
        array2[51] = 16.802289;
        array2[52] = 13.198973;
        array2[53] = 0.693351;
        array2[54] = 1.541191;
        array2[55] = 10.504055;
        array2[56] = 15.591095;
        array2[57] = 17.892375;
        array2[58] = 19.951383;
        array2[59] = 22.187501;
        array2[60] = 25.375613;
        array2[61] = 25.617568;
        array2[62] = 30.627458;
        array2[63] = 31.082902;
        array2[64] = 31.894166;
        array2[65] = 32.503117;
        array2[66] = 32.805056;
        array2[67] = 34.256784;
        array2[68] = 35.155304;
        array2[69] = 36.90119;
        array2[70] = 37.83411;
        array2[71] = 37.940728;
        array2[72] = 38.64708;
        array2[73] = 38.966937;
        array2[74] = 40.979374;
        array2[75] = 41.253698;
        array2[76] = 42.069802;
        array2[77] = 42.48888;
        array2[78] = 44.65045;
        array2[79] = 44.691252;
        array2[80] = 48.620679;
        array2[81] = 48.091311;
        array2[82] = 49.194151;
        array2[83] = 50.032311;
        array2[84] = 53.274665;
        array2[85] = 53.627577;
        array2[86] = 53.892257;
        array2[87] = 52.987929;
        array2[88] = 52.017425;
        array2[89] = 50.230825;
        array2[90] = 50.186707;
        array2[91] = 47.495779;
        array2[92] = 47.341379;
        array2[93] = 46.503219;
        array2[94] = 45.245983;
        array2[95] = 43.216755;
        c = c2;
    }
    
    private d() {
        this.d = null;
        final int length = com.baidu.location.d.d.b.length;
        this.d = new LinkedList();
        int i = 0;
        while (i < length - 1) {
            final LinkedList d = this.d;
            final double n = com.baidu.location.d.d.b[i];
            final double n2 = 100000.0;
            final d$a d$a = new d$a(this, n * n2, com.baidu.location.d.d.c[i] * n2);
            final double[] b = com.baidu.location.d.d.b;
            ++i;
            d.add(new d$b(this, d$a, new d$a(this, b[i] * n2, com.baidu.location.d.d.c[i] * n2)));
        }
    }
    
    public static d a() {
        if (d.a == null) {
            d.a = new d();
        }
        return d.a;
    }
    
    int a(final double n) {
        if (n < -1.0E-8) {
            return -1;
        }
        if (n > 1.0E-8) {
            return 1;
        }
        return 0;
    }
    
    public boolean a(final double n, final double n2) {
        boolean b = true;
        try {
            final double n3 = 100000.0;
            final d$a d$a = new d$a(this, n * n3, n2 * n3);
            final LinkedList d = this.d;
            try {
                final Iterator<d$b> iterator = (Iterator<d$b>)d.iterator();
                int n4 = 0;
                while (true) {
                    Label_0235: {
                        if (!iterator.hasNext()) {
                            break Label_0235;
                        }
                        final d$b next = iterator.next();
                        try {
                            final d$b d$b = next;
                            if (d$b.b(d$a)) {
                                return b;
                            }
                            final int a = this.a(d$b.a(d$a));
                            try {
                                final d$a a2 = d$b.a;
                                try {
                                    final double b2 = a2.b;
                                    try {
                                        final int a3 = this.a(b2 - d$a.b);
                                        try {
                                            final d$a b3 = d$b.b;
                                            try {
                                                final double b4 = b3.b;
                                                try {
                                                    final int a4 = this.a(b4 - d$a.b);
                                                    if (a > 0 && a3 <= 0 && a4 > 0) {
                                                        ++n4;
                                                    }
                                                    if (a < 0 && a4 <= 0 && a3 > 0) {
                                                        --n4;
                                                        continue;
                                                    }
                                                    continue;
                                                    // iftrue(Label_0248:, n4 != 0)
                                                    b = false;
                                                }
                                                catch (Exception ex) {}
                                            }
                                            catch (Exception ex2) {}
                                        }
                                        catch (Exception ex3) {}
                                    }
                                    catch (Exception ex4) {}
                                }
                                catch (Exception ex5) {}
                            }
                            catch (Exception ex6) {}
                        }
                        catch (Exception ex7) {}
                    }
                }
            }
            catch (Exception ex8) {}
        }
        catch (Exception ex9) {}
        Label_0248: {
            return b;
        }
    }
}
