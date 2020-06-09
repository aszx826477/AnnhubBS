// 
// Decompiled by Procyon v0.5.30
// 

package com.bumptech.glide.gifencoder;

class NeuQuant
{
    protected static final int alphabiasshift = 10;
    protected static final int alpharadbias = 262144;
    protected static final int alpharadbshift = 18;
    protected static final int beta = 64;
    protected static final int betagamma = 65536;
    protected static final int betashift = 10;
    protected static final int gamma = 1024;
    protected static final int gammashift = 10;
    protected static final int initalpha = 1024;
    protected static final int initrad = 32;
    protected static final int initradius = 2048;
    protected static final int intbias = 65536;
    protected static final int intbiasshift = 16;
    protected static final int maxnetpos = 255;
    protected static final int minpicturebytes = 1509;
    protected static final int ncycles = 100;
    protected static final int netbiasshift = 4;
    protected static final int netsize = 256;
    protected static final int prime1 = 499;
    protected static final int prime2 = 491;
    protected static final int prime3 = 487;
    protected static final int prime4 = 503;
    protected static final int radbias = 256;
    protected static final int radbiasshift = 8;
    protected static final int radiusbias = 64;
    protected static final int radiusbiasshift = 6;
    protected static final int radiusdec = 30;
    protected int alphadec;
    protected int[] bias;
    protected int[] freq;
    protected int lengthcount;
    protected int[] netindex;
    protected int[][] network;
    protected int[] radpower;
    protected int samplefac;
    protected byte[] thepicture;
    
    public NeuQuant(final byte[] thepicture, final int lengthcount, final int samplefac) {
        final int n = 256;
        this.netindex = new int[n];
        this.bias = new int[n];
        this.freq = new int[n];
        this.radpower = new int[32];
        this.thepicture = thepicture;
        this.lengthcount = lengthcount;
        this.samplefac = samplefac;
        this.network = new int[n][];
        for (int i = 0; i < n; ++i) {
            final int[][] network = this.network;
            network[i] = new int[4];
            final int[] array = network[i];
            final int n2 = (i << 12) / n;
            array[2] = n2;
            array[0] = (array[1] = n2);
            this.freq[i] = n;
            this.bias[i] = 0;
        }
    }
    
    protected void alterneigh(final int n, final int n2, final int n3, final int n4, final int n5) {
        final int n6 = n2 - n;
        int n7;
        if (n6 < -1) {
            n7 = -1;
        }
        else {
            n7 = n6;
        }
        final int n8 = n2 + n;
        int n9;
        if (n8 > 256) {
            n9 = 256;
        }
        else {
            n9 = n8;
        }
        int n10 = n2 + 1;
        int n11 = n2 - 1;
        int n12 = 1;
        while (n10 < n9 || n11 > n7) {
            final int[] radpower = this.radpower;
            final int n13 = n12 + 1;
            final int n14 = radpower[n12];
            final int n15 = 2;
            final int n16 = 262144;
            final int n17 = 1;
            int n18 = 0;
            Label_0287: {
                if (n10 < n9) {
                    final int[][] network = this.network;
                    n18 = n10 + 1;
                    final int[] array2;
                    final int[] array = array2 = network[n10];
                    try {
                        array[0] = array2[0] - (array[0] - n3) * n14 / n16;
                        final int[] array3 = array;
                        try {
                            array[n17] = array3[n17] - (array[n17] - n4) * n14 / n16;
                            final int[] array4 = array;
                            try {
                                array[n15] = array4[n15] - (array[n15] - n5) * n14 / n16;
                                break Label_0287;
                            }
                            catch (Exception ex) {
                                break Label_0287;
                            }
                        }
                        catch (Exception ex2) {}
                    }
                    catch (Exception ex3) {}
                }
                n18 = n10;
            }
            if (n11 > n7) {
                final int[][] network2 = this.network;
                final int n19 = n11 - 1;
                final int[] array6;
                final int[] array5 = array6 = network2[n11];
                try {
                    array5[0] = array6[0] - (array5[0] - n3) * n14 / n16;
                    final int[] array7 = array5;
                    try {
                        array5[n17] = array7[n17] - (array5[n17] - n4) * n14 / n16;
                        final int[] array8 = array5;
                        try {
                            array5[n15] = array8[n15] - (array5[n15] - n5) * n14 / n16;
                        }
                        catch (Exception ex4) {}
                    }
                    catch (Exception ex5) {}
                }
                catch (Exception ex6) {}
                n12 = n13;
                n11 = n19;
                n10 = n18;
            }
            else {
                n12 = n13;
                n10 = n18;
            }
        }
    }
    
