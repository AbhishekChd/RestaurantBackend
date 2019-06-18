package io.github.abhishekchd.restaurantbackend.repositoryservices;

import io.github.abhishekchd.restaurantbackend.dto.Item;
import io.github.abhishekchd.restaurantbackend.dto.Menu;
import io.github.abhishekchd.restaurantbackend.models.ItemEntity;
import io.github.abhishekchd.restaurantbackend.models.MenuEntity;
import io.github.abhishekchd.restaurantbackend.repository.ItemRepository;
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
            itemRepository.insert(modelMapper.map(item, ItemEntity.class));
            Optional<MenuEntity> updatedMenuEntity = menuRepository.findMenuByRestaurantId(restaurantId);
            updatedMenu = modelMapper.map(updatedMenuEntity.get(), Menu.class);
        }

        return updatedMenu;
    }

    @Override
    public Menu findAndUpdateMenuItem(String restaurantId, String itemId, Item item) {
        ModelMapper modelMapper = modelMapperProvider.get();

        Optional<ItemEntity> optionalItemEntity = itemRepository.findItemByItemId(itemId);

        if (optionalItemEntity.isPresent()) {
            itemRepository.save(modelMapper.map(item, ItemEntity.class));
        }

        Optional<MenuEntity> updatedMenuEntity = menuRepository.findMenuByRestaurantId(restaurantId);
        Menu updatedMenu = modelMapper.map(updatedMenuEntity.get(), Menu.class);

        return updatedMenu;
    }

    @Override
    public Menu findAndDeleteMenuItem(String itemId, String restaurantId) {
        ModelMapper modelMapper = modelMapperProvider.get();

        Optional<ItemEntity> optionalItemEntity = itemRepository.findItemByItemId(itemId);

        if (optionalItemEntity.isPresent()) {
            itemRepository.deleteById(itemId);
        }

        Optional<MenuEntity> updatedMenuEntity = menuRepository.findMenuByRestaurantId(restaurantId);
        Menu updatedMenu = modelMapper.map(updatedMenuEntity.get(), Menu.class);

        return updatedMenu;
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
