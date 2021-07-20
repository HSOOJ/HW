package com.java.first;

// 반지름이 5인 원 넓이 출력하기
public class CircleArea {

	public static void main(String[] args) {
		int radius = 5;
		double area;
		area = Math.pow(radius, 2) * Math.PI;
		 
		System.out.println("반지름이 5Cm인 원의 넓이는 " + area + "Cm2입니다.");
	}

}
