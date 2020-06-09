// 
// Decompiled by Procyon v0.5.30
// 

package com.google.gson.internal.bind;

import com.google.gson.stream.JsonWriter;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonReader;
import java.text.ParseException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.internal.bind.util.ISO8601Utils;
import java.text.ParsePosition;
import java.util.Date;
import java.util.Locale;
import java.text.DateFormat;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.TypeAdapter;

public final class DateTypeAdapter extends TypeAdapter
{
    public static final TypeAdapterFactory FACTORY;
    private final DateFormat enUsFormat;
    private final DateFormat localFormat;
    
    static {
        FACTORY = new DateTypeAdapter$1();
    }
    
    public DateTypeAdapter() {
        final Locale us = Locale.US;
        final int n = 2;
        this.enUsFormat = DateFormat.getDateTimeInstance(n, n, us);
        this.localFormat = DateFormat.getDateTimeInstance(n, n);
    }
    
    private Date deserializeToDate(final String s) {
        // monitorenter(this)
        try {
            try {
                // monitorexit(this)
                return this.localFormat.parse(s);
            }
            finally {}
        }
        catch (ParseException ex2) {
            try {
                // monitorexit(this)
                return this.enUsFormat.parse(s);
            }
            catch (ParseException ex3) {
                try {
                    final ParsePosition parsePosition = new ParsePosition(0);
                    final String s2 = s;
                    try {
                        // monitorexit(this)
                        return ISO8601Utils.parse(s2, parsePosition);
                    }
                    catch (ParseException ex) {
                        throw new JsonSyntaxException(s, ex);
                    }
                }
                catch (ParseException ex4) {}
            }
        }
    }
    // monitorexit(this)
    
    public Date read(final JsonReader jsonReader) {
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.nextNull();
            return null;
        }
        return this.deserializeToDate(jsonReader.nextString());
    }
    
    public void write(final JsonWriter jsonWriter, final Date date) {
        // monitorenter(this)
        Label_0014: {
            if (date != null) {
                break Label_0014;
            }
            try {
                jsonWriter.nullValue();
                return;
                jsonWriter.value(this.enUsFormat.format(date));
            }
            finally {
            }
            // monitorexit(this)
        }
    }
}
