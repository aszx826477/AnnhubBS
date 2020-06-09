.class public Lcom/coolweather/android/db/Province;
.super Lorg/litepal/crud/DataSupport;
.source "Province.java"


# instance fields
.field private id:I

.field private provinceCode:I

.field private provinceName:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 5
    invoke-direct {p0}, Lorg/litepal/crud/DataSupport;-><init>()V

    return-void
.end method


# virtual methods
.method public getId()I
    .locals 1

    .line 14
    iget v0, p0, Lcom/coolweather/android/db/Province;->id:I

    return v0
.end method

.method public getProvinceCode()I
    .locals 1

    .line 30
    iget v0, p0, Lcom/coolweather/android/db/Province;->provinceCode:I

    return v0
.end method

.method public getProvinceName()Ljava/lang/String;
    .locals 1

    .line 22
    iget-object v0, p0, Lcom/coolweather/android/db/Province;->provinceName:Ljava/lang/String;

    return-object v0
.end method

.method public setId(I)V
    .locals 0
    .param p1, "id"    # I

    .line 18
    iput p1, p0, Lcom/coolweather/android/db/Province;->id:I

    .line 19
    return-void
.end method

.method public setProvinceCode(I)V
    .locals 0
    .param p1, "provinceCode"    # I

    .line 34
    iput p1, p0, Lcom/coolweather/android/db/Province;->provinceCode:I

    .line 35
    return-void
.end method

.method public setProvinceName(Ljava/lang/String;)V
    .locals 0
    .param p1, "provinceName"    # Ljava/lang/String;

    .line 26
    iput-object p1, p0, Lcom/coolweather/android/db/Province;->provinceName:Ljava/lang/String;

    .line 27
    return-void
.end method
