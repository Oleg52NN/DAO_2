package com.example.dzdataaccessobject.controller;

import com.example.dzdataaccessobject.service.SqlService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SqlController {
    private final SqlService service;

    public SqlController(SqlService service) {
        this.service = service;
    }

    @GetMapping("/products/fetch-product")
    public List<String> fetchProduct(@RequestParam("name") String name) {

        return service.getProducts(name);
    }

}

