package com.nabil.udemy.ecommerce.userservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.io.Resource;
import org.springframework.data.r2dbc.core.R2dbcEntityTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.util.StreamUtils;

import java.nio.charset.StandardCharsets;

/**
 * @author Nabil Fawwaz Elqayyim
 */

@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class DataSetupService implements CommandLineRunner {

    @Value("classpath:init.sql")
    private Resource initSql;

    private final R2dbcEntityTemplate entityTemplate;

    @Override // Create table on startup application
    public void run(String... args) throws Exception {
//        String query = StreamUtils.copyToString(initSql.getInputStream(), StandardCharsets.UTF_8);
//        System.out.println(query);
//        entityTemplate
//                .getDatabaseClient()
//                .sql(query)
//                .then()
//                .subscribe();
    }
}
