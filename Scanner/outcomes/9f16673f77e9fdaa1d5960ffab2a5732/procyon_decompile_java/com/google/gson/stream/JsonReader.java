// 
// Decompiled by Procyon v0.5.30
// 

package com.google.gson.stream;

import java.io.IOException;
import java.io.EOFException;
import com.google.gson.internal.JsonReaderInternalAccess;
import java.io.Reader;
import java.io.Closeable;

public class JsonReader implements Closeable
{
    private static final long MIN_INCOMPLETE_INTEGER = -922337203685477580L;
    private static final char[] NON_EXECUTE_PREFIX;
    private static final int NUMBER_CHAR_DECIMAL = 3;
    private static final int NUMBER_CHAR_DIGIT = 2;
    private static final int NUMBER_CHAR_EXP_DIGIT = 7;
    private static final int NUMBER_CHAR_EXP_E = 5;
    private static final int NUMBER_CHAR_EXP_SIGN = 6;
    private static final int NUMBER_CHAR_FRACTION_DIGIT = 4;
    private static final int NUMBER_CHAR_NONE = 0;
    private static final int NUMBER_CHAR_SIGN = 1;
    private static final int PEEKED_BEGIN_ARRAY = 3;
    private static final int PEEKED_BEGIN_OBJECT = 1;
    private static final int PEEKED_BUFFERED = 11;
    private static final int PEEKED_DOUBLE_QUOTED = 9;
    private static final int PEEKED_DOUBLE_QUOTED_NAME = 13;
    private static final int PEEKED_END_ARRAY = 4;
    private static final int PEEKED_END_OBJECT = 2;
    private static final int PEEKED_EOF = 17;
    private static final int PEEKED_FALSE = 6;
    private static final int PEEKED_LONG = 15;
    private static final int PEEKED_NONE = 0;
    private static final int PEEKED_NULL = 7;
    private static final int PEEKED_NUMBER = 16;
    private static final int PEEKED_SINGLE_QUOTED = 8;
    private static final int PEEKED_SINGLE_QUOTED_NAME = 12;
    private static final int PEEKED_TRUE = 5;
    private static final int PEEKED_UNQUOTED = 10;
    private static final int PEEKED_UNQUOTED_NAME = 14;
    private final char[] buffer;
    private final Reader in;
    private boolean lenient;
    private int limit;
    private int lineNumber;
    private int lineStart;
    private int[] pathIndices;
    private String[] pathNames;
    int peeked;
    private long peekedLong;
    private int peekedNumberLength;
    private String peekedString;
    private int pos;
    private int[] stack;
    private int stackSize;
    
    static {
        NON_EXECUTE_PREFIX = ")]}'\n".toCharArray();
        JsonReaderInternalAccess.INSTANCE = new JsonReader$1();
    }
    
    public JsonReader(final Reader in) {
        this.lenient = false;
        this.buffer = new char[1024];
        this.pos = 0;
        this.limit = 0;
        this.lineNumber = 0;
        this.lineStart = 0;
        this.peeked = 0;
        final int n = 32;
        this.stack = new int[n];
        this.stackSize = 0;
        this.stack[this.stackSize++] = 6;
        this.pathNames = new String[n];
        this.pathIndices = new int[n];
        if (in != null) {
            this.in = in;
            return;
        }
        throw new NullPointerException("in == null");
    }
    
    private void checkLenient() {
        if (this.lenient) {
            return;
        }
        throw this.syntaxError("Use JsonReader.setLenient(true) to accept malformed JSON");
    }
    
    private void consumeNonExecutePrefix() {
        final int n = 1;
        this.nextNonWhitespace(n != 0);
        this.pos -= n;
        final int pos = this.pos;
        final char[] non_EXECUTE_PREFIX = JsonReader.NON_EXECUTE_PREFIX;
        if (pos + non_EXECUTE_PREFIX.length > this.limit && !this.fillBuffer(non_EXECUTE_PREFIX.length)) {
            return;
        }
        int n2 = 0;
        while (true) {
            final char[] non_EXECUTE_PREFIX2 = JsonReader.NON_EXECUTE_PREFIX;
            if (n2 >= non_EXECUTE_PREFIX2.length) {
                this.pos += non_EXECUTE_PREFIX2.length;
                return;
            }
            if (this.buffer[this.pos + n2] != non_EXECUTE_PREFIX2[n2]) {
                return;
            }
            ++n2;
        }
    }
    
    private boolean fillBuffer(int n) {
        final char[] buffer = this.buffer;
        final int lineStart = this.lineStart;
        final int pos = this.pos;
        this.lineStart = lineStart - pos;
        final int limit = this.limit;
        if (limit != pos) {
            System.arraycopy(buffer, pos, buffer, 0, this.limit = limit - pos);
        }
        else {
            this.limit = 0;
        }
        this.pos = 0;
        while (true) {
            final Reader in = this.in;
            final int limit2 = this.limit;
            final int read;
            if ((read = in.read(buffer, limit2, buffer.length - limit2)) == -1) {
                return false;
            }
            this.limit += read;
            final int lineNumber = this.lineNumber;
            final int n2 = 1;
            if (lineNumber == 0) {
                final int lineStart2 = this.lineStart;
                if (lineStart2 == 0 && this.limit > 0 && buffer[0] == '\ufeff') {
                    this.pos += n2;
                    this.lineStart = lineStart2 + 1;
                    ++n;
                }
            }
            if (this.limit >= n) {
                return n2 != 0;
            }
        }
    }
    
