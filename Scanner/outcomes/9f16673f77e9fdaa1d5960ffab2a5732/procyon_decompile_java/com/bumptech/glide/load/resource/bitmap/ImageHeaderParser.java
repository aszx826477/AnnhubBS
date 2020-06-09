// 
// Decompiled by Procyon v0.5.30
// 

package com.bumptech.glide.load.resource.bitmap;

import java.nio.ByteOrder;
import android.util.Log;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

public class ImageHeaderParser
{
    private static final int[] BYTES_PER_FORMAT;
    private static final int EXIF_MAGIC_NUMBER = 65496;
    private static final int EXIF_SEGMENT_TYPE = 225;
    private static final int GIF_HEADER = 4671814;
    private static final int INTEL_TIFF_MAGIC_NUMBER = 18761;
    private static final String JPEG_EXIF_SEGMENT_PREAMBLE = "Exif\u0000\u0000";
    private static final byte[] JPEG_EXIF_SEGMENT_PREAMBLE_BYTES;
    private static final int MARKER_EOI = 217;
    private static final int MOTOROLA_TIFF_MAGIC_NUMBER = 19789;
    private static final int ORIENTATION_TAG_TYPE = 274;
    private static final int PNG_HEADER = -1991225785;
    private static final int SEGMENT_SOS = 218;
    private static final int SEGMENT_START_ID = 255;
    private static final String TAG = "ImageHeaderParser";
    private final ImageHeaderParser$StreamReader streamReader;
    
    static {
        final int[] array;
        final int[] bytes_PER_FORMAT = array = new int[13];
        array[0] = 0;
        array[2] = (array[1] = 1);
        array[3] = 2;
        array[4] = 4;
        array[5] = 8;
        array[7] = (array[6] = 1);
        array[8] = 2;
        array[9] = 4;
        array[10] = 8;
        array[11] = 4;
        array[12] = 8;
        BYTES_PER_FORMAT = bytes_PER_FORMAT;
        byte[] bytes = new byte[0];
        final String s = "Exif\u0000\u0000";
        final String s2 = "UTF-8";
        final String s3 = s;
        try {
            bytes = s3.getBytes(s2);
        }
        catch (UnsupportedEncodingException ex) {}
        JPEG_EXIF_SEGMENT_PREAMBLE_BYTES = bytes;
    }
    
    public ImageHeaderParser(final InputStream inputStream) {
        this.streamReader = new ImageHeaderParser$StreamReader(inputStream);
    }
    
    private static int calcTagOffset(final int n, final int n2) {
        return n + 2 + n2 * 12;
    }
    
    private byte[] getExifSegment() {
        while (true) {
            final short uInt8 = this.streamReader.getUInt8();
            final short n = 255;
            final int n2 = 3;
            if (uInt8 != n) {
                if (Log.isLoggable("ImageHeaderParser", n2)) {
                    final String s = "ImageHeaderParser";
                    final StringBuilder sb = new StringBuilder();
                    sb.append("Unknown segmentId=");
                    sb.append(uInt8);
                    Log.d(s, sb.toString());
                }
                return null;
            }
            final short uInt9 = this.streamReader.getUInt8();
            if (uInt9 == 218) {
                return null;
            }
            if (uInt9 == 217) {
                if (Log.isLoggable("ImageHeaderParser", n2)) {
                    Log.d("ImageHeaderParser", "Found MARKER_EOI in exif segment");
                }
                return null;
            }
            final int n3 = this.streamReader.getUInt16() - 2;
            if (uInt9 != 225) {
                final long skip = this.streamReader.skip(n3);
                if (skip != n3) {
                    if (Log.isLoggable("ImageHeaderParser", n2)) {
                        final String s2 = "ImageHeaderParser";
                        final StringBuilder sb2 = new StringBuilder();
                        sb2.append("Unable to skip enough data, type: ");
                        sb2.append(uInt9);
                        sb2.append(", wanted to skip: ");
                        sb2.append(n3);
                        sb2.append(", but actually skipped: ");
                        sb2.append(skip);
                        Log.d(s2, sb2.toString());
                    }
                    return null;
                }
                continue;
            }
            else {
                final byte[] array = new byte[n3];
                final int read = this.streamReader.read(array);
                if (read != n3) {
                    if (Log.isLoggable("ImageHeaderParser", n2)) {
                        final String s3 = "ImageHeaderParser";
                        final StringBuilder sb3 = new StringBuilder();
                        sb3.append("Unable to read segment data, type: ");
                        sb3.append(uInt9);
                        sb3.append(", length: ");
                        sb3.append(n3);
                        sb3.append(", actually read: ");
                        sb3.append(read);
                        Log.d(s3, sb3.toString());
                    }
                    return null;
                }
                return array;
            }
        }
    }
    
    private static boolean handles(final int n) {
        final char c = (char)(-40);
        return (n & c) == c || n == 19789 || n == 18761;
    }
    
