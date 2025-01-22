package main.java.entity;

public class Product {

    public ProductType type;
    public int price;
    public int quantity;

    public Product(ProductType type, int price, int quantity){
        this.type = type;
        this.price = price;
        this.quantity = quantity;
    }
}
