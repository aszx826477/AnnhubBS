// 
// Decompiled by Procyon v0.5.30
// 

package okhttp3;

import okhttp3.internal.Util;
import java.util.List;
import java.util.Locale;
import java.util.ArrayList;
import java.util.TreeMap;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.TreeSet;
import java.util.Set;
import okhttp3.internal.http.HttpDate;
import java.util.Date;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;

public final class Headers
{
    private final String[] namesAndValues;
    
    private Headers(final Headers$Builder headers$Builder) {
        this.namesAndValues = headers$Builder.namesAndValues.toArray(new String[headers$Builder.namesAndValues.size()]);
    }
    
    private Headers(final String[] namesAndValues) {
        this.namesAndValues = namesAndValues;
    }
    
    private static String get(final String[] array, final String s) {
        for (int i = array.length - 2; i >= 0; i -= 2) {
            if (s.equalsIgnoreCase(array[i])) {
                return array[i + 1];
            }
        }
        return null;
    }
    
    public static Headers of(final Map map) {
        if (map != null) {
            final String[] array = new String[map.size() * 2];
            int n = 0;
            for (final Map.Entry<Object, V> entry : map.entrySet()) {
                if (entry.getKey() != null && entry.getValue() != null) {
                    final String trim = entry.getKey().trim();
                    final String trim2 = ((String)entry.getValue()).trim();
                    if (trim.length() != 0) {
                        final int index = trim.indexOf(0);
                        final int n2 = -1;
                        if (index == n2 && trim2.indexOf(0) == n2) {
                            array[n] = trim;
                            array[n + 1] = trim2;
                            n += 2;
                            continue;
                        }
                    }
                    final StringBuilder sb = new StringBuilder();
                    sb.append("Unexpected header: ");
                    sb.append(trim);
                    sb.append(": ");
                    sb.append(trim2);
                    throw new IllegalArgumentException(sb.toString());
                }
                throw new IllegalArgumentException("Headers cannot be null");
            }
            return new Headers(array);
        }
        throw new NullPointerException("headers == null");
    }
    
    public static Headers of(String... array) {
        if (array == null) {
            throw new NullPointerException("namesAndValues == null");
        }
        if (array.length % 2 == 0) {
            array = array.clone();
            for (int i = 0; i < array.length; ++i) {
                if (array[i] == null) {
                    throw new IllegalArgumentException("Headers cannot be null");
                }
                array[i] = array[i].trim();
            }
            int j = 0;
            while (j < array.length) {
                final String s = array[j];
                final String s2 = array[j + 1];
                if (s.length() != 0) {
                    final int index = s.indexOf(0);
                    final int n = -1;
                    if (index == n && s2.indexOf(0) == n) {
                        j += 2;
                        continue;
                    }
                }
                final StringBuilder sb = new StringBuilder();
                sb.append("Unexpected header: ");
                sb.append(s);
                sb.append(": ");
                sb.append(s2);
                throw new IllegalArgumentException(sb.toString());
            }
            return new Headers(array);
        }
        throw new IllegalArgumentException("Expected alternating header names and values");
    }
    
    public boolean equals(final Object o) {
        return o instanceof Headers && Arrays.equals(((Headers)o).namesAndValues, this.namesAndValues);
    }
    
    public String get(final String s) {
        return get(this.namesAndValues, s);
    }
    
    public Date getDate(final String s) {
        final String value = this.get(s);
        Date parse;
        if (value != null) {
            parse = HttpDate.parse(value);
        }
        else {
            parse = null;
        }
        return parse;
    }
    
    public int hashCode() {
        return Arrays.hashCode(this.namesAndValues);
    }
    
    public String name(final int n) {
        return this.namesAndValues[n * 2];
    }
    
    public Set names() {
        final TreeSet<String> set = new TreeSet<String>(String.CASE_INSENSITIVE_ORDER);
        for (int i = 0; i < this.size(); ++i) {
            set.add(this.name(i));
        }
        return Collections.unmodifiableSet((Set<?>)set);
    }
    
    public Headers$Builder newBuilder() {
        final Headers$Builder headers$Builder = new Headers$Builder();
        Collections.addAll(headers$Builder.namesAndValues, this.namesAndValues);
        return headers$Builder;
    }
    
    public int size() {
        return this.namesAndValues.length / 2;
    }
    
    public Map toMultimap() {
        final TreeMap<String, ArrayList<Object>> treeMap = (TreeMap<String, ArrayList<Object>>)new TreeMap<Object, ArrayList<Object>>((Comparator<? super Object>)String.CASE_INSENSITIVE_ORDER);
        for (int i = 0; i < this.size(); ++i) {
            final String lowerCase = this.name(i).toLowerCase(Locale.US);
            Object o = treeMap.get(lowerCase);
            if (o == null) {
                treeMap.put(lowerCase, (ArrayList<Object>)(o = new ArrayList<String>(2)));
            }
            ((List<String>)o).add(this.value(i));
        }
        return treeMap;
    }
    
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.size(); ++i) {
            sb.append(this.name(i));
            sb.append(": ");
            sb.append(this.value(i));
            sb.append("\n");
        }
        return sb.toString();
    }
    
    public String value(final int n) {
        return this.namesAndValues[n * 2 + 1];
    }
    
    public List values(final String s) {
        Object o = null;
        for (int i = 0; i < this.size(); ++i) {
            if (s.equalsIgnoreCase(this.name(i))) {
                if (o == null) {
                    o = new ArrayList<String>(2);
                }
                ((List<String>)o).add(this.value(i));
            }
        }
        List<Object> list;
        if (o != null) {
            list = Collections.unmodifiableList((List<?>)o);
        }
        else {
            list = Collections.emptyList();
        }
        return list;
    }
}
