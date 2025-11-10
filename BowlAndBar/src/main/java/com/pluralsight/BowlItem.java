package com.pluralsight;

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

    }
}
