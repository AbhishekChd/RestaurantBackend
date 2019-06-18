package io.github.abhishekchd.restaurantbackend.repositoryservices;

import io.github.abhishekchd.restaurantbackend.dto.Item;
import io.github.abhishekchd.restaurantbackend.dto.Menu;

import java.util.Optional;

public interface MenuRepositoryService {

    /**
     * Return the restaurant menu.
     *
     * @param restaurantId id of the restaurant
     * @return the restaurant's menu
     */
    Menu findMenu(String restaurantId);


    /**
     * Add menu item
     *
     * @param restaurantId if of restaurant
     * @param item         New item to be added
     * @return Modified Menu
     */
    Menu addMenuItem(String restaurantId, Item item);

    /**
     * Find the item in Menu and update it
     *
     * @param restaurantId if of restaurant
     * @param itemId       id of he item
     * @param item         item to be updated
     * @return Modified Menu
     */
    Menu findAndUpdateMenuItem(String restaurantId, String itemId, Item item);

    /**
     * Find the item in Menu and delete it
     *
     * @param itemId       id of he item
     * @param restaurantId if of restaurant
     * @return Modified Menu
     */
    Menu findAndDeleteMenuItem(String itemId, String restaurantId);

    /**
     * Find the item in the restaurant using restaurantId/itemId and return the item if found.
     *
     * @param itemId       id of the item
     * @param restaurantId id of the restaurant
     * @return item if found
     */
    Optional<Item> findItem(String itemId, String restaurantId);
}


