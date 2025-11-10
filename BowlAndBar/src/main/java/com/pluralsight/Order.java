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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n===================================\n");
        sb.append("          BOWL & BAR ORDER           \n");
        sb.append("=======================================");

        if (!items.isEmpty()) {
            sb.append("ITEMS:\n");
            sb.append("-----------------------------------\n");
            for (int i = 0; i < items.size(); i++) {
                sb.append((i + 1)).append(". ").append(items.get(i)).append("\n");
                sb.append("   Price: $").append(String.format("%.2f", items.get(i).getPrice())).append("\n\n");
            }
        }
        if (!drinks.isEmpty()) {
            sb.append("DRINKS:\n");
            sb.append("--------------------------------------\n");
            for (int i = 0; i < drinks.size(); i++) {
                sb.append((i + 1)).append(". ").append(drinks.get(i)).append("\n");
            }
            sb.append("\n");
        }
        if (!sides.isEmpty()) {
            sb.append("SIDES: \n");
            sb.append("-----------------------------------------\n");
            for (int i = 0; i < sides.size(); i++) {
                sb.append((i + 1)).append(". ").append(sides.get(i)).append("\n");
            }
            sb.append("\n");
        }

        sb.append("===============================================\n");
        sb.append("TOTAL: $").append(String.format("%.2f", getTotalPrice())).append("\n");
        sb.append("===============================================\n");

        return sb.toString();
    }
}