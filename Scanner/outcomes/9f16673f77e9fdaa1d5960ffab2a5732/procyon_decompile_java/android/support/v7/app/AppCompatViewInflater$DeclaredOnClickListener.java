// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v7.app;

import java.lang.reflect.InvocationTargetException;
import android.content.ContextWrapper;
import java.lang.reflect.Method;
import android.content.Context;
import android.view.View;
import android.view.View$OnClickListener;

class AppCompatViewInflater$DeclaredOnClickListener implements View$OnClickListener
{
    private final View mHostView;
    private final String mMethodName;
    private Context mResolvedContext;
    private Method mResolvedMethod;
    
    public AppCompatViewInflater$DeclaredOnClickListener(final View mHostView, final String mMethodName) {
        this.mHostView = mHostView;
        this.mMethodName = mMethodName;
    }
    
    private void resolveMethod(Context baseContext, final String s) {
        while (baseContext != null) {
            try {
                Label_0076: {
                    if (baseContext.isRestricted()) {
                        break Label_0076;
                    }
                    final Class<? extends Context> class1 = baseContext.getClass();
                    try {
                        final Method method = class1.getMethod(this.mMethodName, View.class);
                        if (method == null) {
                            break Label_0076;
                        }
                        this.mResolvedMethod = method;
                        try {
                            this.mResolvedContext = baseContext;
                            return;
                        }
                        catch (NoSuchMethodException ex) {}
                    }
                    catch (NoSuchMethodException ex2) {}
                }
            }
            catch (NoSuchMethodException ex3) {}
            if (baseContext instanceof ContextWrapper) {
                baseContext = ((ContextWrapper)baseContext).getBaseContext();
            }
            else {
                baseContext = null;
            }
        }
        final int id = this.mHostView.getId();
        String string;
        if (id == -1) {
            string = "";
        }
        else {
            final StringBuilder sb = new StringBuilder();
            sb.append(" with id '");
            sb.append(this.mHostView.getContext().getResources().getResourceEntryName(id));
            sb.append("'");
            string = sb.toString();
        }
        final StringBuilder sb2 = new StringBuilder();
        sb2.append("Could not find method ");
        sb2.append(this.mMethodName);
        sb2.append("(View) in a parent or ancestor Context for android:onClick ");
        sb2.append("attribute defined on view ");
        sb2.append(this.mHostView.getClass());
        sb2.append(string);
        throw new IllegalStateException(sb2.toString());
    }
    
    public void onClick(final View view) {
        if (this.mResolvedMethod == null) {
            this.resolveMethod(this.mHostView.getContext(), this.mMethodName);
        }
        try {
            final Method mResolvedMethod = this.mResolvedMethod;
            try {
                mResolvedMethod.invoke(this.mResolvedContext, view);
            }
            catch (InvocationTargetException ex) {
                throw new IllegalStateException("Could not execute method for android:onClick", ex);
            }
            catch (IllegalAccessException ex2) {
                throw new IllegalStateException("Could not execute non-public method for android:onClick", ex2);
            }
        }
        catch (InvocationTargetException ex3) {}
        catch (IllegalAccessException ex4) {}
    }
}
