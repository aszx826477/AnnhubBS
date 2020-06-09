// 
// Decompiled by Procyon v0.5.30
// 

package com.google.gson.internal.bind;

import com.google.gson.stream.JsonWriter;
import java.text.ParseException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.stream.JsonToken;
import java.sql.Date;
import com.google.gson.stream.JsonReader;
import java.text.SimpleDateFormat;
import java.text.DateFormat;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.TypeAdapter;

public final class SqlDateTypeAdapter extends TypeAdapter
{
    public static final TypeAdapterFactory FACTORY;
    private final DateFormat format;
    
    static {
        FACTORY = new SqlDateTypeAdapter$1();
    }
    
    public SqlDateTypeAdapter() {
        this.format = new SimpleDateFormat("MMM d, yyyy");
    }
    
    public Date read(final JsonReader jsonReader) {
        // monitorenter(this)
        try {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            try {
                final DateFormat format = this.format;
                try {
                    final java.util.Date parse = format.parse(jsonReader.nextString());
                    try {
                        final long time = parse.getTime();
                        try {
                            return new Date(time);
                        }
                        catch (ParseException ex) {
                            throw new JsonSyntaxException(ex);
                        }
                    }
                    catch (ParseException ex2) {}
                }
                catch (ParseException ex3) {}
                finally {
                }
                // monitorexit(this)
            }
            catch (ParseException ex4) {}
        }
        finally {}
    }
    
    public void write(final JsonWriter jsonWriter, final Date date) {
        // monitorenter(this)
        Label_0022: {
            if (date == null) {
                final String format = null;
                break Label_0022;
            }
            try {
                final String format = this.format.format(date);
                jsonWriter.value(format);
            }
            finally {
            }
            // monitorexit(this)
        }
    }
}
