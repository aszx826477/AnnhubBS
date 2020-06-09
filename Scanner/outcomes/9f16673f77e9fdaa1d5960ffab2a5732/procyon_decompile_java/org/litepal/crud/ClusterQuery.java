// 
// Decompiled by Procyon v0.5.30
// 

package org.litepal.crud;

import java.util.List;
import org.litepal.tablemanager.Connector;
import org.litepal.util.BaseUtility;

public class ClusterQuery
{
    String[] mColumns;
    String[] mConditions;
    String mLimit;
    String mOffset;
    String mOrderBy;
    
    public double average(final Class clazz, final String s) {
        synchronized (this) {
            return this.average(BaseUtility.changeCase(clazz.getSimpleName()), s);
        }
    }
    
    public double average(final String s, final String s2) {
        synchronized (this) {
            return new QueryHandler(Connector.getDatabase()).onAverage(s, s2, this.mConditions);
        }
    }
    
    public int count(final Class clazz) {
        synchronized (this) {
            return this.count(BaseUtility.changeCase(clazz.getSimpleName()));
        }
    }
    
    public int count(final String s) {
        synchronized (this) {
            return new QueryHandler(Connector.getDatabase()).onCount(s, this.mConditions);
        }
    }
    
    public List find(final Class clazz) {
        return this.find(clazz, false);
    }
    
    public List find(final Class clazz, final boolean b) {
        synchronized (this) {
            final QueryHandler queryHandler = new QueryHandler(Connector.getDatabase());
            String s;
            if (this.mOffset == null) {
                s = this.mLimit;
            }
            else {
                if (this.mLimit == null) {
                    this.mLimit = "0";
                }
                final StringBuilder sb = new StringBuilder();
                sb.append(this.mOffset);
                sb.append(",");
                sb.append(this.mLimit);
                s = sb.toString();
            }
            return queryHandler.onFind(clazz, this.mColumns, this.mConditions, this.mOrderBy, s, b);
        }
    }
    
    public Object findFirst(final Class clazz) {
        return this.findFirst(clazz, false);
    }
    
    public Object findFirst(final Class clazz, final boolean b) {
        final List find = this.find(clazz, b);
        if (find.size() > 0) {
            return find.get(0);
        }
        return null;
    }
    
    public Object findLast(final Class clazz) {
        return this.findLast(clazz, false);
    }
    
    public Object findLast(final Class clazz, final boolean b) {
        final List find = this.find(clazz, b);
        final int size = find.size();
        if (size > 0) {
            return find.get(size - 1);
        }
        return null;
    }
    
    public ClusterQuery limit(final int n) {
        this.mLimit = String.valueOf(n);
        return this;
    }
    
    public Object max(final Class clazz, final String s, final Class clazz2) {
        synchronized (this) {
            return this.max(BaseUtility.changeCase(clazz.getSimpleName()), s, clazz2);
        }
    }
    
    public Object max(final String s, final String s2, final Class clazz) {
        synchronized (this) {
            return new QueryHandler(Connector.getDatabase()).onMax(s, s2, this.mConditions, clazz);
        }
    }
    
    public Object min(final Class clazz, final String s, final Class clazz2) {
        synchronized (this) {
            return this.min(BaseUtility.changeCase(clazz.getSimpleName()), s, clazz2);
        }
    }
    
    public Object min(final String s, final String s2, final Class clazz) {
        synchronized (this) {
            return new QueryHandler(Connector.getDatabase()).onMin(s, s2, this.mConditions, clazz);
        }
    }
    
    public ClusterQuery offset(final int n) {
        this.mOffset = String.valueOf(n);
        return this;
    }
    
    public ClusterQuery order(final String mOrderBy) {
        this.mOrderBy = mOrderBy;
        return this;
    }
    
    public ClusterQuery select(final String... mColumns) {
        this.mColumns = mColumns;
        return this;
    }
    
    public Object sum(final Class clazz, final String s, final Class clazz2) {
        synchronized (this) {
            return this.sum(BaseUtility.changeCase(clazz.getSimpleName()), s, clazz2);
        }
    }
    
    public Object sum(final String s, final String s2, final Class clazz) {
        synchronized (this) {
            return new QueryHandler(Connector.getDatabase()).onSum(s, s2, this.mConditions, clazz);
        }
    }
    
    public ClusterQuery where(final String... mConditions) {
        this.mConditions = mConditions;
        return this;
    }
}
