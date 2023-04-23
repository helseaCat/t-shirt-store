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
        MenuOption option = MenuOption.fromOptionId(getNextIntFromUser());
        while(option != MenuOption.EXIT){
            handleShopperMenuOptionSelection(option);
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
            case LIST_PRODUCTS:
                shop.printProducts();
                printMenu();
                option.fromOptionId(getNextIntFromUser());
                break;
            case BUY_PRODUCT:
                addToCart();
                printMenu();
                option.fromOptionId(getNextIntFromUser());
                break;
            case FIND_PRODUCT:
                findProduct();
                printMenu();
                option.fromOptionId(getNextIntFromUser());
                break;
            case SHOW_CART:
                cart.showDetails();
                printMenu();
                option.fromOptionId(getNextIntFromUser());
                break;
            case CHECKOUT:
                cart.checkout();
                printMenu();
                option.fromOptionId(getNextIntFromUser());
                break;
            default:
                System.out.println("Invalid Input.");
                printMenu();
                option.fromOptionId(getNextIntFromUser());
                break;
        }
    }

    /**
     * Skips a line of empty input from the scanner's input stream
     * and then returns the next available line.
     * @return string representing the line of input typed by the user
     */
    private String getNextStringLineFromUser() {
        scanner.nextLine();
        return scanner.nextLine();
    }

    /**
     * Prints the menu header and menu options.
     */
    private void printMenu() {
        System.out.println("\n--Main Menu--\nSelect an option using one of the numbers shown\n");
        int i = 0;
        for (MenuOption options : MenuOption.values()) {
            String[] ins = options.toString().split("_");
            if(ins.length == 2){
                String front = ins[0].substring(0, 1) + ins[0].substring(1).toLowerCase();
                String back = ins[1].substring(0, 1) + ins[1].substring(1).toLowerCase();
                System.out.printf("%d: %s %s%n", i, front, back);
            }
            else {
                System.out.printf("%d: %s%n", i, ins[0].substring(0, 1) + ins[0].substring(1).toLowerCase());
            }
            i++;
        }
    }

    private void findProduct(){
        System.out.println("Enter the item to search for:");
        String itemToFind = getNextStringLineFromUser();
        int result = shop.findProduct(itemToFind);
        if(result == -1){
            System.out.println("That product was not found.");
        } else {
            System.out.println(itemToFind + " was found and its product id is " + result);
        }
    }

    private void addToCart(){
        System.out.println("Please enter the ID of the product you would like to purchase:");
        Product product = shop.findProductByID(getNextIntFromUser());
        if(product == null){
            System.out.println("That item ID is invalid and could not be added to the cart.");
        }
        else {
            cart.addItem(product);
        }
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
//        int ins = -1;
//        do{
//            try{
//                ins = scanner.nextInt();
//            }
//            catch(InputMismatchException e){
//                System.out.println("Invalid Input.");
//            }
//            scanner.nextLine();
//        }while (ins > 5 || ins < 0);
//        return ins;
    }
}
