package org.example.repository;
@Repository
public interface CartRepository extends JpaRepository<CartItem, Long> {
    // Check if product is already in the cart
    boolean existsByProduct(Product product);

    // Find cart item by product ID for removal logic
    Optional<CartItem> findByProductId(Long productId);
}
