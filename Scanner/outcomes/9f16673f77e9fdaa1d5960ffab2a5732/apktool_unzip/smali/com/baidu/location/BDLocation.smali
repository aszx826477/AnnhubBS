.class public final Lcom/baidu/location/BDLocation;
.super Ljava/lang/Object;

# interfaces
.implements Landroid/os/Parcelable;


# static fields
.field public static final BDLOCATION_BD09LL_TO_GCJ02:Ljava/lang/String; = "bd09ll2gcj"

.field public static final BDLOCATION_BD09_TO_GCJ02:Ljava/lang/String; = "bd092gcj"

.field public static final BDLOCATION_GCJ02_TO_BD09:Ljava/lang/String; = "bd09"

.field public static final BDLOCATION_GCJ02_TO_BD09LL:Ljava/lang/String; = "bd09ll"

.field public static final BDLOCATION_WGS84_TO_GCJ02:Ljava/lang/String; = "gps2gcj"

.field public static final CREATOR:Landroid/os/Parcelable$Creator;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/os/Parcelable$Creator<",
            "Lcom/baidu/location/BDLocation;",
            ">;"
        }
    .end annotation
.end field

.field public static final GPS_ACCURACY_BAD:I = 0x3

.field public static final GPS_ACCURACY_GOOD:I = 0x1

.field public static final GPS_ACCURACY_MID:I = 0x2

.field public static final GPS_ACCURACY_UNKNOWN:I = 0x0

.field public static final GPS_RECTIFY_INDOOR:I = 0x1

.field public static final GPS_RECTIFY_NONE:I = 0x0

.field public static final GPS_RECTIFY_OUTDOOR:I = 0x2

.field public static final INDOOR_LOCATION_NEARBY_SURPPORT_TRUE:I = 0x2

.field public static final INDOOR_LOCATION_SOURCE_BLUETOOTH:I = 0x4

.field public static final INDOOR_LOCATION_SOURCE_MAGNETIC:I = 0x2

.field public static final INDOOR_LOCATION_SOURCE_SMALLCELLSTATION:I = 0x8

.field public static final INDOOR_LOCATION_SOURCE_UNKNOWN:I = 0x0

.field public static final INDOOR_LOCATION_SOURCE_WIFI:I = 0x1

.field public static final INDOOR_LOCATION_SURPPORT_FALSE:I = 0x0

.field public static final INDOOR_LOCATION_SURPPORT_TRUE:I = 0x1

.field public static final INDOOR_NETWORK_STATE_HIGH:I = 0x2

.field public static final INDOOR_NETWORK_STATE_LOW:I = 0x0

.field public static final INDOOR_NETWORK_STATE_MIDDLE:I = 0x1

.field public static final LOCATION_WHERE_IN_CN:I = 0x1

.field public static final LOCATION_WHERE_OUT_CN:I = 0x0

.field public static final LOCATION_WHERE_UNKNOW:I = 0x2

.field public static final OPERATORS_TYPE_MOBILE:I = 0x1

.field public static final OPERATORS_TYPE_TELECOMU:I = 0x3

.field public static final OPERATORS_TYPE_UNICOM:I = 0x2

.field public static final OPERATORS_TYPE_UNKONW:I = 0x0

.field public static final TypeCacheLocation:I = 0x41

.field public static final TypeCriteriaException:I = 0x3e

.field public static final TypeGpsLocation:I = 0x3d

.field public static final TypeNetWorkException:I = 0x3f

.field public static final TypeNetWorkLocation:I = 0xa1

.field public static final TypeNone:I = 0x0

.field public static final TypeOffLineLocation:I = 0x42

.field public static final TypeOffLineLocationFail:I = 0x43

.field public static final TypeOffLineLocationNetworkFail:I = 0x44

.field public static final TypeServerCheckKeyError:I = 0x1f9

.field public static final TypeServerDecryptError:I = 0xa2

.field public static final TypeServerError:I = 0xa7

.field public static final USER_INDDOR_TRUE:I = 0x1

.field public static final USER_INDOOR_FALSE:I = 0x0

.field public static final USER_INDOOR_UNKNOW:I = -0x1


# instance fields
.field private A:I

.field private B:Ljava/lang/String;

.field private C:I

.field private D:Ljava/lang/String;

.field private E:I

.field private F:I

.field private G:I

.field private H:I

.field private I:Ljava/lang/String;

.field private J:Ljava/lang/String;

.field private K:Ljava/lang/String;

.field private L:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List<",
            "Lcom/baidu/location/Poi;",
            ">;"
        }
    .end annotation
.end field

.field private M:Ljava/lang/String;

.field private N:Ljava/lang/String;

.field private O:Ljava/util/HashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashMap<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private P:I

.field private Q:I

.field private a:I

.field private b:Ljava/lang/String;

.field private c:D

.field private d:D

.field private e:Z

.field private f:D

.field private g:Z

.field private h:F

.field private i:Z

.field private j:F

.field private k:Z

.field private l:I

.field private m:F

.field private n:Ljava/lang/String;

.field private o:Z

.field private p:Ljava/lang/String;

.field private q:Ljava/lang/String;

.field private r:Ljava/lang/String;

.field private s:Ljava/lang/String;

.field private t:Z

.field private u:Lcom/baidu/location/Address;

.field private v:Ljava/lang/String;

.field private w:Ljava/lang/String;

.field private x:Ljava/lang/String;

.field private y:Z

.field private z:I


# direct methods
.method static constructor <clinit>()V
    .locals 1

    new-instance v0, Lcom/baidu/location/a;

    invoke-direct {v0}, Lcom/baidu/location/a;-><init>()V

    sput-object v0, Lcom/baidu/location/BDLocation;->CREATOR:Landroid/os/Parcelable$Creator;

    return-void
.end method

.method public constructor <init>()V
    .locals 4

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    const/4 v0, 0x0

    iput v0, p0, Lcom/baidu/location/BDLocation;->a:I

    const/4 v1, 0x0

    iput-object v1, p0, Lcom/baidu/location/BDLocation;->b:Ljava/lang/String;

    const-wide/16 v2, 0x1

    iput-wide v2, p0, Lcom/baidu/location/BDLocation;->c:D

    iput-wide v2, p0, Lcom/baidu/location/BDLocation;->d:D

    iput-boolean v0, p0, Lcom/baidu/location/BDLocation;->e:Z

    iput-wide v2, p0, Lcom/baidu/location/BDLocation;->f:D

    iput-boolean v0, p0, Lcom/baidu/location/BDLocation;->g:Z

    const/4 v2, 0x0

    iput v2, p0, Lcom/baidu/location/BDLocation;->h:F

    iput-boolean v0, p0, Lcom/baidu/location/BDLocation;->i:Z

    iput v2, p0, Lcom/baidu/location/BDLocation;->j:F

    iput-boolean v0, p0, Lcom/baidu/location/BDLocation;->k:Z

    const/4 v2, -0x1

    iput v2, p0, Lcom/baidu/location/BDLocation;->l:I

    const/high16 v3, -0x40800000    # -1.0f

    iput v3, p0, Lcom/baidu/location/BDLocation;->m:F

    iput-object v1, p0, Lcom/baidu/location/BDLocation;->n:Ljava/lang/String;

    iput-boolean v0, p0, Lcom/baidu/location/BDLocation;->o:Z

    iput-object v1, p0, Lcom/baidu/location/BDLocation;->p:Ljava/lang/String;

    iput-object v1, p0, Lcom/baidu/location/BDLocation;->q:Ljava/lang/String;

    iput-object v1, p0, Lcom/baidu/location/BDLocation;->r:Ljava/lang/String;

    iput-object v1, p0, Lcom/baidu/location/BDLocation;->s:Ljava/lang/String;

    iput-boolean v0, p0, Lcom/baidu/location/BDLocation;->t:Z

    new-instance v3, Lcom/baidu/location/Address$Builder;

    invoke-direct {v3}, Lcom/baidu/location/Address$Builder;-><init>()V

    invoke-virtual {v3}, Lcom/baidu/location/Address$Builder;->build()Lcom/baidu/location/Address;

    move-result-object v3

    iput-object v3, p0, Lcom/baidu/location/BDLocation;->u:Lcom/baidu/location/Address;

    iput-object v1, p0, Lcom/baidu/location/BDLocation;->v:Ljava/lang/String;

    iput-object v1, p0, Lcom/baidu/location/BDLocation;->w:Ljava/lang/String;

    iput-object v1, p0, Lcom/baidu/location/BDLocation;->x:Ljava/lang/String;

    iput-boolean v0, p0, Lcom/baidu/location/BDLocation;->y:Z

    iput v0, p0, Lcom/baidu/location/BDLocation;->z:I

    const/4 v3, 0x1

    iput v3, p0, Lcom/baidu/location/BDLocation;->A:I

    iput-object v1, p0, Lcom/baidu/location/BDLocation;->B:Ljava/lang/String;

    const-string v3, ""

    iput-object v3, p0, Lcom/baidu/location/BDLocation;->D:Ljava/lang/String;

    iput v2, p0, Lcom/baidu/location/BDLocation;->E:I

    iput v0, p0, Lcom/baidu/location/BDLocation;->F:I

    const/4 v2, 0x2

    iput v2, p0, Lcom/baidu/location/BDLocation;->G:I

    iput v0, p0, Lcom/baidu/location/BDLocation;->H:I

    iput-object v1, p0, Lcom/baidu/location/BDLocation;->I:Ljava/lang/String;

    iput-object v1, p0, Lcom/baidu/location/BDLocation;->J:Ljava/lang/String;

    iput-object v1, p0, Lcom/baidu/location/BDLocation;->K:Ljava/lang/String;

    iput-object v1, p0, Lcom/baidu/location/BDLocation;->L:Ljava/util/List;

    iput-object v1, p0, Lcom/baidu/location/BDLocation;->M:Ljava/lang/String;

    iput-object v1, p0, Lcom/baidu/location/BDLocation;->N:Ljava/lang/String;

    new-instance v1, Ljava/util/HashMap;

    invoke-direct {v1}, Ljava/util/HashMap;-><init>()V

    iput-object v1, p0, Lcom/baidu/location/BDLocation;->O:Ljava/util/HashMap;

    iput v0, p0, Lcom/baidu/location/BDLocation;->P:I

    iput v0, p0, Lcom/baidu/location/BDLocation;->Q:I

    return-void
.end method

