// 
// Decompiled by Procyon v0.5.30
// 

package com.bumptech.glide.load.model;

import android.net.Uri;

final class AssetUriParser
{
    private static final String ASSET_PATH_SEGMENT = "android_asset";
    private static final String ASSET_PREFIX = "file:///android_asset/";
    private static final int ASSET_PREFIX_LENGTH;
    
    static {
        ASSET_PREFIX_LENGTH = "file:///android_asset/".length();
    }
    
    public static boolean isAssetUri(final Uri uri) {
        final boolean equals = "file".equals(uri.getScheme());
        boolean b = false;
        if (equals && !uri.getPathSegments().isEmpty() && "android_asset".equals(uri.getPathSegments().get(0))) {
            b = true;
        }
        return b;
    }
    
    public static String toAssetPath(final Uri uri) {
        return uri.toString().substring(AssetUriParser.ASSET_PREFIX_LENGTH);
    }
}
