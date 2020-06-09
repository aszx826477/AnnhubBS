// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v7.widget;

import android.support.v7.appcompat.R$id;
import android.net.Uri$Builder;
import android.view.ViewGroup;
import java.util.List;
import android.content.res.Resources;
import java.io.FileNotFoundException;
import android.view.View;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.TextView;
import android.widget.ImageView;
import android.content.res.Resources$NotFoundException;
import android.support.v4.content.ContextCompat;
import android.net.Uri;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager$NameNotFoundException;
import android.util.Log;
import android.content.ComponentName;
import android.text.style.TextAppearanceSpan;
import android.text.SpannableString;
import android.support.v7.appcompat.R$attr;
import android.util.TypedValue;
import android.graphics.drawable.Drawable$ConstantState;
import android.graphics.drawable.Drawable;
import android.database.Cursor;
import android.content.res.ColorStateList;
import android.app.SearchableInfo;
import android.app.SearchManager;
import android.content.Context;
import java.util.WeakHashMap;
import android.view.View$OnClickListener;
import android.support.v4.widget.ResourceCursorAdapter;

class SuggestionsAdapter extends ResourceCursorAdapter implements View$OnClickListener
{
    private static final boolean DBG = false;
    static final int INVALID_INDEX = 255;
    private static final String LOG_TAG = "SuggestionsAdapter";
    private static final int QUERY_LIMIT = 50;
    static final int REFINE_ALL = 2;
    static final int REFINE_BY_ENTRY = 1;
    static final int REFINE_NONE;
    private boolean mClosed;
    private final int mCommitIconResId;
    private int mFlagsCol;
    private int mIconName1Col;
    private int mIconName2Col;
    private final WeakHashMap mOutsideDrawablesCache;
    private final Context mProviderContext;
    private int mQueryRefinement;
    private final SearchManager mSearchManager;
    private final SearchView mSearchView;
    private final SearchableInfo mSearchable;
    private int mText1Col;
    private int mText2Col;
    private int mText2UrlCol;
    private ColorStateList mUrlColor;
    
    public SuggestionsAdapter(final Context mProviderContext, final SearchView mSearchView, final SearchableInfo mSearchable, final WeakHashMap mOutsideDrawablesCache) {
        final int suggestionRowLayout = mSearchView.getSuggestionRowLayout();
        final boolean mQueryRefinement = true;
        super(mProviderContext, suggestionRowLayout, null, mQueryRefinement);
        this.mClosed = false;
        this.mQueryRefinement = (mQueryRefinement ? 1 : 0);
        final int n = -1;
        this.mText1Col = n;
        this.mText2Col = n;
        this.mText2UrlCol = n;
        this.mIconName1Col = n;
        this.mIconName2Col = n;
        this.mFlagsCol = n;
        this.mSearchManager = (SearchManager)this.mContext.getSystemService("search");
        this.mSearchView = mSearchView;
        this.mSearchable = mSearchable;
        this.mCommitIconResId = mSearchView.getSuggestionCommitIconResId();
        this.mProviderContext = mProviderContext;
        this.mOutsideDrawablesCache = mOutsideDrawablesCache;
    }
    
    private Drawable checkIconCache(final String s) {
        final Drawable$ConstantState drawable$ConstantState = this.mOutsideDrawablesCache.get(s);
        if (drawable$ConstantState == null) {
            return null;
        }
        return drawable$ConstantState.newDrawable();
    }
    
    private CharSequence formatUrl(final CharSequence charSequence) {
        if (this.mUrlColor == null) {
            final TypedValue typedValue = new TypedValue();
            this.mContext.getTheme().resolveAttribute(R$attr.textColorSearchUrl, typedValue, true);
            this.mUrlColor = this.mContext.getResources().getColorStateList(typedValue.resourceId);
        }
        final SpannableString spannableString = new SpannableString(charSequence);
        spannableString.setSpan((Object)new TextAppearanceSpan((String)null, 0, 0, this.mUrlColor, (ColorStateList)null), 0, charSequence.length(), 33);
        return (CharSequence)spannableString;
    }
    
