package org.example.api;

import lombok.RequiredArgsConstructor;
import org.example.domain.Cart;
import org.example.domain.CartItem;
import org.example.dto.CartItemResponse;
import org.example.dto.CartRequest;
import org.example.service.CartService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cart")
@RequiredArgsConstructor
public class CartItemController {
    private final CartService service;

    @PostMapping
    public Cart createCart(CartRequest cartRequest) {
        return service.createCart(cartRequest);
    }

    @PostMapping("/{cartId}/add/{productId}")
    public void addToCart(@PathVariable Long cartId, @PathVariable Long productId) {
        service.addToCart(cartId, productId);
    }

    @GetMapping("/{cartId}")
    public List<CartItemResponse> viewCart(@PathVariable Long cartId) {
        return service.viewCart(cartId);
    }

    @GetMapping("/{cartId}/total")
    public Double total(@PathVariable Long cartId) {
        return service.getTotal(cartId);
    }

    @DeleteMapping("/{cartId}/remove/{productId}")
    public void remove(@PathVariable Long cartId, @PathVariable Long productId) {
        service.removeItem(cartId, productId);
    }
}
