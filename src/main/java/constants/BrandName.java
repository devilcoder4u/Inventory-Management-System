package constants;

import java.util.*;

public class BrandName {

    public static final List<String> availableBrands= Arrays.asList("Adidas","Nike","Peppe","Roadster");
    public static Map<Integer, String> displayMap = new HashMap<>();

    static {
        displayMap.put(1, "Shoes");
        displayMap.put(2, "Jeans");
        displayMap.put(3, "Shirt");
    }

    public static List<String> getAvailableBrands() {
        return availableBrands;
    }

    public static Map<Integer, String> getDisplayMap() {
        return displayMap;
    }

    public static void setDisplayMap(Map<Integer, String> displayMap) {
        BrandName.displayMap = displayMap;
    }
}
