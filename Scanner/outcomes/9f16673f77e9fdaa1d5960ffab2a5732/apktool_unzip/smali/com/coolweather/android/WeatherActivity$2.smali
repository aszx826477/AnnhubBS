.class Lcom/coolweather/android/WeatherActivity$2;
.super Ljava/lang/Object;
.source "WeatherActivity.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/coolweather/android/WeatherActivity;->onCreate(Landroid/os/Bundle;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/coolweather/android/WeatherActivity;


# direct methods
.method constructor <init>(Lcom/coolweather/android/WeatherActivity;)V
    .locals 0
    .param p1, "this$0"    # Lcom/coolweather/android/WeatherActivity;

    .line 166
    iput-object p1, p0, Lcom/coolweather/android/WeatherActivity$2;->this$0:Lcom/coolweather/android/WeatherActivity;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 2
    .param p1, "v"    # Landroid/view/View;

    .line 169
    iget-object v0, p0, Lcom/coolweather/android/WeatherActivity$2;->this$0:Lcom/coolweather/android/WeatherActivity;

    iget-object v0, v0, Lcom/coolweather/android/WeatherActivity;->drawerLayout:Landroid/support/v4/widget/DrawerLayout;

    const v1, 0x800003

    invoke-virtual {v0, v1}, Landroid/support/v4/widget/DrawerLayout;->openDrawer(I)V

    .line 170
    return-void
.end method
