package com.nabil.udemy.ecommerce.orderservice.handler;

import com.nabil.udemy.ecommerce.orderservice.dto.PurchaseOrderRequestDto;
import com.nabil.udemy.ecommerce.orderservice.dto.PurchaseOrderResponseDto;
import com.nabil.udemy.ecommerce.orderservice.service.OrderFulfillmentService;
import com.nabil.udemy.ecommerce.orderservice.service.OrderQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

/**
 * @author Nabil Fawwaz Elqayyim
 */

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class PurchaseOrderHandler {
    private final OrderFulfillmentService orderFulfillmentService;

    private final OrderQueryService queryService;

    public Mono<ServerResponse> order(ServerRequest request) {
        Mono<PurchaseOrderRequestDto> requestDtoMono = request.bodyToMono(PurchaseOrderRequestDto.class);
        return ServerResponse.ok().body(orderFulfillmentService.processOrder(requestDtoMono), PurchaseOrderResponseDto.class);
//                .map(ResponseEntity::ok)
//                .onErrorReturn(WebClientResponseException.class, ResponseEntity.badRequest().build())
//                .onErrorReturn(WebClientRequestException.class, ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).build());
    }

    public Mono<ServerResponse> getOrdersByUserId(ServerRequest request) {
        int userId = Integer.parseInt(request.pathVariable("userId"));
        return ServerResponse.ok().body(queryService.getProductsByUserId(userId), PurchaseOrderResponseDto.class);
    }
}
