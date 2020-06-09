// 
// Decompiled by Procyon v0.5.30
// 

package com.coolweather.android.db;

import org.litepal.crud.DataSupport;

public class County extends DataSupport
{
    private int cityId;
    private String countyName;
    private int id;
    private String weatherId;
    
    public int getCityId() {
        return this.cityId;
    }
    
    public String getCountyName() {
        return this.countyName;
    }
    
    public int getId() {
        return this.id;
    }
    
    public String getWeatherId() {
        return this.weatherId;
    }
    
    public void setCityId(final int cityId) {
        this.cityId = cityId;
    }
    
    public void setCountyName(final String countyName) {
        this.countyName = countyName;
    }
    
    public void setId(final int id) {
        this.id = id;
    }
    
    public void setWeatherId(final String weatherId) {
        this.weatherId = weatherId;
    }
}
