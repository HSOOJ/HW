package com.ssafy.hw06;

// Product를 상속 받은 Refrigerator 클래스
public class Refrigerator extends Product{
	// 추가 필드
	private int capacity; // 용량
	
	public Refrigerator() {	}

	public Refrigerator(String serNum, String name, int price, int quantity, int capacity) {
		super(serNum, name, price, quantity);
		this.capacity = capacity;
	}

	// 출력
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
