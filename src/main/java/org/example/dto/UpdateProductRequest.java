package org.example.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UpdateProductRequest {
    private String name;
    private String category;
    private Double price;
}
