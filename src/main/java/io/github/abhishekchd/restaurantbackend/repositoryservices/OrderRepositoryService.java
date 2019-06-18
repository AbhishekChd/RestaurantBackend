package io.github.abhishekchd.restaurantbackend.repositoryservices;

import io.github.abhishekchd.restaurantbackend.dto.Order;
import io.github.abhishekchd.restaurantbackend.dto.Status;

import java.util.List;

public interface OrderRepositoryService {


    /**
     * TODO:  Implement getArchivedOrders.
     * Place order based on the cart.
     * @param restaurantId - restaurantId of restaurant whose orders need to be retrieved.
     * @return return -  orders that were placed.
     */

    List<Order> getOrders(String restaurantId);


    /**
     * TODO:  Implement updateStatus.
     * Place order based on the cart.
     * @param restaurantId - restaurantId of restaurant whose current orders need to be retrieved.
     * @return return - all the orders that were just placed.
     */

    Status UpdateStatus(String restaurantId, String OrderId, Status status);
}
