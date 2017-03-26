package com.addon.kamazhi.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.view.View;

import com.addon.kamazhi.KamazhiApp;
import com.addon.kamazhi.objectmodel.BookType;

import java.util.ArrayList;

/**
 * Created by sathishbabur on 3/25/2017.
 */

public class BookTypeDB {

    public static void addBookType(BookType bookType)
    {
        DBHelper dbHelper=new DBHelper(KamazhiApp.getContext());
        SQLiteDatabase database= dbHelper.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(BookType.COLUMN_NAME_ID,bookType.getId());
        contentValues.put(BookType.COLUMN_NAME_NAME,bookType.getName());
        contentValues.put(BookType.COLUMN_NAME_DESC,bookType.getDescription());
        long lngData=database.insert(BookType.TABLE_NAME,null,contentValues);
        Log.i("Insert Operation",""+lngData);
        dbHelper.close();
    }

    public static ArrayList<BookType> listBookTypes()
    {
        DBHelper dbHelper=new DBHelper(KamazhiApp.getContext());
        SQLiteDatabase database=dbHelper.getReadableDatabase();
        Cursor cursor= database.query(BookType.TABLE_NAME,new String[]
                {
                        BookType.COLUMN_NAME_ID,
                        BookType.COLUMN_NAME_NAME,
                        BookType.COLUMN_NAME_DESC
                },null,null,null,null,null);

        ArrayList<BookType> bookTypes= new ArrayList<BookType>();
        while(cursor.moveToNext()) {
            int id=cursor.getInt(cursor.getColumnIndex(BookType.COLUMN_NAME_ID));
            String name =cursor.getString(cursor.getColumnIndex((BookType.COLUMN_NAME_NAME)));
            String description=cursor.getString(cursor.getColumnIndex(BookType.COLUMN_NAME_DESC));
            BookType bookType=new BookType(id,name,description);
            bookTypes.add(bookType);
        }
        cursor.close();
        dbHelper.close();
        return bookTypes;
    }
}