    protected void altersingle(final int n, final int n2, final int n3, final int n4, final int n5) {
        final int[] array = this.network[n2];
        array[0] -= (array[0] - n3) * n / 1024;
        final int n6 = 1;
        array[n6] -= (array[n6] - n4) * n / 1024;
        final int n7 = 2;
        array[n7] -= (array[n7] - n5) * n / 1024;
    }
    
    public byte[] colorMap() {
        final byte[] array = new byte[768];
        final int n = 256;
        final int[] array2 = new int[n];
        for (int i = 0; i < n; ++i) {
            array2[this.network[i][3]] = i;
        }
        int n2 = 0;
        int n6;
        for (int j = 0; j < n; ++j, n2 = n6) {
            final int n3 = array2[j];
            final int n4 = n2 + 1;
            final int[][] network = this.network;
            array[n2] = (byte)network[n3][0];
            final int n5 = n4 + 1;
            array[n4] = (byte)network[n3][1];
            n6 = n5 + 1;
            array[n5] = (byte)network[n3][2];
        }
        return array;
    }
    
    protected int contest(final int n, final int n2, final int n3) {
        int n5;
        int n4 = n5 = -1 >>> 1;
        int n7;
        int n6 = n7 = -1;
        for (int i = 0; i < 256; ++i) {
            final int[] array = this.network[i];
            int n8 = array[0] - n;
            if (n8 < 0) {
                n8 = -n8;
            }
            int n9 = array[1] - n2;
            if (n9 < 0) {
                n9 = -n9;
            }
            final int n10 = n8 + n9;
            int n11 = array[2] - n3;
            if (n11 < 0) {
                n11 = -n11;
            }
            final int n12 = n10 + n11;
            if (n12 < n4) {
                n4 = n12;
                n6 = i;
            }
            final int n13 = n12 - (this.bias[i] >> 12);
            if (n13 < n5) {
                n5 = n13;
                n7 = i;
            }
            final int[] freq = this.freq;
            final int n14 = freq[i] >> 10;
            freq[i] -= n14;
            final int[] bias = this.bias;
            bias[i] += n14 << 10;
        }
        final int[] freq2 = this.freq;
        freq2[n6] += 64;
        final int[] bias2 = this.bias;
        bias2[n6] -= 65536;
        return n7;
    }
    
    public void inxbuild() {
        int n = 0;
        int n2 = 0;
        int n3 = 0;
        int n4;
        while (true) {
            n4 = 256;
            final int n5 = 1;
            if (n3 >= n4) {
                break;
            }
            final int[] array = this.network[n3];
            int n6 = n3;
            int n7 = array[n5];
            for (int i = n3 + 1; i < n4; ++i) {
                final int[] array2 = this.network[i];
                if (array2[n5] < n7) {
                    n6 = i;
                    n7 = array2[n5];
                }
            }
            final int[] array3 = this.network[n6];
            if (n3 != n6) {
                final int n8 = array3[0];
                array3[0] = array[0];
                array[0] = n8;
                final int n9 = array3[n5];
                array3[n5] = array[n5];
                array[n5] = n9;
                final int n10 = 2;
                final int n11 = array3[n10];
                array3[n10] = array[n10];
                array[n10] = n11;
                final int n12 = 3;
                final int n13 = array3[n12];
                array3[n12] = array[n12];
                array[n12] = n13;
            }
            if (n7 != n) {
                this.netindex[n] = n2 + n3 >> 1;
                for (int j = n + 1; j < n7; ++j) {
                    this.netindex[j] = n3;
                }
                n = n7;
                n2 = n3;
            }
            ++n3;
        }
        this.netindex[n] = n2 + 255 >> 1;
        for (int k = n + 1; k < n4; ++k) {
            this.netindex[k] = 255;
        }
    }
    
