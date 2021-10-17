package com.nabil.udemy.ecommerce.orderservice.client;

import com.nabil.udemy.ecommerce.orderservice.dto.TransactionRequestDto;
import com.nabil.udemy.ecommerce.orderservice.dto.TransactionResponseDto;
import com.nabil.udemy.ecommerce.orderservice.dto.UserDto;
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
public class UserClient {

    private WebClient webClient;

    @Value("${user.service.url}")
    private String url;

    @Bean
    public void userServiceBaseUrl() {
        this.webClient = WebClient.builder().baseUrl(url).build();
    }

    public Mono<TransactionResponseDto> authorizeTransaction(TransactionRequestDto requestDto) {
        return webClient.post().uri("transaction").bodyValue(requestDto).retrieve().bodyToMono(TransactionResponseDto.class);
    }

    public Flux<UserDto> getAllUsers() {
        return webClient.get().uri("all").retrieve().bodyToFlux(UserDto.class);
    }
}
