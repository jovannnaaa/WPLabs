package mk.ukim.finki.wp.lab.controller;

import mk.ukim.finki.wp.lab.model.Chef;
import mk.ukim.finki.wp.lab.model.ChefGender;
import mk.ukim.finki.wp.lab.service.ChefService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
@RequestMapping("/chefs")
public class ChefController {
    private final ChefService chefService;

    public ChefController(ChefService chefService) {
        this.chefService = chefService;
    }

    @GetMapping
    public String getChefs(Model model) {
        model.addAttribute("chefs", chefService.listChefs());
        return "listChefs";
    }

    @PostMapping("/add")
    public String saveChef(@RequestParam Long id, @RequestParam String firstName, @RequestParam String lastName, @RequestParam String bio, @RequestParam ChefGender gender) {
        chefService.create(id, new ArrayList<>(), bio, firstName, lastName, gender);
        return "redirect:/chefs";
    }

    @PostMapping("/edit/{id}")
    public String editChef(@PathVariable Long id, @RequestParam String firstName, @RequestParam String lastName, @RequestParam String bio, @RequestParam ChefGender gender) {
        chefService.update(id, new ArrayList<>(), bio, firstName, lastName, gender);
        return "redirect:/chefs";
    }

    @GetMapping("/delete/{id}")
    public String deleteChef(@PathVariable Long id) {
        chefService.delete(id);
        return "redirect:/chefs";
    }

    @GetMapping("/chef-form/{id}")
    public String getEditChefPage(@PathVariable Long id, Model model) {
        Chef c = chefService.findById(id);
        if(c == null) {
            return "redirect:/chefs?error=ChefNotFound";
        }
        model.addAttribute("chef", c);
        model.addAttribute("genders", ChefGender.values());
        return "chef-form";
    }

    @GetMapping("/chef-form")
    public String getAddChefPage(Model model) {
        model.addAttribute("genders", ChefGender.values());
        return "chef-form";
    }
}
