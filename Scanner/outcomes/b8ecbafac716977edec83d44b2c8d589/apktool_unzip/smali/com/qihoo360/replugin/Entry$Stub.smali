.class public Lcom/qihoo360/replugin/Entry$Stub;
.super Landroid/os/Binder;
.source "SourceFile"

# interfaces
.implements Landroid/os/IInterface;


# static fields
.field private static final DESCRIPTOR:Ljava/lang/String; = "com.qihoo360.loader2.IPlugin"


# instance fields
.field private mRemote:Landroid/os/IBinder;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 25
    invoke-direct {p0}, Landroid/os/Binder;-><init>()V

    .line 20
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/qihoo360/replugin/Entry$Stub;->mRemote:Landroid/os/IBinder;

    .line 26
    const-string v0, "com.qihoo360.loader2.IPlugin"

    invoke-virtual {p0, p0, v0}, Lcom/qihoo360/replugin/Entry$Stub;->attachInterface(Landroid/os/IInterface;Ljava/lang/String;)V

    .line 27
    return-void
.end method


# virtual methods
.method public asBinder()Landroid/os/IBinder;
    .locals 1

    .prologue
    .line 29
    iget-object v0, p0, Lcom/qihoo360/replugin/Entry$Stub;->mRemote:Landroid/os/IBinder;

    return-object v0
.end method

.method public onTransact(ILandroid/os/Parcel;Landroid/os/Parcel;I)Z
    .locals 1

    .prologue
    .line 32
    iget-object v0, p0, Lcom/qihoo360/replugin/Entry$Stub;->mRemote:Landroid/os/IBinder;

    if-eqz v0, :cond_0

    .line 33
    iget-object v0, p0, Lcom/qihoo360/replugin/Entry$Stub;->mRemote:Landroid/os/IBinder;

    invoke-interface {v0, p1, p2, p3, p4}, Landroid/os/IBinder;->transact(ILandroid/os/Parcel;Landroid/os/Parcel;I)Z

    move-result v0

    .line 35
    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public setRemote(Landroid/os/IBinder;)V
    .locals 0

    .prologue
    .line 22
    iput-object p1, p0, Lcom/qihoo360/replugin/Entry$Stub;->mRemote:Landroid/os/IBinder;

    .line 23
    return-void
.end method
