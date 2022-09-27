# REDIS-WITH-SPRING

## Introduction
When thing to work with Redis and Java with spring there era two approaches:
- spring data redis (it works like spring data JPA implementation)
- caching process as we know throughout other languages

## Docker compose with Redis server
```
version: '3'
services:
  redis:
    image: redis
    command: redis-server --requirepass abc1234
    container_name: redis
    ports: 
      - "6379:6379"
```

## References
[A Guide To Caching in Spring](https://www.baeldung.com/spring-cache-tutorial)