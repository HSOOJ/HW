package com.ssafy.hw;

public class TV {
	private String serNum;
	private String name;
	private int price;
	private int quantity;
	private int inch;
	private String display;
	
	
	public TV() { }


	public String getSerNum() {
		return serNum;
	}


	public void setSerNum(String serNum) {
		this.serNum = serNum;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
	}


	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	public int getInch() {
		return inch;
	}


	public void setInch(int inch) {
		this.inch = inch;
	}


	public String getDisplay() {
		return display;
	}


	public void setDisplay(String display) {
		this.display = display;
	}

	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("TV [serNum=");
		builder.append(serNum);
		builder.append(", name=");
		builder.append(name);
		builder.append(", price=");
		builder.append(price);
		builder.append(", quantity=");
		builder.append(quantity);
		builder.append(", inch=");
		builder.append(inch);
		builder.append(", display=");
		builder.append(display);
		builder.append("]");
		return builder.toString();
	}
	
	
	
	
	
}
