package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.*;

public class Main {

    public static void main(String[] args) throws CustomException {

        //TODO Fix fileReader in FileCreator

        Goods goods = new Goods(123, "banana", 200, LocalDate.now());
        Goods goods1 = new Goods(124, "blueberry", 240, LocalDate.now());
        Goods goods2 = new Goods(125, "apple", 260, LocalDate.now());

        Cashier cs1 = new Cashier("Peter", "Petkov");
        Cashier cs2 = new Cashier("Dimitar", "Ivanov");
        Cashier cs3 = new Cashier("Ivan", "Stoyanov");
        List<Cashier> listOfCashiers = new ArrayList<Cashier>();
        listOfCashiers.add(cs1);
        listOfCashiers.add(cs2);
        listOfCashiers.add(cs3);

        Store store = new Store(listOfCashiers);
        store.addToStorage(goods, 10);
        store.addToStorage(goods1, 5);
        store.addToStorage(goods2, 3);
        ShoppingCart cart = new ShoppingCart(store);
        ShoppingCart cart2 = new ShoppingCart(store);
        //ShoppingCart cart3 = new ShoppingCart(store);
        cart.addToShoppingCart(goods, 5);
        cart2.addToShoppingCart(goods1, 3);
        cart2.addToShoppingCart(goods2, 3);
        //cart3.addToShoppingCart(goods2, 5);
        store.purchase(cart, "Stoyan");
        store.purchase(cart2, "Gosho");
        //store.purchase(cart3, "Ivan");
        store.getStoreTotal();
        store.getIssuedReceipts();

        readFromFile(1);
        System.out.println("------------------------------------------");
        readFromFile(2);
    }

    //TODO Fix file reader
    public static void readFromFile(int fileNumber) throws CustomException {
        String fileName = fileNumber + ".txt";

        try (FileReader fReader = new FileReader(fileName)) {
            BufferedReader bReader = new BufferedReader(fReader);
            String line = bReader.readLine();
            while (line != null) {
                System.out.println(line);
                line = bReader.readLine();
            }
        } catch (IOException e) {
            throw new CustomException("There is no such file");
        }
    }
}
