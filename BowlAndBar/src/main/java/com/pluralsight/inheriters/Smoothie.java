package com.pluralsight.inheriters;

import com.pluralsight.enums.ItemSize;

public class Smoothie extends BowlItem {
    private static final String[] TYPES =  {"Berry Blast", "Tropical Paradise","Green Machine","Chocolate PeanutButter"};

    public Smoothie (ItemSize size, String type) {
        super(size, type);
    }

    public static String[] getTypes() {
        return TYPES;
    }

    @Override
    public double getPrice() {
        double price = getBasePrice() + getToppingsPrice();
        if (specialized) {
            price += 1.00;
        }
        return price;
    }

    @Override
    public String toString() {
        return "Smoothie - " + super.toString();
    }
}
