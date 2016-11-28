package csci4100u.travellogger_project_khirthanasubramanian_and_jainapatel;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by 100523188 on 11/27/2016.
 */

public class WishlistDBHelper extends SQLiteOpenHelper{

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "wishes";
    private static final String TABLE_WISHES = "wish";
    private static final String KEY_ID = "id";
    private static final String KEY_WISHNAME = "wish";
    private static final String KEY_STATUS = "status";

    public WishlistDBHelper (Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE IF NOT EXISTS " + TABLE_WISHES + " ( "
        + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
        + KEY_WISHNAME+ " TEXT, "
        + KEY_STATUS + " INTEGER)";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldV, int newV) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_WISHES);
        // Create tables again
        onCreate(db);
    }

    public void addWish(MyWish wish) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_WISHNAME, wish.getTitle());

        values.put(KEY_STATUS, wish.getStatus());


        db.insert(TABLE_WISHES, null, values);
        db.close();
    }

    public List<MyWish> getAllWishes() {
        List<MyWish> wlist = new ArrayList<MyWish>();

        String selectQuery = "SELECT  * FROM " + TABLE_WISHES;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                MyWish task = new MyWish();
                task.setId(cursor.getInt(0));
                task.setTitle(cursor.getString(1));
                task.setStatus(cursor.getInt(2));

                wlist.add(task);
            } while (cursor.moveToNext());
        }

        return wlist;
    }

    public void updateWish(MyWish wish) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_WISHNAME, wish.getTitle());
        values.put(KEY_STATUS, wish.getStatus());
        db.update(TABLE_WISHES, values, KEY_ID + " = ?",
                new String[]{String.valueOf(wish.getId())});
    }
}

