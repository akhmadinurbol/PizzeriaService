package com.company.builder;

import com.company.decorator.IngredientDecorator;

public class HawaianBuilder extends Builder{

    @Override
    public void addIngredients() {
        pizza = new IngredientDecorator(pizza, "chicken ham, ", 50);
        pizza = new IngredientDecorator(pizza,"pineapple, ",250);
        pizza = new IngredientDecorator(pizza,"mozzarella,  ",200);
        pizza = new IngredientDecorator(pizza,"tomato sauce, ",300);
        pizza = new IngredientDecorator(pizza,"cheddar ",200);

    }

    @Override
    public void BasePizza() {
        pizza.setPrice(500);
        pizza.setIngredient("Hawaian - ");
    }
}
