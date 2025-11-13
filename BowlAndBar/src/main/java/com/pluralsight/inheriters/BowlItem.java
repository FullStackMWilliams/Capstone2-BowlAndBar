package com.pluralsight.inheriters;

import com.pluralsight.objects.Topping;
import com.pluralsight.enums.ItemSize;

import java.util.ArrayList;
import java.util.List;

public abstract class BowlItem {
    protected ItemSize size;
    protected String type;
    protected List<Topping> toppings;
    protected boolean specialized;

    public BowlItem(ItemSize size, String type) {
        this.size = size;
        this.type = type;
        this.toppings = new ArrayList<>();
        this.specialized = false;
    }

    public ItemSize getSize() {
        return size;
    }

    public String getType() {
        return type;
    }

    public void addTopping(Topping topping) {
        toppings.add(topping);
    }

    public void setSpecialized(boolean specialized) {
        this.specialized = specialized;
    }

    public abstract double getPrice();

    protected double getBasePrice() {
        switch (size) {
            case SMALL: return 4.50;
            case MEDIUM: return 6.35;
            case LARGE: return 8.50;
            default: return 0.0;
        }
    }

    protected double getToppingsPrice() {
        double total = 0.0;
        for (Topping topping : toppings) {
            total += topping.getPrice(size);
        }
        return total;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(size).append(" ").append(type);
        if (specialized) {
            sb.append(" (Specialized)");
        }
        if (!toppings.isEmpty()) {
            sb.append("\n Toppings:");
            for (Topping topping : toppings) {
                sb.append("\n     - ").append(topping);
            }
        }
        return sb.toString();
    }
}
