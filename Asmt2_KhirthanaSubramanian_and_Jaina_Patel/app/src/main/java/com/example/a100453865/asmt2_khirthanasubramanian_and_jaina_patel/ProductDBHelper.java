/*
 *class takes care of the creation of the database table
 * and population of that table with sample product data
-productId (integer, primary key)
-name (string)
-description (string)
-price (decimal)

o This class will have a function for querying the database, finding all products

o This class will have a function for deleting a product from the database

o This class will have a function for inserting a new product into the database

 */

package com.example.a100453865.asmt2_khirthanasubramanian_and_jaina_patel;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.*;

public class ProductDBHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "product";
    private static final String TABLE_PRODUCT_DETAIL = "productdetail";

    private static final String KEY_id = "id";
    private static final String KEY_name = "productname";
    private static final String KEY_desc = "productdescription";
    private static final String KEY_price = "productprice";

    public ProductDBHelper (Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);

    }
    public void onCreate (SQLiteDatabase db){
        String CREATE_PRODUCT_TABLE = "CREATE TABLE" + TABLE_PRODUCT_DETAIL + "("
                + KEY_id + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + KEY_name + " TEXT,"
                + KEY_desc + " TEXT,"
                + KEY_price + " REAL" + ")";

        db.execSQL(CREATE_PRODUCT_TABLE);
    }

    public void onUpgrade (SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PRODUCT_DETAIL);

        onCreate(db);
    }

    public boolean addData (String name, String desc, double price){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(KEY_name,name);
        contentValues.put(KEY_desc,desc);
        contentValues.put(KEY_price, price);
        long result = db.insert (TABLE_PRODUCT_DETAIL, null, contentValues);

        if (result == 1)
            return false;
        else
            return true;
    }

    public List<Product> getAllData (){
        SQLiteDatabase db = this.getWritableDatabase();
        //Cursor res = db.rawQuery("Select * From "+ TABLE_PRODUCT_DETAIL, null);
        //return res;

        ArrayList<Product> results = new ArrayList<>();

        String[] columns = new String[] { KEY_id, KEY_name,KEY_desc,KEY_price};
        String where = "";  // all grades
        String[] whereArgs = new String[] {};
        String groupBy = "";  // no grouping
        String groupArgs = "";
        String orderBy =KEY_id;

        Cursor cursor = db.query("product", columns, where, whereArgs,groupBy, groupArgs, orderBy);
        cursor.moveToFirst();
        while(!cursor.isAfterLast()) {
            int product_id=cursor.getInt(0);
            String product_name= cursor.getString(1);
            String product_desc=cursor.getString(2);
            double price=cursor.getDouble(3);

            results.add(new Product(product_id,product_name,product_desc,price));

            cursor.moveToNext();
        }

        return results;
    }

    public Integer deleteData (int id){
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_PRODUCT_DETAIL, "id = ?", new String [] {""+id});
    }
}
