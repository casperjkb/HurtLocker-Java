package com.codedifferently;

import com.codedifferently.Item;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Printer {

    private List<Item> itemList;

    public Printer(List<Item> itemList){
        this.itemList = itemList;
    }
    public Map<String, ArrayList<String>> getItemCount(){
        Map<String, ArrayList<String>> itemCount = new HashMap<>();
        System.out.println("In Printer. ");
        for(Item item:itemList){
            ArrayList<String> listOfPrices = itemCount.get(item.getName());
            System.out.println("In Printer. item = " + item + listOfPrices);
            if(listOfPrices == null){
                listOfPrices = new ArrayList<>();
                itemCount.put(item.getName(), listOfPrices);
                System.out.println("In Printer itemCount = " + itemCount);

            }
            listOfPrices.add(item.getPrice());
            System.out.println("In Printer. item = " +  listOfPrices);
        }
        return itemCount;
    }
}

