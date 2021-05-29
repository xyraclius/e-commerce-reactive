package com.nabil.udemy.ecommerce.orderservice.controller;

import com.nabil.udemy.ecommerce.orderservice.dto.PurchaseOrderRequestDto;
import com.nabil.udemy.ecommerce.orderservice.dto.PurchaseOrderResponseDto;
import com.nabil.udemy.ecommerce.orderservice.service.OrderFulfillmentService;
import com.nabil.udemy.ecommerce.orderservice.service.OrderQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClientRequestException;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author Nabil Fawwaz Elqayyim
 */

@RestController
@RequestMapping("order")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class PurchaseOrderController {

    private final OrderFulfillmentService orderFulfillmentService;

    private final OrderQueryService queryService;

    @PostMapping
    public Mono<ResponseEntity<PurchaseOrderResponseDto>> order(@RequestBody Mono<PurchaseOrderRequestDto> requestDtoMono) {
        return orderFulfillmentService.processOrder(requestDtoMono)
                .map(ResponseEntity::ok)
                .onErrorReturn(WebClientResponseException.class, ResponseEntity.badRequest().build())
                .onErrorReturn(WebClientRequestException.class, ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).build());
    }

    @GetMapping("user/{userId}")
    public Flux<PurchaseOrderResponseDto> getOrdersByUserId(@PathVariable int userId) {
        return queryService.getProductsByUserId(userId);
    }
}
