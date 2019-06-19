package io.github.abhishekchd.restaurantbackend.services;

import io.github.abhishekchd.restaurantbackend.dto.Item;
import io.github.abhishekchd.restaurantbackend.dto.Menu;
import io.github.abhishekchd.restaurantbackend.exceptions.ItemNotFoundInRestaurantMenuException;
import io.github.abhishekchd.restaurantbackend.exchanges.GetMenuResponse;
import io.github.abhishekchd.restaurantbackend.exchanges.MenuModifiedResponse;
import io.github.abhishekchd.restaurantbackend.repositoryservices.MenuRepositoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuRepositoryService menuRepositoryService;

    @Override public GetMenuResponse findMenu(String restaurantId) {
        Menu menu = menuRepositoryService.findMenu(restaurantId);
        return new GetMenuResponse(menu);
    }

    @Override public MenuModifiedResponse addMenuItem(String restaurantId, Item item) {
        return new MenuModifiedResponse(menuRepositoryService.addMenuItem(restaurantId, item));
    }

    @Override public MenuModifiedResponse findAndUpdateMenuItem(String restaurantId, String itemId, Item item) {
        return new MenuModifiedResponse(menuRepositoryService.findAndUpdateMenuItem(restaurantId, itemId, item));
    }

    @Override public MenuModifiedResponse findAndDeleteMenuItem(String itemId, String restaurantId) {
        return new MenuModifiedResponse(menuRepositoryService.findAndDeleteMenuItem(itemId, restaurantId));
    }

    @Override public Item findItem(String itemId, String restaurantId) throws ItemNotFoundInRestaurantMenuException {
        Optional<Item> item = menuRepositoryService.findItem(itemId, restaurantId);
        return item.orElseGet(Item::new);
    }
}
