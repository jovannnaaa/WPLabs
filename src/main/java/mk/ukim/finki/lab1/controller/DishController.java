package mk.ukim.finki.lab1.controller;

import jakarta.servlet.http.HttpSession;
import mk.ukim.finki.lab1.model.Dish;
import mk.ukim.finki.lab1.service.ChefService;
import mk.ukim.finki.lab1.service.DishService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/dishes")
public class DishController  {
    private final DishService dishService;
    private final ChefService chefService;

    public DishController(DishService dishService, ChefService chefService) {
        this.dishService = dishService;
        this.chefService = chefService;
    }

    @PostMapping
    public String postHandleDishes(HttpSession session, @RequestParam Long chefId) {
        session.setAttribute("chefId", chefId);
        return "redirect:/dishes";
    }

    @GetMapping
    public String getDishesPage(HttpSession session, @RequestParam(required = false) String error, Model model) {
        Long chefId = (Long) session.getAttribute("chefId");
        String chefName= chefService.findById(chefId).getFirstName()+" "+ chefService.findById(chefId).getLastName();

        model.addAttribute("chefId",chefId);
        model.addAttribute("chefName",chefName);
        model.addAttribute("dishes", dishService.listDishes());
        return "dishesList";
    }

    @PostMapping("/add")
    public String saveDish(@RequestParam String dishId, @RequestParam String name, @RequestParam String cuisine, @RequestParam int preparationTime) {
        dishService.create(dishId, name, cuisine, preparationTime);
        return "redirect:/dishes";
    }

    @PostMapping("/edit/{id}")
    public String editDish(@PathVariable Long id, @RequestParam String dishId, @RequestParam String name, @RequestParam String cuisine, @RequestParam int preparationTime) {
        dishService.update(id, dishId, name, cuisine, preparationTime);
        return "redirect:/dishes";
    }

    @GetMapping("/delete/{id}")
    public String deleteDish(@PathVariable Long id) {
        dishService.delete(id);
        return "redirect:/dishes";
    }

    @GetMapping("/dish-form/{id}")
    public String getEditDishForm(@PathVariable Long id, Model model) {
        Dish d = dishService.findById(id);
        if (d == null) {
            return "redirect:/dishes?error=DishNotFound.";
        }
        model.addAttribute("dish", d);
        return "dish-form";
    }

    @GetMapping("/dish-form")
    public String getAddDishPage() {
        return "dish-form";
    }
}