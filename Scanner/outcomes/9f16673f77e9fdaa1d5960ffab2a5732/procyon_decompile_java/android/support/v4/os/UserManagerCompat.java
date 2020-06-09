// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.os;

import android.content.Context;

public class UserManagerCompat
{
    public static boolean isUserUnlocked(final Context context) {
        return !BuildCompat.isAtLeastN() || UserManagerCompatApi24.isUserUnlocked(context);
    }
}
