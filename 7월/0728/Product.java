package com.ssafy.hw07;

// public 클래스
// 상품 공통 정보를 담는 클래스
public class Product {
	 private String serNum; // 상품 정보
	 private String name;   // 상품명
	 private int price;     // 가격
	 private int quantity;  // 수량
	 
	 
	 public Product(String serNum, String name, int price, int quantity) {
		 this.serNum = serNum;
		 this.name = name;
		 this.price = price;
		 this.quantity = quantity;
	 }


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


	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("상품번호=");
		builder.append(serNum);
		builder.append(", 상품명=");
		builder.append(name);
		builder.append(", 가격=");
		builder.append(price);
		builder.append(", 재고=");
		builder.append(quantity);
		return builder.toString();
	}
	 
}
