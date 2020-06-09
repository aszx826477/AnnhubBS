// 
// Decompiled by Procyon v0.5.30
// 

package com.baidu.location.a;

import android.database.sqlite.SQLiteDatabase$CursorFactory;
import java.io.File;
import com.baidu.location.b.g;
import com.baidu.location.b.b;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.content.ContentValues;
import org.json.JSONObject;
import com.baidu.location.Jni;
import com.baidu.location.d.j;
import java.util.HashMap;
import com.baidu.location.d.e;

class h$a extends e
{
    final /* synthetic */ h a;
    private String b;
    private String c;
    private boolean d;
    private boolean e;
    
    h$a(final h a) {
        this.a = a;
        this.b = null;
        this.c = null;
        this.d = true;
        this.e = false;
        this.k = new HashMap();
    }
    
    public void a() {
        this.i = 1;
        this.h = com.baidu.location.d.j.c();
        final String encodeTp4 = Jni.encodeTp4(this.c);
        this.c = null;
        this.k.put("bloc", encodeTp4);
    }
    
    public void a(String f, final String c) {
        if (!this.a.g) {
            this.a.g = true;
            this.b = f;
            this.c = c;
            f = com.baidu.location.d.j.f;
            this.b(f);
        }
    }
    
    public void a(boolean int1) {
        Label_0470: {
            if (int1 && this.j != null) {
                try {
                    final String j = this.j;
                    try {
                        if (!this.d) {
                            break Label_0470;
                        }
                        final JSONObject jsonObject = new JSONObject(j);
                        JSONObject jsonObject2;
                        if (jsonObject.has("content")) {
                            jsonObject2 = jsonObject.getJSONObject("content");
                        }
                        else {
                            jsonObject2 = null;
                        }
                        if (jsonObject2 == null || !jsonObject2.has("imo")) {
                            break Label_0470;
                        }
                        final String string = jsonObject2.getJSONObject("imo").getString("mac");
                        try {
                            final Long value = Long.valueOf(string);
                            int1 = jsonObject2.getJSONObject("imo").getInt("mv");
                            try {
                                final String b = this.b;
                                try {
                                    final Long encode3 = Jni.encode3(b);
                                    try {
                                        final long longValue = encode3;
                                        try {
                                            if (longValue != value) {
                                                break Label_0470;
                                            }
                                            try {
                                                final ContentValues contentValues = new ContentValues();
                                                contentValues.put("tt", (int)(System.currentTimeMillis() / 1000L));
                                                contentValues.put("hst", int1);
                                                Label_0386: {
                                                    try {
                                                        final h a = this.a;
                                                        try {
                                                            final SQLiteDatabase a2 = a.f;
                                                            final String s = "hstdata";
                                                            try {
                                                                final StringBuilder sb = new StringBuilder();
                                                                sb.append("id = \"");
                                                                final StringBuilder sb2 = sb;
                                                                try {
                                                                    sb2.append(value);
                                                                    sb.append("\"");
                                                                    if (a2.update(s, contentValues, sb.toString(), (String[])null) > 0) {
                                                                        break Label_0386;
                                                                    }
                                                                    contentValues.put("id", value);
                                                                    final h a3 = this.a;
                                                                    try {
                                                                        a3.f.insert("hstdata", (String)null, contentValues);
                                                                    }
                                                                    catch (Exception ex) {}
                                                                }
                                                                catch (Exception ex2) {}
                                                            }
                                                            catch (Exception ex3) {}
                                                        }
                                                        catch (Exception ex4) {}
                                                    }
                                                    catch (Exception ex5) {}
                                                }
                                                try {
                                                    final Bundle bundle = new Bundle();
                                                    final String s2 = "mac";
                                                    final String b2 = this.b;
                                                    try {
                                                        bundle.putByteArray(s2, b2.getBytes());
                                                        bundle.putInt("hotspot", int1);
                                                        this.a.a(bundle);
                                                        break Label_0470;
                                                    }
                                                    catch (Exception ex6) {
                                                        break Label_0470;
                                                    }
                                                }
                                                catch (Exception ex7) {}
                                            }
                                            catch (Exception ex8) {}
                                        }
                                        catch (Exception ex9) {}
                                    }
                                    catch (Exception ex10) {}
                                }
                                catch (Exception ex11) {}
                            }
                            catch (Exception ex12) {}
                        }
                        catch (Exception ex13) {}
                    }
                    catch (Exception ex14) {}
                }
                catch (Exception ex15) {}
            }
            if (this.d) {
                this.a.f();
            }
        }
        if (this.k != null) {
            this.k.clear();
        }
        this.a.g = false;
    }
}
