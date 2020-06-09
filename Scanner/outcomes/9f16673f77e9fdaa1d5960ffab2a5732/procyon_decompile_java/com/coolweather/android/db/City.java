// 
// Decompiled by Procyon v0.5.30
// 

package com.coolweather.android.db;

import org.litepal.crud.DataSupport;

public class City extends DataSupport
{
    private int cityCode;
    private String cityName;
    private int id;
    private int provinceId;
    
    public int getCityCode() {
        return this.cityCode;
    }
    
    public String getCityName() {
        return this.cityName;
    }
    
    public int getId() {
        return this.id;
    }
    
    public int getProvinceId() {
        return this.provinceId;
    }
    
    public void setCityCode(final int cityCode) {
        this.cityCode = cityCode;
    }
    
    public void setCityName(final String cityName) {
        this.cityName = cityName;
    }
    
    public void setId(final int id) {
        this.id = id;
    }
    
    public void setProvinceId(final int provinceId) {
        this.provinceId = provinceId;
    }
}
