// 
// Decompiled by Procyon v0.5.30
// 

package com.google.gson.internal.bind;

import com.google.gson.stream.JsonWriter;
import java.util.Date;
import java.text.ParseException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.stream.JsonToken;
import java.sql.Time;
import com.google.gson.stream.JsonReader;
import java.text.SimpleDateFormat;
import java.text.DateFormat;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.TypeAdapter;

public final class TimeTypeAdapter extends TypeAdapter
{
    public static final TypeAdapterFactory FACTORY;
    private final DateFormat format;
    
    static {
        FACTORY = new TimeTypeAdapter$1();
    }
    
    public TimeTypeAdapter() {
        this.format = new SimpleDateFormat("hh:mm:ss a");
    }
    
    public Time read(final JsonReader jsonReader) {
        // monitorenter(this)
        try {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            try {
                final DateFormat format = this.format;
                try {
                    final Date parse = format.parse(jsonReader.nextString());
                    try {
                        try {
                            return new Time(parse.getTime());
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
    
    public void write(final JsonWriter jsonWriter, final Time time) {
        // monitorenter(this)
        Label_0022: {
            if (time == null) {
                final String format = null;
                break Label_0022;
            }
            try {
                final String format = this.format.format(time);
                jsonWriter.value(format);
            }
            finally {
            }
            // monitorexit(this)
        }
    }
}
