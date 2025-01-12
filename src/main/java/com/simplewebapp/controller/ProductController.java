package com.simplewebapp.controller;

import com.simplewebapp.model.Product;
import com.simplewebapp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping("/product")
    public List<Product> getProducts(){
        return productService.getProducts();
    }
    @RequestMapping("/product/{prodId}")
    public Product getProduct(@PathVariable int prodId){
        return productService.getProductById(prodId);
    }
}
