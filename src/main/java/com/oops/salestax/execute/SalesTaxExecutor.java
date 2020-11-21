package com.oops.salestax.execute;

import com.oops.salestax.entities.commons.InputDetails;
import com.oops.salestax.entities.items.Item;
import com.oops.salestax.entities.receipt.Receipt;
import com.oops.salestax.tax.TaxCalculator;
import com.oops.salestax.utils.InputParser;

import java.util.ArrayList;
import java.util.List;
import java.text.DecimalFormat;

public class SalesTaxExecutor {

	public void execute(String filePath) {
		List<InputDetails> inputDetails = InputParser.parseInput(filePath);
		generateReceipt(inputDetails);

	}

	private void generateReceipt(List<InputDetails> inputDetailsList) {
		List<InputDetails> taxCalculatedItemsList = TaxCalculator.calculateTax(inputDetailsList);
		Receipt receipt = getReceipt(taxCalculatedItemsList);
		System.out.println(receipt.toString());
	}

	private Receipt getReceipt(List<InputDetails> taxCalculatedItemsList) {
		Receipt receipt = new Receipt();
		receipt.setReceiptNo((int) Math.random());
		List<Item> items = new ArrayList<Item>();
		DecimalFormat df = new DecimalFormat("0.00");
		for (InputDetails inputDetails : taxCalculatedItemsList) {
			receipt.setSalesTax(Double.parseDouble(df.format(
					receipt.getSalesTax() + inputDetails.getNoOfItems() * inputDetails.getItem().getTaxPrice())));
			receipt.setTotalAmount(Double.parseDouble(df.format(
					receipt.getTotalAmount() + inputDetails.getNoOfItems() * inputDetails.getItem().getPrice())));
			items.add(inputDetails.getItem());
		}
		receipt.setItemList(items);
		return receipt;
	}

}
