// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v7.app;

import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.AppCompatSpinner;
import android.support.v7.widget.AppCompatImageButton;
import android.support.v7.widget.AppCompatCheckBox;
import android.support.v7.widget.AppCompatRadioButton;
import android.support.v7.widget.AppCompatCheckedTextView;
import android.support.v7.widget.AppCompatAutoCompleteTextView;
import android.support.v7.widget.AppCompatMultiAutoCompleteTextView;
import android.support.v7.widget.AppCompatRatingBar;
import android.support.v7.widget.AppCompatSeekBar;
import android.support.v7.widget.TintContextWrapper;
import android.support.v7.view.ContextThemeWrapper;
import android.util.Log;
import android.support.v7.appcompat.R$styleable;
import java.lang.reflect.Executable;
import java.lang.reflect.Constructor;
import android.content.res.TypedArray;
import android.view.View$OnClickListener;
import android.support.v4.view.ViewCompat;
import android.os.Build$VERSION;
import android.content.ContextWrapper;
import android.view.View;
import android.support.v4.util.ArrayMap;
import android.util.AttributeSet;
import android.content.Context;
import java.util.Map;

class AppCompatViewInflater
{
    private static final String LOG_TAG = "AppCompatViewInflater";
    private static final String[] sClassPrefixList;
    private static final Map sConstructorMap;
    private static final Class[] sConstructorSignature;
    private static final int[] sOnClickAttrs;
    private final Object[] mConstructorArgs;
    
    static {
        final int n = 2;
        final Class[] sConstructorSignature2 = new Class[n];
        sConstructorSignature2[0] = Context.class;
        final int n2 = 1;
        sConstructorSignature2[n2] = AttributeSet.class;
        sConstructorSignature = sConstructorSignature2;
        final int[] sOnClickAttrs2 = new int[n2];
        sOnClickAttrs2[0] = 16843375;
        sOnClickAttrs = sOnClickAttrs2;
        final String[] sClassPrefixList2 = { "android.widget.", null, null };
        sClassPrefixList2[n2] = "android.view.";
        sClassPrefixList2[n] = "android.webkit.";
        sClassPrefixList = sClassPrefixList2;
        sConstructorMap = new ArrayMap();
    }
    
    AppCompatViewInflater() {
        this.mConstructorArgs = new Object[2];
    }
    
    private void checkOnClickListener(final View view, final AttributeSet set) {
        final Context context = view.getContext();
        if (context instanceof ContextWrapper && (Build$VERSION.SDK_INT < 15 || ViewCompat.hasOnClickListeners(view))) {
            final TypedArray obtainStyledAttributes = context.obtainStyledAttributes(set, AppCompatViewInflater.sOnClickAttrs);
            final String string = obtainStyledAttributes.getString(0);
            if (string != null) {
                view.setOnClickListener((View$OnClickListener)new AppCompatViewInflater$DeclaredOnClickListener(view, string));
            }
            obtainStyledAttributes.recycle();
        }
    }
    
    private View createView(final Context context, final String s, final String s2) {
        Executable constructor = AppCompatViewInflater.sConstructorMap.get(s);
        Label_0125: {
            if (constructor != null) {
                break Label_0125;
            }
            try {
                final ClassLoader classLoader = context.getClassLoader();
                Label_0063: {
                    if (s2 == null) {
                        break Label_0063;
                    }
                    try {
                        final StringBuilder sb2;
                        final StringBuilder sb = sb2 = new StringBuilder();
                        try {
                            sb2.append(s2);
                            final StringBuilder sb3 = sb;
                            try {
                                sb3.append(s);
                                String string = sb.toString();
                                final Class<? extends View> subclass = classLoader.loadClass(string).asSubclass(View.class);
                                try {
                                    constructor = subclass.getConstructor((Class<?>[])AppCompatViewInflater.sConstructorSignature);
                                    AppCompatViewInflater.sConstructorMap.put(s, constructor);
                                    constructor.setAccessible(true);
                                    final View instance = ((Constructor<View>)constructor).newInstance(this.mConstructorArgs);
                                    try {
                                        return instance;
                                    }
                                    catch (Exception ex) {
                                        return null;
                                    }
                                }
                                catch (Exception ex2) {}
                                string = s;
                            }
                            catch (Exception ex3) {}
                        }
                        catch (Exception ex4) {}
                    }
                    catch (Exception ex5) {}
                }
            }
            catch (Exception ex6) {}
        }
    }
    
