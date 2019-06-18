package io.github.abhishekchd.restaurantbackend.controller;

import io.github.abhishekchd.restaurantbackend.dto.Item;
import io.github.abhishekchd.restaurantbackend.dto.Status;
import io.github.abhishekchd.restaurantbackend.exchanges.*;
import io.github.abhishekchd.restaurantbackend.services.MenuService;
import io.github.abhishekchd.restaurantbackend.services.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@Slf4j
@RequestMapping(RestaurantController.RESTAURANT_API_ENDPOINT)
public class RestaurantController {

    @Autowired
    private MenuService menuService;

    @Autowired
    private OrderService orderService;

    public static final String RESTAURANT_API_ENDPOINT = "/restaurant/v1";
    private static final String MENU_API = "/menu";
    private static final String ITEM_API = "/item";
    private static final String ORDER_API = "/order";
    private static final String ORDER_HISTORY_API = "/order/history";
    private static final String ORDER_ACTIVE_API = "/order/active";

    @GetMapping(MENU_API)
    public ResponseEntity<GetMenuResponse> getMenu(GetMenuRequest getMenuRequest) {
        log.info("GetMenuRequest {}", getMenuRequest);
        String restaurantId = getMenuRequest.getRestaurantId();
        if (restaurantId == null || restaurantId.equals("")) {
            return ResponseEntity.badRequest().build();
        } else {
            GetMenuResponse response = menuService.findMenu(restaurantId);
            return ResponseEntity.ok().body(response);
        }

    }

    @PostMapping(ITEM_API)
    public ResponseEntity<MenuModifiedResponse> addMenuItem(AddMenuItemRequest addMenuItemRequest) {
        String restaurantId = addMenuItemRequest.getRestaurantId();
        Item item = addMenuItemRequest.getItem();
        if (StringUtils.isEmpty(restaurantId) || item == null) {
            return ResponseEntity.badRequest().build();
        } else {
            MenuModifiedResponse menuModifiedResponse = menuService.addMenuItem(restaurantId, item);
            return ResponseEntity.ok().body(menuModifiedResponse);
        }
    }

    @PutMapping(ITEM_API)
    public ResponseEntity<MenuModifiedResponse> updateMenuItem(UpdateMenuItemRequest updateMenuItemRequest) {
        String restaurantId = updateMenuItemRequest.getRestaurantId();
        String itemId = updateMenuItemRequest.getItemId();
        Item item = updateMenuItemRequest.getItem();
        if (StringUtils.isEmpty(restaurantId) || StringUtils.isEmpty(itemId) || item == null) {
            return ResponseEntity.badRequest().build();
        } else {
            MenuModifiedResponse menuModifiedResponse = menuService.findAndUpdateMenuItem(restaurantId, itemId, item);
            return ResponseEntity.ok().body(menuModifiedResponse);
        }
    }

    @DeleteMapping(ITEM_API)
    public ResponseEntity<MenuModifiedResponse> deleteMenuItem(DeleteMenuItemRequest deleteMenuItemRequest) {
        String restaurantId = deleteMenuItemRequest.getRestaurantId();
        String itemId = deleteMenuItemRequest.getItemId();
        if (StringUtils.isEmpty(restaurantId) || StringUtils.isEmpty(itemId)) {
            return ResponseEntity.badRequest().build();
        } else {
            MenuModifiedResponse menuModifiedResponse = menuService.findAndDeleteMenuItem(itemId, restaurantId);
            return ResponseEntity.ok().body(menuModifiedResponse);
        }
    }

    @GetMapping(ORDER_HISTORY_API)
    public ResponseEntity<GetOrdersListResponse> getOrderHistory(GetMenuRequest getMenuRequest) {
        String restaurantId = getMenuRequest.getRestaurantId();
        if (StringUtils.isEmpty(restaurantId)) {
            return ResponseEntity.badRequest().build();
        } else {
            GetOrdersListResponse getOrdersListResponse = orderService.getOrderHistory(restaurantId);
            return ResponseEntity.ok().body(getOrdersListResponse);
        }
    }

    @GetMapping(ORDER_ACTIVE_API)
    public ResponseEntity<GetOrdersListResponse> getActiveOrders(GetMenuRequest getMenuRequest) {
        String restaurantId = getMenuRequest.getRestaurantId();
        if (StringUtils.isEmpty(restaurantId)) {
            return ResponseEntity.badRequest().build();
        } else {
            GetOrdersListResponse getOrdersListResponse = orderService.getActiveOrders(restaurantId);
            return ResponseEntity.ok().body(getOrdersListResponse);
        }
    }

    @PutMapping(ORDER_API)
    public ResponseEntity<ModifiedOrderResponse> updateOrderStatus(GetOrderStatusRequest getOrderStatusRequest) {
        String restaurantId = getOrderStatusRequest.getRestaurantId();
        Status status = getOrderStatusRequest.getStatus();
        String orderId = getOrderStatusRequest.getOrderId();

        log.info("GetOrderStatusRequest  {}", getOrderStatusRequest);

        //todo add exception for status and orderId as well
        if (StringUtils.isEmpty(restaurantId) || StringUtils.isEmpty(orderId) || status == null) {
            return ResponseEntity.badRequest().build();
        } else {
            ModifiedOrderResponse modifiedOrderResponse = orderService.updateOrderStatus(restaurantId, orderId, status);
            return ResponseEntity.ok().body(modifiedOrderResponse);
        }
    }
}

