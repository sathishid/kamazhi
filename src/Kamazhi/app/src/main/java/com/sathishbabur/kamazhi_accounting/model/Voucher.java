package com.sathishbabur.kamazhi_accounting.model;

/**
 * Created by sathishbabur on 11/8/2017.
 */

public final class Voucher {
    private int voucherId;
    private int trasactionDate;
    private VoucherTypeMaster voucherTypeMaster;

    public Voucher(int voucherId, int trasactionDate, VoucherTypeMaster voucherTypeMaster) {
        this.voucherId = voucherId;
        this.trasactionDate = trasactionDate;
        this.voucherTypeMaster = voucherTypeMaster;
    }

    public int getVoucherId() {
        return voucherId;
    }

    public void setVoucherId(int voucherId) {
        this.voucherId = voucherId;
    }

    public int getTrasactionDate() {
        return trasactionDate;
    }

    public void setTrasactionDate(int trasactionDate) {
        this.trasactionDate = trasactionDate;
    }

}