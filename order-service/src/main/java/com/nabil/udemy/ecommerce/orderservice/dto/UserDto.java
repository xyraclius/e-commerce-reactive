package com.nabil.udemy.ecommerce.orderservice.dto;

import lombok.*;

import java.io.Serializable;

/**
 * @author Nabil Fawwaz Elqayyim
 */

@Data
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDto implements Serializable {
    private Integer id;
    private String name;
    private Integer balance;
}
