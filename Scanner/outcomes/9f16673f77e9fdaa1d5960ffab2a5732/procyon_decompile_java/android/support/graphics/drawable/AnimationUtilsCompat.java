// 
// Decompiled by Procyon v0.5.30
// 

package android.support.graphics.drawable;

import android.util.AttributeSet;
import android.view.animation.BounceInterpolator;
import android.view.animation.AnticipateOvershootInterpolator;
import android.view.animation.OvershootInterpolator;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.CycleInterpolator;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.util.Xml;
import android.view.animation.Interpolator;
import org.xmlpull.v1.XmlPullParser;
import android.content.res.Resources$Theme;
import android.content.res.Resources;
import android.content.Context;

public class AnimationUtilsCompat
{
    private static Interpolator createInterpolatorFromXml(final Context context, final Resources resources, final Resources$Theme resources$Theme, final XmlPullParser xmlPullParser) {
        Object o = null;
        final int depth = xmlPullParser.getDepth();
        int next;
        while (((next = xmlPullParser.next()) != 3 || xmlPullParser.getDepth() > depth) && next != 1) {
            if (next != 2) {
                continue;
            }
            final AttributeSet attributeSet = Xml.asAttributeSet(xmlPullParser);
            final String name = xmlPullParser.getName();
            if (name.equals("linearInterpolator")) {
                o = new LinearInterpolator();
            }
            else if (name.equals("accelerateInterpolator")) {
                o = new AccelerateInterpolator(context, attributeSet);
            }
            else if (name.equals("decelerateInterpolator")) {
                o = new DecelerateInterpolator(context, attributeSet);
            }
            else if (name.equals("accelerateDecelerateInterpolator")) {
                o = new AccelerateDecelerateInterpolator();
            }
            else if (name.equals("cycleInterpolator")) {
                o = new CycleInterpolator(context, attributeSet);
            }
            else if (name.equals("anticipateInterpolator")) {
                o = new AnticipateInterpolator(context, attributeSet);
            }
            else if (name.equals("overshootInterpolator")) {
                o = new OvershootInterpolator(context, attributeSet);
            }
            else if (name.equals("anticipateOvershootInterpolator")) {
                o = new AnticipateOvershootInterpolator(context, attributeSet);
            }
            else if (name.equals("bounceInterpolator")) {
                o = new BounceInterpolator();
            }
            else {
                if (!name.equals("pathInterpolator")) {
                    final StringBuilder sb = new StringBuilder();
                    sb.append("Unknown interpolator name: ");
                    sb.append(xmlPullParser.getName());
                    throw new RuntimeException(sb.toString());
                }
                o = new PathInterpolatorCompat(context, attributeSet, xmlPullParser);
            }
        }
        return (Interpolator)o;
    }
    
