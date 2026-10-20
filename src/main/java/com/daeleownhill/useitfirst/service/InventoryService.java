package com.daeleownhill.useitfirst.service;

import com.daeleownhill.useitfirst.model.Ingredient;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class InventoryService {
    private final Map<String, Ingredient> inventory = new HashMap<>();

    public void addIngredient(Ingredient ingredient) {
        String key = normalize(ingredient.getName());
        Ingredient existing = inventory.get(key);
        if (existing == null) {
            inventory.put(key, ingredient);
        } else {
            existing.setQuantity(existing.getQuantity() + ingredient.getQuantity());
        }
    }

    public Ingredient getIngredient(String name) {
        return inventory.get(normalize(name));
    }

    public boolean contains(String name) {
        return inventory.containsKey(normalize(name));
    }

    public boolean useQuantity(String name, double amount) {
        Ingredient item = inventory.get(normalize(name));
        if (item == null || item.getQuantity() < amount) {
            return false;
        }
        item.setQuantity(item.getQuantity() - amount);
        if (item.getQuantity() == 0) {
            inventory.remove(normalize(name));
        }
        return true;
    }

    public Ingredient removeIngredient(String name) {
        return inventory.remove(normalize(name));
    }

    public Collection<Ingredient> getAll() {
        return inventory.values();
    }

    public int size() {
        return inventory.size();
    }
    private String normalize(String name) {
        return name.trim().toLowerCase();
    }
}
