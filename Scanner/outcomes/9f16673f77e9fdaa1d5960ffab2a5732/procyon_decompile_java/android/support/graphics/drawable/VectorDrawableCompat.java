// 
// Decompiled by Procyon v0.5.30
// 

package android.support.graphics.drawable;

import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.graphics.Canvas;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import java.util.Stack;
import android.util.AttributeSet;
import android.content.res.XmlResourceParser;
import java.io.IOException;
import android.util.Log;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParser;
import android.util.Xml;
import android.support.v4.content.res.ResourcesCompat;
import android.os.Build$VERSION;
import android.content.res.Resources$Theme;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.PorterDuffColorFilter;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable$ConstantState;
import android.graphics.PorterDuff$Mode;

public class VectorDrawableCompat extends VectorDrawableCommon
{
    private static final boolean DBG_VECTOR_DRAWABLE = false;
    static final PorterDuff$Mode DEFAULT_TINT_MODE;
    private static final int LINECAP_BUTT = 0;
    private static final int LINECAP_ROUND = 1;
    private static final int LINECAP_SQUARE = 2;
    private static final int LINEJOIN_BEVEL = 2;
    private static final int LINEJOIN_MITER = 0;
    private static final int LINEJOIN_ROUND = 1;
    static final String LOGTAG = "VectorDrawableCompat";
    private static final int MAX_CACHED_BITMAP_SIZE = 2048;
    private static final String SHAPE_CLIP_PATH = "clip-path";
    private static final String SHAPE_GROUP = "group";
    private static final String SHAPE_PATH = "path";
    private static final String SHAPE_VECTOR = "vector";
    private boolean mAllowCaching;
    private Drawable$ConstantState mCachedConstantStateDelegate;
    private ColorFilter mColorFilter;
    private boolean mMutated;
    private PorterDuffColorFilter mTintFilter;
    private final Rect mTmpBounds;
    private final float[] mTmpFloats;
    private final Matrix mTmpMatrix;
    private VectorDrawableCompat$VectorDrawableCompatState mVectorState;
    
    static {
        DEFAULT_TINT_MODE = PorterDuff$Mode.SRC_IN;
    }
    
    VectorDrawableCompat() {
        this.mAllowCaching = true;
        this.mTmpFloats = new float[9];
        this.mTmpMatrix = new Matrix();
        this.mTmpBounds = new Rect();
        this.mVectorState = new VectorDrawableCompat$VectorDrawableCompatState();
    }
    
    VectorDrawableCompat(final VectorDrawableCompat$VectorDrawableCompatState mVectorState) {
        this.mAllowCaching = true;
        this.mTmpFloats = new float[9];
        this.mTmpMatrix = new Matrix();
        this.mTmpBounds = new Rect();
        this.mVectorState = mVectorState;
        this.mTintFilter = this.updateTintFilter(this.mTintFilter, mVectorState.mTint, mVectorState.mTintMode);
    }
    
    static int applyAlpha(int n, final float n2) {
        final int alpha = Color.alpha(n);
        n &= 0xFFFFFF;
        return n | (int)(alpha * n2) << 24;
    }
    
