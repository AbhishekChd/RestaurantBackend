package io.github.abhishekchd.restaurantbackend.repositoryservices;

import io.github.abhishekchd.restaurantbackend.dto.Menu;

public interface MenuRepositoryService {

    /**
     * TODO:  Implement findMenu
     * Return the restaurant menu.
     *
     * @param restaurantId id of the restaurant
     * @return the restaurant's menu
     */
    Menu findMenu(String restaurantId);

    /**
     * TODO:  Implement updateMenu
     * Return the restaurant menu.
     *
     * @param restaurantId id of the restaurant
     * @return the restaurant's menu
     */

    Menu updateMenu(String restaurantId);

}


