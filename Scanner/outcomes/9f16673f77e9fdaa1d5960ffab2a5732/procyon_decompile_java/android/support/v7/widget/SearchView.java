// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v7.widget;

import android.view.inputmethod.InputMethodManager;
import android.content.ActivityNotFoundException;
import android.support.v4.view.KeyEventCompat;
import android.view.KeyEvent;
import android.view.View$MeasureSpec;
import android.view.TouchDelegate;
import android.widget.AutoCompleteTextView;
import android.widget.ListAdapter;
import android.text.TextUtils;
import android.text.Editable;
import android.util.Log;
import android.support.v7.appcompat.R$dimen;
import android.text.style.ImageSpan;
import android.text.SpannableStringBuilder;
import android.content.res.Resources;
import android.content.ComponentName;
import android.os.Parcelable;
import android.app.PendingIntent;
import android.database.Cursor;
import android.net.Uri;
import android.view.View$OnLayoutChangeListener;
import android.view.ViewTreeObserver$OnGlobalLayoutListener;
import android.os.Build$VERSION;
import android.support.v4.view.ViewCompat;
import android.support.v7.appcompat.R$id;
import android.view.ViewGroup;
import android.support.v7.appcompat.R$layout;
import android.view.LayoutInflater;
import android.support.v7.appcompat.R$styleable;
import android.support.v7.appcompat.R$attr;
import android.util.AttributeSet;
import android.content.Context;
import android.content.Intent;
import android.text.TextWatcher;
import android.view.View$OnKeyListener;
import android.support.v4.widget.CursorAdapter;
import android.app.SearchableInfo;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import java.util.WeakHashMap;
import android.view.View$OnFocusChangeListener;
import android.widget.AdapterView$OnItemSelectedListener;
import android.widget.AdapterView$OnItemClickListener;
import android.widget.TextView$OnEditorActionListener;
import android.view.View$OnClickListener;
import android.view.View;
import android.widget.ImageView;
import android.os.Bundle;
import android.support.v7.view.CollapsibleActionView;

public class SearchView extends LinearLayoutCompat implements CollapsibleActionView
{
    static final boolean DBG = false;
    static final SearchView$AutoCompleteTextViewReflector HIDDEN_METHOD_INVOKER;
    private static final String IME_OPTION_NO_MICROPHONE = "nm";
    static final String LOG_TAG = "SearchView";
    private Bundle mAppSearchData;
    private boolean mClearingFocus;
    final ImageView mCloseButton;
    private final ImageView mCollapsedIcon;
    private int mCollapsedImeOptions;
    private final CharSequence mDefaultQueryHint;
    private final View mDropDownAnchor;
    private boolean mExpandedInActionView;
    final ImageView mGoButton;
    private boolean mIconified;
    private boolean mIconifiedByDefault;
    private int mMaxWidth;
    private CharSequence mOldQueryText;
    private final View$OnClickListener mOnClickListener;
    private SearchView$OnCloseListener mOnCloseListener;
    private final TextView$OnEditorActionListener mOnEditorActionListener;
    private final AdapterView$OnItemClickListener mOnItemClickListener;
    private final AdapterView$OnItemSelectedListener mOnItemSelectedListener;
    private SearchView$OnQueryTextListener mOnQueryChangeListener;
    View$OnFocusChangeListener mOnQueryTextFocusChangeListener;
    private View$OnClickListener mOnSearchClickListener;
    private SearchView$OnSuggestionListener mOnSuggestionListener;
    private final WeakHashMap mOutsideDrawablesCache;
    private CharSequence mQueryHint;
    private boolean mQueryRefinement;
    private Runnable mReleaseCursorRunnable;
    final ImageView mSearchButton;
    private final View mSearchEditFrame;
    private final Drawable mSearchHintIcon;
    private final View mSearchPlate;
    final SearchView$SearchAutoComplete mSearchSrcTextView;
    private Rect mSearchSrcTextViewBounds;
    private Rect mSearchSrtTextViewBoundsExpanded;
    SearchableInfo mSearchable;
    private Runnable mShowImeRunnable;
    private final View mSubmitArea;
    private boolean mSubmitButtonEnabled;
    private final int mSuggestionCommitIconResId;
    private final int mSuggestionRowLayout;
    CursorAdapter mSuggestionsAdapter;
    private int[] mTemp;
    private int[] mTemp2;
    View$OnKeyListener mTextKeyListener;
    private TextWatcher mTextWatcher;
    private SearchView$UpdatableTouchDelegate mTouchDelegate;
    private final Runnable mUpdateDrawableStateRunnable;
    private CharSequence mUserQuery;
    private final Intent mVoiceAppSearchIntent;
    final ImageView mVoiceButton;
    private boolean mVoiceButtonEnabled;
    private final Intent mVoiceWebSearchIntent;
    
    static {
        HIDDEN_METHOD_INVOKER = new SearchView$AutoCompleteTextViewReflector();
    }
    
    public SearchView(final Context context) {
        this(context, null);
    }
    
    public SearchView(final Context context, final AttributeSet set) {
        this(context, set, R$attr.searchViewStyle);
    }
    
