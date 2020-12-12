import constants.BrandName;
import exceptions.DataNotFoundException;
import model.Product;

import java.util.*;
import java.lang.*;
import java.util.concurrent.ExecutorService;

public class InventoryMain {
    private static Map<String, List<Product>> inventoryMap = new HashMap<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int input = 0;
        while (true) {
            System.out.println("**************************");
            System.out.println("Press 1 to Enter Data");
            System.out.println("Press 2 to View Data");
            System.out.println("Press 3 to Modify Data");
            System.out.println("Press 4 to Delete Data");
            System.out.println("Press 5 to View All Inventory Data");
            System.out.println("Press 6 to Exit");
            System.out.println("**************************");
            System.out.println("Enter your choice:");
            input = sc.nextInt();
            if (!isValidInput(input)) {
                System.out.println("Please Enter Valid Options..");
                continue;
            }
            System.out.println("Input you Entered " + input);
            if (String.valueOf(input).equalsIgnoreCase("6")) {
                System.out.println("Exiting Inventory System..");
                break;
            }
            evaluateChoices(input);
        }
    }

    private static boolean isValidInput(int input) {
        if (!(input >= 1 && input <= 5)) {
            return false;
        }
        return true;
    }

    private static void evaluateChoices(int input) {

        if (String.valueOf(input).equalsIgnoreCase("1")) {
            try {
                addProductToInventory();
            } catch (Exception e) {
                System.out.println("Exception Occureed : "+e.getMessage());
                return;
            }
        } else if (String.valueOf(input).equalsIgnoreCase("2")) {
            System.out.println("Press 1 to View Shoes ");
            System.out.println("Press 2 to View Jeans ");
            System.out.println("Press 3 to View Shirt ");
            Integer view = sc.nextInt();
            displayInventory(BrandName.getDisplayMap().get(view));
        } else if (String.valueOf(input).equalsIgnoreCase("3")) {
            System.out.println("This feature will be coming soon...");
        } else if (String.valueOf(input).equalsIgnoreCase("4")) {
            System.out.println("Enter the product which you want to delete: ");
            System.out.println("Press 1 to Remove Shoes ");
            System.out.println("Press 2 to Remove Jeans ");
            System.out.println("Press 3 to Remove Shirt ");
            Integer remove = sc.nextInt();
            displayInventory(BrandName.getDisplayMap().get(remove));
            removeProduct(BrandName.getDisplayMap().get(remove));
        }else if(String.valueOf(input).equalsIgnoreCase("5")){
            System.out.println(inventoryMap);
        }


    }

    //Function to add item
    private static void addProduct(Product product, String productName) {
        try {

            List<Product> products = inventoryMap.get(productName);

            if (products == null) {
                products = new ArrayList<Product>();
                products.add(product);
                inventoryMap.put(productName, products);
            } else {
                if (!products.contains(product)) products.add(product);
                else System.out.println("Item already exists");
            }
            System.out.println("Your item is succesfully added in the Inventory!!");

        } catch (Exception e) {

        }
    }

    //Function to remove item
    private static void removeProduct(String product) {
        List<Product> products = inventoryMap.get(product);
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the brand name that you want to delete : ");
        String brand_name = sc.next();
        Product temp = null;
        for (Product p : products) {
            if (p.getBrand().equalsIgnoreCase(brand_name)) {
                System.out.println(brand_name + " is Successfully deleted from the cart");
                temp = p;
                break;
            } else {
                System.out.println("Entered Item not found");
                break;
            }
        }
        if (temp != null)
            products.remove(temp);
    }


    //Function to view items of selected product
    private static void displayInventory(String product) {
        System.out.println("*****************************************************");
        List<Product> temp = inventoryMap.get(product);
        System.out.println(product);
        for (Product p : temp)
            System.out.println(p);
        System.out.println("*****************************************************");
    }



    /*    
    //Function to view all the item present in the Inventory
    private static void displayInventory(String product){
       System.out.println("*****************************************************");
        for (Map.Entry<String, List<model.Product>> entry : inventoryMap.entrySet()) {
            System.out.println( entry.getKey());
            System.out.println( entry.getValue());//Returns the list of values
        }
        System.out.println("*****************************************************");
    }

    */

    public static void addProductToInventory() throws Exception {
        String productType="";
        System.out.println("Enter the Type of model.Product : {Shoes :: Jeans :: Shirt}");
        while (true) {
            System.out.println("Press 1 to Enter Shoes");
            System.out.println("Press 2 to Enter Jeans");
            System.out.println("Press 3 to Enter Shirt");
            System.out.println("Press 4 to Return to main menu");
            int input = sc.nextInt();
            Product product=null;
            if (String.valueOf(input).equalsIgnoreCase("4")) {
                break;
            }
            if (String.valueOf(input).equalsIgnoreCase("1")) {
                product=createProductInsideInventory();
                productType="Shoes";
            } else if (String.valueOf(input).equalsIgnoreCase("2")) {
                product= createProductInsideInventory();
                productType="Jeans";
            } else if (String.valueOf(input).equalsIgnoreCase("3")) {
                product=createProductInsideInventory();
                productType="Shirt";
            }
            addProduct(product, productType);
        }
    }

    private static Product createProductInsideInventory() throws Exception {
        Product product=null;
            System.out.println("Enter Brand Name : ");
            String brand = sc.next();
            String validatedBrand = BrandName.getAvailableBrands().stream()
                    .filter(b -> b.equalsIgnoreCase(brand)).findFirst().get();

            System.out.println("Enter the size");
            double size = sc.nextInt();
            if (!(size >= 0 && size <= 10))
                throw new DataNotFoundException("Size out of the limit..", 404);

            System.out.println("Enter the Quantity : ");
            int quantity = sc.nextInt();
            product = new Product(validatedBrand, size, quantity);

        return product;
    }
}
