// 
// Decompiled by Procyon v0.5.30
// 

package android.support.graphics.drawable;

import java.util.Stack;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.PorterDuffColorFilter;
import java.util.Collection;
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
import android.animation.Animator;
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
import android.graphics.drawable.Drawable;
import android.content.res.Resources;
import android.content.Context;
import android.graphics.drawable.Drawable$Callback;
import android.animation.ArgbEvaluator;
import android.animation.Animator$AnimatorListener;
import java.util.ArrayList;

public class AnimatedVectorDrawableCompat extends VectorDrawableCommon implements Animatable2Compat
{
    private static final String ANIMATED_VECTOR = "animated-vector";
    private static final boolean DBG_ANIMATION_VECTOR_DRAWABLE = false;
    private static final String LOGTAG = "AnimatedVDCompat";
    private static final String TARGET = "target";
    private AnimatedVectorDrawableCompat$AnimatedVectorDrawableCompatState mAnimatedVectorState;
    private ArrayList mAnimationCallbacks;
    private Animator$AnimatorListener mAnimatorListener;
    private ArgbEvaluator mArgbEvaluator;
    AnimatedVectorDrawableCompat$AnimatedVectorDrawableDelegateState mCachedConstantStateDelegate;
    final Drawable$Callback mCallback;
    private Context mContext;
    
    AnimatedVectorDrawableCompat() {
        this(null, null, null);
    }
    
    private AnimatedVectorDrawableCompat(final Context context) {
        this(context, null, null);
    }
    
    private AnimatedVectorDrawableCompat(final Context mContext, final AnimatedVectorDrawableCompat$AnimatedVectorDrawableCompatState mAnimatedVectorState, final Resources resources) {
        this.mArgbEvaluator = null;
        this.mAnimatorListener = null;
        this.mAnimationCallbacks = null;
        this.mCallback = (Drawable$Callback)new AnimatedVectorDrawableCompat$1(this);
        this.mContext = mContext;
        if (mAnimatedVectorState != null) {
            this.mAnimatedVectorState = mAnimatedVectorState;
        }
        else {
            this.mAnimatedVectorState = new AnimatedVectorDrawableCompat$AnimatedVectorDrawableCompatState(mContext, mAnimatedVectorState, this.mCallback, resources);
        }
    }
    
    public static void clearAnimationCallbacks(final Drawable drawable) {
        if (drawable != null && drawable instanceof Animatable) {
            if (Build$VERSION.SDK_INT >= 24) {
                ((AnimatedVectorDrawable)drawable).clearAnimationCallbacks();
            }
            else {
                ((AnimatedVectorDrawableCompat)drawable).clearAnimationCallbacks();
            }
        }
    }
    
    public static AnimatedVectorDrawableCompat create(final Context context, final int n) {
        if (Build$VERSION.SDK_INT >= 24) {
            final AnimatedVectorDrawableCompat animatedVectorDrawableCompat = new AnimatedVectorDrawableCompat(context);
            (animatedVectorDrawableCompat.mDelegateDrawable = ResourcesCompat.getDrawable(context.getResources(), n, context.getTheme())).setCallback(animatedVectorDrawableCompat.mCallback);
            animatedVectorDrawableCompat.mCachedConstantStateDelegate = new AnimatedVectorDrawableCompat$AnimatedVectorDrawableDelegateState(animatedVectorDrawableCompat.mDelegateDrawable.getConstantState());
            return animatedVectorDrawableCompat;
        }
        final Resources resources = context.getResources();
        try {
            final XmlResourceParser xml = resources.getXml(n);
            try {
                final AttributeSet attributeSet = Xml.asAttributeSet((XmlPullParser)xml);
                try {
                    int next;
                    int n2;
                    int n3;
                    do {
                        n2 = (next = ((XmlPullParser)xml).next());
                        n3 = 2;
                    } while (n2 != n3 && next != 1);
                    Label_0194: {
                        if (next != n3) {
                            break Label_0194;
                        }
                        final Resources resources2 = context.getResources();
                        try {
                            return createFromXmlInner(context, resources2, (XmlPullParser)xml, attributeSet, context.getTheme());
                            throw new XmlPullParserException("No start tag found");
                        }
                        catch (IOException ex) {
                            Log.e("AnimatedVDCompat", "parser error", (Throwable)ex);
                        }
                        catch (XmlPullParserException ex2) {
                            Log.e("AnimatedVDCompat", "parser error", (Throwable)ex2);
                        }
                    }
                }
                catch (IOException ex3) {}
                catch (XmlPullParserException ex4) {}
            }
            catch (IOException ex5) {}
            catch (XmlPullParserException ex6) {}
        }
        catch (IOException ex7) {}
        catch (XmlPullParserException ex8) {}
        return null;
    }
    
