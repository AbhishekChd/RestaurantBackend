package io.github.abhishekchd.restaurantbackend.services;

import io.github.abhishekchd.restaurantbackend.dto.Order;
import io.github.abhishekchd.restaurantbackend.dto.Status;
import io.github.abhishekchd.restaurantbackend.exchanges.GetOrdersListResponse;
import io.github.abhishekchd.restaurantbackend.exchanges.ModifiedOrderResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class OrderServiceImpl implements OrderService {
    @Override public GetOrdersListResponse getOrderHistory(String restaurantId) {
        return new GetOrdersListResponse(new ArrayList<>());
    }

    @Override public GetOrdersListResponse getActiveOrders(String restaurantId) {
        return new GetOrdersListResponse(new ArrayList<>());
    }

    @Override public ModifiedOrderResponse updateOrderStatus(String restaurantId, String orderId, Status status) {
        return new ModifiedOrderResponse(new Order(), "Dummy message");
    }
}