    public static Interpolator loadInterpolator(final Context p0, final int p1) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     0: getstatic       android/os/Build$VERSION.SDK_INT:I
        //     3: istore_2       
        //     4: bipush          21
        //     6: istore_3       
        //     7: iload_2        
        //     8: iload_3        
        //     9: if_icmplt       18
        //    12: aload_0        
        //    13: iload_1        
        //    14: invokestatic    android/view/animation/AnimationUtils.loadInterpolator:(Landroid/content/Context;I)Landroid/view/animation/Interpolator;
        //    17: areturn        
        //    18: iconst_0       
        //    19: istore_2       
        //    20: aconst_null    
        //    21: astore          4
        //    23: ldc             17563663
        //    25: istore_3       
        //    26: iload_1        
        //    27: iload_3        
        //    28: if_icmpne       69
        //    31: new             Landroid/support/v4/view/animation/FastOutLinearInInterpolator;
        //    34: astore          5
        //    36: aload           5
        //    38: invokespecial   android/support/v4/view/animation/FastOutLinearInInterpolator.<init>:()V
        //    41: iconst_0       
        //    42: ifeq            51
        //    45: aconst_null    
        //    46: invokeinterface android/content/res/XmlResourceParser.close:()V
        //    51: aload           5
        //    53: areturn        
        //    54: astore          5
        //    56: goto            320
        //    59: astore          5
        //    61: goto            188
        //    64: astore          5
        //    66: goto            254
        //    69: ldc             17563661
        //    71: istore_3       
        //    72: iload_1        
        //    73: iload_3        
        //    74: if_icmpne       100
        //    77: new             Landroid/support/v4/view/animation/FastOutSlowInInterpolator;
        //    80: astore          5
        //    82: aload           5
        //    84: invokespecial   android/support/v4/view/animation/FastOutSlowInInterpolator.<init>:()V
        //    87: iconst_0       
        //    88: ifeq            97
        //    91: aconst_null    
        //    92: invokeinterface android/content/res/XmlResourceParser.close:()V
        //    97: aload           5
        //    99: areturn        
        //   100: ldc             17563662
        //   102: istore_3       
        //   103: iload_1        
        //   104: iload_3        
        //   105: if_icmpne       131
        //   108: new             Landroid/support/v4/view/animation/LinearOutSlowInInterpolator;
        //   111: astore          5
        //   113: aload           5
        //   115: invokespecial   android/support/v4/view/animation/LinearOutSlowInInterpolator.<init>:()V
        //   118: iconst_0       
        //   119: ifeq            128
        //   122: aconst_null    
        //   123: invokeinterface android/content/res/XmlResourceParser.close:()V
        //   128: aload           5
        //   130: areturn        
        //   131: aload_0        
        //   132: invokevirtual   android/content/Context.getResources:()Landroid/content/res/Resources;
        //   135: astore          5
        //   137: aload           5
        //   139: iload_1        
        //   140: invokevirtual   android/content/res/Resources.getAnimation:(I)Landroid/content/res/XmlResourceParser;
        //   143: astore          5
        //   145: aload           5
        //   147: astore          4
        //   149: aload_0        
        //   150: invokevirtual   android/content/Context.getResources:()Landroid/content/res/Resources;
        //   153: astore          5
        //   155: aload_0        
        //   156: invokevirtual   android/content/Context.getTheme:()Landroid/content/res/Resources$Theme;
        //   159: astore          6
        //   161: aload_0        
        //   162: aload           5
        //   164: aload           6
        //   166: aload           4
        //   168: invokestatic    android/support/graphics/drawable/AnimationUtilsCompat.createInterpolatorFromXml:(Landroid/content/Context;Landroid/content/res/Resources;Landroid/content/res/Resources$Theme;Lorg/xmlpull/v1/XmlPullParser;)Landroid/view/animation/Interpolator;
        //   171: astore          5
        //   173: aload           4
        //   175: ifnull          185
        //   178: aload           4
        //   180: invokeinterface android/content/res/XmlResourceParser.close:()V
        //   185: aload           5
        //   187: areturn        
        //   188: new             Landroid/content/res/Resources$NotFoundException;
        //   191: astore          6
        //   193: new             Ljava/lang/StringBuilder;
        //   196: astore          7
        //   198: aload           7
        //   200: invokespecial   java/lang/StringBuilder.<init>:()V
        //   203: ldc             "Can't load animation resource ID #0x"
        //   205: astore          8
        //   207: aload           7
        //   209: aload           8
        //   211: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   214: pop            
        //   215: iload_1        
        //   216: invokestatic    java/lang/Integer.toHexString:(I)Ljava/lang/String;
        //   219: astore          8
        //   221: aload           7
        //   223: aload           8
        //   225: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   228: pop            
        //   229: aload           7
        //   231: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   234: astore          7
        //   236: aload           6
        //   238: aload           7
        //   240: invokespecial   android/content/res/Resources$NotFoundException.<init>:(Ljava/lang/String;)V
        //   243: aload           6
        //   245: aload           5
        //   247: invokevirtual   android/content/res/Resources$NotFoundException.initCause:(Ljava/lang/Throwable;)Ljava/lang/Throwable;
        //   250: pop            
        //   251: aload           6
        //   253: athrow         
        //   254: new             Landroid/content/res/Resources$NotFoundException;
        //   257: astore          6
        //   259: new             Ljava/lang/StringBuilder;
        //   262: astore          7
        //   264: aload           7
        //   266: invokespecial   java/lang/StringBuilder.<init>:()V
        //   269: ldc             "Can't load animation resource ID #0x"
        //   271: astore          8
        //   273: aload           7
        //   275: aload           8
        //   277: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   280: pop            
        //   281: iload_1        
        //   282: invokestatic    java/lang/Integer.toHexString:(I)Ljava/lang/String;
        //   285: astore          8
        //   287: aload           7
        //   289: aload           8
        //   291: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   294: pop            
        //   295: aload           7
        //   297: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   300: astore          7
        //   302: aload           6
        //   304: aload           7
        //   306: invokespecial   android/content/res/Resources$NotFoundException.<init>:(Ljava/lang/String;)V
        //   309: aload           6
        //   311: aload           5
        //   313: invokevirtual   android/content/res/Resources$NotFoundException.initCause:(Ljava/lang/Throwable;)Ljava/lang/Throwable;
        //   316: pop            
        //   317: aload           6
        //   319: athrow         
        //   320: aload           4
        //   322: ifnull          332
        //   325: aload           4
        //   327: invokeinterface android/content/res/XmlResourceParser.close:()V
        //   332: aload           5
        //   334: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                                   
        //  -----  -----  -----  -----  ---------------------------------------
        //  31     34     64     320    Lorg/xmlpull/v1/XmlPullParserException;
        //  31     34     59     254    Ljava/io/IOException;
        //  31     34     54     335    Any
        //  36     41     64     320    Lorg/xmlpull/v1/XmlPullParserException;
        //  36     41     59     254    Ljava/io/IOException;
        //  36     41     54     335    Any
        //  77     80     64     320    Lorg/xmlpull/v1/XmlPullParserException;
        //  77     80     59     254    Ljava/io/IOException;
        //  77     80     54     335    Any
        //  82     87     64     320    Lorg/xmlpull/v1/XmlPullParserException;
        //  82     87     59     254    Ljava/io/IOException;
        //  82     87     54     335    Any
        //  108    111    64     320    Lorg/xmlpull/v1/XmlPullParserException;
        //  108    111    59     254    Ljava/io/IOException;
        //  108    111    54     335    Any
        //  113    118    64     320    Lorg/xmlpull/v1/XmlPullParserException;
        //  113    118    59     254    Ljava/io/IOException;
        //  113    118    54     335    Any
        //  131    135    64     320    Lorg/xmlpull/v1/XmlPullParserException;
        //  131    135    59     254    Ljava/io/IOException;
        //  131    135    54     335    Any
        //  139    143    64     320    Lorg/xmlpull/v1/XmlPullParserException;
        //  139    143    59     254    Ljava/io/IOException;
        //  139    143    54     335    Any
        //  149    153    64     320    Lorg/xmlpull/v1/XmlPullParserException;
        //  149    153    59     254    Ljava/io/IOException;
        //  149    153    54     335    Any
        //  155    159    64     320    Lorg/xmlpull/v1/XmlPullParserException;
        //  155    159    59     254    Ljava/io/IOException;
        //  155    159    54     335    Any
        //  166    171    64     320    Lorg/xmlpull/v1/XmlPullParserException;
        //  166    171    59     254    Ljava/io/IOException;
        //  166    171    54     335    Any
        //  188    191    54     335    Any
        //  193    196    54     335    Any
        //  198    203    54     335    Any
        //  209    215    54     335    Any
        //  215    219    54     335    Any
        //  223    229    54     335    Any
        //  229    234    54     335    Any
        //  238    243    54     335    Any
        //  245    251    54     335    Any
        //  251    254    54     335    Any
        //  254    257    54     335    Any
        //  259    262    54     335    Any
        //  264    269    54     335    Any
        //  275    281    54     335    Any
        //  281    285    54     335    Any
        //  289    295    54     335    Any
        //  295    300    54     335    Any
        //  304    309    54     335    Any
        //  311    317    54     335    Any
        //  317    320    54     335    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index: 130, Size: 130
        //     at java.util.ArrayList.rangeCheck(ArrayList.java:657)
        //     at java.util.ArrayList.get(ArrayList.java:433)
        //     at com.strobel.decompiler.ast.AstBuilder.convertToAst(AstBuilder.java:3303)
        //     at com.strobel.decompiler.ast.AstBuilder.convertToAst(AstBuilder.java:3551)
        //     at com.strobel.decompiler.ast.AstBuilder.convertToAst(AstBuilder.java:3417)
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
