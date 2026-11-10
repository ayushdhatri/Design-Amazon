package models;

import enums.ProductCategory;

public class Product {
    private final String id;

    private final String name;

    private final String desc;

    private double price;

    private final ProductCategory category;

    Product(String id, String name, String desc, double price, ProductCategory category){
        this.id = id;
        this.name = name;
        this.desc = desc;
        this.price = price;
        this.category = category;
    }

    public String getId(){
        return this.id;
    }

    public String getName(){
        return this.name;
    }

    public double getPrice(){
        return this.price;
    }

    public ProductCategory getCategory(){
        return this.category;
    }


}
