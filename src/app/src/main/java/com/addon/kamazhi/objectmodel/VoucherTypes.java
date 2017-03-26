package com.addon.kamazhi.objectmodel;

import com.addon.kamazhi.db.BookTypeDB;
import com.addon.kamazhi.db.VoucherTypeDB;

import java.util.ArrayList;

/**
 * Created by sathishbabur on 3/26/2017.
 */

public class VoucherTypes {
    private ArrayList<VoucherType> voucherTypes;
    public static VoucherTypes listofVouchers;

    public VoucherTypes() {
        voucherTypes= new ArrayList<>();
    }
    public void addVoucherTypes(VoucherType voucherType)
    {
        voucherTypes.add(voucherType);
    }
    public static VoucherTypes getPreservedTypes()
    {
        if(listofVouchers==null) {
            listofVouchers= new VoucherTypes();
            listofVouchers.voucherTypes= VoucherTypeDB.listVoucherTypes();
        }
        return listofVouchers;
    }
}