    private Drawable getActivityIcon(final ComponentName componentName) {
        final PackageManager packageManager = this.mContext.getPackageManager();
        final int n = 128;
        final PackageManager packageManager2 = packageManager;
        try {
            final ActivityInfo activityInfo = packageManager2.getActivityInfo(componentName, n);
            final int iconResource = activityInfo.getIconResource();
            if (iconResource == 0) {
                return null;
            }
            final Drawable drawable = packageManager.getDrawable(componentName.getPackageName(), iconResource, activityInfo.applicationInfo);
            if (drawable == null) {
                final StringBuilder sb = new StringBuilder();
                sb.append("Invalid icon resource ");
                sb.append(iconResource);
                sb.append(" for ");
                sb.append(componentName.flattenToShortString());
                Log.w("SuggestionsAdapter", sb.toString());
                return null;
            }
            return drawable;
        }
        catch (PackageManager$NameNotFoundException ex) {
            Log.w("SuggestionsAdapter", ex.toString());
            return null;
        }
    }
    
    private Drawable getActivityIconWithCache(final ComponentName componentName) {
        final String flattenToShortString = componentName.flattenToShortString();
        final boolean containsKey = this.mOutsideDrawablesCache.containsKey(flattenToShortString);
        Object o = null;
        if (containsKey) {
            final Drawable$ConstantState drawable$ConstantState = this.mOutsideDrawablesCache.get(flattenToShortString);
            if (drawable$ConstantState != null) {
                o = drawable$ConstantState.newDrawable(this.mProviderContext.getResources());
            }
            return (Drawable)o;
        }
        final Drawable activityIcon = this.getActivityIcon(componentName);
        if (activityIcon != null) {
            o = activityIcon.getConstantState();
        }
        this.mOutsideDrawablesCache.put(flattenToShortString, o);
        return activityIcon;
    }
    
    public static String getColumnString(final Cursor cursor, final String s) {
        return getStringOrNull(cursor, cursor.getColumnIndex(s));
    }
    
    private Drawable getDefaultIcon1(final Cursor cursor) {
        final Drawable activityIconWithCache = this.getActivityIconWithCache(this.mSearchable.getSearchActivity());
        if (activityIconWithCache != null) {
            return activityIconWithCache;
        }
        return this.mContext.getPackageManager().getDefaultActivityIcon();
    }
    