    private boolean isLiteral(final char c) {
        switch (c) {
            default: {
                return true;
            }
            case '#':
            case '/':
            case ';':
            case '=':
            case '\\': {
                this.checkLenient();
            }
            case '\t':
            case '\n':
            case '\f':
            case '\r':
            case ' ':
            case ',':
            case ':':
            case '[':
            case ']':
            case '{':
            case '}': {
                return false;
            }
        }
    }
    
    private String locationString() {
        final int n = this.lineNumber + 1;
        final int n2 = this.pos - this.lineStart + 1;
        final StringBuilder sb = new StringBuilder();
        sb.append(" at line ");
        sb.append(n);
        sb.append(" column ");
        sb.append(n2);
        sb.append(" path ");
        sb.append(this.getPath());
        return sb.toString();
    }
    
    private int nextNonWhitespace(final boolean b) {
        final char[] buffer = this.buffer;
        int pos = this.pos;
        int n = this.limit;
        while (true) {
            final int n2 = 1;
            if (pos == n) {
                this.pos = pos;
                if (!this.fillBuffer(n2)) {
                    if (!b) {
                        return -1;
                    }
                    final StringBuilder sb = new StringBuilder();
                    sb.append("End of input");
                    sb.append(this.locationString());
                    throw new EOFException(sb.toString());
                }
                else {
                    pos = this.pos;
                    n = this.limit;
                }
            }
            final int n3 = pos + 1;
            final char c = buffer[pos];
            if (c == '\n') {
                this.lineNumber += n2;
                this.lineStart = n3;
            }
            else if (c != ' ' && c != '\r') {
                if (c != '\t') {
                    final char c2 = '/';
                    if (c == c2) {
                        this.pos = n3;
                        final int n4 = 2;
                        if (n3 == n) {
                            this.pos -= n2;
                            final boolean fillBuffer = this.fillBuffer(n4);
                            this.pos += n2;
                            if (!fillBuffer) {
                                return c;
                            }
                        }
                        this.checkLenient();
                        final int pos2 = this.pos;
                        final char c3 = buffer[pos2];
                        if (c3 != '*') {
                            if (c3 != c2) {
                                return c;
                            }
                            this.pos = pos2 + 1;
                            this.skipToEndOfLine();
                            final int pos3 = this.pos;
                            n = this.limit;
                            pos = pos3;
                            continue;
                        }
                        else {
                            this.pos = pos2 + 1;
                            if (this.skipTo("*/")) {
                                final int n5 = this.pos + n4;
                                n = this.limit;
                                pos = n5;
                                continue;
                            }
                            throw this.syntaxError("Unterminated comment");
                        }
                    }
                    else {
                        if (c == '#') {
                            this.pos = n3;
                            this.checkLenient();
                            this.skipToEndOfLine();
                            final int pos4 = this.pos;
                            n = this.limit;
                            pos = pos4;
                            continue;
                        }
                        this.pos = n3;
                        return c;
                    }
                }
            }
            pos = n3;
        }
    }
    
    private String nextQuotedValue(final char c) {
        final char[] buffer = this.buffer;
        final StringBuilder sb = new StringBuilder();
        while (true) {
            int pos = this.pos;
            int n = this.limit;
            int n2 = pos;
            while (true) {
                final int n3 = 1;
                if (pos < n) {
                    final int lineStart = pos + 1;
                    final char c2 = buffer[pos];
                    if (c2 == c) {
                        sb.append(buffer, n2, (this.pos = lineStart) - n2 - n3);
                        return sb.toString();
                    }
                    if (c2 == '\\') {
                        sb.append(buffer, n2, (this.pos = lineStart) - n2 - n3);
                        sb.append(this.readEscapeCharacter());
                        final int pos2 = this.pos;
                        n = this.limit;
                        n2 = pos2;
                        pos = pos2;
                    }
                    else {
                        if (c2 == '\n') {
                            this.lineNumber += n3;
                            this.lineStart = lineStart;
                        }
                        pos = lineStart;
                    }
                }
                else {
                    sb.append(buffer, n2, pos - n2);
                    this.pos = pos;
                    if (this.fillBuffer(n3)) {
                        break;
                    }
                    throw this.syntaxError("Unterminated string");
                }
            }
        }
    }
    
