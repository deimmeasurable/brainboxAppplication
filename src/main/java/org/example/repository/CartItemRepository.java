package org.example.repository;

import org.example.domain.CartItem;
import org.example.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CartItemRepository extends JpaRepository<CartItem, Long> {
    List<CartItem> findByCartId(Long cartId);
    Optional<CartItem> findByIdAndProductId(Long cartId, Long productId);
    boolean existsByCartIdAndProductId(Long cartId, Long productId);
    Optional<CartItem> findByProductId(Long productId);
}
