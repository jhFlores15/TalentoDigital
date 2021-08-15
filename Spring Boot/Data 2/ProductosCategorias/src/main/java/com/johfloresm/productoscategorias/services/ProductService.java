package com.johfloresm.productoscategorias.services;

import com.johfloresm.productoscategorias.models.Category;
import com.johfloresm.productoscategorias.models.Product;
import com.johfloresm.productoscategorias.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService{

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getProducts(){
        return productRepository.findAll();
    }

    public Product getProductById(Long id){
        return productRepository.findProductById(id);
    }

    public Product createProduct(Product p){
        return productRepository.save(p);
    }
}
