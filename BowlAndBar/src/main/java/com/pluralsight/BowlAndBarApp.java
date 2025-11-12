package com.pluralsight;

import com.pluralsight.objects.Order;

import java.util.Scanner;


public class BowlAndBarApp {


    private Scanner scanner;
    private Order currentOrder;

    private static final String[] PROTEINS = {
            "Peanut Butter", "Almond Butter", "Protein Powder", "Hemp Seeds", "Chia Seeds", "Greek Yogurt"
    };

    private static final String[] PREMIUM_TOPPINGS = {
            "Acai", "Pitaya", "Matcha", "Spirulina"
    };

    private static final String[] REGULAR_TOPPINGS = {
            "Apple", "Banana", "Strawberry", "Blueberry", "Mango", "Pineapple", "Granola","Coconuts Flakes","Honey","Cacao Nibs"
    };

    private static final String[] CONDIMENTS = {
            "Agave Syrup", "Maple Syrup", "Cinnamon", "Vanilla extract", "Coco powder", "Mint"

    };

    public BowlAndBarApp() {
        scanner = new Scanner(System.in);
        currentOrder = null;
    }


    public static void main(String[] args) {
        BowlAndBarApp app = new BowlAndBarApp();
        app.run();
    }

    public void run() {

        System.out.println("\n======================================");
        System.out.println("|        WELCOME TO BOWL & BAR!        |");
        System.out.println("|    Fresh Smoothies, Juices & Bowls   |");
        System.out.println("|                                      |");
        System.out.println("========================================");

        boolean running = true;


    }

    private void displayHomeScreen() {
        System.out.println("\n======================================");
        System.out.println("HOME SCREEN");
        System.out.println();

    }
}


