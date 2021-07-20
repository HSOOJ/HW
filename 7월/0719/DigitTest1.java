package com.ssafy.ws01.step3;

public class DigitTest1 {

	public static void main(String[] args) {
		int count = 0;
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 5; j++) {
				if (i > j) {
					System.out.print("\t");
				}
				else {
					System.out.print(++count + "\t");					
				}
			} System.out.println();
		}
	}

}
