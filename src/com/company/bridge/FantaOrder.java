package com.company.bridge;

public class FantaOrder extends AdditionalOrder{

    @Override
    public String additionalOrderInfo() {
        drinks.drinkStuff();
        return "150";
    }
}
