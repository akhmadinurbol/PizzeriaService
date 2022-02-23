package com.company.state;

public class ReadyOrder implements Activity{

    @Override
    public void makeOrder() {
        System.out.println("Your order is ready!");
    }
}
