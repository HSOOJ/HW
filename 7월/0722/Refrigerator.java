package com.ssafy.hw;

public class Refrigerator {
	private String serNum;
	private String name;
	private int price;
	private int quantity;
	private int capacity;
	
	public Refrigerator() {}

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

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Refrigerator [serNum=");
		builder.append(serNum);
		builder.append(", name=");
		builder.append(name);
		builder.append(", price=");
		builder.append(price);
		builder.append(", quantity=");
		builder.append(quantity);
		builder.append(", capacity=");
		builder.append(capacity);
		builder.append("]");
		return builder.toString();
	}
}