.method private constructor <init>(Landroid/os/Parcel;)V
    .locals 14

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    const/4 v0, 0x0

    iput v0, p0, Lcom/baidu/location/BDLocation;->a:I

    const/4 v1, 0x0

    iput-object v1, p0, Lcom/baidu/location/BDLocation;->b:Ljava/lang/String;

    const-wide/16 v2, 0x1

    iput-wide v2, p0, Lcom/baidu/location/BDLocation;->c:D

    iput-wide v2, p0, Lcom/baidu/location/BDLocation;->d:D

    iput-boolean v0, p0, Lcom/baidu/location/BDLocation;->e:Z

    iput-wide v2, p0, Lcom/baidu/location/BDLocation;->f:D

    iput-boolean v0, p0, Lcom/baidu/location/BDLocation;->g:Z

    const/4 v2, 0x0

    iput v2, p0, Lcom/baidu/location/BDLocation;->h:F

    iput-boolean v0, p0, Lcom/baidu/location/BDLocation;->i:Z

    iput v2, p0, Lcom/baidu/location/BDLocation;->j:F

    iput-boolean v0, p0, Lcom/baidu/location/BDLocation;->k:Z

    const/4 v2, -0x1

    iput v2, p0, Lcom/baidu/location/BDLocation;->l:I

    const/high16 v3, -0x40800000    # -1.0f

    iput v3, p0, Lcom/baidu/location/BDLocation;->m:F

    iput-object v1, p0, Lcom/baidu/location/BDLocation;->n:Ljava/lang/String;

    iput-boolean v0, p0, Lcom/baidu/location/BDLocation;->o:Z

    iput-object v1, p0, Lcom/baidu/location/BDLocation;->p:Ljava/lang/String;

    iput-object v1, p0, Lcom/baidu/location/BDLocation;->q:Ljava/lang/String;

    iput-object v1, p0, Lcom/baidu/location/BDLocation;->r:Ljava/lang/String;

    iput-object v1, p0, Lcom/baidu/location/BDLocation;->s:Ljava/lang/String;

    iput-boolean v0, p0, Lcom/baidu/location/BDLocation;->t:Z

    new-instance v3, Lcom/baidu/location/Address$Builder;

    invoke-direct {v3}, Lcom/baidu/location/Address$Builder;-><init>()V

    invoke-virtual {v3}, Lcom/baidu/location/Address$Builder;->build()Lcom/baidu/location/Address;

    move-result-object v3

    iput-object v3, p0, Lcom/baidu/location/BDLocation;->u:Lcom/baidu/location/Address;

    iput-object v1, p0, Lcom/baidu/location/BDLocation;->v:Ljava/lang/String;

    iput-object v1, p0, Lcom/baidu/location/BDLocation;->w:Ljava/lang/String;

    iput-object v1, p0, Lcom/baidu/location/BDLocation;->x:Ljava/lang/String;

    iput-boolean v0, p0, Lcom/baidu/location/BDLocation;->y:Z

    iput v0, p0, Lcom/baidu/location/BDLocation;->z:I

    const/4 v3, 0x1

    iput v3, p0, Lcom/baidu/location/BDLocation;->A:I

    iput-object v1, p0, Lcom/baidu/location/BDLocation;->B:Ljava/lang/String;

    const-string v4, ""

    iput-object v4, p0, Lcom/baidu/location/BDLocation;->D:Ljava/lang/String;

    iput v2, p0, Lcom/baidu/location/BDLocation;->E:I

    iput v0, p0, Lcom/baidu/location/BDLocation;->F:I

    const/4 v2, 0x2

    iput v2, p0, Lcom/baidu/location/BDLocation;->G:I

    iput v0, p0, Lcom/baidu/location/BDLocation;->H:I

    iput-object v1, p0, Lcom/baidu/location/BDLocation;->I:Ljava/lang/String;

    iput-object v1, p0, Lcom/baidu/location/BDLocation;->J:Ljava/lang/String;

    iput-object v1, p0, Lcom/baidu/location/BDLocation;->K:Ljava/lang/String;

    iput-object v1, p0, Lcom/baidu/location/BDLocation;->L:Ljava/util/List;

    iput-object v1, p0, Lcom/baidu/location/BDLocation;->M:Ljava/lang/String;

    iput-object v1, p0, Lcom/baidu/location/BDLocation;->N:Ljava/lang/String;

    new-instance v4, Ljava/util/HashMap;

    invoke-direct {v4}, Ljava/util/HashMap;-><init>()V

    iput-object v4, p0, Lcom/baidu/location/BDLocation;->O:Ljava/util/HashMap;

    iput v0, p0, Lcom/baidu/location/BDLocation;->P:I

    iput v0, p0, Lcom/baidu/location/BDLocation;->Q:I

    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v4

    iput v4, p0, Lcom/baidu/location/BDLocation;->a:I

    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v4

    iput-object v4, p0, Lcom/baidu/location/BDLocation;->b:Ljava/lang/String;

    invoke-virtual {p1}, Landroid/os/Parcel;->readDouble()D

    move-result-wide v4

    iput-wide v4, p0, Lcom/baidu/location/BDLocation;->c:D

    invoke-virtual {p1}, Landroid/os/Parcel;->readDouble()D

    move-result-wide v4

    iput-wide v4, p0, Lcom/baidu/location/BDLocation;->d:D

    invoke-virtual {p1}, Landroid/os/Parcel;->readDouble()D

    move-result-wide v4

    iput-wide v4, p0, Lcom/baidu/location/BDLocation;->f:D

    invoke-virtual {p1}, Landroid/os/Parcel;->readFloat()F

    move-result v4

    iput v4, p0, Lcom/baidu/location/BDLocation;->h:F

    invoke-virtual {p1}, Landroid/os/Parcel;->readFloat()F

    move-result v4

    iput v4, p0, Lcom/baidu/location/BDLocation;->j:F

    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v4

    iput v4, p0, Lcom/baidu/location/BDLocation;->l:I

    invoke-virtual {p1}, Landroid/os/Parcel;->readFloat()F

    move-result v4

    iput v4, p0, Lcom/baidu/location/BDLocation;->m:F

    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v4

    iput-object v4, p0, Lcom/baidu/location/BDLocation;->v:Ljava/lang/String;

    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v4

    iput v4, p0, Lcom/baidu/location/BDLocation;->z:I

    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v4

    iput-object v4, p0, Lcom/baidu/location/BDLocation;->w:Ljava/lang/String;

    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v4

    iput-object v4, p0, Lcom/baidu/location/BDLocation;->x:Ljava/lang/String;

    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v4

    iput-object v4, p0, Lcom/baidu/location/BDLocation;->B:Ljava/lang/String;

    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v9

    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v10

    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v11

    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v12

    new-instance v13, Lcom/baidu/location/Address$Builder;

    invoke-direct {v13}, Lcom/baidu/location/Address$Builder;-><init>()V

    invoke-virtual {v13, v10}, Lcom/baidu/location/Address$Builder;->country(Ljava/lang/String;)Lcom/baidu/location/Address$Builder;

    move-result-object v10

    invoke-virtual {v10, v11}, Lcom/baidu/location/Address$Builder;->countryCode(Ljava/lang/String;)Lcom/baidu/location/Address$Builder;

    move-result-object v10

    invoke-virtual {v10, v4}, Lcom/baidu/location/Address$Builder;->province(Ljava/lang/String;)Lcom/baidu/location/Address$Builder;

    move-result-object v4

    invoke-virtual {v4, v5}, Lcom/baidu/location/Address$Builder;->city(Ljava/lang/String;)Lcom/baidu/location/Address$Builder;

    move-result-object v4

    invoke-virtual {v4, v9}, Lcom/baidu/location/Address$Builder;->cityCode(Ljava/lang/String;)Lcom/baidu/location/Address$Builder;

    move-result-object v4

    invoke-virtual {v4, v6}, Lcom/baidu/location/Address$Builder;->district(Ljava/lang/String;)Lcom/baidu/location/Address$Builder;

    move-result-object v4

    invoke-virtual {v4, v7}, Lcom/baidu/location/Address$Builder;->street(Ljava/lang/String;)Lcom/baidu/location/Address$Builder;

    move-result-object v4

    invoke-virtual {v4, v8}, Lcom/baidu/location/Address$Builder;->streetNumber(Ljava/lang/String;)Lcom/baidu/location/Address$Builder;

    move-result-object v4

    invoke-virtual {v4, v12}, Lcom/baidu/location/Address$Builder;->adcode(Ljava/lang/String;)Lcom/baidu/location/Address$Builder;

    move-result-object v4

    invoke-virtual {v4}, Lcom/baidu/location/Address$Builder;->build()Lcom/baidu/location/Address;

    move-result-object v4

    iput-object v4, p0, Lcom/baidu/location/BDLocation;->u:Lcom/baidu/location/Address;

    const/4 v4, 0x7

    new-array v4, v4, [Z

    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v5

    iput v5, p0, Lcom/baidu/location/BDLocation;->C:I

    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v5

    iput-object v5, p0, Lcom/baidu/location/BDLocation;->D:Ljava/lang/String;

    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v5

    iput-object v5, p0, Lcom/baidu/location/BDLocation;->q:Ljava/lang/String;

    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v5

    iput-object v5, p0, Lcom/baidu/location/BDLocation;->r:Ljava/lang/String;

    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v5

    iput-object v5, p0, Lcom/baidu/location/BDLocation;->s:Ljava/lang/String;

    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v5

    iput v5, p0, Lcom/baidu/location/BDLocation;->A:I

    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v5

    iput-object v5, p0, Lcom/baidu/location/BDLocation;->M:Ljava/lang/String;

    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v5

    iput v5, p0, Lcom/baidu/location/BDLocation;->E:I

    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v5

    iput v5, p0, Lcom/baidu/location/BDLocation;->F:I

    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v5

    iput v5, p0, Lcom/baidu/location/BDLocation;->G:I

    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v5

    iput v5, p0, Lcom/baidu/location/BDLocation;->H:I

    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v5

    iput-object v5, p0, Lcom/baidu/location/BDLocation;->I:Ljava/lang/String;

    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v5

    iput-object v5, p0, Lcom/baidu/location/BDLocation;->J:Ljava/lang/String;

    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v5

    iput-object v5, p0, Lcom/baidu/location/BDLocation;->K:Ljava/lang/String;

    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v5

    iput v5, p0, Lcom/baidu/location/BDLocation;->P:I

    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v5

    iput-object v5, p0, Lcom/baidu/location/BDLocation;->N:Ljava/lang/String;

    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v5

    iput v5, p0, Lcom/baidu/location/BDLocation;->Q:I

    :try_start_0
    invoke-virtual {p1, v4}, Landroid/os/Parcel;->readBooleanArray([Z)V

    aget-boolean v0, v4, v0

    iput-boolean v0, p0, Lcom/baidu/location/BDLocation;->e:Z

    aget-boolean v0, v4, v3

    iput-boolean v0, p0, Lcom/baidu/location/BDLocation;->g:Z

    aget-boolean v0, v4, v2

    iput-boolean v0, p0, Lcom/baidu/location/BDLocation;->i:Z

    const/4 v0, 0x3

    aget-boolean v0, v4, v0

    iput-boolean v0, p0, Lcom/baidu/location/BDLocation;->k:Z

    const/4 v0, 0x4

    aget-boolean v0, v4, v0

    iput-boolean v0, p0, Lcom/baidu/location/BDLocation;->o:Z

    const/4 v0, 0x5

    aget-boolean v0, v4, v0

    iput-boolean v0, p0, Lcom/baidu/location/BDLocation;->t:Z

    const/4 v0, 0x6

    aget-boolean v0, v4, v0

    iput-boolean v0, p0, Lcom/baidu/location/BDLocation;->y:Z
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    :catch_0
    move-exception v0

    :goto_0
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    const-class v2, Lcom/baidu/location/Poi;

    invoke-virtual {v2}, Ljava/lang/Class;->getClassLoader()Ljava/lang/ClassLoader;

    move-result-object v2

    invoke-virtual {p1, v0, v2}, Landroid/os/Parcel;->readList(Ljava/util/List;Ljava/lang/ClassLoader;)V

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result p1

    if-nez p1, :cond_0

    iput-object v1, p0, Lcom/baidu/location/BDLocation;->L:Ljava/util/List;

    goto :goto_1

    :cond_0
    iput-object v0, p0, Lcom/baidu/location/BDLocation;->L:Ljava/util/List;

    :goto_1
    return-void
.end method

.method synthetic constructor <init>(Landroid/os/Parcel;Lcom/baidu/location/a;)V
    .locals 0

    invoke-direct {p0, p1}, Lcom/baidu/location/BDLocation;-><init>(Landroid/os/Parcel;)V

    return-void
.end method

.method public constructor <init>(Lcom/baidu/location/BDLocation;)V
    .locals 8

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    const/4 v0, 0x0

    iput v0, p0, Lcom/baidu/location/BDLocation;->a:I

    const/4 v1, 0x0

    iput-object v1, p0, Lcom/baidu/location/BDLocation;->b:Ljava/lang/String;

    const-wide/16 v2, 0x1

    iput-wide v2, p0, Lcom/baidu/location/BDLocation;->c:D

    iput-wide v2, p0, Lcom/baidu/location/BDLocation;->d:D

    iput-boolean v0, p0, Lcom/baidu/location/BDLocation;->e:Z

    iput-wide v2, p0, Lcom/baidu/location/BDLocation;->f:D

    iput-boolean v0, p0, Lcom/baidu/location/BDLocation;->g:Z

    const/4 v2, 0x0

    iput v2, p0, Lcom/baidu/location/BDLocation;->h:F

    iput-boolean v0, p0, Lcom/baidu/location/BDLocation;->i:Z

    iput v2, p0, Lcom/baidu/location/BDLocation;->j:F

    iput-boolean v0, p0, Lcom/baidu/location/BDLocation;->k:Z

    const/4 v2, -0x1

    iput v2, p0, Lcom/baidu/location/BDLocation;->l:I

    const/high16 v3, -0x40800000    # -1.0f

    iput v3, p0, Lcom/baidu/location/BDLocation;->m:F

    iput-object v1, p0, Lcom/baidu/location/BDLocation;->n:Ljava/lang/String;

    iput-boolean v0, p0, Lcom/baidu/location/BDLocation;->o:Z

    iput-object v1, p0, Lcom/baidu/location/BDLocation;->p:Ljava/lang/String;

    iput-object v1, p0, Lcom/baidu/location/BDLocation;->q:Ljava/lang/String;

    iput-object v1, p0, Lcom/baidu/location/BDLocation;->r:Ljava/lang/String;

    iput-object v1, p0, Lcom/baidu/location/BDLocation;->s:Ljava/lang/String;

    iput-boolean v0, p0, Lcom/baidu/location/BDLocation;->t:Z

    new-instance v3, Lcom/baidu/location/Address$Builder;

    invoke-direct {v3}, Lcom/baidu/location/Address$Builder;-><init>()V

    invoke-virtual {v3}, Lcom/baidu/location/Address$Builder;->build()Lcom/baidu/location/Address;

    move-result-object v3

    iput-object v3, p0, Lcom/baidu/location/BDLocation;->u:Lcom/baidu/location/Address;

    iput-object v1, p0, Lcom/baidu/location/BDLocation;->v:Ljava/lang/String;

    iput-object v1, p0, Lcom/baidu/location/BDLocation;->w:Ljava/lang/String;

    iput-object v1, p0, Lcom/baidu/location/BDLocation;->x:Ljava/lang/String;

    iput-boolean v0, p0, Lcom/baidu/location/BDLocation;->y:Z

    iput v0, p0, Lcom/baidu/location/BDLocation;->z:I

    const/4 v3, 0x1

    iput v3, p0, Lcom/baidu/location/BDLocation;->A:I

    iput-object v1, p0, Lcom/baidu/location/BDLocation;->B:Ljava/lang/String;

    const-string v3, ""

    iput-object v3, p0, Lcom/baidu/location/BDLocation;->D:Ljava/lang/String;

    iput v2, p0, Lcom/baidu/location/BDLocation;->E:I

    iput v0, p0, Lcom/baidu/location/BDLocation;->F:I

    const/4 v2, 0x2

    iput v2, p0, Lcom/baidu/location/BDLocation;->G:I

    iput v0, p0, Lcom/baidu/location/BDLocation;->H:I

    iput-object v1, p0, Lcom/baidu/location/BDLocation;->I:Ljava/lang/String;

    iput-object v1, p0, Lcom/baidu/location/BDLocation;->J:Ljava/lang/String;

    iput-object v1, p0, Lcom/baidu/location/BDLocation;->K:Ljava/lang/String;

    iput-object v1, p0, Lcom/baidu/location/BDLocation;->L:Ljava/util/List;

    iput-object v1, p0, Lcom/baidu/location/BDLocation;->M:Ljava/lang/String;

    iput-object v1, p0, Lcom/baidu/location/BDLocation;->N:Ljava/lang/String;

    new-instance v2, Ljava/util/HashMap;

    invoke-direct {v2}, Ljava/util/HashMap;-><init>()V

    iput-object v2, p0, Lcom/baidu/location/BDLocation;->O:Ljava/util/HashMap;

    iput v0, p0, Lcom/baidu/location/BDLocation;->P:I

    iput v0, p0, Lcom/baidu/location/BDLocation;->Q:I

    iget v2, p1, Lcom/baidu/location/BDLocation;->a:I

    iput v2, p0, Lcom/baidu/location/BDLocation;->a:I

    iget-object v2, p1, Lcom/baidu/location/BDLocation;->b:Ljava/lang/String;

    iput-object v2, p0, Lcom/baidu/location/BDLocation;->b:Ljava/lang/String;

    iget-wide v2, p1, Lcom/baidu/location/BDLocation;->c:D

    iput-wide v2, p0, Lcom/baidu/location/BDLocation;->c:D

    iget-wide v2, p1, Lcom/baidu/location/BDLocation;->d:D

    iput-wide v2, p0, Lcom/baidu/location/BDLocation;->d:D

    iget-boolean v2, p1, Lcom/baidu/location/BDLocation;->e:Z

    iput-boolean v2, p0, Lcom/baidu/location/BDLocation;->e:Z

    iget-wide v2, p1, Lcom/baidu/location/BDLocation;->f:D

    iput-wide v2, p0, Lcom/baidu/location/BDLocation;->f:D

    iget-boolean v2, p1, Lcom/baidu/location/BDLocation;->g:Z

    iput-boolean v2, p0, Lcom/baidu/location/BDLocation;->g:Z

    iget v2, p1, Lcom/baidu/location/BDLocation;->h:F

    iput v2, p0, Lcom/baidu/location/BDLocation;->h:F

    iget-boolean v2, p1, Lcom/baidu/location/BDLocation;->i:Z

    iput-boolean v2, p0, Lcom/baidu/location/BDLocation;->i:Z

    iget v2, p1, Lcom/baidu/location/BDLocation;->j:F

    iput v2, p0, Lcom/baidu/location/BDLocation;->j:F

    iget-boolean v2, p1, Lcom/baidu/location/BDLocation;->k:Z

    iput-boolean v2, p0, Lcom/baidu/location/BDLocation;->k:Z

    iget v2, p1, Lcom/baidu/location/BDLocation;->l:I

    iput v2, p0, Lcom/baidu/location/BDLocation;->l:I

    iget v2, p1, Lcom/baidu/location/BDLocation;->m:F

    iput v2, p0, Lcom/baidu/location/BDLocation;->m:F

    iget-object v2, p1, Lcom/baidu/location/BDLocation;->n:Ljava/lang/String;

    iput-object v2, p0, Lcom/baidu/location/BDLocation;->n:Ljava/lang/String;

    iget-boolean v2, p1, Lcom/baidu/location/BDLocation;->o:Z

    iput-boolean v2, p0, Lcom/baidu/location/BDLocation;->o:Z

    iget-object v2, p1, Lcom/baidu/location/BDLocation;->p:Ljava/lang/String;

    iput-object v2, p0, Lcom/baidu/location/BDLocation;->p:Ljava/lang/String;

    iget-boolean v2, p1, Lcom/baidu/location/BDLocation;->t:Z

    iput-boolean v2, p0, Lcom/baidu/location/BDLocation;->t:Z

    new-instance v2, Lcom/baidu/location/Address$Builder;

    invoke-direct {v2}, Lcom/baidu/location/Address$Builder;-><init>()V

    iget-object v3, p1, Lcom/baidu/location/BDLocation;->u:Lcom/baidu/location/Address;

    iget-object v3, v3, Lcom/baidu/location/Address;->country:Ljava/lang/String;

    invoke-virtual {v2, v3}, Lcom/baidu/location/Address$Builder;->country(Ljava/lang/String;)Lcom/baidu/location/Address$Builder;

    move-result-object v2

    iget-object v3, p1, Lcom/baidu/location/BDLocation;->u:Lcom/baidu/location/Address;

    iget-object v3, v3, Lcom/baidu/location/Address;->countryCode:Ljava/lang/String;

    invoke-virtual {v2, v3}, Lcom/baidu/location/Address$Builder;->countryCode(Ljava/lang/String;)Lcom/baidu/location/Address$Builder;

    move-result-object v2

    iget-object v3, p1, Lcom/baidu/location/BDLocation;->u:Lcom/baidu/location/Address;

    iget-object v3, v3, Lcom/baidu/location/Address;->province:Ljava/lang/String;

    invoke-virtual {v2, v3}, Lcom/baidu/location/Address$Builder;->province(Ljava/lang/String;)Lcom/baidu/location/Address$Builder;

    move-result-object v2

    iget-object v3, p1, Lcom/baidu/location/BDLocation;->u:Lcom/baidu/location/Address;

    iget-object v3, v3, Lcom/baidu/location/Address;->city:Ljava/lang/String;

    invoke-virtual {v2, v3}, Lcom/baidu/location/Address$Builder;->city(Ljava/lang/String;)Lcom/baidu/location/Address$Builder;

    move-result-object v2

    iget-object v3, p1, Lcom/baidu/location/BDLocation;->u:Lcom/baidu/location/Address;

    iget-object v3, v3, Lcom/baidu/location/Address;->cityCode:Ljava/lang/String;

    invoke-virtual {v2, v3}, Lcom/baidu/location/Address$Builder;->cityCode(Ljava/lang/String;)Lcom/baidu/location/Address$Builder;

    move-result-object v2

    iget-object v3, p1, Lcom/baidu/location/BDLocation;->u:Lcom/baidu/location/Address;

    iget-object v3, v3, Lcom/baidu/location/Address;->district:Ljava/lang/String;

    invoke-virtual {v2, v3}, Lcom/baidu/location/Address$Builder;->district(Ljava/lang/String;)Lcom/baidu/location/Address$Builder;

    move-result-object v2

    iget-object v3, p1, Lcom/baidu/location/BDLocation;->u:Lcom/baidu/location/Address;

    iget-object v3, v3, Lcom/baidu/location/Address;->street:Ljava/lang/String;

    invoke-virtual {v2, v3}, Lcom/baidu/location/Address$Builder;->street(Ljava/lang/String;)Lcom/baidu/location/Address$Builder;

    move-result-object v2

    iget-object v3, p1, Lcom/baidu/location/BDLocation;->u:Lcom/baidu/location/Address;

    iget-object v3, v3, Lcom/baidu/location/Address;->streetNumber:Ljava/lang/String;

    invoke-virtual {v2, v3}, Lcom/baidu/location/Address$Builder;->streetNumber(Ljava/lang/String;)Lcom/baidu/location/Address$Builder;

    move-result-object v2

    iget-object v3, p1, Lcom/baidu/location/BDLocation;->u:Lcom/baidu/location/Address;

    iget-object v3, v3, Lcom/baidu/location/Address;->adcode:Ljava/lang/String;

    invoke-virtual {v2, v3}, Lcom/baidu/location/Address$Builder;->adcode(Ljava/lang/String;)Lcom/baidu/location/Address$Builder;

    move-result-object v2

    invoke-virtual {v2}, Lcom/baidu/location/Address$Builder;->build()Lcom/baidu/location/Address;

    move-result-object v2

    iput-object v2, p0, Lcom/baidu/location/BDLocation;->u:Lcom/baidu/location/Address;

    iget-object v2, p1, Lcom/baidu/location/BDLocation;->v:Ljava/lang/String;

    iput-object v2, p0, Lcom/baidu/location/BDLocation;->v:Ljava/lang/String;

    iget-object v2, p1, Lcom/baidu/location/BDLocation;->w:Ljava/lang/String;

    iput-object v2, p0, Lcom/baidu/location/BDLocation;->w:Ljava/lang/String;

    iget-object v2, p1, Lcom/baidu/location/BDLocation;->x:Ljava/lang/String;

    iput-object v2, p0, Lcom/baidu/location/BDLocation;->x:Ljava/lang/String;

    iget v2, p1, Lcom/baidu/location/BDLocation;->A:I

    iput v2, p0, Lcom/baidu/location/BDLocation;->A:I

    iget v2, p1, Lcom/baidu/location/BDLocation;->z:I

    iput v2, p0, Lcom/baidu/location/BDLocation;->z:I

    iget-boolean v2, p1, Lcom/baidu/location/BDLocation;->y:Z

    iput-boolean v2, p0, Lcom/baidu/location/BDLocation;->y:Z

    iget-object v2, p1, Lcom/baidu/location/BDLocation;->B:Ljava/lang/String;

    iput-object v2, p0, Lcom/baidu/location/BDLocation;->B:Ljava/lang/String;

    iget v2, p1, Lcom/baidu/location/BDLocation;->C:I

    iput v2, p0, Lcom/baidu/location/BDLocation;->C:I

    iget-object v2, p1, Lcom/baidu/location/BDLocation;->D:Ljava/lang/String;

    iput-object v2, p0, Lcom/baidu/location/BDLocation;->D:Ljava/lang/String;

    iget-object v2, p1, Lcom/baidu/location/BDLocation;->q:Ljava/lang/String;

    iput-object v2, p0, Lcom/baidu/location/BDLocation;->q:Ljava/lang/String;

    iget-object v2, p1, Lcom/baidu/location/BDLocation;->r:Ljava/lang/String;

    iput-object v2, p0, Lcom/baidu/location/BDLocation;->r:Ljava/lang/String;

    iget-object v2, p1, Lcom/baidu/location/BDLocation;->s:Ljava/lang/String;

    iput-object v2, p0, Lcom/baidu/location/BDLocation;->s:Ljava/lang/String;

    iget v2, p1, Lcom/baidu/location/BDLocation;->E:I

    iput v2, p0, Lcom/baidu/location/BDLocation;->E:I

    iget v2, p1, Lcom/baidu/location/BDLocation;->F:I

    iput v2, p0, Lcom/baidu/location/BDLocation;->F:I

    iget v2, p1, Lcom/baidu/location/BDLocation;->F:I

    iput v2, p0, Lcom/baidu/location/BDLocation;->G:I

    iget v2, p1, Lcom/baidu/location/BDLocation;->H:I

    iput v2, p0, Lcom/baidu/location/BDLocation;->H:I

    iget-object v2, p1, Lcom/baidu/location/BDLocation;->I:Ljava/lang/String;

    iput-object v2, p0, Lcom/baidu/location/BDLocation;->I:Ljava/lang/String;

    iget-object v2, p1, Lcom/baidu/location/BDLocation;->J:Ljava/lang/String;

    iput-object v2, p0, Lcom/baidu/location/BDLocation;->J:Ljava/lang/String;

    iget-object v2, p1, Lcom/baidu/location/BDLocation;->K:Ljava/lang/String;

    iput-object v2, p0, Lcom/baidu/location/BDLocation;->K:Ljava/lang/String;

    iget v2, p1, Lcom/baidu/location/BDLocation;->P:I

    iput v2, p0, Lcom/baidu/location/BDLocation;->P:I

    iget-object v2, p1, Lcom/baidu/location/BDLocation;->N:Ljava/lang/String;

    iput-object v2, p0, Lcom/baidu/location/BDLocation;->N:Ljava/lang/String;

    iget-object v2, p1, Lcom/baidu/location/BDLocation;->L:Ljava/util/List;

    if-nez v2, :cond_1

    :cond_0
    iput-object v1, p0, Lcom/baidu/location/BDLocation;->L:Ljava/util/List;

    goto :goto_1

    :cond_1
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    :goto_0
    iget-object v2, p1, Lcom/baidu/location/BDLocation;->L:Ljava/util/List;

    invoke-interface {v2}, Ljava/util/List;->size()I

    move-result v2

    if-ge v0, v2, :cond_0

    iget-object v2, p1, Lcom/baidu/location/BDLocation;->L:Ljava/util/List;

    invoke-interface {v2, v0}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/baidu/location/Poi;

    new-instance v3, Lcom/baidu/location/Poi;

    invoke-virtual {v2}, Lcom/baidu/location/Poi;->getId()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v2}, Lcom/baidu/location/Poi;->getName()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v2}, Lcom/baidu/location/Poi;->getRank()D

    move-result-wide v6

    invoke-direct {v3, v4, v5, v6, v7}, Lcom/baidu/location/Poi;-><init>(Ljava/lang/String;Ljava/lang/String;D)V

    invoke-interface {v1, v3}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    :goto_1
    iget-object v0, p1, Lcom/baidu/location/BDLocation;->M:Ljava/lang/String;

    iput-object v0, p0, Lcom/baidu/location/BDLocation;->M:Ljava/lang/String;

    iget-object v0, p1, Lcom/baidu/location/BDLocation;->O:Ljava/util/HashMap;

    iput-object v0, p0, Lcom/baidu/location/BDLocation;->O:Ljava/util/HashMap;

    iget p1, p1, Lcom/baidu/location/BDLocation;->Q:I

    iput p1, p0, Lcom/baidu/location/BDLocation;->Q:I

    return-void
