package com.java.first;

import java.util.Scanner;

// 두 개의 정수 입력 받아 곱과 몫 출력
public class Compute {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int num1 = scan.nextInt();
		int num2 = scan.nextInt();
 
		int mul, quo;
		mul = num1 * num2;
		quo = num1 / num2;

		System.out.println("곱=" + mul);
		System.out.println("몫=" + quo);
	}

}
