.class Lcom/coolweather/android/WeatherActivity$MyLocationListener$1;
.super Ljava/lang/Object;
.source "WeatherActivity.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/coolweather/android/WeatherActivity$MyLocationListener;->onReceiveLocation(Lcom/baidu/location/BDLocation;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/coolweather/android/WeatherActivity$MyLocationListener;

.field final synthetic val$location:Lcom/baidu/location/BDLocation;


# direct methods
.method constructor <init>(Lcom/coolweather/android/WeatherActivity$MyLocationListener;Lcom/baidu/location/BDLocation;)V
    .locals 0
    .param p1, "this$1"    # Lcom/coolweather/android/WeatherActivity$MyLocationListener;

    .line 293
    iput-object p1, p0, Lcom/coolweather/android/WeatherActivity$MyLocationListener$1;->this$1:Lcom/coolweather/android/WeatherActivity$MyLocationListener;

    iput-object p2, p0, Lcom/coolweather/android/WeatherActivity$MyLocationListener$1;->val$location:Lcom/baidu/location/BDLocation;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 5

    .line 296
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    .line 297
    .local v0, "currentPosition":Ljava/lang/StringBuilder;
    const-string v1, "\u7eac\u5ea6\uff1a"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    iget-object v1, p0, Lcom/coolweather/android/WeatherActivity$MyLocationListener$1;->val$location:Lcom/baidu/location/BDLocation;

    invoke-virtual {v1}, Lcom/baidu/location/BDLocation;->getLatitude()D

    move-result-wide v1

    invoke-virtual {v0, v1, v2}, Ljava/lang/StringBuilder;->append(D)Ljava/lang/StringBuilder;

    const-string v1, "\n"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 298
    const-string v1, "\u7ecf\u5ea6\uff1a"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    iget-object v1, p0, Lcom/coolweather/android/WeatherActivity$MyLocationListener$1;->val$location:Lcom/baidu/location/BDLocation;

    invoke-virtual {v1}, Lcom/baidu/location/BDLocation;->getLongitude()D

    move-result-wide v1

    invoke-virtual {v0, v1, v2}, Ljava/lang/StringBuilder;->append(D)Ljava/lang/StringBuilder;

    const-string v1, "\n"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 299
    const-string v1, "\u56fd\u5bb6\uff1a"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    iget-object v1, p0, Lcom/coolweather/android/WeatherActivity$MyLocationListener$1;->val$location:Lcom/baidu/location/BDLocation;

    invoke-virtual {v1}, Lcom/baidu/location/BDLocation;->getCountry()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v1, "\n"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 300
    const-string v1, "\u7701\uff1a"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    iget-object v1, p0, Lcom/coolweather/android/WeatherActivity$MyLocationListener$1;->val$location:Lcom/baidu/location/BDLocation;

    invoke-virtual {v1}, Lcom/baidu/location/BDLocation;->getProvince()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v1, "\n"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 301
    const-string v1, "\u5e02\uff1a"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    iget-object v1, p0, Lcom/coolweather/android/WeatherActivity$MyLocationListener$1;->val$location:Lcom/baidu/location/BDLocation;

    invoke-virtual {v1}, Lcom/baidu/location/BDLocation;->getCity()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v1, "\n"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 302
    const-string v1, "\u533a\uff1a"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    iget-object v1, p0, Lcom/coolweather/android/WeatherActivity$MyLocationListener$1;->val$location:Lcom/baidu/location/BDLocation;

    invoke-virtual {v1}, Lcom/baidu/location/BDLocation;->getDistrict()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v1, "\n"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 303
    const-string v1, "\u8857\u9053\uff1a"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    iget-object v1, p0, Lcom/coolweather/android/WeatherActivity$MyLocationListener$1;->val$location:Lcom/baidu/location/BDLocation;

    invoke-virtual {v1}, Lcom/baidu/location/BDLocation;->getStreet()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v1, "\n"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 304
    const-string v1, "\u5b9a\u4f4d\u65b9\u5f0f\uff1a"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 305
    iget-object v1, p0, Lcom/coolweather/android/WeatherActivity$MyLocationListener$1;->val$location:Lcom/baidu/location/BDLocation;

    invoke-virtual {v1}, Lcom/baidu/location/BDLocation;->getLocType()I

    move-result v1

    const/16 v2, 0x3d

    if-ne v1, v2, :cond_0

    .line 306
    const-string v1, "GPS\n"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    goto :goto_0

    .line 307
    :cond_0
    iget-object v1, p0, Lcom/coolweather/android/WeatherActivity$MyLocationListener$1;->val$location:Lcom/baidu/location/BDLocation;

    invoke-virtual {v1}, Lcom/baidu/location/BDLocation;->getLocType()I

    move-result v1

    const/16 v2, 0xa1

    if-ne v1, v2, :cond_1

    .line 308
    const-string v1, "\u7f51\u7edc\n"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    goto :goto_0

    .line 307
    :cond_1
    nop

    .line 311
    :goto_0
    iget-object v1, p0, Lcom/coolweather/android/WeatherActivity$MyLocationListener$1;->this$1:Lcom/coolweather/android/WeatherActivity$MyLocationListener;

    iget-object v1, v1, Lcom/coolweather/android/WeatherActivity$MyLocationListener;->this$0:Lcom/coolweather/android/WeatherActivity;

    iget-object v2, p0, Lcom/coolweather/android/WeatherActivity$MyLocationListener$1;->this$1:Lcom/coolweather/android/WeatherActivity$MyLocationListener;

    iget-object v2, v2, Lcom/coolweather/android/WeatherActivity$MyLocationListener;->this$0:Lcom/coolweather/android/WeatherActivity;

    iget-object v3, p0, Lcom/coolweather/android/WeatherActivity$MyLocationListener$1;->val$location:Lcom/baidu/location/BDLocation;

    invoke-static {v2, v3}, Lcom/coolweather/android/WeatherActivity;->access$100(Lcom/coolweather/android/WeatherActivity;Lcom/baidu/location/BDLocation;)Ljava/lang/String;

    move-result-object v2

    iput-object v2, v1, Lcom/coolweather/android/WeatherActivity;->districtCode:Ljava/lang/String;

    .line 312
    const-string v1, "\u5730\u533a\u4ee3\u7801\uff1a"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    iget-object v1, p0, Lcom/coolweather/android/WeatherActivity$MyLocationListener$1;->this$1:Lcom/coolweather/android/WeatherActivity$MyLocationListener;

    iget-object v1, v1, Lcom/coolweather/android/WeatherActivity$MyLocationListener;->this$0:Lcom/coolweather/android/WeatherActivity;

    iget-object v1, v1, Lcom/coolweather/android/WeatherActivity;->districtCode:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 313
    iget-object v1, p0, Lcom/coolweather/android/WeatherActivity$MyLocationListener$1;->this$1:Lcom/coolweather/android/WeatherActivity$MyLocationListener;

    iget-object v1, v1, Lcom/coolweather/android/WeatherActivity$MyLocationListener;->this$0:Lcom/coolweather/android/WeatherActivity;

    invoke-static {v1}, Lcom/coolweather/android/WeatherActivity;->access$200(Lcom/coolweather/android/WeatherActivity;)Landroid/widget/TextView;

    move-result-object v1

    invoke-virtual {v1, v0}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 318
    iget-object v1, p0, Lcom/coolweather/android/WeatherActivity$MyLocationListener$1;->this$1:Lcom/coolweather/android/WeatherActivity$MyLocationListener;

    iget-object v1, v1, Lcom/coolweather/android/WeatherActivity$MyLocationListener;->this$0:Lcom/coolweather/android/WeatherActivity;

    new-instance v2, Landroid/support/v7/app/AlertDialog$Builder;

    iget-object v3, p0, Lcom/coolweather/android/WeatherActivity$MyLocationListener$1;->this$1:Lcom/coolweather/android/WeatherActivity$MyLocationListener;

    iget-object v3, v3, Lcom/coolweather/android/WeatherActivity$MyLocationListener;->context:Landroid/content/Context;

    invoke-direct {v2, v3}, Landroid/support/v7/app/AlertDialog$Builder;-><init>(Landroid/content/Context;)V

    const-string v3, "\u5c0f\u8d34\u58eb"

    .line 319
    invoke-virtual {v2, v3}, Landroid/support/v7/app/AlertDialog$Builder;->setTitle(Ljava/lang/CharSequence;)Landroid/support/v7/app/AlertDialog$Builder;

    move-result-object v2

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "\u5b9a\u4f4d\u5230\u60a8\u76ee\u524d\u5728"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    iget-object v4, p0, Lcom/coolweather/android/WeatherActivity$MyLocationListener$1;->val$location:Lcom/baidu/location/BDLocation;

    .line 320
    invoke-virtual {v4}, Lcom/baidu/location/BDLocation;->getProvince()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    iget-object v4, p0, Lcom/coolweather/android/WeatherActivity$MyLocationListener$1;->val$location:Lcom/baidu/location/BDLocation;

    invoke-virtual {v4}, Lcom/baidu/location/BDLocation;->getCity()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    iget-object v4, p0, Lcom/coolweather/android/WeatherActivity$MyLocationListener$1;->val$location:Lcom/baidu/location/BDLocation;

    invoke-virtual {v4}, Lcom/baidu/location/BDLocation;->getDistrict()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v4, "\uff0c\u662f\u5426\u9700\u8981\u5207\u6362\u5230\u8be5\u5730\uff1f"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Landroid/support/v7/app/AlertDialog$Builder;->setMessage(Ljava/lang/CharSequence;)Landroid/support/v7/app/AlertDialog$Builder;

    move-result-object v2

    const-string v3, "\u786e\u5b9a"

    new-instance v4, Lcom/coolweather/android/WeatherActivity$MyLocationListener$1$2;

    invoke-direct {v4, p0}, Lcom/coolweather/android/WeatherActivity$MyLocationListener$1$2;-><init>(Lcom/coolweather/android/WeatherActivity$MyLocationListener$1;)V

    .line 321
    invoke-virtual {v2, v3, v4}, Landroid/support/v7/app/AlertDialog$Builder;->setPositiveButton(Ljava/lang/CharSequence;Landroid/content/DialogInterface$OnClickListener;)Landroid/support/v7/app/AlertDialog$Builder;

    move-result-object v2

    const-string v3, "\u53d6\u6d88"

    new-instance v4, Lcom/coolweather/android/WeatherActivity$MyLocationListener$1$1;

    invoke-direct {v4, p0}, Lcom/coolweather/android/WeatherActivity$MyLocationListener$1$1;-><init>(Lcom/coolweather/android/WeatherActivity$MyLocationListener$1;)V

    .line 331
    invoke-virtual {v2, v3, v4}, Landroid/support/v7/app/AlertDialog$Builder;->setNegativeButton(Ljava/lang/CharSequence;Landroid/content/DialogInterface$OnClickListener;)Landroid/support/v7/app/AlertDialog$Builder;

    move-result-object v2

    .line 336
    invoke-virtual {v2}, Landroid/support/v7/app/AlertDialog$Builder;->create()Landroid/support/v7/app/AlertDialog;

    move-result-object v2

    iput-object v2, v1, Lcom/coolweather/android/WeatherActivity;->alertLocation:Landroid/support/v7/app/AlertDialog;

    .line 337
    iget-object v1, p0, Lcom/coolweather/android/WeatherActivity$MyLocationListener$1;->this$1:Lcom/coolweather/android/WeatherActivity$MyLocationListener;

    iget-object v1, v1, Lcom/coolweather/android/WeatherActivity$MyLocationListener;->this$0:Lcom/coolweather/android/WeatherActivity;

    iget-object v1, v1, Lcom/coolweather/android/WeatherActivity;->alertLocation:Landroid/support/v7/app/AlertDialog;

    const/4 v2, 0x0

    invoke-virtual {v1, v2}, Landroid/support/v7/app/AlertDialog;->setCancelable(Z)V

    .line 338
    iget-object v1, p0, Lcom/coolweather/android/WeatherActivity$MyLocationListener$1;->this$1:Lcom/coolweather/android/WeatherActivity$MyLocationListener;

    iget-object v1, v1, Lcom/coolweather/android/WeatherActivity$MyLocationListener;->this$0:Lcom/coolweather/android/WeatherActivity;

    iget-object v1, v1, Lcom/coolweather/android/WeatherActivity;->alertLocation:Landroid/support/v7/app/AlertDialog;

    invoke-virtual {v1}, Landroid/support/v7/app/AlertDialog;->show()V

    .line 339
    return-void
.end method