.end method

.method public constructor <init>(Ljava/lang/String;)V
    .locals 18

    move-object/from16 v1, p0

    move-object/from16 v2, p1

    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    const/4 v3, 0x0

    iput v3, v1, Lcom/baidu/location/BDLocation;->a:I

    const/4 v4, 0x0

    iput-object v4, v1, Lcom/baidu/location/BDLocation;->b:Ljava/lang/String;

    const-wide/16 v5, 0x1

    iput-wide v5, v1, Lcom/baidu/location/BDLocation;->c:D

    iput-wide v5, v1, Lcom/baidu/location/BDLocation;->d:D

    iput-boolean v3, v1, Lcom/baidu/location/BDLocation;->e:Z

    iput-wide v5, v1, Lcom/baidu/location/BDLocation;->f:D

    iput-boolean v3, v1, Lcom/baidu/location/BDLocation;->g:Z

    const/4 v5, 0x0

    iput v5, v1, Lcom/baidu/location/BDLocation;->h:F

    iput-boolean v3, v1, Lcom/baidu/location/BDLocation;->i:Z

    iput v5, v1, Lcom/baidu/location/BDLocation;->j:F

    iput-boolean v3, v1, Lcom/baidu/location/BDLocation;->k:Z

    const/4 v5, -0x1

    iput v5, v1, Lcom/baidu/location/BDLocation;->l:I

    const/high16 v6, -0x40800000    # -1.0f

    iput v6, v1, Lcom/baidu/location/BDLocation;->m:F

    iput-object v4, v1, Lcom/baidu/location/BDLocation;->n:Ljava/lang/String;

    iput-boolean v3, v1, Lcom/baidu/location/BDLocation;->o:Z

    iput-object v4, v1, Lcom/baidu/location/BDLocation;->p:Ljava/lang/String;

    iput-object v4, v1, Lcom/baidu/location/BDLocation;->q:Ljava/lang/String;

    iput-object v4, v1, Lcom/baidu/location/BDLocation;->r:Ljava/lang/String;

    iput-object v4, v1, Lcom/baidu/location/BDLocation;->s:Ljava/lang/String;

    iput-boolean v3, v1, Lcom/baidu/location/BDLocation;->t:Z

    new-instance v6, Lcom/baidu/location/Address$Builder;

    invoke-direct {v6}, Lcom/baidu/location/Address$Builder;-><init>()V

    invoke-virtual {v6}, Lcom/baidu/location/Address$Builder;->build()Lcom/baidu/location/Address;

    move-result-object v6

    iput-object v6, v1, Lcom/baidu/location/BDLocation;->u:Lcom/baidu/location/Address;

    iput-object v4, v1, Lcom/baidu/location/BDLocation;->v:Ljava/lang/String;

    iput-object v4, v1, Lcom/baidu/location/BDLocation;->w:Ljava/lang/String;

    iput-object v4, v1, Lcom/baidu/location/BDLocation;->x:Ljava/lang/String;

    iput-boolean v3, v1, Lcom/baidu/location/BDLocation;->y:Z

    iput v3, v1, Lcom/baidu/location/BDLocation;->z:I

    const/4 v6, 0x1

    iput v6, v1, Lcom/baidu/location/BDLocation;->A:I

    iput-object v4, v1, Lcom/baidu/location/BDLocation;->B:Ljava/lang/String;

    const-string v7, ""

    iput-object v7, v1, Lcom/baidu/location/BDLocation;->D:Ljava/lang/String;

    iput v5, v1, Lcom/baidu/location/BDLocation;->E:I

    iput v3, v1, Lcom/baidu/location/BDLocation;->F:I

    const/4 v5, 0x2

    iput v5, v1, Lcom/baidu/location/BDLocation;->G:I

    iput v3, v1, Lcom/baidu/location/BDLocation;->H:I

    iput-object v4, v1, Lcom/baidu/location/BDLocation;->I:Ljava/lang/String;

    iput-object v4, v1, Lcom/baidu/location/BDLocation;->J:Ljava/lang/String;

    iput-object v4, v1, Lcom/baidu/location/BDLocation;->K:Ljava/lang/String;

    iput-object v4, v1, Lcom/baidu/location/BDLocation;->L:Ljava/util/List;

    iput-object v4, v1, Lcom/baidu/location/BDLocation;->M:Ljava/lang/String;

    iput-object v4, v1, Lcom/baidu/location/BDLocation;->N:Ljava/lang/String;

    new-instance v7, Ljava/util/HashMap;

    invoke-direct {v7}, Ljava/util/HashMap;-><init>()V

    iput-object v7, v1, Lcom/baidu/location/BDLocation;->O:Ljava/util/HashMap;

    iput v3, v1, Lcom/baidu/location/BDLocation;->P:I

    iput v3, v1, Lcom/baidu/location/BDLocation;->Q:I

    if-eqz v2, :cond_35

    const-string v7, ""

    invoke-virtual {v2, v7}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v7

    if-eqz v7, :cond_0

    goto/16 :goto_21

    :cond_0
    :try_start_0
    new-instance v7, Lorg/json/JSONObject;

    invoke-direct {v7, v2}, Lorg/json/JSONObject;-><init>(Ljava/lang/String;)V

    const-string v2, "result"

    invoke-virtual {v7, v2}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v2

    const-string v8, "error"

    invoke-virtual {v2, v8}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v8

    invoke-static {v8}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v8

    invoke-virtual {v1, v8}, Lcom/baidu/location/BDLocation;->setLocType(I)V

    const-string v9, "time"

    invoke-virtual {v2, v9}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/baidu/location/BDLocation;->setTime(Ljava/lang/String;)V

    const/16 v2, 0x3d

    if-ne v8, v2, :cond_4

    const-string v2, "content"

    invoke-virtual {v7, v2}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v2

    const-string v4, "point"

    invoke-virtual {v2, v4}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v4

    const-string v5, "y"

    invoke-virtual {v4, v5}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    invoke-static {v5}, Ljava/lang/Double;->parseDouble(Ljava/lang/String;)D

    move-result-wide v7

    invoke-virtual {v1, v7, v8}, Lcom/baidu/location/BDLocation;->setLatitude(D)V

    const-string v5, "x"

    invoke-virtual {v4, v5}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-static {v4}, Ljava/lang/Double;->parseDouble(Ljava/lang/String;)D

    move-result-wide v4

    invoke-virtual {v1, v4, v5}, Lcom/baidu/location/BDLocation;->setLongitude(D)V

    const-string v4, "radius"

    invoke-virtual {v2, v4}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-static {v4}, Ljava/lang/Float;->parseFloat(Ljava/lang/String;)F

    move-result v4

    invoke-virtual {v1, v4}, Lcom/baidu/location/BDLocation;->setRadius(F)V

    const-string v4, "s"

    invoke-virtual {v2, v4}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-static {v4}, Ljava/lang/Float;->parseFloat(Ljava/lang/String;)F

    move-result v4

    invoke-virtual {v1, v4}, Lcom/baidu/location/BDLocation;->setSpeed(F)V

    const-string v4, "d"

    invoke-virtual {v2, v4}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-static {v4}, Ljava/lang/Float;->parseFloat(Ljava/lang/String;)F

    move-result v4

    invoke-virtual {v1, v4}, Lcom/baidu/location/BDLocation;->setDirection(F)V

    const-string v4, "n"

    invoke-virtual {v2, v4}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-static {v4}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v4

    invoke-virtual {v1, v4}, Lcom/baidu/location/BDLocation;->setSatelliteNumber(I)V

    const-string v4, "h"

    invoke-virtual {v2, v4}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v4
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_10
    .catch Ljava/lang/Error; {:try_start_0 .. :try_end_0} :catch_f

    if-eqz v4, :cond_1

    :try_start_1
    const-string v4, "h"

    invoke-virtual {v2, v4}, Lorg/json/JSONObject;->getDouble(Ljava/lang/String;)D

    move-result-wide v4

    invoke-virtual {v1, v4, v5}, Lcom/baidu/location/BDLocation;->setAltitude(D)V
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0
    .catch Ljava/lang/Error; {:try_start_1 .. :try_end_1} :catch_f

    goto :goto_0

    :catch_0
    move-exception v0

    :cond_1
    :goto_0
    :try_start_2
    const-string v4, "in_cn"

    invoke-virtual {v2, v4}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v4

    if-eqz v4, :cond_2

    const-string v4, "in_cn"

    invoke-virtual {v2, v4}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v2

    invoke-virtual {v1, v2}, Lcom/baidu/location/BDLocation;->setLocationWhere(I)V

    goto :goto_1

    :cond_2
    invoke-virtual {v1, v6}, Lcom/baidu/location/BDLocation;->setLocationWhere(I)V
    :try_end_2
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_1
    .catch Ljava/lang/Error; {:try_start_2 .. :try_end_2} :catch_f

    goto :goto_1

    :catch_1
    move-exception v0

    :goto_1
    :try_start_3
    iget v2, v1, Lcom/baidu/location/BDLocation;->A:I

    if-nez v2, :cond_3

    const-string v2, "wgs84"

    :goto_2
    invoke-virtual {v1, v2}, Lcom/baidu/location/BDLocation;->setCoorType(Ljava/lang/String;)V

    goto/16 :goto_21

    :cond_3
    const-string v2, "gcj02"

    goto :goto_2

    :cond_4
    const/16 v2, 0xa1

    if-ne v8, v2, :cond_32

    const-string v2, "content"

    invoke-virtual {v7, v2}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v2

    const-string v7, "point"

    invoke-virtual {v2, v7}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v7

    const-string v8, "y"

    invoke-virtual {v7, v8}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v8

    invoke-static {v8}, Ljava/lang/Double;->parseDouble(Ljava/lang/String;)D

    move-result-wide v8

    invoke-virtual {v1, v8, v9}, Lcom/baidu/location/BDLocation;->setLatitude(D)V

    const-string v8, "x"

    invoke-virtual {v7, v8}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v7

    invoke-static {v7}, Ljava/lang/Double;->parseDouble(Ljava/lang/String;)D

    move-result-wide v7

    invoke-virtual {v1, v7, v8}, Lcom/baidu/location/BDLocation;->setLongitude(D)V

    const-string v7, "radius"

    invoke-virtual {v2, v7}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v7

    invoke-static {v7}, Ljava/lang/Float;->parseFloat(Ljava/lang/String;)F

    move-result v7

    invoke-virtual {v1, v7}, Lcom/baidu/location/BDLocation;->setRadius(F)V

    const-string v7, "sema"

    invoke-virtual {v2, v7}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v7

    if-eqz v7, :cond_a

    const-string v7, "sema"

    invoke-virtual {v2, v7}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v7

    const-string v8, "aptag"

    invoke-virtual {v7, v8}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v8

    if-eqz v8, :cond_6

    const-string v8, "aptag"

    invoke-virtual {v7, v8}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v8

    invoke-static {v8}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v9

    if-nez v9, :cond_5

    :goto_3
    iput-object v8, v1, Lcom/baidu/location/BDLocation;->q:Ljava/lang/String;

    goto :goto_4

    :cond_5
    const-string v8, ""

    goto :goto_3

    :cond_6
    :goto_4
    const-string v8, "aptagd"

    invoke-virtual {v7, v8}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v8

    if-eqz v8, :cond_8

    const-string v8, "aptagd"

    invoke-virtual {v7, v8}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v8

    const-string v9, "pois"

    invoke-virtual {v8, v9}, Lorg/json/JSONObject;->getJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v8

    new-instance v9, Ljava/util/ArrayList;

    invoke-direct {v9}, Ljava/util/ArrayList;-><init>()V

    const/4 v10, 0x0

    :goto_5
    invoke-virtual {v8}, Lorg/json/JSONArray;->length()I

    move-result v11

    if-ge v10, v11, :cond_7

    invoke-virtual {v8, v10}, Lorg/json/JSONArray;->getJSONObject(I)Lorg/json/JSONObject;

    move-result-object v11

    const-string v12, "pname"

    invoke-virtual {v11, v12}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v12

    const-string v13, "pid"

    invoke-virtual {v11, v13}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v13

    const-string v14, "pr"

    invoke-virtual {v11, v14}, Lorg/json/JSONObject;->getDouble(Ljava/lang/String;)D

    move-result-wide v14

    new-instance v11, Lcom/baidu/location/Poi;

    invoke-direct {v11, v13, v12, v14, v15}, Lcom/baidu/location/Poi;-><init>(Ljava/lang/String;Ljava/lang/String;D)V

    invoke-interface {v9, v11}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    add-int/lit8 v10, v10, 0x1

    goto :goto_5

    :cond_7
    iput-object v9, v1, Lcom/baidu/location/BDLocation;->L:Ljava/util/List;

    :cond_8
    const-string v8, "poiregion"

    invoke-virtual {v7, v8}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v8

    if-eqz v8, :cond_9

    const-string v8, "poiregion"

    invoke-virtual {v7, v8}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v8

    invoke-static {v8}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v9

    if-nez v9, :cond_9

    iput-object v8, v1, Lcom/baidu/location/BDLocation;->r:Ljava/lang/String;

    :cond_9
    const-string v8, "regular"

    invoke-virtual {v7, v8}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v8

    if-eqz v8, :cond_a

    const-string v8, "regular"

    invoke-virtual {v7, v8}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v7

    invoke-static {v7}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v8

    if-nez v8, :cond_a

    iput-object v7, v1, Lcom/baidu/location/BDLocation;->s:Ljava/lang/String;

    :cond_a
    const-string v7, "addr"

    invoke-virtual {v2, v7}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v7
    :try_end_3
    .catch Ljava/lang/Exception; {:try_start_3 .. :try_end_3} :catch_10
    .catch Ljava/lang/Error; {:try_start_3 .. :try_end_3} :catch_f

    if-eqz v7, :cond_1e

    :try_start_4
    const-string v7, "addr"

    invoke-virtual {v2, v7}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v7
    :try_end_4
    .catch Ljava/lang/Exception; {:try_start_4 .. :try_end_4} :catch_2
    .catch Ljava/lang/Error; {:try_start_4 .. :try_end_4} :catch_f

    const/4 v8, 0x1

    goto :goto_6

    :catch_2
    move-exception v0

    move-object v7, v4

    const/4 v8, 0x0

    :goto_6
    if-eqz v7, :cond_14

    :try_start_5
    const-string v9, ""

    const-string v10, ""

    const-string v11, ""

    const-string v12, ""

    const-string v13, ""

    const-string v14, ""

    const-string v15, ""

    const-string v16, ""

    const-string v17, ""

    const-string v4, "city"

    invoke-virtual {v7, v4}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v4

    if-eqz v4, :cond_b

    const-string v4, "city"

    invoke-virtual {v7, v4}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v12

    :cond_b
    const-string v4, "city_code"

    invoke-virtual {v7, v4}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v4

    if-eqz v4, :cond_c

    const-string v4, "city_code"

    invoke-virtual {v7, v4}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v13

    :cond_c
    const-string v4, "country"

    invoke-virtual {v7, v4}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v4

    if-eqz v4, :cond_d

    const-string v4, "country"

    invoke-virtual {v7, v4}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v9

    :cond_d
    const-string v4, "country_code"

    invoke-virtual {v7, v4}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v4

    if-eqz v4, :cond_e

    const-string v4, "country_code"

    invoke-virtual {v7, v4}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v10

    :cond_e
    const-string v4, "province"

    invoke-virtual {v7, v4}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v4

    if-eqz v4, :cond_f

    const-string v4, "province"

    invoke-virtual {v7, v4}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v11

    :cond_f
    const-string v4, "district"

    invoke-virtual {v7, v4}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v4

    if-eqz v4, :cond_10

    const-string v4, "district"

    invoke-virtual {v7, v4}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v14

    :cond_10
    const-string v4, "street"

    invoke-virtual {v7, v4}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v4

    if-eqz v4, :cond_11

    const-string v4, "street"

    invoke-virtual {v7, v4}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v15

    :cond_11
    const-string v4, "street_number"

    invoke-virtual {v7, v4}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v4

    if-eqz v4, :cond_12

    const-string v4, "street_number"

    invoke-virtual {v7, v4}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v16

    :cond_12
    const-string v4, "adcode"

    invoke-virtual {v7, v4}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v4

    if-eqz v4, :cond_13

    const-string v4, "adcode"

    invoke-virtual {v7, v4}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4
    :try_end_5
    .catch Ljava/lang/Exception; {:try_start_5 .. :try_end_5} :catch_10
    .catch Ljava/lang/Error; {:try_start_5 .. :try_end_5} :catch_f

    move-object/from16 v5, v16

    goto/16 :goto_16

    :cond_13
    move-object/from16 v5, v16

    move-object/from16 v4, v17

    goto/16 :goto_16

    :cond_14
    :try_start_6
    const-string v4, "addr"

    invoke-virtual {v2, v4}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    const-string v7, ","

    invoke-virtual {v4, v7}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v4

    array-length v7, v4

    if-lez v7, :cond_15

    aget-object v8, v4, v3
    :try_end_6
    .catch Ljava/lang/Exception; {:try_start_6 .. :try_end_6} :catch_b
    .catch Ljava/lang/Error; {:try_start_6 .. :try_end_6} :catch_f

    goto :goto_7

    :cond_15
    const/4 v8, 0x0

    :goto_7
    if-le v7, v6, :cond_16

    :try_start_7
    aget-object v9, v4, v6
    :try_end_7
    .catch Ljava/lang/Exception; {:try_start_7 .. :try_end_7} :catch_3
    .catch Ljava/lang/Error; {:try_start_7 .. :try_end_7} :catch_f

    goto :goto_8

    :catch_3
    move-exception v0

    move-object v4, v0

    move-object v11, v8

    const/4 v5, 0x0

    const/4 v9, 0x0

    const/4 v10, 0x0

    goto/16 :goto_12

    :cond_16
    const/4 v9, 0x0

    :goto_8
    if-le v7, v5, :cond_17

    :try_start_8
    aget-object v10, v4, v5
    :try_end_8
    .catch Ljava/lang/Exception; {:try_start_8 .. :try_end_8} :catch_4
    .catch Ljava/lang/Error; {:try_start_8 .. :try_end_8} :catch_f

    goto :goto_9

    :catch_4
    move-exception v0

    move-object v4, v0

    move-object v11, v8

    move-object v12, v9

    const/4 v5, 0x0

    const/4 v9, 0x0

    const/4 v10, 0x0

    goto/16 :goto_13

    :cond_17
    const/4 v10, 0x0

    :goto_9
    const/4 v11, 0x3

    if-le v7, v11, :cond_18

    :try_start_9
    aget-object v11, v4, v11
    :try_end_9
    .catch Ljava/lang/Exception; {:try_start_9 .. :try_end_9} :catch_5
    .catch Ljava/lang/Error; {:try_start_9 .. :try_end_9} :catch_f

    goto :goto_a

    :catch_5
    move-exception v0

    move-object v4, v0

    move-object v11, v8

    move-object v12, v9

    move-object v14, v10

    const/4 v5, 0x0

    const/4 v9, 0x0

    const/4 v10, 0x0

    const/4 v13, 0x0

    goto/16 :goto_14

    :cond_18
    const/4 v11, 0x0

    :goto_a
    const/4 v12, 0x4

    if-le v7, v12, :cond_19

    :try_start_a
    aget-object v12, v4, v12
    :try_end_a
    .catch Ljava/lang/Exception; {:try_start_a .. :try_end_a} :catch_6
    .catch Ljava/lang/Error; {:try_start_a .. :try_end_a} :catch_f

    goto :goto_c

    :catch_6
    move-exception v0

    move-object v4, v0

    move-object v12, v9

    move-object v14, v10

    move-object v15, v11

    const/4 v5, 0x0

    const/4 v9, 0x0

    const/4 v10, 0x0

    const/4 v13, 0x0

    :goto_b
    move-object v11, v8

    goto/16 :goto_15

    :cond_19
    const/4 v12, 0x0

    :goto_c
    const/4 v13, 0x5

    if-le v7, v13, :cond_1a

    :try_start_b
    aget-object v13, v4, v13
    :try_end_b
    .catch Ljava/lang/Exception; {:try_start_b .. :try_end_b} :catch_7
    .catch Ljava/lang/Error; {:try_start_b .. :try_end_b} :catch_f

    goto :goto_e

    :catch_7
    move-exception v0

    move-object v4, v0

    move-object v14, v10

    move-object v15, v11

    move-object v5, v12

    const/4 v10, 0x0

    const/4 v13, 0x0

    :goto_d
    move-object v11, v8

    move-object v12, v9

    const/4 v9, 0x0

    goto/16 :goto_15

    :cond_1a
    const/4 v13, 0x0

    :goto_e
    const/4 v14, 0x6

    if-le v7, v14, :cond_1b

    :try_start_c
    aget-object v14, v4, v14
    :try_end_c
    .catch Ljava/lang/Exception; {:try_start_c .. :try_end_c} :catch_8
    .catch Ljava/lang/Error; {:try_start_c .. :try_end_c} :catch_f

    goto :goto_f

    :catch_8
    move-exception v0

    move-object v4, v0

    move-object v14, v10

    move-object v15, v11

    move-object v5, v12

    const/4 v10, 0x0

    goto :goto_d

    :cond_1b
    const/4 v14, 0x0

    :goto_f
    const/4 v15, 0x7

    if-le v7, v15, :cond_1c

    :try_start_d
    aget-object v15, v4, v15
    :try_end_d
    .catch Ljava/lang/Exception; {:try_start_d .. :try_end_d} :catch_9
    .catch Ljava/lang/Error; {:try_start_d .. :try_end_d} :catch_f

    goto :goto_10

    :catch_9
    move-exception v0

    move-object v4, v0

    move-object v15, v11

    move-object v5, v12

    move-object v11, v8

    move-object v12, v9

    move-object v9, v14

    move-object v14, v10

    const/4 v10, 0x0

    goto :goto_15

    :cond_1c
    const/4 v15, 0x0

    :goto_10
    const/16 v5, 0x8

    if-le v7, v5, :cond_1d

    :try_start_e
    aget-object v4, v4, v5
    :try_end_e
    .catch Ljava/lang/Exception; {:try_start_e .. :try_end_e} :catch_a
    .catch Ljava/lang/Error; {:try_start_e .. :try_end_e} :catch_f

    goto :goto_11

    :catch_a
    move-exception v0

    move-object v4, v0

    move-object v5, v12

    move-object v12, v9

    move-object v9, v14

    move-object v14, v10

    move-object v10, v15

    move-object v15, v11

    goto :goto_b

    :cond_1d
    const/4 v4, 0x0

    :goto_11
    move-object v5, v12

    move-object v12, v9

    move-object v9, v14

    move-object v14, v10

    move-object v10, v15

    move-object v15, v11

    move-object v11, v8

    const/4 v8, 0x1

    goto :goto_16

    :catch_b
    move-exception v0

    move-object v4, v0

    const/4 v5, 0x0

    const/4 v9, 0x0

    const/4 v10, 0x0

    const/4 v11, 0x0

    :goto_12
    const/4 v12, 0x0

    :goto_13
    const/4 v13, 0x0

    const/4 v14, 0x0

    :goto_14
    const/4 v15, 0x0

    :goto_15
    :try_start_f
    invoke-virtual {v4}, Ljava/lang/Exception;->printStackTrace()V

    const/4 v4, 0x0

    const/4 v8, 0x0

    :goto_16
    if-eqz v8, :cond_1f

    new-instance v7, Lcom/baidu/location/Address$Builder;

    invoke-direct {v7}, Lcom/baidu/location/Address$Builder;-><init>()V

    invoke-virtual {v7, v9}, Lcom/baidu/location/Address$Builder;->country(Ljava/lang/String;)Lcom/baidu/location/Address$Builder;

    move-result-object v7

    invoke-virtual {v7, v10}, Lcom/baidu/location/Address$Builder;->countryCode(Ljava/lang/String;)Lcom/baidu/location/Address$Builder;

    move-result-object v7

    invoke-virtual {v7, v11}, Lcom/baidu/location/Address$Builder;->province(Ljava/lang/String;)Lcom/baidu/location/Address$Builder;

    move-result-object v7

    invoke-virtual {v7, v12}, Lcom/baidu/location/Address$Builder;->city(Ljava/lang/String;)Lcom/baidu/location/Address$Builder;

    move-result-object v7

    invoke-virtual {v7, v13}, Lcom/baidu/location/Address$Builder;->cityCode(Ljava/lang/String;)Lcom/baidu/location/Address$Builder;

    move-result-object v7

    invoke-virtual {v7, v14}, Lcom/baidu/location/Address$Builder;->district(Ljava/lang/String;)Lcom/baidu/location/Address$Builder;

    move-result-object v7

    invoke-virtual {v7, v15}, Lcom/baidu/location/Address$Builder;->street(Ljava/lang/String;)Lcom/baidu/location/Address$Builder;

    move-result-object v7

    invoke-virtual {v7, v5}, Lcom/baidu/location/Address$Builder;->streetNumber(Ljava/lang/String;)Lcom/baidu/location/Address$Builder;

    move-result-object v5

    invoke-virtual {v5, v4}, Lcom/baidu/location/Address$Builder;->adcode(Ljava/lang/String;)Lcom/baidu/location/Address$Builder;

    move-result-object v4

    invoke-virtual {v4}, Lcom/baidu/location/Address$Builder;->build()Lcom/baidu/location/Address;

    move-result-object v4

    iput-object v4, v1, Lcom/baidu/location/BDLocation;->u:Lcom/baidu/location/Address;

    iput-boolean v6, v1, Lcom/baidu/location/BDLocation;->o:Z

    goto :goto_17

    :cond_1e
    iput-boolean v3, v1, Lcom/baidu/location/BDLocation;->o:Z

    const/4 v4, 0x0

    invoke-virtual {v1, v4}, Lcom/baidu/location/BDLocation;->setAddrStr(Ljava/lang/String;)V

    :cond_1f
    :goto_17
    const-string v4, "floor"

    invoke-virtual {v2, v4}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v4

    if-eqz v4, :cond_20

    const-string v4, "floor"

    invoke-virtual {v2, v4}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    iput-object v4, v1, Lcom/baidu/location/BDLocation;->v:Ljava/lang/String;

    iget-object v4, v1, Lcom/baidu/location/BDLocation;->v:Ljava/lang/String;

    invoke-static {v4}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v4

    if-eqz v4, :cond_20

    const/4 v4, 0x0

    iput-object v4, v1, Lcom/baidu/location/BDLocation;->v:Ljava/lang/String;

    :cond_20
    const-string v4, "indoor"

    invoke-virtual {v2, v4}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v4

    if-eqz v4, :cond_21

    const-string v4, "indoor"

    invoke-virtual {v2, v4}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-static {v4}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v5

    if-nez v5, :cond_21

    invoke-static {v4}, Ljava/lang/Integer;->valueOf(Ljava/lang/String;)Ljava/lang/Integer;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/Integer;->intValue()I

    move-result v4

    invoke-virtual {v1, v4}, Lcom/baidu/location/BDLocation;->setUserIndoorState(I)V

    :cond_21
    const-string v4, "loctp"

    invoke-virtual {v2, v4}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v4

    if-eqz v4, :cond_22

    const-string v4, "loctp"

    invoke-virtual {v2, v4}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    iput-object v4, v1, Lcom/baidu/location/BDLocation;->B:Ljava/lang/String;

    iget-object v4, v1, Lcom/baidu/location/BDLocation;->B:Ljava/lang/String;

    invoke-static {v4}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v4

    if-eqz v4, :cond_22

    const/4 v4, 0x0

    iput-object v4, v1, Lcom/baidu/location/BDLocation;->B:Ljava/lang/String;

    :cond_22
    const-string v4, "bldgid"

    invoke-virtual {v2, v4}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v4

    if-eqz v4, :cond_23

    const-string v4, "bldgid"

    invoke-virtual {v2, v4}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    iput-object v4, v1, Lcom/baidu/location/BDLocation;->w:Ljava/lang/String;

    iget-object v4, v1, Lcom/baidu/location/BDLocation;->w:Ljava/lang/String;

    invoke-static {v4}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v4

    if-eqz v4, :cond_23

    const/4 v4, 0x0

    iput-object v4, v1, Lcom/baidu/location/BDLocation;->w:Ljava/lang/String;

    :cond_23
    const-string v4, "bldg"

    invoke-virtual {v2, v4}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v4

    if-eqz v4, :cond_24

    const-string v4, "bldg"

    invoke-virtual {v2, v4}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    iput-object v4, v1, Lcom/baidu/location/BDLocation;->x:Ljava/lang/String;

    iget-object v4, v1, Lcom/baidu/location/BDLocation;->x:Ljava/lang/String;

    invoke-static {v4}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v4

    if-eqz v4, :cond_24

    const/4 v4, 0x0

    iput-object v4, v1, Lcom/baidu/location/BDLocation;->x:Ljava/lang/String;

    :cond_24
    const-string v4, "ibav"

    invoke-virtual {v2, v4}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v4

    if-eqz v4, :cond_27

    const-string v4, "ibav"

    invoke-virtual {v2, v4}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-static {v4}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v5

    if-eqz v5, :cond_25

    :goto_18
    iput v3, v1, Lcom/baidu/location/BDLocation;->z:I

    goto :goto_19

    :cond_25
    const-string v5, "0"

    invoke-virtual {v4, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_26

    goto :goto_18

    :cond_26
    invoke-static {v4}, Ljava/lang/Integer;->valueOf(Ljava/lang/String;)Ljava/lang/Integer;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/Integer;->intValue()I

    move-result v4

    iput v4, v1, Lcom/baidu/location/BDLocation;->z:I

    :cond_27
    :goto_19
    const-string v4, "indoorflags"

    invoke-virtual {v2, v4}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v4
    :try_end_f
    .catch Ljava/lang/Exception; {:try_start_f .. :try_end_f} :catch_10
    .catch Ljava/lang/Error; {:try_start_f .. :try_end_f} :catch_f

    if-eqz v4, :cond_2e

    :try_start_10
    const-string v4, "indoorflags"

    invoke-virtual {v2, v4}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v4

    const-string v5, "area"

    invoke-virtual {v4, v5}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v5

    if-eqz v5, :cond_29

    const-string v5, "area"

    invoke-virtual {v4, v5}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    invoke-static {v5}, Ljava/lang/Integer;->valueOf(Ljava/lang/String;)Ljava/lang/Integer;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/Integer;->intValue()I

    move-result v5

    if-nez v5, :cond_28

    const/4 v7, 0x2

    invoke-virtual {v1, v7}, Lcom/baidu/location/BDLocation;->setIndoorLocationSurpport(I)V

    goto :goto_1a

    :cond_28
    if-ne v5, v6, :cond_29

    invoke-virtual {v1, v6}, Lcom/baidu/location/BDLocation;->setIndoorLocationSurpport(I)V

    :cond_29
    :goto_1a
    const-string v5, "support"

    invoke-virtual {v4, v5}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v5

    if-eqz v5, :cond_2a

    const-string v5, "support"

    invoke-virtual {v4, v5}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    invoke-static {v5}, Ljava/lang/Integer;->valueOf(Ljava/lang/String;)Ljava/lang/Integer;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/Integer;->intValue()I

    move-result v5

    invoke-virtual {v1, v5}, Lcom/baidu/location/BDLocation;->setIndoorLocationSource(I)V

    :cond_2a
    const-string v5, "inbldg"

    invoke-virtual {v4, v5}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v5

    if-eqz v5, :cond_2b

    const-string v5, "inbldg"

    invoke-virtual {v4, v5}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    iput-object v5, v1, Lcom/baidu/location/BDLocation;->I:Ljava/lang/String;

    :cond_2b
    const-string v5, "inbldgid"

    invoke-virtual {v4, v5}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v5

    if-eqz v5, :cond_2c

    const-string v5, "inbldgid"

    invoke-virtual {v4, v5}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    iput-object v5, v1, Lcom/baidu/location/BDLocation;->J:Ljava/lang/String;

    :cond_2c
    const-string v5, "polygon"

    invoke-virtual {v4, v5}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v5

    if-eqz v5, :cond_2d

    const-string v5, "polygon"

    invoke-virtual {v4, v5}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v1, v5}, Lcom/baidu/location/BDLocation;->setIndoorSurpportPolygon(Ljava/lang/String;)V

    :cond_2d
    const-string v5, "ret_fields"

    invoke-virtual {v4, v5}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v5
    :try_end_10
    .catch Ljava/lang/Exception; {:try_start_10 .. :try_end_10} :catch_d
    .catch Ljava/lang/Error; {:try_start_10 .. :try_end_10} :catch_f

    if-eqz v5, :cond_2e

    :try_start_11
    const-string v5, "ret_fields"

    invoke-virtual {v4, v5}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    const-string v5, "\\|"

    invoke-virtual {v4, v5}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v4

    array-length v5, v4

    const/4 v7, 0x0

    :goto_1b
    if-ge v7, v5, :cond_2e

    aget-object v8, v4, v7

    const-string v9, "="

    invoke-virtual {v8, v9}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v8

    aget-object v9, v8, v3

    aget-object v8, v8, v6

    iget-object v10, v1, Lcom/baidu/location/BDLocation;->O:Ljava/util/HashMap;

    invoke-virtual {v10, v9, v8}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    :try_end_11
    .catch Ljava/lang/Exception; {:try_start_11 .. :try_end_11} :catch_c
    .catch Ljava/lang/Error; {:try_start_11 .. :try_end_11} :catch_f

    add-int/lit8 v7, v7, 0x1

    goto :goto_1b

    :catch_c
    move-exception v0

    move-object v4, v0

    :try_start_12
    invoke-virtual {v4}, Ljava/lang/Exception;->printStackTrace()V
    :try_end_12
    .catch Ljava/lang/Exception; {:try_start_12 .. :try_end_12} :catch_d
    .catch Ljava/lang/Error; {:try_start_12 .. :try_end_12} :catch_f

    goto :goto_1c

    :catch_d
    move-exception v0

    move-object v4, v0

    :try_start_13
    invoke-virtual {v4}, Ljava/lang/Exception;->printStackTrace()V

    :cond_2e
    :goto_1c
    const-string v4, "gpscs"

    invoke-virtual {v2, v4}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v4

    if-eqz v4, :cond_2f

    const-string v4, "gpscs"

    invoke-virtual {v2, v4}, Lorg/json/JSONObject;->getInt(Ljava/lang/String;)I

    move-result v4

    invoke-virtual {v1, v4}, Lcom/baidu/location/BDLocation;->setGpsCheckStatus(I)V

    goto :goto_1d

    :cond_2f
    invoke-virtual {v1, v3}, Lcom/baidu/location/BDLocation;->setGpsCheckStatus(I)V
    :try_end_13
    .catch Ljava/lang/Exception; {:try_start_13 .. :try_end_13} :catch_10
    .catch Ljava/lang/Error; {:try_start_13 .. :try_end_13} :catch_f

    :goto_1d
    :try_start_14
    const-string v4, "in_cn"

    invoke-virtual {v2, v4}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v4

    if-eqz v4, :cond_30

    const-string v4, "in_cn"

    invoke-virtual {v2, v4}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v2

    invoke-virtual {v1, v2}, Lcom/baidu/location/BDLocation;->setLocationWhere(I)V

    goto :goto_1e

    :cond_30
    invoke-virtual {v1, v6}, Lcom/baidu/location/BDLocation;->setLocationWhere(I)V
    :try_end_14
    .catch Ljava/lang/Exception; {:try_start_14 .. :try_end_14} :catch_e
    .catch Ljava/lang/Error; {:try_start_14 .. :try_end_14} :catch_f

    goto :goto_1e

    :catch_e
    move-exception v0

    :goto_1e
    :try_start_15
    iget v2, v1, Lcom/baidu/location/BDLocation;->A:I

    if-nez v2, :cond_31

    const-string v2, "wgs84"

    goto/16 :goto_2

    :cond_31
    const-string v2, "gcj02"

    goto/16 :goto_2

    :cond_32
    const/16 v2, 0x42

    if-eq v8, v2, :cond_34

    const/16 v2, 0x44

    if-ne v8, v2, :cond_33

    goto :goto_1f

    :cond_33
    const/16 v2, 0xa7

    if-ne v8, v2, :cond_35

    const/4 v2, 0x2

    invoke-virtual {v1, v2}, Lcom/baidu/location/BDLocation;->setLocationWhere(I)V

    goto :goto_21

    :cond_34
    :goto_1f
    const-string v2, "content"

    invoke-virtual {v7, v2}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v2

    const-string v4, "point"

    invoke-virtual {v2, v4}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v4

    const-string v5, "y"

    invoke-virtual {v4, v5}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    invoke-static {v5}, Ljava/lang/Double;->parseDouble(Ljava/lang/String;)D

    move-result-wide v5

    invoke-virtual {v1, v5, v6}, Lcom/baidu/location/BDLocation;->setLatitude(D)V

    const-string v5, "x"

    invoke-virtual {v4, v5}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-static {v4}, Ljava/lang/Double;->parseDouble(Ljava/lang/String;)D

    move-result-wide v4

    invoke-virtual {v1, v4, v5}, Lcom/baidu/location/BDLocation;->setLongitude(D)V

    const-string v4, "radius"

    invoke-virtual {v2, v4}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-static {v4}, Ljava/lang/Float;->parseFloat(Ljava/lang/String;)F

    move-result v4

    invoke-virtual {v1, v4}, Lcom/baidu/location/BDLocation;->setRadius(F)V

    const-string v4, "isCellChanged"

    invoke-virtual {v2, v4}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Ljava/lang/Boolean;->parseBoolean(Ljava/lang/String;)Z

    move-result v2

    invoke-static {v2}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v2

    invoke-direct {v1, v2}, Lcom/baidu/location/BDLocation;->a(Ljava/lang/Boolean;)V

    const-string v2, "gcj02"
    :try_end_15
    .catch Ljava/lang/Exception; {:try_start_15 .. :try_end_15} :catch_10
    .catch Ljava/lang/Error; {:try_start_15 .. :try_end_15} :catch_f

    goto/16 :goto_2

    :catch_f
    move-exception v0

    move-object v2, v0

    invoke-virtual {v2}, Ljava/lang/Error;->printStackTrace()V

    goto :goto_20

    :catch_10
    move-exception v0

    move-object v2, v0

    invoke-virtual {v2}, Ljava/lang/Exception;->printStackTrace()V

    :goto_20
    iput v3, v1, Lcom/baidu/location/BDLocation;->a:I

    iput-boolean v3, v1, Lcom/baidu/location/BDLocation;->o:Z

    :cond_35
    :goto_21
    return-void
