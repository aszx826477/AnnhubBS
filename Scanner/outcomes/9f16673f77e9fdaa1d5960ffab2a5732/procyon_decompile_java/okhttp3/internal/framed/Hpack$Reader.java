// 
// Decompiled by Procyon v0.5.30
// 

package okhttp3.internal.framed;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Collection;
import java.io.IOException;
import okio.ByteString;
import java.util.Arrays;
import okio.Okio;
import java.util.ArrayList;
import okio.Source;
import okio.BufferedSource;
import java.util.List;

final class Hpack$Reader
{
    Header[] dynamicTable;
    int dynamicTableByteCount;
    int headerCount;
    private final List headerList;
    private final int headerTableSizeSetting;
    private int maxDynamicTableByteCount;
    int nextHeaderIndex;
    private final BufferedSource source;
    
    Hpack$Reader(final int headerTableSizeSetting, final int maxDynamicTableByteCount, final Source source) {
        this.headerList = new ArrayList();
        this.dynamicTable = new Header[8];
        this.nextHeaderIndex = this.dynamicTable.length - 1;
        this.headerCount = 0;
        this.dynamicTableByteCount = 0;
        this.headerTableSizeSetting = headerTableSizeSetting;
        this.maxDynamicTableByteCount = maxDynamicTableByteCount;
        this.source = Okio.buffer(source);
    }
    
    Hpack$Reader(final int n, final Source source) {
        this(n, n, source);
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
        this.headerList.clear();
        Arrays.fill(this.dynamicTable, null);
        this.nextHeaderIndex = this.dynamicTable.length - 1;
        this.headerCount = 0;
        this.dynamicTableByteCount = 0;
    }
    
    private int dynamicTableIndex(final int n) {
        return this.nextHeaderIndex + 1 + n;
    }
    
    private int evictToRecoverBytes(int n) {
        int n2 = 0;
        if (n > 0) {
            for (int n3 = this.dynamicTable.length - 1; n3 >= this.nextHeaderIndex && n > 0; n -= this.dynamicTable[n3].hpackSize, this.dynamicTableByteCount -= this.dynamicTable[n3].hpackSize, --this.headerCount, ++n2, --n3) {}
            final Header[] dynamicTable = this.dynamicTable;
            final int nextHeaderIndex = this.nextHeaderIndex;
            System.arraycopy(dynamicTable, nextHeaderIndex + 1, dynamicTable, nextHeaderIndex + 1 + n2, this.headerCount);
            this.nextHeaderIndex += n2;
        }
        return n2;
    }
    
    private ByteString getName(final int n) {
        if (this.isStaticHeader(n)) {
            return Hpack.STATIC_HEADER_TABLE[n].name;
        }
        return this.dynamicTable[this.dynamicTableIndex(n - Hpack.STATIC_HEADER_TABLE.length)].name;
    }
    
    private void insertIntoDynamicTable(int n, final Header header) {
        this.headerList.add(header);
        int hpackSize = header.hpackSize;
        final int n2 = -1;
        if (n != n2) {
            hpackSize -= this.dynamicTable[this.dynamicTableIndex(n)].hpackSize;
        }
        final int maxDynamicTableByteCount = this.maxDynamicTableByteCount;
        if (hpackSize > maxDynamicTableByteCount) {
            this.clearDynamicTable();
            return;
        }
        final int evictToRecoverBytes = this.evictToRecoverBytes(this.dynamicTableByteCount + hpackSize - maxDynamicTableByteCount);
        if (n == n2) {
            final int n3 = this.headerCount + 1;
            final Header[] dynamicTable = this.dynamicTable;
            if (n3 > dynamicTable.length) {
                final Header[] dynamicTable2 = new Header[dynamicTable.length * 2];
                System.arraycopy(dynamicTable, 0, dynamicTable2, dynamicTable.length, dynamicTable.length);
                this.nextHeaderIndex = this.dynamicTable.length - 1;
                this.dynamicTable = dynamicTable2;
            }
            this.dynamicTable[n = this.nextHeaderIndex--] = header;
            ++this.headerCount;
        }
        else {
            n += this.dynamicTableIndex(n) + evictToRecoverBytes;
            this.dynamicTable[n] = header;
        }
        this.dynamicTableByteCount += hpackSize;
    }
    
