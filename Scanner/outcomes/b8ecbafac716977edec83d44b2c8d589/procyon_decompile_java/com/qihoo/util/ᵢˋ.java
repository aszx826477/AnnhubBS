// 
// Decompiled by Procyon v0.5.30
// 

package com.qihoo.util;

import android.app.AlertDialog;
import android.content.DialogInterface$OnClickListener;
import android.app.AlertDialog$Builder;
import android.os.Looper;
import android.content.Context;

final class \u1d62\u02cb implements Runnable
{
    private /* synthetic */ Context \u1d62\u02cb;
    private /* synthetic */ String \u1d62\u02ce;
    
    \u1d62\u02cb(final Context \u1d62\u02cb, final String \u1d62\u02ce) {
        this.\u1d62\u02cb = \u1d62\u02cb;
        this.\u1d62\u02ce = \u1d62\u02ce;
    }
    
    public final void run() {
        Looper.prepare();
        final AlertDialog create = new AlertDialog$Builder(this.\u1d62\u02cb).setMessage((CharSequence)this.\u1d62\u02ce).setCancelable(false).setPositiveButton((CharSequence)"\u786e\u5b9a", (DialogInterface$OnClickListener)new \u1d62\u02ce(this)).create();
        create.getWindow().setType(2005);
        create.show();
        Looper.loop();
    }
}
