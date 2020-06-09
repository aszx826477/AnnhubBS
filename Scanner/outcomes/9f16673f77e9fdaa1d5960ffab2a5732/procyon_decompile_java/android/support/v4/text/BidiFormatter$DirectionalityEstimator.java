// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.text;

class BidiFormatter$DirectionalityEstimator
{
    private static final byte[] DIR_TYPE_CACHE;
    private static final int DIR_TYPE_CACHE_SIZE = 1792;
    private int charIndex;
    private final boolean isHtml;
    private char lastChar;
    private final int length;
    private final CharSequence text;
    
    static {
        final int n = 1792;
        DIR_TYPE_CACHE = new byte[n];
        for (int i = 0; i < n; ++i) {
            BidiFormatter$DirectionalityEstimator.DIR_TYPE_CACHE[i] = Character.getDirectionality(i);
        }
    }
    
    BidiFormatter$DirectionalityEstimator(final CharSequence text, final boolean isHtml) {
        this.text = text;
        this.isHtml = isHtml;
        this.length = text.length();
    }
    
    private static byte getCachedDirectionality(final char c) {
        byte directionality;
        if (c < '\u0700') {
            directionality = BidiFormatter$DirectionalityEstimator.DIR_TYPE_CACHE[c];
        }
        else {
            directionality = Character.getDirectionality(c);
        }
        return directionality;
    }
    
    private byte skipEntityBackward() {
        final int charIndex = this.charIndex;
        char lastChar;
        char lastChar2;
        do {
            final int charIndex2 = this.charIndex;
            lastChar = ';';
            if (charIndex2 <= 0) {
                break;
            }
            final CharSequence text = this.text;
            final int charIndex3 = charIndex2 - 1;
            this.charIndex = charIndex3;
            this.lastChar = text.charAt(charIndex3);
            lastChar2 = this.lastChar;
            if (lastChar2 == '&') {
                return 12;
            }
        } while (lastChar2 != lastChar);
        this.charIndex = charIndex;
        this.lastChar = lastChar;
        return 13;
    }
    
    private byte skipEntityForward() {
        int charIndex;
        CharSequence text;
        do {
            charIndex = this.charIndex;
            if (charIndex >= this.length) {
                break;
            }
            text = this.text;
            this.charIndex = charIndex + 1;
        } while ((this.lastChar = text.charAt(charIndex)) != ';');
        return 12;
    }
    
    private byte skipTagBackward() {
        final int charIndex = this.charIndex;
        char lastChar;
        while (true) {
            final int charIndex2 = this.charIndex;
            lastChar = '>';
            if (charIndex2 <= 0) {
                break;
            }
            final CharSequence text = this.text;
            final int charIndex3 = charIndex2 - 1;
            this.charIndex = charIndex3;
            this.lastChar = text.charAt(charIndex3);
            final char lastChar2 = this.lastChar;
            if (lastChar2 == '<') {
                return 12;
            }
            if (lastChar2 == lastChar) {
                break;
            }
            if (lastChar2 != '\"' && lastChar2 != '\'') {
                continue;
            }
            final char lastChar3 = this.lastChar;
            CharSequence text2;
            int charIndex5;
            do {
                final int charIndex4 = this.charIndex;
                if (charIndex4 <= 0) {
                    break;
                }
                text2 = this.text;
                charIndex5 = charIndex4 - 1;
                this.charIndex = charIndex5;
            } while ((this.lastChar = text2.charAt(charIndex5)) != lastChar3);
        }
        this.charIndex = charIndex;
        this.lastChar = lastChar;
        return 13;
    }
    
    private byte skipTagForward() {
        final int charIndex = this.charIndex;
        while (true) {
            final int charIndex2 = this.charIndex;
            if (charIndex2 >= this.length) {
                this.charIndex = charIndex;
                this.lastChar = '<';
                return 13;
            }
            final CharSequence text = this.text;
            this.charIndex = charIndex2 + 1;
            this.lastChar = text.charAt(charIndex2);
            final char lastChar = this.lastChar;
            if (lastChar == '>') {
                return 12;
            }
            if (lastChar != '\"' && lastChar != '\'') {
                continue;
            }
            final char lastChar2 = this.lastChar;
            int charIndex3;
            CharSequence text2;
            do {
                charIndex3 = this.charIndex;
                if (charIndex3 >= this.length) {
                    break;
                }
                text2 = this.text;
                this.charIndex = charIndex3 + 1;
            } while ((this.lastChar = text2.charAt(charIndex3)) != lastChar2);
        }
    }
    
