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
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderRepositoryService orderRepositoryService;

    @Override
    public GetOrdersListResponse getOrderHistory(String restaurantId) {
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

    @Override
    public GetOrdersListResponse getActiveOrders(String restaurantId) {
        List<Order> orders = orderRepositoryService.getActiveOrders(restaurantId);
        GetOrdersListResponse ans = new GetOrdersListResponse(orders);
        return ans;
    }

    @Override
    public ModifiedOrderResponse updateOrderStatus(String restaurantId, String orderId, Status status) {
        Optional<Order> updatedorder = orderRepositoryService.updateOrderStatus(restaurantId, orderId, status);
        //TODO is kuch bhi ko change krna hai
        ModifiedOrderResponse ans = new ModifiedOrderResponse(updatedorder.get(),"kuch bhi");
        return ans;
    }
}
