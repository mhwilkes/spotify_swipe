package net.wcc.spotify_swipe.feature.SQL;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class SQLHandler {

    private SQLiteDatabase db;
    private DataBaseHelper dbHelper;

    public SQLHandler(Context context) {
        dbHelper = new DataBaseHelper(context);
    }

    public SQLHandler createDatabase() throws SQLException {
        try {
            dbHelper.createDataBase();
        } catch (Exception e){
            e.printStackTrace();
        }

        return this;
    }

    public SQLHandler open() throws SQLException {
        try {
            dbHelper.openDataBase();
            dbHelper.close();
            db = dbHelper.getWritableDatabase();
        } catch (Exception e){
            e.printStackTrace();
        }
        return this;
    }

    public void close() {
        dbHelper.close();
    }

    public Cursor query(String sql) {
        try {
            Cursor cursor = db.rawQuery(sql, null);
            return cursor;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public int update(String table, ContentValues cv, String where, String[] whereArgs) {
        return db.update(table, cv, where, whereArgs);
    }

    public long insert(String table, ContentValues cv) {
        return db.insert(table,null, cv);
    }
}
