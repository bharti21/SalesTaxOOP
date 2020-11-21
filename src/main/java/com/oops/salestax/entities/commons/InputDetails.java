package com.oops.salestax.entities.commons;

import com.oops.salestax.entities.items.Item;

public class InputDetails {
    private int noOfItems;
    private Item item;

    public InputDetails() {
    }

    public InputDetails(int noOfItems, Item item) {
        this.noOfItems = noOfItems;
        this.item = item;
    }

    public int getNoOfItems() {
        return noOfItems;
    }

    public void setNoOfItems(int noOfItems) {
        this.noOfItems = noOfItems;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }
}
