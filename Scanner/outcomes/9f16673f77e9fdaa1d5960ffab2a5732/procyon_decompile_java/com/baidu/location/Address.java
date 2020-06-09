// 
// Decompiled by Procyon v0.5.30
// 

package com.baidu.location;

public final class Address
{
    public final String adcode;
    public final String address;
    public final String city;
    public final String cityCode;
    public final String country;
    public final String countryCode;
    public final String district;
    public final String province;
    public final String street;
    public final String streetNumber;
    
    private Address(final Address$Builder address$Builder) {
        this.country = address$Builder.mCountry;
        this.countryCode = address$Builder.mCountryCode;
        this.province = address$Builder.mProvince;
        this.city = address$Builder.mCity;
        this.cityCode = address$Builder.mCityCode;
        this.district = address$Builder.mDistrict;
        this.street = address$Builder.mStreet;
        this.streetNumber = address$Builder.mStreetNumber;
        this.address = address$Builder.mAddress;
        this.adcode = address$Builder.mAdcode;
    }
}
