// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.view.accessibility;

import android.view.View;
import java.util.List;
import android.os.Parcelable;
import android.os.Build$VERSION;

public class AccessibilityRecordCompat
{
    private static final AccessibilityRecordCompat$AccessibilityRecordImpl IMPL;
    private final Object mRecord;
    
    static {
        if (Build$VERSION.SDK_INT >= 16) {
            IMPL = new AccessibilityRecordCompat$AccessibilityRecordJellyBeanImpl();
        }
        else if (Build$VERSION.SDK_INT >= 15) {
            IMPL = new AccessibilityRecordCompat$AccessibilityRecordIcsMr1Impl();
        }
        else if (Build$VERSION.SDK_INT >= 14) {
            IMPL = new AccessibilityRecordCompat$AccessibilityRecordIcsImpl();
        }
        else {
            IMPL = new AccessibilityRecordCompat$AccessibilityRecordStubImpl();
        }
    }
    
    public AccessibilityRecordCompat(final Object mRecord) {
        this.mRecord = mRecord;
    }
    
    public static AccessibilityRecordCompat obtain() {
        return new AccessibilityRecordCompat(AccessibilityRecordCompat.IMPL.obtain());
    }
    
    public static AccessibilityRecordCompat obtain(final AccessibilityRecordCompat accessibilityRecordCompat) {
        return new AccessibilityRecordCompat(AccessibilityRecordCompat.IMPL.obtain(accessibilityRecordCompat.mRecord));
    }
    
    public boolean equals(final Object o) {
        final boolean b = true;
        if (this == o) {
            return b;
        }
        if (o == null) {
            return false;
        }
        if (this.getClass() != o.getClass()) {
            return false;
        }
        final AccessibilityRecordCompat accessibilityRecordCompat = (AccessibilityRecordCompat)o;
        final Object mRecord = this.mRecord;
        if (mRecord == null) {
            if (accessibilityRecordCompat.mRecord != null) {
                return false;
            }
        }
        else if (!mRecord.equals(accessibilityRecordCompat.mRecord)) {
            return false;
        }
        return b;
    }
    
    public int getAddedCount() {
        return AccessibilityRecordCompat.IMPL.getAddedCount(this.mRecord);
    }
    
    public CharSequence getBeforeText() {
        return AccessibilityRecordCompat.IMPL.getBeforeText(this.mRecord);
    }
    
    public CharSequence getClassName() {
        return AccessibilityRecordCompat.IMPL.getClassName(this.mRecord);
    }
    
    public CharSequence getContentDescription() {
        return AccessibilityRecordCompat.IMPL.getContentDescription(this.mRecord);
    }
    
    public int getCurrentItemIndex() {
        return AccessibilityRecordCompat.IMPL.getCurrentItemIndex(this.mRecord);
    }
    
    public int getFromIndex() {
        return AccessibilityRecordCompat.IMPL.getFromIndex(this.mRecord);
    }
    
    public Object getImpl() {
        return this.mRecord;
    }
    
    public int getItemCount() {
        return AccessibilityRecordCompat.IMPL.getItemCount(this.mRecord);
    }
    
    public int getMaxScrollX() {
        return AccessibilityRecordCompat.IMPL.getMaxScrollX(this.mRecord);
    }
    
    public int getMaxScrollY() {
        return AccessibilityRecordCompat.IMPL.getMaxScrollY(this.mRecord);
    }
    
    public Parcelable getParcelableData() {
        return AccessibilityRecordCompat.IMPL.getParcelableData(this.mRecord);
    }
    
    public int getRemovedCount() {
        return AccessibilityRecordCompat.IMPL.getRemovedCount(this.mRecord);
    }
    
    public int getScrollX() {
        return AccessibilityRecordCompat.IMPL.getScrollX(this.mRecord);
    }
    
    public int getScrollY() {
        return AccessibilityRecordCompat.IMPL.getScrollY(this.mRecord);
    }
    
    public AccessibilityNodeInfoCompat getSource() {
        return AccessibilityRecordCompat.IMPL.getSource(this.mRecord);
    }
    
    public List getText() {
        return AccessibilityRecordCompat.IMPL.getText(this.mRecord);
    }
    
    public int getToIndex() {
        return AccessibilityRecordCompat.IMPL.getToIndex(this.mRecord);
    }
    
