// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.provider;

import android.database.Cursor;
import android.content.ContentResolver;
import android.util.Log;
import java.util.ArrayList;
import android.provider.DocumentsContract;
import android.net.Uri;
import android.content.Context;

class DocumentsContractApi21
{
    private static final String TAG = "DocumentFile";
    
    private static void closeQuietly(final AutoCloseable autoCloseable) {
        if (autoCloseable != null) {
            try {
                autoCloseable.close();
            }
            catch (Exception ex2) {}
            catch (RuntimeException ex) {
                throw ex;
            }
        }
    }
    
    public static Uri createDirectory(final Context context, final Uri uri, final String s) {
        return createFile(context, uri, "vnd.android.document/directory", s);
    }
    
    public static Uri createFile(final Context context, final Uri uri, final String s, final String s2) {
        return DocumentsContract.createDocument(context.getContentResolver(), uri, s, s2);
    }
    
    public static Uri[] listFiles(final Context context, final Uri uri) {
        final ContentResolver contentResolver = context.getContentResolver();
        final Uri buildChildDocumentsUriUsingTree = DocumentsContract.buildChildDocumentsUriUsingTree(uri, DocumentsContract.getDocumentId(uri));
        final ArrayList<Uri> list = new ArrayList<Uri>();
        Object query = null;
        final int n = 1;
        while (true) {
            try {
                try {
                    final String[] array = new String[n];
                    array[0] = "document_id";
                    query = contentResolver.query(buildChildDocumentsUriUsingTree, array, (String)null, (String[])null, (String)null);
                    while (((Cursor)query).moveToNext()) {
                        list.add(DocumentsContract.buildDocumentUriUsingTree(uri, ((Cursor)query).getString(0)));
                    }
                    closeQuietly((AutoCloseable)query);
                }
                finally {}
            }
            catch (Exception ex) {
                final String s = "DocumentFile";
                final StringBuilder sb = new StringBuilder();
                sb.append("Failed query: ");
                sb.append(ex);
                Log.w(s, sb.toString());
                continue;
            }
            break;
        }
        return list.toArray(new Uri[list.size()]);
        closeQuietly((AutoCloseable)query);
    }
    
    public static Uri prepareTreeUri(final Uri uri) {
        return DocumentsContract.buildDocumentUriUsingTree(uri, DocumentsContract.getTreeDocumentId(uri));
    }
    
    public static Uri renameTo(final Context context, final Uri uri, final String s) {
        return DocumentsContract.renameDocument(context.getContentResolver(), uri, s);
    }
}
