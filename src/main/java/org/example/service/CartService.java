package org.example.service;

import org.example.domain.CartItem;
import org.example.dto.CartRequest;

import java.util.List;

public interface CartService {
    CartItem createCart(CartRequest request);
    void addToCart(Long cartId, Long productId);
    List<CartItem> viewCart(Long cartId);
    Double getTotal(Long cartId);
    void removeItem(Long cartId, Long productId);
}