    public SearchView(final Context context, final AttributeSet set, final int n) {
        super(context, set, n);
        this.mSearchSrcTextViewBounds = new Rect();
        this.mSearchSrtTextViewBoundsExpanded = new Rect();
        final int n2 = 2;
        this.mTemp = new int[n2];
        this.mTemp2 = new int[n2];
        this.mShowImeRunnable = new SearchView$1(this);
        this.mUpdateDrawableStateRunnable = new SearchView$2(this);
        this.mReleaseCursorRunnable = new SearchView$3(this);
        this.mOutsideDrawablesCache = new WeakHashMap();
        this.mOnClickListener = (View$OnClickListener)new SearchView$7(this);
        this.mTextKeyListener = (View$OnKeyListener)new SearchView$8(this);
        this.mOnEditorActionListener = (TextView$OnEditorActionListener)new SearchView$9(this);
        this.mOnItemClickListener = (AdapterView$OnItemClickListener)new SearchView$10(this);
        this.mOnItemSelectedListener = (AdapterView$OnItemSelectedListener)new SearchView$11(this);
        this.mTextWatcher = (TextWatcher)new SearchView$12(this);
        final TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(context, set, R$styleable.SearchView, n, 0);
        final LayoutInflater from = LayoutInflater.from(context);
        final int resourceId = obtainStyledAttributes.getResourceId(R$styleable.SearchView_layout, R$layout.abc_search_view);
        final boolean b = true;
        from.inflate(resourceId, (ViewGroup)this, b);
        (this.mSearchSrcTextView = (SearchView$SearchAutoComplete)this.findViewById(R$id.search_src_text)).setSearchView(this);
        this.mSearchEditFrame = this.findViewById(R$id.search_edit_frame);
        this.mSearchPlate = this.findViewById(R$id.search_plate);
        this.mSubmitArea = this.findViewById(R$id.submit_area);
        this.mSearchButton = (ImageView)this.findViewById(R$id.search_button);
        this.mGoButton = (ImageView)this.findViewById(R$id.search_go_btn);
        this.mCloseButton = (ImageView)this.findViewById(R$id.search_close_btn);
        this.mVoiceButton = (ImageView)this.findViewById(R$id.search_voice_btn);
        this.mCollapsedIcon = (ImageView)this.findViewById(R$id.search_mag_icon);
        ViewCompat.setBackground(this.mSearchPlate, obtainStyledAttributes.getDrawable(R$styleable.SearchView_queryBackground));
        ViewCompat.setBackground(this.mSubmitArea, obtainStyledAttributes.getDrawable(R$styleable.SearchView_submitBackground));
        this.mSearchButton.setImageDrawable(obtainStyledAttributes.getDrawable(R$styleable.SearchView_searchIcon));
        this.mGoButton.setImageDrawable(obtainStyledAttributes.getDrawable(R$styleable.SearchView_goIcon));
        this.mCloseButton.setImageDrawable(obtainStyledAttributes.getDrawable(R$styleable.SearchView_closeIcon));
        this.mVoiceButton.setImageDrawable(obtainStyledAttributes.getDrawable(R$styleable.SearchView_voiceIcon));
        this.mCollapsedIcon.setImageDrawable(obtainStyledAttributes.getDrawable(R$styleable.SearchView_searchIcon));
        this.mSearchHintIcon = obtainStyledAttributes.getDrawable(R$styleable.SearchView_searchHintIcon);
        this.mSuggestionRowLayout = obtainStyledAttributes.getResourceId(R$styleable.SearchView_suggestionRowLayout, R$layout.abc_search_dropdown_item_icons_2line);
        this.mSuggestionCommitIconResId = obtainStyledAttributes.getResourceId(R$styleable.SearchView_commitIcon, 0);
        this.mSearchButton.setOnClickListener(this.mOnClickListener);
        this.mCloseButton.setOnClickListener(this.mOnClickListener);
        this.mGoButton.setOnClickListener(this.mOnClickListener);
        this.mVoiceButton.setOnClickListener(this.mOnClickListener);
        this.mSearchSrcTextView.setOnClickListener(this.mOnClickListener);
        this.mSearchSrcTextView.addTextChangedListener(this.mTextWatcher);
        this.mSearchSrcTextView.setOnEditorActionListener(this.mOnEditorActionListener);
        this.mSearchSrcTextView.setOnItemClickListener(this.mOnItemClickListener);
        this.mSearchSrcTextView.setOnItemSelectedListener(this.mOnItemSelectedListener);
        this.mSearchSrcTextView.setOnKeyListener(this.mTextKeyListener);
        this.mSearchSrcTextView.setOnFocusChangeListener((View$OnFocusChangeListener)new SearchView$4(this));
        this.setIconifiedByDefault(obtainStyledAttributes.getBoolean(R$styleable.SearchView_iconifiedByDefault, b));
        final int searchView_android_maxWidth = R$styleable.SearchView_android_maxWidth;
        final int n3 = -1;
        final int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(searchView_android_maxWidth, n3);
        if (dimensionPixelSize != n3) {
            this.setMaxWidth(dimensionPixelSize);
        }
        this.mDefaultQueryHint = obtainStyledAttributes.getText(R$styleable.SearchView_defaultQueryHint);
        this.mQueryHint = obtainStyledAttributes.getText(R$styleable.SearchView_queryHint);
        final int int1 = obtainStyledAttributes.getInt(R$styleable.SearchView_android_imeOptions, n3);
        if (int1 != n3) {
            this.setImeOptions(int1);
        }
        final int int2 = obtainStyledAttributes.getInt(R$styleable.SearchView_android_inputType, n3);
        if (int2 != n3) {
            this.setInputType(int2);
        }
        this.setFocusable(obtainStyledAttributes.getBoolean(R$styleable.SearchView_android_focusable, true));
        obtainStyledAttributes.recycle();
        this.mVoiceWebSearchIntent = new Intent("android.speech.action.WEB_SEARCH");
        final Intent mVoiceWebSearchIntent = this.mVoiceWebSearchIntent;
        final int n4 = 268435456;
        mVoiceWebSearchIntent.addFlags(n4);
        this.mVoiceWebSearchIntent.putExtra("android.speech.extra.LANGUAGE_MODEL", "web_search");
        (this.mVoiceAppSearchIntent = new Intent("android.speech.action.RECOGNIZE_SPEECH")).addFlags(n4);
        this.mDropDownAnchor = this.findViewById(this.mSearchSrcTextView.getDropDownAnchor());
        if (this.mDropDownAnchor != null) {
            if (Build$VERSION.SDK_INT >= 11) {
                this.addOnLayoutChangeListenerToDropDownAnchorSDK11();
            }
            else {
                this.addOnLayoutChangeListenerToDropDownAnchorBase();
            }
        }
        this.updateViewsVisibility(this.mIconifiedByDefault);
        this.updateQueryHint();
    }
    
    private void addOnLayoutChangeListenerToDropDownAnchorBase() {
        this.mDropDownAnchor.getViewTreeObserver().addOnGlobalLayoutListener((ViewTreeObserver$OnGlobalLayoutListener)new SearchView$6(this));
    }
    
    private void addOnLayoutChangeListenerToDropDownAnchorSDK11() {
        this.mDropDownAnchor.addOnLayoutChangeListener((View$OnLayoutChangeListener)new SearchView$5(this));
    }
    
    private Intent createIntent(final String s, final Uri data, final String s2, final String s3, final int n, final String s4) {
        final Intent intent = new Intent(s);
        intent.addFlags(268435456);
        if (data != null) {
            intent.setData(data);
        }
        intent.putExtra("user_query", this.mUserQuery);
        if (s3 != null) {
            intent.putExtra("query", s3);
        }
        if (s2 != null) {
            intent.putExtra("intent_extra_data_key", s2);
        }
        final Bundle mAppSearchData = this.mAppSearchData;
        if (mAppSearchData != null) {
            intent.putExtra("app_data", mAppSearchData);
        }
        if (n != 0) {
            intent.putExtra("action_key", n);
            intent.putExtra("action_msg", s4);
        }
        intent.setComponent(this.mSearchable.getSearchActivity());
        return intent;
    }
    
