package com.nabil.udemy.ecommerce.orderservice.dto;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author Nabil Fawwaz Elqayyim
 */

@Data
@ToString
public class PurchaseOrderRequestDto implements Serializable {

    private Integer userId;

    private String productId;
}
