package io.github.abhishekchd.restaurantbackend.models;

import java.util.ArrayList;
import java.util.List;
import javax.validation.constraints.NotNull;

import io.github.abhishekchd.restaurantbackend.dto.Item;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "orders")
@NoArgsConstructor
public class OrderEntity {

    @Id
    private String id;

    @NotNull
    private String restaurantId;

    @NotNull
    private String userId;

    @NotNull
    private List<Item> items = new ArrayList();

    @NotNull
    private int total = 0;

    @NotNull
    private String placedTime;

}
