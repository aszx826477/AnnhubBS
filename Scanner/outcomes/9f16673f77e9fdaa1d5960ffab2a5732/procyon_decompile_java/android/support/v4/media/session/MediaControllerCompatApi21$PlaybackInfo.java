// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.media.session;

import android.media.session.MediaController$PlaybackInfo;
import android.media.AudioAttributes;

public class MediaControllerCompatApi21$PlaybackInfo
{
    private static final int FLAG_SCO = 4;
    private static final int STREAM_BLUETOOTH_SCO = 6;
    private static final int STREAM_SYSTEM_ENFORCED = 7;
    
    public static AudioAttributes getAudioAttributes(final Object o) {
        return ((MediaController$PlaybackInfo)o).getAudioAttributes();
    }
    
    public static int getCurrentVolume(final Object o) {
        return ((MediaController$PlaybackInfo)o).getCurrentVolume();
    }
    
    public static int getLegacyAudioStream(final Object o) {
        return toLegacyStreamType(getAudioAttributes(o));
    }
    
    public static int getMaxVolume(final Object o) {
        return ((MediaController$PlaybackInfo)o).getMaxVolume();
    }
    
    public static int getPlaybackType(final Object o) {
        return ((MediaController$PlaybackInfo)o).getPlaybackType();
    }
    
    public static int getVolumeControl(final Object o) {
        return ((MediaController$PlaybackInfo)o).getVolumeControl();
    }
    
    private static int toLegacyStreamType(final AudioAttributes audioAttributes) {
        final int flags = audioAttributes.getFlags();
        final boolean b = true;
        if ((flags & (b ? 1 : 0)) == (b ? 1 : 0)) {
            return 7;
        }
        final int flags2 = audioAttributes.getFlags();
        final int n = 4;
        if ((flags2 & n) == n) {
            return 6;
        }
        final int usage = audioAttributes.getUsage();
        final int n2 = 3;
        switch (usage) {
            default: {
                return n2;
            }
            case 13: {
                return b ? 1 : 0;
            }
            case 6: {
                return 2;
            }
            case 5:
            case 7:
            case 8:
            case 9:
            case 10: {
                return 5;
            }
            case 4: {
                return n;
            }
            case 3: {
                return 8;
            }
            case 2: {
                return 0;
            }
            case 1:
            case 11:
            case 12:
            case 14: {
                return n2;
            }
        }
    }
}
