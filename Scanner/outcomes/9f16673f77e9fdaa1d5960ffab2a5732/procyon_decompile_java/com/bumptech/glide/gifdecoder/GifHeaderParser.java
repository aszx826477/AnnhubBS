// 
// Decompiled by Procyon v0.5.30
// 

package com.bumptech.glide.gifdecoder;

import java.nio.ByteOrder;
import java.util.Arrays;
import java.nio.BufferUnderflowException;
import android.util.Log;
import java.nio.ByteBuffer;

public class GifHeaderParser
{
    static final int DEFAULT_FRAME_DELAY = 10;
    private static final int MAX_BLOCK_SIZE = 256;
    static final int MIN_FRAME_DELAY = 3;
    public static final String TAG = "GifHeaderParser";
    private final byte[] block;
    private int blockSize;
    private GifHeader header;
    private ByteBuffer rawData;
    
    public GifHeaderParser() {
        this.block = new byte[256];
        this.blockSize = 0;
    }
    
    private boolean err() {
        return this.header.status != 0;
    }
    
    private int read() {
        int n = 0;
        try {
            final ByteBuffer rawData = this.rawData;
            try {
                n = (rawData.get() & 0xFF);
            }
            catch (Exception ex) {
                this.header.status = 1;
            }
        }
        catch (Exception ex2) {}
        return n;
    }
    
    private void readBitmap() {
        this.header.currentFrame.ix = this.readShort();
        this.header.currentFrame.iy = this.readShort();
        this.header.currentFrame.iw = this.readShort();
        this.header.currentFrame.ih = this.readShort();
        final int read = this.read();
        final int n = read & 0x80;
        boolean interlace = false;
        final int n2 = 1;
        final boolean b = n != 0;
        final int n3 = (int)Math.pow(2.0, (read & 0x7) + n2);
        final GifFrame currentFrame = this.header.currentFrame;
        if ((read & 0x40) != 0x0) {
            interlace = true;
        }
        currentFrame.interlace = interlace;
        if (b) {
            this.header.currentFrame.lct = this.readColorTable(n3);
        }
        else {
            this.header.currentFrame.lct = null;
        }
        this.header.currentFrame.bufferFrameStart = this.rawData.position();
        this.skipImageData();
        if (this.err()) {
            return;
        }
        final GifHeader header = this.header;
        header.frameCount += n2;
        this.header.frames.add(this.header.currentFrame);
    }
    
    private int readBlock() {
        this.blockSize = this.read();
        int n = 0;
        if (this.blockSize > 0) {
            int n2 = 0;
            try {
            Label_0071_Outer:
                while (true) {
                    while (true) {
                        if (n < this.blockSize) {
                            n2 = this.blockSize - n;
                            final ByteBuffer rawData = this.rawData;
                            try {
                                rawData.get(this.block, n, n2);
                                n += n2;
                                continue Label_0071_Outer;
                            }
                            catch (Exception ex) {
                                if (Log.isLoggable("GifHeaderParser", 3)) {
                                    final String s = "GifHeaderParser";
                                    final StringBuilder sb = new StringBuilder();
                                    sb.append("Error Reading Block n: ");
                                    sb.append(n);
                                    sb.append(" count: ");
                                    sb.append(n2);
                                    sb.append(" blockSize: ");
                                    sb.append(this.blockSize);
                                    Log.d(s, sb.toString(), (Throwable)ex);
                                }
                                this.header.status = 1;
                            }
                            break;
                        }
                        continue;
                    }
                }
            }
            catch (Exception ex2) {}
        }
        return n;
    }
    
    private int[] readColorTable(final int n) {
        final int n2 = n * 3;
        int[] array = null;
        final byte[] array2 = new byte[n2];
        try {
            this.rawData.get(array2);
            array = new int[256];
            int i = 0;
            int n3 = 0;
            while (i < n) {
                final int n4 = n3 + 1;
                final int n5 = array2[n3] & 0xFF;
                final int n6 = n4 + 1;
                final int n7 = array2[n4] & 0xFF;
                final int n8 = n6 + 1;
                final int n9 = array2[n6] & 0xFF;
                final int n10 = i + 1;
                array[i] = (0xFF000000 | n5 << 16 | n7 << 8 | n9);
                n3 = n8;
                i = n10;
            }
        }
        catch (BufferUnderflowException ex) {
            if (Log.isLoggable("GifHeaderParser", 3)) {
                Log.d("GifHeaderParser", "Format Error Reading Color Table", (Throwable)ex);
            }
            this.header.status = 1;
        }
        return array;
    }
    
