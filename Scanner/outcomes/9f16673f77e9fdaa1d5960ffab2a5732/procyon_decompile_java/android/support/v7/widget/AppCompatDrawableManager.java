// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v7.widget;

import android.support.v7.content.res.AppCompatResources;
import android.support.v7.appcompat.R$color;
import android.support.v4.content.ContextCompat;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.graphics.ColorFilter;
import android.util.AttributeSet;
import android.content.res.XmlResourceParser;
import android.util.Log;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParser;
import android.util.Xml;
import android.support.graphics.drawable.VectorDrawableCompat;
import android.os.Build$VERSION;
import android.graphics.PorterDuffColorFilter;
import android.content.res.Resources;
import android.graphics.drawable.LayerDrawable;
import android.support.v4.graphics.ColorUtils;
import android.support.v7.appcompat.R$attr;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable$ConstantState;
import java.lang.ref.WeakReference;
import android.support.v4.util.LongSparseArray;
import android.graphics.drawable.Drawable;
import android.content.Context;
import android.support.v7.appcompat.R$drawable;
import android.util.TypedValue;
import android.support.v4.util.SparseArrayCompat;
import java.util.WeakHashMap;
import android.support.v4.util.ArrayMap;
import android.graphics.PorterDuff$Mode;

public final class AppCompatDrawableManager
{
    private static final int[] COLORFILTER_COLOR_BACKGROUND_MULTIPLY;
    private static final int[] COLORFILTER_COLOR_CONTROL_ACTIVATED;
    private static final int[] COLORFILTER_TINT_COLOR_CONTROL_NORMAL;
    private static final AppCompatDrawableManager$ColorFilterLruCache COLOR_FILTER_CACHE;
    private static final boolean DEBUG = false;
    private static final PorterDuff$Mode DEFAULT_MODE;
    private static AppCompatDrawableManager INSTANCE;
    private static final String PLATFORM_VD_CLAZZ = "android.graphics.drawable.VectorDrawable";
    private static final String SKIP_DRAWABLE_TAG = "appcompat_skip_skip";
    private static final String TAG = "AppCompatDrawableManager";
    private static final int[] TINT_CHECKABLE_BUTTON_LIST;
    private static final int[] TINT_COLOR_CONTROL_NORMAL;
    private static final int[] TINT_COLOR_CONTROL_STATE_LIST;
    private ArrayMap mDelegates;
    private final Object mDrawableCacheLock;
    private final WeakHashMap mDrawableCaches;
    private boolean mHasCheckedVectorDrawableSetup;
    private SparseArrayCompat mKnownDrawableIdTags;
    private WeakHashMap mTintLists;
    private TypedValue mTypedValue;
    
