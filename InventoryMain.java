import java.util.*;

public class InventoryMain {

   private static Map<String, List<Product>> inventoryMap = new HashMap<>();
   static Map<Integer,String> displayMap = new HashMap<>();

   static {
       displayMap.put(1,"Shoes");
   }

    public static void main(String[] args) {

        Scanner sc= new Scanner(System.in);

        int input=0;
        System.out.println("Press 1 to Enter Data");
        System.out.println("Press 2 to View Data");
        System.out.println("Press 3 to Modify Data");
        System.out.println("Press 4 to Delete Data");
        System.out.println("Enter your choice:");
        input = sc.nextInt();


        System.out.println("Input you Entered "+ input);

        if(String.valueOf(input).equalsIgnoreCase("1")){
            System.out.println("Entet the Type of Product : {Shoes :: Sunglasses :: Mobiles}");

            System.out.println("Press 1 to Enter Shoes");
            System.out.println("Press 2 to Enter Sunglasses");
            System.out.println("Press 3 to Enter Mobiles");
            input = sc.nextInt();

            if(String.valueOf(input).equalsIgnoreCase("1")){

                System.out.println("Enter Brand Name : ");
                String brand = sc.next();

                System.out.println("Enter the size");
                int size = sc.nextInt();

                System.out.println("Enter the Quantity : ");
                int quantity = sc.nextInt();

                Product product = new Product(brand,size,quantity);
                addShoes(product);
            }

        }else if(String.valueOf(input).equalsIgnoreCase("2")){

            System.out.println();
            System.out.println("Press 1 to Enter Shoes");
            System.out.println("Press 2 to Enter Sunglasses");
            System.out.println("Press 3 to Enter Mobiles");
            Integer product = sc.nextInt();

            displayInventory(displayMap.get(product));
        }

    }


    private static void addShoes(Product product){
        try{

            if(null!=inventoryMap.get("Shoes")){
                List<Product> shoes = inventoryMap.get("Shoes");
                shoes.add(product);
                inventoryMap.put("Shoes",shoes);
            }else{
               inventoryMap.put("Shoes", Arrays.asList(product));
            }

            displayInventory("Shoes");

        }catch (Exception e){
            System.out.println("Error Occurred While adding shoes  : "+e.getMessage());
        }
    }

    private static void displayInventory(String product){
       System.out.println("*****************************************************");
        List<Product> products = inventoryMap.get(product);
        System.out.println(product+"    "+products);
        System.out.println("*****************************************************");
    }
}


