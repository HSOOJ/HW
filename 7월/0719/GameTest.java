package com.ssafy.ws01.step3;

import java.util.Scanner;

public class GameTest {
	public static void main(String[] args) {
		System.out.println("가위바위보 게임을 시작합니다. 아래보기 중 하나를 고르세요.");
		System.out.println("1. 5판 3승");
		System.out.println("2. 3판 2승");
		System.out.println("3. 1판 1승");
		System.out.print("번호를 입력하세요. ");

		
		int win = 0;
		int lose = 0;
		int reswin = 0;
		int resgame = 0;
		int countgame = 0;
		int num = 0;
		
		Scanner scan = new Scanner(System.in);
		num = scan.nextInt();
		
		if (num == 1) {
			resgame = 5;
			reswin = 3;
		}else if(num == 2) {
			resgame = 3;
			reswin = 2;
		}else {
			resgame = 1;
			reswin = 1;
		}
		
//		while(countgame <= )
	}
}