    static {
        DEFAULT_MODE = PorterDuff$Mode.SRC_IN;
        final int n = 6;
        COLOR_FILTER_CACHE = new AppCompatDrawableManager$ColorFilterLruCache(n);
        final int n2 = 3;
        final int[] colorfilter_TINT_COLOR_CONTROL_NORMAL = new int[n2];
        colorfilter_TINT_COLOR_CONTROL_NORMAL[0] = R$drawable.abc_textfield_search_default_mtrl_alpha;
        final int abc_textfield_default_mtrl_alpha = R$drawable.abc_textfield_default_mtrl_alpha;
        final int n3 = 1;
        colorfilter_TINT_COLOR_CONTROL_NORMAL[n3] = abc_textfield_default_mtrl_alpha;
        final int abc_ab_share_pack_mtrl_alpha = R$drawable.abc_ab_share_pack_mtrl_alpha;
        final int n4 = 2;
        colorfilter_TINT_COLOR_CONTROL_NORMAL[n4] = abc_ab_share_pack_mtrl_alpha;
        COLORFILTER_TINT_COLOR_CONTROL_NORMAL = colorfilter_TINT_COLOR_CONTROL_NORMAL;
        final int n5 = 7;
        final int[] tint_COLOR_CONTROL_NORMAL = new int[n5];
        tint_COLOR_CONTROL_NORMAL[0] = R$drawable.abc_ic_commit_search_api_mtrl_alpha;
        tint_COLOR_CONTROL_NORMAL[n3] = R$drawable.abc_seekbar_tick_mark_material;
        tint_COLOR_CONTROL_NORMAL[n4] = R$drawable.abc_ic_menu_share_mtrl_alpha;
        tint_COLOR_CONTROL_NORMAL[n2] = R$drawable.abc_ic_menu_copy_mtrl_am_alpha;
        final int abc_ic_menu_cut_mtrl_alpha = R$drawable.abc_ic_menu_cut_mtrl_alpha;
        final int n6 = 4;
        tint_COLOR_CONTROL_NORMAL[n6] = abc_ic_menu_cut_mtrl_alpha;
        final int abc_ic_menu_selectall_mtrl_alpha = R$drawable.abc_ic_menu_selectall_mtrl_alpha;
        final int n7 = 5;
        tint_COLOR_CONTROL_NORMAL[n7] = abc_ic_menu_selectall_mtrl_alpha;
        tint_COLOR_CONTROL_NORMAL[n] = R$drawable.abc_ic_menu_paste_mtrl_am_alpha;
        TINT_COLOR_CONTROL_NORMAL = tint_COLOR_CONTROL_NORMAL;
        final int[] colorfilter_COLOR_CONTROL_ACTIVATED = new int[10];
        colorfilter_COLOR_CONTROL_ACTIVATED[0] = R$drawable.abc_textfield_activated_mtrl_alpha;
        colorfilter_COLOR_CONTROL_ACTIVATED[n3] = R$drawable.abc_textfield_search_activated_mtrl_alpha;
        colorfilter_COLOR_CONTROL_ACTIVATED[n4] = R$drawable.abc_cab_background_top_mtrl_alpha;
        colorfilter_COLOR_CONTROL_ACTIVATED[n2] = R$drawable.abc_text_cursor_material;
        colorfilter_COLOR_CONTROL_ACTIVATED[n6] = R$drawable.abc_text_select_handle_left_mtrl_dark;
        colorfilter_COLOR_CONTROL_ACTIVATED[n7] = R$drawable.abc_text_select_handle_middle_mtrl_dark;
        colorfilter_COLOR_CONTROL_ACTIVATED[n] = R$drawable.abc_text_select_handle_right_mtrl_dark;
        colorfilter_COLOR_CONTROL_ACTIVATED[n5] = R$drawable.abc_text_select_handle_left_mtrl_light;
        colorfilter_COLOR_CONTROL_ACTIVATED[8] = R$drawable.abc_text_select_handle_middle_mtrl_light;
        colorfilter_COLOR_CONTROL_ACTIVATED[9] = R$drawable.abc_text_select_handle_right_mtrl_light;
        COLORFILTER_COLOR_CONTROL_ACTIVATED = colorfilter_COLOR_CONTROL_ACTIVATED;
        final int[] colorfilter_COLOR_BACKGROUND_MULTIPLY = new int[n2];
        colorfilter_COLOR_BACKGROUND_MULTIPLY[0] = R$drawable.abc_popup_background_mtrl_mult;
        colorfilter_COLOR_BACKGROUND_MULTIPLY[n3] = R$drawable.abc_cab_background_internal_bg;
        colorfilter_COLOR_BACKGROUND_MULTIPLY[n4] = R$drawable.abc_menu_hardkey_panel_mtrl_mult;
        COLORFILTER_COLOR_BACKGROUND_MULTIPLY = colorfilter_COLOR_BACKGROUND_MULTIPLY;
        final int[] tint_COLOR_CONTROL_STATE_LIST = new int[n4];
        tint_COLOR_CONTROL_STATE_LIST[0] = R$drawable.abc_tab_indicator_material;
        tint_COLOR_CONTROL_STATE_LIST[n3] = R$drawable.abc_textfield_search_material;
        TINT_COLOR_CONTROL_STATE_LIST = tint_COLOR_CONTROL_STATE_LIST;
        final int[] tint_CHECKABLE_BUTTON_LIST = new int[n4];
        tint_CHECKABLE_BUTTON_LIST[0] = R$drawable.abc_btn_check_material;
        tint_CHECKABLE_BUTTON_LIST[n3] = R$drawable.abc_btn_radio_material;
        TINT_CHECKABLE_BUTTON_LIST = tint_CHECKABLE_BUTTON_LIST;
    }
    
    public AppCompatDrawableManager() {
        this.mDrawableCacheLock = new Object();
        this.mDrawableCaches = new WeakHashMap(0);
    }
    
