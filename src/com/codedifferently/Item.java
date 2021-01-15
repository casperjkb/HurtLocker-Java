package com.codedifferently;
import java.util.Map;

public class Item {

    private String name;
    private String price;
    private String type;
    private String expiration;
    public int count;

    public Item(Map<String,String> rawDataMap){
        this.name = rawDataMap.get("name");
        this.price = rawDataMap.get("price");
        this.type = rawDataMap.get("type");
        this.expiration = rawDataMap.get("expiration");

        System.out.println("Item: In Item name = " + this.name);
        System.out.println("Item: In Item price = " + this.price);
        System.out.println("Item: In Item type = " + this.type);
        System.out.println("Item: In Item expiration = " + this.expiration);
    }

    public String getName() {
        System.out.println("Item: In Item getName = " + name);
        return name;
    }

    public void setName(String name) {
        System.out.println("In Item setName = " + name);
        this.name = name;
    }

    public String getPrice() {
        System.out.println("In Item getPrice = " + price);
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getType() {
        System.out.println("In Item getType = " + type);
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getExpiration() {
        System.out.println("In Item getExpiration = " + expiration);
        return expiration;
    }

    public void setExpiration(String expiration) {
        this.expiration = expiration;
    }

    public String toString(){
        return name + " " + price + " " + type + " " + expiration + " ";
    }



}

