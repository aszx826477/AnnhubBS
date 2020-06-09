.class Lcom/coolweather/android/ChooseAreaFragment$1;
.super Ljava/lang/Object;
.source "ChooseAreaFragment.java"

# interfaces
.implements Landroid/widget/AdapterView$OnItemClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/coolweather/android/ChooseAreaFragment;->onActivityCreated(Landroid/os/Bundle;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/coolweather/android/ChooseAreaFragment;


# direct methods
.method constructor <init>(Lcom/coolweather/android/ChooseAreaFragment;)V
    .locals 0
    .param p1, "this$0"    # Lcom/coolweather/android/ChooseAreaFragment;

    .line 102
    iput-object p1, p0, Lcom/coolweather/android/ChooseAreaFragment$1;->this$0:Lcom/coolweather/android/ChooseAreaFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onItemClick(Landroid/widget/AdapterView;Landroid/view/View;IJ)V
    .locals 4
    .param p2, "view"    # Landroid/view/View;
    .param p3, "position"    # I
    .param p4, "id"    # J
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/widget/AdapterView<",
            "*>;",
            "Landroid/view/View;",
            "IJ)V"
        }
    .end annotation

    .line 105
    .local p1, "parent":Landroid/widget/AdapterView;, "Landroid/widget/AdapterView<*>;"
    iget-object v0, p0, Lcom/coolweather/android/ChooseAreaFragment$1;->this$0:Lcom/coolweather/android/ChooseAreaFragment;

    invoke-static {v0}, Lcom/coolweather/android/ChooseAreaFragment;->access$000(Lcom/coolweather/android/ChooseAreaFragment;)I

    move-result v0

    if-nez v0, :cond_0

    .line 106
    iget-object v0, p0, Lcom/coolweather/android/ChooseAreaFragment$1;->this$0:Lcom/coolweather/android/ChooseAreaFragment;

    invoke-static {v0}, Lcom/coolweather/android/ChooseAreaFragment;->access$200(Lcom/coolweather/android/ChooseAreaFragment;)Ljava/util/List;

    move-result-object v1

    invoke-interface {v1, p3}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/coolweather/android/db/Province;

    invoke-static {v0, v1}, Lcom/coolweather/android/ChooseAreaFragment;->access$102(Lcom/coolweather/android/ChooseAreaFragment;Lcom/coolweather/android/db/Province;)Lcom/coolweather/android/db/Province;

    .line 107
    iget-object v0, p0, Lcom/coolweather/android/ChooseAreaFragment$1;->this$0:Lcom/coolweather/android/ChooseAreaFragment;

    invoke-static {v0}, Lcom/coolweather/android/ChooseAreaFragment;->access$300(Lcom/coolweather/android/ChooseAreaFragment;)V

    goto/16 :goto_1

    .line 108
    :cond_0
    iget-object v0, p0, Lcom/coolweather/android/ChooseAreaFragment$1;->this$0:Lcom/coolweather/android/ChooseAreaFragment;

    invoke-static {v0}, Lcom/coolweather/android/ChooseAreaFragment;->access$000(Lcom/coolweather/android/ChooseAreaFragment;)I

    move-result v0

    const/4 v1, 0x1

    if-ne v0, v1, :cond_1

    .line 109
    iget-object v0, p0, Lcom/coolweather/android/ChooseAreaFragment$1;->this$0:Lcom/coolweather/android/ChooseAreaFragment;

    invoke-static {v0}, Lcom/coolweather/android/ChooseAreaFragment;->access$500(Lcom/coolweather/android/ChooseAreaFragment;)Ljava/util/List;

    move-result-object v1

    invoke-interface {v1, p3}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/coolweather/android/db/City;

    invoke-static {v0, v1}, Lcom/coolweather/android/ChooseAreaFragment;->access$402(Lcom/coolweather/android/ChooseAreaFragment;Lcom/coolweather/android/db/City;)Lcom/coolweather/android/db/City;

    .line 110
    iget-object v0, p0, Lcom/coolweather/android/ChooseAreaFragment$1;->this$0:Lcom/coolweather/android/ChooseAreaFragment;

    invoke-static {v0}, Lcom/coolweather/android/ChooseAreaFragment;->access$600(Lcom/coolweather/android/ChooseAreaFragment;)V

    goto :goto_1

    .line 111
    :cond_1
    iget-object v0, p0, Lcom/coolweather/android/ChooseAreaFragment$1;->this$0:Lcom/coolweather/android/ChooseAreaFragment;

    invoke-static {v0}, Lcom/coolweather/android/ChooseAreaFragment;->access$000(Lcom/coolweather/android/ChooseAreaFragment;)I

    move-result v0

    const/4 v2, 0x2

    if-ne v0, v2, :cond_4

    .line 112
    iget-object v0, p0, Lcom/coolweather/android/ChooseAreaFragment$1;->this$0:Lcom/coolweather/android/ChooseAreaFragment;

    invoke-static {v0}, Lcom/coolweather/android/ChooseAreaFragment;->access$700(Lcom/coolweather/android/ChooseAreaFragment;)Ljava/util/List;

    move-result-object v0

    invoke-interface {v0, p3}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/coolweather/android/db/County;

    invoke-virtual {v0}, Lcom/coolweather/android/db/County;->getWeatherId()Ljava/lang/String;

    move-result-object v0

    .line 113
    .local v0, "weatherId":Ljava/lang/String;
    iget-object v2, p0, Lcom/coolweather/android/ChooseAreaFragment$1;->this$0:Lcom/coolweather/android/ChooseAreaFragment;

    invoke-virtual {v2}, Lcom/coolweather/android/ChooseAreaFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v2

    instance-of v2, v2, Lcom/coolweather/android/MainActivity;

    if-eqz v2, :cond_2

    .line 114
    new-instance v1, Landroid/content/Intent;

    iget-object v2, p0, Lcom/coolweather/android/ChooseAreaFragment$1;->this$0:Lcom/coolweather/android/ChooseAreaFragment;

    invoke-virtual {v2}, Lcom/coolweather/android/ChooseAreaFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v2

    const-class v3, Lcom/coolweather/android/WeatherActivity;

    invoke-direct {v1, v2, v3}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 115
    .local v1, "intent":Landroid/content/Intent;
    const-string v2, "weather_id"

    invoke-virtual {v1, v2, v0}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 116
    iget-object v2, p0, Lcom/coolweather/android/ChooseAreaFragment$1;->this$0:Lcom/coolweather/android/ChooseAreaFragment;

    invoke-virtual {v2, v1}, Lcom/coolweather/android/ChooseAreaFragment;->startActivity(Landroid/content/Intent;)V

    .line 117
    iget-object v2, p0, Lcom/coolweather/android/ChooseAreaFragment$1;->this$0:Lcom/coolweather/android/ChooseAreaFragment;

    invoke-virtual {v2}, Lcom/coolweather/android/ChooseAreaFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v2

    invoke-virtual {v2}, Landroid/support/v4/app/FragmentActivity;->finish()V

    .end local v1    # "intent":Landroid/content/Intent;
    goto :goto_0

    .line 118
    :cond_2
    iget-object v2, p0, Lcom/coolweather/android/ChooseAreaFragment$1;->this$0:Lcom/coolweather/android/ChooseAreaFragment;

    invoke-virtual {v2}, Lcom/coolweather/android/ChooseAreaFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v2

    instance-of v2, v2, Lcom/coolweather/android/WeatherActivity;

    if-eqz v2, :cond_3

    .line 119
    iget-object v2, p0, Lcom/coolweather/android/ChooseAreaFragment$1;->this$0:Lcom/coolweather/android/ChooseAreaFragment;

    invoke-virtual {v2}, Lcom/coolweather/android/ChooseAreaFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v2

    check-cast v2, Lcom/coolweather/android/WeatherActivity;

    .line 120
    .local v2, "activity":Lcom/coolweather/android/WeatherActivity;
    iget-object v3, v2, Lcom/coolweather/android/WeatherActivity;->drawerLayout:Landroid/support/v4/widget/DrawerLayout;

    invoke-virtual {v3}, Landroid/support/v4/widget/DrawerLayout;->closeDrawers()V

    .line 121
    iget-object v3, v2, Lcom/coolweather/android/WeatherActivity;->swipeRefresh:Landroid/support/v4/widget/SwipeRefreshLayout;

    invoke-virtual {v3, v1}, Landroid/support/v4/widget/SwipeRefreshLayout;->setRefreshing(Z)V

    .line 122
    invoke-virtual {v2, v0}, Lcom/coolweather/android/WeatherActivity;->requestWeather(Ljava/lang/String;)V

    goto :goto_1

    .line 118
    .end local v2    # "activity":Lcom/coolweather/android/WeatherActivity;
    :cond_3
    :goto_0
    goto :goto_1

    .line 111
    .end local v0    # "weatherId":Ljava/lang/String;
    :cond_4
    nop

    .line 125
    :goto_1
    return-void
.end method
