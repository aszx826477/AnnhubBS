// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v7.view.menu;

class BaseWrapper
{
    final Object mWrappedObject;
    
    BaseWrapper(final Object mWrappedObject) {
        if (mWrappedObject != null) {
            this.mWrappedObject = mWrappedObject;
            return;
        }
        throw new IllegalArgumentException("Wrapped Object can not be null.");
    }
    
    public Object getWrappedObject() {
        return this.mWrappedObject;
    }
}
