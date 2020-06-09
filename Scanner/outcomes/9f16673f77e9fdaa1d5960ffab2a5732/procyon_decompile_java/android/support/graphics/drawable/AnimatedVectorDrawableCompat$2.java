// 
// Decompiled by Procyon v0.5.30
// 

package android.support.graphics.drawable;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff$Mode;
import android.content.res.TypedArray;
import android.graphics.Region;
import android.graphics.Rect;
import android.graphics.drawable.Drawable$ConstantState;
import android.graphics.ColorFilter;
import android.graphics.Canvas;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.animation.TypeEvaluator;
import android.animation.ObjectAnimator;
import android.animation.AnimatorSet;
import android.support.v4.util.ArrayMap;
import android.content.res.Resources$Theme;
import android.util.AttributeSet;
import android.content.res.XmlResourceParser;
import java.io.IOException;
import android.util.Log;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParser;
import android.util.Xml;
import android.support.v4.content.res.ResourcesCompat;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.os.Build$VERSION;
import android.graphics.drawable.Animatable;
import android.content.res.Resources;
import android.content.Context;
import android.graphics.drawable.Drawable$Callback;
import android.animation.ArgbEvaluator;
import android.animation.Animator$AnimatorListener;
import android.graphics.drawable.Drawable;
import java.util.Collection;
import java.util.ArrayList;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

class AnimatedVectorDrawableCompat$2 extends AnimatorListenerAdapter
{
    final /* synthetic */ AnimatedVectorDrawableCompat this$0;
    
    AnimatedVectorDrawableCompat$2(final AnimatedVectorDrawableCompat this$0) {
        this.this$0 = this$0;
    }
    
    public void onAnimationEnd(final Animator animator) {
        final ArrayList<Animatable2Compat$AnimationCallback> list = new ArrayList<Animatable2Compat$AnimationCallback>(this.this$0.mAnimationCallbacks);
        for (int size = list.size(), i = 0; i < size; ++i) {
            list.get(i).onAnimationEnd(this.this$0);
        }
    }
    
    public void onAnimationStart(final Animator animator) {
        final ArrayList<Animatable2Compat$AnimationCallback> list = new ArrayList<Animatable2Compat$AnimationCallback>(this.this$0.mAnimationCallbacks);
        for (int size = list.size(), i = 0; i < size; ++i) {
            list.get(i).onAnimationStart(this.this$0);
        }
    }
}
