// 
// Decompiled by Procyon v0.5.30
// 

package okhttp3.internal.tls;

import javax.security.auth.x500.X500Principal;

final class DistinguishedNameParser
{
    private int beg;
    private char[] chars;
    private int cur;
    private final String dn;
    private int end;
    private final int length;
    private int pos;
    
    public DistinguishedNameParser(final X500Principal x500Principal) {
        this.dn = x500Principal.getName("RFC2253");
        this.length = this.dn.length();
    }
    
    private String escapedAV() {
        final int pos = this.pos;
        this.beg = pos;
        this.end = pos;
        Label_0440: {
        Label_0222:
            while (true) {
                final int pos2 = this.pos;
                if (pos2 >= this.length) {
                    final char[] chars = this.chars;
                    final int beg = this.beg;
                    return new String(chars, beg, this.end - beg);
                }
                final char[] chars2 = this.chars;
                final char c = chars2[pos2];
                final char c2 = ';';
                final char c3 = ' ';
                if (c != c3) {
                    if (c == c2) {
                        break;
                    }
                    if (c != '\\') {
                        switch (c) {
                            default: {
                                chars2[this.end++] = chars2[pos2];
                                this.pos = pos2 + 1;
                                continue;
                            }
                            case 43:
                            case 44: {
                                break Label_0222;
                            }
                        }
                    }
                    else {
                        chars2[this.end++] = this.getEscaped();
                        ++this.pos;
                    }
                }
                else {
                    final int end = this.end;
                    this.cur = end;
                    this.pos = pos2 + 1;
                    this.end = end + 1;
                    chars2[end] = c3;
                    while (true) {
                        final int pos3 = this.pos;
                        if (pos3 >= this.length) {
                            break;
                        }
                        final char[] chars3 = this.chars;
                        if (chars3[pos3] != c3) {
                            break;
                        }
                        chars3[this.end++] = c3;
                        this.pos = pos3 + 1;
                    }
                    final int pos4 = this.pos;
                    if (pos4 == this.length) {
                        break Label_0440;
                    }
                    final char[] chars4 = this.chars;
                    if (chars4[pos4] == ',' || chars4[pos4] == '+') {
                        break Label_0440;
                    }
                    if (chars4[pos4] == c2) {
                        break Label_0440;
                    }
                    continue;
                }
            }
            final char[] chars5 = this.chars;
            final int beg2 = this.beg;
            return new String(chars5, beg2, this.end - beg2);
        }
        final char[] chars6 = this.chars;
        final int beg3 = this.beg;
        return new String(chars6, beg3, this.cur - beg3);
    }
    
    private int getByte(final int n) {
        if (n + 1 < this.length) {
            final char c = this.chars[n];
            final char c2 = 'F';
            final char c3 = 'f';
            final char c4 = 'A';
            final char c5 = '9';
            final char c6 = 'a';
            final char c7 = '0';
            int n2;
            if (c >= c7 && c <= c5) {
                n2 = c - c7;
            }
            else if (c >= c6 && c <= c3) {
                n2 = c - 87;
            }
            else {
                if (c < c4 || c > c2) {
                    final StringBuilder sb = new StringBuilder();
                    sb.append("Malformed DN: ");
                    sb.append(this.dn);
                    throw new IllegalStateException(sb.toString());
                }
                n2 = c - 55;
            }
            final char c8 = this.chars[n + 1];
            int n3;
            if (c8 >= c7 && c8 <= c5) {
                n3 = c8 - c7;
            }
            else if (c8 >= c6 && c8 <= c3) {
                n3 = c8 - 87;
            }
            else {
                if (c8 < c4 || c8 > c2) {
                    final StringBuilder sb2 = new StringBuilder();
                    sb2.append("Malformed DN: ");
                    sb2.append(this.dn);
                    throw new IllegalStateException(sb2.toString());
                }
                n3 = c8 - 55;
            }
            return (n2 << 4) + n3;
        }
        final StringBuilder sb3 = new StringBuilder();
        sb3.append("Malformed DN: ");
        sb3.append(this.dn);
        throw new IllegalStateException(sb3.toString());
    }
    
