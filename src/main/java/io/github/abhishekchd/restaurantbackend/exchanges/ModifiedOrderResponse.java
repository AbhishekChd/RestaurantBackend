package io.github.abhishekchd.restaurantbackend.exchanges;

import io.github.abhishekchd.restaurantbackend.dto.Order;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

@Data
@AllArgsConstructor
@NonNull
public class ModifiedOrderResponse {
    private Order order;
    private String message;
}
