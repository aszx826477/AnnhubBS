// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.provider;

import android.database.Cursor;
import android.content.ContentResolver;
import android.util.Log;
import android.provider.DocumentsContract;
import android.text.TextUtils;
import android.net.Uri;
import android.content.Context;

class DocumentsContractApi19
{
    private static final int FLAG_VIRTUAL_DOCUMENT = 512;
    private static final String TAG = "DocumentFile";
    
    public static boolean canRead(final Context context, final Uri uri) {
        final int n = 1;
        return context.checkCallingOrSelfUriPermission(uri, n) == 0 && !TextUtils.isEmpty((CharSequence)getRawType(context, uri)) && n;
    }
    
    public static boolean canWrite(final Context context, final Uri uri) {
        if (context.checkCallingOrSelfUriPermission(uri, 2) != 0) {
            return false;
        }
        final String rawType = getRawType(context, uri);
        final int queryForInt = queryForInt(context, uri, "flags", 0);
        if (TextUtils.isEmpty((CharSequence)rawType)) {
            return false;
        }
        final int n = queryForInt & 0x4;
        final boolean b = true;
        if (n != 0) {
            return b;
        }
        if ("vnd.android.document/directory".equals(rawType) && (queryForInt & 0x8) != 0x0) {
            return b;
        }
        return !TextUtils.isEmpty((CharSequence)rawType) && (queryForInt & 0x2) != 0x0 && b;
    }
    
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
    
    public static boolean delete(final Context context, final Uri uri) {
        return DocumentsContract.deleteDocument(context.getContentResolver(), uri);
    }
    
    public static boolean exists(final Context context, final Uri uri) {
        final ContentResolver contentResolver = context.getContentResolver();
        Object query = null;
        int n = 1;
        try {
            try {
                final String[] array = new String[n];
                array[0] = "document_id";
                if (((Cursor)(query = contentResolver.query(uri, array, (String)null, (String[])null, (String)null))).getCount() <= 0) {
                    n = 0;
                }
                closeQuietly((AutoCloseable)query);
                return n != 0;
            }
            finally {}
        }
        catch (Exception ex) {
            final String s = "DocumentFile";
            final StringBuilder sb = new StringBuilder();
            sb.append("Failed query: ");
            sb.append(ex);
            Log.w(s, sb.toString());
            closeQuietly((AutoCloseable)query);
            return false;
        }
        closeQuietly((AutoCloseable)query);
    }
    
    public static long getFlags(final Context context, final Uri uri) {
        return queryForLong(context, uri, "flags", 0L);
    }
    
    public static String getName(final Context context, final Uri uri) {
        return queryForString(context, uri, "_display_name", null);
    }
    
    private static String getRawType(final Context context, final Uri uri) {
        return queryForString(context, uri, "mime_type", null);
    }
    
    public static String getType(final Context context, final Uri uri) {
        final String rawType = getRawType(context, uri);
        if ("vnd.android.document/directory".equals(rawType)) {
            return null;
        }
        return rawType;
    }
    
    public static boolean isDirectory(final Context context, final Uri uri) {
        return "vnd.android.document/directory".equals(getRawType(context, uri));
    }
    
    public static boolean isDocumentUri(final Context context, final Uri uri) {
        return DocumentsContract.isDocumentUri(context, uri);
    }
    
    public static boolean isFile(final Context context, final Uri uri) {
        final String rawType = getRawType(context, uri);
        return !"vnd.android.document/directory".equals(rawType) && !TextUtils.isEmpty((CharSequence)rawType);
    }
    
    public static boolean isVirtual(final Context context, final Uri uri) {
        final boolean documentUri = isDocumentUri(context, uri);
        boolean b = false;
        if (!documentUri) {
            return false;
        }
        if ((getFlags(context, uri) & 0x200L) != 0x0L) {
            b = true;
        }
        return b;
    }
    
    public static long lastModified(final Context context, final Uri uri) {
        return queryForLong(context, uri, "last_modified", 0L);
    }
    
    public static long length(final Context context, final Uri uri) {
        return queryForLong(context, uri, "_size", 0L);
    }
    
    private static int queryForInt(final Context context, final Uri uri, final String s, final int n) {
        return (int)queryForLong(context, uri, s, n);
    }
    
    private static long queryForLong(final Context context, final Uri uri, final String s, final long n) {
        final ContentResolver contentResolver = context.getContentResolver();
        Object query = null;
        final int n2 = 1;
        try {
            try {
                final String[] array = new String[n2];
                array[0] = s;
                final Cursor cursor = (Cursor)(query = contentResolver.query(uri, array, (String)null, (String[])null, (String)null));
                if (cursor.moveToFirst() && !cursor.isNull(0)) {
                    final long long1 = cursor.getLong(0);
                    closeQuietly((AutoCloseable)cursor);
                    return long1;
                }
                closeQuietly((AutoCloseable)query);
                return n;
            }
            finally {}
        }
        catch (Exception ex) {
            final String s2 = "DocumentFile";
            final StringBuilder sb = new StringBuilder();
            sb.append("Failed query: ");
            sb.append(ex);
            Log.w(s2, sb.toString());
            closeQuietly((AutoCloseable)query);
            return n;
        }
        closeQuietly((AutoCloseable)query);
    }
    
    private static String queryForString(final Context context, final Uri uri, final String s, final String s2) {
        final ContentResolver contentResolver = context.getContentResolver();
        Object query = null;
        final int n = 1;
        try {
            try {
                final String[] array = new String[n];
                array[0] = s;
                final Cursor cursor = (Cursor)(query = contentResolver.query(uri, array, (String)null, (String[])null, (String)null));
                if (cursor.moveToFirst() && !cursor.isNull(0)) {
                    final String string = cursor.getString(0);
                    closeQuietly((AutoCloseable)query);
                    return string;
                }
                closeQuietly((AutoCloseable)query);
                return s2;
            }
            finally {}
        }
        catch (Exception ex) {
            final String s3 = "DocumentFile";
            final StringBuilder sb = new StringBuilder();
            sb.append("Failed query: ");
            sb.append(ex);
            Log.w(s3, sb.toString());
            closeQuietly((AutoCloseable)query);
            return s2;
        }
        closeQuietly((AutoCloseable)query);
    }
}
