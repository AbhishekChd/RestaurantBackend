package io.github.abhishekchd.restaurantbackend.controller;

import io.github.abhishekchd.restaurantbackend.dto.Status;
import io.github.abhishekchd.restaurantbackend.exchanges.*;
import io.github.abhishekchd.restaurantbackend.services.MenuService;
import io.github.abhishekchd.restaurantbackend.services.OrderService;
import lombok.extern.slf4j.Slf4j;
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
    public static final String MENU_API = "/menu";
    public static final String ORDER_API = "/order";
    public static final String ORDER_API_H = "/order/history";
    public static final String ITEM_API = "/item";
    public static final String ORDER_API_A = "order/active";

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

    //todo un comment the below section after creating item service
    /*@PostMapping(ITEM_API)
    public ResponseEntity<GetOrdersListResponse> additem(GetMenuRequest getMenuRequest) {
        String restaurantId= getMenuRequest.getRestaurantId();
        if (restaurantId == null || restaurantId.equals("")) {
            return ResponseEntity.badRequest().build();
        } else {

            GetOrdersListResponse getOrdersListResponse=orderService.getActiveOrders(restaurantId);
            return ResponseEntity.ok().body(getOrdersListResponse);
        }
    }

    @PutMapping(ITEM_API)
    public ResponseEntity<GetOrdersListResponse> findandupdateitem(GetMenuRequest getMenuRequest) {
        String restaurantId= getMenuRequest.getRestaurantId();
        if (restaurantId == null || restaurantId.equals("")) {
            return ResponseEntity.badRequest().build();
        } else {

            GetOrdersListResponse getOrdersListResponse=orderService.getActiveOrders(restaurantId);
            return ResponseEntity.ok().body(getOrdersListResponse);
        }
    }

    @DeleteMapping(ITEM_API)
    public ResponseEntity<GetOrdersListResponse> findanddeleteitem(GetMenuRequest getMenuRequest) {
        String restaurantId= getMenuRequest.getRestaurantId();
        if (restaurantId == null || restaurantId.equals("")) {
            return ResponseEntity.badRequest().build();
        } else {

            GetOrdersListResponse getOrdersListResponse=orderService.getActiveOrders(restaurantId);
            return ResponseEntity.ok().body(getOrdersListResponse);
        }
    }*/
    @GetMapping(ORDER_API_H)
    public ResponseEntity<GetOrdersListResponse> getorderhistory(GetMenuRequest getMenuRequest) {
        String restaurantId = getMenuRequest.getRestaurantId();
        if (restaurantId == null || restaurantId.equals("")) {
            return ResponseEntity.badRequest().build();
        } else {

            GetOrdersListResponse getOrdersListResponse = orderService.getOrderHistory(restaurantId);
            return ResponseEntity.ok().body(getOrdersListResponse);
        }
    }

    @GetMapping(ORDER_API_A)
    public ResponseEntity<GetOrdersListResponse> getorderactive(GetMenuRequest getMenuRequest) {
        String restaurantId = getMenuRequest.getRestaurantId();
        if (restaurantId == null || restaurantId.equals("")) {
            return ResponseEntity.badRequest().build();
        } else {

            GetOrdersListResponse getOrdersListResponse = orderService.getActiveOrders(restaurantId);
            return ResponseEntity.ok().body(getOrdersListResponse);
        }
    }

    @PutMapping(ORDER_API)
    public ResponseEntity<ModifiedOrderResponse> updatestatus(GetOrderStatusRequest getOrderStatusRequest) {
        String restaurantId = getOrderStatusRequest.getRestaurantId();
        Status status = getOrderStatusRequest.getStatus();
        String orderid = getOrderStatusRequest.getOrderId();
        //todo add exception for status and orderid as well
        if (restaurantId == null || restaurantId.equals("")) {
            return ResponseEntity.badRequest().build();
        } else {

            ModifiedOrderResponse modifiedOrderResponse = orderService.updateOrderStatus(restaurantId, orderid, status);
            return ResponseEntity.ok().body(modifiedOrderResponse);
        }
    }

}

