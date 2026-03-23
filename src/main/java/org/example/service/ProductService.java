package org.example.service;

import org.example.domain.Product;
import org.example.dto.ProductRequest;
import org.example.dto.ProductResponse;
import org.example.dto.UpdateProductRequest;

import java.util.List;

public interface ProductService {

    ProductResponse create(ProductRequest productRequest);
    List<Product> getAll();;
    Product getAProduct(Long id);
    ProductResponse updateProduct(Long id, UpdateProductRequest updated);
    ProductResponse delete(Long id);
}
