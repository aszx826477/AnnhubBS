// 
// Decompiled by Procyon v0.5.30
// 

package org.litepal.crud;

import org.litepal.exceptions.DataSupportException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import android.content.ContentValues;
import java.util.Collection;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import org.litepal.tablemanager.Connector;
import java.util.Iterator;
import java.util.Set;
import org.litepal.util.BaseUtility;
import org.litepal.util.DBUtility;
import java.util.List;
import java.util.Map;

public class DataSupport
{
    private Map associatedModelsMapForJoinTable;
    private Map associatedModelsMapWithFK;
    private Map associatedModelsMapWithoutFK;
    private long baseObjId;
    private List fieldsToSetToDefault;
    private List listToClearAssociatedFK;
    private List listToClearSelfFK;
    
    public static double average(final Class clazz, final String s) {
        synchronized (DataSupport.class) {
            return average(BaseUtility.changeCase(DBUtility.getTableNameByClassName(clazz.getName())), s);
        }
    }
    
    public static double average(final String s, final String s2) {
        synchronized (DataSupport.class) {
            return new ClusterQuery().average(s, s2);
        }
    }
    
    private void clearFKNameList() {
        this.getListToClearSelfFK().clear();
        this.getListToClearAssociatedFK().clear();
    }
    
    private void clearIdOfModelForJoinTable() {
        final Iterator<String> iterator = this.getAssociatedModelsMapForJoinTable().keySet().iterator();
        while (iterator.hasNext()) {
            ((Set)this.associatedModelsMapForJoinTable.get(iterator.next())).clear();
        }
        this.associatedModelsMapForJoinTable.clear();
    }
    
    private void clearIdOfModelWithFK() {
        final Iterator<String> iterator = this.getAssociatedModelsMapWithFK().keySet().iterator();
        while (iterator.hasNext()) {
            ((Set)this.associatedModelsMapWithFK.get(iterator.next())).clear();
        }
        this.associatedModelsMapWithFK.clear();
    }
    
    private void clearIdOfModelWithoutFK() {
        this.getAssociatedModelsMapWithoutFK().clear();
    }
    
    public static int count(final Class clazz) {
        synchronized (DataSupport.class) {
            return count(BaseUtility.changeCase(DBUtility.getTableNameByClassName(clazz.getName())));
        }
    }
    
    public static int count(final String s) {
        synchronized (DataSupport.class) {
            return new ClusterQuery().count(s);
        }
    }
    
    public static int delete(final Class clazz, final long n) {
        synchronized (DataSupport.class) {
            final SQLiteDatabase database = Connector.getDatabase();
            database.beginTransaction();
            try {
                final int onDelete = new DeleteHandler(database).onDelete(clazz, n);
                database.setTransactionSuccessful();
                return onDelete;
            }
            finally {
                database.endTransaction();
            }
        }
    }
    
    public static int deleteAll(final Class clazz, final String... array) {
        synchronized (DataSupport.class) {
            return new DeleteHandler(Connector.getDatabase()).onDeleteAll(clazz, array);
        }
    }
    
    public static int deleteAll(final String s, final String... array) {
        synchronized (DataSupport.class) {
            return new DeleteHandler(Connector.getDatabase()).onDeleteAll(s, array);
        }
    }
    
    public static Object find(final Class clazz, final long n) {
        final Class<DataSupport> clazz2 = DataSupport.class;
        synchronized (clazz2) {
            return find(clazz, n, false);
        }
    }
    
    public static Object find(final Class clazz, final long n, final boolean b) {
        synchronized (DataSupport.class) {
            return new QueryHandler(Connector.getDatabase()).onFind(clazz, n, b);
        }
    }
    
    public static List findAll(final Class clazz, final boolean b, final long... array) {
        synchronized (DataSupport.class) {
            return new QueryHandler(Connector.getDatabase()).onFindAll(clazz, b, array);
        }
    }
    
