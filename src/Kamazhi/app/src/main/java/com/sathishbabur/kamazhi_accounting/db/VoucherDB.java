package com.sathishbabur.kamazhi_accounting.db;

/**
 * Created by sathishbabur on 11/8/2017.
 */

public final class VoucherDB {
    public static final String TableName = "Voucher";
    public static final String TypeID = "VoucherID";
    public static final String TransactionDate = "TransactionDate";
    public static final String VoucherTypeID = "VoucherTypeID";
    public static final String SQL_CREATE =
            "CREATE TABLE " + TableName + " (" +
                    TypeID + " INTEGER PRIMARY KEY," +
                    TransactionDate + " INTEGER," +
                    VoucherTypeID + " INTEGER)";
    public static final String SQL_DROP =
            "DROP TABLE IF EXISTS " + TableName;
}
