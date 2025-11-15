package com.pluralsight.objects;

// This class will let us define our topping options

import com.pluralsight.enums.ItemSize;
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


    // Get Price method/ Switch cases for toppings/topping options and prices

    public double getPrice(ItemSize size) {
        double price = 0.0;

        switch (category) {
            case PROTEIN:
                if (extra) {
                    switch (size){
                        case SMALL: return 0.50;
                        case MEDIUM: return 1.00;
                        case LARGE: return 1.50;
                    }
                } else {
                    switch (size) {
                        case SMALL: return 1.00;
                        case MEDIUM: return 2.00;
                        case LARGE: return 3.00;
                    }
                }
                break;
            case PREMIUM:
                if (extra) {
                    switch (size) {
                        case SMALL: return 0.50;
                        case MEDIUM: return 1.00;
                        case LARGE: return 1.50;
                    }
                } else {
                    switch (size) {
                        case SMALL: return 1.00;
                        case MEDIUM: return 2.50;
                        case LARGE: return 3.25;
                    }
                }
                break;
            case REGULAR:
                if (extra) {
                    switch (size) {
                        case SMALL: return 0.25;
                        case MEDIUM: return 0.50;
                        case LARGE: return 0.75;
                    }
                }
                return 0.0;

            case CONDIMENT:
                if (extra) {
                    switch (size) {
                        case SMALL: return 0.20;
                        case MEDIUM: return 0.40;
                        case LARGE: return 0.60;
                    }
                }
                return 0.0;
        }

        return price;
    }

    @Override
    public String toString(){
        String result = name;
        if (extra) {
            result += " (Extra)";
        }
        return result;
    }
}
