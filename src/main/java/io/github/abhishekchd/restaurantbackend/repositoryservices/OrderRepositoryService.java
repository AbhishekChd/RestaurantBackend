package io.github.abhishekchd.restaurantbackend.repositoryservices;

import io.github.abhishekchd.restaurantbackend.dto.Order;
import io.github.abhishekchd.restaurantbackend.dto.Status;
import io.github.abhishekchd.restaurantbackend.exchanges.GetOrdersListResponse;
import io.github.abhishekchd.restaurantbackend.exchanges.ModifiedOrderResponse;

import java.util.List;
import java.util.Optional;

public interface OrderRepositoryService {

    /**
     * Get all orders
     *
     * @param restaurantId Id of the restaurant
     * @return List of orders
     */
    List<Order> getAllOrders(String restaurantId);


    /**
     * Get all orders that are active
     *
     * @param restaurantId Id of the restaurant
     * @return List of active orders
     */
    List<Order> getActiveOrders(String restaurantId);


    /**
     * Update current order status
     *
     * @param restaurantId Id of the restaurant
     * @param orderId      Id of the current order
     * @param status       {@link io.github.abhishekchd.restaurantbackend.dto.Status} of the order
     * @return Modified Order
     */
    Optional<Order> updateOrderStatus(String restaurantId, String orderId, Status status);
}
