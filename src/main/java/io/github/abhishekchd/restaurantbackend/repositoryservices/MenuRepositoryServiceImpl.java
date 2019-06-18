package io.github.abhishekchd.restaurantbackend.repositoryservices;

import io.github.abhishekchd.restaurantbackend.dto.Item;
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

        Menu menu = new Menu();

        if (menuById.isPresent()) {
            menu = modelMapper.map(menuById.get(), Menu.class);
        }

        return menu;
    }

    @Override public Menu addMenuItem(String restaurantId, Item item) {
        return null;
    }

    @Override public Menu findAndUpdateMenuItem(String restaurantId, String itemId, Item item) {
        ModelMapper modelMapper = modelMapperProvider.get();

//        Optional<MenuEntity> menuEntity = menuRepository.updateMenuByRestaurantId(restaurantId);

        Menu menu = null;

//        if (menuEntity.isPresent()) {
//            menu = modelMapper.map(menuEntity.get(), Menu.class);
//        }

        return menu;
    }

    @Override public Menu findAndDeleteMenuItem(String itemId, String restaurantId) {
        return null;
    }

    @Override public Optional<Item> findItem(String itemId, String restaurantId) {
        return Optional.empty();
    }
}
