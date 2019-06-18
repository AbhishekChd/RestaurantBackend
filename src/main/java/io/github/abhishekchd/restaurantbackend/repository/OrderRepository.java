package io.github.abhishekchd.restaurantbackend.repository;

import io.github.abhishekchd.restaurantbackend.dto.Order;
import io.github.abhishekchd.restaurantbackend.models.OrderEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface OrderRepository extends MongoRepository<OrderEntity, String> {

    Optional<List<OrderEntity>> findOrdersByRestaurantId(String restaurantId);
}

