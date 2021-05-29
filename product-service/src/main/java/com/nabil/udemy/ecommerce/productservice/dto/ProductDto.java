package com.nabil.udemy.ecommerce.productservice.dto;

import lombok.*;

/**
 * @author Nabil Fawwaz Elqayyim
 */

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {
    private String id;

    private String description;

    private Integer price;
}
