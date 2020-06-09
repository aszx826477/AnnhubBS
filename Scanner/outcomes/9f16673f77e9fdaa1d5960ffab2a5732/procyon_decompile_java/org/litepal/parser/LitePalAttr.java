// 
// Decompiled by Procyon v0.5.30
// 

package org.litepal.parser;

import java.util.ArrayList;
import org.litepal.util.SharedUtil;
import org.litepal.exceptions.InvalidAttributesException;
import android.text.TextUtils;
import java.util.List;

public final class LitePalAttr
{
    private static LitePalAttr litePalAttr;
    private String cases;
    private List classNames;
    private String dbName;
    private String storage;
    private int version;
    
    public static LitePalAttr getInstance() {
        if (LitePalAttr.litePalAttr == null) {
            synchronized (LitePalAttr.class) {
                if (LitePalAttr.litePalAttr == null) {
                    LitePalAttr.litePalAttr = new LitePalAttr();
                }
            }
        }
        return LitePalAttr.litePalAttr;
    }
    
    void addClassName(final String s) {
        this.getClassNames().add(s);
    }
    
    public boolean checkSelfValid() {
        if (TextUtils.isEmpty((CharSequence)this.dbName)) {
            throw new InvalidAttributesException("dbname is empty or not defined in litepal.xml file");
        }
        if (!this.dbName.endsWith(".db")) {
            final StringBuilder sb = new StringBuilder();
            sb.append(this.dbName);
            sb.append(".db");
            this.dbName = sb.toString();
        }
        final int version = this.version;
        final int n = 1;
        if (version < n) {
            throw new InvalidAttributesException("the version of database can not be less than 1");
        }
        if (version >= SharedUtil.getLastVersion()) {
            if (TextUtils.isEmpty((CharSequence)this.cases)) {
                this.cases = "lower";
            }
            else if (!this.cases.equals("upper") && !this.cases.equals("lower")) {
                if (!this.cases.equals("keep")) {
                    final StringBuilder sb2 = new StringBuilder();
                    sb2.append(this.cases);
                    sb2.append(" is an invalid value for <cases></cases>");
                    throw new InvalidAttributesException(sb2.toString());
                }
            }
            return n != 0;
        }
        throw new InvalidAttributesException("the version in litepal.xml is earlier than the current version");
    }
    
    public String getCases() {
        return this.cases;
    }
    
    public List getClassNames() {
        final List classNames = this.classNames;
        if (classNames == null) {
            (this.classNames = new ArrayList()).add("org.litepal.model.Table_Schema");
        }
        else if (classNames.isEmpty()) {
            this.classNames.add("org.litepal.model.Table_Schema");
        }
        return this.classNames;
    }
    
    public String getDbName() {
        return this.dbName;
    }
    
    public String getStorage() {
        return this.storage;
    }
    
    public int getVersion() {
        return this.version;
    }
    
    void setCases(final String cases) {
        this.cases = cases;
    }
    
    void setDbName(final String dbName) {
        this.dbName = dbName;
    }
    
    void setStorage(final String storage) {
        this.storage = storage;
    }
    
    void setVersion(final int version) {
        this.version = version;
    }
}
