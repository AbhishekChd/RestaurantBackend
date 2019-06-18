package io.github.abhishekchd.restaurantbackend.repository;

import io.github.abhishekchd.restaurantbackend.models.ItemEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface ItemRepository extends MongoRepository<ItemEntity, String> {

    Optional<ItemEntity> findItemByItemId(String itemId);
}