    private Intent createIntentFromSuggestion(final Cursor p0, final int p1, final String p2) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     0: ldc_w           "suggest_intent_action"
        //     3: astore          4
        //     5: aload_1        
        //     6: aload           4
        //     8: invokestatic    android/support/v7/widget/SuggestionsAdapter.getColumnString:(Landroid/database/Cursor;Ljava/lang/String;)Ljava/lang/String;
        //    11: astore          4
        //    13: aload           4
        //    15: ifnonnull       38
        //    18: aload_0        
        //    19: getfield        android/support/v7/widget/SearchView.mSearchable:Landroid/app/SearchableInfo;
        //    22: astore          5
        //    24: aload           5
        //    26: invokevirtual   android/app/SearchableInfo.getSuggestIntentAction:()Ljava/lang/String;
        //    29: astore          5
        //    31: aload           5
        //    33: astore          4
        //    35: goto            38
        //    38: aload           4
        //    40: ifnonnull       55
        //    43: ldc_w           "android.intent.action.SEARCH"
        //    46: astore          5
        //    48: aload           5
        //    50: astore          4
        //    52: goto            55
        //    55: ldc_w           "suggest_intent_data"
        //    58: astore          5
        //    60: aload_1        
        //    61: aload           5
        //    63: invokestatic    android/support/v7/widget/SuggestionsAdapter.getColumnString:(Landroid/database/Cursor;Ljava/lang/String;)Ljava/lang/String;
        //    66: astore          5
        //    68: aload           5
        //    70: ifnonnull       93
        //    73: aload_0        
        //    74: getfield        android/support/v7/widget/SearchView.mSearchable:Landroid/app/SearchableInfo;
        //    77: astore          6
        //    79: aload           6
        //    81: invokevirtual   android/app/SearchableInfo.getSuggestIntentData:()Ljava/lang/String;
        //    84: astore          6
        //    86: aload           6
        //    88: astore          5
        //    90: goto            93
        //    93: aload           5
        //    95: ifnull          183
        //    98: ldc_w           "suggest_intent_data_id"
        //   101: astore          6
        //   103: aload_1        
        //   104: aload           6
        //   106: invokestatic    android/support/v7/widget/SuggestionsAdapter.getColumnString:(Landroid/database/Cursor;Ljava/lang/String;)Ljava/lang/String;
        //   109: astore          6
        //   111: aload           6
        //   113: ifnull          180
        //   116: new             Ljava/lang/StringBuilder;
        //   119: astore          7
        //   121: aload           7
        //   123: invokespecial   java/lang/StringBuilder.<init>:()V
        //   126: aload           7
        //   128: aload           5
        //   130: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   133: pop            
        //   134: ldc_w           "/"
        //   137: astore          8
        //   139: aload           7
        //   141: aload           8
        //   143: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   146: pop            
        //   147: aload           6
        //   149: invokestatic    android/net/Uri.encode:(Ljava/lang/String;)Ljava/lang/String;
        //   152: astore          8
        //   154: aload           7
        //   156: aload           8
        //   158: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   161: pop            
        //   162: aload           7
        //   164: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   167: astore          7
        //   169: aload           7
        //   171: astore          5
        //   173: aload           7
        //   175: astore          9
        //   177: goto            187
        //   180: goto            183
        //   183: aload           5
        //   185: astore          9
        //   187: aload           9
        //   189: ifnonnull       198
        //   192: aconst_null    
        //   193: astore          7
        //   195: goto            209
        //   198: aload           9
        //   200: invokestatic    android/net/Uri.parse:(Ljava/lang/String;)Landroid/net/Uri;
        //   203: astore          5
        //   205: aload           5
        //   207: astore          7
        //   209: ldc_w           "suggest_intent_query"
        //   212: astore          5
        //   214: aload_1        
        //   215: aload           5
        //   217: invokestatic    android/support/v7/widget/SuggestionsAdapter.getColumnString:(Landroid/database/Cursor;Ljava/lang/String;)Ljava/lang/String;
        //   220: astore          10
        //   222: ldc_w           "suggest_intent_extra_data"
        //   225: astore          5
        //   227: aload_1        
        //   228: aload           5
        //   230: invokestatic    android/support/v7/widget/SuggestionsAdapter.getColumnString:(Landroid/database/Cursor;Ljava/lang/String;)Ljava/lang/String;
        //   233: astore          8
        //   235: aload_0        
        //   236: astore          5
        //   238: aload           4
        //   240: astore          6
        //   242: aload_0        
        //   243: aload           4
        //   245: aload           7
        //   247: aload           8
        //   249: aload           10
        //   251: iload_2        
        //   252: aload_3        
        //   253: invokespecial   android/support/v7/widget/SearchView.createIntent:(Ljava/lang/String;Landroid/net/Uri;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)Landroid/content/Intent;
        //   256: areturn        
        //   257: astore          4
        //   259: aload_1        
        //   260: invokeinterface android/database/Cursor.getPosition:()I
        //   265: istore          11
        //   267: goto            275
        //   270: astore          5
        //   272: iconst_m1      
        //   273: istore          11
        //   275: new             Ljava/lang/StringBuilder;
        //   278: astore          7
        //   280: aload           7
        //   282: invokespecial   java/lang/StringBuilder.<init>:()V
        //   285: aload           7
        //   287: ldc_w           "Search suggestions cursor at row "
        //   290: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   293: pop            
        //   294: aload           7
        //   296: iload           11
        //   298: invokevirtual   java/lang/StringBuilder.append:(I)Ljava/lang/StringBuilder;
        //   301: pop            
        //   302: aload           7
        //   304: ldc_w           " returned exception."
        //   307: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   310: pop            
        //   311: aload           7
        //   313: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   316: astore          7
        //   318: ldc             "SearchView"
        //   320: aload           7
        //   322: aload           4
        //   324: invokestatic    android/util/Log.w:(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
        //   327: pop            
        //   328: aconst_null    
        //   329: areturn        
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                        
        //  -----  -----  -----  -----  ----------------------------
        //  6      11     257    330    Ljava/lang/RuntimeException;
        //  18     22     257    330    Ljava/lang/RuntimeException;
        //  24     29     257    330    Ljava/lang/RuntimeException;
        //  61     66     257    330    Ljava/lang/RuntimeException;
        //  73     77     257    330    Ljava/lang/RuntimeException;
        //  79     84     257    330    Ljava/lang/RuntimeException;
        //  104    109    257    330    Ljava/lang/RuntimeException;
        //  116    119    257    330    Ljava/lang/RuntimeException;
        //  121    126    257    330    Ljava/lang/RuntimeException;
        //  128    134    257    330    Ljava/lang/RuntimeException;
        //  141    147    257    330    Ljava/lang/RuntimeException;
        //  147    152    257    330    Ljava/lang/RuntimeException;
        //  156    162    257    330    Ljava/lang/RuntimeException;
        //  162    167    257    330    Ljava/lang/RuntimeException;
        //  198    203    257    330    Ljava/lang/RuntimeException;
        //  215    220    257    330    Ljava/lang/RuntimeException;
        //  228    233    257    330    Ljava/lang/RuntimeException;
        //  252    256    257    330    Ljava/lang/RuntimeException;
        //  259    265    270    275    Ljava/lang/RuntimeException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index: 152, Size: 152
        //     at java.util.ArrayList.rangeCheck(ArrayList.java:657)
        //     at java.util.ArrayList.get(ArrayList.java:433)
        //     at com.strobel.decompiler.ast.AstBuilder.convertToAst(AstBuilder.java:3303)
        //     at com.strobel.decompiler.ast.AstBuilder.convertToAst(AstBuilder.java:3551)
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
    
