package model;

public class Product {

    private String brand;
    private Double size;
    private Integer quantity;

    public Product(String brand, Double size, Integer quantity) {
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

    public Double getSize() {
        return size;
    }

    public void setSize(Double size) {
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
        return "model.Product{" +
                "brand='" + brand + '\'' +
                ", size=" + size +
                ", quantity=" + quantity +
                '}';
    }

}
