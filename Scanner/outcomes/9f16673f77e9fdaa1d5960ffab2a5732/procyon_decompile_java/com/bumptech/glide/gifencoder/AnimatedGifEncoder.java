// 
// Decompiled by Procyon v0.5.30
// 

package com.bumptech.glide.gifencoder;

import java.io.FileOutputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import android.util.Log;
import android.graphics.Paint;
import android.graphics.Canvas;
import android.graphics.Bitmap$Config;
import android.graphics.Color;
import java.io.OutputStream;
import android.graphics.Bitmap;

public class AnimatedGifEncoder
{
    private static final double MIN_TRANSPARENT_PERCENTAGE = 4.0;
    private static final String TAG = "AnimatedGifEncoder";
    private boolean closeStream;
    private int colorDepth;
    private byte[] colorTab;
    private int delay;
    private int dispose;
    private boolean firstFrame;
    private boolean hasTransparentPixels;
    private int height;
    private Bitmap image;
    private byte[] indexedPixels;
    private OutputStream out;
    private int palSize;
    private byte[] pixels;
    private int repeat;
    private int sample;
    private boolean sizeSet;
    private boolean started;
    private int transIndex;
    private Integer transparent;
    private boolean[] usedEntry;
    private int width;
    
    public AnimatedGifEncoder() {
        this.transparent = null;
        final int n = -1;
        this.repeat = n;
        this.delay = 0;
        this.started = false;
        this.usedEntry = new boolean[256];
        this.palSize = 7;
        this.dispose = n;
        this.closeStream = false;
        this.firstFrame = true;
        this.sizeSet = false;
        this.sample = 10;
    }
    
    private void analyzePixels() {
        final byte[] pixels = this.pixels;
        final int length = pixels.length;
        final int n = length / 3;
        this.indexedPixels = new byte[n];
        final NeuQuant neuQuant;
        this.colorTab = (neuQuant = new NeuQuant(pixels, length, this.sample)).process();
        int n2 = 0;
        while (true) {
            final byte[] colorTab = this.colorTab;
            if (n2 >= colorTab.length) {
                break;
            }
            final byte b = colorTab[n2];
            colorTab[n2] = colorTab[n2 + 2];
            colorTab[n2 + 2] = b;
            this.usedEntry[n2 / 3] = false;
            n2 += 3;
        }
        int n3 = 0;
        int n8;
        for (int i = 0; i < n; ++i, n3 = n8) {
            final byte[] pixels2 = this.pixels;
            final int n4 = n3 + 1;
            final int n5 = pixels2[n3] & 0xFF;
            final int n6 = n4 + 1;
            final int n7 = pixels2[n4] & 0xFF;
            n8 = n6 + 1;
            final int map = neuQuant.map(n5, n7, pixels2[n6] & 0xFF);
            this.usedEntry[map] = true;
            this.indexedPixels[i] = (byte)map;
        }
        this.pixels = null;
        this.colorDepth = 8;
        this.palSize = 7;
        final Integer transparent = this.transparent;
        if (transparent != null) {
            this.transIndex = this.findClosest(transparent);
        }
        else if (this.hasTransparentPixels) {
            this.transIndex = this.findClosest(0);
        }
    }
    
    private int findClosest(final int n) {
        if (this.colorTab == null) {
            return -1;
        }
        final int red = Color.red(n);
        final int green = Color.green(n);
        final int blue = Color.blue(n);
        int n2 = 0;
        int n3 = 16777216;
        int n6;
        for (int length = this.colorTab.length, i = 0; i < length; i = n6 + 1) {
            final byte[] colorTab = this.colorTab;
            final int n4 = i + 1;
            final int n5 = red - (colorTab[i] & 0xFF);
            n6 = n4 + 1;
            final int n7 = green - (colorTab[n4] & 0xFF);
            final int n8 = blue - (colorTab[n6] & 0xFF);
            final int n9 = n5 * n5 + n7 * n7 + n8 * n8;
            final int n10 = n6 / 3;
            if (this.usedEntry[n10] && n9 < n3) {
                n3 = n9;
                n2 = n10;
            }
        }
        return n2;
    }
    
