package com.company.adapter;

public class TxtAdapter implements IReceipt{

    private TxtReceipt txtReceipt;

    public TxtAdapter(TxtReceipt txtReceipt) {
        this.txtReceipt = txtReceipt;
    }

    @Override
    public void readPdf() {
        System.out.println("Pdf format receipt is being converted in txt...");
        txtReceipt.readTxt();
    }
}
