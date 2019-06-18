package io.github.abhishekchd.restaurantbackend.exchanges;


import io.github.abhishekchd.restaurantbackend.dto.Status;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Data
public class GetOrderStatusRequest {
    private String restaurantId;
    private String orderId;
    private Status status;

    public String getRestaurantId() {
        return restaurantId;
    }

    public String getOrderId() {
        return orderId;
    }

    public Status getStatus() {
        return status;
    }
}
