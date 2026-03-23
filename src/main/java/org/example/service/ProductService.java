package org.example.service;

import org.example.domain.Product;

import java.util.List;

public interface ProductService {
    Product create(Product product);
    List<Product> getAll();
    Product get(Long id);
    Product update(Long id, Product updated);
}
