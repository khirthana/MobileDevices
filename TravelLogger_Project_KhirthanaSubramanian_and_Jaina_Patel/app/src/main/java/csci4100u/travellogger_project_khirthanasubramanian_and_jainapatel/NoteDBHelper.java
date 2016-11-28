import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by 100523188 on 11/27/2016.
 */

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

    public boolean addNote (String name, String desc, String price){
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

    public Cursor getAllNotes (){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("Select * From "+ TABLE_NOTE_DETAIL, null);
        return res;
    }

    public Integer deleteNote (String id){
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NOTE_DETAIL, "ID = ?", new String [] {id});
    }
}
