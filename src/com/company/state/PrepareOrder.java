package com.company.state;

public class PrepareOrder implements Activity{

    @Override
    public void makeOrder() {
        System.out.println("Your order is being prepared..." );
    }
}
