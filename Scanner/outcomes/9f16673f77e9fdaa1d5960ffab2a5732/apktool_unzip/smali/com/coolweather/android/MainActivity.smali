.class public Lcom/coolweather/android/MainActivity;
.super Landroid/support/v7/app/AppCompatActivity;
.source "MainActivity.java"


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 10
    invoke-direct {p0}, Landroid/support/v7/app/AppCompatActivity;-><init>()V

    return-void
.end method


# virtual methods
.method protected onCreate(Landroid/os/Bundle;)V
    .locals 3
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .line 14
    invoke-super {p0, p1}, Landroid/support/v7/app/AppCompatActivity;->onCreate(Landroid/os/Bundle;)V

    .line 15
    const v0, 0x7f09001b

    invoke-virtual {p0, v0}, Lcom/coolweather/android/MainActivity;->setContentView(I)V

    .line 16
    invoke-static {p0}, Landroid/preference/PreferenceManager;->getDefaultSharedPreferences(Landroid/content/Context;)Landroid/content/SharedPreferences;

    move-result-object v0

    .line 17
    .local v0, "prefs":Landroid/content/SharedPreferences;
    const-string v1, "weather"

    const/4 v2, 0x0

    invoke-interface {v0, v1, v2}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    if-eqz v1, :cond_0

    .line 18
    new-instance v1, Landroid/content/Intent;

    const-class v2, Lcom/coolweather/android/WeatherActivity;

    invoke-direct {v1, p0, v2}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 19
    .local v1, "intent":Landroid/content/Intent;
    invoke-virtual {p0, v1}, Lcom/coolweather/android/MainActivity;->startActivity(Landroid/content/Intent;)V

    .line 20
    invoke-virtual {p0}, Lcom/coolweather/android/MainActivity;->finish()V

    goto :goto_0

    .line 17
    .end local v1    # "intent":Landroid/content/Intent;
    :cond_0
    nop

    .line 22
    :goto_0
    return-void
.end method