.end method

.method private a(Ljava/lang/Boolean;)V
    .locals 0

    invoke-virtual {p1}, Ljava/lang/Boolean;->booleanValue()Z

    move-result p1

    iput-boolean p1, p0, Lcom/baidu/location/BDLocation;->t:Z

    return-void
.end method


# virtual methods
.method public describeContents()I
    .locals 1

    const/4 v0, 0x0

    return v0
.end method

.method public getAdCode()Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lcom/baidu/location/BDLocation;->u:Lcom/baidu/location/Address;

    iget-object v0, v0, Lcom/baidu/location/Address;->adcode:Ljava/lang/String;

    return-object v0
.end method

.method public getAddrStr()Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lcom/baidu/location/BDLocation;->u:Lcom/baidu/location/Address;

    iget-object v0, v0, Lcom/baidu/location/Address;->address:Ljava/lang/String;

    return-object v0
.end method

.method public getAddress()Lcom/baidu/location/Address;
    .locals 1

    iget-object v0, p0, Lcom/baidu/location/BDLocation;->u:Lcom/baidu/location/Address;

    return-object v0
.end method

.method public getAltitude()D
    .locals 2

    iget-wide v0, p0, Lcom/baidu/location/BDLocation;->f:D

    return-wide v0
.end method

.method public getBuildingID()Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lcom/baidu/location/BDLocation;->w:Ljava/lang/String;

    return-object v0
