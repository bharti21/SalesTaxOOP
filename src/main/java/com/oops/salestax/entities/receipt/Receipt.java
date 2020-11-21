package com.oops.salestax.entities.receipt;

import com.oops.salestax.entities.items.Item;

import java.util.List;

public class Receipt {
    private int receiptNo;
    private List<Item> itemList;
    private double salesTax;
    private double totalAmount;

    public Receipt() {
    }

    public Receipt(int receiptNo, List<Item> itemList, double salesTax, double totalAmount) {
        this.receiptNo = receiptNo;
        this.itemList = itemList;
        this.salesTax = salesTax;
        this.totalAmount = totalAmount;
    }

    public int getReceiptNo() {
        return receiptNo;
    }

    public void setReceiptNo(int receiptNo) {
        this.receiptNo = receiptNo;
    }

    public List<Item> getItemList() {
        return itemList;
    }

    public void setItemList(List<Item> itemList) {
        this.itemList = itemList;
    }

    public double getSalesTax() {
        return salesTax;
    }

    public void setSalesTax(double salesTax) {
        this.salesTax = salesTax;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    @Override
    public String toString() {
        return "Receipt{" +
                "receiptNo=" + receiptNo +
                ", itemList=" + itemList +
                ", salesTax=" + salesTax +
                ", totalAmount=" + totalAmount +
                '}';
    }
}
