package io.github.abhishekchd.restaurantbackend.dto;

import java.util.ArrayList;
import java.util.List;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
public class Order {

    @NotNull
    private String id;

    @NotNull
    private String restaurantId;

    @NotNull
    private String userId;

    @NotNull
    private List<Item> items = new ArrayList();

    @NotNull
    private int total;

    @NonNull
    private Status status;

    @NotNull
    private String timePlaced;

    public enum Status {
        PLACED,
        ACCEPTED,
        PREPARING,
        READY_FOR_PICK_UP,
        COMPLETED,
        CANCELLED,
        REJECTED
    }

}