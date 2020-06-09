// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v7.widget;

import android.view.View;
import android.os.ResultReceiver;
import android.view.inputmethod.InputMethodManager;
import android.widget.AutoCompleteTextView;
import java.lang.reflect.Method;

class SearchView$AutoCompleteTextViewReflector
{
    private Method doAfterTextChanged;
    private Method doBeforeTextChanged;
    private Method ensureImeVisible;
    private Method showSoftInputUnchecked;
    
    SearchView$AutoCompleteTextViewReflector() {
        final int n = 1;
        final Class<AutoCompleteTextView> clazz = AutoCompleteTextView.class;
        final String s = "doBeforeTextChanged";
        try {
            (this.doBeforeTextChanged = clazz.getDeclaredMethod(s, (Class<?>[])new Class[0])).setAccessible(n != 0);
        }
        catch (NoSuchMethodException ex) {}
        final Class<AutoCompleteTextView> clazz2 = AutoCompleteTextView.class;
        final String s2 = "doAfterTextChanged";
        try {
            (this.doAfterTextChanged = clazz2.getDeclaredMethod(s2, (Class<?>[])new Class[0])).setAccessible(n != 0);
        }
        catch (NoSuchMethodException ex2) {}
        final Class<AutoCompleteTextView> clazz3 = AutoCompleteTextView.class;
        final String s3 = "ensureImeVisible";
        try {
            final Class[] array = new Class[n];
            try {
                array[0] = Boolean.TYPE;
                (this.ensureImeVisible = clazz3.getMethod(s3, (Class<?>[])array)).setAccessible(n != 0);
            }
            catch (NoSuchMethodException ex3) {}
        }
        catch (NoSuchMethodException ex4) {}
        final Class<InputMethodManager> clazz4 = InputMethodManager.class;
        final String s4 = "showSoftInputUnchecked";
        final int n2 = 2;
        try {
            final Class[] array2 = new Class[n2];
            try {
                array2[0] = Integer.TYPE;
                array2[n] = ResultReceiver.class;
                (this.showSoftInputUnchecked = clazz4.getMethod(s4, (Class<?>[])array2)).setAccessible(n != 0);
            }
            catch (NoSuchMethodException ex5) {}
        }
        catch (NoSuchMethodException ex6) {}
    }
    
    void doAfterTextChanged(final AutoCompleteTextView autoCompleteTextView) {
        final Method doAfterTextChanged = this.doAfterTextChanged;
        if (doAfterTextChanged != null) {
            try {
                doAfterTextChanged.invoke(autoCompleteTextView, new Object[0]);
            }
            catch (Exception ex) {}
        }
    }
    
    void doBeforeTextChanged(final AutoCompleteTextView autoCompleteTextView) {
        final Method doBeforeTextChanged = this.doBeforeTextChanged;
        if (doBeforeTextChanged != null) {
            try {
                doBeforeTextChanged.invoke(autoCompleteTextView, new Object[0]);
            }
            catch (Exception ex) {}
        }
    }
    
    void ensureImeVisible(final AutoCompleteTextView autoCompleteTextView, final boolean b) {
        final Method ensureImeVisible = this.ensureImeVisible;
        if (ensureImeVisible != null) {
            final int n = 1;
            try {
                final Object[] array = new Object[n];
                try {
                    array[0] = b;
                    ensureImeVisible.invoke(autoCompleteTextView, array);
                }
                catch (Exception ex) {}
            }
            catch (Exception ex2) {}
        }
    }
    
    void showSoftInputUnchecked(final InputMethodManager inputMethodManager, final View view, final int n) {
        final Method showSoftInputUnchecked = this.showSoftInputUnchecked;
        if (showSoftInputUnchecked != null) {
            final int n2 = 2;
            try {
                final Object[] array = new Object[n2];
                array[0] = n;
                array[1] = null;
                showSoftInputUnchecked.invoke(inputMethodManager, array);
                return;
            }
            catch (Exception ex) {}
        }
        inputMethodManager.showSoftInput(view, n);
    }
}