    public int getWindowId() {
        return AccessibilityRecordCompat.IMPL.getWindowId(this.mRecord);
    }
    
    public int hashCode() {
        final Object mRecord = this.mRecord;
        int hashCode;
        if (mRecord == null) {
            hashCode = 0;
        }
        else {
            hashCode = mRecord.hashCode();
        }
        return hashCode;
    }
    
    public boolean isChecked() {
        return AccessibilityRecordCompat.IMPL.isChecked(this.mRecord);
    }
    
    public boolean isEnabled() {
        return AccessibilityRecordCompat.IMPL.isEnabled(this.mRecord);
    }
    
    public boolean isFullScreen() {
        return AccessibilityRecordCompat.IMPL.isFullScreen(this.mRecord);
    }
    
    public boolean isPassword() {
        return AccessibilityRecordCompat.IMPL.isPassword(this.mRecord);
    }
    
    public boolean isScrollable() {
        return AccessibilityRecordCompat.IMPL.isScrollable(this.mRecord);
    }
    
    public void recycle() {
        AccessibilityRecordCompat.IMPL.recycle(this.mRecord);
    }
    
    public void setAddedCount(final int n) {
        AccessibilityRecordCompat.IMPL.setAddedCount(this.mRecord, n);
    }
    
    public void setBeforeText(final CharSequence charSequence) {
        AccessibilityRecordCompat.IMPL.setBeforeText(this.mRecord, charSequence);
    }
    
    public void setChecked(final boolean b) {
        AccessibilityRecordCompat.IMPL.setChecked(this.mRecord, b);
    }
    
    public void setClassName(final CharSequence charSequence) {
        AccessibilityRecordCompat.IMPL.setClassName(this.mRecord, charSequence);
    }
    
    public void setContentDescription(final CharSequence charSequence) {
        AccessibilityRecordCompat.IMPL.setContentDescription(this.mRecord, charSequence);
    }
    
    public void setCurrentItemIndex(final int n) {
        AccessibilityRecordCompat.IMPL.setCurrentItemIndex(this.mRecord, n);
    }
    
    public void setEnabled(final boolean b) {
        AccessibilityRecordCompat.IMPL.setEnabled(this.mRecord, b);
    }
    
    public void setFromIndex(final int n) {
        AccessibilityRecordCompat.IMPL.setFromIndex(this.mRecord, n);
    }
    
    public void setFullScreen(final boolean b) {
        AccessibilityRecordCompat.IMPL.setFullScreen(this.mRecord, b);
    }
    
    public void setItemCount(final int n) {
        AccessibilityRecordCompat.IMPL.setItemCount(this.mRecord, n);
    }
    
    public void setMaxScrollX(final int n) {
        AccessibilityRecordCompat.IMPL.setMaxScrollX(this.mRecord, n);
    }
    
    public void setMaxScrollY(final int n) {
        AccessibilityRecordCompat.IMPL.setMaxScrollY(this.mRecord, n);
    }
    
    public void setParcelableData(final Parcelable parcelable) {
        AccessibilityRecordCompat.IMPL.setParcelableData(this.mRecord, parcelable);
    }
    
    public void setPassword(final boolean b) {
        AccessibilityRecordCompat.IMPL.setPassword(this.mRecord, b);
    }
    
    public void setRemovedCount(final int n) {
        AccessibilityRecordCompat.IMPL.setRemovedCount(this.mRecord, n);
    }
    
    public void setScrollX(final int n) {
        AccessibilityRecordCompat.IMPL.setScrollX(this.mRecord, n);
    }
    
    public void setScrollY(final int n) {
        AccessibilityRecordCompat.IMPL.setScrollY(this.mRecord, n);
    }
    
    public void setScrollable(final boolean b) {
        AccessibilityRecordCompat.IMPL.setScrollable(this.mRecord, b);
    }
    
    public void setSource(final View view) {
        AccessibilityRecordCompat.IMPL.setSource(this.mRecord, view);
    }
    
    public void setSource(final View view, final int n) {
        AccessibilityRecordCompat.IMPL.setSource(this.mRecord, view, n);
    }
    
    public void setToIndex(final int n) {
        AccessibilityRecordCompat.IMPL.setToIndex(this.mRecord, n);
    }
}
