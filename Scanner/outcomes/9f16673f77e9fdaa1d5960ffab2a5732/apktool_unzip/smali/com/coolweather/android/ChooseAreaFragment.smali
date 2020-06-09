.class public Lcom/coolweather/android/ChooseAreaFragment;
.super Landroid/support/v4/app/Fragment;
.source "ChooseAreaFragment.java"


# static fields
.field public static final LEVEL_CITY:I = 0x1

.field public static final LEVEL_COUNTY:I = 0x2

.field public static final LEVEL_PROVINCE:I = 0x0

.field private static final TAG:Ljava/lang/String; = "ChooseAreaFragment"


# instance fields
.field private adapter:Landroid/widget/ArrayAdapter;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/widget/ArrayAdapter<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private backButton:Landroid/widget/Button;

.field private cityList:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List<",
            "Lcom/coolweather/android/db/City;",
            ">;"
        }
    .end annotation
.end field

.field private countyList:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List<",
            "Lcom/coolweather/android/db/County;",
            ">;"
        }
    .end annotation
.end field

.field private currentLevel:I

.field private dataList:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private listView:Landroid/widget/ListView;

.field private progressDialog:Landroid/app/ProgressDialog;

.field private provinceList:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List<",
            "Lcom/coolweather/android/db/Province;",
            ">;"
        }
    .end annotation
.end field

.field private selectedCity:Lcom/coolweather/android/db/City;

.field private selectedProvince:Lcom/coolweather/android/db/Province;

.field private titleText:Landroid/widget/TextView;


# direct methods
.method public constructor <init>()V
    .locals 1

    .line 34
    invoke-direct {p0}, Landroid/support/v4/app/Fragment;-><init>()V

    .line 54
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/coolweather/android/ChooseAreaFragment;->dataList:Ljava/util/List;

    return-void
.end method

.method static synthetic access$000(Lcom/coolweather/android/ChooseAreaFragment;)I
    .locals 1
    .param p0, "x0"    # Lcom/coolweather/android/ChooseAreaFragment;

    .line 34
    iget v0, p0, Lcom/coolweather/android/ChooseAreaFragment;->currentLevel:I

    return v0
.end method

.method static synthetic access$100(Lcom/coolweather/android/ChooseAreaFragment;)Lcom/coolweather/android/db/Province;
    .locals 1
    .param p0, "x0"    # Lcom/coolweather/android/ChooseAreaFragment;

    .line 34
    iget-object v0, p0, Lcom/coolweather/android/ChooseAreaFragment;->selectedProvince:Lcom/coolweather/android/db/Province;

    return-object v0
.end method

.method static synthetic access$102(Lcom/coolweather/android/ChooseAreaFragment;Lcom/coolweather/android/db/Province;)Lcom/coolweather/android/db/Province;
    .locals 0
    .param p0, "x0"    # Lcom/coolweather/android/ChooseAreaFragment;
    .param p1, "x1"    # Lcom/coolweather/android/db/Province;

    .line 34
    iput-object p1, p0, Lcom/coolweather/android/ChooseAreaFragment;->selectedProvince:Lcom/coolweather/android/db/Province;

    return-object p1
.end method

.method static synthetic access$200(Lcom/coolweather/android/ChooseAreaFragment;)Ljava/util/List;
    .locals 1
    .param p0, "x0"    # Lcom/coolweather/android/ChooseAreaFragment;

    .line 34
    iget-object v0, p0, Lcom/coolweather/android/ChooseAreaFragment;->provinceList:Ljava/util/List;

    return-object v0
.end method

.method static synthetic access$300(Lcom/coolweather/android/ChooseAreaFragment;)V
    .locals 0
    .param p0, "x0"    # Lcom/coolweather/android/ChooseAreaFragment;

    .line 34
    invoke-direct {p0}, Lcom/coolweather/android/ChooseAreaFragment;->queryCities()V

    return-void
.end method

.method static synthetic access$400(Lcom/coolweather/android/ChooseAreaFragment;)Lcom/coolweather/android/db/City;
    .locals 1
    .param p0, "x0"    # Lcom/coolweather/android/ChooseAreaFragment;

    .line 34
    iget-object v0, p0, Lcom/coolweather/android/ChooseAreaFragment;->selectedCity:Lcom/coolweather/android/db/City;

    return-object v0
