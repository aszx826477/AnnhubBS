.class Lcom/bumptech/glide/ListPreloader$2;
.super Ljava/lang/Object;
.source "ListPreloader.java"

# interfaces
.implements Lcom/bumptech/glide/ListPreloader$PreloadSizeProvider;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/bumptech/glide/ListPreloader;-><init>(I)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Lcom/bumptech/glide/ListPreloader$PreloadSizeProvider<",
        "TT;>;"
    }
.end annotation


# instance fields
.field final synthetic this$0:Lcom/bumptech/glide/ListPreloader;


# direct methods
.method constructor <init>(Lcom/bumptech/glide/ListPreloader;)V
    .locals 0

    .line 114
    .local p0, "this":Lcom/bumptech/glide/ListPreloader$2;, "Lcom/bumptech/glide/ListPreloader.2;"
    iput-object p1, p0, Lcom/bumptech/glide/ListPreloader$2;->this$0:Lcom/bumptech/glide/ListPreloader;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getPreloadSize(Ljava/lang/Object;II)[I
    .locals 1
    .param p2, "adapterPosition"    # I
    .param p3, "perItemPosition"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TT;II)[I"
        }
    .end annotation

    .line 118
    .local p0, "this":Lcom/bumptech/glide/ListPreloader$2;, "Lcom/bumptech/glide/ListPreloader.2;"
    .local p1, "item":Ljava/lang/Object;, "TT;"
    iget-object v0, p0, Lcom/bumptech/glide/ListPreloader$2;->this$0:Lcom/bumptech/glide/ListPreloader;

    invoke-virtual {v0, p1}, Lcom/bumptech/glide/ListPreloader;->getDimensions(Ljava/lang/Object;)[I

    move-result-object v0

    return-object v0
.end method
