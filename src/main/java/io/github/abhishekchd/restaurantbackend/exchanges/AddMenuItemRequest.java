package io.github.abhishekchd.restaurantbackend.exchanges;

import io.github.abhishekchd.restaurantbackend.dto.Item;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddMenuItemRequest {
    private String restaurantId;
    private Item item;
}
