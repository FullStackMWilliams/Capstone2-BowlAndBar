package com.pluralsight;

import com.pluralsight.enums.DrinkSize;

public class Drink {
    private DrinkSize size;
    private String flavor;

    private static final String[] Flavors = {
            "Water", "Coconut water", "Lemonade", "Iced tea", "Kombucha"
    };

    public Drink(DrinkSize size, String flavor) {
        this.size = size;
        this.flavor = flavor;
    }

    public static String[] getFlavors() {
        return Flavors;
    }

    public double getPrice() {
        return size.getPrice();
    }

    @Override
    public String toString() {
        return size + " " + flavor + " - $" + String.format("%.2f", getPrice());
    }
}
