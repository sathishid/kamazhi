package com.addon.kamazhi.db;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.addon.kamazhi.KamazhiApp;
import com.addon.kamazhi.objectmodel.BookType;
import com.addon.kamazhi.objectmodel.VoucherType;

import java.util.ArrayList;

/**
 * Created by sathishbabur on 3/26/2017.
 */

public class VoucherTypeDB
{
    public static void addVoucherType(VoucherType voucherType)
    {
        DBHelper dbHelper=new DBHelper(KamazhiApp.getContext());
        SQLiteDatabase database= dbHelper.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(VoucherType.COLUMN_NAME_ID,voucherType.getId());
        contentValues.put(VoucherType.COLUMN_NAME_NAME,voucherType.getName());
        contentValues.put(VoucherType.COLUMN_NAME_DESC,voucherType.getDescription());
        long lngData=database.insert(VoucherType.TABLE_NAME,null,contentValues);
        Log.i("Voucher Type","Inserted "+voucherType.getName());
        dbHelper.close();
    }

    public static ArrayList<VoucherType> listVoucherTypes()
    {
        DBHelper dbHelper=new DBHelper(KamazhiApp.getContext());
        SQLiteDatabase database=dbHelper.getReadableDatabase();

        Cursor cursor= database.query(VoucherType.TABLE_NAME,new String[]
                {
                        VoucherType.COLUMN_NAME_ID,
                        VoucherType.COLUMN_NAME_NAME,
                        VoucherType.COLUMN_NAME_DESC
                },null,null,null,null,null);

        ArrayList<VoucherType> voucherTypes= new ArrayList<VoucherType>();
        while(cursor.moveToNext()) {
            int id=cursor.getInt(cursor.getColumnIndex(VoucherType.COLUMN_NAME_ID));
            String name =cursor.getString(cursor.getColumnIndex((VoucherType.COLUMN_NAME_NAME)));
            String description=cursor.getString(cursor.getColumnIndex(VoucherType.COLUMN_NAME_DESC));
            VoucherType bookType=new VoucherType(id,name,description);
            voucherTypes.add(bookType);
        }
        cursor.close();
        dbHelper.close();
        return voucherTypes;
    }
}
