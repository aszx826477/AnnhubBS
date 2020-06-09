// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.content;

import java.io.File;
import android.net.Uri;

interface FileProvider$PathStrategy
{
    File getFileForUri(final Uri p0);
    
    Uri getUriForFile(final File p0);
}