    public static List findAll(final Class clazz, final long... array) {
        final Class<DataSupport> clazz2 = DataSupport.class;
        // monitorenter(clazz2)
        final boolean b = false;
        try {
            return findAll(clazz, b, array);
        }
        finally {
        }
        // monitorexit(clazz2)
    }
    
    public static Cursor findBySQL(final String... array) {
        synchronized (DataSupport.class) {
            BaseUtility.checkConditionsCorrect(array);
            if (array == null) {
                return null;
            }
            if (array.length <= 0) {
                return null;
            }
            final int length = array.length;
            final int n = 1;
            String[] array2;
            if (length == n) {
                array2 = null;
            }
            else {
                array2 = new String[array.length - n];
                System.arraycopy(array, n, array2, 0, array.length - n);
            }
            return Connector.getDatabase().rawQuery(array[0], array2);
        }
    }
    
    public static Object findFirst(final Class clazz) {
        final Class<DataSupport> clazz2 = DataSupport.class;
        synchronized (clazz2) {
            return findFirst(clazz, false);
        }
    }
    
    public static Object findFirst(final Class clazz, final boolean b) {
        synchronized (DataSupport.class) {
            return new QueryHandler(Connector.getDatabase()).onFindFirst(clazz, b);
        }
    }
    
    public static Object findLast(final Class clazz) {
        final Class<DataSupport> clazz2 = DataSupport.class;
        synchronized (clazz2) {
            return findLast(clazz, false);
        }
    }
    
    public static Object findLast(final Class clazz, final boolean b) {
        synchronized (DataSupport.class) {
            return new QueryHandler(Connector.getDatabase()).onFindLast(clazz, b);
        }
    }
    
    public static boolean isExist(final Class clazz, final String... array) {
        boolean b = false;
        if (array == null) {
            return false;
        }
        if (where(array).count(clazz) > 0) {
            b = true;
        }
        return b;
    }
    
    public static ClusterQuery limit(final int n) {
        synchronized (DataSupport.class) {
            final ClusterQuery clusterQuery = new ClusterQuery();
            clusterQuery.mLimit = String.valueOf(n);
            return clusterQuery;
        }
    }
    
    public static void markAsDeleted(final Collection collection) {
        final Iterator<DataSupport> iterator = collection.iterator();
        while (iterator.hasNext()) {
            iterator.next().clearSavedState();
        }
    }
    
    public static Object max(final Class clazz, final String s, final Class clazz2) {
        synchronized (DataSupport.class) {
            return max(BaseUtility.changeCase(DBUtility.getTableNameByClassName(clazz.getName())), s, clazz2);
        }
    }
    
    public static Object max(final String s, final String s2, final Class clazz) {
        synchronized (DataSupport.class) {
            return new ClusterQuery().max(s, s2, clazz);
        }
    }
    
    public static Object min(final Class clazz, final String s, final Class clazz2) {
        synchronized (DataSupport.class) {
            return min(BaseUtility.changeCase(DBUtility.getTableNameByClassName(clazz.getName())), s, clazz2);
        }
    }
    
    public static Object min(final String s, final String s2, final Class clazz) {
        synchronized (DataSupport.class) {
            return new ClusterQuery().min(s, s2, clazz);
        }
    }
    
    public static ClusterQuery offset(final int n) {
        synchronized (DataSupport.class) {
            final ClusterQuery clusterQuery = new ClusterQuery();
            clusterQuery.mOffset = String.valueOf(n);
            return clusterQuery;
        }
    }
    
    public static ClusterQuery order(final String mOrderBy) {
        synchronized (DataSupport.class) {
            final ClusterQuery clusterQuery = new ClusterQuery();
            clusterQuery.mOrderBy = mOrderBy;
            return clusterQuery;
        }
    }
    
