package com.pluralsight;

import com.pluralsight.enums.ItemSize;

public class Juice extends BowlItem {
    private static final String[] TYPES = {"Orange Fresh", "Apple Crisp", "Carrot Ginger", "Beet Energy"};

    public Juice(ItemSize size, String type) {
        super(size, type);
    }

    public static String[] getTypes() {
        return TYPES;
    }

    @Override
    public double getPrice() {
        double price = getBasePrice() + getToppingsPrice();
        if (specialized) {
            price += 0.75;
        }
        return price;
    }

    @Override
    public String toString() {
        return "Juice - " + super.toString();
    }
}
