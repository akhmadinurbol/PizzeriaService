package com.company.builder;

import com.company.decorator.IngredientDecorator;

import java.util.HashMap;
import java.util.Map;

public class MargaritaBuilder extends Builder{

    @Override
    public void addIngredients() {
        pizza = new IngredientDecorator(pizza, "sauce, ", 100);
        pizza = new IngredientDecorator(pizza,"chorizo, ",100);
        pizza = new IngredientDecorator(pizza,"ham, ",100);
        pizza = new IngredientDecorator(pizza,"tomatoes, ",100);
        pizza = new IngredientDecorator(pizza,"cheddar, ",100);

    }

    @Override
    public void BasePizza() {
        pizza.setPrice(500);
        pizza.setIngredient("Margarita - ");
    }
}
