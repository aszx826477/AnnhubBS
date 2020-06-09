// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.media.session;

import android.media.session.PlaybackState$CustomAction$Builder;
import android.os.Bundle;
import android.media.session.PlaybackState$CustomAction;

final class PlaybackStateCompatApi21$CustomAction
{
    public static String getAction(final Object o) {
        return ((PlaybackState$CustomAction)o).getAction();
    }
    
    public static Bundle getExtras(final Object o) {
        return ((PlaybackState$CustomAction)o).getExtras();
    }
    
    public static int getIcon(final Object o) {
        return ((PlaybackState$CustomAction)o).getIcon();
    }
    
    public static CharSequence getName(final Object o) {
        return ((PlaybackState$CustomAction)o).getName();
    }
    
    public static Object newInstance(final String s, final CharSequence charSequence, final int n, final Bundle extras) {
        final PlaybackState$CustomAction$Builder playbackState$CustomAction$Builder = new PlaybackState$CustomAction$Builder(s, charSequence, n);
        playbackState$CustomAction$Builder.setExtras(extras);
        return playbackState$CustomAction$Builder.build();
    }
}
