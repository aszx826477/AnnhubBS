// 
// Decompiled by Procyon v0.5.30
// 

package org.litepal.crud;

import org.litepal.util.BaseUtility;
import java.util.List;
import android.database.sqlite.SQLiteDatabase;

class QueryHandler extends DataHandler
{
    QueryHandler(final SQLiteDatabase mDatabase) {
        this.mDatabase = mDatabase;
    }
    
    double onAverage(final String s, final String s2, final String[] array) {
        final String[] array2 = { null };
        final StringBuilder sb = new StringBuilder();
        sb.append("avg(");
        sb.append(s2);
        sb.append(")");
        array2[0] = sb.toString();
        return (double)this.mathQuery(s, array2, array, Double.TYPE);
    }
    
    int onCount(final String s, final String[] array) {
        return (int)this.mathQuery(s, new String[] { "count(1)" }, array, Integer.TYPE);
    }
    
    Object onFind(final Class clazz, final long n, final boolean b) {
        final List query = this.query(clazz, null, "id = ?", new String[] { String.valueOf(n) }, null, null, null, null, this.getForeignKeyAssociations(clazz.getName(), b));
        if (query.size() > 0) {
            return query.get(0);
        }
        return null;
    }
    
    List onFind(final Class clazz, final String[] array, final String[] array2, final String s, final String s2, final boolean b) {
        BaseUtility.checkConditionsCorrect(array2);
        return this.query(clazz, array, this.getWhereClause(array2), this.getWhereArgs(array2), null, null, s, s2, this.getForeignKeyAssociations(clazz.getName(), b));
    }
    
    List onFindAll(final Class clazz, final boolean b, final long... array) {
        List list;
        if (this.isAffectAllLines(array)) {
            list = this.query(clazz, null, null, null, null, null, "id", null, this.getForeignKeyAssociations(clazz.getName(), b));
        }
        else {
            list = this.query(clazz, null, this.getWhereOfIdsWithOr(array), null, null, null, "id", null, this.getForeignKeyAssociations(clazz.getName(), b));
        }
        return list;
    }
    
    Object onFindFirst(final Class clazz, final boolean b) {
        final List query = this.query(clazz, null, null, null, null, null, "id", "1", this.getForeignKeyAssociations(clazz.getName(), b));
        if (query.size() > 0) {
            return query.get(0);
        }
        return null;
    }
    
    Object onFindLast(final Class clazz, final boolean b) {
        final List query = this.query(clazz, null, null, null, null, null, "id desc", "1", this.getForeignKeyAssociations(clazz.getName(), b));
        if (query.size() > 0) {
            return query.get(0);
        }
        return null;
    }
    
    Object onMax(final String s, final String s2, final String[] array, final Class clazz) {
        final String[] array2 = { null };
        final StringBuilder sb = new StringBuilder();
        sb.append("max(");
        sb.append(s2);
        sb.append(")");
        array2[0] = sb.toString();
        return this.mathQuery(s, array2, array, clazz);
    }
    
    Object onMin(final String s, final String s2, final String[] array, final Class clazz) {
        final String[] array2 = { null };
        final StringBuilder sb = new StringBuilder();
        sb.append("min(");
        sb.append(s2);
        sb.append(")");
        array2[0] = sb.toString();
        return this.mathQuery(s, array2, array, clazz);
    }
    
    Object onSum(final String s, final String s2, final String[] array, final Class clazz) {
        final String[] array2 = { null };
        final StringBuilder sb = new StringBuilder();
        sb.append("sum(");
        sb.append(s2);
        sb.append(")");
        array2[0] = sb.toString();
        return this.mathQuery(s, array2, array, clazz);
    }
}
