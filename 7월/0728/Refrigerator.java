package com.ssafy.hw07;

// Product를 상속 받은 Refrigerator 클래스
public class Refrigerator extends Product{
	// 추가 필드
	private int capacity; // 용량
	

	public Refrigerator(String serNum, String name, int price, int quantity, int capacity) {
		super(serNum, name, price, quantity);
		this.capacity = capacity;
	}

	
	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	// 출력
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("냉장고 [");
		builder.append(super.toString());
		builder.append(", 용량=");
		builder.append(capacity);
		builder.append("]");
		return builder.toString();
	}
	
}