.end method

.method static synthetic access$402(Lcom/coolweather/android/ChooseAreaFragment;Lcom/coolweather/android/db/City;)Lcom/coolweather/android/db/City;
    .locals 0
    .param p0, "x0"    # Lcom/coolweather/android/ChooseAreaFragment;
    .param p1, "x1"    # Lcom/coolweather/android/db/City;

    .line 34
    iput-object p1, p0, Lcom/coolweather/android/ChooseAreaFragment;->selectedCity:Lcom/coolweather/android/db/City;

    return-object p1
.end method

.method static synthetic access$500(Lcom/coolweather/android/ChooseAreaFragment;)Ljava/util/List;
    .locals 1
    .param p0, "x0"    # Lcom/coolweather/android/ChooseAreaFragment;

    .line 34
    iget-object v0, p0, Lcom/coolweather/android/ChooseAreaFragment;->cityList:Ljava/util/List;

    return-object v0
.end method

.method static synthetic access$600(Lcom/coolweather/android/ChooseAreaFragment;)V
    .locals 0
    .param p0, "x0"    # Lcom/coolweather/android/ChooseAreaFragment;

    .line 34
    invoke-direct {p0}, Lcom/coolweather/android/ChooseAreaFragment;->queryCounties()V

    return-void
.end method

.method static synthetic access$700(Lcom/coolweather/android/ChooseAreaFragment;)Ljava/util/List;
    .locals 1
    .param p0, "x0"    # Lcom/coolweather/android/ChooseAreaFragment;

    .line 34
    iget-object v0, p0, Lcom/coolweather/android/ChooseAreaFragment;->countyList:Ljava/util/List;

    return-object v0
.end method

.method static synthetic access$800(Lcom/coolweather/android/ChooseAreaFragment;)V
    .locals 0
    .param p0, "x0"    # Lcom/coolweather/android/ChooseAreaFragment;

    .line 34
    invoke-direct {p0}, Lcom/coolweather/android/ChooseAreaFragment;->queryProvinces()V

    return-void
.end method

.method static synthetic access$900(Lcom/coolweather/android/ChooseAreaFragment;)V
    .locals 0
    .param p0, "x0"    # Lcom/coolweather/android/ChooseAreaFragment;

    .line 34
    invoke-direct {p0}, Lcom/coolweather/android/ChooseAreaFragment;->closeProgressDialog()V

    return-void
.end method

.method private closeProgressDialog()V
    .locals 1

    .line 270
    iget-object v0, p0, Lcom/coolweather/android/ChooseAreaFragment;->progressDialog:Landroid/app/ProgressDialog;

    if-eqz v0, :cond_0

    .line 271
    invoke-virtual {v0}, Landroid/app/ProgressDialog;->dismiss()V

    goto :goto_0

    .line 270
    :cond_0
    nop

    .line 273
    :goto_0
    return-void
.end method

