package org.example.api;

import lombok.RequiredArgsConstructor;
import org.example.domain.Product;
import org.example.dto.ProductRequest;
import org.example.dto.ProductResponse;
import org.example.dto.UpdateProductRequest;
import org.example.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService service;

    @PostMapping
    public ProductResponse create(@RequestBody ProductRequest p) {
        ProductResponse response=  service.create(p);

        return response;
    }

    @GetMapping
    public List<Product> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Product getAProduct(@PathVariable Long id) {
        return service.getAProduct(id);
    }

    @PutMapping("/{id}")
    public ProductResponse update(@PathVariable Long id, @RequestBody UpdateProductRequest updateProductRequest) {
        return service.updateProduct(id, updateProductRequest);
    }

    @DeleteMapping("/{id}")
    public ProductResponse delete(@PathVariable Long id) {
       return service.delete(id);
    }
}


