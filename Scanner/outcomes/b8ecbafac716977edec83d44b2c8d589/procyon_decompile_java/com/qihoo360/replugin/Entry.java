// 
// Decompiled by Procyon v0.5.30
// 

package com.qihoo360.replugin;

import android.os.IBinder;
import android.content.Context;

public class Entry
{
    static ClassLoader cl;
    static Context context;
    static Entry$Stub fakeBinder;
    static IBinder manager;
    static IBinder realEntryBinder;
    
    static {
        Entry.context = null;
        Entry.cl = null;
        Entry.manager = null;
        Entry.realEntryBinder = null;
        Entry.fakeBinder = null;
    }
    
    public static final IBinder create(final Context context, final ClassLoader cl, final IBinder manager) {
        Entry.context = context;
        Entry.cl = cl;
        Entry.manager = manager;
        return (IBinder)(Entry.fakeBinder = new Entry$Stub());
    }
    
    public static void init() {
        final String s = "com.qihoo360.replugin.Entry_Jiagu";
        try {
            if ((Entry.realEntryBinder = (IBinder)Class.forName(s).getDeclaredMethod("create", Context.class, ClassLoader.class, IBinder.class).invoke(null, Entry.context, Entry.cl, Entry.manager)) != null && Entry.fakeBinder != null) {
                Entry.fakeBinder.setRemote(Entry.realEntryBinder);
            }
        }
        finally {}
    }
}
