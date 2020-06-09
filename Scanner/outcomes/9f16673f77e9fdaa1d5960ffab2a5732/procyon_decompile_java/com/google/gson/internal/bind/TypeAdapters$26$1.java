// 
// Decompiled by Procyon v0.5.30
// 

package com.google.gson.internal.bind;

import com.google.gson.stream.JsonWriter;
import java.util.Date;
import java.sql.Timestamp;
import com.google.gson.stream.JsonReader;
import com.google.gson.TypeAdapter;

class TypeAdapters$26$1 extends TypeAdapter
{
    final /* synthetic */ TypeAdapters$26 this$0;
    final /* synthetic */ TypeAdapter val$dateTypeAdapter;
    
    TypeAdapters$26$1(final TypeAdapters$26 this$0, final TypeAdapter val$dateTypeAdapter) {
        this.this$0 = this$0;
        this.val$dateTypeAdapter = val$dateTypeAdapter;
    }
    
    public Timestamp read(final JsonReader jsonReader) {
        final Date date = (Date)this.val$dateTypeAdapter.read(jsonReader);
        Timestamp timestamp;
        if (date != null) {
            timestamp = new Timestamp(date.getTime());
        }
        else {
            timestamp = null;
        }
        return timestamp;
    }
    
    public void write(final JsonWriter jsonWriter, final Timestamp timestamp) {
        this.val$dateTypeAdapter.write(jsonWriter, timestamp);
    }
}
