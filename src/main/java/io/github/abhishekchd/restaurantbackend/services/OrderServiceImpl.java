package io.github.abhishekchd.restaurantbackend.services;

import io.github.abhishekchd.restaurantbackend.dto.Order;
import io.github.abhishekchd.restaurantbackend.exchanges.GetOrdersListResponse;
import io.github.abhishekchd.restaurantbackend.exchanges.ModifiedOrderResponse;

import java.util.ArrayList;

public class OrderServiceImpl implements OrderService {
    @Override public GetOrdersListResponse getOrderHistory(String restaurantId) {
        return new GetOrdersListResponse(new ArrayList<>());
    }

    @Override public GetOrdersListResponse getActiveOrders(String restaurantId) {
        return new GetOrdersListResponse(new ArrayList<>());
    }

    @Override public ModifiedOrderResponse updateOrderStatus(String restaurantId, String orderId, Order.Status status) {
        return new ModifiedOrderResponse(new Order(), "Dummy message");
    }
}