    private void getImagePixels() {
        final int width = this.image.getWidth();
        final int height = this.image.getHeight();
        if (width != this.width || height != this.height) {
            final Bitmap bitmap = Bitmap.createBitmap(this.width, this.height, Bitmap$Config.ARGB_8888);
            new Canvas(bitmap).drawBitmap(bitmap, 0.0f, 0.0f, (Paint)null);
            this.image = bitmap;
        }
        final int[] array = new int[width * height];
        final Bitmap image = this.image;
        boolean hasTransparentPixels = false;
        image.getPixels(array, 0, width, 0, 0, width, height);
        final int length = array.length;
        final int n = 3;
        this.pixels = new byte[length * 3];
        int n2 = 0;
        this.hasTransparentPixels = false;
        int n3 = 0;
        final int[] array2 = array;
        int n7;
        for (int length2 = array.length, i = 0; i < length2; ++i, n2 = n7) {
            final int n4 = array2[i];
            if (n4 == 0) {
                ++n3;
            }
            final byte[] pixels = this.pixels;
            final int n5 = n2 + 1;
            pixels[n2] = (byte)(n4 & 0xFF);
            final int n6 = n5 + 1;
            pixels[n5] = (byte)(n4 >> 8 & 0xFF);
            n7 = n6 + 1;
            pixels[n6] = (byte)(n4 >> 16 & 0xFF);
        }
        final double n8 = n3 * 100;
        final double n9 = array.length;
        Double.isNaN(n8);
        Double.isNaN(n9);
        final double n10 = n8 / n9;
        if (n10 > 4.0) {
            hasTransparentPixels = true;
        }
        this.hasTransparentPixels = hasTransparentPixels;
        if (Log.isLoggable("AnimatedGifEncoder", n)) {
            final String s = "AnimatedGifEncoder";
            final StringBuilder sb = new StringBuilder();
            sb.append("got pixels for frame with ");
            sb.append(n10);
            sb.append("% transparent pixels");
            Log.d(s, sb.toString());
        }
    }
    
    private void writeGraphicCtrlExt() {
        this.out.write(33);
        this.out.write(249);
        this.out.write(4);
        boolean b;
        int n;
        if (this.transparent == null && !this.hasTransparentPixels) {
            b = false;
            n = 0;
        }
        else {
            b = true;
            n = 2;
        }
        final int dispose = this.dispose;
        if (dispose >= 0) {
            n = (dispose & 0x7);
        }
        this.out.write(n << 2 | 0x0 | 0x0 | (b ? 1 : 0));
        this.writeShort(this.delay);
        this.out.write(this.transIndex);
        this.out.write(0);
    }
    
    private void writeImageDesc() {
        this.out.write(44);
        this.writeShort(0);
        this.writeShort(0);
        this.writeShort(this.width);
        this.writeShort(this.height);
        if (this.firstFrame) {
            this.out.write(0);
        }
        else {
            this.out.write(this.palSize | 0x80);
        }
    }
    
    private void writeLSD() {
        this.writeShort(this.width);
        this.writeShort(this.height);
        this.out.write(this.palSize | 0xF0);
        this.out.write(0);
        this.out.write(0);
    }
    
    private void writeNetscapeExt() {
        this.out.write(33);
        this.out.write(255);
        this.out.write(11);
        this.writeString("NETSCAPE2.0");
        this.out.write(3);
        this.out.write(1);
        this.writeShort(this.repeat);
        this.out.write(0);
    }
    
    private void writePalette() {
        final OutputStream out = this.out;
        final byte[] colorTab = this.colorTab;
        out.write(colorTab, 0, colorTab.length);
        for (int n = 768 - this.colorTab.length, i = 0; i < n; ++i) {
            this.out.write(0);
        }
    }
    
    private void writePixels() {
        new LZWEncoder(this.width, this.height, this.indexedPixels, this.colorDepth).encode(this.out);
    }
    
    private void writeShort(final int n) {
        this.out.write(n & 0xFF);
        this.out.write(n >> 8 & 0xFF);
    }
    
