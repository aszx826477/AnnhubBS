// 
// Decompiled by Procyon v0.5.30
// 

package com.coolweather.android.db;

import org.litepal.crud.DataSupport;

public class Province extends DataSupport
{
    private int id;
    private int provinceCode;
    private String provinceName;
    
    public int getId() {
        return this.id;
    }
    
    public int getProvinceCode() {
        return this.provinceCode;
    }
    
    public String getProvinceName() {
        return this.provinceName;
    }
    
    public void setId(final int id) {
        this.id = id;
    }
    
    public void setProvinceCode(final int provinceCode) {
        this.provinceCode = provinceCode;
    }
    
    public void setProvinceName(final String provinceName) {
        this.provinceName = provinceName;
    }
}
