package io.github.abhishekchd.restaurantbackend.exchanges;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class GetOrderStatusRequest {
    private String restaurantId;
    private String orderId;
    private String status;
}