    private static int parseExifSegment(final ImageHeaderParser$RandomAccessReader imageHeaderParser$RandomAccessReader) {
        final int length = "Exif\u0000\u0000".length();
        final short int16 = imageHeaderParser$RandomAccessReader.getInt16(length);
        int n = 3;
        ByteOrder byteOrder;
        if (int16 == 19789) {
            byteOrder = ByteOrder.BIG_ENDIAN;
        }
        else if (int16 == 18761) {
            byteOrder = ByteOrder.LITTLE_ENDIAN;
        }
        else {
            if (Log.isLoggable("ImageHeaderParser", n)) {
                final String s = "ImageHeaderParser";
                final StringBuilder sb = new StringBuilder();
                sb.append("Unknown endianness = ");
                sb.append(int16);
                Log.d(s, sb.toString());
            }
            byteOrder = ByteOrder.BIG_ENDIAN;
        }
        imageHeaderParser$RandomAccessReader.order(byteOrder);
        final int n2 = imageHeaderParser$RandomAccessReader.getInt32(length + 4) + length;
        for (short int17 = imageHeaderParser$RandomAccessReader.getInt16(n2), n3 = 0; n3 < int17; ++n3, n = 3) {
            final int calcTagOffset = calcTagOffset(n2, n3);
            final short int18 = imageHeaderParser$RandomAccessReader.getInt16(calcTagOffset);
            if (int18 == 274) {
                final short int19 = imageHeaderParser$RandomAccessReader.getInt16(calcTagOffset + 2);
                if (int19 >= 1 && int19 <= 12) {
                    final int int20 = imageHeaderParser$RandomAccessReader.getInt32(calcTagOffset + 4);
                    if (int20 < 0) {
                        if (Log.isLoggable("ImageHeaderParser", n)) {
                            Log.d("ImageHeaderParser", "Negative tiff component count");
                        }
                    }
                    else {
                        if (Log.isLoggable("ImageHeaderParser", n)) {
                            final String s2 = "ImageHeaderParser";
                            final StringBuilder sb2 = new StringBuilder();
                            sb2.append("Got tagIndex=");
                            sb2.append(n3);
                            sb2.append(" tagType=");
                            sb2.append(int18);
                            sb2.append(" formatCode=");
                            sb2.append(int19);
                            sb2.append(" componentCount=");
                            sb2.append(int20);
                            Log.d(s2, sb2.toString());
                        }
                        final int n4 = ImageHeaderParser.BYTES_PER_FORMAT[int19] + int20;
                        if (n4 > 4) {
                            if (Log.isLoggable("ImageHeaderParser", n)) {
                                final String s3 = "ImageHeaderParser";
                                final StringBuilder sb3 = new StringBuilder();
                                sb3.append("Got byte count > 4, not orientation, continuing, formatCode=");
                                sb3.append(int19);
                                Log.d(s3, sb3.toString());
                            }
                        }
                        else {
                            final int n5 = calcTagOffset + 8;
                            if (n5 >= 0 && n5 <= imageHeaderParser$RandomAccessReader.length()) {
                                if (n4 >= 0 && n5 + n4 <= imageHeaderParser$RandomAccessReader.length()) {
                                    return imageHeaderParser$RandomAccessReader.getInt16(n5);
                                }
                                if (Log.isLoggable("ImageHeaderParser", n)) {
                                    final String s4 = "ImageHeaderParser";
                                    final StringBuilder sb4 = new StringBuilder();
                                    sb4.append("Illegal number of bytes for TI tag data tagType=");
                                    sb4.append(int18);
                                    Log.d(s4, sb4.toString());
                                }
                            }
                            else if (Log.isLoggable("ImageHeaderParser", 3)) {
                                final String s5 = "ImageHeaderParser";
                                final StringBuilder sb5 = new StringBuilder();
                                sb5.append("Illegal tagValueOffset=");
                                sb5.append(n5);
                                sb5.append(" tagType=");
                                sb5.append(int18);
                                Log.d(s5, sb5.toString());
                            }
                        }
                    }
                }
                else if (Log.isLoggable("ImageHeaderParser", 3)) {
                    final String s6 = "ImageHeaderParser";
                    final StringBuilder sb6 = new StringBuilder();
                    sb6.append("Got invalid format code=");
                    sb6.append(int19);
                    Log.d(s6, sb6.toString());
                }
            }
        }
        return -1;
    }
    
    public int getOrientation() {
        final boolean handles = handles(this.streamReader.getUInt16());
        final int n = -1;
        if (!handles) {
            return n;
        }
        final byte[] exifSegment = this.getExifSegment();
        int n2;
        if (exifSegment != null && exifSegment.length > ImageHeaderParser.JPEG_EXIF_SEGMENT_PREAMBLE_BYTES.length) {
            n2 = 1;
        }
        else {
            n2 = 0;
        }
        if (n2 != 0) {
            int n3 = 0;
            while (true) {
                final byte[] jpeg_EXIF_SEGMENT_PREAMBLE_BYTES = ImageHeaderParser.JPEG_EXIF_SEGMENT_PREAMBLE_BYTES;
                if (n3 >= jpeg_EXIF_SEGMENT_PREAMBLE_BYTES.length) {
                    break;
                }
                if (exifSegment[n3] != jpeg_EXIF_SEGMENT_PREAMBLE_BYTES[n3]) {
                    n2 = 0;
                    break;
                }
                ++n3;
            }
        }
        if (n2 != 0) {
            return parseExifSegment(new ImageHeaderParser$RandomAccessReader(exifSegment));
        }
        return n;
    }
    
    public ImageHeaderParser$ImageType getType() {
        final int uInt16 = this.streamReader.getUInt16();
        if (uInt16 == (char)(-40)) {
            return ImageHeaderParser$ImageType.JPEG;
        }
        final int n = (uInt16 << 16 & 0xFFFF0000) | (this.streamReader.getUInt16() & (char)(-1));
        if (n == -1991225785) {
            this.streamReader.skip(21);
            ImageHeaderParser$ImageType imageHeaderParser$ImageType;
            if (this.streamReader.getByte() >= 3) {
                imageHeaderParser$ImageType = ImageHeaderParser$ImageType.PNG_A;
            }
            else {
                imageHeaderParser$ImageType = ImageHeaderParser$ImageType.PNG;
            }
            return imageHeaderParser$ImageType;
        }
        if (n >> 8 == 4671814) {
            return ImageHeaderParser$ImageType.GIF;
        }
        return ImageHeaderParser$ImageType.UNKNOWN;
    }
    
    public boolean hasAlpha() {
        return this.getType().hasAlpha();
    }
}
