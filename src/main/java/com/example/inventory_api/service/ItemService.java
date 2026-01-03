package com.example.inventory_api.service;

import com.example.inventory_api.model.Item;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ItemService {
    private final List<Item> items = new ArrayList<>();

    public List<Item> getAllItems() {
        return items;
    }

    public Optional<Item> getItemById(String id) {
        return items.stream().filter(i -> i.getId().equals(id)).findFirst();
    }

    public Item addItem(Item item) {
        items.add(item);
        return item;
    }

    public boolean deleteItem(String id) {
        return items.removeIf(i -> i.getId().equals(id));
    }

    public Optional<Item> updateItem(String id, Item updated) {
        return getItemById(id).map(existing -> {
            existing.setName(updated.getName());
            existing.setQuantity(updated.getQuantity());
            return existing;
        });
    }
}
