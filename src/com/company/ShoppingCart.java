package com.company;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private Store store;
    private List<Goods> items;

    public ShoppingCart(Store store) {
        this.store = store;
        this.items = new ArrayList<>();
    }

    public void addToShoppingCart(Goods item, int amount) throws CustomException{
        if(store.checkIfSoldInStore(item, amount))
            items.add(item);
        else
            throw new CustomException("Insufficient amount");
    }

    public void printShoppingCart(){
        for(Goods good : this.items){
            System.out.println("You have purchased " + good.getName());
        }
    }

    public List<Goods> getItems(){
        return this.items;
    }
}
