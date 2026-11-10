package services;

import enums.ProductCategory;
import models.Product;

import java.util.List;
import java.util.Locale;

public class SearchService {
    private final List<Product> productCatalog;

    SearchService(List<Product> productCatalog){
        this.productCatalog = productCatalog;
    }

    public List<Product> searchByName(String name){
        return productCatalog.stream().filter(product -> {
            return product.getName().equalsIgnoreCase(name);
        }).toList();
    }

    public List<Product> searchByCategory(ProductCategory category){
        return productCatalog.stream().filter(product ->{
            return product.getCategory().equals(category);
        }).toList();
    }



}
