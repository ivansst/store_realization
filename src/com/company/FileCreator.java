package com.company;

import java.io.*;
import java.util.List;

public class FileCreator {
    private String fileName;
    private String finalName;

    public FileCreator(int fileName) {
        this.fileName = String.valueOf(fileName);
        finalName = fileName + ".txt";
    }

    public void createFile(){
        try {
            var myObj = new File(finalName);
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File already exists.");
            }
        }
        catch (IOException e) {
            System.out.println("An error occurred.");
        }
    }

    public void writeToFile(String dateTime, String cashier, List<Goods> goods, double total){
        try(FileWriter myWriter = new FileWriter(finalName)) {
            StringBuilder goodsString = new StringBuilder();
            for (Goods good: goods) {
                if(goodsString.length() > 0)
                    goodsString.append(", ");
                goodsString.append(good.getName());
            }

            myWriter.write("This receipt's number is " + fileName + "\n" +
                                "Today's date is " + dateTime + "\n" +
                                "Current working cashier is " + cashier + "\n" +
                                "Your grocery list contains " + goodsString + "\n" +
                                "The total amount is " + total + " BGN");

        } catch (IOException e) {
            System.out.println("Could not create file!");
        }
    }
}
