package com.kiddyenterprise.Domain;

public class WonItemMessage {
    private int caseID;
    private Item item;

    public WonItemMessage() {

    }

    public WonItemMessage(int caseID, Item item) {
        this.caseID = caseID;
        this.item = item;
    }

    public int getCaseID() {
        return caseID;
    }

    public Item getItem() {
        return item;
    }
}