    public void learn() {
        final int lengthcount = this.lengthcount;
        final int n = 1509;
        final int samplefac = 1;
        if (lengthcount < n) {
            this.samplefac = samplefac;
        }
        final int samplefac2 = this.samplefac;
        this.alphadec = (samplefac2 - 1) / 3 + 30;
        final byte[] thepicture = this.thepicture;
        final int lengthcount2 = this.lengthcount;
        final int n2 = this.lengthcount / (samplefac2 * 3);
        final int n3 = n2 / 100;
        final int n4 = 1024;
        final int n5 = 2048;
        int n6 = n5 >> 6;
        if (n6 <= samplefac) {
            n6 = 0;
        }
        for (int i = 0; i < n6; ++i) {
            this.radpower[i] = (n6 * n6 - i * i) * 256 / (n6 * n6) * n4;
        }
        final int lengthcount3 = this.lengthcount;
        int n7;
        if (lengthcount3 < n) {
            n7 = 3;
        }
        else if (lengthcount3 % 499 != 0) {
            n7 = 1497;
        }
        else if (lengthcount3 % 491 != 0) {
            n7 = 1473;
        }
        else if (lengthcount3 % 487 != 0) {
            n7 = 1461;
        }
        else {
            n7 = 1509;
        }
        int n8 = n3;
        int j = 0;
        int n9 = 0;
        int n10 = n4;
        int n11 = n5;
        int n12 = n6;
        while (j < n2) {
            final int n13 = (thepicture[n9 + 0] & 0xFF) << 4;
            final int n14 = (thepicture[n9 + 1] & 0xFF) << 4;
            final int n15 = (thepicture[n9 + 2] & 0xFF) << 4;
            final int contest = this.contest(n13, n14, n15);
            final int n16 = n15;
            final int n17 = n13;
            this.altersingle(n10, contest, n17, n14, n16);
            if (n12 != 0) {
                this.alterneigh(n12, contest, n17, n14, n16);
            }
            final int n18 = n9 + n7;
            if (n18 >= lengthcount2) {
                n9 = n18 - this.lengthcount;
            }
            else {
                n9 = n18;
            }
            ++j;
            if (n8 == 0) {
                n8 = 1;
            }
            if (j % n8 == 0) {
                n10 -= n10 / this.alphadec;
                n11 -= n11 / 30;
                final int n19 = n11 >> 6;
                if (n19 <= samplefac) {
                    n12 = 0;
                }
                else {
                    n12 = n19;
                }
                for (int k = 0; k < n12; ++k) {
                    this.radpower[k] = (n12 * n12 - k * k) * 256 / (n12 * n12) * n10;
                }
            }
        }
    }
    
    public int map(final int n, final int n2, final int n3) {
        int n4 = 1000;
        int n5 = -1;
        int n6 = this.netindex[n2];
        int n7 = n6 - 1;
        while (true) {
            final int n8 = 256;
            if (n6 >= n8 && n7 < 0) {
                break;
            }
            final int n9 = 3;
            final int n10 = 2;
            final int n11 = 1;
            if (n6 < n8) {
                final int[] array = this.network[n6];
                int n12 = array[n11] - n2;
                if (n12 >= n4) {
                    n6 = 256;
                }
                else {
                    ++n6;
                    if (n12 < 0) {
                        n12 = -n12;
                    }
                    int n13 = array[0] - n;
                    if (n13 < 0) {
                        n13 = -n13;
                    }
                    final int n14 = n12 + n13;
                    if (n14 < n4) {
                        int n15 = array[n10] - n3;
                        if (n15 < 0) {
                            n15 = -n15;
                        }
                        final int n16 = n14 + n15;
                        if (n16 < n4) {
                            n4 = n16;
                            n5 = array[n9];
                        }
                    }
                }
            }
            if (n7 < 0) {
                continue;
            }
            final int[] array2 = this.network[n7];
            int n17 = n2 - array2[n11];
            if (n17 >= n4) {
                n7 = -1;
            }
            else {
                --n7;
                if (n17 < 0) {
                    n17 = -n17;
                }
                int n18 = array2[0] - n;
                if (n18 < 0) {
                    n18 = -n18;
                }
                final int n19 = n17 + n18;
                if (n19 >= n4) {
                    continue;
                }
                int n20 = array2[n10] - n3;
                if (n20 < 0) {
                    n20 = -n20;
                }
                final int n21 = n19 + n20;
                if (n21 >= n4) {
                    continue;
                }
                n4 = n21;
                n5 = array2[n9];
            }
        }
        return n5;
    }
    
    public byte[] process() {
        this.learn();
        this.unbiasnet();
        this.inxbuild();
        return this.colorMap();
    }
    
    public void unbiasnet() {
        for (int i = 0; i < 256; ++i) {
            final int[][] network = this.network;
            final int[] array = network[i];
            array[0] >>= 4;
            final int[] array2 = network[i];
            final int n = 1;
            array2[n] >>= 4;
            final int[] array3 = network[i];
            final int n2 = 2;
            array3[n2] >>= 4;
            network[i][3] = i;
        }
    }
}
