package com.company.builder;

import com.company.PizzaSpecific;
import com.company.decorator.Pizza;

public abstract class Builder {

    protected Pizza pizza;

    public Builder(){
        pizza = new PizzaSpecific();
    }

    public Pizza getPizza(){
        return this.pizza;
    }

    public abstract void addIngredients();

    public abstract void BasePizza();
}
