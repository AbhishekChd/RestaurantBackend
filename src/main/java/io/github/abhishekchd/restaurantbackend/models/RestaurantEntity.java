/*
 *
 *  * Copyright (c) Crio.Do 2019. All rights reserved
 *
 */

package io.github.abhishekchd.restaurantbackend.models;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

// Java class that maps to Mongo collection.
@Data
@Document(collection = "restaurants")
@NoArgsConstructor
public class RestaurantEntity {

  @Id
  private String id;

  @NotNull
  private String restaurantId;

  @NotNull
  private String name;

  @NotNull
  private String city;

  @NotNull
  private String imageUrl;

  @NotNull
  private Double latitude;

  @NotNull
  private Double longitude;

  @NotNull
  private String opensAt;

  @NotNull
  private String closesAt;

  @NotNull
  private List<String> attributes = new ArrayList<>();

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RestaurantEntity that = (RestaurantEntity) o;
    return Objects.equals(id, that.id)
        && Objects.equals(restaurantId, that.restaurantId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, restaurantId, name, city, imageUrl, latitude, longitude, opensAt,
        closesAt, attributes);
  }
}
