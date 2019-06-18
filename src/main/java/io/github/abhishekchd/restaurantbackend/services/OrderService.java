package io.github.abhishekchd.restaurantbackend.services;

import io.github.abhishekchd.restaurantbackend.dto.Order;
import io.github.abhishekchd.restaurantbackend.exchanges.ModifiedOrderResponse;
import io.github.abhishekchd.restaurantbackend.exchanges.GetOrdersListResponse;

public interface OrderService {

    /**
     * Get all orders that have {@link io.github.abhishekchd.restaurantbackend.dto.Order.Status}
     * Accepted, Rejected or Cancelled
     *
     * @param restaurantId Id of the restaurant
     * @return List of orders
     */
    GetOrdersListResponse getOrderHistory(String restaurantId);


    /**
     * Get all orders that are active
     *
     * @param restaurantId Id of the restaurant
     * @return List of active orders
     */
    GetOrdersListResponse getActiveOrders(String restaurantId);


    /**
     * Update current order status
     *
     * @param restaurantId Id of the restaurant
     * @param orderId      Id of the current order
     * @param status       {@link io.github.abhishekchd.restaurantbackend.dto.Order.Status} of the order
     * @return Modified Order
     */
    ModifiedOrderResponse updateOrderStatus(String restaurantId, String orderId, Order.Status status);
}