    public static AnimatedVectorDrawableCompat createFromXmlInner(final Context context, final Resources resources, final XmlPullParser xmlPullParser, final AttributeSet set, final Resources$Theme resources$Theme) {
        final AnimatedVectorDrawableCompat animatedVectorDrawableCompat = new AnimatedVectorDrawableCompat(context);
        animatedVectorDrawableCompat.inflate(resources, xmlPullParser, set, resources$Theme);
        return animatedVectorDrawableCompat;
    }
    
    public static void registerAnimationCallback(final Drawable drawable, final Animatable2Compat$AnimationCallback animatable2Compat$AnimationCallback) {
        if (drawable == null || animatable2Compat$AnimationCallback == null) {
            return;
        }
        if (!(drawable instanceof Animatable)) {
            return;
        }
        if (Build$VERSION.SDK_INT >= 24) {
            registerPlatformCallback((AnimatedVectorDrawable)drawable, animatable2Compat$AnimationCallback);
        }
        else {
            ((AnimatedVectorDrawableCompat)drawable).registerAnimationCallback(animatable2Compat$AnimationCallback);
        }
    }
    
    private static void registerPlatformCallback(final AnimatedVectorDrawable animatedVectorDrawable, final Animatable2Compat$AnimationCallback animatable2Compat$AnimationCallback) {
        animatedVectorDrawable.registerAnimationCallback(animatable2Compat$AnimationCallback.getPlatformCallback());
    }
    
    private void removeAnimatorSetListener() {
        if (this.mAnimatorListener != null) {
            this.mAnimatedVectorState.mAnimatorSet.removeListener(this.mAnimatorListener);
            this.mAnimatorListener = null;
        }
    }
    
    private void setupAnimatorsForTarget(final String s, final Animator animator) {
        animator.setTarget(this.mAnimatedVectorState.mVectorDrawable.getTargetByName(s));
        if (Build$VERSION.SDK_INT < 21) {
            this.setupColorAnimator(animator);
        }
        if (this.mAnimatedVectorState.mAnimators == null) {
            this.mAnimatedVectorState.mAnimators = new ArrayList();
            this.mAnimatedVectorState.mTargetNameMap = new ArrayMap();
        }
        this.mAnimatedVectorState.mAnimators.add(animator);
        this.mAnimatedVectorState.mTargetNameMap.put(animator, s);
    }
    
    private void setupColorAnimator(final Animator animator) {
        if (animator instanceof AnimatorSet) {
            final ArrayList childAnimations = ((AnimatorSet)animator).getChildAnimations();
            if (childAnimations != null) {
                for (int i = 0; i < childAnimations.size(); ++i) {
                    this.setupColorAnimator((Animator)childAnimations.get(i));
                }
            }
        }
        if (animator instanceof ObjectAnimator) {
            final ObjectAnimator objectAnimator = (ObjectAnimator)animator;
            final String propertyName = objectAnimator.getPropertyName();
            if ("fillColor".equals(propertyName) || "strokeColor".equals(propertyName)) {
                if (this.mArgbEvaluator == null) {
                    this.mArgbEvaluator = new ArgbEvaluator();
                }
                objectAnimator.setEvaluator((TypeEvaluator)this.mArgbEvaluator);
            }
        }
    }
    
