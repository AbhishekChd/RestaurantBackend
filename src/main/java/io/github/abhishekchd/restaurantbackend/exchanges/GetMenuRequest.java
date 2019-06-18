package io.github.abhishekchd.restaurantbackend.exchanges;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Data

public class GetMenuRequest {
    private String restaurantId;

    public String getRestaurantId() {
        return restaurantId;
    }
}
