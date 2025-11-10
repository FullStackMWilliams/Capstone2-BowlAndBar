package com.pluralsight.enums;

// this class will help us


import com.pluralsight.BowlItem;

public class YogurtBowl extends BowlItem {
    private static final String[] TYPES = {"Greek Yogurt","Vanilla Yogurt","Coconut Yogurt", "Plain Yogurt"};

    public YogurtBowl(ItemSize size,String type) {
        super(size, type);
    }
    public static String[] getTypes() {
        return TYPES;
    }
}
