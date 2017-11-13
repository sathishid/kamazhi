package com.sathishbabur.kamazhi_accounting.db;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.sathishbabur.kamazhi_accounting.model.BookMaster;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by sathishbabur on 11/8/2017.
 */

public class BookMasterDB {
    public static final String TABLE_NAME = "BookMaster";
    public static final String BOOK_ID = "BookID";
    public static final String NAME = "Name";
    public static final String DESC = "Desc";
    public static final String BOOK_TYPE_ID = "BookTypeID";
    public static final String SQL_CREATE =
            "CREATE TABLE " + TABLE_NAME + " (" +
                    BOOK_ID + " INTEGER PRIMARY KEY," +
                    NAME + " TEXT," +
                    DESC + " TEXT ," +
                    BOOK_TYPE_ID + " INTEGER)";
    public static final String SQL_DROP =
            "DROP TABLE IF EXISTS " + TABLE_NAME;

    public static int saveDefault(SQLiteDatabase db,String[] typeNames,int bookTypeId,int startId)
    {
        db.beginTransaction();
        int id = startId;
        try {

            for (String typeName : typeNames) {
                ContentValues values = new ContentValues();
                values.put(BOOK_ID, id);
                values.put(NAME, typeName);
                values.put(DESC, "");
                values.put(BOOK_TYPE_ID, bookTypeId);
                db.insert(TABLE_NAME, null, values);
                id++;
            }
            db.setTransactionSuccessful();
        }
        finally {
            db.endTransaction();
        }
        return id;
    }
    public static long save(DBHelper dbHelper, BookMaster bookMaster) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(BOOK_ID, bookMaster.getBookId());
        values.put(NAME, bookMaster.getName());
        values.put(DESC, bookMaster.getDesc());
        values.put(BOOK_TYPE_ID, bookMaster.getBookTypeId());
        long returValue = db.insert(TABLE_NAME, null, values);
        db.close();
        return returValue;
    }

    public static Iterator<BookMaster> getAll(DBHelper dbHelper) {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.query(TABLE_NAME, new String[]{
                BOOK_ID,
                NAME,
                DESC,
                BOOK_TYPE_ID
        }, null, null, null, null, null);
        List<BookMaster> bookMasters = new ArrayList<BookMaster>();
        int bookIdIndex = cursor.getColumnIndex(BOOK_ID);
        int nameIndex = cursor.getColumnIndex(NAME);
        int descIndex = cursor.getColumnIndex(DESC);
        int bookTypeIdIndex = cursor.getColumnIndex(BOOK_TYPE_ID);
        while (cursor.moveToNext()) {
            int bookId = cursor.getInt(bookIdIndex);
            String name = cursor.getString(nameIndex);
            String desc = cursor.getString(descIndex);
            int bookTypeId = cursor.getInt(bookTypeIdIndex);
            bookMasters.add(
                    new BookMaster(bookId, name, desc, bookTypeId)
            );
        }
        return bookMasters.iterator();
    }

}
