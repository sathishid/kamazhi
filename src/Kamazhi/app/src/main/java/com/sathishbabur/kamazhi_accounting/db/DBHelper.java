package com.sathishbabur.kamazhi_accounting.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by sathishbabur on 11/6/2017.
 */

public class DBHelper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION=1;
    public static final String DATABASE_NAME="kamazhi_accounts.db";
    public DBHelper(Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(VoucherDB.SQL_CREATE);
        db.execSQL(VoucherTypeMasterDB.SQL_CREATE);
        db.execSQL(VoucherInfoDB.SQL_CREATE);
        db.execSQL(BookTypeMasterDB.SQL_CREATE);
        db.execSQL(BookMasterDB.SQL_CREATE);

        InitDefaultDB.initialize(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(VoucherDB.SQL_DROP);
        db.execSQL(BookMasterDB.SQL_DROP);
        db.execSQL(BookTypeMasterDB.SQL_DROP);
        db.execSQL(VoucherInfoDB.SQL_DROP);
        db.execSQL(VoucherTypeMasterDB.SQL_DROP);
    }

    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        super.onDowngrade(db, oldVersion, newVersion);
    }
}
