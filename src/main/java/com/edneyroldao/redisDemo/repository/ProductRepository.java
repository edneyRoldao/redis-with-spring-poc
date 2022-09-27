package com.edneyroldao.redisDemo.repository;

import com.edneyroldao.redisDemo.model.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends CrudRepository<Product, String> {
}
