package mk.ukim.finki.wp.lab.service;

import mk.ukim.finki.wp.lab.model.Chef;
import mk.ukim.finki.wp.lab.model.ChefGender;
import mk.ukim.finki.wp.lab.model.Dish;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ChefService {
    List<Chef> listChefs();
    Chef findById(Long id);
    Chef addDishToChef(Long chefId, String dishId);
    Chef create(Long id, List<Dish> dishes, String bio, String firstName, String lastName, ChefGender gender);
    Chef update(Long id, List<Dish> dishes, String bio, String firstName, String lastName, ChefGender gender);
    void delete(Long id);
}
