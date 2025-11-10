package com.pluralsight.enums;

public enum ItemSize {
    SMALL(1),
    MEDIUM(2),
    LARGE(3);

    private final int value;

    ItemSize(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
