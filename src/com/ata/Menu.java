package com.ata;

import java.util.Scanner;

/**
 * Menu class is responsible for greeting the user, showing a menu
 * to the user for interaction with the application.
 * The class maintains a String[] array of menu options, which it
 * uses for printing the menu to standard out.
 * The class is also responsible for responding to user interaction
 * with respect to its menu.
 */
public class Menu {
    private Cart cart = new Cart();
    private Shop shop;
    private Scanner scanner;

    /**
     * Class constructor, which expects a Scanner object
     * It allows for the user to specify how a Scanner is to
     * be configured outside this class and for basic inversion of control.
     * @param scanner takes in a Scanner object to initialize
     */
    public Menu(Scanner scanner, Shop shop) {
        this.scanner = scanner;
        this.shop = shop;
    }

    /**
     * Prints the menu to standard output, using the class's menuOptions array.
     * It accepts user input using the encapsulated Scanner instance.
     * All output is printed to standard out.
     * All input is collected from standard in.
     */
    public void executeMenu() {
        printMenu();
        MenuOption option = null;
        option = option.fromOptionId(getNextIntFromUser());
        while(option != MenuOption.EXIT){
            handleShopperMenuOptionSelection(option);
            option = option.fromOptionId(getNextIntFromUser());
        }
        System.out.println("Exiting now. Goodbye.");
        exit();
    }

    /**
     * Asks the user to enter their name.
     * After the user provides their name, it outputs a greeting to the user to standard out.
     */
    public void greet() {
        System.out.println("Hello. Please enter your name:");
        String name = scanner.nextLine();
        System.out.println("Welcome " + name + " to " + shop.getName());
    }


    private void handleShopperMenuOptionSelection(MenuOption option) {

        switch (option){
            case EXIT:
            case CHECKOUT:
            case SHOW_CART:
            case BUY_PRODUCT:
            case FIND_PRODUCT:
            case LIST_PRODUCTS:
            default:
                System.out.println("Invalid Input.");
        }

//        if(option.equals(null)){
//            System.out.println("Invalid Input.");
//        }
//        else if(option.equals(MenuOption.LIST_PRODUCTS)) {
//            shop.printProducts();
//        }
//        else if(option.equals().MenuOption.() == 2){
//        System.out.println("Please enter the ID of the product you would like to purchase:");
//        Product product = shop.findProductByID(getNextIntFromUser());
//        if(product == null){
//            System.out.println("That item ID is invalid and could not be added to the cart.");
//        }
//        else {
//            cart.addItem(product);
//        }
//    }
//        else if(option.equals().MenuOption.() == 3){
//        System.out.println("Enter the item to search for:");
//        String itemToFind = getNextStringLineFromUser();
//        int result = shop.findProduct(itemToFind);
//        if(result == -1){
//            System.out.println("That product was not found.");
//        } else {
//            System.out.println(itemToFind + " was found and its product id is " + result);
//        }
//    }
//        else if(option.equals().MenuOption.() == 4){
//        cart.showDetails();
//    }
//        else if(option.equals().MenuOption.() == 5){
//        if(cart.checkout()){
//            System.out.println("Thank you for shopping at " + shop.getName() + ".");
//        }
//        else {System.out.println("Your cart is currently empty. Please add at least one product to check out.");}
//    }
//        else {
//        System.out.println("Option " + option.equals().MenuOption.() + " was selected. Not yet implemented.");
//    }
        printMenu();
        option.equals().MenuOption.() = getNextIntFromUser();
    }

    private String getNextStringLineFromUser() {
        scanner.nextLine();
        return scanner.nextLine();
    }



    /**
     * Prints the menu header and menu options.
     */
    private void printMenu() {
        System.out.println("\n--Main Menu--\nSelect an option using one of the numbers shown\n");
        for (MenuOption options : MenuOption.values()) {
            System.out.print(options.MenuOption.() + ": " + options.getDisplayValue());
        }
    }

    private void findProduct(){

    }

    /**
     * Prints an exit statement and closes the scanner object.
     */
    private void exit() {
        scanner.close();
    }

    /**
     * Collects next user-entered int.
     * @return integer value denoting the user selection
     */
    private int getNextIntFromUser() {
        return scanner.nextInt();
    }

    /**
     * Skips a line of empty input from the scanner's input stream
     * and then returns the next available line.
     * @return string representing the line of input typed by the user
     */
}
