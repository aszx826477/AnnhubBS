// 
// Decompiled by Procyon v0.5.30
// 

package okhttp3;

import java.util.ArrayList;
import java.util.List;

public final class FormBody$Builder
{
    private final List names;
    private final List values;
    
    public FormBody$Builder() {
        this.names = new ArrayList();
        this.values = new ArrayList();
    }
    
    public FormBody$Builder add(final String s, final String s2) {
        final List names = this.names;
        final boolean b = true;
        final boolean b2 = true;
        names.add(HttpUrl.canonicalize(s, " \"':;<=>@[]^`{}|/\\?#&!$(),~", false, false, b, b2));
        this.values.add(HttpUrl.canonicalize(s2, " \"':;<=>@[]^`{}|/\\?#&!$(),~", false, false, b, b2));
        return this;
    }
    
    public FormBody$Builder addEncoded(final String s, final String s2) {
        final List names = this.names;
        final boolean b = true;
        final boolean b2 = true;
        final boolean b3 = true;
        names.add(HttpUrl.canonicalize(s, " \"':;<=>@[]^`{}|/\\?#&!$(),~", b, false, b2, b3));
        this.values.add(HttpUrl.canonicalize(s2, " \"':;<=>@[]^`{}|/\\?#&!$(),~", b, false, b2, b3));
        return this;
    }
    
    public FormBody build() {
        return new FormBody(this.names, this.values, null);
    }
}
