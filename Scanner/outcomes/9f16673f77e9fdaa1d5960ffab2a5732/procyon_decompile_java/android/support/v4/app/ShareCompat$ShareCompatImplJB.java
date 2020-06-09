// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.app;

import android.view.MenuItem;

class ShareCompat$ShareCompatImplJB extends ShareCompat$ShareCompatImplICS
{
    public String escapeHtml(final CharSequence charSequence) {
        return ShareCompatJB.escapeHtml(charSequence);
    }
    
    boolean shouldAddChooserIntent(final MenuItem menuItem) {
        return false;
    }
}
