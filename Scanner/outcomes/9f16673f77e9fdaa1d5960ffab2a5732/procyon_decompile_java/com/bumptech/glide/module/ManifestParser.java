// 
// Decompiled by Procyon v0.5.30
// 

package com.bumptech.glide.module;

import java.util.Iterator;
import java.util.Set;
import android.os.Bundle;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager$NameNotFoundException;
import java.util.ArrayList;
import java.util.List;
import android.content.Context;

public final class ManifestParser
{
    private static final String GLIDE_MODULE_VALUE = "GlideModule";
    private final Context context;
    
    public ManifestParser(final Context context) {
        this.context = context;
    }
    
    private static GlideModule parseModule(final String s) {
        try {
            final Class<?> forName = Class.forName(s);
            try {
                final Object instance = forName.newInstance();
                if (instance instanceof GlideModule) {
                    return (GlideModule)instance;
                }
                final StringBuilder sb = new StringBuilder();
                sb.append("Expected instanceof GlideModule, but found: ");
                sb.append(instance);
                throw new RuntimeException(sb.toString());
            }
            catch (IllegalAccessException ex) {
                final StringBuilder sb2 = new StringBuilder();
                sb2.append("Unable to instantiate GlideModule implementation for ");
                sb2.append(forName);
                throw new RuntimeException(sb2.toString(), ex);
            }
            catch (InstantiationException ex2) {
                final StringBuilder sb3 = new StringBuilder();
                sb3.append("Unable to instantiate GlideModule implementation for ");
                sb3.append(forName);
                throw new RuntimeException(sb3.toString(), ex2);
            }
        }
        catch (ClassNotFoundException ex3) {
            throw new IllegalArgumentException("Unable to find GlideModule implementation", ex3);
        }
    }
    
    public List parse() {
        final ArrayList<GlideModule> list = new ArrayList<GlideModule>();
        try {
            final Context context = this.context;
            try {
                final PackageManager packageManager = context.getPackageManager();
                try {
                    final Context context2 = this.context;
                    try {
                        final ApplicationInfo applicationInfo = packageManager.getApplicationInfo(context2.getPackageName(), 128);
                        try {
                            if (applicationInfo.metaData == null) {
                                return list;
                            }
                            final Bundle metaData = applicationInfo.metaData;
                            try {
                                final Set keySet = metaData.keySet();
                                try {
                                    final Iterator<String> iterator = keySet.iterator();
                                    try {
                                        while (true) {
                                            if (!iterator.hasNext()) {
                                                return list;
                                            }
                                            final String next = iterator.next();
                                            try {
                                                final String s = next;
                                                if (!"GlideModule".equals(applicationInfo.metaData.get(s))) {
                                                    continue;
                                                }
                                                list.add(parseModule(s));
                                                continue;
                                            }
                                            catch (PackageManager$NameNotFoundException ex) {
                                                throw new RuntimeException("Unable to find metadata to parse GlideModules", (Throwable)ex);
                                            }
                                        }
                                    }
                                    catch (PackageManager$NameNotFoundException ex2) {}
                                }
                                catch (PackageManager$NameNotFoundException ex3) {}
                            }
                            catch (PackageManager$NameNotFoundException ex4) {}
                        }
                        catch (PackageManager$NameNotFoundException ex5) {}
                    }
                    catch (PackageManager$NameNotFoundException ex6) {}
                }
                catch (PackageManager$NameNotFoundException ex7) {}
            }
            catch (PackageManager$NameNotFoundException ex8) {}
        }
        catch (PackageManager$NameNotFoundException ex9) {}
    }
}
