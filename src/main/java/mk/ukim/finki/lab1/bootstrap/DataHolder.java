package mk.ukim.finki.lab1.bootstrap;

import jakarta.annotation.PostConstruct;
import mk.ukim.finki.lab1.model.Chef;
import mk.ukim.finki.lab1.model.Dish;
import org.springframework.stereotype.Component;



import java.util.ArrayList;
import java.util.List;
@Component
public class DataHolder {
    public static List<Chef> chefs = new ArrayList<>();
    public static List<Dish> dishes = new ArrayList<>();

    @PostConstruct
    public void init() {
        chefs.add(new Chef(1L, "Aleksandar", "Petrovski", "Traditional Macedonian dishes and homemade specialties expert", new ArrayList<>()));
        chefs.add(new Chef(2L, "Marija", "Trajcheva", "Pastry chef specialized in desserts, cakes, and French pastries", new ArrayList<>()));
        chefs.add(new Chef(3L, "Nikola", "Jovanov", "Asian cuisine lover focusing on sushi and Thai street food", new ArrayList<>()));
        chefs.add(new Chef(4L, "Simona", "Ristovska", "Mediterranean cuisine chef with a focus on seafood and light meals", new ArrayList<>()));
        chefs.add(new Chef(5L, "Filip", "Kostadinov", "Experimental chef blending molecular gastronomy with modern art", new ArrayList<>()));

        dishes.add(new Dish("D1", "Tavche Gravche", "Macedonian", 45));
        dishes.add(new Dish("D2", "Pad Thai", "Thai", 30));
        dishes.add(new Dish("D3", "Lasagna Bolognese", "Italian", 60));
        dishes.add(new Dish("D4", "Sushi Platter", "Japanese", 50));
        dishes.add(new Dish("D5", "Vegan Buddha Bowl", "Fusion", 25));

    }
}