    private Intent createVoiceAppSearchIntent(final Intent intent, final SearchableInfo searchableInfo) {
        final ComponentName searchActivity = searchableInfo.getSearchActivity();
        final Intent intent2 = new Intent("android.intent.action.SEARCH");
        intent2.setComponent(searchActivity);
        final PendingIntent activity = PendingIntent.getActivity(this.getContext(), 0, intent2, 1073741824);
        final Bundle bundle = new Bundle();
        final Bundle mAppSearchData = this.mAppSearchData;
        if (mAppSearchData != null) {
            bundle.putParcelable("app_data", (Parcelable)mAppSearchData);
        }
        final Intent intent3 = new Intent(intent);
        String string = "free_form";
        String string2 = null;
        String string3 = null;
        int voiceMaxResults = 1;
        final Resources resources = this.getResources();
        if (searchableInfo.getVoiceLanguageModeId() != 0) {
            string = resources.getString(searchableInfo.getVoiceLanguageModeId());
        }
        if (searchableInfo.getVoicePromptTextId() != 0) {
            string2 = resources.getString(searchableInfo.getVoicePromptTextId());
        }
        if (searchableInfo.getVoiceLanguageId() != 0) {
            string3 = resources.getString(searchableInfo.getVoiceLanguageId());
        }
        if (searchableInfo.getVoiceMaxResults() != 0) {
            voiceMaxResults = searchableInfo.getVoiceMaxResults();
        }
        intent3.putExtra("android.speech.extra.LANGUAGE_MODEL", string);
        intent3.putExtra("android.speech.extra.PROMPT", string2);
        intent3.putExtra("android.speech.extra.LANGUAGE", string3);
        intent3.putExtra("android.speech.extra.MAX_RESULTS", voiceMaxResults);
        final String s = "calling_package";
        String flattenToShortString;
        if (searchActivity == null) {
            flattenToShortString = null;
        }
        else {
            flattenToShortString = searchActivity.flattenToShortString();
        }
        intent3.putExtra(s, flattenToShortString);
        intent3.putExtra("android.speech.extra.RESULTS_PENDINGINTENT", (Parcelable)activity);
        intent3.putExtra("android.speech.extra.RESULTS_PENDINGINTENT_BUNDLE", bundle);
        return intent3;
    }
    
    private Intent createVoiceWebSearchIntent(final Intent intent, final SearchableInfo searchableInfo) {
        final Intent intent2 = new Intent(intent);
        final ComponentName searchActivity = searchableInfo.getSearchActivity();
        final String s = "calling_package";
        String flattenToShortString;
        if (searchActivity == null) {
            flattenToShortString = null;
        }
        else {
            flattenToShortString = searchActivity.flattenToShortString();
        }
        intent2.putExtra(s, flattenToShortString);
        return intent2;
    }
    
    private void dismissSuggestions() {
        this.mSearchSrcTextView.dismissDropDown();
    }
    
    private void getChildBoundsWithinSearchView(final View view, final Rect rect) {
        view.getLocationInWindow(this.mTemp);
        this.getLocationInWindow(this.mTemp2);
        final int[] mTemp = this.mTemp;
        final int n = 1;
        final int n2 = mTemp[n];
        final int[] mTemp2 = this.mTemp2;
        final int n3 = n2 - mTemp2[n];
        final int n4 = mTemp[0] - mTemp2[0];
        rect.set(n4, n3, view.getWidth() + n4, view.getHeight() + n3);
    }
    
    private CharSequence getDecoratedHint(final CharSequence charSequence) {
        if (this.mIconifiedByDefault && this.mSearchHintIcon != null) {
            final double n = this.mSearchSrcTextView.getTextSize();
            Double.isNaN(n);
            final int n2 = (int)(n * 1.25);
            this.mSearchHintIcon.setBounds(0, 0, n2, n2);
            final SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder((CharSequence)"   ");
            spannableStringBuilder.setSpan((Object)new ImageSpan(this.mSearchHintIcon), 1, 2, 33);
            spannableStringBuilder.append(charSequence);
            return (CharSequence)spannableStringBuilder;
        }
        return charSequence;
    }
    
    private int getPreferredHeight() {
        return this.getContext().getResources().getDimensionPixelSize(R$dimen.abc_search_view_preferred_height);
    }
    
    private int getPreferredWidth() {
        return this.getContext().getResources().getDimensionPixelSize(R$dimen.abc_search_view_preferred_width);
    }
    
    private boolean hasVoiceSearch() {
        final SearchableInfo mSearchable = this.mSearchable;
        boolean b = false;
        if (mSearchable != null && mSearchable.getVoiceSearchEnabled()) {
            Intent intent = null;
            if (this.mSearchable.getVoiceSearchLaunchWebSearch()) {
                intent = this.mVoiceWebSearchIntent;
            }
            else if (this.mSearchable.getVoiceSearchLaunchRecognizer()) {
                intent = this.mVoiceAppSearchIntent;
            }
            if (intent != null) {
                if (this.getContext().getPackageManager().resolveActivity(intent, 65536) != null) {
                    b = true;
                }
                return b;
            }
        }
        return false;
    }
    
    static boolean isLandscapeMode(final Context context) {
        return context.getResources().getConfiguration().orientation == 2;
    }
    
