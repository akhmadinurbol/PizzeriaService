package com.company.builder;

import com.company.decorator.IngredientDecorator;

public class PepperoniBuilder extends Builder{

    @Override
    public void addIngredients() {
        pizza = new IngredientDecorator(pizza, "pepperoni, ", 100);
        pizza = new IngredientDecorator(pizza,"chorizo, ",100);
        pizza = new IngredientDecorator(pizza,"ham, ",100);
        pizza = new IngredientDecorator(pizza,"sauce, ",100);
        pizza = new IngredientDecorator(pizza,"mozzarella, ",100);

    }

    @Override
    public void BasePizza() {
        pizza.setPrice(1500);
        pizza.setIngredient("Pepperoni - ");
    }
}
