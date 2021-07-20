package com.ssafy.ws01.step3;

public class DigitTest2 {

	public static void main(String[] args) {
		int count = 0;
		int s = 0;
		int e = 4;
		
		while(s < e) {
			for (int j = 0; j < s; j++) {
				System.out.print("\t");
			}
			for (int i = s; i <= e; i++) {
				System.out.print(++count + "\t");				
			}
			s++;
			e--;
			System.out.println();
		}
		
		while(s >= 0) {
			for (int j = 0; j < s; j++) {
				System.out.print("\t");
			}
			for (int i = s; i <= e; i++) {
				System.out.print(++count + "\t");				
			}
			s--;
			e++;
			System.out.println();
		}
	}

}
