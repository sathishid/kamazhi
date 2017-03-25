package com.addon.kamazhi.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by sathishbabur on 3/25/2017.
 */

public class DBHelper extends SQLiteOpenHelper {

    public DBHelper(Context context){
        super(context,DBConstants.DBName,null,DBConstants.DBVersion);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DBConstants.CREATE_BOOKTYPE_QUERY);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(DBConstants.CREATE_BOOKTYPE_QUERY);
    }
}
