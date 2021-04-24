package com.example.shoppinglist;

import android.util.Log;

public class Items {
    private String shop;
    private float price = 0;
    private String name;
    private int quantity;
    public Items(String shop, String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
        this.shop = shop;

        Log.i("Msg", "Itemstats: " + this.name + " " + this.quantity + " " + this.shop);
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getShop() {
        return shop;
    }
}
