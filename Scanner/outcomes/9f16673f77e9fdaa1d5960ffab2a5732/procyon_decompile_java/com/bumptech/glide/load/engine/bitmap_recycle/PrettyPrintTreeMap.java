// 
// Decompiled by Procyon v0.5.30
// 

package com.bumptech.glide.load.engine.bitmap_recycle;

import java.io.ObjectInputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

class PrettyPrintTreeMap extends TreeMap
{
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("( ");
        for (final Map.Entry<Object, Object> entry : this.entrySet()) {
            sb.append('{');
            sb.append(entry.getKey());
            sb.append(':');
            sb.append(entry.getValue());
            sb.append("}, ");
        }
        if (!this.isEmpty()) {
            sb.replace(sb.length() - 2, sb.length(), "");
        }
        sb.append(" )");
        return sb.toString();
    }
}
