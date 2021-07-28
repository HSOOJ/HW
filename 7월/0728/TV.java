package com.ssafy.hw07;

// Product 상속 받은 TV 클래스
public class TV extends Product{
	// 추가 필드
	private int inch;       // 인치
	private String display; // 화면 종류
	
	
	public TV(String serNum, String name, int price, int quantity, int inch, String display) {
		super(serNum, name, price, quantity);
		this.inch = inch;
		this.display = display;
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

	// 출력문
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("TV [");
		builder.append(super.toString());
		builder.append(", 인치=");
		builder.append(inch);
		builder.append(", 디스플레이 종류=");
		builder.append(display);
		builder.append("]");
		return builder.toString();
	}
}
