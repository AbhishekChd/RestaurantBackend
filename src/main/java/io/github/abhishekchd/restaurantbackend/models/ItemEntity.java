package io.github.abhishekchd.restaurantbackend.models;

import java.util.ArrayList;
import java.util.List;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "items")
@NoArgsConstructor
public class ItemEntity {

    @Id
    private String id;

    @NotNull
    private String itemId;

    @NotNull
    private String name;

    @NotNull
    private String imageUrl;

    @NonNull
    Double quantity;

    @NotNull
    private Double price;

    @NotNull
    private List<String> attributes = new ArrayList<>();
}