    private String nextUnquotedValue() {
        StringBuilder sb = null;
        int n = 0;
    Label_0194:
        while (true) {
            final int pos = this.pos;
            if (pos + n < this.limit) {
                switch (this.buffer[pos + n]) {
                    default: {
                        ++n;
                        continue;
                    }
                    case '#':
                    case '/':
                    case ';':
                    case '=':
                    case '\\': {
                        this.checkLenient();
                    }
                    case '\t':
                    case '\n':
                    case '\f':
                    case '\r':
                    case ' ':
                    case ',':
                    case ':':
                    case '[':
                    case ']':
                    case '{':
                    case '}': {
                        break Label_0194;
                    }
                }
            }
            else if (n < this.buffer.length) {
                if (this.fillBuffer(n + 1)) {
                    continue;
                }
                break;
            }
            else {
                if (sb == null) {
                    sb = new StringBuilder();
                }
                sb.append(this.buffer, this.pos, n);
                this.pos += n;
                n = 0;
                if (!this.fillBuffer(1)) {
                    break;
                }
                continue;
            }
        }
        String string;
        if (sb == null) {
            string = new String(this.buffer, this.pos, n);
        }
        else {
            sb.append(this.buffer, this.pos, n);
            string = sb.toString();
        }
        this.pos += n;
        return string;
    }
    
    private int peekKeyword() {
        final char c = this.buffer[this.pos];
        String s;
        String s2;
        int peeked;
        if (c != 't' && c != 'T') {
            if (c != 'f' && c != 'F') {
                if (c != 'n' && c != 'N') {
                    return 0;
                }
                s = "null";
                s2 = "NULL";
                peeked = 7;
            }
            else {
                s = "false";
                s2 = "FALSE";
                peeked = 6;
            }
        }
        else {
            s = "true";
            s2 = "TRUE";
            peeked = 5;
        }
        final int length = s.length();
        for (int i = 1; i < length; ++i) {
            if (this.pos + i >= this.limit && !this.fillBuffer(i + 1)) {
                return 0;
            }
            final char c2 = this.buffer[this.pos + i];
            if (c2 != s.charAt(i) && c2 != s2.charAt(i)) {
                return 0;
            }
        }
        if (this.pos + length < this.limit || this.fillBuffer(length + 1)) {
            if (this.isLiteral(this.buffer[this.pos + length])) {
                return 0;
            }
        }
        this.pos += length;
        return this.peeked = peeked;
    }
    
    private int peekNumber() {
        final char[] buffer = this.buffer;
        int n = this.pos;
        int n2 = this.limit;
        long n3 = 0L;
        int n4 = 0;
        boolean b = true;
        int n5 = 0;
        int peekedNumberLength = 0;
        int n7 = 0;
        int n8 = 0;
    Label_0412:
        while (true) {
            final int n6 = n + peekedNumberLength;
            n7 = 4;
            n8 = 2;
            if (n6 == n2) {
                if (peekedNumberLength == buffer.length) {
                    return 0;
                }
                if (!this.fillBuffer(peekedNumberLength + 1)) {
                    break;
                }
                n = this.pos;
                n2 = this.limit;
            }
            final char c = buffer[n + peekedNumberLength];
            final char c2 = '+';
            final int n9 = 5;
            if (c != c2) {
                if (c != 'E' && c != 'e') {
                    switch (c) {
                        default: {
                            if (c >= '0' && c <= '9') {
                                if (n5 || n5 == 0) {
                                    n3 = -(c - 48);
                                    n5 = 2;
                                    break;
                                }
                                if (n5 == n8) {
                                    if (n3 == 0L) {
                                        return 0;
                                    }
                                    final long n10 = 10 * n3 - (c - 48);
                                    final long n11 = -922337203685477580L;
                                    b &= (n3 > n11 || (n3 == n11 && n10 < n3));
                                    n3 = n10;
                                    break;
                                }
                                else {
                                    if (n5 == 3) {
                                        n5 = 4;
                                        break;
                                    }
                                    if (n5 != n9 && n5 != 6) {
                                        break;
                                    }
                                    n5 = 7;
                                    break;
                                }
                            }
                            else {
                                if (!this.isLiteral(c)) {
                                    break Label_0412;
                                }
                                return 0;
                            }
                            break;
                        }
                        case 46: {
                            if (n5 == n8) {
                                n5 = 3;
                                break;
                            }
                            return 0;
                        }
                        case 45: {
                            if (n5 == 0) {
                                n4 = 1;
                                n5 = (true ? 1 : 0);
                                break;
                            }
                            if (n5 == n9) {
                                n5 = 6;
                                break;
                            }
                            return 0;
                        }
                    }
                }
                else {
                    if (n5 != n8 && n5 != n7) {
                        return 0;
                    }
                    n5 = 5;
                }
            }
            else {
                if (n5 != n9) {
                    return 0;
                }
                n5 = 6;
            }
            ++peekedNumberLength;
        }
        if (n5 == n8 && b && (n3 != Long.MIN_VALUE || n4 != 0)) {
            long peekedLong;
            if (n4 != 0) {
                peekedLong = n3;
            }
            else {
                peekedLong = -n3;
            }
            this.peekedLong = peekedLong;
            this.pos += peekedNumberLength;
            return this.peeked = 15;
        }
        if (n5 != n8 && n5 != n7 && n5 != 7) {
            return 0;
        }
        this.peekedNumberLength = peekedNumberLength;
        return this.peeked = 16;
    }
    
