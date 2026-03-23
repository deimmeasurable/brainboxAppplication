package org.example.dto;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class ProductResponse implements Serializable {
    private String message;
}
