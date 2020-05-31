package com.company;

import java.time.LocalDate;
import java.util.*;

public class Main {

    public static void main(String[] args) throws CustomException {

        //TODO Fix fileReader in FileCreator

        Goods goods = new Goods(123, "banana", 200, LocalDate.now());
        Goods goods1 = new Goods(124, "bana", 240, LocalDate.now());
        Goods goods2 = new Goods(125, "ban", 200, LocalDate.now());
        List<Goods> listOfGoods = new ArrayList<Goods>();

        Cashier cs1 = new Cashier("Georgi", "Petkov");
        Cashier cs2 = new Cashier("Dimitar", "Ivanov");
        Cashier cs3 = new Cashier("Ivan", "Stoyanov");
        List<Cashier> listOfCashiers = new ArrayList<Cashier>();
        listOfCashiers.add(cs1);
        listOfCashiers.add(cs2);
        listOfCashiers.add(cs3);

        Store store = new Store(listOfCashiers, 213);
        store.addToStorage(goods, 10);
        store.addToStorage(goods1, 5);
        Goods bate = new Goods(126, "bate", 2000, LocalDate.now());
        ShoppingCart cart = new ShoppingCart(store);
        ShoppingCart cart2 = new ShoppingCart(store);
        cart.addToShoppingCart(goods, 5);
        cart2.addToShoppingCart(goods1, 3);
        store.purchase(cart, "Stoyan");
        store.purchase(cart2, "Gosho");
        store.getStoreTotal();
    }
}
