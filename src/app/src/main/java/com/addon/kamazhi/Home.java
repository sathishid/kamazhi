package com.addon.kamazhi;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.util.Log;

import com.addon.kamazhi.db.BookTypeDB;
import com.addon.kamazhi.db.DBHelper;
import com.addon.kamazhi.db.VoucherTypeDB;
import com.addon.kamazhi.objectmodel.BookType;
import com.addon.kamazhi.objectmodel.VoucherType;

import java.util.ArrayList;

public class Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }
    public void addBookItem(View view)
    {
        VoucherType btype=new VoucherType(3,"OTher","Other Desc");
        VoucherTypeDB.addVoucherType(btype);

        ArrayList<VoucherType> bookTypes=VoucherTypeDB.listBookTypes();
        for(VoucherType bookType : bookTypes)
        {
            Log.i(bookType.getName(),bookType.getDescription());
        }
    }
}
