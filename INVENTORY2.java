
import java.util.*;

public class INVENTORY2 
{
    private static ArrayList<Product> inventory = new ArrayList<>();
    private static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) 
    {
        while (true) 
        {
            
            System.out.println("Inventory Management System");
            System.out.println("1. Add Product");
            System.out.println("2. View All Products");
            System.out.println("3. Search Product by Name");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            int option = scan.nextInt();
            scan.nextLine();

            switch (option) 
            {
                case 1 -> addProduct();
                case 2 -> viewProducts();
                case 3 -> searchProduct();
                case 4 -> 
                {
                    System.out.println("goodbye");
                    return;
                }
                default -> System.out.println("Invalid choice");
            }
        }
    }

    //Add Product
    private static void addProduct() 
    {
        System.out.print("Enter Product ID: ");
        int id = scan.nextInt();
        scan.nextLine();
        
        System.out.print("Enter Product Name: ");
        String name = scan.nextLine();
        
        System.out.print("Enter Quantity: ");
        int qty = scan.nextInt();
        
        System.out.print("Enter Price: ");
        double price = scan.nextDouble();

        inventory.add(new Product(id, name, qty, price));
        System.out.println("Product added");
    }

    //View Inventory
    private static void viewProducts() 
    {
        if (inventory.isEmpty()) 
        {
            System.out.println("Inventory is empty.");
        } 
        
        else 
        {
            System.out.println("Current Inventory");
            for (Product p : inventory) 
            {
                System.out.println(p);
            }
        }
    }

    //Search
    private static void searchProduct() 
    {
        System.out.print("Enter product name to search: ");
        String searchName = scan.nextLine();
        
        boolean found = false;

        for (Product p : inventory) 
        {
            if (p.getName().equalsIgnoreCase(searchName)) 
            {
                System.out.println("Match found: " + p);
                found = true;
            }
        }
        if (!found) System.out.println("Product not found.");
    }
}