    public static boolean unregisterAnimationCallback(final Drawable drawable, final Animatable2Compat$AnimationCallback animatable2Compat$AnimationCallback) {
        if (drawable == null || animatable2Compat$AnimationCallback == null) {
            return false;
        }
        if (!(drawable instanceof Animatable)) {
            return false;
        }
        if (Build$VERSION.SDK_INT >= 24) {
            return unregisterPlatformCallback((AnimatedVectorDrawable)drawable, animatable2Compat$AnimationCallback);
        }
        return ((AnimatedVectorDrawableCompat)drawable).unregisterAnimationCallback(animatable2Compat$AnimationCallback);
    }
    
    private static boolean unregisterPlatformCallback(final AnimatedVectorDrawable animatedVectorDrawable, final Animatable2Compat$AnimationCallback animatable2Compat$AnimationCallback) {
        return animatedVectorDrawable.unregisterAnimationCallback(animatable2Compat$AnimationCallback.getPlatformCallback());
    }
    
    public void applyTheme(final Resources$Theme resources$Theme) {
        if (this.mDelegateDrawable != null) {
            DrawableCompat.applyTheme(this.mDelegateDrawable, resources$Theme);
        }
    }
    
    public boolean canApplyTheme() {
        return this.mDelegateDrawable != null && DrawableCompat.canApplyTheme(this.mDelegateDrawable);
    }
    
    public void clearAnimationCallbacks() {
        if (this.mDelegateDrawable != null) {
            ((AnimatedVectorDrawable)this.mDelegateDrawable).clearAnimationCallbacks();
            return;
        }
        this.removeAnimatorSetListener();
        final ArrayList mAnimationCallbacks = this.mAnimationCallbacks;
        if (mAnimationCallbacks == null) {
            return;
        }
        mAnimationCallbacks.clear();
    }
    
    public void draw(final Canvas canvas) {
        if (this.mDelegateDrawable != null) {
            this.mDelegateDrawable.draw(canvas);
            return;
        }
        this.mAnimatedVectorState.mVectorDrawable.draw(canvas);
        if (this.mAnimatedVectorState.mAnimatorSet.isStarted()) {
            this.invalidateSelf();
        }
    }
    
    public int getAlpha() {
        if (this.mDelegateDrawable != null) {
            return DrawableCompat.getAlpha(this.mDelegateDrawable);
        }
        return this.mAnimatedVectorState.mVectorDrawable.getAlpha();
    }
    
    public int getChangingConfigurations() {
        if (this.mDelegateDrawable != null) {
            return this.mDelegateDrawable.getChangingConfigurations();
        }
        return super.getChangingConfigurations() | this.mAnimatedVectorState.mChangingConfigurations;
    }
    
    public Drawable$ConstantState getConstantState() {
        if (this.mDelegateDrawable != null) {
            return new AnimatedVectorDrawableCompat$AnimatedVectorDrawableDelegateState(this.mDelegateDrawable.getConstantState());
        }
        return null;
    }
    
    public int getIntrinsicHeight() {
        if (this.mDelegateDrawable != null) {
            return this.mDelegateDrawable.getIntrinsicHeight();
        }
        return this.mAnimatedVectorState.mVectorDrawable.getIntrinsicHeight();
    }
    
    public int getIntrinsicWidth() {
        if (this.mDelegateDrawable != null) {
            return this.mDelegateDrawable.getIntrinsicWidth();
        }
        return this.mAnimatedVectorState.mVectorDrawable.getIntrinsicWidth();
    }
    
    public int getOpacity() {
        if (this.mDelegateDrawable != null) {
            return this.mDelegateDrawable.getOpacity();
        }
        return this.mAnimatedVectorState.mVectorDrawable.getOpacity();
    }
    
    public void inflate(final Resources resources, final XmlPullParser xmlPullParser, final AttributeSet set) {
        this.inflate(resources, xmlPullParser, set, null);
    }
    
