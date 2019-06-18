package io.github.abhishekchd.restaurantbackend.repositoryservices;

import io.github.abhishekchd.restaurantbackend.dto.Order;
import io.github.abhishekchd.restaurantbackend.dto.Status;
import io.github.abhishekchd.restaurantbackend.models.OrderEntity;
import io.github.abhishekchd.restaurantbackend.repository.OrderRepository;
import io.swagger.models.Model;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import javax.inject.Provider;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static io.github.abhishekchd.restaurantbackend.dto.Status.*;

@Service
public class OrderRepositoryServiceImpl implements OrderRepositoryService {

    @Autowired
    private Provider<ModelMapper> modelMapperProvider;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private MongoTemplate mongoTemplate;


    @Override
    public List<Order> getAllOrders(String restaurantId) {
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

    @Override
    public List<Order> getActiveOrders(String restaurantId) {
        Optional<List<OrderEntity>> response = orderRepository.findOrdersByRestaurantId(restaurantId);
        List<Order> ans = new ArrayList<>();
        if (response.isPresent()) {
            ModelMapper modelMapper = modelMapperProvider.get();
            List<OrderEntity> fromrepo = response.get();
            //iterating and adding where status= placed <---> Ready for pick up
            for (OrderEntity orderEntity : fromrepo) {
                Status check = orderEntity.getStatus();
                if (check == PLACED || check == ACCEPTED || check == PREPARING || check == READY_FOR_PICK_UP) {
                    ans.add(modelMapper.map(orderEntity, Order.class));
                }

            }
        }
        return ans;
    }

    @Override
    public Optional<Order> updateOrderStatus(String restaurantId, String orderId, Status status) {

        Optional<List<OrderEntity>> response = orderRepository.findOrdersByRestaurantId(restaurantId);
        Order ans;
        if (response.isPresent()) {
            ModelMapper modelMapper = modelMapperProvider.get();
            List<OrderEntity> fromrepo = response.get();

            for (OrderEntity orderEntity : fromrepo) {
                String id = orderEntity.getId();
                if (id.equals(orderId)) {
                    orderEntity.setStatus(status);
                    //todo collection ka naam dalo
                    mongoTemplate.save(orderEntity, "orders");
                    // return krne ke lie convert
                    ans = modelMapper.map(orderEntity, Order.class);
                    return Optional.of(ans);
                }
            }
        }
        return Optional.empty();
    }
}
