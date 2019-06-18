package io.github.abhishekchd.restaurantbackend.exchanges;


import io.github.abhishekchd.restaurantbackend.dto.Status;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class GetOrderStatusRequest {
    private String restaurantId;
    private String orderId;
    private Status status;
}