    private Drawable getDrawable(final Uri p0) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     0: aload_1        
        //     1: invokevirtual   android/net/Uri.getScheme:()Ljava/lang/String;
        //     4: astore_2       
        //     5: ldc_w           "android.resource"
        //     8: astore_3       
        //     9: aload_3        
        //    10: aload_2        
        //    11: invokevirtual   java/lang/String.equals:(Ljava/lang/Object;)Z
        //    14: istore          4
        //    16: iload           4
        //    18: ifeq            80
        //    21: aload_0        
        //    22: aload_1        
        //    23: invokevirtual   android/support/v7/widget/SuggestionsAdapter.getDrawableFromResourceUri:(Landroid/net/Uri;)Landroid/graphics/drawable/Drawable;
        //    26: areturn        
        //    27: astore_3       
        //    28: new             Ljava/io/FileNotFoundException;
        //    31: astore          5
        //    33: new             Ljava/lang/StringBuilder;
        //    36: astore          6
        //    38: aload           6
        //    40: invokespecial   java/lang/StringBuilder.<init>:()V
        //    43: ldc_w           "Resource does not exist: "
        //    46: astore          7
        //    48: aload           6
        //    50: aload           7
        //    52: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //    55: pop            
        //    56: aload           6
        //    58: aload_1        
        //    59: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/Object;)Ljava/lang/StringBuilder;
        //    62: pop            
        //    63: aload           6
        //    65: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //    68: astore          6
        //    70: aload           5
        //    72: aload           6
        //    74: invokespecial   java/io/FileNotFoundException.<init>:(Ljava/lang/String;)V
        //    77: aload           5
        //    79: athrow         
        //    80: aload_0        
        //    81: getfield        android/support/v7/widget/SuggestionsAdapter.mProviderContext:Landroid/content/Context;
        //    84: astore_3       
        //    85: aload_3        
        //    86: invokevirtual   android/content/Context.getContentResolver:()Landroid/content/ContentResolver;
        //    89: astore_3       
        //    90: aload_3        
        //    91: aload_1        
        //    92: invokevirtual   android/content/ContentResolver.openInputStream:(Landroid/net/Uri;)Ljava/io/InputStream;
        //    95: astore_3       
        //    96: aload_3        
        //    97: ifnull          235
        //   100: aload_3        
        //   101: aconst_null    
        //   102: invokestatic    android/graphics/drawable/Drawable.createFromStream:(Ljava/io/InputStream;Ljava/lang/String;)Landroid/graphics/drawable/Drawable;
        //   105: astore          5
        //   107: aload_3        
        //   108: invokevirtual   java/io/InputStream.close:()V
        //   111: goto            167
        //   114: astore          6
        //   116: ldc             "SuggestionsAdapter"
        //   118: astore          7
        //   120: new             Ljava/lang/StringBuilder;
        //   123: astore          8
        //   125: aload           8
        //   127: invokespecial   java/lang/StringBuilder.<init>:()V
        //   130: ldc_w           "Error closing icon stream for "
        //   133: astore          9
        //   135: aload           8
        //   137: aload           9
        //   139: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   142: pop            
        //   143: aload           8
        //   145: aload_1        
        //   146: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/Object;)Ljava/lang/StringBuilder;
        //   149: pop            
        //   150: aload           8
        //   152: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   155: astore          8
        //   157: aload           7
        //   159: aload           8
        //   161: aload           6
        //   163: invokestatic    android/util/Log.e:(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
        //   166: pop            
        //   167: aload           5
        //   169: areturn        
        //   170: astore          5
        //   172: aload_3        
        //   173: invokevirtual   java/io/InputStream.close:()V
        //   176: goto            232
        //   179: astore          6
        //   181: ldc             "SuggestionsAdapter"
        //   183: astore          7
        //   185: new             Ljava/lang/StringBuilder;
        //   188: astore          8
        //   190: aload           8
        //   192: invokespecial   java/lang/StringBuilder.<init>:()V
        //   195: ldc_w           "Error closing icon stream for "
        //   198: astore          9
        //   200: aload           8
        //   202: aload           9
        //   204: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   207: pop            
        //   208: aload           8
        //   210: aload_1        
        //   211: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/Object;)Ljava/lang/StringBuilder;
        //   214: pop            
        //   215: aload           8
        //   217: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   220: astore          8
        //   222: aload           7
        //   224: aload           8
        //   226: aload           6
        //   228: invokestatic    android/util/Log.e:(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
        //   231: pop            
        //   232: aload           5
        //   234: athrow         
        //   235: new             Ljava/io/FileNotFoundException;
        //   238: astore          5
        //   240: new             Ljava/lang/StringBuilder;
        //   243: astore          6
        //   245: aload           6
        //   247: invokespecial   java/lang/StringBuilder.<init>:()V
        //   250: ldc_w           "Failed to open "
        //   253: astore          7
        //   255: aload           6
        //   257: aload           7
        //   259: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   262: pop            
        //   263: aload           6
        //   265: aload_1        
        //   266: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/Object;)Ljava/lang/StringBuilder;
        //   269: pop            
        //   270: aload           6
        //   272: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   275: astore          6
        //   277: aload           5
        //   279: aload           6
        //   281: invokespecial   java/io/FileNotFoundException.<init>:(Ljava/lang/String;)V
        //   284: aload           5
        //   286: athrow         
        //   287: astore_2       
        //   288: new             Ljava/lang/StringBuilder;
        //   291: astore          5
        //   293: aload           5
        //   295: invokespecial   java/lang/StringBuilder.<init>:()V
        //   298: aload           5
        //   300: ldc_w           "Icon not found: "
        //   303: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   306: pop            
        //   307: aload           5
        //   309: aload_1        
        //   310: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/Object;)Ljava/lang/StringBuilder;
        //   313: pop            
        //   314: aload           5
        //   316: ldc_w           ", "
        //   319: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   322: pop            
        //   323: aload_2        
        //   324: invokevirtual   java/io/FileNotFoundException.getMessage:()Ljava/lang/String;
        //   327: astore          6
        //   329: aload           5
        //   331: aload           6
        //   333: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   336: pop            
        //   337: aload           5
        //   339: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   342: astore          5
        //   344: ldc             "SuggestionsAdapter"
        //   346: aload           5
        //   348: invokestatic    android/util/Log.w:(Ljava/lang/String;Ljava/lang/String;)I
        //   351: pop            
        //   352: aconst_null    
        //   353: areturn        
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                                             
        //  -----  -----  -----  -----  -------------------------------------------------
        //  0      4      287    354    Ljava/io/FileNotFoundException;
        //  10     14     287    354    Ljava/io/FileNotFoundException;
        //  22     26     27     80     Landroid/content/res/Resources$NotFoundException;
        //  22     26     287    354    Ljava/io/FileNotFoundException;
        //  28     31     287    354    Ljava/io/FileNotFoundException;
        //  33     36     287    354    Ljava/io/FileNotFoundException;
        //  38     43     287    354    Ljava/io/FileNotFoundException;
        //  50     56     287    354    Ljava/io/FileNotFoundException;
        //  58     63     287    354    Ljava/io/FileNotFoundException;
        //  63     68     287    354    Ljava/io/FileNotFoundException;
        //  72     77     287    354    Ljava/io/FileNotFoundException;
        //  77     80     287    354    Ljava/io/FileNotFoundException;
        //  80     84     287    354    Ljava/io/FileNotFoundException;
        //  85     89     287    354    Ljava/io/FileNotFoundException;
        //  91     95     287    354    Ljava/io/FileNotFoundException;
        //  101    105    170    235    Any
        //  107    111    114    167    Ljava/io/IOException;
        //  107    111    287    354    Ljava/io/FileNotFoundException;
        //  120    123    287    354    Ljava/io/FileNotFoundException;
        //  125    130    287    354    Ljava/io/FileNotFoundException;
        //  137    143    287    354    Ljava/io/FileNotFoundException;
        //  145    150    287    354    Ljava/io/FileNotFoundException;
        //  150    155    287    354    Ljava/io/FileNotFoundException;
        //  161    167    287    354    Ljava/io/FileNotFoundException;
        //  172    176    179    232    Ljava/io/IOException;
        //  172    176    287    354    Ljava/io/FileNotFoundException;
        //  185    188    287    354    Ljava/io/FileNotFoundException;
        //  190    195    287    354    Ljava/io/FileNotFoundException;
        //  202    208    287    354    Ljava/io/FileNotFoundException;
        //  210    215    287    354    Ljava/io/FileNotFoundException;
        //  215    220    287    354    Ljava/io/FileNotFoundException;
        //  226    232    287    354    Ljava/io/FileNotFoundException;
        //  232    235    287    354    Ljava/io/FileNotFoundException;
        //  235    238    287    354    Ljava/io/FileNotFoundException;
        //  240    243    287    354    Ljava/io/FileNotFoundException;
        //  245    250    287    354    Ljava/io/FileNotFoundException;
        //  257    263    287    354    Ljava/io/FileNotFoundException;
        //  265    270    287    354    Ljava/io/FileNotFoundException;
        //  270    275    287    354    Ljava/io/FileNotFoundException;
        //  279    284    287    354    Ljava/io/FileNotFoundException;
        //  284    287    287    354    Ljava/io/FileNotFoundException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0232:
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
    