    public static VectorDrawableCompat create(final Resources resources, final int n, final Resources$Theme resources$Theme) {
        if (Build$VERSION.SDK_INT >= 24) {
            final VectorDrawableCompat vectorDrawableCompat = new VectorDrawableCompat();
            vectorDrawableCompat.mDelegateDrawable = ResourcesCompat.getDrawable(resources, n, resources$Theme);
            vectorDrawableCompat.mCachedConstantStateDelegate = new VectorDrawableCompat$VectorDrawableDelegateState(vectorDrawableCompat.mDelegateDrawable.getConstantState());
            return vectorDrawableCompat;
        }
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
                    if (next == n3) {
                        return createFromXmlInner(resources, (XmlPullParser)xml, attributeSet, resources$Theme);
                    }
                    throw new XmlPullParserException("No start tag found");
                }
                catch (IOException ex) {
                    Log.e("VectorDrawableCompat", "parser error", (Throwable)ex);
                }
                catch (XmlPullParserException ex2) {
                    Log.e("VectorDrawableCompat", "parser error", (Throwable)ex2);
                }
            }
            catch (IOException ex3) {}
            catch (XmlPullParserException ex4) {}
        }
        catch (IOException ex5) {}
        catch (XmlPullParserException ex6) {}
        return null;
    }
    
    public static VectorDrawableCompat createFromXmlInner(final Resources resources, final XmlPullParser xmlPullParser, final AttributeSet set, final Resources$Theme resources$Theme) {
        final VectorDrawableCompat vectorDrawableCompat = new VectorDrawableCompat();
        vectorDrawableCompat.inflate(resources, xmlPullParser, set, resources$Theme);
        return vectorDrawableCompat;
    }
    
    private void inflateInternal(final Resources resources, final XmlPullParser xmlPullParser, final AttributeSet set, final Resources$Theme resources$Theme) {
        final VectorDrawableCompat$VectorDrawableCompatState mVectorState = this.mVectorState;
        final VectorDrawableCompat$VPathRenderer mvPathRenderer = mVectorState.mVPathRenderer;
        boolean b = true;
        final Stack<VectorDrawableCompat$VGroup> stack = new Stack<VectorDrawableCompat$VGroup>();
        stack.push(mvPathRenderer.mRootGroup);
        int i = xmlPullParser.getEventType();
        final int depth = xmlPullParser.getDepth();
        int n = 1;
        final int n2 = depth + n;
        while (i != n) {
            final int depth2 = xmlPullParser.getDepth();
            final int n3 = 3;
            if (depth2 < n2 && i == n3) {
                break;
            }
            if (i == 2) {
                final String name = xmlPullParser.getName();
                final VectorDrawableCompat$VGroup vectorDrawableCompat$VGroup = stack.peek();
                if ("path".equals(name)) {
                    final VectorDrawableCompat$VFullPath vectorDrawableCompat$VFullPath = new VectorDrawableCompat$VFullPath();
                    vectorDrawableCompat$VFullPath.inflate(resources, set, resources$Theme, xmlPullParser);
                    vectorDrawableCompat$VGroup.mChildren.add(vectorDrawableCompat$VFullPath);
                    if (vectorDrawableCompat$VFullPath.getPathName() != null) {
                        mvPathRenderer.mVGTargetsMap.put(vectorDrawableCompat$VFullPath.getPathName(), vectorDrawableCompat$VFullPath);
                    }
                    b = false;
                    mVectorState.mChangingConfigurations |= vectorDrawableCompat$VFullPath.mChangingConfigurations;
                }
                else if ("clip-path".equals(name)) {
                    final VectorDrawableCompat$VClipPath vectorDrawableCompat$VClipPath = new VectorDrawableCompat$VClipPath();
                    vectorDrawableCompat$VClipPath.inflate(resources, set, resources$Theme, xmlPullParser);
                    vectorDrawableCompat$VGroup.mChildren.add(vectorDrawableCompat$VClipPath);
                    if (vectorDrawableCompat$VClipPath.getPathName() != null) {
                        mvPathRenderer.mVGTargetsMap.put(vectorDrawableCompat$VClipPath.getPathName(), vectorDrawableCompat$VClipPath);
                    }
                    mVectorState.mChangingConfigurations |= vectorDrawableCompat$VClipPath.mChangingConfigurations;
                }
                else if ("group".equals(name)) {
                    final VectorDrawableCompat$VGroup vectorDrawableCompat$VGroup2 = new VectorDrawableCompat$VGroup();
                    vectorDrawableCompat$VGroup2.inflate(resources, set, resources$Theme, xmlPullParser);
                    vectorDrawableCompat$VGroup.mChildren.add(vectorDrawableCompat$VGroup2);
                    stack.push(vectorDrawableCompat$VGroup2);
                    if (vectorDrawableCompat$VGroup2.getGroupName() != null) {
                        mvPathRenderer.mVGTargetsMap.put(vectorDrawableCompat$VGroup2.getGroupName(), vectorDrawableCompat$VGroup2);
                    }
                    mVectorState.mChangingConfigurations |= vectorDrawableCompat$VGroup2.mChangingConfigurations;
                }
            }
            else if (i == n3) {
                if ("group".equals(xmlPullParser.getName())) {
                    stack.pop();
                }
            }
            i = xmlPullParser.next();
            n = 1;
        }
        if (b) {
            final StringBuffer sb = new StringBuffer();
            if (sb.length() > 0) {
                sb.append(" or ");
            }
            sb.append("path");
            final StringBuilder sb2 = new StringBuilder();
            sb2.append("no ");
            sb2.append((Object)sb);
            sb2.append(" defined");
            throw new XmlPullParserException(sb2.toString());
        }
    }
    
    private boolean needMirroring() {
        final int sdk_INT = Build$VERSION.SDK_INT;
        boolean b = false;
        if (sdk_INT < 17) {
            return false;
        }
        final boolean autoMirrored = this.isAutoMirrored();
        final boolean b2 = true;
        if (autoMirrored && this.getLayoutDirection() == (b2 ? 1 : 0)) {
            b = true;
        }
        return b;
    }
    
    private static PorterDuff$Mode parseTintModeCompat(final int n, final PorterDuff$Mode porterDuff$Mode) {
        if (n == 3) {
            return PorterDuff$Mode.SRC_OVER;
        }
        if (n == 5) {
            return PorterDuff$Mode.SRC_IN;
        }
        if (n == 9) {
            return PorterDuff$Mode.SRC_ATOP;
        }
        switch (n) {
            default: {
                return porterDuff$Mode;
            }
            case 16: {
                if (Build$VERSION.SDK_INT >= 11) {
                    return PorterDuff$Mode.ADD;
                }
                return porterDuff$Mode;
            }
            case 15: {
                return PorterDuff$Mode.SCREEN;
            }
            case 14: {
                return PorterDuff$Mode.MULTIPLY;
            }
        }
    }
    
    private void printGroupTree(final VectorDrawableCompat$VGroup vectorDrawableCompat$VGroup, final int n) {
        String string = "";
        for (int i = 0; i < n; ++i) {
            final StringBuilder sb = new StringBuilder();
            sb.append(string);
            sb.append("    ");
            string = sb.toString();
        }
        final StringBuilder sb2 = new StringBuilder();
        sb2.append(string);
        sb2.append("current group is :");
        sb2.append(vectorDrawableCompat$VGroup.getGroupName());
        sb2.append(" rotation is ");
        sb2.append(vectorDrawableCompat$VGroup.mRotate);
        Log.v("VectorDrawableCompat", sb2.toString());
        final StringBuilder sb3 = new StringBuilder();
        sb3.append(string);
        sb3.append("matrix is :");
        sb3.append(vectorDrawableCompat$VGroup.getLocalMatrix().toString());
        Log.v("VectorDrawableCompat", sb3.toString());
        for (int j = 0; j < vectorDrawableCompat$VGroup.mChildren.size(); ++j) {
            final Object value = vectorDrawableCompat$VGroup.mChildren.get(j);
            if (value instanceof VectorDrawableCompat$VGroup) {
                this.printGroupTree((VectorDrawableCompat$VGroup)value, n + 1);
            }
            else {
                ((VectorDrawableCompat$VPath)value).printVPath(n + 1);
            }
        }
    }
    
    private void updateStateFromTypedArray(final TypedArray typedArray, final XmlPullParser xmlPullParser) {
        final VectorDrawableCompat$VectorDrawableCompatState mVectorState = this.mVectorState;
        final VectorDrawableCompat$VPathRenderer mvPathRenderer = mVectorState.mVPathRenderer;
        mVectorState.mTintMode = parseTintModeCompat(TypedArrayUtils.getNamedInt(typedArray, xmlPullParser, "tintMode", 6, -1), PorterDuff$Mode.SRC_IN);
        final ColorStateList colorStateList = typedArray.getColorStateList(1);
        if (colorStateList != null) {
            mVectorState.mTint = colorStateList;
        }
        mVectorState.mAutoMirrored = TypedArrayUtils.getNamedBoolean(typedArray, xmlPullParser, "autoMirrored", 5, mVectorState.mAutoMirrored);
        mvPathRenderer.mViewportWidth = TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, "viewportWidth", 7, mvPathRenderer.mViewportWidth);
        mvPathRenderer.mViewportHeight = TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, "viewportHeight", 8, mvPathRenderer.mViewportHeight);
        if (mvPathRenderer.mViewportWidth <= 0.0f) {
            final StringBuilder sb = new StringBuilder();
            sb.append(typedArray.getPositionDescription());
            sb.append("<vector> tag requires viewportWidth > 0");
            throw new XmlPullParserException(sb.toString());
        }
        if (mvPathRenderer.mViewportHeight <= 0.0f) {
            final StringBuilder sb2 = new StringBuilder();
            sb2.append(typedArray.getPositionDescription());
            sb2.append("<vector> tag requires viewportHeight > 0");
            throw new XmlPullParserException(sb2.toString());
        }
        mvPathRenderer.mBaseWidth = typedArray.getDimension(3, mvPathRenderer.mBaseWidth);
        mvPathRenderer.mBaseHeight = typedArray.getDimension(2, mvPathRenderer.mBaseHeight);
        if (mvPathRenderer.mBaseWidth <= 0.0f) {
            final StringBuilder sb3 = new StringBuilder();
            sb3.append(typedArray.getPositionDescription());
            sb3.append("<vector> tag requires width > 0");
            throw new XmlPullParserException(sb3.toString());
        }
        if (mvPathRenderer.mBaseHeight > 0.0f) {
            mvPathRenderer.setAlpha(TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, "alpha", 4, mvPathRenderer.getAlpha()));
            final String string = typedArray.getString(0);
            if (string != null) {
                mvPathRenderer.mRootName = string;
                mvPathRenderer.mVGTargetsMap.put(string, mvPathRenderer);
            }
            return;
        }
        final StringBuilder sb4 = new StringBuilder();
        sb4.append(typedArray.getPositionDescription());
        sb4.append("<vector> tag requires height > 0");
        throw new XmlPullParserException(sb4.toString());
    }
    
    public boolean canApplyTheme() {
        if (this.mDelegateDrawable != null) {
            DrawableCompat.canApplyTheme(this.mDelegateDrawable);
        }
        return false;
    }
    
    public void draw(final Canvas canvas) {
        if (this.mDelegateDrawable != null) {
            this.mDelegateDrawable.draw(canvas);
            return;
        }
        this.copyBounds(this.mTmpBounds);
        if (this.mTmpBounds.width() <= 0 || this.mTmpBounds.height() <= 0) {
            return;
        }
        Object o = this.mColorFilter;
        if (o == null) {
            o = this.mTintFilter;
        }
        canvas.getMatrix(this.mTmpMatrix);
        this.mTmpMatrix.getValues(this.mTmpFloats);
        float abs = Math.abs(this.mTmpFloats[0]);
        float abs2 = Math.abs(this.mTmpFloats[4]);
        final float abs3 = Math.abs(this.mTmpFloats[1]);
        final float abs4 = Math.abs(this.mTmpFloats[3]);
        if (abs3 != 0.0f || abs4 != 0.0f) {
            abs = 1.0f;
            abs2 = 1.0f;
        }
        final int n = (int)(this.mTmpBounds.width() * abs);
        final int n2 = (int)(this.mTmpBounds.height() * abs2);
        final int n3 = 2048;
        final int min = Math.min(n3, n);
        final int min2 = Math.min(n3, n2);
        if (min > 0 && min2 > 0) {
            final int save = canvas.save();
            canvas.translate((float)this.mTmpBounds.left, (float)this.mTmpBounds.top);
            if (this.needMirroring()) {
                canvas.translate((float)this.mTmpBounds.width(), 0.0f);
                canvas.scale(-1.0f, 1.0f);
            }
            this.mTmpBounds.offsetTo(0, 0);
            this.mVectorState.createCachedBitmapIfNeeded(min, min2);
            if (!this.mAllowCaching) {
                this.mVectorState.updateCachedBitmap(min, min2);
            }
            else if (!this.mVectorState.canReuseCache()) {
                this.mVectorState.updateCachedBitmap(min, min2);
                this.mVectorState.updateCacheStates();
            }
            this.mVectorState.drawCachedBitmapWithRootAlpha(canvas, (ColorFilter)o, this.mTmpBounds);
            canvas.restoreToCount(save);
        }
    }
    
    public int getAlpha() {
        if (this.mDelegateDrawable != null) {
            return DrawableCompat.getAlpha(this.mDelegateDrawable);
        }
        return this.mVectorState.mVPathRenderer.getRootAlpha();
    }
    
    public int getChangingConfigurations() {
        if (this.mDelegateDrawable != null) {
            return this.mDelegateDrawable.getChangingConfigurations();
        }
        return super.getChangingConfigurations() | this.mVectorState.getChangingConfigurations();
    }
    
    public Drawable$ConstantState getConstantState() {
        if (this.mDelegateDrawable != null) {
            return new VectorDrawableCompat$VectorDrawableDelegateState(this.mDelegateDrawable.getConstantState());
        }
        this.mVectorState.mChangingConfigurations = this.getChangingConfigurations();
        return this.mVectorState;
    }
    
    public int getIntrinsicHeight() {
        if (this.mDelegateDrawable != null) {
            return this.mDelegateDrawable.getIntrinsicHeight();
        }
        return (int)this.mVectorState.mVPathRenderer.mBaseHeight;
    }
    
    public int getIntrinsicWidth() {
        if (this.mDelegateDrawable != null) {
            return this.mDelegateDrawable.getIntrinsicWidth();
        }
        return (int)this.mVectorState.mVPathRenderer.mBaseWidth;
    }
    
    public int getOpacity() {
        if (this.mDelegateDrawable != null) {
            return this.mDelegateDrawable.getOpacity();
        }
        return -3;
    }
    
    public float getPixelSize() {
        final VectorDrawableCompat$VectorDrawableCompatState mVectorState = this.mVectorState;
        if ((mVectorState != null || mVectorState.mVPathRenderer != null) && this.mVectorState.mVPathRenderer.mBaseWidth != 0.0f && this.mVectorState.mVPathRenderer.mBaseHeight != 0.0f && this.mVectorState.mVPathRenderer.mViewportHeight != 0.0f && this.mVectorState.mVPathRenderer.mViewportWidth != 0.0f) {
            return Math.min(this.mVectorState.mVPathRenderer.mViewportWidth / this.mVectorState.mVPathRenderer.mBaseWidth, this.mVectorState.mVPathRenderer.mViewportHeight / this.mVectorState.mVPathRenderer.mBaseHeight);
        }
        return 1.0f;
    }
    
    Object getTargetByName(final String s) {
        return this.mVectorState.mVPathRenderer.mVGTargetsMap.get(s);
    }
    
    public void inflate(final Resources resources, final XmlPullParser xmlPullParser, final AttributeSet set) {
        if (this.mDelegateDrawable != null) {
            this.mDelegateDrawable.inflate(resources, xmlPullParser, set);
            return;
        }
        this.inflate(resources, xmlPullParser, set, null);
    }
    
    public void inflate(final Resources resources, final XmlPullParser xmlPullParser, final AttributeSet set, final Resources$Theme resources$Theme) {
        if (this.mDelegateDrawable != null) {
            DrawableCompat.inflate(this.mDelegateDrawable, resources, xmlPullParser, set, resources$Theme);
            return;
        }
        final VectorDrawableCompat$VectorDrawableCompatState mVectorState = this.mVectorState;
        mVectorState.mVPathRenderer = new VectorDrawableCompat$VPathRenderer();
        final TypedArray obtainAttributes = TypedArrayUtils.obtainAttributes(resources, resources$Theme, set, AndroidResources.STYLEABLE_VECTOR_DRAWABLE_TYPE_ARRAY);
        this.updateStateFromTypedArray(obtainAttributes, xmlPullParser);
        obtainAttributes.recycle();
        mVectorState.mChangingConfigurations = this.getChangingConfigurations();
        mVectorState.mCacheDirty = true;
        this.inflateInternal(resources, xmlPullParser, set, resources$Theme);
        this.mTintFilter = this.updateTintFilter(this.mTintFilter, mVectorState.mTint, mVectorState.mTintMode);
    }
    
    public void invalidateSelf() {
        if (this.mDelegateDrawable != null) {
            this.mDelegateDrawable.invalidateSelf();
            return;
        }
        super.invalidateSelf();
    }
    
    public boolean isAutoMirrored() {
        if (this.mDelegateDrawable != null) {
            return DrawableCompat.isAutoMirrored(this.mDelegateDrawable);
        }
        return this.mVectorState.mAutoMirrored;
    }
    
    public boolean isStateful() {
        if (this.mDelegateDrawable != null) {
            return this.mDelegateDrawable.isStateful();
        }
        if (!super.isStateful()) {
            final VectorDrawableCompat$VectorDrawableCompatState mVectorState = this.mVectorState;
            if (mVectorState == null || mVectorState.mTint == null || !this.mVectorState.mTint.isStateful()) {
                return false;
            }
        }
        return true;
    }
    
    public Drawable mutate() {
        if (this.mDelegateDrawable != null) {
            this.mDelegateDrawable.mutate();
            return this;
        }
        if (!this.mMutated && super.mutate() == this) {
            this.mVectorState = new VectorDrawableCompat$VectorDrawableCompatState(this.mVectorState);
            this.mMutated = true;
        }
        return this;
    }
    
    protected void onBoundsChange(final Rect bounds) {
        if (this.mDelegateDrawable != null) {
            this.mDelegateDrawable.setBounds(bounds);
        }
    }
    
    protected boolean onStateChange(final int[] state) {
        if (this.mDelegateDrawable != null) {
            return this.mDelegateDrawable.setState(state);
        }
        final VectorDrawableCompat$VectorDrawableCompatState mVectorState = this.mVectorState;
        if (mVectorState.mTint != null && mVectorState.mTintMode != null) {
            this.mTintFilter = this.updateTintFilter(this.mTintFilter, mVectorState.mTint, mVectorState.mTintMode);
            this.invalidateSelf();
            return true;
        }
        return false;
    }
    
    public void scheduleSelf(final Runnable runnable, final long n) {
        if (this.mDelegateDrawable != null) {
            this.mDelegateDrawable.scheduleSelf(runnable, n);
            return;
        }
        super.scheduleSelf(runnable, n);
    }
    
    void setAllowCaching(final boolean mAllowCaching) {
        this.mAllowCaching = mAllowCaching;
    }
    
    public void setAlpha(final int n) {
        if (this.mDelegateDrawable != null) {
            this.mDelegateDrawable.setAlpha(n);
            return;
        }
        if (this.mVectorState.mVPathRenderer.getRootAlpha() != n) {
            this.mVectorState.mVPathRenderer.setRootAlpha(n);
            this.invalidateSelf();
        }
    }
    
    public void setAutoMirrored(final boolean mAutoMirrored) {
        if (this.mDelegateDrawable != null) {
            DrawableCompat.setAutoMirrored(this.mDelegateDrawable, mAutoMirrored);
            return;
        }
        this.mVectorState.mAutoMirrored = mAutoMirrored;
    }
    
    public void setColorFilter(final ColorFilter colorFilter) {
        if (this.mDelegateDrawable != null) {
            this.mDelegateDrawable.setColorFilter(colorFilter);
            return;
        }
        this.mColorFilter = colorFilter;
        this.invalidateSelf();
    }
    
    public void setTint(final int n) {
        if (this.mDelegateDrawable != null) {
            DrawableCompat.setTint(this.mDelegateDrawable, n);
            return;
        }
        this.setTintList(ColorStateList.valueOf(n));
    }
    
    public void setTintList(final ColorStateList mTint) {
        if (this.mDelegateDrawable != null) {
            DrawableCompat.setTintList(this.mDelegateDrawable, mTint);
            return;
        }
        final VectorDrawableCompat$VectorDrawableCompatState mVectorState = this.mVectorState;
        if (mVectorState.mTint != mTint) {
            mVectorState.mTint = mTint;
            this.mTintFilter = this.updateTintFilter(this.mTintFilter, mTint, mVectorState.mTintMode);
            this.invalidateSelf();
        }
    }
    
    public void setTintMode(final PorterDuff$Mode mTintMode) {
        if (this.mDelegateDrawable != null) {
            DrawableCompat.setTintMode(this.mDelegateDrawable, mTintMode);
            return;
        }
        final VectorDrawableCompat$VectorDrawableCompatState mVectorState = this.mVectorState;
        if (mVectorState.mTintMode != mTintMode) {
            mVectorState.mTintMode = mTintMode;
            this.mTintFilter = this.updateTintFilter(this.mTintFilter, mVectorState.mTint, mTintMode);
            this.invalidateSelf();
        }
    }
    
    public boolean setVisible(final boolean b, final boolean b2) {
        if (this.mDelegateDrawable != null) {
            return this.mDelegateDrawable.setVisible(b, b2);
        }
        return super.setVisible(b, b2);
    }
    
    public void unscheduleSelf(final Runnable runnable) {
        if (this.mDelegateDrawable != null) {
            this.mDelegateDrawable.unscheduleSelf(runnable);
            return;
        }
        super.unscheduleSelf(runnable);
    }
    
    PorterDuffColorFilter updateTintFilter(final PorterDuffColorFilter porterDuffColorFilter, final ColorStateList list, final PorterDuff$Mode porterDuff$Mode) {
        if (list != null && porterDuff$Mode != null) {
            return new PorterDuffColorFilter(list.getColorForState(this.getState(), 0), porterDuff$Mode);
        }
        return null;
    }
}
