package com.kiddyenterprise.Domain;

/**
 * POJO OBJECT FOR TESTING PURPOSES
 */
public class Item {
    private int itemID;
    private String name;
    private Float price;

    public Item(){
        //Constructor for jackson
    }

    public Item(int itemID, String name, Float price){
        this.itemID = itemID;
        this.name = name;
        this.price = price;
    }

    public int getItemID() {
        return itemID;
    }

    public String getName() {
        return name;
    }

    public Float getPrice() {
        return price;
    }
}