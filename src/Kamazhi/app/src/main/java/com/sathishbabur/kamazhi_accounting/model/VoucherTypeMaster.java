package com.sathishbabur.kamazhi_accounting.model;

/**
 * Created by sathishbabur on 11/8/2017.
 */

public final class VoucherTypeMaster {
    private int voucherTypeId;
    private String name;
    private String desc;

    public int getVoucherTypeId() {
        return voucherTypeId;
    }

    public void setVoucherTypeId(int voucherTypeId) {
        this.voucherTypeId = voucherTypeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }


}