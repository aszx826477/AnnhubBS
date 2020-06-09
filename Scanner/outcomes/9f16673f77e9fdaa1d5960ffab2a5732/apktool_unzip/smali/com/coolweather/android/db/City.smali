.class public Lcom/coolweather/android/db/City;
.super Lorg/litepal/crud/DataSupport;
.source "City.java"


# instance fields
.field private cityCode:I

.field private cityName:Ljava/lang/String;

.field private id:I

.field private provinceId:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 5
    invoke-direct {p0}, Lorg/litepal/crud/DataSupport;-><init>()V

    return-void
.end method


# virtual methods
.method public getCityCode()I
    .locals 1

    .line 32
    iget v0, p0, Lcom/coolweather/android/db/City;->cityCode:I

    return v0
.end method

.method public getCityName()Ljava/lang/String;
    .locals 1

    .line 24
    iget-object v0, p0, Lcom/coolweather/android/db/City;->cityName:Ljava/lang/String;

    return-object v0
.end method

.method public getId()I
    .locals 1

    .line 16
    iget v0, p0, Lcom/coolweather/android/db/City;->id:I

    return v0
.end method

.method public getProvinceId()I
    .locals 1

    .line 40
    iget v0, p0, Lcom/coolweather/android/db/City;->provinceId:I

    return v0
.end method

.method public setCityCode(I)V
    .locals 0
    .param p1, "cityCode"    # I

    .line 36
    iput p1, p0, Lcom/coolweather/android/db/City;->cityCode:I

    .line 37
    return-void
.end method

.method public setCityName(Ljava/lang/String;)V
    .locals 0
    .param p1, "cityName"    # Ljava/lang/String;

    .line 28
    iput-object p1, p0, Lcom/coolweather/android/db/City;->cityName:Ljava/lang/String;

    .line 29
    return-void
.end method

.method public setId(I)V
    .locals 0
    .param p1, "id"    # I

    .line 20
    iput p1, p0, Lcom/coolweather/android/db/City;->id:I

    .line 21
    return-void
.end method

.method public setProvinceId(I)V
    .locals 0
    .param p1, "provinceId"    # I

    .line 44
    iput p1, p0, Lcom/coolweather/android/db/City;->provinceId:I

    .line 45
    return-void
.end method
