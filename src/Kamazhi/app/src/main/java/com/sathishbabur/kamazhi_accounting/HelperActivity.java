package com.sathishbabur.kamazhi_accounting;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.health.PackageHealthStats;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;

public class HelperActivity extends AppCompatActivity {

    public static final int NUMERIC=1;
    public static final int DATE=2;
    public static final int TEXT=3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_helper);
        addControl();
    }
    protected void addControl()
    {
        Intent requestIntent=this.getIntent();
        int type=requestIntent.getIntExtra("type",TEXT);
        switch (type)
        {
            case NUMERIC:
                addNumeric();
                break;
            case TEXT:
                addText();
                break;
            case DATE:
                addDate();
                break;
        }
    }

    private void addDate() {
        addEditText(InputType.TYPE_DATETIME_VARIATION_DATE);
    }

    private void addNumeric() {
        addEditText(InputType.TYPE_CLASS_NUMBER);
    }

    protected void addText()
    {
        addEditText(InputType.TYPE_CLASS_TEXT);
    }
    EditText editText;
    protected void addEditText(int inputType)
    {
        LinearLayout layout = (LinearLayout) findViewById(R.id.llInput);
        LinearLayout.LayoutParams gl=new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        editText=new EditText(this);
        editText.setInputType(inputType);

        layout.addView(editText, gl);
        editText.requestFocus();
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.showSoftInput(editText, InputMethodManager.SHOW_FORCED);
    }
    protected Intent getResultIntent()
    {
        Intent intent=new Intent();
        intent.putExtra("result",editText.getText().toString());
        return intent;
    }

    public void sendResultBack(View view) {
        setResult(Activity.RESULT_OK,getResultIntent());
        finish();
    }
}
