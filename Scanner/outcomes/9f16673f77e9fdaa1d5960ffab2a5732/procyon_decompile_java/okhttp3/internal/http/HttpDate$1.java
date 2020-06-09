// 
// Decompiled by Procyon v0.5.30
// 

package okhttp3.internal.http;

import okhttp3.internal.Util;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.text.DateFormat;

final class HttpDate$1 extends ThreadLocal
{
    protected DateFormat initialValue() {
        final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss 'GMT'", Locale.US);
        simpleDateFormat.setLenient(false);
        simpleDateFormat.setTimeZone(Util.UTC);
        return simpleDateFormat;
    }
}
