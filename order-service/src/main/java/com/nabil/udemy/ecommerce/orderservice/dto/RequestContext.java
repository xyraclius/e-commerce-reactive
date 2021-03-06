package com.nabil.udemy.ecommerce.orderservice.dto;

import lombok.*;

/**
 * @author Nabil Fawwaz Elqayyim
 */

@Getter
@Setter
@ToString
@NoArgsConstructor
@RequiredArgsConstructor
public class RequestContext {
    @NonNull
    private PurchaseOrderRequestDto purchaseOrderRequestDto;

    private ProductDto productDto;

    private TransactionRequestDto transactionRequestDto;

    private TransactionResponseDto transactionResponseDto;
}
