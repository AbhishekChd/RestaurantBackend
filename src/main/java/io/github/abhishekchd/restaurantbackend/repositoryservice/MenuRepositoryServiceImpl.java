package io.github.abhishekchd.restaurantbackend.repositoryservice;

import io.github.abhishekchd.restaurantbackend.dto.Menu;
import io.github.abhishekchd.restaurantbackend.models.MenuEntity;
import io.github.abhishekchd.restaurantbackend.repository.MenuRepository;

import java.util.Optional;

import org.modelmapper.ModelMapper;;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.inject.Provider;

@Service
public class MenuRepositoryServiceImpl implements MenuRepositoryService {

    @Autowired
    private MenuRepository menuRepository;

    @Autowired
    private Provider<ModelMapper> modelMapperProvider;

    public Menu findMenu(String restaurantId) {
        ModelMapper modelMapper = modelMapperProvider.get();

        Optional<MenuEntity> menuById = menuRepository.findMenuByRestaurantId(restaurantId);

        Menu menu = null;

        if (menuById.isPresent()) {
            menu = modelMapper.map(menuById.get(), Menu.class);
        }

        return menu;
    }

    public Menu updateMenu(String restaurantId) {
        ModelMapper modelMapper = modelMapperProvider.get();

//        Optional<MenuEntity> menuEntity = menuRepository.updateMenuByRestaurantId(restaurantId);

        Menu menu = null;

//        if (menuEntity.isPresent()) {
//            menu = modelMapper.map(menuEntity.get(), Menu.class);
//        }

        return menu;
    }
}
