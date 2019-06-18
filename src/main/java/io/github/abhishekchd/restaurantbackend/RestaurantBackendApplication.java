package io.github.abhishekchd.restaurantbackend;

import io.github.abhishekchd.restaurantbackend.dto.Status;
import io.github.abhishekchd.restaurantbackend.models.OrderEntity;
import io.github.abhishekchd.restaurantbackend.repository.OrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

import java.time.LocalTime;
import java.util.ArrayList;

@SpringBootApplication
@Slf4j
public class RestaurantBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestaurantBackendApplication.class, args);
        log.info("server started");
    }

    @Bean
    @Scope("prototype")
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Bean
    CommandLineRunner initDatabase(OrderRepository repository) {
        return args -> {
            log.info("Preloading " + repository.save(new OrderEntity(
                    "#1",
                    "301728",
                    "abhishek",
                    new ArrayList<>(),
                    100,
                    Status.COMPLETED,
                    LocalTime.now().toString()
            )));
            log.info("Preloading " + repository.save(new OrderEntity(
                    "#2",
                    "301728",
                    "abhishek",
                    new ArrayList<>(),
                    20,
                    Status.CANCELLED,
                    LocalTime.now().toString()
            )));
        };
    }

}