    private void push(final int n) {
        final int stackSize = this.stackSize;
        final int[] stack = this.stack;
        if (stackSize == stack.length) {
            final int[] stack2 = new int[stackSize * 2];
            final int[] pathIndices = new int[stackSize * 2];
            final String[] pathNames = new String[stackSize * 2];
            System.arraycopy(stack, 0, stack2, 0, stackSize);
            System.arraycopy(this.pathIndices, 0, pathIndices, 0, this.stackSize);
            System.arraycopy(this.pathNames, 0, pathNames, 0, this.stackSize);
            this.stack = stack2;
            this.pathIndices = pathIndices;
            this.pathNames = pathNames;
        }
        this.stack[this.stackSize++] = n;
    }
    
    private char readEscapeCharacter() {
        final int pos = this.pos;
        final int limit = this.limit;
        final int n = 1;
        if (pos == limit && !this.fillBuffer(n)) {
            throw this.syntaxError("Unterminated escape sequence");
        }
        final char c = this.buffer[this.pos++];
        final char c2 = '\n';
        if (c != c2) {
            if (c != '\"' && c != '\'' && c != '/' && c != '\\') {
                if (c == 'b') {
                    return '\b';
                }
                final char c3 = 'f';
                if (c == c3) {
                    return '\f';
                }
                if (c == 'n') {
                    return c2;
                }
                if (c == 'r') {
                    return '\r';
                }
                switch (c) {
                    default: {
                        throw this.syntaxError("Invalid escape sequence");
                    }
                    case 'u': {
                        final int pos2 = this.pos;
                        final int n2 = 4;
                        if (pos2 + n2 > this.limit && !this.fillBuffer(n2)) {
                            throw this.syntaxError("Unterminated escape sequence");
                        }
                        char c4 = '\0';
                        for (int i = this.pos; i < i + 4; ++i) {
                            final char c5 = this.buffer[i];
                            final char c6 = (char)(c4 << 4);
                            if (c5 >= '0' && c5 <= '9') {
                                c4 = (char)(c5 - 48 + c6);
                            }
                            else if (c5 >= 'a' && c5 <= c3) {
                                c4 = (char)(c5 - 97 + c2 + c6);
                            }
                            else {
                                if (c5 < 'A' || c5 > 'F') {
                                    final StringBuilder sb = new StringBuilder();
                                    sb.append("\\u");
                                    sb.append(new String(this.buffer, this.pos, n2));
                                    throw new NumberFormatException(sb.toString());
                                }
                                c4 = (char)(c5 - 65 + c2 + c6);
                            }
                        }
                        this.pos += n2;
                        return c4;
                    }
                    case 't': {
                        return '\t';
                    }
                }
            }
        }
        else {
            this.lineNumber += n;
            this.lineStart = this.pos;
        }
        return c;
    }
    
    private void skipQuotedValue(final char c) {
        final char[] buffer = this.buffer;
        while (true) {
            int pos = this.pos;
            int n = this.limit;
            while (true) {
                final int n2 = 1;
                if (pos < n) {
                    final int lineStart = pos + 1;
                    final char c2 = buffer[pos];
                    if (c2 == c) {
                        this.pos = lineStart;
                        return;
                    }
                    if (c2 == '\\') {
                        this.pos = lineStart;
                        this.readEscapeCharacter();
                        final int pos2 = this.pos;
                        n = this.limit;
                        pos = pos2;
                    }
                    else {
                        if (c2 == '\n') {
                            this.lineNumber += n2;
                            this.lineStart = lineStart;
                        }
                        pos = lineStart;
                    }
                }
                else {
                    this.pos = pos;
                    if (this.fillBuffer(n2)) {
                        break;
                    }
                    throw this.syntaxError("Unterminated string");
                }
            }
        }
    }
    
    private boolean skipTo(final String s) {
        while (this.pos + s.length() <= this.limit || this.fillBuffer(s.length())) {
            final char[] buffer = this.buffer;
            final int pos = this.pos;
            final char c = buffer[pos];
            final char c2 = '\n';
            final int n = 1;
            Label_0146: {
                if (c != c2) {
                    for (int i = 0; i < s.length(); ++i) {
                        if (this.buffer[this.pos + i] != s.charAt(i)) {
                            break Label_0146;
                        }
                    }
                    return n != 0;
                }
                this.lineNumber += n;
                this.lineStart = pos + 1;
            }
            this.pos += n;
        }
        return false;
    }
    
    private void skipToEndOfLine() {
        char c;
        do {
            final int pos = this.pos;
            final int limit = this.limit;
            final int n = 1;
            if (pos >= limit && !this.fillBuffer(n)) {
                break;
            }
            c = this.buffer[this.pos++];
            if (c == '\n') {
                this.lineNumber += n;
                this.lineStart = this.pos;
                break;
            }
        } while (c != '\r');
    }
    
