package com.ssafy.hw06;

// Product 상속 받은 TV 클래스
public class TV extends Product{
	// 추가 필드
	private int inch;       // 인치
	private String display; // 화면 종류
	
	public TV() {	}
	
	public TV(String serNum, String name, int price, int quantity, int inch, String display) {
		super(serNum, name, price, quantity);
		this.inch = inch;
		this.display = display;
	}


	// 출력문
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
