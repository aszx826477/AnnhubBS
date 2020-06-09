// 
// Decompiled by Procyon v0.5.30
// 

package okhttp3.internal.framed;

import java.io.OutputStream;
import java.io.ByteArrayOutputStream;

class Huffman
{
    private static final int[] CODES;
    private static final byte[] CODE_LENGTHS;
    private static final Huffman INSTANCE;
    private final Huffman$Node root;
    
    static {
        final int n = 256;
        final int[] array;
        final int[] codes = array = new int[n];
        array[0] = 8184;
        array[1] = 8388568;
        array[2] = 268435426;
        array[3] = 268435427;
        array[4] = 268435428;
        array[5] = 268435429;
        array[6] = 268435430;
        array[7] = 268435431;
        array[8] = 268435432;
        array[9] = 16777194;
        array[10] = 1073741820;
        array[11] = 268435433;
        array[12] = 268435434;
        array[13] = 1073741821;
        array[14] = 268435435;
        array[15] = 268435436;
        array[16] = 268435437;
        array[17] = 268435438;
        array[18] = 268435439;
        array[19] = 268435440;
        array[20] = 268435441;
        array[21] = 268435442;
        array[22] = 1073741822;
        array[23] = 268435443;
        array[24] = 268435444;
        array[25] = 268435445;
        array[26] = 268435446;
        array[27] = 268435447;
        array[28] = 268435448;
        array[29] = 268435449;
        array[30] = 268435450;
        array[31] = 268435451;
        array[32] = 20;
        array[33] = 1016;
        array[34] = 1017;
        array[35] = 4090;
        array[36] = 8185;
        array[37] = 21;
        array[38] = 248;
        array[39] = 2042;
        array[40] = 1018;
        array[41] = 1019;
        array[42] = 249;
        array[43] = 2043;
        array[44] = 250;
        array[45] = 22;
        array[46] = 23;
        array[47] = 24;
        array[48] = 0;
        array[49] = 1;
        array[50] = 2;
        array[51] = 25;
        array[52] = 26;
        array[53] = 27;
        array[54] = 28;
        array[55] = 29;
        array[56] = 30;
        array[57] = 31;
        array[58] = 92;
        array[59] = 251;
        array[60] = 32764;
        array[61] = 32;
        array[62] = 4091;
        array[63] = 1020;
        array[64] = 8186;
        array[65] = 33;
        array[66] = 93;
        array[67] = 94;
        array[68] = 95;
        array[69] = 96;
        array[70] = 97;
        array[71] = 98;
        array[72] = 99;
        array[73] = 100;
        array[74] = 101;
        array[75] = 102;
        array[76] = 103;
        array[77] = 104;
        array[78] = 105;
        array[79] = 106;
        array[80] = 107;
        array[81] = 108;
        array[82] = 109;
        array[83] = 110;
        array[84] = 111;
        array[85] = 112;
        array[86] = 113;
        array[87] = 114;
        array[88] = 252;
        array[89] = 115;
        array[90] = 253;
        array[91] = 8187;
        array[92] = 524272;
        array[93] = 8188;
        array[94] = 16380;
        array[95] = 34;
        array[96] = 32765;
        array[97] = 3;
        array[98] = 35;
        array[99] = 4;
        array[100] = 36;
        array[101] = 5;
        array[102] = 37;
        array[103] = 38;
        array[104] = 39;
        array[105] = 6;
        array[106] = 116;
        array[107] = 117;
        array[108] = 40;
        array[109] = 41;
        array[110] = 42;
        array[111] = 7;
        array[112] = 43;
        array[113] = 118;
        array[114] = 44;
        array[115] = 8;
        array[116] = 9;
        array[117] = 45;
        array[array[118] = 119] = 120;
        array[array[120] = 121] = 122;
        array[array[122] = 123] = 32766;
        array[124] = 2044;
        array[125] = 16381;
        array[126] = 8189;
        array[127] = 268435452;
        array[128] = 1048550;
        array[129] = 4194258;
        array[130] = 1048551;
        array[131] = 1048552;
        array[132] = 4194259;
        array[133] = 4194260;
        array[134] = 4194261;
        array[135] = 8388569;
        array[136] = 4194262;
        array[137] = 8388570;
        array[138] = 8388571;
        array[139] = 8388572;
        array[140] = 8388573;
        array[141] = 8388574;
        array[142] = 16777195;
        array[143] = 8388575;
        array[144] = 16777196;
        array[145] = 16777197;
        array[146] = 4194263;
        array[147] = 8388576;
        array[148] = 16777198;
        array[149] = 8388577;
        array[150] = 8388578;
        array[151] = 8388579;
        array[152] = 8388580;
        array[153] = 2097116;
        array[154] = 4194264;
        array[155] = 8388581;
        array[156] = 4194265;
        array[157] = 8388582;
        array[158] = 8388583;
        array[159] = 16777199;
        array[160] = 4194266;
        array[161] = 2097117;
        array[162] = 1048553;
        array[163] = 4194267;
        array[164] = 4194268;
        array[165] = 8388584;
        array[166] = 8388585;
        array[167] = 2097118;
        array[168] = 8388586;
        array[169] = 4194269;
        array[170] = 4194270;
        array[171] = 16777200;
        array[172] = 2097119;
        array[173] = 4194271;
        array[174] = 8388587;
        array[175] = 8388588;
        array[176] = 2097120;
        array[177] = 2097121;
        array[178] = 4194272;
        array[179] = 2097122;
        array[180] = 8388589;
        array[181] = 4194273;
        array[182] = 8388590;
        array[183] = 8388591;
        array[184] = 1048554;
        array[185] = 4194274;
        array[186] = 4194275;
        array[187] = 4194276;
        array[188] = 8388592;
        array[189] = 4194277;
        array[190] = 4194278;
        array[191] = 8388593;
        array[192] = 67108832;
        array[193] = 67108833;
        array[194] = 1048555;
        array[195] = 524273;
        array[196] = 4194279;
        array[197] = 8388594;
        array[198] = 4194280;
        array[199] = 33554412;
        array[200] = 67108834;
        array[201] = 67108835;
        array[202] = 67108836;
        array[203] = 134217694;
        array[204] = 134217695;
        array[205] = 67108837;
        array[206] = 16777201;
        array[207] = 33554413;
        array[208] = 524274;
        array[209] = 2097123;
        array[210] = 67108838;
        array[211] = 134217696;
        array[212] = 134217697;
        array[213] = 67108839;
        array[214] = 134217698;
        array[215] = 16777202;
        array[216] = 2097124;
        array[217] = 2097125;
        array[218] = 67108840;
        array[219] = 67108841;
        array[220] = 268435453;
        array[221] = 134217699;
        array[222] = 134217700;
        array[223] = 134217701;
        array[224] = 1048556;
        array[225] = 16777203;
        array[226] = 1048557;
        array[227] = 2097126;
        array[228] = 4194281;
        array[229] = 2097127;
        array[230] = 2097128;
        array[231] = 8388595;
        array[232] = 4194282;
        array[233] = 4194283;
        array[234] = 33554414;
        array[235] = 33554415;
        array[236] = 16777204;
        array[237] = 16777205;
        array[238] = 67108842;
        array[239] = 8388596;
        array[240] = 67108843;
        array[241] = 134217702;
        array[242] = 67108844;
        array[243] = 67108845;
        array[244] = 134217703;
        array[245] = 134217704;
        array[246] = 134217705;
        array[247] = 134217706;
        array[248] = 134217707;
        array[249] = 268435454;
        array[250] = 134217708;
        array[251] = 134217709;
        array[252] = 134217710;
        array[253] = 134217711;
        array[254] = 134217712;
        array[255] = 67108846;
        CODES = codes;
        final byte[] array2;
        final byte[] code_LENGTHS = array2 = new byte[n];
        array2[0] = 13;
        array2[1] = 23;
        array2[2] = 28;
        array2[4] = (array2[3] = 28);
        array2[6] = (array2[5] = 28);
        array2[8] = (array2[7] = 28);
        array2[9] = 24;
        array2[10] = 30;
        array2[12] = (array2[11] = 28);
        array2[13] = 30;
        array2[15] = (array2[14] = 28);
        array2[17] = (array2[16] = 28);
        array2[19] = (array2[18] = 28);
        array2[21] = (array2[20] = 28);
        array2[22] = 30;
        array2[23] = 28;
        array2[25] = (array2[24] = 28);
        array2[27] = (array2[26] = 28);
        array2[29] = (array2[28] = 28);
        array2[31] = (array2[30] = 28);
        array2[32] = 6;
        array2[34] = (array2[33] = 10);
        array2[35] = 12;
        array2[36] = 13;
        array2[37] = 6;
        array2[38] = 8;
        array2[39] = 11;
        array2[41] = (array2[40] = 10);
        array2[42] = 8;
        array2[43] = 11;
        array2[44] = 8;
        array2[45] = 6;
        array2[47] = (array2[46] = 6);
        array2[48] = 5;
        array2[50] = (array2[49] = 5);
        array2[51] = 6;
        array2[53] = (array2[52] = 6);
        array2[55] = (array2[54] = 6);
        array2[57] = (array2[56] = 6);
        array2[58] = 7;
        array2[59] = 8;
        array2[60] = 15;
        array2[61] = 6;
        array2[62] = 12;
        array2[63] = 10;
        array2[64] = 13;
        array2[65] = 6;
        array2[67] = (array2[66] = 7);
        array2[69] = (array2[68] = 7);
        array2[71] = (array2[70] = 7);
        array2[73] = (array2[72] = 7);
        array2[75] = (array2[74] = 7);
        array2[77] = (array2[76] = 7);
        array2[79] = (array2[78] = 7);
        array2[81] = (array2[80] = 7);
        array2[83] = (array2[82] = 7);
        array2[85] = (array2[84] = 7);
        array2[87] = (array2[86] = 7);
        array2[88] = 8;
        array2[89] = 7;
        array2[90] = 8;
        array2[91] = 13;
        array2[92] = 19;
        array2[93] = 13;
        array2[94] = 14;
        array2[95] = 6;
        array2[96] = 15;
        array2[97] = 5;
        array2[98] = 6;
        array2[99] = 5;
        array2[100] = 6;
        array2[101] = 5;
        array2[102] = 6;
        array2[104] = (array2[103] = 6);
        array2[105] = 5;
        array2[107] = (array2[106] = 7);
        array2[108] = 6;
        array2[110] = (array2[109] = 6);
        array2[111] = 5;
        array2[112] = 6;
        array2[113] = 7;
        array2[114] = 6;
        array2[116] = (array2[115] = 5);
        array2[117] = 6;
        array2[118] = 7;
        array2[120] = (array2[119] = 7);
        array2[122] = (array2[121] = 7);
        array2[123] = 15;
        array2[124] = 11;
        array2[125] = 14;
        array2[126] = 13;
        array2[127] = 28;
        array2[128] = 20;
        array2[129] = 22;
        array2[131] = (array2[130] = 20);
        array2[132] = 22;
        array2[134] = (array2[133] = 22);
        array2[135] = 23;
        array2[136] = 22;
        array2[137] = 23;
        array2[139] = (array2[138] = 23);
        array2[141] = (array2[140] = 23);
        array2[142] = 24;
        array2[143] = 23;
        array2[145] = (array2[144] = 24);
        array2[146] = 22;
        array2[147] = 23;
        array2[148] = 24;
        array2[150] = (array2[149] = 23);
        array2[152] = (array2[151] = 23);
        array2[153] = 21;
        array2[154] = 22;
        array2[155] = 23;
        array2[156] = 22;
        array2[158] = (array2[157] = 23);
        array2[159] = 24;
        array2[160] = 22;
        array2[161] = 21;
        array2[162] = 20;
        array2[164] = (array2[163] = 22);
        array2[166] = (array2[165] = 23);
        array2[167] = 21;
        array2[168] = 23;
        array2[170] = (array2[169] = 22);
        array2[171] = 24;
        array2[172] = 21;
        array2[173] = 22;
        array2[175] = (array2[174] = 23);
        array2[177] = (array2[176] = 21);
        array2[178] = 22;
        array2[179] = 21;
        array2[180] = 23;
        array2[181] = 22;
        array2[183] = (array2[182] = 23);
        array2[184] = 20;
        array2[185] = 22;
        array2[187] = (array2[186] = 22);
        array2[188] = 23;
        array2[190] = (array2[189] = 22);
        array2[191] = 23;
        array2[193] = (array2[192] = 26);
        array2[194] = 20;
        array2[195] = 19;
        array2[196] = 22;
        array2[197] = 23;
        array2[198] = 22;
        array2[199] = 25;
        array2[200] = 26;
        array2[202] = (array2[201] = 26);
        array2[204] = (array2[203] = 27);
        array2[205] = 26;
        array2[206] = 24;
        array2[207] = 25;
        array2[208] = 19;
        array2[209] = 21;
        array2[210] = 26;
        array2[212] = (array2[211] = 27);
        array2[213] = 26;
        array2[214] = 27;
        array2[215] = 24;
        array2[217] = (array2[216] = 21);
        array2[219] = (array2[218] = 26);
        array2[220] = 28;
        array2[221] = 27;
        array2[223] = (array2[222] = 27);
        array2[224] = 20;
        array2[225] = 24;
        array2[226] = 20;
        array2[227] = 21;
        array2[228] = 22;
        array2[230] = (array2[229] = 21);
        array2[231] = 23;
        array2[233] = (array2[232] = 22);
        array2[235] = (array2[234] = 25);
        array2[237] = (array2[236] = 24);
        array2[238] = 26;
        array2[239] = 23;
        array2[240] = 26;
        array2[241] = 27;
        array2[243] = (array2[242] = 26);
        array2[244] = 27;
        array2[246] = (array2[245] = 27);
        array2[248] = (array2[247] = 27);
        array2[249] = 28;
        array2[250] = 27;
        array2[252] = (array2[251] = 27);
        array2[254] = (array2[253] = 27);
        array2[255] = 26;
        CODE_LENGTHS = code_LENGTHS;
        INSTANCE = new Huffman();
    }
    
