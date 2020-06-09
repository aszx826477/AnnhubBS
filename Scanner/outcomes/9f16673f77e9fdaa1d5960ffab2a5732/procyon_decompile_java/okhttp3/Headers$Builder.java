// 
// Decompiled by Procyon v0.5.30
// 

package okhttp3;

import okhttp3.internal.Util;
import java.util.ArrayList;
import java.util.List;

public final class Headers$Builder
{
    private final List namesAndValues;
    
    public Headers$Builder() {
        this.namesAndValues = new ArrayList(20);
    }
    
    private void checkNameAndValue(final String s, final String s2) {
        if (s == null) {
            throw new NullPointerException("name == null");
        }
        if (s.isEmpty()) {
            throw new IllegalArgumentException("name is empty");
        }
        int n = 0;
        final int length = s.length();
        while (true) {
            final char c = '\u007f';
            final int n2 = 2;
            final int n3 = 3;
            final char c2 = '\u001f';
            final int n4 = 1;
            if (n < length) {
                final char char1 = s.charAt(n);
                if (char1 <= c2 || char1 >= c) {
                    final Object[] array = new Object[n3];
                    array[0] = char1;
                    array[n4] = n;
                    array[n2] = s;
                    throw new IllegalArgumentException(Util.format("Unexpected char %#04x at %d in header name: %s", array));
                }
                ++n;
            }
            else {
                if (s2 != null) {
                    for (int i = 0; i < s2.length(); ++i) {
                        final char char2 = s2.charAt(i);
                        if (char2 <= c2 || char2 >= c) {
                            final Object[] array2 = new Object[4];
                            array2[0] = char2;
                            array2[n4] = i;
                            array2[n2] = s;
                            array2[n3] = s2;
                            throw new IllegalArgumentException(Util.format("Unexpected char %#04x at %d in %s value: %s", array2));
                        }
                    }
                    return;
                }
                throw new NullPointerException("value == null");
            }
        }
    }
    
    public Headers$Builder add(final String s) {
        final int index = s.indexOf(":");
        if (index != -1) {
            return this.add(s.substring(0, index).trim(), s.substring(index + 1));
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("Unexpected header: ");
        sb.append(s);
        throw new IllegalArgumentException(sb.toString());
    }
    
    public Headers$Builder add(final String s, final String s2) {
        this.checkNameAndValue(s, s2);
        return this.addLenient(s, s2);
    }
    
    Headers$Builder addLenient(final String s) {
        final String s2 = ":";
        final int n = 1;
        final int index = s.indexOf(s2, n);
        if (index != -1) {
            return this.addLenient(s.substring(0, index), s.substring(index + 1));
        }
        if (s.startsWith(":")) {
            return this.addLenient("", s.substring(n));
        }
        return this.addLenient("", s);
    }
    
    Headers$Builder addLenient(final String s, final String s2) {
        this.namesAndValues.add(s);
        this.namesAndValues.add(s2.trim());
        return this;
    }
    
    public Headers build() {
        return new Headers(this, null);
    }
    
    public String get(final String s) {
        for (int i = this.namesAndValues.size() - 2; i >= 0; i -= 2) {
            if (s.equalsIgnoreCase((String)this.namesAndValues.get(i))) {
                return (String)this.namesAndValues.get(i + 1);
            }
        }
        return null;
    }
    
    public Headers$Builder removeAll(final String s) {
        for (int i = 0; i < this.namesAndValues.size(); i += 2) {
            if (s.equalsIgnoreCase((String)this.namesAndValues.get(i))) {
                this.namesAndValues.remove(i);
                this.namesAndValues.remove(i);
                i -= 2;
            }
        }
        return this;
    }
    
    public Headers$Builder set(final String s, final String s2) {
        this.checkNameAndValue(s, s2);
        this.removeAll(s);
        this.addLenient(s, s2);
        return this;
    }
}
