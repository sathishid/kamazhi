package com.sathishbabur.kamazhi_accounting.model;

/**
 * Created by sathishbabur on 11/4/2017.
 */

public class HomeViewModel {
    public double getBalanceAmount() {
        return balanceAmount;
    }

    public void setBalanceAmount(double balanceAmount) {
        this.balanceAmount = balanceAmount;
    }
    public void credit(double value)
    {
        balanceAmount+=value;
    }
    public void debit(double value)
    {
        balanceAmount-=value;
    }
    double balanceAmount;

}
