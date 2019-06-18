package io.github.abhishekchd.restaurantbackend.repository;

import io.github.abhishekchd.restaurantbackend.models.OrderEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrderRepository extends MongoRepository<OrderEntity, String> {

}