    private void addDelegate(final String s, final AppCompatDrawableManager$InflateDelegate appCompatDrawableManager$InflateDelegate) {
        if (this.mDelegates == null) {
            this.mDelegates = new ArrayMap();
        }
        this.mDelegates.put(s, appCompatDrawableManager$InflateDelegate);
    }
    
    private boolean addDrawableToCache(final Context context, final long n, final Drawable drawable) {
        final Drawable$ConstantState constantState = drawable.getConstantState();
        if (constantState != null) {
            synchronized (this.mDrawableCacheLock) {
                LongSparseArray longSparseArray = this.mDrawableCaches.get(context);
                if (longSparseArray == null) {
                    longSparseArray = new LongSparseArray();
                    this.mDrawableCaches.put(context, longSparseArray);
                }
                longSparseArray.put(n, new WeakReference(constantState));
                return true;
            }
        }
        return false;
    }
    
    private void addTintListToCache(final Context context, final int n, final ColorStateList list) {
        if (this.mTintLists == null) {
            this.mTintLists = new WeakHashMap();
        }
        SparseArrayCompat sparseArrayCompat = this.mTintLists.get(context);
        if (sparseArrayCompat == null) {
            sparseArrayCompat = new SparseArrayCompat();
            this.mTintLists.put(context, sparseArrayCompat);
        }
        sparseArrayCompat.append(n, list);
    }
    
    private static boolean arrayContains(final int[] array, final int n) {
        for (int length = array.length, i = 0; i < length; ++i) {
            if (array[i] == n) {
                return true;
            }
        }
        return false;
    }
    
    private void checkVectorDrawableSetup(final Context context) {
        if (this.mHasCheckedVectorDrawableSetup) {
            return;
        }
        this.mHasCheckedVectorDrawableSetup = true;
        final Drawable drawable = this.getDrawable(context, R$drawable.abc_vector_test);
        if (drawable != null && isVectorDrawable(drawable)) {
            return;
        }
        this.mHasCheckedVectorDrawableSetup = false;
        throw new IllegalStateException("This app has been built with an incorrect configuration. Please configure your build for VectorDrawableCompat.");
    }
    
    private ColorStateList createBorderlessButtonColorStateList(final Context context) {
        return this.createButtonColorStateList(context, 0);
    }
    
    private ColorStateList createButtonColorStateList(final Context context, final int n) {
        final int n2 = 4;
        final int[][] array = new int[n2][];
        final int[] array2 = new int[n2];
        final int themeAttrColor = ThemeUtils.getThemeAttrColor(context, R$attr.colorControlHighlight);
        final int disabledThemeAttrColor = ThemeUtils.getDisabledThemeAttrColor(context, R$attr.colorButtonNormal);
        array[0] = ThemeUtils.DISABLED_STATE_SET;
        array2[0] = disabledThemeAttrColor;
        final int n3 = 0 + 1;
        array[n3] = ThemeUtils.PRESSED_STATE_SET;
        array2[n3] = ColorUtils.compositeColors(themeAttrColor, n);
        final int n4 = n3 + 1;
        array[n4] = ThemeUtils.FOCUSED_STATE_SET;
        array2[n4] = ColorUtils.compositeColors(themeAttrColor, n);
        final int n5 = n4 + 1;
        array[n5] = ThemeUtils.EMPTY_STATE_SET;
        array2[n5] = n;
        return new ColorStateList(array, array2);
    }
    
    private static long createCacheKey(final TypedValue typedValue) {
        return typedValue.assetCookie << 32 | typedValue.data;
    }
    
    private ColorStateList createColoredButtonColorStateList(final Context context) {
        return this.createButtonColorStateList(context, ThemeUtils.getThemeAttrColor(context, R$attr.colorAccent));
    }
    
    private ColorStateList createDefaultButtonColorStateList(final Context context) {
        return this.createButtonColorStateList(context, ThemeUtils.getThemeAttrColor(context, R$attr.colorButtonNormal));
    }
    