    private void skipUnquotedValue() {
        int n = 0;
    Label_0190:
        while (true) {
            n = 0;
            int pos;
            while (true) {
                pos = this.pos;
                if (pos + n >= this.limit) {
                    break;
                }
                switch (this.buffer[pos + n]) {
                    default: {
                        ++n;
                        continue;
                    }
                    case '#':
                    case '/':
                    case ';':
                    case '=':
                    case '\\': {
                        this.checkLenient();
                    }
                    case '\t':
                    case '\n':
                    case '\f':
                    case '\r':
                    case ' ':
                    case ',':
                    case ':':
                    case '[':
                    case ']':
                    case '{':
                    case '}': {
                        break Label_0190;
                    }
                }
            }
            this.pos = pos + n;
            if (!this.fillBuffer(1)) {
                return;
            }
        }
        this.pos += n;
    }
    
    private IOException syntaxError(final String s) {
        final StringBuilder sb = new StringBuilder();
        sb.append(s);
        sb.append(this.locationString());
        throw new MalformedJsonException(sb.toString());
    }
    
    public void beginArray() {
        int n = this.peeked;
        if (n == 0) {
            n = this.doPeek();
        }
        if (n == 3) {
            final int n2 = 1;
            this.push(n2);
            this.pathIndices[this.stackSize - n2] = 0;
            this.peeked = 0;
            return;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("Expected BEGIN_ARRAY but was ");
        sb.append(this.peek());
        sb.append(this.locationString());
        throw new IllegalStateException(sb.toString());
    }
    
    public void beginObject() {
        int n = this.peeked;
        if (n == 0) {
            n = this.doPeek();
        }
        if (n == 1) {
            this.push(3);
            this.peeked = 0;
            return;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("Expected BEGIN_OBJECT but was ");
        sb.append(this.peek());
        sb.append(this.locationString());
        throw new IllegalStateException(sb.toString());
    }
    
    public void close() {
        this.peeked = 0;
        this.stack[0] = 8;
        this.stackSize = 1;
        this.in.close();
    }
    
    int doPeek() {
        final int[] stack = this.stack;
        final int stackSize = this.stackSize;
        final int n = stack[stackSize - 1];
        final int peeked = 8;
        final int n2 = 39;
        final int n3 = 34;
        final int n4 = 93;
        final int peeked2 = 3;
        final int peeked3 = 7;
        final int n5 = 59;
        final int n6 = 44;
        final int n7 = 4;
        final int n8 = 2;
        final int peeked4 = 1;
        if (n == peeked4) {
            stack[stackSize - peeked4] = n8;
        }
        else if (n == n8) {
            final int nextNonWhitespace = this.nextNonWhitespace(peeked4 != 0);
            if (nextNonWhitespace != n6) {
                if (nextNonWhitespace != n5) {
                    if (nextNonWhitespace == n4) {
                        return this.peeked = n7;
                    }
                    throw this.syntaxError("Unterminated array");
                }
                else {
                    this.checkLenient();
                }
            }
        }
        else {
            final int n9 = 5;
            if (n != peeked2 && n != n9) {
                if (n == n7) {
                    stack[stackSize - peeked4] = n9;
                    final int nextNonWhitespace2 = this.nextNonWhitespace(peeked4 != 0);
                    if (nextNonWhitespace2 != 58) {
                        if (nextNonWhitespace2 != 61) {
                            throw this.syntaxError("Expected ':'");
                        }
                        this.checkLenient();
                        if (this.pos < this.limit || this.fillBuffer(peeked4)) {
                            final char[] buffer = this.buffer;
                            final int pos = this.pos;
                            if (buffer[pos] == '>') {
                                this.pos = pos + peeked4;
                            }
                        }
                    }
                }
                else if (n == 6) {
                    if (this.lenient) {
                        this.consumeNonExecutePrefix();
                    }
                    this.stack[this.stackSize - peeked4] = peeked3;
                }
                else if (n == peeked3) {
                    if (this.nextNonWhitespace(false) == -1) {
                        return this.peeked = 17;
                    }
                    this.checkLenient();
                    this.pos -= peeked4;
                }
                else if (n == peeked) {
                    throw new IllegalStateException("JsonReader is closed");
                }
            }
            else {
                this.stack[this.stackSize - peeked4] = n7;
                final int n10 = 125;
                if (n == n9) {
                    final int nextNonWhitespace3 = this.nextNonWhitespace(peeked4 != 0);
                    if (nextNonWhitespace3 != n6) {
                        if (nextNonWhitespace3 != n5) {
                            if (nextNonWhitespace3 == n10) {
                                return this.peeked = 2;
                            }
                            throw this.syntaxError("Unterminated object");
                        }
                        else {
                            this.checkLenient();
                        }
                    }
                }
                final int nextNonWhitespace4 = this.nextNonWhitespace(peeked4 != 0);
                if (nextNonWhitespace4 == n3) {
                    return this.peeked = 13;
                }
                if (nextNonWhitespace4 == n2) {
                    this.checkLenient();
                    return this.peeked = 12;
                }
                if (nextNonWhitespace4 != n10) {
                    this.checkLenient();
                    this.pos -= peeked4;
                    if (this.isLiteral((char)nextNonWhitespace4)) {
                        return this.peeked = 14;
                    }
                    throw this.syntaxError("Expected name");
                }
                else {
                    if (n != n9) {
                        return this.peeked = 2;
                    }
                    throw this.syntaxError("Expected name");
                }
            }
        }
        final int nextNonWhitespace5 = this.nextNonWhitespace(peeked4 != 0);
        if (nextNonWhitespace5 == n3) {
            return this.peeked = 9;
        }
        if (nextNonWhitespace5 == n2) {
            this.checkLenient();
            return this.peeked = peeked;
        }
        if (nextNonWhitespace5 != n6 && nextNonWhitespace5 != n5) {
            if (nextNonWhitespace5 == 91) {
                return this.peeked = peeked2;
            }
            if (nextNonWhitespace5 != n4) {
                if (nextNonWhitespace5 == 123) {
                    return this.peeked = peeked4;
                }
                this.pos -= peeked4;
                final int peekKeyword = this.peekKeyword();
                if (peekKeyword != 0) {
                    return peekKeyword;
                }
                final int peekNumber = this.peekNumber();
                if (peekNumber != 0) {
                    return peekNumber;
                }
                if (this.isLiteral(this.buffer[this.pos])) {
                    this.checkLenient();
                    return this.peeked = 10;
                }
                throw this.syntaxError("Expected value");
            }
            else if (n == peeked4) {
                return this.peeked = n7;
            }
        }
        if (n != peeked4 && n != 2) {
            throw this.syntaxError("Unexpected value");
        }
        this.checkLenient();
        this.pos -= peeked4;
        return this.peeked = peeked3;
    }
    
    public void endArray() {
        int n = this.peeked;
        if (n == 0) {
            n = this.doPeek();
        }
        if (n == 4) {
            --this.stackSize;
            final int[] pathIndices = this.pathIndices;
            final int n2 = this.stackSize - 1;
            ++pathIndices[n2];
            this.peeked = 0;
            return;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("Expected END_ARRAY but was ");
        sb.append(this.peek());
        sb.append(this.locationString());
        throw new IllegalStateException(sb.toString());
    }
    
    public void endObject() {
        int n = this.peeked;
        if (n == 0) {
            n = this.doPeek();
        }
        if (n == 2) {
            --this.stackSize;
            final String[] pathNames = this.pathNames;
            final int stackSize = this.stackSize;
            pathNames[stackSize] = null;
            final int[] pathIndices = this.pathIndices;
            final int n2 = stackSize - 1;
            ++pathIndices[n2];
            this.peeked = 0;
            return;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("Expected END_OBJECT but was ");
        sb.append(this.peek());
        sb.append(this.locationString());
        throw new IllegalStateException(sb.toString());
    }
    
    public String getPath() {
        final StringBuilder append = new StringBuilder().append('$');
        for (int i = 0; i < this.stackSize; ++i) {
            switch (this.stack[i]) {
                case 3:
                case 4:
                case 5: {
                    append.append('.');
                    final String[] pathNames = this.pathNames;
                    if (pathNames[i] != null) {
                        append.append(pathNames[i]);
                        break;
                    }
                    break;
                }
                case 1:
                case 2: {
                    append.append('[');
                    append.append(this.pathIndices[i]);
                    append.append(']');
                    break;
                }
            }
        }
        return append.toString();
    }
    
    public boolean hasNext() {
        int n = this.peeked;
        if (n == 0) {
            n = this.doPeek();
        }
        return n != 2 && n != 4;
    }
    
    public final boolean isLenient() {
        return this.lenient;
    }
    
    public boolean nextBoolean() {
        int n = this.peeked;
        if (n == 0) {
            n = this.doPeek();
        }
        final int n2 = 5;
        final int n3 = 1;
        if (n == n2) {
            this.peeked = 0;
            final int[] pathIndices = this.pathIndices;
            final int n4 = this.stackSize - n3;
            pathIndices[n4] += n3;
            return n3 != 0;
        }
        if (n == 6) {
            this.peeked = 0;
            final int[] pathIndices2 = this.pathIndices;
            final int n5 = this.stackSize - n3;
            pathIndices2[n5] += n3;
            return false;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("Expected a boolean but was ");
        sb.append(this.peek());
        sb.append(this.locationString());
        throw new IllegalStateException(sb.toString());
    }
    
    public double nextDouble() {
        int n = this.peeked;
        if (n == 0) {
            n = this.doPeek();
        }
        if (n == 15) {
            this.peeked = 0;
            final int[] pathIndices = this.pathIndices;
            final int n2 = this.stackSize - 1;
            ++pathIndices[n2];
            return this.peekedLong;
        }
        final int n3 = 16;
        final int peeked = 11;
        if (n == n3) {
            this.peekedString = new String(this.buffer, this.pos, this.peekedNumberLength);
            this.pos += this.peekedNumberLength;
        }
        else {
            final int n4 = 8;
            if (n != n4 && n != 9) {
                if (n == 10) {
                    this.peekedString = this.nextUnquotedValue();
                }
                else if (n != peeked) {
                    final StringBuilder sb = new StringBuilder();
                    sb.append("Expected a double but was ");
                    sb.append(this.peek());
                    sb.append(this.locationString());
                    throw new IllegalStateException(sb.toString());
                }
            }
            else {
                char c;
                if (n == n4) {
                    c = '\'';
                }
                else {
                    c = '\"';
                }
                this.peekedString = this.nextQuotedValue(c);
            }
        }
        this.peeked = peeked;
        final double double1 = Double.parseDouble(this.peekedString);
        if (!this.lenient && (Double.isNaN(double1) || Double.isInfinite(double1))) {
            final StringBuilder sb2 = new StringBuilder();
            sb2.append("JSON forbids NaN and infinities: ");
            sb2.append(double1);
            sb2.append(this.locationString());
            throw new MalformedJsonException(sb2.toString());
        }
        this.peekedString = null;
        this.peeked = 0;
        final int[] pathIndices2 = this.pathIndices;
        final int n5 = this.stackSize - 1;
        ++pathIndices2[n5];
        return double1;
    }
    
    public int nextInt() {
        int n = this.peeked;
        if (n == 0) {
            n = this.doPeek();
        }
        if (n == 15) {
            final long peekedLong = this.peekedLong;
            final int n2 = (int)peekedLong;
            if (peekedLong == n2) {
                this.peeked = 0;
                final int[] pathIndices = this.pathIndices;
                final int n3 = this.stackSize - 1;
                ++pathIndices[n3];
                return n2;
            }
            final StringBuilder sb = new StringBuilder();
            sb.append("Expected an int but was ");
            sb.append(this.peekedLong);
            sb.append(this.locationString());
            throw new NumberFormatException(sb.toString());
        }
        else {
            if (n == 16) {
                this.peekedString = new String(this.buffer, this.pos, this.peekedNumberLength);
                this.pos += this.peekedNumberLength;
            }
            else {
                final int n4 = 10;
                final int n5 = 8;
                if (n != n5 && n != 9 && n != n4) {
                    final StringBuilder sb2 = new StringBuilder();
                    sb2.append("Expected an int but was ");
                    sb2.append(this.peek());
                    sb2.append(this.locationString());
                    throw new IllegalStateException(sb2.toString());
                }
                if (n == n4) {
                    this.peekedString = this.nextUnquotedValue();
                }
                else {
                    char c;
                    if (n == n5) {
                        c = '\'';
                    }
                    else {
                        c = '\"';
                    }
                    this.peekedString = this.nextQuotedValue(c);
                }
                try {
                    final String peekedString = this.peekedString;
                    try {
                        final int int1 = Integer.parseInt(peekedString);
                        this.peeked = 0;
                        final int[] pathIndices2 = this.pathIndices;
                        try {
                            final int n6 = this.stackSize - 1;
                            ++pathIndices2[n6];
                            return int1;
                        }
                        catch (NumberFormatException ex) {}
                    }
                    catch (NumberFormatException ex2) {}
                }
                catch (NumberFormatException ex3) {}
            }
            this.peeked = 11;
            final double double1 = Double.parseDouble(this.peekedString);
            final int n7 = (int)double1;
            if (n7 == double1) {
                this.peekedString = null;
                this.peeked = 0;
                final int[] pathIndices3 = this.pathIndices;
                final int n8 = this.stackSize - 1;
                ++pathIndices3[n8];
                return n7;
            }
            final StringBuilder sb3 = new StringBuilder();
            sb3.append("Expected an int but was ");
            sb3.append(this.peekedString);
            sb3.append(this.locationString());
            throw new NumberFormatException(sb3.toString());
        }
    }
    
    public long nextLong() {
        int n = this.peeked;
        if (n == 0) {
            n = this.doPeek();
        }
        if (n == 15) {
            this.peeked = 0;
            final int[] pathIndices = this.pathIndices;
            final int n2 = this.stackSize - 1;
            ++pathIndices[n2];
            return this.peekedLong;
        }
        if (n == 16) {
            this.peekedString = new String(this.buffer, this.pos, this.peekedNumberLength);
            this.pos += this.peekedNumberLength;
        }
        else {
            final int n3 = 10;
            final int n4 = 8;
            if (n != n4 && n != 9 && n != n3) {
                final StringBuilder sb = new StringBuilder();
                sb.append("Expected a long but was ");
                sb.append(this.peek());
                sb.append(this.locationString());
                throw new IllegalStateException(sb.toString());
            }
            if (n == n3) {
                this.peekedString = this.nextUnquotedValue();
            }
            else {
                char c;
                if (n == n4) {
                    c = '\'';
                }
                else {
                    c = '\"';
                }
                this.peekedString = this.nextQuotedValue(c);
            }
            try {
                final String peekedString = this.peekedString;
                try {
                    final long long1 = Long.parseLong(peekedString);
                    this.peeked = 0;
                    final int[] pathIndices2 = this.pathIndices;
                    try {
                        final int n5 = this.stackSize - 1;
                        ++pathIndices2[n5];
                        return long1;
                    }
                    catch (NumberFormatException ex) {}
                }
                catch (NumberFormatException ex2) {}
            }
            catch (NumberFormatException ex3) {}
        }
        this.peeked = 11;
        final double double1 = Double.parseDouble(this.peekedString);
        final long n6 = (long)double1;
        if (n6 == double1) {
            this.peekedString = null;
            this.peeked = 0;
            final int[] pathIndices3 = this.pathIndices;
            final int n7 = this.stackSize - 1;
            ++pathIndices3[n7];
            return n6;
        }
        final StringBuilder sb2 = new StringBuilder();
        sb2.append("Expected a long but was ");
        sb2.append(this.peekedString);
        sb2.append(this.locationString());
        throw new NumberFormatException(sb2.toString());
    }
    
    public String nextName() {
        int n = this.peeked;
        if (n == 0) {
            n = this.doPeek();
        }
        String s;
        if (n == 14) {
            s = this.nextUnquotedValue();
        }
        else if (n == 12) {
            s = this.nextQuotedValue('\'');
        }
        else {
            if (n != 13) {
                final StringBuilder sb = new StringBuilder();
                sb.append("Expected a name but was ");
                sb.append(this.peek());
                sb.append(this.locationString());
                throw new IllegalStateException(sb.toString());
            }
            s = this.nextQuotedValue('\"');
        }
        this.peeked = 0;
        return this.pathNames[this.stackSize - 1] = s;
    }
    
    public void nextNull() {
        int n = this.peeked;
        if (n == 0) {
            n = this.doPeek();
        }
        if (n == 7) {
            this.peeked = 0;
            final int[] pathIndices = this.pathIndices;
            final int n2 = this.stackSize - 1;
            ++pathIndices[n2];
            return;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("Expected null but was ");
        sb.append(this.peek());
        sb.append(this.locationString());
        throw new IllegalStateException(sb.toString());
    }
    
    public String nextString() {
        int n = this.peeked;
        if (n == 0) {
            n = this.doPeek();
        }
        String s;
        if (n == 10) {
            s = this.nextUnquotedValue();
        }
        else if (n == 8) {
            s = this.nextQuotedValue('\'');
        }
        else if (n == 9) {
            s = this.nextQuotedValue('\"');
        }
        else if (n == 11) {
            s = this.peekedString;
            this.peekedString = null;
        }
        else if (n == 15) {
            s = Long.toString(this.peekedLong);
        }
        else {
            if (n != 16) {
                final StringBuilder sb = new StringBuilder();
                sb.append("Expected a string but was ");
                sb.append(this.peek());
                sb.append(this.locationString());
                throw new IllegalStateException(sb.toString());
            }
            s = new String(this.buffer, this.pos, this.peekedNumberLength);
            this.pos += this.peekedNumberLength;
        }
        this.peeked = 0;
        final int[] pathIndices = this.pathIndices;
        final int n2 = this.stackSize - 1;
        ++pathIndices[n2];
        return s;
    }
    
    public JsonToken peek() {
        int n = this.peeked;
        if (n == 0) {
            n = this.doPeek();
        }
        switch (n) {
            default: {
                throw new AssertionError();
            }
            case 17: {
                return JsonToken.END_DOCUMENT;
            }
            case 15:
            case 16: {
                return JsonToken.NUMBER;
            }
            case 12:
            case 13:
            case 14: {
                return JsonToken.NAME;
            }
            case 8:
            case 9:
            case 10:
            case 11: {
                return JsonToken.STRING;
            }
            case 7: {
                return JsonToken.NULL;
            }
            case 5:
            case 6: {
                return JsonToken.BOOLEAN;
            }
            case 4: {
                return JsonToken.END_ARRAY;
            }
            case 3: {
                return JsonToken.BEGIN_ARRAY;
            }
            case 2: {
                return JsonToken.END_OBJECT;
            }
            case 1: {
                return JsonToken.BEGIN_OBJECT;
            }
        }
    }
    
    public final void setLenient(final boolean lenient) {
        this.lenient = lenient;
    }
    
    public void skipValue() {
        int n = 0;
        int n4;
        do {
            int n2 = this.peeked;
            if (n2 == 0) {
                n2 = this.doPeek();
            }
            final int n3 = 3;
            n4 = 1;
            if (n2 == n3) {
                this.push(n4);
                ++n;
            }
            else if (n2 == n4) {
                this.push(n3);
                ++n;
            }
            else if (n2 == 4) {
                this.stackSize -= n4;
                --n;
            }
            else if (n2 == 2) {
                this.stackSize -= n4;
                --n;
            }
            else if (n2 != 14 && n2 != 10) {
                if (n2 != 8 && n2 != 12) {
                    if (n2 != 9 && n2 != 13) {
                        if (n2 == 16) {
                            this.pos += this.peekedNumberLength;
                        }
                    }
                    else {
                        this.skipQuotedValue('\"');
                    }
                }
                else {
                    this.skipQuotedValue('\'');
                }
            }
            else {
                this.skipUnquotedValue();
            }
            this.peeked = 0;
        } while (n != 0);
        final int[] pathIndices = this.pathIndices;
        final int stackSize = this.stackSize;
        final int n5 = stackSize - 1;
        pathIndices[n5] += n4;
        this.pathNames[stackSize - n4] = "null";
    }
    
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(this.getClass().getSimpleName());
        sb.append(this.locationString());
        return sb.toString();
    }
}