    private Huffman() {
        this.root = new Huffman$Node();
        this.buildTree();
    }
    
    private void addCode(final int n, final int n2, byte b) {
        final Huffman$Node huffman$Node = new Huffman$Node(n, b);
        Huffman$Node root = this.root;
        while (true) {
            final byte b2 = 8;
            if (b <= b2) {
                final byte b3 = (byte)(b2 - b);
                for (int n3 = n2 << b3 & 0xFF, n4 = 1 << b3, i = n3; i < n3 + n4; ++i) {
                    root.children[i] = huffman$Node;
                }
                return;
            }
            b -= 8;
            final int n5 = n2 >>> b & 0xFF;
            if (root.children == null) {
                throw new IllegalStateException("invalid dictionary: prefix not unique");
            }
            if (root.children[n5] == null) {
                root.children[n5] = new Huffman$Node();
            }
            root = root.children[n5];
        }
    }
    
    private void buildTree() {
        int n = 0;
        while (true) {
            final byte[] code_LENGTHS = Huffman.CODE_LENGTHS;
            if (n >= code_LENGTHS.length) {
                break;
            }
            this.addCode(n, Huffman.CODES[n], code_LENGTHS[n]);
            ++n;
        }
    }
    
    public static Huffman get() {
        return Huffman.INSTANCE;
    }
    