    private boolean isSubmitAreaEnabled() {
        return (this.mSubmitButtonEnabled || this.mVoiceButtonEnabled) && !this.isIconified();
    }
    
    private void launchIntent(final Intent intent) {
        if (intent == null) {
            return;
        }
        try {
            this.getContext().startActivity(intent);
        }
        catch (RuntimeException ex) {
            final String s = "SearchView";
            final StringBuilder sb = new StringBuilder();
            sb.append("Failed launch activity: ");
            sb.append(intent);
            Log.e(s, sb.toString(), (Throwable)ex);
        }
    }
    
    private boolean launchSuggestion(final int n, final int n2, final String s) {
        final Cursor cursor = this.mSuggestionsAdapter.getCursor();
        if (cursor != null && cursor.moveToPosition(n)) {
            this.launchIntent(this.createIntentFromSuggestion(cursor, n2, s));
            return true;
        }
        return false;
    }
    
    private void postUpdateFocusedState() {
        this.post(this.mUpdateDrawableStateRunnable);
    }
    
    private void rewriteQueryFromSuggestion(final int n) {
        final Editable text = this.mSearchSrcTextView.getText();
        final Cursor cursor = this.mSuggestionsAdapter.getCursor();
        if (cursor == null) {
            return;
        }
        if (cursor.moveToPosition(n)) {
            final CharSequence convertToString = this.mSuggestionsAdapter.convertToString(cursor);
            if (convertToString != null) {
                this.setQuery(convertToString);
            }
            else {
                this.setQuery((CharSequence)text);
            }
        }
        else {
            this.setQuery((CharSequence)text);
        }
    }
    
    private void setQuery(final CharSequence text) {
        this.mSearchSrcTextView.setText(text);
        final SearchView$SearchAutoComplete mSearchSrcTextView = this.mSearchSrcTextView;
        int length;
        if (TextUtils.isEmpty(text)) {
            length = 0;
        }
        else {
            length = text.length();
        }
        mSearchSrcTextView.setSelection(length);
    }
    
    private void updateCloseButton() {
        final boolean empty = TextUtils.isEmpty((CharSequence)this.mSearchSrcTextView.getText());
        boolean b = true;
        final boolean b2 = empty ^ b;
        int visibility = 0;
        if (!b2) {
            if (!this.mIconifiedByDefault || this.mExpandedInActionView) {
                b = false;
            }
        }
        final ImageView mCloseButton = this.mCloseButton;
        if (!b) {
            visibility = 8;
        }
        mCloseButton.setVisibility(visibility);
        final Drawable drawable = this.mCloseButton.getDrawable();
        if (drawable != null) {
            int[] state;
            if (b2) {
                state = SearchView.ENABLED_STATE_SET;
            }
            else {
                state = SearchView.EMPTY_STATE_SET;
            }
            drawable.setState(state);
        }
    }
    
    private void updateQueryHint() {
        final CharSequence queryHint = this.getQueryHint();
        final SearchView$SearchAutoComplete mSearchSrcTextView = this.mSearchSrcTextView;
        CharSequence charSequence;
        if (queryHint == null) {
            charSequence = "";
        }
        else {
            charSequence = queryHint;
        }
        mSearchSrcTextView.setHint(this.getDecoratedHint(charSequence));
    }
    
    private void updateSearchAutoComplete() {
        this.mSearchSrcTextView.setThreshold(this.mSearchable.getSuggestThreshold());
        this.mSearchSrcTextView.setImeOptions(this.mSearchable.getImeOptions());
        int inputType = this.mSearchable.getInputType();
        final int n = inputType & 0xF;
        int queryRefinement = 1;
        if (n == queryRefinement) {
            inputType &= 0xFFFEFFFF;
            if (this.mSearchable.getSuggestAuthority() != null) {
                inputType = (inputType | 0x10000 | 0x80000);
            }
        }
        this.mSearchSrcTextView.setInputType(inputType);
        final CursorAdapter mSuggestionsAdapter = this.mSuggestionsAdapter;
        if (mSuggestionsAdapter != null) {
            mSuggestionsAdapter.changeCursor(null);
        }
        if (this.mSearchable.getSuggestAuthority() != null) {
            this.mSuggestionsAdapter = new SuggestionsAdapter(this.getContext(), this, this.mSearchable, this.mOutsideDrawablesCache);
            this.mSearchSrcTextView.setAdapter((ListAdapter)this.mSuggestionsAdapter);
            final SuggestionsAdapter suggestionsAdapter = (SuggestionsAdapter)this.mSuggestionsAdapter;
            if (this.mQueryRefinement) {
                queryRefinement = 2;
            }
            suggestionsAdapter.setQueryRefinement(queryRefinement);
        }
    }
    
    private void updateSubmitArea() {
        int visibility = 8;
        if (this.isSubmitAreaEnabled()) {
            if (this.mGoButton.getVisibility() == 0 || this.mVoiceButton.getVisibility() == 0) {
                visibility = 0;
            }
        }
        this.mSubmitArea.setVisibility(visibility);
    }
    
    private void updateSubmitButton(final boolean b) {
        int visibility = 8;
        if (this.mSubmitButtonEnabled && this.isSubmitAreaEnabled() && this.hasFocus() && (b || !this.mVoiceButtonEnabled)) {
            visibility = 0;
        }
        this.mGoButton.setVisibility(visibility);
    }
    
    private void updateViewsVisibility(final boolean mIconified) {
        this.mIconified = mIconified;
        int visibility = 8;
        boolean b = false;
        int visibility2;
        if (mIconified) {
            visibility2 = 0;
        }
        else {
            visibility2 = 8;
        }
        final boolean b2 = TextUtils.isEmpty((CharSequence)this.mSearchSrcTextView.getText()) ^ true;
        this.mSearchButton.setVisibility(visibility2);
        this.updateSubmitButton(b2);
        final View mSearchEditFrame = this.mSearchEditFrame;
        if (!mIconified) {
            visibility = 0;
        }
        mSearchEditFrame.setVisibility(visibility);
        int visibility3;
        if (this.mCollapsedIcon.getDrawable() != null && !this.mIconifiedByDefault) {
            visibility3 = 0;
        }
        else {
            visibility3 = 8;
        }
        this.mCollapsedIcon.setVisibility(visibility3);
        this.updateCloseButton();
        if (!b2) {
            b = true;
        }
        this.updateVoiceButton(b);
        this.updateSubmitArea();
    }
    
    private void updateVoiceButton(final boolean b) {
        int visibility = 8;
        if (this.mVoiceButtonEnabled && !this.isIconified() && b) {
            visibility = 0;
            this.mGoButton.setVisibility(8);
        }
        this.mVoiceButton.setVisibility(visibility);
    }
    
