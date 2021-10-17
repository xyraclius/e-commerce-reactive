package com.nabil.udemy.ecommerce.productservice.dto;

import lombok.*;

/**
 * @author Nabil Fawwaz Elqayyim
 */

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {
    private String id;

    private String description;

    private Integer price;
}
