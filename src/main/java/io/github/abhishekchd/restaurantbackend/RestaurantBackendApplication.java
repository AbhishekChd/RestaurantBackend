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
import java.util.Random;

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
            for (int i = 0; i < 100; i++) {
                Random ran = new Random();
                Status ran_status = Status.PLACED;
                int ran_for_name = ran.nextInt(3);
                int random = ran.nextInt(7);
                String res_id = "301728";
                String name = "Shivansh";
                switch (ran_for_name) {
                    case 0: {
                        name = "Shivansh";
                        res_id = "301728";
                        break;
                    }
                    case 1: {
                        name = "Abhishek";
                        res_id = "301286";
                        break;
                    }
                    case 2: {
                        name = "Fatma";
                        res_id = "307843";
                        break;
                    }
                    default: {
                        name = "Shivansh";
                        res_id = "301728";

                    }
                }
                switch (random) {
                    case 0:
                        ran_status = Status.PLACED;
                        break;
                    case 1:
                        ran_status = Status.CANCELLED;
                        break;
                    case 2:
                        ran_status = Status.COMPLETED;
                        break;
                    case 3:
                        ran_status = Status.PREPARING;
                        break;
                    case 4:
                        ran_status = Status.REJECTED;
                        break;
                    case 5:
                        ran_status = Status.READY_FOR_PICK_UP;
                        break;
                    case 6:
                        ran_status = Status.ACCEPTED;
                        break;
                    default:
                        ran_status = Status.PLACED;

                }
                log.info("Preloading " + repository.save(new OrderEntity(
                        "#1",
                        res_id,
                        name,
                        new ArrayList<>(),
                        100,
                        ran_status,
                        LocalTime.now().toString()
                )));
            }

        };
    }

}
