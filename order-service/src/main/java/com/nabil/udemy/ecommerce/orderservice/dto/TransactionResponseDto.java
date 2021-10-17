package com.nabil.udemy.ecommerce.orderservice.dto;

import lombok.*;

import java.io.Serializable;

/**
 * @author Nabil Fawwaz Elqayyim
 */

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TransactionResponseDto implements Serializable {

    private static final long serialVersionUID = -6572358935195018646L;

    private Integer userId;

    private Integer amount;

    private TransactionStatus status;
}
