// 
// Decompiled by Procyon v0.5.30
// 

package com.baidu.location;

import android.text.TextUtils;

public final class LocationClientOption
{
    public static final int GpsFirst = 1;
    public static final int GpsOnly = 3;
    public static final int LOC_SENSITIVITY_HIGHT = 1;
    public static final int LOC_SENSITIVITY_LOW = 3;
    public static final int LOC_SENSITIVITY_MIDDLE = 2;
    public static final int MIN_AUTO_NOTIFY_INTERVAL = 10000;
    public static final int MIN_SCAN_SPAN = 1000;
    public static final int NetWorkFirst = 2;
    protected LocationClientOption$LocationMode a;
    public String addrType;
    public float autoNotifyLocSensitivity;
    public int autoNotifyMaxInterval;
    public int autoNotifyMinDistance;
    public int autoNotifyMinTimeInterval;
    public String coorType;
    public boolean disableLocCache;
    public boolean enableSimulateGps;
    public boolean isIgnoreCacheException;
    public boolean isIgnoreKillProcess;
    public boolean isNeedAltitude;
    public boolean isNeedAptag;
    public boolean isNeedAptagd;
    public boolean isNeedPoiRegion;
    public boolean isNeedRegular;
    public boolean location_change_notify;
    public boolean mIsNeedDeviceDirect;
    public boolean openGps;
    public int priority;
    public String prodName;
    public int scanSpan;
    public String serviceName;
    public int timeOut;
    public int wifiCacheTimeOut;
    
    public LocationClientOption() {
        this.coorType = "gcj02";
        this.addrType = "detail";
        this.openGps = false;
        this.scanSpan = 0;
        this.timeOut = 12000;
        this.prodName = "SDK6.0";
        final boolean isIgnoreKillProcess = true;
        this.priority = (isIgnoreKillProcess ? 1 : 0);
        this.location_change_notify = false;
        this.disableLocCache = isIgnoreKillProcess;
        this.enableSimulateGps = false;
        this.serviceName = "com.baidu.location.service_v2.9";
        this.isIgnoreCacheException = false;
        this.isIgnoreKillProcess = isIgnoreKillProcess;
        this.mIsNeedDeviceDirect = false;
        this.isNeedAptag = false;
        this.isNeedAptagd = false;
        this.isNeedPoiRegion = false;
        this.isNeedRegular = false;
        this.isNeedAltitude = false;
        this.autoNotifyMaxInterval = 0;
        this.autoNotifyLocSensitivity = 0.5f;
        this.autoNotifyMinTimeInterval = 0;
        this.autoNotifyMinDistance = 0;
        this.wifiCacheTimeOut = -1 >>> 1;
    }
    
    public LocationClientOption(final LocationClientOption locationClientOption) {
        this.coorType = "gcj02";
        this.addrType = "detail";
        this.openGps = false;
        this.scanSpan = 0;
        this.timeOut = 12000;
        this.prodName = "SDK6.0";
        final boolean isIgnoreKillProcess = true;
        this.priority = (isIgnoreKillProcess ? 1 : 0);
        this.location_change_notify = false;
        this.disableLocCache = isIgnoreKillProcess;
        this.enableSimulateGps = false;
        this.serviceName = "com.baidu.location.service_v2.9";
        this.isIgnoreCacheException = false;
        this.isIgnoreKillProcess = isIgnoreKillProcess;
        this.mIsNeedDeviceDirect = false;
        this.isNeedAptag = false;
        this.isNeedAptagd = false;
        this.isNeedPoiRegion = false;
        this.isNeedRegular = false;
        this.isNeedAltitude = false;
        this.autoNotifyMaxInterval = 0;
        this.autoNotifyLocSensitivity = 0.5f;
        this.autoNotifyMinTimeInterval = 0;
        this.autoNotifyMinDistance = 0;
        this.wifiCacheTimeOut = -1 >>> 1;
        this.coorType = locationClientOption.coorType;
        this.addrType = locationClientOption.addrType;
        this.openGps = locationClientOption.openGps;
        this.scanSpan = locationClientOption.scanSpan;
        this.timeOut = locationClientOption.timeOut;
        this.prodName = locationClientOption.prodName;
        this.priority = locationClientOption.priority;
        this.location_change_notify = locationClientOption.location_change_notify;
        this.serviceName = locationClientOption.serviceName;
        this.disableLocCache = locationClientOption.disableLocCache;
        this.isIgnoreCacheException = locationClientOption.isIgnoreCacheException;
        this.isIgnoreKillProcess = locationClientOption.isIgnoreKillProcess;
        this.enableSimulateGps = locationClientOption.enableSimulateGps;
        this.a = locationClientOption.a;
        this.isNeedAptag = locationClientOption.isNeedAptag;
        this.isNeedAptagd = locationClientOption.isNeedAptagd;
        this.isNeedPoiRegion = locationClientOption.isNeedPoiRegion;
        this.isNeedRegular = locationClientOption.isNeedRegular;
        this.mIsNeedDeviceDirect = locationClientOption.mIsNeedDeviceDirect;
        this.isNeedAltitude = locationClientOption.isNeedAltitude;
        this.autoNotifyMaxInterval = locationClientOption.autoNotifyMaxInterval;
        this.autoNotifyLocSensitivity = locationClientOption.autoNotifyLocSensitivity;
        this.autoNotifyMinTimeInterval = locationClientOption.autoNotifyMinTimeInterval;
        this.autoNotifyMinDistance = locationClientOption.autoNotifyMinDistance;
        this.wifiCacheTimeOut = locationClientOption.wifiCacheTimeOut;
    }
    
