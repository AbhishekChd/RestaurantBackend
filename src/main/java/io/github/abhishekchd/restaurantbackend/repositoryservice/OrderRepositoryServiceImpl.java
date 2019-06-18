package io.github.abhishekchd.restaurantbackend.repositoryservice;

import io.github.abhishekchd.restaurantbackend.dto.Order;
import io.github.abhishekchd.restaurantbackend.dto.Status;
import io.github.abhishekchd.restaurantbackend.repository.OrderRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.Provider;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

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
