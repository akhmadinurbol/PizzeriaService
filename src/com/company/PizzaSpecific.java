package com.company;

import com.company.decorator.Pizza;

public class PizzaSpecific extends Pizza {

    @Override
    public double getPrice() {
        return this.price;
    }

    @Override
    public String getIngredient() {
        return this.ingredient;
    }

    @Override
    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public void setIngredient(String ingredient) {
        this.ingredient = ingredient;
    }


}
