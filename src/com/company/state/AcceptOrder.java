package com.company.state;

public class AcceptOrder implements Activity{
    @Override
    public void makeOrder() {
        System.out.println("\n" + "Your order is accepted." );
    }
}
