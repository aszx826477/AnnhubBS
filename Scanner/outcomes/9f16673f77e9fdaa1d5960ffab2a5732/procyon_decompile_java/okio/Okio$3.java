// 
// Decompiled by Procyon v0.5.30
// 

package okio;

import java.util.logging.Logger;
import java.util.logging.Level;
import java.net.SocketTimeoutException;
import java.io.IOException;
import java.net.Socket;

final class Okio$3 extends AsyncTimeout
{
    final /* synthetic */ Socket val$socket;
    
    Okio$3(final Socket val$socket) {
        this.val$socket = val$socket;
    }
    
    protected IOException newTimeoutException(final IOException ex) {
        final SocketTimeoutException ex2 = new SocketTimeoutException("timeout");
        if (ex != null) {
            ex2.initCause(ex);
        }
        return ex2;
    }
    
    protected void timedOut() {
        try {
            final Socket val$socket = this.val$socket;
            try {
                val$socket.close();
            }
            catch (AssertionError assertionError) {
                if (Okio.isAndroidGetsocknameError(assertionError)) {
                    final Logger logger = Okio.logger;
                    final Level warning = Level.WARNING;
                    final StringBuilder sb = new StringBuilder();
                    sb.append("Failed to close timed out socket ");
                    sb.append(this.val$socket);
                    logger.log(warning, sb.toString(), assertionError);
                    return;
                }
                throw assertionError;
            }
            catch (Exception ex) {
                final Logger logger2 = Okio.logger;
                final Level warning2 = Level.WARNING;
                final StringBuilder sb2 = new StringBuilder();
                sb2.append("Failed to close timed out socket ");
                sb2.append(this.val$socket);
                logger2.log(warning2, sb2.toString(), ex);
            }
        }
        catch (AssertionError assertionError2) {}
        catch (Exception ex2) {}
    }
}