    private void writeString(final String s) {
        for (int i = 0; i < s.length(); ++i) {
            this.out.write((byte)s.charAt(i));
        }
    }
    
    public boolean addFrame(final Bitmap image) {
        if (image != null && this.started) {
            boolean b = true;
            try {
                Label_0048: {
                    if (this.sizeSet) {
                        break Label_0048;
                    }
                    final int width = image.getWidth();
                    try {
                        this.setSize(width, image.getHeight());
                        this.image = image;
                        this.getImagePixels();
                        this.analyzePixels();
                        if (this.firstFrame) {
                            this.writeLSD();
                            this.writePalette();
                            if (this.repeat >= 0) {
                                this.writeNetscapeExt();
                            }
                        }
                        this.writeGraphicCtrlExt();
                        this.writeImageDesc();
                        if (!this.firstFrame) {
                            this.writePalette();
                        }
                        this.writePixels();
                        try {
                            this.firstFrame = false;
                        }
                        catch (IOException ex) {
                            b = false;
                        }
                    }
                    catch (IOException ex2) {}
                }
            }
            catch (IOException ex3) {}
            return b;
        }
        return false;
    }
    
    public boolean finish() {
        if (!this.started) {
            return false;
        }
        boolean b = true;
        this.started = false;
        try {
            this.out.write(59);
            final OutputStream out = this.out;
            try {
                out.flush();
                Label_0063: {
                    if (!this.closeStream) {
                        break Label_0063;
                    }
                    final OutputStream out2 = this.out;
                    try {
                        out2.close();
                    }
                    catch (IOException ex) {
                        b = false;
                    }
                }
            }
            catch (IOException ex2) {}
        }
        catch (IOException ex3) {}
        this.transIndex = 0;
        this.out = null;
        this.image = null;
        this.pixels = null;
        this.indexedPixels = null;
        this.colorTab = null;
        this.closeStream = false;
        this.firstFrame = true;
        return b;
    }
    
    public void setDelay(final int n) {
        this.delay = Math.round(n / 10.0f);
    }
    
    public void setDispose(final int dispose) {
        if (dispose >= 0) {
            this.dispose = dispose;
        }
    }
    
    public void setFrameRate(final float n) {
        if (n != 0.0f) {
            this.delay = Math.round(100.0f / n);
        }
    }
    
    public void setQuality(int sample) {
        if (sample < 1) {
            sample = 1;
        }
        this.sample = sample;
    }
    
    public void setRepeat(final int repeat) {
        if (repeat >= 0) {
            this.repeat = repeat;
        }
    }
    
    public void setSize(final int width, final int height) {
        if (this.started && !this.firstFrame) {
            return;
        }
        this.width = width;
        this.height = height;
        final int width2 = this.width;
        final int sizeSet = 1;
        if (width2 < sizeSet) {
            this.width = 320;
        }
        if (this.height < sizeSet) {
            this.height = 240;
        }
        this.sizeSet = (sizeSet != 0);
    }
    
    public void setTransparent(final int n) {
        this.transparent = n;
    }
    
    public boolean start(final OutputStream out) {
        if (out == null) {
            return false;
        }
        boolean started = true;
        this.closeStream = false;
        this.out = out;
        final String s = "GIF89a";
        try {
            this.writeString(s);
        }
        catch (IOException ex) {
            started = false;
        }
        return this.started = started;
    }
    
    public boolean start(final String s) {
        boolean start = false;
        try {
            final BufferedOutputStream out = new(java.io.BufferedOutputStream.class);
            try {
                final FileOutputStream fileOutputStream = new FileOutputStream(s);
                final BufferedOutputStream bufferedOutputStream = out;
                try {
                    new BufferedOutputStream(fileOutputStream);
                    try {
                        this.out = out;
                        start = this.start(this.out);
                        this.closeStream = true;
                    }
                    catch (IOException ex) {
                        start = false;
                    }
                }
                catch (IOException ex2) {}
            }
            catch (IOException ex3) {}
        }
        catch (IOException ex4) {}
        return this.started = start;
    }
}
