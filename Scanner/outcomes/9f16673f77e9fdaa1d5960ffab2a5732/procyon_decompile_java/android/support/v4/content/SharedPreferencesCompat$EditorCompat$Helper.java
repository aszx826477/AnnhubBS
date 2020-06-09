// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.content;

import android.content.SharedPreferences$Editor;

class SharedPreferencesCompat$EditorCompat$Helper
{
    public void apply(final SharedPreferences$Editor sharedPreferences$Editor) {
        try {
            sharedPreferences$Editor.apply();
        }
        catch (AbstractMethodError abstractMethodError) {
            sharedPreferences$Editor.commit();
        }
    }
}