    private Drawable createDrawableIfNeeded(final Context context, final int n) {
        if (this.mTypedValue == null) {
            this.mTypedValue = new TypedValue();
        }
        final TypedValue mTypedValue = this.mTypedValue;
        final Resources resources = context.getResources();
        final int n2 = 1;
        resources.getValue(n, mTypedValue, (boolean)(n2 != 0));
        final long cacheKey = createCacheKey(mTypedValue);
        Object cachedDrawable = this.getCachedDrawable(context, cacheKey);
        if (cachedDrawable != null) {
            return (Drawable)cachedDrawable;
        }
        if (n == R$drawable.abc_cab_background_top_material) {
            final Drawable[] array = { this.getDrawable(context, R$drawable.abc_cab_background_internal_bg), null };
            array[n2] = this.getDrawable(context, R$drawable.abc_cab_background_top_mtrl_alpha);
            cachedDrawable = new LayerDrawable(array);
        }
        if (cachedDrawable != null) {
            ((Drawable)cachedDrawable).setChangingConfigurations(mTypedValue.changingConfigurations);
            this.addDrawableToCache(context, cacheKey, (Drawable)cachedDrawable);
        }
        return (Drawable)cachedDrawable;
    }
    
    private static PorterDuffColorFilter createTintFilter(final ColorStateList list, final PorterDuff$Mode porterDuff$Mode, final int[] array) {
        if (list != null && porterDuff$Mode != null) {
            return getPorterDuffColorFilter(list.getColorForState(array, 0), porterDuff$Mode);
        }
        return null;
    }
    
    public static AppCompatDrawableManager get() {
        if (AppCompatDrawableManager.INSTANCE == null) {
            installDefaultInflateDelegates(AppCompatDrawableManager.INSTANCE = new AppCompatDrawableManager());
        }
        return AppCompatDrawableManager.INSTANCE;
    }
    
    private Drawable getCachedDrawable(final Context context, final long n) {
        synchronized (this.mDrawableCacheLock) {
            final LongSparseArray longSparseArray = this.mDrawableCaches.get(context);
            if (longSparseArray == null) {
                return null;
            }
            final WeakReference<Object> weakReference = (WeakReference<Object>)longSparseArray.get(n);
            if (weakReference != null) {
                final Drawable$ConstantState drawable$ConstantState = weakReference.get();
                if (drawable$ConstantState != null) {
                    return drawable$ConstantState.newDrawable(context.getResources());
                }
                longSparseArray.delete(n);
            }
            return null;
        }
    }
    
    public static PorterDuffColorFilter getPorterDuffColorFilter(final int n, final PorterDuff$Mode porterDuff$Mode) {
        PorterDuffColorFilter value = AppCompatDrawableManager.COLOR_FILTER_CACHE.get(n, porterDuff$Mode);
        if (value == null) {
            value = new PorterDuffColorFilter(n, porterDuff$Mode);
            AppCompatDrawableManager.COLOR_FILTER_CACHE.put(n, porterDuff$Mode, value);
        }
        return value;
    }
    
    private ColorStateList getTintListFromCache(final Context context, final int n) {
        final WeakHashMap mTintLists = this.mTintLists;
        ColorStateList list = null;
        if (mTintLists != null) {
            final SparseArrayCompat sparseArrayCompat = mTintLists.get(context);
            if (sparseArrayCompat != null) {
                list = (ColorStateList)sparseArrayCompat.get(n);
            }
            return list;
        }
        return null;
    }
    
    static PorterDuff$Mode getTintMode(final int n) {
        PorterDuff$Mode multiply = null;
        if (n == R$drawable.abc_switch_thumb_material) {
            multiply = PorterDuff$Mode.MULTIPLY;
        }
        return multiply;
    }
    
    private static void installDefaultInflateDelegates(final AppCompatDrawableManager appCompatDrawableManager) {
        if (Build$VERSION.SDK_INT < 24) {
            appCompatDrawableManager.addDelegate("vector", new AppCompatDrawableManager$VdcInflateDelegate());
            if (Build$VERSION.SDK_INT >= 11) {
                appCompatDrawableManager.addDelegate("animated-vector", new AppCompatDrawableManager$AvdcInflateDelegate());
            }
        }
    }
    
    private static boolean isVectorDrawable(final Drawable drawable) {
        return drawable instanceof VectorDrawableCompat || "android.graphics.drawable.VectorDrawable".equals(drawable.getClass().getName());
    }
    
