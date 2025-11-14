# Bowl & Bar 🥤🍓
### **A Java CLI Point of Sales application for a custom smoothie, juice, and yogurt bowl shop.**

---

# 📋 Project Description
Bowl & Bar is a command-line interface application designed to streamline the ordering process for a health-focused food establishment. Customers can customize their orders by selecting from smoothies, juices, and yogurt bowls with various sizes, types, toppings, and special preparations. The application handles the complete order workflow from item customization to receipt generation.

---

# 🎯 Features

### Three Core Products:

**Smoothies**: Berry Blast, Tropical Paradise, Green Machine, Chocolate Peanut

**Juices**: Orange Fresh, Apple Crisp, Carrot Ginger, Beet Energy

**Yogurt Bowls**: Greek, Vanilla, Coconut, Plain


### Customization Options:

- Three sizes (Small, Medium, Large) with different pricing
- Premium protein toppings (Peanut Butter, Almond Butter, Protein Powder, Hemp Seeds, Chia Seeds, Greek Yogurt)
- Premium toppings (Acai, Pitaya, Matcha, Spirulina)
- Regular toppings (Banana, Strawberry, Blueberry, Mango, Pineapple, Granola, Coconut Flakes, Honey, Cacao Nibs)
- Condiments (Agave Syrup, Maple Syrup, Cinnamon, Vanilla Extract, Cocoa Powder, Mint)
- Special preparation options (Protein boost for smoothies, Cold pressed for juices, Layered for bowls)


### Additional Items:

Drinks in three sizes with five flavor options
Main sides (Energy Bites, Protein Bar)


### Order Management:

Add multiple items, drinks, and sides to a single order
View order summary with itemized pricing
Confirm or cancel orders
Automatic receipt generation with timestamp

---

# 📁 Project Structure

```java
bowl-and-bar/
├── receipts
├── src/
│   └── main/
│       ├── java/
│       │   └── com.pluralsight/
│       │       ├── BowlAndBarApp.java (main application)
│       │       ├── enums/
│       │       │   ├── DrinkSize.java <img width="3267" height="4092" alt="Bowl   Bar Capstone App-2025-11-13-223125" src="https://github.com/user-attachments/assets/c6d0bb0c-aed8-4c69-8a50-0ec54bb7e9c5" />

│       │       │   ├── ItemSize.java
│       │       │   └── ToppingCategory.java
│       │       ├── inheriters/
│       │       │   ├── BowlItem.java (abstract class)
│       │       │   ├── Juice.java
│       │       │   ├── Smoothie.java
│       │       │   └── YogurtBowl.java
│       │       └── objects/
│       │           ├── Drink.java
│       │           ├── Order.java
│       │           ├── ReceiptWriter.java
│       │           ├── Side.java
│       │           └── Topping.java
│       └── resources/
├── test/
├── target/ 
└── README.md
```

---

# Diagram

