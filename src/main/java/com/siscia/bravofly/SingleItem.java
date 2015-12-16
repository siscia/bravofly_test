package com.siscia.bravofly; 

import java.lang.String;

public class SingleItem {
    private int pricePreTax;
    private String description;
    private int taxOnItem;

    public SingleItem(String name, int price, boolean isTaxable, boolean isImported){
	this.description = name;
	this.pricePreTax = price;
	double saleTax = 0;
	double importTax = 0;
	if(isTaxable){
	    saleTax = this.pricePreTax * .1;
	}
	if(isImported) {
	    importTax = this.pricePreTax * .05;
	}
	this.taxOnItem = roundPrice(saleTax + importTax);
	}

    private int roundPrice(double round) {
	int toRound = (int)Math.floor(round);
	if (toRound % 5 == 0) {
		return toRound;
	}
	return toRound + ( 5 - (toRound % 5));
    }

    final public int getPrice() {
	return this.pricePreTax;
    }

    final public int getTaxOnItem() {
	return this.taxOnItem;
    }

    final public String getDescription() {
	return this.description;
    }
}