    void adjustDropDownSizeAndPosition() {
        if (this.mDropDownAnchor.getWidth() > 1) {
            final Resources resources = this.getContext().getResources();
            final int paddingLeft = this.mSearchPlate.getPaddingLeft();
            final Rect rect = new Rect();
            final boolean layoutRtl = ViewUtils.isLayoutRtl((View)this);
            int n;
            if (this.mIconifiedByDefault) {
                n = resources.getDimensionPixelSize(R$dimen.abc_dropdownitem_icon_width) + resources.getDimensionPixelSize(R$dimen.abc_dropdownitem_text_padding_left);
            }
            else {
                n = 0;
            }
            this.mSearchSrcTextView.getDropDownBackground().getPadding(rect);
            int dropDownHorizontalOffset;
            if (layoutRtl) {
                dropDownHorizontalOffset = -rect.left;
            }
            else {
                dropDownHorizontalOffset = paddingLeft - (rect.left + n);
            }
            this.mSearchSrcTextView.setDropDownHorizontalOffset(dropDownHorizontalOffset);
            this.mSearchSrcTextView.setDropDownWidth(this.mDropDownAnchor.getWidth() + rect.left + rect.right + n - paddingLeft);
        }
    }
    
    public void clearFocus() {
        this.mClearingFocus = true;
        this.setImeVisibility(false);
        super.clearFocus();
        this.mSearchSrcTextView.clearFocus();
        this.mClearingFocus = false;
    }
    
    void forceSuggestionQuery() {
        SearchView.HIDDEN_METHOD_INVOKER.doBeforeTextChanged(this.mSearchSrcTextView);
        SearchView.HIDDEN_METHOD_INVOKER.doAfterTextChanged(this.mSearchSrcTextView);
    }
    
    public int getImeOptions() {
        return this.mSearchSrcTextView.getImeOptions();
    }
    
    public int getInputType() {
        return this.mSearchSrcTextView.getInputType();
    }
    
    public int getMaxWidth() {
        return this.mMaxWidth;
    }
    
    public CharSequence getQuery() {
        return (CharSequence)this.mSearchSrcTextView.getText();
    }
    
    public CharSequence getQueryHint() {
        CharSequence charSequence;
        if (this.mQueryHint != null) {
            charSequence = this.mQueryHint;
        }
        else {
            final SearchableInfo mSearchable = this.mSearchable;
            if (mSearchable != null && mSearchable.getHintId() != 0) {
                charSequence = this.getContext().getText(this.mSearchable.getHintId());
            }
            else {
                charSequence = this.mDefaultQueryHint;
            }
        }
        return charSequence;
    }
    
    int getSuggestionCommitIconResId() {
        return this.mSuggestionCommitIconResId;
    }
    
    int getSuggestionRowLayout() {
        return this.mSuggestionRowLayout;
    }
    
    public CursorAdapter getSuggestionsAdapter() {
        return this.mSuggestionsAdapter;
    }
    
    public boolean isIconfiedByDefault() {
        return this.mIconifiedByDefault;
    }
    
    public boolean isIconified() {
        return this.mIconified;
    }
    
    public boolean isQueryRefinementEnabled() {
        return this.mQueryRefinement;
    }
    
    public boolean isSubmitButtonEnabled() {
        return this.mSubmitButtonEnabled;
    }
    
    void launchQuerySearch(final int n, final String s, final String s2) {
        this.getContext().startActivity(this.createIntent("android.intent.action.SEARCH", null, null, s2, n, s));
    }
    
    public void onActionViewCollapsed() {
        this.setQuery("", false);
        this.clearFocus();
        this.updateViewsVisibility(true);
        this.mSearchSrcTextView.setImeOptions(this.mCollapsedImeOptions);
        this.mExpandedInActionView = false;
    }
    
    public void onActionViewExpanded() {
        if (this.mExpandedInActionView) {
            return;
        }
        this.mExpandedInActionView = true;
        this.mCollapsedImeOptions = this.mSearchSrcTextView.getImeOptions();
        this.mSearchSrcTextView.setImeOptions(this.mCollapsedImeOptions | 0x2000000);
        this.mSearchSrcTextView.setText((CharSequence)"");
        this.setIconified(false);
    }
    
    void onCloseClicked() {
        final boolean empty = TextUtils.isEmpty((CharSequence)this.mSearchSrcTextView.getText());
        final boolean imeVisibility = true;
        if (empty) {
            if (this.mIconifiedByDefault) {
                final SearchView$OnCloseListener mOnCloseListener = this.mOnCloseListener;
                if (mOnCloseListener == null || mOnCloseListener.onClose()) {
                    this.clearFocus();
                    this.updateViewsVisibility(imeVisibility);
                }
            }
        }
        else {
            this.mSearchSrcTextView.setText((CharSequence)"");
            this.mSearchSrcTextView.requestFocus();
            this.setImeVisibility(imeVisibility);
        }
    }
    
    protected void onDetachedFromWindow() {
        this.removeCallbacks(this.mUpdateDrawableStateRunnable);
        this.post(this.mReleaseCursorRunnable);
        super.onDetachedFromWindow();
    }
    
    boolean onItemClicked(final int n, final int n2, final String s) {
        final SearchView$OnSuggestionListener mOnSuggestionListener = this.mOnSuggestionListener;
        if (mOnSuggestionListener != null && mOnSuggestionListener.onSuggestionClick(n)) {
            return false;
        }
        this.launchSuggestion(n, 0, null);
        this.setImeVisibility(false);
        this.dismissSuggestions();
        return true;
    }
    
    boolean onItemSelected(final int n) {
        final SearchView$OnSuggestionListener mOnSuggestionListener = this.mOnSuggestionListener;
        if (mOnSuggestionListener != null && mOnSuggestionListener.onSuggestionSelect(n)) {
            return false;
        }
        this.rewriteQueryFromSuggestion(n);
        return true;
    }
    
    protected void onLayout(final boolean b, final int n, final int n2, final int n3, final int n4) {
        super.onLayout(b, n, n2, n3, n4);
        if (b) {
            this.getChildBoundsWithinSearchView((View)this.mSearchSrcTextView, this.mSearchSrcTextViewBounds);
            this.mSearchSrtTextViewBoundsExpanded.set(this.mSearchSrcTextViewBounds.left, 0, this.mSearchSrcTextViewBounds.right, n4 - n2);
            final SearchView$UpdatableTouchDelegate mTouchDelegate = this.mTouchDelegate;
            if (mTouchDelegate == null) {
                this.setTouchDelegate((TouchDelegate)(this.mTouchDelegate = new SearchView$UpdatableTouchDelegate(this.mSearchSrtTextViewBoundsExpanded, this.mSearchSrcTextViewBounds, (View)this.mSearchSrcTextView)));
            }
            else {
                mTouchDelegate.setBounds(this.mSearchSrtTextViewBoundsExpanded, this.mSearchSrcTextViewBounds);
            }
        }
    }
    
