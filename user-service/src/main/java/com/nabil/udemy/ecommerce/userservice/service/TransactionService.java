package com.nabil.udemy.ecommerce.userservice.service;

import com.nabil.udemy.ecommerce.userservice.dto.TransactionRequestDto;
import com.nabil.udemy.ecommerce.userservice.dto.TransactionResponseDto;
import com.nabil.udemy.ecommerce.userservice.dto.TransactionStatus;
import com.nabil.udemy.ecommerce.userservice.repository.UserRepository;
import com.nabil.udemy.ecommerce.userservice.repository.UserTransactionRepository;
import com.nabil.udemy.ecommerce.userservice.util.EntityDtoUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

/**
 * @author Nabil Fawwaz Elqayyim
 */

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class TransactionService {

    private final UserRepository userRepository;

    private final UserTransactionRepository transactionRepository;

    public Mono<TransactionResponseDto> createTransaction(final TransactionRequestDto requestDto) {
        return userRepository.updateUserEntityBalance(requestDto.getUserId(), requestDto.getAmount())
                .filter(Boolean::booleanValue)
                .map(b -> EntityDtoUtil.toEntity(requestDto))
                .flatMap(transactionRepository::save)
                .map(ut -> EntityDtoUtil.toDto(requestDto, TransactionStatus.APPROVED))
                .defaultIfEmpty(EntityDtoUtil.toDto(requestDto, TransactionStatus.DECLINED));
    }


}
