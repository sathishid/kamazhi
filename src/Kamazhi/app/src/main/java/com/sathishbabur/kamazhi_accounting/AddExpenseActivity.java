package com.sathishbabur.kamazhi_accounting;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.sathishbabur.kamazhi_accounting.db.BookTypeMasterDB;
import com.sathishbabur.kamazhi_accounting.db.DBHelper;
import com.sathishbabur.kamazhi_accounting.model.BookTypeMaster;

import java.util.Map;

public class AddExpenseActivity extends AppCompatActivity {

    public static final int CATEGORY = 1;
    public static final int AMOUNT = 2;
    public static final int DATE = 3;
    public static final int COMMENTS = 4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_expense);
        updatePageType();
    }

    protected void updatePageType() {
        int requestCode = getIntent().getIntExtra("requestCode", 1);
        TextView txtTitle = (TextView) findViewById(R.id.txtTitle);
        Button btnTransaction = (Button) findViewById(R.id.btnTransaction);
        switch (requestCode) {
            case HomeActivity.Expense:
                txtTitle.setText(R.string.add_expense);
                btnTransaction.setText(R.string.add_expense);
                break;
            case HomeActivity.Income:
                txtTitle.setText(R.string.add_income);
                btnTransaction.setText(R.string.add_income);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == Activity.RESULT_OK) {
            updateItem(requestCode, data);
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    protected void updateItem(int requestCode, Intent intent) {
        TextView view;
        switch (requestCode) {
            case CATEGORY:
                view = (TextView) findViewById(R.id.txtCategory);
                view.setText(intent.getStringExtra("result"));
                break;
            case AMOUNT:
                view = (TextView) findViewById(R.id.txtAmount);
                view.setText(intent.getStringExtra("result"));
                break;
            case DATE:
                view = (TextView) findViewById(R.id.txtDate);
                view.setText(intent.getStringExtra("result"));
                break;
            case COMMENTS:
                view = (TextView) findViewById(R.id.txtComments);
                view.setText(intent.getStringExtra("result"));
                break;
        }
    }

    public void getCategory(View view) {
        DBHelper dbHelper=new DBHelper(this.getApplicationContext());
        Map<Integer,BookTypeMaster> bookTypeMasterMap=BookTypeMasterDB.getAllIndexed(dbHelper);
        System.out.println(bookTypeMasterMap);

        Intent intent = new Intent(this, HelperActivity.class);
        intent.putExtra("type", HelperActivity.TEXT);

        startActivityForResult(intent, CATEGORY);

    }

    public void getDate(View view) {
        Intent intent = new Intent(this, DateHelperActivity.class);
        intent.putExtra("type", HelperActivity.DATE);
        startActivityForResult(intent, DATE);
    }

    public void getAmount(View view) {
        Intent intent = new Intent(this, HelperActivity.class);
        intent.putExtra("type", HelperActivity.NUMERIC);
        startActivityForResult(intent, AMOUNT);
    }

    public void getComments(View view) {
        Intent intent = new Intent(this, HelperActivity.class);
        intent.putExtra("type", HelperActivity.TEXT);
        startActivityForResult(intent, COMMENTS);
    }

    protected Intent getResultIntent() {
        Intent intent = new Intent();
        TextView txtView = (TextView) findViewById(R.id.txtAmount);
        double dblValue = Double.parseDouble(txtView.getText().toString());
        intent.putExtra("dblValue", dblValue);
        return intent;
    }

    protected void updateDB() {
        DBHelper dbHelper = new DBHelper(this.getApplicationContext());
    }

    public void sendResultBack(View view) {
        setResult(Activity.RESULT_OK, getResultIntent());
        finish();
    }
}
