package io.github.abhishekchd.restaurantbackend.exceptions;

public class ItemNotFoundInRestaurantMenuException extends RuntimeException {

    public ItemNotFoundInRestaurantMenuException(String message) {
        super(message);
    }
}
