package com.nabil.udemy.ecommerce.userservice.dto;

import lombok.*;

/**
 * @author Nabil Fawwaz Elqayyim
 */

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TransactionResponseDto {
    private Integer userId;
    private Integer amount;
    private TransactionStatus status;
}
