package com.company.strategy;

public interface PayStrategy {
    boolean pay(double paymentAmount);
    void collectPaymentDetails();

}
