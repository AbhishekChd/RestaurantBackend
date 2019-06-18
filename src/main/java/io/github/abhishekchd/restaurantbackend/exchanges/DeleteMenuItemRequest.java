package io.github.abhishekchd.restaurantbackend.exchanges;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class DeleteMenuItemRequest {
    private String restaurantId;
    private String itemId;
}
