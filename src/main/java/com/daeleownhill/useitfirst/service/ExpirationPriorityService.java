package com.daeleownhill.useitfirst.service;

import com.daeleownhill.useitfirst.model.Ingredient;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class ExpirationPriorityService {

    private final PriorityQueue<Ingredient> queue =
            new PriorityQueue<>(Comparator.comparing(Ingredient::getExpirationDate));

    public void loadFrom(Collection<Ingredient> ingredients) {
        queue.clear();
        queue.addAll(ingredients);
    }

    public Ingredient peekMostUrgent() {
        return queue.peek();
    }

    public Ingredient pollMostUrgent() {
        return queue.poll();
    }

    public List<Ingredient> getExpiringWithin(int days) {
        PriorityQueue<Ingredient> copy = new PriorityQueue<>(queue);
        List<Ingredient> result = new ArrayList<>();

        while (!copy.isEmpty() && copy.peek().daysUntilExpiry() <= days) {
            result.add(copy.poll());
        }
        return result;
    }
}
