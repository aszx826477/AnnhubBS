// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v7.widget;

import android.content.ComponentName;
import java.util.Collections;
import android.os.AsyncTask;
import android.support.v4.os.AsyncTaskCompat;
import java.util.Collection;
import android.content.pm.ResolveInfo;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import android.content.Intent;
import android.content.Context;
import java.util.List;
import java.util.Map;
import android.database.DataSetObservable;

class ActivityChooserModel extends DataSetObservable
{
    static final String ATTRIBUTE_ACTIVITY = "activity";
    static final String ATTRIBUTE_TIME = "time";
    static final String ATTRIBUTE_WEIGHT = "weight";
    static final boolean DEBUG = false;
    private static final int DEFAULT_ACTIVITY_INFLATION = 5;
    private static final float DEFAULT_HISTORICAL_RECORD_WEIGHT = 1.0f;
    public static final String DEFAULT_HISTORY_FILE_NAME = "activity_choser_model_history.xml";
    public static final int DEFAULT_HISTORY_MAX_LENGTH = 50;
    private static final String HISTORY_FILE_EXTENSION = ".xml";
    private static final int INVALID_INDEX = 255;
    static final String LOG_TAG;
    static final String TAG_HISTORICAL_RECORD = "historical-record";
    static final String TAG_HISTORICAL_RECORDS = "historical-records";
    private static final Map sDataModelRegistry;
    private static final Object sRegistryLock;
    private final List mActivities;
    private ActivityChooserModel$OnChooseActivityListener mActivityChoserModelPolicy;
    private ActivityChooserModel$ActivitySorter mActivitySorter;
    boolean mCanReadHistoricalData;
    final Context mContext;
    private final List mHistoricalRecords;
    private boolean mHistoricalRecordsChanged;
    final String mHistoryFileName;
    private int mHistoryMaxSize;
    private final Object mInstanceLock;
    private Intent mIntent;
    private boolean mReadShareHistoryCalled;
    private boolean mReloadActivities;
    
    static {
        LOG_TAG = ActivityChooserModel.class.getSimpleName();
        sRegistryLock = new Object();
        sDataModelRegistry = new HashMap();
    }
    
    private ActivityChooserModel(final Context context, final String mHistoryFileName) {
        this.mInstanceLock = new Object();
        this.mActivities = new ArrayList();
        this.mHistoricalRecords = new ArrayList();
        this.mActivitySorter = new ActivityChooserModel$DefaultSorter(this);
        this.mHistoryMaxSize = 50;
        final boolean b = true;
        this.mCanReadHistoricalData = b;
        this.mReadShareHistoryCalled = false;
        this.mHistoricalRecordsChanged = b;
        this.mReloadActivities = false;
        this.mContext = context.getApplicationContext();
        if (!TextUtils.isEmpty((CharSequence)mHistoryFileName) && !mHistoryFileName.endsWith(".xml")) {
            final StringBuilder sb = new StringBuilder();
            sb.append(mHistoryFileName);
            sb.append(".xml");
            this.mHistoryFileName = sb.toString();
        }
        else {
            this.mHistoryFileName = mHistoryFileName;
        }
    }
    
    private boolean addHistoricalRecord(final ActivityChooserModel$HistoricalRecord activityChooserModel$HistoricalRecord) {
        final boolean add = this.mHistoricalRecords.add(activityChooserModel$HistoricalRecord);
        if (add) {
            this.mHistoricalRecordsChanged = true;
            this.pruneExcessiveHistoricalRecordsIfNeeded();
            this.persistHistoricalDataIfNeeded();
            this.sortActivitiesIfNeeded();
            this.notifyChanged();
        }
        return add;
    }
    
    private void ensureConsistentState() {
        final boolean b = this.loadActivitiesIfNeeded() | this.readHistoricalDataIfNeeded();
        this.pruneExcessiveHistoricalRecordsIfNeeded();
        if (b) {
            this.sortActivitiesIfNeeded();
            this.notifyChanged();
        }
    }
    
    public static ActivityChooserModel get(final Context context, final String s) {
        synchronized (ActivityChooserModel.sRegistryLock) {
            ActivityChooserModel activityChooserModel = ActivityChooserModel.sDataModelRegistry.get(s);
            if (activityChooserModel == null) {
                activityChooserModel = new ActivityChooserModel(context, s);
                ActivityChooserModel.sDataModelRegistry.put(s, activityChooserModel);
            }
            return activityChooserModel;
        }
    }
    
