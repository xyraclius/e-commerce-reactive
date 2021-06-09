package com.nabil.udemy.ecommerce.orderservice.dto;

import lombok.*;

import java.io.Serializable;

/**
 * @author Nabil Fawwaz Elqayyim
 */

@Data
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TransactionRequestDto implements Serializable {

    private Integer userId;
    private Integer amount;

}
