package io.github.abhishekchd.restaurantbackend.repositoryService;

import io.github.abhishekchd.restaurantbackend.dto.Order;
import io.github.abhishekchd.restaurantbackend.dto.Status;
import io.github.abhishekchd.restaurantbackend.models.OrderEntity;
import io.github.abhishekchd.restaurantbackend.repository.OrderRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.Provider;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class OrderRepositoryServiceImpl implements OrderRepositoryService{

    @Autowired
    private Provider<ModelMapper> modelMapperProvider;

    @Autowired
    private OrderRepository orderRepository;


    @Override
    public List<Order> getOrders(String restaurantId) {
        return null;
    }

    @Override
    public Status UpdateStatus(String restaurantId, String OrderId, Status status) {
        return null;
    }
}
