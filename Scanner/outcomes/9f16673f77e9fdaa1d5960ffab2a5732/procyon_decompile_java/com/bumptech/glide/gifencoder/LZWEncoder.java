// 
// Decompiled by Procyon v0.5.30
// 

package com.bumptech.glide.gifencoder;

import java.io.OutputStream;

class LZWEncoder
{
    static final int BITS = 12;
    private static final int EOF = 255;
    static final int HSIZE = 5003;
    int ClearCode;
    int EOFCode;
    int a_count;
    byte[] accum;
    boolean clear_flg;
    int[] codetab;
    private int curPixel;
    int cur_accum;
    int cur_bits;
    int free_ent;
    int g_init_bits;
    int hsize;
    int[] htab;
    private int imgH;
    private int imgW;
    private int initCodeSize;
    int[] masks;
    int maxbits;
    int maxcode;
    int maxmaxcode;
    int n_bits;
    private byte[] pixAry;
    private int remaining;
    
    LZWEncoder(final int imgW, final int imgH, final byte[] pixAry, final int n) {
        this.maxbits = 12;
        this.maxmaxcode = 4096;
        final int hsize = 5003;
        this.htab = new int[hsize];
        this.codetab = new int[hsize];
        this.hsize = hsize;
        this.free_ent = 0;
        this.clear_flg = false;
        this.cur_accum = 0;
        this.cur_bits = 0;
        final int[] array;
        final int[] masks = array = new int[17];
        array[0] = 0;
        array[1] = 1;
        array[array[2] = 3] = 7;
        array[4] = 15;
        array[5] = 31;
        array[6] = 63;
        array[7] = 127;
        array[8] = 255;
        array[9] = 511;
        array[10] = 1023;
        array[11] = 2047;
        array[12] = 4095;
        array[13] = 8191;
        array[14] = 16383;
        array[15] = 32767;
        array[16] = (char)(-1);
        this.masks = masks;
        this.accum = new byte[256];
        this.imgW = imgW;
        this.imgH = imgH;
        this.pixAry = pixAry;
        this.initCodeSize = Math.max(2, n);
    }
    
    private int nextPixel() {
        final int remaining = this.remaining;
        if (remaining == 0) {
            return -1;
        }
        this.remaining = remaining - 1;
        return this.pixAry[this.curPixel++] & 0xFF;
    }
    
    final int MAXCODE(final int n) {
        final int n2 = 1;
        return (n2 << n) - n2;
    }
    
    void char_out(final byte b, final OutputStream outputStream) {
        this.accum[this.a_count++] = b;
        if (this.a_count >= 254) {
            this.flush_char(outputStream);
        }
    }
    
    void cl_block(final OutputStream outputStream) {
        this.cl_hash(this.hsize);
        final int clearCode = this.ClearCode;
        this.free_ent = clearCode + 2;
        this.clear_flg = true;
        this.output(clearCode, outputStream);
    }
    
    void cl_hash(final int n) {
        for (int i = 0; i < n; ++i) {
            this.htab[i] = -1;
        }
    }
    
    void compress(final int g_init_bits, final OutputStream outputStream) {
        this.g_init_bits = g_init_bits;
        this.clear_flg = false;
        this.n_bits = this.g_init_bits;
        this.maxcode = this.MAXCODE(this.n_bits);
        this.ClearCode = 1 << g_init_bits - 1;
        final int clearCode = this.ClearCode;
        this.EOFCode = clearCode + 1;
        this.free_ent = clearCode + 2;
        this.a_count = 0;
        int nextPixel = this.nextPixel();
        int n = 0;
        for (int i = this.hsize; i < 65536; i *= 2) {
            ++n;
        }
        final int n2 = 8 - n;
        final int hsize = this.hsize;
        this.cl_hash(hsize);
        this.output(this.ClearCode, outputStream);
        int nextPixel2;
    Label_0147:
        while ((nextPixel2 = this.nextPixel()) != -1) {
            final int n3 = (nextPixel2 << this.maxbits) + nextPixel;
            int n4 = nextPixel2 << n2 ^ nextPixel;
            final int[] htab = this.htab;
            if (htab[n4] == n3) {
                nextPixel = this.codetab[n4];
            }
            else {
                if (htab[n4] >= 0) {
                    int n5 = hsize - n4;
                    if (n4 == 0) {
                        n5 = 1;
                    }
                    int[] htab2;
                    do {
                        final int n6 = n4 - n5;
                        if ((n4 = n6) < 0) {
                            n4 = n6 + hsize;
                        }
                        htab2 = this.htab;
                        if (htab2[n4] == n3) {
                            nextPixel = this.codetab[n4];
                            continue Label_0147;
                        }
                    } while (htab2[n4] >= 0);
                }
                this.output(nextPixel, outputStream);
                nextPixel = nextPixel2;
                final int free_ent = this.free_ent;
                if (free_ent < this.maxmaxcode) {
                    final int[] codetab = this.codetab;
                    this.free_ent = free_ent + 1;
                    codetab[n4] = free_ent;
                    this.htab[n4] = n3;
                }
                else {
                    this.cl_block(outputStream);
                }
            }
        }
        this.output(nextPixel, outputStream);
        this.output(this.EOFCode, outputStream);
    }
    
    void encode(final OutputStream outputStream) {
        outputStream.write(this.initCodeSize);
        this.remaining = this.imgW * this.imgH;
        this.curPixel = 0;
        this.compress(this.initCodeSize + 1, outputStream);
        outputStream.write(0);
    }
    
    void flush_char(final OutputStream outputStream) {
        final int a_count = this.a_count;
        if (a_count > 0) {
            outputStream.write(a_count);
            outputStream.write(this.accum, 0, this.a_count);
            this.a_count = 0;
        }
    }
    
    void output(final int cur_accum, final OutputStream outputStream) {
        final int cur_accum2 = this.cur_accum;
        final int[] masks = this.masks;
        final int cur_bits = this.cur_bits;
        this.cur_accum = (cur_accum2 & masks[cur_bits]);
        if (cur_bits > 0) {
            this.cur_accum |= cur_accum << cur_bits;
        }
        else {
            this.cur_accum = cur_accum;
        }
        this.cur_bits += this.n_bits;
        int n;
        while (true) {
            final int cur_bits2 = this.cur_bits;
            n = 8;
            if (cur_bits2 < n) {
                break;
            }
            this.char_out((byte)(this.cur_accum & 0xFF), outputStream);
            this.cur_accum >>= n;
            this.cur_bits -= n;
        }
        if (this.free_ent > this.maxcode || this.clear_flg) {
            if (this.clear_flg) {
                final int g_init_bits = this.g_init_bits;
                this.n_bits = g_init_bits;
                this.maxcode = this.MAXCODE(g_init_bits);
                this.clear_flg = false;
            }
            else {
                ++this.n_bits;
                final int n_bits = this.n_bits;
                if (n_bits == this.maxbits) {
                    this.maxcode = this.maxmaxcode;
                }
                else {
                    this.maxcode = this.MAXCODE(n_bits);
                }
            }
        }
        if (cur_accum == this.EOFCode) {
            while (this.cur_bits > 0) {
                this.char_out((byte)(this.cur_accum & 0xFF), outputStream);
                this.cur_accum >>= n;
                this.cur_bits -= n;
            }
            this.flush_char(outputStream);
        }
    }
}
