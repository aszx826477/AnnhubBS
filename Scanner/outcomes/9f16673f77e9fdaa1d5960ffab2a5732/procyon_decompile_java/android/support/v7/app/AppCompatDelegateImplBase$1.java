// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v7.app;

import android.content.res.Resources$NotFoundException;

final class AppCompatDelegateImplBase$1 implements UncaughtExceptionHandler
{
    final /* synthetic */ UncaughtExceptionHandler val$defHandler;
    
    AppCompatDelegateImplBase$1(final UncaughtExceptionHandler val$defHandler) {
        this.val$defHandler = val$defHandler;
    }
    
    private boolean shouldWrapException(final Throwable t) {
        final boolean b = t instanceof Resources$NotFoundException;
        boolean b2 = false;
        if (b) {
            final String message = t.getMessage();
            if (message != null) {
                if (message.contains("drawable") || message.contains("Drawable")) {
                    b2 = true;
                }
            }
            return b2;
        }
        return false;
    }
    
    public void uncaughtException(final Thread thread, final Throwable t) {
        if (this.shouldWrapException(t)) {
            final StringBuilder sb = new StringBuilder();
            sb.append(t.getMessage());
            sb.append(". If the resource you are trying to use is a vector resource, you may be referencing it in an unsupported way. See AppCompatDelegate.setCompatVectorFromResourcesEnabled() for more info.");
            final Resources$NotFoundException ex = new Resources$NotFoundException(sb.toString());
            ((Throwable)ex).initCause(t.getCause());
            ((Throwable)ex).setStackTrace(t.getStackTrace());
            this.val$defHandler.uncaughtException(thread, (Throwable)ex);
        }
        else {
            this.val$defHandler.uncaughtException(thread, t);
        }
    }
}
