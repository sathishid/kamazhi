package com.addon.kamazhi.db;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.addon.kamazhi.KamazhiApp;
import com.addon.kamazhi.objectmodel.Book;
import com.addon.kamazhi.objectmodel.BookType;

import java.util.ArrayList;

/**
 * Created by sathishbabur on 3/26/2017.
 */

public class BookDB {

    public static void addBook(Book book)
    {
        DBHelper dbHelper=new DBHelper(KamazhiApp.getContext());
        SQLiteDatabase database= dbHelper.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(Book.COLUMN_NAME_ID,book.getId());
        contentValues.put(Book.COLUMN_NAME_NAME,book.getName());
        contentValues.put(Book.COLUMN_NAME_DESC,book.getDescription());
        contentValues.put(Book.COLUMN_NAME_Type,book.getBookType().getId());
        long lngData=database.insert(Book.TABLE_NAME,null,contentValues);
        Log.i("Book e","Inserted "+book.getName());
        dbHelper.close();
    }

    public static ArrayList<Book> listBookTypes()
    {
        DBHelper dbHelper=new DBHelper(KamazhiApp.getContext());
        SQLiteDatabase database=dbHelper.getReadableDatabase();
        Cursor cursor= database.query(Book.TABLE_NAME,new String[]
                {
                        Book.COLUMN_NAME_ID,
                        Book.COLUMN_NAME_NAME,
                        Book.COLUMN_NAME_DESC,
                        Book.COLUMN_NAME_Type
                },null,null,null,null,null);

        ArrayList<Book> books= new ArrayList<Book>();
        while(cursor.moveToNext()) {
            int id=cursor.getInt(cursor.getColumnIndex(Book.COLUMN_NAME_ID));
            String name =cursor.getString(cursor.getColumnIndex((Book.COLUMN_NAME_NAME)));
            String description=cursor.getString(cursor.getColumnIndex(Book.COLUMN_NAME_DESC));
            int bookTypeID=cursor.getInt(cursor.getColumnIndex(Book.COLUMN_NAME_Type));
            Book book=new Book(id,name,description,bookTypeID);
            books.add(book);
        }
        cursor.close();
        dbHelper.close();
        return books;
    }
}
