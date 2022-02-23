package com.company.facade;

import com.company.adapter.*;
import com.company.bridge.*;
import com.company.builder.Director;
import com.company.builder.HawaianBuilder;
import com.company.builder.MargaritaBuilder;
import com.company.builder.PepperoniBuilder;
import com.company.decorator.Pizza;
import com.company.state.AcceptOrder;
import com.company.state.Activity;
import com.company.state.OrderState;
import com.company.strategy.CreditCardPay;
import com.company.strategy.KaspiGoldPay;
import com.company.strategy.Order;
import com.company.strategy.PayStrategy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ProcessFacade {

    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static Order order = new Order();
    private static PayStrategy strategy;

    public void process() throws IOException {
        System.out.println("Welcome to Console Pizza Ordering!" + "\n" + "----------------------------------");

        Director director = new Director(new MargaritaBuilder());
        Pizza pizza1 = director.build();
        Director director1 = new Director(new PepperoniBuilder());
        Pizza pizza2 = director1.build();
        Director director2 = new Director(new HawaianBuilder());
        Pizza pizza3 = director2.build();

        AdditionalOrder additionalOrder = new ColaOrder();
        AdditionalOrder additionalOrder1 = new FantaOrder();
        Drinks cola = new Cola();
        Drinks fanta = new Fanta();
        additionalOrder.setAdditionalTings(cola);
        additionalOrder1.setAdditionalTings(fanta);

        while (!order.isClosed()) {
            double cost = 0;

            String continueChoice;
            do {
                System.out.print("Please, select a product:" + "\n" +
                        "1 - " +  pizza1.getIngredient()  + "\n"  +  "Price : " + pizza1.getPrice() + "\n" +
                        "2 - " + pizza2.getIngredient()  + "\n" + "Price : " + pizza2.getPrice() + "\n"+
                        "3 - " + pizza3.getIngredient()  + "\n" + "Price : " + pizza3.getPrice() + "\n");

                int choice = Integer.parseInt(reader.readLine());
                if(choice == 1) {
                    cost = pizza1.getPrice();
                }
                else if(choice == 2){
                    cost = pizza2.getPrice();
                }
                else if(choice == 3){
                    cost = pizza3.getPrice();
                }

                System.out.print("Count: ");
                int count = Integer.parseInt(reader.readLine());
                order.setTotalCost(cost * count);
                System.out.print("Do you wish to continue selecting products? Y/N: ");
                continueChoice = reader.readLine();

            } while (continueChoice.equalsIgnoreCase("Y"));

            String continueChoice1;
            String continueChoice2;
            do {
                System.out.print("Do you wish to select some drinks? Y/N: ");
                continueChoice1 = reader.readLine();
                System.out.print("\n" + "Please, select a drink:" + "\n" +
                        "1 - Cola" + "\n"  +  "Price : " + Double.parseDouble(additionalOrder.additionalOrderInfo()) + "\n" +
                        "2 - Fanta" + "\n" + "Price : " + Double.parseDouble(additionalOrder1.additionalOrderInfo()) + "\n" );

                int choice = Integer.parseInt(reader.readLine());
                if(choice == 1) {
                    cost = Double.parseDouble(additionalOrder.additionalOrderInfo());
                }
                else if(choice == 2){
                    cost = Double.parseDouble(additionalOrder1.additionalOrderInfo());
                }
                System.out.print("Count: ");
                int count = Integer.parseInt(reader.readLine());
                order.setTotalCost(cost * count);
                System.out.print("Do you wish to continue selecting drinks? Y/N: ");
                continueChoice2 = reader.readLine();

            } while (continueChoice1.equalsIgnoreCase("Y") && continueChoice2.equalsIgnoreCase("Y"));



            if (strategy == null) {
                System.out.println("\n" + "Please, select a payment method:" + "\n" +
                        "1 - Kaspi Gold" + "\n" +
                        "2 - Credit Card");
                String paymentMethod = reader.readLine();

                if (paymentMethod.equals("1")) {
                    strategy = new KaspiGoldPay();
                } else {
                    strategy = new CreditCardPay();
                }
            }

            order.processOrder(strategy);

            System.out.print("Pay " + order.getTotalCost() + " tenge or Continue shopping? P/C: ");
            String proceed = reader.readLine();
            if (proceed.equalsIgnoreCase("P")) {
                if (strategy.pay(order.getTotalCost())) {
                    System.out.println("Payment has been successful. Please take your Receipt!" + "\n");
                } else {
                    System.out.println("FAIL! Please, check your data." + "\n");
                }
                order.setClosed();
            }
        }
    }
            public void getReceipt() throws IOException{

                Client client = new Client();
                IReceipt pdf = new PdfReceipt();
                TxtReceipt txt = new TxtReceipt();
                TxtAdapter txtAdapter = new TxtAdapter(txt);
                WordReceipt word = new WordReceipt();
                WordAdapter wordAdapter = new WordAdapter(word);

                System.out.println("Receipt is in pdf format : " + "\n" +
                        "1 - Take Receipt" + "\n" +
                        "2 - Convert to txt" + "\n" +
                        "3 - Convert to word");

                int choice = Integer.parseInt(reader.readLine());
                if (choice == 1) {
                    client.ReadReceipt(pdf);
                } else if (choice == 2) {
                    client.ReadReceipt(txtAdapter);
                } else if (choice == 3) {
                    client.ReadReceipt(wordAdapter);
                }
            }

            public void getState() throws IOException {

                Activity activity = new AcceptOrder();
                OrderState orderState = new OrderState();

                orderState.setActivity(activity);

                for (int i = 0; i < 3; i++) {
                    orderState.makeOrder();
                    orderState.changeActivity();
                }
            }
}
