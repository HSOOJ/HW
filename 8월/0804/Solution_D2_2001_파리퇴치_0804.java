import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution_D2_2001_파리퇴치 {

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("input.txt"));
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			int M = sc.nextInt();

			int[][] arr = new int[N][N];

			int res = 0; // 잡은 파리 수
			int max = -1; // 잡은 파리의 최대 수
			for (int i = 0; i < N; i++) { // 데이터 입력
				for (int j = 0; j < N; j++) {
					arr[i][j] = sc.nextInt();
				}
			} // 데이터 입력

			int search = N - M + 1;
			for(int i = 0; i < search; i++) {
				for(int j = 0; j < search; j++) {
					res = 0;
					for(int k = i; k < i+M; k++) {
						for(int l = j; l < j+M; l++) {
							res += arr[k][l];
						}
					}
					// 최대값 찾기
					if (max < res)
						max = res;
				}
			}
			System.out.println("#" + t + " " + max);

		}
		sc.close();
	} // main

}
