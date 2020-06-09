.class public Landroid/support/graphics/drawable/AnimatorInflaterCompat;
.super Ljava/lang/Object;
.source "AnimatorInflaterCompat.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroid/support/graphics/drawable/AnimatorInflaterCompat$PathDataEvaluator;
    }
.end annotation


# static fields
.field private static final DBG_ANIMATOR_INFLATER:Z = false

.field private static final SEQUENTIALLY:I = 0x1

.field private static final TAG:Ljava/lang/String; = "AnimatorInflater"

.field private static final TOGETHER:I = 0x0

.field private static final VALUE_TYPE_COLOR:I = 0x3

.field private static final VALUE_TYPE_FLOAT:I = 0x0

.field private static final VALUE_TYPE_INT:I = 0x1

.field private static final VALUE_TYPE_PATH:I = 0x2

.field private static final VALUE_TYPE_UNDEFINED:I = 0x4

.field private static final sTmpTypedValue:Landroid/util/TypedValue;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .line 78
    new-instance v0, Landroid/util/TypedValue;

    invoke-direct {v0}, Landroid/util/TypedValue;-><init>()V

    sput-object v0, Landroid/support/graphics/drawable/AnimatorInflaterCompat;->sTmpTypedValue:Landroid/util/TypedValue;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .line 58
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 151
    return-void
.end method

.method private static createAnimatorFromXml(Landroid/content/Context;Landroid/content/res/Resources;Landroid/content/res/Resources$Theme;Lorg/xmlpull/v1/XmlPullParser;F)Landroid/animation/Animator;
    .locals 8
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "res"    # Landroid/content/res/Resources;
    .param p2, "theme"    # Landroid/content/res/Resources$Theme;
    .param p3, "parser"    # Lorg/xmlpull/v1/XmlPullParser;
    .param p4, "pixelSize"    # F
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/xmlpull/v1/XmlPullParserException;,
            Ljava/io/IOException;
        }
    .end annotation

    .line 417
    invoke-static {p3}, Landroid/util/Xml;->asAttributeSet(Lorg/xmlpull/v1/XmlPullParser;)Landroid/util/AttributeSet;

    move-result-object v4

    const/4 v5, 0x0

    const/4 v6, 0x0

    move-object v0, p0

    move-object v1, p1

    move-object v2, p2

    move-object v3, p3

    move v7, p4

    invoke-static/range {v0 .. v7}, Landroid/support/graphics/drawable/AnimatorInflaterCompat;->createAnimatorFromXml(Landroid/content/Context;Landroid/content/res/Resources;Landroid/content/res/Resources$Theme;Lorg/xmlpull/v1/XmlPullParser;Landroid/util/AttributeSet;Landroid/animation/AnimatorSet;IF)Landroid/animation/Animator;

    move-result-object v0

    return-object v0
.end method

