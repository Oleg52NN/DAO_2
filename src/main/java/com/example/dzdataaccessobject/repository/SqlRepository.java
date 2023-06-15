package com.example.dzdataaccessobject.repository;

import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository

public class SqlRepository {
    private final NamedParameterJdbcTemplate template;
    private final String sql;

    public SqlRepository(NamedParameterJdbcTemplate template) {
        this.template = template;
        this.sql = read("join.sql");
    }

    private static String read(String sqlFileName) {
        try (InputStream is = new ClassPathResource(sqlFileName).getInputStream();
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is))) {
            return bufferedReader.lines().collect(Collectors.joining("\n"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<String> getProductName(String name) {
        return template.queryForList(
                this.sql,
                Map.of("name", name),
                String.class);
    }
}
