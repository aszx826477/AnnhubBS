// 
// Decompiled by Procyon v0.5.30
// 

package com.google.gson.internal;

import com.google.gson.stream.JsonWriter;
import com.google.gson.stream.JsonReader;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;

class Excluder$1 extends TypeAdapter
{
    private TypeAdapter delegate;
    final /* synthetic */ Excluder this$0;
    final /* synthetic */ Gson val$gson;
    final /* synthetic */ boolean val$skipDeserialize;
    final /* synthetic */ boolean val$skipSerialize;
    final /* synthetic */ TypeToken val$type;
    
    Excluder$1(final Excluder this$0, final boolean val$skipDeserialize, final boolean val$skipSerialize, final Gson val$gson, final TypeToken val$type) {
        this.this$0 = this$0;
        this.val$skipDeserialize = val$skipDeserialize;
        this.val$skipSerialize = val$skipSerialize;
        this.val$gson = val$gson;
        this.val$type = val$type;
    }
    
    private TypeAdapter delegate() {
        final TypeAdapter delegate = this.delegate;
        TypeAdapter delegateAdapter;
        if (delegate != null) {
            delegateAdapter = delegate;
        }
        else {
            delegateAdapter = this.val$gson.getDelegateAdapter(this.this$0, this.val$type);
            this.delegate = delegateAdapter;
        }
        return delegateAdapter;
    }
    
    public Object read(final JsonReader jsonReader) {
        if (this.val$skipDeserialize) {
            jsonReader.skipValue();
            return null;
        }
        return this.delegate().read(jsonReader);
    }
    
    public void write(final JsonWriter jsonWriter, final Object o) {
        if (this.val$skipSerialize) {
            jsonWriter.nullValue();
            return;
        }
        this.delegate().write(jsonWriter, o);
    }
}
