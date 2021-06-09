package com.nabil.udemy.ecommerce.orderservice.router;

import com.nabil.udemy.ecommerce.orderservice.handler.PurchaseOrderHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

/**
 * @author Nabil Fawwaz Elqayyim
 */

@Configuration
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class PurchaseOrderRouter {
    private final PurchaseOrderHandler purchaseOrderHandler;

    @Bean
    public RouterFunction<ServerResponse> routerFunction() {
        return RouterFunctions.route()
                .POST("/order", purchaseOrderHandler::order)
                .GET("/order/user/{userId}",purchaseOrderHandler::getOrdersByUserId)
                .build();

    }
}
