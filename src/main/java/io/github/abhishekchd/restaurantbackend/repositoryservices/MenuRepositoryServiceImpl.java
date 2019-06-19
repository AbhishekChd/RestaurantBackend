package io.github.abhishekchd.restaurantbackend.repositoryservices;

import io.github.abhishekchd.restaurantbackend.dto.Item;
import io.github.abhishekchd.restaurantbackend.dto.Menu;
import io.github.abhishekchd.restaurantbackend.models.ItemEntity;
import io.github.abhishekchd.restaurantbackend.models.MenuEntity;
import io.github.abhishekchd.restaurantbackend.repository.ItemRepository;
import io.github.abhishekchd.restaurantbackend.repository.MenuRepository;

import java.util.ArrayList;
import java.util.List;
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
    private ItemRepository itemRepository;

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
        ModelMapper modelMapper = modelMapperProvider.get();

        Optional<MenuEntity> menuEntity = menuRepository.findMenuByRestaurantId(restaurantId);

        Menu updatedMenu = null;

        if (menuEntity.isPresent()) {
            menuEntity.get().getItems().add(item);
            MenuEntity s = menuRepository.save(menuEntity.get());
            return modelMapper.map(s, Menu.class);
        }

        return null;
    }

    @Override
    public Menu findAndUpdateMenuItem(String restaurantId, String itemId, Item item) {
        ModelMapper modelMapper = modelMapperProvider.get();

        Optional<MenuEntity> menuEntity = menuRepository.findMenuByRestaurantId(restaurantId);

        Menu updatedMenu = null;

        if (menuEntity.isPresent()) {
            List<Item> items = menuEntity.get().getItems();
            ArrayList<Item> updatedItems = new ArrayList<>();
            for (Item item1 : items) {
                if (item1.getItemId().equals(itemId)) {
                    item1 = item;
                }
                updatedItems.add(item1);
            }
            menuEntity.get().setItems(updatedItems);
            MenuEntity s = menuRepository.save(menuEntity.get());
            return modelMapper.map(s, Menu.class);
        }

        return null;
    }

    @Override
    public Menu findAndDeleteMenuItem(String itemId, String restaurantId) {
        ModelMapper modelMapper = modelMapperProvider.get();

        Optional<MenuEntity> menuEntity = menuRepository.findMenuByRestaurantId(restaurantId);

        Menu updatedMenu = null;

        if (menuEntity.isPresent()) {
            List<Item> items = menuEntity.get().getItems();
            ArrayList<Item> updatedItems = new ArrayList<>();
            for (Item item1 : items) {
                if (!item1.getItemId().equals(itemId)) {
                    updatedItems.add(item1);
                }
            }
            menuEntity.get().setItems(updatedItems);
            MenuEntity s = menuRepository.save(menuEntity.get());
            return modelMapper.map(s, Menu.class);
        }

        return null;
    }

    @Override
    public Optional<Item> findItem(String itemId, String restaurantId) {
        ModelMapper modelMapper = modelMapperProvider.get();

        Optional<ItemEntity> itemEntity = itemRepository.findItemByItemId(itemId);
        if (itemEntity.isPresent()) {
            return Optional.of(modelMapper.map(itemEntity.get(), Item.class));
        }
        return Optional.empty();
    }
}
