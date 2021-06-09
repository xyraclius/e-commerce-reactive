package com.nabil.udemy.ecommerce.orderservice.dto;

import lombok.*;

import java.io.Serializable;

/**
 * @author Nabil Fawwaz Elqayyim
 */

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto implements Serializable {
    private String id;

    private String description;

    private Integer price;
}
