package io.github.abhishekchd.restaurantbackend.exchanges;

import javax.validation.constraints.NotNull;

import io.github.abhishekchd.restaurantbackend.dto.Menu;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetMenuResponse {
    @NotNull
    Menu menu;
}
