package com.pluralsight.objects;

public class Side {
    private String type;
    private static final double PRICE = 1.50;

    private static final String[] TYPES = {
            "Energy Bites", "Protein Bar"
    };

    public Side(String type) {
        this.type = type;
    }

    public static String[] getTYPES() {
        return TYPES;
    }

    public static double getPrice() {
        return PRICE;
    }

    @Override
    public String toString() {
        return type + " - $" + String.format("%.2f", getPrice());
    }
}
