package com.ssafy.hw06;

// public 클래스
// 상품 공통 정보를 담는 클래스
public class Product {
	 String serNum; // 상품 정보
	 String name;   // 상품명
	 int price;     // 가격
	 int quantity;  // 수량
	 
	 public Product() {	}
	 
	 public Product(String serNum, String name, int price, int quantity) {
		 super();
		 this.serNum = serNum;
		 this.name = name;
		 this.price = price;
		 this.quantity = quantity;
	 }

}
