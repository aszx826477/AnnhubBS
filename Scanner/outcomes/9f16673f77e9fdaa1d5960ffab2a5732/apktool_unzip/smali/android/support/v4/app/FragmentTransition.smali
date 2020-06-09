.class Landroid/support/v4/app/FragmentTransition;
.super Ljava/lang/Object;
.source "FragmentTransition.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroid/support/v4/app/FragmentTransition$FragmentContainerTransition;
    }
.end annotation


# static fields
.field private static final INVERSE_OPS:[I


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .line 42
    const/16 v0, 0x8

    new-array v0, v0, [I

    fill-array-data v0, :array_0

    sput-object v0, Landroid/support/v4/app/FragmentTransition;->INVERSE_OPS:[I

    return-void

    :array_0
    .array-data 4
        0x0
        0x3
        0x0
        0x1
        0x5
        0x4
        0x7
        0x6
    .end array-data
.end method

.method constructor <init>()V
    .locals 0

    .line 37
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 1121
    return-void
.end method

.method static synthetic access$000(Ljava/util/ArrayList;I)V
    .locals 0
    .param p0, "x0"    # Ljava/util/ArrayList;
    .param p1, "x1"    # I

    .line 37
    invoke-static {p0, p1}, Landroid/support/v4/app/FragmentTransition;->setViewVisibility(Ljava/util/ArrayList;I)V

    return-void
.end method

.method static synthetic access$100(Ljava/lang/Object;Landroid/support/v4/app/Fragment;Ljava/util/ArrayList;Landroid/view/View;)Ljava/util/ArrayList;
    .locals 1
    .param p0, "x0"    # Ljava/lang/Object;
    .param p1, "x1"    # Landroid/support/v4/app/Fragment;
    .param p2, "x2"    # Ljava/util/ArrayList;
    .param p3, "x3"    # Landroid/view/View;

    .line 37
    invoke-static {p0, p1, p2, p3}, Landroid/support/v4/app/FragmentTransition;->configureEnteringExitingViews(Ljava/lang/Object;Landroid/support/v4/app/Fragment;Ljava/util/ArrayList;Landroid/view/View;)Ljava/util/ArrayList;

    move-result-object v0

    return-object v0
.end method

.method static synthetic access$200(Landroid/support/v4/app/Fragment;Landroid/support/v4/app/Fragment;ZLandroid/support/v4/util/ArrayMap;Z)V
    .locals 0
    .param p0, "x0"    # Landroid/support/v4/app/Fragment;
    .param p1, "x1"    # Landroid/support/v4/app/Fragment;
    .param p2, "x2"    # Z
    .param p3, "x3"    # Landroid/support/v4/util/ArrayMap;
    .param p4, "x4"    # Z

    .line 37
    invoke-static {p0, p1, p2, p3, p4}, Landroid/support/v4/app/FragmentTransition;->callSharedElementStartEnd(Landroid/support/v4/app/Fragment;Landroid/support/v4/app/Fragment;ZLandroid/support/v4/util/ArrayMap;Z)V

    return-void
.end method

.method static synthetic access$300(Landroid/support/v4/util/ArrayMap;Ljava/lang/Object;Landroid/support/v4/app/FragmentTransition$FragmentContainerTransition;)Landroid/support/v4/util/ArrayMap;
    .locals 1
    .param p0, "x0"    # Landroid/support/v4/util/ArrayMap;
    .param p1, "x1"    # Ljava/lang/Object;
    .param p2, "x2"    # Landroid/support/v4/app/FragmentTransition$FragmentContainerTransition;

    .line 37
    invoke-static {p0, p1, p2}, Landroid/support/v4/app/FragmentTransition;->captureInSharedElements(Landroid/support/v4/util/ArrayMap;Ljava/lang/Object;Landroid/support/v4/app/FragmentTransition$FragmentContainerTransition;)Landroid/support/v4/util/ArrayMap;

    move-result-object v0

    return-object v0
.end method

.method static synthetic access$400(Landroid/support/v4/util/ArrayMap;Landroid/support/v4/app/FragmentTransition$FragmentContainerTransition;Ljava/lang/Object;Z)Landroid/view/View;
    .locals 1
    .param p0, "x0"    # Landroid/support/v4/util/ArrayMap;
    .param p1, "x1"    # Landroid/support/v4/app/FragmentTransition$FragmentContainerTransition;
    .param p2, "x2"    # Ljava/lang/Object;
    .param p3, "x3"    # Z

    .line 37
    invoke-static {p0, p1, p2, p3}, Landroid/support/v4/app/FragmentTransition;->getInEpicenterView(Landroid/support/v4/util/ArrayMap;Landroid/support/v4/app/FragmentTransition$FragmentContainerTransition;Ljava/lang/Object;Z)Landroid/view/View;

    move-result-object v0

    return-object v0
.end method

.method private static addSharedElementsWithMatchingNames(Ljava/util/ArrayList;Landroid/support/v4/util/ArrayMap;Ljava/util/Collection;)V
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/ArrayList<",
            "Landroid/view/View;",
            ">;",
            "Landroid/support/v4/util/ArrayMap<",
            "Ljava/lang/String;",
            "Landroid/view/View;",
            ">;",
            "Ljava/util/Collection<",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .line 552
    .local p0, "views":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Landroid/view/View;>;"
    .local p1, "sharedElements":Landroid/support/v4/util/ArrayMap;, "Landroid/support/v4/util/ArrayMap<Ljava/lang/String;Landroid/view/View;>;"
    .local p2, "nameOverridesSet":Ljava/util/Collection;, "Ljava/util/Collection<Ljava/lang/String;>;"
    invoke-virtual {p1}, Landroid/support/v4/util/ArrayMap;->size()I

    move-result v0

    add-int/lit8 v0, v0, -0x1

    .local v0, "i":I
    :goto_0
    if-ltz v0, :cond_1

    .line 553
    invoke-virtual {p1, v0}, Landroid/support/v4/util/ArrayMap;->valueAt(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/view/View;

    .line 554
    .local v1, "view":Landroid/view/View;
    invoke-static {v1}, Landroid/support/v4/view/ViewCompat;->getTransitionName(Landroid/view/View;)Ljava/lang/String;

    move-result-object v2

    invoke-interface {p2, v2}, Ljava/util/Collection;->contains(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 555
    invoke-virtual {p0, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto :goto_1

    .line 554
    :cond_0
    nop

    .line 552
    .end local v1    # "view":Landroid/view/View;
    :goto_1
    add-int/lit8 v0, v0, -0x1

    goto :goto_0

    .line 558
    .end local v0    # "i":I
    :cond_1
    return-void
.end method

.method private static addToFirstInLastOut(Landroid/support/v4/app/BackStackRecord;Landroid/support/v4/app/BackStackRecord$Op;Landroid/util/SparseArray;ZZ)V
    .locals 22
    .param p0, "transaction"    # Landroid/support/v4/app/BackStackRecord;
    .param p1, "op"    # Landroid/support/v4/app/BackStackRecord$Op;
    .param p3, "isPop"    # Z
    .param p4, "isOptimizedTransaction"    # Z
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/support/v4/app/BackStackRecord;",
            "Landroid/support/v4/app/BackStackRecord$Op;",
            "Landroid/util/SparseArray<",
            "Landroid/support/v4/app/FragmentTransition$FragmentContainerTransition;",
            ">;ZZ)V"
        }
    .end annotation

    .line 1016
    .local p2, "transitioningFragments":Landroid/util/SparseArray;, "Landroid/util/SparseArray<Landroid/support/v4/app/FragmentTransition$FragmentContainerTransition;>;"
    move-object/from16 v0, p0

    move-object/from16 v1, p1

    move-object/from16 v2, p2

    move/from16 v3, p3

    iget-object v10, v1, Landroid/support/v4/app/BackStackRecord$Op;->fragment:Landroid/support/v4/app/Fragment;

    .line 1017
    .local v10, "fragment":Landroid/support/v4/app/Fragment;
    iget v11, v10, Landroid/support/v4/app/Fragment;->mContainerId:I

    .line 1018
    .local v11, "containerId":I
    if-nez v11, :cond_0

    .line 1019
    return-void

    .line 1021
    :cond_0
    if-eqz v3, :cond_1

    sget-object v4, Landroid/support/v4/app/FragmentTransition;->INVERSE_OPS:[I

    iget v5, v1, Landroid/support/v4/app/BackStackRecord$Op;->cmd:I

    aget v4, v4, v5

    goto :goto_0

    :cond_1
    iget v4, v1, Landroid/support/v4/app/BackStackRecord$Op;->cmd:I

    :goto_0
    move v12, v4

    .line 1022
    .local v12, "command":I
    const/4 v4, 0x0

    .line 1023
    .local v4, "setLastIn":Z
    const/4 v5, 0x0

    .line 1024
    .local v5, "wasRemoved":Z
    const/4 v6, 0x0

    .line 1025
    .local v6, "setFirstOut":Z
    const/4 v7, 0x0

    .line 1026
    .local v7, "wasAdded":Z
    const/4 v8, 0x0

    const/4 v9, 0x1

    if-eq v12, v9, :cond_b

    packed-switch v12, :pswitch_data_0

    move v13, v4

    move v15, v5

    move/from16 v16, v6

    move v14, v7

    goto/16 :goto_9

    .line 1028
    :pswitch_0
    if-eqz p4, :cond_3

    .line 1029
    iget-boolean v13, v10, Landroid/support/v4/app/Fragment;->mHiddenChanged:Z

    if-eqz v13, :cond_2

    iget-boolean v13, v10, Landroid/support/v4/app/Fragment;->mHidden:Z

    if-nez v13, :cond_2

    iget-boolean v13, v10, Landroid/support/v4/app/Fragment;->mAdded:Z

    if-eqz v13, :cond_2

    const/4 v8, 0x1

    nop

    :cond_2
    move v4, v8

    goto :goto_1

    .line 1031
    :cond_3
    iget-boolean v4, v10, Landroid/support/v4/app/Fragment;->mHidden:Z

    .line 1033
    :goto_1
    const/4 v7, 0x1

    .line 1034
    move v13, v4

    move v15, v5

    move/from16 v16, v6

    move v14, v7

    goto/16 :goto_9

    .line 1045
    :pswitch_1
    if-eqz p4, :cond_5

    .line 1046
    iget-boolean v13, v10, Landroid/support/v4/app/Fragment;->mHiddenChanged:Z

    if-eqz v13, :cond_4

    iget-boolean v13, v10, Landroid/support/v4/app/Fragment;->mAdded:Z

    if-eqz v13, :cond_4

    iget-boolean v13, v10, Landroid/support/v4/app/Fragment;->mHidden:Z

    if-eqz v13, :cond_4

    const/4 v8, 0x1

    nop

    :cond_4
    move v6, v8

    goto :goto_2

    .line 1048
    :cond_5
    iget-boolean v13, v10, Landroid/support/v4/app/Fragment;->mAdded:Z

    if-eqz v13, :cond_6

    iget-boolean v13, v10, Landroid/support/v4/app/Fragment;->mHidden:Z

    if-nez v13, :cond_6

    const/4 v8, 0x1

    nop

    :cond_6
    move v6, v8

    .line 1050
    :goto_2
    const/4 v5, 0x1

    .line 1051
    move v13, v4

    move v15, v5

    move/from16 v16, v6

    move v14, v7

    goto/16 :goto_9

    .line 1054
    :pswitch_2
    if-eqz p4, :cond_9

    .line 1055
    iget-boolean v13, v10, Landroid/support/v4/app/Fragment;->mAdded:Z

    if-nez v13, :cond_8

    iget-object v13, v10, Landroid/support/v4/app/Fragment;->mView:Landroid/view/View;

    if-eqz v13, :cond_8

    iget-object v13, v10, Landroid/support/v4/app/Fragment;->mView:Landroid/view/View;

    .line 1056
    invoke-virtual {v13}, Landroid/view/View;->getVisibility()I

    move-result v13

    if-nez v13, :cond_7

    iget v13, v10, Landroid/support/v4/app/Fragment;->mPostponedAlpha:F

    const/4 v14, 0x0

    cmpl-float v13, v13, v14

    if-ltz v13, :cond_7

    const/4 v8, 0x1

    goto :goto_4

    :cond_7
    goto :goto_3

    .line 1055
    :cond_8
    nop

    .line 1056
    :goto_3
    nop

    :goto_4
    move v6, v8

    goto :goto_6

    .line 1059
    :cond_9
    nop

    iget-boolean v13, v10, Landroid/support/v4/app/Fragment;->mAdded:Z

    if-eqz v13, :cond_a

    nop

    iget-boolean v13, v10, Landroid/support/v4/app/Fragment;->mHidden:Z

    if-nez v13, :cond_a

    nop

    const/4 v8, 0x1

    goto :goto_5

    :cond_a
    nop

    nop

    :goto_5
    nop

    move v6, v8

    .line 1061
    :goto_6
    nop

    const/4 v5, 0x1

    move v13, v4

    move v15, v5

    move/from16 v16, v6

    move v14, v7

    goto :goto_9

    .line 1037
    :cond_b
    :pswitch_3
    nop

    if-eqz p4, :cond_c

    .line 1038
    nop

    iget-boolean v4, v10, Landroid/support/v4/app/Fragment;->mIsNewlyAdded:Z

    goto :goto_8

    .line 1040
    :cond_c
    nop

    iget-boolean v13, v10, Landroid/support/v4/app/Fragment;->mAdded:Z

    if-nez v13, :cond_d

    nop

    iget-boolean v13, v10, Landroid/support/v4/app/Fragment;->mHidden:Z

    if-nez v13, :cond_d

    nop

    const/4 v8, 0x1

    goto :goto_7

    :cond_d
    nop

    nop

    :goto_7
    nop

    move v4, v8

    .line 1042
    :goto_8
    nop

    const/4 v7, 0x1

    .line 1043
    nop

    move v13, v4

    move v15, v5

    move/from16 v16, v6

    move v14, v7

    .line 1064
    .end local v4    # "setLastIn":Z
    .end local v5    # "wasRemoved":Z
    .end local v6    # "setFirstOut":Z
    .end local v7    # "wasAdded":Z
    .local v13, "setLastIn":Z
    .local v14, "wasAdded":Z
    .local v15, "wasRemoved":Z
    .local v16, "setFirstOut":Z
    :goto_9
    nop

    invoke-virtual {v2, v11}, Landroid/util/SparseArray;->get(I)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Landroid/support/v4/app/FragmentTransition$FragmentContainerTransition;

    .line 1065
    .local v4, "containerTransition":Landroid/support/v4/app/FragmentTransition$FragmentContainerTransition;
    nop

    if-eqz v13, :cond_e

    .line 1066
    nop

    .line 1067
    nop

    invoke-static {v4, v2, v11}, Landroid/support/v4/app/FragmentTransition;->ensureContainer(Landroid/support/v4/app/FragmentTransition$FragmentContainerTransition;Landroid/util/SparseArray;I)Landroid/support/v4/app/FragmentTransition$FragmentContainerTransition;

    move-result-object v4

    .line 1068
    nop

    iput-object v10, v4, Landroid/support/v4/app/FragmentTransition$FragmentContainerTransition;->lastIn:Landroid/support/v4/app/Fragment;

    .line 1069
    nop

    iput-boolean v3, v4, Landroid/support/v4/app/FragmentTransition$FragmentContainerTransition;->lastInIsPop:Z

    .line 1070
    nop

    iput-object v0, v4, Landroid/support/v4/app/FragmentTransition$FragmentContainerTransition;->lastInTransaction:Landroid/support/v4/app/BackStackRecord;

    move-object v8, v4

    goto :goto_a

    .line 1065
    :cond_e
    nop

    move-object v8, v4

    .line 1072
    .end local v4    # "containerTransition":Landroid/support/v4/app/FragmentTransition$FragmentContainerTransition;
    .local v8, "containerTransition":Landroid/support/v4/app/FragmentTransition$FragmentContainerTransition;
    :goto_a
    nop

    const/4 v7, 0x0

    if-nez p4, :cond_11

    nop

    if-eqz v14, :cond_11

    .line 1073
    nop

    if-eqz v8, :cond_f

    nop

    iget-object v4, v8, Landroid/support/v4/app/FragmentTransition$FragmentContainerTransition;->firstOut:Landroid/support/v4/app/Fragment;

    if-ne v4, v10, :cond_f

    .line 1074
    nop

    iput-object v7, v8, Landroid/support/v4/app/FragmentTransition$FragmentContainerTransition;->firstOut:Landroid/support/v4/app/Fragment;

    goto :goto_b

    .line 1073
    :cond_f
    nop

    .line 1081
    :goto_b
    nop

    iget-object v6, v0, Landroid/support/v4/app/BackStackRecord;->mManager:Landroid/support/v4/app/FragmentManagerImpl;

    .line 1082
    .local v6, "manager":Landroid/support/v4/app/FragmentManagerImpl;
    nop

    iget v4, v10, Landroid/support/v4/app/Fragment;->mState:I

    if-ge v4, v9, :cond_10

    nop

    iget v4, v6, Landroid/support/v4/app/FragmentManagerImpl;->mCurState:I

    if-lt v4, v9, :cond_10

    nop

    iget-boolean v4, v0, Landroid/support/v4/app/BackStackRecord;->mAllowOptimization:Z

    if-nez v4, :cond_10

    .line 1084
    nop

    invoke-virtual {v6, v10}, Landroid/support/v4/app/FragmentManagerImpl;->makeActive(Landroid/support/v4/app/Fragment;)V

    .line 1085
    nop

    const/4 v9, 0x1

    const/16 v17, 0x0

    const/16 v18, 0x0

    const/16 v19, 0x0

    move-object v4, v6

    move-object v5, v10

    move-object/from16 v20, v6

    .end local v6    # "manager":Landroid/support/v4/app/FragmentManagerImpl;
    .local v20, "manager":Landroid/support/v4/app/FragmentManagerImpl;
    move v6, v9

    move-object v9, v7

    move/from16 v7, v17

    move-object/from16 v21, v8

    .end local v8    # "containerTransition":Landroid/support/v4/app/FragmentTransition$FragmentContainerTransition;
    .local v21, "containerTransition":Landroid/support/v4/app/FragmentTransition$FragmentContainerTransition;
    move/from16 v8, v18

    move-object v1, v9

    move/from16 v9, v19

    invoke-virtual/range {v4 .. v9}, Landroid/support/v4/app/FragmentManagerImpl;->moveToState(Landroid/support/v4/app/Fragment;IIIZ)V

    goto :goto_c

    .line 1082
    .end local v20    # "manager":Landroid/support/v4/app/FragmentManagerImpl;
    .end local v21    # "containerTransition":Landroid/support/v4/app/FragmentTransition$FragmentContainerTransition;
    .restart local v6    # "manager":Landroid/support/v4/app/FragmentManagerImpl;
    .restart local v8    # "containerTransition":Landroid/support/v4/app/FragmentTransition$FragmentContainerTransition;
    :cond_10
    move-object/from16 v20, v6

    move-object v1, v7

    move-object/from16 v21, v8

    .end local v6    # "manager":Landroid/support/v4/app/FragmentManagerImpl;
    .end local v8    # "containerTransition":Landroid/support/v4/app/FragmentTransition$FragmentContainerTransition;
    .restart local v20    # "manager":Landroid/support/v4/app/FragmentManagerImpl;
    .restart local v21    # "containerTransition":Landroid/support/v4/app/FragmentTransition$FragmentContainerTransition;
    nop

    goto :goto_c

    .line 1072
    .end local v20    # "manager":Landroid/support/v4/app/FragmentManagerImpl;
    .end local v21    # "containerTransition":Landroid/support/v4/app/FragmentTransition$FragmentContainerTransition;
    .restart local v8    # "containerTransition":Landroid/support/v4/app/FragmentTransition$FragmentContainerTransition;
    :cond_11
    move-object v1, v7

    move-object/from16 v21, v8

    .end local v8    # "containerTransition":Landroid/support/v4/app/FragmentTransition$FragmentContainerTransition;
    .restart local v21    # "containerTransition":Landroid/support/v4/app/FragmentTransition$FragmentContainerTransition;
    nop

    .line 1088
    :goto_c
    nop

    if-eqz v16, :cond_13

    nop

    move-object/from16 v4, v21

    .end local v21    # "containerTransition":Landroid/support/v4/app/FragmentTransition$FragmentContainerTransition;
    .restart local v4    # "containerTransition":Landroid/support/v4/app/FragmentTransition$FragmentContainerTransition;
    if-eqz v4, :cond_12

    nop

    iget-object v5, v4, Landroid/support/v4/app/FragmentTransition$FragmentContainerTransition;->firstOut:Landroid/support/v4/app/Fragment;

    if-nez v5, :cond_14

    :cond_12
    nop

    .line 1089
    nop

    .line 1090
    nop

    invoke-static {v4, v2, v11}, Landroid/support/v4/app/FragmentTransition;->ensureContainer(Landroid/support/v4/app/FragmentTransition$FragmentContainerTransition;Landroid/util/SparseArray;I)Landroid/support/v4/app/FragmentTransition$FragmentContainerTransition;

    move-result-object v8

    .line 1091
    .end local v4    # "containerTransition":Landroid/support/v4/app/FragmentTransition$FragmentContainerTransition;
    .restart local v8    # "containerTransition":Landroid/support/v4/app/FragmentTransition$FragmentContainerTransition;
    nop

    iput-object v10, v8, Landroid/support/v4/app/FragmentTransition$FragmentContainerTransition;->firstOut:Landroid/support/v4/app/Fragment;

    .line 1092
    nop

    iput-boolean v3, v8, Landroid/support/v4/app/FragmentTransition$FragmentContainerTransition;->firstOutIsPop:Z

    .line 1093
    nop

    iput-object v0, v8, Landroid/support/v4/app/FragmentTransition$FragmentContainerTransition;->firstOutTransaction:Landroid/support/v4/app/BackStackRecord;

    move-object v4, v8

    goto :goto_d

    .line 1088
    .end local v8    # "containerTransition":Landroid/support/v4/app/FragmentTransition$FragmentContainerTransition;
    .restart local v21    # "containerTransition":Landroid/support/v4/app/FragmentTransition$FragmentContainerTransition;
    :cond_13
    move-object/from16 v4, v21

    .end local v21    # "containerTransition":Landroid/support/v4/app/FragmentTransition$FragmentContainerTransition;
    .restart local v4    # "containerTransition":Landroid/support/v4/app/FragmentTransition$FragmentContainerTransition;
    :cond_14
    nop

    .line 1096
    :goto_d
    nop

    if-nez p4, :cond_15

    nop

    if-eqz v15, :cond_15

    nop

    if-eqz v4, :cond_15

    nop

    iget-object v5, v4, Landroid/support/v4/app/FragmentTransition$FragmentContainerTransition;->lastIn:Landroid/support/v4/app/Fragment;

    if-ne v5, v10, :cond_15

    .line 1098
    nop

    iput-object v1, v4, Landroid/support/v4/app/FragmentTransition$FragmentContainerTransition;->lastIn:Landroid/support/v4/app/Fragment;

    goto :goto_e

    .line 1096
    :cond_15
    nop

    .line 1100
    :goto_e
    nop

    return-void

    nop

    :pswitch_data_0
    .packed-switch 0x3
        :pswitch_2
        :pswitch_1
        :pswitch_0
        :pswitch_2
        :pswitch_3
    .end packed-switch
.end method

.method public static calculateFragments(Landroid/support/v4/app/BackStackRecord;Landroid/util/SparseArray;Z)V
    .locals 4
    .param p0, "transaction"    # Landroid/support/v4/app/BackStackRecord;
    .param p2, "isOptimized"    # Z
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/support/v4/app/BackStackRecord;",
            "Landroid/util/SparseArray<",
            "Landroid/support/v4/app/FragmentTransition$FragmentContainerTransition;",
            ">;Z)V"
        }
    .end annotation

    .line 973
    .local p1, "transitioningFragments":Landroid/util/SparseArray;, "Landroid/util/SparseArray<Landroid/support/v4/app/FragmentTransition$FragmentContainerTransition;>;"
    iget-object v0, p0, Landroid/support/v4/app/BackStackRecord;->mOps:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    .line 974
    .local v0, "numOps":I
    const/4 v1, 0x0

    .local v1, "opNum":I
    :goto_0
    if-ge v1, v0, :cond_0

    .line 975
    iget-object v2, p0, Landroid/support/v4/app/BackStackRecord;->mOps:Ljava/util/ArrayList;

    invoke-virtual {v2, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Landroid/support/v4/app/BackStackRecord$Op;

    .line 976
    .local v2, "op":Landroid/support/v4/app/BackStackRecord$Op;
    const/4 v3, 0x0

    invoke-static {p0, v2, p1, v3, p2}, Landroid/support/v4/app/FragmentTransition;->addToFirstInLastOut(Landroid/support/v4/app/BackStackRecord;Landroid/support/v4/app/BackStackRecord$Op;Landroid/util/SparseArray;ZZ)V

    .line 974
    .end local v2    # "op":Landroid/support/v4/app/BackStackRecord$Op;
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 978
    .end local v1    # "opNum":I
    :cond_0
    return-void
.end method

.method private static calculateNameOverrides(ILjava/util/ArrayList;Ljava/util/ArrayList;II)Landroid/support/v4/util/ArrayMap;
    .locals 11
    .param p0, "containerId"    # I
    .param p3, "startIndex"    # I
    .param p4, "endIndex"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(I",
            "Ljava/util/ArrayList<",
            "Landroid/support/v4/app/BackStackRecord;",
            ">;",
            "Ljava/util/ArrayList<",
            "Ljava/lang/Boolean;",
            ">;II)",
            "Landroid/support/v4/util/ArrayMap<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .line 138
    .local p1, "records":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Landroid/support/v4/app/BackStackRecord;>;"
    .local p2, "isRecordPop":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/Boolean;>;"
    new-instance v0, Landroid/support/v4/util/ArrayMap;

    invoke-direct {v0}, Landroid/support/v4/util/ArrayMap;-><init>()V

    .line 139
    .local v0, "nameOverrides":Landroid/support/v4/util/ArrayMap;, "Landroid/support/v4/util/ArrayMap<Ljava/lang/String;Ljava/lang/String;>;"
    add-int/lit8 v1, p4, -0x1

    .local v1, "recordNum":I
    :goto_0
    if-lt v1, p3, :cond_5

    .line 140
    invoke-virtual {p1, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Landroid/support/v4/app/BackStackRecord;

    .line 141
    .local v2, "record":Landroid/support/v4/app/BackStackRecord;
    invoke-virtual {v2, p0}, Landroid/support/v4/app/BackStackRecord;->interactsWith(I)Z

    move-result v3

    if-nez v3, :cond_0

    .line 142
    goto :goto_4

    .line 144
    :cond_0
    invoke-virtual {p2, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/Boolean;

    invoke-virtual {v3}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v3

    .line 145
    .local v3, "isPop":Z
    iget-object v4, v2, Landroid/support/v4/app/BackStackRecord;->mSharedElementSourceNames:Ljava/util/ArrayList;

    if-eqz v4, :cond_4

    .line 146
    iget-object v4, v2, Landroid/support/v4/app/BackStackRecord;->mSharedElementSourceNames:Ljava/util/ArrayList;

    invoke-virtual {v4}, Ljava/util/ArrayList;->size()I

    move-result v4

    .line 149
    .local v4, "numSharedElements":I
    if-eqz v3, :cond_1

    .line 150
    iget-object v5, v2, Landroid/support/v4/app/BackStackRecord;->mSharedElementSourceNames:Ljava/util/ArrayList;

    .line 151
    .local v5, "targets":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/String;>;"
    iget-object v6, v2, Landroid/support/v4/app/BackStackRecord;->mSharedElementTargetNames:Ljava/util/ArrayList;

    goto :goto_1

    .line 153
    .end local v5    # "targets":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/String;>;"
    :cond_1
    iget-object v6, v2, Landroid/support/v4/app/BackStackRecord;->mSharedElementSourceNames:Ljava/util/ArrayList;

    .line 154
    .local v6, "sources":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/String;>;"
    iget-object v5, v2, Landroid/support/v4/app/BackStackRecord;->mSharedElementTargetNames:Ljava/util/ArrayList;

    .line 156
    .restart local v5    # "targets":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/String;>;"
    :goto_1
    const/4 v7, 0x0

    .local v7, "i":I
    :goto_2
    if-ge v7, v4, :cond_3

    .line 157
    invoke-virtual {v6, v7}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v8

    check-cast v8, Ljava/lang/String;

    .line 158
    .local v8, "sourceName":Ljava/lang/String;
    invoke-virtual {v5, v7}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v9

    check-cast v9, Ljava/lang/String;

    .line 159
    .local v9, "targetName":Ljava/lang/String;
    invoke-virtual {v0, v9}, Landroid/support/v4/util/ArrayMap;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v10

    check-cast v10, Ljava/lang/String;

    .line 160
    .local v10, "previousTarget":Ljava/lang/String;
    if-eqz v10, :cond_2

    .line 161
    invoke-virtual {v0, v8, v10}, Landroid/support/v4/util/ArrayMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_3

    .line 163
    :cond_2
    invoke-virtual {v0, v8, v9}, Landroid/support/v4/util/ArrayMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 156
    .end local v8    # "sourceName":Ljava/lang/String;
    .end local v9    # "targetName":Ljava/lang/String;
    .end local v10    # "previousTarget":Ljava/lang/String;
    :goto_3
    add-int/lit8 v7, v7, 0x1

    goto :goto_2

    :cond_3
    goto :goto_4

    .line 145
    .end local v4    # "numSharedElements":I
    .end local v5    # "targets":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/String;>;"
    .end local v6    # "sources":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/String;>;"
    .end local v7    # "i":I
    :cond_4
    nop

    .line 139
    .end local v2    # "record":Landroid/support/v4/app/BackStackRecord;
    .end local v3    # "isPop":Z
    :goto_4
    add-int/lit8 v1, v1, -0x1

    goto :goto_0

    .line 168
    .end local v1    # "recordNum":I
    :cond_5
    return-object v0
.end method

.method public static calculatePopFragments(Landroid/support/v4/app/BackStackRecord;Landroid/util/SparseArray;Z)V
    .locals 4
    .param p0, "transaction"    # Landroid/support/v4/app/BackStackRecord;
    .param p2, "isOptimized"    # Z
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/support/v4/app/BackStackRecord;",
            "Landroid/util/SparseArray<",
            "Landroid/support/v4/app/FragmentTransition$FragmentContainerTransition;",
            ">;Z)V"
        }
    .end annotation

    .line 990
    .local p1, "transitioningFragments":Landroid/util/SparseArray;, "Landroid/util/SparseArray<Landroid/support/v4/app/FragmentTransition$FragmentContainerTransition;>;"
    iget-object v0, p0, Landroid/support/v4/app/BackStackRecord;->mManager:Landroid/support/v4/app/FragmentManagerImpl;

    iget-object v0, v0, Landroid/support/v4/app/FragmentManagerImpl;->mContainer:Landroid/support/v4/app/FragmentContainer;

    invoke-virtual {v0}, Landroid/support/v4/app/FragmentContainer;->onHasView()Z

    move-result v0

    if-nez v0, :cond_0

    .line 991
    return-void

    .line 993
    :cond_0
    iget-object v0, p0, Landroid/support/v4/app/BackStackRecord;->mOps:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    .line 994
    .local v0, "numOps":I
    add-int/lit8 v1, v0, -0x1

    .local v1, "opNum":I
    :goto_0
    if-ltz v1, :cond_1

    .line 995
    iget-object v2, p0, Landroid/support/v4/app/BackStackRecord;->mOps:Ljava/util/ArrayList;

    invoke-virtual {v2, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Landroid/support/v4/app/BackStackRecord$Op;

    .line 996
    .local v2, "op":Landroid/support/v4/app/BackStackRecord$Op;
    const/4 v3, 0x1

    invoke-static {p0, v2, p1, v3, p2}, Landroid/support/v4/app/FragmentTransition;->addToFirstInLastOut(Landroid/support/v4/app/BackStackRecord;Landroid/support/v4/app/BackStackRecord$Op;Landroid/util/SparseArray;ZZ)V

    .line 994
    .end local v2    # "op":Landroid/support/v4/app/BackStackRecord$Op;
    add-int/lit8 v1, v1, -0x1

    goto :goto_0

    .line 998
    .end local v1    # "opNum":I
    :cond_1
    return-void
.end method

.method private static callSharedElementStartEnd(Landroid/support/v4/app/Fragment;Landroid/support/v4/app/Fragment;ZLandroid/support/v4/util/ArrayMap;Z)V
    .locals 6
    .param p0, "inFragment"    # Landroid/support/v4/app/Fragment;
    .param p1, "outFragment"    # Landroid/support/v4/app/Fragment;
    .param p2, "isPop"    # Z
    .param p4, "isStart"    # Z
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/support/v4/app/Fragment;",
            "Landroid/support/v4/app/Fragment;",
            "Z",
            "Landroid/support/v4/util/ArrayMap<",
            "Ljava/lang/String;",
            "Landroid/view/View;",
            ">;Z)V"
        }
    .end annotation

    .line 879
    .local p3, "sharedElements":Landroid/support/v4/util/ArrayMap;, "Landroid/support/v4/util/ArrayMap<Ljava/lang/String;Landroid/view/View;>;"
    if-eqz p2, :cond_0

    .line 880
    invoke-virtual {p1}, Landroid/support/v4/app/Fragment;->getEnterTransitionCallback()Landroid/support/v4/app/SharedElementCallback;

    move-result-object v0

    goto :goto_0

    .line 881
    :cond_0
    invoke-virtual {p0}, Landroid/support/v4/app/Fragment;->getEnterTransitionCallback()Landroid/support/v4/app/SharedElementCallback;

    move-result-object v0

    :goto_0
    nop

    .line 882
    .local v0, "sharedElementCallback":Landroid/support/v4/app/SharedElementCallback;
    if-eqz v0, :cond_4

    .line 883
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    .line 884
    .local v1, "views":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Landroid/view/View;>;"
    new-instance v2, Ljava/util/ArrayList;

    invoke-direct {v2}, Ljava/util/ArrayList;-><init>()V

    .line 885
    .local v2, "names":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/String;>;"
    if-nez p3, :cond_1

    const/4 v3, 0x0

    goto :goto_1

    :cond_1
    invoke-virtual {p3}, Landroid/support/v4/util/ArrayMap;->size()I

    move-result v3

    .line 886
    .local v3, "count":I
    :goto_1
    const/4 v4, 0x0

    .local v4, "i":I
    :goto_2
    if-ge v4, v3, :cond_2

    .line 887
    invoke-virtual {p3, v4}, Landroid/support/v4/util/ArrayMap;->keyAt(I)Ljava/lang/Object;

    move-result-object v5

    invoke-virtual {v2, v5}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 888
    invoke-virtual {p3, v4}, Landroid/support/v4/util/ArrayMap;->valueAt(I)Ljava/lang/Object;

    move-result-object v5

    invoke-virtual {v1, v5}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 886
    add-int/lit8 v4, v4, 0x1

    goto :goto_2

    .line 890
    .end local v4    # "i":I
    :cond_2
    const/4 v4, 0x0

    if-eqz p4, :cond_3

    .line 891
    invoke-virtual {v0, v2, v1, v4}, Landroid/support/v4/app/SharedElementCallback;->onSharedElementStart(Ljava/util/List;Ljava/util/List;Ljava/util/List;)V

    goto :goto_3

    .line 893
    :cond_3
    invoke-virtual {v0, v2, v1, v4}, Landroid/support/v4/app/SharedElementCallback;->onSharedElementEnd(Ljava/util/List;Ljava/util/List;Ljava/util/List;)V

    goto :goto_3

    .line 882
    .end local v1    # "views":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Landroid/view/View;>;"
    .end local v2    # "names":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/String;>;"
    .end local v3    # "count":I
    :cond_4
    nop

    .line 896
    :goto_3
    return-void
.end method

.method private static captureInSharedElements(Landroid/support/v4/util/ArrayMap;Ljava/lang/Object;Landroid/support/v4/app/FragmentTransition$FragmentContainerTransition;)Landroid/support/v4/util/ArrayMap;
    .locals 11
    .param p1, "sharedElementTransition"    # Ljava/lang/Object;
    .param p2, "fragments"    # Landroid/support/v4/app/FragmentTransition$FragmentContainerTransition;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/support/v4/util/ArrayMap<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;",
            "Ljava/lang/Object;",
            "Landroid/support/v4/app/FragmentTransition$FragmentContainerTransition;",
            ")",
            "Landroid/support/v4/util/ArrayMap<",
            "Ljava/lang/String;",
            "Landroid/view/View;",
            ">;"
        }
    .end annotation

    .line 742
    .local p0, "nameOverrides":Landroid/support/v4/util/ArrayMap;, "Landroid/support/v4/util/ArrayMap<Ljava/lang/String;Ljava/lang/String;>;"
    iget-object v0, p2, Landroid/support/v4/app/FragmentTransition$FragmentContainerTransition;->lastIn:Landroid/support/v4/app/Fragment;

    .line 743
    .local v0, "inFragment":Landroid/support/v4/app/Fragment;
    invoke-virtual {v0}, Landroid/support/v4/app/Fragment;->getView()Landroid/view/View;

    move-result-object v1

    .line 744
    .local v1, "fragmentView":Landroid/view/View;
    invoke-virtual {p0}, Landroid/support/v4/util/ArrayMap;->isEmpty()Z

    move-result v2

    if-nez v2, :cond_9

    if-eqz p1, :cond_9

    if-nez v1, :cond_0

    goto/16 :goto_6

    .line 748
    :cond_0
    new-instance v2, Landroid/support/v4/util/ArrayMap;

    invoke-direct {v2}, Landroid/support/v4/util/ArrayMap;-><init>()V

    .line 749
    .local v2, "inSharedElements":Landroid/support/v4/util/ArrayMap;, "Landroid/support/v4/util/ArrayMap<Ljava/lang/String;Landroid/view/View;>;"
    invoke-static {v2, v1}, Landroid/support/v4/app/FragmentTransitionCompat21;->findNamedViews(Ljava/util/Map;Landroid/view/View;)V

    .line 753
    iget-object v3, p2, Landroid/support/v4/app/FragmentTransition$FragmentContainerTransition;->lastInTransaction:Landroid/support/v4/app/BackStackRecord;

    .line 754
    .local v3, "inTransaction":Landroid/support/v4/app/BackStackRecord;
    iget-boolean v4, p2, Landroid/support/v4/app/FragmentTransition$FragmentContainerTransition;->lastInIsPop:Z

    if-eqz v4, :cond_1

    .line 755
    invoke-virtual {v0}, Landroid/support/v4/app/Fragment;->getExitTransitionCallback()Landroid/support/v4/app/SharedElementCallback;

    move-result-object v4

    .line 756
    .local v4, "sharedElementCallback":Landroid/support/v4/app/SharedElementCallback;
    iget-object v5, v3, Landroid/support/v4/app/BackStackRecord;->mSharedElementSourceNames:Ljava/util/ArrayList;

    goto :goto_0

    .line 758
    .end local v4    # "sharedElementCallback":Landroid/support/v4/app/SharedElementCallback;
    :cond_1
    invoke-virtual {v0}, Landroid/support/v4/app/Fragment;->getEnterTransitionCallback()Landroid/support/v4/app/SharedElementCallback;

    move-result-object v4

    .line 759
    .restart local v4    # "sharedElementCallback":Landroid/support/v4/app/SharedElementCallback;
    iget-object v5, v3, Landroid/support/v4/app/BackStackRecord;->mSharedElementTargetNames:Ljava/util/ArrayList;

    .line 762
    .local v5, "names":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/String;>;"
    :goto_0
    if-eqz v5, :cond_2

    .line 763
    invoke-virtual {v2, v5}, Landroid/support/v4/util/ArrayMap;->retainAll(Ljava/util/Collection;)Z

    goto :goto_1

    .line 762
    :cond_2
    nop

    .line 765
    :goto_1
    if-eqz v4, :cond_8

    .line 766
    invoke-virtual {v4, v5, v2}, Landroid/support/v4/app/SharedElementCallback;->onMapSharedElements(Ljava/util/List;Ljava/util/Map;)V

    .line 767
    invoke-virtual {v5}, Ljava/util/ArrayList;->size()I

    move-result v6

    add-int/lit8 v6, v6, -0x1

    .local v6, "i":I
    :goto_2
    if-ltz v6, :cond_7

    .line 768
    invoke-virtual {v5, v6}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v7

    check-cast v7, Ljava/lang/String;

    .line 769
    .local v7, "name":Ljava/lang/String;
    invoke-virtual {v2, v7}, Landroid/support/v4/util/ArrayMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v8

    check-cast v8, Landroid/view/View;

    .line 770
    .local v8, "view":Landroid/view/View;
    if-nez v8, :cond_4

    .line 771
    invoke-static {p0, v7}, Landroid/support/v4/app/FragmentTransition;->findKeyForValue(Landroid/support/v4/util/ArrayMap;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v9

    .line 772
    .local v9, "key":Ljava/lang/String;
    if-eqz v9, :cond_3

    .line 773
    invoke-virtual {p0, v9}, Landroid/support/v4/util/ArrayMap;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_3

    .line 772
    :cond_3
    goto :goto_3

    .line 775
    .end local v9    # "key":Ljava/lang/String;
    :cond_4
    invoke-static {v8}, Landroid/support/v4/view/ViewCompat;->getTransitionName(Landroid/view/View;)Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v7, v9}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v9

    if-nez v9, :cond_6

    .line 776
    invoke-static {p0, v7}, Landroid/support/v4/app/FragmentTransition;->findKeyForValue(Landroid/support/v4/util/ArrayMap;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v9

    .line 777
    .restart local v9    # "key":Ljava/lang/String;
    if-eqz v9, :cond_5

    .line 778
    invoke-static {v8}, Landroid/support/v4/view/ViewCompat;->getTransitionName(Landroid/view/View;)Ljava/lang/String;

    move-result-object v10

    invoke-virtual {p0, v9, v10}, Landroid/support/v4/util/ArrayMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_4

    .line 777
    :cond_5
    goto :goto_4

    .line 775
    .end local v9    # "key":Ljava/lang/String;
    :cond_6
    :goto_3
    nop

    .line 767
    .end local v7    # "name":Ljava/lang/String;
    .end local v8    # "view":Landroid/view/View;
    :goto_4
    add-int/lit8 v6, v6, -0x1

    goto :goto_2

    :cond_7
    goto :goto_5

    .line 783
    .end local v6    # "i":I
    :cond_8
    invoke-static {p0, v2}, Landroid/support/v4/app/FragmentTransition;->retainValues(Landroid/support/v4/util/ArrayMap;Landroid/support/v4/util/ArrayMap;)V

    .line 785
    :goto_5
    return-object v2

    .line 744
    .end local v2    # "inSharedElements":Landroid/support/v4/util/ArrayMap;, "Landroid/support/v4/util/ArrayMap<Ljava/lang/String;Landroid/view/View;>;"
    .end local v3    # "inTransaction":Landroid/support/v4/app/BackStackRecord;
    .end local v4    # "sharedElementCallback":Landroid/support/v4/app/SharedElementCallback;
    .end local v5    # "names":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/String;>;"
    :cond_9
    :goto_6
    nop

    .line 745
    invoke-virtual {p0}, Landroid/support/v4/util/ArrayMap;->clear()V

    .line 746
    const/4 v2, 0x0

    return-object v2
.end method

.method private static captureOutSharedElements(Landroid/support/v4/util/ArrayMap;Ljava/lang/Object;Landroid/support/v4/app/FragmentTransition$FragmentContainerTransition;)Landroid/support/v4/util/ArrayMap;
    .locals 10
    .param p1, "sharedElementTransition"    # Ljava/lang/Object;
    .param p2, "fragments"    # Landroid/support/v4/app/FragmentTransition$FragmentContainerTransition;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/support/v4/util/ArrayMap<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;",
            "Ljava/lang/Object;",
            "Landroid/support/v4/app/FragmentTransition$FragmentContainerTransition;",
            ")",
            "Landroid/support/v4/util/ArrayMap<",
            "Ljava/lang/String;",
            "Landroid/view/View;",
            ">;"
        }
    .end annotation

    .line 687
    .local p0, "nameOverrides":Landroid/support/v4/util/ArrayMap;, "Landroid/support/v4/util/ArrayMap<Ljava/lang/String;Ljava/lang/String;>;"
    invoke-virtual {p0}, Landroid/support/v4/util/ArrayMap;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_6

    if-nez p1, :cond_0

    goto :goto_4

    .line 691
    :cond_0
    iget-object v0, p2, Landroid/support/v4/app/FragmentTransition$FragmentContainerTransition;->firstOut:Landroid/support/v4/app/Fragment;

    .line 692
    .local v0, "outFragment":Landroid/support/v4/app/Fragment;
    new-instance v1, Landroid/support/v4/util/ArrayMap;

    invoke-direct {v1}, Landroid/support/v4/util/ArrayMap;-><init>()V

    .line 693
    .local v1, "outSharedElements":Landroid/support/v4/util/ArrayMap;, "Landroid/support/v4/util/ArrayMap<Ljava/lang/String;Landroid/view/View;>;"
    invoke-virtual {v0}, Landroid/support/v4/app/Fragment;->getView()Landroid/view/View;

    move-result-object v2

    invoke-static {v1, v2}, Landroid/support/v4/app/FragmentTransitionCompat21;->findNamedViews(Ljava/util/Map;Landroid/view/View;)V

    .line 697
    iget-object v2, p2, Landroid/support/v4/app/FragmentTransition$FragmentContainerTransition;->firstOutTransaction:Landroid/support/v4/app/BackStackRecord;

    .line 698
    .local v2, "outTransaction":Landroid/support/v4/app/BackStackRecord;
    iget-boolean v3, p2, Landroid/support/v4/app/FragmentTransition$FragmentContainerTransition;->firstOutIsPop:Z

    if-eqz v3, :cond_1

    .line 699
    invoke-virtual {v0}, Landroid/support/v4/app/Fragment;->getEnterTransitionCallback()Landroid/support/v4/app/SharedElementCallback;

    move-result-object v3

    .line 700
    .local v3, "sharedElementCallback":Landroid/support/v4/app/SharedElementCallback;
    iget-object v4, v2, Landroid/support/v4/app/BackStackRecord;->mSharedElementTargetNames:Ljava/util/ArrayList;

    goto :goto_0

    .line 702
    .end local v3    # "sharedElementCallback":Landroid/support/v4/app/SharedElementCallback;
    :cond_1
    invoke-virtual {v0}, Landroid/support/v4/app/Fragment;->getExitTransitionCallback()Landroid/support/v4/app/SharedElementCallback;

    move-result-object v3

    .line 703
    .restart local v3    # "sharedElementCallback":Landroid/support/v4/app/SharedElementCallback;
    iget-object v4, v2, Landroid/support/v4/app/BackStackRecord;->mSharedElementSourceNames:Ljava/util/ArrayList;

    .line 706
    .local v4, "names":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/String;>;"
    :goto_0
    invoke-virtual {v1, v4}, Landroid/support/v4/util/ArrayMap;->retainAll(Ljava/util/Collection;)Z

    .line 707
    if-eqz v3, :cond_5

    .line 708
    invoke-virtual {v3, v4, v1}, Landroid/support/v4/app/SharedElementCallback;->onMapSharedElements(Ljava/util/List;Ljava/util/Map;)V

    .line 709
    invoke-virtual {v4}, Ljava/util/ArrayList;->size()I

    move-result v5

    add-int/lit8 v5, v5, -0x1

    .local v5, "i":I
    :goto_1
    if-ltz v5, :cond_4

    .line 710
    invoke-virtual {v4, v5}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Ljava/lang/String;

    .line 711
    .local v6, "name":Ljava/lang/String;
    invoke-virtual {v1, v6}, Landroid/support/v4/util/ArrayMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v7

    check-cast v7, Landroid/view/View;

    .line 712
    .local v7, "view":Landroid/view/View;
    if-nez v7, :cond_2

    .line 713
    invoke-virtual {p0, v6}, Landroid/support/v4/util/ArrayMap;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_2

    .line 714
    :cond_2
    invoke-static {v7}, Landroid/support/v4/view/ViewCompat;->getTransitionName(Landroid/view/View;)Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v6, v8}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v8

    if-nez v8, :cond_3

    .line 715
    invoke-virtual {p0, v6}, Landroid/support/v4/util/ArrayMap;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v8

    check-cast v8, Ljava/lang/String;

    .line 716
    .local v8, "targetValue":Ljava/lang/String;
    invoke-static {v7}, Landroid/support/v4/view/ViewCompat;->getTransitionName(Landroid/view/View;)Ljava/lang/String;

    move-result-object v9

    invoke-virtual {p0, v9, v8}, Landroid/support/v4/util/ArrayMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_2

    .line 714
    .end local v8    # "targetValue":Ljava/lang/String;
    :cond_3
    nop

    .line 709
    .end local v6    # "name":Ljava/lang/String;
    .end local v7    # "view":Landroid/view/View;
    :goto_2
    add-int/lit8 v5, v5, -0x1

    goto :goto_1

    :cond_4
    goto :goto_3

    .line 720
    .end local v5    # "i":I
    :cond_5
    invoke-virtual {v1}, Landroid/support/v4/util/ArrayMap;->keySet()Ljava/util/Set;

    move-result-object v5

    invoke-virtual {p0, v5}, Landroid/support/v4/util/ArrayMap;->retainAll(Ljava/util/Collection;)Z

    .line 722
    :goto_3
    return-object v1

    .line 687
    .end local v0    # "outFragment":Landroid/support/v4/app/Fragment;
    .end local v1    # "outSharedElements":Landroid/support/v4/util/ArrayMap;, "Landroid/support/v4/util/ArrayMap<Ljava/lang/String;Landroid/view/View;>;"
    .end local v2    # "outTransaction":Landroid/support/v4/app/BackStackRecord;
    .end local v3    # "sharedElementCallback":Landroid/support/v4/app/SharedElementCallback;
    .end local v4    # "names":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/String;>;"
    :cond_6
    :goto_4
    nop

    .line 688
    invoke-virtual {p0}, Landroid/support/v4/util/ArrayMap;->clear()V

    .line 689
    const/4 v0, 0x0

    return-object v0
.end method

.method private static configureEnteringExitingViews(Ljava/lang/Object;Landroid/support/v4/app/Fragment;Ljava/util/ArrayList;Landroid/view/View;)Ljava/util/ArrayList;
    .locals 3
    .param p0, "transition"    # Ljava/lang/Object;
    .param p1, "fragment"    # Landroid/support/v4/app/Fragment;
    .param p3, "nonExistentView"    # Landroid/view/View;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Object;",
            "Landroid/support/v4/app/Fragment;",
            "Ljava/util/ArrayList<",
            "Landroid/view/View;",
            ">;",
            "Landroid/view/View;",
            ")",
            "Ljava/util/ArrayList<",
            "Landroid/view/View;",
            ">;"
        }
    .end annotation

    .line 900
    .local p2, "sharedElements":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Landroid/view/View;>;"
    const/4 v0, 0x0

    .line 901
    .local v0, "viewList":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Landroid/view/View;>;"
    if-eqz p0, :cond_3

    .line 902
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    move-object v0, v1

    .line 903
    invoke-virtual {p1}, Landroid/support/v4/app/Fragment;->getView()Landroid/view/View;

    move-result-object v1

    .line 904
    .local v1, "root":Landroid/view/View;
    if-eqz v1, :cond_0

    .line 905
    invoke-static {v0, v1}, Landroid/support/v4/app/FragmentTransitionCompat21;->captureTransitioningViews(Ljava/util/ArrayList;Landroid/view/View;)V

    goto :goto_0

    .line 904
    :cond_0
    nop

    .line 907
    :goto_0
    if-eqz p2, :cond_1

    .line 908
    invoke-virtual {v0, p2}, Ljava/util/ArrayList;->removeAll(Ljava/util/Collection;)Z

    goto :goto_1

    .line 907
    :cond_1
    nop

    .line 910
    :goto_1
    invoke-virtual {v0}, Ljava/util/ArrayList;->isEmpty()Z

    move-result v2

    if-nez v2, :cond_2

    .line 911
    invoke-virtual {v0, p3}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 912
    invoke-static {p0, v0}, Landroid/support/v4/app/FragmentTransitionCompat21;->addTargets(Ljava/lang/Object;Ljava/util/ArrayList;)V

    goto :goto_2

    .line 910
    :cond_2
    goto :goto_2

    .line 901
    .end local v1    # "root":Landroid/view/View;
    :cond_3
    nop

    .line 915
    :goto_2
    return-object v0
.end method

.method private static configureSharedElementsOptimized(Landroid/view/ViewGroup;Landroid/view/View;Landroid/support/v4/util/ArrayMap;Landroid/support/v4/app/FragmentTransition$FragmentContainerTransition;Ljava/util/ArrayList;Ljava/util/ArrayList;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    .locals 22
    .param p0, "sceneRoot"    # Landroid/view/ViewGroup;
    .param p1, "nonExistentView"    # Landroid/view/View;
    .param p3, "fragments"    # Landroid/support/v4/app/FragmentTransition$FragmentContainerTransition;
    .param p6, "enterTransition"    # Ljava/lang/Object;
    .param p7, "exitTransition"    # Ljava/lang/Object;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/view/ViewGroup;",
            "Landroid/view/View;",
            "Landroid/support/v4/util/ArrayMap<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;",
            "Landroid/support/v4/app/FragmentTransition$FragmentContainerTransition;",
            "Ljava/util/ArrayList<",
            "Landroid/view/View;",
            ">;",
            "Ljava/util/ArrayList<",
            "Landroid/view/View;",
            ">;",
            "Ljava/lang/Object;",
            "Ljava/lang/Object;",
            ")",
            "Ljava/lang/Object;"
        }
    .end annotation

    .line 466
    .local p2, "nameOverrides":Landroid/support/v4/util/ArrayMap;, "Landroid/support/v4/util/ArrayMap<Ljava/lang/String;Ljava/lang/String;>;"
    .local p4, "sharedElementsOut":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Landroid/view/View;>;"
    .local p5, "sharedElementsIn":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Landroid/view/View;>;"
    move-object/from16 v0, p1

    move-object/from16 v1, p2

    move-object/from16 v2, p3

    move-object/from16 v3, p4

    move-object/from16 v4, p5

    move-object/from16 v5, p6

    move-object/from16 v6, p7

    iget-object v14, v2, Landroid/support/v4/app/FragmentTransition$FragmentContainerTransition;->lastIn:Landroid/support/v4/app/Fragment;

    .line 467
    .local v14, "inFragment":Landroid/support/v4/app/Fragment;
    iget-object v15, v2, Landroid/support/v4/app/FragmentTransition$FragmentContainerTransition;->firstOut:Landroid/support/v4/app/Fragment;

    .line 468
    .local v15, "outFragment":Landroid/support/v4/app/Fragment;
    if-eqz v14, :cond_0

    .line 469
    invoke-virtual {v14}, Landroid/support/v4/app/Fragment;->getView()Landroid/view/View;

    move-result-object v7

    const/4 v8, 0x0

    invoke-virtual {v7, v8}, Landroid/view/View;->setVisibility(I)V

    goto :goto_0

    .line 468
    :cond_0
    nop

    .line 471
    :goto_0
    const/4 v7, 0x0

    if-eqz v14, :cond_9

    if-nez v15, :cond_1

    move-object/from16 v8, p0

    goto/16 :goto_7

    .line 475
    :cond_1
    iget-boolean v13, v2, Landroid/support/v4/app/FragmentTransition$FragmentContainerTransition;->lastInIsPop:Z

    .line 476
    .local v13, "inIsPop":Z
    invoke-virtual/range {p2 .. p2}, Landroid/support/v4/util/ArrayMap;->isEmpty()Z

    move-result v8

    if-eqz v8, :cond_2

    move-object v8, v7

    goto :goto_1

    .line 477
    :cond_2
    invoke-static {v14, v15, v13}, Landroid/support/v4/app/FragmentTransition;->getSharedElementTransition(Landroid/support/v4/app/Fragment;Landroid/support/v4/app/Fragment;Z)Ljava/lang/Object;

    move-result-object v8

    :goto_1
    nop

    .line 479
    .local v8, "sharedElementTransition":Ljava/lang/Object;
    invoke-static {v1, v8, v2}, Landroid/support/v4/app/FragmentTransition;->captureOutSharedElements(Landroid/support/v4/util/ArrayMap;Ljava/lang/Object;Landroid/support/v4/app/FragmentTransition$FragmentContainerTransition;)Landroid/support/v4/util/ArrayMap;

    move-result-object v12

    .line 482
    .local v12, "outSharedElements":Landroid/support/v4/util/ArrayMap;, "Landroid/support/v4/util/ArrayMap<Ljava/lang/String;Landroid/view/View;>;"
    invoke-static {v1, v8, v2}, Landroid/support/v4/app/FragmentTransition;->captureInSharedElements(Landroid/support/v4/util/ArrayMap;Ljava/lang/Object;Landroid/support/v4/app/FragmentTransition$FragmentContainerTransition;)Landroid/support/v4/util/ArrayMap;

    move-result-object v11

    .line 485
    .local v11, "inSharedElements":Landroid/support/v4/util/ArrayMap;, "Landroid/support/v4/util/ArrayMap<Ljava/lang/String;Landroid/view/View;>;"
    invoke-virtual/range {p2 .. p2}, Landroid/support/v4/util/ArrayMap;->isEmpty()Z

    move-result v9

    if-eqz v9, :cond_5

    .line 486
    const/4 v8, 0x0

    .line 487
    if-eqz v12, :cond_3

    .line 488
    invoke-virtual {v12}, Landroid/support/v4/util/ArrayMap;->clear()V

    goto :goto_2

    .line 487
    :cond_3
    nop

    .line 490
    :goto_2
    if-eqz v11, :cond_4

    .line 491
    invoke-virtual {v11}, Landroid/support/v4/util/ArrayMap;->clear()V

    goto :goto_3

    .line 490
    :cond_4
    nop

    .line 500
    :goto_3
    move-object v10, v8

    goto :goto_4

    .line 494
    :cond_5
    nop

    .line 495
    invoke-virtual/range {p2 .. p2}, Landroid/support/v4/util/ArrayMap;->keySet()Ljava/util/Set;

    move-result-object v9

    .line 494
    invoke-static {v3, v12, v9}, Landroid/support/v4/app/FragmentTransition;->addSharedElementsWithMatchingNames(Ljava/util/ArrayList;Landroid/support/v4/util/ArrayMap;Ljava/util/Collection;)V

    .line 496
    nop

    .line 497
    invoke-virtual/range {p2 .. p2}, Landroid/support/v4/util/ArrayMap;->values()Ljava/util/Collection;

    move-result-object v9

    .line 496
    invoke-static {v4, v11, v9}, Landroid/support/v4/app/FragmentTransition;->addSharedElementsWithMatchingNames(Ljava/util/ArrayList;Landroid/support/v4/util/ArrayMap;Ljava/util/Collection;)V

    move-object v10, v8

    .line 500
    .end local v8    # "sharedElementTransition":Ljava/lang/Object;
    .local v10, "sharedElementTransition":Ljava/lang/Object;
    :goto_4
    if-nez v5, :cond_6

    if-nez v6, :cond_6

    if-nez v10, :cond_6

    .line 502
    return-object v7

    .line 500
    :cond_6
    nop

    .line 505
    const/4 v7, 0x1

    invoke-static {v14, v15, v13, v12, v7}, Landroid/support/v4/app/FragmentTransition;->callSharedElementStartEnd(Landroid/support/v4/app/Fragment;Landroid/support/v4/app/Fragment;ZLandroid/support/v4/util/ArrayMap;Z)V

    .line 509
    if-eqz v10, :cond_8

    .line 510
    invoke-virtual {v4, v0}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 511
    invoke-static {v10, v0, v3}, Landroid/support/v4/app/FragmentTransitionCompat21;->setSharedElementTargets(Ljava/lang/Object;Landroid/view/View;Ljava/util/ArrayList;)V

    .line 513
    iget-boolean v7, v2, Landroid/support/v4/app/FragmentTransition$FragmentContainerTransition;->firstOutIsPop:Z

    .line 514
    .local v7, "outIsPop":Z
    iget-object v8, v2, Landroid/support/v4/app/FragmentTransition$FragmentContainerTransition;->firstOutTransaction:Landroid/support/v4/app/BackStackRecord;

    .line 515
    .local v8, "outTransaction":Landroid/support/v4/app/BackStackRecord;
    invoke-static {v10, v6, v12, v7, v8}, Landroid/support/v4/app/FragmentTransition;->setOutEpicenter(Ljava/lang/Object;Ljava/lang/Object;Landroid/support/v4/util/ArrayMap;ZLandroid/support/v4/app/BackStackRecord;)V

    .line 517
    new-instance v9, Landroid/graphics/Rect;

    invoke-direct {v9}, Landroid/graphics/Rect;-><init>()V

    .line 518
    .local v9, "epicenter":Landroid/graphics/Rect;
    invoke-static {v11, v2, v5, v13}, Landroid/support/v4/app/FragmentTransition;->getInEpicenterView(Landroid/support/v4/util/ArrayMap;Landroid/support/v4/app/FragmentTransition$FragmentContainerTransition;Ljava/lang/Object;Z)Landroid/view/View;

    move-result-object v16

    .line 520
    .local v16, "epicenterView":Landroid/view/View;
    if-eqz v16, :cond_7

    .line 521
    invoke-static {v5, v9}, Landroid/support/v4/app/FragmentTransitionCompat21;->setEpicenter(Ljava/lang/Object;Landroid/graphics/Rect;)V

    goto :goto_5

    .line 520
    :cond_7
    nop

    .line 523
    .end local v7    # "outIsPop":Z
    .end local v8    # "outTransaction":Landroid/support/v4/app/BackStackRecord;
    :goto_5
    move-object/from16 v17, v9

    goto :goto_6

    .line 524
    .end local v9    # "epicenter":Landroid/graphics/Rect;
    .end local v16    # "epicenterView":Landroid/view/View;
    :cond_8
    const/4 v7, 0x0

    .line 525
    .local v7, "epicenter":Landroid/graphics/Rect;
    const/4 v8, 0x0

    move-object/from16 v17, v7

    move-object/from16 v16, v8

    .line 528
    .end local v7    # "epicenter":Landroid/graphics/Rect;
    .restart local v16    # "epicenterView":Landroid/view/View;
    .local v17, "epicenter":Landroid/graphics/Rect;
    :goto_6
    new-instance v9, Landroid/support/v4/app/FragmentTransition$3;

    move-object v7, v9

    move-object v8, v14

    move-object v0, v9

    move-object v9, v15

    move-object/from16 v18, v10

    .end local v10    # "sharedElementTransition":Ljava/lang/Object;
    .local v18, "sharedElementTransition":Ljava/lang/Object;
    move v10, v13

    move-object/from16 v19, v11

    .end local v11    # "inSharedElements":Landroid/support/v4/util/ArrayMap;, "Landroid/support/v4/util/ArrayMap<Ljava/lang/String;Landroid/view/View;>;"
    .local v19, "inSharedElements":Landroid/support/v4/util/ArrayMap;, "Landroid/support/v4/util/ArrayMap<Ljava/lang/String;Landroid/view/View;>;"
    move-object/from16 v20, v12

    .end local v12    # "outSharedElements":Landroid/support/v4/util/ArrayMap;, "Landroid/support/v4/util/ArrayMap<Ljava/lang/String;Landroid/view/View;>;"
    .local v20, "outSharedElements":Landroid/support/v4/util/ArrayMap;, "Landroid/support/v4/util/ArrayMap<Ljava/lang/String;Landroid/view/View;>;"
    move-object/from16 v12, v16

    move/from16 v21, v13

    .end local v13    # "inIsPop":Z
    .local v21, "inIsPop":Z
    move-object/from16 v13, v17

    invoke-direct/range {v7 .. v13}, Landroid/support/v4/app/FragmentTransition$3;-><init>(Landroid/support/v4/app/Fragment;Landroid/support/v4/app/Fragment;ZLandroid/support/v4/util/ArrayMap;Landroid/view/View;Landroid/graphics/Rect;)V

    move-object/from16 v8, p0

    invoke-static {v8, v0}, Landroid/support/v4/app/OneShotPreDrawListener;->add(Landroid/view/View;Ljava/lang/Runnable;)Landroid/support/v4/app/OneShotPreDrawListener;

    .line 538
    return-object v18

    .line 471
    .end local v16    # "epicenterView":Landroid/view/View;
    .end local v17    # "epicenter":Landroid/graphics/Rect;
    .end local v18    # "sharedElementTransition":Ljava/lang/Object;
    .end local v19    # "inSharedElements":Landroid/support/v4/util/ArrayMap;, "Landroid/support/v4/util/ArrayMap<Ljava/lang/String;Landroid/view/View;>;"
    .end local v20    # "outSharedElements":Landroid/support/v4/util/ArrayMap;, "Landroid/support/v4/util/ArrayMap<Ljava/lang/String;Landroid/view/View;>;"
    .end local v21    # "inIsPop":Z
    :cond_9
    move-object/from16 v8, p0

    .line 472
    :goto_7
    return-object v7
.end method

.method private static configureSharedElementsUnoptimized(Landroid/view/ViewGroup;Landroid/view/View;Landroid/support/v4/util/ArrayMap;Landroid/support/v4/app/FragmentTransition$FragmentContainerTransition;Ljava/util/ArrayList;Ljava/util/ArrayList;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    .locals 22
    .param p0, "sceneRoot"    # Landroid/view/ViewGroup;
    .param p1, "nonExistentView"    # Landroid/view/View;
    .param p3, "fragments"    # Landroid/support/v4/app/FragmentTransition$FragmentContainerTransition;
    .param p6, "enterTransition"    # Ljava/lang/Object;
    .param p7, "exitTransition"    # Ljava/lang/Object;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/view/ViewGroup;",
            "Landroid/view/View;",
            "Landroid/support/v4/util/ArrayMap<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;",
            "Landroid/support/v4/app/FragmentTransition$FragmentContainerTransition;",
            "Ljava/util/ArrayList<",
            "Landroid/view/View;",
            ">;",
            "Ljava/util/ArrayList<",
            "Landroid/view/View;",
            ">;",
            "Ljava/lang/Object;",
            "Ljava/lang/Object;",
            ")",
            "Ljava/lang/Object;"
        }
    .end annotation

    .line 594
    .local p2, "nameOverrides":Landroid/support/v4/util/ArrayMap;, "Landroid/support/v4/util/ArrayMap<Ljava/lang/String;Ljava/lang/String;>;"
    .local p4, "sharedElementsOut":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Landroid/view/View;>;"
    .local p5, "sharedElementsIn":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Landroid/view/View;>;"
    move-object/from16 v12, p3

    move-object/from16 v13, p4

    move-object/from16 v14, p6

    move-object/from16 v15, p7

    iget-object v11, v12, Landroid/support/v4/app/FragmentTransition$FragmentContainerTransition;->lastIn:Landroid/support/v4/app/Fragment;

    .line 595
    .local v11, "inFragment":Landroid/support/v4/app/Fragment;
    iget-object v10, v12, Landroid/support/v4/app/FragmentTransition$FragmentContainerTransition;->firstOut:Landroid/support/v4/app/Fragment;

    .line 597
    .local v10, "outFragment":Landroid/support/v4/app/Fragment;
    const/4 v0, 0x0

    if-eqz v11, :cond_6

    if-nez v10, :cond_0

    move-object/from16 v1, p0

    move-object/from16 v20, v10

    move-object/from16 v21, v11

    goto/16 :goto_4

    .line 601
    :cond_0
    iget-boolean v9, v12, Landroid/support/v4/app/FragmentTransition$FragmentContainerTransition;->lastInIsPop:Z

    .line 602
    .local v9, "inIsPop":Z
    invoke-virtual/range {p2 .. p2}, Landroid/support/v4/util/ArrayMap;->isEmpty()Z

    move-result v1

    if-eqz v1, :cond_1

    move-object v1, v0

    goto :goto_0

    .line 603
    :cond_1
    invoke-static {v11, v10, v9}, Landroid/support/v4/app/FragmentTransition;->getSharedElementTransition(Landroid/support/v4/app/Fragment;Landroid/support/v4/app/Fragment;Z)Ljava/lang/Object;

    move-result-object v1

    :goto_0
    nop

    .line 605
    .local v1, "sharedElementTransition":Ljava/lang/Object;
    move-object/from16 v8, p2

    invoke-static {v8, v1, v12}, Landroid/support/v4/app/FragmentTransition;->captureOutSharedElements(Landroid/support/v4/util/ArrayMap;Ljava/lang/Object;Landroid/support/v4/app/FragmentTransition$FragmentContainerTransition;)Landroid/support/v4/util/ArrayMap;

    move-result-object v7

    .line 608
    .local v7, "outSharedElements":Landroid/support/v4/util/ArrayMap;, "Landroid/support/v4/util/ArrayMap<Ljava/lang/String;Landroid/view/View;>;"
    invoke-virtual/range {p2 .. p2}, Landroid/support/v4/util/ArrayMap;->isEmpty()Z

    move-result v2

    if-eqz v2, :cond_2

    .line 609
    const/4 v1, 0x0

    move-object v6, v1

    goto :goto_1

    .line 611
    :cond_2
    invoke-virtual {v7}, Landroid/support/v4/util/ArrayMap;->values()Ljava/util/Collection;

    move-result-object v2

    invoke-virtual {v13, v2}, Ljava/util/ArrayList;->addAll(Ljava/util/Collection;)Z

    move-object v6, v1

    .line 614
    .end local v1    # "sharedElementTransition":Ljava/lang/Object;
    .local v6, "sharedElementTransition":Ljava/lang/Object;
    :goto_1
    if-nez v14, :cond_3

    if-nez v15, :cond_3

    if-nez v6, :cond_3

    .line 616
    return-object v0

    .line 614
    :cond_3
    nop

    .line 619
    const/4 v0, 0x1

    invoke-static {v11, v10, v9, v7, v0}, Landroid/support/v4/app/FragmentTransition;->callSharedElementStartEnd(Landroid/support/v4/app/Fragment;Landroid/support/v4/app/Fragment;ZLandroid/support/v4/util/ArrayMap;Z)V

    .line 622
    if-eqz v6, :cond_5

    .line 623
    new-instance v0, Landroid/graphics/Rect;

    invoke-direct {v0}, Landroid/graphics/Rect;-><init>()V

    .line 624
    .local v0, "inEpicenter":Landroid/graphics/Rect;
    move-object/from16 v5, p1

    invoke-static {v6, v5, v13}, Landroid/support/v4/app/FragmentTransitionCompat21;->setSharedElementTargets(Ljava/lang/Object;Landroid/view/View;Ljava/util/ArrayList;)V

    .line 626
    iget-boolean v1, v12, Landroid/support/v4/app/FragmentTransition$FragmentContainerTransition;->firstOutIsPop:Z

    .line 627
    .local v1, "outIsPop":Z
    iget-object v2, v12, Landroid/support/v4/app/FragmentTransition$FragmentContainerTransition;->firstOutTransaction:Landroid/support/v4/app/BackStackRecord;

    .line 628
    .local v2, "outTransaction":Landroid/support/v4/app/BackStackRecord;
    invoke-static {v6, v15, v7, v1, v2}, Landroid/support/v4/app/FragmentTransition;->setOutEpicenter(Ljava/lang/Object;Ljava/lang/Object;Landroid/support/v4/util/ArrayMap;ZLandroid/support/v4/app/BackStackRecord;)V

    .line 630
    if-eqz v14, :cond_4

    .line 631
    invoke-static {v14, v0}, Landroid/support/v4/app/FragmentTransitionCompat21;->setEpicenter(Ljava/lang/Object;Landroid/graphics/Rect;)V

    goto :goto_2

    .line 630
    :cond_4
    nop

    .line 633
    .end local v1    # "outIsPop":Z
    .end local v2    # "outTransaction":Landroid/support/v4/app/BackStackRecord;
    :goto_2
    move-object/from16 v16, v0

    goto :goto_3

    .line 634
    .end local v0    # "inEpicenter":Landroid/graphics/Rect;
    :cond_5
    move-object/from16 v5, p1

    const/4 v0, 0x0

    move-object/from16 v16, v0

    .line 638
    .local v16, "inEpicenter":Landroid/graphics/Rect;
    :goto_3
    move-object v2, v6

    .line 639
    .local v2, "finalSharedElementTransition":Ljava/lang/Object;
    new-instance v4, Landroid/support/v4/app/FragmentTransition$4;

    move-object v0, v4

    move-object/from16 v1, p2

    move-object/from16 v3, p3

    move-object v12, v4

    move-object/from16 v4, p5

    move-object/from16 v5, p1

    move-object/from16 v17, v6

    .end local v6    # "sharedElementTransition":Ljava/lang/Object;
    .local v17, "sharedElementTransition":Ljava/lang/Object;
    move-object v6, v11

    move-object/from16 v18, v7

    .end local v7    # "outSharedElements":Landroid/support/v4/util/ArrayMap;, "Landroid/support/v4/util/ArrayMap<Ljava/lang/String;Landroid/view/View;>;"
    .local v18, "outSharedElements":Landroid/support/v4/util/ArrayMap;, "Landroid/support/v4/util/ArrayMap<Ljava/lang/String;Landroid/view/View;>;"
    move-object v7, v10

    move v8, v9

    move/from16 v19, v9

    .end local v9    # "inIsPop":Z
    .local v19, "inIsPop":Z
    move-object/from16 v9, p4

    move-object/from16 v20, v10

    .end local v10    # "outFragment":Landroid/support/v4/app/Fragment;
    .local v20, "outFragment":Landroid/support/v4/app/Fragment;
    move-object/from16 v10, p6

    move-object/from16 v21, v11

    .end local v11    # "inFragment":Landroid/support/v4/app/Fragment;
    .local v21, "inFragment":Landroid/support/v4/app/Fragment;
    move-object/from16 v11, v16

    invoke-direct/range {v0 .. v11}, Landroid/support/v4/app/FragmentTransition$4;-><init>(Landroid/support/v4/util/ArrayMap;Ljava/lang/Object;Landroid/support/v4/app/FragmentTransition$FragmentContainerTransition;Ljava/util/ArrayList;Landroid/view/View;Landroid/support/v4/app/Fragment;Landroid/support/v4/app/Fragment;ZLjava/util/ArrayList;Ljava/lang/Object;Landroid/graphics/Rect;)V

    move-object/from16 v1, p0

    invoke-static {v1, v12}, Landroid/support/v4/app/OneShotPreDrawListener;->add(Landroid/view/View;Ljava/lang/Runnable;)Landroid/support/v4/app/OneShotPreDrawListener;

    .line 667
    return-object v17

    .line 597
    .end local v2    # "finalSharedElementTransition":Ljava/lang/Object;
    .end local v16    # "inEpicenter":Landroid/graphics/Rect;
    .end local v17    # "sharedElementTransition":Ljava/lang/Object;
    .end local v18    # "outSharedElements":Landroid/support/v4/util/ArrayMap;, "Landroid/support/v4/util/ArrayMap<Ljava/lang/String;Landroid/view/View;>;"
    .end local v19    # "inIsPop":Z
    .end local v20    # "outFragment":Landroid/support/v4/app/Fragment;
    .end local v21    # "inFragment":Landroid/support/v4/app/Fragment;
    .restart local v10    # "outFragment":Landroid/support/v4/app/Fragment;
    .restart local v11    # "inFragment":Landroid/support/v4/app/Fragment;
    :cond_6
    move-object/from16 v1, p0

    move-object/from16 v20, v10

    move-object/from16 v21, v11

    .line 598
    .end local v10    # "outFragment":Landroid/support/v4/app/Fragment;
    .end local v11    # "inFragment":Landroid/support/v4/app/Fragment;
    .restart local v20    # "outFragment":Landroid/support/v4/app/Fragment;
    .restart local v21    # "inFragment":Landroid/support/v4/app/Fragment;
    :goto_4
    return-object v0
.end method

.method private static configureTransitionsOptimized(Landroid/support/v4/app/FragmentManagerImpl;ILandroid/support/v4/app/FragmentTransition$FragmentContainerTransition;Landroid/view/View;Landroid/support/v4/util/ArrayMap;)V
    .locals 26
    .param p0, "fragmentManager"    # Landroid/support/v4/app/FragmentManagerImpl;
    .param p1, "containerId"    # I
    .param p2, "fragments"    # Landroid/support/v4/app/FragmentTransition$FragmentContainerTransition;
    .param p3, "nonExistentView"    # Landroid/view/View;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/support/v4/app/FragmentManagerImpl;",
            "I",
            "Landroid/support/v4/app/FragmentTransition$FragmentContainerTransition;",
            "Landroid/view/View;",
            "Landroid/support/v4/util/ArrayMap<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .line 189
    .local p4, "nameOverrides":Landroid/support/v4/util/ArrayMap;, "Landroid/support/v4/util/ArrayMap<Ljava/lang/String;Ljava/lang/String;>;"
    move-object/from16 v0, p0

    move-object/from16 v9, p2

    move-object/from16 v10, p3

    const/4 v1, 0x0

    .line 190
    .local v1, "sceneRoot":Landroid/view/ViewGroup;
    iget-object v2, v0, Landroid/support/v4/app/FragmentManagerImpl;->mContainer:Landroid/support/v4/app/FragmentContainer;

    invoke-virtual {v2}, Landroid/support/v4/app/FragmentContainer;->onHasView()Z

    move-result v2

    if-eqz v2, :cond_0

    .line 191
    iget-object v2, v0, Landroid/support/v4/app/FragmentManagerImpl;->mContainer:Landroid/support/v4/app/FragmentContainer;

    move/from16 v11, p1

    invoke-virtual {v2, v11}, Landroid/support/v4/app/FragmentContainer;->onFindViewById(I)Landroid/view/View;

    move-result-object v2

    move-object v1, v2

    check-cast v1, Landroid/view/ViewGroup;

    move-object v12, v1

    goto :goto_0

    .line 190
    :cond_0
    move/from16 v11, p1

    move-object v12, v1

    .line 193
    .end local v1    # "sceneRoot":Landroid/view/ViewGroup;
    .local v12, "sceneRoot":Landroid/view/ViewGroup;
    :goto_0
    if-nez v12, :cond_1

    .line 194
    return-void

    .line 196
    :cond_1
    iget-object v13, v9, Landroid/support/v4/app/FragmentTransition$FragmentContainerTransition;->lastIn:Landroid/support/v4/app/Fragment;

    .line 197
    .local v13, "inFragment":Landroid/support/v4/app/Fragment;
    iget-object v14, v9, Landroid/support/v4/app/FragmentTransition$FragmentContainerTransition;->firstOut:Landroid/support/v4/app/Fragment;

    .line 198
    .local v14, "outFragment":Landroid/support/v4/app/Fragment;
    iget-boolean v15, v9, Landroid/support/v4/app/FragmentTransition$FragmentContainerTransition;->lastInIsPop:Z

    .line 199
    .local v15, "inIsPop":Z
    iget-boolean v8, v9, Landroid/support/v4/app/FragmentTransition$FragmentContainerTransition;->firstOutIsPop:Z

    .line 201
    .local v8, "outIsPop":Z
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    move-object v7, v1

    .line 202
    .local v7, "sharedElementsIn":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Landroid/view/View;>;"
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    move-object v6, v1

    .line 203
    .local v6, "sharedElementsOut":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Landroid/view/View;>;"
    invoke-static {v13, v15}, Landroid/support/v4/app/FragmentTransition;->getEnterTransition(Landroid/support/v4/app/Fragment;Z)Ljava/lang/Object;

    move-result-object v5

    .line 204
    .local v5, "enterTransition":Ljava/lang/Object;
    invoke-static {v14, v8}, Landroid/support/v4/app/FragmentTransition;->getExitTransition(Landroid/support/v4/app/Fragment;Z)Ljava/lang/Object;

    move-result-object v4

    .line 206
    .local v4, "exitTransition":Ljava/lang/Object;
    move-object v1, v12

    move-object/from16 v2, p3

    move-object/from16 v3, p4

    move-object/from16 v23, v4

    .end local v4    # "exitTransition":Ljava/lang/Object;
    .local v23, "exitTransition":Ljava/lang/Object;
    move-object/from16 v4, p2

    move-object/from16 v24, v5

    .end local v5    # "enterTransition":Ljava/lang/Object;
    .local v24, "enterTransition":Ljava/lang/Object;
    move-object v5, v6

    move-object v0, v6

    .end local v6    # "sharedElementsOut":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Landroid/view/View;>;"
    .local v0, "sharedElementsOut":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Landroid/view/View;>;"
    move-object v6, v7

    move-object v9, v7

    .end local v7    # "sharedElementsIn":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Landroid/view/View;>;"
    .local v9, "sharedElementsIn":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Landroid/view/View;>;"
    move-object/from16 v7, v24

    move/from16 v25, v8

    .end local v8    # "outIsPop":Z
    .local v25, "outIsPop":Z
    move-object/from16 v8, v23

    invoke-static/range {v1 .. v8}, Landroid/support/v4/app/FragmentTransition;->configureSharedElementsOptimized(Landroid/view/ViewGroup;Landroid/view/View;Landroid/support/v4/util/ArrayMap;Landroid/support/v4/app/FragmentTransition$FragmentContainerTransition;Ljava/util/ArrayList;Ljava/util/ArrayList;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    .line 210
    .local v1, "sharedElementTransition":Ljava/lang/Object;
    move-object/from16 v2, v24

    .end local v24    # "enterTransition":Ljava/lang/Object;
    .local v2, "enterTransition":Ljava/lang/Object;
    if-nez v2, :cond_2

    if-nez v1, :cond_2

    move-object/from16 v3, v23

    .end local v23    # "exitTransition":Ljava/lang/Object;
    .local v3, "exitTransition":Ljava/lang/Object;
    if-nez v3, :cond_3

    .line 212
    return-void

    .line 210
    .end local v3    # "exitTransition":Ljava/lang/Object;
    .restart local v23    # "exitTransition":Ljava/lang/Object;
    :cond_2
    move-object/from16 v3, v23

    .line 215
    .end local v23    # "exitTransition":Ljava/lang/Object;
    .restart local v3    # "exitTransition":Ljava/lang/Object;
    :cond_3
    invoke-static {v3, v14, v0, v10}, Landroid/support/v4/app/FragmentTransition;->configureEnteringExitingViews(Ljava/lang/Object;Landroid/support/v4/app/Fragment;Ljava/util/ArrayList;Landroid/view/View;)Ljava/util/ArrayList;

    move-result-object v4

    .line 218
    .local v4, "exitingViews":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Landroid/view/View;>;"
    invoke-static {v2, v13, v9, v10}, Landroid/support/v4/app/FragmentTransition;->configureEnteringExitingViews(Ljava/lang/Object;Landroid/support/v4/app/Fragment;Ljava/util/ArrayList;Landroid/view/View;)Ljava/util/ArrayList;

    move-result-object v5

    .line 221
    .local v5, "enteringViews":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Landroid/view/View;>;"
    const/4 v6, 0x4

    invoke-static {v5, v6}, Landroid/support/v4/app/FragmentTransition;->setViewVisibility(Ljava/util/ArrayList;I)V

    .line 223
    invoke-static {v2, v3, v1, v13, v15}, Landroid/support/v4/app/FragmentTransition;->mergeTransitions(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Landroid/support/v4/app/Fragment;Z)Ljava/lang/Object;

    move-result-object v6

    .line 226
    .local v6, "transition":Ljava/lang/Object;
    if-eqz v6, :cond_4

    .line 227
    invoke-static {v3, v14, v4}, Landroid/support/v4/app/FragmentTransition;->replaceHide(Ljava/lang/Object;Landroid/support/v4/app/Fragment;Ljava/util/ArrayList;)V

    .line 228
    nop

    .line 229
    invoke-static {v9}, Landroid/support/v4/app/FragmentTransitionCompat21;->prepareSetNameOverridesOptimized(Ljava/util/ArrayList;)Ljava/util/ArrayList;

    move-result-object v7

    .line 230
    .local v7, "inNames":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/String;>;"
    move-object/from16 v16, v6

    move-object/from16 v17, v2

    move-object/from16 v18, v5

    move-object/from16 v19, v3

    move-object/from16 v20, v4

    move-object/from16 v21, v1

    move-object/from16 v22, v9

    invoke-static/range {v16 .. v22}, Landroid/support/v4/app/FragmentTransitionCompat21;->scheduleRemoveTargets(Ljava/lang/Object;Ljava/lang/Object;Ljava/util/ArrayList;Ljava/lang/Object;Ljava/util/ArrayList;Ljava/lang/Object;Ljava/util/ArrayList;)V

    .line 233
    invoke-static {v12, v6}, Landroid/support/v4/app/FragmentTransitionCompat21;->beginDelayedTransition(Landroid/view/ViewGroup;Ljava/lang/Object;)V

    .line 234
    move-object/from16 v8, p4

    invoke-static {v12, v0, v9, v7, v8}, Landroid/support/v4/app/FragmentTransitionCompat21;->setNameOverridesOptimized(Landroid/view/View;Ljava/util/ArrayList;Ljava/util/ArrayList;Ljava/util/ArrayList;Ljava/util/Map;)V

    .line 236
    move-object/from16 v24, v2

    .end local v2    # "enterTransition":Ljava/lang/Object;
    .restart local v24    # "enterTransition":Ljava/lang/Object;
    const/4 v2, 0x0

    invoke-static {v5, v2}, Landroid/support/v4/app/FragmentTransition;->setViewVisibility(Ljava/util/ArrayList;I)V

    .line 237
    invoke-static {v1, v0, v9}, Landroid/support/v4/app/FragmentTransitionCompat21;->swapSharedElementTargets(Ljava/lang/Object;Ljava/util/ArrayList;Ljava/util/ArrayList;)V

    goto :goto_1

    .line 226
    .end local v7    # "inNames":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/String;>;"
    .end local v24    # "enterTransition":Ljava/lang/Object;
    .restart local v2    # "enterTransition":Ljava/lang/Object;
    :cond_4
    move-object/from16 v8, p4

    move-object/from16 v24, v2

    .line 240
    .end local v2    # "enterTransition":Ljava/lang/Object;
    .restart local v24    # "enterTransition":Ljava/lang/Object;
    :goto_1
    return-void
.end method

.method private static configureTransitionsUnoptimized(Landroid/support/v4/app/FragmentManagerImpl;ILandroid/support/v4/app/FragmentTransition$FragmentContainerTransition;Landroid/view/View;Landroid/support/v4/util/ArrayMap;)V
    .locals 28
    .param p0, "fragmentManager"    # Landroid/support/v4/app/FragmentManagerImpl;
    .param p1, "containerId"    # I
    .param p2, "fragments"    # Landroid/support/v4/app/FragmentTransition$FragmentContainerTransition;
    .param p3, "nonExistentView"    # Landroid/view/View;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/support/v4/app/FragmentManagerImpl;",
            "I",
            "Landroid/support/v4/app/FragmentTransition$FragmentContainerTransition;",
            "Landroid/view/View;",
            "Landroid/support/v4/util/ArrayMap<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .line 282
    .local p4, "nameOverrides":Landroid/support/v4/util/ArrayMap;, "Landroid/support/v4/util/ArrayMap<Ljava/lang/String;Ljava/lang/String;>;"
    move-object/from16 v0, p0

    move-object/from16 v9, p2

    move-object/from16 v10, p3

    move-object/from16 v11, p4

    const/4 v1, 0x0

    .line 283
    .local v1, "sceneRoot":Landroid/view/ViewGroup;
    iget-object v2, v0, Landroid/support/v4/app/FragmentManagerImpl;->mContainer:Landroid/support/v4/app/FragmentContainer;

    invoke-virtual {v2}, Landroid/support/v4/app/FragmentContainer;->onHasView()Z

    move-result v2

    if-eqz v2, :cond_0

    .line 284
    iget-object v2, v0, Landroid/support/v4/app/FragmentManagerImpl;->mContainer:Landroid/support/v4/app/FragmentContainer;

    move/from16 v12, p1

    invoke-virtual {v2, v12}, Landroid/support/v4/app/FragmentContainer;->onFindViewById(I)Landroid/view/View;

    move-result-object v2

    move-object v1, v2

    check-cast v1, Landroid/view/ViewGroup;

    move-object v13, v1

    goto :goto_0

    .line 283
    :cond_0
    move/from16 v12, p1

    move-object v13, v1

    .line 286
    .end local v1    # "sceneRoot":Landroid/view/ViewGroup;
    .local v13, "sceneRoot":Landroid/view/ViewGroup;
    :goto_0
    if-nez v13, :cond_1

    .line 287
    return-void

    .line 289
    :cond_1
    iget-object v14, v9, Landroid/support/v4/app/FragmentTransition$FragmentContainerTransition;->lastIn:Landroid/support/v4/app/Fragment;

    .line 290
    .local v14, "inFragment":Landroid/support/v4/app/Fragment;
    iget-object v15, v9, Landroid/support/v4/app/FragmentTransition$FragmentContainerTransition;->firstOut:Landroid/support/v4/app/Fragment;

    .line 291
    .local v15, "outFragment":Landroid/support/v4/app/Fragment;
    iget-boolean v8, v9, Landroid/support/v4/app/FragmentTransition$FragmentContainerTransition;->lastInIsPop:Z

    .line 292
    .local v8, "inIsPop":Z
    iget-boolean v7, v9, Landroid/support/v4/app/FragmentTransition$FragmentContainerTransition;->firstOutIsPop:Z

    .line 294
    .local v7, "outIsPop":Z
    invoke-static {v14, v8}, Landroid/support/v4/app/FragmentTransition;->getEnterTransition(Landroid/support/v4/app/Fragment;Z)Ljava/lang/Object;

    move-result-object v6

    .line 295
    .local v6, "enterTransition":Ljava/lang/Object;
    invoke-static {v15, v7}, Landroid/support/v4/app/FragmentTransition;->getExitTransition(Landroid/support/v4/app/Fragment;Z)Ljava/lang/Object;

    move-result-object v5

    .line 297
    .local v5, "exitTransition":Ljava/lang/Object;
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    move-object v4, v1

    .line 298
    .local v4, "sharedElementsOut":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Landroid/view/View;>;"
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    move-object v3, v1

    .line 300
    .local v3, "sharedElementsIn":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Landroid/view/View;>;"
    move-object v1, v13

    move-object/from16 v2, p3

    move-object/from16 v23, v3

    .end local v3    # "sharedElementsIn":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Landroid/view/View;>;"
    .local v23, "sharedElementsIn":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Landroid/view/View;>;"
    move-object/from16 v3, p4

    move-object/from16 v24, v4

    .end local v4    # "sharedElementsOut":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Landroid/view/View;>;"
    .local v24, "sharedElementsOut":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Landroid/view/View;>;"
    move-object/from16 v4, p2

    move-object/from16 v16, v5

    .end local v5    # "exitTransition":Ljava/lang/Object;
    .local v16, "exitTransition":Ljava/lang/Object;
    move-object/from16 v5, v24

    move-object/from16 v25, v6

    .end local v6    # "enterTransition":Ljava/lang/Object;
    .local v25, "enterTransition":Ljava/lang/Object;
    move-object/from16 v6, v23

    move/from16 v26, v7

    .end local v7    # "outIsPop":Z
    .local v26, "outIsPop":Z
    move-object/from16 v7, v25

    move/from16 v27, v8

    .end local v8    # "inIsPop":Z
    .local v27, "inIsPop":Z
    move-object/from16 v8, v16

    invoke-static/range {v1 .. v8}, Landroid/support/v4/app/FragmentTransition;->configureSharedElementsUnoptimized(Landroid/view/ViewGroup;Landroid/view/View;Landroid/support/v4/util/ArrayMap;Landroid/support/v4/app/FragmentTransition$FragmentContainerTransition;Ljava/util/ArrayList;Ljava/util/ArrayList;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v8

    .line 304
    .local v8, "sharedElementTransition":Ljava/lang/Object;
    nop

    .end local v25    # "enterTransition":Ljava/lang/Object;
    .local v7, "enterTransition":Ljava/lang/Object;
    if-nez v7, :cond_2

    if-nez v8, :cond_2

    move-object/from16 v1, v16

    .end local v16    # "exitTransition":Ljava/lang/Object;
    .local v1, "exitTransition":Ljava/lang/Object;
    if-nez v1, :cond_3

    .line 306
    return-void

    .line 304
    .end local v1    # "exitTransition":Ljava/lang/Object;
    .restart local v16    # "exitTransition":Ljava/lang/Object;
    :cond_2
    move-object/from16 v1, v16

    .line 309
    .end local v16    # "exitTransition":Ljava/lang/Object;
    .restart local v1    # "exitTransition":Ljava/lang/Object;
    :cond_3
    move-object/from16 v6, v24

    .end local v24    # "sharedElementsOut":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Landroid/view/View;>;"
    .local v6, "sharedElementsOut":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Landroid/view/View;>;"
    invoke-static {v1, v15, v6, v10}, Landroid/support/v4/app/FragmentTransition;->configureEnteringExitingViews(Ljava/lang/Object;Landroid/support/v4/app/Fragment;Ljava/util/ArrayList;Landroid/view/View;)Ljava/util/ArrayList;

    move-result-object v24

    .line 312
    .local v24, "exitingViews":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Landroid/view/View;>;"
    if-eqz v24, :cond_5

    invoke-virtual/range {v24 .. v24}, Ljava/util/ArrayList;->isEmpty()Z

    move-result v2

    if-eqz v2, :cond_4

    goto :goto_1

    :cond_4
    move-object v5, v1

    goto :goto_2

    .line 313
    :cond_5
    :goto_1
    const/4 v1, 0x0

    move-object v5, v1

    .line 318
    .end local v1    # "exitTransition":Ljava/lang/Object;
    .restart local v5    # "exitTransition":Ljava/lang/Object;
    :goto_2
    invoke-static {v7, v10}, Landroid/support/v4/app/FragmentTransitionCompat21;->addTarget(Ljava/lang/Object;Landroid/view/View;)V

    .line 320
    iget-boolean v1, v9, Landroid/support/v4/app/FragmentTransition$FragmentContainerTransition;->lastInIsPop:Z

    invoke-static {v7, v5, v8, v14, v1}, Landroid/support/v4/app/FragmentTransition;->mergeTransitions(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Landroid/support/v4/app/Fragment;Z)Ljava/lang/Object;

    move-result-object v4

    .line 323
    .local v4, "transition":Ljava/lang/Object;
    if-eqz v4, :cond_6

    .line 324
    new-instance v18, Ljava/util/ArrayList;

    invoke-direct/range {v18 .. v18}, Ljava/util/ArrayList;-><init>()V

    .line 325
    .local v18, "enteringViews":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Landroid/view/View;>;"
    move-object/from16 v16, v4

    move-object/from16 v17, v7

    move-object/from16 v19, v5

    move-object/from16 v20, v24

    move-object/from16 v21, v8

    move-object/from16 v22, v23

    invoke-static/range {v16 .. v22}, Landroid/support/v4/app/FragmentTransitionCompat21;->scheduleRemoveTargets(Ljava/lang/Object;Ljava/lang/Object;Ljava/util/ArrayList;Ljava/lang/Object;Ljava/util/ArrayList;Ljava/lang/Object;Ljava/util/ArrayList;)V

    .line 328
    move-object v1, v13

    move-object v2, v14

    move-object/from16 v3, p3

    move-object v0, v4

    .end local v4    # "transition":Ljava/lang/Object;
    .local v0, "transition":Ljava/lang/Object;
    move-object/from16 v4, v23

    move-object/from16 v16, v5

    .end local v5    # "exitTransition":Ljava/lang/Object;
    .restart local v16    # "exitTransition":Ljava/lang/Object;
    move-object v5, v7

    move-object/from16 v17, v6

    .end local v6    # "sharedElementsOut":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Landroid/view/View;>;"
    .local v17, "sharedElementsOut":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Landroid/view/View;>;"
    move-object/from16 v6, v18

    move-object/from16 v19, v7

    .end local v7    # "enterTransition":Ljava/lang/Object;
    .local v19, "enterTransition":Ljava/lang/Object;
    move-object/from16 v7, v16

    move-object/from16 v20, v8

    .end local v8    # "sharedElementTransition":Ljava/lang/Object;
    .local v20, "sharedElementTransition":Ljava/lang/Object;
    move-object/from16 v8, v24

    invoke-static/range {v1 .. v8}, Landroid/support/v4/app/FragmentTransition;->scheduleTargetChange(Landroid/view/ViewGroup;Landroid/support/v4/app/Fragment;Landroid/view/View;Ljava/util/ArrayList;Ljava/lang/Object;Ljava/util/ArrayList;Ljava/lang/Object;Ljava/util/ArrayList;)V

    .line 330
    move-object/from16 v1, v23

    .end local v23    # "sharedElementsIn":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Landroid/view/View;>;"
    .local v1, "sharedElementsIn":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Landroid/view/View;>;"
    invoke-static {v13, v1, v11}, Landroid/support/v4/app/FragmentTransitionCompat21;->setNameOverridesUnoptimized(Landroid/view/View;Ljava/util/ArrayList;Ljava/util/Map;)V

    .line 333
    invoke-static {v13, v0}, Landroid/support/v4/app/FragmentTransitionCompat21;->beginDelayedTransition(Landroid/view/ViewGroup;Ljava/lang/Object;)V

    .line 334
    invoke-static {v13, v1, v11}, Landroid/support/v4/app/FragmentTransitionCompat21;->scheduleNameReset(Landroid/view/ViewGroup;Ljava/util/ArrayList;Ljava/util/Map;)V

    goto :goto_3

    .line 323
    .end local v0    # "transition":Ljava/lang/Object;
    .end local v1    # "sharedElementsIn":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Landroid/view/View;>;"
    .end local v16    # "exitTransition":Ljava/lang/Object;
    .end local v17    # "sharedElementsOut":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Landroid/view/View;>;"
    .end local v18    # "enteringViews":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Landroid/view/View;>;"
    .end local v19    # "enterTransition":Ljava/lang/Object;
    .end local v20    # "sharedElementTransition":Ljava/lang/Object;
    .restart local v4    # "transition":Ljava/lang/Object;
    .restart local v5    # "exitTransition":Ljava/lang/Object;
    .restart local v6    # "sharedElementsOut":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Landroid/view/View;>;"
    .restart local v7    # "enterTransition":Ljava/lang/Object;
    .restart local v8    # "sharedElementTransition":Ljava/lang/Object;
    .restart local v23    # "sharedElementsIn":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Landroid/view/View;>;"
    :cond_6
    move-object v0, v4

    move-object/from16 v16, v5

    move-object/from16 v17, v6

    move-object/from16 v19, v7

    move-object/from16 v20, v8

    move-object/from16 v1, v23

    .line 337
    .end local v4    # "transition":Ljava/lang/Object;
    .end local v5    # "exitTransition":Ljava/lang/Object;
    .end local v6    # "sharedElementsOut":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Landroid/view/View;>;"
    .end local v7    # "enterTransition":Ljava/lang/Object;
    .end local v8    # "sharedElementTransition":Ljava/lang/Object;
    .end local v23    # "sharedElementsIn":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Landroid/view/View;>;"
    .restart local v0    # "transition":Ljava/lang/Object;
    .restart local v1    # "sharedElementsIn":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Landroid/view/View;>;"
    .restart local v16    # "exitTransition":Ljava/lang/Object;
    .restart local v17    # "sharedElementsOut":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Landroid/view/View;>;"
    .restart local v19    # "enterTransition":Ljava/lang/Object;
    .restart local v20    # "sharedElementTransition":Ljava/lang/Object;
    :goto_3
    return-void
.end method

.method private static ensureContainer(Landroid/support/v4/app/FragmentTransition$FragmentContainerTransition;Landroid/util/SparseArray;I)Landroid/support/v4/app/FragmentTransition$FragmentContainerTransition;
    .locals 1
    .param p0, "containerTransition"    # Landroid/support/v4/app/FragmentTransition$FragmentContainerTransition;
    .param p2, "containerId"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/support/v4/app/FragmentTransition$FragmentContainerTransition;",
            "Landroid/util/SparseArray<",
            "Landroid/support/v4/app/FragmentTransition$FragmentContainerTransition;",
            ">;I)",
            "Landroid/support/v4/app/FragmentTransition$FragmentContainerTransition;"
        }
    .end annotation

    .line 1110
    .local p1, "transitioningFragments":Landroid/util/SparseArray;, "Landroid/util/SparseArray<Landroid/support/v4/app/FragmentTransition$FragmentContainerTransition;>;"
    if-nez p0, :cond_0

    .line 1111
    new-instance v0, Landroid/support/v4/app/FragmentTransition$FragmentContainerTransition;

    invoke-direct {v0}, Landroid/support/v4/app/FragmentTransition$FragmentContainerTransition;-><init>()V

    move-object p0, v0

    .line 1112
    invoke-virtual {p1, p2, p0}, Landroid/util/SparseArray;->put(ILjava/lang/Object;)V

    goto :goto_0

    .line 1110
    :cond_0
    nop

    .line 1114
    :goto_0
    return-object p0
.end method

.method private static findKeyForValue(Landroid/support/v4/util/ArrayMap;Ljava/lang/String;)Ljava/lang/String;
    .locals 3
    .param p1, "value"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/support/v4/util/ArrayMap<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;",
            "Ljava/lang/String;",
            ")",
            "Ljava/lang/String;"
        }
    .end annotation

    .line 792
    .local p0, "map":Landroid/support/v4/util/ArrayMap;, "Landroid/support/v4/util/ArrayMap<Ljava/lang/String;Ljava/lang/String;>;"
    invoke-virtual {p0}, Landroid/support/v4/util/ArrayMap;->size()I

    move-result v0

    .line 793
    .local v0, "numElements":I
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_0
    if-ge v1, v0, :cond_1

    .line 794
    invoke-virtual {p0, v1}, Landroid/support/v4/util/ArrayMap;->valueAt(I)Ljava/lang/Object;

    move-result-object v2

    invoke-virtual {p1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 795
    invoke-virtual {p0, v1}, Landroid/support/v4/util/ArrayMap;->keyAt(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    return-object v2

    .line 793
    :cond_0
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 798
    .end local v1    # "i":I
    :cond_1
    const/4 v1, 0x0

    return-object v1
.end method

.method private static getEnterTransition(Landroid/support/v4/app/Fragment;Z)Ljava/lang/Object;
    .locals 1
    .param p0, "inFragment"    # Landroid/support/v4/app/Fragment;
    .param p1, "isPop"    # Z

    .line 413
    if-nez p0, :cond_0

    .line 414
    const/4 v0, 0x0

    return-object v0

    .line 416
    :cond_0
    if-eqz p1, :cond_1

    .line 417
    invoke-virtual {p0}, Landroid/support/v4/app/Fragment;->getReenterTransition()Ljava/lang/Object;

    move-result-object v0

    goto :goto_0

    .line 418
    :cond_1
    invoke-virtual {p0}, Landroid/support/v4/app/Fragment;->getEnterTransition()Ljava/lang/Object;

    move-result-object v0

    .line 416
    :goto_0
    invoke-static {v0}, Landroid/support/v4/app/FragmentTransitionCompat21;->cloneTransition(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    return-object v0
.end method

.method private static getExitTransition(Landroid/support/v4/app/Fragment;Z)Ljava/lang/Object;
    .locals 1
    .param p0, "outFragment"    # Landroid/support/v4/app/Fragment;
    .param p1, "isPop"    # Z

    .line 425
    if-nez p0, :cond_0

    .line 426
    const/4 v0, 0x0

    return-object v0

    .line 428
    :cond_0
    if-eqz p1, :cond_1

    .line 429
    invoke-virtual {p0}, Landroid/support/v4/app/Fragment;->getReturnTransition()Ljava/lang/Object;

    move-result-object v0

    goto :goto_0

    .line 430
    :cond_1
    invoke-virtual {p0}, Landroid/support/v4/app/Fragment;->getExitTransition()Ljava/lang/Object;

    move-result-object v0

    .line 428
    :goto_0
    invoke-static {v0}, Landroid/support/v4/app/FragmentTransitionCompat21;->cloneTransition(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    return-object v0
.end method

.method private static getInEpicenterView(Landroid/support/v4/util/ArrayMap;Landroid/support/v4/app/FragmentTransition$FragmentContainerTransition;Ljava/lang/Object;Z)Landroid/view/View;
    .locals 3
    .param p1, "fragments"    # Landroid/support/v4/app/FragmentTransition$FragmentContainerTransition;
    .param p2, "enterTransition"    # Ljava/lang/Object;
    .param p3, "inIsPop"    # Z
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/support/v4/util/ArrayMap<",
            "Ljava/lang/String;",
            "Landroid/view/View;",
            ">;",
            "Landroid/support/v4/app/FragmentTransition$FragmentContainerTransition;",
            "Ljava/lang/Object;",
            "Z)",
            "Landroid/view/View;"
        }
    .end annotation

    .line 813
    .local p0, "inSharedElements":Landroid/support/v4/util/ArrayMap;, "Landroid/support/v4/util/ArrayMap<Ljava/lang/String;Landroid/view/View;>;"
    iget-object v0, p1, Landroid/support/v4/app/FragmentTransition$FragmentContainerTransition;->lastInTransaction:Landroid/support/v4/app/BackStackRecord;

    .line 814
    .local v0, "inTransaction":Landroid/support/v4/app/BackStackRecord;
    if-eqz p2, :cond_2

    if-eqz p0, :cond_2

    iget-object v1, v0, Landroid/support/v4/app/BackStackRecord;->mSharedElementSourceNames:Ljava/util/ArrayList;

    if-eqz v1, :cond_2

    iget-object v1, v0, Landroid/support/v4/app/BackStackRecord;->mSharedElementSourceNames:Ljava/util/ArrayList;

    .line 816
    invoke-virtual {v1}, Ljava/util/ArrayList;->isEmpty()Z

    move-result v1

    if-nez v1, :cond_1

    .line 817
    const/4 v1, 0x0

    if-eqz p3, :cond_0

    iget-object v2, v0, Landroid/support/v4/app/BackStackRecord;->mSharedElementSourceNames:Ljava/util/ArrayList;

    .line 818
    invoke-virtual {v2, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    goto :goto_0

    :cond_0
    iget-object v2, v0, Landroid/support/v4/app/BackStackRecord;->mSharedElementTargetNames:Ljava/util/ArrayList;

    .line 819
    invoke-virtual {v2, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    :goto_0
    nop

    .line 820
    .local v1, "targetName":Ljava/lang/String;
    invoke-virtual {p0, v1}, Landroid/support/v4/util/ArrayMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Landroid/view/View;

    return-object v2

    .line 816
    .end local v1    # "targetName":Ljava/lang/String;
    :cond_1
    goto :goto_1

    .line 814
    :cond_2
    nop

    .line 822
    :goto_1
    const/4 v1, 0x0

    return-object v1
.end method

.method private static getSharedElementTransition(Landroid/support/v4/app/Fragment;Landroid/support/v4/app/Fragment;Z)Ljava/lang/Object;
    .locals 2
    .param p0, "inFragment"    # Landroid/support/v4/app/Fragment;
    .param p1, "outFragment"    # Landroid/support/v4/app/Fragment;
    .param p2, "isPop"    # Z

    .line 400
    if-eqz p0, :cond_2

    if-nez p1, :cond_0

    goto :goto_1

    .line 403
    :cond_0
    if-eqz p2, :cond_1

    .line 404
    invoke-virtual {p1}, Landroid/support/v4/app/Fragment;->getSharedElementReturnTransition()Ljava/lang/Object;

    move-result-object v0

    goto :goto_0

    .line 405
    :cond_1
    invoke-virtual {p0}, Landroid/support/v4/app/Fragment;->getSharedElementEnterTransition()Ljava/lang/Object;

    move-result-object v0

    .line 403
    :goto_0
    invoke-static {v0}, Landroid/support/v4/app/FragmentTransitionCompat21;->cloneTransition(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    .line 406
    .local v0, "transition":Ljava/lang/Object;
    invoke-static {v0}, Landroid/support/v4/app/FragmentTransitionCompat21;->wrapTransitionInSet(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    return-object v1

    .line 400
    .end local v0    # "transition":Ljava/lang/Object;
    :cond_2
    :goto_1
    nop

    .line 401
    const/4 v0, 0x0

    return-object v0
.end method

.method private static mergeTransitions(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Landroid/support/v4/app/Fragment;Z)Ljava/lang/Object;
    .locals 2
    .param p0, "enterTransition"    # Ljava/lang/Object;
    .param p1, "exitTransition"    # Ljava/lang/Object;
    .param p2, "sharedElementTransition"    # Ljava/lang/Object;
    .param p3, "inFragment"    # Landroid/support/v4/app/Fragment;
    .param p4, "isPop"    # Z

    .line 938
    const/4 v0, 0x1

    .line 939
    .local v0, "overlap":Z
    if-eqz p0, :cond_1

    if-eqz p1, :cond_1

    if-eqz p3, :cond_1

    .line 940
    if-eqz p4, :cond_0

    invoke-virtual {p3}, Landroid/support/v4/app/Fragment;->getAllowReturnTransitionOverlap()Z

    move-result v1

    goto :goto_0

    .line 941
    :cond_0
    invoke-virtual {p3}, Landroid/support/v4/app/Fragment;->getAllowEnterTransitionOverlap()Z

    move-result v1

    :goto_0
    move v0, v1

    goto :goto_1

    .line 939
    :cond_1
    nop

    .line 949
    :goto_1
    if-eqz v0, :cond_2

    .line 951
    invoke-static {p1, p0, p2}, Landroid/support/v4/app/FragmentTransitionCompat21;->mergeTransitionsTogether(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    goto :goto_2

    .line 956
    :cond_2
    invoke-static {p1, p0, p2}, Landroid/support/v4/app/FragmentTransitionCompat21;->mergeTransitionsInSequence(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    .line 959
    .local v1, "transition":Ljava/lang/Object;
    :goto_2
    return-object v1
.end method

.method private static replaceHide(Ljava/lang/Object;Landroid/support/v4/app/Fragment;Ljava/util/ArrayList;)V
    .locals 2
    .param p0, "exitTransition"    # Ljava/lang/Object;
    .param p1, "exitingFragment"    # Landroid/support/v4/app/Fragment;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Object;",
            "Landroid/support/v4/app/Fragment;",
            "Ljava/util/ArrayList<",
            "Landroid/view/View;",
            ">;)V"
        }
    .end annotation

    .line 249
    .local p2, "exitingViews":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Landroid/view/View;>;"
    if-eqz p1, :cond_0

    if-eqz p0, :cond_0

    iget-boolean v0, p1, Landroid/support/v4/app/Fragment;->mAdded:Z

    if-eqz v0, :cond_0

    iget-boolean v0, p1, Landroid/support/v4/app/Fragment;->mHidden:Z

    if-eqz v0, :cond_0

    iget-boolean v0, p1, Landroid/support/v4/app/Fragment;->mHiddenChanged:Z

    if-eqz v0, :cond_0

    .line 251
    const/4 v0, 0x1

    invoke-virtual {p1, v0}, Landroid/support/v4/app/Fragment;->setHideReplaced(Z)V

    .line 252
    nop

    .line 253
    invoke-virtual {p1}, Landroid/support/v4/app/Fragment;->getView()Landroid/view/View;

    move-result-object v0

    .line 252
    invoke-static {p0, v0, p2}, Landroid/support/v4/app/FragmentTransitionCompat21;->scheduleHideFragmentView(Ljava/lang/Object;Landroid/view/View;Ljava/util/ArrayList;)V

    .line 254
    iget-object v0, p1, Landroid/support/v4/app/Fragment;->mContainer:Landroid/view/ViewGroup;

    .line 255
    .local v0, "container":Landroid/view/ViewGroup;
    new-instance v1, Landroid/support/v4/app/FragmentTransition$1;

    invoke-direct {v1, p2}, Landroid/support/v4/app/FragmentTransition$1;-><init>(Ljava/util/ArrayList;)V

    invoke-static {v0, v1}, Landroid/support/v4/app/OneShotPreDrawListener;->add(Landroid/view/View;Ljava/lang/Runnable;)Landroid/support/v4/app/OneShotPreDrawListener;

    goto :goto_0

    .line 249
    .end local v0    # "container":Landroid/view/ViewGroup;
    :cond_0
    nop

    .line 262
    :goto_0
    return-void
.end method

.method private static retainValues(Landroid/support/v4/util/ArrayMap;Landroid/support/v4/util/ArrayMap;)V
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/support/v4/util/ArrayMap<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;",
            "Landroid/support/v4/util/ArrayMap<",
            "Ljava/lang/String;",
            "Landroid/view/View;",
            ">;)V"
        }
    .end annotation

    .line 858
    .local p0, "nameOverrides":Landroid/support/v4/util/ArrayMap;, "Landroid/support/v4/util/ArrayMap<Ljava/lang/String;Ljava/lang/String;>;"
    .local p1, "namedViews":Landroid/support/v4/util/ArrayMap;, "Landroid/support/v4/util/ArrayMap<Ljava/lang/String;Landroid/view/View;>;"
    invoke-virtual {p0}, Landroid/support/v4/util/ArrayMap;->size()I

    move-result v0

    add-int/lit8 v0, v0, -0x1

    .local v0, "i":I
    :goto_0
    if-ltz v0, :cond_1

    .line 859
    invoke-virtual {p0, v0}, Landroid/support/v4/util/ArrayMap;->valueAt(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    .line 860
    .local v1, "targetName":Ljava/lang/String;
    invoke-virtual {p1, v1}, Landroid/support/v4/util/ArrayMap;->containsKey(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_0

    .line 861
    invoke-virtual {p0, v0}, Landroid/support/v4/util/ArrayMap;->removeAt(I)Ljava/lang/Object;

    goto :goto_1

    .line 860
    :cond_0
    nop

    .line 858
    .end local v1    # "targetName":Ljava/lang/String;
    :goto_1
    add-int/lit8 v0, v0, -0x1

    goto :goto_0

    .line 864
    .end local v0    # "i":I
    :cond_1
    return-void
.end method

.method private static scheduleTargetChange(Landroid/view/ViewGroup;Landroid/support/v4/app/Fragment;Landroid/view/View;Ljava/util/ArrayList;Ljava/lang/Object;Ljava/util/ArrayList;Ljava/lang/Object;Ljava/util/ArrayList;)V
    .locals 9
    .param p0, "sceneRoot"    # Landroid/view/ViewGroup;
    .param p1, "inFragment"    # Landroid/support/v4/app/Fragment;
    .param p2, "nonExistentView"    # Landroid/view/View;
    .param p4, "enterTransition"    # Ljava/lang/Object;
    .param p6, "exitTransition"    # Ljava/lang/Object;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/view/ViewGroup;",
            "Landroid/support/v4/app/Fragment;",
            "Landroid/view/View;",
            "Ljava/util/ArrayList<",
            "Landroid/view/View;",
            ">;",
            "Ljava/lang/Object;",
            "Ljava/util/ArrayList<",
            "Landroid/view/View;",
            ">;",
            "Ljava/lang/Object;",
            "Ljava/util/ArrayList<",
            "Landroid/view/View;",
            ">;)V"
        }
    .end annotation

    .line 361
    .local p3, "sharedElementsIn":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Landroid/view/View;>;"
    .local p5, "enteringViews":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Landroid/view/View;>;"
    .local p7, "exitingViews":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Landroid/view/View;>;"
    new-instance v8, Landroid/support/v4/app/FragmentTransition$2;

    move-object v0, v8

    move-object v1, p4

    move-object v2, p2

    move-object v3, p1

    move-object v4, p3

    move-object v5, p5

    move-object/from16 v6, p7

    move-object v7, p6

    invoke-direct/range {v0 .. v7}, Landroid/support/v4/app/FragmentTransition$2;-><init>(Ljava/lang/Object;Landroid/view/View;Landroid/support/v4/app/Fragment;Ljava/util/ArrayList;Ljava/util/ArrayList;Ljava/util/ArrayList;Ljava/lang/Object;)V

    move-object v0, p0

    invoke-static {p0, v8}, Landroid/support/v4/app/OneShotPreDrawListener;->add(Landroid/view/View;Ljava/lang/Runnable;)Landroid/support/v4/app/OneShotPreDrawListener;

    .line 384
    return-void
.end method

.method private static setOutEpicenter(Ljava/lang/Object;Ljava/lang/Object;Landroid/support/v4/util/ArrayMap;ZLandroid/support/v4/app/BackStackRecord;)V
    .locals 2
    .param p0, "sharedElementTransition"    # Ljava/lang/Object;
    .param p1, "exitTransition"    # Ljava/lang/Object;
    .param p3, "outIsPop"    # Z
    .param p4, "outTransaction"    # Landroid/support/v4/app/BackStackRecord;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Object;",
            "Ljava/lang/Object;",
            "Landroid/support/v4/util/ArrayMap<",
            "Ljava/lang/String;",
            "Landroid/view/View;",
            ">;Z",
            "Landroid/support/v4/app/BackStackRecord;",
            ")V"
        }
    .end annotation

    .line 837
    .local p2, "outSharedElements":Landroid/support/v4/util/ArrayMap;, "Landroid/support/v4/util/ArrayMap<Ljava/lang/String;Landroid/view/View;>;"
    iget-object v0, p4, Landroid/support/v4/app/BackStackRecord;->mSharedElementSourceNames:Ljava/util/ArrayList;

    if-eqz v0, :cond_3

    iget-object v0, p4, Landroid/support/v4/app/BackStackRecord;->mSharedElementSourceNames:Ljava/util/ArrayList;

    .line 838
    invoke-virtual {v0}, Ljava/util/ArrayList;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_2

    .line 839
    const/4 v0, 0x0

    if-eqz p3, :cond_0

    iget-object v1, p4, Landroid/support/v4/app/BackStackRecord;->mSharedElementTargetNames:Ljava/util/ArrayList;

    .line 840
    invoke-virtual {v1, v0}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    goto :goto_0

    :cond_0
    iget-object v1, p4, Landroid/support/v4/app/BackStackRecord;->mSharedElementSourceNames:Ljava/util/ArrayList;

    .line 841
    invoke-virtual {v1, v0}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    :goto_0
    nop

    .line 842
    .local v0, "sourceName":Ljava/lang/String;
    invoke-virtual {p2, v0}, Landroid/support/v4/util/ArrayMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/view/View;

    .line 843
    .local v1, "outEpicenterView":Landroid/view/View;
    invoke-static {p0, v1}, Landroid/support/v4/app/FragmentTransitionCompat21;->setEpicenter(Ljava/lang/Object;Landroid/view/View;)V

    .line 845
    if-eqz p1, :cond_1

    .line 846
    invoke-static {p1, v1}, Landroid/support/v4/app/FragmentTransitionCompat21;->setEpicenter(Ljava/lang/Object;Landroid/view/View;)V

    goto :goto_1

    .line 845
    :cond_1
    goto :goto_1

    .line 838
    .end local v0    # "sourceName":Ljava/lang/String;
    .end local v1    # "outEpicenterView":Landroid/view/View;
    :cond_2
    goto :goto_1

    .line 837
    :cond_3
    nop

    .line 849
    :goto_1
    return-void
.end method

.method private static setViewVisibility(Ljava/util/ArrayList;I)V
    .locals 2
    .param p1, "visibility"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/ArrayList<",
            "Landroid/view/View;",
            ">;I)V"
        }
    .end annotation

    .line 922
    .local p0, "views":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Landroid/view/View;>;"
    if-nez p0, :cond_0

    .line 923
    return-void

    .line 925
    :cond_0
    invoke-virtual {p0}, Ljava/util/ArrayList;->size()I

    move-result v0

    add-int/lit8 v0, v0, -0x1

    .local v0, "i":I
    :goto_0
    if-ltz v0, :cond_1

    .line 926
    invoke-virtual {p0, v0}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/view/View;

    .line 927
    .local v1, "view":Landroid/view/View;
    invoke-virtual {v1, p1}, Landroid/view/View;->setVisibility(I)V

    .line 925
    .end local v1    # "view":Landroid/view/View;
    add-int/lit8 v0, v0, -0x1

    goto :goto_0

    .line 929
    .end local v0    # "i":I
    :cond_1
    return-void
.end method

.method static startTransitions(Landroid/support/v4/app/FragmentManagerImpl;Ljava/util/ArrayList;Ljava/util/ArrayList;IIZ)V
    .locals 7
    .param p0, "fragmentManager"    # Landroid/support/v4/app/FragmentManagerImpl;
    .param p3, "startIndex"    # I
    .param p4, "endIndex"    # I
    .param p5, "isOptimized"    # Z
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/support/v4/app/FragmentManagerImpl;",
            "Ljava/util/ArrayList<",
            "Landroid/support/v4/app/BackStackRecord;",
            ">;",
            "Ljava/util/ArrayList<",
            "Ljava/lang/Boolean;",
            ">;IIZ)V"
        }
    .end annotation

    .line 83
    .local p1, "records":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Landroid/support/v4/app/BackStackRecord;>;"
    .local p2, "isRecordPop":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/Boolean;>;"
    iget v0, p0, Landroid/support/v4/app/FragmentManagerImpl;->mCurState:I

    const/4 v1, 0x1

    if-lt v0, v1, :cond_6

    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v1, 0x15

    if-ge v0, v1, :cond_0

    goto :goto_5

    .line 87
    :cond_0
    new-instance v0, Landroid/util/SparseArray;

    invoke-direct {v0}, Landroid/util/SparseArray;-><init>()V

    .line 89
    .local v0, "transitioningFragments":Landroid/util/SparseArray;, "Landroid/util/SparseArray<Landroid/support/v4/app/FragmentTransition$FragmentContainerTransition;>;"
    move v1, p3

    .local v1, "i":I
    :goto_0
    if-ge v1, p4, :cond_2

    .line 90
    invoke-virtual {p1, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Landroid/support/v4/app/BackStackRecord;

    .line 91
    .local v2, "record":Landroid/support/v4/app/BackStackRecord;
    invoke-virtual {p2, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/Boolean;

    invoke-virtual {v3}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v3

    .line 92
    .local v3, "isPop":Z
    if-eqz v3, :cond_1

    .line 93
    invoke-static {v2, v0, p5}, Landroid/support/v4/app/FragmentTransition;->calculatePopFragments(Landroid/support/v4/app/BackStackRecord;Landroid/util/SparseArray;Z)V

    goto :goto_1

    .line 95
    :cond_1
    invoke-static {v2, v0, p5}, Landroid/support/v4/app/FragmentTransition;->calculateFragments(Landroid/support/v4/app/BackStackRecord;Landroid/util/SparseArray;Z)V

    .line 89
    .end local v2    # "record":Landroid/support/v4/app/BackStackRecord;
    .end local v3    # "isPop":Z
    :goto_1
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 99
    .end local v1    # "i":I
    :cond_2
    invoke-virtual {v0}, Landroid/util/SparseArray;->size()I

    move-result v1

    if-eqz v1, :cond_5

    .line 100
    new-instance v1, Landroid/view/View;

    iget-object v2, p0, Landroid/support/v4/app/FragmentManagerImpl;->mHost:Landroid/support/v4/app/FragmentHostCallback;

    invoke-virtual {v2}, Landroid/support/v4/app/FragmentHostCallback;->getContext()Landroid/content/Context;

    move-result-object v2

    invoke-direct {v1, v2}, Landroid/view/View;-><init>(Landroid/content/Context;)V

    .line 101
    .local v1, "nonExistentView":Landroid/view/View;
    invoke-virtual {v0}, Landroid/util/SparseArray;->size()I

    move-result v2

    .line 102
    .local v2, "numContainers":I
    const/4 v3, 0x0

    .local v3, "i":I
    :goto_2
    if-ge v3, v2, :cond_4

    .line 103
    invoke-virtual {v0, v3}, Landroid/util/SparseArray;->keyAt(I)I

    move-result v4

    .line 104
    .local v4, "containerId":I
    invoke-static {v4, p1, p2, p3, p4}, Landroid/support/v4/app/FragmentTransition;->calculateNameOverrides(ILjava/util/ArrayList;Ljava/util/ArrayList;II)Landroid/support/v4/util/ArrayMap;

    move-result-object v5

    .line 107
    .local v5, "nameOverrides":Landroid/support/v4/util/ArrayMap;, "Landroid/support/v4/util/ArrayMap<Ljava/lang/String;Ljava/lang/String;>;"
    invoke-virtual {v0, v3}, Landroid/util/SparseArray;->valueAt(I)Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Landroid/support/v4/app/FragmentTransition$FragmentContainerTransition;

    .line 109
    .local v6, "containerTransition":Landroid/support/v4/app/FragmentTransition$FragmentContainerTransition;
    if-eqz p5, :cond_3

    .line 110
    invoke-static {p0, v4, v6, v1, v5}, Landroid/support/v4/app/FragmentTransition;->configureTransitionsOptimized(Landroid/support/v4/app/FragmentManagerImpl;ILandroid/support/v4/app/FragmentTransition$FragmentContainerTransition;Landroid/view/View;Landroid/support/v4/util/ArrayMap;)V

    goto :goto_3

    .line 113
    :cond_3
    invoke-static {p0, v4, v6, v1, v5}, Landroid/support/v4/app/FragmentTransition;->configureTransitionsUnoptimized(Landroid/support/v4/app/FragmentManagerImpl;ILandroid/support/v4/app/FragmentTransition$FragmentContainerTransition;Landroid/view/View;Landroid/support/v4/util/ArrayMap;)V

    .line 102
    .end local v4    # "containerId":I
    .end local v5    # "nameOverrides":Landroid/support/v4/util/ArrayMap;, "Landroid/support/v4/util/ArrayMap<Ljava/lang/String;Ljava/lang/String;>;"
    .end local v6    # "containerTransition":Landroid/support/v4/app/FragmentTransition$FragmentContainerTransition;
    :goto_3
    add-int/lit8 v3, v3, 0x1

    goto :goto_2

    :cond_4
    goto :goto_4

    .line 99
    .end local v1    # "nonExistentView":Landroid/view/View;
    .end local v2    # "numContainers":I
    .end local v3    # "i":I
    :cond_5
    nop

    .line 118
    :goto_4
    return-void

    .line 83
    .end local v0    # "transitioningFragments":Landroid/util/SparseArray;, "Landroid/util/SparseArray<Landroid/support/v4/app/FragmentTransition$FragmentContainerTransition;>;"
    :cond_6
    :goto_5
    nop

    .line 85
    return-void
.end method