    private boolean loadActivitiesIfNeeded() {
        if (this.mReloadActivities && this.mIntent != null) {
            this.mReloadActivities = false;
            this.mActivities.clear();
            final List queryIntentActivities = this.mContext.getPackageManager().queryIntentActivities(this.mIntent, 0);
            for (int size = queryIntentActivities.size(), i = 0; i < size; ++i) {
                this.mActivities.add(new ActivityChooserModel$ActivityResolveInfo(this, queryIntentActivities.get(i)));
            }
            return true;
        }
        return false;
    }
    
    private void persistHistoricalDataIfNeeded() {
        if (!this.mReadShareHistoryCalled) {
            throw new IllegalStateException("No preceding call to #readHistoricalData");
        }
        if (!this.mHistoricalRecordsChanged) {
            return;
        }
        this.mHistoricalRecordsChanged = false;
        if (!TextUtils.isEmpty((CharSequence)this.mHistoryFileName)) {
            AsyncTaskCompat.executeParallel(new ActivityChooserModel$PersistHistoryAsyncTask(this), new ArrayList(this.mHistoricalRecords), this.mHistoryFileName);
        }
    }
    
    private void pruneExcessiveHistoricalRecordsIfNeeded() {
        final int n = this.mHistoricalRecords.size() - this.mHistoryMaxSize;
        if (n <= 0) {
            return;
        }
        this.mHistoricalRecordsChanged = true;
        for (int i = 0; i < n; ++i) {
            final ActivityChooserModel$HistoricalRecord activityChooserModel$HistoricalRecord = this.mHistoricalRecords.remove(0);
        }
    }
    
    private boolean readHistoricalDataIfNeeded() {
        if (this.mCanReadHistoricalData && this.mHistoricalRecordsChanged && !TextUtils.isEmpty((CharSequence)this.mHistoryFileName)) {
            this.mCanReadHistoricalData = false;
            final boolean mReadShareHistoryCalled = true;
            this.mReadShareHistoryCalled = mReadShareHistoryCalled;
            this.readHistoricalDataImpl();
            return mReadShareHistoryCalled;
        }
        return false;
    }
    