    private View createViewFromTag(final Context context, String attributeValue, final AttributeSet set) {
        if (attributeValue.equals("view")) {
            attributeValue = set.getAttributeValue((String)null, "class");
        }
        final int n = 1;
        try {
            this.mConstructorArgs[0] = context;
            this.mConstructorArgs[n] = set;
            Label_0180: {
                if (-1 != attributeValue.indexOf(46)) {
                    break Label_0180;
                }
                int n2 = 0;
                while (true) {
                    final String[] sClassPrefixList = AppCompatViewInflater.sClassPrefixList;
                    try {
                        if (n2 >= sClassPrefixList.length) {
                            return null;
                        }
                        final View view = this.createView(context, attributeValue, AppCompatViewInflater.sClassPrefixList[n2]);
                        if (view != null) {
                            return view;
                        }
                        ++n2;
                        continue;
                        return this.createView(context, attributeValue, null);
                    }
                    catch (Exception ex) {
                        return null;
                    }
                }
            }
        }
        catch (Exception ex2) {}
    }
    
    private static Context themifyContext(Context context, final AttributeSet set, final boolean b, final boolean b2) {
        final TypedArray obtainStyledAttributes = context.obtainStyledAttributes(set, R$styleable.View, 0, 0);
        int n = 0;
        if (b) {
            n = obtainStyledAttributes.getResourceId(R$styleable.View_android_theme, 0);
        }
        if (b2 && n == 0) {
            n = obtainStyledAttributes.getResourceId(R$styleable.View_theme, 0);
            if (n != 0) {
                Log.i("AppCompatViewInflater", "app:theme is now deprecated. Please move to using android:theme instead.");
            }
        }
        obtainStyledAttributes.recycle();
        if (n != 0) {
            if (!(context instanceof ContextThemeWrapper) || ((ContextThemeWrapper)context).getThemeResId() != n) {
                context = (Context)new ContextThemeWrapper(context, n);
            }
        }
        return context;
    }
    
    public final View createView(final View view, final String s, Context context, final AttributeSet set, final boolean b, final boolean b2, final boolean b3, final boolean b4) {
        final Context context2 = context;
        if (b && view != null) {
            context = view.getContext();
        }
        if (b2 || b3) {
            context = themifyContext(context, set, b2, b3);
        }
        if (b4) {
            context = TintContextWrapper.wrap(context);
        }
        Object viewFromTag = null;
        switch (s) {
            case "SeekBar": {
                viewFromTag = new AppCompatSeekBar(context, set);
                break;
            }
            case "RatingBar": {
                viewFromTag = new AppCompatRatingBar(context, set);
                break;
            }
            case "MultiAutoCompleteTextView": {
                viewFromTag = new AppCompatMultiAutoCompleteTextView(context, set);
                break;
            }
            case "AutoCompleteTextView": {
                viewFromTag = new AppCompatAutoCompleteTextView(context, set);
                break;
            }
            case "CheckedTextView": {
                viewFromTag = new AppCompatCheckedTextView(context, set);
                break;
            }
            case "RadioButton": {
                viewFromTag = new AppCompatRadioButton(context, set);
                break;
            }
            case "CheckBox": {
                viewFromTag = new AppCompatCheckBox(context, set);
                break;
            }
            case "ImageButton": {
                viewFromTag = new AppCompatImageButton(context, set);
                break;
            }
            case "Spinner": {
                viewFromTag = new AppCompatSpinner(context, set);
                break;
            }
            case "EditText": {
                viewFromTag = new AppCompatEditText(context, set);
                break;
            }
            case "Button": {
                viewFromTag = new AppCompatButton(context, set);
                break;
            }
            case "ImageView": {
                viewFromTag = new AppCompatImageView(context, set);
                break;
            }
            case "TextView": {
                viewFromTag = new AppCompatTextView(context, set);
                break;
            }
        }
        if (viewFromTag == null && context2 != context) {
            viewFromTag = this.createViewFromTag(context, s, set);
        }
        if (viewFromTag != null) {
            this.checkOnClickListener((View)viewFromTag, set);
        }
        return (View)viewFromTag;
    }
}
