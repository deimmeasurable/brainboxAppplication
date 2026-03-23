package org.example.dto;

import lombok.Data;

import java.io.Serializable;
@Data
public class CartRequest implements Serializable {
        private String userId;
}
