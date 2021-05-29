package com.nabil.udemy.ecommerce.orderservice.service;

import com.nabil.udemy.ecommerce.orderservice.client.ProductClient;
import com.nabil.udemy.ecommerce.orderservice.client.UserClient;
import com.nabil.udemy.ecommerce.orderservice.dto.PurchaseOrderRequestDto;
import com.nabil.udemy.ecommerce.orderservice.dto.PurchaseOrderResponseDto;
import com.nabil.udemy.ecommerce.orderservice.dto.RequestContext;
import com.nabil.udemy.ecommerce.orderservice.repository.PurchaseOrderRepository;
import com.nabil.udemy.ecommerce.orderservice.util.EntityDtoUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;
import reactor.util.retry.Retry;

import java.time.Duration;

/**
 * @author Nabil Fawwaz Elqayyim
 */

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class OrderFulfillmentService {
    private final ProductClient productClient;

    private final UserClient userClient;

    private final PurchaseOrderRepository purchaseOrderRepository;

    public Mono<PurchaseOrderResponseDto> processOrder(Mono<PurchaseOrderRequestDto> requestDtoMono) {
        return requestDtoMono.map(RequestContext::new)
                .flatMap(this::productRequestResponse)
                .doOnNext(EntityDtoUtil::setTransactionRequestDto)
                .flatMap(this::userRequestResponse)
                .map(EntityDtoUtil::getPurchaseOrder)
                .map(purchaseOrderRepository::saveAndFlush) // blocking
                .map(EntityDtoUtil::getPurchaseOrderResponseDto)
                .subscribeOn(Schedulers.boundedElastic()); // prevent blocking operations affected during transaction
    }

    private Mono<RequestContext> productRequestResponse(RequestContext rc) {
        return productClient.getProductById(rc.getPurchaseOrderRequestDto().getProductId())
                .doOnNext(rc::setProductDto)
                .retryWhen(Retry.fixedDelay(5, Duration.ofSeconds(1)))
                .thenReturn(rc);
    }

    private Mono<RequestContext> userRequestResponse(RequestContext rc) {
        return userClient.authorizeTransaction(rc.getTransactionRequestDto())
                .doOnNext(rc::setTransactionResponseDto)
                .thenReturn(rc);
    }
}
