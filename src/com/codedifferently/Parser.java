package com.codedifferently;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


import com.codedifferently.Item;
import exceptions.ItemCreationException;
import exceptions.ItemMissingKeyException;
import exceptions.ItemMissingValueException;

import java.util.*;

public class Parser {

    //take in cleaned data string from DataReader
    //separate at ; to get keys
    //set the map with keys for name, price, type, and expiration
    //set value based on :
    //fix c0okies by replacing zero

    private ArrayList<String> listOfKeys;


    private int errorCounter;

    public Parser() {
        listOfKeys = new ArrayList<>();
        listOfKeys.add("name");
        listOfKeys.add("price");
        listOfKeys.add("type");
        listOfKeys.add("expiration");
    //ListOfKeys is initialized here. No additions are made.

    }

    public List<Item> makeItemList(String[] cleanedDataArray) throws Exception {
        List<Item> itemsList = new ArrayList();
        System.out.println("In Parser.makeItemList Process each list item in cleaned DataArray");
        // Take a grocery list i.e. name:milk;price:3.23;type:food;expiration:1/25/2016
        // pass to makeItemfromString to put pairs in a item i.e name milk price 3.23 type food expiration 1/25/2016
        // that will be added to an itemList
        for (String cleanedData : cleanedDataArray) {
            System.out.println("In Parser.makeItemList cleanedData = " + cleanedData);
            Item item = makeItemFromString(cleanedData);
            System.out.println("In Parser.makeItemList Add Item to itemsList" + item);
            if (item != null) {
                itemsList.add(item);
            }
            System.out.println("\n");
        }

        return itemsList;

    }

    public Item makeItemFromString(String cleanedData) throws Exception {
        HashMap<String, String> itemData = new HashMap<>();
        try {
            System.out.println("In Parser.makeItemFromString. ListOfKeys length =  "+ listOfKeys.toArray().length);
            System.out.println("In Parser.makeItemFromString. ListOfKeys length =  "+ listOfKeys);
            //List of keys contains name,price,type,expiration which are elements of grocery list
            for (String key : listOfKeys) {
                System.out.println("In Parser.makeItemFromString key from ListOfKeys " + key);
                // find grocery item i.e. name and its value i.e. name milk and put in itemData Hash
                String value = findFieldByKeyValue(key, cleanedData);
                System.out.println("In Parser.makeItemFromString key: " + key + " value: " + value);
                itemData.put(key, value);
                System.out.println("In Parser.makeItemFromString get itemData " + key + "value =" + itemData.get(key));
            }
            System.out.println("In Parser.makeItemFromString print all itemData" + itemData);
            return new Item(itemData);

        } catch (ItemMissingKeyException exception) {
            System.out.println("MissingKeyException");
            //return null;
        } catch (ItemMissingValueException exception) {
            System.out.println("MissingValueException");
            //return null;
        }
        return new Item(itemData);

    }


    public String findFieldByKeyValue(String key, String cleanedData) throws Exception {

        String[] dataArray = cleanedData.split(";");
        System.out.println("In Parser.findFieldByKeyValue show dataArray after split on regex;");
        for (int i = 0; i < 4; i++) {
        System.out.println("In Parser.findFieldByKeyValue dataArray = " + dataArray[i] );}


        //Take the cleanedData String/Array
        //and Get the Grocery List Item associated with the name key
        //name:milk;price:3.23;type:food;expiration:1/25/2016;
        //dataArray[0] = "name:milk"
        //dataArray[1] = "price:2.23" etc
        System.out.println("In Parser.findFieldByKeyValue set value to null");
        String value = null;
        int i=0;
        for (String item : dataArray) {
            System.out.println("In Parser.findFieldByKeyValue Grocery List item: " + item);
            String[] itemArray = item.split(":");
            //itemArray[0] = "name" itemArray[1] = "milk"
            //do for each pair in grocery list until the key is found i.e. name,price,type,expiration
            System.out.println("In Parser.findFieldByKeyValueitemArray[0]/[1]: " + itemArray[0] + " and "+ itemArray[1]);
            System.out.println("In Parser.findFieldByKeyValuelistOfKeys " + listOfKeys.contains(itemArray[0])+" " +listOfKeys.get(i++));

            if (listOfKeys.contains(itemArray[0])) {
            //A key name i.e. price was found in grocery list
            // if length < 2 there is no value wih it throw exception
                if (itemArray.length < 2) {
                    errorCounter++;
                    throw new ItemMissingValueException();
                }
                // when then the key is found i.e. price return the value associate with it

                System.out.println("In Parser.findFieldByKeyValue Found key value " + key + itemArray[0]+itemArray[1]);
                System.out.println("In Parser.findFieldByKeyValue Found key value " + key +" " + itemArray[0]);

                if  (itemArray[0].equals(key)) {
                    value = itemArray[1];
                    System.out.println("In Parser.findFieldByKeyValue Found and set key value " + key + value);
                   }

            } else {
                errorCounter++;
                throw new ItemMissingKeyException();
            }
        }
        System.out.println("In Parser.findFieldByKeyValue return value " + value);
        return value;
    }

        public int getErrorCounter () {
            return errorCounter;
        }

    }

