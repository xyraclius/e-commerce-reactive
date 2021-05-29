package com.nabil.udemy.ecommerce.userservice.util;

import com.nabil.udemy.ecommerce.userservice.dto.TransactionRequestDto;
import com.nabil.udemy.ecommerce.userservice.dto.TransactionResponseDto;
import com.nabil.udemy.ecommerce.userservice.dto.TransactionStatus;
import com.nabil.udemy.ecommerce.userservice.dto.UserDto;
import com.nabil.udemy.ecommerce.userservice.entity.UserEntity;
import com.nabil.udemy.ecommerce.userservice.entity.UserTransactionEntity;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @author Nabil Fawwaz Elqayyim
 */

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class EntityDtoUtil {

    public static UserDto toDto(UserEntity userEntity) {
        return UserDto.builder()
                .id(userEntity.getId())
                .name(userEntity.getName())
                .balance(userEntity.getBalance())
                .build();
    }

    public static UserEntity toEntity(UserDto userDto) {
        return UserEntity.builder()
                .id(userDto.getId())
                .name(userDto.getName())
                .balance(userDto.getBalance())
                .build();
    }

    public static UserTransactionEntity toEntity(TransactionRequestDto transactionRequestDto) {
        return UserTransactionEntity.builder()
                .userId(transactionRequestDto.getUserId())
                .amount(transactionRequestDto.getAmount())
                .transactionDate(LocalDateTime.now())
                .build();
    }

    public static TransactionResponseDto toDto(TransactionRequestDto requestDto, TransactionStatus status) {
        return TransactionResponseDto.builder()
                .userId(requestDto.getUserId())
                .amount(requestDto.getAmount())
                .status(status)
                .build();
    }
}
