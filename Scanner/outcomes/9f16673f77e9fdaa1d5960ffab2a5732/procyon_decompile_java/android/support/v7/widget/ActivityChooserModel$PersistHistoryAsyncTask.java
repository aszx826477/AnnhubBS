// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v7.widget;

import android.os.AsyncTask;

final class ActivityChooserModel$PersistHistoryAsyncTask extends AsyncTask
{
    final /* synthetic */ ActivityChooserModel this$0;
    
    ActivityChooserModel$PersistHistoryAsyncTask(final ActivityChooserModel this$0) {
        this.this$0 = this$0;
    }
    
    public Void doInBackground(final Object... p0) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     0: aconst_null    
        //     1: astore_2       
        //     2: aload_1        
        //     3: iconst_0       
        //     4: aaload         
        //     5: checkcast       Ljava/util/List;
        //     8: astore_3       
        //     9: iconst_1       
        //    10: istore          4
        //    12: aload_1        
        //    13: iload           4
        //    15: aaload         
        //    16: checkcast       Ljava/lang/String;
        //    19: astore          5
        //    21: aconst_null    
        //    22: astore          6
        //    24: aconst_null    
        //    25: astore          7
        //    27: aload_0        
        //    28: getfield        android/support/v7/widget/ActivityChooserModel$PersistHistoryAsyncTask.this$0:Landroid/support/v7/widget/ActivityChooserModel;
        //    31: astore          8
        //    33: aload           8
        //    35: getfield        android/support/v7/widget/ActivityChooserModel.mContext:Landroid/content/Context;
        //    38: astore          8
        //    40: aload           8
        //    42: aload           5
        //    44: iconst_0       
        //    45: invokevirtual   android/content/Context.openFileOutput:(Ljava/lang/String;I)Ljava/io/FileOutputStream;
        //    48: astore          6
        //    50: invokestatic    android/util/Xml.newSerializer:()Lorg/xmlpull/v1/XmlSerializer;
        //    53: astore          8
        //    55: aload           8
        //    57: aload           6
        //    59: aconst_null    
        //    60: invokeinterface org/xmlpull/v1/XmlSerializer.setOutput:(Ljava/io/OutputStream;Ljava/lang/String;)V
        //    65: ldc             "UTF-8"
        //    67: astore          9
        //    69: iload           4
        //    71: invokestatic    java/lang/Boolean.valueOf:(Z)Ljava/lang/Boolean;
        //    74: astore          10
        //    76: aload           8
        //    78: aload           9
        //    80: aload           10
        //    82: invokeinterface org/xmlpull/v1/XmlSerializer.startDocument:(Ljava/lang/String;Ljava/lang/Boolean;)V
        //    87: ldc             "historical-records"
        //    89: astore          9
        //    91: aload           8
        //    93: aconst_null    
        //    94: aload           9
        //    96: invokeinterface org/xmlpull/v1/XmlSerializer.startTag:(Ljava/lang/String;Ljava/lang/String;)Lorg/xmlpull/v1/XmlSerializer;
        //   101: pop            
        //   102: aload_3        
        //   103: invokeinterface java/util/List.size:()I
        //   108: istore          11
        //   110: iconst_0       
        //   111: istore          12
        //   113: aconst_null    
        //   114: astore          10
        //   116: iload           12
        //   118: iload           11
        //   120: if_icmpge       271
        //   123: aload_3        
        //   124: iconst_0       
        //   125: invokeinterface java/util/List.remove:(I)Ljava/lang/Object;
        //   130: astore          13
        //   132: aload           13
        //   134: checkcast       Landroid/support/v7/widget/ActivityChooserModel$HistoricalRecord;
        //   137: astore          13
        //   139: ldc             "historical-record"
        //   141: astore          14
        //   143: aload           8
        //   145: aconst_null    
        //   146: aload           14
        //   148: invokeinterface org/xmlpull/v1/XmlSerializer.startTag:(Ljava/lang/String;Ljava/lang/String;)Lorg/xmlpull/v1/XmlSerializer;
        //   153: pop            
        //   154: ldc             "activity"
        //   156: astore          14
        //   158: aload           13
        //   160: getfield        android/support/v7/widget/ActivityChooserModel$HistoricalRecord.activity:Landroid/content/ComponentName;
        //   163: astore          15
        //   165: aload           15
        //   167: invokevirtual   android/content/ComponentName.flattenToString:()Ljava/lang/String;
        //   170: astore          15
        //   172: aload           8
        //   174: aconst_null    
        //   175: aload           14
        //   177: aload           15
        //   179: invokeinterface org/xmlpull/v1/XmlSerializer.attribute:(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lorg/xmlpull/v1/XmlSerializer;
        //   184: pop            
        //   185: ldc             "time"
        //   187: astore          14
        //   189: aload           13
        //   191: getfield        android/support/v7/widget/ActivityChooserModel$HistoricalRecord.time:J
        //   194: lstore          16
        //   196: lload           16
        //   198: invokestatic    java/lang/String.valueOf:(J)Ljava/lang/String;
        //   201: astore          15
        //   203: aload           8
        //   205: aconst_null    
        //   206: aload           14
        //   208: aload           15
        //   210: invokeinterface org/xmlpull/v1/XmlSerializer.attribute:(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lorg/xmlpull/v1/XmlSerializer;
        //   215: pop            
        //   216: ldc             "weight"
        //   218: astore          14
        //   220: aload           13
        //   222: getfield        android/support/v7/widget/ActivityChooserModel$HistoricalRecord.weight:F
        //   225: fstore          18
        //   227: fload           18
        //   229: invokestatic    java/lang/String.valueOf:(F)Ljava/lang/String;
        //   232: astore          15
        //   234: aload           8
        //   236: aconst_null    
        //   237: aload           14
        //   239: aload           15
        //   241: invokeinterface org/xmlpull/v1/XmlSerializer.attribute:(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lorg/xmlpull/v1/XmlSerializer;
        //   246: pop            
        //   247: ldc             "historical-record"
        //   249: astore          14
        //   251: aload           8
        //   253: aconst_null    
        //   254: aload           14
        //   256: invokeinterface org/xmlpull/v1/XmlSerializer.endTag:(Ljava/lang/String;Ljava/lang/String;)Lorg/xmlpull/v1/XmlSerializer;
        //   261: pop            
        //   262: iload           12
        //   264: iconst_1       
        //   265: iadd           
        //   266: istore          12
        //   268: goto            116
        //   271: ldc             "historical-records"
        //   273: astore_2       
        //   274: aload           8
        //   276: aconst_null    
        //   277: aload_2        
        //   278: invokeinterface org/xmlpull/v1/XmlSerializer.endTag:(Ljava/lang/String;Ljava/lang/String;)Lorg/xmlpull/v1/XmlSerializer;
        //   283: pop            
        //   284: aload           8
        //   286: invokeinterface org/xmlpull/v1/XmlSerializer.endDocument:()V
        //   291: aload_0        
        //   292: getfield        android/support/v7/widget/ActivityChooserModel$PersistHistoryAsyncTask.this$0:Landroid/support/v7/widget/ActivityChooserModel;
        //   295: astore_2       
        //   296: aload_2        
        //   297: iload           4
        //   299: putfield        android/support/v7/widget/ActivityChooserModel.mCanReadHistoricalData:Z
        //   302: aload           6
        //   304: ifnull          590
        //   307: aload           6
        //   309: invokevirtual   java/io/FileOutputStream.close:()V
        //   312: goto            583
        //   315: astore_2       
        //   316: goto            592
        //   319: astore_2       
        //   320: getstatic       android/support/v7/widget/ActivityChooserModel.LOG_TAG:Ljava/lang/String;
        //   323: astore          9
        //   325: new             Ljava/lang/StringBuilder;
        //   328: astore          10
        //   330: aload           10
        //   332: invokespecial   java/lang/StringBuilder.<init>:()V
        //   335: ldc             "Error writing historical record file: "
        //   337: astore          13
        //   339: aload           10
        //   341: aload           13
        //   343: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   346: pop            
        //   347: aload_0        
        //   348: getfield        android/support/v7/widget/ActivityChooserModel$PersistHistoryAsyncTask.this$0:Landroid/support/v7/widget/ActivityChooserModel;
        //   351: astore          13
        //   353: aload           13
        //   355: getfield        android/support/v7/widget/ActivityChooserModel.mHistoryFileName:Ljava/lang/String;
        //   358: astore          13
        //   360: aload           10
        //   362: aload           13
        //   364: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   367: pop            
        //   368: aload           10
        //   370: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   373: astore          10
        //   375: aload           9
        //   377: aload           10
        //   379: aload_2        
        //   380: invokestatic    android/util/Log.e:(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
        //   383: pop            
        //   384: aload_0        
        //   385: getfield        android/support/v7/widget/ActivityChooserModel$PersistHistoryAsyncTask.this$0:Landroid/support/v7/widget/ActivityChooserModel;
        //   388: astore_2       
        //   389: aload_2        
        //   390: iload           4
        //   392: putfield        android/support/v7/widget/ActivityChooserModel.mCanReadHistoricalData:Z
        //   395: aload           6
        //   397: ifnull          590
        //   400: aload           6
        //   402: invokevirtual   java/io/FileOutputStream.close:()V
        //   405: goto            583
        //   408: astore_2       
        //   409: getstatic       android/support/v7/widget/ActivityChooserModel.LOG_TAG:Ljava/lang/String;
        //   412: astore          9
        //   414: new             Ljava/lang/StringBuilder;
        //   417: astore          10
        //   419: aload           10
        //   421: invokespecial   java/lang/StringBuilder.<init>:()V
        //   424: ldc             "Error writing historical record file: "
        //   426: astore          13
        //   428: aload           10
        //   430: aload           13
        //   432: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   435: pop            
        //   436: aload_0        
        //   437: getfield        android/support/v7/widget/ActivityChooserModel$PersistHistoryAsyncTask.this$0:Landroid/support/v7/widget/ActivityChooserModel;
        //   440: astore          13
        //   442: aload           13
        //   444: getfield        android/support/v7/widget/ActivityChooserModel.mHistoryFileName:Ljava/lang/String;
        //   447: astore          13
        //   449: aload           10
        //   451: aload           13
        //   453: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   456: pop            
        //   457: aload           10
        //   459: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   462: astore          10
        //   464: aload           9
        //   466: aload           10
        //   468: aload_2        
        //   469: invokestatic    android/util/Log.e:(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
        //   472: pop            
        //   473: aload_0        
        //   474: getfield        android/support/v7/widget/ActivityChooserModel$PersistHistoryAsyncTask.this$0:Landroid/support/v7/widget/ActivityChooserModel;
        //   477: astore_2       
        //   478: aload_2        
        //   479: iload           4
        //   481: putfield        android/support/v7/widget/ActivityChooserModel.mCanReadHistoricalData:Z
        //   484: aload           6
        //   486: ifnull          590
        //   489: aload           6
        //   491: invokevirtual   java/io/FileOutputStream.close:()V
        //   494: goto            583
        //   497: astore_2       
        //   498: getstatic       android/support/v7/widget/ActivityChooserModel.LOG_TAG:Ljava/lang/String;
        //   501: astore          9
        //   503: new             Ljava/lang/StringBuilder;
        //   506: astore          10
        //   508: aload           10
        //   510: invokespecial   java/lang/StringBuilder.<init>:()V
        //   513: ldc             "Error writing historical record file: "
        //   515: astore          13
        //   517: aload           10
        //   519: aload           13
        //   521: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   524: pop            
        //   525: aload_0        
        //   526: getfield        android/support/v7/widget/ActivityChooserModel$PersistHistoryAsyncTask.this$0:Landroid/support/v7/widget/ActivityChooserModel;
        //   529: astore          13
        //   531: aload           13
        //   533: getfield        android/support/v7/widget/ActivityChooserModel.mHistoryFileName:Ljava/lang/String;
        //   536: astore          13
        //   538: aload           10
        //   540: aload           13
        //   542: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   545: pop            
        //   546: aload           10
        //   548: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   551: astore          10
        //   553: aload           9
        //   555: aload           10
        //   557: aload_2        
        //   558: invokestatic    android/util/Log.e:(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
        //   561: pop            
        //   562: aload_0        
        //   563: getfield        android/support/v7/widget/ActivityChooserModel$PersistHistoryAsyncTask.this$0:Landroid/support/v7/widget/ActivityChooserModel;
        //   566: astore_2       
        //   567: aload_2        
        //   568: iload           4
        //   570: putfield        android/support/v7/widget/ActivityChooserModel.mCanReadHistoricalData:Z
        //   573: aload           6
        //   575: ifnull          590
        //   578: aload           6
        //   580: invokevirtual   java/io/FileOutputStream.close:()V
        //   583: goto            590
        //   586: astore_2       
        //   587: goto            583
        //   590: aconst_null    
        //   591: areturn        
        //   592: aload_0        
        //   593: getfield        android/support/v7/widget/ActivityChooserModel$PersistHistoryAsyncTask.this$0:Landroid/support/v7/widget/ActivityChooserModel;
        //   596: astore          7
        //   598: aload           7
        //   600: iload           4
        //   602: putfield        android/support/v7/widget/ActivityChooserModel.mCanReadHistoricalData:Z
        //   605: aload           6
        //   607: ifnull          623
        //   610: aload           6
        //   612: invokevirtual   java/io/FileOutputStream.close:()V
        //   615: goto            623
        //   618: astore          19
        //   620: goto            623
        //   623: aload_2        
        //   624: athrow         
        //   625: astore_2       
        //   626: getstatic       android/support/v7/widget/ActivityChooserModel.LOG_TAG:Ljava/lang/String;
        //   629: astore          19
        //   631: new             Ljava/lang/StringBuilder;
        //   634: astore          8
        //   636: aload           8
        //   638: invokespecial   java/lang/StringBuilder.<init>:()V
        //   641: aload           8
        //   643: ldc             "Error writing historical record file: "
        //   645: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   648: pop            
        //   649: aload           8
        //   651: aload           5
        //   653: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   656: pop            
        //   657: aload           8
        //   659: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   662: astore          8
        //   664: aload           19
        //   666: aload           8
        //   668: aload_2        
        //   669: invokestatic    android/util/Log.e:(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
        //   672: pop            
        //   673: aconst_null    
        //   674: areturn        
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                                
        //  -----  -----  -----  -----  ------------------------------------
        //  27     31     625    675    Ljava/io/FileNotFoundException;
        //  33     38     625    675    Ljava/io/FileNotFoundException;
        //  44     48     625    675    Ljava/io/FileNotFoundException;
        //  59     65     497    583    Ljava/lang/IllegalArgumentException;
        //  59     65     408    497    Ljava/lang/IllegalStateException;
        //  59     65     319    408    Ljava/io/IOException;
        //  59     65     315    625    Any
        //  69     74     497    583    Ljava/lang/IllegalArgumentException;
        //  69     74     408    497    Ljava/lang/IllegalStateException;
        //  69     74     319    408    Ljava/io/IOException;
        //  69     74     315    625    Any
        //  80     87     497    583    Ljava/lang/IllegalArgumentException;
        //  80     87     408    497    Ljava/lang/IllegalStateException;
        //  80     87     319    408    Ljava/io/IOException;
        //  80     87     315    625    Any
        //  94     102    497    583    Ljava/lang/IllegalArgumentException;
        //  94     102    408    497    Ljava/lang/IllegalStateException;
        //  94     102    319    408    Ljava/io/IOException;
        //  94     102    315    625    Any
        //  102    108    497    583    Ljava/lang/IllegalArgumentException;
        //  102    108    408    497    Ljava/lang/IllegalStateException;
        //  102    108    319    408    Ljava/io/IOException;
        //  102    108    315    625    Any
        //  124    130    497    583    Ljava/lang/IllegalArgumentException;
        //  124    130    408    497    Ljava/lang/IllegalStateException;
        //  124    130    319    408    Ljava/io/IOException;
        //  124    130    315    625    Any
        //  132    137    497    583    Ljava/lang/IllegalArgumentException;
        //  132    137    408    497    Ljava/lang/IllegalStateException;
        //  132    137    319    408    Ljava/io/IOException;
        //  132    137    315    625    Any
        //  146    154    497    583    Ljava/lang/IllegalArgumentException;
        //  146    154    408    497    Ljava/lang/IllegalStateException;
        //  146    154    319    408    Ljava/io/IOException;
        //  146    154    315    625    Any
        //  158    163    497    583    Ljava/lang/IllegalArgumentException;
        //  158    163    408    497    Ljava/lang/IllegalStateException;
        //  158    163    319    408    Ljava/io/IOException;
        //  158    163    315    625    Any
        //  165    170    497    583    Ljava/lang/IllegalArgumentException;
        //  165    170    408    497    Ljava/lang/IllegalStateException;
        //  165    170    319    408    Ljava/io/IOException;
        //  165    170    315    625    Any
        //  177    185    497    583    Ljava/lang/IllegalArgumentException;
        //  177    185    408    497    Ljava/lang/IllegalStateException;
        //  177    185    319    408    Ljava/io/IOException;
        //  177    185    315    625    Any
        //  189    194    497    583    Ljava/lang/IllegalArgumentException;
        //  189    194    408    497    Ljava/lang/IllegalStateException;
        //  189    194    319    408    Ljava/io/IOException;
        //  189    194    315    625    Any
        //  196    201    497    583    Ljava/lang/IllegalArgumentException;
        //  196    201    408    497    Ljava/lang/IllegalStateException;
        //  196    201    319    408    Ljava/io/IOException;
        //  196    201    315    625    Any
        //  208    216    497    583    Ljava/lang/IllegalArgumentException;
        //  208    216    408    497    Ljava/lang/IllegalStateException;
        //  208    216    319    408    Ljava/io/IOException;
        //  208    216    315    625    Any
        //  220    225    497    583    Ljava/lang/IllegalArgumentException;
        //  220    225    408    497    Ljava/lang/IllegalStateException;
        //  220    225    319    408    Ljava/io/IOException;
        //  220    225    315    625    Any
        //  227    232    497    583    Ljava/lang/IllegalArgumentException;
        //  227    232    408    497    Ljava/lang/IllegalStateException;
        //  227    232    319    408    Ljava/io/IOException;
        //  227    232    315    625    Any
        //  239    247    497    583    Ljava/lang/IllegalArgumentException;
        //  239    247    408    497    Ljava/lang/IllegalStateException;
        //  239    247    319    408    Ljava/io/IOException;
        //  239    247    315    625    Any
        //  254    262    497    583    Ljava/lang/IllegalArgumentException;
        //  254    262    408    497    Ljava/lang/IllegalStateException;
        //  254    262    319    408    Ljava/io/IOException;
        //  254    262    315    625    Any
        //  277    284    497    583    Ljava/lang/IllegalArgumentException;
        //  277    284    408    497    Ljava/lang/IllegalStateException;
        //  277    284    319    408    Ljava/io/IOException;
        //  277    284    315    625    Any
        //  284    291    497    583    Ljava/lang/IllegalArgumentException;
        //  284    291    408    497    Ljava/lang/IllegalStateException;
        //  284    291    319    408    Ljava/io/IOException;
        //  284    291    315    625    Any
        //  307    312    586    590    Ljava/io/IOException;
        //  320    323    315    625    Any
        //  325    328    315    625    Any
        //  330    335    315    625    Any
        //  341    347    315    625    Any
        //  347    351    315    625    Any
        //  353    358    315    625    Any
        //  362    368    315    625    Any
        //  368    373    315    625    Any
        //  379    384    315    625    Any
        //  400    405    586    590    Ljava/io/IOException;
        //  409    412    315    625    Any
        //  414    417    315    625    Any
        //  419    424    315    625    Any
        //  430    436    315    625    Any
        //  436    440    315    625    Any
        //  442    447    315    625    Any
        //  451    457    315    625    Any
        //  457    462    315    625    Any
        //  468    473    315    625    Any
        //  489    494    586    590    Ljava/io/IOException;
        //  498    501    315    625    Any
        //  503    506    315    625    Any
        //  508    513    315    625    Any
        //  519    525    315    625    Any
        //  525    529    315    625    Any
        //  531    536    315    625    Any
        //  540    546    315    625    Any
        //  546    551    315    625    Any
        //  557    562    315    625    Any
        //  578    583    586    590    Ljava/io/IOException;
        //  610    615    618    623    Ljava/io/IOException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index: 321, Size: 321
        //     at java.util.ArrayList.rangeCheck(ArrayList.java:657)
        //     at java.util.ArrayList.get(ArrayList.java:433)
        //     at com.strobel.decompiler.ast.AstBuilder.convertToAst(AstBuilder.java:3303)
        //     at com.strobel.decompiler.ast.AstBuilder.convertToAst(AstBuilder.java:3417)
        //     at com.strobel.decompiler.ast.AstBuilder.convertToAst(AstBuilder.java:3417)
        //     at com.strobel.decompiler.ast.AstBuilder.build(AstBuilder.java:113)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:210)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:99)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethodBody(AstBuilder.java:757)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethod(AstBuilder.java:655)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:532)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:499)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:141)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createType(AstBuilder.java:130)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addType(AstBuilder.java:105)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.buildAst(JavaLanguage.java:71)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.decompileType(JavaLanguage.java:59)
        //     at com.strobel.decompiler.DecompilerDriver.decompileType(DecompilerDriver.java:317)
        //     at com.strobel.decompiler.DecompilerDriver.decompileJar(DecompilerDriver.java:238)
        //     at com.strobel.decompiler.DecompilerDriver.main(DecompilerDriver.java:138)
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
}
