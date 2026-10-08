package com.daeleownhill.useitfirst;

import com.daeleownhill.useitfirst.model.Ingredient;
import java.time.LocalDate;

public class Main {
    public static void main(String[]args) {
        Ingredient milk = new Ingredient("Milk", 1, "gallon", LocalDate.now().plusDays(2));
        System.out.println(milk);
    }
}
