package com.edneyroldao.redisDemo.controller;

import com.edneyroldao.redisDemo.model.Product;
import com.edneyroldao.redisDemo.repository.ProductRepository;
import com.edneyroldao.redisDemo.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("redis-test")
public class ProductController {

    private final ProductService service;
    private final ProductRepository repository;

    @PostMapping("create")
    @ResponseStatus(HttpStatus.CREATED)
    public String createProduct(@RequestBody Product product) {
        repository.save(product);
        return "product saved";
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Product getProduct(@PathVariable String id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("product not found"));
    }


    @GetMapping("/cacheable/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Product getCacheableProduct(@PathVariable String id) {
        return service.getProductWithCache(id);
    }

}
