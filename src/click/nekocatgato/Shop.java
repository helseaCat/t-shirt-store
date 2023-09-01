package click.nekocatgato;

import java.util.ArrayList;

/**
 * Shop class is responsible for storing the full inventory of products.
 * The class also holds a method that prints a formatted list of products
 * using the printProducts method. Another useful method is findProduct
 * which linearly searches the products array for a match. Note that
 * findProduct is case-sensitive at this point in production.
 */
public class Shop {

    private String name;
    private ArrayList<Product> products;
    private Cart cart;

    public Shop(){
    }

    /**
     * Class constructor, which expects a String array.
     * It allows for the owner to pass products as data
     * to be stored in products array.
     * @param name String containing store name.
     * @param products contains data on inventory.
     */
    public Shop(String name, ArrayList<Product> products) {
        this.name = name;
        this.products = products;
    }

    public String getName() {
        return name;
    }

    /**
     * Formats products into a uniform list.
     * Prints the list of product currently loaded into product array.
     */
    public void printProducts(){
        System.out.println("--Products--");
        for (Product product : products) {
            System.out.println("ID " + product.getID() + ": " + product.getName() + " - $" + String.format("%.2f", product.getPrice()));
        }
    }

    /**
     * Basic search functionality for products.
     * @param searchText takes user input and looks for match.
     * @return integer value of ID for found product or -1 if not found.
     */
    public int findProduct(String searchText){
        for (Product product : products) {
            if ((product.getName()).equals(searchText)) {
                return product.getID();
            }
        }
        return -1;
    }

    public Product findProductByID(int id){
        for(Product product : products) {
            if (product.getID() == id) {
                return product;
            }
        }
        return null;
    }
}