.end method

.method public getBuildingName()Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lcom/baidu/location/BDLocation;->x:Ljava/lang/String;

    return-object v0
.end method

.method public getCity()Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lcom/baidu/location/BDLocation;->u:Lcom/baidu/location/Address;

    iget-object v0, v0, Lcom/baidu/location/Address;->city:Ljava/lang/String;

    return-object v0
.end method

.method public getCityCode()Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lcom/baidu/location/BDLocation;->u:Lcom/baidu/location/Address;

    iget-object v0, v0, Lcom/baidu/location/Address;->cityCode:Ljava/lang/String;

    return-object v0
.end method

.method public getCoorType()Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lcom/baidu/location/BDLocation;->n:Ljava/lang/String;

    return-object v0
.end method

.method public getCountry()Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lcom/baidu/location/BDLocation;->u:Lcom/baidu/location/Address;

    iget-object v0, v0, Lcom/baidu/location/Address;->country:Ljava/lang/String;

    return-object v0
.end method

.method public getCountryCode()Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lcom/baidu/location/BDLocation;->u:Lcom/baidu/location/Address;

    iget-object v0, v0, Lcom/baidu/location/Address;->countryCode:Ljava/lang/String;

    return-object v0
.end method

.method public getDerect()F
    .locals 1
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    iget v0, p0, Lcom/baidu/location/BDLocation;->m:F

    return v0
