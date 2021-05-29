package com.nabil.udemy.ecommerce.userservice.controller;

import com.nabil.udemy.ecommerce.userservice.dto.TransactionRequestDto;
import com.nabil.udemy.ecommerce.userservice.dto.TransactionResponseDto;
import com.nabil.udemy.ecommerce.userservice.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * @author Nabil Fawwaz Elqayyim
 */

@RestController
@RequestMapping("user/transaction")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserTransactionController {
    private final TransactionService transactionService;

    @PostMapping
    public Mono<TransactionResponseDto> createTransaction(@RequestBody Mono<TransactionRequestDto> requestDtoMono) {
        return requestDtoMono.flatMap(this.transactionService::createTransaction);
    }
}
