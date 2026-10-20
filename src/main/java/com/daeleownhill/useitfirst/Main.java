package com.daeleownhill.useitfirst;

import com.daeleownhill.useitfirst.model.Ingredient;
import com.daeleownhill.useitfirst.service.InventoryService;

import java.time.LocalDate;

public class Main {
    public static void main(String[]args) {
        InventoryService inventory = new InventoryService();

        inventory.addIngredient(new Ingredient("Milk", 1, "gallon", LocalDate.now().plusDays(2)));
        inventory.addIngredient(new Ingredient("lettuce", 200, "g", LocalDate.now().plusDays(1)));
        inventory.addIngredient(new Ingredient("Eggs", 12, "count", LocalDate.now().plusDays(10)));
        inventory.addIngredient(new Ingredient("milk", 1, "gallon", LocalDate.now().plusDays(2)));

        System.out.println("Items in inventory: " + inventory.size());
        System.out.println(inventory.getIngredient("MILK"));

        inventory.useQuantity("eggs", 4);
        System.out.println(inventory.getIngredient("eggs"));

        System.out.println("Used 500g Lettuce? " + inventory.useQuantity("lettuce", 500));
    }
}
