package org.example.domain;

import lombok.Data;

@Data
@Entity
@Table(name="m_cartItem")
public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
}
