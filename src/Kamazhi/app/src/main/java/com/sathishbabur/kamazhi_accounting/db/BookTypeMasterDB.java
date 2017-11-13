package com.sathishbabur.kamazhi_accounting.db;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import com.sathishbabur.kamazhi_accounting.model.BookMaster;
import com.sathishbabur.kamazhi_accounting.model.BookTypeMaster;

import java.net.UnknownServiceException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by sathishbabur on 11/8/2017.
 */

public class BookTypeMasterDB {
    public static final String TABLE_NAME = "BookTypeMaster";
    public static final String TYPE_ID = "BookTypeID";
    public static final String NAME = "Name";
    public static final String DESC = "Desc";
    public static final String SQL_CREATE =
            "CREATE TABLE " + TABLE_NAME + " (" +
                    TYPE_ID + " INTEGER PRIMARY KEY," +
                    NAME + " TEXT," +
                    DESC + " TEXT)";
    public static final String SQL_DROP =
            "DROP TABLE IF EXISTS " + TABLE_NAME;

    public static void saveDefault(SQLiteDatabase db, String[] typeNames)
    {
        db.beginTransaction();
        try {
            int id = 1;
            ContentValues values = new ContentValues();
            for (String typeName : typeNames) {
                values.put(TYPE_ID, id);
                values.put(NAME, typeName);
                values.put(DESC, "");
                db.insert(TABLE_NAME, null, values);
                id++;
            }
            db.setTransactionSuccessful();
        }
        finally {
            db.endTransaction();
        }
    }

    public static long save(DBHelper dbHelper, BookTypeMaster bookTypeMaster) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(TYPE_ID, bookTypeMaster.getTypeId());
        values.put(NAME, bookTypeMaster.getName());
        values.put(DESC, bookTypeMaster.getDesc());
        long returValue = db.insert(TABLE_NAME, null, values);
        db.close();
        return returValue;
    }
    public static BookTypeMaster getById(DBHelper dbHelper,int bookTypeID)
    {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.query(TABLE_NAME, new String[]{
                TYPE_ID,
                NAME,
                DESC
        }, TYPE_ID+"=?", new String[]{bookTypeID+""}, null, null, null);
        if(!cursor.moveToNext())
            throw new UnsupportedOperationException("Book Type not exists:"+bookTypeID);
        int bookTypeId=cursor.getInt(cursor.getColumnIndex(TYPE_ID));
        String name=cursor.getString(cursor.getColumnIndex(NAME));
        String desc=cursor.getString(cursor.getColumnIndex(DESC));
        return new BookTypeMaster(bookTypeId,name,desc);
    }
    public static Map<Integer,BookTypeMaster> getAllIndexed(DBHelper dbHelper) {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.query(TABLE_NAME, new String[]{
                TYPE_ID,
                NAME,
                DESC,
        }, null, null, null, null, null);
        Map<Integer,BookTypeMaster> bookTypeMasters = new HashMap<>();
        int bookIdIndex = cursor.getColumnIndex(TYPE_ID);
        int nameIndex = cursor.getColumnIndex(NAME);
        int descIndex = cursor.getColumnIndex(DESC);
        while (cursor.moveToNext()) {
            int bookId = cursor.getInt(bookIdIndex);
            String name = cursor.getString(nameIndex);
            String desc = cursor.getString(descIndex);
            bookTypeMasters.put(
                    new Integer(bookId),
                    new BookTypeMaster(bookId, name, desc)
            );
        }
        return bookTypeMasters;
    }

}