    private Drawable loadDrawableFromDelegates(final Context context, final int n) {
        final ArrayMap mDelegates = this.mDelegates;
        if (mDelegates == null || mDelegates.isEmpty()) {
            return null;
        }
        final SparseArrayCompat mKnownDrawableIdTags = this.mKnownDrawableIdTags;
        if (mKnownDrawableIdTags != null) {
            final String s = (String)mKnownDrawableIdTags.get(n);
            if ("appcompat_skip_skip".equals(s) || (s != null && this.mDelegates.get(s) == null)) {
                return null;
            }
        }
        else {
            this.mKnownDrawableIdTags = new SparseArrayCompat();
        }
        if (this.mTypedValue == null) {
            this.mTypedValue = new TypedValue();
        }
        final TypedValue mTypedValue = this.mTypedValue;
        final Resources resources = context.getResources();
        final boolean b = true;
        resources.getValue(n, mTypedValue, b);
        final long cacheKey = createCacheKey(mTypedValue);
        Drawable drawable = this.getCachedDrawable(context, cacheKey);
        if (drawable != null) {
            return drawable;
        }
        Label_0425: {
            if (mTypedValue.string != null && mTypedValue.string.toString().endsWith(".xml")) {
                final Resources resources2 = resources;
                try {
                    final XmlResourceParser xml = resources2.getXml(n);
                    try {
                        final AttributeSet attributeSet = Xml.asAttributeSet((XmlPullParser)xml);
                        try {
                            int next;
                            int n2;
                            int n3;
                            do {
                                n2 = (next = ((XmlPullParser)xml).next());
                                n3 = 2;
                            } while (n2 != n3 && n2 != (b ? 1 : 0));
                            Label_0381: {
                                if (next != n3) {
                                    break Label_0381;
                                }
                                final String name = ((XmlPullParser)xml).getName();
                                try {
                                    this.mKnownDrawableIdTags.append(n, name);
                                    final Object value = this.mDelegates.get(name);
                                    try {
                                        final AppCompatDrawableManager$InflateDelegate appCompatDrawableManager$InflateDelegate = (AppCompatDrawableManager$InflateDelegate)value;
                                        if (appCompatDrawableManager$InflateDelegate != null) {
                                            drawable = appCompatDrawableManager$InflateDelegate.createFromXmlInner(context, (XmlPullParser)xml, attributeSet, context.getTheme());
                                        }
                                        if (drawable != null) {
                                            drawable.setChangingConfigurations(mTypedValue.changingConfigurations);
                                            this.addDrawableToCache(context, cacheKey, drawable);
                                        }
                                        break Label_0425;
                                        throw new XmlPullParserException("No start tag found");
                                    }
                                    catch (Exception ex) {
                                        Log.e("AppCompatDrawableManager", "Exception while inflating drawable", (Throwable)ex);
                                    }
                                }
                                catch (Exception ex2) {}
                            }
                        }
                        catch (Exception ex3) {}
                    }
                    catch (Exception ex4) {}
                }
                catch (Exception ex5) {}
            }
        }
        if (drawable == null) {
            this.mKnownDrawableIdTags.append(n, "appcompat_skip_skip");
        }
        return drawable;
    }
    
    private void removeDelegate(final String s, final AppCompatDrawableManager$InflateDelegate appCompatDrawableManager$InflateDelegate) {
        final ArrayMap mDelegates = this.mDelegates;
        if (mDelegates != null && mDelegates.get(s) == appCompatDrawableManager$InflateDelegate) {
            this.mDelegates.remove(s);
        }
    }
    
    private static void setPorterDuffColorFilter(Drawable mutate, final int n, final PorterDuff$Mode porterDuff$Mode) {
        if (DrawableUtils.canSafelyMutateDrawable(mutate)) {
            mutate = mutate.mutate();
        }
        PorterDuff$Mode default_MODE;
        if (porterDuff$Mode == null) {
            default_MODE = AppCompatDrawableManager.DEFAULT_MODE;
        }
        else {
            default_MODE = porterDuff$Mode;
        }
        mutate.setColorFilter((ColorFilter)getPorterDuffColorFilter(n, default_MODE));
    }
    
