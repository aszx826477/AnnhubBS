// 
// Decompiled by Procyon v0.5.30
// 

package com.baidu.location;

public class Address$Builder
{
    private static final String BEI_JING = "\u5317\u4eac";
    private static final String CHONG_QIN = "\u91cd\u5e86";
    private static final String SHANG_HAI = "\u4e0a\u6d77";
    private static final String TIAN_JIN = "\u5929\u6d25";
    private String mAdcode;
    private String mAddress;
    private String mCity;
    private String mCityCode;
    private String mCountry;
    private String mCountryCode;
    private String mDistrict;
    private String mProvince;
    private String mStreet;
    private String mStreetNumber;
    
    public Address$Builder() {
        this.mCountry = null;
        this.mCountryCode = null;
        this.mProvince = null;
        this.mCity = null;
        this.mCityCode = null;
        this.mDistrict = null;
        this.mStreet = null;
        this.mStreetNumber = null;
        this.mAddress = null;
        this.mAdcode = null;
    }
    
    public Address$Builder adcode(final String mAdcode) {
        this.mAdcode = mAdcode;
        return this;
    }
    
    public Address build() {
        final StringBuffer sb = new StringBuffer();
        final String mCountry = this.mCountry;
        if (mCountry != null) {
            sb.append(mCountry);
        }
        final String mProvince = this.mProvince;
        if (mProvince != null) {
            sb.append(mProvince);
        }
        final String mProvince2 = this.mProvince;
        if (mProvince2 != null) {
            final String mCity = this.mCity;
            if (mCity != null && !mProvince2.equals(mCity)) {
                sb.append(this.mCity);
            }
        }
        String s = this.mDistrict;
        Label_0120: {
            if (s != null) {
                final String mCity2 = this.mCity;
                if (mCity2 != null) {
                    if (mCity2.equals(s)) {
                        break Label_0120;
                    }
                    s = this.mDistrict;
                }
                sb.append(s);
            }
        }
        final String mStreet = this.mStreet;
        if (mStreet != null) {
            sb.append(mStreet);
        }
        final String mStreetNumber = this.mStreetNumber;
        if (mStreetNumber != null) {
            sb.append(mStreetNumber);
        }
        if (sb.length() > 0) {
            this.mAddress = sb.toString();
        }
        return new Address(this, null);
    }
    
    public Address$Builder city(final String mCity) {
        this.mCity = mCity;
        return this;
    }
    
    public Address$Builder cityCode(final String mCityCode) {
        this.mCityCode = mCityCode;
        return this;
    }
    
    public Address$Builder country(final String mCountry) {
        this.mCountry = mCountry;
        return this;
    }
    
    public Address$Builder countryCode(final String mCountryCode) {
        this.mCountryCode = mCountryCode;
        return this;
    }
    
    public Address$Builder district(final String mDistrict) {
        this.mDistrict = mDistrict;
        return this;
    }
    
    public Address$Builder province(final String mProvince) {
        this.mProvince = mProvince;
        return this;
    }
    
    public Address$Builder street(final String mStreet) {
        this.mStreet = mStreet;
        return this;
    }
    
    public Address$Builder streetNumber(final String mStreetNumber) {
        this.mStreetNumber = mStreetNumber;
        return this;
    }
}
