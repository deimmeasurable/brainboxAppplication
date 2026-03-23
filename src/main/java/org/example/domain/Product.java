package org.example.domain;

import lombok.Data;

@Entity
@Data
@Table(name="m_product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String name;

    private String category;
    private Double price;
}