.end method

.method public getDirection()F
    .locals 1

    iget v0, p0, Lcom/baidu/location/BDLocation;->m:F

    return v0
.end method

.method public getDistrict()Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lcom/baidu/location/BDLocation;->u:Lcom/baidu/location/Address;

    iget-object v0, v0, Lcom/baidu/location/Address;->district:Ljava/lang/String;

    return-object v0
.end method

.method public getFloor()Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lcom/baidu/location/BDLocation;->v:Ljava/lang/String;

    return-object v0
.end method

.method public getGpsAccuracyStatus()I
    .locals 1

    iget v0, p0, Lcom/baidu/location/BDLocation;->P:I

    return v0
.end method

.method public getGpsCheckStatus()I
    .locals 1

    iget v0, p0, Lcom/baidu/location/BDLocation;->Q:I

    return v0
.end method

.method public getIndoorLocationSource()I
    .locals 1

    iget v0, p0, Lcom/baidu/location/BDLocation;->H:I

    return v0
.end method

.method public getIndoorLocationSurpport()I
    .locals 1

    iget v0, p0, Lcom/baidu/location/BDLocation;->F:I

    return v0
.end method

.method public getIndoorLocationSurpportBuidlingID()Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lcom/baidu/location/BDLocation;->J:Ljava/lang/String;

    return-object v0
