import java.util.*;
import java.lang.*;
import java.util.regex.*;

/*
               1. add validation Regex and others
               2. Convert Code to Modular Form
               3. Create Generalize Exceptions
               4. Add one more option of Generating Report --> This option Export all the data (that are
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
       displayMap.put(2,"Jeans");
       displayMap.put(3,"Shirt");
   }

    public static void main(String[] args) {

        int input=0;
        Scanner sc= new Scanner(System.in);

        while(true){
            System.out.println("**************************");
            System.out.println("Press 1 to Enter Data");
            System.out.println("Press 2 to View Data");
            System.out.println("Press 3 to Modify Data");
            System.out.println("Press 4 to Delete Data");
            System.out.println("Press 5 to Exit");
            System.out.println("**************************");
            System.out.println("Enter your choice:");
            input = sc.nextInt();
            System.out.println("Input you Entered "+ input);

            if(String.valueOf(input).equalsIgnoreCase("1")){
                addProductToInventory();
            }

            else if(String.valueOf(input).equalsIgnoreCase("2")){
                System.out.println("Press 1 to View Shoes ");
                System.out.println("Press 2 to View Jeans ");
                System.out.println("Press 3 to View Shirt ");
                Integer view = sc.nextInt();
                displayInventory(displayMap.get(view));
            }

            else if(String.valueOf(input).equalsIgnoreCase("3")){
                System.out.println("This feature will be coming soon...");
            }else if(String.valueOf(input).equalsIgnoreCase("4")){
                System.out.println("Enter the product which you want to delete: ");
                System.out.println("Press 1 to Remove Shoes ");
                System.out.println("Press 2 to Remove Jeans ");
                System.out.println("Press 3 to Remove Shirt ");
                Integer remove = sc.nextInt();
                displayInventory(displayMap.get(remove));
                removeProduct(displayMap.get(remove));

            }

            if(String.valueOf(input).equalsIgnoreCase("5")){
                System.out.println("Exiting Inventory System..");
                break;
            }

        }
    }

  
    //Function to add item 
  
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

  
    //Function to remove item
  
    private static void removeProduct(String product){                      

       List<Product> products = inventoryMap.get(product);
       Scanner sc=new Scanner(System.in);
       System.out.println("Enter the brand name that you want to delete : ");
       String brand_name=sc.next();

        Product temp=null;

        for(Product p:products)

        {

            if(p.getBrand().equalsIgnoreCase(brand_name)){

                System.out.println(brand_name+" is Successfully deleted from the cart");

                temp=p;

                break;

            }else{
                System.out.println("Entered Item not found");
                break;
            }

        }

        if(temp!=null)
            products.remove(temp);

    }
    
  
  //Function to view items of selected product
    private static void displayInventory(String product){

        System.out.println("*****************************************************");

        List<Product> temp=inventoryMap.get(product);

        System.out.println(product);

        for(Product p:temp)

            System.out.println(p);

        System.out.println("*****************************************************");

    }



    /*    
    //Function to view all the item present in the Inventory
    private static void displayInventory(String product){
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

       System.out.println("Enter the Type of Product : {Shoes :: Jeans :: Shirt}");

       while(true){

           System.out.println("Press 1 to Enter Shoes");
           System.out.println("Press 2 to Enter Jeans");
           System.out.println("Press 3 to Enter Shirt");
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
                    addProduct(product,"Jeans");

            }else if (String.valueOf(input).equalsIgnoreCase("3")) {

                    System.out.println("Enter Brand Name : ");
                    String brand = sc.next();

                    System.out.println("Enter the size");
                    int size = sc.nextInt();

                    System.out.println("Enter the Quantity : ");
                    int quantity = sc.nextInt();

                    Product product = new Product(brand, size, quantity);
                    addProduct(product,"Shirt");
            }
       }
   }
}
