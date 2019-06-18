package io.github.abhishekchd.restaurantbackend.services;

import io.github.abhishekchd.restaurantbackend.dto.Order;
import io.github.abhishekchd.restaurantbackend.dto.Status;
import io.github.abhishekchd.restaurantbackend.exchanges.GetOrdersListResponse;
import io.github.abhishekchd.restaurantbackend.exchanges.ModifiedOrderResponse;
import io.github.abhishekchd.restaurantbackend.repositoryservices.OrderRepositoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired OrderRepositoryService orderRepositoryService;

    @Override public GetOrdersListResponse getOrderHistory(String restaurantId) {
        List<Order> orders = orderRepositoryService.getAllOrders(restaurantId);
        ArrayList<Order> previousOrders = new ArrayList<>();
        for (Order order : orders) {
            switch (order.getStatus()) {
                case REJECTED:
                case CANCELLED:
                case COMPLETED:
                    previousOrders.add(order);
            }
        }
        return new GetOrdersListResponse(previousOrders);
    }

    @Override public GetOrdersListResponse getActiveOrders(String restaurantId) {
        return new GetOrdersListResponse(new ArrayList<>());
    }

    @Override public ModifiedOrderResponse updateOrderStatus(String restaurantId, String orderId, Status status) {
        return new ModifiedOrderResponse(new Order(), "Dummy message");
    }
}