    private Drawable getDrawableFromResourceValue(final String s) {
        if (s != null && s.length() != 0) {
            if (!"0".equals(s)) {
                try {
                    final int int1 = Integer.parseInt(s);
                    try {
                        try {
                            final StringBuilder sb = new StringBuilder();
                            sb.append("android.resource://");
                            final Context mProviderContext = this.mProviderContext;
                            try {
                                sb.append(mProviderContext.getPackageName());
                                sb.append("/");
                                final StringBuilder sb2 = sb;
                                try {
                                    sb2.append(int1);
                                    final String string = sb.toString();
                                    final Drawable checkIconCache = this.checkIconCache(string);
                                    if (checkIconCache != null) {
                                        return checkIconCache;
                                    }
                                    final Drawable drawable = ContextCompat.getDrawable(this.mProviderContext, int1);
                                    this.storeInIconCache(string, drawable);
                                    return drawable;
                                }
                                catch (Resources$NotFoundException ex) {
                                    final StringBuilder sb3 = new StringBuilder();
                                    sb3.append("Icon resource not found: ");
                                    sb3.append(s);
                                    Log.w("SuggestionsAdapter", sb3.toString());
                                    return null;
                                }
                                catch (NumberFormatException ex2) {
                                    final Drawable checkIconCache2 = this.checkIconCache(s);
                                    if (checkIconCache2 != null) {
                                        return checkIconCache2;
                                    }
                                    final Drawable drawable2 = this.getDrawable(Uri.parse(s));
                                    this.storeInIconCache(s, drawable2);
                                    return drawable2;
                                }
                            }
                            catch (Resources$NotFoundException ex3) {}
                            catch (NumberFormatException ex4) {}
                        }
                        catch (Resources$NotFoundException ex5) {}
                        catch (NumberFormatException ex6) {}
                    }
                    catch (Resources$NotFoundException ex7) {}
                    catch (NumberFormatException ex8) {}
                }
                catch (Resources$NotFoundException ex9) {}
                catch (NumberFormatException ex10) {}
            }
        }
        return null;
    }
    
