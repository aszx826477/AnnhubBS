// 
// Decompiled by Procyon v0.5.30
// 

package com.bumptech.glide.gifdecoder;

import java.util.Iterator;
import java.nio.ByteOrder;
import java.io.IOException;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.Arrays;
import android.os.Build$VERSION;
import android.util.Log;
import java.nio.ByteBuffer;
import android.graphics.Bitmap;
import android.graphics.Bitmap$Config;

public class GifDecoder
{
    private static final Bitmap$Config BITMAP_CONFIG;
    private static final int DISPOSAL_BACKGROUND = 2;
    private static final int DISPOSAL_NONE = 1;
    private static final int DISPOSAL_PREVIOUS = 3;
    private static final int DISPOSAL_UNSPECIFIED = 0;
    private static final int INITIAL_FRAME_POINTER = 255;
    private static final int MAX_STACK_SIZE = 4096;
    private static final int NULL_CODE = 255;
    public static final int STATUS_FORMAT_ERROR = 1;
    public static final int STATUS_OK = 0;
    public static final int STATUS_OPEN_ERROR = 2;
    public static final int STATUS_PARTIAL_DECODE = 3;
    private static final String TAG;
    private int[] act;
    private GifDecoder$BitmapProvider bitmapProvider;
    private final byte[] block;
    private byte[] data;
    private int framePointer;
    private GifHeader header;
    private byte[] mainPixels;
    private int[] mainScratch;
    private GifHeaderParser parser;
    private byte[] pixelStack;
    private short[] prefix;
    private Bitmap previousImage;
    private ByteBuffer rawData;
    private boolean savePrevious;
    private int status;
    private byte[] suffix;
    
    static {
        TAG = GifDecoder.class.getSimpleName();
        BITMAP_CONFIG = Bitmap$Config.ARGB_8888;
    }
    
    public GifDecoder(final GifDecoder$BitmapProvider bitmapProvider) {
        this.block = new byte[256];
        this.bitmapProvider = bitmapProvider;
        this.header = new GifHeader();
    }
    
