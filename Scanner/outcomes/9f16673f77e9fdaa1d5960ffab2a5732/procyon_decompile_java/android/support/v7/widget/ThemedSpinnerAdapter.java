// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v7.widget;

import android.content.res.Resources$Theme;
import android.widget.SpinnerAdapter;

public interface ThemedSpinnerAdapter extends SpinnerAdapter
{
    Resources$Theme getDropDownViewTheme();
    
    void setDropDownViewTheme(final Resources$Theme p0);
}
