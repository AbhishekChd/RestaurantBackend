package io.github.abhishekchd.restaurantbackend.repositoryservices;

import io.github.abhishekchd.restaurantbackend.dto.Order;
import io.github.abhishekchd.restaurantbackend.dto.Status;
import io.github.abhishekchd.restaurantbackend.models.OrderEntity;
import io.github.abhishekchd.restaurantbackend.repository.OrderRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.inject.Provider;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrderRepositoryServiceImpl implements OrderRepositoryService {

    @Autowired
    private Provider<ModelMapper> modelMapperProvider;

    @Autowired
    private OrderRepository orderRepository;

    @Override public List<Order> getAllOrders(String restaurantId) {
        Optional<List<OrderEntity>> response = orderRepository.findOrdersByRestaurantId(restaurantId);
        List<Order> ans = new ArrayList<>();
        if (response.isPresent()) {
            ModelMapper modelMapper = modelMapperProvider.get();
            List<OrderEntity> fromrepo = response.get();
            //iterating and adding contents to order
            for (OrderEntity orderEntity : fromrepo) {
                ans.add(modelMapper.map(orderEntity, Order.class));
            }
        }
        return ans;
    }

    @Override public List<Order> getActiveOrders(String restaurantId) {
        return null;
    }

    @Override public Optional<Order> updateOrderStatus(String restaurantId, String orderId, Status status) {
        return Optional.empty();
    }
}
