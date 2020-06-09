// 
// Decompiled by Procyon v0.5.30
// 

package com.bumptech.glide.disklrucache;

import java.io.StringWriter;
import java.io.Reader;
import java.io.IOException;
import java.io.File;
import java.io.Closeable;
import java.nio.charset.Charset;

final class Util
{
    static final Charset US_ASCII;
    static final Charset UTF_8;
    
    static {
        US_ASCII = Charset.forName("US-ASCII");
        UTF_8 = Charset.forName("UTF-8");
    }
    
    static void closeQuietly(final Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            }
            catch (Exception ex2) {}
            catch (RuntimeException ex) {
                throw ex;
            }
        }
    }
    
    static void deleteContents(final File file) {
        final File[] listFiles = file.listFiles();
        if (listFiles != null) {
            final File[] array = listFiles;
            for (int length = listFiles.length, i = 0; i < length; ++i) {
                final File file2 = array[i];
                if (file2.isDirectory()) {
                    deleteContents(file2);
                }
                if (!file2.delete()) {
                    final StringBuilder sb = new StringBuilder();
                    sb.append("failed to delete file: ");
                    sb.append(file2);
                    throw new IOException(sb.toString());
                }
            }
            return;
        }
        final StringBuilder sb2 = new StringBuilder();
        sb2.append("not a readable directory: ");
        sb2.append(file);
        throw new IOException(sb2.toString());
    }
    
    static String readFully(final Reader reader) {
        try {
            final StringWriter stringWriter = new StringWriter();
            final char[] array = new char[1024];
            int read;
            while ((read = reader.read(array)) != -1) {
                stringWriter.write(array, 0, read);
            }
            return stringWriter.toString();
        }
        finally {
            reader.close();
        }
    }
}
