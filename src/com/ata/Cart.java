package com.ata;

import java.util.ArrayList;

class Cart {
    private ArrayList<Product> items = new ArrayList<>();
    private double total;
    private double taxRate;

    public void addItem(Product p){
        items.add(p);
    }

    public void showDetails(){
    }

    public boolean checkout(){
        return false;
    }
}