    private Drawable getIcon1(final Cursor cursor) {
        final int mIconName1Col = this.mIconName1Col;
        if (mIconName1Col == -1) {
            return null;
        }
        final Drawable drawableFromResourceValue = this.getDrawableFromResourceValue(cursor.getString(mIconName1Col));
        if (drawableFromResourceValue != null) {
            return drawableFromResourceValue;
        }
        return this.getDefaultIcon1(cursor);
    }
    
    private Drawable getIcon2(final Cursor cursor) {
        final int mIconName2Col = this.mIconName2Col;
        if (mIconName2Col == -1) {
            return null;
        }
        return this.getDrawableFromResourceValue(cursor.getString(mIconName2Col));
    }
    
    private static String getStringOrNull(final Cursor cursor, final int n) {
        if (n == -1) {
            return null;
        }
        try {
            return cursor.getString(n);
        }
        catch (Exception ex) {
            Log.e("SuggestionsAdapter", "unexpected error retrieving valid column from cursor, did the remote process die?", (Throwable)ex);
            return null;
        }
    }
    
    private void setViewDrawable(final ImageView imageView, final Drawable imageDrawable, final int visibility) {
        imageView.setImageDrawable(imageDrawable);
        if (imageDrawable == null) {
            imageView.setVisibility(visibility);
        }
        else {
            imageView.setVisibility(0);
            imageDrawable.setVisible(false, false);
            imageDrawable.setVisible(true, false);
        }
    }
    
    private void setViewText(final TextView textView, final CharSequence text) {
        textView.setText(text);
        if (TextUtils.isEmpty(text)) {
            textView.setVisibility(8);
        }
        else {
            textView.setVisibility(0);
        }
    }
    
