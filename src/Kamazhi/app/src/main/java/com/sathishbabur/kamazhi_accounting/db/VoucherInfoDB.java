package com.sathishbabur.kamazhi_accounting.db;

/**
 * Created by sathishbabur on 11/8/2017.
 */

public class VoucherInfoDB {
    public static final String TableName = "VoucherInfo";
    public static final String InfoID = "InfoID";
    public static final String VoucherID = "VoucherID";
    public static final String BookID = "BookID";
    public static final String Debit = "Debit";
    public static final String Credit = "Credit";
    public static final String SQL_CREATE =
            "CREATE TABLE " + TableName + " (" +
                    InfoID + " INTEGER PRIMARY KEY," +
                    VoucherID + " INTEGER," +
                    BookID + " INTEGER ," +
                    Debit + " REAL," +
                    Credit + " REAL)";
    public static final String SQL_DROP =
            "DROP TABLE IF EXISTS " + TableName;

}
