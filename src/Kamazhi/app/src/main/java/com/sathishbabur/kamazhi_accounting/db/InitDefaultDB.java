package com.sathishbabur.kamazhi_accounting.db;

import android.database.sqlite.SQLiteDatabase;

import com.sathishbabur.kamazhi_accounting.model.BookTypeMaster;

/**
 * Created by sathishbabur on 11/8/2017.
 */

public class InitDefaultDB {
    private static final String[] BOOK_TYPES={"Cash","Income","Expense","Asset"};
    private static final int EXPENSE_ID =3;
    private static final int INCOME_ID=2;
    private static final String[] EXPENSES={
            "Breakfast","Coffee","Dinner",
            "Donnation","Dress","Apparel",
            "Snacks"};
    private static final String[] INCOMES={
            "Salary",
            "Rental Income",
            "Stocks",
            "Incentive",
            "Interest"
    };
    public static void initialize(SQLiteDatabase db)
    {
        int startId=1;
        BookTypeMasterDB.saveDefault(db,BOOK_TYPES);
        startId=BookMasterDB.saveDefault(db,EXPENSES,EXPENSE_ID,startId);
        BookMasterDB.saveDefault(db,INCOMES,INCOME_ID,startId);
    }
}