    private void storeInIconCache(final String s, final Drawable drawable) {
        if (drawable != null) {
            this.mOutsideDrawablesCache.put(s, drawable.getConstantState());
        }
    }
    
    private void updateSpinnerState(final Cursor cursor) {
        Bundle extras;
        if (cursor != null) {
            extras = cursor.getExtras();
        }
        else {
            extras = null;
        }
        if (extras != null && extras.getBoolean("in_progress")) {
            return;
        }
    }
    
    public void bindView(final View view, final Context context, final Cursor cursor) {
        final SuggestionsAdapter$ChildViewCache suggestionsAdapter$ChildViewCache = (SuggestionsAdapter$ChildViewCache)view.getTag();
        int int1 = 0;
        final int mFlagsCol = this.mFlagsCol;
        if (mFlagsCol != -1) {
            int1 = cursor.getInt(mFlagsCol);
        }
        if (suggestionsAdapter$ChildViewCache.mText1 != null) {
            this.setViewText(suggestionsAdapter$ChildViewCache.mText1, getStringOrNull(cursor, this.mText1Col));
        }
        final TextView mText2 = suggestionsAdapter$ChildViewCache.mText2;
        final int maxLines = 2;
        final int n = 1;
        if (mText2 != null) {
            final String stringOrNull = getStringOrNull(cursor, this.mText2UrlCol);
            CharSequence charSequence;
            if (stringOrNull != null) {
                charSequence = this.formatUrl(stringOrNull);
            }
            else {
                charSequence = getStringOrNull(cursor, this.mText2Col);
            }
            if (TextUtils.isEmpty(charSequence)) {
                if (suggestionsAdapter$ChildViewCache.mText1 != null) {
                    suggestionsAdapter$ChildViewCache.mText1.setSingleLine(false);
                    suggestionsAdapter$ChildViewCache.mText1.setMaxLines(maxLines);
                }
            }
            else if (suggestionsAdapter$ChildViewCache.mText1 != null) {
                suggestionsAdapter$ChildViewCache.mText1.setSingleLine((boolean)(n != 0));
                suggestionsAdapter$ChildViewCache.mText1.setMaxLines(n);
            }
            this.setViewText(suggestionsAdapter$ChildViewCache.mText2, charSequence);
        }
        if (suggestionsAdapter$ChildViewCache.mIcon1 != null) {
            this.setViewDrawable(suggestionsAdapter$ChildViewCache.mIcon1, this.getIcon1(cursor), 4);
        }
        final ImageView mIcon2 = suggestionsAdapter$ChildViewCache.mIcon2;
        final int visibility = 8;
        if (mIcon2 != null) {
            this.setViewDrawable(suggestionsAdapter$ChildViewCache.mIcon2, this.getIcon2(cursor), visibility);
        }
        final int mQueryRefinement = this.mQueryRefinement;
        if (mQueryRefinement != maxLines && (mQueryRefinement != n || (int1 & 0x1) == 0x0)) {
            suggestionsAdapter$ChildViewCache.mIconRefine.setVisibility(visibility);
        }
        else {
            suggestionsAdapter$ChildViewCache.mIconRefine.setVisibility(0);
            suggestionsAdapter$ChildViewCache.mIconRefine.setTag((Object)suggestionsAdapter$ChildViewCache.mText1.getText());
            suggestionsAdapter$ChildViewCache.mIconRefine.setOnClickListener((View$OnClickListener)this);
        }
    }
    