    private void decodeBitmapData(final GifFrame gifFrame) {
        if (gifFrame != null) {
            this.rawData.position(gifFrame.bufferFrameStart);
        }
        int n;
        int n2;
        if (gifFrame == null) {
            n = this.header.width;
            n2 = this.header.height;
        }
        else {
            n = gifFrame.iw;
            n2 = gifFrame.ih;
        }
        final int n3 = n * n2;
        final byte[] mainPixels = this.mainPixels;
        if (mainPixels == null || mainPixels.length < n3) {
            this.mainPixels = new byte[n3];
        }
        final short[] prefix = this.prefix;
        final int n4 = 4096;
        if (prefix == null) {
            this.prefix = new short[n4];
        }
        if (this.suffix == null) {
            this.suffix = new byte[n4];
        }
        if (this.pixelStack == null) {
            this.pixelStack = new byte[4097];
        }
        int read = this.read();
        int n5 = 1;
        final int n6 = n5 << read;
        final int n7 = n6 + 1;
        final int n8 = n6 + 2;
        final int n9 = -1;
        int n10 = read + 1;
        int n11 = (n5 << n10) - n5;
        for (int i = 0; i < n6; ++i) {
            this.prefix[i] = 0;
            this.suffix[i] = (byte)i;
        }
        int n12 = 0;
        int n13 = 0;
        int j = 0;
        int n14 = 0;
        int block = 0;
        int n15 = 0;
        int n16 = 0;
        final int n17 = n9;
        int n18 = n8;
        int k = 0;
        int n19 = n17;
    Label_0357:
        while (true) {
            while (k < n3) {
                int n20 = 3;
                if (block == 0) {
                    block = this.readBlock();
                    if (block <= 0) {
                        this.status = n20;
                        for (int l = n13; l < n3; ++l) {
                            this.mainPixels[l] = 0;
                        }
                        return;
                    }
                    n12 = 0;
                }
                n16 += (this.block[n12] & 0xFF) << n15;
                final int n21 = n15 + 8;
                n12 += n5;
                --block;
                int n22 = n14;
                int n23 = n13;
                int n24 = k;
                int n25 = n21;
                while (n25 >= n10) {
                    final int n26 = n16 & n11;
                    n16 >>= n10;
                    n25 -= n10;
                    if (n26 != n6) {
                        if (n26 > n18) {
                            this.status = n20;
                        }
                        else if (n26 != n7) {
                            if (n19 == -1) {
                                final byte[] pixelStack = this.pixelStack;
                                final int n27 = j + 1;
                                pixelStack[j] = this.suffix[n26];
                                n19 = n26;
                                n22 = n26;
                                j = n27;
                                n5 = 1;
                                n20 = 3;
                                continue;
                            }
                            final int n28;
                            int n30;
                            int n31;
                            int n32;
                            if ((n28 = n26) >= n18) {
                                final byte[] pixelStack2 = this.pixelStack;
                                final int n29 = j + 1;
                                n30 = n22;
                                n31 = read;
                                pixelStack2[j] = (byte)n30;
                                n32 = n19;
                                j = n29;
                            }
                            else {
                                n30 = n22;
                                n31 = read;
                                n32 = n26;
                            }
                            while (n32 >= n6) {
                                final byte[] pixelStack3 = this.pixelStack;
                                final int n33 = j + 1;
                                final int n34 = n30;
                                pixelStack3[j] = this.suffix[n32];
                                n32 = this.prefix[n32];
                                j = n33;
                                n30 = n34;
                            }
                            final byte[] suffix = this.suffix;
                            final int n35 = suffix[n32] & 0xFF;
                            final byte[] pixelStack4 = this.pixelStack;
                            final int n36 = j + 1;
                            pixelStack4[j] = (byte)n35;
                            if (n18 < 4096) {
                                this.prefix[n18] = (short)n19;
                                suffix[n18] = (byte)n35;
                                ++n18;
                                if ((n18 & n11) == 0x0) {
                                    if (n18 < 4096) {
                                        ++n10;
                                        n11 += n18;
                                    }
                                }
                            }
                            n19 = n28;
                            byte[] mainPixels2;
                            int n37;
                            for (j = n36; j > 0; --j, mainPixels2 = this.mainPixels, n37 = n23 + 1, mainPixels2[n23] = this.pixelStack[j], ++n24, n23 = n37) {}
                            read = n31;
                            n5 = 1;
                            n20 = 3;
                            n22 = n35;
                            continue;
                        }
                        n15 = n25;
                        k = n24;
                        n13 = n23;
                        n14 = n22;
                        continue Label_0357;
                    }
                    n10 = read + 1;
                    n11 = (n5 << n10) - 1;
                    n18 = n6 + 2;
                    n19 = -1;
                }
                final int n38 = n22;
                n15 = n25;
                k = n24;
                n13 = n23;
                n14 = n38;
                n5 = 1;
            }
            continue;
        }
    }
    
    private GifHeaderParser getHeaderParser() {
        if (this.parser == null) {
            this.parser = new GifHeaderParser();
        }
        return this.parser;
    }
    
    private Bitmap getNextBitmap() {
        Bitmap alpha = this.bitmapProvider.obtain(this.header.width, this.header.height, GifDecoder.BITMAP_CONFIG);
        if (alpha == null) {
            alpha = Bitmap.createBitmap(this.header.width, this.header.height, GifDecoder.BITMAP_CONFIG);
        }
        setAlpha(alpha);
        return alpha;
    }
    
    private int read() {
        int n = 0;
        try {
            final ByteBuffer rawData = this.rawData;
            try {
                n = (rawData.get() & 0xFF);
            }
            catch (Exception ex) {
                this.status = 1;
            }
        }
        catch (Exception ex2) {}
        return n;
    }
    
    private int readBlock() {
        final int read = this.read();
        int i = 0;
        if (read > 0) {
            while (i < read) {
                final int n = read - i;
                try {
                    final ByteBuffer rawData = this.rawData;
                    try {
                        rawData.get(this.block, i, n);
                        i += n;
                    }
                    catch (Exception ex) {
                        Log.w(GifDecoder.TAG, "Error Reading Block", (Throwable)ex);
                        this.status = 1;
                    }
                }
                catch (Exception ex2) {}
                break;
            }
        }
        return i;
    }
    
    private static void setAlpha(final Bitmap bitmap) {
        if (Build$VERSION.SDK_INT >= 12) {
            bitmap.setHasAlpha(true);
        }
    }
    
