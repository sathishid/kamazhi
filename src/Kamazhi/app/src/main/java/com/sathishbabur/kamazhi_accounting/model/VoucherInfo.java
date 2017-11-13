package com.sathishbabur.kamazhi_accounting.model;

/**
 * Created by sathishbabur on 11/8/2017.
 */

public final class VoucherInfo {
    private int infoId;
    private Voucher voucher;
    private BookMaster bookMaster;
    private double debit;
    private double credit;

    public int getInfoId() {
        return infoId;
    }

    public void setInfoId(int infoId) {
        this.infoId = infoId;
    }

    public double getDebit() {
        return debit;
    }

    public void setDebit(double debit) {
        this.debit = debit;
    }

    public double getCredit() {
        return credit;
    }

    public void setCredit(double credit) {
        this.credit = credit;
    }


}