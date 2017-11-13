package com.sathishbabur.kamazhi_accounting.db;

/**
 * Created by sathishbabur on 11/8/2017.
 */

public class VoucherTypeMasterDB {
    public static final String TableName = "VoucherTypeMaster";
    public static final String TypeID = "VoucherTypeID";
    public static final String Name = "Name";
    public static final String Desc = "Desc";
    public static final String SQL_CREATE =
            "CREATE TABLE " + TableName + " (" +
                    TypeID + " INTEGER PRIMARY KEY," +
                    Name + " TEXT," +
                    Desc + " TEXT)";
    public static final String SQL_DROP =
            "DROP TABLE IF EXISTS " + TableName;
}
