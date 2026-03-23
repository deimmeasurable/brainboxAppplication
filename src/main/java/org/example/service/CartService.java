package org.example.service;

import org.example.domain.Cart;
import org.example.domain.CartItem;
import org.example.dto.CartItemResponse;
import org.example.dto.CartRequest;

import java.util.List;

public interface CartService {
    Cart createCart(CartRequest request);
    void addToCart(Long cartId, Long productId);
    List<CartItemResponse> viewCart(Long cartId);
    Double getTotal(Long cartId);
    void removeItem(Long cartId, Long productId);
}
