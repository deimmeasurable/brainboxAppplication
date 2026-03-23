package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.domain.CartItem;
import org.example.dto.CartRequest;
import org.example.repository.CartRepository;
import org.example.repository.ProductRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CartServiceImpl {

    private final CartRepository cartRepo;
    private final ProductRepository productRepo;
    private final CartRepository itemRepo;

    public CartItem createCart(CartRequest request) {

        CartItem cart = new CartItem();

        // Optional: if you later add user relationship
        cart.setUserId(request.getUserId());

        return cartRepo.save(cart);
    }
    public void addToCart(Long cartId, Long productId) {
        Cart cart = cartRepo.findById(cartId)
                .orElseThrow();

        Product product = productRepo.findById(productId)
                .orElseThrow();

        itemRepo.findByCartIdAndProductId(cartId, productId)
                .ifPresent(i -> {
                    throw new RuntimeException("Product already in cart");
                });

        CartItem item = new CartItem();
        item.setCart(cart);
        item.setProduct(product);

        itemRepo.save(item);
    }

    public List<CartItem> viewCart(Long cartId) {
        return itemRepo.findByCartId(cartId);
    }

    public Double getTotal(Long cartId) {
        return itemRepo.findByCartId(cartId)
                .stream()
                .mapToDouble(i -> i.getProduct().getPrice())
                .sum();
    }

    public void removeItem(Long cartId, Long productId) {
        CartItem item = itemRepo.findByCartIdAndProductId(cartId, productId)
                .orElseThrow();

        itemRepo.delete(item);
    }
}