.end method

.method public getIndoorLocationSurpportBuidlingName()Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lcom/baidu/location/BDLocation;->I:Ljava/lang/String;

    return-object v0
.end method

.method public getIndoorNetworkState()I
    .locals 1

    iget v0, p0, Lcom/baidu/location/BDLocation;->G:I

    return v0
.end method

.method public getIndoorSurpportPolygon()Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lcom/baidu/location/BDLocation;->K:Ljava/lang/String;

    return-object v0
.end method

.method public getLatitude()D
    .locals 2

    iget-wide v0, p0, Lcom/baidu/location/BDLocation;->c:D

    return-wide v0
.end method

.method public getLocType()I
    .locals 1

    iget v0, p0, Lcom/baidu/location/BDLocation;->a:I

    return v0
.end method

.method public getLocTypeDescription()Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lcom/baidu/location/BDLocation;->M:Ljava/lang/String;

    return-object v0
.end method

.method public getLocationDescribe()Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lcom/baidu/location/BDLocation;->q:Ljava/lang/String;

    return-object v0
.end method

.method public getLocationID()Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lcom/baidu/location/BDLocation;->N:Ljava/lang/String;

    return-object v0
.end method

.method public getLocationWhere()I
    .locals 1

    iget v0, p0, Lcom/baidu/location/BDLocation;->A:I

    return v0
.end method

.method public getLongitude()D
    .locals 2

    iget-wide v0, p0, Lcom/baidu/location/BDLocation;->d:D

    return-wide v0
.end method

.method public getNetworkLocationType()Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lcom/baidu/location/BDLocation;->B:Ljava/lang/String;

    return-object v0
.end method

.method public getOperators()I
    .locals 1

    iget v0, p0, Lcom/baidu/location/BDLocation;->C:I

    return v0
.end method

.method public getPoiList()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List<",
            "Lcom/baidu/location/Poi;",
            ">;"
        }
    .end annotation

    iget-object v0, p0, Lcom/baidu/location/BDLocation;->L:Ljava/util/List;

    return-object v0
.end method

.method public getProvince()Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lcom/baidu/location/BDLocation;->u:Lcom/baidu/location/Address;

    iget-object v0, v0, Lcom/baidu/location/Address;->province:Ljava/lang/String;

    return-object v0
.end method

.method public getRadius()F
    .locals 1

    iget v0, p0, Lcom/baidu/location/BDLocation;->j:F

    return v0
.end method

