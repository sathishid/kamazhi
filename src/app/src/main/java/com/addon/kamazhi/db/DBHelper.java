package com.addon.kamazhi.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.addon.kamazhi.objectmodel.Book;
import com.addon.kamazhi.objectmodel.BookType;
import com.addon.kamazhi.objectmodel.Voucher;
import com.addon.kamazhi.objectmodel.VoucherType;

/**
 * Created by sathishbabur on 3/25/2017.
 */

public class DBHelper extends SQLiteOpenHelper {

    public DBHelper(Context context){
        super(context,DBConstants.DBName,null,DBConstants.DBVersion);
    }
    private void createTables(SQLiteDatabase db)
    {
        db.execSQL(BookType.CREATE_TABLE_QUERY);
        db.execSQL(Book.CREATE_TABLE_QUERY);
        db.execSQL(VoucherType.CREATE_TABLE_QUERY);
        db.execSQL(Voucher.CREATE_TABLE_QUERY);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        createTables(db);
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        createTables(db);
    }
}
