package com.addon.kamazhi.db;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.addon.kamazhi.KamazhiApp;
import com.addon.kamazhi.objectmodel.Book;
import com.addon.kamazhi.objectmodel.Voucher;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by sathishbabur on 3/26/2017.
 */

public class VoucherDB {

    public static void addVoucher(Voucher voucher)
    {
        DBHelper dbHelper=new DBHelper(KamazhiApp.getContext());
        SQLiteDatabase database= dbHelper.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(Voucher.COLUMN_NAME_ID,voucher.getId());
        contentValues.put(Voucher.COLUMN_NAME_DATE,voucher.getDate().getTime());
        contentValues.put(Voucher.COLUMN_NAME_VOUCHERTYPE,voucher.getVoucherType().getId());
        long lngData=database.insert(Voucher.TABLE_NAME,null,contentValues);
        Log.i("Voucher","Inserted "+voucher.getDate());
        dbHelper.close();
    }

    public static ArrayList<Voucher> listVouchers()
    {
        DBHelper dbHelper=new DBHelper(KamazhiApp.getContext());
        SQLiteDatabase database=dbHelper.getReadableDatabase();
        Cursor cursor= database.query(Voucher.TABLE_NAME,new String[]
                {
                        Voucher.COLUMN_NAME_ID,
                        Voucher.COLUMN_NAME_DATE,
                        Voucher.COLUMN_NAME_VOUCHERTYPE,
                },null,null,null,null,null);

        ArrayList<Voucher> vouchers= new ArrayList<Voucher>();
        while(cursor.moveToNext()) {
            int id=cursor.getInt(cursor.getColumnIndex(Voucher.COLUMN_NAME_ID));
            long dateAsLong=cursor.getLong(cursor.getColumnIndex((Voucher.COLUMN_NAME_DATE)));
            Date dtTemp=new Date();
            dtTemp.setTime(dateAsLong);
            int voucherTypeID=cursor.getInt(cursor.getColumnIndex(Voucher.COLUMN_NAME_VOUCHERTYPE));
            Voucher voucher=new Voucher(id,dtTemp,voucherTypeID);
            vouchers.add(voucher);
        }
        cursor.close();
        dbHelper.close();
        return vouchers;
    }
}
