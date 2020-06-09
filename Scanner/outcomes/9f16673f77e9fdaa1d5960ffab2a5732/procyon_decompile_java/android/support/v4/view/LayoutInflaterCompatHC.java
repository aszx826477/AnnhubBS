// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.view;

import android.view.LayoutInflater$Factory;
import android.util.Log;
import android.view.LayoutInflater$Factory2;
import android.view.LayoutInflater;
import java.lang.reflect.Field;

class LayoutInflaterCompatHC
{
    private static final String TAG = "LayoutInflaterCompatHC";
    private static boolean sCheckedField;
    private static Field sLayoutInflaterFactory2Field;
    
    static void forceSetFactory2(final LayoutInflater layoutInflater, final LayoutInflater$Factory2 layoutInflater$Factory2) {
        if (!LayoutInflaterCompatHC.sCheckedField) {
            final boolean b = true;
            final Class<LayoutInflater> clazz = LayoutInflater.class;
            final String s = "mFactory2";
            final Class<LayoutInflater> clazz2 = clazz;
            try {
                final Field declaredField = clazz2.getDeclaredField(s);
                try {
                    (LayoutInflaterCompatHC.sLayoutInflaterFactory2Field = declaredField).setAccessible(b);
                }
                catch (NoSuchFieldException ex) {
                    final String s2 = "LayoutInflaterCompatHC";
                    final StringBuilder sb = new StringBuilder();
                    sb.append("forceSetFactory2 Could not find field 'mFactory2' on class ");
                    sb.append(LayoutInflater.class.getName());
                    sb.append("; inflation may have unexpected results.");
                    Log.e(s2, sb.toString(), (Throwable)ex);
                }
            }
            catch (NoSuchFieldException ex3) {}
            LayoutInflaterCompatHC.sCheckedField = b;
        }
        final Field sLayoutInflaterFactory2Field = LayoutInflaterCompatHC.sLayoutInflaterFactory2Field;
        if (sLayoutInflaterFactory2Field != null) {
            final Field field = sLayoutInflaterFactory2Field;
            try {
                field.set(layoutInflater, layoutInflater$Factory2);
            }
            catch (IllegalAccessException ex2) {
                final String s3 = "LayoutInflaterCompatHC";
                final StringBuilder sb2 = new StringBuilder();
                sb2.append("forceSetFactory2 could not set the Factory2 on LayoutInflater ");
                sb2.append(layoutInflater);
                sb2.append("; inflation may have unexpected results.");
                Log.e(s3, sb2.toString(), (Throwable)ex2);
            }
        }
    }
    
    static void setFactory(final LayoutInflater layoutInflater, final LayoutInflaterFactory layoutInflaterFactory) {
        Object factory2;
        if (layoutInflaterFactory != null) {
            factory2 = new LayoutInflaterCompatHC$FactoryWrapperHC(layoutInflaterFactory);
        }
        else {
            factory2 = null;
        }
        layoutInflater.setFactory2((LayoutInflater$Factory2)factory2);
        final LayoutInflater$Factory factory3 = layoutInflater.getFactory();
        if (factory3 instanceof LayoutInflater$Factory2) {
            forceSetFactory2(layoutInflater, (LayoutInflater$Factory2)factory3);
        }
        else {
            forceSetFactory2(layoutInflater, (LayoutInflater$Factory2)factory2);
        }
    }
}
