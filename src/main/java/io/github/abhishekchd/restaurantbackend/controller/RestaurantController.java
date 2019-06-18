package io.github.abhishekchd.restaurantbackend.controller;

import io.github.abhishekchd.restaurantbackend.exchanges.GetMenuRequest;
import io.github.abhishekchd.restaurantbackend.exchanges.GetMenuResponse;
import io.github.abhishekchd.restaurantbackend.services.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(RestaurantController.RESTAURANT_API_ENDPOINT)
public class RestaurantController {

    @Autowired
    private MenuService menuService;

    public static final String RESTAURANT_API_ENDPOINT = "/restaurant/v1";
    public static final String MENU_API = "/menu";

    @GetMapping(MENU_API)
    public ResponseEntity<GetMenuResponse> getMenu(GetMenuRequest getMenuRequest) {
        String restaurantId = getMenuRequest.getRestaurantId();
        if (restaurantId == null || restaurantId.equals("")) {
            return ResponseEntity.badRequest().build();
        } else {

            GetMenuResponse response = menuService.findMenu(restaurantId);
            return ResponseEntity.ok().body(response);
        }

    }

}