![IMG_0523](https://github.com/user-attachments/assets/eea1d2d8-6137-43eb-9261-0351c35b556e)
---

# 🚀 Getting Started
### Prerequisites

- Java Development Kit (JDK) 8 or higher
- Git

### Installation

**1. Clone the repository:**
```bash
bashgit clone https://github.com/yourusername/bowl-and-bar.git
cd bowl-and-bar
```

**2. Navigate to the source directory:**
```bash
bashcd src
```

**3. Compile all Java files:**
```bash
bashjavac *.java
```

**4. Run the application:**
```bash
bashjava BowlAndBarApp
```

---

# 💻 Usage
## Home Screen
### When you start the application, you'll see the home screen with options to:

- Start a new order (1)
- Exit the application (0)

### Order Screen
After starting a new order, you can:

- Add items (smoothies, juices, or bowls) (1)
- Add drinks (2)
- Add main sides (3)
- Checkout (4)
- Cancel the order (0)

### Adding Items
When adding an item, you'll be guided through:

1. Selecting the item type (Smoothie, Juice, or Yogurt Bowl)
2. Choosing the specific variety
3. Selecting the size
4. Adding proteins (with optional extra portions)
5. Adding premium toppings (with optional extra portions)
6. Adding regular toppings
7. Adding condiments
8. Choosing special preparation options

### Checkout
At checkout, you'll see:

- Complete order summary with all items and toppings
- Itemized prices
- Total order cost
- Option to confirm or cancel

**After confirmation, a receipt file is automatically generated in the receipts folder with a timestamp filename (e.g., 20231107-143022.txt).**

---

# 💰 Pricing Structure
## **Base Item Prices**
- Small: $4.50
- Medium: $6.35
- Large: $8.50

## Toppings Price
**Proteins**:

- Small: $1.00 (Extra: $0.50)
- Medium: $2.00 (Extra: $1.00)
- Large: $3.00 (Extra: $1.50)

**Premium Toppings**:

- Small: $1.00 (Extra: $0.50)
- Medium: $2.50 (Extra: $1.00)
- Large: $3.25 (Extra: $1.50)

### (Regular Toppings & Condiments: Included, unless extra.)

**Regular Toppings** 

- Small: Extra: $0.25
- Medium: Extra: $0.50
- Large: Extra: $0.75

**Condiments** 

- Small: Extra: $0.20
- Medium: Extra: $0.40
- Large: Extra: $0.60

**Special Preparations**

- Protein Boost (Smoothie): $1.00
- Cold Pressed (Juice): $0.75
- Layered Bowl (Yogurt): $1.25

**Drinks**

- Small: $2.00
- Medium: $2.50
- Large: $3.00

**Sides**

- All sides: $1.50

---

# 🏗️ Object-Oriented Design
## The application follows OOP principles with:
### Classes

- **BowlAndBarApp**: Main application with UI logic
- **Order**: Manages collections of items, drinks, and sides
- **BowlItem** (Abstract): Base class for all customizable items
- **Smoothie**, Juice, YogurtBowl: Concrete item implementations
- **Topping**: Represents toppings with category and pricing
- **Drink**: Beverage products
- **Side**: Side items
- **ReceiptWriter**: Handles receipt file generation

### Enums

- **ItemSize**: SMALL, MEDIUM, LARGE
- **DrinkSize**: SMALL, MEDIUM, LARGE (with prices)
- **ToppingCategory**: PROTEIN, PREMIUM, REGULAR, CONDIMENT

### Key Design Patterns

- **Inheritance** Smoothie, Juice, and YogurtBowl extend BowlItem
- **Polymorphism**: Different item types implement getPrice() differently
- **Encapsulation**: Private fields with public methods
- **Composition**: Order contains lists of items, drinks, and sides

---

# 🎨 Interesting Code Feature
One of the most interesting aspects of this project is the dynamic topping pricing system. The Topping class calculates prices based on both the topping category and the item size:

```java
 public double getPrice(ItemSize size) {
        double price = 0.0;

        switch (category) {
            case PROTEIN:
                if (extra) {
                    switch (size){
                        case SMALL: return 0.50;
                        case MEDIUM: return 1.00;
                        case LARGE: return 1.50;
                    }
                } else {
                    switch (size) {
                        case SMALL: return 1.00;
                        case MEDIUM: return 2.00;
                        case LARGE: return 3.00;
                    }
                }
                break;
            case PREMIUM:
                if (extra) {
                    switch (size) {
                        case SMALL: return 0.50;
                        case MEDIUM: return 1.00;
                        case LARGE: return 1.50;
                    }
                } else {
                    switch (size) {
                        case SMALL: return 1.00;
                        case MEDIUM: return 2.50;
                        case LARGE: return 3.25;
                    }
                }
                break;
            case REGULAR:
                if (extra) {
                    switch (size) {
                        case SMALL: return 0.25;
                        case MEDIUM: return 0.50;
                        case LARGE: return 0.75;
                    }
                }
                return 0.0;

            case CONDIMENT:
                if (extra) {
                    switch (size) {
                        case SMALL: return 0.20;
                        case MEDIUM: return 0.40;
                        case LARGE: return 0.60;
                    }
                }
                return 0.0;
        }

        return price;
    }
```
This design allows for flexible pricing that scales with item size and accounts for extra portions, making the system easily maintainable and extensible.

```java
📝 Receipt Example
========================================
           BOWL & BAR ORDER            
========================================

ITEMS:
--------------------------------------
1. Smoothie - Medium Berry Blast
  Toppings:
    - Peanut Butter
    - Banana
    - Strawberry
    - Agave Syrup
   Price: $12.00

DRINKS:
--------------------------------------
1. Medium Coconut Water - $2.50

========================================
TOTAL: $14.50
========================================
```

--- 

# 🤝 Contributing
This is a capstone project for educational purposes. If you'd like to suggest improvements:

Fork the repository
Create a feature branch
Commit your changes
Push to the branch
Open a Pull Request


# 📄 License
This project is created for educational purposes as part of the Year UP United/Pluralsight JAVA course.

---

# 👤 Author
[**Markus Williams**]

GitHub: **@FullStackMWilliams**

---

# 🙏 Acknowledgments

Year UP United/Pluralsight JAVA course
Capstone project requirements and guidelines
