package com.nabil.udemy.ecommerce.orderservice.dto;

import lombok.*;

/**
 * @author Nabil Fawwaz Elqayyim
 */

@Data
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TransactionRequestDto {

    private Integer userId;
    private Integer amount;

}
