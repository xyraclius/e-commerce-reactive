package com.nabil.udemy.ecommerce.orderservice.util;

import com.nabil.udemy.ecommerce.orderservice.dto.*;
import com.nabil.udemy.ecommerce.orderservice.entity.PurchaseOrder;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

/**
 * @author Nabil Fawwaz Elqayyim
 */

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class EntityDtoUtil {

    public static PurchaseOrderResponseDto getPurchaseOrderResponseDto(PurchaseOrder purchaseOrder) {
        PurchaseOrderResponseDto dto = new PurchaseOrderResponseDto();
        BeanUtils.copyProperties(purchaseOrder, dto);
        dto.setOrderId(purchaseOrder.getId());
        return dto;
    }

    public static void setTransactionRequestDto(RequestContext requestContext) {
        TransactionRequestDto dto = TransactionRequestDto.builder()
                .userId(requestContext.getPurchaseOrderRequestDto().getUserId())
                .amount(requestContext.getProductDto().getPrice())
                .build();
        requestContext.setTransactionRequestDto(dto);
    }

    public static PurchaseOrder getPurchaseOrder(RequestContext requestContext) {
        TransactionStatus status = requestContext.getTransactionResponseDto().getStatus();
        return PurchaseOrder.builder()
                .userId(requestContext.getPurchaseOrderRequestDto().getUserId())
                .productId(requestContext.getPurchaseOrderRequestDto().getProductId())
                .amount(requestContext.getProductDto().getPrice())
                .status(TransactionStatus.APPROVED.equals(status) ? OrderStatus.COMPLETED : OrderStatus.FAILED).build();
    }
}
