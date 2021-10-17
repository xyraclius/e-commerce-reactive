package com.nabil.udemy.ecommerce.userservice.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

/**
 * @author Nabil Fawwaz Elqayyim
 */

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table("user_transaction")
public class UserTransactionEntity {

    @Id
    private Integer id;

    private Integer userId;

    private Integer amount;

    private LocalDateTime transactionDate;

}
