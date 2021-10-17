package com.nabil.udemy.ecommerce.orderservice.dto;

import lombok.*;

import java.io.Serializable;

/**
 * @author Nabil Fawwaz Elqayyim
 */

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto implements Serializable {

    private static final long serialVersionUID = -6557080527778077286L;

    private String id;

    private String description;

    private Integer price;
}
