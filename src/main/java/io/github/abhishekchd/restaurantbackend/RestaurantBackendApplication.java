package io.github.abhishekchd.restaurantbackend;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

@SpringBootApplication
public class RestaurantBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestaurantBackendApplication.class, args);
    }

    @Bean
    @Scope("prototype")
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

}
