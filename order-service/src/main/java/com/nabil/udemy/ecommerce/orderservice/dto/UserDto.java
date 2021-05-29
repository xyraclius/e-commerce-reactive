package com.nabil.udemy.ecommerce.orderservice.dto;

import lombok.*;

/**
 * @author Nabil Fawwaz Elqayyim
 */

@Data
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private Integer id;
    private String name;
    private Integer balance;
}