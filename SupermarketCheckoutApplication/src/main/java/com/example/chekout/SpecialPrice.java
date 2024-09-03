package com.example.chekout;

public class SpecialPrice {

	private int quantity;
	private int price;
	
    public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

    public SpecialPrice(int quantity, int price) {
        this.quantity = quantity;
        this.price = price;
    }
}
