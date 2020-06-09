.class public final Landroid/support/v4/text/util/LinkifyCompat;
.super Ljava/lang/Object;
.source "LinkifyCompat.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroid/support/v4/text/util/LinkifyCompat$LinkSpec;,
        Landroid/support/v4/text/util/LinkifyCompat$LinkifyMask;
    }
.end annotation


# static fields
.field private static final COMPARATOR:Ljava/util/Comparator;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Comparator<",
            "Landroid/support/v4/text/util/LinkifyCompat$LinkSpec;",
            ">;"
        }
    .end annotation
.end field

.field private static final EMPTY_STRING:[Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .line 51
    const/4 v0, 0x0

    new-array v0, v0, [Ljava/lang/String;

    sput-object v0, Landroid/support/v4/text/util/LinkifyCompat;->EMPTY_STRING:[Ljava/lang/String;

    .line 53
    new-instance v0, Landroid/support/v4/text/util/LinkifyCompat$1;

    invoke-direct {v0}, Landroid/support/v4/text/util/LinkifyCompat$1;-><init>()V

    sput-object v0, Landroid/support/v4/text/util/LinkifyCompat;->COMPARATOR:Ljava/util/Comparator;

    return-void
.end method

.method private constructor <init>()V
    .locals 0

    .line 495
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method private static addLinkMovementMethod(Landroid/widget/TextView;)V
    .locals 2
    .param p0, "t"    # Landroid/widget/TextView;
        .annotation build Landroid/support/annotation/NonNull;
        .end annotation
    .end param

    .line 340
    invoke-virtual {p0}, Landroid/widget/TextView;->getMovementMethod()Landroid/text/method/MovementMethod;

    move-result-object v0

    .line 342
    .local v0, "m":Landroid/text/method/MovementMethod;
    if-eqz v0, :cond_1

    instance-of v1, v0, Landroid/text/method/LinkMovementMethod;

    if-nez v1, :cond_0

    goto :goto_0

    :cond_0
    goto :goto_1

    .line 343
    :cond_1
    :goto_0
    invoke-virtual {p0}, Landroid/widget/TextView;->getLinksClickable()Z

    move-result v1

    if-eqz v1, :cond_2

    .line 344
    invoke-static {}, Landroid/text/method/LinkMovementMethod;->getInstance()Landroid/text/method/MovementMethod;

    move-result-object v1

    invoke-virtual {p0, v1}, Landroid/widget/TextView;->setMovementMethod(Landroid/text/method/MovementMethod;)V

    goto :goto_1

    .line 343
    :cond_2
    nop

    .line 347
    :goto_1
    return-void
.end method

.method public static final addLinks(Landroid/widget/TextView;Ljava/util/regex/Pattern;Ljava/lang/String;)V
    .locals 6
    .param p0, "text"    # Landroid/widget/TextView;
        .annotation build Landroid/support/annotation/NonNull;
        .end annotation
    .end param
    .param p1, "pattern"    # Ljava/util/regex/Pattern;
        .annotation build Landroid/support/annotation/NonNull;
        .end annotation
    .end param
    .param p2, "scheme"    # Ljava/lang/String;
        .annotation build Landroid/support/annotation/Nullable;
        .end annotation
    .end param

    .line 195
    const/4 v3, 0x0

    const/4 v4, 0x0

    const/4 v5, 0x0

    move-object v0, p0

    move-object v1, p1

    move-object v2, p2

    invoke-static/range {v0 .. v5}, Landroid/support/v4/text/util/LinkifyCompat;->addLinks(Landroid/widget/TextView;Ljava/util/regex/Pattern;Ljava/lang/String;[Ljava/lang/String;Landroid/text/util/Linkify$MatchFilter;Landroid/text/util/Linkify$TransformFilter;)V

    .line 196
    return-void
.end method

.method public static final addLinks(Landroid/widget/TextView;Ljava/util/regex/Pattern;Ljava/lang/String;Landroid/text/util/Linkify$MatchFilter;Landroid/text/util/Linkify$TransformFilter;)V
    .locals 6
    .param p0, "text"    # Landroid/widget/TextView;
        .annotation build Landroid/support/annotation/NonNull;
        .end annotation
    .end param
    .param p1, "pattern"    # Ljava/util/regex/Pattern;
        .annotation build Landroid/support/annotation/NonNull;
        .end annotation
    .end param
    .param p2, "scheme"    # Ljava/lang/String;
        .annotation build Landroid/support/annotation/Nullable;
        .end annotation
    .end param
    .param p3, "matchFilter"    # Landroid/text/util/Linkify$MatchFilter;
        .annotation build Landroid/support/annotation/Nullable;
        .end annotation
    .end param
    .param p4, "transformFilter"    # Landroid/text/util/Linkify$TransformFilter;
        .annotation build Landroid/support/annotation/Nullable;
        .end annotation
    .end param

    .line 215
    const/4 v3, 0x0

    move-object v0, p0

    move-object v1, p1

    move-object v2, p2

    move-object v4, p3

    move-object v5, p4

    invoke-static/range {v0 .. v5}, Landroid/support/v4/text/util/LinkifyCompat;->addLinks(Landroid/widget/TextView;Ljava/util/regex/Pattern;Ljava/lang/String;[Ljava/lang/String;Landroid/text/util/Linkify$MatchFilter;Landroid/text/util/Linkify$TransformFilter;)V

    .line 216
    return-void
.end method

.method public static final addLinks(Landroid/widget/TextView;Ljava/util/regex/Pattern;Ljava/lang/String;[Ljava/lang/String;Landroid/text/util/Linkify$MatchFilter;Landroid/text/util/Linkify$TransformFilter;)V
    .locals 7
    .param p0, "text"    # Landroid/widget/TextView;
        .annotation build Landroid/support/annotation/NonNull;
        .end annotation
    .end param
    .param p1, "pattern"    # Ljava/util/regex/Pattern;
        .annotation build Landroid/support/annotation/NonNull;
        .end annotation
    .end param
    .param p2, "defaultScheme"    # Ljava/lang/String;
        .annotation build Landroid/support/annotation/Nullable;
        .end annotation
    .end param
    .param p3, "schemes"    # [Ljava/lang/String;
        .annotation build Landroid/support/annotation/Nullable;
        .end annotation
    .end param
    .param p4, "matchFilter"    # Landroid/text/util/Linkify$MatchFilter;
        .annotation build Landroid/support/annotation/Nullable;
        .end annotation
    .end param
    .param p5, "transformFilter"    # Landroid/text/util/Linkify$TransformFilter;
        .annotation build Landroid/support/annotation/Nullable;
        .end annotation
    .end param

    .line 238
    invoke-virtual {p0}, Landroid/widget/TextView;->getText()Ljava/lang/CharSequence;

    move-result-object v0

    invoke-static {v0}, Landroid/text/SpannableString;->valueOf(Ljava/lang/CharSequence;)Landroid/text/SpannableString;

    move-result-object v0

    .line 240
    .local v0, "spannable":Landroid/text/SpannableString;
    move-object v1, v0

    move-object v2, p1

    move-object v3, p2

    move-object v4, p3

    move-object v5, p4

    move-object v6, p5

    invoke-static/range {v1 .. v6}, Landroid/support/v4/text/util/LinkifyCompat;->addLinks(Landroid/text/Spannable;Ljava/util/regex/Pattern;Ljava/lang/String;[Ljava/lang/String;Landroid/text/util/Linkify$MatchFilter;Landroid/text/util/Linkify$TransformFilter;)Z

    move-result v1

    .line 242
    .local v1, "linksAdded":Z
    if-eqz v1, :cond_0

    .line 243
    invoke-virtual {p0, v0}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 244
    invoke-static {p0}, Landroid/support/v4/text/util/LinkifyCompat;->addLinkMovementMethod(Landroid/widget/TextView;)V

    goto :goto_0

    .line 242
    :cond_0
    nop

    .line 246
    :goto_0
    return-void
.end method

.method public static final addLinks(Landroid/text/Spannable;I)Z
    .locals 11
    .param p0, "text"    # Landroid/text/Spannable;
        .annotation build Landroid/support/annotation/NonNull;
        .end annotation
    .end param
    .param p1, "mask"    # I

    .line 94
    const/4 v0, 0x0

    if-nez p1, :cond_0

    .line 95
    return v0

    .line 98
    :cond_0
    invoke-interface {p0}, Landroid/text/Spannable;->length()I

    move-result v1

    const-class v2, Landroid/text/style/URLSpan;

    invoke-interface {p0, v0, v1, v2}, Landroid/text/Spannable;->getSpans(IILjava/lang/Class;)[Ljava/lang/Object;

    move-result-object v1

    check-cast v1, [Landroid/text/style/URLSpan;

    .line 100
    .local v1, "old":[Landroid/text/style/URLSpan;
    array-length v2, v1

    const/4 v3, 0x1

    sub-int/2addr v2, v3

    .local v2, "i":I
    :goto_0
    if-ltz v2, :cond_1

    .line 101
    aget-object v4, v1, v2

    invoke-interface {p0, v4}, Landroid/text/Spannable;->removeSpan(Ljava/lang/Object;)V

    .line 100
    add-int/lit8 v2, v2, -0x1

    goto :goto_0

    .line 105
    .end local v2    # "i":I
    :cond_1
    const/4 v2, 0x0

    .line 106
    .local v2, "frameworkReturn":Z
    and-int/lit8 v4, p1, 0x4

    if-eqz v4, :cond_2

    .line 107
    const/4 v4, 0x4

    invoke-static {p0, v4}, Landroid/text/util/Linkify;->addLinks(Landroid/text/Spannable;I)Z

    move-result v2

    goto :goto_1

    .line 106
    :cond_2
    nop

    .line 110
    :goto_1
    new-instance v4, Ljava/util/ArrayList;

    invoke-direct {v4}, Ljava/util/ArrayList;-><init>()V

    .line 112
    .local v4, "links":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Landroid/support/v4/text/util/LinkifyCompat$LinkSpec;>;"
    and-int/lit8 v5, p1, 0x1

    if-eqz v5, :cond_3

    .line 113
    sget-object v7, Landroid/support/v4/util/PatternsCompat;->AUTOLINK_WEB_URL:Ljava/util/regex/Pattern;

    const/4 v5, 0x3

    new-array v8, v5, [Ljava/lang/String;

    const-string v5, "http://"

    aput-object v5, v8, v0

    const-string v5, "https://"

    aput-object v5, v8, v3

    const-string v5, "rtsp://"

    const/4 v6, 0x2

    aput-object v5, v8, v6

    sget-object v9, Landroid/text/util/Linkify;->sUrlMatchFilter:Landroid/text/util/Linkify$MatchFilter;

    const/4 v10, 0x0

    move-object v5, v4

    move-object v6, p0

    invoke-static/range {v5 .. v10}, Landroid/support/v4/text/util/LinkifyCompat;->gatherLinks(Ljava/util/ArrayList;Landroid/text/Spannable;Ljava/util/regex/Pattern;[Ljava/lang/String;Landroid/text/util/Linkify$MatchFilter;Landroid/text/util/Linkify$TransformFilter;)V

    goto :goto_2

    .line 112
    :cond_3
    nop

    .line 118
    :goto_2
    and-int/lit8 v5, p1, 0x2

    if-eqz v5, :cond_4

    .line 119
    sget-object v7, Landroid/support/v4/util/PatternsCompat;->AUTOLINK_EMAIL_ADDRESS:Ljava/util/regex/Pattern;

    new-array v8, v3, [Ljava/lang/String;

    const-string v5, "mailto:"

    aput-object v5, v8, v0

    const/4 v9, 0x0

    const/4 v10, 0x0

    move-object v5, v4

    move-object v6, p0

    invoke-static/range {v5 .. v10}, Landroid/support/v4/text/util/LinkifyCompat;->gatherLinks(Ljava/util/ArrayList;Landroid/text/Spannable;Ljava/util/regex/Pattern;[Ljava/lang/String;Landroid/text/util/Linkify$MatchFilter;Landroid/text/util/Linkify$TransformFilter;)V

    goto :goto_3

    .line 118
    :cond_4
    nop

    .line 124
    :goto_3
    and-int/lit8 v5, p1, 0x8

    if-eqz v5, :cond_5

    .line 125
    invoke-static {v4, p0}, Landroid/support/v4/text/util/LinkifyCompat;->gatherMapLinks(Ljava/util/ArrayList;Landroid/text/Spannable;)V

    goto :goto_4

    .line 124
    :cond_5
    nop

    .line 128
    :goto_4
    invoke-static {v4, p0}, Landroid/support/v4/text/util/LinkifyCompat;->pruneOverlaps(Ljava/util/ArrayList;Landroid/text/Spannable;)V

    .line 130
    invoke-virtual {v4}, Ljava/util/ArrayList;->size()I

    move-result v5

    if-nez v5, :cond_6

    .line 131
    return v0

    .line 134
    :cond_6
    invoke-virtual {v4}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v0

    :goto_5
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_8

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Landroid/support/v4/text/util/LinkifyCompat$LinkSpec;

    .line 135
    .local v5, "link":Landroid/support/v4/text/util/LinkifyCompat$LinkSpec;
    iget-object v6, v5, Landroid/support/v4/text/util/LinkifyCompat$LinkSpec;->frameworkAddedSpan:Landroid/text/style/URLSpan;

    if-nez v6, :cond_7

    .line 136
    iget-object v6, v5, Landroid/support/v4/text/util/LinkifyCompat$LinkSpec;->url:Ljava/lang/String;

    iget v7, v5, Landroid/support/v4/text/util/LinkifyCompat$LinkSpec;->start:I

    iget v8, v5, Landroid/support/v4/text/util/LinkifyCompat$LinkSpec;->end:I

    invoke-static {v6, v7, v8, p0}, Landroid/support/v4/text/util/LinkifyCompat;->applyLink(Ljava/lang/String;IILandroid/text/Spannable;)V

    goto :goto_6

    .line 135
    :cond_7
    nop

    .line 138
    .end local v5    # "link":Landroid/support/v4/text/util/LinkifyCompat$LinkSpec;
    :goto_6
    goto :goto_5

    .line 140
    :cond_8
    return v3
.end method

.method public static final addLinks(Landroid/text/Spannable;Ljava/util/regex/Pattern;Ljava/lang/String;)Z
    .locals 6
    .param p0, "text"    # Landroid/text/Spannable;
        .annotation build Landroid/support/annotation/NonNull;
        .end annotation
    .end param
    .param p1, "pattern"    # Ljava/util/regex/Pattern;
        .annotation build Landroid/support/annotation/NonNull;
        .end annotation
    .end param
    .param p2, "scheme"    # Ljava/lang/String;
        .annotation build Landroid/support/annotation/Nullable;
        .end annotation
    .end param

    .line 259
    const/4 v3, 0x0

    const/4 v4, 0x0

    const/4 v5, 0x0

    move-object v0, p0

    move-object v1, p1

    move-object v2, p2

    invoke-static/range {v0 .. v5}, Landroid/support/v4/text/util/LinkifyCompat;->addLinks(Landroid/text/Spannable;Ljava/util/regex/Pattern;Ljava/lang/String;[Ljava/lang/String;Landroid/text/util/Linkify$MatchFilter;Landroid/text/util/Linkify$TransformFilter;)Z

    move-result v0

    return v0
.end method

.method public static final addLinks(Landroid/text/Spannable;Ljava/util/regex/Pattern;Ljava/lang/String;Landroid/text/util/Linkify$MatchFilter;Landroid/text/util/Linkify$TransformFilter;)Z
    .locals 6
    .param p0, "spannable"    # Landroid/text/Spannable;
        .annotation build Landroid/support/annotation/NonNull;
        .end annotation
    .end param
    .param p1, "pattern"    # Ljava/util/regex/Pattern;
        .annotation build Landroid/support/annotation/NonNull;
        .end annotation
    .end param
    .param p2, "scheme"    # Ljava/lang/String;
        .annotation build Landroid/support/annotation/Nullable;
        .end annotation
    .end param
    .param p3, "matchFilter"    # Landroid/text/util/Linkify$MatchFilter;
        .annotation build Landroid/support/annotation/Nullable;
        .end annotation
    .end param
    .param p4, "transformFilter"    # Landroid/text/util/Linkify$TransformFilter;
        .annotation build Landroid/support/annotation/Nullable;
        .end annotation
    .end param

    .line 280
    const/4 v3, 0x0

    move-object v0, p0

    move-object v1, p1

    move-object v2, p2

    move-object v4, p3

    move-object v5, p4

    invoke-static/range {v0 .. v5}, Landroid/support/v4/text/util/LinkifyCompat;->addLinks(Landroid/text/Spannable;Ljava/util/regex/Pattern;Ljava/lang/String;[Ljava/lang/String;Landroid/text/util/Linkify$MatchFilter;Landroid/text/util/Linkify$TransformFilter;)Z

    move-result v0

    return v0
.end method

.method public static final addLinks(Landroid/text/Spannable;Ljava/util/regex/Pattern;Ljava/lang/String;[Ljava/lang/String;Landroid/text/util/Linkify$MatchFilter;Landroid/text/util/Linkify$TransformFilter;)Z
    .locals 8
    .param p0, "spannable"    # Landroid/text/Spannable;
        .annotation build Landroid/support/annotation/NonNull;
        .end annotation
    .end param
    .param p1, "pattern"    # Ljava/util/regex/Pattern;
        .annotation build Landroid/support/annotation/NonNull;
        .end annotation
    .end param
    .param p2, "defaultScheme"    # Ljava/lang/String;
        .annotation build Landroid/support/annotation/Nullable;
        .end annotation
    .end param
    .param p3, "schemes"    # [Ljava/lang/String;
        .annotation build Landroid/support/annotation/Nullable;
        .end annotation
    .end param
    .param p4, "matchFilter"    # Landroid/text/util/Linkify$MatchFilter;
        .annotation build Landroid/support/annotation/Nullable;
        .end annotation
    .end param
    .param p5, "transformFilter"    # Landroid/text/util/Linkify$TransformFilter;
        .annotation build Landroid/support/annotation/Nullable;
        .end annotation
    .end param

    .line 304
    if-nez p2, :cond_0

    const-string p2, ""

    nop

    .line 305
    :cond_0
    const/4 v0, 0x1

    if-eqz p3, :cond_2

    array-length v1, p3

    if-ge v1, v0, :cond_1

    goto :goto_0

    :cond_1
    goto :goto_1

    .line 306
    :cond_2
    :goto_0
    sget-object p3, Landroid/support/v4/text/util/LinkifyCompat;->EMPTY_STRING:[Ljava/lang/String;

    .line 309
    :goto_1
    array-length v1, p3

    add-int/2addr v1, v0

    new-array v0, v1, [Ljava/lang/String;

    .line 310
    .local v0, "schemesCopy":[Ljava/lang/String;
    sget-object v1, Ljava/util/Locale;->ROOT:Ljava/util/Locale;

    invoke-virtual {p2, v1}, Ljava/lang/String;->toLowerCase(Ljava/util/Locale;)Ljava/lang/String;

    move-result-object v1

    const/4 v2, 0x0

    aput-object v1, v0, v2

    .line 311
    const/4 v1, 0x0

    .local v1, "index":I
    :goto_2
    array-length v3, p3

    if-ge v1, v3, :cond_4

    .line 312
    aget-object v3, p3, v1

    .line 313
    .local v3, "scheme":Ljava/lang/String;
    add-int/lit8 v4, v1, 0x1

    if-nez v3, :cond_3

    const-string v5, ""

    goto :goto_3

    :cond_3
    sget-object v5, Ljava/util/Locale;->ROOT:Ljava/util/Locale;

    invoke-virtual {v3, v5}, Ljava/lang/String;->toLowerCase(Ljava/util/Locale;)Ljava/lang/String;

    move-result-object v5

    :goto_3
    aput-object v5, v0, v4

    .line 311
    .end local v3    # "scheme":Ljava/lang/String;
    add-int/lit8 v1, v1, 0x1

    goto :goto_2

    .line 316
    .end local v1    # "index":I
    :cond_4
    const/4 v1, 0x0

    .line 317
    .local v1, "hasMatches":Z
    invoke-virtual {p1, p0}, Ljava/util/regex/Pattern;->matcher(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;

    move-result-object v3

    .line 319
    .local v3, "m":Ljava/util/regex/Matcher;
    :goto_4
    invoke-virtual {v3}, Ljava/util/regex/Matcher;->find()Z

    move-result v4

    if-eqz v4, :cond_7

    .line 320
    invoke-virtual {v3}, Ljava/util/regex/Matcher;->start()I

    move-result v4

    .line 321
    .local v4, "start":I
    invoke-virtual {v3}, Ljava/util/regex/Matcher;->end()I

    move-result v5

    .line 322
    .local v5, "end":I
    const/4 v6, 0x1

    .line 324
    .local v6, "allowed":Z
    if-eqz p4, :cond_5

    .line 325
    invoke-interface {p4, p0, v4, v5}, Landroid/text/util/Linkify$MatchFilter;->acceptMatch(Ljava/lang/CharSequence;II)Z

    move-result v6

    goto :goto_5

    .line 324
    :cond_5
    nop

    .line 328
    :goto_5
    if-eqz v6, :cond_6

    .line 329
    invoke-virtual {v3, v2}, Ljava/util/regex/Matcher;->group(I)Ljava/lang/String;

    move-result-object v7

    invoke-static {v7, v0, v3, p5}, Landroid/support/v4/text/util/LinkifyCompat;->makeUrl(Ljava/lang/String;[Ljava/lang/String;Ljava/util/regex/Matcher;Landroid/text/util/Linkify$TransformFilter;)Ljava/lang/String;

    move-result-object v7

    .line 331
    .local v7, "url":Ljava/lang/String;
    invoke-static {v7, v4, v5, p0}, Landroid/support/v4/text/util/LinkifyCompat;->applyLink(Ljava/lang/String;IILandroid/text/Spannable;)V

    .line 332
    const/4 v1, 0x1

    goto :goto_6

    .line 328
    .end local v7    # "url":Ljava/lang/String;
    :cond_6
    nop

    .line 334
    .end local v4    # "start":I
    .end local v5    # "end":I
    .end local v6    # "allowed":Z
    :goto_6
    goto :goto_4

    .line 336
    :cond_7
    return v1
.end method

.method public static final addLinks(Landroid/widget/TextView;I)Z
    .locals 5
    .param p0, "text"    # Landroid/widget/TextView;
        .annotation build Landroid/support/annotation/NonNull;
        .end annotation
    .end param
    .param p1, "mask"    # I

    .line 155
    const/4 v0, 0x0

    if-nez p1, :cond_0

    .line 156
    return v0

    .line 159
    :cond_0
    invoke-virtual {p0}, Landroid/widget/TextView;->getText()Ljava/lang/CharSequence;

    move-result-object v1

    .line 161
    .local v1, "t":Ljava/lang/CharSequence;
    instance-of v2, v1, Landroid/text/Spannable;

    const/4 v3, 0x1

    if-eqz v2, :cond_2

    .line 162
    move-object v2, v1

    check-cast v2, Landroid/text/Spannable;

    invoke-static {v2, p1}, Landroid/support/v4/text/util/LinkifyCompat;->addLinks(Landroid/text/Spannable;I)Z

    move-result v2

    if-eqz v2, :cond_1

    .line 163
    invoke-static {p0}, Landroid/support/v4/text/util/LinkifyCompat;->addLinkMovementMethod(Landroid/widget/TextView;)V

    .line 164
    return v3

    .line 167
    :cond_1
    return v0

    .line 169
    :cond_2
    invoke-static {v1}, Landroid/text/SpannableString;->valueOf(Ljava/lang/CharSequence;)Landroid/text/SpannableString;

    move-result-object v2

    .line 171
    .local v2, "s":Landroid/text/SpannableString;
    invoke-static {v2, p1}, Landroid/support/v4/text/util/LinkifyCompat;->addLinks(Landroid/text/Spannable;I)Z

    move-result v4

    if-eqz v4, :cond_3

    .line 172
    invoke-static {p0}, Landroid/support/v4/text/util/LinkifyCompat;->addLinkMovementMethod(Landroid/widget/TextView;)V

    .line 173
    invoke-virtual {p0, v2}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 175
    return v3

    .line 178
    :cond_3
    return v0
.end method

.method private static applyLink(Ljava/lang/String;IILandroid/text/Spannable;)V
    .locals 2
    .param p0, "url"    # Ljava/lang/String;
    .param p1, "start"    # I
    .param p2, "end"    # I
    .param p3, "text"    # Landroid/text/Spannable;

    .line 400
    new-instance v0, Landroid/text/style/URLSpan;

    invoke-direct {v0, p0}, Landroid/text/style/URLSpan;-><init>(Ljava/lang/String;)V

    .line 402
    .local v0, "span":Landroid/text/style/URLSpan;
    const/16 v1, 0x21

    invoke-interface {p3, v0, p1, p2, v1}, Landroid/text/Spannable;->setSpan(Ljava/lang/Object;III)V

    .line 403
    return-void
.end method

.method private static gatherLinks(Ljava/util/ArrayList;Landroid/text/Spannable;Ljava/util/regex/Pattern;[Ljava/lang/String;Landroid/text/util/Linkify$MatchFilter;Landroid/text/util/Linkify$TransformFilter;)V
    .locals 5
    .param p1, "s"    # Landroid/text/Spannable;
    .param p2, "pattern"    # Ljava/util/regex/Pattern;
    .param p3, "schemes"    # [Ljava/lang/String;
    .param p4, "matchFilter"    # Landroid/text/util/Linkify$MatchFilter;
    .param p5, "transformFilter"    # Landroid/text/util/Linkify$TransformFilter;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/ArrayList<",
            "Landroid/support/v4/text/util/LinkifyCompat$LinkSpec;",
            ">;",
            "Landroid/text/Spannable;",
            "Ljava/util/regex/Pattern;",
            "[",
            "Ljava/lang/String;",
            "Landroid/text/util/Linkify$MatchFilter;",
            "Landroid/text/util/Linkify$TransformFilter;",
            ")V"
        }
    .end annotation

    .line 380
    .local p0, "links":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Landroid/support/v4/text/util/LinkifyCompat$LinkSpec;>;"
    invoke-virtual {p2, p1}, Ljava/util/regex/Pattern;->matcher(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;

    move-result-object v0

    .line 382
    .local v0, "m":Ljava/util/regex/Matcher;
    :goto_0
    invoke-virtual {v0}, Ljava/util/regex/Matcher;->find()Z

    move-result v1

    if-eqz v1, :cond_2

    .line 383
    invoke-virtual {v0}, Ljava/util/regex/Matcher;->start()I

    move-result v1

    .line 384
    .local v1, "start":I
    invoke-virtual {v0}, Ljava/util/regex/Matcher;->end()I

    move-result v2

    .line 386
    .local v2, "end":I
    if-eqz p4, :cond_1

    invoke-interface {p4, p1, v1, v2}, Landroid/text/util/Linkify$MatchFilter;->acceptMatch(Ljava/lang/CharSequence;II)Z

    move-result v3

    if-eqz v3, :cond_0

    goto :goto_1

    :cond_0
    goto :goto_2

    .line 387
    :cond_1
    :goto_1
    new-instance v3, Landroid/support/v4/text/util/LinkifyCompat$LinkSpec;

    invoke-direct {v3}, Landroid/support/v4/text/util/LinkifyCompat$LinkSpec;-><init>()V

    .line 388
    .local v3, "spec":Landroid/support/v4/text/util/LinkifyCompat$LinkSpec;
    const/4 v4, 0x0

    invoke-virtual {v0, v4}, Ljava/util/regex/Matcher;->group(I)Ljava/lang/String;

    move-result-object v4

    invoke-static {v4, p3, v0, p5}, Landroid/support/v4/text/util/LinkifyCompat;->makeUrl(Ljava/lang/String;[Ljava/lang/String;Ljava/util/regex/Matcher;Landroid/text/util/Linkify$TransformFilter;)Ljava/lang/String;

    move-result-object v4

    .line 390
    .local v4, "url":Ljava/lang/String;
    iput-object v4, v3, Landroid/support/v4/text/util/LinkifyCompat$LinkSpec;->url:Ljava/lang/String;

    .line 391
    iput v1, v3, Landroid/support/v4/text/util/LinkifyCompat$LinkSpec;->start:I

    .line 392
    iput v2, v3, Landroid/support/v4/text/util/LinkifyCompat$LinkSpec;->end:I

    .line 394
    invoke-virtual {p0, v3}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 396
    .end local v1    # "start":I
    .end local v2    # "end":I
    .end local v3    # "spec":Landroid/support/v4/text/util/LinkifyCompat$LinkSpec;
    .end local v4    # "url":Ljava/lang/String;
    :goto_2
    goto :goto_0

    .line 397
    :cond_2
    return-void
.end method

.method private static final gatherMapLinks(Ljava/util/ArrayList;Landroid/text/Spannable;)V
    .locals 10
    .param p1, "s"    # Landroid/text/Spannable;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/ArrayList<",
            "Landroid/support/v4/text/util/LinkifyCompat$LinkSpec;",
            ">;",
            "Landroid/text/Spannable;",
            ")V"
        }
    .end annotation

    .line 406
    .local p0, "links":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Landroid/support/v4/text/util/LinkifyCompat$LinkSpec;>;"
    invoke-virtual {p1}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v0

    .line 408
    .local v0, "string":Ljava/lang/String;
    const/4 v1, 0x0

    .line 411
    .local v1, "base":I
    :goto_0
    :try_start_0
    invoke-static {v0}, Landroid/webkit/WebView;->findAddress(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    move-object v3, v2

    .local v3, "address":Ljava/lang/String;
    if-eqz v2, :cond_1

    .line 412
    invoke-virtual {v0, v3}, Ljava/lang/String;->indexOf(Ljava/lang/String;)I

    move-result v2

    .line 414
    .local v2, "start":I
    if-gez v2, :cond_0

    .line 415
    goto :goto_1

    .line 418
    :cond_0
    new-instance v4, Landroid/support/v4/text/util/LinkifyCompat$LinkSpec;

    invoke-direct {v4}, Landroid/support/v4/text/util/LinkifyCompat$LinkSpec;-><init>()V

    .line 419
    .local v4, "spec":Landroid/support/v4/text/util/LinkifyCompat$LinkSpec;
    invoke-virtual {v3}, Ljava/lang/String;->length()I

    move-result v5

    .line 420
    .local v5, "length":I
    add-int v6, v2, v5

    .line 422
    .local v6, "end":I
    add-int v7, v1, v2

    iput v7, v4, Landroid/support/v4/text/util/LinkifyCompat$LinkSpec;->start:I

    .line 423
    add-int v7, v1, v6

    iput v7, v4, Landroid/support/v4/text/util/LinkifyCompat$LinkSpec;->end:I

    .line 424
    invoke-virtual {v0, v6}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v7
    :try_end_0
    .catch Ljava/lang/UnsupportedOperationException; {:try_start_0 .. :try_end_0} :catch_1

    move-object v0, v7

    .line 425
    add-int/2addr v1, v6

    .line 427
    const/4 v7, 0x0

    .line 430
    .local v7, "encodedAddress":Ljava/lang/String;
    :try_start_1
    const-string v8, "UTF-8"

    invoke-static {v3, v8}, Ljava/net/URLEncoder;->encode(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v8
    :try_end_1
    .catch Ljava/io/UnsupportedEncodingException; {:try_start_1 .. :try_end_1} :catch_0
    .catch Ljava/lang/UnsupportedOperationException; {:try_start_1 .. :try_end_1} :catch_1

    move-object v7, v8

    .line 433
    nop

    .line 435
    :try_start_2
    new-instance v8, Ljava/lang/StringBuilder;

    invoke-direct {v8}, Ljava/lang/StringBuilder;-><init>()V

    const-string v9, "geo:0,0?q="

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v8, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v8}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v8

    iput-object v8, v4, Landroid/support/v4/text/util/LinkifyCompat$LinkSpec;->url:Ljava/lang/String;

    .line 436
    invoke-virtual {p0, v4}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z
    :try_end_2
    .catch Ljava/lang/UnsupportedOperationException; {:try_start_2 .. :try_end_2} :catch_1

    .line 437
    goto :goto_0

    .line 431
    :catch_0
    move-exception v8

    .line 432
    .local v8, "e":Ljava/io/UnsupportedEncodingException;
    goto :goto_0

    .line 411
    .end local v2    # "start":I
    .end local v4    # "spec":Landroid/support/v4/text/util/LinkifyCompat$LinkSpec;
    .end local v5    # "length":I
    .end local v6    # "end":I
    .end local v7    # "encodedAddress":Ljava/lang/String;
    .end local v8    # "e":Ljava/io/UnsupportedEncodingException;
    :cond_1
    nop

    .line 443
    :goto_1
    nop

    .line 444
    return-void

    .line 438
    .end local v3    # "address":Ljava/lang/String;
    :catch_1
    move-exception v2

    .line 442
    .local v2, "e":Ljava/lang/UnsupportedOperationException;
    return-void
.end method

.method private static makeUrl(Ljava/lang/String;[Ljava/lang/String;Ljava/util/regex/Matcher;Landroid/text/util/Linkify$TransformFilter;)Ljava/lang/String;
    .locals 8
    .param p0, "url"    # Ljava/lang/String;
        .annotation build Landroid/support/annotation/NonNull;
        .end annotation
    .end param
    .param p1, "prefixes"    # [Ljava/lang/String;
        .annotation build Landroid/support/annotation/NonNull;
        .end annotation
    .end param
    .param p2, "matcher"    # Ljava/util/regex/Matcher;
    .param p3, "filter"    # Landroid/text/util/Linkify$TransformFilter;
        .annotation build Landroid/support/annotation/Nullable;
        .end annotation
    .end param

    .line 351
    if-eqz p3, :cond_0

    .line 352
    invoke-interface {p3, p2, p0}, Landroid/text/util/Linkify$TransformFilter;->transformUrl(Ljava/util/regex/Matcher;Ljava/lang/String;)Ljava/lang/String;

    move-result-object p0

    goto :goto_0

    .line 351
    :cond_0
    nop

    .line 355
    :goto_0
    const/4 v6, 0x0

    .line 357
    .local v6, "hasPrefix":Z
    const/4 v0, 0x0

    move v7, v0

    .local v7, "i":I
    :goto_1
    array-length v0, p1

    if-ge v7, v0, :cond_3

    .line 358
    const/4 v1, 0x1

    const/4 v2, 0x0

    aget-object v3, p1, v7

    const/4 v4, 0x0

    aget-object v0, p1, v7

    invoke-virtual {v0}, Ljava/lang/String;->length()I

    move-result v5

    move-object v0, p0

    invoke-virtual/range {v0 .. v5}, Ljava/lang/String;->regionMatches(ZILjava/lang/String;II)Z

    move-result v0

    if-eqz v0, :cond_2

    .line 359
    const/4 v6, 0x1

    .line 362
    const/4 v1, 0x0

    const/4 v2, 0x0

    aget-object v3, p1, v7

    const/4 v4, 0x0

    aget-object v0, p1, v7

    invoke-virtual {v0}, Ljava/lang/String;->length()I

    move-result v5

    move-object v0, p0

    invoke-virtual/range {v0 .. v5}, Ljava/lang/String;->regionMatches(ZILjava/lang/String;II)Z

    move-result v0

    if-nez v0, :cond_1

    .line 363
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    aget-object v1, p1, v7

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    aget-object v1, p1, v7

    invoke-virtual {v1}, Ljava/lang/String;->length()I

    move-result v1

    invoke-virtual {p0, v1}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p0

    goto :goto_2

    .line 362
    :cond_1
    goto :goto_2

    .line 357
    :cond_2
    add-int/lit8 v7, v7, 0x1

    goto :goto_1

    .line 370
    .end local v7    # "i":I
    :cond_3
    :goto_2
    if-nez v6, :cond_4

    array-length v0, p1

    if-lez v0, :cond_4

    .line 371
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const/4 v1, 0x0

    aget-object v1, p1, v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v0, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p0

    goto :goto_3

    .line 370
    :cond_4
    nop

    .line 374
    :goto_3
    return-object p0
.end method

.method private static final pruneOverlaps(Ljava/util/ArrayList;Landroid/text/Spannable;)V
    .locals 9
    .param p1, "text"    # Landroid/text/Spannable;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/ArrayList<",
            "Landroid/support/v4/text/util/LinkifyCompat$LinkSpec;",
            ">;",
            "Landroid/text/Spannable;",
            ")V"
        }
    .end annotation

    .line 448
    .local p0, "links":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Landroid/support/v4/text/util/LinkifyCompat$LinkSpec;>;"
    invoke-interface {p1}, Landroid/text/Spannable;->length()I

    move-result v0

    const-class v1, Landroid/text/style/URLSpan;

    const/4 v2, 0x0

    invoke-interface {p1, v2, v0, v1}, Landroid/text/Spannable;->getSpans(IILjava/lang/Class;)[Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Landroid/text/style/URLSpan;

    .line 449
    .local v0, "urlSpans":[Landroid/text/style/URLSpan;
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_0
    array-length v2, v0

    if-ge v1, v2, :cond_0

    .line 450
    new-instance v2, Landroid/support/v4/text/util/LinkifyCompat$LinkSpec;

    invoke-direct {v2}, Landroid/support/v4/text/util/LinkifyCompat$LinkSpec;-><init>()V

    .line 451
    .local v2, "spec":Landroid/support/v4/text/util/LinkifyCompat$LinkSpec;
    aget-object v3, v0, v1

    iput-object v3, v2, Landroid/support/v4/text/util/LinkifyCompat$LinkSpec;->frameworkAddedSpan:Landroid/text/style/URLSpan;

    .line 452
    aget-object v3, v0, v1

    invoke-interface {p1, v3}, Landroid/text/Spannable;->getSpanStart(Ljava/lang/Object;)I

    move-result v3

    iput v3, v2, Landroid/support/v4/text/util/LinkifyCompat$LinkSpec;->start:I

    .line 453
    aget-object v3, v0, v1

    invoke-interface {p1, v3}, Landroid/text/Spannable;->getSpanEnd(Ljava/lang/Object;)I

    move-result v3

    iput v3, v2, Landroid/support/v4/text/util/LinkifyCompat$LinkSpec;->end:I

    .line 454
    invoke-virtual {p0, v2}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 449
    .end local v2    # "spec":Landroid/support/v4/text/util/LinkifyCompat$LinkSpec;
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 457
    .end local v1    # "i":I
    :cond_0
    sget-object v1, Landroid/support/v4/text/util/LinkifyCompat;->COMPARATOR:Ljava/util/Comparator;

    invoke-static {p0, v1}, Ljava/util/Collections;->sort(Ljava/util/List;Ljava/util/Comparator;)V

    .line 459
    invoke-virtual {p0}, Ljava/util/ArrayList;->size()I

    move-result v1

    .line 460
    .local v1, "len":I
    const/4 v2, 0x0

    .line 462
    .local v2, "i":I
    :goto_1
    add-int/lit8 v3, v1, -0x1

    if-ge v2, v3, :cond_7

    .line 463
    invoke-virtual {p0, v2}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Landroid/support/v4/text/util/LinkifyCompat$LinkSpec;

    .line 464
    .local v3, "a":Landroid/support/v4/text/util/LinkifyCompat$LinkSpec;
    add-int/lit8 v4, v2, 0x1

    invoke-virtual {p0, v4}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Landroid/support/v4/text/util/LinkifyCompat$LinkSpec;

    .line 465
    .local v4, "b":Landroid/support/v4/text/util/LinkifyCompat$LinkSpec;
    const/4 v5, -0x1

    .line 467
    .local v5, "remove":I
    iget v6, v3, Landroid/support/v4/text/util/LinkifyCompat$LinkSpec;->start:I

    iget v7, v4, Landroid/support/v4/text/util/LinkifyCompat$LinkSpec;->start:I

    if-gt v6, v7, :cond_6

    iget v6, v3, Landroid/support/v4/text/util/LinkifyCompat$LinkSpec;->end:I

    iget v7, v4, Landroid/support/v4/text/util/LinkifyCompat$LinkSpec;->start:I

    if-le v6, v7, :cond_6

    .line 468
    iget v6, v4, Landroid/support/v4/text/util/LinkifyCompat$LinkSpec;->end:I

    iget v7, v3, Landroid/support/v4/text/util/LinkifyCompat$LinkSpec;->end:I

    if-gt v6, v7, :cond_1

    .line 469
    add-int/lit8 v5, v2, 0x1

    goto :goto_2

    .line 470
    :cond_1
    iget v6, v3, Landroid/support/v4/text/util/LinkifyCompat$LinkSpec;->end:I

    iget v7, v3, Landroid/support/v4/text/util/LinkifyCompat$LinkSpec;->start:I

    sub-int/2addr v6, v7

    iget v7, v4, Landroid/support/v4/text/util/LinkifyCompat$LinkSpec;->end:I

    iget v8, v4, Landroid/support/v4/text/util/LinkifyCompat$LinkSpec;->start:I

    sub-int/2addr v7, v8

    if-le v6, v7, :cond_2

    .line 471
    add-int/lit8 v5, v2, 0x1

    goto :goto_2

    .line 472
    :cond_2
    iget v6, v3, Landroid/support/v4/text/util/LinkifyCompat$LinkSpec;->end:I

    iget v7, v3, Landroid/support/v4/text/util/LinkifyCompat$LinkSpec;->start:I

    sub-int/2addr v6, v7

    iget v7, v4, Landroid/support/v4/text/util/LinkifyCompat$LinkSpec;->end:I

    iget v8, v4, Landroid/support/v4/text/util/LinkifyCompat$LinkSpec;->start:I

    sub-int/2addr v7, v8

    if-ge v6, v7, :cond_3

    .line 473
    move v5, v2

    goto :goto_2

    .line 472
    :cond_3
    nop

    .line 476
    :goto_2
    const/4 v6, -0x1

    if-eq v5, v6, :cond_5

    .line 477
    invoke-virtual {p0, v5}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Landroid/support/v4/text/util/LinkifyCompat$LinkSpec;

    iget-object v6, v6, Landroid/support/v4/text/util/LinkifyCompat$LinkSpec;->frameworkAddedSpan:Landroid/text/style/URLSpan;

    .line 478
    .local v6, "span":Landroid/text/style/URLSpan;
    if-eqz v6, :cond_4

    .line 479
    invoke-interface {p1, v6}, Landroid/text/Spannable;->removeSpan(Ljava/lang/Object;)V

    goto :goto_3

    .line 478
    :cond_4
    nop

    .line 481
    :goto_3
    invoke-virtual {p0, v5}, Ljava/util/ArrayList;->remove(I)Ljava/lang/Object;

    .line 482
    add-int/lit8 v1, v1, -0x1

    .line 483
    goto :goto_1

    .line 476
    .end local v6    # "span":Landroid/text/style/URLSpan;
    :cond_5
    goto :goto_4

    .line 467
    :cond_6
    nop

    .line 488
    :goto_4
    nop

    .end local v3    # "a":Landroid/support/v4/text/util/LinkifyCompat$LinkSpec;
    .end local v4    # "b":Landroid/support/v4/text/util/LinkifyCompat$LinkSpec;
    .end local v5    # "remove":I
    add-int/lit8 v2, v2, 0x1

    .line 489
    goto :goto_1

    .line 490
    :cond_7
    return-void
.end method
