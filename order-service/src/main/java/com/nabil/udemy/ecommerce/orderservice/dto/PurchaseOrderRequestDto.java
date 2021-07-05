package com.nabil.udemy.ecommerce.orderservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @author Nabil Fawwaz Elqayyim
 */

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class PurchaseOrderRequestDto implements Serializable {

    @NotNull(message = "User ID cannot null")
    @Min(message = "User ID is required", value = 1)
    private Integer userId;

    @NotEmpty(message = "Product ID is required")
    @NotNull(message = "Product cannot null")
    private String productId;
}
