package com.kafka.kafka_messaging.Repository;

import com.kafka.kafka_messaging.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}