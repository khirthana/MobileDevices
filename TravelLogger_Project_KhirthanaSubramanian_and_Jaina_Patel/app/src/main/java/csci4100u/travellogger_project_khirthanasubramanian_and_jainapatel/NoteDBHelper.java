/*
    CSCI4100U Project - TravelLogger

    Team Members: Khirthana Subramanian(100453865) and Jaina Patel(100523188)

    NoteDBHelper: database to store notes contents

 */
package csci4100u.travellogger_project_khirthanasubramanian_and_jainapatel;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;


public class NoteDBHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "notes";
    private static final String TABLE_NOTE_DETAIL = "notesdetail";

    private static final String KEY_id = "id";
    private static final String KEY_name = "notename";
    private static final String KEY_detail = "notedetail";


    public NoteDBHelper (Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);

    }
    public void onCreate (SQLiteDatabase db){
        String CREATE_PRODUCT_TABLE = "CREATE TABLE " + TABLE_NOTE_DETAIL + "("
                + KEY_id + "INTEGER PRIMARY KEY AUTOINCREMENT,"
                + KEY_name + " TEXT,"
                + KEY_detail + " TEXT"+ ")";

        db.execSQL(CREATE_PRODUCT_TABLE);
    }

    public void onUpgrade (SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NOTE_DETAIL);

        onCreate(db);
    }

    public boolean addNote (String name, String desc){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(KEY_name,name);
        contentValues.put(KEY_detail,desc);
        long result = db.insert (TABLE_NOTE_DETAIL, null, contentValues);

        if (result == 1)
            return false;
        else
            return true;
    }

    public List<Note> getAllNotes (){
        List<Note> nlist = new ArrayList<Note>();

        String selectQuery = "SELECT  * FROM " + TABLE_NOTE_DETAIL;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                Note task = new Note();
                task.setId(cursor.getInt(0));
                task.setNote_name(cursor.getString(1));
                task.setNote_content(cursor.getString(2));

               nlist.add(task);
            } while (cursor.moveToNext());
        }

        return nlist;
    }

    public Integer deleteNote (String id){
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NOTE_DETAIL, "ID = ?", new String [] {id});
    }
}
