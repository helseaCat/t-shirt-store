package com.ata;

/**
 * Shop class is responsible for storing the full inventory of products.
 * The class also holds a method that prints a formatted list of products
 * using the printProducts method. Another useful method is findProduct
 * which linearly searches the products array for a match. Note that
 * findProduct is case-sensitive at this point in production.
 */
public class Product {

    private int id;
    private String name;
    private double price;

    /**
     * Class constructor, which expects a String array.
     * It allows for the owner to pass products as data
     * to be stored in products array.
     * @param name contains inventory name.
     * @param price contains USD price of item.
     */
    public Product(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public int getID() {
        return id;
    }

    public String getName(){
        return this.name;
    }

    public double getPrice(){
        return this.price;
    }
}
