package io.github.abhishekchd.restaurantbackend.services;

import io.github.abhishekchd.restaurantbackend.dto.Item;
import io.github.abhishekchd.restaurantbackend.exceptions.ItemNotFoundInRestaurantMenuException;
import io.github.abhishekchd.restaurantbackend.exchanges.GetMenuResponse;
import io.github.abhishekchd.restaurantbackend.exchanges.MenuModifiedResponse;
import org.springframework.stereotype.Service;

@Service
public interface MenuService {

    /**
     * Return the restaurant menu.
     *
     * @param restaurantId id of the restaurant
     * @return the restaurant's menu
     */
    GetMenuResponse findMenu(String restaurantId);

    /**
     * Add menu item
     *
     * @param restaurantId if of restaurant
     * @param item         New item to be added
     * @return Modified Menu
     */
    MenuModifiedResponse addMenuItem(String restaurantId, Item item);

    /**
     * Find the item in Menu and update it
     *
     * @param itemId       id of he item
     * @param restaurantId if of restaurant
     * @return Modified Menu
     */
    MenuModifiedResponse findAndUpdateMenuItem(String itemId, String restaurantId);

    /**
     * Find the item in Menu and delete it
     *
     * @param itemId       id of he item
     * @param restaurantId if of restaurant
     * @return Modified Menu
     */
    MenuModifiedResponse findAndDeleteMenuItem(String itemId, String restaurantId);

    /**
     * Find the item in the restaurant using restaurantId/itemId and return the item if found.
     *
     * @param itemId       id of the item
     * @param restaurantId id of the restaurant
     * @return item if found
     * @throws ItemNotFoundInRestaurantMenuException if the item is not found
     */
    Item findItem(String itemId, String restaurantId) throws ItemNotFoundInRestaurantMenuException;
}
