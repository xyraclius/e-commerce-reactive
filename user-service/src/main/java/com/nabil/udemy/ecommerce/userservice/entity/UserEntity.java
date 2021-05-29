package com.nabil.udemy.ecommerce.userservice.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

/**
 * @author Nabil Fawwaz Elqayyim
 */

@Data
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table("users")
public class UserEntity {

    @Id
    private Integer id;
    private String name;
    private Integer balance;

}
