// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.media.session;

import android.media.AudioManager;
import android.content.Context;
import android.media.RemoteControlClient;
import android.app.PendingIntent;
import android.graphics.Bitmap;
import android.media.RemoteControlClient$MetadataEditor;
import android.os.Bundle;

class MediaSessionCompatApi14
{
    private static final long ACTION_FAST_FORWARD = 64L;
    private static final long ACTION_PAUSE = 2L;
    private static final long ACTION_PLAY = 4L;
    private static final long ACTION_PLAY_PAUSE = 512L;
    private static final long ACTION_REWIND = 8L;
    private static final long ACTION_SKIP_TO_NEXT = 32L;
    private static final long ACTION_SKIP_TO_PREVIOUS = 16L;
    private static final long ACTION_STOP = 1L;
    private static final String METADATA_KEY_ALBUM = "android.media.metadata.ALBUM";
    private static final String METADATA_KEY_ALBUM_ART = "android.media.metadata.ALBUM_ART";
    private static final String METADATA_KEY_ALBUM_ARTIST = "android.media.metadata.ALBUM_ARTIST";
    private static final String METADATA_KEY_ART = "android.media.metadata.ART";
    private static final String METADATA_KEY_ARTIST = "android.media.metadata.ARTIST";
    private static final String METADATA_KEY_AUTHOR = "android.media.metadata.AUTHOR";
    private static final String METADATA_KEY_COMPILATION = "android.media.metadata.COMPILATION";
    private static final String METADATA_KEY_COMPOSER = "android.media.metadata.COMPOSER";
    private static final String METADATA_KEY_DATE = "android.media.metadata.DATE";
    private static final String METADATA_KEY_DISC_NUMBER = "android.media.metadata.DISC_NUMBER";
    private static final String METADATA_KEY_DURATION = "android.media.metadata.DURATION";
    private static final String METADATA_KEY_GENRE = "android.media.metadata.GENRE";
    private static final String METADATA_KEY_TITLE = "android.media.metadata.TITLE";
    private static final String METADATA_KEY_TRACK_NUMBER = "android.media.metadata.TRACK_NUMBER";
    private static final String METADATA_KEY_WRITER = "android.media.metadata.WRITER";
    static final int RCC_PLAYSTATE_NONE = 0;
    static final int STATE_BUFFERING = 6;
    static final int STATE_CONNECTING = 8;
    static final int STATE_ERROR = 7;
    static final int STATE_FAST_FORWARDING = 4;
    static final int STATE_NONE = 0;
    static final int STATE_PAUSED = 2;
    static final int STATE_PLAYING = 3;
    static final int STATE_REWINDING = 5;
    static final int STATE_SKIPPING_TO_NEXT = 10;
    static final int STATE_SKIPPING_TO_PREVIOUS = 9;
    static final int STATE_SKIPPING_TO_QUEUE_ITEM = 11;
    static final int STATE_STOPPED = 1;
    
