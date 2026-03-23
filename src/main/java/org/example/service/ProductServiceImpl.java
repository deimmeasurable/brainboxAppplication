package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.domain.Product;

import org.example.dto.ProductRequest;
import org.example.dto.ProductResponse;
import org.example.dto.UpdateProductRequest;
import org.example.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository repo;
@Override
public ProductResponse create(ProductRequest productRequest) {

        repo.findByNameIgnoreCase(productRequest.getName())
                .ifPresent(p -> {
                    throw new RuntimeException("Product already exists");
                });


        Product product = new Product();
        product.setName(productRequest.getName());
        product.setCategory(productRequest.getCategory());
        product.setPrice(productRequest.getPrice());


     repo.save(product);

        return ProductResponse.builder()
                .message("Product created successfully")
                .build();
    }
@Override
    public List<Product> getAll() {
        return repo.findAll();
    }
@Override
public Product getAProduct(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Not found"));
    }
@Override
public ProductResponse updateProduct(Long id, UpdateProductRequest updated) {
        Product p = getAProduct(id);
        p.setName(updated.getName());
        p.setCategory(updated.getCategory());
        p.setPrice(updated.getPrice());

         repo.save(p);
         return ProductResponse.builder()
                 .message("product updated successfully")
                 .build();

    }
@Override
public ProductResponse delete(Long id) {

        repo.deleteById(id);
        return ProductResponse.builder()
                .message("product deleted successfully")
                .build();
    }
}


