package com.pluralsight;

import com.pluralsight.enums.ItemSize;
import com.pluralsight.enums.ToppingCategory;
import com.pluralsight.inheriters.BowlItem;
import com.pluralsight.inheriters.Juice;
import com.pluralsight.inheriters.Smoothie;
import com.pluralsight.inheriters.YogurtBowl;
import com.pluralsight.objects.*;

import javax.swing.text.Style;
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

        while (running) {
            displayHomeScreen();
            int choice = getIntInput("Select an option: ");

            switch (choice) {
                case 1: startNewOrder();
                case 0: running = false;
                    System.out.println("\nThank you for visiting Bowl & Bar!");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
        scanner.close();
    }

    private void displayHomeScreen() {
        System.out.println("\n======================================");
        System.out.println("HOME SCREEN");
        System.out.println("1) New Order");
        System.out.println("0) Exit");
        System.out.println("========================================");

    }

    private void startNewOrder() {
        currentOrder = new Order();
        displayOrderScreen();
    }

    private void displayOrderScreen() {
        boolean orderActive = true;

        while (orderActive) {
            System.out.println("\n============================================");
            System.out.println("ORDER SCREEN");
            System.out.println("==============================================");
            System.out.println("1) Add Item (Smoothie/Juice/Bowl)");
            System.out.println("2) Add Drink");
            System.out.println("3) Add Main Side");
            System.out.println("4) Checkout");
            System.out.println("0) Cancel Order");
            System.out.println("===============================================");

        }
    }


    private void addItem() {
        System.out.println("\n================================================");
        System.out.println("ADD ITEM");
        System.out.println("===================================================");
        System.out.println("Select item type:");
        System.out.println("1) Smoothie");
        System.out.println("2) Juice");
        System.out.println("3) Yogurt Bowl");
        System.out.println("0) Cancel");

    }

     private void addDrink() {
         System.out.println("\n====================================");
         System.out.println("ADD DRINK");
         System.out.println("=======================================");

         String[] flavors = Drink.getFlavors();
         System.out.println("Select flavor:");
     }

     private void addSide() {
         System.out.println("\n======================================");
         System.out.println("ADD MAIN SIDE");
         System.out.println("=========================================");

     }

     private boolean checkout() {

        if (currentOrder.isEmpty()) {
            System.out.println("\nYour order is empty! Please add item to checkout.");
            return false;
        }

        if (!currentOrder.hasValidOrder()) {
            System.out.println("\nIf you don't order any items, you must purchase a side or drink.");
            return false;
        }

         System.out.println(currentOrder);

         System.out.println("\nConfirm order? (y/n): ");
         String confirm = scanner.nextLine().trim().toLowerCase();

         if(confirm.equals("y") || confirm.equals("yes")) {

             ReceiptWriter.writeReceipt(currentOrder);
             System.out.println("\n Order confirmed! Thank you for your purchased!");
             currentOrder = null;

         } else
             System.out.println("Order ");
         return false;
     }

     private Smoothie createSmoothie() {

         String[] types = Smoothie.getTypes();
         System.out.println("\nSelect smoothie type:");
         for (int i = 0; i < types.length; i++) {
             System.out.println((i + 1) + ") " + types[i]);
         }

         int typeChoice = getIntInput("Choose: ") - 1;
         if (typeChoice < 0 || typeChoice >= types.length) {
             System.out.println("Invalid selection.");
             return null;
         }

         return null;
     }

     private Juice createJuice() {

        String[] types = Juice.getTypes();
         System.out.println("\nSelect juice type:");
         for(int i = 0; i < types.length; i++) {
             System.out.println((i + 1) + ")" + types[i]);
         }

         int typeChoice = getIntInput("Choose: ") -1;
         if (typeChoice < 0 || typeChoice >= types.length) {
             System.out.println("Invalid selection.");
             return null;
         }
         return null;
     }

     private YogurtBowl createYogurtBowl() {

        String[] types = YogurtBowl.getTypes();
         System.out.println("\nSelect yogurt base:");
         for (int i = 0; i < types.length; i++) {
             System.out.println((i + 1) + ") " + types[i]);
         }

         int typeChoice = getIntInput("Choose:");
         if (typeChoice < 0 || typeChoice >= types.length) {
             System.out.println("Invalid selection.");
             return null;
         }
         return null;
     }

     private ItemSize selectSize() {
         System.out.println("\nSelect size:");
         System.out.println("1) Small - $");
         System.out.println("2) Medium - $");
         System.out.println("3) Large - $");

         int sizeChoice = getIntInput("Choose: ");
         switch (sizeChoice) {
             case 1: return ItemSize.SMALL;
             case 2: return ItemSize.MEDIUM;
             case 3: return ItemSize.LARGE;
             default:
                 System.out.println("Invalid size.");
                 return null;
         }
     }

     private void addToppingCategory(BowlItem item, String categoryName, String[] options, ToppingCategory category) {
         System.out.println("\n" + categoryName + ":");

         for (int i = 0; i < options.length; i++) {
             System.out.println((i + 1) + ") " + options[i]);
         }
         System.out.println("0) Done");

         while (true) {
             int choice = getIntInput("Add topping (or 0 when done): ") -1;

             if (choice == -1) break;

             if (choice >= 0 && choice < options.length) {
                 item.addTopping(new Topping(options[choice], category, false ));
                 System.out.println("Added " + options[choice]);

                 if (category == ToppingCategory.REGULAR || category == ToppingCategory.PREMIUM || category == ToppingCategory.PROTEIN) {
                     System.out.println("Would you like etra? (y/n): ");
                     String extra = scanner.nextLine().trim().toLowerCase();
                     if (extra.equals("y") || extra.equals("yes")) {
                         item.addTopping(new Topping(options[choice],category,true ));
                         System.out.println("Added extra " + options[choice]);
                     }
                 } else {
                     System.out.println("Invalid selection");
                 }
             }
         }
     }

     private int getIntInput(String prompt) {
         System.out.println(prompt);

         while (!scanner.hasNextInt()) {
             scanner.nextLine();
             System.out.println("Please enter a valid number");
         }

         int value = scanner.nextInt();
         scanner.nextLine();
         return value;
     }
}