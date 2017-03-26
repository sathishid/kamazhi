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
import com.addon.kamazhi.db.VoucherDB;
import com.addon.kamazhi.db.VoucherTypeDB;
import com.addon.kamazhi.objectmodel.BookType;
import com.addon.kamazhi.objectmodel.Voucher;
import com.addon.kamazhi.objectmodel.VoucherType;

import java.util.ArrayList;
import java.util.Date;

public class Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }
    public void addBookItem(View view)
    {
        Voucher btype=new Voucher(4, new Date(),1);
        VoucherDB.addVoucher(btype);

        ArrayList<Voucher> bookTypes=VoucherDB.listVouchers();
        for(Voucher bookType : bookTypes)
        {
            Log.i(bookType.getDate().toString(),bookType.getVoucherType().toString());
        }
    }
}