    private Bitmap setPixels(final GifFrame gifFrame, final GifFrame gifFrame2) {
        final int width = this.header.width;
        final int height = this.header.height;
        final int[] mainScratch = this.mainScratch;
        if (gifFrame2 != null && gifFrame2.dispose > 0) {
            if (gifFrame2.dispose == 2) {
                int bgColor = 0;
                if (!gifFrame.transparency) {
                    bgColor = this.header.bgColor;
                }
                Arrays.fill(mainScratch, bgColor);
            }
            else if (gifFrame2.dispose == 3) {
                final Bitmap previousImage = this.previousImage;
                if (previousImage != null) {
                    previousImage.getPixels(mainScratch, 0, width, 0, 0, width, height);
                }
            }
        }
        this.decodeBitmapData(gifFrame);
        final int n = 1;
        final int n2 = 8;
        int i = 0;
        int n3 = n;
        int n4 = n2;
        int n5 = 0;
        while (i < gifFrame.ih) {
            int n6 = i;
            if (gifFrame.interlace) {
                if (n5 >= gifFrame.ih) {
                    ++n3;
                    switch (n3) {
                        case 4: {
                            n5 = 1;
                            n4 = 2;
                            break;
                        }
                        case 3: {
                            n5 = 2;
                            n4 = 4;
                            break;
                        }
                        case 2: {
                            n5 = 4;
                            break;
                        }
                    }
                }
                n6 = n5;
                n5 += n4;
            }
            final int n7 = n6 + gifFrame.iy;
            if (n7 < this.header.height) {
                final int n8 = this.header.width * n7;
                int j = gifFrame.ix + n8;
                int n9 = gifFrame.iw + j;
                if (this.header.width + n8 < n9) {
                    n9 = n8 + this.header.width;
                }
                int n10 = gifFrame.iw * i;
                while (j < n9) {
                    final byte[] mainPixels = this.mainPixels;
                    final int n11 = n10 + 1;
                    final int n12 = this.act[mainPixels[n10] & 0xFF];
                    if (n12 != 0) {
                        mainScratch[j] = n12;
                    }
                    ++j;
                    n10 = n11;
                }
            }
            ++i;
        }
        if (this.savePrevious && (gifFrame.dispose == 0 || gifFrame.dispose == 1)) {
            if (this.previousImage == null) {
                this.previousImage = this.getNextBitmap();
            }
            this.previousImage.setPixels(mainScratch, 0, width, 0, 0, width, height);
        }
        final Bitmap nextBitmap = this.getNextBitmap();
        nextBitmap.setPixels(mainScratch, 0, width, 0, 0, width, height);
        return nextBitmap;
    }
    
    public void advance() {
        this.framePointer = (this.framePointer + 1) % this.header.frameCount;
    }
    
    public void clear() {
        this.header = null;
        this.data = null;
        this.mainPixels = null;
        this.mainScratch = null;
        final Bitmap previousImage = this.previousImage;
        if (previousImage != null) {
            this.bitmapProvider.release(previousImage);
        }
        this.previousImage = null;
        this.rawData = null;
    }
    
    public int getCurrentFrameIndex() {
        return this.framePointer;
    }
    
    public byte[] getData() {
        return this.data;
    }
    
    public int getDelay(final int n) {
        int delay = -1;
        if (n >= 0 && n < this.header.frameCount) {
            delay = this.header.frames.get(n).delay;
        }
        return delay;
    }
    
    public int getFrameCount() {
        return this.header.frameCount;
    }
    
    public int getHeight() {
        return this.header.height;
    }
    
    public int getLoopCount() {
        return this.header.loopCount;
    }
    
    public int getNextDelay() {
        if (this.header.frameCount > 0) {
            final int framePointer = this.framePointer;
            if (framePointer >= 0) {
                return this.getDelay(framePointer);
            }
        }
        return -1;
    }
    
