package com.johfloresm.productoscategorias.repositories;

import com.johfloresm.productoscategorias.models.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long>{

    List<Product> findAll();
    Product findProductById(Long id);

}