    protected void onMeasure(final int n, final int n2) {
        if (this.isIconified()) {
            super.onMeasure(n, n2);
            return;
        }
        final int mode = View$MeasureSpec.getMode(n);
        int n3 = View$MeasureSpec.getSize(n);
        final int n4 = -1 << -1;
        if (mode != n4) {
            if (mode != 0) {
                if (mode == 1073741824) {
                    final int mMaxWidth = this.mMaxWidth;
                    if (mMaxWidth > 0) {
                        n3 = Math.min(mMaxWidth, n3);
                    }
                }
            }
            else {
                int n5 = this.mMaxWidth;
                if (n5 <= 0) {
                    n5 = this.getPreferredWidth();
                }
                n3 = n5;
            }
        }
        else {
            final int mMaxWidth2 = this.mMaxWidth;
            if (mMaxWidth2 > 0) {
                n3 = Math.min(mMaxWidth2, n3);
            }
            else {
                n3 = Math.min(this.getPreferredWidth(), n3);
            }
        }
        final int n6 = 1073741824;
        final int mode2 = View$MeasureSpec.getMode(n2);
        int n7 = View$MeasureSpec.getSize(n2);
        if (mode2 != n4) {
            if (mode2 == 0) {
                n7 = this.getPreferredHeight();
            }
        }
        else {
            n7 = Math.min(this.getPreferredHeight(), n7);
        }
        super.onMeasure(View$MeasureSpec.makeMeasureSpec(n3, n6), View$MeasureSpec.makeMeasureSpec(n7, 1073741824));
    }
    
    void onQueryRefine(final CharSequence query) {
        this.setQuery(query);
    }
    
