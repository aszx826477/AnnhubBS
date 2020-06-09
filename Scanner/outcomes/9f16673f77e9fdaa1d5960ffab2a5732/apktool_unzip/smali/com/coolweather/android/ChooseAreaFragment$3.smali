.class Lcom/coolweather/android/ChooseAreaFragment$3;
.super Ljava/lang/Object;
.source "ChooseAreaFragment.java"

# interfaces
.implements Lokhttp3/Callback;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/coolweather/android/ChooseAreaFragment;->queryFromServer(Ljava/lang/String;Ljava/lang/String;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/coolweather/android/ChooseAreaFragment;

.field final synthetic val$type:Ljava/lang/String;


# direct methods
.method constructor <init>(Lcom/coolweather/android/ChooseAreaFragment;Ljava/lang/String;)V
    .locals 0
    .param p1, "this$0"    # Lcom/coolweather/android/ChooseAreaFragment;

    .line 211
    iput-object p1, p0, Lcom/coolweather/android/ChooseAreaFragment$3;->this$0:Lcom/coolweather/android/ChooseAreaFragment;

    iput-object p2, p0, Lcom/coolweather/android/ChooseAreaFragment$3;->val$type:Ljava/lang/String;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onFailure(Lokhttp3/Call;Ljava/io/IOException;)V
    .locals 2
    .param p1, "call"    # Lokhttp3/Call;
    .param p2, "e"    # Ljava/io/IOException;

    .line 243
    iget-object v0, p0, Lcom/coolweather/android/ChooseAreaFragment$3;->this$0:Lcom/coolweather/android/ChooseAreaFragment;

    invoke-virtual {v0}, Lcom/coolweather/android/ChooseAreaFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    new-instance v1, Lcom/coolweather/android/ChooseAreaFragment$3$2;

    invoke-direct {v1, p0}, Lcom/coolweather/android/ChooseAreaFragment$3$2;-><init>(Lcom/coolweather/android/ChooseAreaFragment$3;)V

    invoke-virtual {v0, v1}, Landroid/support/v4/app/FragmentActivity;->runOnUiThread(Ljava/lang/Runnable;)V

    .line 250
    return-void
.end method

.method public onResponse(Lokhttp3/Call;Lokhttp3/Response;)V
    .locals 4
    .param p1, "call"    # Lokhttp3/Call;
    .param p2, "response"    # Lokhttp3/Response;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .line 214
    invoke-virtual {p2}, Lokhttp3/Response;->body()Lokhttp3/ResponseBody;

    move-result-object v0

    invoke-virtual {v0}, Lokhttp3/ResponseBody;->string()Ljava/lang/String;

    move-result-object v0

    .line 215
    .local v0, "responseText":Ljava/lang/String;
    const/4 v1, 0x0

    .line 216
    .local v1, "result":Z
    const-string v2, "province"

    iget-object v3, p0, Lcom/coolweather/android/ChooseAreaFragment$3;->val$type:Ljava/lang/String;

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 217
    invoke-static {v0}, Lcom/coolweather/android/util/Utility;->handleProvinceResponse(Ljava/lang/String;)Z

    move-result v1

    goto :goto_0

    .line 218
    :cond_0
    const-string v2, "city"

    iget-object v3, p0, Lcom/coolweather/android/ChooseAreaFragment$3;->val$type:Ljava/lang/String;

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_1

    .line 219
    iget-object v2, p0, Lcom/coolweather/android/ChooseAreaFragment$3;->this$0:Lcom/coolweather/android/ChooseAreaFragment;

    invoke-static {v2}, Lcom/coolweather/android/ChooseAreaFragment;->access$100(Lcom/coolweather/android/ChooseAreaFragment;)Lcom/coolweather/android/db/Province;

    move-result-object v2

    invoke-virtual {v2}, Lcom/coolweather/android/db/Province;->getId()I

    move-result v2

    invoke-static {v0, v2}, Lcom/coolweather/android/util/Utility;->handleCityResponse(Ljava/lang/String;I)Z

    move-result v1

    goto :goto_0

    .line 220
    :cond_1
    const-string v2, "county"

    iget-object v3, p0, Lcom/coolweather/android/ChooseAreaFragment$3;->val$type:Ljava/lang/String;

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_2

    .line 221
    iget-object v2, p0, Lcom/coolweather/android/ChooseAreaFragment$3;->this$0:Lcom/coolweather/android/ChooseAreaFragment;

    invoke-static {v2}, Lcom/coolweather/android/ChooseAreaFragment;->access$400(Lcom/coolweather/android/ChooseAreaFragment;)Lcom/coolweather/android/db/City;

    move-result-object v2

    invoke-virtual {v2}, Lcom/coolweather/android/db/City;->getId()I

    move-result v2

    invoke-static {v0, v2}, Lcom/coolweather/android/util/Utility;->handleCountyResponse(Ljava/lang/String;I)Z

    move-result v1

    goto :goto_0

    .line 220
    :cond_2
    nop

    .line 223
    :goto_0
    if-eqz v1, :cond_3

    .line 224
    iget-object v2, p0, Lcom/coolweather/android/ChooseAreaFragment$3;->this$0:Lcom/coolweather/android/ChooseAreaFragment;

    invoke-virtual {v2}, Lcom/coolweather/android/ChooseAreaFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v2

    new-instance v3, Lcom/coolweather/android/ChooseAreaFragment$3$1;

    invoke-direct {v3, p0}, Lcom/coolweather/android/ChooseAreaFragment$3$1;-><init>(Lcom/coolweather/android/ChooseAreaFragment$3;)V

    invoke-virtual {v2, v3}, Landroid/support/v4/app/FragmentActivity;->runOnUiThread(Ljava/lang/Runnable;)V

    goto :goto_1

    .line 223
    :cond_3
    nop

    .line 238
    :goto_1
    return-void
.end method
