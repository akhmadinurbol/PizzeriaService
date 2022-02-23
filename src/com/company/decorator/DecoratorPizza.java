package com.company.decorator;

public abstract class DecoratorPizza extends Pizza{

    private Pizza pizza;

    public DecoratorPizza(Pizza pizza, String ingredient, double price) {
        this.pizza = pizza;
        super.setPrice(price);
        super.setIngredient(ingredient);
    }


    public Pizza getPizza() {
        return pizza;
    }
}
