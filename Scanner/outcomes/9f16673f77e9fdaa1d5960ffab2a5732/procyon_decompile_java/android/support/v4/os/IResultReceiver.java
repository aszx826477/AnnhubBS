// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.os;

import android.os.Bundle;
import android.os.IInterface;

public interface IResultReceiver extends IInterface
{
    void send(final int p0, final Bundle p1);
}