    private char getEscaped() {
        ++this.pos;
        final int pos = this.pos;
        if (pos != this.length) {
            final char c = this.chars[pos];
            Label_0157: {
                if (c != ' ' && c != '%' && c != '\\' && c != '_') {
                    switch (c) {
                        default: {
                            switch (c) {
                                default: {
                                    switch (c) {
                                        default: {
                                            return this.getUTF8();
                                        }
                                        case 59:
                                        case 60:
                                        case 61:
                                        case 62: {
                                            break Label_0157;
                                        }
                                    }
                                    break;
                                }
                                case 42:
                                case 43:
                                case 44: {
                                    break Label_0157;
                                }
                            }
                            break;
                        }
                        case 34:
                        case 35: {
                            break;
                        }
                    }
                }
            }
            return this.chars[this.pos];
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("Unexpected end of DN: ");
        sb.append(this.dn);
        throw new IllegalStateException(sb.toString());
    }
    
    private char getUTF8() {
        final int byte1 = this.getByte(this.pos);
        ++this.pos;
        final int n = 128;
        if (byte1 < n) {
            return (char)byte1;
        }
        final int n2 = 192;
        final char c = '?';
        if (byte1 >= n2 && byte1 <= 247) {
            int n3;
            int n4;
            if (byte1 <= 223) {
                n3 = 1;
                n4 = (byte1 & 0x1F);
            }
            else if (byte1 <= 239) {
                n3 = 2;
                n4 = (byte1 & 0xF);
            }
            else {
                n3 = 3;
                n4 = (byte1 & 0x7);
            }
            for (int i = 0; i < n3; ++i) {
                ++this.pos;
                final int pos = this.pos;
                if (pos == this.length || this.chars[pos] != '\\') {
                    return c;
                }
                this.pos = pos + 1;
                final int byte2 = this.getByte(this.pos);
                ++this.pos;
                if ((byte2 & 0xC0) != n) {
                    return c;
                }
                n4 = (n4 << 6) + (byte2 & 0x3F);
            }
            return (char)n4;
        }
        return c;
    }
    
    private String hexAV() {
        final int pos = this.pos;
        if (pos + 4 >= this.length) {
            final StringBuilder sb = new StringBuilder();
            sb.append("Unexpected end of DN: ");
            sb.append(this.dn);
            throw new IllegalStateException(sb.toString());
        }
        this.beg = pos;
        this.pos = pos + 1;
        Label_0250: {
            while (true) {
                final int pos2 = this.pos;
                if (pos2 == this.length) {
                    break;
                }
                final char[] chars = this.chars;
                if (chars[pos2] == '+' || chars[pos2] == ',') {
                    break;
                }
                if (chars[pos2] == ';') {
                    break;
                }
                final char c = chars[pos2];
                final char c2 = ' ';
                if (c == c2) {
                    this.end = pos2;
                    this.pos = pos2 + 1;
                    while (true) {
                        final int pos3 = this.pos;
                        if (pos3 >= this.length || this.chars[pos3] != c2) {
                            break;
                        }
                        this.pos = pos3 + 1;
                    }
                    break Label_0250;
                }
                if (chars[pos2] >= 'A' && chars[pos2] <= 'F') {
                    chars[pos2] += c2;
                }
                ++this.pos;
            }
            this.end = this.pos;
        }
        final int end = this.end;
        final int beg = this.beg;
        final int n = end - beg;
        if (n >= 5 && (n & 0x1) != 0x0) {
            final byte[] array = new byte[n / 2];
            int i = 0;
            int n2 = beg + 1;
            while (i < array.length) {
                array[i] = (byte)this.getByte(n2);
                n2 += 2;
                ++i;
            }
            return new String(this.chars, this.beg, n);
        }
        final StringBuilder sb2 = new StringBuilder();
        sb2.append("Unexpected end of DN: ");
        sb2.append(this.dn);
        throw new IllegalStateException(sb2.toString());
    }
    
    private String nextAT() {
        char c;
        while (true) {
            final int pos = this.pos;
            final int length = this.length;
            c = ' ';
            if (pos >= length || this.chars[pos] != c) {
                break;
            }
            this.pos = pos + 1;
        }
        final int pos2 = this.pos;
        if (pos2 == this.length) {
            return null;
        }
        this.beg = pos2;
        this.pos = pos2 + 1;
        char c2;
        while (true) {
            final int pos3 = this.pos;
            final int length2 = this.length;
            c2 = '=';
            if (pos3 >= length2) {
                break;
            }
            final char[] chars = this.chars;
            if (chars[pos3] == c2 || chars[pos3] == c) {
                break;
            }
            this.pos = pos3 + 1;
        }
        final int pos4 = this.pos;
        if (pos4 < this.length) {
            this.end = pos4;
            if (this.chars[pos4] == c) {
                while (true) {
                    final int pos5 = this.pos;
                    if (pos5 >= this.length) {
                        break;
                    }
                    final char[] chars2 = this.chars;
                    if (chars2[pos5] == c2 || chars2[pos5] != c) {
                        break;
                    }
                    this.pos = pos5 + 1;
                }
                final char[] chars3 = this.chars;
                final int pos6 = this.pos;
                if (chars3[pos6] != c2 || pos6 == this.length) {
                    final StringBuilder sb = new StringBuilder();
                    sb.append("Unexpected end of DN: ");
                    sb.append(this.dn);
                    throw new IllegalStateException(sb.toString());
                }
            }
            ++this.pos;
            while (true) {
                final int pos7 = this.pos;
                if (pos7 >= this.length || this.chars[pos7] != c) {
                    break;
                }
                this.pos = pos7 + 1;
            }
            final int end = this.end;
            final int beg = this.beg;
            final int n = end - beg;
            final int n2 = 4;
            if (n > n2) {
                final char[] chars4 = this.chars;
                if (chars4[beg + 3] == '.' && (chars4[beg] == 'O' || chars4[beg] == 'o')) {
                    final char[] chars5 = this.chars;
                    final int beg2 = this.beg;
                    if (chars5[beg2 + 1] == 'I' || chars5[beg2 + 1] == 'i') {
                        final char[] chars6 = this.chars;
                        final int beg3 = this.beg;
                        if (chars6[beg3 + 2] == 'D' || chars6[beg3 + 2] == 'd') {
                            this.beg += n2;
                        }
                    }
                }
            }
            final char[] chars7 = this.chars;
            final int beg4 = this.beg;
            return new String(chars7, beg4, this.end - beg4);
        }
        final StringBuilder sb2 = new StringBuilder();
        sb2.append("Unexpected end of DN: ");
        sb2.append(this.dn);
        throw new IllegalStateException(sb2.toString());
    }
    
    private String quotedAV() {
        ++this.pos;
        this.beg = this.pos;
        this.end = this.beg;
        while (true) {
            final int pos = this.pos;
            if (pos == this.length) {
                final StringBuilder sb = new StringBuilder();
                sb.append("Unexpected end of DN: ");
                sb.append(this.dn);
                throw new IllegalStateException(sb.toString());
            }
            final char[] chars = this.chars;
            if (chars[pos] == '\"') {
                this.pos = pos + 1;
                while (true) {
                    final int pos2 = this.pos;
                    if (pos2 >= this.length || this.chars[pos2] != ' ') {
                        break;
                    }
                    this.pos = pos2 + 1;
                }
                final char[] chars2 = this.chars;
                final int beg = this.beg;
                return new String(chars2, beg, this.end - beg);
            }
            if (chars[pos] == '\\') {
                chars[this.end] = this.getEscaped();
            }
            else {
                chars[this.end] = chars[pos];
            }
            ++this.pos;
            ++this.end;
        }
    }
    
    public String findMostSpecific(final String s) {
        this.pos = 0;
        this.beg = 0;
        this.end = 0;
        this.cur = 0;
        this.chars = this.dn.toCharArray();
        String s2 = this.nextAT();
        if (s2 == null) {
            return null;
        }
        while (true) {
            String s3 = "";
            final int pos = this.pos;
            if (pos == this.length) {
                return null;
            }
            switch (this.chars[pos]) {
                default: {
                    s3 = this.escapedAV();
                    break;
                }
                case '+':
                case ',':
                case ';': {
                    break;
                }
                case '#': {
                    s3 = this.hexAV();
                    break;
                }
                case '\"': {
                    s3 = this.quotedAV();
                    break;
                }
            }
            if (s.equalsIgnoreCase(s2)) {
                return s3;
            }
            final int pos2 = this.pos;
            if (pos2 >= this.length) {
                return null;
            }
            final char[] chars = this.chars;
            if (chars[pos2] != ',') {
                if (chars[pos2] != ';') {
                    if (chars[pos2] != '+') {
                        final StringBuilder sb = new StringBuilder();
                        sb.append("Malformed DN: ");
                        sb.append(this.dn);
                        throw new IllegalStateException(sb.toString());
                    }
                }
            }
            ++this.pos;
            s2 = this.nextAT();
            if (s2 != null) {
                continue;
            }
            final StringBuilder sb2 = new StringBuilder();
            sb2.append("Malformed DN: ");
            sb2.append(this.dn);
            throw new IllegalStateException(sb2.toString());
        }
    }
}
