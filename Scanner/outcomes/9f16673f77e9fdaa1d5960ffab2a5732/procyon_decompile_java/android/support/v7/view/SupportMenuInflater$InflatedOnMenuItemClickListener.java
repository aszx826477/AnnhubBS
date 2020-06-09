// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v7.view;

import android.view.InflateException;
import android.view.MenuItem;
import java.lang.reflect.Method;
import android.view.MenuItem$OnMenuItemClickListener;

class SupportMenuInflater$InflatedOnMenuItemClickListener implements MenuItem$OnMenuItemClickListener
{
    private static final Class[] PARAM_TYPES;
    private Method mMethod;
    private Object mRealOwner;
    
    static {
        PARAM_TYPES = new Class[] { MenuItem.class };
    }
    
    public SupportMenuInflater$InflatedOnMenuItemClickListener(final Object mRealOwner, final String s) {
        this.mRealOwner = mRealOwner;
        final Class<?> class1 = mRealOwner.getClass();
        try {
            this.mMethod = class1.getMethod(s, (Class<?>[])SupportMenuInflater$InflatedOnMenuItemClickListener.PARAM_TYPES);
        }
        catch (Exception ex2) {
            final StringBuilder sb = new StringBuilder();
            sb.append("Couldn't resolve menu item onClick handler ");
            sb.append(s);
            sb.append(" in class ");
            sb.append(class1.getName());
            final InflateException ex = new InflateException(sb.toString());
            ex.initCause((Throwable)ex2);
            throw ex;
        }
    }
    
    public boolean onMenuItemClick(final MenuItem menuItem) {
        try {
            final Method mMethod = this.mMethod;
            try {
                final Class<?> returnType = mMethod.getReturnType();
                try {
                    final Class<Boolean> type = Boolean.TYPE;
                    final int n = 1;
                    Label_0062: {
                        if (returnType != type) {
                            break Label_0062;
                        }
                        final Method mMethod2 = this.mMethod;
                        try {
                            final Object mRealOwner = this.mRealOwner;
                            try {
                                final Object[] array = new Object[n];
                                array[0] = menuItem;
                                final Object invoke = mMethod2.invoke(mRealOwner, array);
                                try {
                                    final Boolean b = (Boolean)invoke;
                                    try {
                                        return b;
                                        final Method mMethod3 = this.mMethod;
                                        try {
                                            final Object mRealOwner2 = this.mRealOwner;
                                            try {
                                                final Object[] array2 = new Object[n];
                                                array2[0] = menuItem;
                                                mMethod3.invoke(mRealOwner2, array2);
                                                return n != 0;
                                            }
                                            catch (Exception ex) {
                                                throw new RuntimeException(ex);
                                            }
                                        }
                                        catch (Exception ex2) {}
                                    }
                                    catch (Exception ex3) {}
                                }
                                catch (Exception ex4) {}
                            }
                            catch (Exception ex5) {}
                        }
                        catch (Exception ex6) {}
                    }
                }
                catch (Exception ex7) {}
            }
            catch (Exception ex8) {}
        }
        catch (Exception ex9) {}
    }
}
