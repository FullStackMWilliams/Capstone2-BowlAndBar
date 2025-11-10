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

    public void addItem(BowlItem item) {
        items.add(item);
    }

    public void addDrink(Drink drink) {
        drinks.add(drink);
    }

    public void addSide(Side side) {
        sides.add(side);
    }

    public boolean isEmpty() {
        return items.isEmpty() && drinks.isEmpty() && sides.isEmpty();
    }

    public boolean hasValidOrder() {
        if (items.isEmpty()) {
            return !drinks.isEmpty() || !sides.isEmpty();
        }
        return true;
    }

    public double getTotalPrice() {
        double total = 0.0;
        for (BowlItem item : items) {
            total += item.getPrice();
        }
        for (Drink drink : drinks) {
            total += drink.getPrice();
        }
        for (Side side : sides) {
            total += side.getPrice();
        }
        return total;
    }

}
