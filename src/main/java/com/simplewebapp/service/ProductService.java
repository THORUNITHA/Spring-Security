package com.simplewebapp.service;

import com.simplewebapp.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

@Service
public class ProductService {

    //Arrays.asList it is immutable list
    //mutable new ArrayList<>
    List<Product> products = new ArrayList<>(Arrays.asList(
            new Product(1,"iphone",48000),
            new Product(2,"Laptop",90000)
    ));
    public List<Product> getProducts(){
        return products;
    }

    public Product getProductById(int prodId){
        return products.stream().filter(p->p.getProdId() == prodId).findFirst().orElse(new Product(100,"No item",0));
    }
}