    private boolean isStaticHeader(final int n) {
        int n2 = 1;
        if (n < 0 || n > Hpack.STATIC_HEADER_TABLE.length - n2) {
            n2 = 0;
        }
        return n2 != 0;
    }
    
    private int readByte() {
        return this.source.readByte() & 0xFF;
    }
    
    private void readIndexedHeader(final int n) {
        if (!this.isStaticHeader(n)) {
            final int dynamicTableIndex = this.dynamicTableIndex(n - Hpack.STATIC_HEADER_TABLE.length);
            if (dynamicTableIndex >= 0) {
                final Header[] dynamicTable = this.dynamicTable;
                if (dynamicTableIndex <= dynamicTable.length - 1) {
                    this.headerList.add(dynamicTable[dynamicTableIndex]);
                    return;
                }
            }
            final StringBuilder sb = new StringBuilder();
            sb.append("Header index too large ");
            sb.append(n + 1);
            throw new IOException(sb.toString());
        }
        this.headerList.add(Hpack.STATIC_HEADER_TABLE[n]);
    }
    
    private void readLiteralHeaderWithIncrementalIndexingIndexedName(final int n) {
        this.insertIntoDynamicTable(-1, new Header(this.getName(n), this.readByteString()));
    }
    
    private void readLiteralHeaderWithIncrementalIndexingNewName() {
        this.insertIntoDynamicTable(-1, new Header(checkLowercase(this.readByteString()), this.readByteString()));
    }
    
    private void readLiteralHeaderWithoutIndexingIndexedName(final int n) {
        this.headerList.add(new Header(this.getName(n), this.readByteString()));
    }
    
    private void readLiteralHeaderWithoutIndexingNewName() {
        this.headerList.add(new Header(checkLowercase(this.readByteString()), this.readByteString()));
    }
    
    public List getAndResetHeaderList() {
        final ArrayList list = new ArrayList(this.headerList);
        this.headerList.clear();
        return list;
    }
    
    int maxDynamicTableByteCount() {
        return this.maxDynamicTableByteCount;
    }
    
    ByteString readByteString() {
        final int byte1 = this.readByte();
        final boolean b = (byte1 & 0x80) == 0x80;
        final int int1 = this.readInt(byte1, 127);
        if (b) {
            return ByteString.of(Huffman.get().decode(this.source.readByteArray(int1)));
        }
        return this.source.readByteString(int1);
    }
    
    void readHeaders() {
        while (!this.source.exhausted()) {
            final int n = this.source.readByte() & 0xFF;
            final int n2 = 128;
            if (n == n2) {
                throw new IOException("index == 0");
            }
            if ((n & 0x80) == n2) {
                this.readIndexedHeader(this.readInt(n, 127) - 1);
            }
            else {
                final int n3 = 64;
                if (n == n3) {
                    this.readLiteralHeaderWithIncrementalIndexingNewName();
                }
                else if ((n & 0x40) == n3) {
                    this.readLiteralHeaderWithIncrementalIndexingIndexedName(this.readInt(n, 63) - 1);
                }
                else if ((n & 0x20) == 0x20) {
                    this.maxDynamicTableByteCount = this.readInt(n, 31);
                    final int maxDynamicTableByteCount = this.maxDynamicTableByteCount;
                    if (maxDynamicTableByteCount < 0 || maxDynamicTableByteCount > this.headerTableSizeSetting) {
                        final StringBuilder sb = new StringBuilder();
                        sb.append("Invalid dynamic table size update ");
                        sb.append(this.maxDynamicTableByteCount);
                        throw new IOException(sb.toString());
                    }
                    this.adjustDynamicTableByteCount();
                }
                else if (n != 16 && n != 0) {
                    this.readLiteralHeaderWithoutIndexingIndexedName(this.readInt(n, 15) - 1);
                }
                else {
                    this.readLiteralHeaderWithoutIndexingNewName();
                }
            }
        }
    }
    
    int readInt(final int n, final int n2) {
        final int n3 = n & n2;
        if (n3 < n2) {
            return n3;
        }
        int n4 = n2;
        int n5 = 0;
        int byte1;
        while (true) {
            byte1 = this.readByte();
            if ((byte1 & 0x80) == 0x0) {
                break;
            }
            n4 += (byte1 & 0x7F) << n5;
            n5 += 7;
        }
        return n4 + (byte1 << n5);
    }
}
