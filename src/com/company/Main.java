package com.company;

import com.company.facade.ProcessFacade;
import java.io.IOException;


public class Main {

    public static void main(String[] args) throws IOException {
        ProcessFacade processFacade = new ProcessFacade();
        processFacade.process();
        processFacade.getReceipt();
        processFacade.getState();
    }

}
