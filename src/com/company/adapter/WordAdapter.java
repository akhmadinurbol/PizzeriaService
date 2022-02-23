package com.company.adapter;

public class WordAdapter implements IReceipt{

    private  WordReceipt wordReceipt;

    public WordAdapter(WordReceipt wordReceipt) {
        this.wordReceipt = wordReceipt;
    }

    @Override
    public void readPdf() {
        System.out.println("Pdf format receipt is being converted in word...");
        wordReceipt.readWord();
    }
}
