package com.siscia.bravofly; 

import java.util.LinkedList;

class Recepit {
    private LinkedList<SingleItem> recepit = new LinkedList();
    private int total;
    private int totalTax;

    public Recepit(){
	this.total = 0;
	this.totalTax = 0;
    }

    public Recepit(SingleItem i){
	this.recepit.add(i);
	this.total = i.getPrice();
	this.totalTax = i.getTaxOnItem();
    }

    public void addItem(SingleItem i){
	this.recepit.add(i);
	this.total += i.getPrice();
	this.totalTax += i.getTaxOnItem();
    }

    public int getTotalPrice(){
	return this.total;
    }

    public int getTotalTax(){
	return this.totalTax;
    }

    public void printRecepit(){
	for(SingleItem item : this.recepit){
	    System.out.format("%s: %d", item.getDescription(), item.getPrice());
	System.out.format("Sales Tax: %d", this.totalTax);
	System.out.format("Total: %d", this.total);
	System.out.format("Total Due: %d", this.totalTax + this.total);
	}
    }

}


