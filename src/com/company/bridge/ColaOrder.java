package com.company.bridge;

public class ColaOrder extends AdditionalOrder{

    @Override
    public String additionalOrderInfo() {
        drinks.drinkStuff();
        return "100";
    }
}