.method private queryCities()V
    .locals 6

    .line 165
    iget-object v0, p0, Lcom/coolweather/android/ChooseAreaFragment;->titleText:Landroid/widget/TextView;

    iget-object v1, p0, Lcom/coolweather/android/ChooseAreaFragment;->selectedProvince:Lcom/coolweather/android/db/Province;

    invoke-virtual {v1}, Lcom/coolweather/android/db/Province;->getProvinceName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 166
    iget-object v0, p0, Lcom/coolweather/android/ChooseAreaFragment;->backButton:Landroid/widget/Button;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/Button;->setVisibility(I)V

    .line 167
    const/4 v0, 0x2

    new-array v0, v0, [Ljava/lang/String;

    const-string v2, "provinceid = ?"

    aput-object v2, v0, v1

    iget-object v2, p0, Lcom/coolweather/android/ChooseAreaFragment;->selectedProvince:Lcom/coolweather/android/db/Province;

    invoke-virtual {v2}, Lcom/coolweather/android/db/Province;->getId()I

    move-result v2

    invoke-static {v2}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v2

    const/4 v3, 0x1

    aput-object v2, v0, v3

    invoke-static {v0}, Lorg/litepal/crud/DataSupport;->where([Ljava/lang/String;)Lorg/litepal/crud/ClusterQuery;

    move-result-object v0

    const-class v2, Lcom/coolweather/android/db/City;

    invoke-virtual {v0, v2}, Lorg/litepal/crud/ClusterQuery;->find(Ljava/lang/Class;)Ljava/util/List;

    move-result-object v0

    iput-object v0, p0, Lcom/coolweather/android/ChooseAreaFragment;->cityList:Ljava/util/List;

    .line 168
    iget-object v0, p0, Lcom/coolweather/android/ChooseAreaFragment;->cityList:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    if-lez v0, :cond_1

    .line 169
    iget-object v0, p0, Lcom/coolweather/android/ChooseAreaFragment;->dataList:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->clear()V

    .line 170
    iget-object v0, p0, Lcom/coolweather/android/ChooseAreaFragment;->cityList:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v0

    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_0

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/coolweather/android/db/City;

    .line 171
    .local v2, "city":Lcom/coolweather/android/db/City;
    iget-object v4, p0, Lcom/coolweather/android/ChooseAreaFragment;->dataList:Ljava/util/List;

    invoke-virtual {v2}, Lcom/coolweather/android/db/City;->getCityName()Ljava/lang/String;

    move-result-object v5

    invoke-interface {v4, v5}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 172
    .end local v2    # "city":Lcom/coolweather/android/db/City;
    goto :goto_0

    .line 173
    :cond_0
    iget-object v0, p0, Lcom/coolweather/android/ChooseAreaFragment;->adapter:Landroid/widget/ArrayAdapter;

    invoke-virtual {v0}, Landroid/widget/ArrayAdapter;->notifyDataSetChanged()V

    .line 174
    iget-object v0, p0, Lcom/coolweather/android/ChooseAreaFragment;->listView:Landroid/widget/ListView;

    invoke-virtual {v0, v1}, Landroid/widget/ListView;->setSelection(I)V

    .line 175
    iput v3, p0, Lcom/coolweather/android/ChooseAreaFragment;->currentLevel:I

    goto :goto_1

    .line 177
    :cond_1
    iget-object v0, p0, Lcom/coolweather/android/ChooseAreaFragment;->selectedProvince:Lcom/coolweather/android/db/Province;

    invoke-virtual {v0}, Lcom/coolweather/android/db/Province;->getProvinceCode()I

    move-result v0

    .line 178
    .local v0, "provinceCode":I
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "http://guolin.tech/api/china/"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 179
    .local v1, "address":Ljava/lang/String;
    const-string v2, "city"

    invoke-direct {p0, v1, v2}, Lcom/coolweather/android/ChooseAreaFragment;->queryFromServer(Ljava/lang/String;Ljava/lang/String;)V

    .line 181
    .end local v0    # "provinceCode":I
    .end local v1    # "address":Ljava/lang/String;
    :goto_1
    return-void
.end method

.method private queryCounties()V
    .locals 6

    .line 187
    iget-object v0, p0, Lcom/coolweather/android/ChooseAreaFragment;->titleText:Landroid/widget/TextView;

    iget-object v1, p0, Lcom/coolweather/android/ChooseAreaFragment;->selectedCity:Lcom/coolweather/android/db/City;

    invoke-virtual {v1}, Lcom/coolweather/android/db/City;->getCityName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 188
    iget-object v0, p0, Lcom/coolweather/android/ChooseAreaFragment;->backButton:Landroid/widget/Button;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/Button;->setVisibility(I)V

    .line 189
    const/4 v0, 0x2

    new-array v2, v0, [Ljava/lang/String;

    const-string v3, "cityid = ?"

    aput-object v3, v2, v1

    iget-object v3, p0, Lcom/coolweather/android/ChooseAreaFragment;->selectedCity:Lcom/coolweather/android/db/City;

    invoke-virtual {v3}, Lcom/coolweather/android/db/City;->getId()I

    move-result v3

    invoke-static {v3}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v3

    const/4 v4, 0x1

    aput-object v3, v2, v4

    invoke-static {v2}, Lorg/litepal/crud/DataSupport;->where([Ljava/lang/String;)Lorg/litepal/crud/ClusterQuery;

    move-result-object v2

    const-class v3, Lcom/coolweather/android/db/County;

    invoke-virtual {v2, v3}, Lorg/litepal/crud/ClusterQuery;->find(Ljava/lang/Class;)Ljava/util/List;

    move-result-object v2

    iput-object v2, p0, Lcom/coolweather/android/ChooseAreaFragment;->countyList:Ljava/util/List;

    .line 190
    iget-object v2, p0, Lcom/coolweather/android/ChooseAreaFragment;->countyList:Ljava/util/List;

    invoke-interface {v2}, Ljava/util/List;->size()I

    move-result v2

    if-lez v2, :cond_1

    .line 191
    iget-object v2, p0, Lcom/coolweather/android/ChooseAreaFragment;->dataList:Ljava/util/List;

    invoke-interface {v2}, Ljava/util/List;->clear()V

    .line 192
    iget-object v2, p0, Lcom/coolweather/android/ChooseAreaFragment;->countyList:Ljava/util/List;

    invoke-interface {v2}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :goto_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_0

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lcom/coolweather/android/db/County;

    .line 193
    .local v3, "county":Lcom/coolweather/android/db/County;
    iget-object v4, p0, Lcom/coolweather/android/ChooseAreaFragment;->dataList:Ljava/util/List;

    invoke-virtual {v3}, Lcom/coolweather/android/db/County;->getCountyName()Ljava/lang/String;

    move-result-object v5

    invoke-interface {v4, v5}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 194
    .end local v3    # "county":Lcom/coolweather/android/db/County;
    goto :goto_0

    .line 195
    :cond_0
    iget-object v2, p0, Lcom/coolweather/android/ChooseAreaFragment;->adapter:Landroid/widget/ArrayAdapter;

    invoke-virtual {v2}, Landroid/widget/ArrayAdapter;->notifyDataSetChanged()V

    .line 196
    iget-object v2, p0, Lcom/coolweather/android/ChooseAreaFragment;->listView:Landroid/widget/ListView;

    invoke-virtual {v2, v1}, Landroid/widget/ListView;->setSelection(I)V

    .line 197
    iput v0, p0, Lcom/coolweather/android/ChooseAreaFragment;->currentLevel:I

    goto :goto_1

    .line 199
    :cond_1
    iget-object v0, p0, Lcom/coolweather/android/ChooseAreaFragment;->selectedProvince:Lcom/coolweather/android/db/Province;

    invoke-virtual {v0}, Lcom/coolweather/android/db/Province;->getProvinceCode()I

    move-result v0

    .line 200
    .local v0, "provinceCode":I
    iget-object v1, p0, Lcom/coolweather/android/ChooseAreaFragment;->selectedCity:Lcom/coolweather/android/db/City;

    invoke-virtual {v1}, Lcom/coolweather/android/db/City;->getCityCode()I

    move-result v1

    .line 201
    .local v1, "cityCode":I
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "http://guolin.tech/api/china/"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    const-string v3, "/"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v2, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .line 202
    .local v2, "address":Ljava/lang/String;
    const-string v3, "county"

    invoke-direct {p0, v2, v3}, Lcom/coolweather/android/ChooseAreaFragment;->queryFromServer(Ljava/lang/String;Ljava/lang/String;)V

    .line 204
    .end local v0    # "provinceCode":I
    .end local v1    # "cityCode":I
    .end local v2    # "address":Ljava/lang/String;
    :goto_1
    return-void
.end method

.method private queryFromServer(Ljava/lang/String;Ljava/lang/String;)V
    .locals 1
    .param p1, "address"    # Ljava/lang/String;
    .param p2, "type"    # Ljava/lang/String;

    .line 210
    invoke-direct {p0}, Lcom/coolweather/android/ChooseAreaFragment;->showProgressDialog()V

    .line 211
    new-instance v0, Lcom/coolweather/android/ChooseAreaFragment$3;

    invoke-direct {v0, p0, p2}, Lcom/coolweather/android/ChooseAreaFragment$3;-><init>(Lcom/coolweather/android/ChooseAreaFragment;Ljava/lang/String;)V

    invoke-static {p1, v0}, Lcom/coolweather/android/util/HttpUtil;->sendOkHttpRequest(Ljava/lang/String;Lokhttp3/Callback;)V

    .line 252
    return-void
.end method

.method private queryProvinces()V
    .locals 5

    .line 144
    iget-object v0, p0, Lcom/coolweather/android/ChooseAreaFragment;->titleText:Landroid/widget/TextView;

    const-string v1, "\u4e2d\u56fd"

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 145
    iget-object v0, p0, Lcom/coolweather/android/ChooseAreaFragment;->backButton:Landroid/widget/Button;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/widget/Button;->setVisibility(I)V

    .line 146
    const-class v0, Lcom/coolweather/android/db/Province;

    const/4 v1, 0x0

    new-array v2, v1, [J

    invoke-static {v0, v2}, Lorg/litepal/crud/DataSupport;->findAll(Ljava/lang/Class;[J)Ljava/util/List;

    move-result-object v0

    iput-object v0, p0, Lcom/coolweather/android/ChooseAreaFragment;->provinceList:Ljava/util/List;

    .line 147
    iget-object v0, p0, Lcom/coolweather/android/ChooseAreaFragment;->provinceList:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    if-lez v0, :cond_1

    .line 148
    iget-object v0, p0, Lcom/coolweather/android/ChooseAreaFragment;->dataList:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->clear()V

    .line 149
    iget-object v0, p0, Lcom/coolweather/android/ChooseAreaFragment;->provinceList:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v0

    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_0

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/coolweather/android/db/Province;

    .line 150
    .local v2, "province":Lcom/coolweather/android/db/Province;
    iget-object v3, p0, Lcom/coolweather/android/ChooseAreaFragment;->dataList:Ljava/util/List;

    invoke-virtual {v2}, Lcom/coolweather/android/db/Province;->getProvinceName()Ljava/lang/String;

    move-result-object v4

    invoke-interface {v3, v4}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 151
    .end local v2    # "province":Lcom/coolweather/android/db/Province;
    goto :goto_0

    .line 152
    :cond_0
    iget-object v0, p0, Lcom/coolweather/android/ChooseAreaFragment;->adapter:Landroid/widget/ArrayAdapter;

    invoke-virtual {v0}, Landroid/widget/ArrayAdapter;->notifyDataSetChanged()V

    .line 153
    iget-object v0, p0, Lcom/coolweather/android/ChooseAreaFragment;->listView:Landroid/widget/ListView;

    invoke-virtual {v0, v1}, Landroid/widget/ListView;->setSelection(I)V

    .line 154
    iput v1, p0, Lcom/coolweather/android/ChooseAreaFragment;->currentLevel:I

    goto :goto_1

    .line 156
    :cond_1
    const-string v0, "http://guolin.tech/api/china"

    .line 157
    .local v0, "address":Ljava/lang/String;
    const-string v1, "province"

    invoke-direct {p0, v0, v1}, Lcom/coolweather/android/ChooseAreaFragment;->queryFromServer(Ljava/lang/String;Ljava/lang/String;)V

    .line 159
    .end local v0    # "address":Ljava/lang/String;
    :goto_1
    return-void
.end method

.method private showProgressDialog()V
    .locals 2

    .line 258
    iget-object v0, p0, Lcom/coolweather/android/ChooseAreaFragment;->progressDialog:Landroid/app/ProgressDialog;

    if-nez v0, :cond_0

    .line 259
    new-instance v0, Landroid/app/ProgressDialog;

    invoke-virtual {p0}, Lcom/coolweather/android/ChooseAreaFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    invoke-direct {v0, v1}, Landroid/app/ProgressDialog;-><init>(Landroid/content/Context;)V

    iput-object v0, p0, Lcom/coolweather/android/ChooseAreaFragment;->progressDialog:Landroid/app/ProgressDialog;

    .line 260
    iget-object v0, p0, Lcom/coolweather/android/ChooseAreaFragment;->progressDialog:Landroid/app/ProgressDialog;

    const-string v1, "\u6b63\u5728\u52a0\u8f7d..."

    invoke-virtual {v0, v1}, Landroid/app/ProgressDialog;->setMessage(Ljava/lang/CharSequence;)V

    .line 261
    iget-object v0, p0, Lcom/coolweather/android/ChooseAreaFragment;->progressDialog:Landroid/app/ProgressDialog;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/app/ProgressDialog;->setCanceledOnTouchOutside(Z)V

    goto :goto_0

    .line 258
    :cond_0
    nop

    .line 263
    :goto_0
    iget-object v0, p0, Lcom/coolweather/android/ChooseAreaFragment;->progressDialog:Landroid/app/ProgressDialog;

    invoke-virtual {v0}, Landroid/app/ProgressDialog;->show()V

    .line 264
    return-void
.end method


# virtual methods
.method public onActivityCreated(Landroid/os/Bundle;)V
    .locals 2
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .line 101
    invoke-super {p0, p1}, Landroid/support/v4/app/Fragment;->onActivityCreated(Landroid/os/Bundle;)V

    .line 102
    iget-object v0, p0, Lcom/coolweather/android/ChooseAreaFragment;->listView:Landroid/widget/ListView;

    new-instance v1, Lcom/coolweather/android/ChooseAreaFragment$1;

    invoke-direct {v1, p0}, Lcom/coolweather/android/ChooseAreaFragment$1;-><init>(Lcom/coolweather/android/ChooseAreaFragment;)V

    invoke-virtual {v0, v1}, Landroid/widget/ListView;->setOnItemClickListener(Landroid/widget/AdapterView$OnItemClickListener;)V

    .line 127
    iget-object v0, p0, Lcom/coolweather/android/ChooseAreaFragment;->backButton:Landroid/widget/Button;

    new-instance v1, Lcom/coolweather/android/ChooseAreaFragment$2;

    invoke-direct {v1, p0}, Lcom/coolweather/android/ChooseAreaFragment$2;-><init>(Lcom/coolweather/android/ChooseAreaFragment;)V

    invoke-virtual {v0, v1}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 137
    invoke-direct {p0}, Lcom/coolweather/android/ChooseAreaFragment;->queryProvinces()V

    .line 138
    return-void
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 5
    .param p1, "inflater"    # Landroid/view/LayoutInflater;
    .param p2, "container"    # Landroid/view/ViewGroup;
    .param p3, "savedInstanceState"    # Landroid/os/Bundle;

    .line 90
    const v0, 0x7f09001e

    const/4 v1, 0x0

    invoke-virtual {p1, v0, p2, v1}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    .line 91
    .local v0, "view":Landroid/view/View;
    const v1, 0x7f07007b

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/TextView;

    iput-object v1, p0, Lcom/coolweather/android/ChooseAreaFragment;->titleText:Landroid/widget/TextView;

    .line 92
    const v1, 0x7f070018

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/Button;

    iput-object v1, p0, Lcom/coolweather/android/ChooseAreaFragment;->backButton:Landroid/widget/Button;

    .line 93
    const v1, 0x7f07003f

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/ListView;

    iput-object v1, p0, Lcom/coolweather/android/ChooseAreaFragment;->listView:Landroid/widget/ListView;

    .line 94
    new-instance v1, Landroid/widget/ArrayAdapter;

    invoke-virtual {p0}, Lcom/coolweather/android/ChooseAreaFragment;->getContext()Landroid/content/Context;

    move-result-object v2

    iget-object v3, p0, Lcom/coolweather/android/ChooseAreaFragment;->dataList:Ljava/util/List;

    const v4, 0x1090003

    invoke-direct {v1, v2, v4, v3}, Landroid/widget/ArrayAdapter;-><init>(Landroid/content/Context;ILjava/util/List;)V

    iput-object v1, p0, Lcom/coolweather/android/ChooseAreaFragment;->adapter:Landroid/widget/ArrayAdapter;

    .line 95
    iget-object v1, p0, Lcom/coolweather/android/ChooseAreaFragment;->listView:Landroid/widget/ListView;

    iget-object v2, p0, Lcom/coolweather/android/ChooseAreaFragment;->adapter:Landroid/widget/ArrayAdapter;

    invoke-virtual {v1, v2}, Landroid/widget/ListView;->setAdapter(Landroid/widget/ListAdapter;)V

    .line 96
    return-object v0
.end method