    public void inflate(final Resources resources, final XmlPullParser xmlPullParser, final AttributeSet set, final Resources$Theme resources$Theme) {
        if (this.mDelegateDrawable != null) {
            DrawableCompat.inflate(this.mDelegateDrawable, resources, xmlPullParser, set, resources$Theme);
            return;
        }
        int n = xmlPullParser.getEventType();
        final int depth = xmlPullParser.getDepth();
        for (int n2 = 1, n3 = depth + n2; n != n2 && (xmlPullParser.getDepth() >= n3 || n != 3); n = xmlPullParser.next()) {
            if (n == 2) {
                final String name = xmlPullParser.getName();
                if ("animated-vector".equals(name)) {
                    final TypedArray obtainAttributes = TypedArrayUtils.obtainAttributes(resources, resources$Theme, set, AndroidResources.STYLEABLE_ANIMATED_VECTOR_DRAWABLE);
                    final int resourceId = obtainAttributes.getResourceId(0, 0);
                    if (resourceId != 0) {
                        final VectorDrawableCompat create = VectorDrawableCompat.create(resources, resourceId, resources$Theme);
                        create.setAllowCaching(false);
                        create.setCallback(this.mCallback);
                        if (this.mAnimatedVectorState.mVectorDrawable != null) {
                            this.mAnimatedVectorState.mVectorDrawable.setCallback((Drawable$Callback)null);
                        }
                        this.mAnimatedVectorState.mVectorDrawable = create;
                    }
                    obtainAttributes.recycle();
                }
                else if ("target".equals(name)) {
                    final TypedArray obtainAttributes2 = resources.obtainAttributes(set, AndroidResources.STYLEABLE_ANIMATED_VECTOR_DRAWABLE_TARGET);
                    final String string = obtainAttributes2.getString(0);
                    final int resourceId2 = obtainAttributes2.getResourceId(n2, 0);
                    if (resourceId2 != 0) {
                        final Context mContext = this.mContext;
                        if (mContext == null) {
                            obtainAttributes2.recycle();
                            throw new IllegalStateException("Context can't be null when inflating animators");
                        }
                        this.setupAnimatorsForTarget(string, AnimatorInflaterCompat.loadAnimator(mContext, resourceId2));
                    }
                    obtainAttributes2.recycle();
                }
            }
        }
        this.mAnimatedVectorState.setupAnimatorSet();
    }
    
    public boolean isAutoMirrored() {
        if (this.mDelegateDrawable != null) {
            return DrawableCompat.isAutoMirrored(this.mDelegateDrawable);
        }
        return this.mAnimatedVectorState.mVectorDrawable.isAutoMirrored();
    }
    
    public boolean isRunning() {
        if (this.mDelegateDrawable != null) {
            return ((AnimatedVectorDrawable)this.mDelegateDrawable).isRunning();
        }
        return this.mAnimatedVectorState.mAnimatorSet.isRunning();
    }
    
    public boolean isStateful() {
        if (this.mDelegateDrawable != null) {
            return this.mDelegateDrawable.isStateful();
        }
        return this.mAnimatedVectorState.mVectorDrawable.isStateful();
    }
    
    public Drawable mutate() {
        if (this.mDelegateDrawable != null) {
            this.mDelegateDrawable.mutate();
        }
        return this;
    }
    
    protected void onBoundsChange(final Rect rect) {
        if (this.mDelegateDrawable != null) {
            this.mDelegateDrawable.setBounds(rect);
            return;
        }
        this.mAnimatedVectorState.mVectorDrawable.setBounds(rect);
    }
    
    protected boolean onLevelChange(final int n) {
        if (this.mDelegateDrawable != null) {
            return this.mDelegateDrawable.setLevel(n);
        }
        return this.mAnimatedVectorState.mVectorDrawable.setLevel(n);
    }
    
    protected boolean onStateChange(final int[] array) {
        if (this.mDelegateDrawable != null) {
            return this.mDelegateDrawable.setState(array);
        }
        return this.mAnimatedVectorState.mVectorDrawable.setState(array);
    }
    