    private Drawable tintDrawable(final Context context, final int n, final boolean b, Drawable drawable) {
        final ColorStateList tintList = this.getTintList(context, n);
        if (tintList != null) {
            if (DrawableUtils.canSafelyMutateDrawable(drawable)) {
                drawable = drawable.mutate();
            }
            drawable = DrawableCompat.wrap(drawable);
            DrawableCompat.setTintList(drawable, tintList);
            final PorterDuff$Mode tintMode = getTintMode(n);
            if (tintMode != null) {
                DrawableCompat.setTintMode(drawable, tintMode);
            }
        }
        else {
            final int abc_seekbar_track_material = R$drawable.abc_seekbar_track_material;
            final int n2 = 16908301;
            final int n3 = 16908303;
            final int n4 = 16908288;
            if (n == abc_seekbar_track_material) {
                final LayerDrawable layerDrawable = (LayerDrawable)drawable;
                setPorterDuffColorFilter(layerDrawable.findDrawableByLayerId(n4), ThemeUtils.getThemeAttrColor(context, R$attr.colorControlNormal), AppCompatDrawableManager.DEFAULT_MODE);
                setPorterDuffColorFilter(layerDrawable.findDrawableByLayerId(n3), ThemeUtils.getThemeAttrColor(context, R$attr.colorControlNormal), AppCompatDrawableManager.DEFAULT_MODE);
                setPorterDuffColorFilter(layerDrawable.findDrawableByLayerId(n2), ThemeUtils.getThemeAttrColor(context, R$attr.colorControlActivated), AppCompatDrawableManager.DEFAULT_MODE);
            }
            else if (n != R$drawable.abc_ratingbar_material && n != R$drawable.abc_ratingbar_indicator_material && n != R$drawable.abc_ratingbar_small_material) {
                if (!tintDrawableUsingColorFilter(context, n, drawable) && b) {
                    drawable = null;
                }
            }
            else {
                final LayerDrawable layerDrawable2 = (LayerDrawable)drawable;
                setPorterDuffColorFilter(layerDrawable2.findDrawableByLayerId(n4), ThemeUtils.getDisabledThemeAttrColor(context, R$attr.colorControlNormal), AppCompatDrawableManager.DEFAULT_MODE);
                setPorterDuffColorFilter(layerDrawable2.findDrawableByLayerId(n3), ThemeUtils.getThemeAttrColor(context, R$attr.colorControlActivated), AppCompatDrawableManager.DEFAULT_MODE);
                setPorterDuffColorFilter(layerDrawable2.findDrawableByLayerId(n2), ThemeUtils.getThemeAttrColor(context, R$attr.colorControlActivated), AppCompatDrawableManager.DEFAULT_MODE);
            }
        }
        return drawable;
    }
    
    static void tintDrawable(final Drawable drawable, final TintInfo tintInfo, final int[] array) {
        if (DrawableUtils.canSafelyMutateDrawable(drawable) && drawable.mutate() != drawable) {
            Log.d("AppCompatDrawableManager", "Mutated drawable is not the same instance as the input.");
            return;
        }
        if (!tintInfo.mHasTintList && !tintInfo.mHasTintMode) {
            drawable.clearColorFilter();
        }
        else {
            ColorStateList mTintList;
            if (tintInfo.mHasTintList) {
                mTintList = tintInfo.mTintList;
            }
            else {
                mTintList = null;
            }
            PorterDuff$Mode porterDuff$Mode;
            if (tintInfo.mHasTintMode) {
                porterDuff$Mode = tintInfo.mTintMode;
            }
            else {
                porterDuff$Mode = AppCompatDrawableManager.DEFAULT_MODE;
            }
            drawable.setColorFilter((ColorFilter)createTintFilter(mTintList, porterDuff$Mode, array));
        }
        if (Build$VERSION.SDK_INT <= 23) {
            drawable.invalidateSelf();
        }
    }
    
    static boolean tintDrawableUsingColorFilter(final Context context, final int n, Drawable mutate) {
        PorterDuff$Mode porterDuff$Mode = AppCompatDrawableManager.DEFAULT_MODE;
        boolean b = false;
        int n2 = 0;
        int round = -1;
        if (arrayContains(AppCompatDrawableManager.COLORFILTER_TINT_COLOR_CONTROL_NORMAL, n)) {
            n2 = R$attr.colorControlNormal;
            b = true;
        }
        else if (arrayContains(AppCompatDrawableManager.COLORFILTER_COLOR_CONTROL_ACTIVATED, n)) {
            n2 = R$attr.colorControlActivated;
            b = true;
        }
        else if (arrayContains(AppCompatDrawableManager.COLORFILTER_COLOR_BACKGROUND_MULTIPLY, n)) {
            n2 = 16842801;
            b = true;
            porterDuff$Mode = PorterDuff$Mode.MULTIPLY;
        }
        else if (n == R$drawable.abc_list_divider_mtrl_alpha) {
            n2 = 16842800;
            b = true;
            round = Math.round(40.8f);
        }
        else if (n == R$drawable.abc_dialog_material_background) {
            n2 = 16842801;
            b = true;
        }
        if (b) {
            if (DrawableUtils.canSafelyMutateDrawable(mutate)) {
                mutate = mutate.mutate();
            }
            mutate.setColorFilter((ColorFilter)getPorterDuffColorFilter(ThemeUtils.getThemeAttrColor(context, n2), porterDuff$Mode));
            if (round != -1) {
                mutate.setAlpha(round);
            }
            return true;
        }
        return false;
    }
    
