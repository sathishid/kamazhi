package com.addon.kamazhi.objectmodel;

import com.addon.kamazhi.db.VoucherTypeDB;

import java.util.Date;

/**
 * Created by sathishbabur on 3/26/2017.
 */

public class Voucher {

    public static final String TABLE_NAME = "Voucher";
    public static final String COLUMN_NAME_ID = "ID";
    public static final String COLUMN_NAME_DATE = "VoucherDate";
    public static final String COLUMN_NAME_VOUCHERTYPE = "VoucherType";
    public static final String CREATE_TABLE_QUERY =
            "CREATE TABLE " + TABLE_NAME + " (" +
                    COLUMN_NAME_ID + " INTEGER PRIMARY KEY," +
                    COLUMN_NAME_DATE + " long," +
                    COLUMN_NAME_VOUCHERTYPE + " INTEGER)";



    public Date getDate() {
        return date;
    }

    public int getId() {
        return id;
    }

    public VoucherType getVoucherType() {
        return new VoucherType(1,"D","f");
        //TODO: Need to fetch from DB.
    }
    private int id;
    private String name;
    private Date date;
    private int voucherType;

    public Voucher(int id, Date date, int voucherType) {
        this.id = id;
        this.date = date;
        this.voucherType = voucherType;
    }
}
