// 
// Decompiled by Procyon v0.5.30
// 

package org.litepal.tablemanager;

import org.litepal.util.SharedUtil;
import android.database.sqlite.SQLiteDatabase;
import org.litepal.LitePalApplication;
import android.database.sqlite.SQLiteDatabase$CursorFactory;
import android.content.Context;
import android.database.sqlite.SQLiteOpenHelper;

class LitePalOpenHelper extends SQLiteOpenHelper
{
    public static final String TAG = "LitePalHelper";
    
    LitePalOpenHelper(final Context context, final String s, final SQLiteDatabase$CursorFactory sqLiteDatabase$CursorFactory, final int n) {
        super(context, s, sqLiteDatabase$CursorFactory, n);
    }
    
    LitePalOpenHelper(final String s, final int n) {
        this(LitePalApplication.getContext(), s, null, n);
    }
    
    public void onCreate(final SQLiteDatabase sqLiteDatabase) {
        Generator.create(sqLiteDatabase);
    }
    
    public void onUpgrade(final SQLiteDatabase sqLiteDatabase, final int n, final int n2) {
        Generator.upgrade(sqLiteDatabase);
        SharedUtil.updateVersion(n2);
    }
}
