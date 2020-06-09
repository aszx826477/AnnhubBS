// 
// Decompiled by Procyon v0.5.30
// 

package com.bumptech.glide.load.model;

import android.content.res.Resources$NotFoundException;
import android.util.Log;
import android.net.Uri;
import com.bumptech.glide.load.data.DataFetcher;
import android.content.Context;
import android.content.res.Resources;

public class ResourceLoader implements ModelLoader
{
    private static final String TAG = "ResourceLoader";
    private final Resources resources;
    private final ModelLoader uriLoader;
    
    public ResourceLoader(final Context context, final ModelLoader modelLoader) {
        this(context.getResources(), modelLoader);
    }
    
    public ResourceLoader(final Resources resources, final ModelLoader uriLoader) {
        this.resources = resources;
        this.uriLoader = uriLoader;
    }
    
    public DataFetcher getResourceFetcher(final Integer n, final int n2, final int n3) {
        Object parse = null;
        try {
            try {
                final StringBuilder sb = new StringBuilder();
                sb.append("android.resource://");
                final Resources resources = this.resources;
                try {
                    sb.append(resources.getResourcePackageName((int)n));
                    final char c = '/';
                    sb.append(c);
                    final Resources resources2 = this.resources;
                    try {
                        sb.append(resources2.getResourceTypeName((int)n));
                        final StringBuilder sb2 = sb;
                        try {
                            sb2.append(c);
                            final Resources resources3 = this.resources;
                            try {
                                sb.append(resources3.getResourceEntryName((int)n));
                                final String string = sb.toString();
                                try {
                                    parse = Uri.parse(string);
                                }
                                catch (Resources$NotFoundException ex) {
                                    if (Log.isLoggable("ResourceLoader", 5)) {
                                        final String s = "ResourceLoader";
                                        final StringBuilder sb3 = new StringBuilder();
                                        sb3.append("Received invalid resource id: ");
                                        sb3.append(n);
                                        Log.w(s, sb3.toString(), (Throwable)ex);
                                    }
                                }
                            }
                            catch (Resources$NotFoundException ex2) {}
                        }
                        catch (Resources$NotFoundException ex3) {}
                    }
                    catch (Resources$NotFoundException ex4) {}
                }
                catch (Resources$NotFoundException ex5) {}
            }
            catch (Resources$NotFoundException ex6) {}
        }
        catch (Resources$NotFoundException ex7) {}
        if (parse != null) {
            return this.uriLoader.getResourceFetcher(parse, n2, n3);
        }
        return null;
    }
}
