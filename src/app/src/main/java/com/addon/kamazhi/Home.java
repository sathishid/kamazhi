package com.addon.kamazhi;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.addon.kamazhi.db.DBHelper;
import com.addon.kamazhi.objectmodel.BookType;

public class Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }
    public void addBookItem(View view)
    {

        DBHelper dbHelper=new DBHelper(getApplicationContext());
        SQLiteDatabase database= dbHelper.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(BookType.COLUMN_NAME_ID,"1");
        contentValues.put(BookType.COLUMN_NAME_NAME,"Summa");
        contentValues.put(BookType.COLUMN_NAME_DESC,"TEst Desc");
        database.insert(BookType.TABLE_NAME,null,contentValues);
        dbHelper.close();

        database=dbHelper.getReadableDatabase();
        Cursor cursor= database.query(BookType.TABLE_NAME,new String[]
                {
                        BookType.COLUMN_NAME_ID,
                        BookType.COLUMN_NAME_NAME,
                        BookType.COLUMN_NAME_DESC
                },null,null,null,null,null);
        while(cursor.moveToNext()) {
           System.out.println(cursor);
            String name =cursor.getString(cursor.getColumnIndex((BookType.COLUMN_NAME_NAME)));
            System.out.println(name);
        }
        cursor.close();
    }
}
