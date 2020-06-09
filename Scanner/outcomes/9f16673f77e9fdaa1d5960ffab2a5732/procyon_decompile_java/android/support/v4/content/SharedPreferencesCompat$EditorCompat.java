// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.content;

import android.content.SharedPreferences$Editor;

public final class SharedPreferencesCompat$EditorCompat
{
    private static SharedPreferencesCompat$EditorCompat sInstance;
    private final SharedPreferencesCompat$EditorCompat$Helper mHelper;
    
    private SharedPreferencesCompat$EditorCompat() {
        this.mHelper = new SharedPreferencesCompat$EditorCompat$Helper();
    }
    
    public static SharedPreferencesCompat$EditorCompat getInstance() {
        if (SharedPreferencesCompat$EditorCompat.sInstance == null) {
            SharedPreferencesCompat$EditorCompat.sInstance = new SharedPreferencesCompat$EditorCompat();
        }
        return SharedPreferencesCompat$EditorCompat.sInstance;
    }
    
    public void apply(final SharedPreferences$Editor sharedPreferences$Editor) {
        this.mHelper.apply(sharedPreferences$Editor);
    }
}
