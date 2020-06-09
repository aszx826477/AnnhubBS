// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.app;

import android.text.Html;
import android.net.Uri;
import android.os.Parcelable;
import android.content.Intent;
import java.util.ArrayList;
import android.app.Activity;

public class ShareCompat$IntentBuilder
{
    private Activity mActivity;
    private ArrayList mBccAddresses;
    private ArrayList mCcAddresses;
    private CharSequence mChooserTitle;
    private Intent mIntent;
    private ArrayList mStreams;
    private ArrayList mToAddresses;
    
    private ShareCompat$IntentBuilder(final Activity mActivity) {
        this.mActivity = mActivity;
        (this.mIntent = new Intent().setAction("android.intent.action.SEND")).putExtra("android.support.v4.app.EXTRA_CALLING_PACKAGE", mActivity.getPackageName());
        this.mIntent.putExtra("android.support.v4.app.EXTRA_CALLING_ACTIVITY", (Parcelable)mActivity.getComponentName());
        this.mIntent.addFlags(524288);
    }
    
    private void combineArrayExtra(final String s, final ArrayList list) {
        final String[] stringArrayExtra = this.mIntent.getStringArrayExtra(s);
        int length;
        if (stringArrayExtra != null) {
            length = stringArrayExtra.length;
        }
        else {
            length = 0;
        }
        final String[] array = new String[list.size() + length];
        list.toArray(array);
        if (stringArrayExtra != null) {
            System.arraycopy(stringArrayExtra, 0, array, list.size(), length);
        }
        this.mIntent.putExtra(s, array);
    }
    
    private void combineArrayExtra(final String s, final String[] array) {
        final Intent intent = this.getIntent();
        final String[] stringArrayExtra = intent.getStringArrayExtra(s);
        int length;
        if (stringArrayExtra != null) {
            length = stringArrayExtra.length;
        }
        else {
            length = 0;
        }
        final String[] array2 = new String[array.length + length];
        if (stringArrayExtra != null) {
            System.arraycopy(stringArrayExtra, 0, array2, 0, length);
        }
        System.arraycopy(array, 0, array2, length, array.length);
        intent.putExtra(s, array2);
    }
    
    public static ShareCompat$IntentBuilder from(final Activity activity) {
        return new ShareCompat$IntentBuilder(activity);
    }
    
    public ShareCompat$IntentBuilder addEmailBcc(final String s) {
        if (this.mBccAddresses == null) {
            this.mBccAddresses = new ArrayList();
        }
        this.mBccAddresses.add(s);
        return this;
    }
    
    public ShareCompat$IntentBuilder addEmailBcc(final String[] array) {
        this.combineArrayExtra("android.intent.extra.BCC", array);
        return this;
    }
    
    public ShareCompat$IntentBuilder addEmailCc(final String s) {
        if (this.mCcAddresses == null) {
            this.mCcAddresses = new ArrayList();
        }
        this.mCcAddresses.add(s);
        return this;
    }
    
    public ShareCompat$IntentBuilder addEmailCc(final String[] array) {
        this.combineArrayExtra("android.intent.extra.CC", array);
        return this;
    }
    
    public ShareCompat$IntentBuilder addEmailTo(final String s) {
        if (this.mToAddresses == null) {
            this.mToAddresses = new ArrayList();
        }
        this.mToAddresses.add(s);
        return this;
    }
    
    public ShareCompat$IntentBuilder addEmailTo(final String[] array) {
        this.combineArrayExtra("android.intent.extra.EMAIL", array);
        return this;
    }
    
    public ShareCompat$IntentBuilder addStream(final Uri stream) {
        final Uri uri = (Uri)this.mIntent.getParcelableExtra("android.intent.extra.STREAM");
        if (this.mStreams == null && uri == null) {
            return this.setStream(stream);
        }
        if (this.mStreams == null) {
            this.mStreams = new ArrayList();
        }
        if (uri != null) {
            this.mIntent.removeExtra("android.intent.extra.STREAM");
            this.mStreams.add(uri);
        }
        this.mStreams.add(stream);
        return this;
    }
    
    public Intent createChooserIntent() {
        return Intent.createChooser(this.getIntent(), this.mChooserTitle);
    }
    
