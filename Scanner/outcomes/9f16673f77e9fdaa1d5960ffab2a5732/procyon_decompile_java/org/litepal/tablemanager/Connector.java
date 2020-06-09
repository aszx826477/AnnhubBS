// 
// Decompiled by Procyon v0.5.30
// 

package org.litepal.tablemanager;

import android.database.sqlite.SQLiteDatabase;
import org.litepal.exceptions.InvalidAttributesException;
import org.litepal.LitePalApplication;
import org.litepal.parser.LitePalParser;
import org.litepal.parser.LitePalAttr;

public class Connector
{
    private static LitePalAttr mLitePalAttr;
    private static LitePalOpenHelper mLitePalHelper;
    
    private static LitePalOpenHelper buildConnection() {
        if (Connector.mLitePalAttr == null) {
            LitePalParser.parseLitePalConfiguration();
            Connector.mLitePalAttr = LitePalAttr.getInstance();
        }
        if (Connector.mLitePalAttr.checkSelfValid()) {
            if (Connector.mLitePalHelper == null) {
                String s = Connector.mLitePalAttr.getDbName();
                if ("external".equalsIgnoreCase(Connector.mLitePalAttr.getStorage())) {
                    final StringBuilder sb = new StringBuilder();
                    sb.append(LitePalApplication.getContext().getExternalFilesDir(""));
                    sb.append("/databases/");
                    sb.append(s);
                    s = sb.toString();
                }
                Connector.mLitePalHelper = new LitePalOpenHelper(s, Connector.mLitePalAttr.getVersion());
            }
            return Connector.mLitePalHelper;
        }
        throw new InvalidAttributesException("Uncaught invalid attributes exception happened");
    }
    
    public static SQLiteDatabase getDatabase() {
        return getWritableDatabase();
    }
    
    public static SQLiteDatabase getReadableDatabase() {
        synchronized (Connector.class) {
            return buildConnection().getReadableDatabase();
        }
    }
    
    public static SQLiteDatabase getWritableDatabase() {
        synchronized (Connector.class) {
            return buildConnection().getWritableDatabase();
        }
    }
}
