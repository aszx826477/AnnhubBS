// 
// Decompiled by Procyon v0.5.30
// 

package okhttp3.internal.framed;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.io.IOException;
import java.util.Map;
import okhttp3.internal.Util;
import java.util.List;
import okio.ByteString;
import java.util.Arrays;
import okio.Buffer;

final class Hpack$Writer
{
    private static final int SETTINGS_HEADER_TABLE_SIZE = 4096;
    private static final int SETTINGS_HEADER_TABLE_SIZE_LIMIT = 16384;
    Header[] dynamicTable;
    int dynamicTableByteCount;
    private boolean emitDynamicTableSizeUpdate;
    int headerCount;
    int headerTableSizeSetting;
    int maxDynamicTableByteCount;
    int nextHeaderIndex;
    private final Buffer out;
    private int smallestHeaderTableSizeSetting;
    
    Hpack$Writer(final int n, final Buffer out) {
        this.smallestHeaderTableSizeSetting = -1 >>> 1;
        this.dynamicTable = new Header[8];
        this.nextHeaderIndex = this.dynamicTable.length - 1;
        this.headerCount = 0;
        this.dynamicTableByteCount = 0;
        this.headerTableSizeSetting = n;
        this.maxDynamicTableByteCount = n;
        this.out = out;
    }
    
    Hpack$Writer(final Buffer buffer) {
        this(4096, buffer);
    }
    
    private void adjustDynamicTableByteCount() {
        final int maxDynamicTableByteCount = this.maxDynamicTableByteCount;
        final int dynamicTableByteCount = this.dynamicTableByteCount;
        if (maxDynamicTableByteCount < dynamicTableByteCount) {
            if (maxDynamicTableByteCount == 0) {
                this.clearDynamicTable();
            }
            else {
                this.evictToRecoverBytes(dynamicTableByteCount - maxDynamicTableByteCount);
            }
        }
    }
    
    private void clearDynamicTable() {
        Arrays.fill(this.dynamicTable, null);
        this.nextHeaderIndex = this.dynamicTable.length - 1;
        this.headerCount = 0;
        this.dynamicTableByteCount = 0;
    }
    
    private int evictToRecoverBytes(int n) {
        int n2 = 0;
        if (n > 0) {
            for (int n3 = this.dynamicTable.length - 1; n3 >= this.nextHeaderIndex && n > 0; n -= this.dynamicTable[n3].hpackSize, this.dynamicTableByteCount -= this.dynamicTable[n3].hpackSize, --this.headerCount, ++n2, --n3) {}
            final Header[] dynamicTable = this.dynamicTable;
            final int nextHeaderIndex = this.nextHeaderIndex;
            System.arraycopy(dynamicTable, nextHeaderIndex + 1, dynamicTable, nextHeaderIndex + 1 + n2, this.headerCount);
            final Header[] dynamicTable2 = this.dynamicTable;
            final int nextHeaderIndex2 = this.nextHeaderIndex;
            Arrays.fill(dynamicTable2, nextHeaderIndex2 + 1, nextHeaderIndex2 + 1 + n2, null);
            this.nextHeaderIndex += n2;
        }
        return n2;
    }
    
    private void insertIntoDynamicTable(final Header header) {
        final int hpackSize = header.hpackSize;
        final int maxDynamicTableByteCount = this.maxDynamicTableByteCount;
        if (hpackSize > maxDynamicTableByteCount) {
            this.clearDynamicTable();
            return;
        }
        this.evictToRecoverBytes(this.dynamicTableByteCount + hpackSize - maxDynamicTableByteCount);
        final int n = this.headerCount + 1;
        final Header[] dynamicTable = this.dynamicTable;
        if (n > dynamicTable.length) {
            final Header[] dynamicTable2 = new Header[dynamicTable.length * 2];
            System.arraycopy(dynamicTable, 0, dynamicTable2, dynamicTable.length, dynamicTable.length);
            this.nextHeaderIndex = this.dynamicTable.length - 1;
            this.dynamicTable = dynamicTable2;
        }
        this.dynamicTable[this.nextHeaderIndex--] = header;
        ++this.headerCount;
        this.dynamicTableByteCount += hpackSize;
    }
    
    void setHeaderTableSizeSetting(final int headerTableSizeSetting) {
        this.headerTableSizeSetting = headerTableSizeSetting;
        final int min = Math.min(headerTableSizeSetting, 16384);
        final int maxDynamicTableByteCount = this.maxDynamicTableByteCount;
        if (maxDynamicTableByteCount == min) {
            return;
        }
        if (min < maxDynamicTableByteCount) {
            this.smallestHeaderTableSizeSetting = Math.min(this.smallestHeaderTableSizeSetting, min);
        }
        this.emitDynamicTableSizeUpdate = true;
        this.maxDynamicTableByteCount = min;
        this.adjustDynamicTableByteCount();
    }
    
    void writeByteString(final ByteString byteString) {
        this.writeInt(byteString.size(), 127, 0);
        this.out.write(byteString);
    }
    
    void writeHeaders(final List list) {
        if (this.emitDynamicTableSizeUpdate) {
            final int smallestHeaderTableSizeSetting = this.smallestHeaderTableSizeSetting;
            final int maxDynamicTableByteCount = this.maxDynamicTableByteCount;
            final int n = 32;
            final int n2 = 31;
            if (smallestHeaderTableSizeSetting < maxDynamicTableByteCount) {
                this.writeInt(smallestHeaderTableSizeSetting, n2, n);
            }
            this.emitDynamicTableSizeUpdate = false;
            this.smallestHeaderTableSizeSetting = -1 >>> 1;
            this.writeInt(this.maxDynamicTableByteCount, n2, n);
        }
        for (int i = 0; i < list.size(); ++i) {
            final Header header = list.get(i);
            final ByteString asciiLowercase = header.name.toAsciiLowercase();
            final ByteString value = header.value;
            final Integer n3 = Hpack.NAME_TO_FIRST_INDEX.get(asciiLowercase);
            if (n3 != null) {
                this.writeInt(n3 + 1, 15, 0);
                this.writeByteString(value);
            }
            else {
                final int index = Util.indexOf(this.dynamicTable, header);
                if (index != -1) {
                    this.writeInt(index - this.nextHeaderIndex + Hpack.STATIC_HEADER_TABLE.length, 127, 128);
                }
                else {
                    this.out.writeByte(64);
                    this.writeByteString(asciiLowercase);
                    this.writeByteString(value);
                    this.insertIntoDynamicTable(header);
                }
            }
        }
    }
    
    void writeInt(int i, final int n, final int n2) {
        if (i < n) {
            this.out.writeByte(n2 | i);
            return;
        }
        this.out.writeByte(n2 | n);
        for (i -= n; i >= 128; i >>>= 7) {
            this.out.writeByte((i & 0x7F) | 0x80);
        }
        this.out.writeByte(i);
    }
}
