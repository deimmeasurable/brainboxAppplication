package org.example.api;

import org.example.dto.CartRequest;
import org.example.service.CartService;

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
    public List<CartItem> viewCart(@PathVariable Long cartId) {
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
