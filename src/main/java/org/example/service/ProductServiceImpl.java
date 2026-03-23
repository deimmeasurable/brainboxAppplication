package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.domain.CartItem;
import org.example.domain.Product;
import org.example.repository.CartRepository;
import org.example.repository.ProductRepository;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository repo;

    public Product create(Product product) {
        repo.findByNameIgnoreCase(product.getName())
                .ifPresent(p -> {
                    throw new RuntimeException("Product already exists");
                });

        return repo.save(product);
    }

    public List<Product> getAll() {
        return repo.findAll();
    }

    public Product get(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Not found"));
    }

    public Product update(Long id, Product updated) {
        Product p = get(id);
        p.setName(updated.getName());
        p.setCategory(updated.getCategory());
        p.setPrice(updated.getPrice());
        return repo.save(p);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}


