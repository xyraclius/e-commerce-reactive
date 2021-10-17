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
public class TransactionRequestDto implements Serializable {

    private static final long serialVersionUID = 830211206886224066L;

    private Integer userId;

    private Integer amount;

}
