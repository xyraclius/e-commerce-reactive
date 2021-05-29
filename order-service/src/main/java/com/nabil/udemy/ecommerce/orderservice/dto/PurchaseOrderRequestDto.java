package com.nabil.udemy.ecommerce.orderservice.dto;

import lombok.Data;
import lombok.ToString;

/**
 * @author Nabil Fawwaz Elqayyim
 */

@Data
@ToString
public class PurchaseOrderRequestDto {

    private Integer userId;

    private String productId;
}
