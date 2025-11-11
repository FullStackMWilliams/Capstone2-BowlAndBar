package com.pluralsight.inheriters;

// this class will help us


import com.pluralsight.enums.ItemSize;

public class YogurtBowl extends BowlItem {
    private static final String[] TYPES = {"Greek Yogurt","Vanilla Yogurt","Coconut Yogurt", "Plain Yogurt"};

    public YogurtBowl(ItemSize size, String type) {
        super(size, type);
    }
    public static String[] getTypes() {
        return TYPES;
    }

    @Override
    public double getPrice() {
        double price = getBasePrice() + getToppingsPrice();
        if (specialized) {
            price += 1.25;
        }
        return price;
    }

    @Override
    public String toString() {
        return "Yogurt Bowl - " + super.toString();
    }
}
