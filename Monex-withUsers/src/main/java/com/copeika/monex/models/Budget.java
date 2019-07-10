package com.copeika.monex.models;

public class Budget {
    private Integer money;
    private Integer cash_balance;


    public Budget() {
    }

    public Budget(Integer money){
        this.money = money;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

    public Integer getCash_balance() {
        return cash_balance;
    }

    public void setCash_balance(Integer cash_balance) {
        this.cash_balance = cash_balance;
    }

}
