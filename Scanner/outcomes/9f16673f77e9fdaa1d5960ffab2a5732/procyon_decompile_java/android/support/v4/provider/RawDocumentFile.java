// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.provider;

import java.util.ArrayList;
import android.net.Uri;
import java.io.IOException;
import android.webkit.MimeTypeMap;
import android.util.Log;
import java.io.File;

class RawDocumentFile extends DocumentFile
{
    private File mFile;
    
    RawDocumentFile(final DocumentFile documentFile, final File mFile) {
        super(documentFile);
        this.mFile = mFile;
    }
    
    private static boolean deleteContents(final File file) {
        final File[] listFiles = file.listFiles();
        boolean b = true;
        if (listFiles != null) {
            for (int length = listFiles.length, i = 0; i < length; ++i) {
                final File file2 = listFiles[i];
                if (file2.isDirectory()) {
                    b &= deleteContents(file2);
                }
                if (!file2.delete()) {
                    final String s = "DocumentFile";
                    final StringBuilder sb = new StringBuilder();
                    sb.append("Failed to delete ");
                    sb.append(file2);
                    Log.w(s, sb.toString());
                    b = false;
                }
            }
        }
        return b;
    }
    
    private static String getTypeForName(final String s) {
        final int lastIndex = s.lastIndexOf(46);
        if (lastIndex >= 0) {
            final String mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(s.substring(lastIndex + 1).toLowerCase());
            if (mimeTypeFromExtension != null) {
                return mimeTypeFromExtension;
            }
        }
        return "application/octet-stream";
    }
    
    public boolean canRead() {
        return this.mFile.canRead();
    }
    
    public boolean canWrite() {
        return this.mFile.canWrite();
    }
    
    public DocumentFile createDirectory(final String s) {
        final File file = new File(this.mFile, s);
        if (!file.isDirectory() && !file.mkdir()) {
            return null;
        }
        return new RawDocumentFile(this, file);
    }
    
    public DocumentFile createFile(final String s, String string) {
        final String extensionFromMimeType = MimeTypeMap.getSingleton().getExtensionFromMimeType(s);
        if (extensionFromMimeType != null) {
            final StringBuilder sb = new StringBuilder();
            sb.append(string);
            sb.append(".");
            sb.append(extensionFromMimeType);
            string = sb.toString();
        }
        final File file = new File(this.mFile, string);
        try {
            file.createNewFile();
            return new RawDocumentFile(this, file);
        }
        catch (IOException ex) {
            final StringBuilder sb2 = new StringBuilder();
            sb2.append("Failed to createFile: ");
            sb2.append(ex);
            Log.w("DocumentFile", sb2.toString());
            return null;
        }
    }
    
    public boolean delete() {
        deleteContents(this.mFile);
        return this.mFile.delete();
    }
    
    public boolean exists() {
        return this.mFile.exists();
    }
    
    public String getName() {
        return this.mFile.getName();
    }
    
    public String getType() {
        if (this.mFile.isDirectory()) {
            return null;
        }
        return getTypeForName(this.mFile.getName());
    }
    
    public Uri getUri() {
        return Uri.fromFile(this.mFile);
    }
    
    public boolean isDirectory() {
        return this.mFile.isDirectory();
    }
    
    public boolean isFile() {
        return this.mFile.isFile();
    }
    
    public boolean isVirtual() {
        return false;
    }
    
    public long lastModified() {
        return this.mFile.lastModified();
    }
    
    public long length() {
        return this.mFile.length();
    }
    
    public DocumentFile[] listFiles() {
        final ArrayList<RawDocumentFile> list = new ArrayList<RawDocumentFile>();
        final File[] listFiles = this.mFile.listFiles();
        if (listFiles != null) {
            for (int length = listFiles.length, i = 0; i < length; ++i) {
                list.add(new RawDocumentFile(this, listFiles[i]));
            }
        }
        return list.toArray(new DocumentFile[list.size()]);
    }
    
    public boolean renameTo(final String s) {
        final File mFile = new File(this.mFile.getParentFile(), s);
        if (this.mFile.renameTo(mFile)) {
            this.mFile = mFile;
            return true;
        }
        return false;
    }
}