    public void changeCursor(final Cursor cursor) {
        if (this.mClosed) {
            Log.w("SuggestionsAdapter", "Tried to change cursor after adapter was closed.");
            if (cursor != null) {
                cursor.close();
            }
            return;
        }
        try {
            super.changeCursor(cursor);
            if (cursor != null) {
                this.mText1Col = cursor.getColumnIndex("suggest_text_1");
                this.mText2Col = cursor.getColumnIndex("suggest_text_2");
                this.mText2UrlCol = cursor.getColumnIndex("suggest_text_2_url");
                this.mIconName1Col = cursor.getColumnIndex("suggest_icon_1");
                this.mIconName2Col = cursor.getColumnIndex("suggest_icon_2");
                this.mFlagsCol = cursor.getColumnIndex("suggest_flags");
            }
        }
        catch (Exception ex) {
            Log.e("SuggestionsAdapter", "error changing cursor and caching columns", (Throwable)ex);
        }
    }
    
    public void close() {
        this.changeCursor(null);
        this.mClosed = true;
    }
    
    public CharSequence convertToString(final Cursor cursor) {
        if (cursor == null) {
            return null;
        }
        final String columnString = getColumnString(cursor, "suggest_intent_query");
        if (columnString != null) {
            return columnString;
        }
        if (this.mSearchable.shouldRewriteQueryFromData()) {
            final String columnString2 = getColumnString(cursor, "suggest_intent_data");
            if (columnString2 != null) {
                return columnString2;
            }
        }
        if (this.mSearchable.shouldRewriteQueryFromText()) {
            final String columnString3 = getColumnString(cursor, "suggest_text_1");
            if (columnString3 != null) {
                return columnString3;
            }
        }
        return null;
    }
    
    Drawable getDrawableFromResourceUri(final Uri uri) {
        final String authority = uri.getAuthority();
        if (!TextUtils.isEmpty((CharSequence)authority)) {
            try {
                final Context mContext = this.mContext;
                try {
                    final Resources resourcesForApplication = mContext.getPackageManager().getResourcesForApplication(authority);
                    final List pathSegments = uri.getPathSegments();
                    if (pathSegments == null) {
                        final StringBuilder sb = new StringBuilder();
                        sb.append("No path: ");
                        sb.append(uri);
                        throw new FileNotFoundException(sb.toString());
                    }
                    final int size = pathSegments.size();
                    final int n = 1;
                    if (size == n) {
                        final List list = pathSegments;
                        try {
                            final String value = list.get(0);
                            try {
                                final String s = value;
                                try {
                                    final int n2 = Integer.parseInt(s);
                                }
                                catch (NumberFormatException ex) {
                                    final StringBuilder sb2 = new StringBuilder();
                                    sb2.append("Single path segment is not a resource ID: ");
                                    sb2.append(uri);
                                    throw new FileNotFoundException(sb2.toString());
                                }
                            }
                            catch (NumberFormatException ex2) {}
                        }
                        catch (NumberFormatException ex3) {}
                    }
                    if (size != 2) {
                        final StringBuilder sb3 = new StringBuilder();
                        sb3.append("More than two path segments: ");
                        sb3.append(uri);
                        throw new FileNotFoundException(sb3.toString());
                    }
                    final int n2 = resourcesForApplication.getIdentifier((String)pathSegments.get(n), (String)pathSegments.get(0), authority);
                    if (n2 != 0) {
                        return resourcesForApplication.getDrawable(n2);
                    }
                    final StringBuilder sb4 = new StringBuilder();
                    sb4.append("No resource found for: ");
                    sb4.append(uri);
                    throw new FileNotFoundException(sb4.toString());
                }
                catch (PackageManager$NameNotFoundException ex4) {
                    final StringBuilder sb5 = new StringBuilder();
                    sb5.append("No package found for authority: ");
                    sb5.append(uri);
                    throw new FileNotFoundException(sb5.toString());
                }
            }
            catch (PackageManager$NameNotFoundException ex5) {}
        }
        final StringBuilder sb6 = new StringBuilder();
        sb6.append("No authority: ");
        sb6.append(uri);
        throw new FileNotFoundException(sb6.toString());
    }
    