    public void SetIgnoreCacheException(final boolean isIgnoreCacheException) {
        this.isIgnoreCacheException = isIgnoreCacheException;
    }
    
    int a() {
        return this.autoNotifyMaxInterval;
    }
    
    float b() {
        return this.autoNotifyLocSensitivity;
    }
    
    public void disableCache(final boolean disableLocCache) {
        this.disableLocCache = disableLocCache;
    }
    
    public String getAddrType() {
        return this.addrType;
    }
    
    public int getAutoNotifyMinDistance() {
        return this.autoNotifyMinDistance;
    }
    
    public int getAutoNotifyMinTimeInterval() {
        return this.autoNotifyMinTimeInterval;
    }
    
    public String getCoorType() {
        return this.coorType;
    }
    
    public LocationClientOption$LocationMode getLocationMode() {
        return this.a;
    }
    
    public int getPriority() {
        return this.priority;
    }
    
    public String getProdName() {
        return this.prodName;
    }
    
    public int getScanSpan() {
        return this.scanSpan;
    }
    
    public String getServiceName() {
        return this.serviceName;
    }
    
    public int getTimeOut() {
        return this.timeOut;
    }
    
    public boolean isDisableCache() {
        return this.disableLocCache;
    }
    
    public boolean isLocationNotify() {
        return this.location_change_notify;
    }
    
    public boolean isOpenGps() {
        return this.openGps;
    }
    
    public boolean optionEquals(final LocationClientOption locationClientOption) {
        return this.coorType.equals(locationClientOption.coorType) && this.addrType.equals(locationClientOption.addrType) && this.openGps == locationClientOption.openGps && this.scanSpan == locationClientOption.scanSpan && this.timeOut == locationClientOption.timeOut && this.prodName.equals(locationClientOption.prodName) && this.location_change_notify == locationClientOption.location_change_notify && this.priority == locationClientOption.priority && this.disableLocCache == locationClientOption.disableLocCache && this.isIgnoreCacheException == locationClientOption.isIgnoreCacheException && this.isIgnoreKillProcess == locationClientOption.isIgnoreKillProcess && this.isNeedAptag == locationClientOption.isNeedAptag && this.isNeedAptagd == locationClientOption.isNeedAptagd && this.isNeedPoiRegion == locationClientOption.isNeedPoiRegion && this.isNeedRegular == locationClientOption.isNeedRegular && this.mIsNeedDeviceDirect == locationClientOption.mIsNeedDeviceDirect && this.autoNotifyMaxInterval == locationClientOption.autoNotifyMaxInterval && this.autoNotifyLocSensitivity == locationClientOption.autoNotifyLocSensitivity && this.autoNotifyMinTimeInterval == locationClientOption.autoNotifyMinTimeInterval && this.autoNotifyMinDistance == locationClientOption.autoNotifyMinDistance && this.wifiCacheTimeOut == locationClientOption.wifiCacheTimeOut && this.isNeedAltitude == locationClientOption.isNeedAltitude && this.a == locationClientOption.a;
    }
    
    public void setAddrType(final String s) {
        if (TextUtils.isEmpty((CharSequence)s)) {
            return;
        }
        this.setIsNeedAddress("all".equals(s));
    }
    
    public void setCoorType(String lowerCase) {
        lowerCase = lowerCase.toLowerCase();
        if (lowerCase.equals("gcj02") || lowerCase.equals("bd09") || lowerCase.equals("bd09ll")) {
            this.coorType = lowerCase;
        }
    }
    
    public void setEnableSimulateGps(final boolean enableSimulateGps) {
        this.enableSimulateGps = enableSimulateGps;
    }
    
    public void setIgnoreKillProcess(final boolean isIgnoreKillProcess) {
        this.isIgnoreKillProcess = isIgnoreKillProcess;
    }
    
