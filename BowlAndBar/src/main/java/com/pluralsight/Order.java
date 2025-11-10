package com.pluralsight;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<BowlItem> items;
    private List<Drink> drinks;
    private List<Side> sides;

    public Order() {
        this.items = new ArrayList<>();
        this.drinks = new ArrayList<>();
        this.sides = new ArrayList<>();
    }

}
