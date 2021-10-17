package com.nabil.udemy.ecommerce.userservice.dto;

import lombok.*;

/**
 * @author Nabil Fawwaz Elqayyim
 */

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private Integer id;
    private String name;
    private Integer balance;
}
