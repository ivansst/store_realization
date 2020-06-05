package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Store {
    private List<Goods> goods;
    private List<Cashier> cashiers;
    private int issuedReceipts = 0;
    private static double storeTotal = 0;
    private int randomNumberForCashier;

    public Store(List<Goods> goods, List<Cashier> cashiers) {
        this.goods = goods;
        this.cashiers = cashiers;
        this.issuedReceipts = issuedReceipts;
        randomNumberForCashier = new Random().nextInt(cashiers.size());
    }

    public Store(List<Cashier> cashiers){
        this.cashiers = cashiers;
        this.issuedReceipts = issuedReceipts;
        this.goods = new ArrayList<>();
        randomNumberForCashier = new Random().nextInt(cashiers.size());
    }

    public void addToStorage(Goods item, int amount){
      for(int count = 0; count < amount; count++){
          this.goods.add(item);
      }
    }

    public boolean checkIfSoldInStore(Goods item, int amount) throws CustomException{
        int counter = 0;

            if(this.goods.contains(item)){
                for (Goods good : this.goods){
                    if(good.getId() == item.getId())
                        counter++;
                }

                return counter >= amount;
            }
            else {
                throw new CustomException("We don't sell this item in the store!");
            }
    }

    public void purchase(ShoppingCart cart, String name){
        Thread register = new Thread(new Register(cashiers.get(randomNumberForCashier), goods), name);
        register.start();
        cart.printShoppingCart();
        addToStoreTotal(cart.getItems());
        issuedReceipts++;
    }

    public void getIssuedReceipts(){
        System.out.println("The number of issued receipts is " + this.issuedReceipts);
    }

    public void getStoreTotal(){
        System.out.println("The total profit for the store is " + storeTotal);
    }

    private void addToStoreTotal(List<Goods> items){
        for (Goods good : items){
            storeTotal += good.getPrice();
        }
    }
}
