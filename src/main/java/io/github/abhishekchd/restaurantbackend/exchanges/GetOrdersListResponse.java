package io.github.abhishekchd.restaurantbackend.exchanges;

import io.github.abhishekchd.restaurantbackend.dto.Order;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

import java.util.List;

@Data
@AllArgsConstructor
@NonNull
public class GetOrdersListResponse {
    private List<Order> orders;
}
