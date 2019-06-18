package io.github.abhishekchd.restaurantbackend.exchanges;

import io.github.abhishekchd.restaurantbackend.dto.Menu;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MenuModifiedResponse {
    private Menu menu;
}
