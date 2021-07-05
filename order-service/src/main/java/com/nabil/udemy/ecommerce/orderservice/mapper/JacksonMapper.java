package com.nabil.udemy.ecommerce.orderservice.mapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;

import java.io.IOException;
import java.io.OutputStream;

/**
 * @author Nabil Fawwaz Elqayyim
 */

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class JacksonMapper {
    private static final ObjectMapper mapper = new ObjectMapper();

    @SneakyThrows(JsonProcessingException.class)
    public static JsonNode readTree(String content) {
        return mapper.readTree(content);
    }

    @SneakyThrows(IOException.class)
    public static void writeValue(OutputStream out, Object value) {
        mapper.writeValue(out, value);
    }
}
