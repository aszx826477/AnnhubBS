// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.view;

import android.view.LayoutInflater$Factory;
import android.view.LayoutInflater;

class LayoutInflaterCompatBase
{
    static LayoutInflaterFactory getFactory(final LayoutInflater layoutInflater) {
        final LayoutInflater$Factory factory = layoutInflater.getFactory();
        if (factory instanceof LayoutInflaterCompatBase$FactoryWrapper) {
            return ((LayoutInflaterCompatBase$FactoryWrapper)factory).mDelegateFactory;
        }
        return null;
    }
    
    static void setFactory(final LayoutInflater layoutInflater, final LayoutInflaterFactory layoutInflaterFactory) {
        Object factory;
        if (layoutInflaterFactory != null) {
            factory = new LayoutInflaterCompatBase$FactoryWrapper(layoutInflaterFactory);
        }
        else {
            factory = null;
        }
        layoutInflater.setFactory((LayoutInflater$Factory)factory);
    }
}