    private void readHistoricalDataImpl() {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     0: aconst_null    
        //     1: astore_1       
        //     2: aload_0        
        //     3: getfield        android/support/v7/widget/ActivityChooserModel.mContext:Landroid/content/Context;
        //     6: astore_2       
        //     7: aload_0        
        //     8: getfield        android/support/v7/widget/ActivityChooserModel.mHistoryFileName:Ljava/lang/String;
        //    11: astore_3       
        //    12: aload_2        
        //    13: aload_3        
        //    14: invokevirtual   android/content/Context.openFileInput:(Ljava/lang/String;)Ljava/io/FileInputStream;
        //    17: astore_2       
        //    18: aload_2        
        //    19: astore_1       
        //    20: invokestatic    android/util/Xml.newPullParser:()Lorg/xmlpull/v1/XmlPullParser;
        //    23: astore_2       
        //    24: ldc             "UTF-8"
        //    26: astore_3       
        //    27: aload_2        
        //    28: aload_1        
        //    29: aload_3        
        //    30: invokeinterface org/xmlpull/v1/XmlPullParser.setInput:(Ljava/io/InputStream;Ljava/lang/String;)V
        //    35: iconst_0       
        //    36: istore          4
        //    38: aconst_null    
        //    39: astore_3       
        //    40: iconst_1       
        //    41: istore          5
        //    43: iload           4
        //    45: iload           5
        //    47: if_icmpeq       75
        //    50: iconst_2       
        //    51: istore          6
        //    53: iload           4
        //    55: iload           6
        //    57: if_icmpeq       75
        //    60: aload_2        
        //    61: invokeinterface org/xmlpull/v1/XmlPullParser.next:()I
        //    66: istore          5
        //    68: iload           5
        //    70: istore          4
        //    72: goto            40
        //    75: ldc             "historical-records"
        //    77: astore          7
        //    79: aload_2        
        //    80: invokeinterface org/xmlpull/v1/XmlPullParser.getName:()Ljava/lang/String;
        //    85: astore          8
        //    87: aload           7
        //    89: aload           8
        //    91: invokevirtual   java/lang/String.equals:(Ljava/lang/Object;)Z
        //    94: istore          6
        //    96: iload           6
        //    98: ifeq            310
        //   101: aload_0        
        //   102: getfield        android/support/v7/widget/ActivityChooserModel.mHistoricalRecords:Ljava/util/List;
        //   105: astore          7
        //   107: aload           7
        //   109: invokeinterface java/util/List.clear:()V
        //   114: aload_2        
        //   115: invokeinterface org/xmlpull/v1/XmlPullParser.next:()I
        //   120: istore          9
        //   122: iload           9
        //   124: istore          4
        //   126: iload           9
        //   128: iload           5
        //   130: if_icmpne       144
        //   133: aload_1        
        //   134: ifnull          474
        //   137: aload_1        
        //   138: invokevirtual   java/io/FileInputStream.close:()V
        //   141: goto            467
        //   144: iconst_3       
        //   145: istore          9
        //   147: iload           4
        //   149: iload           9
        //   151: if_icmpeq       307
        //   154: iconst_4       
        //   155: istore          9
        //   157: iload           4
        //   159: iload           9
        //   161: if_icmpne       167
        //   164: goto            114
        //   167: aload_2        
        //   168: invokeinterface org/xmlpull/v1/XmlPullParser.getName:()Ljava/lang/String;
        //   173: astore          8
        //   175: ldc             "historical-record"
        //   177: astore          10
        //   179: aload           10
        //   181: aload           8
        //   183: invokevirtual   java/lang/String.equals:(Ljava/lang/Object;)Z
        //   186: istore          11
        //   188: iload           11
        //   190: ifeq            287
        //   193: ldc             "activity"
        //   195: astore          10
        //   197: fconst_0       
        //   198: fstore          12
        //   200: aconst_null    
        //   201: astore          13
        //   203: aload_2        
        //   204: aconst_null    
        //   205: aload           10
        //   207: invokeinterface org/xmlpull/v1/XmlPullParser.getAttributeValue:(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
        //   212: astore          10
        //   214: ldc             "time"
        //   216: astore          14
        //   218: aload_2        
        //   219: aconst_null    
        //   220: aload           14
        //   222: invokeinterface org/xmlpull/v1/XmlPullParser.getAttributeValue:(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
        //   227: astore          14
        //   229: aload           14
        //   231: invokestatic    java/lang/Long.parseLong:(Ljava/lang/String;)J
        //   234: lstore          15
        //   236: ldc             "weight"
        //   238: astore          17
        //   240: aload_2        
        //   241: aconst_null    
        //   242: aload           17
        //   244: invokeinterface org/xmlpull/v1/XmlPullParser.getAttributeValue:(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
        //   249: astore          13
        //   251: aload           13
        //   253: invokestatic    java/lang/Float.parseFloat:(Ljava/lang/String;)F
        //   256: fstore          12
        //   258: new             Landroid/support/v7/widget/ActivityChooserModel$HistoricalRecord;
        //   261: astore          17
        //   263: aload           17
        //   265: aload           10
        //   267: lload           15
        //   269: fload           12
        //   271: invokespecial   android/support/v7/widget/ActivityChooserModel$HistoricalRecord.<init>:(Ljava/lang/String;JF)V
        //   274: aload           7
        //   276: aload           17
        //   278: invokeinterface java/util/List.add:(Ljava/lang/Object;)Z
        //   283: pop            
        //   284: goto            114
        //   287: new             Lorg/xmlpull/v1/XmlPullParserException;
        //   290: astore          18
        //   292: ldc_w           "Share records file not well-formed."
        //   295: astore          10
        //   297: aload           18
        //   299: aload           10
        //   301: invokespecial   org/xmlpull/v1/XmlPullParserException.<init>:(Ljava/lang/String;)V
        //   304: aload           18
        //   306: athrow         
        //   307: goto            114
        //   310: new             Lorg/xmlpull/v1/XmlPullParserException;
        //   313: astore          18
        //   315: ldc_w           "Share records file does not start with historical-records tag."
        //   318: astore          7
        //   320: aload           18
        //   322: aload           7
        //   324: invokespecial   org/xmlpull/v1/XmlPullParserException.<init>:(Ljava/lang/String;)V
        //   327: aload           18
        //   329: athrow         
        //   330: astore_2       
        //   331: goto            475
        //   334: astore_2       
        //   335: getstatic       android/support/v7/widget/ActivityChooserModel.LOG_TAG:Ljava/lang/String;
        //   338: astore_3       
        //   339: new             Ljava/lang/StringBuilder;
        //   342: astore          18
        //   344: aload           18
        //   346: invokespecial   java/lang/StringBuilder.<init>:()V
        //   349: ldc_w           "Error reading historical recrod file: "
        //   352: astore          7
        //   354: aload           18
        //   356: aload           7
        //   358: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   361: pop            
        //   362: aload_0        
        //   363: getfield        android/support/v7/widget/ActivityChooserModel.mHistoryFileName:Ljava/lang/String;
        //   366: astore          7
        //   368: aload           18
        //   370: aload           7
        //   372: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   375: pop            
        //   376: aload           18
        //   378: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   381: astore          18
        //   383: aload_3        
        //   384: aload           18
        //   386: aload_2        
        //   387: invokestatic    android/util/Log.e:(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
        //   390: pop            
        //   391: aload_1        
        //   392: ifnull          474
        //   395: aload_1        
        //   396: invokevirtual   java/io/FileInputStream.close:()V
        //   399: goto            467
        //   402: astore_2       
        //   403: getstatic       android/support/v7/widget/ActivityChooserModel.LOG_TAG:Ljava/lang/String;
        //   406: astore_3       
        //   407: new             Ljava/lang/StringBuilder;
        //   410: astore          18
        //   412: aload           18
        //   414: invokespecial   java/lang/StringBuilder.<init>:()V
        //   417: ldc_w           "Error reading historical recrod file: "
        //   420: astore          7
        //   422: aload           18
        //   424: aload           7
        //   426: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   429: pop            
        //   430: aload_0        
        //   431: getfield        android/support/v7/widget/ActivityChooserModel.mHistoryFileName:Ljava/lang/String;
        //   434: astore          7
        //   436: aload           18
        //   438: aload           7
        //   440: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   443: pop            
        //   444: aload           18
        //   446: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   449: astore          18
        //   451: aload_3        
        //   452: aload           18
        //   454: aload_2        
        //   455: invokestatic    android/util/Log.e:(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
        //   458: pop            
        //   459: aload_1        
        //   460: ifnull          474
        //   463: aload_1        
        //   464: invokevirtual   java/io/FileInputStream.close:()V
        //   467: goto            474
        //   470: astore_2       
        //   471: goto            467
        //   474: return         
        //   475: aload_1        
        //   476: ifnull          490
        //   479: aload_1        
        //   480: invokevirtual   java/io/FileInputStream.close:()V
        //   483: goto            490
        //   486: astore_3       
        //   487: goto            490
        //   490: aload_2        
        //   491: athrow         
        //   492: astore_2       
        //   493: return         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                                   
        //  -----  -----  -----  -----  ---------------------------------------
        //  2      6      492    494    Ljava/io/FileNotFoundException;
        //  7      11     492    494    Ljava/io/FileNotFoundException;
        //  13     17     492    494    Ljava/io/FileNotFoundException;
        //  20     23     402    467    Lorg/xmlpull/v1/XmlPullParserException;
        //  20     23     334    402    Ljava/io/IOException;
        //  20     23     330    492    Any
        //  29     35     402    467    Lorg/xmlpull/v1/XmlPullParserException;
        //  29     35     334    402    Ljava/io/IOException;
        //  29     35     330    492    Any
        //  60     66     402    467    Lorg/xmlpull/v1/XmlPullParserException;
        //  60     66     334    402    Ljava/io/IOException;
        //  60     66     330    492    Any
        //  79     85     402    467    Lorg/xmlpull/v1/XmlPullParserException;
        //  79     85     334    402    Ljava/io/IOException;
        //  79     85     330    492    Any
        //  89     94     402    467    Lorg/xmlpull/v1/XmlPullParserException;
        //  89     94     334    402    Ljava/io/IOException;
        //  89     94     330    492    Any
        //  101    105    402    467    Lorg/xmlpull/v1/XmlPullParserException;
        //  101    105    334    402    Ljava/io/IOException;
        //  101    105    330    492    Any
        //  107    114    402    467    Lorg/xmlpull/v1/XmlPullParserException;
        //  107    114    334    402    Ljava/io/IOException;
        //  107    114    330    492    Any
        //  114    120    402    467    Lorg/xmlpull/v1/XmlPullParserException;
        //  114    120    334    402    Ljava/io/IOException;
        //  114    120    330    492    Any
        //  137    141    470    474    Ljava/io/IOException;
        //  167    173    402    467    Lorg/xmlpull/v1/XmlPullParserException;
        //  167    173    334    402    Ljava/io/IOException;
        //  167    173    330    492    Any
        //  181    186    402    467    Lorg/xmlpull/v1/XmlPullParserException;
        //  181    186    334    402    Ljava/io/IOException;
        //  181    186    330    492    Any
        //  205    212    402    467    Lorg/xmlpull/v1/XmlPullParserException;
        //  205    212    334    402    Ljava/io/IOException;
        //  205    212    330    492    Any
        //  220    227    402    467    Lorg/xmlpull/v1/XmlPullParserException;
        //  220    227    334    402    Ljava/io/IOException;
        //  220    227    330    492    Any
        //  229    234    402    467    Lorg/xmlpull/v1/XmlPullParserException;
        //  229    234    334    402    Ljava/io/IOException;
        //  229    234    330    492    Any
        //  242    249    402    467    Lorg/xmlpull/v1/XmlPullParserException;
        //  242    249    334    402    Ljava/io/IOException;
        //  242    249    330    492    Any
        //  251    256    402    467    Lorg/xmlpull/v1/XmlPullParserException;
        //  251    256    334    402    Ljava/io/IOException;
        //  251    256    330    492    Any
        //  258    261    402    467    Lorg/xmlpull/v1/XmlPullParserException;
        //  258    261    334    402    Ljava/io/IOException;
        //  258    261    330    492    Any
        //  269    274    402    467    Lorg/xmlpull/v1/XmlPullParserException;
        //  269    274    334    402    Ljava/io/IOException;
        //  269    274    330    492    Any
        //  276    284    402    467    Lorg/xmlpull/v1/XmlPullParserException;
        //  276    284    334    402    Ljava/io/IOException;
        //  276    284    330    492    Any
        //  287    290    402    467    Lorg/xmlpull/v1/XmlPullParserException;
        //  287    290    334    402    Ljava/io/IOException;
        //  287    290    330    492    Any
        //  299    304    402    467    Lorg/xmlpull/v1/XmlPullParserException;
        //  299    304    334    402    Ljava/io/IOException;
        //  299    304    330    492    Any
        //  304    307    402    467    Lorg/xmlpull/v1/XmlPullParserException;
        //  304    307    334    402    Ljava/io/IOException;
        //  304    307    330    492    Any
        //  310    313    402    467    Lorg/xmlpull/v1/XmlPullParserException;
        //  310    313    334    402    Ljava/io/IOException;
        //  310    313    330    492    Any
        //  322    327    402    467    Lorg/xmlpull/v1/XmlPullParserException;
        //  322    327    334    402    Ljava/io/IOException;
        //  322    327    330    492    Any
        //  327    330    402    467    Lorg/xmlpull/v1/XmlPullParserException;
        //  327    330    334    402    Ljava/io/IOException;
        //  327    330    330    492    Any
        //  335    338    330    492    Any
        //  339    342    330    492    Any
        //  344    349    330    492    Any
        //  356    362    330    492    Any
        //  362    366    330    492    Any
        //  370    376    330    492    Any
        //  376    381    330    492    Any
        //  386    391    330    492    Any
        //  395    399    470    474    Ljava/io/IOException;
        //  403    406    330    492    Any
        //  407    410    330    492    Any
        //  412    417    330    492    Any
        //  424    430    330    492    Any
        //  430    434    330    492    Any
        //  438    444    330    492    Any
        //  444    449    330    492    Any
        //  454    459    330    492    Any
        //  463    467    470    474    Ljava/io/IOException;
        //  479    483    486    490    Ljava/io/IOException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0144:
        //     at com.strobel.decompiler.ast.Error.expressionLinkedFromMultipleLocations(Error.java:27)
        //     at com.strobel.decompiler.ast.AstOptimizer.mergeDisparateObjectInitializations(AstOptimizer.java:2592)
        //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:235)
        //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:42)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:214)
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
    
    private boolean sortActivitiesIfNeeded() {
        if (this.mActivitySorter != null && this.mIntent != null && (!this.mActivities.isEmpty() && !this.mHistoricalRecords.isEmpty())) {
            this.mActivitySorter.sort(this.mIntent, this.mActivities, Collections.unmodifiableList((List<?>)this.mHistoricalRecords));
            return true;
        }
        return false;
    }
    
    public Intent chooseActivity(final int n) {
        synchronized (this.mInstanceLock) {
            if (this.mIntent == null) {
                return null;
            }
            this.ensureConsistentState();
            final ActivityChooserModel$ActivityResolveInfo activityChooserModel$ActivityResolveInfo = this.mActivities.get(n);
            final ComponentName component = new ComponentName(activityChooserModel$ActivityResolveInfo.resolveInfo.activityInfo.packageName, activityChooserModel$ActivityResolveInfo.resolveInfo.activityInfo.name);
            final Intent intent = new Intent(this.mIntent);
            intent.setComponent(component);
            if (this.mActivityChoserModelPolicy != null && this.mActivityChoserModelPolicy.onChooseActivity(this, new Intent(intent))) {
                return null;
            }
            this.addHistoricalRecord(new ActivityChooserModel$HistoricalRecord(component, System.currentTimeMillis(), 1.0f));
            return intent;
        }
    }
    
    public ResolveInfo getActivity(final int n) {
        synchronized (this.mInstanceLock) {
            this.ensureConsistentState();
            return this.mActivities.get(n).resolveInfo;
        }
    }
    
    public int getActivityCount() {
        synchronized (this.mInstanceLock) {
            this.ensureConsistentState();
            return this.mActivities.size();
        }
    }
    
    public int getActivityIndex(final ResolveInfo resolveInfo) {
        synchronized (this.mInstanceLock) {
            this.ensureConsistentState();
            final List mActivities = this.mActivities;
            for (int size = mActivities.size(), i = 0; i < size; ++i) {
                if (mActivities.get(i).resolveInfo == resolveInfo) {
                    return i;
                }
            }
            return -1;
        }
    }
    
    public ResolveInfo getDefaultActivity() {
        synchronized (this.mInstanceLock) {
            this.ensureConsistentState();
            if (!this.mActivities.isEmpty()) {
                return this.mActivities.get(0).resolveInfo;
            }
            return null;
        }
    }
    
    public int getHistoryMaxSize() {
        synchronized (this.mInstanceLock) {
            return this.mHistoryMaxSize;
        }
    }
    
    public int getHistorySize() {
        synchronized (this.mInstanceLock) {
            this.ensureConsistentState();
            return this.mHistoricalRecords.size();
        }
    }
    
    public Intent getIntent() {
        synchronized (this.mInstanceLock) {
            return this.mIntent;
        }
    }
    
    public void setActivitySorter(final ActivityChooserModel$ActivitySorter mActivitySorter) {
        synchronized (this.mInstanceLock) {
            if (this.mActivitySorter == mActivitySorter) {
                return;
            }
            this.mActivitySorter = mActivitySorter;
            if (this.sortActivitiesIfNeeded()) {
                this.notifyChanged();
            }
        }
    }
    
    public void setDefaultActivity(final int n) {
        synchronized (this.mInstanceLock) {
            this.ensureConsistentState();
            final ActivityChooserModel$ActivityResolveInfo activityChooserModel$ActivityResolveInfo = this.mActivities.get(n);
            final ActivityChooserModel$ActivityResolveInfo activityChooserModel$ActivityResolveInfo2 = this.mActivities.get(0);
            float n2;
            if (activityChooserModel$ActivityResolveInfo2 != null) {
                n2 = activityChooserModel$ActivityResolveInfo2.weight - activityChooserModel$ActivityResolveInfo.weight + 5.0f;
            }
            else {
                n2 = 1.0f;
            }
            this.addHistoricalRecord(new ActivityChooserModel$HistoricalRecord(new ComponentName(activityChooserModel$ActivityResolveInfo.resolveInfo.activityInfo.packageName, activityChooserModel$ActivityResolveInfo.resolveInfo.activityInfo.name), System.currentTimeMillis(), n2));
        }
    }
    
    public void setHistoryMaxSize(final int mHistoryMaxSize) {
        synchronized (this.mInstanceLock) {
            if (this.mHistoryMaxSize == mHistoryMaxSize) {
                return;
            }
            this.mHistoryMaxSize = mHistoryMaxSize;
            this.pruneExcessiveHistoricalRecordsIfNeeded();
            if (this.sortActivitiesIfNeeded()) {
                this.notifyChanged();
            }
        }
    }
    
    public void setIntent(final Intent mIntent) {
        synchronized (this.mInstanceLock) {
            if (this.mIntent == mIntent) {
                return;
            }
            this.mIntent = mIntent;
            this.mReloadActivities = true;
            this.ensureConsistentState();
        }
    }
    
    public void setOnChooseActivityListener(final ActivityChooserModel$OnChooseActivityListener mActivityChoserModelPolicy) {
        synchronized (this.mInstanceLock) {
            this.mActivityChoserModelPolicy = mActivityChoserModelPolicy;
        }
    }
}
