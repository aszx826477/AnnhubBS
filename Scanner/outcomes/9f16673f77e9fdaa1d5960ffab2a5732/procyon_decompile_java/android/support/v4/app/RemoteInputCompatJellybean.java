// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.app;

import android.content.ClipDescription;
import android.content.ClipData;
import android.os.Bundle;
import android.content.Intent;

class RemoteInputCompatJellybean
{
    public static final String EXTRA_RESULTS_DATA = "android.remoteinput.resultsData";
    private static final String KEY_ALLOW_FREE_FORM_INPUT = "allowFreeFormInput";
    private static final String KEY_CHOICES = "choices";
    private static final String KEY_EXTRAS = "extras";
    private static final String KEY_LABEL = "label";
    private static final String KEY_RESULT_KEY = "resultKey";
    public static final String RESULTS_CLIP_LABEL = "android.remoteinput.results";
    
    static void addResultsToIntent(final RemoteInputCompatBase$RemoteInput[] array, final Intent intent, final Bundle bundle) {
        final Bundle bundle2 = new Bundle();
        for (int length = array.length, i = 0; i < length; ++i) {
            final RemoteInputCompatBase$RemoteInput remoteInputCompatBase$RemoteInput = array[i];
            final Object value = bundle.get(remoteInputCompatBase$RemoteInput.getResultKey());
            if (value instanceof CharSequence) {
                bundle2.putCharSequence(remoteInputCompatBase$RemoteInput.getResultKey(), (CharSequence)value);
            }
        }
        final Intent intent2 = new Intent();
        intent2.putExtra("android.remoteinput.resultsData", bundle2);
        intent.setClipData(ClipData.newIntent((CharSequence)"android.remoteinput.results", intent2));
    }
    
    static RemoteInputCompatBase$RemoteInput fromBundle(final Bundle bundle, final RemoteInputCompatBase$RemoteInput$Factory remoteInputCompatBase$RemoteInput$Factory) {
        return remoteInputCompatBase$RemoteInput$Factory.build(bundle.getString("resultKey"), bundle.getCharSequence("label"), bundle.getCharSequenceArray("choices"), bundle.getBoolean("allowFreeFormInput"), bundle.getBundle("extras"));
    }
    
    static RemoteInputCompatBase$RemoteInput[] fromBundleArray(final Bundle[] array, final RemoteInputCompatBase$RemoteInput$Factory remoteInputCompatBase$RemoteInput$Factory) {
        if (array == null) {
            return null;
        }
        final RemoteInputCompatBase$RemoteInput[] array2 = remoteInputCompatBase$RemoteInput$Factory.newArray(array.length);
        for (int i = 0; i < array.length; ++i) {
            array2[i] = fromBundle(array[i], remoteInputCompatBase$RemoteInput$Factory);
        }
        return array2;
    }
    
    static Bundle getResultsFromIntent(final Intent intent) {
        final ClipData clipData = intent.getClipData();
        if (clipData == null) {
            return null;
        }
        final ClipDescription description = clipData.getDescription();
        if (!description.hasMimeType("text/vnd.android.intent")) {
            return null;
        }
        if (description.getLabel().equals("android.remoteinput.results")) {
            return (Bundle)clipData.getItemAt(0).getIntent().getExtras().getParcelable("android.remoteinput.resultsData");
        }
        return null;
    }
    
    static Bundle toBundle(final RemoteInputCompatBase$RemoteInput remoteInputCompatBase$RemoteInput) {
        final Bundle bundle = new Bundle();
        bundle.putString("resultKey", remoteInputCompatBase$RemoteInput.getResultKey());
        bundle.putCharSequence("label", remoteInputCompatBase$RemoteInput.getLabel());
        bundle.putCharSequenceArray("choices", remoteInputCompatBase$RemoteInput.getChoices());
        bundle.putBoolean("allowFreeFormInput", remoteInputCompatBase$RemoteInput.getAllowFreeFormInput());
        bundle.putBundle("extras", remoteInputCompatBase$RemoteInput.getExtras());
        return bundle;
    }
    
    static Bundle[] toBundleArray(final RemoteInputCompatBase$RemoteInput[] array) {
        if (array == null) {
            return null;
        }
        final Bundle[] array2 = new Bundle[array.length];
        for (int i = 0; i < array.length; ++i) {
            array2[i] = toBundle(array[i]);
        }
        return array2;
    }
}
