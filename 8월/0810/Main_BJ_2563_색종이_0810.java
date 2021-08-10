import java.util.Arrays;
import java.util.Scanner;

public class Main_BJ_2563_색종이 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt(); // 색종이 수
		int paper[][] = new int [100][100]; // 도화지
		int res = 0; // 도화지 넓이
		
		for(int t = 0; t < T; t++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			
			// 도화지에 색종이를 붙이면 1로
			for(int i = x-1; i < x+9 ; i++) {
				for(int j = y-1; j < y+9; j++ ) {
					if(paper[i][j] != 1)
						paper[i][j] = 1;
				}
			}
			
			res = 0;
			// 도화지 줄별로 sum 총합
			for(int i = 0; i < 100; i++) { 
				res += Arrays.stream(paper[i]).sum();
			}
		}
		System.out.println(res);
		
		sc.close();
	} // main

}