    public Bitmap getNextFrame() {
        synchronized (this) {
            final int frameCount = this.header.frameCount;
            final int n = 3;
            final int n2 = 1;
            if (frameCount <= 0 || this.framePointer < 0) {
                if (Log.isLoggable(GifDecoder.TAG, n)) {
                    final String tag = GifDecoder.TAG;
                    final StringBuilder sb = new StringBuilder();
                    sb.append("unable to decode frame, frameCount=");
                    sb.append(this.header.frameCount);
                    sb.append(" framePointer=");
                    sb.append(this.framePointer);
                    Log.d(tag, sb.toString());
                }
                this.status = n2;
            }
            if (this.status == n2 || this.status == 2) {
                if (Log.isLoggable(GifDecoder.TAG, n)) {
                    final String tag2 = GifDecoder.TAG;
                    final StringBuilder sb2 = new StringBuilder();
                    sb2.append("Unable to decode frame, status=");
                    sb2.append(this.status);
                    Log.d(tag2, sb2.toString());
                }
                return null;
            }
            this.status = 0;
            final GifFrame gifFrame = this.header.frames.get(this.framePointer);
            GifFrame gifFrame2 = null;
            final int n3 = this.framePointer - n2;
            if (n3 >= 0) {
                gifFrame2 = (GifFrame)this.header.frames.get(n3);
            }
            if (gifFrame.lct == null) {
                this.act = this.header.gct;
            }
            else {
                this.act = gifFrame.lct;
                if (this.header.bgIndex == gifFrame.transIndex) {
                    this.header.bgColor = 0;
                }
            }
            int n4 = 0;
            if (gifFrame.transparency) {
                n4 = this.act[gifFrame.transIndex];
                this.act[gifFrame.transIndex] = 0;
            }
            if (this.act == null) {
                if (Log.isLoggable(GifDecoder.TAG, n)) {
                    Log.d(GifDecoder.TAG, "No Valid Color Table");
                }
                this.status = n2;
                return null;
            }
            final Bitmap setPixels = this.setPixels(gifFrame, gifFrame2);
            if (gifFrame.transparency) {
                this.act[gifFrame.transIndex] = n4;
            }
            return setPixels;
        }
    }
    
    public int getStatus() {
        return this.status;
    }
    
    public int getWidth() {
        return this.header.width;
    }
    
    public int read(final InputStream inputStream, final int n) {
        Label_0137: {
            if (inputStream != null) {
                final int n2 = 16384;
                int n3;
                if (n > 0) {
                    n3 = n + 4096;
                }
                else {
                    n3 = 16384;
                }
                try {
                    final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(n3);
                    final byte[] array = new byte[n2];
                    try {
                        while (true) {
                            final int read = inputStream.read(array, 0, array.length);
                            if (read == -1) {
                                break;
                            }
                            byteArrayOutputStream.write(array, 0, read);
                        }
                        byteArrayOutputStream.flush();
                        this.read(byteArrayOutputStream.toByteArray());
                    }
                    catch (IOException ex) {
                        Log.w(GifDecoder.TAG, "Error reading data from stream", (Throwable)ex);
                    }
                    break Label_0137;
                }
                catch (IOException ex3) {}
            }
            this.status = 2;
        }
        if (inputStream != null) {
            try {
                inputStream.close();
            }
            catch (IOException ex2) {
                Log.w(GifDecoder.TAG, "Error closing stream", (Throwable)ex2);
            }
        }
        return this.status;
    }
    
    public int read(final byte[] array) {
        this.data = array;
        this.header = this.getHeaderParser().setData(array).parseHeader();
        if (array != null) {
            (this.rawData = ByteBuffer.wrap(array)).rewind();
            this.rawData.order(ByteOrder.LITTLE_ENDIAN);
            this.mainPixels = new byte[this.header.width * this.header.height];
            this.mainScratch = new int[this.header.width * this.header.height];
            this.savePrevious = false;
            final Iterator<GifFrame> iterator = this.header.frames.iterator();
            while (iterator.hasNext()) {
                if (iterator.next().dispose == 3) {
                    this.savePrevious = true;
                    break;
                }
            }
        }
        return this.status;
    }
    
    public void resetFrameIndex() {
        this.framePointer = -1;
    }
    
    public void setData(final GifHeader header, final byte[] data) {
        this.header = header;
        this.data = data;
        this.status = 0;
        this.framePointer = -1;
        (this.rawData = ByteBuffer.wrap(data)).rewind();
        this.rawData.order(ByteOrder.LITTLE_ENDIAN);
        this.savePrevious = false;
        final Iterator<GifFrame> iterator = header.frames.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().dispose == 3) {
                this.savePrevious = true;
                break;
            }
        }
        this.mainPixels = new byte[header.width * header.height];
        this.mainScratch = new int[header.width * header.height];
    }
}
