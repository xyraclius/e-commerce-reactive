package com.nabil.udemy.ecommerce.orderservice.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author Nabil Fawwaz Elqayyim
 */

@Getter
@Setter
@ToString
public class PurchaseOrderResponseDto implements Serializable {

    private static final long serialVersionUID = -1764477141938400675L;

    private Integer orderId;

    private Integer userId;

    private String productId;

    private Integer amount;

    private OrderStatus status;
}