.method private static createAnimatorFromXml(Landroid/content/Context;Landroid/content/res/Resources;Landroid/content/res/Resources$Theme;Lorg/xmlpull/v1/XmlPullParser;Landroid/util/AttributeSet;Landroid/animation/AnimatorSet;IF)Landroid/animation/Animator;
    .locals 20
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "res"    # Landroid/content/res/Resources;
    .param p2, "theme"    # Landroid/content/res/Resources$Theme;
    .param p3, "parser"    # Lorg/xmlpull/v1/XmlPullParser;
    .param p4, "attrs"    # Landroid/util/AttributeSet;
    .param p5, "parent"    # Landroid/animation/AnimatorSet;
    .param p6, "sequenceOrdering"    # I
    .param p7, "pixelSize"    # F
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/xmlpull/v1/XmlPullParserException;,
            Ljava/io/IOException;
        }
    .end annotation

    .line 425
    move-object/from16 v8, p1

    move-object/from16 v9, p2

    move-object/from16 v10, p3

    move-object/from16 v11, p5

    const/4 v0, 0x0

    .line 426
    .local v0, "anim":Landroid/animation/Animator;
    const/4 v1, 0x0

    .line 430
    .local v1, "childAnims":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Landroid/animation/Animator;>;"
    invoke-interface/range {p3 .. p3}, Lorg/xmlpull/v1/XmlPullParser;->getDepth()I

    move-result v12

    move-object v7, v0

    move-object v13, v1

    .line 432
    .end local v0    # "anim":Landroid/animation/Animator;
    .end local v1    # "childAnims":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Landroid/animation/Animator;>;"
    .local v7, "anim":Landroid/animation/Animator;
    .local v12, "depth":I
    .local v13, "childAnims":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Landroid/animation/Animator;>;"
    :goto_0
    invoke-interface/range {p3 .. p3}, Lorg/xmlpull/v1/XmlPullParser;->next()I

    move-result v0

    move v14, v0

    .local v14, "type":I
    const/4 v1, 0x3

    if-ne v0, v1, :cond_1

    invoke-interface/range {p3 .. p3}, Lorg/xmlpull/v1/XmlPullParser;->getDepth()I

    move-result v0

    if-le v0, v12, :cond_0

    goto :goto_1

    :cond_0
    move-object/from16 v1, p0

    goto/16 :goto_6

    :cond_1
    :goto_1
    const/4 v0, 0x1

    if-eq v14, v0, :cond_a

    .line 435
    const/4 v0, 0x2

    if-eq v14, v0, :cond_2

    .line 436
    goto :goto_0

    .line 439
    :cond_2
    invoke-interface/range {p3 .. p3}, Lorg/xmlpull/v1/XmlPullParser;->getName()Ljava/lang/String;

    move-result-object v15

    .line 440
    .local v15, "name":Ljava/lang/String;
    const/16 v16, 0x0

    .line 442
    .local v16, "gotValues":Z
    const-string v0, "objectAnimator"

    invoke-virtual {v15, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_3

    .line 443
    move-object/from16 v0, p0

    move-object/from16 v1, p1

    move-object/from16 v2, p2

    move-object/from16 v3, p4

    move/from16 v4, p7

    move-object/from16 v5, p3

    invoke-static/range {v0 .. v5}, Landroid/support/graphics/drawable/AnimatorInflaterCompat;->loadObjectAnimator(Landroid/content/Context;Landroid/content/res/Resources;Landroid/content/res/Resources$Theme;Landroid/util/AttributeSet;FLorg/xmlpull/v1/XmlPullParser;)Landroid/animation/ObjectAnimator;

    move-result-object v0

    move-object/from16 v1, p0

    move-object v7, v0

    goto/16 :goto_3

    .line 444
    :cond_3
    const-string v0, "animator"

    invoke-virtual {v15, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_4

    .line 445
    const/4 v4, 0x0

    move-object/from16 v0, p0

    move-object/from16 v1, p1

    move-object/from16 v2, p2

    move-object/from16 v3, p4

    move/from16 v5, p7

    move-object/from16 v6, p3

    invoke-static/range {v0 .. v6}, Landroid/support/graphics/drawable/AnimatorInflaterCompat;->loadAnimator(Landroid/content/Context;Landroid/content/res/Resources;Landroid/content/res/Resources$Theme;Landroid/util/AttributeSet;Landroid/animation/ValueAnimator;FLorg/xmlpull/v1/XmlPullParser;)Landroid/animation/ValueAnimator;

    move-result-object v0

    move-object/from16 v1, p0

    move-object v7, v0

    goto :goto_3

    .line 446
    :cond_4
    const-string v0, "set"

    invoke-virtual {v15, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_5

    .line 447
    new-instance v0, Landroid/animation/AnimatorSet;

    invoke-direct {v0}, Landroid/animation/AnimatorSet;-><init>()V

    move-object/from16 v17, v0

    .line 448
    .end local v7    # "anim":Landroid/animation/Animator;
    .local v17, "anim":Landroid/animation/Animator;
    sget-object v0, Landroid/support/graphics/drawable/AndroidResources;->STYLEABLE_ANIMATOR_SET:[I

    move-object/from16 v7, p4

    invoke-static {v8, v9, v7, v0}, Landroid/support/graphics/drawable/TypedArrayUtils;->obtainAttributes(Landroid/content/res/Resources;Landroid/content/res/Resources$Theme;Landroid/util/AttributeSet;[I)Landroid/content/res/TypedArray;

    move-result-object v6

    .line 451
    .local v6, "a":Landroid/content/res/TypedArray;
    const-string v0, "ordering"

    const/4 v1, 0x0

    invoke-static {v6, v10, v0, v1, v1}, Landroid/support/graphics/drawable/TypedArrayUtils;->getNamedInt(Landroid/content/res/TypedArray;Lorg/xmlpull/v1/XmlPullParser;Ljava/lang/String;II)I

    move-result v18

    .line 454
    .local v18, "ordering":I
    move-object/from16 v5, v17

    check-cast v5, Landroid/animation/AnimatorSet;

    move-object/from16 v0, p0

    move-object/from16 v1, p1

    move-object/from16 v2, p2

    move-object/from16 v3, p3

    move-object/from16 v4, p4

    move-object/from16 v19, v6

    .end local v6    # "a":Landroid/content/res/TypedArray;
    .local v19, "a":Landroid/content/res/TypedArray;
    move/from16 v6, v18

    move/from16 v7, p7

    invoke-static/range {v0 .. v7}, Landroid/support/graphics/drawable/AnimatorInflaterCompat;->createAnimatorFromXml(Landroid/content/Context;Landroid/content/res/Resources;Landroid/content/res/Resources$Theme;Lorg/xmlpull/v1/XmlPullParser;Landroid/util/AttributeSet;Landroid/animation/AnimatorSet;IF)Landroid/animation/Animator;

    .line 456
    invoke-virtual/range {v19 .. v19}, Landroid/content/res/TypedArray;->recycle()V

    .line 457
    .end local v18    # "ordering":I
    .end local v19    # "a":Landroid/content/res/TypedArray;
    move-object/from16 v1, p0

    move-object/from16 v7, v17

    goto :goto_3

    .end local v17    # "anim":Landroid/animation/Animator;
    .restart local v7    # "anim":Landroid/animation/Animator;
    :cond_5
    const-string v0, "propertyValuesHolder"

    invoke-virtual {v15, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_9

    .line 458
    nop

    .line 459
    invoke-static/range {p3 .. p3}, Landroid/util/Xml;->asAttributeSet(Lorg/xmlpull/v1/XmlPullParser;)Landroid/util/AttributeSet;

    move-result-object v0

    .line 458
    move-object/from16 v1, p0

    invoke-static {v1, v8, v9, v10, v0}, Landroid/support/graphics/drawable/AnimatorInflaterCompat;->loadValues(Landroid/content/Context;Landroid/content/res/Resources;Landroid/content/res/Resources$Theme;Lorg/xmlpull/v1/XmlPullParser;Landroid/util/AttributeSet;)[Landroid/animation/PropertyValuesHolder;

    move-result-object v0

    .line 460
    .local v0, "values":[Landroid/animation/PropertyValuesHolder;
    if-eqz v0, :cond_6

    if-eqz v7, :cond_6

    instance-of v2, v7, Landroid/animation/ValueAnimator;

    if-eqz v2, :cond_6

    .line 461
    move-object v2, v7

    check-cast v2, Landroid/animation/ValueAnimator;

    invoke-virtual {v2, v0}, Landroid/animation/ValueAnimator;->setValues([Landroid/animation/PropertyValuesHolder;)V

    goto :goto_2

    .line 460
    :cond_6
    nop

    .line 463
    :goto_2
    const/16 v16, 0x1

    .line 464
    .end local v0    # "values":[Landroid/animation/PropertyValuesHolder;
    nop

    .line 468
    :goto_3
    if-eqz v11, :cond_8

    if-nez v16, :cond_8

    .line 469
    if-nez v13, :cond_7

    .line 470
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    move-object v13, v0

    goto :goto_4

    .line 469
    :cond_7
    nop

    .line 472
    :goto_4
    invoke-virtual {v13, v7}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto :goto_5

    .line 468
    :cond_8
    nop

    .line 474
    .end local v15    # "name":Ljava/lang/String;
    .end local v16    # "gotValues":Z
    :goto_5
    goto/16 :goto_0

    .line 465
    .restart local v15    # "name":Ljava/lang/String;
    .restart local v16    # "gotValues":Z
    :cond_9
    move-object/from16 v1, p0

    new-instance v0, Ljava/lang/RuntimeException;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Unknown animator name: "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-interface/range {p3 .. p3}, Lorg/xmlpull/v1/XmlPullParser;->getName()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v0, v2}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 432
    .end local v15    # "name":Ljava/lang/String;
    .end local v16    # "gotValues":Z
    :cond_a
    move-object/from16 v1, p0

    .line 475
    :goto_6
    if-eqz v11, :cond_d

    if-eqz v13, :cond_d

    .line 476
    invoke-virtual {v13}, Ljava/util/ArrayList;->size()I

    move-result v0

    new-array v0, v0, [Landroid/animation/Animator;

    .line 477
    .local v0, "animsArray":[Landroid/animation/Animator;
    const/4 v2, 0x0

    .line 478
    .local v2, "index":I
    invoke-virtual {v13}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v3

    :goto_7
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_b

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Landroid/animation/Animator;

    .line 479
    .local v4, "a":Landroid/animation/Animator;
    add-int/lit8 v5, v2, 0x1

    .end local v2    # "index":I
    .local v5, "index":I
    aput-object v4, v0, v2

    .line 480
    .end local v4    # "a":Landroid/animation/Animator;
    move v2, v5

    goto :goto_7

    .line 481
    .end local v5    # "index":I
    .restart local v2    # "index":I
    :cond_b
    if-nez p6, :cond_c

    .line 482
    invoke-virtual {v11, v0}, Landroid/animation/AnimatorSet;->playTogether([Landroid/animation/Animator;)V

    goto :goto_8

    .line 484
    :cond_c
    invoke-virtual {v11, v0}, Landroid/animation/AnimatorSet;->playSequentially([Landroid/animation/Animator;)V

    goto :goto_8

    .line 475
    .end local v0    # "animsArray":[Landroid/animation/Animator;
    .end local v2    # "index":I
    :cond_d
    nop

    .line 487
    :goto_8
    return-object v7
.end method

.method private static createNewKeyframe(Landroid/animation/Keyframe;F)Landroid/animation/Keyframe;
    .locals 2
    .param p0, "sampleKeyframe"    # Landroid/animation/Keyframe;
    .param p1, "fraction"    # F

    .line 695
    invoke-virtual {p0}, Landroid/animation/Keyframe;->getType()Ljava/lang/Class;

    move-result-object v0

    sget-object v1, Ljava/lang/Float;->TYPE:Ljava/lang/Class;

    if-ne v0, v1, :cond_0

    .line 696
    invoke-static {p1}, Landroid/animation/Keyframe;->ofFloat(F)Landroid/animation/Keyframe;

    move-result-object v0

    goto :goto_0

    .line 697
    :cond_0
    invoke-virtual {p0}, Landroid/animation/Keyframe;->getType()Ljava/lang/Class;

    move-result-object v0

    sget-object v1, Ljava/lang/Integer;->TYPE:Ljava/lang/Class;

    if-ne v0, v1, :cond_1

    .line 698
    invoke-static {p1}, Landroid/animation/Keyframe;->ofInt(F)Landroid/animation/Keyframe;

    move-result-object v0

    goto :goto_0

    .line 699
    :cond_1
    invoke-static {p1}, Landroid/animation/Keyframe;->ofObject(F)Landroid/animation/Keyframe;

    move-result-object v0

    :goto_0
    return-object v0
.end method

.method private static distributeKeyframes([Landroid/animation/Keyframe;FII)V
    .locals 5
    .param p0, "keyframes"    # [Landroid/animation/Keyframe;
    .param p1, "gap"    # F
    .param p2, "startIndex"    # I
    .param p3, "endIndex"    # I

    .line 722
    sub-int v0, p3, p2

    add-int/lit8 v0, v0, 0x2

    .line 723
    .local v0, "count":I
    int-to-float v1, v0

    div-float v1, p1, v1

    .line 724
    .local v1, "increment":F
    move v2, p2

    .local v2, "i":I
    :goto_0
    if-gt v2, p3, :cond_0

    .line 725
    aget-object v3, p0, v2

    add-int/lit8 v4, v2, -0x1

    aget-object v4, p0, v4

    invoke-virtual {v4}, Landroid/animation/Keyframe;->getFraction()F

    move-result v4

    add-float/2addr v4, v1

    invoke-virtual {v3, v4}, Landroid/animation/Keyframe;->setFraction(F)V

    .line 724
    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    .line 727
    .end local v2    # "i":I
    :cond_0
    return-void
.end method

.method private static dumpKeyframes([Ljava/lang/Object;Ljava/lang/String;)V
    .locals 7
    .param p0, "keyframes"    # [Ljava/lang/Object;
    .param p1, "header"    # Ljava/lang/String;

    .line 589
    if-eqz p0, :cond_4

    array-length v0, p0

    if-nez v0, :cond_0

    goto :goto_3

    .line 592
    :cond_0
    const-string v0, "AnimatorInflater"

    invoke-static {v0, p1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 593
    array-length v0, p0

    .line 594
    .local v0, "count":I
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_0
    if-ge v1, v0, :cond_3

    .line 595
    aget-object v2, p0, v1

    check-cast v2, Landroid/animation/Keyframe;

    .line 596
    .local v2, "keyframe":Landroid/animation/Keyframe;
    const-string v3, "AnimatorInflater"

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "Keyframe "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v4, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    const-string v5, ": fraction "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 597
    invoke-virtual {v2}, Landroid/animation/Keyframe;->getFraction()F

    move-result v5

    const/4 v6, 0x0

    cmpg-float v5, v5, v6

    if-gez v5, :cond_1

    const-string v5, "null"

    goto :goto_1

    :cond_1
    invoke-virtual {v2}, Landroid/animation/Keyframe;->getFraction()F

    move-result v5

    invoke-static {v5}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v5

    :goto_1
    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    const-string v5, ", "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v5, ", value : "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 598
    invoke-virtual {v2}, Landroid/animation/Keyframe;->hasValue()Z

    move-result v5

    if-eqz v5, :cond_2

    invoke-virtual {v2}, Landroid/animation/Keyframe;->getValue()Ljava/lang/Object;

    move-result-object v5

    goto :goto_2

    :cond_2
    const-string v5, "null"

    :goto_2
    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    .line 596
    invoke-static {v3, v4}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 594
    .end local v2    # "keyframe":Landroid/animation/Keyframe;
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 600
    .end local v1    # "i":I
    :cond_3
    return-void

    .line 589
    .end local v0    # "count":I
    :cond_4
    :goto_3
    nop

    .line 590
    return-void
.end method

.method private static getPVH(Landroid/content/res/TypedArray;IIILjava/lang/String;)Landroid/animation/PropertyValuesHolder;
    .locals 22
    .param p0, "styledAttributes"    # Landroid/content/res/TypedArray;
    .param p1, "valueType"    # I
    .param p2, "valueFromId"    # I
    .param p3, "valueToId"    # I
    .param p4, "propertyName"    # Ljava/lang/String;

    .line 201
    move-object/from16 v0, p0

    move/from16 v1, p2

    move/from16 v2, p3

    move-object/from16 v3, p4

    invoke-virtual {v0, v1}, Landroid/content/res/TypedArray;->peekValue(I)Landroid/util/TypedValue;

    move-result-object v4

    .line 202
    .local v4, "tvFrom":Landroid/util/TypedValue;
    if-eqz v4, :cond_0

    const/4 v7, 0x1

    goto :goto_0

    :cond_0
    const/4 v7, 0x0

    .line 203
    .local v7, "hasFrom":Z
    :goto_0
    if-eqz v7, :cond_1

    iget v8, v4, Landroid/util/TypedValue;->type:I

    goto :goto_1

    :cond_1
    const/4 v8, 0x0

    .line 204
    .local v8, "fromType":I
    :goto_1
    invoke-virtual {v0, v2}, Landroid/content/res/TypedArray;->peekValue(I)Landroid/util/TypedValue;

    move-result-object v9

    .line 205
    .local v9, "tvTo":Landroid/util/TypedValue;
    if-eqz v9, :cond_2

    const/4 v10, 0x1

    goto :goto_2

    :cond_2
    const/4 v10, 0x0

    .line 206
    .local v10, "hasTo":Z
    :goto_2
    if-eqz v10, :cond_3

    iget v11, v9, Landroid/util/TypedValue;->type:I

    goto :goto_3

    :cond_3
    const/4 v11, 0x0

    .line 208
    .local v11, "toType":I
    :goto_3
    const/4 v12, 0x4

    move/from16 v13, p1

    if-ne v13, v12, :cond_7

    .line 210
    if-eqz v7, :cond_5

    invoke-static {v8}, Landroid/support/graphics/drawable/AnimatorInflaterCompat;->isColorType(I)Z

    move-result v12

    if-nez v12, :cond_4

    goto :goto_5

    :cond_4
    :goto_4
    goto :goto_6

    :cond_5
    :goto_5
    if-eqz v10, :cond_6

    invoke-static {v11}, Landroid/support/graphics/drawable/AnimatorInflaterCompat;->isColorType(I)Z

    move-result v12

    if-eqz v12, :cond_6

    goto :goto_4

    .line 211
    :goto_6
    const/4 v12, 0x3

    goto :goto_7

    .line 210
    :cond_6
    nop

    .line 213
    const/4 v12, 0x0

    goto :goto_7

    .line 208
    :cond_7
    move v12, v13

    .line 217
    .end local p1    # "valueType":I
    .local v12, "valueType":I
    :goto_7
    if-nez v12, :cond_8

    const/4 v13, 0x1

    goto :goto_8

    :cond_8
    const/4 v13, 0x0

    .line 219
    .local v13, "getFloats":Z
    :goto_8
    const/4 v14, 0x0

    .line 221
    .local v14, "returnValue":Landroid/animation/PropertyValuesHolder;
    const/4 v15, 0x2

    if-ne v12, v15, :cond_f

    .line 222
    invoke-virtual {v0, v1}, Landroid/content/res/TypedArray;->getString(I)Ljava/lang/String;

    move-result-object v5

    .line 223
    .local v5, "fromString":Ljava/lang/String;
    invoke-virtual {v0, v2}, Landroid/content/res/TypedArray;->getString(I)Ljava/lang/String;

    move-result-object v6

    .line 225
    .local v6, "toString":Ljava/lang/String;
    nop

    .line 226
    invoke-static {v5}, Landroid/support/graphics/drawable/PathParser;->createNodesFromPathData(Ljava/lang/String;)[Landroid/support/graphics/drawable/PathParser$PathDataNode;

    move-result-object v15

    .line 227
    .local v15, "nodesFrom":[Landroid/support/graphics/drawable/PathParser$PathDataNode;
    nop

    .line 228
    move-object/from16 v18, v4

    .end local v4    # "tvFrom":Landroid/util/TypedValue;
    .local v18, "tvFrom":Landroid/util/TypedValue;
    invoke-static {v6}, Landroid/support/graphics/drawable/PathParser;->createNodesFromPathData(Ljava/lang/String;)[Landroid/support/graphics/drawable/PathParser$PathDataNode;

    move-result-object v4

    .line 229
    .local v4, "nodesTo":[Landroid/support/graphics/drawable/PathParser$PathDataNode;
    if-nez v15, :cond_a

    if-eqz v4, :cond_9

    goto :goto_9

    :cond_9
    move-object/from16 v19, v9

    move/from16 v21, v11

    move-object/from16 v20, v14

    goto/16 :goto_b

    .line 230
    :cond_a
    :goto_9
    move-object/from16 v19, v9

    .end local v9    # "tvTo":Landroid/util/TypedValue;
    .local v19, "tvTo":Landroid/util/TypedValue;
    const/4 v9, 0x0

    if-eqz v15, :cond_d

    .line 231
    move-object/from16 v20, v14

    .end local v14    # "returnValue":Landroid/animation/PropertyValuesHolder;
    .local v20, "returnValue":Landroid/animation/PropertyValuesHolder;
    new-instance v14, Landroid/support/graphics/drawable/AnimatorInflaterCompat$PathDataEvaluator;

    invoke-direct {v14, v9}, Landroid/support/graphics/drawable/AnimatorInflaterCompat$PathDataEvaluator;-><init>(Landroid/support/graphics/drawable/AnimatorInflaterCompat$1;)V

    move-object v9, v14

    .line 232
    .local v9, "evaluator":Landroid/animation/TypeEvaluator;
    if-eqz v4, :cond_c

    .line 233
    invoke-static {v15, v4}, Landroid/support/graphics/drawable/PathParser;->canMorph([Landroid/support/graphics/drawable/PathParser$PathDataNode;[Landroid/support/graphics/drawable/PathParser$PathDataNode;)Z

    move-result v14

    if-eqz v14, :cond_b

    .line 237
    const/4 v14, 0x2

    new-array v14, v14, [Ljava/lang/Object;

    const/16 v17, 0x0

    aput-object v15, v14, v17

    const/16 v16, 0x1

    aput-object v4, v14, v16

    invoke-static {v3, v9, v14}, Landroid/animation/PropertyValuesHolder;->ofObject(Ljava/lang/String;Landroid/animation/TypeEvaluator;[Ljava/lang/Object;)Landroid/animation/PropertyValuesHolder;

    move-result-object v14

    move/from16 v21, v11

    goto :goto_a

    .line 234
    :cond_b
    new-instance v14, Landroid/view/InflateException;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    move/from16 v21, v11

    .end local v11    # "toType":I
    .local v21, "toType":I
    const-string v11, " Can\'t morph from "

    invoke-virtual {v2, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v2, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v11, " to "

    invoke-virtual {v2, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v2, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v14, v2}, Landroid/view/InflateException;-><init>(Ljava/lang/String;)V

    throw v14

    .line 240
    .end local v21    # "toType":I
    .restart local v11    # "toType":I
    :cond_c
    move/from16 v21, v11

    .end local v11    # "toType":I
    .restart local v21    # "toType":I
    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v11, 0x0

    aput-object v15, v2, v11

    invoke-static {v3, v9, v2}, Landroid/animation/PropertyValuesHolder;->ofObject(Ljava/lang/String;Landroid/animation/TypeEvaluator;[Ljava/lang/Object;)Landroid/animation/PropertyValuesHolder;

    move-result-object v2

    move-object v14, v2

    .line 243
    .end local v9    # "evaluator":Landroid/animation/TypeEvaluator;
    .end local v20    # "returnValue":Landroid/animation/PropertyValuesHolder;
    .restart local v14    # "returnValue":Landroid/animation/PropertyValuesHolder;
    :goto_a
    goto :goto_c

    .end local v21    # "toType":I
    .restart local v11    # "toType":I
    :cond_d
    move/from16 v21, v11

    move-object/from16 v20, v14

    .end local v11    # "toType":I
    .end local v14    # "returnValue":Landroid/animation/PropertyValuesHolder;
    .restart local v20    # "returnValue":Landroid/animation/PropertyValuesHolder;
    .restart local v21    # "toType":I
    if-eqz v4, :cond_e

    .line 244
    new-instance v2, Landroid/support/graphics/drawable/AnimatorInflaterCompat$PathDataEvaluator;

    invoke-direct {v2, v9}, Landroid/support/graphics/drawable/AnimatorInflaterCompat$PathDataEvaluator;-><init>(Landroid/support/graphics/drawable/AnimatorInflaterCompat$1;)V

    .line 245
    .local v2, "evaluator":Landroid/animation/TypeEvaluator;
    const/4 v9, 0x1

    new-array v9, v9, [Ljava/lang/Object;

    const/4 v11, 0x0

    aput-object v4, v9, v11

    invoke-static {v3, v2, v9}, Landroid/animation/PropertyValuesHolder;->ofObject(Ljava/lang/String;Landroid/animation/TypeEvaluator;[Ljava/lang/Object;)Landroid/animation/PropertyValuesHolder;

    move-result-object v14

    goto :goto_c

    .line 243
    .end local v2    # "evaluator":Landroid/animation/TypeEvaluator;
    :cond_e
    nop

    .line 249
    .end local v4    # "nodesTo":[Landroid/support/graphics/drawable/PathParser$PathDataNode;
    .end local v5    # "fromString":Ljava/lang/String;
    .end local v6    # "toString":Ljava/lang/String;
    .end local v15    # "nodesFrom":[Landroid/support/graphics/drawable/PathParser$PathDataNode;
    .end local v19    # "tvTo":Landroid/util/TypedValue;
    .end local v20    # "returnValue":Landroid/animation/PropertyValuesHolder;
    .end local v21    # "toType":I
    .local v9, "tvTo":Landroid/util/TypedValue;
    .restart local v11    # "toType":I
    .restart local v14    # "returnValue":Landroid/animation/PropertyValuesHolder;
    :goto_b
    move-object/from16 v14, v20

    .end local v9    # "tvTo":Landroid/util/TypedValue;
    .end local v11    # "toType":I
    .restart local v19    # "tvTo":Landroid/util/TypedValue;
    .restart local v21    # "toType":I
    :goto_c
    move/from16 v9, v21

    move/from16 v11, p3

    goto/16 :goto_16

    .line 250
    .end local v18    # "tvFrom":Landroid/util/TypedValue;
    .end local v19    # "tvTo":Landroid/util/TypedValue;
    .end local v21    # "toType":I
    .local v4, "tvFrom":Landroid/util/TypedValue;
    .restart local v9    # "tvTo":Landroid/util/TypedValue;
    .restart local v11    # "toType":I
    :cond_f
    move-object/from16 v18, v4

    move-object/from16 v19, v9

    move/from16 v21, v11

    move-object/from16 v20, v14

    .end local v4    # "tvFrom":Landroid/util/TypedValue;
    .end local v9    # "tvTo":Landroid/util/TypedValue;
    .end local v11    # "toType":I
    .end local v14    # "returnValue":Landroid/animation/PropertyValuesHolder;
    .restart local v18    # "tvFrom":Landroid/util/TypedValue;
    .restart local v19    # "tvTo":Landroid/util/TypedValue;
    .restart local v20    # "returnValue":Landroid/animation/PropertyValuesHolder;
    .restart local v21    # "toType":I
    const/4 v2, 0x0

    .line 252
    .restart local v2    # "evaluator":Landroid/animation/TypeEvaluator;
    const/4 v4, 0x3

    if-ne v12, v4, :cond_10

    .line 254
    invoke-static {}, Landroid/support/graphics/drawable/ArgbEvaluator;->getInstance()Landroid/support/graphics/drawable/ArgbEvaluator;

    move-result-object v2

    goto :goto_d

    .line 252
    :cond_10
    nop

    .line 256
    :goto_d
    const/4 v4, 0x5

    const/4 v5, 0x0

    if-eqz v13, :cond_16

    .line 259
    if-eqz v7, :cond_14

    .line 260
    if-ne v8, v4, :cond_11

    .line 261
    invoke-virtual {v0, v1, v5}, Landroid/content/res/TypedArray;->getDimension(IF)F

    move-result v6

    goto :goto_e

    .line 263
    :cond_11
    invoke-virtual {v0, v1, v5}, Landroid/content/res/TypedArray;->getFloat(IF)F

    move-result v6

    .line 265
    .local v6, "valueFrom":F
    :goto_e
    if-eqz v10, :cond_13

    .line 266
    move/from16 v9, v21

    .end local v21    # "toType":I
    .local v9, "toType":I
    if-ne v9, v4, :cond_12

    .line 267
    move/from16 v11, p3

    invoke-virtual {v0, v11, v5}, Landroid/content/res/TypedArray;->getDimension(IF)F

    move-result v4

    goto :goto_f

    .line 269
    :cond_12
    move/from16 v11, p3

    invoke-virtual {v0, v11, v5}, Landroid/content/res/TypedArray;->getFloat(IF)F

    move-result v4

    .line 271
    .local v4, "valueTo":F
    :goto_f
    const/4 v5, 0x2

    new-array v5, v5, [F

    const/4 v14, 0x0

    aput v6, v5, v14

    const/4 v15, 0x1

    aput v4, v5, v15

    invoke-static {v3, v5}, Landroid/animation/PropertyValuesHolder;->ofFloat(Ljava/lang/String;[F)Landroid/animation/PropertyValuesHolder;

    move-result-object v5

    move-object v14, v5

    goto :goto_11

    .line 274
    .end local v4    # "valueTo":F
    .end local v9    # "toType":I
    .restart local v21    # "toType":I
    :cond_13
    move/from16 v9, v21

    move/from16 v11, p3

    const/4 v14, 0x0

    const/4 v15, 0x1

    .end local v21    # "toType":I
    .restart local v9    # "toType":I
    new-array v4, v15, [F

    aput v6, v4, v14

    invoke-static {v3, v4}, Landroid/animation/PropertyValuesHolder;->ofFloat(Ljava/lang/String;[F)Landroid/animation/PropertyValuesHolder;

    move-result-object v4

    move-object v14, v4

    goto :goto_11

    .line 277
    .end local v6    # "valueFrom":F
    .end local v9    # "toType":I
    .restart local v21    # "toType":I
    :cond_14
    move/from16 v9, v21

    move/from16 v11, p3

    .end local v21    # "toType":I
    .restart local v9    # "toType":I
    if-ne v9, v4, :cond_15

    .line 278
    invoke-virtual {v0, v11, v5}, Landroid/content/res/TypedArray;->getDimension(IF)F

    move-result v4

    goto :goto_10

    .line 280
    :cond_15
    invoke-virtual {v0, v11, v5}, Landroid/content/res/TypedArray;->getFloat(IF)F

    move-result v4

    .line 282
    .restart local v4    # "valueTo":F
    :goto_10
    const/4 v5, 0x1

    new-array v5, v5, [F

    const/4 v6, 0x0

    aput v4, v5, v6

    invoke-static {v3, v5}, Landroid/animation/PropertyValuesHolder;->ofFloat(Ljava/lang/String;[F)Landroid/animation/PropertyValuesHolder;

    move-result-object v5

    move-object v14, v5

    .line 284
    .end local v4    # "valueTo":F
    .end local v20    # "returnValue":Landroid/animation/PropertyValuesHolder;
    .restart local v14    # "returnValue":Landroid/animation/PropertyValuesHolder;
    :goto_11
    goto/16 :goto_15

    .line 287
    .end local v9    # "toType":I
    .end local v14    # "returnValue":Landroid/animation/PropertyValuesHolder;
    .restart local v20    # "returnValue":Landroid/animation/PropertyValuesHolder;
    .restart local v21    # "toType":I
    :cond_16
    move/from16 v9, v21

    move/from16 v11, p3

    .end local v21    # "toType":I
    .restart local v9    # "toType":I
    if-eqz v7, :cond_1c

    .line 288
    if-ne v8, v4, :cond_17

    .line 289
    invoke-virtual {v0, v1, v5}, Landroid/content/res/TypedArray;->getDimension(IF)F

    move-result v6

    float-to-int v6, v6

    move v14, v6

    goto :goto_12

    .line 290
    :cond_17
    invoke-static {v8}, Landroid/support/graphics/drawable/AnimatorInflaterCompat;->isColorType(I)Z

    move-result v6

    if-eqz v6, :cond_18

    .line 291
    const/4 v6, 0x0

    invoke-virtual {v0, v1, v6}, Landroid/content/res/TypedArray;->getColor(II)I

    move-result v14

    goto :goto_12

    .line 293
    :cond_18
    const/4 v6, 0x0

    invoke-virtual {v0, v1, v6}, Landroid/content/res/TypedArray;->getInt(II)I

    move-result v14

    .line 295
    .local v14, "valueFrom":I
    :goto_12
    if-eqz v10, :cond_1b

    .line 296
    if-ne v9, v4, :cond_19

    .line 297
    invoke-virtual {v0, v11, v5}, Landroid/content/res/TypedArray;->getDimension(IF)F

    move-result v4

    float-to-int v4, v4

    move v5, v4

    const/4 v4, 0x0

    goto :goto_13

    .line 298
    :cond_19
    invoke-static {v9}, Landroid/support/graphics/drawable/AnimatorInflaterCompat;->isColorType(I)Z

    move-result v4

    if-eqz v4, :cond_1a

    .line 299
    const/4 v4, 0x0

    invoke-virtual {v0, v11, v4}, Landroid/content/res/TypedArray;->getColor(II)I

    move-result v5

    goto :goto_13

    .line 301
    :cond_1a
    const/4 v4, 0x0

    invoke-virtual {v0, v11, v4}, Landroid/content/res/TypedArray;->getInt(II)I

    move-result v5

    .line 303
    .local v5, "valueTo":I
    :goto_13
    const/4 v6, 0x2

    new-array v6, v6, [I

    aput v14, v6, v4

    const/4 v15, 0x1

    aput v5, v6, v15

    invoke-static {v3, v6}, Landroid/animation/PropertyValuesHolder;->ofInt(Ljava/lang/String;[I)Landroid/animation/PropertyValuesHolder;

    move-result-object v4

    move-object v14, v4

    goto :goto_15

    .line 305
    .end local v5    # "valueTo":I
    :cond_1b
    const/4 v4, 0x0

    const/4 v15, 0x1

    new-array v5, v15, [I

    aput v14, v5, v4

    invoke-static {v3, v5}, Landroid/animation/PropertyValuesHolder;->ofInt(Ljava/lang/String;[I)Landroid/animation/PropertyValuesHolder;

    move-result-object v4

    move-object v14, v4

    goto :goto_15

    .line 308
    .end local v14    # "valueFrom":I
    :cond_1c
    if-eqz v10, :cond_1f

    .line 309
    if-ne v9, v4, :cond_1d

    .line 310
    invoke-virtual {v0, v11, v5}, Landroid/content/res/TypedArray;->getDimension(IF)F

    move-result v4

    float-to-int v4, v4

    move v5, v4

    const/4 v4, 0x0

    goto :goto_14

    .line 311
    :cond_1d
    invoke-static {v9}, Landroid/support/graphics/drawable/AnimatorInflaterCompat;->isColorType(I)Z

    move-result v4

    if-eqz v4, :cond_1e

    .line 312
    const/4 v4, 0x0

    invoke-virtual {v0, v11, v4}, Landroid/content/res/TypedArray;->getColor(II)I

    move-result v5

    goto :goto_14

    .line 314
    :cond_1e
    const/4 v4, 0x0

    invoke-virtual {v0, v11, v4}, Landroid/content/res/TypedArray;->getInt(II)I

    move-result v5

    .line 316
    .restart local v5    # "valueTo":I
    :goto_14
    const/4 v6, 0x1

    new-array v6, v6, [I

    aput v5, v6, v4

    invoke-static {v3, v6}, Landroid/animation/PropertyValuesHolder;->ofInt(Ljava/lang/String;[I)Landroid/animation/PropertyValuesHolder;

    move-result-object v14

    goto :goto_15

    .line 308
    .end local v5    # "valueTo":I
    :cond_1f
    move-object/from16 v14, v20

    .line 320
    .end local v20    # "returnValue":Landroid/animation/PropertyValuesHolder;
    .local v14, "returnValue":Landroid/animation/PropertyValuesHolder;
    :goto_15
    if-eqz v14, :cond_20

    if-eqz v2, :cond_20

    .line 321
    invoke-virtual {v14, v2}, Landroid/animation/PropertyValuesHolder;->setEvaluator(Landroid/animation/TypeEvaluator;)V

    goto :goto_16

    .line 320
    :cond_20
    nop

    .line 325
    .end local v2    # "evaluator":Landroid/animation/TypeEvaluator;
    :goto_16
    return-object v14
.end method

.method private static inferValueTypeFromValues(Landroid/content/res/TypedArray;II)I
    .locals 7
    .param p0, "styledAttributes"    # Landroid/content/res/TypedArray;
    .param p1, "valueFromId"    # I
    .param p2, "valueToId"    # I

    .line 571
    invoke-virtual {p0, p1}, Landroid/content/res/TypedArray;->peekValue(I)Landroid/util/TypedValue;

    move-result-object v0

    .line 572
    .local v0, "tvFrom":Landroid/util/TypedValue;
    const/4 v1, 0x1

    const/4 v2, 0x0

    if-eqz v0, :cond_0

    const/4 v3, 0x1

    goto :goto_0

    :cond_0
    const/4 v3, 0x0

    .line 573
    .local v3, "hasFrom":Z
    :goto_0
    if-eqz v3, :cond_1

    iget v4, v0, Landroid/util/TypedValue;->type:I

    goto :goto_1

    :cond_1
    const/4 v4, 0x0

    .line 574
    .local v4, "fromType":I
    :goto_1
    invoke-virtual {p0, p2}, Landroid/content/res/TypedArray;->peekValue(I)Landroid/util/TypedValue;

    move-result-object v5

    .line 575
    .local v5, "tvTo":Landroid/util/TypedValue;
    if-eqz v5, :cond_2

    goto :goto_2

    :cond_2
    const/4 v1, 0x0

    .line 576
    .local v1, "hasTo":Z
    :goto_2
    if-eqz v1, :cond_3

    iget v2, v5, Landroid/util/TypedValue;->type:I

    nop

    .line 580
    .local v2, "toType":I
    :cond_3
    if-eqz v3, :cond_5

    invoke-static {v4}, Landroid/support/graphics/drawable/AnimatorInflaterCompat;->isColorType(I)Z

    move-result v6

    if-nez v6, :cond_4

    goto :goto_4

    :cond_4
    :goto_3
    goto :goto_5

    :cond_5
    :goto_4
    if-eqz v1, :cond_6

    invoke-static {v2}, Landroid/support/graphics/drawable/AnimatorInflaterCompat;->isColorType(I)Z

    move-result v6

    if-eqz v6, :cond_6

    goto :goto_3

    .line 581
    :goto_5
    const/4 v6, 0x3

    goto :goto_6

    .line 580
    :cond_6
    nop

    .line 583
    const/4 v6, 0x0

    .line 585
    .local v6, "valueType":I
    :goto_6
    return v6
.end method

.method private static inferValueTypeOfKeyframe(Landroid/content/res/Resources;Landroid/content/res/Resources$Theme;Landroid/util/AttributeSet;Lorg/xmlpull/v1/XmlPullParser;)I
    .locals 4
    .param p0, "res"    # Landroid/content/res/Resources;
    .param p1, "theme"    # Landroid/content/res/Resources$Theme;
    .param p2, "attrs"    # Landroid/util/AttributeSet;
    .param p3, "parser"    # Lorg/xmlpull/v1/XmlPullParser;

    .line 552
    sget-object v0, Landroid/support/graphics/drawable/AndroidResources;->STYLEABLE_KEYFRAME:[I

    invoke-static {p0, p1, p2, v0}, Landroid/support/graphics/drawable/TypedArrayUtils;->obtainAttributes(Landroid/content/res/Resources;Landroid/content/res/Resources$Theme;Landroid/util/AttributeSet;[I)Landroid/content/res/TypedArray;

    move-result-object v0

    .line 555
    .local v0, "a":Landroid/content/res/TypedArray;
    const-string v1, "value"

    const/4 v2, 0x0

    invoke-static {v0, p3, v1, v2}, Landroid/support/graphics/drawable/TypedArrayUtils;->peekNamedValue(Landroid/content/res/TypedArray;Lorg/xmlpull/v1/XmlPullParser;Ljava/lang/String;I)Landroid/util/TypedValue;

    move-result-object v1

    .line 557
    .local v1, "keyframeValue":Landroid/util/TypedValue;
    if-eqz v1, :cond_0

    const/4 v2, 0x1

    nop

    .line 560
    .local v2, "hasValue":Z
    :cond_0
    if-eqz v2, :cond_1

    iget v3, v1, Landroid/util/TypedValue;->type:I

    invoke-static {v3}, Landroid/support/graphics/drawable/AnimatorInflaterCompat;->isColorType(I)Z

    move-result v3

    if-eqz v3, :cond_1

    .line 561
    const/4 v3, 0x3

    goto :goto_0

    .line 560
    :cond_1
    nop

    .line 563
    const/4 v3, 0x0

    .line 565
    .local v3, "valueType":I
    :goto_0
    invoke-virtual {v0}, Landroid/content/res/TypedArray;->recycle()V

    .line 566
    return v3
.end method

.method private static isColorType(I)Z
    .locals 1
    .param p0, "type"    # I

    .line 833
    const/16 v0, 0x1c

    if-lt p0, v0, :cond_0

    const/16 v0, 0x1f

    if-gt p0, v0, :cond_0

    const/4 v0, 0x1

    goto :goto_0

    :cond_0
    const/4 v0, 0x0

    :goto_0
    return v0
.end method

.method public static loadAnimator(Landroid/content/Context;I)Landroid/animation/Animator;
    .locals 2
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "id"    # I
        .annotation build Landroid/support/annotation/AnimatorRes;
        .end annotation
    .end param
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/content/res/Resources$NotFoundException;
        }
    .end annotation

    .line 93
    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v1, 0x18

    if-lt v0, v1, :cond_0

    .line 94
    invoke-static {p0, p1}, Landroid/animation/AnimatorInflater;->loadAnimator(Landroid/content/Context;I)Landroid/animation/Animator;

    move-result-object v0

    goto :goto_0

    .line 96
    :cond_0
    invoke-virtual {p0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    invoke-virtual {p0}, Landroid/content/Context;->getTheme()Landroid/content/res/Resources$Theme;

    move-result-object v1

    invoke-static {p0, v0, v1, p1}, Landroid/support/graphics/drawable/AnimatorInflaterCompat;->loadAnimator(Landroid/content/Context;Landroid/content/res/Resources;Landroid/content/res/Resources$Theme;I)Landroid/animation/Animator;

    move-result-object v0

    .line 98
    .local v0, "objectAnimator":Landroid/animation/Animator;
    :goto_0
    return-object v0
.end method

.method public static loadAnimator(Landroid/content/Context;Landroid/content/res/Resources;Landroid/content/res/Resources$Theme;I)Landroid/animation/Animator;
    .locals 1
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "resources"    # Landroid/content/res/Resources;
    .param p2, "theme"    # Landroid/content/res/Resources$Theme;
    .param p3, "id"    # I
        .annotation build Landroid/support/annotation/AnimatorRes;
        .end annotation
    .end param
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/content/res/Resources$NotFoundException;
        }
    .end annotation

    .line 113
    const/high16 v0, 0x3f800000    # 1.0f

    invoke-static {p0, p1, p2, p3, v0}, Landroid/support/graphics/drawable/AnimatorInflaterCompat;->loadAnimator(Landroid/content/Context;Landroid/content/res/Resources;Landroid/content/res/Resources$Theme;IF)Landroid/animation/Animator;

    move-result-object v0

    return-object v0
.end method

.method public static loadAnimator(Landroid/content/Context;Landroid/content/res/Resources;Landroid/content/res/Resources$Theme;IF)Landroid/animation/Animator;
    .locals 5
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "resources"    # Landroid/content/res/Resources;
    .param p2, "theme"    # Landroid/content/res/Resources$Theme;
    .param p3, "id"    # I
        .annotation build Landroid/support/annotation/AnimatorRes;
        .end annotation
    .end param
    .param p4, "pathErrorScale"    # F
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/content/res/Resources$NotFoundException;
        }
    .end annotation

    .line 123
    const/4 v0, 0x0

    .line 125
    .local v0, "parser":Landroid/content/res/XmlResourceParser;
    :try_start_0
    invoke-virtual {p1, p3}, Landroid/content/res/Resources;->getAnimation(I)Landroid/content/res/XmlResourceParser;

    move-result-object v1

    move-object v0, v1

    .line 126
    invoke-static {p0, p1, p2, v0, p4}, Landroid/support/graphics/drawable/AnimatorInflaterCompat;->createAnimatorFromXml(Landroid/content/Context;Landroid/content/res/Resources;Landroid/content/res/Resources$Theme;Lorg/xmlpull/v1/XmlPullParser;F)Landroid/animation/Animator;

    move-result-object v1
    :try_end_0
    .catch Lorg/xmlpull/v1/XmlPullParserException; {:try_start_0 .. :try_end_0} :catch_1
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 127
    .local v1, "animator":Landroid/animation/Animator;
    nop

    .line 141
    if-eqz v0, :cond_0

    invoke-interface {v0}, Landroid/content/res/XmlResourceParser;->close()V

    nop

    :cond_0
    return-object v1

    .end local v1    # "animator":Landroid/animation/Animator;
    :catchall_0
    move-exception v1

    goto :goto_0

    .line 134
    :catch_0
    move-exception v1

    .line 135
    .local v1, "ex":Ljava/io/IOException;
    :try_start_1
    new-instance v2, Landroid/content/res/Resources$NotFoundException;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "Can\'t load animation resource ID #0x"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 137
    invoke-static {p3}, Ljava/lang/Integer;->toHexString(I)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-direct {v2, v3}, Landroid/content/res/Resources$NotFoundException;-><init>(Ljava/lang/String;)V

    .line 138
    .local v2, "rnf":Landroid/content/res/Resources$NotFoundException;
    invoke-virtual {v2, v1}, Landroid/content/res/Resources$NotFoundException;->initCause(Ljava/lang/Throwable;)Ljava/lang/Throwable;

    .line 139
    nop

    .end local v0    # "parser":Landroid/content/res/XmlResourceParser;
    .end local p0    # "context":Landroid/content/Context;
    .end local p1    # "resources":Landroid/content/res/Resources;
    .end local p2    # "theme":Landroid/content/res/Resources$Theme;
    .end local p3    # "id":I
    .end local p4    # "pathErrorScale":F
    throw v2

    .line 128
    .end local v1    # "ex":Ljava/io/IOException;
    .end local v2    # "rnf":Landroid/content/res/Resources$NotFoundException;
    .restart local v0    # "parser":Landroid/content/res/XmlResourceParser;
    .restart local p0    # "context":Landroid/content/Context;
    .restart local p1    # "resources":Landroid/content/res/Resources;
    .restart local p2    # "theme":Landroid/content/res/Resources$Theme;
    .restart local p3    # "id":I
    .restart local p4    # "pathErrorScale":F
    :catch_1
    move-exception v1

    .line 129
    .local v1, "ex":Lorg/xmlpull/v1/XmlPullParserException;
    new-instance v2, Landroid/content/res/Resources$NotFoundException;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "Can\'t load animation resource ID #0x"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 131
    invoke-static {p3}, Ljava/lang/Integer;->toHexString(I)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-direct {v2, v3}, Landroid/content/res/Resources$NotFoundException;-><init>(Ljava/lang/String;)V

    .line 132
    .restart local v2    # "rnf":Landroid/content/res/Resources$NotFoundException;
    invoke-virtual {v2, v1}, Landroid/content/res/Resources$NotFoundException;->initCause(Ljava/lang/Throwable;)Ljava/lang/Throwable;

    .line 133
    nop

    .end local v0    # "parser":Landroid/content/res/XmlResourceParser;
    .end local p0    # "context":Landroid/content/Context;
    .end local p1    # "resources":Landroid/content/res/Resources;
    .end local p2    # "theme":Landroid/content/res/Resources$Theme;
    .end local p3    # "id":I
    .end local p4    # "pathErrorScale":F
    throw v2
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 141
    .end local v1    # "ex":Lorg/xmlpull/v1/XmlPullParserException;
    .end local v2    # "rnf":Landroid/content/res/Resources$NotFoundException;
    .restart local v0    # "parser":Landroid/content/res/XmlResourceParser;
    .restart local p0    # "context":Landroid/content/Context;
    .restart local p1    # "resources":Landroid/content/res/Resources;
    .restart local p2    # "theme":Landroid/content/res/Resources$Theme;
    .restart local p3    # "id":I
    .restart local p4    # "pathErrorScale":F
    :goto_0
    if-eqz v0, :cond_1

    invoke-interface {v0}, Landroid/content/res/XmlResourceParser;->close()V

    nop

    :cond_1
    throw v1
.end method

.method private static loadAnimator(Landroid/content/Context;Landroid/content/res/Resources;Landroid/content/res/Resources$Theme;Landroid/util/AttributeSet;Landroid/animation/ValueAnimator;FLorg/xmlpull/v1/XmlPullParser;)Landroid/animation/ValueAnimator;
    .locals 4
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "res"    # Landroid/content/res/Resources;
    .param p2, "theme"    # Landroid/content/res/Resources$Theme;
    .param p3, "attrs"    # Landroid/util/AttributeSet;
    .param p4, "anim"    # Landroid/animation/ValueAnimator;
    .param p5, "pathErrorScale"    # F
    .param p6, "parser"    # Lorg/xmlpull/v1/XmlPullParser;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/content/res/Resources$NotFoundException;
        }
    .end annotation

    .line 806
    sget-object v0, Landroid/support/graphics/drawable/AndroidResources;->STYLEABLE_ANIMATOR:[I

    invoke-static {p1, p2, p3, v0}, Landroid/support/graphics/drawable/TypedArrayUtils;->obtainAttributes(Landroid/content/res/Resources;Landroid/content/res/Resources$Theme;Landroid/util/AttributeSet;[I)Landroid/content/res/TypedArray;

    move-result-object v0

    .line 808
    .local v0, "arrayAnimator":Landroid/content/res/TypedArray;
    sget-object v1, Landroid/support/graphics/drawable/AndroidResources;->STYLEABLE_PROPERTY_ANIMATOR:[I

    invoke-static {p1, p2, p3, v1}, Landroid/support/graphics/drawable/TypedArrayUtils;->obtainAttributes(Landroid/content/res/Resources;Landroid/content/res/Resources$Theme;Landroid/util/AttributeSet;[I)Landroid/content/res/TypedArray;

    move-result-object v1

    .line 811
    .local v1, "arrayObjectAnimator":Landroid/content/res/TypedArray;
    if-nez p4, :cond_0

    .line 812
    new-instance v2, Landroid/animation/ValueAnimator;

    invoke-direct {v2}, Landroid/animation/ValueAnimator;-><init>()V

    move-object p4, v2

    goto :goto_0

    .line 811
    :cond_0
    nop

    .line 815
    :goto_0
    invoke-static {p4, v0, v1, p5, p6}, Landroid/support/graphics/drawable/AnimatorInflaterCompat;->parseAnimatorFromTypeArray(Landroid/animation/ValueAnimator;Landroid/content/res/TypedArray;Landroid/content/res/TypedArray;FLorg/xmlpull/v1/XmlPullParser;)V

    .line 818
    const-string v2, "interpolator"

    const/4 v3, 0x0

    invoke-static {v0, p6, v2, v3, v3}, Landroid/support/graphics/drawable/TypedArrayUtils;->getNamedResId(Landroid/content/res/TypedArray;Lorg/xmlpull/v1/XmlPullParser;Ljava/lang/String;II)I

    move-result v2

    .line 820
    .local v2, "resID":I
    if-lez v2, :cond_1

    .line 821
    invoke-static {p0, v2}, Landroid/support/graphics/drawable/AnimationUtilsCompat;->loadInterpolator(Landroid/content/Context;I)Landroid/view/animation/Interpolator;

    move-result-object v3

    .line 822
    .local v3, "interpolator":Landroid/view/animation/Interpolator;
    invoke-virtual {p4, v3}, Landroid/animation/ValueAnimator;->setInterpolator(Landroid/animation/TimeInterpolator;)V

    goto :goto_1

    .line 820
    .end local v3    # "interpolator":Landroid/view/animation/Interpolator;
    :cond_1
    nop

    .line 825
    :goto_1
    invoke-virtual {v0}, Landroid/content/res/TypedArray;->recycle()V

    .line 826
    if-eqz v1, :cond_2

    .line 827
    invoke-virtual {v1}, Landroid/content/res/TypedArray;->recycle()V

    goto :goto_2

    .line 826
    :cond_2
    nop

    .line 829
    :goto_2
    return-object p4
.end method

.method private static loadKeyframe(Landroid/content/Context;Landroid/content/res/Resources;Landroid/content/res/Resources$Theme;Landroid/util/AttributeSet;ILorg/xmlpull/v1/XmlPullParser;)Landroid/animation/Keyframe;
    .locals 9
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "res"    # Landroid/content/res/Resources;
    .param p2, "theme"    # Landroid/content/res/Resources$Theme;
    .param p3, "attrs"    # Landroid/util/AttributeSet;
    .param p4, "valueType"    # I
    .param p5, "parser"    # Lorg/xmlpull/v1/XmlPullParser;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/xmlpull/v1/XmlPullParserException;,
            Ljava/io/IOException;
        }
    .end annotation

    .line 734
    sget-object v0, Landroid/support/graphics/drawable/AndroidResources;->STYLEABLE_KEYFRAME:[I

    invoke-static {p1, p2, p3, v0}, Landroid/support/graphics/drawable/TypedArrayUtils;->obtainAttributes(Landroid/content/res/Resources;Landroid/content/res/Resources$Theme;Landroid/util/AttributeSet;[I)Landroid/content/res/TypedArray;

    move-result-object v0

    .line 737
    .local v0, "a":Landroid/content/res/TypedArray;
    const/4 v1, 0x0

    .line 739
    .local v1, "keyframe":Landroid/animation/Keyframe;
    const-string v2, "fraction"

    const/4 v3, 0x3

    const/high16 v4, -0x40800000    # -1.0f

    invoke-static {v0, p5, v2, v3, v4}, Landroid/support/graphics/drawable/TypedArrayUtils;->getNamedFloat(Landroid/content/res/TypedArray;Lorg/xmlpull/v1/XmlPullParser;Ljava/lang/String;IF)F

    move-result v2

    .line 742
    .local v2, "fraction":F
    const-string v4, "value"

    const/4 v5, 0x0

    invoke-static {v0, p5, v4, v5}, Landroid/support/graphics/drawable/TypedArrayUtils;->peekNamedValue(Landroid/content/res/TypedArray;Lorg/xmlpull/v1/XmlPullParser;Ljava/lang/String;I)Landroid/util/TypedValue;

    move-result-object v4

    .line 744
    .local v4, "keyframeValue":Landroid/util/TypedValue;
    const/4 v6, 0x1

    if-eqz v4, :cond_0

    const/4 v7, 0x1

    goto :goto_0

    :cond_0
    const/4 v7, 0x0

    .line 745
    .local v7, "hasValue":Z
    :goto_0
    const/4 v8, 0x4

    if-ne p4, v8, :cond_2

    .line 748
    if-eqz v7, :cond_1

    iget v8, v4, Landroid/util/TypedValue;->type:I

    invoke-static {v8}, Landroid/support/graphics/drawable/AnimatorInflaterCompat;->isColorType(I)Z

    move-result v8

    if-eqz v8, :cond_1

    .line 749
    const/4 p4, 0x3

    goto :goto_1

    .line 748
    :cond_1
    nop

    .line 751
    const/4 p4, 0x0

    goto :goto_1

    .line 745
    :cond_2
    nop

    .line 755
    :goto_1
    if-eqz v7, :cond_4

    .line 756
    if-eq p4, v3, :cond_3

    packed-switch p4, :pswitch_data_0

    goto :goto_2

    .line 758
    :pswitch_0
    const-string v3, "value"

    const/4 v8, 0x0

    invoke-static {v0, p5, v3, v5, v8}, Landroid/support/graphics/drawable/TypedArrayUtils;->getNamedFloat(Landroid/content/res/TypedArray;Lorg/xmlpull/v1/XmlPullParser;Ljava/lang/String;IF)F

    move-result v3

    .line 760
    .local v3, "value":F
    invoke-static {v2, v3}, Landroid/animation/Keyframe;->ofFloat(FF)Landroid/animation/Keyframe;

    move-result-object v1

    .line 761
    goto :goto_2

    .line 764
    .end local v3    # "value":F
    :cond_3
    :pswitch_1
    const-string v3, "value"

    invoke-static {v0, p5, v3, v5, v5}, Landroid/support/graphics/drawable/TypedArrayUtils;->getNamedInt(Landroid/content/res/TypedArray;Lorg/xmlpull/v1/XmlPullParser;Ljava/lang/String;II)I

    move-result v3

    .line 766
    .local v3, "intValue":I
    invoke-static {v2, v3}, Landroid/animation/Keyframe;->ofInt(FI)Landroid/animation/Keyframe;

    move-result-object v1

    .line 767
    .end local v3    # "intValue":I
    :goto_2
    goto :goto_4

    .line 770
    :cond_4
    if-nez p4, :cond_5

    invoke-static {v2}, Landroid/animation/Keyframe;->ofFloat(F)Landroid/animation/Keyframe;

    move-result-object v3

    goto :goto_3

    .line 771
    :cond_5
    invoke-static {v2}, Landroid/animation/Keyframe;->ofInt(F)Landroid/animation/Keyframe;

    move-result-object v3

    :goto_3
    move-object v1, v3

    .line 774
    :goto_4
    const-string v3, "interpolator"

    invoke-static {v0, p5, v3, v6, v5}, Landroid/support/graphics/drawable/TypedArrayUtils;->getNamedResId(Landroid/content/res/TypedArray;Lorg/xmlpull/v1/XmlPullParser;Ljava/lang/String;II)I

    move-result v3

    .line 776
    .local v3, "resID":I
    if-lez v3, :cond_6

    .line 777
    invoke-static {p0, v3}, Landroid/support/graphics/drawable/AnimationUtilsCompat;->loadInterpolator(Landroid/content/Context;I)Landroid/view/animation/Interpolator;

    move-result-object v5

    .line 778
    .local v5, "interpolator":Landroid/view/animation/Interpolator;
    invoke-virtual {v1, v5}, Landroid/animation/Keyframe;->setInterpolator(Landroid/animation/TimeInterpolator;)V

    goto :goto_5

    .line 776
    .end local v5    # "interpolator":Landroid/view/animation/Interpolator;
    :cond_6
    nop

    .line 780
    :goto_5
    invoke-virtual {v0}, Landroid/content/res/TypedArray;->recycle()V

    .line 782
    return-object v1

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_0
        :pswitch_1
    .end packed-switch
.end method

.method private static loadObjectAnimator(Landroid/content/Context;Landroid/content/res/Resources;Landroid/content/res/Resources$Theme;Landroid/util/AttributeSet;FLorg/xmlpull/v1/XmlPullParser;)Landroid/animation/ObjectAnimator;
    .locals 8
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "res"    # Landroid/content/res/Resources;
    .param p2, "theme"    # Landroid/content/res/Resources$Theme;
    .param p3, "attrs"    # Landroid/util/AttributeSet;
    .param p4, "pathErrorScale"    # F
    .param p5, "parser"    # Lorg/xmlpull/v1/XmlPullParser;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/content/res/Resources$NotFoundException;
        }
    .end annotation

    .line 788
    new-instance v0, Landroid/animation/ObjectAnimator;

    invoke-direct {v0}, Landroid/animation/ObjectAnimator;-><init>()V

    .line 790
    .local v0, "anim":Landroid/animation/ObjectAnimator;
    move-object v1, p0

    move-object v2, p1

    move-object v3, p2

    move-object v4, p3

    move-object v5, v0

    move v6, p4

    move-object v7, p5

    invoke-static/range {v1 .. v7}, Landroid/support/graphics/drawable/AnimatorInflaterCompat;->loadAnimator(Landroid/content/Context;Landroid/content/res/Resources;Landroid/content/res/Resources$Theme;Landroid/util/AttributeSet;Landroid/animation/ValueAnimator;FLorg/xmlpull/v1/XmlPullParser;)Landroid/animation/ValueAnimator;

    .line 792
    return-object v0
.end method

.method private static loadPvh(Landroid/content/Context;Landroid/content/res/Resources;Landroid/content/res/Resources$Theme;Lorg/xmlpull/v1/XmlPullParser;Ljava/lang/String;I)Landroid/animation/PropertyValuesHolder;
    .locals 20
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "res"    # Landroid/content/res/Resources;
    .param p2, "theme"    # Landroid/content/res/Resources$Theme;
    .param p3, "parser"    # Lorg/xmlpull/v1/XmlPullParser;
    .param p4, "propertyName"    # Ljava/lang/String;
    .param p5, "valueType"    # I
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/xmlpull/v1/XmlPullParserException;,
            Ljava/io/IOException;
        }
    .end annotation

    .line 608
    const/4 v0, 0x0

    .line 609
    .local v0, "value":Landroid/animation/PropertyValuesHolder;
    const/4 v1, 0x0

    move/from16 v2, p5

    .line 612
    .end local p5    # "valueType":I
    .local v1, "keyframes":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Landroid/animation/Keyframe;>;"
    .local v2, "valueType":I
    :goto_0
    invoke-interface/range {p3 .. p3}, Lorg/xmlpull/v1/XmlPullParser;->next()I

    move-result v3

    move v4, v3

    .local v4, "type":I
    const/4 v5, 0x3

    if-eq v3, v5, :cond_4

    const/4 v3, 0x1

    if-eq v4, v3, :cond_4

    .line 614
    invoke-interface/range {p3 .. p3}, Lorg/xmlpull/v1/XmlPullParser;->getName()Ljava/lang/String;

    move-result-object v3

    .line 615
    .local v3, "name":Ljava/lang/String;
    const-string v5, "keyframe"

    invoke-virtual {v3, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_3

    .line 616
    const/4 v5, 0x4

    if-ne v2, v5, :cond_0

    .line 617
    invoke-static/range {p3 .. p3}, Landroid/util/Xml;->asAttributeSet(Lorg/xmlpull/v1/XmlPullParser;)Landroid/util/AttributeSet;

    move-result-object v5

    move-object/from16 v12, p1

    move-object/from16 v13, p2

    move-object/from16 v14, p3

    invoke-static {v12, v13, v5, v14}, Landroid/support/graphics/drawable/AnimatorInflaterCompat;->inferValueTypeOfKeyframe(Landroid/content/res/Resources;Landroid/content/res/Resources$Theme;Landroid/util/AttributeSet;Lorg/xmlpull/v1/XmlPullParser;)I

    move-result v2

    goto :goto_1

    .line 616
    :cond_0
    move-object/from16 v12, p1

    move-object/from16 v13, p2

    move-object/from16 v14, p3

    .line 620
    :goto_1
    invoke-static/range {p3 .. p3}, Landroid/util/Xml;->asAttributeSet(Lorg/xmlpull/v1/XmlPullParser;)Landroid/util/AttributeSet;

    move-result-object v9

    move-object/from16 v6, p0

    move-object/from16 v7, p1

    move-object/from16 v8, p2

    move v10, v2

    move-object/from16 v11, p3

    invoke-static/range {v6 .. v11}, Landroid/support/graphics/drawable/AnimatorInflaterCompat;->loadKeyframe(Landroid/content/Context;Landroid/content/res/Resources;Landroid/content/res/Resources$Theme;Landroid/util/AttributeSet;ILorg/xmlpull/v1/XmlPullParser;)Landroid/animation/Keyframe;

    move-result-object v5

    .line 622
    .local v5, "keyframe":Landroid/animation/Keyframe;
    if-eqz v5, :cond_2

    .line 623
    if-nez v1, :cond_1

    .line 624
    new-instance v6, Ljava/util/ArrayList;

    invoke-direct {v6}, Ljava/util/ArrayList;-><init>()V

    move-object v1, v6

    goto :goto_2

    .line 623
    :cond_1
    nop

    .line 626
    :goto_2
    invoke-virtual {v1, v5}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto :goto_3

    .line 622
    :cond_2
    nop

    .line 628
    :goto_3
    invoke-interface/range {p3 .. p3}, Lorg/xmlpull/v1/XmlPullParser;->next()I

    goto :goto_4

    .line 615
    .end local v5    # "keyframe":Landroid/animation/Keyframe;
    :cond_3
    move-object/from16 v12, p1

    move-object/from16 v13, p2

    move-object/from16 v14, p3

    .line 630
    .end local v3    # "name":Ljava/lang/String;
    :goto_4
    goto :goto_0

    .line 612
    :cond_4
    move-object/from16 v12, p1

    move-object/from16 v13, p2

    move-object/from16 v14, p3

    .line 633
    if-eqz v1, :cond_10

    invoke-virtual {v1}, Ljava/util/ArrayList;->size()I

    move-result v3

    move v6, v3

    .local v6, "count":I
    if-lez v3, :cond_10

    .line 639
    const/4 v3, 0x0

    invoke-virtual {v1, v3}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v7

    check-cast v7, Landroid/animation/Keyframe;

    .line 640
    .local v7, "firstKeyframe":Landroid/animation/Keyframe;
    add-int/lit8 v8, v6, -0x1

    invoke-virtual {v1, v8}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v8

    check-cast v8, Landroid/animation/Keyframe;

    .line 641
    .local v8, "lastKeyframe":Landroid/animation/Keyframe;
    invoke-virtual {v8}, Landroid/animation/Keyframe;->getFraction()F

    move-result v9

    .line 642
    .local v9, "endFraction":F
    const/high16 v10, 0x3f800000    # 1.0f

    const/4 v11, 0x0

    cmpg-float v15, v9, v10

    if-gez v15, :cond_6

    .line 643
    cmpg-float v15, v9, v11

    if-gez v15, :cond_5

    .line 644
    invoke-virtual {v8, v10}, Landroid/animation/Keyframe;->setFraction(F)V

    goto :goto_5

    .line 646
    :cond_5
    invoke-virtual {v1}, Ljava/util/ArrayList;->size()I

    move-result v15

    invoke-static {v8, v10}, Landroid/support/graphics/drawable/AnimatorInflaterCompat;->createNewKeyframe(Landroid/animation/Keyframe;F)Landroid/animation/Keyframe;

    move-result-object v5

    invoke-virtual {v1, v15, v5}, Ljava/util/ArrayList;->add(ILjava/lang/Object;)V

    .line 647
    add-int/lit8 v6, v6, 0x1

    goto :goto_5

    .line 642
    :cond_6
    nop

    .line 650
    :goto_5
    invoke-virtual {v7}, Landroid/animation/Keyframe;->getFraction()F

    move-result v5

    .line 651
    .local v5, "startFraction":F
    cmpl-float v15, v5, v11

    if-eqz v15, :cond_8

    .line 652
    cmpg-float v15, v5, v11

    if-gez v15, :cond_7

    .line 653
    invoke-virtual {v7, v11}, Landroid/animation/Keyframe;->setFraction(F)V

    goto :goto_6

    .line 655
    :cond_7
    invoke-static {v7, v11}, Landroid/support/graphics/drawable/AnimatorInflaterCompat;->createNewKeyframe(Landroid/animation/Keyframe;F)Landroid/animation/Keyframe;

    move-result-object v15

    invoke-virtual {v1, v3, v15}, Ljava/util/ArrayList;->add(ILjava/lang/Object;)V

    .line 656
    add-int/lit8 v6, v6, 0x1

    goto :goto_6

    .line 651
    :cond_8
    nop

    .line 659
    :goto_6
    new-array v3, v6, [Landroid/animation/Keyframe;

    .line 660
    .local v3, "keyframeArray":[Landroid/animation/Keyframe;
    invoke-virtual {v1, v3}, Ljava/util/ArrayList;->toArray([Ljava/lang/Object;)[Ljava/lang/Object;

    .line 661
    const/4 v15, 0x0

    .local v15, "i":I
    :goto_7
    if-ge v15, v6, :cond_e

    .line 662
    aget-object v10, v3, v15

    .line 663
    .local v10, "keyframe":Landroid/animation/Keyframe;
    invoke-virtual {v10}, Landroid/animation/Keyframe;->getFraction()F

    move-result v17

    cmpg-float v17, v17, v11

    if-gez v17, :cond_d

    .line 664
    if-nez v15, :cond_9

    .line 665
    invoke-virtual {v10, v11}, Landroid/animation/Keyframe;->setFraction(F)V

    move-object/from16 v19, v0

    move-object/from16 v16, v1

    move/from16 v18, v4

    const/16 v17, 0x0

    goto :goto_a

    .line 666
    :cond_9
    add-int/lit8 v11, v6, -0x1

    if-ne v15, v11, :cond_a

    .line 667
    const/high16 v11, 0x3f800000    # 1.0f

    invoke-virtual {v10, v11}, Landroid/animation/Keyframe;->setFraction(F)V

    move-object/from16 v19, v0

    move-object/from16 v16, v1

    move/from16 v18, v4

    const/16 v17, 0x0

    goto :goto_a

    .line 671
    :cond_a
    const/high16 v11, 0x3f800000    # 1.0f

    move/from16 v16, v15

    .line 672
    .local v16, "startIndex":I
    move/from16 v18, v15

    .line 673
    .local v18, "endIndex":I
    move/from16 v11, v16

    .end local v16    # "startIndex":I
    .local v11, "startIndex":I
    add-int/lit8 v16, v11, 0x1

    move-object/from16 v19, v0

    move/from16 v0, v16

    move-object/from16 v16, v1

    move/from16 v1, v18

    .end local v18    # "endIndex":I
    .local v0, "j":I
    .local v1, "endIndex":I
    .local v16, "keyframes":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Landroid/animation/Keyframe;>;"
    .local v19, "value":Landroid/animation/PropertyValuesHolder;
    :goto_8
    move/from16 v18, v4

    .end local v4    # "type":I
    .local v18, "type":I
    add-int/lit8 v4, v6, -0x1

    if-ge v0, v4, :cond_c

    .line 674
    aget-object v4, v3, v0

    invoke-virtual {v4}, Landroid/animation/Keyframe;->getFraction()F

    move-result v4

    const/16 v17, 0x0

    cmpl-float v4, v4, v17

    if-ltz v4, :cond_b

    .line 675
    goto :goto_9

    .line 677
    :cond_b
    move v1, v0

    .line 673
    add-int/lit8 v0, v0, 0x1

    move/from16 v4, v18

    goto :goto_8

    :cond_c
    const/16 v17, 0x0

    .line 679
    .end local v0    # "j":I
    :goto_9
    add-int/lit8 v0, v1, 0x1

    aget-object v0, v3, v0

    invoke-virtual {v0}, Landroid/animation/Keyframe;->getFraction()F

    move-result v0

    add-int/lit8 v4, v11, -0x1

    aget-object v4, v3, v4

    .line 680
    invoke-virtual {v4}, Landroid/animation/Keyframe;->getFraction()F

    move-result v4

    sub-float/2addr v0, v4

    .line 681
    .local v0, "gap":F
    invoke-static {v3, v0, v11, v1}, Landroid/support/graphics/drawable/AnimatorInflaterCompat;->distributeKeyframes([Landroid/animation/Keyframe;FII)V

    goto :goto_a

    .line 663
    .end local v11    # "startIndex":I
    .end local v16    # "keyframes":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Landroid/animation/Keyframe;>;"
    .end local v18    # "type":I
    .end local v19    # "value":Landroid/animation/PropertyValuesHolder;
    .local v0, "value":Landroid/animation/PropertyValuesHolder;
    .local v1, "keyframes":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Landroid/animation/Keyframe;>;"
    .restart local v4    # "type":I
    :cond_d
    move-object/from16 v19, v0

    move-object/from16 v16, v1

    move/from16 v18, v4

    const/16 v17, 0x0

    .line 661
    .end local v0    # "value":Landroid/animation/PropertyValuesHolder;
    .end local v1    # "keyframes":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Landroid/animation/Keyframe;>;"
    .end local v4    # "type":I
    .end local v10    # "keyframe":Landroid/animation/Keyframe;
    .restart local v16    # "keyframes":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Landroid/animation/Keyframe;>;"
    .restart local v18    # "type":I
    .restart local v19    # "value":Landroid/animation/PropertyValuesHolder;
    :goto_a
    add-int/lit8 v15, v15, 0x1

    move-object/from16 v1, v16

    move/from16 v4, v18

    move-object/from16 v0, v19

    const/high16 v10, 0x3f800000    # 1.0f

    const/4 v11, 0x0

    goto/16 :goto_7

    .end local v16    # "keyframes":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Landroid/animation/Keyframe;>;"
    .end local v18    # "type":I
    .end local v19    # "value":Landroid/animation/PropertyValuesHolder;
    .restart local v0    # "value":Landroid/animation/PropertyValuesHolder;
    .restart local v1    # "keyframes":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Landroid/animation/Keyframe;>;"
    .restart local v4    # "type":I
    :cond_e
    move-object/from16 v19, v0

    move-object/from16 v16, v1

    move/from16 v18, v4

    .line 685
    .end local v0    # "value":Landroid/animation/PropertyValuesHolder;
    .end local v1    # "keyframes":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Landroid/animation/Keyframe;>;"
    .end local v4    # "type":I
    .end local v15    # "i":I
    .restart local v16    # "keyframes":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Landroid/animation/Keyframe;>;"
    .restart local v18    # "type":I
    .restart local v19    # "value":Landroid/animation/PropertyValuesHolder;
    move-object/from16 v0, p4

    invoke-static {v0, v3}, Landroid/animation/PropertyValuesHolder;->ofKeyframe(Ljava/lang/String;[Landroid/animation/Keyframe;)Landroid/animation/PropertyValuesHolder;

    move-result-object v1

    .line 686
    .end local v19    # "value":Landroid/animation/PropertyValuesHolder;
    .local v1, "value":Landroid/animation/PropertyValuesHolder;
    const/4 v4, 0x3

    if-ne v2, v4, :cond_f

    .line 687
    invoke-static {}, Landroid/support/graphics/drawable/ArgbEvaluator;->getInstance()Landroid/support/graphics/drawable/ArgbEvaluator;

    move-result-object v4

    invoke-virtual {v1, v4}, Landroid/animation/PropertyValuesHolder;->setEvaluator(Landroid/animation/TypeEvaluator;)V

    goto :goto_b

    .line 686
    :cond_f
    goto :goto_b

    .line 633
    .end local v3    # "keyframeArray":[Landroid/animation/Keyframe;
    .end local v5    # "startFraction":F
    .end local v6    # "count":I
    .end local v7    # "firstKeyframe":Landroid/animation/Keyframe;
    .end local v8    # "lastKeyframe":Landroid/animation/Keyframe;
    .end local v9    # "endFraction":F
    .end local v16    # "keyframes":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Landroid/animation/Keyframe;>;"
    .end local v18    # "type":I
    .restart local v0    # "value":Landroid/animation/PropertyValuesHolder;
    .local v1, "keyframes":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Landroid/animation/Keyframe;>;"
    .restart local v4    # "type":I
    :cond_10
    move-object/from16 v19, v0

    move-object/from16 v16, v1

    move/from16 v18, v4

    move-object/from16 v0, p4

    .line 691
    .end local v0    # "value":Landroid/animation/PropertyValuesHolder;
    .end local v1    # "keyframes":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Landroid/animation/Keyframe;>;"
    .end local v4    # "type":I
    .restart local v16    # "keyframes":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Landroid/animation/Keyframe;>;"
    .restart local v18    # "type":I
    .restart local v19    # "value":Landroid/animation/PropertyValuesHolder;
    move-object/from16 v1, v19

    .end local v19    # "value":Landroid/animation/PropertyValuesHolder;
    .local v1, "value":Landroid/animation/PropertyValuesHolder;
    :goto_b
    return-object v1
.end method

.method private static loadValues(Landroid/content/Context;Landroid/content/res/Resources;Landroid/content/res/Resources$Theme;Lorg/xmlpull/v1/XmlPullParser;Landroid/util/AttributeSet;)[Landroid/animation/PropertyValuesHolder;
    .locals 17
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "res"    # Landroid/content/res/Resources;
    .param p2, "theme"    # Landroid/content/res/Resources$Theme;
    .param p3, "parser"    # Lorg/xmlpull/v1/XmlPullParser;
    .param p4, "attrs"    # Landroid/util/AttributeSet;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/xmlpull/v1/XmlPullParserException;,
            Ljava/io/IOException;
        }
    .end annotation

    .line 492
    move-object/from16 v6, p3

    const/4 v0, 0x0

    move-object v7, v0

    .line 495
    .local v7, "values":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Landroid/animation/PropertyValuesHolder;>;"
    :goto_0
    invoke-interface/range {p3 .. p3}, Lorg/xmlpull/v1/XmlPullParser;->getEventType()I

    move-result v0

    move v8, v0

    .local v8, "type":I
    const/4 v1, 0x3

    if-eq v0, v1, :cond_5

    const/4 v9, 0x1

    if-eq v8, v9, :cond_5

    .line 498
    const/4 v0, 0x2

    if-eq v8, v0, :cond_0

    .line 499
    invoke-interface/range {p3 .. p3}, Lorg/xmlpull/v1/XmlPullParser;->next()I

    .line 500
    goto :goto_0

    .line 503
    :cond_0
    invoke-interface/range {p3 .. p3}, Lorg/xmlpull/v1/XmlPullParser;->getName()Ljava/lang/String;

    move-result-object v10

    .line 505
    .local v10, "name":Ljava/lang/String;
    const-string v2, "propertyValuesHolder"

    invoke-virtual {v10, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_4

    .line 506
    sget-object v2, Landroid/support/graphics/drawable/AndroidResources;->STYLEABLE_PROPERTY_VALUES_HOLDER:[I

    move-object/from16 v11, p1

    move-object/from16 v12, p2

    move-object/from16 v13, p4

    invoke-static {v11, v12, v13, v2}, Landroid/support/graphics/drawable/TypedArrayUtils;->obtainAttributes(Landroid/content/res/Resources;Landroid/content/res/Resources$Theme;Landroid/util/AttributeSet;[I)Landroid/content/res/TypedArray;

    move-result-object v14

    .line 509
    .local v14, "a":Landroid/content/res/TypedArray;
    const-string v2, "propertyName"

    invoke-static {v14, v6, v2, v1}, Landroid/support/graphics/drawable/TypedArrayUtils;->getNamedString(Landroid/content/res/TypedArray;Lorg/xmlpull/v1/XmlPullParser;Ljava/lang/String;I)Ljava/lang/String;

    move-result-object v15

    .line 511
    .local v15, "propertyName":Ljava/lang/String;
    const-string v1, "valueType"

    const/4 v2, 0x4

    invoke-static {v14, v6, v1, v0, v2}, Landroid/support/graphics/drawable/TypedArrayUtils;->getNamedInt(Landroid/content/res/TypedArray;Lorg/xmlpull/v1/XmlPullParser;Ljava/lang/String;II)I

    move-result v5

    .line 515
    .local v5, "valueType":I
    move-object/from16 v0, p0

    move-object/from16 v1, p1

    move-object/from16 v2, p2

    move-object/from16 v3, p3

    move-object v4, v15

    move/from16 v16, v5

    .end local v5    # "valueType":I
    .local v16, "valueType":I
    invoke-static/range {v0 .. v5}, Landroid/support/graphics/drawable/AnimatorInflaterCompat;->loadPvh(Landroid/content/Context;Landroid/content/res/Resources;Landroid/content/res/Resources$Theme;Lorg/xmlpull/v1/XmlPullParser;Ljava/lang/String;I)Landroid/animation/PropertyValuesHolder;

    move-result-object v0

    .line 517
    .local v0, "pvh":Landroid/animation/PropertyValuesHolder;
    if-nez v0, :cond_1

    .line 518
    const/4 v1, 0x0

    move/from16 v2, v16

    .end local v16    # "valueType":I
    .local v2, "valueType":I
    invoke-static {v14, v2, v1, v9, v15}, Landroid/support/graphics/drawable/AnimatorInflaterCompat;->getPVH(Landroid/content/res/TypedArray;IIILjava/lang/String;)Landroid/animation/PropertyValuesHolder;

    move-result-object v0

    goto :goto_1

    .line 517
    .end local v2    # "valueType":I
    .restart local v16    # "valueType":I
    :cond_1
    move/from16 v2, v16

    .line 523
    .end local v16    # "valueType":I
    .restart local v2    # "valueType":I
    :goto_1
    if-eqz v0, :cond_3

    .line 524
    if-nez v7, :cond_2

    .line 525
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    move-object v7, v1

    goto :goto_2

    .line 524
    :cond_2
    nop

    .line 527
    :goto_2
    invoke-virtual {v7, v0}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto :goto_3

    .line 523
    :cond_3
    nop

    .line 529
    :goto_3
    invoke-virtual {v14}, Landroid/content/res/TypedArray;->recycle()V

    goto :goto_4

    .line 505
    .end local v0    # "pvh":Landroid/animation/PropertyValuesHolder;
    .end local v2    # "valueType":I
    .end local v14    # "a":Landroid/content/res/TypedArray;
    .end local v15    # "propertyName":Ljava/lang/String;
    :cond_4
    move-object/from16 v11, p1

    move-object/from16 v12, p2

    move-object/from16 v13, p4

    .line 532
    :goto_4
    invoke-interface/range {p3 .. p3}, Lorg/xmlpull/v1/XmlPullParser;->next()I

    .line 533
    .end local v10    # "name":Ljava/lang/String;
    goto :goto_0

    .line 495
    :cond_5
    move-object/from16 v11, p1

    move-object/from16 v12, p2

    move-object/from16 v13, p4

    .line 535
    const/4 v0, 0x0

    .line 536
    .local v0, "valuesArray":[Landroid/animation/PropertyValuesHolder;
    if-eqz v7, :cond_7

    .line 537
    invoke-virtual {v7}, Ljava/util/ArrayList;->size()I

    move-result v1

    .line 538
    .local v1, "count":I
    new-array v0, v1, [Landroid/animation/PropertyValuesHolder;

    .line 539
    const/4 v2, 0x0

    .local v2, "i":I
    :goto_5
    if-ge v2, v1, :cond_6

    .line 540
    invoke-virtual {v7, v2}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Landroid/animation/PropertyValuesHolder;

    aput-object v3, v0, v2

    .line 539
    add-int/lit8 v2, v2, 0x1

    goto :goto_5

    :cond_6
    goto :goto_6

    .line 536
    .end local v1    # "count":I
    .end local v2    # "i":I
    :cond_7
    nop

    .line 543
    :goto_6
    return-object v0
.end method

.method private static parseAnimatorFromTypeArray(Landroid/animation/ValueAnimator;Landroid/content/res/TypedArray;Landroid/content/res/TypedArray;FLorg/xmlpull/v1/XmlPullParser;)V
    .locals 11
    .param p0, "anim"    # Landroid/animation/ValueAnimator;
    .param p1, "arrayAnimator"    # Landroid/content/res/TypedArray;
    .param p2, "arrayObjectAnimator"    # Landroid/content/res/TypedArray;
    .param p3, "pixelSize"    # F
    .param p4, "parser"    # Lorg/xmlpull/v1/XmlPullParser;

    .line 339
    const-string v0, "duration"

    const/4 v1, 0x1

    const/16 v2, 0x12c

    invoke-static {p1, p4, v0, v1, v2}, Landroid/support/graphics/drawable/TypedArrayUtils;->getNamedInt(Landroid/content/res/TypedArray;Lorg/xmlpull/v1/XmlPullParser;Ljava/lang/String;II)I

    move-result v0

    int-to-long v2, v0

    .line 341
    .local v2, "duration":J
    const-string v0, "startOffset"

    const/4 v4, 0x0

    const/4 v5, 0x2

    invoke-static {p1, p4, v0, v5, v4}, Landroid/support/graphics/drawable/TypedArrayUtils;->getNamedInt(Landroid/content/res/TypedArray;Lorg/xmlpull/v1/XmlPullParser;Ljava/lang/String;II)I

    move-result v0

    int-to-long v5, v0

    .line 343
    .local v5, "startDelay":J
    const-string v0, "valueType"

    const/4 v7, 0x4

    const/4 v8, 0x7

    invoke-static {p1, p4, v0, v8, v7}, Landroid/support/graphics/drawable/TypedArrayUtils;->getNamedInt(Landroid/content/res/TypedArray;Lorg/xmlpull/v1/XmlPullParser;Ljava/lang/String;II)I

    move-result v0

    .line 347
    .local v0, "valueType":I
    const-string v8, "valueFrom"

    invoke-static {p4, v8}, Landroid/support/graphics/drawable/TypedArrayUtils;->hasAttribute(Lorg/xmlpull/v1/XmlPullParser;Ljava/lang/String;)Z

    move-result v8

    if-eqz v8, :cond_4

    const-string v8, "valueTo"

    .line 348
    invoke-static {p4, v8}, Landroid/support/graphics/drawable/TypedArrayUtils;->hasAttribute(Lorg/xmlpull/v1/XmlPullParser;Ljava/lang/String;)Z

    move-result v8

    if-eqz v8, :cond_3

    .line 349
    const/4 v8, 0x6

    const/4 v9, 0x5

    if-ne v0, v7, :cond_0

    .line 350
    invoke-static {p1, v9, v8}, Landroid/support/graphics/drawable/AnimatorInflaterCompat;->inferValueTypeFromValues(Landroid/content/res/TypedArray;II)I

    move-result v0

    goto :goto_0

    .line 349
    :cond_0
    nop

    .line 354
    :goto_0
    const-string v10, ""

    invoke-static {p1, v0, v9, v8, v10}, Landroid/support/graphics/drawable/AnimatorInflaterCompat;->getPVH(Landroid/content/res/TypedArray;IIILjava/lang/String;)Landroid/animation/PropertyValuesHolder;

    move-result-object v8

    .line 357
    .local v8, "pvh":Landroid/animation/PropertyValuesHolder;
    if-eqz v8, :cond_1

    .line 358
    new-array v9, v1, [Landroid/animation/PropertyValuesHolder;

    aput-object v8, v9, v4

    invoke-virtual {p0, v9}, Landroid/animation/ValueAnimator;->setValues([Landroid/animation/PropertyValuesHolder;)V

    goto :goto_1

    .line 357
    :cond_1
    nop

    .line 360
    .end local v8    # "pvh":Landroid/animation/PropertyValuesHolder;
    :goto_1
    nop

    .line 363
    invoke-virtual {p0, v2, v3}, Landroid/animation/ValueAnimator;->setDuration(J)Landroid/animation/ValueAnimator;

    .line 364
    invoke-virtual {p0, v5, v6}, Landroid/animation/ValueAnimator;->setStartDelay(J)V

    .line 366
    const-string v8, "repeatCount"

    const/4 v9, 0x3

    invoke-static {p1, p4, v8, v9, v4}, Landroid/support/graphics/drawable/TypedArrayUtils;->getNamedInt(Landroid/content/res/TypedArray;Lorg/xmlpull/v1/XmlPullParser;Ljava/lang/String;II)I

    move-result v4

    invoke-virtual {p0, v4}, Landroid/animation/ValueAnimator;->setRepeatCount(I)V

    .line 368
    const-string v4, "repeatMode"

    invoke-static {p1, p4, v4, v7, v1}, Landroid/support/graphics/drawable/TypedArrayUtils;->getNamedInt(Landroid/content/res/TypedArray;Lorg/xmlpull/v1/XmlPullParser;Ljava/lang/String;II)I

    move-result v1

    invoke-virtual {p0, v1}, Landroid/animation/ValueAnimator;->setRepeatMode(I)V

    .line 371
    if-eqz p2, :cond_2

    .line 372
    invoke-static {p0, p2, v0, p3, p4}, Landroid/support/graphics/drawable/AnimatorInflaterCompat;->setupObjectAnimator(Landroid/animation/ValueAnimator;Landroid/content/res/TypedArray;IFLorg/xmlpull/v1/XmlPullParser;)V

    goto :goto_2

    .line 371
    :cond_2
    nop

    .line 374
    :goto_2
    return-void

    .line 348
    :cond_3
    goto :goto_3

    .line 347
    :cond_4
    nop

    .line 361
    :goto_3
    new-instance v1, Ljava/lang/IllegalArgumentException;

    const-string v4, "no valueFrom or no valueTo"

    invoke-direct {v1, v4}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v1
.end method

.method private static setupObjectAnimator(Landroid/animation/ValueAnimator;Landroid/content/res/TypedArray;IFLorg/xmlpull/v1/XmlPullParser;)V
    .locals 4
    .param p0, "anim"    # Landroid/animation/ValueAnimator;
    .param p1, "arrayObjectAnimator"    # Landroid/content/res/TypedArray;
    .param p2, "valueType"    # I
    .param p3, "pixelSize"    # F
    .param p4, "parser"    # Lorg/xmlpull/v1/XmlPullParser;

    .line 387
    move-object v0, p0

    check-cast v0, Landroid/animation/ObjectAnimator;

    .line 388
    .local v0, "oa":Landroid/animation/ObjectAnimator;
    const-string v1, "pathData"

    const/4 v2, 0x1

    invoke-static {p1, p4, v1, v2}, Landroid/support/graphics/drawable/TypedArrayUtils;->getNamedString(Landroid/content/res/TypedArray;Lorg/xmlpull/v1/XmlPullParser;Ljava/lang/String;I)Ljava/lang/String;

    move-result-object v1

    .line 399
    .local v1, "pathData":Ljava/lang/String;
    if-eqz v1, :cond_0

    .line 400
    const-string v2, "AnimatorInflater"

    const-string v3, "We don\'t support moving along path yet"

    invoke-static {v2, v3}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_0

    .line 402
    :cond_0
    const-string v2, "propertyName"

    const/4 v3, 0x0

    .line 403
    invoke-static {p1, p4, v2, v3}, Landroid/support/graphics/drawable/TypedArrayUtils;->getNamedString(Landroid/content/res/TypedArray;Lorg/xmlpull/v1/XmlPullParser;Ljava/lang/String;I)Ljava/lang/String;

    move-result-object v2

    .line 405
    .local v2, "propertyName":Ljava/lang/String;
    invoke-virtual {v0, v2}, Landroid/animation/ObjectAnimator;->setPropertyName(Ljava/lang/String;)V

    .line 409
    .end local v2    # "propertyName":Ljava/lang/String;
    :goto_0
    return-void
.end method
