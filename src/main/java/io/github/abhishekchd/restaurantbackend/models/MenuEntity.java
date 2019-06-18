/*
 *
 *  * Copyright (c) Crio.Do 2019. All rights reserved
 *
 */

package io.github.abhishekchd.restaurantbackend.models;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotNull;

import io.github.abhishekchd.restaurantbackend.dto.Item;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "menus")
@NoArgsConstructor
@AllArgsConstructor
public class MenuEntity {

    @Id
    private String id;

    @NotNull
    private String restaurantId;

    @NotNull
    private List<Item> items = new ArrayList();
}
