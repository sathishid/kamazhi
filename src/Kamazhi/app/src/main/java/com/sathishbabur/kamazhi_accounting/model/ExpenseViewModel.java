package com.sathishbabur.kamazhi_accounting.model;

/**
 * Created by sathishbabur on 9/9/2017.
 */

public class ExpenseViewModel {
    int categoryId;
    String categoryName;
    double amount;
    long lgDate;

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    String desc;

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public long getLgDate() {
        return lgDate;
    }

    public void setLgDate(long lgDate) {
        this.lgDate = lgDate;
    }
}
