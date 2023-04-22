package com.ata;

public enum MenuOption {
    EXIT(1,"Exit"),
    LIST_PRODUCTS(2,"List Products"),
    BUY_PRODUCT(3, "Buy Product"),
    FIND_PRODUCT(4, "Find Product"),
    SHOW_CART(5, "Show Cart"),
    CHECKOUT(6, "Checkout");
    private int id;
    private String displayValue;

    public int getId() {
        return id;
    }

    public String getDisplayValue() {
        return displayValue;
    }

    MenuOption(int id, String displayValue){
    }
}

