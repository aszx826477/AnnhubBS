// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.content;

import java.util.Iterator;
import android.net.Uri$Builder;
import java.util.Map;
import android.net.Uri;
import java.io.IOException;
import android.text.TextUtils;
import java.io.File;
import java.util.HashMap;

class FileProvider$SimplePathStrategy implements FileProvider$PathStrategy
{
    private final String mAuthority;
    private final HashMap mRoots;
    
    public FileProvider$SimplePathStrategy(final String mAuthority) {
        this.mRoots = new HashMap();
        this.mAuthority = mAuthority;
    }
    
    public void addRoot(final String s, File canonicalFile) {
        if (!TextUtils.isEmpty((CharSequence)s)) {
            try {
                canonicalFile = canonicalFile.getCanonicalFile();
                this.mRoots.put(s, canonicalFile);
                return;
            }
            catch (IOException ex) {
                final StringBuilder sb = new StringBuilder();
                sb.append("Failed to resolve canonical path for ");
                sb.append(canonicalFile);
                throw new IllegalArgumentException(sb.toString(), ex);
            }
        }
        throw new IllegalArgumentException("Name must not be empty");
    }
    
    public File getFileForUri(final Uri uri) {
        final String encodedPath = uri.getEncodedPath();
        final int n = 1;
        final int index = encodedPath.indexOf(47, n);
        final String decode = Uri.decode(encodedPath.substring(n, index));
        final String decode2 = Uri.decode(encodedPath.substring(index + 1));
        final File file = this.mRoots.get(decode);
        if (file != null) {
            File canonicalFile = new File(file, decode2);
            try {
                if ((canonicalFile = canonicalFile.getCanonicalFile()).getPath().startsWith(file.getPath())) {
                    return canonicalFile;
                }
                throw new SecurityException("Resolved path jumped beyond configured root");
            }
            catch (IOException ex) {
                final StringBuilder sb = new StringBuilder();
                sb.append("Failed to resolve canonical path for ");
                sb.append(canonicalFile);
                throw new IllegalArgumentException(sb.toString());
            }
        }
        final StringBuilder sb2 = new StringBuilder();
        sb2.append("Unable to find configured root for ");
        sb2.append(uri);
        throw new IllegalArgumentException(sb2.toString());
    }
    
    public Uri getUriForFile(final File file) {
        try {
            final String canonicalPath = file.getCanonicalPath();
            Object o = null;
            for (final Map.Entry<K, File> entry : this.mRoots.entrySet()) {
                final String path = entry.getValue().getPath();
                if (canonicalPath.startsWith(path)) {
                    if (o != null && path.length() <= ((Map.Entry<K, File>)o).getValue().getPath().length()) {
                        continue;
                    }
                    o = entry;
                }
            }
            if (o != null) {
                final String path2 = ((Map.Entry<K, File>)o).getValue().getPath();
                String s;
                if (path2.endsWith("/")) {
                    s = canonicalPath.substring(path2.length());
                }
                else {
                    s = canonicalPath.substring(path2.length() + 1);
                }
                final StringBuilder sb = new StringBuilder();
                sb.append(Uri.encode((String)((Map.Entry)o).getKey()));
                sb.append('/');
                sb.append(Uri.encode(s, "/"));
                return new Uri$Builder().scheme("content").authority(this.mAuthority).encodedPath(sb.toString()).build();
            }
            final StringBuilder sb2 = new StringBuilder();
            sb2.append("Failed to find configured root that contains ");
            sb2.append(canonicalPath);
            throw new IllegalArgumentException(sb2.toString());
        }
        catch (IOException ex) {
            final StringBuilder sb3 = new StringBuilder();
            sb3.append("Failed to resolve canonical path for ");
            sb3.append(file);
            throw new IllegalArgumentException(sb3.toString());
        }
    }
}