    public void setIsNeedAddress(final boolean b) {
        String addrType;
        if (b) {
            addrType = "all";
        }
        else {
            addrType = "noaddr";
        }
        this.addrType = addrType;
    }
    
    public void setIsNeedAltitude(final boolean isNeedAltitude) {
        this.isNeedAltitude = isNeedAltitude;
    }
    
    public void setIsNeedLocationDescribe(final boolean isNeedAptag) {
        this.isNeedAptag = isNeedAptag;
    }
    
    public void setIsNeedLocationPoiList(final boolean isNeedAptagd) {
        this.isNeedAptagd = isNeedAptagd;
    }
    
    public void setLocationMode(final LocationClientOption$LocationMode a) {
        final int n = LocationClientOption$1.a[a.ordinal()];
        final boolean priority = true;
        switch (n) {
            default: {
                final StringBuilder sb = new StringBuilder();
                sb.append("Illegal this mode : ");
                sb.append(a);
                throw new IllegalArgumentException(sb.toString());
            }
            case 3: {
                this.priority = 3;
                this.openGps = priority;
                break;
            }
            case 2: {
                this.openGps = false;
                this.priority = 2;
                break;
            }
            case 1: {
                this.openGps = priority;
                this.priority = (priority ? 1 : 0);
                break;
            }
        }
        this.a = a;
    }
    
    public void setLocationNotify(final boolean location_change_notify) {
        this.location_change_notify = location_change_notify;
    }
    
    public void setNeedDeviceDirect(final boolean mIsNeedDeviceDirect) {
        this.mIsNeedDeviceDirect = mIsNeedDeviceDirect;
    }
    
    public void setOpenAutoNotifyMode() {
        this.setOpenAutoNotifyMode(0, 0, 1);
    }
    
    public void setOpenAutoNotifyMode(final int autoNotifyMinTimeInterval, final int autoNotifyMinDistance, int n) {
        int autoNotifyMaxInterval = 180000;
        if (autoNotifyMinTimeInterval > autoNotifyMaxInterval) {
            autoNotifyMaxInterval = autoNotifyMinTimeInterval + 1000;
        }
        final int n2 = 10000;
        if (autoNotifyMaxInterval >= n2) {
            float autoNotifyLocSensitivity = 0.0f;
            switch (n) {
                default: {
                    final StringBuilder sb = new StringBuilder();
                    sb.append("Illegal this locSensitivity : ");
                    sb.append(n);
                    throw new IllegalArgumentException(sb.toString());
                }
                case 3: {
                    n = 1036831949;
                    autoNotifyLocSensitivity = 0.1f;
                    break;
                }
                case 2: {
                    n = 1050253722;
                    autoNotifyLocSensitivity = 0.3f;
                    break;
                }
                case 1: {
                    n = 1056964608;
                    autoNotifyLocSensitivity = 0.5f;
                    break;
                }
            }
            this.autoNotifyLocSensitivity = autoNotifyLocSensitivity;
            this.autoNotifyMaxInterval = autoNotifyMaxInterval;
            this.autoNotifyMinTimeInterval = autoNotifyMinTimeInterval;
            this.autoNotifyMinDistance = autoNotifyMinDistance;
            return;
        }
        final StringBuilder sb2 = new StringBuilder();
        sb2.append("Illegal this maxLocInterval : ");
        sb2.append(autoNotifyMaxInterval);
        sb2.append(" , maxLocInterval must >= ");
        sb2.append(n2);
        throw new IllegalArgumentException(sb2.toString());
    }
    
    public void setOpenGps(final boolean openGps) {
        this.openGps = openGps;
    }
    
    public void setPriority(final int priority) {
        if (priority == 1 || priority == 2) {
            this.priority = priority;
        }
    }
    
    public void setProdName(String substring) {
        final int length = substring.length();
        final int n = 64;
        if (length > n) {
            substring = substring.substring(0, n);
        }
        this.prodName = substring;
    }
    
    public void setScanSpan(final int scanSpan) {
        this.scanSpan = scanSpan;
    }
    
    public void setSema(final boolean isNeedAptag, final boolean isNeedPoiRegion, final boolean isNeedRegular) {
        this.isNeedAptag = isNeedAptag;
        this.isNeedPoiRegion = isNeedPoiRegion;
        this.isNeedRegular = isNeedRegular;
    }
    
    public void setServiceName(final String serviceName) {
        this.serviceName = serviceName;
    }
    
    public void setTimeOut(final int timeOut) {
        this.timeOut = timeOut;
    }
    
    public void setWifiCacheTimeOut(final int wifiCacheTimeOut) {
        if (wifiCacheTimeOut >= 10000) {
            this.wifiCacheTimeOut = wifiCacheTimeOut;
        }
    }
}
