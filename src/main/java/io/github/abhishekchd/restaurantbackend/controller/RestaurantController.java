package io.github.abhishekchd.restaurantbackend.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.ws.Response;

@RestController
@RequestMapping(RestaurantController.RESTAURANT_API_ENDPOINT)
public class RestaurantController {
    public static final String RESTAURANT_API_ENDPOINT = "/restaurant/v1";
    public static final String MENU_API = "/menu";

    @GetMapping(MENU_API)
    public ResponseEntity<?> getMenu() {
        return ResponseEntity.badRequest().build();
    }
}