    public static void saveAll(final Collection collection) {
        synchronized (DataSupport.class) {
            final SQLiteDatabase database = Connector.getDatabase();
            database.beginTransaction();
            SaveHandler saveHandler = null;
            try {
                saveHandler = new SaveHandler(database);
                final Collection collection2 = collection;
                saveHandler.onSaveAll(collection2);
                final SQLiteDatabase sqLiteDatabase = database;
                sqLiteDatabase.setTransactionSuccessful();
                final SQLiteDatabase sqLiteDatabase2 = database;
                sqLiteDatabase2.endTransaction();
                return;
            }
            catch (Exception ex) {}
            finally {
                database.endTransaction();
            }
            try {
                final Collection collection2 = collection;
                saveHandler.onSaveAll(collection2);
                final SQLiteDatabase sqLiteDatabase = database;
                sqLiteDatabase.setTransactionSuccessful();
                final SQLiteDatabase sqLiteDatabase2 = database;
                sqLiteDatabase2.endTransaction();
            }
            catch (Exception ex2) {}
        }
    }
    
    public static ClusterQuery select(final String... mColumns) {
        synchronized (DataSupport.class) {
            final ClusterQuery clusterQuery = new ClusterQuery();
            clusterQuery.mColumns = mColumns;
            return clusterQuery;
        }
    }
    
    public static Object sum(final Class clazz, final String s, final Class clazz2) {
        synchronized (DataSupport.class) {
            return sum(BaseUtility.changeCase(DBUtility.getTableNameByClassName(clazz.getName())), s, clazz2);
        }
    }
    
    public static Object sum(final String s, final String s2, final Class clazz) {
        synchronized (DataSupport.class) {
            return new ClusterQuery().sum(s, s2, clazz);
        }
    }
    
    public static int update(final Class clazz, final ContentValues contentValues, final long n) {
        synchronized (DataSupport.class) {
            return new UpdateHandler(Connector.getDatabase()).onUpdate(clazz, n, contentValues);
        }
    }
    
    public static int updateAll(final Class clazz, final ContentValues contentValues, final String... array) {
        synchronized (DataSupport.class) {
            return updateAll(BaseUtility.changeCase(DBUtility.getTableNameByClassName(clazz.getName())), contentValues, array);
        }
    }
    
    public static int updateAll(final String s, final ContentValues contentValues, final String... array) {
        synchronized (DataSupport.class) {
            return new UpdateHandler(Connector.getDatabase()).onUpdateAll(s, contentValues, array);
        }
    }
    
    public static ClusterQuery where(final String... mConditions) {
        synchronized (DataSupport.class) {
            final ClusterQuery clusterQuery = new ClusterQuery();
            clusterQuery.mConditions = mConditions;
            return clusterQuery;
        }
    }
    
    void addAssociatedModelForJoinTable(final String s, final long n) {
        final Set<Long> set = this.getAssociatedModelsMapForJoinTable().get(s);
        if (set == null) {
            final HashSet<Long> set2 = new HashSet<Long>();
            set2.add(n);
            this.associatedModelsMapForJoinTable.put(s, set2);
        }
        else {
            set.add(n);
        }
    }
    
    void addAssociatedModelWithFK(final String s, final long n) {
        final Set<Long> set = this.getAssociatedModelsMapWithFK().get(s);
        if (set == null) {
            final HashSet<Long> set2 = new HashSet<Long>();
            set2.add(n);
            this.associatedModelsMapWithFK.put(s, set2);
        }
        else {
            set.add(n);
        }
    }
    
    void addAssociatedModelWithoutFK(final String s, final long n) {
        this.getAssociatedModelsMapWithoutFK().put(s, n);
    }
    
    void addAssociatedTableNameToClearFK(final String s) {
        final List listToClearAssociatedFK = this.getListToClearAssociatedFK();
        if (!listToClearAssociatedFK.contains(s)) {
            listToClearAssociatedFK.add(s);
        }
    }
    
