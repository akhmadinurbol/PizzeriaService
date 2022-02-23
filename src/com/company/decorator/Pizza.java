package com.company.decorator;

public abstract class Pizza {

    protected double price;
    protected String ingredient;

    public abstract double getPrice();

    public void setPrice(double price) {
        this.price = price;
    }

    public abstract String getIngredient();

    public void setIngredient(String ingredient) {
        this.ingredient = ingredient;
    }

}
