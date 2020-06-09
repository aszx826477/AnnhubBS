// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v7.view;

import android.view.Menu;
import android.util.AttributeSet;
import org.xmlpull.v1.XmlPullParser;
import android.content.ContextWrapper;
import android.app.Activity;
import android.content.Context;
import android.view.MenuInflater;

public class SupportMenuInflater extends MenuInflater
{
    static final Class[] ACTION_PROVIDER_CONSTRUCTOR_SIGNATURE;
    static final Class[] ACTION_VIEW_CONSTRUCTOR_SIGNATURE;
    static final String LOG_TAG = "SupportMenuInflater";
    static final int NO_ID = 0;
    private static final String XML_GROUP = "group";
    private static final String XML_ITEM = "item";
    private static final String XML_MENU = "menu";
    final Object[] mActionProviderConstructorArguments;
    final Object[] mActionViewConstructorArguments;
    Context mContext;
    private Object mRealOwner;
    
    static {
        ACTION_VIEW_CONSTRUCTOR_SIGNATURE = new Class[] { Context.class };
        ACTION_PROVIDER_CONSTRUCTOR_SIGNATURE = SupportMenuInflater.ACTION_VIEW_CONSTRUCTOR_SIGNATURE;
    }
    
    public SupportMenuInflater(final Context mContext) {
        super(mContext);
        this.mContext = mContext;
        this.mActionViewConstructorArguments = new Object[] { mContext };
        this.mActionProviderConstructorArguments = this.mActionViewConstructorArguments;
    }
    
    private Object findRealOwner(final Object o) {
        if (o instanceof Activity) {
            return o;
        }
        if (o instanceof ContextWrapper) {
            return this.findRealOwner(((ContextWrapper)o).getBaseContext());
        }
        return o;
    }
    
