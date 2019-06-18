package io.github.abhishekchd.restaurantbackend.services;

import io.github.abhishekchd.restaurantbackend.dto.Item;
import io.github.abhishekchd.restaurantbackend.dto.Menu;
import io.github.abhishekchd.restaurantbackend.exceptions.ItemNotFoundInRestaurantMenuException;
import io.github.abhishekchd.restaurantbackend.exchanges.GetMenuResponse;
import io.github.abhishekchd.restaurantbackend.exchanges.MenuModifiedResponse;
import org.springframework.stereotype.Service;

@Service
public class MenuServiceImpl implements MenuService {
    @Override public GetMenuResponse findMenu(String restaurantId) {
        return new GetMenuResponse(new Menu());
    }

    @Override public MenuModifiedResponse addMenuItem(String restaurantId, Item item) {
        return new MenuModifiedResponse(new Menu());
    }

    @Override public MenuModifiedResponse findAndUpdateMenuItem(String itemId, String restaurantId) {
        return new MenuModifiedResponse();
    }

    @Override public MenuModifiedResponse findAndDeleteMenuItem(String itemId, String restaurantId) {
        return new MenuModifiedResponse();
    }

    @Override public Item findItem(String itemId, String restaurantId) throws ItemNotFoundInRestaurantMenuException {
        return new Item();
    }
}
