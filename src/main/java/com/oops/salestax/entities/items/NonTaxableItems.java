package com.oops.salestax.entities.items;

public enum NonTaxableItems {
    BOOK("book"), FOOD("food"), MEDICINE("medicine");

    private String category;

    

    private NonTaxableItems(String category) {
		this.category = category;
	}



	public String getCategory() {
        return category;
    }
}
