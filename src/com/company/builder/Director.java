package com.company.builder;

import com.company.decorator.Pizza;

public class Director {

    private Builder builder;

    public Director(Builder builder) {
        this.builder = builder;
        this.builder.BasePizza();
    }

    public Pizza build(){
        this.builder.addIngredients();
        return this.builder.getPizza();
    }

}
