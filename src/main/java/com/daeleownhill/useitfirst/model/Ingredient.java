package com.daeleownhill.useitfirst.model;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Ingredient {
    private final String name;
    private double quantity;
    private final String unit;
    private final LocalDate expirationDate;

    public Ingredient(String name, double quantity, String unit, LocalDate expirationDate) {
        this.name = name;
        this.quantity = quantity;
        this.unit = unit;
        this.expirationDate = expirationDate;
}

    public long daysUntilExpiry() {
        return ChronoUnit.DAYS.between(LocalDate.now(), expirationDate);
    }

    public boolean isExpired() {
        return daysUntilExpiry() < 0;
    }

    public String getName() { return name; }
    public double getQuantity() { return quantity; }
    public String getUnit() { return unit; }
    public LocalDate getExpirationDate() { return expirationDate; }
    public void setQuantity(double quantity) { this.quantity = quantity; }

    @Override
    public String toString() {
        return name + " (" + quantity + " " + unit + ") expires in " + daysUntilExpiry() + " days";
    }
}
