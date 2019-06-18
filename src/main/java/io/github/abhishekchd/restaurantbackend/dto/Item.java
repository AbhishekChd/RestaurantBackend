/*
 *
 *  * Copyright (c) Crio.Do 2019. All rights reserved
 *
 */

package io.github.abhishekchd.restaurantbackend.dto;

import java.util.ArrayList;
import java.util.List;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.data.annotation.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Item {

    @NotNull
    String itemId;

    @NotNull
    String name;

    @NotNull
    String imageUrl;

    @NonNull
    Double quantity;

    @NotNull
    List<String> attributes = new ArrayList<>();

    @NotNull
    int price;
}