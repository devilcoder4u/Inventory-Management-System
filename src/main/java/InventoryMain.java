import java.util.*;
import java.lang.*;

/*
               1. add validation Regex and others
               2. Convert Code to Modular Form
               3. Create Generalize Exceptions
               4. Add one more option o
               f Generating Report --> This option Export all the data (that are
                   available in the map at that instance) in the excel sheet using Apache POI framework (Read This Framework)
               5. Gracefully Handle Exception and where ever possible throw it manually to give user error message

               Future Prospect
               1. Convert This project into MultiThreading where each thread separately performing task available in main menu
               2. Add Persistent Layer
                    2.1 using JDBC
                    2.2 ORM
                    2.3 Perform Connection Pooling using Hikari and C3P0
                    2.4 Implement Lazy and Eage Loading using Hibernate
 */

public class InventoryMain {

   private static Map<String, List<Product>> inventoryMap = new HashMap<>();
   static Map<Integer,String> displayMap = new HashMap<>();

   static {
       displayMap.put(1,"Shoes");
       displayMap.put(2,"Sunglasses");
       displayMap.put(3,"Mobiles");
   }

    public static void main(String[] args) {

        int input=0;
        Scanner sc= new Scanner(System.in);

        while(true){

            System.out.println("Press 1 to Enter Data");
            System.out.println("Press 2 to View Data");
            System.out.println("Press 3 to Modify Data");
            System.out.println("Press 4 to Delete Data");
            System.out.println("Press 5 to Exit");
            System.out.println("Enter your choice:");
            input = sc.nextInt();
            System.out.println("Input you Entered "+ input);

            if(String.valueOf(input).equalsIgnoreCase("1")){
                addProductToInventory();
            }

            else if(String.valueOf(input).equalsIgnoreCase("2")){
                System.out.println("Press 1 to View Shoes ");
                System.out.println("Press 2 to View Sunglasses ");
                System.out.println("Press 3 to View Mobiles ");
                Integer view = sc.nextInt();
                displayInventory(displayMap.get(view));
            }

            else if(String.valueOf(input).equalsIgnoreCase("3")){
                System.out.println("This feature will be coming soon...");
            }else if(String.valueOf(input).equalsIgnoreCase("4")){
                System.out.println("Enter the product which you want to delete: ");
                System.out.println("Press 1 to Remove Shoes ");
                System.out.println("Press 2 to Remove Sunglasses ");
                System.out.println("Press 3 to Remove Mobiles ");
                Integer remove = sc.nextInt();


            }

            if(String.valueOf(input).equalsIgnoreCase("5")){
                System.out.println("Exiting Inventory System..");
                break;
            }

        }
    }

    private static void addProduct(Product product, String productName){
       try{

           List<Product> products = inventoryMap.get(productName);

           if(products == null) {
               products = new ArrayList<Product>();
               products.add(product);
               inventoryMap.put(productName, products);
           } else {
               if(!products.contains(product)) products.add(product);
               else System.out.println("Item already exists");
           }
           System.out.println("Your item is succesfully added in the Inventory!!");

       }catch(Exception e ){

       }
    }

    private static void removeProduct(Product product, String productName){

       List<Product> products = inventoryMap.get(productName);


    }

    private static void displayInventory(String product){

        System.out.println("*****************************************************");

        List<Product> temp=inventoryMap.get(product);

        System.out.println(product);

        for(Product p:temp)

            System.out.println(p);

        System.out.println("*****************************************************");

    }



    /*    private static void displayInventory(String product){
       System.out.println("*****************************************************");
        for (Map.Entry<String, List<Product>> entry : inventoryMap.entrySet()) {
            System.out.println( entry.getKey());
            System.out.println( entry.getValue());//Returns the list of values
        }
        System.out.println("*****************************************************");
    }

    */

    public static void addProductToInventory(){

       Scanner sc = new Scanner(System.in);

       System.out.println("Enter the Type of Product : {Shoes :: Sunglasses :: Mobiles}");

       while(true){

           System.out.println("Press 1 to Enter Shoes");
           System.out.println("Press 2 to Enter Sunglasses");
           System.out.println("Press 3 to Enter Mobiles");
           System.out.println("Press 4 to Return to main menu");

           int input = sc.nextInt();

           if(String.valueOf(input).equalsIgnoreCase("4")){
               break;
           }


            if (String.valueOf(input).equalsIgnoreCase("1")) {

                    System.out.println("Enter Brand Name : ");
                    String brand = sc.next();

                    System.out.println("Enter the size");
                    int size = sc.nextInt();

                    System.out.println("Enter the Quantity : ");
                    int quantity = sc.nextInt();
                    Product product = new Product(brand, size, quantity);
                    addProduct(product,"Shoes");

            } else if (String.valueOf(input).equalsIgnoreCase("2")) {

                    System.out.println("Enter Brand Name : ");
                    String brand = sc.next();
                    System.out.println("Enter the size");
                    int size = sc.nextInt();

                    System.out.println("Enter the Quantity : ");
                    int quantity = sc.nextInt();

                    Product product = new Product(brand, size, quantity);
                    addProduct(product,"Sunglasses");

            }else if (String.valueOf(input).equalsIgnoreCase("3")) {

                    System.out.println("Enter Brand Name : ");
                    String brand = sc.next();

                    System.out.println("Enter the RAM size");
                    int size = sc.nextInt();

                    System.out.println("Enter the Quantity : ");
                    int quantity = sc.nextInt();

                    Product product = new Product(brand, size, quantity);
                    addProduct(product,"Mobiles");
            }
       }
   }

   public static void removeProductFromInventory(){
       System.out.println("Press 1 to Delete Shoes ");
       System.out.println("Press 2 to Delete Sunglasses ");
       System.out.println("Press 3 to Delete Mobiles ");
       System.out.println("Press 4 to Return to main menu");
       Scanner sc = new Scanner(System.in);
       Integer input = sc.nextInt();

       if (String.valueOf(input).equalsIgnoreCase("1")){

       }
   }
}
