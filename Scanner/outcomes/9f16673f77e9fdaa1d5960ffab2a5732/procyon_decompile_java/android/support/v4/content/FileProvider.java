// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.content;

import android.database.MatrixCursor;
import android.database.Cursor;
import android.os.ParcelFileDescriptor;
import android.content.ContentValues;
import android.webkit.MimeTypeMap;
import android.content.pm.ProviderInfo;
import android.content.res.XmlResourceParser;
import android.os.Environment;
import android.net.Uri;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParserException;
import android.content.Context;
import java.util.HashMap;
import java.io.File;
import android.content.ContentProvider;

public class FileProvider extends ContentProvider
{
    private static final String ATTR_NAME = "name";
    private static final String ATTR_PATH = "path";
    private static final String[] COLUMNS;
    private static final File DEVICE_ROOT;
    private static final String META_DATA_FILE_PROVIDER_PATHS = "android.support.FILE_PROVIDER_PATHS";
    private static final String TAG_CACHE_PATH = "cache-path";
    private static final String TAG_EXTERNAL = "external-path";
    private static final String TAG_EXTERNAL_CACHE = "external-cache-path";
    private static final String TAG_EXTERNAL_FILES = "external-files-path";
    private static final String TAG_FILES_PATH = "files-path";
    private static final String TAG_ROOT_PATH = "root-path";
    private static HashMap sCache;
    private FileProvider$PathStrategy mStrategy;
    
    static {
        COLUMNS = new String[] { "_display_name", "_size" };
        DEVICE_ROOT = new File("/");
        FileProvider.sCache = new HashMap();
    }
    
    private static File buildPath(final File file, final String... array) {
        File file2 = file;
        for (int length = array.length, i = 0; i < length; ++i) {
            final String s = array[i];
            if (s != null) {
                file2 = new File(file2, s);
            }
        }
        return file2;
    }
    
    private static Object[] copyOf(final Object[] array, final int n) {
        final Object[] array2 = new Object[n];
        System.arraycopy(array, 0, array2, 0, n);
        return array2;
    }
    
    private static String[] copyOf(final String[] array, final int n) {
        final String[] array2 = new String[n];
        System.arraycopy(array, 0, array2, 0, n);
        return array2;
    }
    
    private static FileProvider$PathStrategy getPathStrategy(final Context context, final String s) {
        final HashMap sCache = FileProvider.sCache;
        synchronized (sCache) {
            FileProvider$PathStrategy pathStrategy;
            if ((pathStrategy = FileProvider.sCache.get(s)) == null) {
                try {
                    pathStrategy = parsePathStrategy(context, s);
                    FileProvider.sCache.put(s, pathStrategy);
                }
                catch (XmlPullParserException ex) {
                    throw new IllegalArgumentException("Failed to parse android.support.FILE_PROVIDER_PATHS meta-data", (Throwable)ex);
                }
                catch (IOException ex2) {
                    throw new IllegalArgumentException("Failed to parse android.support.FILE_PROVIDER_PATHS meta-data", ex2);
                }
            }
            return pathStrategy;
        }
    }
    
    public static Uri getUriForFile(final Context context, final String s, final File file) {
        return getPathStrategy(context, s).getUriForFile(file);
    }
    
    private static int modeToMode(final String s) {
        int n;
        if ("r".equals(s)) {
            n = 268435456;
        }
        else if (!"w".equals(s) && !"wt".equals(s)) {
            if ("wa".equals(s)) {
                n = 704643072;
            }
            else if ("rw".equals(s)) {
                n = 939524096;
            }
            else {
                if (!"rwt".equals(s)) {
                    final StringBuilder sb = new StringBuilder();
                    sb.append("Invalid mode: ");
                    sb.append(s);
                    throw new IllegalArgumentException(sb.toString());
                }
                n = 1006632960;
            }
        }
        else {
            n = 738197504;
        }
        return n;
    }
    