    void addEmptyModelForJoinTable(final String s) {
        if (this.getAssociatedModelsMapForJoinTable().get(s) == null) {
            this.associatedModelsMapForJoinTable.put(s, new HashSet());
        }
    }
    
    void addFKNameToClearSelf(final String s) {
        final List listToClearSelfFK = this.getListToClearSelfFK();
        if (!listToClearSelfFK.contains(s)) {
            listToClearSelfFK.add(s);
        }
    }
    
    public void assignBaseObjId(final int n) {
        this.baseObjId = n;
    }
    
    void clearAssociatedData() {
        this.clearIdOfModelWithFK();
        this.clearIdOfModelWithoutFK();
        this.clearIdOfModelForJoinTable();
        this.clearFKNameList();
    }
    
    public void clearSavedState() {
        this.baseObjId = 0L;
    }
    
    public int delete() {
        synchronized (this) {
            final SQLiteDatabase database = Connector.getDatabase();
            database.beginTransaction();
            try {
                final int onDelete = new DeleteHandler(database).onDelete(this);
                this.baseObjId = 0L;
                database.setTransactionSuccessful();
                return onDelete;
            }
            finally {
                database.endTransaction();
            }
        }
    }
    
    Map getAssociatedModelsMapForJoinTable() {
        if (this.associatedModelsMapForJoinTable == null) {
            this.associatedModelsMapForJoinTable = new HashMap();
        }
        return this.associatedModelsMapForJoinTable;
    }
    
    Map getAssociatedModelsMapWithFK() {
        if (this.associatedModelsMapWithFK == null) {
            this.associatedModelsMapWithFK = new HashMap();
        }
        return this.associatedModelsMapWithFK;
    }
    
    Map getAssociatedModelsMapWithoutFK() {
        if (this.associatedModelsMapWithoutFK == null) {
            this.associatedModelsMapWithoutFK = new HashMap();
        }
        return this.associatedModelsMapWithoutFK;
    }
    
    protected long getBaseObjId() {
        return this.baseObjId;
    }
    
    protected String getClassName() {
        return this.getClass().getName();
    }
    
    List getFieldsToSetToDefault() {
        if (this.fieldsToSetToDefault == null) {
            this.fieldsToSetToDefault = new ArrayList();
        }
        return this.fieldsToSetToDefault;
    }
    
    List getListToClearAssociatedFK() {
        if (this.listToClearAssociatedFK == null) {
            this.listToClearAssociatedFK = new ArrayList();
        }
        return this.listToClearAssociatedFK;
    }
    
    List getListToClearSelfFK() {
        if (this.listToClearSelfFK == null) {
            this.listToClearSelfFK = new ArrayList();
        }
        return this.listToClearSelfFK;
    }
    
    protected String getTableName() {
        return BaseUtility.changeCase(DBUtility.getTableNameByClassName(this.getClassName()));
    }
    
    public boolean isSaved() {
        return this.baseObjId > 0L;
    }
    
    public boolean save() {
        // monitorenter(this)
        try {
            try {
                this.saveThrows();
                // monitorexit(this)
                return true;
            }
            finally {}
        }
        catch (Exception ex) {
            ex.printStackTrace();
            // monitorexit(this)
            return false;
        }
    }
    // monitorexit(this)
    
    public boolean saveFast() {
        synchronized (this) {
            final SQLiteDatabase database = Connector.getDatabase();
            database.beginTransaction();
            SaveHandler saveHandler = null;
            try {
                saveHandler = new SaveHandler(database);
                saveHandler.onSaveFast(this);
                final SQLiteDatabase sqLiteDatabase = database;
                sqLiteDatabase.setTransactionSuccessful();
                final int n = true ? 1 : 0;
                final SQLiteDatabase sqLiteDatabase2 = database;
                sqLiteDatabase2.endTransaction();
                final int n2 = n;
                return n2 != 0;
            }
            catch (Exception ex) {}
            finally {
                database.endTransaction();
            }
            try {
                saveHandler.onSaveFast(this);
                final SQLiteDatabase sqLiteDatabase = database;
                sqLiteDatabase.setTransactionSuccessful();
                final int n = true ? 1 : 0;
                final SQLiteDatabase sqLiteDatabase2 = database;
                sqLiteDatabase2.endTransaction();
                final int n2 = n;
                return n2 != 0;
            }
            catch (Exception ex2) {}
        }
    }
    
