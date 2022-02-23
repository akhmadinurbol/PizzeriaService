package com.company.decorator;

public class IngredientDecorator extends DecoratorPizza{

    public IngredientDecorator(Pizza pizza, String ingredient, double price){
        super(pizza, ingredient, price);
    }


    @Override
    public double getPrice() {
        return this.getPizza().getPrice() + this.price;
    }

    @Override
    public String getIngredient() {
        return this.getPizza().getIngredient() + this.ingredient;
    }



}