    Activity getActivity() {
        return this.mActivity;
    }
    
    public Intent getIntent() {
        final ArrayList mToAddresses = this.mToAddresses;
        if (mToAddresses != null) {
            this.combineArrayExtra("android.intent.extra.EMAIL", mToAddresses);
            this.mToAddresses = null;
        }
        final ArrayList mCcAddresses = this.mCcAddresses;
        if (mCcAddresses != null) {
            this.combineArrayExtra("android.intent.extra.CC", mCcAddresses);
            this.mCcAddresses = null;
        }
        final ArrayList mBccAddresses = this.mBccAddresses;
        if (mBccAddresses != null) {
            this.combineArrayExtra("android.intent.extra.BCC", mBccAddresses);
            this.mBccAddresses = null;
        }
        final ArrayList mStreams = this.mStreams;
        int n = 1;
        if (mStreams == null || mStreams.size() <= n) {
            n = 0;
        }
        final int n2 = n;
        final boolean equals = this.mIntent.getAction().equals("android.intent.action.SEND_MULTIPLE");
        if (n2 == 0 && equals) {
            this.mIntent.setAction("android.intent.action.SEND");
            final ArrayList mStreams2 = this.mStreams;
            if (mStreams2 != null && !mStreams2.isEmpty()) {
                this.mIntent.putExtra("android.intent.extra.STREAM", (Parcelable)this.mStreams.get(0));
            }
            else {
                this.mIntent.removeExtra("android.intent.extra.STREAM");
            }
            this.mStreams = null;
        }
        if (n2 != 0 && !equals) {
            this.mIntent.setAction("android.intent.action.SEND_MULTIPLE");
            final ArrayList mStreams3 = this.mStreams;
            if (mStreams3 != null && !mStreams3.isEmpty()) {
                this.mIntent.putParcelableArrayListExtra("android.intent.extra.STREAM", this.mStreams);
            }
            else {
                this.mIntent.removeExtra("android.intent.extra.STREAM");
            }
        }
        return this.mIntent;
    }
    
    public ShareCompat$IntentBuilder setChooserTitle(final int n) {
        return this.setChooserTitle(this.mActivity.getText(n));
    }
    
    public ShareCompat$IntentBuilder setChooserTitle(final CharSequence mChooserTitle) {
        this.mChooserTitle = mChooserTitle;
        return this;
    }
    
    public ShareCompat$IntentBuilder setEmailBcc(final String[] array) {
        this.mIntent.putExtra("android.intent.extra.BCC", array);
        return this;
    }
    
    public ShareCompat$IntentBuilder setEmailCc(final String[] array) {
        this.mIntent.putExtra("android.intent.extra.CC", array);
        return this;
    }
    
    public ShareCompat$IntentBuilder setEmailTo(final String[] array) {
        if (this.mToAddresses != null) {
            this.mToAddresses = null;
        }
        this.mIntent.putExtra("android.intent.extra.EMAIL", array);
        return this;
    }
    
    public ShareCompat$IntentBuilder setHtmlText(final String s) {
        this.mIntent.putExtra("android.intent.extra.HTML_TEXT", s);
        if (!this.mIntent.hasExtra("android.intent.extra.TEXT")) {
            this.setText((CharSequence)Html.fromHtml(s));
        }
        return this;
    }
    
    public ShareCompat$IntentBuilder setStream(final Uri uri) {
        if (!this.mIntent.getAction().equals("android.intent.action.SEND")) {
            this.mIntent.setAction("android.intent.action.SEND");
        }
        this.mStreams = null;
        this.mIntent.putExtra("android.intent.extra.STREAM", (Parcelable)uri);
        return this;
    }
    
    public ShareCompat$IntentBuilder setSubject(final String s) {
        this.mIntent.putExtra("android.intent.extra.SUBJECT", s);
        return this;
    }
    
    public ShareCompat$IntentBuilder setText(final CharSequence charSequence) {
        this.mIntent.putExtra("android.intent.extra.TEXT", charSequence);
        return this;
    }
    
    public ShareCompat$IntentBuilder setType(final String type) {
        this.mIntent.setType(type);
        return this;
    }
    
    public void startChooser() {
        this.mActivity.startActivity(this.createChooserIntent());
    }
}