    private void readContents() {
        int n = 0;
        while (n == 0 && !this.err()) {
            final int read = this.read();
            final int n2 = 33;
            final boolean status = true;
            if (read != n2) {
                if (read != 44) {
                    if (read != 59) {
                        this.header.status = (status ? 1 : 0);
                    }
                    else {
                        n = 1;
                    }
                }
                else {
                    if (this.header.currentFrame == null) {
                        this.header.currentFrame = new GifFrame();
                    }
                    this.readBitmap();
                }
            }
            else {
                final int read2 = this.read();
                if (read2 != (status ? 1 : 0)) {
                    if (read2 != 249) {
                        switch (read2) {
                            default: {
                                this.skip();
                                continue;
                            }
                            case 255: {
                                this.readBlock();
                                String string = "";
                                for (int i = 0; i < 11; ++i) {
                                    final StringBuilder sb = new StringBuilder();
                                    sb.append(string);
                                    sb.append((char)this.block[i]);
                                    string = sb.toString();
                                }
                                if (string.equals("NETSCAPE2.0")) {
                                    this.readNetscapeExt();
                                    continue;
                                }
                                this.skip();
                                continue;
                            }
                            case 254: {
                                this.skip();
                                continue;
                            }
                        }
                    }
                    else {
                        this.header.currentFrame = new GifFrame();
                        this.readGraphicControlExt();
                    }
                }
                else {
                    this.skip();
                }
            }
        }
    }
    
    private void readGraphicControlExt() {
        this.read();
        final int read = this.read();
        this.header.currentFrame.dispose = (read & 0x1C) >> 2;
        final int dispose = this.header.currentFrame.dispose;
        boolean b = true;
        if (dispose == 0) {
            this.header.currentFrame.dispose = (b ? 1 : 0);
        }
        final GifFrame currentFrame = this.header.currentFrame;
        if ((read & 0x1) == 0x0) {
            b = false;
        }
        currentFrame.transparency = b;
        int short1 = this.readShort();
        if (short1 < 3) {
            short1 = 10;
        }
        this.header.currentFrame.delay = short1 * 10;
        this.header.currentFrame.transIndex = this.read();
        this.read();
    }
    
    private void readHeader() {
        String string = "";
        for (int i = 0; i < 6; ++i) {
            final StringBuilder sb = new StringBuilder();
            sb.append(string);
            sb.append((char)this.read());
            string = sb.toString();
        }
        if (!string.startsWith("GIF")) {
            this.header.status = 1;
            return;
        }
        this.readLSD();
        if (this.header.gctFlag && !this.err()) {
            final GifHeader header = this.header;
            header.gct = this.readColorTable(header.gctSize);
            final GifHeader header2 = this.header;
            header2.bgColor = header2.gct[this.header.bgIndex];
        }
    }
    
    private void readLSD() {
        this.header.width = this.readShort();
        this.header.height = this.readShort();
        final int read = this.read();
        this.header.gctFlag = ((read & 0x80) != 0x0);
        final GifHeader header = this.header;
        header.gctSize = 2 << (read & 0x7);
        header.bgIndex = this.read();
        this.header.pixelAspect = this.read();
    }
    
    private void readNetscapeExt() {
        do {
            this.readBlock();
            final byte[] block = this.block;
            final byte b = block[0];
            final byte b2 = 1;
            if (b == b2) {
                this.header.loopCount = ((block[2] & 0xFF) << 8 | (block[b2] & 0xFF));
            }
        } while (this.blockSize > 0 && !this.err());
    }
    
    private int readShort() {
        return this.rawData.getShort();
    }
    
    private void reset() {
        this.rawData = null;
        Arrays.fill(this.block, (byte)0);
        this.header = new GifHeader();
        this.blockSize = 0;
    }
    
    private void skip() {
        int read;
        do {
            read = this.read();
            final ByteBuffer rawData = this.rawData;
            rawData.position(rawData.position() + read);
        } while (read > 0);
    }
    
    private void skipImageData() {
        this.read();
        this.skip();
    }
    
    public void clear() {
        this.rawData = null;
        this.header = null;
    }
    
    public GifHeader parseHeader() {
        if (this.rawData == null) {
            throw new IllegalStateException("You must call setData() before parseHeader()");
        }
        if (this.err()) {
            return this.header;
        }
        this.readHeader();
        if (!this.err()) {
            this.readContents();
            if (this.header.frameCount < 0) {
                this.header.status = 1;
            }
        }
        return this.header;
    }
    
    public GifHeaderParser setData(final byte[] array) {
        this.reset();
        if (array != null) {
            (this.rawData = ByteBuffer.wrap(array)).rewind();
            this.rawData.order(ByteOrder.LITTLE_ENDIAN);
        }
        else {
            this.rawData = null;
            this.header.status = 2;
        }
        return this;
    }
}
