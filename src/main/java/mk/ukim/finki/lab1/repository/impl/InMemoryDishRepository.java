package mk.ukim.finki.lab1.repository.impl;

import mk.ukim.finki.lab1.bootstrap.DataHolder;
import mk.ukim.finki.lab1.model.Dish;
import mk.ukim.finki.lab1.repository.DishRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class InMemoryDishRepository implements DishRepository {

    @Override
    public List<Dish> findAll() {
        return DataHolder.dishes;
    }

    @Override
    public Dish findByDishId(String dishId) {
        return DataHolder.dishes.stream().filter(d -> d.getDishId().equals(dishId)).findFirst().orElse(null);
    }

    @Override
    public Optional<Dish> findById(Long id) {
        return DataHolder.dishes.stream().filter(d -> d.getId().equals(id)).findFirst();
    }

    @Override
    public Dish save(Dish dish) {
        Dish d = DataHolder.dishes.stream().filter(dish1 -> dish1.getId().equals(dish.getId())).findFirst().orElse(null);
        if (d == null) {
            DataHolder.dishes.add(dish);
        }
        else {
            DataHolder.dishes.remove(d);
            DataHolder.dishes.add(dish);
        }
        return dish;
    }

    @Override
    public void deleteById(Long id) {
        DataHolder.dishes.removeIf(dish -> dish.getId().equals(id));
    }
}