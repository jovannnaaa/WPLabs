package mk.ukim.finki.wp.lab.bootstrap;

import mk.ukim.finki.wp.lab.model.Chef;
import mk.ukim.finki.wp.lab.model.ChefGender;
import mk.ukim.finki.wp.lab.model.Dish;

import java.util.ArrayList;
import java.util.List;

public class DataHolder {
    public static List<Chef> chefs = new ArrayList<>();
    public static List<Dish> dishes = new ArrayList<>();
    
    static {
        dishes.add(new Dish("D1", "Beef Wellington", "British", 45));
        dishes.add(new Dish("D2", "Pasta Carbonara", "Italian", 25));
        dishes.add(new Dish("D3", "Sushi Rolls", "Japanese", 30));
        dishes.add(new Dish("D4", "Tacos", "Mexican", 20));
        dishes.add(new Dish("D5", "Ratatouille", "French", 35));
        
        chefs.add(new Chef(1L, new ArrayList<>(List.of(dishes.get(0), dishes.get(1))),
                "Famous for British fine dining.", "Gordon", "Ramsay", ChefGender.Male));
        chefs.add(new Chef(2L, new ArrayList<>(List.of(dishes.get(2))),
                "Expert in traditional Japanese cuisine.", "Masaharu", "Morimoto", ChefGender.Male));
        
        chefs.add(new Chef(3L, new ArrayList<>(List.of(dishes.get(3))),
                "Known for authentic Mexican street food.", "Enrique", "Olvera", ChefGender.Male));
        
        chefs.add(new Chef(4L, new ArrayList<>(List.of(dishes.get(4))),
                "Master of French nouvelle cuisine.", "Alain", "Ducasse", ChefGender.Male));
        
        chefs.add(new Chef(5L, new ArrayList<>(List.of(dishes.get(1), dishes.get(4))),
                "Italian chef specializing in modern pasta dishes.", "Massimo", "Bottura", ChefGender.Male));
    }
}
