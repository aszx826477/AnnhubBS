// 
// Decompiled by Procyon v0.5.30
// 

package org.litepal.exceptions;

public class GlobalException extends RuntimeException
{
    public static final String APPLICATION_CONTEXT_IS_NULL = "Application context is null. Maybe you haven't configured your application name with \"org.litepal.LitePalApplication\" in your AndroidManifest.xml. Or you can call LitePalApplication.initialize(Context) method instead.";
    private static final long serialVersionUID = 1L;
    
    public GlobalException(final String s) {
        super(s);
    }
}
