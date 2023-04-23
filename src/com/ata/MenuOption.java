package com.ata;

public enum MenuOption {
    EXIT, LIST_PRODUCTS, BUY_PRODUCT, FIND_PRODUCT, SHOW_CART, CHECKOUT;
    private int id;
    private String displayValue;

    public int getId() {
        return id;
    }

    public String getDisplayValue() {
        return displayValue;
    }

    static MenuOption fromOptionId(int optionId){
        switch (optionId){
            case 0:
                return EXIT;
            case 1:
                return LIST_PRODUCTS;
            case 2:
                return BUY_PRODUCT;
            case 3:
                return FIND_PRODUCT;
            case 4:
                return SHOW_CART;
            case 5:
                return CHECKOUT;
            default:
                return null;
        }
    }
}

