// 
// Decompiled by Procyon v0.5.30
// 

package com.bumptech.glide.load.model;

import android.text.TextUtils;
import com.bumptech.glide.load.data.DataFetcher;
import java.io.File;
import android.net.Uri;

public class StringLoader implements ModelLoader
{
    private final ModelLoader uriLoader;
    
    public StringLoader(final ModelLoader uriLoader) {
        this.uriLoader = uriLoader;
    }
    
    private static Uri toFileUri(final String s) {
        return Uri.fromFile(new File(s));
    }
    
    public DataFetcher getResourceFetcher(final String s, final int n, final int n2) {
        if (TextUtils.isEmpty((CharSequence)s)) {
            return null;
        }
        Uri uri;
        if (s.startsWith("/")) {
            uri = toFileUri(s);
        }
        else {
            uri = Uri.parse(s);
            if (uri.getScheme() == null) {
                uri = toFileUri(s);
            }
        }
        return this.uriLoader.getResourceFetcher(uri, n, n2);
    }
}
