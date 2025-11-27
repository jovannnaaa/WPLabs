package mk.ukim.finki.wp.lab.model;

import lombok.Data;

import java.util.List;

@Data
public class Chef {
    protected Long id;
    protected String firstName;
    protected String lastName;
    protected ChefGender gender;
    protected String bio;

    protected List<Dish> dishes;
    
    public Chef(Long id, List<Dish> dishes, String bio, String firstName, String lastName, ChefGender gender) {
        this.id = id;
        this.dishes = dishes;
        this.bio = bio;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public ChefGender getGender() {
        return gender;
    }

    public void setGender(ChefGender gender) {
        this.gender = gender;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public List<Dish> getDishes() {
        return dishes;
    }

    public void setDishes(List<Dish> dishes) {
        this.dishes = dishes;
    }
}
