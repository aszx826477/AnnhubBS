// 
// Decompiled by Procyon v0.5.30
// 

package org.litepal;

import org.litepal.exceptions.GlobalException;
import android.content.Context;
import android.app.Application;

public class LitePalApplication extends Application
{
    private static Context sContext;
    
    public LitePalApplication() {
        LitePalApplication.sContext = (Context)this;
    }
    
    public static Context getContext() {
        final Context sContext = LitePalApplication.sContext;
        if (sContext != null) {
            return sContext;
        }
        throw new GlobalException("Application context is null. Maybe you haven't configured your application name with \"org.litepal.LitePalApplication\" in your AndroidManifest.xml. Or you can call LitePalApplication.initialize(Context) method instead.");
    }
    
    public static void initialize(final Context sContext) {
        LitePalApplication.sContext = sContext;
    }
}
