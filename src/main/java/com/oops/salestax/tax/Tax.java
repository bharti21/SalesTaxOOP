package com.oops.salestax.tax;

public enum Tax {
    SALES_TAX(10), IMPORT_DUTY_TAX(5);
    private int percent;

    
    private Tax(int percent) {
		this.percent = percent;
	}


	public int getPercent() {
        return percent;
    }
}