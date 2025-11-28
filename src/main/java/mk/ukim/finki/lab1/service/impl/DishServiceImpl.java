package mk.ukim.finki.lab1.service.impl;

import mk.ukim.finki.lab1.model.Dish;
import mk.ukim.finki.lab1.repository.DishRepository;
import mk.ukim.finki.lab1.service.DishService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DishServiceImpl implements DishService {

    private final DishRepository dishRepository;

    public DishServiceImpl(DishRepository dishRepository) {
        this.dishRepository = dishRepository;
    }

    @Override
    public List<Dish> listDishes() {
        return dishRepository.findAll();
    }

    @Override
    public Dish findByDishId(String dishId) {
        return dishRepository.findByDishId(dishId);
    }

    @Override
    public Dish findById(Long id) {
        return dishRepository.findById(id).orElse(null);
    }

    @Override
    public Dish create(String dishId, String name, String cuisine, int preparationTime) {
        Dish d = new Dish(dishId, name, cuisine, preparationTime);
        dishRepository.save(d);
        return d;
    }

    @Override
    public Dish update(Long id, String dishId, String name, String cuisine, int preparationTime) {
        Dish d = dishRepository.findById(id).orElse(null);
        if(d == null) {
            return null;
        }
        d.setCuisine(cuisine);
        d.setPreparationTime(preparationTime);
        d.setName(name);
        d.setDishId(dishId);
        dishRepository.save(d);
        return d;
    }

    @Override
    public void delete(Long id) {
        dishRepository.deleteById(id);
    }

    public void likeDish(Long id) {
        Dish d = findById(id);
        if (d != null) {
            d.setLikes(d.getLikes() + 1);
        }
    }

}