package com.nabil.udemy.ecommerce.orderservice.client;

import com.nabil.udemy.ecommerce.orderservice.dto.ProductDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author Nabil Fawwaz Elqayyim
 */

@Service
public class ProductClient {

    private WebClient webClient;

    @Value("${product.service.url}")
    private String url;

    @Bean
    public void productServiceBaseUrl() {
        this.webClient = WebClient.builder().baseUrl(url).build();
    }

    public Mono<ProductDto> getProductById(final String productId) {
        return webClient.get().uri("{id}", productId).retrieve().bodyToMono(ProductDto.class);
    }

    public Flux<ProductDto> getAllProducts() {
        return webClient.get().uri("all").retrieve().bodyToFlux(ProductDto.class);
    }
}
