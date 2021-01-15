package com.codedifferently;

import org.apache.log4j.Logger;
import org.apache.commons.io.IOUtils;

import java.util.*;



public class Main {

    private final static Logger logger = Logger.getLogger(Main.class);

      public String readRawDataToString() throws Exception {
          try {
              ClassLoader classLoader = getClass().getClassLoader();
              String result = IOUtils.toString(classLoader.getResourceAsStream("RawData.txt"));
              return result;
          } catch (Exception e) {
              System.out.println("In readRawDataToString Something went wrong in RawData Read");
          }
          return null;
      }

    public static void  main(String[] args) throws Exception {

        String output = (new Main()).readRawDataToString();
        System.out.println("raw data from file output "+ output);

        //DataReader stores each shopping list entry in the cleandedDataArray and stores them in the following format
        //name:milk;price:3.23;type:food;expiration:1/25/2016
        //name:bread;price:1.23;type:food;expiration:1/02/2016
        // etc
        String[] cleanedDataArray = DataReader.rawDataReader(output);


        //Parser takes each grocery list item and places them in itemList in the following format
        // name milk (also the key)
        // price 3.23
        // type food
        // expiration 1/25/2016
        //etc (for each grocery list item)

        System.out.println("In Main " +
                "Process each list item from cleanedDataArray entering parser.makeItemList");
        Parser parser = new Parser();
        List<Item> itemList = parser.makeItemList(cleanedDataArray);

        for (int i = 0; i < itemList.size(); i++)
         {System.out.println("In Main itemList " + " i = " + i + " "+ itemList.get(i));}

        Set<String> setOfKnownItemKeysAsName = new HashSet<>();

        System.out.println("In Main Name of the item "  + itemList);
        for(Item item : itemList){
            setOfKnownItemKeysAsName.add(item.getName());
            System.out.println("In Main For loop Name of the item " + item+item.getName());
        }
        System.out.println("In Main Item list" + itemList);

        int numberOfErrors = parser.getErrorCounter();
        var printer = new Printer(itemList);
        Map<String, ArrayList<String>> groceryCount = printer.getItemCount();

        //ArrayList<String> milkPriceList = groceryCount.get("milk");
        for(String keyNameOfItem : setOfKnownItemKeysAsName){
            int counterOfItem = groceryCount.get(keyNameOfItem).size();
            System.out.println(keyNameOfItem + ": " + counterOfItem);
            System.out.println(ItemStringFormatter.createColumnString(keyNameOfItem, counterOfItem));

            HashMap<String, Integer> pricesOccurances = new HashMap<String, Integer>();
            for(String price: groceryCount.get(keyNameOfItem)){
                pricesOccurances.put(price, pricesOccurances.get(price) != null ? pricesOccurances.get(price) + 1 : 1 );
                System.out.println(ItemStringFormatter.createColumnString(price,pricesOccurances.get(price)));
            }
        }
    }
}


