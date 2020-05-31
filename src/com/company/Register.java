package com.company;

import java.util.List;

public class Register implements Runnable {
    private Cashier currentCashier;
    private List<Goods> goods;

    public Register(Cashier currentCashier, List<Goods> goods) {
        this.currentCashier = currentCashier;
        this.goods = goods;
    }

    public Cashier getCurrentCashier(){
        return currentCashier;
    }

    public void newReceipt(){
       Receipt receipt = new Receipt(getCurrentCashier(), goods);
       receipt.generateReceipt();
    }

    @Override
    public void run() {
        newReceipt();
    }
}
