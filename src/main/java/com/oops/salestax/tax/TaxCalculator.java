package com.oops.salestax.tax;

import com.oops.salestax.entities.commons.InputDetails;
import com.oops.salestax.entities.items.Item;

import java.util.List;
public class TaxCalculator {

	private static final double ROUNDOFF = 0.05;
    public static List<InputDetails> calculateTax(List<InputDetails> inputDetailsList) {
        for (InputDetails inputDetails : inputDetailsList) {
            Item item = inputDetails.getItem();
            
            double taxPrice = 0;
            if (item.isTaxable()) {
                taxPrice = (item.getPrice() * Tax.SALES_TAX.getPercent()) / 100;
                taxPrice = calculateRoundOff(taxPrice);
            }
            if (item.isImported()) {
                taxPrice += (item.getPrice() * Tax.IMPORT_DUTY_TAX.getPercent()) / 100;
                taxPrice = calculateRoundOff(taxPrice);
            }
            item.setPrice(item.getPrice() + taxPrice);
            item.setTaxPrice(taxPrice);
            inputDetails.setItem(item);
        }
        return inputDetailsList;
    }
    public static  double calculateRoundOff(double price){
    	return Math.ceil(price/ROUNDOFF) * ROUNDOFF;
    }
}
