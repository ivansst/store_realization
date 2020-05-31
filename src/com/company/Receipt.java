package com.company;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Receipt {
    private static int id = 0;
    private Cashier cashier;
    private static String dateTime = "";
    private List<Goods> goods;
    private double total = 0;

    public Receipt(Cashier cashier, List<Goods> goods) {
        this.cashier = cashier;
        this.goods = goods;
        id++;
        dateTime = formatDate();
    }

    private String formatDate(){
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

        return now.format(formatter);
    }

    public double getTotal(){
        for(Goods items : this.goods){
            total += items.getPrice();
        }

       return total;
    }

    public String getCashier(){
        return cashier.getFullName();
    }

    public void generateReceipt(){
        FileCreator file = new FileCreator("D:", id);
        file.createFile();
        file.writeToFile(dateTime, getCashier(), goods, getTotal());
        file.readFromFile();
    }
}
