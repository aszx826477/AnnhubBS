// 
// Decompiled by Procyon v0.5.30
// 

package com.google.gson;

import java.io.ObjectInputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Locale;
import java.lang.reflect.Field;

public enum FieldNamingPolicy implements FieldNamingStrategy
{
    IDENTITY("IDENTITY", 0) {
        FieldNamingPolicy$1(final String s, final int n) {
        }
        
        public String translateName(final Field field) {
            return field.getName();
        }
    }, 
    LOWER_CASE_WITH_DASHES("LOWER_CASE_WITH_DASHES", n4) {
        FieldNamingPolicy$5(final String s, final int n) {
        }
        
        public String translateName(final Field field) {
            return FieldNamingPolicy.separateCamelCase(field.getName(), "-").toLowerCase(Locale.ENGLISH);
        }
    }, 
    LOWER_CASE_WITH_UNDERSCORES("LOWER_CASE_WITH_UNDERSCORES", n3) {
        FieldNamingPolicy$4(final String s, final int n) {
        }
        
        public String translateName(final Field field) {
            return FieldNamingPolicy.separateCamelCase(field.getName(), "_").toLowerCase(Locale.ENGLISH);
        }
    }, 
    UPPER_CAMEL_CASE("UPPER_CAMEL_CASE", n) {
        FieldNamingPolicy$2(final String s, final int n) {
        }
        
        public String translateName(final Field field) {
            return FieldNamingPolicy.upperCaseFirstLetter(field.getName());
        }
    }, 
    UPPER_CAMEL_CASE_WITH_SPACES("UPPER_CAMEL_CASE_WITH_SPACES", n2) {
        FieldNamingPolicy$3(final String s, final int n) {
        }
        
        public String translateName(final Field field) {
            return FieldNamingPolicy.upperCaseFirstLetter(FieldNamingPolicy.separateCamelCase(field.getName(), " "));
        }
    };
    
    static {
        final int n = 1;
        final int n2 = 2;
        final int n3 = 3;
        final int n4 = 4;
        final FieldNamingPolicy[] $values = new FieldNamingPolicy[5];
        $values[0] = FieldNamingPolicy.IDENTITY;
        $values[n] = FieldNamingPolicy.UPPER_CAMEL_CASE;
        $values[n2] = FieldNamingPolicy.UPPER_CAMEL_CASE_WITH_SPACES;
        $values[n3] = FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES;
        $values[n4] = FieldNamingPolicy.LOWER_CASE_WITH_DASHES;
        $VALUES = $values;
    }
    
    private FieldNamingPolicy(final String s, final int n) {
    }
    
    private static String modifyString(final char c, final String s, final int n) {
        String s2;
        if (n < s.length()) {
            final StringBuilder sb = new StringBuilder();
            sb.append(c);
            sb.append(s.substring(n));
            s2 = sb.toString();
        }
        else {
            s2 = String.valueOf(c);
        }
        return s2;
    }
    
    static String separateCamelCase(final String s, final String s2) {
        final StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); ++i) {
            final char char1 = s.charAt(i);
            if (Character.isUpperCase(char1) && sb.length() != 0) {
                sb.append(s2);
            }
            sb.append(char1);
        }
        return sb.toString();
    }
    
    static String upperCaseFirstLetter(final String s) {
        final StringBuilder sb = new StringBuilder();
        int n;
        char c;
        for (n = 0, c = s.charAt(0); n < s.length() - 1 && !Character.isLetter(c); ++n, c = s.charAt(n)) {
            sb.append(c);
        }
        if (n == s.length()) {
            return sb.toString();
        }
        if (!Character.isUpperCase(c)) {
            sb.append(modifyString(Character.toUpperCase(c), s, n + 1));
            return sb.toString();
        }
        return s;
    }
}
