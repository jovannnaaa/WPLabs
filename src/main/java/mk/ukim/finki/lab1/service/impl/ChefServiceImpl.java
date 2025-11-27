package mk.ukim.finki.lab1.service.impl;

import mk.ukim.finki.lab1.model.Chef;
import mk.ukim.finki.lab1.model.Dish;
import mk.ukim.finki.lab1.repository.ChefRepository;
import mk.ukim.finki.lab1.repository.DishRepository;
import mk.ukim.finki.lab1.service.ChefService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ChefServiceImpl implements ChefService {

    private final ChefRepository chefRepository;
    private final DishRepository dishRepository;

    public ChefServiceImpl(ChefRepository chefRepository, DishRepository dishRepository){
        this.chefRepository = chefRepository;
        this.dishRepository = dishRepository;
    }

    @Override
    public List<Chef> listChefs() {
        return this.chefRepository.findAll();
    }

    @Override
    public Chef findById(Long id) {
        return this.chefRepository.findById(id).orElse(null);
    }

    @Override
    public Chef addDishToChef(Long chefId, String dishId) {
       Chef chef =this.chefRepository.findById(chefId).orElse(null);
        Dish dish = this.dishRepository.findByDishId(dishId);
     // chef.setDishes((List<Dish>) dish);
        chef.getDishes().add(dish);
      this.chefRepository.save(chef);
        return chef;
    }
}