    public boolean saveIfNotExist(final String... array) {
        synchronized (this) {
            return !isExist(this.getClass(), array) && this.save();
        }
    }
    
    public void saveThrows() {
        synchronized (this) {
            final SQLiteDatabase database = Connector.getDatabase();
            database.beginTransaction();
            SaveHandler saveHandler = null;
            try {
                saveHandler = new SaveHandler(database);
                saveHandler.onSave(this);
                this.clearAssociatedData();
                final SQLiteDatabase sqLiteDatabase = database;
                sqLiteDatabase.setTransactionSuccessful();
                final SQLiteDatabase sqLiteDatabase2 = database;
                sqLiteDatabase2.endTransaction();
                return;
            }
            catch (Exception ex) {}
            finally {
                database.endTransaction();
            }
            try {
                saveHandler.onSave(this);
                this.clearAssociatedData();
                final SQLiteDatabase sqLiteDatabase = database;
                sqLiteDatabase.setTransactionSuccessful();
                final SQLiteDatabase sqLiteDatabase2 = database;
                sqLiteDatabase2.endTransaction();
            }
            catch (Exception ex2) {}
        }
    }
    
    public void setToDefault(final String s) {
        this.getFieldsToSetToDefault().add(s);
    }
    
    public int update(final long n) {
        // monitorenter(this)
        int onUpdate = 0;
        List list = null;
        try {
            try {
                onUpdate = new UpdateHandler(Connector.getDatabase()).onUpdate(this, n);
                try {
                    final List fieldsToSetToDefault;
                    list = (fieldsToSetToDefault = this.getFieldsToSetToDefault());
                    fieldsToSetToDefault.clear();
                    final DataSupport dataSupport = this;
                    // monitorexit(dataSupport)
                    return onUpdate;
                }
                catch (Exception ex3) {
                    final Exception ex2;
                    final Exception ex = ex2;
                    throw new DataSupportException(ex.getMessage(), ex);
                }
            }
            catch (Exception ex4) {}
        }
        catch (Exception ex5) {}
        try {
            final List fieldsToSetToDefault = list;
            fieldsToSetToDefault.clear();
            final DataSupport dataSupport = this;
            // monitorexit(dataSupport)
            return onUpdate;
        }
        catch (Exception ex2) {}
    }
    // monitorexit(this)
    
    public int updateAll(final String... array) {
        // monitorenter(this)
        int onUpdateAll = 0;
        List list = null;
        try {
            try {
                onUpdateAll = new UpdateHandler(Connector.getDatabase()).onUpdateAll(this, array);
                try {
                    final List fieldsToSetToDefault;
                    list = (fieldsToSetToDefault = this.getFieldsToSetToDefault());
                    fieldsToSetToDefault.clear();
                    final DataSupport dataSupport = this;
                    // monitorexit(dataSupport)
                    return onUpdateAll;
                }
                catch (Exception ex3) {
                    final Exception ex2;
                    final Exception ex = ex2;
                    throw new DataSupportException(ex.getMessage(), ex);
                }
            }
            catch (Exception ex4) {}
        }
        catch (Exception ex5) {}
        try {
            final List fieldsToSetToDefault = list;
            fieldsToSetToDefault.clear();
            final DataSupport dataSupport = this;
            // monitorexit(dataSupport)
            return onUpdateAll;
        }
        catch (Exception ex2) {}
    }
    // monitorexit(this)
}
