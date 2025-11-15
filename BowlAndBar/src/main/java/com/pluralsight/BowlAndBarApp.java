package com.pluralsight;

import com.pluralsight.enums.DrinkSize;
import com.pluralsight.enums.ItemSize;
import com.pluralsight.enums.ToppingCategory;
import com.pluralsight.inheritors.BowlAndBarItem;
import com.pluralsight.inheritors.Juice;
import com.pluralsight.inheritors.Smoothie;
import com.pluralsight.inheritors.YogurtBowl;
import com.pluralsight.objects.*;

import java.util.Scanner;

// Main app class

public class BowlAndBarApp {


    // Initializing/ Declaring scanner and order class

    private final Scanner scanner;
    private Order currentOrder;


    // Imported toppings: PROTEINS, PREMIUM, REGULAR, and CONDIMENTS

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


    // Bowl and Bar app method

    public BowlAndBarApp() {
        scanner = new Scanner(System.in);  // Non-locale Scanner
        currentOrder = null; // Initializing current order var
    }


    // App entry point

    public static void main(String[] args) {
        BowlAndBarApp app = new BowlAndBarApp();
        app.run();
    }


    // Run method for app entry

    public void run() {


        // Printing Billboard display

        System.out.println("\n==========================================");
        System.out.println("|                                        |");
        System.out.println("|        WELCOME TO BOWL & BAR!          |");
        System.out.println("|    Fresh Smoothies, Juices & Bowls     |");
        System.out.println("|                                        |");
        System.out.println("==========================================");


        // Boolean var for validation to start app

        boolean running = true;


        // While statement for displaying home screen and I/O handling of customer's selection

        while (running) {

            displayHomeScreen(); // Printing home screen

            int choice = getIntInput("Select an option: "); // I/O handling

            switch (choice) {
                case 1:
                    startNewOrder();
                        break;

                case 0:
                    running = false;
                    System.out.println("\nThank you for visiting Bowl & Bar!");
                        break;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
        scanner.close();
    }


    // Display home Screen method

    private void displayHomeScreen() {


        // Printing Home Screen

        System.out.println("\n===============================");
        System.out.println("HOME SCREEN");
        System.out.println("===============================");
        System.out.println("1) New Order");
        System.out.println("0) Exit");
        System.out.println("===============================");
    }


    // Method to start new order

    private void startNewOrder() {
        currentOrder = new Order();
        displayOrderScreen();
    }


    // Order Screen method

    private void displayOrderScreen() {


        // Boolean var for order validation

        boolean orderActive = true;


        // While Statement for Order Screen

        while (orderActive) {
            System.out.println("\n===============================");
            System.out.println("ORDER SCREEN");
            System.out.println("===============================");
            System.out.println("1) Add Item");
            System.out.println("2) Add Drink");
            System.out.println("3) Add Main Side");
            System.out.println("4) Checkout");
            System.out.println("0) Cancel Order");
            System.out.println("=====================================");

            // I/O Handling for customer's order screen selection

            int choice = getIntInput("Select an option: ");


            // Switch statement for Order Screen selection

            switch (choice) {
                case 1:
                    addItem();
                    break;

                case 2:
                    addDrink();
                    break;

                case 3:
                    addSide();
                    break;

                case 4:
                    orderActive = !checkout();
                    break;

                case 0:
                    System.out.println("\nOrder cancelled.");
                    currentOrder = null;
                    orderActive = false;
                    break;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }


    // Add item method

    private void addItem() {


        // Validation for item selection

        boolean validSelection = false;


        // while statement to print Add item screen

        while (!validSelection) {
            System.out.println("\n================================");
            System.out.println("ADD ITEM");
            System.out.println("================================");
            System.out.println("Select item type:");
            System.out.println("1) Smoothie");
            System.out.println("2) Juice");
            System.out.println("3) Yogurt Bowl");
            System.out.println("0) Cancel");


            // I/O handling for customer's add item screen selection

            int itemType = getIntInput("Choose: ");


            // If statement for canceling order

            if (itemType == 0) {
                return;
            }


            // Declaring/ Initializing bowl item

            BowlAndBarItem item = null;


            // Switch statement for add item screen

            switch (itemType) {
                case 1:
                    item = createSmoothie();
                    validSelection = true;
                    break;

                case 2:
                    item = createJuice();
                    validSelection = true;
                    break;

                case 3:
                    item = createYogurtBowl();
                    validSelection = true;
                    break;

                default:
                    System.out.println("Invalid selection. Please choose 1, 2, 3, or 0.");
            }


            // Adding item if selected

            if (item != null) {
                currentOrder.addItem(item);
                System.out.println("\nItem added to order!");
            }
        }
    }


    // Add Drink method

    private void addDrink() {


        // Printing Add drink screen

        System.out.println("\n================================");
        System.out.println("ADD DRINK");
        System.out.println("================================");


        // Imported Array list of flavors for Drink options

        String[] flavors = Drink.getFlavors();
        int flavorChoice = -1;


        // While statement, plus validation to print flavors array list

        while (flavorChoice < 0 || flavorChoice >= flavors.length) {
            System.out.println("Select flavor:");
            for (int i = 0; i < flavors.length; i++) {
                System.out.println((i + 1) + ") " + flavors[i]);
            }


            // Customer I/O handling for flavor selection

            flavorChoice = getIntInput("Choose: ") - 1;
            if (flavorChoice < 0 || flavorChoice >= flavors.length) {
                System.out.println("Invalid selection. Please choose a number from 1 to " + flavors.length + ".");
            }
        }


        // Declaring size var for user drink input

        DrinkSize size = null;


        // While Statement for Select size Screen

        while (size == null) {
            System.out.println("\nSelect size:");
            System.out.println("1) Small - $2.00");
            System.out.println("2) Medium - $2.50");
            System.out.println("3) Large - $3.00");


            // Customer I/O Handling for drink size

            int sizeChoice = getIntInput("Choose: ");


            // Switch Statement for DRINK size options

            switch (sizeChoice) {
                case 1:
                    size = DrinkSize.SMALL;
                    break;

                case 2:
                    size = DrinkSize.MEDIUM;
                    break;

                case 3:
                    size = DrinkSize.LARGE;
                    break;

                default:
                    System.out.println("Invalid size. Please choose: 1, 2, or 3.");
            }
        }


        // Creating new drink to add to customer's current order

        Drink drink = new Drink(size, flavors[flavorChoice]);
        currentOrder.addDrink(drink);
        System.out.println("Drink added to order!");
    }


    // Add Side method

    private void addSide() {
        System.out.println("\n================================");
        System.out.println("ADD MAIN SIDE");
        System.out.println("================================");


        // Importing Sides array list

        String[] types = Side.getTYPES();
        int choice = -1;


        // While Statement to print Select sides for user input

        while (choice < 0 || choice >= types.length) {
            System.out.println("Select sides:");
            for (int i = 0; i < types.length; i++) {
                System.out.println((i + 1) + ") " + types[i] + " - $1.50");
            }


            // Customer I/O Handling for side selection

            choice = getIntInput("Choose: ") - 1;
            if (choice < 0 || choice >= types.length) {
                System.out.println("Invalid selection. Please choose a number from 1 to " + types.length + ".");
            }
        }


        // Creating a new side var for customer input after selection

        Side side = new Side(types[choice]);
        currentOrder.addSide(side);
        System.out.println("Side added to order!");
    }


    // Boolean Check out method (for order validation)

     private boolean checkout() {


        // If statements, if order is empty OR customer has a valid

        if (currentOrder.isEmpty()) {  // EMPTY ORDER
            System.out.println("\nYour order is empty! Please add item to checkout.");
            return false;
        }


        if (!currentOrder.hasValidOrder()) {  // VALID ORDER
            System.out.println("\nIf you don't order any items, you must purchase a side or drink.");
            return false;
        }


        // Printing customer's order and capturing input

         System.out.println(currentOrder);
         System.out.println("\nConfirm order? (y/n): ");
         String confirm = scanner.nextLine().trim().toLowerCase();


         // if and else statements for validating a customer confirming an order

         if (!confirm.equals("y") && !confirm.equals("yes")) {
             System.out.println("Order cancelled.");
         } else {
             ReceiptWriter.writeReceipt(currentOrder);
             System.out.println("\n Order confirmed! Thank you for your purchase!");
         }
         currentOrder = null;
         return true;
     }


     // Create smoothie method Signature item creation (SignatureItem.Template)

    private Smoothie createSmoothie() {


        // Importing array list of smoothie types/("names")

        String[] types = Smoothie.getTypes();
        int typeChoice = -1;


        // While statement for printing smoothie types

        while (typeChoice < 0 || typeChoice >= types.length) {
            System.out.println("\nSelect smoothie type:");
            for (int i = 0; i < types.length; i++) {
                System.out.println((i + 1) + ") " + types[i]);
            }


            //  I/O Handling for customer's smoothie type

            typeChoice = getIntInput("Choose: ") - 1;
            if (typeChoice < 0 || typeChoice >= types.length) {
                System.out.println("Invalid selection. Please choose a number from 1 to " + types.length + ".");
            }
        }


        // Declaring/ Initializing new smoothie and item size var/ method

        ItemSize size = selectSize();
        Smoothie smoothie = new Smoothie(size, types[typeChoice]);


        // Passing arg. Smoothie to add topping method

        addToppingToItem(smoothie);


        // While statements to print prompt and nested if statement for special smoothie orders

        String special;
        while (true) {
            System.out.print("Would you like to add a protein boost? (+$1.00) (y/n): ");
            special = scanner.nextLine().trim().toLowerCase();


            // VALIDATION if customer wants smoothie specialized

            if (special.equals("y") || special.equals("yes") ||
                    special.equals("n") || special.equals("no")) {
                break;
            }
            System.out.println("Invalid input. Please enter: 'y' or 'n'.");
        }


        // If statement to set specialized to ture after customer's input

        if (special.equals("y") || special.equals("yes")) {
            smoothie.setSpecialized(true);
        }
        return smoothie;  // Returning customer's smoothie order
    }


    // Create juice method (RegularItem.Temp)

    private Juice createJuice() {


        // Importing juice types

        String[] types = Juice.getTypes();
        int typeChoice = -1;


        // While statement to print juice types

        while (typeChoice < 0 || typeChoice >= types.length) {
            System.out.println("\nSelect juice type:");
            for (int i = 0; i < types.length; i++) {
                System.out.println((i + 1) + ") " + types[i]);
            }


            // Customer I/O handling for juice type

            typeChoice = getIntInput("Choose: ") - 1;
            if (typeChoice < 0 || typeChoice >= types.length) {
                System.out.println("Invalid selection. Please choose a number from 1 to " + types.length + ".");
            }
        }


        // Declaring/ Initializing new juice and select size method

        ItemSize size = selectSize();
        Juice juice = new Juice(size, types[typeChoice]);


        // Passing arg. Juice through add toppings method

        addToppingToItem(juice);


        // While statement to check and capture if customer wants juice specialized

        String special;
        while (true) {
            System.out.print("Would you like cold pressed? (+$0.75) (y/n): ");
            special = scanner.nextLine().trim().toLowerCase();


            // if statement for customer selection

            if (special.equals("y") || special.equals("yes") ||
                    special.equals("n") || special.equals("no")) {
                break; // - if valid input, then print (print statement below)
            }
            System.out.println("Invalid input. Please enter: 'y' or 'n'.");
        }


        // if statement to print is and set is specialized

        if (special.equals("y") || special.equals("yes")) {
            juice.setSpecialized(true);
        }
        return juice;  // Returning customer's juice selection
    }


    // Create yogurt bowl method (CustomItem.Template)

    private YogurtBowl createYogurtBowl() {


        // Importing yogurt bowl types

        String[] types = YogurtBowl.getTypes();
        int typeChoice = -1;


        // While statement for printing yogurt bowl types

        while (typeChoice < 0 || typeChoice >= types.length) {
            System.out.println("\nSelect yogurt base:");
            for (int i = 0; i < types.length; i++) {
                System.out.println((i + 1) + ") " + types[i]);
            }


            // Customer I/O Handling for yogurt bowl base

            typeChoice = getIntInput("Choose: ") - 1;
            if (typeChoice < 0 || typeChoice >= types.length) {
                System.out.println("Invalid selection. Please choose a number from 1 to " + types.length + ".");
            }
        }


        // Initializing/ Declaring new yogurt bowl and size selection var

        ItemSize size = selectSize();
        YogurtBowl bowl = new YogurtBowl(size, types[typeChoice]);
        addToppingToItem(bowl); // Adding customer's topping selection


        // While statement if customer wants bowl specailized

        String special;
        while (true) {
            System.out.print("Would you like it as a layered bowl? (+$1.25) (y/n): ");
            special = scanner.nextLine().trim().toLowerCase();


            // if statement/ validation if customer wants bowl customized

            if (special.equals("y") || special.equals("yes") ||
                    special.equals("n") || special.equals("no")) {
                break;
            }
            System.out.println("Invalid input. Please enter: 'y' or 'n'.");
        }


        // if statement to set customer's bowl to specailized

        if (special.equals("y") || special.equals("yes")) {
            bowl.setSpecialized(true);
        }
        return bowl; // Returning customer's bowl selection
    }


        // Select size method

        private ItemSize selectSize() {
        ItemSize size = null;


        // While statement to print select size screen

        while (size == null) {
            System.out.println("\nSelect size:");
            System.out.println("1) Small - $4.50");
            System.out.println("2) Medium - $6.35");
            System.out.println("3) Large - $8.50");


            // Customer I/O Handling for size selection

            int sizeChoice = getIntInput("Choose: ");


            // Switch statement for customer size selection

            switch (sizeChoice) {
                case 1:
                    size = ItemSize.SMALL;
                    break;
                case 2:
                    size = ItemSize.MEDIUM;
                    break;
                case 3:
                    size = ItemSize.LARGE;
                    break;
                default:
                    System.out.println("Invalid size. Please choose 1, 2, or 3.");
            }
        }
        return size; // Returing customer's size selection
    }


    // Add topping method/ Helper method

     private void addToppingToItem(BowlAndBarItem item) {

        //  Calling different array list in topping category class

        addToppingCategory(item,"PROTEINS TOPPINGS (S $1.00, M $2.00, L $3.00)",PROTEINS,ToppingCategory.PROTEIN);

        addToppingCategory(item,"PREMIUM TOPPINGS (S $1.00, M $2.50, L $3.25)",PREMIUM_TOPPINGS,ToppingCategory.PREMIUM);

        addToppingCategory(item,"REGULAR TOPPINGS (FREE UNLESS EXTRA)",REGULAR_TOPPINGS,ToppingCategory.REGULAR);

        addToppingCategory(item,"CONDIMENTS (FREE UNLESS EXTRA)",CONDIMENTS,ToppingCategory.CONDIMENT);
     }


     // Topping's category method and constructor

    private void addToppingCategory(BowlAndBarItem item, String categoryName, String[] options, ToppingCategory category) {


        // Printing topppings array lists

        System.out.println("\n" + categoryName + ":");
        for (int i = 0; i < options.length; i++) {
            System.out.println((i + 1) + ") " + options[i]);
        }
        System.out.println("0) Done");


        // While statement for toppings selection flow

        while (true) {


            // Customer I/O handling for toppings

            int choice = getIntInput("Add topping (or 0 when done): ");
            if (choice == 0)
                break;
            int index = choice - 1;


            // If statemen for toppings ordering logic

            if (index >= 0 && index < options.length) {
                item.addTopping(new Topping(options[index], category, false));
                System.out.println("Added " + options[index]);


                // Print statement for adding extra toppings

                System.out.print("Would you like extra? (y/n): ");
                String extra = scanner.nextLine().trim().toLowerCase();


                // Nested-if statement for validating customer's input

                if (extra.equals("y") || extra.equals("yes")) {
                    item.addTopping(new Topping(options[index], category, true));
                    System.out.println("Added extra " + options[index]);


                    // Nested-if statement to print out toppings extra's charge prompts

                    if (category == ToppingCategory.PROTEIN) {
                        System.out.println("   (Extra protein charge applied: $0.50-$1.50 based on size)");
                    } else if (category == ToppingCategory.PREMIUM) {
                        System.out.println("   (Extra premium charge applied: $0.50-$1.50 based on size)");
                    } else if (category == ToppingCategory.REGULAR) {
                        System.out.println("   (Extra regular topping charge applied: $0.25-$0.75 based on size)");
                    } else if (category == ToppingCategory.CONDIMENT) {
                        System.out.println("   (Extra condiment charge applied: $0.20-$0.60 based on size)");
                    }
                }
            } else { // VALIDATION FOR CORRECT SELECTION
                System.out.println("Invalid selection. Please choose a number between 1 and " + options.length + ".");
            }
        }
    }


    // Helper method for capturing customer's input

     private int getIntInput(String prompt) {
         System.out.print(prompt);


         // While statement for valid int input

         while (!scanner.hasNextInt()) {
             scanner.nextLine();
             System.out.println("Please enter a valid number");
         }


         // Setting scanner to capture and return customer selection

         int value = scanner.nextInt();
         scanner.nextLine();
         return value; // Returning customer's input
     }
}