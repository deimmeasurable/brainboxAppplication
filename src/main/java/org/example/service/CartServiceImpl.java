package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.domain.Cart;
import org.example.domain.CartItem;
import org.example.domain.Product;
import org.example.dto.CartItemResponse;
import org.example.dto.CartRequest;
import org.example.repository.CartItemRepository;
import org.example.repository.CartRepository;
import org.example.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CartServiceImpl implements CartService {

    private final CartRepository cartRepo;
    private final ProductRepository productRepo;
    private final CartItemRepository itemRepo;

    public Cart createCart(CartRequest request) {

        Cart cart = new Cart();

        cart.setUserId(request.getUserId());

        return cartRepo.save(cart);
    }
    public void addToCart(Long cartId, Long productId) {

        if (itemRepo.existsByCartIdAndProductId(cartId, productId)) {
            throw new RuntimeException("Product already in cart");
        }

        Cart cart = cartRepo.findById(cartId).orElseThrow();
        Product product = productRepo.findById(productId).orElseThrow();

        CartItem item = new CartItem();
        item.setCart(cart);
        item.setProduct(product);

        itemRepo.save(item);
    }
    public List<CartItemResponse> viewCart(Long cartId) {

        return itemRepo.findByCartId(cartId)
                .stream()
                .map(item -> new CartItemResponse(
                        item.getProduct().getName(),
                        item.getProduct().getCategory(),
                        item.getProduct().getPrice()
                ))
                .toList();
    }

    public Double getTotal(Long cartId) {
        return itemRepo.findByCartId(cartId)
                .stream()
                .mapToDouble(i -> i.getProduct().getPrice())
                .sum();
    }

    public void removeItem(Long cartId, Long productId) {
        CartItem item = itemRepo.findByIdAndProductId(cartId, productId)
                .orElseThrow();

        itemRepo.delete(item);
    }
}
