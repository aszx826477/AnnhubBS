// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.provider;

import android.net.Uri;
import android.content.Context;

class TreeDocumentFile extends DocumentFile
{
    private Context mContext;
    private Uri mUri;
    
    TreeDocumentFile(final DocumentFile documentFile, final Context mContext, final Uri mUri) {
        super(documentFile);
        this.mContext = mContext;
        this.mUri = mUri;
    }
    
    public boolean canRead() {
        return DocumentsContractApi19.canRead(this.mContext, this.mUri);
    }
    
    public boolean canWrite() {
        return DocumentsContractApi19.canWrite(this.mContext, this.mUri);
    }
    
    public DocumentFile createDirectory(final String s) {
        final Uri directory = DocumentsContractApi21.createDirectory(this.mContext, this.mUri, s);
        DocumentFile documentFile;
        if (directory != null) {
            documentFile = new TreeDocumentFile(this, this.mContext, directory);
        }
        else {
            documentFile = null;
        }
        return documentFile;
    }
    
    public DocumentFile createFile(final String s, final String s2) {
        final Uri file = DocumentsContractApi21.createFile(this.mContext, this.mUri, s, s2);
        DocumentFile documentFile;
        if (file != null) {
            documentFile = new TreeDocumentFile(this, this.mContext, file);
        }
        else {
            documentFile = null;
        }
        return documentFile;
    }
    
    public boolean delete() {
        return DocumentsContractApi19.delete(this.mContext, this.mUri);
    }
    
    public boolean exists() {
        return DocumentsContractApi19.exists(this.mContext, this.mUri);
    }
    
    public String getName() {
        return DocumentsContractApi19.getName(this.mContext, this.mUri);
    }
    
    public String getType() {
        return DocumentsContractApi19.getType(this.mContext, this.mUri);
    }
    
    public Uri getUri() {
        return this.mUri;
    }
    
    public boolean isDirectory() {
        return DocumentsContractApi19.isDirectory(this.mContext, this.mUri);
    }
    
    public boolean isFile() {
        return DocumentsContractApi19.isFile(this.mContext, this.mUri);
    }
    
    public boolean isVirtual() {
        return DocumentsContractApi19.isVirtual(this.mContext, this.mUri);
    }
    
    public long lastModified() {
        return DocumentsContractApi19.lastModified(this.mContext, this.mUri);
    }
    
    public long length() {
        return DocumentsContractApi19.length(this.mContext, this.mUri);
    }
    
    public DocumentFile[] listFiles() {
        final Uri[] listFiles = DocumentsContractApi21.listFiles(this.mContext, this.mUri);
        final DocumentFile[] array = new DocumentFile[listFiles.length];
        for (int i = 0; i < listFiles.length; ++i) {
            array[i] = new TreeDocumentFile(this, this.mContext, listFiles[i]);
        }
        return array;
    }
    
    public boolean renameTo(final String s) {
        final Uri renameTo = DocumentsContractApi21.renameTo(this.mContext, this.mUri, s);
        if (renameTo != null) {
            this.mUri = renameTo;
            return true;
        }
        return false;
    }
}