    public void registerAnimationCallback(final Animatable2Compat$AnimationCallback animatable2Compat$AnimationCallback) {
        if (this.mDelegateDrawable != null) {
            registerPlatformCallback((AnimatedVectorDrawable)this.mDelegateDrawable, animatable2Compat$AnimationCallback);
            return;
        }
        if (animatable2Compat$AnimationCallback == null) {
            return;
        }
        if (this.mAnimationCallbacks == null) {
            this.mAnimationCallbacks = new ArrayList();
        }
        if (this.mAnimationCallbacks.contains(animatable2Compat$AnimationCallback)) {
            return;
        }
        this.mAnimationCallbacks.add(animatable2Compat$AnimationCallback);
        if (this.mAnimatorListener == null) {
            this.mAnimatorListener = (Animator$AnimatorListener)new AnimatedVectorDrawableCompat$2(this);
        }
        this.mAnimatedVectorState.mAnimatorSet.addListener(this.mAnimatorListener);
    }
    
    public void setAlpha(final int n) {
        if (this.mDelegateDrawable != null) {
            this.mDelegateDrawable.setAlpha(n);
            return;
        }
        this.mAnimatedVectorState.mVectorDrawable.setAlpha(n);
    }
    
    public void setAutoMirrored(final boolean b) {
        if (this.mDelegateDrawable != null) {
            this.mDelegateDrawable.setAutoMirrored(b);
            return;
        }
        this.mAnimatedVectorState.mVectorDrawable.setAutoMirrored(b);
    }
    
    public void setColorFilter(final ColorFilter colorFilter) {
        if (this.mDelegateDrawable != null) {
            this.mDelegateDrawable.setColorFilter(colorFilter);
            return;
        }
        this.mAnimatedVectorState.mVectorDrawable.setColorFilter(colorFilter);
    }
    
    public void setTint(final int tint) {
        if (this.mDelegateDrawable != null) {
            DrawableCompat.setTint(this.mDelegateDrawable, tint);
            return;
        }
        this.mAnimatedVectorState.mVectorDrawable.setTint(tint);
    }
    
    public void setTintList(final ColorStateList tintList) {
        if (this.mDelegateDrawable != null) {
            DrawableCompat.setTintList(this.mDelegateDrawable, tintList);
            return;
        }
        this.mAnimatedVectorState.mVectorDrawable.setTintList(tintList);
    }
    
    public void setTintMode(final PorterDuff$Mode tintMode) {
        if (this.mDelegateDrawable != null) {
            DrawableCompat.setTintMode(this.mDelegateDrawable, tintMode);
            return;
        }
        this.mAnimatedVectorState.mVectorDrawable.setTintMode(tintMode);
    }
    
    public boolean setVisible(final boolean b, final boolean b2) {
        if (this.mDelegateDrawable != null) {
            return this.mDelegateDrawable.setVisible(b, b2);
        }
        this.mAnimatedVectorState.mVectorDrawable.setVisible(b, b2);
        return super.setVisible(b, b2);
    }
    
    public void start() {
        if (this.mDelegateDrawable != null) {
            ((AnimatedVectorDrawable)this.mDelegateDrawable).start();
            return;
        }
        if (this.mAnimatedVectorState.mAnimatorSet.isStarted()) {
            return;
        }
        this.mAnimatedVectorState.mAnimatorSet.start();
        this.invalidateSelf();
    }
    
    public void stop() {
        if (this.mDelegateDrawable != null) {
            ((AnimatedVectorDrawable)this.mDelegateDrawable).stop();
            return;
        }
        this.mAnimatedVectorState.mAnimatorSet.end();
    }
    
    public boolean unregisterAnimationCallback(final Animatable2Compat$AnimationCallback animatable2Compat$AnimationCallback) {
        if (this.mDelegateDrawable != null) {
            unregisterPlatformCallback((AnimatedVectorDrawable)this.mDelegateDrawable, animatable2Compat$AnimationCallback);
        }
        final ArrayList mAnimationCallbacks = this.mAnimationCallbacks;
        if (mAnimationCallbacks != null && animatable2Compat$AnimationCallback != null) {
            final boolean remove = mAnimationCallbacks.remove(animatable2Compat$AnimationCallback);
            if (this.mAnimationCallbacks.size() == 0) {
                this.removeAnimatorSetListener();
            }
            return remove;
        }
        return false;
    }
}
