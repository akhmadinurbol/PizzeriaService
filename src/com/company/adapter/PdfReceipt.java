package com.company.adapter;

public class PdfReceipt implements IReceipt{

    @Override
    public void readPdf() {
        System.out.println("Pdf format receipt is sent!");
    }
}