    public Drawable getDrawable(final Context context, final int n) {
        return this.getDrawable(context, n, false);
    }
    
    Drawable getDrawable(final Context context, final int n, final boolean b) {
        this.checkVectorDrawableSetup(context);
        Drawable drawable = this.loadDrawableFromDelegates(context, n);
        if (drawable == null) {
            drawable = this.createDrawableIfNeeded(context, n);
        }
        if (drawable == null) {
            drawable = ContextCompat.getDrawable(context, n);
        }
        if (drawable != null) {
            drawable = this.tintDrawable(context, n, b, drawable);
        }
        if (drawable != null) {
            DrawableUtils.fixDrawable(drawable);
        }
        return drawable;
    }
    
    ColorStateList getTintList(final Context context, final int n) {
        ColorStateList list = this.getTintListFromCache(context, n);
        if (list == null) {
            if (n == R$drawable.abc_edit_text_material) {
                list = AppCompatResources.getColorStateList(context, R$color.abc_tint_edittext);
            }
            else if (n == R$drawable.abc_switch_track_mtrl_alpha) {
                list = AppCompatResources.getColorStateList(context, R$color.abc_tint_switch_track);
            }
            else if (n == R$drawable.abc_switch_thumb_material) {
                list = AppCompatResources.getColorStateList(context, R$color.abc_tint_switch_thumb);
            }
            else if (n == R$drawable.abc_btn_default_mtrl_shape) {
                list = this.createDefaultButtonColorStateList(context);
            }
            else if (n == R$drawable.abc_btn_borderless_material) {
                list = this.createBorderlessButtonColorStateList(context);
            }
            else if (n == R$drawable.abc_btn_colored_material) {
                list = this.createColoredButtonColorStateList(context);
            }
            else if (n != R$drawable.abc_spinner_mtrl_am_alpha && n != R$drawable.abc_spinner_textfield_background_material) {
                if (arrayContains(AppCompatDrawableManager.TINT_COLOR_CONTROL_NORMAL, n)) {
                    list = ThemeUtils.getThemeAttrColorStateList(context, R$attr.colorControlNormal);
                }
                else if (arrayContains(AppCompatDrawableManager.TINT_COLOR_CONTROL_STATE_LIST, n)) {
                    list = AppCompatResources.getColorStateList(context, R$color.abc_tint_default);
                }
                else if (arrayContains(AppCompatDrawableManager.TINT_CHECKABLE_BUTTON_LIST, n)) {
                    list = AppCompatResources.getColorStateList(context, R$color.abc_tint_btn_checkable);
                }
                else if (n == R$drawable.abc_seekbar_thumb_material) {
                    list = AppCompatResources.getColorStateList(context, R$color.abc_tint_seek_thumb);
                }
            }
            else {
                list = AppCompatResources.getColorStateList(context, R$color.abc_tint_spinner);
            }
            if (list != null) {
                this.addTintListToCache(context, n, list);
            }
        }
        return list;
    }
    
    public void onConfigurationChanged(final Context context) {
        synchronized (this.mDrawableCacheLock) {
            final LongSparseArray longSparseArray = this.mDrawableCaches.get(context);
            if (longSparseArray != null) {
                longSparseArray.clear();
            }
        }
    }
    
    Drawable onDrawableLoadedFromResources(final Context context, final VectorEnabledTintResources vectorEnabledTintResources, final int n) {
        Drawable drawable = this.loadDrawableFromDelegates(context, n);
        if (drawable == null) {
            drawable = vectorEnabledTintResources.superGetDrawable(n);
        }
        if (drawable != null) {
            return this.tintDrawable(context, n, false, drawable);
        }
        return null;
    }
}
