// 
// Decompiled by Procyon v0.5.30
// 

package com.google.gson;

public class JsonParseException extends RuntimeException
{
    static final long serialVersionUID = -4086729973971783390L;
    
    public JsonParseException(final String s) {
        super(s);
    }
    
    public JsonParseException(final String s, final Throwable t) {
        super(s, t);
    }
    
    public JsonParseException(final Throwable t) {
        super(t);
    }
}
