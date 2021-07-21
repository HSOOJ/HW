package com.ssafy.algo;

import java.util.Scanner;

public class Solution22 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int T = scan.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int sum = 0;
			int N = scan.nextInt();
			int W = scan.nextInt();
			
			int [][] arr = new int[N][N];
			
			for (int i = 0; i < W; i++) {
				int r = scan.nextInt(); // 행
				int c = scan.nextInt(); // 열
				int d = scan.nextInt(); // 방향
				
				// 소금쟁이 뛰기 - 각 방향으로 6칸씩 움직임
				if (arr[r][c] == 0) {
					// 1상 2하 3좌 4우
					switch(d) {
					case 1:
						if (r - 6 >= 0) arr[r-6][c] = 1;
						continue;
					case 2:
						if (r + 6 < N) arr[r+6][c] = 1;
						continue;
					case 3:
						if (c - 6 >= 0) arr[r][c-6] = 1;
						continue;
					case 4:
						if (c + 6 < N) arr[r][c+6] = 1;
						continue;
					} // switch
				}
				
			} // 소금쟁이 
			
			// 소금쟁이 수 세기
			for (int i = 0; i < N; i++) {
				for (int x: arr[i])
					if (x == 1) sum++;
			}
			
			System.out.print("#" + tc + " " + sum);
		} //Testcase

		scan.close();
	} //main
	
}
