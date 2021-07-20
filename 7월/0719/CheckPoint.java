package com.java.first;

import java.util.Scanner;

// 키, 몸무게 정수로 입력받기
// 비만수치 출력
// 비만수치 = 몸무게 + 100 - 키
// 비만수치 > 0 출력 메시지
public class CheckPoint {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int height = scan.nextInt();
		int weight = scan.nextInt();
		 
		int bmi = weight + 100 - height;
		
		System.out.println("비만수치는 " + bmi + "입니다.");
		if (bmi > 0) {
			System.out.println("당신은 비만이군요");
		}
	}

}
