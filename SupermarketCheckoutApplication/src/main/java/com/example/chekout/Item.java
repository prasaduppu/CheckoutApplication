package com.example.chekout;

public class Item {
    private String name;
    private int unitPrice;
    private SpecialPrice specialPrice;


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(int unitPrice) {
		this.unitPrice = unitPrice;
	}
	
	public SpecialPrice getSpecialPrice() {
		return specialPrice;
	}

	public void setSpecialPrice(SpecialPrice specialPrice) {
		this.specialPrice = specialPrice;
	}

    public Item(String name, int unitPrice, SpecialPrice specialPrice) {
        this.name = name;
        this.unitPrice = unitPrice;
        this.specialPrice = specialPrice;
    }

	
}
