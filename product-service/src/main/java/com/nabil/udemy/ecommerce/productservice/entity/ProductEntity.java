package com.nabil.udemy.ecommerce.productservice.entity;

import lombok.*;
import org.springframework.data.annotation.Id;

/**
 * @author Nabil Fawwaz Elqayyim
 */

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ProductEntity {

    @Id
    private String id;

    private String description;

    private Integer price;
}
