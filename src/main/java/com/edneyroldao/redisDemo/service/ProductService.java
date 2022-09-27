package com.edneyroldao.redisDemo.service;

import com.edneyroldao.redisDemo.model.Product;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Slf4j
@Service
public class ProductService {

    private final List<Product> products;

    public ProductService() {
        this.products = Arrays.asList(
                new Product("1", "test1"),
                new Product("2", "test2"),
                new Product("3", "test3"));
    }

    @SneakyThrows
    @Cacheable(value = "products")
    public Product getProductWithCache(String productId) {
        log.warn("Calling method. Not caching");

        TimeUnit.SECONDS.sleep(3);

        return products.stream()
                .filter(p -> p.getId().equals(productId))
                .findAny()
                .orElseThrow(() -> new RuntimeException("product not found"));
    }



}
