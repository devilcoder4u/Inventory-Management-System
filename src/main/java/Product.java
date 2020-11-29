public class Product {

    private String brand;
    private Integer size;
    private Integer quantity;

    public Product(String brand, Integer size, Integer quantity) {
        this.brand = brand;
        this.size = size;
        this.quantity = quantity;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Product{" +
                "brand='" + brand + '\'' +
                ", size=" + size +
                ", quantity=" + quantity +
                '}';
    }

}
