package net.wcc.spotify_swipe.feature.SQL;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataBaseHelper extends SQLiteOpenHelper {

    private SQLiteDatabase db;
    private final Context context;
    private static String DB_PATH = "";
    private static String DB_NAME = "android.db";

    public DataBaseHelper(Context context) {
        super(context, DB_NAME, null, 1);
        DB_PATH = context.getApplicationInfo().dataDir + "/databases/";
        this.context = context;
    }

    public void createDataBase() {

        File dbFile = new File(DB_PATH + DB_NAME);
        boolean dataBaseExist = dbFile.exists();
        if(!dataBaseExist) {
            this.getReadableDatabase();
            this.close();
            try {
                copyDataBase();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void copyDataBase() throws IOException {
        InputStream input = context.getAssets().open(DB_NAME);
        String outFileName = DB_PATH + DB_NAME;
        OutputStream output = new FileOutputStream(outFileName);
        byte[] buffer = new byte[1024];
        int len;
        while ((len = input.read(buffer))>0)
        {
            output.write(buffer, 0, len);
        }
        output.flush();
        output.close();
        input.close();
    }

    public boolean openDataBase() throws SQLException {
        String path = DB_PATH + DB_NAME;
        db = SQLiteDatabase.openDatabase(path, null, SQLiteDatabase.CREATE_IF_NECESSARY);
        return db != null;
    }

    @Override
    public synchronized void close() {
        if(db != null)
            db.close();
        super.close();
    }

    @Override
    public void onCreate(SQLiteDatabase db) { }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) { }
}