    static void buildOldMetadata(final Bundle bundle, final RemoteControlClient$MetadataEditor remoteControlClient$MetadataEditor) {
        if (bundle == null) {
            return;
        }
        final boolean containsKey = bundle.containsKey("android.media.metadata.ART");
        final int n = 100;
        if (containsKey) {
            remoteControlClient$MetadataEditor.putBitmap(n, (Bitmap)bundle.getParcelable("android.media.metadata.ART"));
        }
        else if (bundle.containsKey("android.media.metadata.ALBUM_ART")) {
            remoteControlClient$MetadataEditor.putBitmap(n, (Bitmap)bundle.getParcelable("android.media.metadata.ALBUM_ART"));
        }
        if (bundle.containsKey("android.media.metadata.ALBUM")) {
            remoteControlClient$MetadataEditor.putString(1, bundle.getString("android.media.metadata.ALBUM"));
        }
        if (bundle.containsKey("android.media.metadata.ALBUM_ARTIST")) {
            remoteControlClient$MetadataEditor.putString(13, bundle.getString("android.media.metadata.ALBUM_ARTIST"));
        }
        if (bundle.containsKey("android.media.metadata.ARTIST")) {
            remoteControlClient$MetadataEditor.putString(2, bundle.getString("android.media.metadata.ARTIST"));
        }
        if (bundle.containsKey("android.media.metadata.AUTHOR")) {
            remoteControlClient$MetadataEditor.putString(3, bundle.getString("android.media.metadata.AUTHOR"));
        }
        if (bundle.containsKey("android.media.metadata.COMPILATION")) {
            remoteControlClient$MetadataEditor.putString(15, bundle.getString("android.media.metadata.COMPILATION"));
        }
        if (bundle.containsKey("android.media.metadata.COMPOSER")) {
            remoteControlClient$MetadataEditor.putString(4, bundle.getString("android.media.metadata.COMPOSER"));
        }
        if (bundle.containsKey("android.media.metadata.DATE")) {
            remoteControlClient$MetadataEditor.putString(5, bundle.getString("android.media.metadata.DATE"));
        }
        if (bundle.containsKey("android.media.metadata.DISC_NUMBER")) {
            remoteControlClient$MetadataEditor.putLong(14, bundle.getLong("android.media.metadata.DISC_NUMBER"));
        }
        if (bundle.containsKey("android.media.metadata.DURATION")) {
            remoteControlClient$MetadataEditor.putLong(9, bundle.getLong("android.media.metadata.DURATION"));
        }
        if (bundle.containsKey("android.media.metadata.GENRE")) {
            remoteControlClient$MetadataEditor.putString(6, bundle.getString("android.media.metadata.GENRE"));
        }
        if (bundle.containsKey("android.media.metadata.TITLE")) {
            remoteControlClient$MetadataEditor.putString(7, bundle.getString("android.media.metadata.TITLE"));
        }
        if (bundle.containsKey("android.media.metadata.TRACK_NUMBER")) {
            remoteControlClient$MetadataEditor.putLong(0, bundle.getLong("android.media.metadata.TRACK_NUMBER"));
        }
        if (bundle.containsKey("android.media.metadata.WRITER")) {
            remoteControlClient$MetadataEditor.putString(11, bundle.getString("android.media.metadata.WRITER"));
        }
    }
    
    public static Object createRemoteControlClient(final PendingIntent pendingIntent) {
        return new RemoteControlClient(pendingIntent);
    }
    
    static int getRccStateFromState(final int n) {
        switch (n) {
            default: {
                return -1;
            }
            case 10:
            case 11: {
                return 6;
            }
            case 9: {
                return 7;
            }
            case 7: {
                return 9;
            }
            case 6:
            case 8: {
                return 8;
            }
            case 5: {
                return 5;
            }
            case 4: {
                return 4;
            }
            case 3: {
                return 3;
            }
            case 2: {
                return 2;
            }
            case 1: {
                return 1;
            }
            case 0: {
                return 0;
            }
        }
    }
    
    static int getRccTransportControlFlagsFromActions(final long n) {
        int n2 = 0;
        final long n3 = 0x1L & n;
        final long n4 = 0L;
        if (n3 != n4) {
            n2 = (0x0 | 0x20);
        }
        if ((0x2 & n) != n4) {
            n2 |= 0x10;
        }
        if ((0x4 & n) != n4) {
            n2 |= 0x4;
        }
        if ((0x8 & n) != n4) {
            n2 |= 0x2;
        }
        if ((0x10 & n) != n4) {
            n2 |= 0x1;
        }
        if ((0x20 & n) != n4) {
            n2 |= 0x80;
        }
        if ((0x40 & n) != n4) {
            n2 |= 0x40;
        }
        if ((0x200L & n) != n4) {
            n2 |= 0x8;
        }
        return n2;
    }
    
    public static void registerRemoteControlClient(final Context context, final Object o) {
        ((AudioManager)context.getSystemService("audio")).registerRemoteControlClient((RemoteControlClient)o);
    }
    
    public static void setMetadata(final Object o, final Bundle bundle) {
        final RemoteControlClient$MetadataEditor editMetadata = ((RemoteControlClient)o).editMetadata(true);
        buildOldMetadata(bundle, editMetadata);
        editMetadata.apply();
    }
    
    public static void setState(final Object o, final int n) {
        ((RemoteControlClient)o).setPlaybackState(getRccStateFromState(n));
    }
    
    public static void setTransportControlFlags(final Object o, final long n) {
        ((RemoteControlClient)o).setTransportControlFlags(getRccTransportControlFlagsFromActions(n));
    }
    
    public static void unregisterRemoteControlClient(final Context context, final Object o) {
        ((AudioManager)context.getSystemService("audio")).unregisterRemoteControlClient((RemoteControlClient)o);
    }
}
