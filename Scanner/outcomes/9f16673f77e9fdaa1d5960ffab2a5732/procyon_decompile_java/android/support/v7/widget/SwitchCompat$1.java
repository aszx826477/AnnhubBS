// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v7.widget;

import android.support.v7.content.res.AppCompatResources;
import android.support.v7.text.AllCapsTransformationMethod;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.ViewCompat;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityEvent;
import android.graphics.Region$Op;
import android.text.TextUtils;
import android.graphics.Canvas;
import android.graphics.Typeface;
import android.text.StaticLayout;
import android.text.Layout$Alignment;
import android.view.View;
import android.view.MotionEvent;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.os.Build$VERSION;
import android.view.ViewConfiguration;
import android.graphics.drawable.Drawable$Callback;
import android.support.v7.appcompat.R$styleable;
import android.support.v7.appcompat.R$attr;
import android.util.AttributeSet;
import android.content.Context;
import android.view.VelocityTracker;
import android.graphics.PorterDuff$Mode;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.text.method.TransformationMethod;
import android.animation.ObjectAnimator;
import android.text.Layout;
import android.widget.CompoundButton;
import android.util.Property;

final class SwitchCompat$1 extends Property
{
    SwitchCompat$1(final Class clazz, final String s) {
        super(clazz, s);
    }
    
    public Float get(final SwitchCompat switchCompat) {
        return switchCompat.mThumbPosition;
    }
    
    public void set(final SwitchCompat switchCompat, final Float n) {
        switchCompat.setThumbPosition(n);
    }
}
