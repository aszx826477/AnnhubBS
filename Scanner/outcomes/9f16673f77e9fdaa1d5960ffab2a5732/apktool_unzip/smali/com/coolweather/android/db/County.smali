.class public Lcom/coolweather/android/db/County;
.super Lorg/litepal/crud/DataSupport;
.source "County.java"


# instance fields
.field private cityId:I

.field private countyName:Ljava/lang/String;

.field private id:I

.field private weatherId:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 5
    invoke-direct {p0}, Lorg/litepal/crud/DataSupport;-><init>()V

    return-void
.end method


# virtual methods
.method public getCityId()I
    .locals 1

    .line 40
    iget v0, p0, Lcom/coolweather/android/db/County;->cityId:I

    return v0
.end method

.method public getCountyName()Ljava/lang/String;
    .locals 1

    .line 24
    iget-object v0, p0, Lcom/coolweather/android/db/County;->countyName:Ljava/lang/String;

    return-object v0
.end method

.method public getId()I
    .locals 1

    .line 16
    iget v0, p0, Lcom/coolweather/android/db/County;->id:I

    return v0
.end method

.method public getWeatherId()Ljava/lang/String;
    .locals 1

    .line 32
    iget-object v0, p0, Lcom/coolweather/android/db/County;->weatherId:Ljava/lang/String;

    return-object v0
.end method

.method public setCityId(I)V
    .locals 0
    .param p1, "cityId"    # I

    .line 44
    iput p1, p0, Lcom/coolweather/android/db/County;->cityId:I

    .line 45
    return-void
.end method

.method public setCountyName(Ljava/lang/String;)V
    .locals 0
    .param p1, "countyName"    # Ljava/lang/String;

    .line 28
    iput-object p1, p0, Lcom/coolweather/android/db/County;->countyName:Ljava/lang/String;

    .line 29
    return-void
.end method

.method public setId(I)V
    .locals 0
    .param p1, "id"    # I

    .line 20
    iput p1, p0, Lcom/coolweather/android/db/County;->id:I

    .line 21
    return-void
.end method

.method public setWeatherId(Ljava/lang/String;)V
    .locals 0
    .param p1, "weatherId"    # Ljava/lang/String;

    .line 36
    iput-object p1, p0, Lcom/coolweather/android/db/County;->weatherId:Ljava/lang/String;

    .line 37
    return-void
.end method
