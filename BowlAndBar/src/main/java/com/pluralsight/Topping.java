package com.pluralsight;

// This class will let us define our topping options

import com.pluralsight.enums.ItemSize;
import com.pluralsight.enums.ToppingCategory;

import static com.pluralsight.enums.ToppingCategory.PREMIUM;

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
                        case SMALL: return 0.30;
                        case MEDIUM: return 0.60;
                        case LARGE: return 0.90;
                    }
                } else {
                    switch (size) {
                        case SMALL: return 0.75;
                        case MEDIUM: return 1.50;
                        case LARGE: return 2.25;
                    }
                }
                break;
            case REGULAR:
            case CONDIMENT:
                return 0.0;
        }

        return price;
    }

    @Override
    public String toString(){
        String result = name;
        if(extra) {
            result += " (Extra)";
        }
        return result;
    }
}
