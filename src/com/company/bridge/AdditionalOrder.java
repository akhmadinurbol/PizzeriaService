package com.company.bridge;

public abstract class AdditionalOrder {

    protected Drinks drinks;

    public void setAdditionalTings(Drinks drinks) {
        this.drinks = drinks;
    }

    public abstract String additionalOrderInfo();
}
