// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.media.session;

import android.os.ResultReceiver;
import android.os.Bundle;

final class MediaSessionCompat$MediaSessionImplBase$Command
{
    public final String command;
    public final Bundle extras;
    public final ResultReceiver stub;
    
    public MediaSessionCompat$MediaSessionImplBase$Command(final String command, final Bundle extras, final ResultReceiver stub) {
        this.command = command;
        this.extras = extras;
        this.stub = stub;
    }
}
