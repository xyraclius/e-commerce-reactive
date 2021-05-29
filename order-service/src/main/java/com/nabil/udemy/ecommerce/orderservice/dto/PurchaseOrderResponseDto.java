package com.nabil.udemy.ecommerce.orderservice.dto;

import lombok.Data;
import lombok.ToString;

/**
 * @author Nabil Fawwaz Elqayyim
 */

@Data
@ToString
public class PurchaseOrderResponseDto {

    private Integer orderId;

    private Integer userId;

    private String productId;

    private Integer amount;

    private OrderStatus status;
}
