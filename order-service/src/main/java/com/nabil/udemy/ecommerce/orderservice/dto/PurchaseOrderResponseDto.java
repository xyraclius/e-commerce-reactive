package com.nabil.udemy.ecommerce.orderservice.dto;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author Nabil Fawwaz Elqayyim
 */

@Data
@ToString
public class PurchaseOrderResponseDto implements Serializable {

    private Integer orderId;

    private Integer userId;

    private String productId;

    private Integer amount;

    private OrderStatus status;
}
