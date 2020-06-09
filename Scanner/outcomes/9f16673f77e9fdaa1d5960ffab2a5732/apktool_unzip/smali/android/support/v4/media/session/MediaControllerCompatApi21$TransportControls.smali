.class public Landroid/support/v4/media/session/MediaControllerCompatApi21$TransportControls;
.super Ljava/lang/Object;
.source "MediaControllerCompatApi21.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/support/v4/media/session/MediaControllerCompatApi21;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "TransportControls"
.end annotation


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 138
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static fastForward(Ljava/lang/Object;)V
    .locals 1
    .param p0, "controlsObj"    # Ljava/lang/Object;

    .line 156
    move-object v0, p0

    check-cast v0, Landroid/media/session/MediaController$TransportControls;

    invoke-virtual {v0}, Landroid/media/session/MediaController$TransportControls;->fastForward()V

    .line 157
    return-void
.end method

.method public static pause(Ljava/lang/Object;)V
    .locals 1
    .param p0, "controlsObj"    # Ljava/lang/Object;

    .line 144
    move-object v0, p0

    check-cast v0, Landroid/media/session/MediaController$TransportControls;

    invoke-virtual {v0}, Landroid/media/session/MediaController$TransportControls;->pause()V

    .line 145
    return-void
.end method

.method public static play(Ljava/lang/Object;)V
    .locals 1
    .param p0, "controlsObj"    # Ljava/lang/Object;

    .line 140
    move-object v0, p0

    check-cast v0, Landroid/media/session/MediaController$TransportControls;

    invoke-virtual {v0}, Landroid/media/session/MediaController$TransportControls;->play()V

    .line 141
    return-void
.end method

.method public static playFromMediaId(Ljava/lang/Object;Ljava/lang/String;Landroid/os/Bundle;)V
    .locals 1
    .param p0, "controlsObj"    # Ljava/lang/Object;
    .param p1, "mediaId"    # Ljava/lang/String;
    .param p2, "extras"    # Landroid/os/Bundle;

    .line 176
    move-object v0, p0

    check-cast v0, Landroid/media/session/MediaController$TransportControls;

    invoke-virtual {v0, p1, p2}, Landroid/media/session/MediaController$TransportControls;->playFromMediaId(Ljava/lang/String;Landroid/os/Bundle;)V

    .line 177
    return-void
.end method

.method public static playFromSearch(Ljava/lang/Object;Ljava/lang/String;Landroid/os/Bundle;)V
    .locals 1
    .param p0, "controlsObj"    # Ljava/lang/Object;
    .param p1, "query"    # Ljava/lang/String;
    .param p2, "extras"    # Landroid/os/Bundle;

    .line 180
    move-object v0, p0

    check-cast v0, Landroid/media/session/MediaController$TransportControls;

    invoke-virtual {v0, p1, p2}, Landroid/media/session/MediaController$TransportControls;->playFromSearch(Ljava/lang/String;Landroid/os/Bundle;)V

    .line 181
    return-void
.end method

.method public static rewind(Ljava/lang/Object;)V
    .locals 1
    .param p0, "controlsObj"    # Ljava/lang/Object;

    .line 160
    move-object v0, p0

    check-cast v0, Landroid/media/session/MediaController$TransportControls;

    invoke-virtual {v0}, Landroid/media/session/MediaController$TransportControls;->rewind()V

    .line 161
    return-void
.end method

.method public static seekTo(Ljava/lang/Object;J)V
    .locals 1
    .param p0, "controlsObj"    # Ljava/lang/Object;
    .param p1, "pos"    # J

    .line 152
    move-object v0, p0

    check-cast v0, Landroid/media/session/MediaController$TransportControls;

    invoke-virtual {v0, p1, p2}, Landroid/media/session/MediaController$TransportControls;->seekTo(J)V

    .line 153
    return-void
.end method

.method public static sendCustomAction(Ljava/lang/Object;Ljava/lang/String;Landroid/os/Bundle;)V
    .locals 1
    .param p0, "controlsObj"    # Ljava/lang/Object;
    .param p1, "action"    # Ljava/lang/String;
    .param p2, "args"    # Landroid/os/Bundle;

    .line 188
    move-object v0, p0

    check-cast v0, Landroid/media/session/MediaController$TransportControls;

    invoke-virtual {v0, p1, p2}, Landroid/media/session/MediaController$TransportControls;->sendCustomAction(Ljava/lang/String;Landroid/os/Bundle;)V

    .line 189
    return-void
.end method

.method public static setRating(Ljava/lang/Object;Ljava/lang/Object;)V
    .locals 2
    .param p0, "controlsObj"    # Ljava/lang/Object;
    .param p1, "ratingObj"    # Ljava/lang/Object;

    .line 172
    move-object v0, p0

    check-cast v0, Landroid/media/session/MediaController$TransportControls;

    move-object v1, p1

    check-cast v1, Landroid/media/Rating;

    invoke-virtual {v0, v1}, Landroid/media/session/MediaController$TransportControls;->setRating(Landroid/media/Rating;)V

    .line 173
    return-void
.end method

.method public static skipToNext(Ljava/lang/Object;)V
    .locals 1
    .param p0, "controlsObj"    # Ljava/lang/Object;

    .line 164
    move-object v0, p0

    check-cast v0, Landroid/media/session/MediaController$TransportControls;

    invoke-virtual {v0}, Landroid/media/session/MediaController$TransportControls;->skipToNext()V

    .line 165
    return-void
.end method

.method public static skipToPrevious(Ljava/lang/Object;)V
    .locals 1
    .param p0, "controlsObj"    # Ljava/lang/Object;

    .line 168
    move-object v0, p0

    check-cast v0, Landroid/media/session/MediaController$TransportControls;

    invoke-virtual {v0}, Landroid/media/session/MediaController$TransportControls;->skipToPrevious()V

    .line 169
    return-void
.end method

.method public static skipToQueueItem(Ljava/lang/Object;J)V
    .locals 1
    .param p0, "controlsObj"    # Ljava/lang/Object;
    .param p1, "id"    # J

    .line 184
    move-object v0, p0

    check-cast v0, Landroid/media/session/MediaController$TransportControls;

    invoke-virtual {v0, p1, p2}, Landroid/media/session/MediaController$TransportControls;->skipToQueueItem(J)V

    .line 185
    return-void
.end method

.method public static stop(Ljava/lang/Object;)V
    .locals 1
    .param p0, "controlsObj"    # Ljava/lang/Object;

    .line 148
    move-object v0, p0

    check-cast v0, Landroid/media/session/MediaController$TransportControls;

    invoke-virtual {v0}, Landroid/media/session/MediaController$TransportControls;->stop()V

    .line 149
    return-void
.end method