    private static FileProvider$PathStrategy parsePathStrategy(final Context context, final String s) {
        final FileProvider$SimplePathStrategy fileProvider$SimplePathStrategy = new FileProvider$SimplePathStrategy(s);
        final XmlResourceParser loadXmlMetaData = context.getPackageManager().resolveContentProvider(s, 128).loadXmlMetaData(context.getPackageManager(), "android.support.FILE_PROVIDER_PATHS");
        if (loadXmlMetaData != null) {
            while (true) {
                final int next = loadXmlMetaData.next();
                final int n = 1;
                if (next == n) {
                    break;
                }
                if (next != 2) {
                    continue;
                }
                final String name = loadXmlMetaData.getName();
                final String attributeValue = loadXmlMetaData.getAttributeValue((String)null, "name");
                final String attributeValue2 = loadXmlMetaData.getAttributeValue((String)null, "path");
                File file = null;
                if ("root-path".equals(name)) {
                    file = FileProvider.DEVICE_ROOT;
                }
                else if ("files-path".equals(name)) {
                    file = context.getFilesDir();
                }
                else if ("cache-path".equals(name)) {
                    file = context.getCacheDir();
                }
                else if ("external-path".equals(name)) {
                    file = Environment.getExternalStorageDirectory();
                }
                else if ("external-files-path".equals(name)) {
                    final File[] externalFilesDirs = ContextCompat.getExternalFilesDirs(context, null);
                    if (externalFilesDirs.length > 0) {
                        file = externalFilesDirs[0];
                    }
                }
                else if ("external-cache-path".equals(name)) {
                    final File[] externalCacheDirs = ContextCompat.getExternalCacheDirs(context);
                    if (externalCacheDirs.length > 0) {
                        file = externalCacheDirs[0];
                    }
                }
                if (file == null) {
                    continue;
                }
                final String[] array = new String[n];
                array[0] = attributeValue2;
                fileProvider$SimplePathStrategy.addRoot(attributeValue, buildPath(file, array));
            }
            return fileProvider$SimplePathStrategy;
        }
        throw new IllegalArgumentException("Missing android.support.FILE_PROVIDER_PATHS meta-data");
    }
    
    public void attachInfo(final Context context, final ProviderInfo providerInfo) {
        super.attachInfo(context, providerInfo);
        if (providerInfo.exported) {
            throw new SecurityException("Provider must not be exported");
        }
        if (providerInfo.grantUriPermissions) {
            this.mStrategy = getPathStrategy(context, providerInfo.authority);
            return;
        }
        throw new SecurityException("Provider must grant uri permissions");
    }
    
    public int delete(final Uri uri, final String s, final String[] array) {
        return this.mStrategy.getFileForUri(uri).delete() ? 1 : 0;
    }
    
    public String getType(final Uri uri) {
        final File fileForUri = this.mStrategy.getFileForUri(uri);
        final int lastIndex = fileForUri.getName().lastIndexOf(46);
        if (lastIndex >= 0) {
            final String mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(fileForUri.getName().substring(lastIndex + 1));
            if (mimeTypeFromExtension != null) {
                return mimeTypeFromExtension;
            }
        }
        return "application/octet-stream";
    }
    
    public Uri insert(final Uri uri, final ContentValues contentValues) {
        throw new UnsupportedOperationException("No external inserts");
    }
    
    public boolean onCreate() {
        return true;
    }
    
    public ParcelFileDescriptor openFile(final Uri uri, final String s) {
        return ParcelFileDescriptor.open(this.mStrategy.getFileForUri(uri), modeToMode(s));
    }
    
    public Cursor query(final Uri uri, String[] columns, final String s, final String[] array, final String s2) {
        final File fileForUri = this.mStrategy.getFileForUri(uri);
        if (columns == null) {
            columns = FileProvider.COLUMNS;
        }
        final String[] array2 = new String[columns.length];
        final Object[] array3 = new Object[columns.length];
        int n = 0;
        for (int length = columns.length, i = 0; i < length; ++i) {
            final String s3 = columns[i];
            if ("_display_name".equals(s3)) {
                array2[n] = "_display_name";
                final int n2 = n + 1;
                array3[n] = fileForUri.getName();
                n = n2;
            }
            else if ("_size".equals(s3)) {
                array2[n] = "_size";
                final int n3 = n + 1;
                array3[n] = fileForUri.length();
                n = n3;
            }
        }
        final String[] copy = copyOf(array2, n);
        final Object[] copy2 = copyOf(array3, n);
        final MatrixCursor matrixCursor = new MatrixCursor(copy, 1);
        matrixCursor.addRow(copy2);
        return (Cursor)matrixCursor;
    }
    
    public int update(final Uri uri, final ContentValues contentValues, final String s, final String[] array) {
        throw new UnsupportedOperationException("No external updates");
    }
}
