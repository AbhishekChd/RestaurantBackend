package io.github.abhishekchd.restaurantbackend.repository;

import io.github.abhishekchd.restaurantbackend.models.MenuEntity;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface MenuRepository extends MongoRepository<MenuEntity, String> {

    Optional<MenuEntity> findMenuByRestaurantId(String restaurantId);
}

