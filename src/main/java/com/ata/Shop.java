package main.java.com.ata;

/**
 * Shop class is responsible for storing the full inventory of products.
 * The class also holds a method that prints a formatted list of products
 * using the printProducts method. Another useful method is findProduct
 * which linearly searches the products array for a match. Note that
 * findProduct is case-sensitive at this point in production.
 */
public class Shop {

    private Product[] products;

    public Shop(){

    }

    /**
     * Class constructor, which expects a String array.
     * It allows for the owner to pass products as data
     * to be stored in products array.
     * @param products contains data on inventory.
     */
    public Shop(Product[] products) {
        this.products = products;
    }

    /**
     * Formats products into a uniform list.
     * Prints the list of product currently loaded into product array.
     */
    public void printProducts(){
        System.out.println("--Products--");

        for(int i = 0; i < products.length; i++) {
            System.out.println("ID " + i + ": " + products[i].getName() + " - $" + String.format("%.2f",products[i].getPrice()));
        }

    }

    /**
     * Basic search functionality for products.
     * @param searchText takes user input and looks for match.
     * @return integer value of index for found product or -1 if not found.
     */
    public int findProduct(String searchText){
        for(int i = 0; i < products.length; i++){
            if((products[i].getName()).equals(searchText)){
                return i;
            }
        }
        return -1;
    }
}