    public View getDropDownView(final int n, final View view, final ViewGroup viewGroup) {
        try {
            return super.getDropDownView(n, view, viewGroup);
        }
        catch (RuntimeException ex) {
            Log.w("SuggestionsAdapter", "Search suggestions cursor threw exception.", (Throwable)ex);
            final View dropDownView = this.newDropDownView(this.mContext, this.mCursor, viewGroup);
            if (dropDownView != null) {
                ((SuggestionsAdapter$ChildViewCache)dropDownView.getTag()).mText1.setText((CharSequence)ex.toString());
            }
            return dropDownView;
        }
    }
    
    public int getQueryRefinement() {
        return this.mQueryRefinement;
    }
    
    Cursor getSearchManagerSuggestions(final SearchableInfo searchableInfo, final String s, final int n) {
        if (searchableInfo == null) {
            return null;
        }
        final String suggestAuthority = searchableInfo.getSuggestAuthority();
        if (suggestAuthority == null) {
            return null;
        }
        final Uri$Builder fragment = new Uri$Builder().scheme("content").authority(suggestAuthority).query("").fragment("");
        final String suggestPath = searchableInfo.getSuggestPath();
        if (suggestPath != null) {
            fragment.appendEncodedPath(suggestPath);
        }
        fragment.appendPath("search_suggest_query");
        final String suggestSelection = searchableInfo.getSuggestSelection();
        String[] array;
        if (suggestSelection != null) {
            array = new String[] { s };
        }
        else {
            fragment.appendPath(s);
            array = null;
        }
        if (n > 0) {
            fragment.appendQueryParameter("limit", String.valueOf(n));
        }
        return this.mContext.getContentResolver().query(fragment.build(), (String[])null, suggestSelection, array, (String)null);
    }
    
    public View getView(final int n, final View view, final ViewGroup viewGroup) {
        try {
            return super.getView(n, view, viewGroup);
        }
        catch (RuntimeException ex) {
            Log.w("SuggestionsAdapter", "Search suggestions cursor threw exception.", (Throwable)ex);
            final View view2 = this.newView(this.mContext, this.mCursor, viewGroup);
            if (view2 != null) {
                ((SuggestionsAdapter$ChildViewCache)view2.getTag()).mText1.setText((CharSequence)ex.toString());
            }
            return view2;
        }
    }
    
    public boolean hasStableIds() {
        return false;
    }
    
    public View newView(final Context context, final Cursor cursor, final ViewGroup viewGroup) {
        final View view = super.newView(context, cursor, viewGroup);
        view.setTag((Object)new SuggestionsAdapter$ChildViewCache(view));
        ((ImageView)view.findViewById(R$id.edit_query)).setImageResource(this.mCommitIconResId);
        return view;
    }
    
    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
        this.updateSpinnerState(this.getCursor());
    }
    
    public void notifyDataSetInvalidated() {
        super.notifyDataSetInvalidated();
        this.updateSpinnerState(this.getCursor());
    }
    
    public void onClick(final View view) {
        final Object tag = view.getTag();
        if (tag instanceof CharSequence) {
            this.mSearchView.onQueryRefine((CharSequence)tag);
        }
    }
    
    public Cursor runQueryOnBackgroundThread(final CharSequence charSequence) {
        String string;
        if (charSequence == null) {
            string = "";
        }
        else {
            string = charSequence.toString();
        }
        if (this.mSearchView.getVisibility() == 0 && this.mSearchView.getWindowVisibility() == 0) {
            try {
                final Cursor searchManagerSuggestions = this.getSearchManagerSuggestions(this.mSearchable, string, 50);
                if (searchManagerSuggestions != null) {
                    searchManagerSuggestions.getCount();
                    return searchManagerSuggestions;
                }
            }
            catch (RuntimeException ex) {
                Log.w("SuggestionsAdapter", "Search suggestions query threw an exception.", (Throwable)ex);
            }
            return null;
        }
        return null;
    }
    
    public void setQueryRefinement(final int mQueryRefinement) {
        this.mQueryRefinement = mQueryRefinement;
    }
}
