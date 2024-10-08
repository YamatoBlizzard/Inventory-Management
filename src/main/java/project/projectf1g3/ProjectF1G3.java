package project.projectf1g3;
//Class Main

import java.util.Arrays;
import java.util.Scanner;

public class ProjectF1G3 {
    private static final int MAX_PRODUCTS = 50; //Stores how many items
    private static ProjectF1G3Product[] products = 
            new ProjectF1G3Product[MAX_PRODUCTS];
    private static int productCount = 0;
    private static int count = 0;
    private static final String ID_CODE = "P";  //ID prefix

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        initializeProducts();

        boolean quit = false;

        do {
            displayUserMenu();
            String msg = input.nextLine();

            try {
                int userInput = Integer.parseInt(msg);
                
                //User Menu
                switch (userInput) {
                    case 1 -> addProduct(input);
                    case 2 -> searchProduct(input);
                    case 3 -> listProducts();
                    case 0 -> {
                        quit = true;
                        System.out.println("Thank you for using the system.");
                    }
                    default -> System.out.println("Invalid Choice. "
                            + "Returning to main menu.");
                }
            } catch (NumberFormatException nfe) {
                System.out.println("Invalid Choice. Returning to main menu.");
            }

        } while (!quit);

        input.close();
    }
    
    //Predefined products, Object Array
    public static void initializeProducts() {
        products[0] = new ProjectF1G3Product(generateId(), 
                "Samsung Galaxy S13", "Phone", 2599.00);
        products[1] = new ProjectF1G3Product(generateId(), 
                "Acer Spin 399", "Laptop", 3900.80);
        products[2] = new ProjectF1G3Product(generateId(), 
                "Samsung Galaxy S14", "Phone", 3599.00);
        products[3] = new ProjectF1G3Product(generateId(), 
                "iPhone 14 Pro Max", "Phone", 4950.00);
        products[4] = new ProjectF1G3Product(generateId(), 
                "Samsung Galaxy S23 Ultra", "Phone", 5700.00);
        products[5] = new ProjectF1G3Product(generateId(), 
                "Google Pixel 7 Pro", "Phone", 4050.00);
        products[6] = new ProjectF1G3Product(generateId(), 
                "MacBook Pro 16 M2", "Laptop", 11245.00);
        products[7] = new ProjectF1G3Product(generateId(), 
                "Dell XPS 13 Plus", "Laptop", 6750.80);
        products[8] = new ProjectF1G3Product(generateId(), 
                "Lenovo ThinkPadX1 Carbon Gen 10", "Laptop", 7000.00);
        products[9] = new ProjectF1G3Product(generateId(), 
                "Sony WH-1000XM5", "Headset", 1600.00);
        products[10] = new ProjectF1G3Product(generateId(), 
                "HyperX Cloud || Wireless", "Headset", 500.00);
        products[11] = new ProjectF1G3Product(generateId(), 
                "Logitech MX Master 3S", "Mouse", 500.00);
        products[12] = new ProjectF1G3Product(generateId(), 
                "Razer DeathAdder V3 Pro", "Mouse", 400.00);
        products[13] = new ProjectF1G3Product(generateId(), 
                "Corsair Dark Core RGB Pro", "Mouse", 900.00);
        products[14] = new ProjectF1G3Product(generateId(), 
                "Asus ROG Zephyrus G14", "Laptop", 6900.00);
        products[15] = new ProjectF1G3Product(generateId(), 
                "Corsair K95 RGB Platinum XT", "Keyboard", 900.00);
        products[16] = new ProjectF1G3Product(generateId(), 
                "Razer Huntsman Elite", "Keyboard", 900.00);
        products[17] = new ProjectF1G3Product(generateId(), 
                "SteelSeries Apex Pro", "Keyboard", 900.00);
        products[18] = new ProjectF1G3Product(generateId(), 
                "Logitech G Pro X Superlight", "Mouse", 600.00);
        products[19] = new ProjectF1G3Product(generateId(), 
                "SteelSeries Arctis 7P+", "Headset", 810.00);
        products[20] = new ProjectF1G3Product(generateId(), 
                "Razer BlackWidow V3", "Keyboard", 630.00);
        products[21] = new ProjectF1G3Product(generateId(), 
                "Apple AirPods Max", "Headset", 2470.50);
        products[22] = new ProjectF1G3Product(generateId(), 
                "Jabra Elite 85h", "Headset", 1125);
        products[23] = new ProjectF1G3Product(generateId(), 
                "Razer Kraken Tournament Edition", "Keyboard", 450.00);
        products[24] = new ProjectF1G3Product(generateId(), 
                "Razer Naga X", "Mouse", 360.00);
        productCount = 25;
    }
    
    //ID code (P1)
    public static String generateId() {
        count++;
        return ID_CODE + count;
    }
    
    //User Menu Interface
    public static void displayUserMenu() {
        System.out.println("Menu selection:");
        System.out.println("1. Add Product");
        System.out.println("2. Search Product");
        System.out.println("3. List Product");
        System.out.print("Enter selection (1/2/3) 0 to exit: ");
    }

    public static void displaySearchMenu() {
        System.out.println("Search by:");
        System.out.println("1. Id");
        System.out.println("2. Name");
        System.out.println("3. Category");
        System.out.print("Enter your search selection (1/2/3): ");
    }

    public static void displayProductMenu() {
        System.out.printf("%-5s | %-5s | %-35s | %-10s | %10s |%n",
                "No", "Id", "Name", "Category", "Price");
        System.out.println("--------------------------------------"
                + "-----------------------------------------");
    }

    public static void displayEndLine() {
        System.out.println("======================================"
                + "=========================================");
    }
    
    //Add Function
    public static void addProduct(Scanner input) {
        //if array is full, display error message
        if (productCount >= MAX_PRODUCTS) {
            System.out.println("Error: Product list is full.");
            return;
        }
        
        //Read the user input and convert p to uppercase to match ID format
        System.out.print("Enter the product ID (e.g., P26): ");
        String id = input.nextLine().toUpperCase(); 

        //Check if the ID is unique
        for (int i = 0; i < productCount; i++) {
            if (products[i].getId().equals(id)) {
                System.out.println("Error: A product with the same ID"
                        + " already exists.");
                System.out.println("");
                return;
            }
        }
        
        System.out.print("Enter the product name: ");
        String name = input.nextLine();
        
        //Check if the name is unique
        for (int i = 0; i < productCount; i++) {
            if (products[i].getName().equalsIgnoreCase(name)) {
                System.out.println("Error: A product with the same name "
                        + "already exists.");
                System.out.println("");
                return;
            }
        }
        
        //choose category name
        System.out.println("\nProduct category:");
        System.out.println("1. Laptop");
        System.out.println("2. Phone");
        System.out.println("3. Headset");
        System.out.println("4. Mouse");
        System.out.println("5. Keyboard");
        System.out.print("Enter the product category number: ");
        int categoryNum;
        try {
            categoryNum = Integer.parseInt(input.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid category. Returning to main menu.");
            return;
        }

        String category;
        switch (categoryNum) {
            case 1 -> category = "Laptop";
            case 2 -> category = "Phone";
            case 3 -> category = "Headset";
            case 4 -> category = "Mouse";
            case 5 -> category = "Keyboard";
            default -> {
                System.out.println("Invalid category. Returning to main menu.");
                return;
            }
        }
        
        //choose price
        System.out.print("Enter the product price in RM: ");
        double price;
        try {
            price = Double.parseDouble(input.nextLine());
        } catch (NumberFormatException nfe) {
            System.out.println("Invalid price. Returning to main menu.");
            return;
        }
        
        //Confirmation of added product
        products[productCount++] = 
                new ProjectF1G3Product(id, name, category, price);
        System.out.println("Product added successfully!\n");
    }
    
    //Search Function
    public static void searchProduct(Scanner input) {
        displaySearchMenu();
        String msg = input.nextLine();

        try {
            int searchOption = Integer.parseInt(msg);

            switch (searchOption) {
                case 1 -> {
                    System.out.print("Enter the product ID to search: ");
                    String id = input.nextLine();
                    searchById(id);
                }

                case 2 -> {
                    System.out.print("Enter the product name to search: ");
                    String name = input.nextLine();
                    searchByName(name);
                }

                case 3 -> {
                    System.out.println("\nProduct category:");
                    System.out.println("1. Laptop");
                    System.out.println("2. Phone");
                    System.out.println("3. Headset");
                    System.out.println("4. Mouse");
                    System.out.println("5. Keyboard");
                    System.out.print("Enter the product category "
                            + "number to search: ");
                    int categoryNum = Integer.parseInt(input.nextLine());
                    searchByCategory(categoryNum);
                }

                default -> System.out.println("Invalid Choice. "
                        + "Returning to main menu.");
            }
        } catch (NumberFormatException nfe) {
            System.out.println("Invalid Choice. Returning to main menu.");
        }
    }
    
    //Search by ID
    public static void searchById(String id) {
        displayProductMenu();
        int no = 1;
        boolean found = false;
        for (int i = 0; i < productCount; i++) {
            if (products[i].getId().equalsIgnoreCase(id)) {
                ProjectF1G3Product product = products[i];
                System.out.printf("%-5d | %-5s | %-35s | %-10s | %10.2f |%n",
                        no++, product.getId(), product.getName(), 
                        product.getCategory(), product.getPrice());
                found = true;
                break; // stop the loop from looking at the whole array
            }
        }
        if (!found) {
            System.out.println("Product not found in the system");
        }
        displayEndLine();
    }

    //Search by Name
    public static void searchByName(String name) {
        displayProductMenu();
        int no = 1;
        boolean found = false;
        for (int i = 0; i < productCount; i++) {
            if (products[i].getName().toLowerCase().
                    contains(name.toLowerCase())) {
                ProjectF1G3Product product = products[i];
                System.out.printf("%-5d | %-5s | %-35s | %-10s | %10.2f |%n",
                        no++, product.getId(), product.getName(), 
                        product.getCategory(), product.getPrice());
                found = true;
            }
        }
        if (!found) {
            System.out.println("Product not found in the system");
        }
        displayEndLine();
    }

    //Search by Category
    public static void searchByCategory(int categoryNum) {
        String category;
        switch (categoryNum) {
            case 1 -> category = "Laptop";
            case 2 -> category = "Phone";
            case 3 -> category = "Headset";
            case 4 -> category = "Mouse";
            case 5 -> category = "Keyboard";
            default -> {
                System.out.println("Invalid category. "
                        + "Returning to main menu.");
                System.out.println("");
                return;
            }
        }

        displayProductMenu();
        int no = 1;
        boolean found = false;
        for (int i = 0; i < productCount; i++) {
            if (products[i].getCategory().equalsIgnoreCase(category)) {
                ProjectF1G3Product product = products[i];
                System.out.printf("%-5d | %-5s | %-35s | %-10s | %10.2f |%n",
                        no++, product.getId(), product.getName(), 
                        product.getCategory(), product.getPrice());
                found = true;
            }
        }
        if (!found) {
            System.out.println("Product not found in the system");
        }
        displayEndLine();
    }
    
    //List Function
    public static void listProducts() {
        displayProductMenu();
        int no = 1;
        for (int i = 0; i < productCount; i++) {
            ProjectF1G3Product product = products[i];
            System.out.printf("%-5d | %-5s | %-35s | %-10s | %10.2f |%n",
                    no++, product.getId(), product.getName(), 
                    product.getCategory(), product.getPrice());
        }
        displayEndLine();
    }
}