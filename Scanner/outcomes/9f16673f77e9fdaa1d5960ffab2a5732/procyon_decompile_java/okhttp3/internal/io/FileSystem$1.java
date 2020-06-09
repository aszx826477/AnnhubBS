// 
// Decompiled by Procyon v0.5.30
// 

package okhttp3.internal.io;

import okio.Source;
import java.io.IOException;
import java.io.FileNotFoundException;
import okio.Okio;
import okio.Sink;
import java.io.File;

final class FileSystem$1 implements FileSystem
{
    public Sink appendingSink(final File file) {
        try {
            return Okio.appendingSink(file);
        }
        catch (FileNotFoundException ex) {
            file.getParentFile().mkdirs();
            return Okio.appendingSink(file);
        }
    }
    
    public void delete(final File file) {
        if (!file.delete() && file.exists()) {
            final StringBuilder sb = new StringBuilder();
            sb.append("failed to delete ");
            sb.append(file);
            throw new IOException(sb.toString());
        }
    }
    
    public void deleteContents(final File file) {
        final File[] listFiles = file.listFiles();
        if (listFiles != null) {
            for (int length = listFiles.length, i = 0; i < length; ++i) {
                final File file2 = listFiles[i];
                if (file2.isDirectory()) {
                    this.deleteContents(file2);
                }
                if (!file2.delete()) {
                    final StringBuilder sb = new StringBuilder();
                    sb.append("failed to delete ");
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
    
    public boolean exists(final File file) {
        return file.exists();
    }
    
    public void rename(final File file, final File file2) {
        this.delete(file2);
        if (file.renameTo(file2)) {
            return;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("failed to rename ");
        sb.append(file);
        sb.append(" to ");
        sb.append(file2);
        throw new IOException(sb.toString());
    }
    
    public Sink sink(final File file) {
        try {
            return Okio.sink(file);
        }
        catch (FileNotFoundException ex) {
            file.getParentFile().mkdirs();
            return Okio.sink(file);
        }
    }
    
    public long size(final File file) {
        return file.length();
    }
    
    public Source source(final File file) {
        return Okio.source(file);
    }
}