    byte dirTypeBackward() {
        this.lastChar = this.text.charAt(this.charIndex - 1);
        if (Character.isLowSurrogate(this.lastChar)) {
            final int codePointBefore = Character.codePointBefore(this.text, this.charIndex);
            this.charIndex -= Character.charCount(codePointBefore);
            return Character.getDirectionality(codePointBefore);
        }
        --this.charIndex;
        byte b = getCachedDirectionality(this.lastChar);
        if (this.isHtml) {
            final char lastChar = this.lastChar;
            if (lastChar == '>') {
                b = this.skipTagBackward();
            }
            else if (lastChar == ';') {
                b = this.skipEntityBackward();
            }
        }
        return b;
    }
    
    byte dirTypeForward() {
        this.lastChar = this.text.charAt(this.charIndex);
        if (Character.isHighSurrogate(this.lastChar)) {
            final int codePoint = Character.codePointAt(this.text, this.charIndex);
            this.charIndex += Character.charCount(codePoint);
            return Character.getDirectionality(codePoint);
        }
        ++this.charIndex;
        byte b = getCachedDirectionality(this.lastChar);
        if (this.isHtml) {
            final char lastChar = this.lastChar;
            if (lastChar == '<') {
                b = this.skipTagForward();
            }
            else if (lastChar == '&') {
                b = this.skipEntityForward();
            }
        }
        return b;
    }
    
    int getEntryDir() {
        this.charIndex = 0;
        int n = 0;
        int n2 = 0;
        int n3 = 0;
        while (true) {
            final int charIndex = this.charIndex;
            final int length = this.length;
            final int n4 = -1;
            final boolean b = true;
            if (charIndex < length && n3 == 0) {
                final byte dirTypeForward = this.dirTypeForward();
                if (dirTypeForward == 9) {
                    continue;
                }
                switch (dirTypeForward) {
                    default: {
                        switch (dirTypeForward) {
                            default: {
                                n3 = n;
                                continue;
                            }
                            case 18: {
                                --n;
                                n2 = 0;
                                continue;
                            }
                            case 16:
                            case 17: {
                                ++n;
                                n2 = 1;
                                continue;
                            }
                            case 14:
                            case 15: {
                                ++n;
                                n2 = -1;
                                continue;
                            }
                        }
                        break;
                    }
                    case 1:
                    case 2: {
                        if (n == 0) {
                            return b ? 1 : 0;
                        }
                        n3 = n;
                        continue;
                    }
                    case 0: {
                        if (n == 0) {
                            return n4;
                        }
                        n3 = n;
                        continue;
                    }
                }
            }
            else {
                if (n3 == 0) {
                    return 0;
                }
                if (n2 != 0) {
                    return n2;
                }
                while (this.charIndex > 0) {
                    switch (this.dirTypeBackward()) {
                        default: {
                            continue;
                        }
                        case 18: {
                            ++n;
                            continue;
                        }
                        case 16:
                        case 17: {
                            if (n3 == n) {
                                return b ? 1 : 0;
                            }
                            --n;
                            continue;
                        }
                        case 14:
                        case 15: {
                            if (n3 == n) {
                                return n4;
                            }
                            --n;
                            continue;
                        }
                    }
                }
                return 0;
            }
        }
    }
    
    int getExitDir() {
        this.charIndex = this.length;
        int n = 0;
        int n2 = 0;
        while (this.charIndex > 0) {
            final byte dirTypeBackward = this.dirTypeBackward();
            if (dirTypeBackward != 9) {
                final boolean b = true;
                final int n3 = -1;
                switch (dirTypeBackward) {
                    default: {
                        switch (dirTypeBackward) {
                            default: {
                                if (n2 == 0) {
                                    n2 = n;
                                    continue;
                                }
                                continue;
                            }
                            case 18: {
                                ++n;
                                continue;
                            }
                            case 16:
                            case 17: {
                                if (n2 == n) {
                                    return b ? 1 : 0;
                                }
                                --n;
                                continue;
                            }
                            case 14:
                            case 15: {
                                if (n2 == n) {
                                    return n3;
                                }
                                --n;
                                continue;
                            }
                        }
                        break;
                    }
                    case 1:
                    case 2: {
                        if (n == 0) {
                            return b ? 1 : 0;
                        }
                        if (n2 == 0) {
                            n2 = n;
                            continue;
                        }
                        continue;
                    }
                    case 0: {
                        if (n == 0) {
                            return n3;
                        }
                        if (n2 == 0) {
                            n2 = n;
                            continue;
                        }
                        continue;
                    }
                }
            }
        }
        return 0;
    }
}
