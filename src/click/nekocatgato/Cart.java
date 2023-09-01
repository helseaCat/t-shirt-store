package click.nekocatgato;

import java.util.ArrayList;

class Cart {
    private ArrayList<Product> items = new ArrayList<>();
    private double total;
    private double taxRate = 0.1;

    public void addItem(Product p){
        items.add(p);
        total+=p.getPrice();
        System.out.println(p.getName() + " has been added to your cart.");
    }

    public void showDetails(){

        if(items.isEmpty()){
            System.out.println("The cart is empty. Please add at least one product to see it in the cart.");
        }
        else{
            System.out.println("--Cart--\nItem Count: " + items.size() + "\nItems:");
            for(Product product : items){
                System.out.println(product.getName() + ": $" + String.format("%.2f", product.getPrice()));
            }
            System.out.println("\nPre-Tax Total: $" + String.format("%.2f", total));
            System.out.println("Post-Tax Total ("+ String.format("%.2f",taxRate*100)+"% Tax): $" + String.format("%.2f", (total+(total*taxRate))));
        }
    }

    public boolean checkout(){
        if(items.isEmpty()){return false;}
        System.out.println("Your total is $" + String.format("%.2f",(total+(total*taxRate))));
        empty();
        return true;
    }

    private void empty(){
        items.clear();
    }
}