.method public getRetFields(Ljava/lang/String;)Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lcom/baidu/location/BDLocation;->O:Ljava/util/HashMap;

    invoke-virtual {v0, p1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object p1

    check-cast p1, Ljava/lang/String;

    return-object p1
.end method

.method public getSatelliteNumber()I
    .locals 1

    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/baidu/location/BDLocation;->k:Z

    iget v0, p0, Lcom/baidu/location/BDLocation;->l:I

    return v0
.end method

.method public getSemaAptag()Ljava/lang/String;
    .locals 1
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    iget-object v0, p0, Lcom/baidu/location/BDLocation;->q:Ljava/lang/String;

    return-object v0
.end method

.method public getSpeed()F
    .locals 1

    iget v0, p0, Lcom/baidu/location/BDLocation;->h:F

    return v0
.end method

.method public getStreet()Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lcom/baidu/location/BDLocation;->u:Lcom/baidu/location/Address;

    iget-object v0, v0, Lcom/baidu/location/Address;->street:Ljava/lang/String;

    return-object v0
.end method

.method public getStreetNumber()Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lcom/baidu/location/BDLocation;->u:Lcom/baidu/location/Address;

    iget-object v0, v0, Lcom/baidu/location/Address;->streetNumber:Ljava/lang/String;

    return-object v0
.end method

.method public getTime()Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lcom/baidu/location/BDLocation;->b:Ljava/lang/String;

    return-object v0
.end method

.method public getUserIndoorState()I
    .locals 1

    iget v0, p0, Lcom/baidu/location/BDLocation;->E:I

    return v0
.end method

.method public hasAddr()Z
    .locals 1

    iget-boolean v0, p0, Lcom/baidu/location/BDLocation;->o:Z

    return v0
.end method

.method public hasAltitude()Z
    .locals 1

    iget-boolean v0, p0, Lcom/baidu/location/BDLocation;->e:Z

    return v0
.end method

.method public hasRadius()Z
    .locals 1

    iget-boolean v0, p0, Lcom/baidu/location/BDLocation;->i:Z

    return v0
.end method

.method public hasSateNumber()Z
    .locals 1

    iget-boolean v0, p0, Lcom/baidu/location/BDLocation;->k:Z

    return v0
.end method

.method public hasSpeed()Z
    .locals 1

    iget-boolean v0, p0, Lcom/baidu/location/BDLocation;->g:Z

    return v0
.end method

.method public isCellChangeFlag()Z
    .locals 1

    iget-boolean v0, p0, Lcom/baidu/location/BDLocation;->t:Z

    return v0
.end method

.method public isIndoorLocMode()Z
    .locals 1

    iget-boolean v0, p0, Lcom/baidu/location/BDLocation;->y:Z

    return v0
.end method

.method public isParkAvailable()I
    .locals 1

    iget v0, p0, Lcom/baidu/location/BDLocation;->z:I

    return v0
.end method

.method public setAddr(Lcom/baidu/location/Address;)V
    .locals 0

    if-eqz p1, :cond_0

    iput-object p1, p0, Lcom/baidu/location/BDLocation;->u:Lcom/baidu/location/Address;

    const/4 p1, 0x1

    iput-boolean p1, p0, Lcom/baidu/location/BDLocation;->o:Z

    :cond_0
    return-void
.end method

.method public setAddrStr(Ljava/lang/String;)V
    .locals 0

    iput-object p1, p0, Lcom/baidu/location/BDLocation;->p:Ljava/lang/String;

    if-nez p1, :cond_0

    const/4 p1, 0x0

    goto :goto_0

    :cond_0
    const/4 p1, 0x1

    :goto_0
    iput-boolean p1, p0, Lcom/baidu/location/BDLocation;->o:Z

    return-void
.end method

.method public setAltitude(D)V
    .locals 0

    iput-wide p1, p0, Lcom/baidu/location/BDLocation;->f:D

    const/4 p1, 0x1

    iput-boolean p1, p0, Lcom/baidu/location/BDLocation;->e:Z

    return-void
.end method

.method public setBuildingID(Ljava/lang/String;)V
    .locals 0

    iput-object p1, p0, Lcom/baidu/location/BDLocation;->w:Ljava/lang/String;

    return-void
.end method

.method public setBuildingName(Ljava/lang/String;)V
    .locals 0

    iput-object p1, p0, Lcom/baidu/location/BDLocation;->x:Ljava/lang/String;

    return-void
.end method

.method public setCoorType(Ljava/lang/String;)V
    .locals 0

    iput-object p1, p0, Lcom/baidu/location/BDLocation;->n:Ljava/lang/String;

    return-void
.end method

.method public setDirection(F)V
    .locals 0

    iput p1, p0, Lcom/baidu/location/BDLocation;->m:F

    return-void
.end method

.method public setFloor(Ljava/lang/String;)V
    .locals 0

    iput-object p1, p0, Lcom/baidu/location/BDLocation;->v:Ljava/lang/String;

    return-void
.end method

.method public setGpsAccuracyStatus(I)V
    .locals 0

    iput p1, p0, Lcom/baidu/location/BDLocation;->P:I

    return-void
.end method

.method public setGpsCheckStatus(I)V
    .locals 0

    iput p1, p0, Lcom/baidu/location/BDLocation;->Q:I

    return-void
.end method

.method public setIndoorLocMode(Z)V
    .locals 0

    iput-boolean p1, p0, Lcom/baidu/location/BDLocation;->y:Z

    return-void
.end method

.method public setIndoorLocationSource(I)V
    .locals 0

    iput p1, p0, Lcom/baidu/location/BDLocation;->H:I

    return-void
.end method

.method public setIndoorLocationSurpport(I)V
    .locals 0

    iput p1, p0, Lcom/baidu/location/BDLocation;->F:I

    return-void
.end method

.method public setIndoorNetworkState(I)V
    .locals 0

    iput p1, p0, Lcom/baidu/location/BDLocation;->G:I

    return-void
.end method

.method public setIndoorSurpportPolygon(Ljava/lang/String;)V
    .locals 0

    iput-object p1, p0, Lcom/baidu/location/BDLocation;->K:Ljava/lang/String;

    return-void
.end method

.method public setLatitude(D)V
    .locals 0

    iput-wide p1, p0, Lcom/baidu/location/BDLocation;->c:D

    return-void
.end method

.method public setLocType(I)V
    .locals 0

    iput p1, p0, Lcom/baidu/location/BDLocation;->a:I

    sparse-switch p1, :sswitch_data_0

    const-string p1, "UnKnown!"

    :goto_0
    invoke-virtual {p0, p1}, Lcom/baidu/location/BDLocation;->setLocTypeDescription(Ljava/lang/String;)V

    goto :goto_1

    :sswitch_0
    const-string p1, "NetWork location failed because baidu location service check the key is unlegal, please check the key in AndroidManifest.xml !"

    goto :goto_0

    :sswitch_1
    const-string p1, "NetWork location failed because baidu location service can not caculate the location!"

    goto :goto_0

    :sswitch_2
    const-string p1, "NetWork location failed because baidu location service can not decrypt the request query, please check the so file !"

    goto :goto_0

    :sswitch_3
    const-string p1, "NetWork location successful!"

    goto :goto_0

    :sswitch_4
    const-string p1, "Offline location successful!"

    goto :goto_0

    :sswitch_5
    const-string p1, "Offline location failed, please check the net (wifi/cell)!"

    goto :goto_0

    :sswitch_6
    const-string p1, "Location failed beacuse we can not get any loc information!"

    goto :goto_0

    :sswitch_7
    const-string p1, "GPS location successful!"

    invoke-virtual {p0, p1}, Lcom/baidu/location/BDLocation;->setLocTypeDescription(Ljava/lang/String;)V

    const/4 p1, 0x0

    invoke-virtual {p0, p1}, Lcom/baidu/location/BDLocation;->setUserIndoorState(I)V

    :goto_1
    return-void

    :sswitch_data_0
    .sparse-switch
        0x3d -> :sswitch_7
        0x3e -> :sswitch_6
        0x3f -> :sswitch_5
        0x42 -> :sswitch_4
        0x43 -> :sswitch_5
        0xa1 -> :sswitch_3
        0xa2 -> :sswitch_2
        0xa7 -> :sswitch_1
        0x1f9 -> :sswitch_0
    .end sparse-switch
.end method

.method public setLocTypeDescription(Ljava/lang/String;)V
    .locals 0

    iput-object p1, p0, Lcom/baidu/location/BDLocation;->M:Ljava/lang/String;

    return-void
.end method

.method public setLocationDescribe(Ljava/lang/String;)V
    .locals 0

    iput-object p1, p0, Lcom/baidu/location/BDLocation;->q:Ljava/lang/String;

    return-void
.end method

.method public setLocationID(Ljava/lang/String;)V
    .locals 0

    iput-object p1, p0, Lcom/baidu/location/BDLocation;->N:Ljava/lang/String;

    return-void
.end method

.method public setLocationWhere(I)V
    .locals 0

    iput p1, p0, Lcom/baidu/location/BDLocation;->A:I

    return-void
.end method

.method public setLongitude(D)V
    .locals 0

    iput-wide p1, p0, Lcom/baidu/location/BDLocation;->d:D

    return-void
.end method

.method public setNetworkLocationType(Ljava/lang/String;)V
    .locals 0

    iput-object p1, p0, Lcom/baidu/location/BDLocation;->B:Ljava/lang/String;

    return-void
.end method

.method public setOperators(I)V
    .locals 0

    iput p1, p0, Lcom/baidu/location/BDLocation;->C:I

    return-void
.end method

.method public setParkAvailable(I)V
    .locals 0

    iput p1, p0, Lcom/baidu/location/BDLocation;->z:I

    return-void
.end method

.method public setPoiList(Ljava/util/List;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List<",
            "Lcom/baidu/location/Poi;",
            ">;)V"
        }
    .end annotation

    iput-object p1, p0, Lcom/baidu/location/BDLocation;->L:Ljava/util/List;

    return-void
.end method

.method public setRadius(F)V
    .locals 0

    iput p1, p0, Lcom/baidu/location/BDLocation;->j:F

    const/4 p1, 0x1

    iput-boolean p1, p0, Lcom/baidu/location/BDLocation;->i:Z

    return-void
.end method

.method public setSatelliteNumber(I)V
    .locals 0

    iput p1, p0, Lcom/baidu/location/BDLocation;->l:I

    return-void
.end method

.method public setSpeed(F)V
    .locals 0

    iput p1, p0, Lcom/baidu/location/BDLocation;->h:F

    const/4 p1, 0x1

    iput-boolean p1, p0, Lcom/baidu/location/BDLocation;->g:Z

    return-void
.end method

.method public setTime(Ljava/lang/String;)V
    .locals 0

    iput-object p1, p0, Lcom/baidu/location/BDLocation;->b:Ljava/lang/String;

    invoke-static {p1}, Lcom/baidu/location/d/j;->a(Ljava/lang/String;)Ljava/lang/String;

    move-result-object p1

    invoke-virtual {p0, p1}, Lcom/baidu/location/BDLocation;->setLocationID(Ljava/lang/String;)V

    return-void
.end method

.method public setUserIndoorState(I)V
    .locals 0

    iput p1, p0, Lcom/baidu/location/BDLocation;->E:I

    return-void
.end method

.method public writeToParcel(Landroid/os/Parcel;I)V
    .locals 2

    iget p2, p0, Lcom/baidu/location/BDLocation;->a:I

    invoke-virtual {p1, p2}, Landroid/os/Parcel;->writeInt(I)V

    iget-object p2, p0, Lcom/baidu/location/BDLocation;->b:Ljava/lang/String;

    invoke-virtual {p1, p2}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    iget-wide v0, p0, Lcom/baidu/location/BDLocation;->c:D

    invoke-virtual {p1, v0, v1}, Landroid/os/Parcel;->writeDouble(D)V

    iget-wide v0, p0, Lcom/baidu/location/BDLocation;->d:D

    invoke-virtual {p1, v0, v1}, Landroid/os/Parcel;->writeDouble(D)V

    iget-wide v0, p0, Lcom/baidu/location/BDLocation;->f:D

    invoke-virtual {p1, v0, v1}, Landroid/os/Parcel;->writeDouble(D)V

    iget p2, p0, Lcom/baidu/location/BDLocation;->h:F

    invoke-virtual {p1, p2}, Landroid/os/Parcel;->writeFloat(F)V

    iget p2, p0, Lcom/baidu/location/BDLocation;->j:F

    invoke-virtual {p1, p2}, Landroid/os/Parcel;->writeFloat(F)V

    iget p2, p0, Lcom/baidu/location/BDLocation;->l:I

    invoke-virtual {p1, p2}, Landroid/os/Parcel;->writeInt(I)V

    iget p2, p0, Lcom/baidu/location/BDLocation;->m:F

    invoke-virtual {p1, p2}, Landroid/os/Parcel;->writeFloat(F)V

    iget-object p2, p0, Lcom/baidu/location/BDLocation;->v:Ljava/lang/String;

    invoke-virtual {p1, p2}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    iget p2, p0, Lcom/baidu/location/BDLocation;->z:I

    invoke-virtual {p1, p2}, Landroid/os/Parcel;->writeInt(I)V

    iget-object p2, p0, Lcom/baidu/location/BDLocation;->w:Ljava/lang/String;

    invoke-virtual {p1, p2}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    iget-object p2, p0, Lcom/baidu/location/BDLocation;->x:Ljava/lang/String;

    invoke-virtual {p1, p2}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    iget-object p2, p0, Lcom/baidu/location/BDLocation;->B:Ljava/lang/String;

    invoke-virtual {p1, p2}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    iget-object p2, p0, Lcom/baidu/location/BDLocation;->u:Lcom/baidu/location/Address;

    iget-object p2, p2, Lcom/baidu/location/Address;->province:Ljava/lang/String;

    invoke-virtual {p1, p2}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    iget-object p2, p0, Lcom/baidu/location/BDLocation;->u:Lcom/baidu/location/Address;

    iget-object p2, p2, Lcom/baidu/location/Address;->city:Ljava/lang/String;

    invoke-virtual {p1, p2}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    iget-object p2, p0, Lcom/baidu/location/BDLocation;->u:Lcom/baidu/location/Address;

    iget-object p2, p2, Lcom/baidu/location/Address;->district:Ljava/lang/String;

    invoke-virtual {p1, p2}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    iget-object p2, p0, Lcom/baidu/location/BDLocation;->u:Lcom/baidu/location/Address;

    iget-object p2, p2, Lcom/baidu/location/Address;->street:Ljava/lang/String;

    invoke-virtual {p1, p2}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    iget-object p2, p0, Lcom/baidu/location/BDLocation;->u:Lcom/baidu/location/Address;

    iget-object p2, p2, Lcom/baidu/location/Address;->streetNumber:Ljava/lang/String;

    invoke-virtual {p1, p2}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    iget-object p2, p0, Lcom/baidu/location/BDLocation;->u:Lcom/baidu/location/Address;

    iget-object p2, p2, Lcom/baidu/location/Address;->cityCode:Ljava/lang/String;

    invoke-virtual {p1, p2}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    iget-object p2, p0, Lcom/baidu/location/BDLocation;->u:Lcom/baidu/location/Address;

    iget-object p2, p2, Lcom/baidu/location/Address;->address:Ljava/lang/String;

    invoke-virtual {p1, p2}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    iget-object p2, p0, Lcom/baidu/location/BDLocation;->u:Lcom/baidu/location/Address;

    iget-object p2, p2, Lcom/baidu/location/Address;->country:Ljava/lang/String;

    invoke-virtual {p1, p2}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    iget-object p2, p0, Lcom/baidu/location/BDLocation;->u:Lcom/baidu/location/Address;

    iget-object p2, p2, Lcom/baidu/location/Address;->countryCode:Ljava/lang/String;

    invoke-virtual {p1, p2}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    iget-object p2, p0, Lcom/baidu/location/BDLocation;->u:Lcom/baidu/location/Address;

    iget-object p2, p2, Lcom/baidu/location/Address;->adcode:Ljava/lang/String;

    invoke-virtual {p1, p2}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    iget p2, p0, Lcom/baidu/location/BDLocation;->C:I

    invoke-virtual {p1, p2}, Landroid/os/Parcel;->writeInt(I)V

    iget-object p2, p0, Lcom/baidu/location/BDLocation;->D:Ljava/lang/String;

    invoke-virtual {p1, p2}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    iget-object p2, p0, Lcom/baidu/location/BDLocation;->q:Ljava/lang/String;

    invoke-virtual {p1, p2}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    iget-object p2, p0, Lcom/baidu/location/BDLocation;->r:Ljava/lang/String;

    invoke-virtual {p1, p2}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    iget-object p2, p0, Lcom/baidu/location/BDLocation;->s:Ljava/lang/String;

    invoke-virtual {p1, p2}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    iget p2, p0, Lcom/baidu/location/BDLocation;->A:I

    invoke-virtual {p1, p2}, Landroid/os/Parcel;->writeInt(I)V

    iget-object p2, p0, Lcom/baidu/location/BDLocation;->M:Ljava/lang/String;

    invoke-virtual {p1, p2}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    iget p2, p0, Lcom/baidu/location/BDLocation;->E:I

    invoke-virtual {p1, p2}, Landroid/os/Parcel;->writeInt(I)V

    iget p2, p0, Lcom/baidu/location/BDLocation;->F:I

    invoke-virtual {p1, p2}, Landroid/os/Parcel;->writeInt(I)V

    iget p2, p0, Lcom/baidu/location/BDLocation;->G:I

    invoke-virtual {p1, p2}, Landroid/os/Parcel;->writeInt(I)V

    iget p2, p0, Lcom/baidu/location/BDLocation;->H:I

    invoke-virtual {p1, p2}, Landroid/os/Parcel;->writeInt(I)V

    iget-object p2, p0, Lcom/baidu/location/BDLocation;->I:Ljava/lang/String;

    invoke-virtual {p1, p2}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    iget-object p2, p0, Lcom/baidu/location/BDLocation;->J:Ljava/lang/String;

    invoke-virtual {p1, p2}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    iget-object p2, p0, Lcom/baidu/location/BDLocation;->K:Ljava/lang/String;

    invoke-virtual {p1, p2}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    iget p2, p0, Lcom/baidu/location/BDLocation;->P:I

    invoke-virtual {p1, p2}, Landroid/os/Parcel;->writeInt(I)V

    iget-object p2, p0, Lcom/baidu/location/BDLocation;->N:Ljava/lang/String;

    invoke-virtual {p1, p2}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    iget p2, p0, Lcom/baidu/location/BDLocation;->Q:I

    invoke-virtual {p1, p2}, Landroid/os/Parcel;->writeInt(I)V

    const/4 p2, 0x7

    new-array p2, p2, [Z

    iget-boolean v0, p0, Lcom/baidu/location/BDLocation;->e:Z

    const/4 v1, 0x0

    aput-boolean v0, p2, v1

    iget-boolean v0, p0, Lcom/baidu/location/BDLocation;->g:Z

    const/4 v1, 0x1

    aput-boolean v0, p2, v1

    iget-boolean v0, p0, Lcom/baidu/location/BDLocation;->i:Z

    const/4 v1, 0x2

    aput-boolean v0, p2, v1

    iget-boolean v0, p0, Lcom/baidu/location/BDLocation;->k:Z

    const/4 v1, 0x3

    aput-boolean v0, p2, v1

    iget-boolean v0, p0, Lcom/baidu/location/BDLocation;->o:Z

    const/4 v1, 0x4

    aput-boolean v0, p2, v1

    iget-boolean v0, p0, Lcom/baidu/location/BDLocation;->t:Z

    const/4 v1, 0x5

    aput-boolean v0, p2, v1

    iget-boolean v0, p0, Lcom/baidu/location/BDLocation;->y:Z

    const/4 v1, 0x6

    aput-boolean v0, p2, v1

    invoke-virtual {p1, p2}, Landroid/os/Parcel;->writeBooleanArray([Z)V

    iget-object p2, p0, Lcom/baidu/location/BDLocation;->L:Ljava/util/List;

    invoke-virtual {p1, p2}, Landroid/os/Parcel;->writeList(Ljava/util/List;)V

    return-void
.end method
