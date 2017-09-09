package com.sathishbabur.kamazhi_accounting;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;

import java.text.DateFormat;
import java.util.Date;

public class DateHelperActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_helper);
    }

    protected Intent getResultIntent()
    {
        DatePicker datePicker=(DatePicker)  findViewById(R.id.datePicker);
        Intent intent=new Intent();
        String dateFormat= getDateAsString(datePicker);
        intent.putExtra("result",dateFormat);
        return intent;
    }
    protected String getDateAsString(DatePicker datePicker)
    {
        int year=datePicker.getYear()-1900 ;
        int month=datePicker.getMonth();
        int day=datePicker.getDayOfMonth();
        Date date=new Date(year,month,day);
        String format=DateFormat.getDateInstance().format(date);
        return format;
    }

    public void sendResultBack(View view) {
            setResult(Activity.RESULT_OK,getResultIntent());
            finish();
    }
}
