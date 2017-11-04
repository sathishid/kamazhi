package com.sathishbabur.kamazhi_accounting;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.TextView;

import com.sathishbabur.kamazhi_accounting.model.HomeViewModel;

public class HomeActivity extends AppCompatActivity {
    public static final int Expense=1;
    public static final int Income=2;
    HomeViewModel homeViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        homeViewModel=new HomeViewModel();
        updateBalance();
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(resultCode== Activity.RESULT_OK) {
            updateTranasction(requestCode,data);
            updateBalance();
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
    public void updateTranasction(int requestCode,Intent data)
    {
        switch (requestCode)
        {
            case Expense:
                homeViewModel.sub(data.getDoubleExtra("dblValue",0));
                break;
            case Income:
                homeViewModel.sum(data.getDoubleExtra("dblValue",0));
                break;
        }

    }
    public void updateBalance()
    {
        TextView balanceView=(TextView) findViewById(R.id.txtBalance);
        balanceView.setText(homeViewModel.getBalanceAmount()+"");
    }
    public void addExpense(View view) {
        doTransaction(Expense);
    }
    public void addIncome(View view)
    {
        doTransaction(Income);
    }
    public void doTransaction(int pageType){
        Intent intent=new Intent(this,AddExpenseActivity.class);
        intent.putExtra("requestCode",pageType);
        startActivityForResult(intent,pageType);
    }

}
