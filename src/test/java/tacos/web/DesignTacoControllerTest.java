package tacos.web;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.ui.Model;
import tacos.Ingredient;
import tacos.Taco;
import tacos.data.IngredientRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DesignTacoControllerTest {

    @Autowired
    IngredientRepository ingredientRepo;
    @Autowired
    DesignTacoController designTacoController;


    @Test
    public void showDesignForm() {
        List<Ingredient> ingredients = new ArrayList<>();
        ingredientRepo.findAll().forEach(i -> ingredients.add(i));
/*
        Ingredient.Type[] types = Ingredient.Type.values();
        for (Ingredient.Type type : types) {
            model.addAttribute(type.toString().toLowerCase(),
                    designTacoController.filterByType(ingredients, type));
        }

*/
        Ingredient.Type[] types = Ingredient.Type.values();
        for (Ingredient.Type type : types) {
            System.out.println(type.toString().toLowerCase() + " " +designTacoController.filterByType(ingredients, type));
        }
     //   model.addAttribute("taco", new Taco());
    }
}