package com.pluralsight;

// This class will let us define our topping options

import com.pluralsight.enums.ToppingCategory;

public class Topping {
    private String name;
    private ToppingCategory category;
    private boolean extra;

    public Topping (String name, ToppingCategory category, boolean extra) {
        this.name = name;
        this.category = category;
        this.extra = extra;
    }

    public String getName() {
        return name;
    }

    public ToppingCategory getCategory() {
        return category;
    }

    public boolean isExtra() {
        return extra;
    }

    //  Switch cases for toppings/topping options and prices
}
