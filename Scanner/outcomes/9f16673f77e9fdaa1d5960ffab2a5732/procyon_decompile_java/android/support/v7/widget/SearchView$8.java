// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v7.widget;

import android.widget.AutoCompleteTextView;
import android.view.inputmethod.InputMethodManager;
import android.view.KeyEvent$DispatcherState;
import android.graphics.Rect;
import android.util.TypedValue;
import android.text.TextUtils;
import android.content.res.Configuration;
import android.support.v4.content.res.ConfigurationHelper;
import android.support.v7.appcompat.R$attr;
import android.util.AttributeSet;
import android.content.Context;
import android.support.v4.view.KeyEventCompat;
import android.view.KeyEvent;
import android.view.View;
import android.view.View$OnKeyListener;

class SearchView$8 implements View$OnKeyListener
{
    final /* synthetic */ SearchView this$0;
    
    SearchView$8(final SearchView this$0) {
        this.this$0 = this$0;
    }
    
    public boolean onKey(final View view, final int n, final KeyEvent keyEvent) {
        if (this.this$0.mSearchable == null) {
            return false;
        }
        if (this.this$0.mSearchSrcTextView.isPopupShowing() && this.this$0.mSearchSrcTextView.getListSelection() != -1) {
            return this.this$0.onSuggestionsKey(view, n, keyEvent);
        }
        if (!this.this$0.mSearchSrcTextView.isEmpty() && KeyEventCompat.hasNoModifiers(keyEvent)) {
            final int action = keyEvent.getAction();
            final boolean b = true;
            if (action == (b ? 1 : 0)) {
                if (n == 66) {
                    view.cancelLongPress();
                    final SearchView this$0 = this.this$0;
                    this$0.launchQuerySearch(0, null, this$0.mSearchSrcTextView.getText().toString());
                    return b;
                }
            }
        }
        return false;
    }
}