    byte[] decode(final byte[] array) {
        final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        Huffman$Node huffman$Node = this.root;
        int n = 0;
        int i = 0;
        int n2 = 0;
        while (true) {
            final int length = array.length;
            final int n3 = 8;
            if (n2 >= length) {
                break;
            }
            n = (n << 8 | (array[n2] & 0xFF));
            i += 8;
            while (i >= n3) {
                huffman$Node = huffman$Node.children[n >>> i - 8 & 0xFF];
                if (huffman$Node.children == null) {
                    byteArrayOutputStream.write(huffman$Node.symbol);
                    i -= huffman$Node.terminalBits;
                    huffman$Node = this.root;
                }
                else {
                    i -= 8;
                }
            }
            ++n2;
        }
        while (i > 0) {
            final Huffman$Node huffman$Node2 = huffman$Node.children[n << 8 - i & 0xFF];
            if (huffman$Node2.children != null) {
                break;
            }
            if (huffman$Node2.terminalBits > i) {
                break;
            }
            byteArrayOutputStream.write(huffman$Node2.symbol);
            i -= huffman$Node2.terminalBits;
            huffman$Node = this.root;
        }
        return byteArrayOutputStream.toByteArray();
    }
    
    void encode(final byte[] array, final OutputStream outputStream) {
        long n = 0L;
        byte b = 0;
        int n2 = 0;
        byte b2;
        int n3;
        while (true) {
            final int length = array.length;
            b2 = 8;
            n3 = 255;
            if (n2 >= length) {
                break;
            }
            final byte b3 = (byte)(array[n2] & n3);
            final int n4 = Huffman.CODES[b3];
            final byte b4 = Huffman.CODE_LENGTHS[b3];
            n = (n << b4 | n4);
            b += b4;
            while (b >= b2) {
                b -= 8;
                outputStream.write((int)(n >> b));
            }
            ++n2;
        }
        if (b > 0) {
            outputStream.write((int)(n << b2 - b | n3 >>> b));
        }
    }
    
    int encodedLength(final byte[] array) {
        long n = 0L;
        for (int i = 0; i < array.length; ++i) {
            n += Huffman.CODE_LENGTHS[array[i] & 0xFF];
        }
        return (int)(7 + n >> 3);
    }
}
