package net.wcc.spotify_swipe.feature.SQL;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class SQLHandler {

    // Define the db, and the dbhelper
    private SQLiteDatabase db;
    private DataBaseHelper dbHelper;

    // Initialize SQLHandler.
    public SQLHandler(Context context) {
        dbHelper = new DataBaseHelper(context);
    }

    // Create the database, if it isn't already existing on user's phone.
    public SQLHandler createDatabase() throws SQLException {
        try {
            dbHelper.createDataBase();
        } catch (Exception e){
            e.printStackTrace();
        }

        return this;
    }

    // Open the database for writing.
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

    // Close the database.
    public void close() {
        dbHelper.close();
    }

    // Return a result set based on the input query.
    public Cursor query(String sql) {
        try {
            Cursor cursor = db.rawQuery(sql, null);
            return cursor;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // Perform an update to a row in the database
    public int update(String table, ContentValues cv, String where, String[] whereArgs) {
        return db.update(table, cv, where, whereArgs);
    }

    // Insert a row into the database.
    public long insert(String table, ContentValues cv) {
        return db.insert(table,null, cv);
    }
}