    protected void onRestoreInstanceState(final Parcelable parcelable) {
        if (!(parcelable instanceof SearchView$SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        final SearchView$SavedState searchView$SavedState = (SearchView$SavedState)parcelable;
        super.onRestoreInstanceState(searchView$SavedState.getSuperState());
        this.updateViewsVisibility(searchView$SavedState.isIconified);
        this.requestLayout();
    }
    
    protected Parcelable onSaveInstanceState() {
        final SearchView$SavedState searchView$SavedState = new SearchView$SavedState(super.onSaveInstanceState());
        searchView$SavedState.isIconified = this.isIconified();
        return (Parcelable)searchView$SavedState;
    }
    
    void onSearchClicked() {
        this.updateViewsVisibility(false);
        this.mSearchSrcTextView.requestFocus();
        this.setImeVisibility(true);
        final View$OnClickListener mOnSearchClickListener = this.mOnSearchClickListener;
        if (mOnSearchClickListener != null) {
            mOnSearchClickListener.onClick((View)this);
        }
    }
    
    void onSubmitQuery() {
        final Editable text = this.mSearchSrcTextView.getText();
        if (text != null && TextUtils.getTrimmedLength((CharSequence)text) > 0) {
            final SearchView$OnQueryTextListener mOnQueryChangeListener = this.mOnQueryChangeListener;
            if (mOnQueryChangeListener == null || mOnQueryChangeListener.onQueryTextSubmit(((CharSequence)text).toString())) {
                if (this.mSearchable != null) {
                    this.launchQuerySearch(0, null, ((CharSequence)text).toString());
                }
                this.setImeVisibility(false);
                this.dismissSuggestions();
            }
        }
    }
    
    boolean onSuggestionsKey(final View view, final int n, final KeyEvent keyEvent) {
        if (this.mSearchable == null) {
            return false;
        }
        if (this.mSuggestionsAdapter == null) {
            return false;
        }
        if (keyEvent.getAction() == 0 && KeyEventCompat.hasNoModifiers(keyEvent)) {
            if (n == 66 || n == 84 || n == 61) {
                return this.onItemClicked(this.mSearchSrcTextView.getListSelection(), 0, null);
            }
            final int n2 = 21;
            if (n == n2 || n == 22) {
                int length;
                if (n == n2) {
                    length = 0;
                }
                else {
                    length = this.mSearchSrcTextView.length();
                }
                this.mSearchSrcTextView.setSelection(length);
                this.mSearchSrcTextView.setListSelection(0);
                this.mSearchSrcTextView.clearListSelection();
                final SearchView$AutoCompleteTextViewReflector hidden_METHOD_INVOKER = SearchView.HIDDEN_METHOD_INVOKER;
                final SearchView$SearchAutoComplete mSearchSrcTextView = this.mSearchSrcTextView;
                final boolean b = true;
                hidden_METHOD_INVOKER.ensureImeVisible(mSearchSrcTextView, b);
                return b;
            }
            if (n == 19 && this.mSearchSrcTextView.getListSelection() == 0) {
                return false;
            }
        }
        return false;
    }
    
    void onTextChanged(final CharSequence charSequence) {
        final Editable text = this.mSearchSrcTextView.getText();
        this.mUserQuery = (CharSequence)text;
        final boolean empty = TextUtils.isEmpty((CharSequence)text);
        boolean b = true;
        final boolean b2 = empty ^ b;
        this.updateSubmitButton(b2);
        if (b2) {
            b = false;
        }
        this.updateVoiceButton(b);
        this.updateCloseButton();
        this.updateSubmitArea();
        if (this.mOnQueryChangeListener != null && !TextUtils.equals(charSequence, this.mOldQueryText)) {
            this.mOnQueryChangeListener.onQueryTextChange(charSequence.toString());
        }
        this.mOldQueryText = charSequence.toString();
    }
    
    void onTextFocusChanged() {
        this.updateViewsVisibility(this.isIconified());
        this.postUpdateFocusedState();
        if (this.mSearchSrcTextView.hasFocus()) {
            this.forceSuggestionQuery();
        }
    }
    
    void onVoiceClicked() {
        if (this.mSearchable == null) {
            return;
        }
        final SearchableInfo mSearchable = this.mSearchable;
        try {
            Label_0051: {
                if (!mSearchable.getVoiceSearchLaunchWebSearch()) {
                    break Label_0051;
                }
                final Intent voiceWebSearchIntent = this.createVoiceWebSearchIntent(this.mVoiceWebSearchIntent, mSearchable);
                try {
                    this.getContext().startActivity(voiceWebSearchIntent);
                    Label_0087: {
                        break Label_0087;
                        final Intent voiceAppSearchIntent = this.createVoiceAppSearchIntent(this.mVoiceAppSearchIntent, mSearchable);
                        try {
                            this.getContext().startActivity(voiceAppSearchIntent);
                        }
                        catch (ActivityNotFoundException ex) {
                            Log.w("SearchView", "Could not find voice search activity");
                        }
                    }
                }
                // iftrue(Label_0087:, !mSearchable.getVoiceSearchLaunchRecognizer())
                catch (ActivityNotFoundException ex2) {}
            }
        }
        catch (ActivityNotFoundException ex3) {}
    }
    
    public void onWindowFocusChanged(final boolean b) {
        super.onWindowFocusChanged(b);
        this.postUpdateFocusedState();
    }
    
    public boolean requestFocus(final int n, final Rect rect) {
        if (this.mClearingFocus) {
            return false;
        }
        if (!this.isFocusable()) {
            return false;
        }
        if (!this.isIconified()) {
            final boolean requestFocus = this.mSearchSrcTextView.requestFocus(n, rect);
            if (requestFocus) {
                this.updateViewsVisibility(false);
            }
            return requestFocus;
        }
        return super.requestFocus(n, rect);
    }
    
    public void setAppSearchData(final Bundle mAppSearchData) {
        this.mAppSearchData = mAppSearchData;
    }
    
    public void setIconified(final boolean b) {
        if (b) {
            this.onCloseClicked();
        }
        else {
            this.onSearchClicked();
        }
    }
    
    public void setIconifiedByDefault(final boolean mIconifiedByDefault) {
        if (this.mIconifiedByDefault == mIconifiedByDefault) {
            return;
        }
        this.updateViewsVisibility(this.mIconifiedByDefault = mIconifiedByDefault);
        this.updateQueryHint();
    }
    
    public void setImeOptions(final int imeOptions) {
        this.mSearchSrcTextView.setImeOptions(imeOptions);
    }
    
    void setImeVisibility(final boolean b) {
        if (b) {
            this.post(this.mShowImeRunnable);
        }
        else {
            this.removeCallbacks(this.mShowImeRunnable);
            final InputMethodManager inputMethodManager = (InputMethodManager)this.getContext().getSystemService("input_method");
            if (inputMethodManager != null) {
                inputMethodManager.hideSoftInputFromWindow(this.getWindowToken(), 0);
            }
        }
    }
    
    public void setInputType(final int inputType) {
        this.mSearchSrcTextView.setInputType(inputType);
    }
    
    public void setMaxWidth(final int mMaxWidth) {
        this.mMaxWidth = mMaxWidth;
        this.requestLayout();
    }
    
    public void setOnCloseListener(final SearchView$OnCloseListener mOnCloseListener) {
        this.mOnCloseListener = mOnCloseListener;
    }
    
    public void setOnQueryTextFocusChangeListener(final View$OnFocusChangeListener mOnQueryTextFocusChangeListener) {
        this.mOnQueryTextFocusChangeListener = mOnQueryTextFocusChangeListener;
    }
    
    public void setOnQueryTextListener(final SearchView$OnQueryTextListener mOnQueryChangeListener) {
        this.mOnQueryChangeListener = mOnQueryChangeListener;
    }
    
    public void setOnSearchClickListener(final View$OnClickListener mOnSearchClickListener) {
        this.mOnSearchClickListener = mOnSearchClickListener;
    }
    
    public void setOnSuggestionListener(final SearchView$OnSuggestionListener mOnSuggestionListener) {
        this.mOnSuggestionListener = mOnSuggestionListener;
    }
    
    public void setQuery(final CharSequence charSequence, final boolean b) {
        this.mSearchSrcTextView.setText(charSequence);
        if (charSequence != null) {
            final SearchView$SearchAutoComplete mSearchSrcTextView = this.mSearchSrcTextView;
            mSearchSrcTextView.setSelection(mSearchSrcTextView.length());
            this.mUserQuery = charSequence;
        }
        if (b && !TextUtils.isEmpty(charSequence)) {
            this.onSubmitQuery();
        }
    }
    
    public void setQueryHint(final CharSequence mQueryHint) {
        this.mQueryHint = mQueryHint;
        this.updateQueryHint();
    }
    
    public void setQueryRefinementEnabled(final boolean mQueryRefinement) {
        this.mQueryRefinement = mQueryRefinement;
        final CursorAdapter mSuggestionsAdapter = this.mSuggestionsAdapter;
        if (mSuggestionsAdapter instanceof SuggestionsAdapter) {
            final SuggestionsAdapter suggestionsAdapter = (SuggestionsAdapter)mSuggestionsAdapter;
            int queryRefinement;
            if (mQueryRefinement) {
                queryRefinement = 2;
            }
            else {
                queryRefinement = 1;
            }
            suggestionsAdapter.setQueryRefinement(queryRefinement);
        }
    }
    
    public void setSearchableInfo(final SearchableInfo mSearchable) {
        this.mSearchable = mSearchable;
        if (this.mSearchable != null) {
            this.updateSearchAutoComplete();
            this.updateQueryHint();
        }
        this.mVoiceButtonEnabled = this.hasVoiceSearch();
        if (this.mVoiceButtonEnabled) {
            this.mSearchSrcTextView.setPrivateImeOptions("nm");
        }
        this.updateViewsVisibility(this.isIconified());
    }
    
    public void setSubmitButtonEnabled(final boolean mSubmitButtonEnabled) {
        this.mSubmitButtonEnabled = mSubmitButtonEnabled;
        this.updateViewsVisibility(this.isIconified());
    }
    
    public void setSuggestionsAdapter(final CursorAdapter mSuggestionsAdapter) {
        this.mSuggestionsAdapter = mSuggestionsAdapter;
        this.mSearchSrcTextView.setAdapter((ListAdapter)this.mSuggestionsAdapter);
    }
    
    void updateFocusedState() {
        int[] array;
        if (this.mSearchSrcTextView.hasFocus()) {
            array = SearchView.FOCUSED_STATE_SET;
        }
        else {
            array = SearchView.EMPTY_STATE_SET;
        }
        final Drawable background = this.mSearchPlate.getBackground();
        if (background != null) {
            background.setState(array);
        }
        final Drawable background2 = this.mSubmitArea.getBackground();
        if (background2 != null) {
            background2.setState(array);
        }
        this.invalidate();
    }
}
