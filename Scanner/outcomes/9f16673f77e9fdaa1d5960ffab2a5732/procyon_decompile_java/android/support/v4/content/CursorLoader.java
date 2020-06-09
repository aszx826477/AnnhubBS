// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.content;

import android.support.v4.os.OperationCanceledException;
import android.database.ContentObserver;
import java.util.Arrays;
import java.io.PrintWriter;
import java.io.FileDescriptor;
import android.content.Context;
import android.net.Uri;
import android.database.Cursor;
import android.support.v4.os.CancellationSignal;

public class CursorLoader extends AsyncTaskLoader
{
    CancellationSignal mCancellationSignal;
    Cursor mCursor;
    final Loader$ForceLoadContentObserver mObserver;
    String[] mProjection;
    String mSelection;
    String[] mSelectionArgs;
    String mSortOrder;
    Uri mUri;
    
    public CursorLoader(final Context context) {
        super(context);
        this.mObserver = new Loader$ForceLoadContentObserver(this);
    }
    
    public CursorLoader(final Context context, final Uri mUri, final String[] mProjection, final String mSelection, final String[] mSelectionArgs, final String mSortOrder) {
        super(context);
        this.mObserver = new Loader$ForceLoadContentObserver(this);
        this.mUri = mUri;
        this.mProjection = mProjection;
        this.mSelection = mSelection;
        this.mSelectionArgs = mSelectionArgs;
        this.mSortOrder = mSortOrder;
    }
    
    public void cancelLoadInBackground() {
        super.cancelLoadInBackground();
        synchronized (this) {
            if (this.mCancellationSignal != null) {
                this.mCancellationSignal.cancel();
            }
        }
    }
    
    public void deliverResult(final Cursor mCursor) {
        if (this.isReset()) {
            if (mCursor != null) {
                mCursor.close();
            }
            return;
        }
        final Cursor mCursor2 = this.mCursor;
        this.mCursor = mCursor;
        if (this.isStarted()) {
            super.deliverResult(mCursor);
        }
        if (mCursor2 != null && mCursor2 != mCursor && !mCursor2.isClosed()) {
            mCursor2.close();
        }
    }
    
    public void dump(final String s, final FileDescriptor fileDescriptor, final PrintWriter printWriter, final String[] array) {
        super.dump(s, fileDescriptor, printWriter, array);
        printWriter.print(s);
        printWriter.print("mUri=");
        printWriter.println(this.mUri);
        printWriter.print(s);
        printWriter.print("mProjection=");
        printWriter.println(Arrays.toString(this.mProjection));
        printWriter.print(s);
        printWriter.print("mSelection=");
        printWriter.println(this.mSelection);
        printWriter.print(s);
        printWriter.print("mSelectionArgs=");
        printWriter.println(Arrays.toString(this.mSelectionArgs));
        printWriter.print(s);
        printWriter.print("mSortOrder=");
        printWriter.println(this.mSortOrder);
        printWriter.print(s);
        printWriter.print("mCursor=");
        printWriter.println(this.mCursor);
        printWriter.print(s);
        printWriter.print("mContentChanged=");
        printWriter.println(this.mContentChanged);
    }
    
    public String[] getProjection() {
        return this.mProjection;
    }
    
    public String getSelection() {
        return this.mSelection;
    }
    
    public String[] getSelectionArgs() {
        return this.mSelectionArgs;
    }
    
    public String getSortOrder() {
        return this.mSortOrder;
    }
    
    public Uri getUri() {
        return this.mUri;
    }
    
    public Cursor loadInBackground() {
        synchronized (this) {
            if (!this.isLoadInBackgroundCanceled()) {
                this.mCancellationSignal = new CancellationSignal();
                // monitorexit(this)
                try {
                    final Cursor query = ContentResolverCompat.query(this.getContext().getContentResolver(), this.mUri, this.mProjection, this.mSelection, this.mSelectionArgs, this.mSortOrder, this.mCancellationSignal);
                    if (query != null) {
                        try {
                            query.getCount();
                            query.registerContentObserver((ContentObserver)this.mObserver);
                        }
                        catch (RuntimeException ex) {
                            query.close();
                            throw ex;
                        }
                    }
                    synchronized (this) {
                        this.mCancellationSignal = null;
                        return query;
                    }
                }
                finally {
                    synchronized (this) {
                        this.mCancellationSignal = null;
                    }
                }
            }
            throw new OperationCanceledException();
        }
    }
    
    public void onCanceled(final Cursor cursor) {
        if (cursor != null && !cursor.isClosed()) {
            cursor.close();
        }
    }
    
    protected void onReset() {
        super.onReset();
        this.onStopLoading();
        final Cursor mCursor = this.mCursor;
        if (mCursor != null && !mCursor.isClosed()) {
            this.mCursor.close();
        }
        this.mCursor = null;
    }
    
    protected void onStartLoading() {
        final Cursor mCursor = this.mCursor;
        if (mCursor != null) {
            this.deliverResult(mCursor);
        }
        if (this.takeContentChanged() || this.mCursor == null) {
            this.forceLoad();
        }
    }
    
    protected void onStopLoading() {
        this.cancelLoad();
    }
    
    public void setProjection(final String[] mProjection) {
        this.mProjection = mProjection;
    }
    
    public void setSelection(final String mSelection) {
        this.mSelection = mSelection;
    }
    
    public void setSelectionArgs(final String[] mSelectionArgs) {
        this.mSelectionArgs = mSelectionArgs;
    }
    
    public void setSortOrder(final String mSortOrder) {
        this.mSortOrder = mSortOrder;
    }
    
    public void setUri(final Uri mUri) {
        this.mUri = mUri;
    }
}
