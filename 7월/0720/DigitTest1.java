package com.ssafy.algo;

import java.util.Arrays;
import java.util.Scanner;

/*
 * 100미만의 양의 정수
 * 0 입력되면 입력 종료
 * 십의 자리 숫자가 각각 몇 개 인지 출력
 */

public class DigitTest1 {

	public static void main(String[] args) {
		int[] arr = new int[10];		
		Scanner scan = new Scanner(System.in);
		
		while(true) {
			int num = scan.nextInt();
			// 0이 아닐때만 십의 자리 숫자세기
			if (num != 0) {
				// num / 10 => 십의 자리 숫자
				arr[num / 10]++;
			}
			// 0이면 종료
			else break;
		}
		
		// 형식에 맞게 출력
		for (int i = 0; i < 10; i++) {
			if (arr[i] != 0)
				System.out.printf("%d : %d개\n", i, arr[i]);
		}
		
	}

}
