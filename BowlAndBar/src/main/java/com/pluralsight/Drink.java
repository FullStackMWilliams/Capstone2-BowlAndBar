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
}
