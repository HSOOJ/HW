import java.util.Arrays;
import java.util.Scanner;

public class Solution_D3_9229_한빈이와SpotMart_0809 {
	static int N;
	static int M;
	static int[] arr;
	static int[] res;
	static int maxWeight;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int t = 1; t <= T; t++) {
			N = sc.nextInt(); // 과자 봉지 개수
			M = sc.nextInt(); // 과자 무게 합

			arr = new int[N]; // 과자 봉지의 무게
			res = new int[2]; // 뽑은 과자

			maxWeight = -1; // 최대 무게 합

			// 데이터 입력
			for (int i = 0; i < N; i++)
				arr[i] = sc.nextInt();

			comb(0, 0);

			// 출력
			System.out.println("#" + t + " " + maxWeight);

		} // testcase
		sc.close();
	} // main

	public static void comb(int cnt, int start) {
		if (cnt == 2) {
//			System.out.println(Arrays.toString(res));
			int sum = 0;
			for (int x : res) {
				sum += x;
			}
			if (sum <= M) // 무게가 M을 초과하지 않도록
				maxWeight = Math.max(maxWeight, sum);
			return;
		} else {
			for (int i = start; i < N; i++) {
				res[cnt] = arr[i];
				comb(cnt + 1, i + 1);
			}
		}
	}
}
