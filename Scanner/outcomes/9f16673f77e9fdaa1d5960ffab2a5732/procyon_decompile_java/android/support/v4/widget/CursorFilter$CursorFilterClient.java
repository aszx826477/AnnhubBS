// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.widget;

import android.database.Cursor;

interface CursorFilter$CursorFilterClient
{
    void changeCursor(final Cursor p0);
    
    CharSequence convertToString(final Cursor p0);
    
    Cursor getCursor();
    
    Cursor runQueryOnBackgroundThread(final CharSequence p0);
}