    private void parseMenu(final XmlPullParser xmlPullParser, final AttributeSet set, final Menu menu) {
        final SupportMenuInflater$MenuState supportMenuInflater$MenuState = new SupportMenuInflater$MenuState(this, menu);
        int i = xmlPullParser.getEventType();
        int n = 0;
        Object o = null;
        String name3;
        while (true) {
            while (i != 2) {
                i = xmlPullParser.next();
                if (i == 1) {
                    int j = 0;
                    while (j == 0) {
                        switch (i) {
                            case 3: {
                                final String name = xmlPullParser.getName();
                                if (n != 0 && name.equals(o)) {
                                    n = 0;
                                    o = null;
                                    break;
                                }
                                if (name.equals("group")) {
                                    supportMenuInflater$MenuState.resetGroup();
                                    break;
                                }
                                if (name.equals("item")) {
                                    if (supportMenuInflater$MenuState.hasAddedItem()) {
                                        break;
                                    }
                                    if (supportMenuInflater$MenuState.itemActionProvider != null && supportMenuInflater$MenuState.itemActionProvider.hasSubMenu()) {
                                        supportMenuInflater$MenuState.addSubMenuItem();
                                        break;
                                    }
                                    supportMenuInflater$MenuState.addItem();
                                    break;
                                }
                                else {
                                    if (name.equals("menu")) {
                                        j = 1;
                                        break;
                                    }
                                    break;
                                }
                                break;
                            }
                            case 2: {
                                if (n != 0) {
                                    break;
                                }
                                final String name2 = xmlPullParser.getName();
                                if (name2.equals("group")) {
                                    supportMenuInflater$MenuState.readGroup(set);
                                    break;
                                }
                                if (name2.equals("item")) {
                                    supportMenuInflater$MenuState.readItem(set);
                                    break;
                                }
                                if (name2.equals("menu")) {
                                    this.parseMenu(xmlPullParser, set, (Menu)supportMenuInflater$MenuState.addSubMenuItem());
                                    break;
                                }
                                n = 1;
                                o = name2;
                                break;
                            }
                            case 1: {
                                throw new RuntimeException("Unexpected end of document");
                            }
                        }
                        i = xmlPullParser.next();
                    }
                    return;
                }
            }
            name3 = xmlPullParser.getName();
            if (name3.equals("menu")) {
                i = xmlPullParser.next();
                continue;
            }
            break;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("Expecting menu, got ");
        sb.append(name3);
        throw new RuntimeException(sb.toString());
    }
    
    Object getRealOwner() {
        if (this.mRealOwner == null) {
            this.mRealOwner = this.findRealOwner(this.mContext);
        }
        return this.mRealOwner;
    }
    
    public void inflate(final int p0, final Menu p1) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     0: aload_2        
        //     1: instanceof      Landroid/support/v4/internal/view/SupportMenu;
        //     4: istore_3       
        //     5: iload_3        
        //     6: ifne            16
        //     9: aload_0        
        //    10: iload_1        
        //    11: aload_2        
        //    12: invokespecial   android/view/MenuInflater.inflate:(ILandroid/view/Menu;)V
        //    15: return         
        //    16: iconst_0       
        //    17: istore_3       
        //    18: aconst_null    
        //    19: astore          4
        //    21: aload_0        
        //    22: getfield        android/support/v7/view/SupportMenuInflater.mContext:Landroid/content/Context;
        //    25: astore          5
        //    27: aload           5
        //    29: invokevirtual   android/content/Context.getResources:()Landroid/content/res/Resources;
        //    32: astore          5
        //    34: aload           5
        //    36: iload_1        
        //    37: invokevirtual   android/content/res/Resources.getLayout:(I)Landroid/content/res/XmlResourceParser;
        //    40: astore          5
        //    42: aload           5
        //    44: astore          4
        //    46: aload           5
        //    48: invokestatic    android/util/Xml.asAttributeSet:(Lorg/xmlpull/v1/XmlPullParser;)Landroid/util/AttributeSet;
        //    51: astore          5
        //    53: aload_0        
        //    54: aload           4
        //    56: aload           5
        //    58: aload_2        
        //    59: checkcast       Landroid/view/Menu;
        //    62: invokespecial   android/support/v7/view/SupportMenuInflater.parseMenu:(Lorg/xmlpull/v1/XmlPullParser;Landroid/util/AttributeSet;Landroid/view/Menu;)V
        //    65: aload           4
        //    67: ifnull          77
        //    70: aload           4
        //    72: invokeinterface android/content/res/XmlResourceParser.close:()V
        //    77: return         
        //    78: astore          5
        //    80: goto            129
        //    83: astore          5
        //    85: new             Landroid/view/InflateException;
        //    88: astore          6
        //    90: ldc             "Error inflating menu XML"
        //    92: astore          7
        //    94: aload           6
        //    96: aload           7
        //    98: aload           5
        //   100: invokespecial   android/view/InflateException.<init>:(Ljava/lang/String;Ljava/lang/Throwable;)V
        //   103: aload           6
        //   105: athrow         
        //   106: astore          5
        //   108: new             Landroid/view/InflateException;
        //   111: astore          6
        //   113: ldc             "Error inflating menu XML"
        //   115: astore          7
        //   117: aload           6
        //   119: aload           7
        //   121: aload           5
        //   123: invokespecial   android/view/InflateException.<init>:(Ljava/lang/String;Ljava/lang/Throwable;)V
        //   126: aload           6
        //   128: athrow         
        //   129: aload           4
        //   131: ifnull          141
        //   134: aload           4
        //   136: invokeinterface android/content/res/XmlResourceParser.close:()V
        //   141: aload           5
        //   143: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                                   
        //  -----  -----  -----  -----  ---------------------------------------
        //  21     25     106    129    Lorg/xmlpull/v1/XmlPullParserException;
        //  21     25     83     106    Ljava/io/IOException;
        //  21     25     78     144    Any
        //  27     32     106    129    Lorg/xmlpull/v1/XmlPullParserException;
        //  27     32     83     106    Ljava/io/IOException;
        //  27     32     78     144    Any
        //  36     40     106    129    Lorg/xmlpull/v1/XmlPullParserException;
        //  36     40     83     106    Ljava/io/IOException;
        //  36     40     78     144    Any
        //  46     51     106    129    Lorg/xmlpull/v1/XmlPullParserException;
        //  46     51     83     106    Ljava/io/IOException;
        //  46     51     78     144    Any
        //  58     65     106    129    Lorg/xmlpull/v1/XmlPullParserException;
        //  58     65     83     106    Ljava/io/IOException;
        //  58     65     78     144    Any
        //  85     88     78     144    Any
        //  98     103    78     144    Any
        //  103    106    78     144    Any
        //  108    111    78     144    Any
        //  121    126    78     144    Any
        //  126    129    78     144    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0077:
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
}
