.class Landroid/support/v7/app/TwilightManager;
.super Ljava/lang/Object;
.source "TwilightManager.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroid/support/v7/app/TwilightManager$TwilightState;
    }
.end annotation


# static fields
.field private static final SUNRISE:I = 0x6

.field private static final SUNSET:I = 0x16

.field private static final TAG:Ljava/lang/String; = "TwilightManager"

.field private static sInstance:Landroid/support/v7/app/TwilightManager;


# instance fields
.field private final mContext:Landroid/content/Context;

.field private final mLocationManager:Landroid/location/LocationManager;

.field private final mTwilightState:Landroid/support/v7/app/TwilightManager$TwilightState;


# direct methods
.method constructor <init>(Landroid/content/Context;Landroid/location/LocationManager;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
        .annotation build Landroid/support/annotation/NonNull;
        .end annotation
    .end param
    .param p2, "locationManager"    # Landroid/location/LocationManager;
        .annotation build Landroid/support/annotation/NonNull;
        .end annotation
    .end param
    .annotation build Landroid/support/annotation/VisibleForTesting;
    .end annotation

    .line 63
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 60
    new-instance v0, Landroid/support/v7/app/TwilightManager$TwilightState;

    invoke-direct {v0}, Landroid/support/v7/app/TwilightManager$TwilightState;-><init>()V

    iput-object v0, p0, Landroid/support/v7/app/TwilightManager;->mTwilightState:Landroid/support/v7/app/TwilightManager$TwilightState;

    .line 64
    iput-object p1, p0, Landroid/support/v7/app/TwilightManager;->mContext:Landroid/content/Context;

    .line 65
    iput-object p2, p0, Landroid/support/v7/app/TwilightManager;->mLocationManager:Landroid/location/LocationManager;

    .line 66
    return-void
.end method

.method static getInstance(Landroid/content/Context;)Landroid/support/v7/app/TwilightManager;
    .locals 2
    .param p0, "context"    # Landroid/content/Context;
        .annotation build Landroid/support/annotation/NonNull;
        .end annotation
    .end param

    .line 44
    sget-object v0, Landroid/support/v7/app/TwilightManager;->sInstance:Landroid/support/v7/app/TwilightManager;

    if-nez v0, :cond_0

    .line 45
    invoke-virtual {p0}, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;

    move-result-object p0

    .line 46
    new-instance v0, Landroid/support/v7/app/TwilightManager;

    const-string v1, "location"

    .line 47
    invoke-virtual {p0, v1}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/location/LocationManager;

    invoke-direct {v0, p0, v1}, Landroid/support/v7/app/TwilightManager;-><init>(Landroid/content/Context;Landroid/location/LocationManager;)V

    sput-object v0, Landroid/support/v7/app/TwilightManager;->sInstance:Landroid/support/v7/app/TwilightManager;

    goto :goto_0

    .line 44
    :cond_0
    nop

    .line 49
    :goto_0
    sget-object v0, Landroid/support/v7/app/TwilightManager;->sInstance:Landroid/support/v7/app/TwilightManager;

    return-object v0
.end method

.method private getLastKnownLocation()Landroid/location/Location;
    .locals 8

    .line 100
    const/4 v0, 0x0

    .line 101
    .local v0, "coarseLoc":Landroid/location/Location;
    const/4 v1, 0x0

    .line 103
    .local v1, "fineLoc":Landroid/location/Location;
    iget-object v2, p0, Landroid/support/v7/app/TwilightManager;->mContext:Landroid/content/Context;

    const-string v3, "android.permission.ACCESS_COARSE_LOCATION"

    invoke-static {v2, v3}, Landroid/support/v4/content/PermissionChecker;->checkSelfPermission(Landroid/content/Context;Ljava/lang/String;)I

    move-result v2

    .line 105
    .local v2, "permission":I
    if-nez v2, :cond_0

    .line 106
    const-string v3, "network"

    invoke-direct {p0, v3}, Landroid/support/v7/app/TwilightManager;->getLastKnownLocationForProvider(Ljava/lang/String;)Landroid/location/Location;

    move-result-object v0

    goto :goto_0

    .line 105
    :cond_0
    nop

    .line 109
    :goto_0
    iget-object v3, p0, Landroid/support/v7/app/TwilightManager;->mContext:Landroid/content/Context;

    const-string v4, "android.permission.ACCESS_FINE_LOCATION"

    invoke-static {v3, v4}, Landroid/support/v4/content/PermissionChecker;->checkSelfPermission(Landroid/content/Context;Ljava/lang/String;)I

    move-result v2

    .line 111
    if-nez v2, :cond_1

    .line 112
    const-string v3, "gps"

    invoke-direct {p0, v3}, Landroid/support/v7/app/TwilightManager;->getLastKnownLocationForProvider(Ljava/lang/String;)Landroid/location/Location;

    move-result-object v1

    goto :goto_1

    .line 111
    :cond_1
    nop

    .line 115
    :goto_1
    if-eqz v1, :cond_3

    if-eqz v0, :cond_3

    .line 117
    invoke-virtual {v1}, Landroid/location/Location;->getTime()J

    move-result-wide v3

    invoke-virtual {v0}, Landroid/location/Location;->getTime()J

    move-result-wide v5

    cmp-long v7, v3, v5

    if-lez v7, :cond_2

    move-object v3, v1

    goto :goto_2

    :cond_2
    move-object v3, v0

    :goto_2
    return-object v3

    .line 115
    :cond_3
    nop

    .line 120
    if-eqz v1, :cond_4

    move-object v3, v1

    goto :goto_3

    :cond_4
    move-object v3, v0

    :goto_3
    return-object v3
.end method

.method private getLastKnownLocationForProvider(Ljava/lang/String;)Landroid/location/Location;
    .locals 3
    .param p1, "provider"    # Ljava/lang/String;

    .line 125
    iget-object v0, p0, Landroid/support/v7/app/TwilightManager;->mLocationManager:Landroid/location/LocationManager;

    if-eqz v0, :cond_1

    .line 127
    nop

    :try_start_0
    invoke-virtual {v0, p1}, Landroid/location/LocationManager;->isProviderEnabled(Ljava/lang/String;)Z

    move-result v0

    nop

    if-eqz v0, :cond_0

    .line 128
    nop

    iget-object v0, p0, Landroid/support/v7/app/TwilightManager;->mLocationManager:Landroid/location/LocationManager;

    nop

    invoke-virtual {v0, p1}, Landroid/location/LocationManager;->getLastKnownLocation(Ljava/lang/String;)Landroid/location/Location;

    move-result-object v0
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    nop

    return-object v0

    .line 132
    :cond_0
    nop

    goto :goto_0

    .line 130
    :catch_0
    move-exception v0

    nop

    .line 131
    .local v0, "e":Ljava/lang/Exception;
    nop

    const-string v1, "TwilightManager"

    const-string v2, "Failed to get last known location"

    invoke-static {v1, v2, v0}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    goto :goto_0

    .line 125
    .end local v0    # "e":Ljava/lang/Exception;
    :cond_1
    nop

    .line 134
    :goto_0
    nop

    const/4 v0, 0x0

    return-object v0
.end method

.method private isStateValid()Z
    .locals 5

    .line 138
    iget-object v0, p0, Landroid/support/v7/app/TwilightManager;->mTwilightState:Landroid/support/v7/app/TwilightManager$TwilightState;

    if-eqz v0, :cond_0

    iget-wide v0, v0, Landroid/support/v7/app/TwilightManager$TwilightState;->nextUpdate:J

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v2

    cmp-long v4, v0, v2

    if-lez v4, :cond_0

    const/4 v0, 0x1

    goto :goto_0

    :cond_0
    const/4 v0, 0x0

    :goto_0
    return v0
.end method

.method static setInstance(Landroid/support/v7/app/TwilightManager;)V
    .locals 0
    .param p0, "twilightManager"    # Landroid/support/v7/app/TwilightManager;
    .annotation build Landroid/support/annotation/VisibleForTesting;
    .end annotation

    .line 54
    sput-object p0, Landroid/support/v7/app/TwilightManager;->sInstance:Landroid/support/v7/app/TwilightManager;

    .line 55
    return-void
.end method

.method private updateState(Landroid/location/Location;)V
    .locals 22
    .param p1, "location"    # Landroid/location/Location;
        .annotation build Landroid/support/annotation/NonNull;
        .end annotation
    .end param

    .line 142
    move-object/from16 v0, p0

    iget-object v1, v0, Landroid/support/v7/app/TwilightManager;->mTwilightState:Landroid/support/v7/app/TwilightManager$TwilightState;

    .line 143
    .local v1, "state":Landroid/support/v7/app/TwilightManager$TwilightState;
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v9

    .line 144
    .local v9, "now":J
    invoke-static {}, Landroid/support/v7/app/TwilightCalculator;->getInstance()Landroid/support/v7/app/TwilightCalculator;

    move-result-object v11

    .line 147
    .local v11, "calculator":Landroid/support/v7/app/TwilightCalculator;
    const-wide/32 v12, 0x5265c00

    sub-long v3, v9, v12

    .line 148
    invoke-virtual/range {p1 .. p1}, Landroid/location/Location;->getLatitude()D

    move-result-wide v5

    invoke-virtual/range {p1 .. p1}, Landroid/location/Location;->getLongitude()D

    move-result-wide v7

    .line 147
    move-object v2, v11

    invoke-virtual/range {v2 .. v8}, Landroid/support/v7/app/TwilightCalculator;->calculateTwilight(JDD)V

    .line 149
    iget-wide v14, v11, Landroid/support/v7/app/TwilightCalculator;->sunset:J

    .line 152
    .local v14, "yesterdaySunset":J
    invoke-virtual/range {p1 .. p1}, Landroid/location/Location;->getLatitude()D

    move-result-wide v5

    invoke-virtual/range {p1 .. p1}, Landroid/location/Location;->getLongitude()D

    move-result-wide v7

    move-wide v3, v9

    invoke-virtual/range {v2 .. v8}, Landroid/support/v7/app/TwilightCalculator;->calculateTwilight(JDD)V

    .line 153
    iget v2, v11, Landroid/support/v7/app/TwilightCalculator;->state:I

    const/4 v3, 0x1

    if-ne v2, v3, :cond_0

    goto :goto_0

    :cond_0
    const/4 v3, 0x0

    :goto_0
    move v7, v3

    .line 154
    .local v7, "isNight":Z
    iget-wide v5, v11, Landroid/support/v7/app/TwilightCalculator;->sunrise:J

    .line 155
    .local v5, "todaySunrise":J
    iget-wide v3, v11, Landroid/support/v7/app/TwilightCalculator;->sunset:J

    .line 158
    .local v3, "todaySunset":J
    add-long/2addr v12, v9

    .line 159
    invoke-virtual/range {p1 .. p1}, Landroid/location/Location;->getLatitude()D

    move-result-wide v16

    invoke-virtual/range {p1 .. p1}, Landroid/location/Location;->getLongitude()D

    move-result-wide v18

    .line 158
    move-object v2, v11

    move-wide/from16 v20, v14

    move-wide v14, v3

    .end local v3    # "todaySunset":J
    .local v14, "todaySunset":J
    .local v20, "yesterdaySunset":J
    move-wide v3, v12

    move-wide v12, v5

    .end local v5    # "todaySunrise":J
    .local v12, "todaySunrise":J
    move-wide/from16 v5, v16

    move v0, v7

    .end local v7    # "isNight":Z
    .local v0, "isNight":Z
    move-wide/from16 v7, v18

    invoke-virtual/range {v2 .. v8}, Landroid/support/v7/app/TwilightCalculator;->calculateTwilight(JDD)V

    .line 160
    iget-wide v2, v11, Landroid/support/v7/app/TwilightCalculator;->sunrise:J

    .line 163
    .local v2, "tomorrowSunrise":J
    const-wide/16 v4, 0x0

    .line 164
    .local v4, "nextUpdate":J
    const-wide/16 v6, -0x1

    cmp-long v8, v12, v6

    if-eqz v8, :cond_4

    cmp-long v8, v14, v6

    if-nez v8, :cond_1

    goto :goto_2

    .line 168
    :cond_1
    cmp-long v6, v9, v14

    if-lez v6, :cond_2

    .line 169
    add-long/2addr v4, v2

    goto :goto_1

    .line 170
    :cond_2
    cmp-long v6, v9, v12

    if-lez v6, :cond_3

    .line 171
    add-long/2addr v4, v14

    goto :goto_1

    .line 173
    :cond_3
    add-long/2addr v4, v12

    .line 176
    :goto_1
    const-wide/32 v6, 0xea60

    add-long/2addr v4, v6

    goto :goto_3

    .line 164
    :cond_4
    :goto_2
    nop

    .line 166
    const-wide/32 v6, 0x2932e00

    add-long v4, v9, v6

    .line 180
    :goto_3
    iput-boolean v0, v1, Landroid/support/v7/app/TwilightManager$TwilightState;->isNight:Z

    .line 181
    move-wide/from16 v6, v20

    .end local v20    # "yesterdaySunset":J
    .local v6, "yesterdaySunset":J
    iput-wide v6, v1, Landroid/support/v7/app/TwilightManager$TwilightState;->yesterdaySunset:J

    .line 182
    iput-wide v12, v1, Landroid/support/v7/app/TwilightManager$TwilightState;->todaySunrise:J

    .line 183
    iput-wide v14, v1, Landroid/support/v7/app/TwilightManager$TwilightState;->todaySunset:J

    .line 184
    iput-wide v2, v1, Landroid/support/v7/app/TwilightManager$TwilightState;->tomorrowSunrise:J

    .line 185
    iput-wide v4, v1, Landroid/support/v7/app/TwilightManager$TwilightState;->nextUpdate:J

    .line 186
    return-void
.end method


# virtual methods
.method isNight()Z
    .locals 5

    .line 74
    iget-object v0, p0, Landroid/support/v7/app/TwilightManager;->mTwilightState:Landroid/support/v7/app/TwilightManager$TwilightState;

    .line 76
    .local v0, "state":Landroid/support/v7/app/TwilightManager$TwilightState;
    invoke-direct {p0}, Landroid/support/v7/app/TwilightManager;->isStateValid()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 78
    iget-boolean v1, v0, Landroid/support/v7/app/TwilightManager$TwilightState;->isNight:Z

    return v1

    .line 82
    :cond_0
    invoke-direct {p0}, Landroid/support/v7/app/TwilightManager;->getLastKnownLocation()Landroid/location/Location;

    move-result-object v1

    .line 83
    .local v1, "location":Landroid/location/Location;
    if-eqz v1, :cond_1

    .line 84
    invoke-direct {p0, v1}, Landroid/support/v7/app/TwilightManager;->updateState(Landroid/location/Location;)V

    .line 85
    iget-boolean v2, v0, Landroid/support/v7/app/TwilightManager$TwilightState;->isNight:Z

    return v2

    .line 88
    :cond_1
    const-string v2, "TwilightManager"

    const-string v3, "Could not get last known location. This is probably because the app does not have any location permissions. Falling back to hardcoded sunrise/sunset values."

    invoke-static {v2, v3}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 94
    invoke-static {}, Ljava/util/Calendar;->getInstance()Ljava/util/Calendar;

    move-result-object v2

    .line 95
    .local v2, "calendar":Ljava/util/Calendar;
    const/16 v3, 0xb

    invoke-virtual {v2, v3}, Ljava/util/Calendar;->get(I)I

    move-result v3

    .line 96
    .local v3, "hour":I
    const/4 v4, 0x6

    if-lt v3, v4, :cond_3

    const/16 v4, 0x16

    if-lt v3, v4, :cond_2

    goto :goto_0

    :cond_2
    const/4 v4, 0x0

    goto :goto_1

    :cond_3
    :goto_0
    const/4 v4, 0x1

    :goto_1
    return v4
.end method
